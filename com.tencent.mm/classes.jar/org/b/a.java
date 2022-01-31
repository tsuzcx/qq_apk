package org.b;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public final class a
{
  public final Object object;
  private final Class<?> xum;
  
  private a(Class<?> paramClass)
  {
    this(paramClass, paramClass);
  }
  
  private a(Class<?> paramClass, Object paramObject)
  {
    this.xum = paramClass;
    this.object = paramObject;
  }
  
  private static Class<?>[] G(Object... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs == null) {
      return new Class[0];
    }
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    if (i < paramVarArgs.length)
    {
      Object localObject = paramVarArgs[i];
      if (localObject == null) {}
      for (localObject = a.a.class;; localObject = localObject.getClass())
      {
        arrayOfClass[i] = localObject;
        i += 1;
        break;
      }
    }
    return arrayOfClass;
  }
  
  private static <T extends AccessibleObject> T a(T paramT)
  {
    T ?;
    if (paramT == null) {
      ? = null;
    }
    do
    {
      Member localMember;
      do
      {
        return ?;
        if (!(paramT instanceof Member)) {
          break;
        }
        localMember = (Member)paramT;
        if (!Modifier.isPublic(localMember.getModifiers())) {
          break;
        }
        ? = paramT;
      } while (Modifier.isPublic(localMember.getDeclaringClass().getModifiers()));
      ? = paramT;
    } while (paramT.isAccessible());
    paramT.setAccessible(true);
    return paramT;
  }
  
  private Method a(String paramString, Class<?>[] paramArrayOfClass)
  {
    Object localObject = this.xum;
    try
    {
      Method localMethod1 = ((Class)localObject).getMethod(paramString, paramArrayOfClass);
      return localMethod1;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      Class localClass;
      do
      {
        try
        {
          Method localMethod2 = ((Class)localObject).getDeclaredMethod(paramString, paramArrayOfClass);
          return localMethod2;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          localClass = ((Class)localObject).getSuperclass();
          localObject = localClass;
        }
      } while (localClass != null);
      throw new NoSuchMethodException();
    }
  }
  
  private static a a(Constructor<?> paramConstructor, Object... paramVarArgs)
  {
    try
    {
      paramConstructor = b(paramConstructor.getDeclaringClass(), ((Constructor)a(paramConstructor)).newInstance(paramVarArgs));
      return paramConstructor;
    }
    catch (Exception paramConstructor)
    {
      throw new b(paramConstructor);
    }
  }
  
  private static a a(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      a(paramMethod);
      if (paramMethod.getReturnType() == Void.TYPE)
      {
        paramMethod.invoke(paramObject, paramVarArgs);
        return cz(paramObject);
      }
      paramMethod = cz(paramMethod.invoke(paramObject, paramVarArgs));
      return paramMethod;
    }
    catch (Exception paramMethod)
    {
      throw new b(paramMethod);
    }
  }
  
  private static boolean a(Method paramMethod, String paramString, Class<?>[] paramArrayOfClass)
  {
    return (paramMethod.getName().equals(paramString)) && (a(paramMethod.getParameterTypes(), paramArrayOfClass));
  }
  
  private static boolean a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    int i;
    if (paramArrayOfClass1.length == paramArrayOfClass2.length) {
      i = 0;
    }
    while (i < paramArrayOfClass2.length)
    {
      if ((paramArrayOfClass2[i] != a.a.class) && (!am(paramArrayOfClass1[i]).isAssignableFrom(am(paramArrayOfClass2[i])))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private Field ahy(String paramString)
  {
    Class localClass = this.xum;
    try
    {
      Field localField1 = (Field)a(localClass.getField(paramString));
      return localField1;
    }
    catch (NoSuchFieldException localNoSuchFieldException1) {}
    for (;;)
    {
      try
      {
        Field localField2 = (Field)a(localClass.getDeclaredField(paramString));
        return localField2;
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        localClass = localClass.getSuperclass();
        if (localClass == null) {
          throw new b(localNoSuchFieldException1);
        }
      }
    }
  }
  
  public static a al(Class<?> paramClass)
  {
    return new a(paramClass);
  }
  
  private static Class<?> am(Class<?> paramClass)
  {
    Class<?> localClass;
    if (paramClass == null) {
      localClass = null;
    }
    do
    {
      do
      {
        return localClass;
        localClass = paramClass;
      } while (!paramClass.isPrimitive());
      if (Boolean.TYPE == paramClass) {
        return Boolean.class;
      }
      if (Integer.TYPE == paramClass) {
        return Integer.class;
      }
      if (Long.TYPE == paramClass) {
        return Long.class;
      }
      if (Short.TYPE == paramClass) {
        return Short.class;
      }
      if (Byte.TYPE == paramClass) {
        return Byte.class;
      }
      if (Double.TYPE == paramClass) {
        return Double.class;
      }
      if (Float.TYPE == paramClass) {
        return Float.class;
      }
      if (Character.TYPE == paramClass) {
        return Character.class;
      }
      localClass = paramClass;
    } while (Void.TYPE != paramClass);
    return Void.class;
  }
  
  private static a b(Class<?> paramClass, Object paramObject)
  {
    return new a(paramClass, paramObject);
  }
  
  public static a cz(Object paramObject)
  {
    if (paramObject == null) {}
    for (Object localObject = Object.class;; localObject = paramObject.getClass()) {
      return new a((Class)localObject, paramObject);
    }
  }
  
  public final a F(Object... paramVarArgs)
  {
    Class[] arrayOfClass = G(paramVarArgs);
    try
    {
      a locala = a(this.xum.getDeclaredConstructor(arrayOfClass), paramVarArgs);
      return locala;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Constructor[] arrayOfConstructor = this.xum.getDeclaredConstructors();
      int j = arrayOfConstructor.length;
      int i = 0;
      while (i < j)
      {
        Constructor localConstructor = arrayOfConstructor[i];
        if (a(localConstructor.getParameterTypes(), arrayOfClass)) {
          return a(localConstructor, paramVarArgs);
        }
        i += 1;
      }
      throw new b(localNoSuchMethodException);
    }
  }
  
  public final a ahx(String paramString)
  {
    try
    {
      paramString = ahy(paramString);
      paramString = b(paramString.getType(), paramString.get(this.object));
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new b(paramString);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof a)) {
      return this.object.equals(((a)paramObject).object);
    }
    return false;
  }
  
  public final <T> T get(String paramString)
  {
    return ahx(paramString).object;
  }
  
  public final int hashCode()
  {
    return this.object.hashCode();
  }
  
  public final String toString()
  {
    return this.object.toString();
  }
  
  public final a y(String paramString, Object... paramVarArgs)
  {
    Class[] arrayOfClass = G(paramVarArgs);
    try
    {
      a locala = a(a(paramString, arrayOfClass), this.object, paramVarArgs);
      return locala;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
    for (;;)
    {
      try
      {
        localClass = this.xum;
        arrayOfMethod1 = localClass.getMethods();
        j = arrayOfMethod1.length;
        i = 0;
        if (i >= j) {
          break label209;
        }
        localObject = arrayOfMethod1[i];
        if (!a((Method)localObject, paramString, arrayOfClass)) {
          break label212;
        }
        return a((Method)localObject, this.object, paramVarArgs);
      }
      catch (NoSuchMethodException paramString)
      {
        Class localClass;
        Method[] arrayOfMethod1;
        int j;
        Object localObject;
        Method[] arrayOfMethod2;
        throw new b(paramString);
      }
      arrayOfMethod2 = localClass.getDeclaredMethods();
      j = arrayOfMethod2.length;
      int i = 0;
      if (i < j)
      {
        arrayOfMethod1 = arrayOfMethod2[i];
        localObject = arrayOfMethod1;
        if (!a(arrayOfMethod1, paramString, arrayOfClass)) {
          i += 1;
        }
      }
      else
      {
        localClass = localClass.getSuperclass();
        if (localClass == null)
        {
          throw new NoSuchMethodException("No similar method " + paramString + " with params " + Arrays.toString(arrayOfClass) + " could be found on type " + this.xum + ".");
          label209:
          continue;
          label212:
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.b.a
 * JD-Core Version:    0.7.0.1
 */