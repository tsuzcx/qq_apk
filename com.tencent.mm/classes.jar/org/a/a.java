package org.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public final class a
{
  private final Class<?> bYJ;
  public final Object object;
  
  private a(Class<?> paramClass)
  {
    this(paramClass, paramClass);
    AppMethodBeat.i(4275);
    AppMethodBeat.o(4275);
  }
  
  private a(Class<?> paramClass, Object paramObject)
  {
    this.bYJ = paramClass;
    this.object = paramObject;
  }
  
  private Method a(String paramString, Class<?>[] paramArrayOfClass)
  {
    AppMethodBeat.i(4281);
    Object localObject = this.bYJ;
    try
    {
      Method localMethod1 = ((Class)localObject).getMethod(paramString, paramArrayOfClass);
      AppMethodBeat.o(4281);
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
          AppMethodBeat.o(4281);
          return localMethod2;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          localClass = ((Class)localObject).getSuperclass();
          localObject = localClass;
        }
      } while (localClass != null);
      paramString = new NoSuchMethodException();
      AppMethodBeat.o(4281);
      throw paramString;
    }
  }
  
  private static boolean a(Method paramMethod, String paramString, Class<?>[] paramArrayOfClass)
  {
    AppMethodBeat.i(4282);
    if ((paramMethod.getName().equals(paramString)) && (a(paramMethod.getParameterTypes(), paramArrayOfClass)))
    {
      AppMethodBeat.o(4282);
      return true;
    }
    AppMethodBeat.o(4282);
    return false;
  }
  
  private static boolean a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    AppMethodBeat.i(4285);
    if (paramArrayOfClass1.length == paramArrayOfClass2.length)
    {
      int i = 0;
      while (i < paramArrayOfClass2.length)
      {
        if ((paramArrayOfClass2[i] != a.a.class) && (!cf(paramArrayOfClass1[i]).isAssignableFrom(cf(paramArrayOfClass2[i]))))
        {
          AppMethodBeat.o(4285);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(4285);
      return true;
    }
    AppMethodBeat.o(4285);
    return false;
  }
  
  private static Class<?>[] ap(Object... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(4291);
    if (paramVarArgs == null)
    {
      AppMethodBeat.o(4291);
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
    AppMethodBeat.o(4291);
    return arrayOfClass;
  }
  
  private static a b(Constructor<?> paramConstructor, Object... paramVarArgs)
  {
    AppMethodBeat.i(4289);
    try
    {
      paramConstructor = e(paramConstructor.getDeclaringClass(), ((Constructor)c(paramConstructor)).newInstance(paramVarArgs));
      AppMethodBeat.o(4289);
      return paramConstructor;
    }
    catch (Exception paramConstructor)
    {
      paramConstructor = new b(paramConstructor);
      AppMethodBeat.o(4289);
      throw paramConstructor;
    }
  }
  
  public static Class<?> bIA(String paramString)
  {
    AppMethodBeat.i(4292);
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(4292);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = new b(paramString);
      AppMethodBeat.o(4292);
      throw paramString;
    }
  }
  
  private Field bIy(String paramString)
  {
    AppMethodBeat.i(4278);
    Class localClass = this.bYJ;
    try
    {
      Field localField1 = (Field)c(localClass.getField(paramString));
      AppMethodBeat.o(4278);
      return localField1;
    }
    catch (NoSuchFieldException localNoSuchFieldException1) {}
    for (;;)
    {
      try
      {
        Field localField2 = (Field)c(localClass.getDeclaredField(paramString));
        AppMethodBeat.o(4278);
        return localField2;
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        localClass = localClass.getSuperclass();
        if (localClass == null)
        {
          paramString = new b(localNoSuchFieldException1);
          AppMethodBeat.o(4278);
          throw paramString;
        }
      }
    }
  }
  
  private static <T extends AccessibleObject> T c(T paramT)
  {
    AppMethodBeat.i(4274);
    if (paramT == null)
    {
      AppMethodBeat.o(4274);
      return null;
    }
    if ((paramT instanceof Member))
    {
      Member localMember = (Member)paramT;
      if ((Modifier.isPublic(localMember.getModifiers())) && (Modifier.isPublic(localMember.getDeclaringClass().getModifiers())))
      {
        AppMethodBeat.o(4274);
        return paramT;
      }
    }
    if (!paramT.isAccessible()) {
      paramT.setAccessible(true);
    }
    AppMethodBeat.o(4274);
    return paramT;
  }
  
  private static a c(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    AppMethodBeat.i(4290);
    try
    {
      c(paramMethod);
      if (paramMethod.getReturnType() == Void.TYPE)
      {
        paramMethod.invoke(paramObject, paramVarArgs);
        paramMethod = gY(paramObject);
        AppMethodBeat.o(4290);
        return paramMethod;
      }
      paramMethod = gY(paramMethod.invoke(paramObject, paramVarArgs));
      AppMethodBeat.o(4290);
      return paramMethod;
    }
    catch (Exception paramMethod)
    {
      paramMethod = new b(paramMethod);
      AppMethodBeat.o(4290);
      throw paramMethod;
    }
  }
  
  public static a ce(Class<?> paramClass)
  {
    AppMethodBeat.i(4271);
    paramClass = new a(paramClass);
    AppMethodBeat.o(4271);
    return paramClass;
  }
  
  private static Class<?> cf(Class<?> paramClass)
  {
    AppMethodBeat.i(4293);
    if (paramClass == null)
    {
      AppMethodBeat.o(4293);
      return null;
    }
    if (paramClass.isPrimitive())
    {
      if (Boolean.TYPE == paramClass)
      {
        AppMethodBeat.o(4293);
        return Boolean.class;
      }
      if (Integer.TYPE == paramClass)
      {
        AppMethodBeat.o(4293);
        return Integer.class;
      }
      if (Long.TYPE == paramClass)
      {
        AppMethodBeat.o(4293);
        return Long.class;
      }
      if (Short.TYPE == paramClass)
      {
        AppMethodBeat.o(4293);
        return Short.class;
      }
      if (Byte.TYPE == paramClass)
      {
        AppMethodBeat.o(4293);
        return Byte.class;
      }
      if (Double.TYPE == paramClass)
      {
        AppMethodBeat.o(4293);
        return Double.class;
      }
      if (Float.TYPE == paramClass)
      {
        AppMethodBeat.o(4293);
        return Float.class;
      }
      if (Character.TYPE == paramClass)
      {
        AppMethodBeat.o(4293);
        return Character.class;
      }
      if (Void.TYPE == paramClass)
      {
        AppMethodBeat.o(4293);
        return Void.class;
      }
    }
    AppMethodBeat.o(4293);
    return paramClass;
  }
  
  private static a e(Class<?> paramClass, Object paramObject)
  {
    AppMethodBeat.i(4273);
    paramClass = new a(paramClass, paramObject);
    AppMethodBeat.o(4273);
    return paramClass;
  }
  
  public static a gY(Object paramObject)
  {
    AppMethodBeat.i(4272);
    if (paramObject == null) {}
    for (Object localObject = Object.class;; localObject = paramObject.getClass())
    {
      paramObject = new a((Class)localObject, paramObject);
      AppMethodBeat.o(4272);
      return paramObject;
    }
  }
  
  public final a ao(Object... paramVarArgs)
  {
    AppMethodBeat.i(4284);
    Class[] arrayOfClass = ap(paramVarArgs);
    try
    {
      a locala = b(this.bYJ.getDeclaredConstructor(arrayOfClass), paramVarArgs);
      AppMethodBeat.o(4284);
      return locala;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Constructor[] arrayOfConstructor = this.bYJ.getDeclaredConstructors();
      int j = arrayOfConstructor.length;
      int i = 0;
      while (i < j)
      {
        Constructor localConstructor = arrayOfConstructor[i];
        if (a(localConstructor.getParameterTypes(), arrayOfClass))
        {
          paramVarArgs = b(localConstructor, paramVarArgs);
          AppMethodBeat.o(4284);
          return paramVarArgs;
        }
        i += 1;
      }
      paramVarArgs = new b(localNoSuchMethodException);
      AppMethodBeat.o(4284);
      throw paramVarArgs;
    }
  }
  
  public final a bIx(String paramString)
  {
    AppMethodBeat.i(4277);
    try
    {
      paramString = bIy(paramString);
      paramString = e(paramString.getType(), paramString.get(this.object));
      AppMethodBeat.o(4277);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = new b(paramString);
      AppMethodBeat.o(4277);
      throw paramString;
    }
  }
  
  public final a bIz(String paramString)
  {
    AppMethodBeat.i(4279);
    paramString = t(paramString, new Object[0]);
    AppMethodBeat.o(4279);
    return paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(4287);
    if ((paramObject instanceof a))
    {
      boolean bool = this.object.equals(((a)paramObject).object);
      AppMethodBeat.o(4287);
      return bool;
    }
    AppMethodBeat.o(4287);
    return false;
  }
  
  public final <T> T get(String paramString)
  {
    AppMethodBeat.i(4276);
    paramString = bIx(paramString).object;
    AppMethodBeat.o(4276);
    return paramString;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(4286);
    int i = this.object.hashCode();
    AppMethodBeat.o(4286);
    return i;
  }
  
  public final a iVg()
  {
    AppMethodBeat.i(4283);
    a locala = ao(new Object[0]);
    AppMethodBeat.o(4283);
    return locala;
  }
  
  public final a t(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(4280);
    Class[] arrayOfClass = ap(paramVarArgs);
    try
    {
      a locala = c(a(paramString, arrayOfClass), this.object, paramVarArgs);
      AppMethodBeat.o(4280);
      return locala;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
    for (;;)
    {
      try
      {
        Class localClass = this.bYJ;
        Method[] arrayOfMethod1 = localClass.getMethods();
        int j = arrayOfMethod1.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = arrayOfMethod1[i];
          if (a((Method)localObject, paramString, arrayOfClass))
          {
            paramString = c((Method)localObject, this.object, paramVarArgs);
            AppMethodBeat.o(4280);
            return paramString;
          }
          i += 1;
          continue;
          Method[] arrayOfMethod2 = localClass.getDeclaredMethods();
          j = arrayOfMethod2.length;
          i = 0;
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
              paramString = new NoSuchMethodException("No similar method " + paramString + " with params " + Arrays.toString(arrayOfClass) + " could be found on type " + this.bYJ + ".");
              AppMethodBeat.o(4280);
              throw paramString;
            }
          }
        }
      }
      catch (NoSuchMethodException paramString)
      {
        paramString = new b(paramString);
        AppMethodBeat.o(4280);
        throw paramString;
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(4288);
    String str = this.object.toString();
    AppMethodBeat.o(4288);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.a.a
 * JD-Core Version:    0.7.0.1
 */