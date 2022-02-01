package com.tencent.mm.plugin.normsg.d;

import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public final class i
{
  private static final LruCache<String, LruCache<String, Field>> MvI;
  private static final LruCache<String, LruCache<String, Method>> MvJ;
  private static final LruCache<String, LruCache<String, Constructor<?>>> MvK;
  
  static
  {
    AppMethodBeat.i(149105);
    MvI = new LruCache(50);
    MvJ = new LruCache(50);
    MvK = new LruCache(50);
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
    finally
    {
      paramClass = new a(paramClass);
      AppMethodBeat.o(149102);
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
    finally
    {
      paramObject = new a(paramObject);
      AppMethodBeat.o(149100);
    }
  }
  
  private static Method b(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(149104);
    LruCache localLruCache = (LruCache)MvJ.get(paramClass.getName());
    if (localLruCache == null)
    {
      localLruCache = new LruCache(30);
      MvJ.put(paramClass.getName(), localLruCache);
    }
    for (;;)
    {
      Object localObject1 = new StringBuilder().append(paramString).append("#");
      if (paramVarArgs != null) {}
      for (String str = Arrays.toString(paramVarArgs);; str = "[]")
      {
        str = str;
        localObject1 = (Method)localLruCache.get(str);
        if (localObject1 == null) {
          break;
        }
        AppMethodBeat.o(149104);
        return localObject1;
      }
      do
      {
        paramClass = paramClass.getSuperclass();
        try
        {
          localObject1 = paramClass.getDeclaredMethod(paramString, paramVarArgs);
          if (!((Method)localObject1).isAccessible()) {
            ((Method)localObject1).setAccessible(true);
          }
          localLruCache.put(str, localObject1);
          AppMethodBeat.o(149104);
          return localObject1;
        }
        finally {}
      } while ((paramClass.getSuperclass() != null) && (paramClass != Object.class));
      AppMethodBeat.o(149104);
      throw localObject2;
    }
  }
  
  public static Class<?>[] c(Class<?>... paramVarArgs)
  {
    return paramVarArgs;
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
    finally
    {
      paramString = new a(paramString);
      AppMethodBeat.o(149095);
    }
  }
  
  public static <T> void g(Object paramObject, String paramString, T paramT)
  {
    AppMethodBeat.i(149099);
    Class localClass = paramObject.getClass();
    try
    {
      k(localClass, paramString).set(paramObject, paramT);
      AppMethodBeat.o(149099);
      return;
    }
    finally
    {
      paramObject = new a(paramObject);
      AppMethodBeat.o(149099);
    }
  }
  
  private static <T> T j(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(149098);
    try
    {
      paramClass = k(paramClass, paramString).get(null);
      AppMethodBeat.o(149098);
      return paramClass;
    }
    finally
    {
      paramClass = new a(paramClass);
      AppMethodBeat.o(149098);
    }
  }
  
  private static Field k(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(149103);
    LruCache localLruCache = (LruCache)MvI.get(paramClass.getName());
    if (localLruCache == null)
    {
      localLruCache = new LruCache(30);
      MvI.put(paramClass.getName(), localLruCache);
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
        finally {}
      } while ((paramClass.getSuperclass() != null) && (paramClass != Object.class));
      AppMethodBeat.o(149103);
      throw localObject;
    }
  }
  
  public static <T> T kJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(149097);
    paramString1 = j(findClass(paramString1), paramString2);
    AppMethodBeat.o(149097);
    return paramString1;
  }
  
  public static <T> T n(Object paramObject, String paramString)
  {
    AppMethodBeat.i(149096);
    Class localClass = paramObject.getClass();
    try
    {
      paramObject = k(localClass, paramString).get(paramObject);
      AppMethodBeat.o(149096);
      return paramObject;
    }
    finally
    {
      paramObject = new a(paramObject);
      AppMethodBeat.o(149096);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.i
 * JD-Core Version:    0.7.0.1
 */