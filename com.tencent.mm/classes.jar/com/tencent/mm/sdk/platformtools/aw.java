package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.ApplicationInfo;
import android.os.Looper;
import android.util.LruCache;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
public final class aw
  implements SharedPreferences
{
  private static ap EVg;
  private static final Object EVp;
  private static final LruCache<String, aw> EVr;
  private FLock EVh;
  private File EVi;
  private File EVj;
  private boolean EVk;
  private int EVl;
  private long EVm;
  private long EVn;
  private final Object EVo;
  private final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> EVq;
  private Map<String, Object> fZH;
  private boolean gcu;
  private int mMode;
  
  static
  {
    AppMethodBeat.i(156249);
    EVg = null;
    EVp = new Object();
    EVr = new LruCache(5);
    AppMethodBeat.o(156249);
  }
  
  private aw()
  {
    AppMethodBeat.i(156232);
    this.EVh = null;
    this.EVi = null;
    this.EVj = null;
    this.mMode = 0;
    this.EVk = false;
    this.fZH = null;
    this.EVl = 0;
    this.gcu = false;
    this.EVm = 0L;
    this.EVn = 0L;
    this.EVo = new Object();
    this.EVq = new WeakHashMap();
    RuntimeException localRuntimeException = new RuntimeException("Not supported.");
    AppMethodBeat.o(156232);
    throw localRuntimeException;
  }
  
  private aw(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(156233);
    this.EVh = null;
    this.EVi = null;
    this.EVj = null;
    this.mMode = 0;
    this.EVk = false;
    this.fZH = null;
    this.EVl = 0;
    this.gcu = false;
    this.EVm = 0L;
    this.EVn = 0L;
    this.EVo = new Object();
    this.EVq = new WeakHashMap();
    Context localContext = paramContext.getApplicationContext();
    if (EVg == null) {
      EVg = new ap(Looper.getMainLooper());
    }
    String str = localContext.getApplicationInfo().dataDir;
    if (str != null)
    {
      paramContext = str;
      if (str.length() != 0) {}
    }
    else
    {
      ad.w("MicroMsg.MultiProcSharedPreferences", "Failed to retrive data path by ApplicationInfo.dataDir, use prefix hardcoded version instead.");
      paramContext = "/data/data/" + localContext.getPackageName();
    }
    ad.i("MicroMsg.MultiProcSharedPreferences", "Path to store sp data: ".concat(String.valueOf(paramContext)));
    paramContext = new File(paramContext, "shared_prefs");
    if (!paramContext.exists())
    {
      paramContext.mkdirs();
      this.EVi = new File(paramContext, paramString + ".xml");
      paramContext = this.EVi;
      this.EVj = new File(paramContext.getPath() + ".bak");
      this.mMode = paramInt;
      if ((paramInt & 0x4) == 0) {
        break label370;
      }
    }
    label370:
    for (boolean bool = true;; bool = false)
    {
      this.EVk = bool;
      if (this.EVk) {
        this.EVh = new FLock(this.EVi.getPath() + ".lock");
      }
      eFY();
      AppMethodBeat.o(156233);
      return;
      if ((paramContext.canRead()) && (paramContext.canWrite())) {
        break;
      }
      paramContext.setReadable(true, true);
      paramContext.setWritable(true, true);
      break;
    }
  }
  
  private void eFY()
  {
    AppMethodBeat.i(156234);
    try
    {
      this.gcu = false;
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(156202);
          synchronized (aw.this)
          {
            aw.a(aw.this);
            AppMethodBeat.o(156202);
            return;
          }
        }
      };
      h.Iye.aS(local1);
      AppMethodBeat.o(156234);
      return;
    }
    finally
    {
      AppMethodBeat.o(156234);
    }
  }
  
  private void eFZ()
  {
    AppMethodBeat.i(156237);
    while (!this.gcu) {
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException) {}
    }
    AppMethodBeat.o(156237);
  }
  
  public static SharedPreferences s(Context paramContext, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(156231);
    ax localax = ax.aFC(paramString);
    if (aw.a.eGb())
    {
      ad.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use Flock version MultiProcessSP.", new Object[] { paramString });
      aw localaw = (aw)EVr.get(paramString);
      if (localaw == null)
      {
        paramContext = new aw(paramContext, paramString, paramInt);
        EVr.put(paramString, paramContext);
      }
      for (;;)
      {
        ax.a(paramContext, localax);
        AppMethodBeat.o(156231);
        return localax;
        paramContext = localaw;
        if ((paramInt & 0x4) != 0)
        {
          for (;;)
          {
            try
            {
              if (localaw.EVl <= 0)
              {
                paramInt = i;
                if (localaw.EVm == localaw.EVi.lastModified())
                {
                  if (localaw.EVn != localaw.EVi.length()) {
                    paramInt = i;
                  }
                }
                else
                {
                  if (paramInt != 0) {
                    break label177;
                  }
                  paramContext = localaw;
                  break;
                }
              }
            }
            finally
            {
              AppMethodBeat.o(156231);
            }
            paramInt = 0;
          }
          label177:
          localaw.eFY();
          paramContext = localaw;
        }
      }
    }
    ad.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use system sp.", new Object[] { paramString });
    paramContext = paramContext.getSharedPreferences(paramString, paramInt);
    AppMethodBeat.o(156231);
    return paramContext;
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(156245);
    try
    {
      eFZ();
      boolean bool = this.fZH.containsKey(paramString);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(156245);
    }
  }
  
  public final SharedPreferences.Editor edit()
  {
    AppMethodBeat.i(156246);
    try
    {
      eFZ();
      b localb = new b((byte)0);
      AppMethodBeat.o(156246);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(156246);
    }
  }
  
  public final Map<String, ?> getAll()
  {
    AppMethodBeat.i(156238);
    try
    {
      eFZ();
      HashMap localHashMap = new HashMap(this.fZH);
      return localHashMap;
    }
    finally
    {
      AppMethodBeat.o(156238);
    }
  }
  
  public final boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156244);
    try
    {
      eFZ();
      paramString = (Boolean)this.fZH.get(paramString);
      if (paramString != null) {
        paramBoolean = paramString.booleanValue();
      }
      return paramBoolean;
    }
    finally
    {
      AppMethodBeat.o(156244);
    }
  }
  
  public final float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(156243);
    try
    {
      eFZ();
      paramString = (Float)this.fZH.get(paramString);
      if (paramString != null) {
        paramFloat = paramString.floatValue();
      }
      return paramFloat;
    }
    finally
    {
      AppMethodBeat.o(156243);
    }
  }
  
  public final int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(156241);
    try
    {
      eFZ();
      paramString = (Integer)this.fZH.get(paramString);
      if (paramString != null) {
        paramInt = paramString.intValue();
      }
      return paramInt;
    }
    finally
    {
      AppMethodBeat.o(156241);
    }
  }
  
  public final long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(156242);
    try
    {
      eFZ();
      paramString = (Long)this.fZH.get(paramString);
      if (paramString != null) {
        paramLong = paramString.longValue();
      }
      return paramLong;
    }
    finally
    {
      AppMethodBeat.o(156242);
    }
  }
  
  /* Error */
  public final String getString(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 456
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: invokespecial 399	com/tencent/mm/sdk/platformtools/aw:eFZ	()V
    //   12: aload_0
    //   13: getfield 92	com/tencent/mm/sdk/platformtools/aw:fZH	Ljava/util/Map;
    //   16: aload_1
    //   17: invokeinterface 423 2 0
    //   22: checkcast 145	java/lang/String
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +13 -> 40
    //   30: aload_0
    //   31: monitorexit
    //   32: ldc_w 456
    //   35: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_1
    //   39: areturn
    //   40: aload_2
    //   41: astore_1
    //   42: goto -12 -> 30
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: ldc_w 456
    //   51: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	aw
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
    //   0: ldc_w 459
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: invokespecial 399	com/tencent/mm/sdk/platformtools/aw:eFZ	()V
    //   12: aload_0
    //   13: getfield 92	com/tencent/mm/sdk/platformtools/aw:fZH	Ljava/util/Map;
    //   16: aload_1
    //   17: invokeinterface 423 2 0
    //   22: checkcast 461	java/util/Set
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +13 -> 40
    //   30: aload_0
    //   31: monitorexit
    //   32: ldc_w 459
    //   35: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_1
    //   39: areturn
    //   40: aload_2
    //   41: astore_1
    //   42: goto -12 -> 30
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: ldc_w 459
    //   51: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	aw
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
    AppMethodBeat.i(156235);
    try
    {
      this.EVq.put(paramOnSharedPreferenceChangeListener, EVp);
      return;
    }
    finally
    {
      AppMethodBeat.o(156235);
    }
  }
  
  public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    AppMethodBeat.i(156236);
    try
    {
      this.EVq.remove(paramOnSharedPreferenceChangeListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(156236);
    }
  }
  
  final class b
    implements SharedPreferences.Editor
  {
    private final Map<String, Object> EVv;
    private boolean EVw;
    
    private b()
    {
      AppMethodBeat.i(156213);
      this.EVv = new HashMap();
      this.EVw = false;
      AppMethodBeat.o(156213);
    }
    
    private FileOutputStream N(File paramFile)
    {
      AppMethodBeat.i(156225);
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
            ad.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create directory for SharedPreferences file ".concat(String.valueOf(paramFile)));
            AppMethodBeat.o(156225);
            return null;
          }
          aw.f((File)localObject, aw.h(aw.this));
          try
          {
            localObject = new FileOutputStream(paramFile);
            paramFile = (File)localObject;
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            ad.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create SharedPreferences file ".concat(String.valueOf(paramFile)), new Object[] { localFileNotFoundException2 });
            paramFile = null;
          }
        }
      }
      AppMethodBeat.o(156225);
      return paramFile;
    }
    
    private void a(final aw.c paramc)
    {
      AppMethodBeat.i(156226);
      if ((paramc.csT == null) || (paramc.EVC == null) || (paramc.EVC.size() == 0))
      {
        AppMethodBeat.o(156226);
        return;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        int i = paramc.EVC.size() - 1;
        while (i >= 0)
        {
          String str = (String)paramc.EVC.get(i);
          Iterator localIterator = paramc.csT.iterator();
          while (localIterator.hasNext())
          {
            SharedPreferences.OnSharedPreferenceChangeListener localOnSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener)localIterator.next();
            if (localOnSharedPreferenceChangeListener != null) {
              localOnSharedPreferenceChangeListener.onSharedPreferenceChanged(aw.this, str);
            }
          }
          i -= 1;
        }
        AppMethodBeat.o(156226);
        return;
      }
      aw.eGa().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(156212);
          aw.b.b(aw.b.this, paramc);
          AppMethodBeat.o(156212);
        }
      });
      AppMethodBeat.o(156226);
    }
    
    private void a(final aw.c paramc, Runnable arg2)
    {
      int j = 1;
      AppMethodBeat.i(156224);
      paramc = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(156211);
          synchronized (aw.f(aw.this))
          {
            aw.b.a(aw.b.this, paramc);
          }
          synchronized (aw.this)
          {
            aw.g(aw.this);
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            AppMethodBeat.o(156211);
            return;
            localObject2 = finally;
            AppMethodBeat.o(156211);
            throw localObject2;
          }
        }
      };
      int i;
      if (??? == null) {
        i = 1;
      }
      while (i != 0) {
        synchronized (aw.this)
        {
          if (aw.b(aw.this) == 1)
          {
            i = j;
            if (i != 0)
            {
              paramc.run();
              AppMethodBeat.o(156224);
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
      bf.eGn().execute(paramc);
      AppMethodBeat.o(156224);
    }
    
    private aw.c eGc()
    {
      AppMethodBeat.i(156223);
      aw.c localc1 = new aw.c((byte)0);
      for (;;)
      {
        Object localObject2;
        String str;
        synchronized (aw.this)
        {
          if (aw.b(aw.this) > 0) {
            aw.a(aw.this, new HashMap(aw.c(aw.this)));
          }
          localc1.EVD = aw.c(aw.this);
          aw.d(aw.this);
          if (aw.e(aw.this).size() > 0)
          {
            i = 1;
            if (i != 0)
            {
              localc1.EVC = new ArrayList();
              localc1.csT = new HashSet(aw.e(aw.this).keySet());
            }
            try
            {
              if (this.EVw)
              {
                if (!aw.c(aw.this).isEmpty())
                {
                  localc1.EVB = true;
                  aw.c(aw.this).clear();
                }
                this.EVw = false;
              }
              Iterator localIterator = this.EVv.entrySet().iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              localObject2 = (Map.Entry)localIterator.next();
              str = (String)((Map.Entry)localObject2).getKey();
              localObject2 = ((Map.Entry)localObject2).getValue();
              if (localObject2 != this) {
                break label318;
              }
              if (!aw.c(aw.this).containsKey(str)) {
                continue;
              }
              aw.c(aw.this).remove(str);
              localc1.EVB = true;
              if (i == 0) {
                continue;
              }
              localc1.EVC.add(str);
              continue;
              localc2 = finally;
            }
            finally
            {
              AppMethodBeat.o(156223);
            }
          }
        }
        int i = 0;
        continue;
        label318:
        if (aw.c(aw.this).containsKey(str))
        {
          Object localObject3 = aw.c(aw.this).get(str);
          if ((localObject3 != null) && (localObject3.equals(localObject2))) {}
        }
        else
        {
          aw.c(aw.this).put(str, localObject2);
        }
      }
      this.EVv.clear();
      AppMethodBeat.o(156223);
      return localc2;
    }
    
    public final void apply()
    {
      AppMethodBeat.i(156222);
      final aw.c localc = eGc();
      final Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(156209);
          try
          {
            localc.EVE.await();
            AppMethodBeat.o(156209);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            AppMethodBeat.o(156209);
          }
        }
      };
      bf.aA(local1);
      a(localc, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(156210);
          local1.run();
          bf.aB(local1);
          AppMethodBeat.o(156210);
        }
      });
      a(localc);
      AppMethodBeat.o(156222);
    }
    
    public final SharedPreferences.Editor clear()
    {
      try
      {
        this.EVw = true;
        return this;
      }
      finally {}
    }
    
    public final boolean commit()
    {
      AppMethodBeat.i(156221);
      aw.c localc = eGc();
      a(localc, null);
      try
      {
        localc.EVE.await();
        a(localc);
        boolean bool = localc.EVF;
        AppMethodBeat.o(156221);
        return bool;
      }
      catch (InterruptedException localInterruptedException)
      {
        AppMethodBeat.o(156221);
      }
      return false;
    }
    
    public final SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(156219);
      try
      {
        this.EVv.put(paramString, Boolean.valueOf(paramBoolean));
        return this;
      }
      finally
      {
        AppMethodBeat.o(156219);
      }
    }
    
    public final SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      AppMethodBeat.i(156218);
      try
      {
        this.EVv.put(paramString, Float.valueOf(paramFloat));
        return this;
      }
      finally
      {
        AppMethodBeat.o(156218);
      }
    }
    
    public final SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(156216);
      try
      {
        this.EVv.put(paramString, Integer.valueOf(paramInt));
        return this;
      }
      finally
      {
        AppMethodBeat.o(156216);
      }
    }
    
    public final SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(156217);
      try
      {
        this.EVv.put(paramString, Long.valueOf(paramLong));
        return this;
      }
      finally
      {
        AppMethodBeat.o(156217);
      }
    }
    
    public final SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(156214);
      try
      {
        this.EVv.put(paramString1, paramString2);
        return this;
      }
      finally
      {
        AppMethodBeat.o(156214);
      }
    }
    
    public final SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      AppMethodBeat.i(156215);
      try
      {
        this.EVv.put(paramString, paramSet);
        return this;
      }
      finally
      {
        AppMethodBeat.o(156215);
      }
    }
    
    public final SharedPreferences.Editor remove(String paramString)
    {
      AppMethodBeat.i(156220);
      try
      {
        this.EVv.put(paramString, this);
        return this;
      }
      finally
      {
        AppMethodBeat.o(156220);
      }
    }
  }
  
  static final class c
  {
    public boolean EVB;
    public List<String> EVC;
    public Map<String, Object> EVD;
    public final CountDownLatch EVE;
    public volatile boolean EVF;
    public Set<SharedPreferences.OnSharedPreferenceChangeListener> csT;
    
    private c()
    {
      AppMethodBeat.i(156229);
      this.EVB = false;
      this.EVC = null;
      this.csT = null;
      this.EVD = null;
      this.EVE = new CountDownLatch(1);
      this.EVF = false;
      AppMethodBeat.o(156229);
    }
    
    public final void uU(boolean paramBoolean)
    {
      AppMethodBeat.i(156230);
      this.EVF = paramBoolean;
      this.EVE.countDown();
      AppMethodBeat.o(156230);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.aw
 * JD-Core Version:    0.7.0.1
 */