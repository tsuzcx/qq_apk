package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.BaseDexClassLoader;
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
  private SpeedyDexClassLoader mClassLoader;
  
  static
  {
    mForceLoadDexFlag = false;
    mService = null;
  }
  
  private DexClassLoaderProvider(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
    AppMethodBeat.i(63730);
    this.mClassLoader = null;
    if (paramBoolean)
    {
      new StringBuilder("SpeedyDexClassLoader: ").append(mRealDexPath);
      this.mClassLoader = new SpeedyDexClassLoader(mRealDexPath, null, paramString3, paramClassLoader);
      AppMethodBeat.o(63730);
      return;
    }
    new StringBuilder("DexClassLoader: ").append(mRealDexPath);
    this.mClassLoader = null;
    AppMethodBeat.o(63730);
  }
  
  public static DexClassLoader createDexClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, Context paramContext)
  {
    AppMethodBeat.i(63731);
    new StringBuilder("new DexClassLoaderDelegate: ").append(paramString1).append(", context: ").append(paramContext);
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
      paramString1 = mInstance;
      AppMethodBeat.o(63731);
      return paramString1;
      mInstance = new DexClassLoaderProvider(paramString1, paramString2, paramString3, paramClassLoader, false);
    }
  }
  
  private static void doAsyncDexLoad(String paramString1, String paramString2, String paramString3, String paramString4, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(63732);
    if (shouldUseDexLoaderService())
    {
      new Timer().schedule(new DexClassLoaderProvider.1(paramString1, paramString2, paramString3, paramString4), 3000L);
      AppMethodBeat.o(63732);
      return;
    }
    new StringBuilder("Background real dex loading(").append(paramString1).append(")");
    new Timer().schedule(new DexClassLoaderProvider.2(paramString2, paramString3, paramString4, paramClassLoader, paramString1), 3000L);
    AppMethodBeat.o(63732);
  }
  
  private static boolean is_first_load_tbs_dex(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63733);
    if (mForceLoadDexFlag)
    {
      AppMethodBeat.o(63733);
      return true;
    }
    if (!new File(paramString1, paramString2 + "_is_first_load_dex_flag_file").exists())
    {
      AppMethodBeat.o(63733);
      return true;
    }
    AppMethodBeat.o(63733);
    return false;
  }
  
  static void setForceLoadDexFlag(boolean paramBoolean, Service paramService)
  {
    mForceLoadDexFlag = paramBoolean;
    mService = paramService;
  }
  
  private static void set_first_load_tbs_dex(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63734);
    paramString1 = new File(paramString1, paramString2 + "_is_first_load_dex_flag_file");
    if (!paramString1.exists()) {
      try
      {
        paramString1.createNewFile();
        AppMethodBeat.o(63734);
        return;
      }
      catch (Throwable paramString1) {}
    }
    AppMethodBeat.o(63734);
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
    AppMethodBeat.i(63741);
    if (useSelfClassloader())
    {
      super.clearAssertionStatus();
      AppMethodBeat.o(63741);
      return;
    }
    this.mClassLoader.clearAssertionStatus();
    AppMethodBeat.o(63741);
  }
  
  protected Package definePackage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, URL paramURL)
  {
    AppMethodBeat.i(63742);
    if (useSelfClassloader())
    {
      paramString1 = super.definePackage(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramURL);
      AppMethodBeat.o(63742);
      return paramString1;
    }
    paramString1 = this.mClassLoader.definePackage(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramURL);
    AppMethodBeat.o(63742);
    return paramString1;
  }
  
  protected Class<?> findClass(String paramString)
  {
    AppMethodBeat.i(63735);
    if (useSelfClassloader())
    {
      paramString = super.findClass(paramString);
      AppMethodBeat.o(63735);
      return paramString;
    }
    paramString = this.mClassLoader.findClass(paramString);
    AppMethodBeat.o(63735);
    return paramString;
  }
  
  public String findLibrary(String paramString)
  {
    AppMethodBeat.i(63736);
    if (useSelfClassloader())
    {
      paramString = super.findLibrary(paramString);
      AppMethodBeat.o(63736);
      return paramString;
    }
    paramString = this.mClassLoader.findLibrary(paramString);
    AppMethodBeat.o(63736);
    return paramString;
  }
  
  protected URL findResource(String paramString)
  {
    AppMethodBeat.i(63737);
    if (useSelfClassloader())
    {
      paramString = super.findResource(paramString);
      AppMethodBeat.o(63737);
      return paramString;
    }
    paramString = this.mClassLoader.findResource(paramString);
    AppMethodBeat.o(63737);
    return paramString;
  }
  
  protected Enumeration<URL> findResources(String paramString)
  {
    AppMethodBeat.i(63738);
    if (useSelfClassloader())
    {
      paramString = super.findResources(paramString);
      AppMethodBeat.o(63738);
      return paramString;
    }
    paramString = this.mClassLoader.findResources(paramString);
    AppMethodBeat.o(63738);
    return paramString;
  }
  
  /* Error */
  protected Package getPackage(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 239
    //   4: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 200	com/tencent/smtt/export/external/DexClassLoaderProvider:useSelfClassloader	()Z
    //   11: ifeq +18 -> 29
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 241	dalvik/system/DexClassLoader:getPackage	(Ljava/lang/String;)Ljava/lang/Package;
    //   19: astore_1
    //   20: ldc 239
    //   22: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: areturn
    //   29: aload_0
    //   30: getfield 63	com/tencent/smtt/export/external/DexClassLoaderProvider:mClassLoader	Lcom/tencent/smtt/export/external/DexClassLoaderProvider$SpeedyDexClassLoader;
    //   33: aload_1
    //   34: invokevirtual 242	com/tencent/smtt/export/external/DexClassLoaderProvider$SpeedyDexClassLoader:getPackage	(Ljava/lang/String;)Ljava/lang/Package;
    //   37: astore_1
    //   38: ldc 239
    //   40: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -18 -> 25
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	DexClassLoaderProvider
    //   0	51	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	25	46	finally
    //   29	43	46	finally
  }
  
  protected Package[] getPackages()
  {
    AppMethodBeat.i(63743);
    if (useSelfClassloader())
    {
      arrayOfPackage = super.getPackages();
      AppMethodBeat.o(63743);
      return arrayOfPackage;
    }
    Package[] arrayOfPackage = this.mClassLoader.getPackages();
    AppMethodBeat.o(63743);
    return arrayOfPackage;
  }
  
  public URL getResource(String paramString)
  {
    AppMethodBeat.i(63744);
    if (useSelfClassloader())
    {
      paramString = super.getResource(paramString);
      AppMethodBeat.o(63744);
      return paramString;
    }
    paramString = this.mClassLoader.getResource(paramString);
    AppMethodBeat.o(63744);
    return paramString;
  }
  
  public InputStream getResourceAsStream(String paramString)
  {
    AppMethodBeat.i(63745);
    if (useSelfClassloader())
    {
      paramString = getResourceAsStream(paramString);
      AppMethodBeat.o(63745);
      return paramString;
    }
    paramString = this.mClassLoader.getResourceAsStream(paramString);
    AppMethodBeat.o(63745);
    return paramString;
  }
  
  public Enumeration<URL> getResources(String paramString)
  {
    AppMethodBeat.i(63746);
    if (useSelfClassloader())
    {
      paramString = super.getResources(paramString);
      AppMethodBeat.o(63746);
      return paramString;
    }
    paramString = this.mClassLoader.getResources(paramString);
    AppMethodBeat.o(63746);
    return paramString;
  }
  
  public Class<?> loadClass(String paramString)
  {
    AppMethodBeat.i(63748);
    if (useSelfClassloader())
    {
      paramString = super.loadClass(paramString);
      AppMethodBeat.o(63748);
      return paramString;
    }
    paramString = this.mClassLoader.loadClass(paramString);
    AppMethodBeat.o(63748);
    return paramString;
  }
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63747);
    if (useSelfClassloader())
    {
      paramString = super.loadClass(paramString, paramBoolean);
      AppMethodBeat.o(63747);
      return paramString;
    }
    paramString = this.mClassLoader.loadClass(paramString, paramBoolean);
    AppMethodBeat.o(63747);
    return paramString;
  }
  
  public void setClassAssertionStatus(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63749);
    if (useSelfClassloader())
    {
      super.setClassAssertionStatus(paramString, paramBoolean);
      AppMethodBeat.o(63749);
      return;
    }
    this.mClassLoader.setClassAssertionStatus(paramString, paramBoolean);
    AppMethodBeat.o(63749);
  }
  
  public void setDefaultAssertionStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(63750);
    if (useSelfClassloader())
    {
      super.setDefaultAssertionStatus(paramBoolean);
      AppMethodBeat.o(63750);
      return;
    }
    this.mClassLoader.setDefaultAssertionStatus(paramBoolean);
    AppMethodBeat.o(63750);
  }
  
  public void setPackageAssertionStatus(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63751);
    if (useSelfClassloader())
    {
      super.setPackageAssertionStatus(paramString, paramBoolean);
      AppMethodBeat.o(63751);
      return;
    }
    this.mClassLoader.setPackageAssertionStatus(paramString, paramBoolean);
    AppMethodBeat.o(63751);
  }
  
  public String toString()
  {
    AppMethodBeat.i(63740);
    if (useSelfClassloader())
    {
      str = super.toString();
      AppMethodBeat.o(63740);
      return str;
    }
    String str = this.mClassLoader.toString();
    AppMethodBeat.o(63740);
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
      AppMethodBeat.i(63727);
      paramString1 = super.definePackage(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramURL);
      AppMethodBeat.o(63727);
      return paramString1;
    }
    
    public Class<?> findClass(String paramString)
    {
      AppMethodBeat.i(63723);
      paramString = super.findClass(paramString);
      AppMethodBeat.o(63723);
      return paramString;
    }
    
    public URL findResource(String paramString)
    {
      AppMethodBeat.i(63724);
      paramString = super.findResource(paramString);
      AppMethodBeat.o(63724);
      return paramString;
    }
    
    public Enumeration<URL> findResources(String paramString)
    {
      AppMethodBeat.i(63725);
      paramString = super.findResources(paramString);
      AppMethodBeat.o(63725);
      return paramString;
    }
    
    public Package getPackage(String paramString)
    {
      try
      {
        AppMethodBeat.i(63726);
        paramString = super.getPackage(paramString);
        AppMethodBeat.o(63726);
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
      AppMethodBeat.i(63728);
      Package[] arrayOfPackage = super.getPackages();
      AppMethodBeat.o(63728);
      return arrayOfPackage;
    }
    
    public Class<?> loadClass(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(63729);
      paramString = super.loadClass(paramString, paramBoolean);
      AppMethodBeat.o(63729);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexClassLoaderProvider
 * JD-Core Version:    0.7.0.1
 */