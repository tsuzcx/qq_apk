package com.tencent.smtt.export.external;

import android.content.Context;
import android.content.pm.ApplicationInfo;
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
  
  /* Error */
  private DexClassLoader createDexClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, Context paramContext)
  {
    // Byte code:
    //   0: ldc 144
    //   2: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 148	com/tencent/smtt/export/external/DexLoader:shouldUseTbsCorePrivateClassLoader	(Ljava/lang/String;)Z
    //   10: ifeq +37 -> 47
    //   13: new 6	com/tencent/smtt/export/external/DexLoader$TbsCorePrivateClassLoader
    //   16: dup
    //   17: aload_1
    //   18: aload_2
    //   19: aload_3
    //   20: aload 4
    //   22: invokespecial 151	com/tencent/smtt/export/external/DexLoader$TbsCorePrivateClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   25: astore_1
    //   26: new 102	java/lang/StringBuilder
    //   29: dup
    //   30: ldc 153
    //   32: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: aload_1
    //   36: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: ldc 144
    //   42: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_1
    //   46: areturn
    //   47: getstatic 159	android/os/Build$VERSION:SDK_INT	I
    //   50: bipush 21
    //   52: if_icmplt +68 -> 120
    //   55: getstatic 159	android/os/Build$VERSION:SDK_INT	I
    //   58: bipush 25
    //   60: if_icmpgt +60 -> 120
    //   63: getstatic 39	com/tencent/smtt/export/external/DexLoader:mUseSpeedyClassLoader	Z
    //   66: ifeq +54 -> 120
    //   69: aload_1
    //   70: aload_2
    //   71: aload_3
    //   72: aload 4
    //   74: aload 5
    //   76: invokestatic 162	com/tencent/smtt/export/external/DexClassLoaderProvider:createDexClassLoader	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;Landroid/content/Context;)Ldalvik/system/DexClassLoader;
    //   79: astore 5
    //   81: aload 5
    //   83: astore_1
    //   84: goto -58 -> 26
    //   87: astore 5
    //   89: new 102	java/lang/StringBuilder
    //   92: dup
    //   93: ldc 164
    //   95: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: aload 5
    //   100: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: new 166	dalvik/system/DexClassLoader
    //   107: dup
    //   108: aload_1
    //   109: aload_2
    //   110: aload_3
    //   111: aload 4
    //   113: invokespecial 167	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   116: astore_1
    //   117: goto -91 -> 26
    //   120: new 166	dalvik/system/DexClassLoader
    //   123: dup
    //   124: aload_1
    //   125: aload_2
    //   126: aload_3
    //   127: aload 4
    //   129: invokespecial 167	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   132: astore_1
    //   133: goto -107 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	DexLoader
    //   0	136	1	paramString1	String
    //   0	136	2	paramString2	String
    //   0	136	3	paramString3	String
    //   0	136	4	paramClassLoader	ClassLoader
    //   0	136	5	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   69	81	87	finally
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
      finally {}
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
      Object localObject1 = this.mClassLoader.loadClass(paramString1).getField(paramString2);
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(null);
      AppMethodBeat.o(53148);
      return localObject1;
    }
    finally
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
    finally
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
    finally
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
    finally
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
      Object localObject1 = this.mClassLoader.loadClass(paramString).newInstance();
      AppMethodBeat.o(53143);
      return localObject1;
    }
    finally
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
    finally
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
    finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexLoader
 * JD-Core Version:    0.7.0.1
 */