package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.ApplicationInfo;
import android.os.Looper;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

@Deprecated
public final class ar
  implements SharedPreferences
{
  private static final Object yoD;
  private static final LruCache<String, ar> yoF;
  private static ak yov;
  private Map<String, Object> eEE;
  private boolean eHo;
  private File gVL;
  private int mMode;
  private long yoA;
  private long yoB;
  private final Object yoC;
  private final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> yoE;
  private FLock yow;
  private File yox;
  private boolean yoy;
  private int yoz;
  
  static
  {
    AppMethodBeat.i(93459);
    yov = null;
    yoD = new Object();
    yoF = new LruCache(5);
    AppMethodBeat.o(93459);
  }
  
  private ar()
  {
    AppMethodBeat.i(93442);
    this.yow = null;
    this.gVL = null;
    this.yox = null;
    this.mMode = 0;
    this.yoy = false;
    this.eEE = null;
    this.yoz = 0;
    this.eHo = false;
    this.yoA = 0L;
    this.yoB = 0L;
    this.yoC = new Object();
    this.yoE = new WeakHashMap();
    RuntimeException localRuntimeException = new RuntimeException("Not supported.");
    AppMethodBeat.o(93442);
    throw localRuntimeException;
  }
  
  private ar(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(93443);
    this.yow = null;
    this.gVL = null;
    this.yox = null;
    this.mMode = 0;
    this.yoy = false;
    this.eEE = null;
    this.yoz = 0;
    this.eHo = false;
    this.yoA = 0L;
    this.yoB = 0L;
    this.yoC = new Object();
    this.yoE = new WeakHashMap();
    Context localContext = paramContext.getApplicationContext();
    if (yov == null) {
      yov = new ak(Looper.getMainLooper());
    }
    String str = localContext.getApplicationInfo().dataDir;
    if (str != null)
    {
      paramContext = str;
      if (str.length() != 0) {}
    }
    else
    {
      ab.w("MicroMsg.MultiProcSharedPreferences", "Failed to retrive data path by ApplicationInfo.dataDir, use prefix hardcoded version instead.");
      paramContext = "/data/data/" + localContext.getPackageName();
    }
    ab.i("MicroMsg.MultiProcSharedPreferences", "Path to store sp data: ".concat(String.valueOf(paramContext)));
    paramContext = new File(paramContext, "shared_prefs");
    if (!paramContext.exists())
    {
      paramContext.mkdirs();
      this.gVL = new File(paramContext, paramString + ".xml");
      paramContext = this.gVL;
      this.yox = new File(paramContext.getPath() + ".bak");
      this.mMode = paramInt;
      if ((paramInt & 0x4) == 0) {
        break label370;
      }
    }
    label370:
    for (boolean bool = true;; bool = false)
    {
      this.yoy = bool;
      if (this.yoy) {
        this.yow = new FLock(this.gVL.getPath() + ".lock");
      }
      dtk();
      AppMethodBeat.o(93443);
      return;
      if ((paramContext.canRead()) && (paramContext.canWrite())) {
        break;
      }
      paramContext.setReadable(true, true);
      paramContext.setWritable(true, true);
      break;
    }
  }
  
  private void dtk()
  {
    AppMethodBeat.i(93444);
    try
    {
      this.eHo = false;
      d.h(new ar.1(this), "MultiProcessSP-LoadThread").start();
      AppMethodBeat.o(93444);
      return;
    }
    finally
    {
      AppMethodBeat.o(93444);
    }
  }
  
  private void dtl()
  {
    AppMethodBeat.i(93447);
    while (!this.eHo) {
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException) {}
    }
    AppMethodBeat.o(93447);
  }
  
  public static SharedPreferences r(Context paramContext, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(93441);
    as localas = as.apq(paramString);
    if (ar.a.dtn())
    {
      ab.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use Flock version MultiProcessSP.", new Object[] { paramString });
      ar localar = (ar)yoF.get(paramString);
      if (localar == null)
      {
        paramContext = new ar(paramContext, paramString, paramInt);
        yoF.put(paramString, paramContext);
      }
      for (;;)
      {
        as.a(paramContext, localas);
        AppMethodBeat.o(93441);
        return localas;
        paramContext = localar;
        if ((paramInt & 0x4) != 0)
        {
          for (;;)
          {
            try
            {
              if (localar.yoz <= 0)
              {
                paramInt = i;
                if (localar.yoA == localar.gVL.lastModified())
                {
                  if (localar.yoB != localar.gVL.length()) {
                    paramInt = i;
                  }
                }
                else
                {
                  if (paramInt != 0) {
                    break label177;
                  }
                  paramContext = localar;
                  break;
                }
              }
            }
            finally
            {
              AppMethodBeat.o(93441);
            }
            paramInt = 0;
          }
          label177:
          localar.dtk();
          paramContext = localar;
        }
      }
    }
    ab.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use system sp.", new Object[] { paramString });
    paramContext = paramContext.getSharedPreferences(paramString, paramInt);
    AppMethodBeat.o(93441);
    return paramContext;
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(93455);
    try
    {
      dtl();
      boolean bool = this.eEE.containsKey(paramString);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(93455);
    }
  }
  
  public final SharedPreferences.Editor edit()
  {
    AppMethodBeat.i(93456);
    try
    {
      dtl();
      b localb = new b((byte)0);
      AppMethodBeat.o(93456);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(93456);
    }
  }
  
  public final Map<String, ?> getAll()
  {
    AppMethodBeat.i(93448);
    try
    {
      dtl();
      HashMap localHashMap = new HashMap(this.eEE);
      return localHashMap;
    }
    finally
    {
      AppMethodBeat.o(93448);
    }
  }
  
  public final boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(93454);
    try
    {
      dtl();
      paramString = (Boolean)this.eEE.get(paramString);
      if (paramString != null) {
        paramBoolean = paramString.booleanValue();
      }
      return paramBoolean;
    }
    finally
    {
      AppMethodBeat.o(93454);
    }
  }
  
  public final float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(93453);
    try
    {
      dtl();
      paramString = (Float)this.eEE.get(paramString);
      if (paramString != null) {
        paramFloat = paramString.floatValue();
      }
      return paramFloat;
    }
    finally
    {
      AppMethodBeat.o(93453);
    }
  }
  
  public final int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(93451);
    try
    {
      dtl();
      paramString = (Integer)this.eEE.get(paramString);
      if (paramString != null) {
        paramInt = paramString.intValue();
      }
      return paramInt;
    }
    finally
    {
      AppMethodBeat.o(93451);
    }
  }
  
  public final long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(93452);
    try
    {
      dtl();
      paramString = (Long)this.eEE.get(paramString);
      if (paramString != null) {
        paramLong = paramString.longValue();
      }
      return paramLong;
    }
    finally
    {
      AppMethodBeat.o(93452);
    }
  }
  
  /* Error */
  public final String getString(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 448
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: invokespecial 391	com/tencent/mm/sdk/platformtools/ar:dtl	()V
    //   12: aload_0
    //   13: getfield 82	com/tencent/mm/sdk/platformtools/ar:eEE	Ljava/util/Map;
    //   16: aload_1
    //   17: invokeinterface 415 2 0
    //   22: checkcast 135	java/lang/String
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +13 -> 40
    //   30: aload_0
    //   31: monitorexit
    //   32: ldc_w 448
    //   35: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_1
    //   39: areturn
    //   40: aload_2
    //   41: astore_1
    //   42: goto -12 -> 30
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: ldc_w 448
    //   51: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	ar
    //   0	56	1	paramString1	String
    //   0	56	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   8	26	45	finally
    //   30	32	45	finally
    //   46	48	45	finally
  }
  
  /* Error */
  public final Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    // Byte code:
    //   0: ldc_w 451
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: invokespecial 391	com/tencent/mm/sdk/platformtools/ar:dtl	()V
    //   12: aload_0
    //   13: getfield 82	com/tencent/mm/sdk/platformtools/ar:eEE	Ljava/util/Map;
    //   16: aload_1
    //   17: invokeinterface 415 2 0
    //   22: checkcast 453	java/util/Set
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +13 -> 40
    //   30: aload_0
    //   31: monitorexit
    //   32: ldc_w 451
    //   35: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_1
    //   39: areturn
    //   40: aload_2
    //   41: astore_1
    //   42: goto -12 -> 30
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: ldc_w 451
    //   51: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	ar
    //   0	56	1	paramString	String
    //   0	56	2	paramSet	Set<String>
    // Exception table:
    //   from	to	target	type
    //   8	26	45	finally
    //   30	32	45	finally
    //   46	48	45	finally
  }
  
  public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    AppMethodBeat.i(93445);
    try
    {
      this.yoE.put(paramOnSharedPreferenceChangeListener, yoD);
      return;
    }
    finally
    {
      AppMethodBeat.o(93445);
    }
  }
  
  public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    AppMethodBeat.i(93446);
    try
    {
      this.yoE.remove(paramOnSharedPreferenceChangeListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(93446);
    }
  }
  
  final class b
    implements SharedPreferences.Editor
  {
    private final Map<String, Object> yoJ;
    private boolean yoK;
    
    private b()
    {
      AppMethodBeat.i(93423);
      this.yoJ = new HashMap();
      this.yoK = false;
      AppMethodBeat.o(93423);
    }
    
    private FileOutputStream W(File paramFile)
    {
      AppMethodBeat.i(93435);
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
        paramFile = localFileOutputStream;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          Object localObject = paramFile.getParentFile();
          if (!((File)localObject).mkdir())
          {
            ab.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create directory for SharedPreferences file ".concat(String.valueOf(paramFile)));
            AppMethodBeat.o(93435);
            return null;
          }
          ar.f((File)localObject, ar.h(ar.this));
          try
          {
            localObject = new FileOutputStream(paramFile);
            paramFile = (File)localObject;
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            ab.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create SharedPreferences file ".concat(String.valueOf(paramFile)), new Object[] { localFileNotFoundException2 });
            paramFile = null;
          }
        }
      }
      AppMethodBeat.o(93435);
      return paramFile;
    }
    
    private void a(ar.c paramc)
    {
      AppMethodBeat.i(93436);
      if ((paramc.bLQ == null) || (paramc.yoQ == null) || (paramc.yoQ.size() == 0))
      {
        AppMethodBeat.o(93436);
        return;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        int i = paramc.yoQ.size() - 1;
        while (i >= 0)
        {
          String str = (String)paramc.yoQ.get(i);
          Iterator localIterator = paramc.bLQ.iterator();
          while (localIterator.hasNext())
          {
            SharedPreferences.OnSharedPreferenceChangeListener localOnSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener)localIterator.next();
            if (localOnSharedPreferenceChangeListener != null) {
              localOnSharedPreferenceChangeListener.onSharedPreferenceChanged(ar.this, str);
            }
          }
          i -= 1;
        }
        AppMethodBeat.o(93436);
        return;
      }
      ar.dtm().post(new ar.b.4(this, paramc));
      AppMethodBeat.o(93436);
    }
    
    private void a(ar.c paramc, Runnable arg2)
    {
      int j = 1;
      AppMethodBeat.i(93434);
      paramc = new ar.b.3(this, paramc, ???);
      int i;
      if (??? == null) {
        i = 1;
      }
      while (i != 0) {
        synchronized (ar.this)
        {
          if (ar.b(ar.this) == 1)
          {
            i = j;
            if (i != 0)
            {
              paramc.run();
              AppMethodBeat.o(93434);
              return;
              i = 0;
            }
          }
          else
          {
            i = 0;
          }
        }
      }
      ba.dtx().execute(paramc);
      AppMethodBeat.o(93434);
    }
    
    private ar.c dto()
    {
      AppMethodBeat.i(93433);
      ar.c localc1 = new ar.c((byte)0);
      for (;;)
      {
        Object localObject2;
        String str;
        synchronized (ar.this)
        {
          if (ar.b(ar.this) > 0) {
            ar.a(ar.this, new HashMap(ar.c(ar.this)));
          }
          localc1.yoR = ar.c(ar.this);
          ar.d(ar.this);
          if (ar.e(ar.this).size() > 0)
          {
            i = 1;
            if (i != 0)
            {
              localc1.yoQ = new ArrayList();
              localc1.bLQ = new HashSet(ar.e(ar.this).keySet());
            }
            try
            {
              if (this.yoK)
              {
                if (!ar.c(ar.this).isEmpty())
                {
                  localc1.yoP = true;
                  ar.c(ar.this).clear();
                }
                this.yoK = false;
              }
              Iterator localIterator = this.yoJ.entrySet().iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              localObject2 = (Map.Entry)localIterator.next();
              str = (String)((Map.Entry)localObject2).getKey();
              localObject2 = ((Map.Entry)localObject2).getValue();
              if (localObject2 != this) {
                break label318;
              }
              if (!ar.c(ar.this).containsKey(str)) {
                continue;
              }
              ar.c(ar.this).remove(str);
              localc1.yoP = true;
              if (i == 0) {
                continue;
              }
              localc1.yoQ.add(str);
              continue;
              localc2 = finally;
            }
            finally
            {
              AppMethodBeat.o(93433);
            }
          }
        }
        int i = 0;
        continue;
        label318:
        if (ar.c(ar.this).containsKey(str))
        {
          Object localObject3 = ar.c(ar.this).get(str);
          if ((localObject3 != null) && (localObject3.equals(localObject2))) {}
        }
        else
        {
          ar.c(ar.this).put(str, localObject2);
        }
      }
      this.yoJ.clear();
      AppMethodBeat.o(93433);
      return localc2;
    }
    
    public final void apply()
    {
      AppMethodBeat.i(93432);
      ar.c localc = dto();
      ar.b.1 local1 = new ar.b.1(this, localc);
      ba.ag(local1);
      a(localc, new ar.b.2(this, local1));
      a(localc);
      AppMethodBeat.o(93432);
    }
    
    public final SharedPreferences.Editor clear()
    {
      try
      {
        this.yoK = true;
        return this;
      }
      finally {}
    }
    
    public final boolean commit()
    {
      AppMethodBeat.i(93431);
      ar.c localc = dto();
      a(localc, null);
      try
      {
        localc.yoS.await();
        a(localc);
        boolean bool = localc.yoT;
        AppMethodBeat.o(93431);
        return bool;
      }
      catch (InterruptedException localInterruptedException)
      {
        AppMethodBeat.o(93431);
      }
      return false;
    }
    
    public final SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(93429);
      try
      {
        this.yoJ.put(paramString, Boolean.valueOf(paramBoolean));
        return this;
      }
      finally
      {
        AppMethodBeat.o(93429);
      }
    }
    
    public final SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      AppMethodBeat.i(93428);
      try
      {
        this.yoJ.put(paramString, Float.valueOf(paramFloat));
        return this;
      }
      finally
      {
        AppMethodBeat.o(93428);
      }
    }
    
    public final SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(93426);
      try
      {
        this.yoJ.put(paramString, Integer.valueOf(paramInt));
        return this;
      }
      finally
      {
        AppMethodBeat.o(93426);
      }
    }
    
    public final SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(93427);
      try
      {
        this.yoJ.put(paramString, Long.valueOf(paramLong));
        return this;
      }
      finally
      {
        AppMethodBeat.o(93427);
      }
    }
    
    public final SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(93424);
      try
      {
        this.yoJ.put(paramString1, paramString2);
        return this;
      }
      finally
      {
        AppMethodBeat.o(93424);
      }
    }
    
    public final SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      AppMethodBeat.i(93425);
      try
      {
        this.yoJ.put(paramString, paramSet);
        return this;
      }
      finally
      {
        AppMethodBeat.o(93425);
      }
    }
    
    public final SharedPreferences.Editor remove(String paramString)
    {
      AppMethodBeat.i(93430);
      try
      {
        this.yoJ.put(paramString, this);
        return this;
      }
      finally
      {
        AppMethodBeat.o(93430);
      }
    }
  }
  
  static final class c
  {
    public Set<SharedPreferences.OnSharedPreferenceChangeListener> bLQ;
    public boolean yoP;
    public List<String> yoQ;
    public Map<String, Object> yoR;
    public final CountDownLatch yoS;
    public volatile boolean yoT;
    
    private c()
    {
      AppMethodBeat.i(93439);
      this.yoP = false;
      this.yoQ = null;
      this.bLQ = null;
      this.yoR = null;
      this.yoS = new CountDownLatch(1);
      this.yoT = false;
      AppMethodBeat.o(93439);
    }
    
    public final void pK(boolean paramBoolean)
    {
      AppMethodBeat.i(93440);
      this.yoT = paramBoolean;
      this.yoS.countDown();
      AppMethodBeat.o(93440);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ar
 * JD-Core Version:    0.7.0.1
 */