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
  private final Class<?> CRy;
  public final Object object;
  
  private a(Class<?> paramClass)
  {
    this(paramClass, paramClass);
    AppMethodBeat.i(59248);
    AppMethodBeat.o(59248);
  }
  
  private a(Class<?> paramClass, Object paramObject)
  {
    this.CRy = paramClass;
    this.object = paramObject;
  }
  
  private Method a(String paramString, Class<?>[] paramArrayOfClass)
  {
    AppMethodBeat.i(59253);
    Object localObject = this.CRy;
    try
    {
      Method localMethod1 = ((Class)localObject).getMethod(paramString, paramArrayOfClass);
      AppMethodBeat.o(59253);
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
          AppMethodBeat.o(59253);
          return localMethod2;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          localClass = ((Class)localObject).getSuperclass();
          localObject = localClass;
        }
      } while (localClass != null);
      paramString = new NoSuchMethodException();
      AppMethodBeat.o(59253);
      throw paramString;
    }
  }
  
  private static a a(Constructor<?> paramConstructor, Object... paramVarArgs)
  {
    AppMethodBeat.i(59260);
    try
    {
      paramConstructor = e(paramConstructor.getDeclaringClass(), ((Constructor)b(paramConstructor)).newInstance(paramVarArgs));
      AppMethodBeat.o(59260);
      return paramConstructor;
    }
    catch (Exception paramConstructor)
    {
      paramConstructor = new b(paramConstructor);
      AppMethodBeat.o(59260);
      throw paramConstructor;
    }
  }
  
  private static a a(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    AppMethodBeat.i(59261);
    try
    {
      b(paramMethod);
      if (paramMethod.getReturnType() == Void.TYPE)
      {
        paramMethod.invoke(paramObject, paramVarArgs);
        paramMethod = ep(paramObject);
        AppMethodBeat.o(59261);
        return paramMethod;
      }
      paramMethod = ep(paramMethod.invoke(paramObject, paramVarArgs));
      AppMethodBeat.o(59261);
      return paramMethod;
    }
    catch (Exception paramMethod)
    {
      paramMethod = new b(paramMethod);
      AppMethodBeat.o(59261);
      throw paramMethod;
    }
  }
  
  private static boolean a(Method paramMethod, String paramString, Class<?>[] paramArrayOfClass)
  {
    AppMethodBeat.i(59254);
    if ((paramMethod.getName().equals(paramString)) && (c(paramMethod.getParameterTypes(), paramArrayOfClass)))
    {
      AppMethodBeat.o(59254);
      return true;
    }
    AppMethodBeat.o(59254);
    return false;
  }
  
  private static Class<?>[] ad(Object... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(59262);
    if (paramVarArgs == null)
    {
      AppMethodBeat.o(59262);
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
    AppMethodBeat.o(59262);
    return arrayOfClass;
  }
  
  private Field azR(String paramString)
  {
    AppMethodBeat.i(59251);
    Class localClass = this.CRy;
    try
    {
      Field localField1 = (Field)b(localClass.getField(paramString));
      AppMethodBeat.o(59251);
      return localField1;
    }
    catch (NoSuchFieldException localNoSuchFieldException1) {}
    for (;;)
    {
      try
      {
        Field localField2 = (Field)b(localClass.getDeclaredField(paramString));
        AppMethodBeat.o(59251);
        return localField2;
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        localClass = localClass.getSuperclass();
        if (localClass == null)
        {
          paramString = new b(localNoSuchFieldException1);
          AppMethodBeat.o(59251);
          throw paramString;
        }
      }
    }
  }
  
  private static <T extends AccessibleObject> T b(T paramT)
  {
    AppMethodBeat.i(59247);
    if (paramT == null)
    {
      AppMethodBeat.o(59247);
      return null;
    }
    if ((paramT instanceof Member))
    {
      Member localMember = (Member)paramT;
      if ((Modifier.isPublic(localMember.getModifiers())) && (Modifier.isPublic(localMember.getDeclaringClass().getModifiers())))
      {
        AppMethodBeat.o(59247);
        return paramT;
      }
    }
    if (!paramT.isAccessible()) {
      paramT.setAccessible(true);
    }
    AppMethodBeat.o(59247);
    return paramT;
  }
  
  public static a ba(Class<?> paramClass)
  {
    AppMethodBeat.i(59244);
    paramClass = new a(paramClass);
    AppMethodBeat.o(59244);
    return paramClass;
  }
  
  private static Class<?> bb(Class<?> paramClass)
  {
    AppMethodBeat.i(59263);
    if (paramClass == null)
    {
      AppMethodBeat.o(59263);
      return null;
    }
    if (paramClass.isPrimitive())
    {
      if (Boolean.TYPE == paramClass)
      {
        AppMethodBeat.o(59263);
        return Boolean.class;
      }
      if (Integer.TYPE == paramClass)
      {
        AppMethodBeat.o(59263);
        return Integer.class;
      }
      if (Long.TYPE == paramClass)
      {
        AppMethodBeat.o(59263);
        return Long.class;
      }
      if (Short.TYPE == paramClass)
      {
        AppMethodBeat.o(59263);
        return Short.class;
      }
      if (Byte.TYPE == paramClass)
      {
        AppMethodBeat.o(59263);
        return Byte.class;
      }
      if (Double.TYPE == paramClass)
      {
        AppMethodBeat.o(59263);
        return Double.class;
      }
      if (Float.TYPE == paramClass)
      {
        AppMethodBeat.o(59263);
        return Float.class;
      }
      if (Character.TYPE == paramClass)
      {
        AppMethodBeat.o(59263);
        return Character.class;
      }
      if (Void.TYPE == paramClass)
      {
        AppMethodBeat.o(59263);
        return Void.class;
      }
    }
    AppMethodBeat.o(59263);
    return paramClass;
  }
  
  private static boolean c(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    AppMethodBeat.i(59256);
    if (paramArrayOfClass1.length == paramArrayOfClass2.length)
    {
      int i = 0;
      while (i < paramArrayOfClass2.length)
      {
        if ((paramArrayOfClass2[i] != a.a.class) && (!bb(paramArrayOfClass1[i]).isAssignableFrom(bb(paramArrayOfClass2[i]))))
        {
          AppMethodBeat.o(59256);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(59256);
      return true;
    }
    AppMethodBeat.o(59256);
    return false;
  }
  
  private static a e(Class<?> paramClass, Object paramObject)
  {
    AppMethodBeat.i(59246);
    paramClass = new a(paramClass, paramObject);
    AppMethodBeat.o(59246);
    return paramClass;
  }
  
  public static a ep(Object paramObject)
  {
    AppMethodBeat.i(59245);
    if (paramObject == null) {}
    for (Object localObject = Object.class;; localObject = paramObject.getClass())
    {
      paramObject = new a((Class)localObject, paramObject);
      AppMethodBeat.o(59245);
      return paramObject;
    }
  }
  
  public static Class<?> forName(String paramString)
  {
    AppMethodBeat.i(145992);
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(145992);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = new b(paramString);
      AppMethodBeat.o(145992);
      throw paramString;
    }
  }
  
  public final a ac(Object... paramVarArgs)
  {
    AppMethodBeat.i(59255);
    Class[] arrayOfClass = ad(paramVarArgs);
    try
    {
      a locala = a(this.CRy.getDeclaredConstructor(arrayOfClass), paramVarArgs);
      AppMethodBeat.o(59255);
      return locala;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Constructor[] arrayOfConstructor = this.CRy.getDeclaredConstructors();
      int j = arrayOfConstructor.length;
      int i = 0;
      while (i < j)
      {
        Constructor localConstructor = arrayOfConstructor[i];
        if (c(localConstructor.getParameterTypes(), arrayOfClass))
        {
          paramVarArgs = a(localConstructor, paramVarArgs);
          AppMethodBeat.o(59255);
          return paramVarArgs;
        }
        i += 1;
      }
      paramVarArgs = new b(localNoSuchMethodException);
      AppMethodBeat.o(59255);
      throw paramVarArgs;
    }
  }
  
  public final a azQ(String paramString)
  {
    AppMethodBeat.i(59250);
    try
    {
      paramString = azR(paramString);
      paramString = e(paramString.getType(), paramString.get(this.object));
      AppMethodBeat.o(59250);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = new b(paramString);
      AppMethodBeat.o(59250);
      throw paramString;
    }
  }
  
  public final a azS(String paramString)
  {
    AppMethodBeat.i(145990);
    paramString = q(paramString, new Object[0]);
    AppMethodBeat.o(145990);
    return paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59258);
    if ((paramObject instanceof a))
    {
      boolean bool = this.object.equals(((a)paramObject).object);
      AppMethodBeat.o(59258);
      return bool;
    }
    AppMethodBeat.o(59258);
    return false;
  }
  
  public final a erv()
  {
    AppMethodBeat.i(145991);
    a locala = ac(new Object[0]);
    AppMethodBeat.o(145991);
    return locala;
  }
  
  public final <T> T get(String paramString)
  {
    AppMethodBeat.i(59249);
    paramString = azQ(paramString).object;
    AppMethodBeat.o(59249);
    return paramString;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59257);
    int i = this.object.hashCode();
    AppMethodBeat.o(59257);
    return i;
  }
  
  public final a q(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(59252);
    Class[] arrayOfClass = ad(paramVarArgs);
    try
    {
      a locala = a(a(paramString, arrayOfClass), this.object, paramVarArgs);
      AppMethodBeat.o(59252);
      return locala;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
    for (;;)
    {
      try
      {
        Class localClass = this.CRy;
        Method[] arrayOfMethod1 = localClass.getMethods();
        int j = arrayOfMethod1.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = arrayOfMethod1[i];
          if (a((Method)localObject, paramString, arrayOfClass))
          {
            paramString = a((Method)localObject, this.object, paramVarArgs);
            AppMethodBeat.o(59252);
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
              paramString = new NoSuchMethodException("No similar method " + paramString + " with params " + Arrays.toString(arrayOfClass) + " could be found on type " + this.CRy + ".");
              AppMethodBeat.o(59252);
              throw paramString;
            }
          }
        }
      }
      catch (NoSuchMethodException paramString)
      {
        paramString = new b(paramString);
        AppMethodBeat.o(59252);
        throw paramString;
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59259);
    String str = this.object.toString();
    AppMethodBeat.o(59259);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.a.a
 * JD-Core Version:    0.7.0.1
 */