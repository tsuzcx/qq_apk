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
public final class ax
  implements SharedPreferences
{
  private static final Object IyB;
  private static final LruCache<String, ax> IyD;
  private static aq Iys;
  private final Object IyA;
  private final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> IyC;
  private FLock Iyt;
  private File Iyu;
  private File Iyv;
  private boolean Iyw;
  private int Iyx;
  private long Iyy;
  private long Iyz;
  private Map<String, Object> gAE;
  private boolean gDr;
  private int mMode;
  
  static
  {
    AppMethodBeat.i(156249);
    Iys = null;
    IyB = new Object();
    IyD = new LruCache(5);
    AppMethodBeat.o(156249);
  }
  
  private ax()
  {
    AppMethodBeat.i(156232);
    this.Iyt = null;
    this.Iyu = null;
    this.Iyv = null;
    this.mMode = 0;
    this.Iyw = false;
    this.gAE = null;
    this.Iyx = 0;
    this.gDr = false;
    this.Iyy = 0L;
    this.Iyz = 0L;
    this.IyA = new Object();
    this.IyC = new WeakHashMap();
    RuntimeException localRuntimeException = new RuntimeException("Not supported.");
    AppMethodBeat.o(156232);
    throw localRuntimeException;
  }
  
  private ax(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(156233);
    this.Iyt = null;
    this.Iyu = null;
    this.Iyv = null;
    this.mMode = 0;
    this.Iyw = false;
    this.gAE = null;
    this.Iyx = 0;
    this.gDr = false;
    this.Iyy = 0L;
    this.Iyz = 0L;
    this.IyA = new Object();
    this.IyC = new WeakHashMap();
    Context localContext = paramContext.getApplicationContext();
    if (Iys == null) {
      Iys = new aq(Looper.getMainLooper());
    }
    String str = localContext.getApplicationInfo().dataDir;
    if (str != null)
    {
      paramContext = str;
      if (str.length() != 0) {}
    }
    else
    {
      ae.w("MicroMsg.MultiProcSharedPreferences", "Failed to retrive data path by ApplicationInfo.dataDir, use prefix hardcoded version instead.");
      paramContext = "/data/data/" + localContext.getPackageName();
    }
    ae.i("MicroMsg.MultiProcSharedPreferences", "Path to store sp data: ".concat(String.valueOf(paramContext)));
    paramContext = new File(paramContext, "shared_prefs");
    if (!paramContext.exists())
    {
      paramContext.mkdirs();
      this.Iyu = new File(paramContext, paramString + ".xml");
      paramContext = this.Iyu;
      this.Iyv = new File(paramContext.getPath() + ".bak");
      this.mMode = paramInt;
      if ((paramInt & 0x4) == 0) {
        break label370;
      }
    }
    label370:
    for (boolean bool = true;; bool = false)
    {
      this.Iyw = bool;
      if (this.Iyw) {
        this.Iyt = new FLock(this.Iyu.getPath() + ".lock");
      }
      foV();
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
  
  private void foV()
  {
    AppMethodBeat.i(156234);
    try
    {
      this.gDr = false;
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(156202);
          synchronized (ax.this)
          {
            ax.a(ax.this);
            AppMethodBeat.o(156202);
            return;
          }
        }
      };
      h.MqF.aR(local1);
      AppMethodBeat.o(156234);
      return;
    }
    finally
    {
      AppMethodBeat.o(156234);
    }
  }
  
  private void foW()
  {
    AppMethodBeat.i(156237);
    while (!this.gDr) {
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException) {}
    }
    AppMethodBeat.o(156237);
  }
  
  public static SharedPreferences r(Context paramContext, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(156231);
    ay localay = ay.aRW(paramString);
    if (ax.a.foY())
    {
      ae.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use Flock version MultiProcessSP.", new Object[] { paramString });
      ax localax = (ax)IyD.get(paramString);
      if (localax == null)
      {
        paramContext = new ax(paramContext, paramString, paramInt);
        IyD.put(paramString, paramContext);
      }
      for (;;)
      {
        ay.a(paramContext, localay);
        AppMethodBeat.o(156231);
        return localay;
        paramContext = localax;
        if ((paramInt & 0x4) != 0)
        {
          for (;;)
          {
            try
            {
              if (localax.Iyx <= 0)
              {
                paramInt = i;
                if (localax.Iyy == localax.Iyu.lastModified())
                {
                  if (localax.Iyz != localax.Iyu.length()) {
                    paramInt = i;
                  }
                }
                else
                {
                  if (paramInt != 0) {
                    break label177;
                  }
                  paramContext = localax;
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
          localax.foV();
          paramContext = localax;
        }
      }
    }
    ae.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use system sp.", new Object[] { paramString });
    paramContext = paramContext.getSharedPreferences(paramString, paramInt);
    AppMethodBeat.o(156231);
    return paramContext;
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(156245);
    try
    {
      foW();
      boolean bool = this.gAE.containsKey(paramString);
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
      foW();
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
      foW();
      HashMap localHashMap = new HashMap(this.gAE);
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
      foW();
      paramString = (Boolean)this.gAE.get(paramString);
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
      foW();
      paramString = (Float)this.gAE.get(paramString);
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
      foW();
      paramString = (Integer)this.gAE.get(paramString);
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
      foW();
      paramString = (Long)this.gAE.get(paramString);
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
    //   9: invokespecial 399	com/tencent/mm/sdk/platformtools/ax:foW	()V
    //   12: aload_0
    //   13: getfield 92	com/tencent/mm/sdk/platformtools/ax:gAE	Ljava/util/Map;
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
    //   0	56	0	this	ax
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
    //   9: invokespecial 399	com/tencent/mm/sdk/platformtools/ax:foW	()V
    //   12: aload_0
    //   13: getfield 92	com/tencent/mm/sdk/platformtools/ax:gAE	Ljava/util/Map;
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
    //   0	56	0	this	ax
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
      this.IyC.put(paramOnSharedPreferenceChangeListener, IyB);
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
      this.IyC.remove(paramOnSharedPreferenceChangeListener);
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
    private final Map<String, Object> IyH;
    private boolean IyI;
    
    private b()
    {
      AppMethodBeat.i(156213);
      this.IyH = new HashMap();
      this.IyI = false;
      AppMethodBeat.o(156213);
    }
    
    private FileOutputStream S(File paramFile)
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
            ae.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create directory for SharedPreferences file ".concat(String.valueOf(paramFile)));
            AppMethodBeat.o(156225);
            return null;
          }
          ax.f((File)localObject, ax.h(ax.this));
          try
          {
            localObject = new FileOutputStream(paramFile);
            paramFile = (File)localObject;
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            ae.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create SharedPreferences file ".concat(String.valueOf(paramFile)), new Object[] { localFileNotFoundException2 });
            paramFile = null;
          }
        }
      }
      AppMethodBeat.o(156225);
      return paramFile;
    }
    
    private void a(final ax.c paramc)
    {
      AppMethodBeat.i(156226);
      if ((paramc.cBA == null) || (paramc.IyO == null) || (paramc.IyO.size() == 0))
      {
        AppMethodBeat.o(156226);
        return;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        int i = paramc.IyO.size() - 1;
        while (i >= 0)
        {
          String str = (String)paramc.IyO.get(i);
          Iterator localIterator = paramc.cBA.iterator();
          while (localIterator.hasNext())
          {
            SharedPreferences.OnSharedPreferenceChangeListener localOnSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener)localIterator.next();
            if (localOnSharedPreferenceChangeListener != null) {
              localOnSharedPreferenceChangeListener.onSharedPreferenceChanged(ax.this, str);
            }
          }
          i -= 1;
        }
        AppMethodBeat.o(156226);
        return;
      }
      ax.foX().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(156212);
          ax.b.b(ax.b.this, paramc);
          AppMethodBeat.o(156212);
        }
      });
      AppMethodBeat.o(156226);
    }
    
    private void a(final ax.c paramc, Runnable arg2)
    {
      int j = 1;
      AppMethodBeat.i(156224);
      paramc = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(156211);
          synchronized (ax.f(ax.this))
          {
            ax.b.a(ax.b.this, paramc);
          }
          synchronized (ax.this)
          {
            ax.g(ax.this);
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
        synchronized (ax.this)
        {
          if (ax.b(ax.this) == 1)
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
      bg.fpk().execute(paramc);
      AppMethodBeat.o(156224);
    }
    
    private ax.c foZ()
    {
      AppMethodBeat.i(156223);
      ax.c localc1 = new ax.c((byte)0);
      for (;;)
      {
        Object localObject2;
        String str;
        synchronized (ax.this)
        {
          if (ax.b(ax.this) > 0) {
            ax.a(ax.this, new HashMap(ax.c(ax.this)));
          }
          localc1.IyP = ax.c(ax.this);
          ax.d(ax.this);
          if (ax.e(ax.this).size() > 0)
          {
            i = 1;
            if (i != 0)
            {
              localc1.IyO = new ArrayList();
              localc1.cBA = new HashSet(ax.e(ax.this).keySet());
            }
            try
            {
              if (this.IyI)
              {
                if (!ax.c(ax.this).isEmpty())
                {
                  localc1.IyN = true;
                  ax.c(ax.this).clear();
                }
                this.IyI = false;
              }
              Iterator localIterator = this.IyH.entrySet().iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              localObject2 = (Map.Entry)localIterator.next();
              str = (String)((Map.Entry)localObject2).getKey();
              localObject2 = ((Map.Entry)localObject2).getValue();
              if (localObject2 != this) {
                break label318;
              }
              if (!ax.c(ax.this).containsKey(str)) {
                continue;
              }
              ax.c(ax.this).remove(str);
              localc1.IyN = true;
              if (i == 0) {
                continue;
              }
              localc1.IyO.add(str);
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
        if (ax.c(ax.this).containsKey(str))
        {
          Object localObject3 = ax.c(ax.this).get(str);
          if ((localObject3 != null) && (localObject3.equals(localObject2))) {}
        }
        else
        {
          ax.c(ax.this).put(str, localObject2);
        }
      }
      this.IyH.clear();
      AppMethodBeat.o(156223);
      return localc2;
    }
    
    public final void apply()
    {
      AppMethodBeat.i(156222);
      final ax.c localc = foZ();
      final Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(156209);
          try
          {
            localc.IyQ.await();
            AppMethodBeat.o(156209);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            AppMethodBeat.o(156209);
          }
        }
      };
      bg.az(local1);
      a(localc, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(156210);
          local1.run();
          bg.aA(local1);
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
        this.IyI = true;
        return this;
      }
      finally {}
    }
    
    public final boolean commit()
    {
      AppMethodBeat.i(156221);
      ax.c localc = foZ();
      a(localc, null);
      try
      {
        localc.IyQ.await();
        a(localc);
        boolean bool = localc.IyR;
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
        this.IyH.put(paramString, Boolean.valueOf(paramBoolean));
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
        this.IyH.put(paramString, Float.valueOf(paramFloat));
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
        this.IyH.put(paramString, Integer.valueOf(paramInt));
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
        this.IyH.put(paramString, Long.valueOf(paramLong));
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
        this.IyH.put(paramString1, paramString2);
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
        this.IyH.put(paramString, paramSet);
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
        this.IyH.put(paramString, this);
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
    public boolean IyN;
    public List<String> IyO;
    public Map<String, Object> IyP;
    public final CountDownLatch IyQ;
    public volatile boolean IyR;
    public Set<SharedPreferences.OnSharedPreferenceChangeListener> cBA;
    
    private c()
    {
      AppMethodBeat.i(156229);
      this.IyN = false;
      this.IyO = null;
      this.cBA = null;
      this.IyP = null;
      this.IyQ = new CountDownLatch(1);
      this.IyR = false;
      AppMethodBeat.o(156229);
    }
    
    public final void wQ(boolean paramBoolean)
    {
      AppMethodBeat.i(156230);
      this.IyR = paramBoolean;
      this.IyQ.countDown();
      AppMethodBeat.o(156230);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ax
 * JD-Core Version:    0.7.0.1
 */