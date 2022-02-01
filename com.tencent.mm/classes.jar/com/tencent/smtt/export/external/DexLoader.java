package com.tencent.smtt.export.external;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import dalvik.system.VMStack;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;

public class DexLoader
{
  private static final String JAVACORE_PACKAGE_PREFIX = "org.chromium";
  private static final String TAF_PACKAGE_PREFIX = "com.taf";
  private static final String TAG = "DexLoader";
  private static final String TBS_FUSION_DEX = "tbs_jars_fusion_dex";
  private static final String TBS_WEBVIEW_DEX = "webview_dex";
  private static final String TENCENT_PACKAGE_PREFIX = "com.tencent";
  static boolean mCanUseDexLoaderProviderService = true;
  private static boolean mMttClassUseCorePrivate = false;
  private static boolean mUseSpeedyClassLoader;
  private static boolean mUseTbsCorePrivateClassLoader = false;
  private DexClassLoader mClassLoader;
  
  static
  {
    mUseSpeedyClassLoader = false;
  }
  
  public DexLoader(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, new String[] { paramString1 }, paramString2);
    AppMethodBeat.i(53141);
    AppMethodBeat.o(53141);
  }
  
  public DexLoader(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    this(null, paramContext, paramArrayOfString, paramString);
  }
  
  public DexLoader(Context paramContext, String[] paramArrayOfString, String paramString, DexLoader paramDexLoader)
  {
    AppMethodBeat.i(53140);
    paramDexLoader = paramDexLoader.getClassLoader();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      paramDexLoader = createDexClassLoader(paramArrayOfString[i], paramString, paramContext.getApplicationInfo().nativeLibraryDir, paramDexLoader, paramContext);
      this.mClassLoader = paramDexLoader;
      i += 1;
    }
    AppMethodBeat.o(53140);
  }
  
  public DexLoader(Context paramContext, String[] paramArrayOfString, String paramString1, String paramString2)
  {
    AppMethodBeat.i(53139);
    ClassLoader localClassLoader = paramContext.getClassLoader();
    String str2 = paramContext.getApplicationInfo().nativeLibraryDir;
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString2)) {
      str1 = str2 + File.pathSeparator + paramString2;
    }
    int i = 0;
    paramString2 = localClassLoader;
    while (i < paramArrayOfString.length)
    {
      paramString2 = createDexClassLoader(paramArrayOfString[i], paramString1, str1, paramString2, paramContext);
      this.mClassLoader = paramString2;
      i += 1;
    }
    AppMethodBeat.o(53139);
  }
  
  public DexLoader(String paramString1, Context paramContext, String[] paramArrayOfString, String paramString2)
  {
    this(paramString1, paramContext, paramArrayOfString, paramString2, null);
  }
  
  public DexLoader(String paramString1, Context paramContext, String[] paramArrayOfString, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(53138);
    initTbsSettings(paramMap);
    Object localObject = VMStack.getCallingClassLoader();
    paramMap = (Map<String, Object>)localObject;
    if (localObject == null) {
      paramMap = paramContext.getClassLoader();
    }
    new StringBuilder("Set base classLoader for DexClassLoader: ").append(paramMap);
    localObject = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      localObject = paramContext.getApplicationInfo().nativeLibraryDir;
    }
    if (!TextUtils.isEmpty("")) {}
    for (paramString1 = (String)localObject + File.pathSeparator + "";; paramString1 = (String)localObject)
    {
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        paramMap = createDexClassLoader(paramArrayOfString[i], paramString2, paramString1, paramMap, paramContext);
        this.mClassLoader = paramMap;
        i += 1;
      }
      AppMethodBeat.o(53138);
      return;
    }
  }
  
  private DexClassLoader createDexClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, Context paramContext)
  {
    AppMethodBeat.i(53142);
    if (shouldUseTbsCorePrivateClassLoader(paramString1)) {
      paramString1 = new TbsCorePrivateClassLoader(paramString1, paramString2, paramString3, paramClassLoader);
    }
    for (;;)
    {
      new StringBuilder("createDexClassLoader result: ").append(paramString1);
      AppMethodBeat.o(53142);
      return paramString1;
      if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT <= 25) && (mUseSpeedyClassLoader)) {
        try
        {
          paramContext = DexClassLoaderProvider.createDexClassLoader(paramString1, paramString2, paramString3, paramClassLoader, paramContext);
          paramString1 = paramContext;
        }
        catch (Throwable paramContext)
        {
          new StringBuilder("createDexClassLoader exception: ").append(paramContext);
          paramString1 = new DexClassLoader(paramString1, paramString2, paramString3, paramClassLoader);
        }
      } else {
        paramString1 = new DexClassLoader(paramString1, paramString2, paramString3, paramClassLoader);
      }
    }
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(53136);
    new StringBuilder("initTbsSettings - ").append(paramMap);
    if (paramMap != null) {
      try
      {
        Object localObject = paramMap.get("use_private_classloader");
        if ((localObject instanceof Boolean)) {
          mUseTbsCorePrivateClassLoader = ((Boolean)localObject).booleanValue();
        }
        localObject = paramMap.get("use_speedy_classloader");
        if ((localObject instanceof Boolean)) {
          mUseSpeedyClassLoader = ((Boolean)localObject).booleanValue();
        }
        localObject = paramMap.get("use_dexloader_service");
        if ((localObject instanceof Boolean)) {
          mCanUseDexLoaderProviderService = ((Boolean)localObject).booleanValue();
        }
        paramMap = paramMap.get("use_mtt_classes");
        if ((paramMap instanceof Boolean)) {
          mMttClassUseCorePrivate = ((Boolean)paramMap).booleanValue();
        }
        AppMethodBeat.o(53136);
        return;
      }
      catch (Throwable paramMap) {}
    }
    AppMethodBeat.o(53136);
  }
  
  private boolean shouldUseTbsCorePrivateClassLoader(String paramString)
  {
    AppMethodBeat.i(53137);
    if (!mUseTbsCorePrivateClassLoader)
    {
      AppMethodBeat.o(53137);
      return false;
    }
    if ((paramString.contains("tbs_jars_fusion_dex")) || (paramString.contains("webview_dex")))
    {
      AppMethodBeat.o(53137);
      return true;
    }
    AppMethodBeat.o(53137);
    return false;
  }
  
  public DexClassLoader getClassLoader()
  {
    return this.mClassLoader;
  }
  
  public Object getStaticField(String paramString1, String paramString2)
  {
    AppMethodBeat.i(53148);
    try
    {
      Object localObject = this.mClassLoader.loadClass(paramString1).getField(paramString2);
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      AppMethodBeat.o(53148);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      getClass().getSimpleName();
      new StringBuilder("'").append(paramString1).append("' get field '").append(paramString2).append("' failed");
      AppMethodBeat.o(53148);
    }
    return null;
  }
  
  public Object invokeMethod(Object paramObject, String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(53147);
    try
    {
      paramArrayOfClass = this.mClassLoader.loadClass(paramString1).getMethod(paramString2, paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramObject = paramArrayOfClass.invoke(paramObject, paramVarArgs);
      AppMethodBeat.o(53147);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      getClass().getSimpleName();
      new StringBuilder("'").append(paramString1).append("' invoke method '").append(paramString2).append("' failed");
      AppMethodBeat.o(53147);
    }
    return null;
  }
  
  public Object invokeStaticMethod(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(53146);
    try
    {
      paramArrayOfClass = this.mClassLoader.loadClass(paramString1).getMethod(paramString2, paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramArrayOfClass = paramArrayOfClass.invoke(null, paramVarArgs);
      AppMethodBeat.o(53146);
      return paramArrayOfClass;
    }
    catch (Throwable paramArrayOfClass)
    {
      if ((paramString2 != null) && (paramString2.equalsIgnoreCase("initTesRuntimeEnvironment")))
      {
        getClass().getSimpleName();
        new StringBuilder("'").append(paramString1).append("' invoke static method '").append(paramString2).append("' failed");
        AppMethodBeat.o(53146);
        return paramArrayOfClass;
      }
      getClass().getSimpleName();
      new StringBuilder("'").append(paramString1).append("' invoke static method '").append(paramString2).append("' failed");
      AppMethodBeat.o(53146);
    }
    return null;
  }
  
  public Class<?> loadClass(String paramString)
  {
    AppMethodBeat.i(53145);
    try
    {
      Class localClass = this.mClassLoader.loadClass(paramString);
      AppMethodBeat.o(53145);
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      getClass().getSimpleName();
      new StringBuilder("loadClass '").append(paramString).append("' failed");
      AppMethodBeat.o(53145);
    }
    return null;
  }
  
  public Object newInstance(String paramString)
  {
    AppMethodBeat.i(53143);
    try
    {
      Object localObject = this.mClassLoader.loadClass(paramString).newInstance();
      AppMethodBeat.o(53143);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      getClass().getSimpleName();
      new StringBuilder("create ").append(paramString).append(" instance failed");
      AppMethodBeat.o(53143);
    }
    return null;
  }
  
  public Object newInstance(String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(53144);
    try
    {
      paramArrayOfClass = this.mClassLoader.loadClass(paramString).getConstructor(paramArrayOfClass).newInstance(paramVarArgs);
      AppMethodBeat.o(53144);
      return paramArrayOfClass;
    }
    catch (Throwable paramArrayOfClass)
    {
      if ("com.tencent.tbs.core.webkit.adapter.X5WebViewAdapter".equalsIgnoreCase(paramString))
      {
        getClass().getSimpleName();
        new StringBuilder("'newInstance ").append(paramString).append(" failed");
        AppMethodBeat.o(53144);
        return paramArrayOfClass;
      }
      getClass().getSimpleName();
      new StringBuilder("create '").append(paramString).append("' instance failed");
      AppMethodBeat.o(53144);
    }
    return null;
  }
  
  public void setStaticField(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(53149);
    try
    {
      Field localField = this.mClassLoader.loadClass(paramString1).getField(paramString2);
      localField.setAccessible(true);
      localField.set(null, paramObject);
      AppMethodBeat.o(53149);
      return;
    }
    catch (Throwable paramObject)
    {
      getClass().getSimpleName();
      new StringBuilder("'").append(paramString1).append("' set field '").append(paramString2).append("' failed");
      AppMethodBeat.o(53149);
    }
  }
  
  static class TbsCorePrivateClassLoader
    extends DexClassLoader
  {
    public TbsCorePrivateClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
    {
      super(paramString2, paramString3, paramClassLoader);
    }
    
    protected Class<?> loadClass(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(53135);
      label69:
      Object localObject2;
      if (paramString != null)
      {
        boolean bool2 = paramString.startsWith("org.chromium");
        boolean bool1 = bool2;
        if (DexLoader.mMttClassUseCorePrivate) {
          if ((!bool2) && (!paramString.startsWith("com.tencent")) && (!paramString.startsWith("com.taf"))) {
            break label69;
          }
        }
        for (bool1 = true; !bool1; bool1 = false)
        {
          paramString = super.loadClass(paramString, paramBoolean);
          AppMethodBeat.o(53135);
          return paramString;
        }
        localObject2 = findLoadedClass(paramString);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      try
      {
        new StringBuilder("WebCoreClassLoader - loadClass(").append(paramString).append(",").append(paramBoolean).append(")...");
        localObject1 = findClass(paramString);
        localObject2 = localObject1;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        label129:
        ClassLoader localClassLoader;
        break label129;
      }
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localClassLoader = getParent();
        localObject1 = localObject2;
        if (localClassLoader != null) {
          localObject1 = localClassLoader.loadClass(paramString);
        }
      }
      AppMethodBeat.o(53135);
      return localObject1;
      paramString = super.loadClass(paramString, paramBoolean);
      AppMethodBeat.o(53135);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexLoader
 * JD-Core Version:    0.7.0.1
 */