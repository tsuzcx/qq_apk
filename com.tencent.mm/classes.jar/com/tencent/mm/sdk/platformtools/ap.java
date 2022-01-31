package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.ApplicationInfo;
import android.os.Looper;
import android.util.LruCache;
import com.tencent.mm.sdk.f.e;
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

public final class ap
  implements SharedPreferences
{
  private static final Object ugH = new Object();
  private static final LruCache<String, ap> ugJ = new LruCache(5);
  private static ah ugz = null;
  private Map<String, Object> dHb = null;
  private boolean dJO = false;
  private File fDw = null;
  private int mMode = 0;
  private FLock ugA = null;
  private File ugB = null;
  private boolean ugC = false;
  private int ugD = 0;
  private long ugE = 0L;
  private long ugF = 0L;
  private final Object ugG = new Object();
  private final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> ugI = new WeakHashMap();
  
  private ap()
  {
    throw new RuntimeException("Not supported.");
  }
  
  private ap(Context paramContext, String paramString, int paramInt)
  {
    Context localContext = paramContext.getApplicationContext();
    if (ugz == null) {
      ugz = new ah(Looper.getMainLooper());
    }
    String str = localContext.getApplicationInfo().dataDir;
    if (str != null)
    {
      paramContext = str;
      if (str.length() != 0) {}
    }
    else
    {
      y.w("MicroMsg.MultiProcSharedPreferences", "Failed to retrive data path by ApplicationInfo.dataDir, use prefix hardcoded version instead.");
      paramContext = "/data/data/" + localContext.getPackageName();
    }
    y.i("MicroMsg.MultiProcSharedPreferences", "Path to store sp data: " + paramContext);
    paramContext = new File(paramContext, "shared_prefs");
    if (!paramContext.exists())
    {
      paramContext.mkdirs();
      this.fDw = new File(paramContext, paramString + ".xml");
      paramContext = this.fDw;
      this.ugB = new File(paramContext.getPath() + ".bak");
      this.mMode = paramInt;
      if ((paramInt & 0x4) == 0) {
        break label367;
      }
    }
    label367:
    for (boolean bool = true;; bool = false)
    {
      this.ugC = bool;
      if (this.ugC) {
        this.ugA = new FLock(this.fDw.getPath() + ".lock");
      }
      crp();
      return;
      if ((paramContext.canRead()) && (paramContext.canWrite())) {
        break;
      }
      paramContext.setReadable(true, true);
      paramContext.setWritable(true, true);
      break;
    }
  }
  
  private void crp()
  {
    try
    {
      this.dJO = false;
      e.b(new Runnable()
      {
        public final void run()
        {
          synchronized (ap.this)
          {
            ap.a(ap.this);
            return;
          }
        }
      }, "MultiProcessSP-LoadThread").start();
      return;
    }
    finally {}
  }
  
  private void crq()
  {
    while (!this.dJO) {
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public static SharedPreferences l(Context paramContext, String paramString, int paramInt)
  {
    int i = 1;
    if (a.crs())
    {
      y.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use Flock version MultiProcessSP.", new Object[] { paramString });
      ap localap = (ap)ugJ.get(paramString);
      if (localap == null)
      {
        paramContext = new ap(paramContext, paramString, paramInt);
        ugJ.put(paramString, paramContext);
      }
      do
      {
        return paramContext;
        paramContext = localap;
      } while ((paramInt & 0x4) == 0);
      for (;;)
      {
        try
        {
          if (localap.ugD <= 0)
          {
            paramInt = i;
            if (localap.ugE == localap.fDw.lastModified())
            {
              if (localap.ugF != localap.fDw.length()) {
                paramInt = i;
              }
            }
            else
            {
              if (paramInt != 0) {
                break;
              }
              return localap;
            }
          }
        }
        finally {}
        paramInt = 0;
      }
      localap.crp();
      return localap;
    }
    y.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use system sp.", new Object[] { paramString });
    return paramContext.getSharedPreferences(paramString, paramInt);
  }
  
  public final boolean contains(String paramString)
  {
    try
    {
      crq();
      boolean bool = this.dHb.containsKey(paramString);
      return bool;
    }
    finally {}
  }
  
  public final SharedPreferences.Editor edit()
  {
    try
    {
      crq();
      return new b((byte)0);
    }
    finally {}
  }
  
  public final Map<String, ?> getAll()
  {
    try
    {
      crq();
      HashMap localHashMap = new HashMap(this.dHb);
      return localHashMap;
    }
    finally {}
  }
  
  public final boolean getBoolean(String paramString, boolean paramBoolean)
  {
    try
    {
      crq();
      paramString = (Boolean)this.dHb.get(paramString);
      if (paramString != null) {
        paramBoolean = paramString.booleanValue();
      }
      return paramBoolean;
    }
    finally {}
  }
  
  public final float getFloat(String paramString, float paramFloat)
  {
    try
    {
      crq();
      paramString = (Float)this.dHb.get(paramString);
      if (paramString != null) {
        paramFloat = paramString.floatValue();
      }
      return paramFloat;
    }
    finally {}
  }
  
  public final int getInt(String paramString, int paramInt)
  {
    try
    {
      crq();
      paramString = (Integer)this.dHb.get(paramString);
      if (paramString != null) {
        paramInt = paramString.intValue();
      }
      return paramInt;
    }
    finally {}
  }
  
  public final long getLong(String paramString, long paramLong)
  {
    try
    {
      crq();
      paramString = (Long)this.dHb.get(paramString);
      if (paramString != null) {
        paramLong = paramString.longValue();
      }
      return paramLong;
    }
    finally {}
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        crq();
        paramString1 = (String)this.dHb.get(paramString1);
        if (paramString1 != null) {
          return paramString1;
        }
      }
      finally {}
      paramString1 = paramString2;
    }
  }
  
  public final Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    for (;;)
    {
      try
      {
        crq();
        paramString = (Set)this.dHb.get(paramString);
        if (paramString != null) {
          return paramString;
        }
      }
      finally {}
      paramString = paramSet;
    }
  }
  
  public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    try
    {
      this.ugI.put(paramOnSharedPreferenceChangeListener, ugH);
      return;
    }
    finally {}
  }
  
  public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    try
    {
      this.ugI.remove(paramOnSharedPreferenceChangeListener);
      return;
    }
    finally {}
  }
  
  public static final class a
  {
    private static SharedPreferences mPref = ae.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
    public static String ugL = "pref_key_is_enable_MultiProcSP";
    public static String ugM = "pref_key_is_disabled_MultiProcSP_manually";
    
    private static boolean Zq(String paramString)
    {
      SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
      mPref = localSharedPreferences;
      if (localSharedPreferences == null)
      {
        y.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
        return false;
      }
      boolean bool = mPref.getBoolean(paramString, false);
      y.d("MicroMsg.MultiProcSharedPreferences", "DynamicConfigStorage, getValue:%b", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    
    public static boolean crs()
    {
      return (!Zq(ugM)) && (Zq(ugL));
    }
    
    public static void mu(boolean paramBoolean)
    {
      setValue(ugM, paramBoolean);
    }
    
    public static void setValue(String paramString, boolean paramBoolean)
    {
      if (mPref == null)
      {
        y.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
        return;
      }
      SharedPreferences.Editor localEditor = mPref.edit();
      localEditor.putBoolean(paramString, paramBoolean);
      localEditor.commit();
    }
  }
  
  private final class b
    implements SharedPreferences.Editor
  {
    private final Map<String, Object> ugN = new HashMap();
    private boolean ugO = false;
    
    private b() {}
    
    private FileOutputStream N(File paramFile)
    {
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
        return localFileOutputStream;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        Object localObject = paramFile.getParentFile();
        if (!((File)localObject).mkdir())
        {
          y.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create directory for SharedPreferences file " + paramFile);
          return null;
        }
        ap.e((File)localObject, ap.h(ap.this));
        try
        {
          localObject = new FileOutputStream(paramFile);
          return localObject;
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          y.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create SharedPreferences file " + paramFile, new Object[] { localFileNotFoundException2 });
        }
      }
      return null;
    }
    
    private void a(final ap.c paramc)
    {
      if ((paramc.dup == null) || (paramc.ugU == null) || (paramc.ugU.size() == 0)) {}
      for (;;)
      {
        return;
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        int i = paramc.ugU.size() - 1;
        while (i >= 0)
        {
          String str = (String)paramc.ugU.get(i);
          Iterator localIterator = paramc.dup.iterator();
          while (localIterator.hasNext())
          {
            SharedPreferences.OnSharedPreferenceChangeListener localOnSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener)localIterator.next();
            if (localOnSharedPreferenceChangeListener != null) {
              localOnSharedPreferenceChangeListener.onSharedPreferenceChanged(ap.this, str);
            }
          }
          i -= 1;
        }
      }
      ap.crr().post(new Runnable()
      {
        public final void run()
        {
          ap.b.b(ap.b.this, paramc);
        }
      });
    }
    
    private void a(final ap.c paramc, Runnable arg2)
    {
      int j = 1;
      paramc = new Runnable()
      {
        public final void run()
        {
          synchronized (ap.f(ap.this))
          {
            ap.b.a(ap.b.this, paramc);
          }
          synchronized (ap.this)
          {
            ap.g(ap.this);
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            return;
            localObject2 = finally;
            throw localObject2;
          }
        }
      };
      int i;
      if (??? == null) {
        i = 1;
      }
      while (i != 0) {
        synchronized (ap.this)
        {
          if (ap.b(ap.this) == 1)
          {
            i = j;
            if (i != 0)
            {
              paramc.run();
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
      aw.cry().execute(paramc);
    }
    
    private ap.c crt()
    {
      ap.c localc1 = new ap.c((byte)0);
      for (;;)
      {
        Object localObject2;
        String str;
        synchronized (ap.this)
        {
          if (ap.b(ap.this) > 0) {
            ap.a(ap.this, new HashMap(ap.c(ap.this)));
          }
          localc1.ugV = ap.c(ap.this);
          ap.d(ap.this);
          if (ap.e(ap.this).size() > 0)
          {
            i = 1;
            if (i != 0)
            {
              localc1.ugU = new ArrayList();
              localc1.dup = new HashSet(ap.e(ap.this).keySet());
            }
            try
            {
              if (this.ugO)
              {
                if (!ap.c(ap.this).isEmpty())
                {
                  localc1.ugT = true;
                  ap.c(ap.this).clear();
                }
                this.ugO = false;
              }
              Iterator localIterator = this.ugN.entrySet().iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              localObject2 = (Map.Entry)localIterator.next();
              str = (String)((Map.Entry)localObject2).getKey();
              localObject2 = ((Map.Entry)localObject2).getValue();
              if (localObject2 != this) {
                break label300;
              }
              if (!ap.c(ap.this).containsKey(str)) {
                continue;
              }
              ap.c(ap.this).remove(str);
              localc1.ugT = true;
              if (i == 0) {
                continue;
              }
              localc1.ugU.add(str);
              continue;
              localc2 = finally;
            }
            finally {}
          }
        }
        int i = 0;
        continue;
        label300:
        if (ap.c(ap.this).containsKey(str))
        {
          Object localObject3 = ap.c(ap.this).get(str);
          if ((localObject3 != null) && (localObject3.equals(localObject2))) {}
        }
        else
        {
          ap.c(ap.this).put(str, localObject2);
        }
      }
      this.ugN.clear();
      return localc2;
    }
    
    public final void apply()
    {
      final ap.c localc = crt();
      final Runnable local1 = new Runnable()
      {
        public final void run()
        {
          try
          {
            localc.ugW.await();
            return;
          }
          catch (InterruptedException localInterruptedException) {}
        }
      };
      aw.U(local1);
      a(localc, new Runnable()
      {
        public final void run()
        {
          local1.run();
          aw.V(local1);
        }
      });
      a(localc);
    }
    
    public final SharedPreferences.Editor clear()
    {
      try
      {
        this.ugO = true;
        return this;
      }
      finally {}
    }
    
    public final boolean commit()
    {
      ap.c localc = crt();
      a(localc, null);
      try
      {
        localc.ugW.await();
        a(localc);
        return localc.ugX;
      }
      catch (InterruptedException localInterruptedException) {}
      return false;
    }
    
    public final SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      try
      {
        this.ugN.put(paramString, Boolean.valueOf(paramBoolean));
        return this;
      }
      finally {}
    }
    
    public final SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      try
      {
        this.ugN.put(paramString, Float.valueOf(paramFloat));
        return this;
      }
      finally {}
    }
    
    public final SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      try
      {
        this.ugN.put(paramString, Integer.valueOf(paramInt));
        return this;
      }
      finally {}
    }
    
    public final SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      try
      {
        this.ugN.put(paramString, Long.valueOf(paramLong));
        return this;
      }
      finally {}
    }
    
    public final SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      try
      {
        this.ugN.put(paramString1, paramString2);
        return this;
      }
      finally {}
    }
    
    public final SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      try
      {
        this.ugN.put(paramString, paramSet);
        return this;
      }
      finally {}
    }
    
    public final SharedPreferences.Editor remove(String paramString)
    {
      try
      {
        this.ugN.put(paramString, this);
        return this;
      }
      finally {}
    }
  }
  
  private static final class c
  {
    public Set<SharedPreferences.OnSharedPreferenceChangeListener> dup = null;
    public boolean ugT = false;
    public List<String> ugU = null;
    public Map<String, Object> ugV = null;
    public final CountDownLatch ugW = new CountDownLatch(1);
    public volatile boolean ugX = false;
    
    public final void mv(boolean paramBoolean)
    {
      this.ugX = paramBoolean;
      this.ugW.countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ap
 * JD-Core Version:    0.7.0.1
 */