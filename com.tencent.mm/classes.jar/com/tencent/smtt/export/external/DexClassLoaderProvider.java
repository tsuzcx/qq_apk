package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

public class DexClassLoaderProvider
  extends DexClassLoader
{
  private static final String IS_FIRST_LOAD_DEX_FLAG_FILE = "is_first_load_dex_flag_file";
  static final String LAST_DEX_NAME = "tbs_shell_dex.jar";
  private static final String LOGTAG = "dexloader";
  protected static DexClassLoader mClassLoaderOriginal = null;
  private static Context mContext = null;
  private static boolean mForceLoadDexFlag;
  private static DexClassLoaderProvider mInstance = null;
  private static String mRealDexPath = null;
  protected static Service mService;
  private SpeedyDexClassLoader mClassLoader;
  
  static
  {
    mForceLoadDexFlag = false;
    mService = null;
  }
  
  private DexClassLoaderProvider(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
    AppMethodBeat.i(53109);
    this.mClassLoader = null;
    if (paramBoolean)
    {
      new StringBuilder("SpeedyDexClassLoader: ").append(mRealDexPath);
      this.mClassLoader = new SpeedyDexClassLoader(mRealDexPath, null, paramString3, paramClassLoader);
      AppMethodBeat.o(53109);
      return;
    }
    new StringBuilder("DexClassLoader: ").append(mRealDexPath);
    this.mClassLoader = null;
    AppMethodBeat.o(53109);
  }
  
  public static DexClassLoader createDexClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, Context paramContext)
  {
    AppMethodBeat.i(53110);
    new StringBuilder("new DexClassLoaderDelegate: ").append(paramString1).append(", context: ").append(paramContext);
    mContext = paramContext.getApplicationContext();
    mRealDexPath = paramString1;
    int i = paramString1.lastIndexOf("/");
    paramContext = paramString1.substring(0, i + 1);
    paramContext = paramContext + "fake_dex.jar";
    String str = paramString1.substring(i + 1);
    if (is_first_load_tbs_dex(paramString2, str))
    {
      mInstance = new DexClassLoaderProvider(paramContext, paramString2, paramString3, paramClassLoader, true);
      doAsyncDexLoad(str, paramString1, paramString2, paramString3, paramClassLoader);
    }
    for (;;)
    {
      paramString1 = mInstance;
      AppMethodBeat.o(53110);
      return paramString1;
      mInstance = new DexClassLoaderProvider(paramString1, paramString2, paramString3, paramClassLoader, false);
    }
  }
  
  private static void doAsyncDexLoad(final String paramString1, String paramString2, final String paramString3, final String paramString4, final ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(53111);
    if (shouldSkipAsyncDexLoad())
    {
      paramClassLoader = new ArrayList(4);
      paramClassLoader.add(0, paramString1);
      paramClassLoader.add(1, paramString2);
      paramClassLoader.add(2, paramString3);
      paramClassLoader.add(3, paramString4);
      paramString2 = new Intent(mContext, DexClassLoaderProviderService.class);
      paramString2.putStringArrayListExtra("dex2oat", paramClassLoader);
      mContext.startService(paramString2);
      new StringBuilder("shouldSkipAsyncDexLoad(").append(paramString1).append(", ").append(paramString2).append(")");
      AppMethodBeat.o(53111);
      return;
    }
    new StringBuilder("Background real dex loading(").append(paramString1).append(")");
    new Timer().schedule(new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(53101);
        Object localObject = new File(this.val$dexPath.replace(".jar", ".dex"));
        if ((((File)localObject).exists()) && (((File)localObject).length() != 0L)) {
          new StringBuilder().append(localObject).append(" existed!");
        }
        for (boolean bool = true;; bool = false)
        {
          long l1 = System.currentTimeMillis();
          new DexClassLoader(this.val$dexPath, paramString3, paramString4, paramClassLoader);
          long l2 = System.currentTimeMillis();
          DexClassLoaderProvider.access$000(paramString3, paramString1);
          localObject = String.format("load_dex completed -- cl_cost: %d, existed: %b", new Object[] { Long.valueOf(l2 - l1), Boolean.valueOf(bool) });
          new StringBuilder().append((String)localObject);
          if ((DexClassLoaderProvider.mForceLoadDexFlag) && ("tbs_shell_dex.jar".equals(paramString1)) && (DexClassLoaderProvider.mService != null)) {
            DexClassLoaderProvider.mService.stopSelf();
          }
          AppMethodBeat.o(53101);
          return;
          new StringBuilder().append(localObject).append(" does not existed!");
        }
      }
    }, 2000L);
    AppMethodBeat.o(53111);
  }
  
  private static boolean is_first_load_tbs_dex(String paramString1, String paramString2)
  {
    AppMethodBeat.i(53112);
    if (mForceLoadDexFlag)
    {
      AppMethodBeat.o(53112);
      return true;
    }
    if (!new File(paramString1, paramString2 + "_is_first_load_dex_flag_file").exists())
    {
      AppMethodBeat.o(53112);
      return true;
    }
    AppMethodBeat.o(53112);
    return false;
  }
  
  public static void setForceLoadDexFlag(boolean paramBoolean, Service paramService)
  {
    mForceLoadDexFlag = paramBoolean;
    mService = paramService;
  }
  
  private static void set_first_load_tbs_dex(String paramString1, String paramString2)
  {
    AppMethodBeat.i(53113);
    paramString1 = new File(paramString1, paramString2 + "_is_first_load_dex_flag_file");
    if (!paramString1.exists()) {
      try
      {
        paramString1.createNewFile();
        AppMethodBeat.o(53113);
        return;
      }
      catch (Throwable paramString1) {}
    }
    AppMethodBeat.o(53113);
  }
  
  private static boolean shouldSkipAsyncDexLoad()
  {
    if (mForceLoadDexFlag) {}
    while (Build.VERSION.SDK_INT != 21) {
      return false;
    }
    return true;
  }
  
  private boolean useSelfClassloader()
  {
    return this.mClassLoader == null;
  }
  
  public void clearAssertionStatus()
  {
    AppMethodBeat.i(53120);
    if (useSelfClassloader())
    {
      super.clearAssertionStatus();
      AppMethodBeat.o(53120);
      return;
    }
    this.mClassLoader.clearAssertionStatus();
    AppMethodBeat.o(53120);
  }
  
  protected Package definePackage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, URL paramURL)
  {
    AppMethodBeat.i(53121);
    if (useSelfClassloader())
    {
      paramString1 = super.definePackage(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramURL);
      AppMethodBeat.o(53121);
      return paramString1;
    }
    paramString1 = this.mClassLoader.definePackage(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramURL);
    AppMethodBeat.o(53121);
    return paramString1;
  }
  
  protected Class<?> findClass(String paramString)
  {
    AppMethodBeat.i(53114);
    if (useSelfClassloader())
    {
      paramString = super.findClass(paramString);
      AppMethodBeat.o(53114);
      return paramString;
    }
    paramString = this.mClassLoader.findClass(paramString);
    AppMethodBeat.o(53114);
    return paramString;
  }
  
  public String findLibrary(String paramString)
  {
    AppMethodBeat.i(53115);
    if (useSelfClassloader())
    {
      paramString = super.findLibrary(paramString);
      AppMethodBeat.o(53115);
      return paramString;
    }
    paramString = this.mClassLoader.findLibrary(paramString);
    AppMethodBeat.o(53115);
    return paramString;
  }
  
  protected URL findResource(String paramString)
  {
    AppMethodBeat.i(53116);
    if (useSelfClassloader())
    {
      paramString = super.findResource(paramString);
      AppMethodBeat.o(53116);
      return paramString;
    }
    paramString = this.mClassLoader.findResource(paramString);
    AppMethodBeat.o(53116);
    return paramString;
  }
  
  protected Enumeration<URL> findResources(String paramString)
  {
    AppMethodBeat.i(53117);
    if (useSelfClassloader())
    {
      paramString = super.findResources(paramString);
      AppMethodBeat.o(53117);
      return paramString;
    }
    paramString = this.mClassLoader.findResources(paramString);
    AppMethodBeat.o(53117);
    return paramString;
  }
  
  SpeedyDexClassLoader getClassLoader()
  {
    return this.mClassLoader;
  }
  
  /* Error */
  protected Package getPackage(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 256
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 215	com/tencent/smtt/export/external/DexClassLoaderProvider:useSelfClassloader	()Z
    //   12: ifeq +19 -> 31
    //   15: aload_0
    //   16: aload_1
    //   17: invokespecial 258	dalvik/system/DexClassLoader:getPackage	(Ljava/lang/String;)Ljava/lang/Package;
    //   20: astore_1
    //   21: ldc_w 256
    //   24: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: areturn
    //   31: aload_0
    //   32: getfield 61	com/tencent/smtt/export/external/DexClassLoaderProvider:mClassLoader	Lcom/tencent/smtt/export/external/DexClassLoaderProvider$SpeedyDexClassLoader;
    //   35: aload_1
    //   36: invokevirtual 259	com/tencent/smtt/export/external/DexClassLoaderProvider$SpeedyDexClassLoader:getPackage	(Ljava/lang/String;)Ljava/lang/Package;
    //   39: astore_1
    //   40: ldc_w 256
    //   43: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: goto -19 -> 27
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	DexClassLoaderProvider
    //   0	54	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	27	49	finally
    //   31	46	49	finally
  }
  
  protected Package[] getPackages()
  {
    AppMethodBeat.i(53122);
    if (useSelfClassloader())
    {
      arrayOfPackage = super.getPackages();
      AppMethodBeat.o(53122);
      return arrayOfPackage;
    }
    Package[] arrayOfPackage = this.mClassLoader.getPackages();
    AppMethodBeat.o(53122);
    return arrayOfPackage;
  }
  
  public URL getResource(String paramString)
  {
    AppMethodBeat.i(53123);
    if (useSelfClassloader())
    {
      paramString = super.getResource(paramString);
      AppMethodBeat.o(53123);
      return paramString;
    }
    paramString = this.mClassLoader.getResource(paramString);
    AppMethodBeat.o(53123);
    return paramString;
  }
  
  public InputStream getResourceAsStream(String paramString)
  {
    AppMethodBeat.i(53124);
    if (useSelfClassloader())
    {
      paramString = getResourceAsStream(paramString);
      AppMethodBeat.o(53124);
      return paramString;
    }
    paramString = this.mClassLoader.getResourceAsStream(paramString);
    AppMethodBeat.o(53124);
    return paramString;
  }
  
  public Enumeration<URL> getResources(String paramString)
  {
    AppMethodBeat.i(53125);
    if (useSelfClassloader())
    {
      paramString = super.getResources(paramString);
      AppMethodBeat.o(53125);
      return paramString;
    }
    paramString = this.mClassLoader.getResources(paramString);
    AppMethodBeat.o(53125);
    return paramString;
  }
  
  public Class<?> loadClass(String paramString)
  {
    AppMethodBeat.i(53127);
    if (useSelfClassloader())
    {
      paramString = super.loadClass(paramString);
      AppMethodBeat.o(53127);
      return paramString;
    }
    paramString = this.mClassLoader.loadClass(paramString);
    AppMethodBeat.o(53127);
    return paramString;
  }
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(53126);
    if (useSelfClassloader())
    {
      paramString = super.loadClass(paramString, paramBoolean);
      AppMethodBeat.o(53126);
      return paramString;
    }
    paramString = this.mClassLoader.loadClass(paramString, paramBoolean);
    AppMethodBeat.o(53126);
    return paramString;
  }
  
  public void setClassAssertionStatus(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(53128);
    if (useSelfClassloader())
    {
      super.setClassAssertionStatus(paramString, paramBoolean);
      AppMethodBeat.o(53128);
      return;
    }
    this.mClassLoader.setClassAssertionStatus(paramString, paramBoolean);
    AppMethodBeat.o(53128);
  }
  
  void setClassLoader(SpeedyDexClassLoader paramSpeedyDexClassLoader)
  {
    this.mClassLoader = paramSpeedyDexClassLoader;
  }
  
  public void setDefaultAssertionStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(53129);
    if (useSelfClassloader())
    {
      super.setDefaultAssertionStatus(paramBoolean);
      AppMethodBeat.o(53129);
      return;
    }
    this.mClassLoader.setDefaultAssertionStatus(paramBoolean);
    AppMethodBeat.o(53129);
  }
  
  public void setPackageAssertionStatus(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(53130);
    if (useSelfClassloader())
    {
      super.setPackageAssertionStatus(paramString, paramBoolean);
      AppMethodBeat.o(53130);
      return;
    }
    this.mClassLoader.setPackageAssertionStatus(paramString, paramBoolean);
    AppMethodBeat.o(53130);
  }
  
  public String toString()
  {
    AppMethodBeat.i(53119);
    if (useSelfClassloader())
    {
      str = super.toString();
      AppMethodBeat.o(53119);
      return str;
    }
    String str = this.mClassLoader.toString();
    AppMethodBeat.o(53119);
    return str;
  }
  
  static class SpeedyDexClassLoader
    extends BaseDexClassLoader
  {
    public SpeedyDexClassLoader(String paramString1, File paramFile, String paramString2, ClassLoader paramClassLoader)
    {
      super(null, paramString2, paramClassLoader);
    }
    
    public Package definePackage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, URL paramURL)
    {
      AppMethodBeat.i(53106);
      paramString1 = super.definePackage(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramURL);
      AppMethodBeat.o(53106);
      return paramString1;
    }
    
    public Class<?> findClass(String paramString)
    {
      AppMethodBeat.i(53102);
      paramString = super.findClass(paramString);
      AppMethodBeat.o(53102);
      return paramString;
    }
    
    public URL findResource(String paramString)
    {
      AppMethodBeat.i(53103);
      paramString = super.findResource(paramString);
      AppMethodBeat.o(53103);
      return paramString;
    }
    
    public Enumeration<URL> findResources(String paramString)
    {
      AppMethodBeat.i(53104);
      paramString = super.findResources(paramString);
      AppMethodBeat.o(53104);
      return paramString;
    }
    
    public Package getPackage(String paramString)
    {
      try
      {
        AppMethodBeat.i(53105);
        paramString = super.getPackage(paramString);
        AppMethodBeat.o(53105);
        return paramString;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    public Package[] getPackages()
    {
      AppMethodBeat.i(53107);
      Package[] arrayOfPackage = super.getPackages();
      AppMethodBeat.o(53107);
      return arrayOfPackage;
    }
    
    public Class<?> loadClass(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(53108);
      paramString = super.loadClass(paramString, paramBoolean);
      AppMethodBeat.o(53108);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexClassLoaderProvider
 * JD-Core Version:    0.7.0.1
 */