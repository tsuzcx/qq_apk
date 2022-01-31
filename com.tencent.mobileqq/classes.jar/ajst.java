import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Application;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.commonsdk.classload.DexClassLoaderUtil;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ajst
{
  public static Object a(Object paramObject)
  {
    return a(paramObject, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
  }
  
  private static Object a(Object paramObject, int paramInt)
  {
    Object localObject = paramObject.getClass().getComponentType();
    int m = Array.getLength(paramObject);
    if ((paramInt < 0) || (paramInt >= m)) {
      return paramObject;
    }
    localObject = Array.newInstance((Class)localObject, m - 1);
    int j = 0;
    int i = 0;
    if (j < m)
    {
      if (j == paramInt) {
        break label82;
      }
      int k = i + 1;
      Array.set(localObject, i, Array.get(paramObject, j));
      i = k;
    }
    label82:
    for (;;)
    {
      j += 1;
      break;
      return localObject;
    }
  }
  
  private static Object a(Object paramObject, Class<?> paramClass, String paramString)
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    return paramClass.get(paramObject);
  }
  
  private static Object a(Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    Object localObject1 = paramObject1.getClass().getComponentType();
    int j = Array.getLength(paramObject1);
    int k = Array.getLength(paramObject2);
    int i;
    label32:
    Object localObject2;
    if (paramBoolean)
    {
      i = j;
      if (!paramBoolean) {
        break label99;
      }
      k = i + k;
      localObject2 = Array.newInstance((Class)localObject1, k);
      j = 0;
      label50:
      if (j >= k) {
        break label144;
      }
      if (j >= i) {
        break label112;
      }
      if (!paramBoolean) {
        break label106;
      }
    }
    label99:
    label106:
    for (localObject1 = paramObject1;; localObject1 = paramObject2)
    {
      Array.set(localObject2, j, Array.get(localObject1, j));
      j += 1;
      break label50;
      i = k;
      break;
      k = j;
      break label32;
    }
    label112:
    if (paramBoolean) {}
    for (localObject1 = paramObject2;; localObject1 = paramObject1)
    {
      Array.set(localObject2, j, Array.get(localObject1, j - i));
      break;
    }
    label144:
    return localObject2;
  }
  
  public static String a(Application paramApplication, int paramInt)
  {
    try
    {
      Class.forName("dalvik.system.LexClassLoader");
      String str = b(paramApplication, paramInt);
      return str;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      int i = 1;
      try
      {
        Class.forName("dalvik.system.BaseDexClassLoader");
        if (i == 0) {
          return c(paramApplication, paramInt);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        for (;;)
        {
          i = 0;
        }
      }
    }
    return d(paramApplication, paramInt);
  }
  
  public static String a(Application paramApplication, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      Class.forName("dalvik.system.LexClassLoader");
      String str = b(paramApplication, paramString1, paramString2, paramBoolean);
      return str;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      int i = 1;
      try
      {
        Class.forName("dalvik.system.BaseDexClassLoader");
        if (i == 0) {
          return c(paramApplication, paramString1, paramString2, paramBoolean);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        for (;;)
        {
          i = 0;
        }
      }
    }
    return d(paramApplication, paramString1, paramString2, paramBoolean);
  }
  
  private static void a(Object paramObject1, Class<?> paramClass, String paramString, Object paramObject2)
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    paramClass.set(paramObject1, paramObject2);
  }
  
  public static Object b(Object paramObject)
  {
    return a(paramObject, paramObject.getClass(), "dexElements");
  }
  
  private static Object b(Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    int k = 1;
    Object localObject1 = paramObject1.getClass().getComponentType();
    int j = Array.getLength(paramObject1);
    int i;
    label33:
    Object localObject2;
    if (paramBoolean)
    {
      i = j;
      if (!paramBoolean) {
        break label99;
      }
      j = k;
      k = i + j;
      localObject2 = Array.newInstance((Class)localObject1, k);
      j = 0;
      label51:
      if (j >= k) {
        break label140;
      }
      if (j >= i) {
        break label108;
      }
      if (!paramBoolean) {
        break label102;
      }
    }
    label99:
    label102:
    for (localObject1 = Array.get(paramObject1, j);; localObject1 = paramObject2)
    {
      Array.set(localObject2, j, localObject1);
      j += 1;
      break label51;
      i = 1;
      break;
      break label33;
    }
    label108:
    if (paramBoolean) {}
    for (localObject1 = paramObject2;; localObject1 = Array.get(paramObject1, j - i))
    {
      Array.set(localObject2, j, localObject1);
      break;
    }
    label140:
    return localObject2;
  }
  
  private static String b(Application paramApplication, int paramInt)
  {
    paramApplication = (PathClassLoader)paramApplication.getClassLoader();
    try
    {
      a(paramApplication, PathClassLoader.class, "mPaths", a(a(paramApplication, PathClassLoader.class, "mPaths"), paramInt));
      a(paramApplication, PathClassLoader.class, "mFiles", a(a(paramApplication, PathClassLoader.class, "mFiles"), paramInt));
      a(paramApplication, PathClassLoader.class, "mZips", a(a(paramApplication, PathClassLoader.class, "mZips"), paramInt));
      a(paramApplication, PathClassLoader.class, "mLexs", a(a(paramApplication, PathClassLoader.class, "mLexs"), paramInt));
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      paramApplication.printStackTrace();
    }
    return "unloadDexInAliyunOs error: " + Log.getStackTraceString(paramApplication);
  }
  
  private static String b(Application paramApplication, String paramString1, String paramString2, boolean paramBoolean)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramApplication.getClassLoader();
    new DexClassLoader(paramString1, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, localPathClassLoader);
    String str = new File(paramString1).getName().replaceAll("\\.[a-zA-Z0-9]+", ".lex");
    try
    {
      Class localClass = Class.forName("dalvik.system.LexClassLoader");
      paramApplication = localClass.getConstructor(new Class[] { String.class, String.class, String.class, ClassLoader.class }).newInstance(new Object[] { paramApplication.getDir("dex", 0).getAbsolutePath() + File.separator + str, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, localPathClassLoader });
      paramString1 = localClass.getMethod("loadClass", new Class[] { String.class });
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1.invoke(paramApplication, new Object[] { paramString2 });
      }
      a(localPathClassLoader, PathClassLoader.class, "mPaths", b(a(localPathClassLoader, PathClassLoader.class, "mPaths"), a(paramApplication, localClass, "mRawDexPath"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mFiles", a(a(localPathClassLoader, PathClassLoader.class, "mFiles"), a(paramApplication, localClass, "mFiles"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mZips", a(a(localPathClassLoader, PathClassLoader.class, "mZips"), a(paramApplication, localClass, "mZips"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mLexs", a(a(localPathClassLoader, PathClassLoader.class, "mLexs"), a(paramApplication, localClass, "mDexs"), paramBoolean));
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      paramApplication.printStackTrace();
    }
    return "injectInAliyunOs error: " + Log.getStackTraceString(paramApplication);
  }
  
  @TargetApi(14)
  private static String c(Application paramApplication, int paramInt)
  {
    paramApplication = (PathClassLoader)paramApplication.getClassLoader();
    try
    {
      a(paramApplication, PathClassLoader.class, "mPaths", a(a(paramApplication, PathClassLoader.class, "mPaths"), paramInt));
      a(paramApplication, PathClassLoader.class, "mFiles", a(a(paramApplication, PathClassLoader.class, "mFiles"), paramInt));
      a(paramApplication, PathClassLoader.class, "mZips", a(a(paramApplication, PathClassLoader.class, "mZips"), paramInt));
      a(paramApplication, PathClassLoader.class, "mDexs", a(a(paramApplication, PathClassLoader.class, "mDexs"), paramInt));
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      paramApplication.printStackTrace();
    }
    return "unloadDexBelowApiLevel14 error: " + Log.getStackTraceString(paramApplication);
  }
  
  @TargetApi(14)
  private static String c(Application paramApplication, String paramString1, String paramString2, boolean paramBoolean)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramApplication.getClassLoader();
    paramApplication = DexClassLoaderUtil.createDexClassLoader(paramString1, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, paramApplication.getClassLoader());
    try
    {
      if (Build.VERSION.SDK_INT <= 8)
      {
        paramString1 = paramApplication.getClass().getDeclaredMethod("ensureInit", new Class[0]);
        paramString1.setAccessible(true);
        paramString1.invoke(paramApplication, new Object[0]);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        paramApplication.loadClass(paramString2);
      }
      a(localPathClassLoader, PathClassLoader.class, "mPaths", b(a(localPathClassLoader, PathClassLoader.class, "mPaths"), a(paramApplication, DexClassLoader.class, "mRawDexPath"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mFiles", a(a(localPathClassLoader, PathClassLoader.class, "mFiles"), a(paramApplication, DexClassLoader.class, "mFiles"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mZips", a(a(localPathClassLoader, PathClassLoader.class, "mZips"), a(paramApplication, DexClassLoader.class, "mZips"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mDexs", a(a(localPathClassLoader, PathClassLoader.class, "mDexs"), a(paramApplication, DexClassLoader.class, "mDexs"), paramBoolean));
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      paramApplication.printStackTrace();
    }
    return "injectBelowApiLevel14 error: " + Log.getStackTraceString(paramApplication);
  }
  
  @SuppressLint({"NewApi"})
  private static String d(Application paramApplication, int paramInt)
  {
    Object localObject = (PathClassLoader)paramApplication.getClassLoader();
    try
    {
      paramApplication = a(b(a(localObject)), paramInt);
      localObject = a(localObject);
      a(localObject, localObject.getClass(), "dexElements", paramApplication);
      return "Success";
    }
    catch (Throwable paramApplication) {}
    return "unloadDexAboveEqualApiLevel14 error: " + Log.getStackTraceString(paramApplication);
  }
  
  @SuppressLint({"NewApi"})
  private static String d(Application paramApplication, String paramString1, String paramString2, boolean paramBoolean)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramApplication.getClassLoader();
    paramApplication = DexClassLoaderUtil.createDexClassLoader(paramString1, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, paramApplication.getClassLoader());
    try
    {
      if (!TextUtils.isEmpty(paramString2)) {
        paramApplication.loadClass(paramString2);
      }
      paramApplication = a(b(a(localPathClassLoader)), b(a(paramApplication)), paramBoolean);
      paramString1 = a(localPathClassLoader);
      a(paramString1, paramString1.getClass(), "dexElements", paramApplication);
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      QLog.e("harlan", 1, "err", paramApplication);
    }
    return "injectAboveEqualApiLevel14 error: " + Log.getStackTraceString(paramApplication);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajst
 * JD-Core Version:    0.7.0.1
 */