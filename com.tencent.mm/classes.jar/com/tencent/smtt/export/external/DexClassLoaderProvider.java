package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Context;
import android.os.Build.VERSION;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Timer;

public class DexClassLoaderProvider
  extends DexClassLoader
{
  private static final String IS_FIRST_LOAD_DEX_FLAG_FILE = "is_first_load_dex_flag_file";
  private static final String LAST_DEX_NAME = "tbs_jars_fusion_dex.jar";
  private static final long LOAD_DEX_DELAY = 3000L;
  private static final String LOGTAG = "dexloader";
  protected static DexClassLoader mClassLoaderOriginal = null;
  private static Context mContext = null;
  private static boolean mForceLoadDexFlag;
  private static DexClassLoaderProvider mInstance = null;
  private static String mRealDexPath = null;
  protected static Service mService;
  private DexClassLoaderProvider.SpeedyDexClassLoader mClassLoader = null;
  
  static
  {
    mForceLoadDexFlag = false;
    mService = null;
  }
  
  private DexClassLoaderProvider(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
    if (paramBoolean)
    {
      new StringBuilder("SpeedyDexClassLoader: ").append(mRealDexPath);
      this.mClassLoader = new DexClassLoaderProvider.SpeedyDexClassLoader(mRealDexPath, null, paramString3, paramClassLoader);
      return;
    }
    new StringBuilder("DexClassLoader: ").append(mRealDexPath);
    this.mClassLoader = null;
  }
  
  public static DexClassLoader createDexClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, Context paramContext)
  {
    mContext = paramContext.getApplicationContext();
    mRealDexPath = paramString1;
    int i = paramString1.lastIndexOf("/");
    paramContext = paramString1.substring(0, i + 1);
    paramContext = paramContext + "fake_dex.jar";
    String str = paramString1.substring(i + 1);
    if ((supportSpeedyClassLoader()) && (is_first_load_tbs_dex(paramString2, str)))
    {
      set_first_load_tbs_dex(paramString2, str);
      mInstance = new DexClassLoaderProvider(paramContext, paramString2, paramString3, paramClassLoader, true);
      doAsyncDexLoad(str, paramString1, paramString2, paramString3, paramClassLoader);
    }
    for (;;)
    {
      return mInstance;
      mInstance = new DexClassLoaderProvider(paramString1, paramString2, paramString3, paramClassLoader, false);
    }
  }
  
  private static void doAsyncDexLoad(String paramString1, String paramString2, String paramString3, String paramString4, ClassLoader paramClassLoader)
  {
    if (shouldUseDexLoaderService())
    {
      new Timer().schedule(new DexClassLoaderProvider.1(paramString1, paramString2, paramString3, paramString4), 3000L);
      return;
    }
    new Timer().schedule(new DexClassLoaderProvider.2(paramString2, paramString3, paramString4, paramClassLoader, paramString1), 3000L);
  }
  
  private static boolean is_first_load_tbs_dex(String paramString1, String paramString2)
  {
    if (mForceLoadDexFlag) {}
    while (!new File(paramString1, paramString2 + "_is_first_load_dex_flag_file").exists()) {
      return true;
    }
    return false;
  }
  
  static void setForceLoadDexFlag(boolean paramBoolean, Service paramService)
  {
    mForceLoadDexFlag = paramBoolean;
    mService = paramService;
  }
  
  private static void set_first_load_tbs_dex(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1, paramString2 + "_is_first_load_dex_flag_file");
    if (!paramString1.exists()) {}
    try
    {
      paramString1.createNewFile();
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  private static boolean shouldUseDexLoaderService()
  {
    if (mForceLoadDexFlag) {}
    while (!DexLoader.mCanUseDexLoaderProviderService) {
      return false;
    }
    return true;
  }
  
  private static boolean supportSpeedyClassLoader()
  {
    return (Build.VERSION.SDK_INT != 21) || (DexLoader.mCanUseDexLoaderProviderService);
  }
  
  private boolean useSelfClassloader()
  {
    return this.mClassLoader == null;
  }
  
  public void clearAssertionStatus()
  {
    if (useSelfClassloader())
    {
      super.clearAssertionStatus();
      return;
    }
    this.mClassLoader.clearAssertionStatus();
  }
  
  protected Package definePackage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, URL paramURL)
  {
    if (useSelfClassloader()) {
      return super.definePackage(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramURL);
    }
    return this.mClassLoader.definePackage(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramURL);
  }
  
  protected Class<?> findClass(String paramString)
  {
    if (useSelfClassloader()) {
      return super.findClass(paramString);
    }
    return this.mClassLoader.findClass(paramString);
  }
  
  public String findLibrary(String paramString)
  {
    if (useSelfClassloader()) {
      return super.findLibrary(paramString);
    }
    return this.mClassLoader.findLibrary(paramString);
  }
  
  protected URL findResource(String paramString)
  {
    if (useSelfClassloader()) {
      return super.findResource(paramString);
    }
    return this.mClassLoader.findResource(paramString);
  }
  
  protected Enumeration<URL> findResources(String paramString)
  {
    if (useSelfClassloader()) {
      return super.findResources(paramString);
    }
    return this.mClassLoader.findResources(paramString);
  }
  
  /* Error */
  protected Package getPackage(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 173	com/tencent/smtt/export/external/DexClassLoaderProvider:useSelfClassloader	()Z
    //   6: ifeq +13 -> 19
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 208	dalvik/system/DexClassLoader:getPackage	(Ljava/lang/String;)Ljava/lang/Package;
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: aload_0
    //   20: getfield 55	com/tencent/smtt/export/external/DexClassLoaderProvider:mClassLoader	Lcom/tencent/smtt/export/external/DexClassLoaderProvider$SpeedyDexClassLoader;
    //   23: aload_1
    //   24: invokevirtual 209	com/tencent/smtt/export/external/DexClassLoaderProvider$SpeedyDexClassLoader:getPackage	(Ljava/lang/String;)Ljava/lang/Package;
    //   27: astore_1
    //   28: goto -13 -> 15
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	DexClassLoaderProvider
    //   0	36	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	15	31	finally
    //   19	28	31	finally
  }
  
  protected Package[] getPackages()
  {
    if (useSelfClassloader()) {
      return super.getPackages();
    }
    return this.mClassLoader.getPackages();
  }
  
  public URL getResource(String paramString)
  {
    if (useSelfClassloader()) {
      return super.getResource(paramString);
    }
    return this.mClassLoader.getResource(paramString);
  }
  
  public InputStream getResourceAsStream(String paramString)
  {
    if (useSelfClassloader()) {
      return getResourceAsStream(paramString);
    }
    return this.mClassLoader.getResourceAsStream(paramString);
  }
  
  public Enumeration<URL> getResources(String paramString)
  {
    if (useSelfClassloader()) {
      return super.getResources(paramString);
    }
    return this.mClassLoader.getResources(paramString);
  }
  
  public Class<?> loadClass(String paramString)
  {
    if (useSelfClassloader()) {
      return super.loadClass(paramString);
    }
    return this.mClassLoader.loadClass(paramString);
  }
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    if (useSelfClassloader()) {
      return super.loadClass(paramString, paramBoolean);
    }
    return this.mClassLoader.loadClass(paramString, paramBoolean);
  }
  
  public void setClassAssertionStatus(String paramString, boolean paramBoolean)
  {
    if (useSelfClassloader())
    {
      super.setClassAssertionStatus(paramString, paramBoolean);
      return;
    }
    this.mClassLoader.setClassAssertionStatus(paramString, paramBoolean);
  }
  
  public void setDefaultAssertionStatus(boolean paramBoolean)
  {
    if (useSelfClassloader())
    {
      super.setDefaultAssertionStatus(paramBoolean);
      return;
    }
    this.mClassLoader.setDefaultAssertionStatus(paramBoolean);
  }
  
  public void setPackageAssertionStatus(String paramString, boolean paramBoolean)
  {
    if (useSelfClassloader())
    {
      super.setPackageAssertionStatus(paramString, paramBoolean);
      return;
    }
    this.mClassLoader.setPackageAssertionStatus(paramString, paramBoolean);
  }
  
  public String toString()
  {
    if (useSelfClassloader()) {
      return super.toString();
    }
    return this.mClassLoader.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexClassLoaderProvider
 * JD-Core Version:    0.7.0.1
 */