package com.tencent.mm.plugin.normsg.c;

import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public final class i
{
  private static final LruCache<String, LruCache<String, Field>> wKQ;
  private static final LruCache<String, LruCache<String, Method>> wKR;
  private static final LruCache<String, LruCache<String, Constructor<?>>> wKS;
  
  static
  {
    AppMethodBeat.i(149105);
    wKQ = new LruCache(50);
    wKR = new LruCache(50);
    wKS = new LruCache(50);
    AppMethodBeat.o(149105);
  }
  
  public static <T> T a(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(149101);
    paramString1 = b(findClass(paramString1), paramString2, paramArrayOfClass, paramVarArgs);
    AppMethodBeat.o(149101);
    return paramString1;
  }
  
  public static <T> T b(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(149102);
    try
    {
      paramClass = b(paramClass, paramString, paramArrayOfClass).invoke(null, paramVarArgs);
      AppMethodBeat.o(149102);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      paramClass = new a(paramClass);
      AppMethodBeat.o(149102);
      throw paramClass;
    }
  }
  
  public static <T> T b(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(149100);
    Class localClass = paramObject.getClass();
    try
    {
      paramObject = b(localClass, paramString, paramArrayOfClass).invoke(paramObject, paramVarArgs);
      AppMethodBeat.o(149100);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      paramObject = new a(paramObject);
      AppMethodBeat.o(149100);
      throw paramObject;
    }
  }
  
  private static Method b(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(149104);
    LruCache localLruCache = (LruCache)wKR.get(paramClass.getName());
    if (localLruCache == null)
    {
      localLruCache = new LruCache(30);
      wKR.put(paramClass.getName(), localLruCache);
    }
    for (;;)
    {
      Object localObject = new StringBuilder().append(paramString).append("#");
      if (paramVarArgs != null) {}
      for (String str = Arrays.toString(paramVarArgs);; str = "[]")
      {
        str = str;
        localObject = (Method)localLruCache.get(str);
        if (localObject == null) {
          break;
        }
        AppMethodBeat.o(149104);
        return localObject;
      }
      do
      {
        paramClass = paramClass.getSuperclass();
        try
        {
          localObject = paramClass.getDeclaredMethod(paramString, paramVarArgs);
          if (!((Method)localObject).isAccessible()) {
            ((Method)localObject).setAccessible(true);
          }
          localLruCache.put(str, localObject);
          AppMethodBeat.o(149104);
          return localObject;
        }
        catch (Throwable localThrowable) {}
      } while ((paramClass.getSuperclass() != null) && (paramClass != Object.class));
      AppMethodBeat.o(149104);
      throw localThrowable;
    }
  }
  
  public static Class<?>[] b(Class<?>... paramVarArgs)
  {
    return paramVarArgs;
  }
  
  private static <T> T c(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(149098);
    try
    {
      paramClass = d(paramClass, paramString).get(null);
      AppMethodBeat.o(149098);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      paramClass = new a(paramClass);
      AppMethodBeat.o(149098);
      throw paramClass;
    }
  }
  
  public static <T> void c(Object paramObject, String paramString, T paramT)
  {
    AppMethodBeat.i(149099);
    Class localClass = paramObject.getClass();
    try
    {
      d(localClass, paramString).set(paramObject, paramT);
      AppMethodBeat.o(149099);
      return;
    }
    catch (Throwable paramObject)
    {
      paramObject = new a(paramObject);
      AppMethodBeat.o(149099);
      throw paramObject;
    }
  }
  
  public static <T> T d(Object paramObject, String paramString)
  {
    AppMethodBeat.i(149096);
    Class localClass = paramObject.getClass();
    try
    {
      paramObject = d(localClass, paramString).get(paramObject);
      AppMethodBeat.o(149096);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      paramObject = new a(paramObject);
      AppMethodBeat.o(149096);
      throw paramObject;
    }
  }
  
  private static Field d(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(149103);
    LruCache localLruCache = (LruCache)wKQ.get(paramClass.getName());
    if (localLruCache == null)
    {
      localLruCache = new LruCache(30);
      wKQ.put(paramClass.getName(), localLruCache);
    }
    for (;;)
    {
      Field localField = (Field)localLruCache.get(paramString);
      if (localField != null)
      {
        AppMethodBeat.o(149103);
        return localField;
      }
      do
      {
        paramClass = paramClass.getSuperclass();
        try
        {
          localField = paramClass.getDeclaredField(paramString);
          if (!localField.isAccessible()) {
            localField.setAccessible(true);
          }
          localLruCache.put(paramString, localField);
          AppMethodBeat.o(149103);
          return localField;
        }
        catch (Throwable localThrowable) {}
      } while ((paramClass.getSuperclass() != null) && (paramClass != Object.class));
      AppMethodBeat.o(149103);
      throw localThrowable;
    }
  }
  
  public static Class<?> findClass(String paramString)
  {
    AppMethodBeat.i(149095);
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(149095);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString = new a(paramString);
      AppMethodBeat.o(149095);
      throw paramString;
    }
  }
  
  public static <T> T iw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(149097);
    paramString1 = c(findClass(paramString1), paramString2);
    AppMethodBeat.o(149097);
    return paramString1;
  }
  
  public static final class a
    extends RuntimeException
  {
    a(Throwable paramThrowable)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.i
 * JD-Core Version:    0.7.0.1
 */