package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class ei
{
  static final Type[] a = new Type[0];
  
  private static int a(Object[] paramArrayOfObject, Object paramObject)
  {
    AppMethodBeat.i(147560);
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      if (paramObject.equals(paramArrayOfObject[i]))
      {
        AppMethodBeat.o(147560);
        return i;
      }
      i += 1;
    }
    paramArrayOfObject = new NoSuchElementException();
    AppMethodBeat.o(147560);
    throw paramArrayOfObject;
  }
  
  private static Class<?> a(TypeVariable<?> paramTypeVariable)
  {
    AppMethodBeat.i(147561);
    paramTypeVariable = paramTypeVariable.getGenericDeclaration();
    if ((paramTypeVariable instanceof Class))
    {
      paramTypeVariable = (Class)paramTypeVariable;
      AppMethodBeat.o(147561);
      return paramTypeVariable;
    }
    AppMethodBeat.o(147561);
    return null;
  }
  
  public static GenericArrayType a(Type paramType)
  {
    AppMethodBeat.i(147544);
    paramType = new ei.a(paramType);
    AppMethodBeat.o(147544);
    return paramType;
  }
  
  public static ParameterizedType a(Type paramType1, Type paramType2, Type... paramVarArgs)
  {
    AppMethodBeat.i(147543);
    paramType1 = new ei.b(paramType1, paramType2, paramVarArgs);
    AppMethodBeat.o(147543);
    return paramType1;
  }
  
  public static Type a(Type paramType, Class<?> paramClass)
  {
    AppMethodBeat.i(147556);
    paramClass = b(paramType, paramClass, Collection.class);
    paramType = paramClass;
    if ((paramClass instanceof WildcardType)) {
      paramType = ((WildcardType)paramClass).getUpperBounds()[0];
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];
      AppMethodBeat.o(147556);
      return paramType;
    }
    AppMethodBeat.o(147556);
    return Object.class;
  }
  
  static Type a(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    AppMethodBeat.i(147553);
    Object localObject = paramClass1;
    paramClass1 = paramType;
    paramType = (Type)localObject;
    if (paramClass2 == paramType)
    {
      AppMethodBeat.o(147553);
      return paramClass1;
    }
    if (paramClass2.isInterface())
    {
      localObject = paramType.getInterfaces();
      int i = 0;
      int j = localObject.length;
      for (;;)
      {
        if (i >= j) {
          break label106;
        }
        if (localObject[i] == paramClass2)
        {
          paramType = paramType.getGenericInterfaces()[i];
          AppMethodBeat.o(147553);
          return paramType;
        }
        if (paramClass2.isAssignableFrom(localObject[i]))
        {
          paramClass1 = paramType.getGenericInterfaces()[i];
          paramType = localObject[i];
          break;
        }
        i += 1;
      }
    }
    label106:
    if (!paramType.isInterface()) {
      for (paramClass1 = paramType;; paramClass1 = paramType)
      {
        if (paramClass1 == Object.class) {
          break label164;
        }
        paramType = paramClass1.getSuperclass();
        if (paramType == paramClass2)
        {
          paramType = paramClass1.getGenericSuperclass();
          AppMethodBeat.o(147553);
          return paramType;
        }
        if (paramClass2.isAssignableFrom(paramType))
        {
          paramClass1 = paramClass1.getGenericSuperclass();
          break;
        }
      }
    }
    label164:
    AppMethodBeat.o(147553);
    return paramClass2;
  }
  
  public static Type a(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    AppMethodBeat.i(147558);
    Object localObject1;
    while ((paramType2 instanceof TypeVariable))
    {
      localObject1 = (TypeVariable)paramType2;
      paramType2 = a(paramType1, paramClass, (TypeVariable)localObject1);
      if (paramType2 == localObject1)
      {
        AppMethodBeat.o(147558);
        return paramType2;
      }
    }
    if (((paramType2 instanceof Class)) && (((Class)paramType2).isArray()))
    {
      paramType2 = (Class)paramType2;
      localObject1 = paramType2.getComponentType();
      paramType1 = a(paramType1, paramClass, (Type)localObject1);
      if (localObject1 == paramType1)
      {
        AppMethodBeat.o(147558);
        return paramType2;
      }
      paramType1 = a(paramType1);
      AppMethodBeat.o(147558);
      return paramType1;
    }
    if ((paramType2 instanceof GenericArrayType))
    {
      paramType2 = (GenericArrayType)paramType2;
      localObject1 = paramType2.getGenericComponentType();
      paramType1 = a(paramType1, paramClass, (Type)localObject1);
      if (localObject1 == paramType1)
      {
        AppMethodBeat.o(147558);
        return paramType2;
      }
      paramType1 = a(paramType1);
      AppMethodBeat.o(147558);
      return paramType1;
    }
    Object localObject2;
    int i;
    int j;
    if ((paramType2 instanceof ParameterizedType))
    {
      localObject1 = (ParameterizedType)paramType2;
      paramType2 = ((ParameterizedType)localObject1).getOwnerType();
      localObject2 = a(paramType1, paramClass, paramType2);
      if (localObject2 != paramType2)
      {
        i = 1;
        paramType2 = ((ParameterizedType)localObject1).getActualTypeArguments();
        int k = paramType2.length;
        j = 0;
        label208:
        if (j >= k) {
          break label269;
        }
        Type localType = a(paramType1, paramClass, paramType2[j]);
        if (localType == paramType2[j]) {
          break label421;
        }
        if (i != 0) {
          break label418;
        }
        paramType2 = (Type[])paramType2.clone();
        i = 1;
        label249:
        paramType2[j] = localType;
      }
    }
    label269:
    label418:
    label421:
    for (;;)
    {
      j += 1;
      break label208;
      i = 0;
      break;
      if (i != 0)
      {
        paramType1 = a((Type)localObject2, ((ParameterizedType)localObject1).getRawType(), paramType2);
        AppMethodBeat.o(147558);
        return paramType1;
      }
      AppMethodBeat.o(147558);
      return localObject1;
      if ((paramType2 instanceof WildcardType))
      {
        paramType2 = (WildcardType)paramType2;
        localObject1 = paramType2.getLowerBounds();
        localObject2 = paramType2.getUpperBounds();
        if (localObject1.length == 1)
        {
          paramType1 = a(paramType1, paramClass, localObject1[0]);
          if (paramType1 != localObject1[0])
          {
            paramType1 = c(paramType1);
            AppMethodBeat.o(147558);
            return paramType1;
          }
        }
        else if (localObject2.length == 1)
        {
          paramType1 = a(paramType1, paramClass, localObject2[0]);
          if (paramType1 != localObject2[0])
          {
            paramType1 = b(paramType1);
            AppMethodBeat.o(147558);
            return paramType1;
          }
        }
        AppMethodBeat.o(147558);
        return paramType2;
      }
      AppMethodBeat.o(147558);
      return paramType2;
      break label249;
    }
  }
  
  static Type a(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    AppMethodBeat.i(147559);
    Class localClass = a(paramTypeVariable);
    if (localClass == null)
    {
      AppMethodBeat.o(147559);
      return paramTypeVariable;
    }
    paramType = a(paramType, paramClass, localClass);
    if ((paramType instanceof ParameterizedType))
    {
      int i = a(localClass.getTypeParameters(), paramTypeVariable);
      paramType = ((ParameterizedType)paramType).getActualTypeArguments()[i];
      AppMethodBeat.o(147559);
      return paramType;
    }
    AppMethodBeat.o(147559);
    return paramTypeVariable;
  }
  
  static boolean a(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(147549);
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2))))
    {
      AppMethodBeat.o(147549);
      return true;
    }
    AppMethodBeat.o(147549);
    return false;
  }
  
  public static boolean a(Type paramType1, Type paramType2)
  {
    AppMethodBeat.i(147550);
    Type localType = paramType1;
    for (paramType1 = paramType2;; paramType1 = paramType1.getGenericComponentType())
    {
      if (localType == paramType1)
      {
        AppMethodBeat.o(147550);
        return true;
      }
      if ((localType instanceof Class))
      {
        boolean bool = localType.equals(paramType1);
        AppMethodBeat.o(147550);
        return bool;
      }
      if ((localType instanceof ParameterizedType))
      {
        if (!(paramType1 instanceof ParameterizedType))
        {
          AppMethodBeat.o(147550);
          return false;
        }
        paramType2 = (ParameterizedType)localType;
        paramType1 = (ParameterizedType)paramType1;
        if ((a(paramType2.getOwnerType(), paramType1.getOwnerType())) && (paramType2.getRawType().equals(paramType1.getRawType())) && (Arrays.equals(paramType2.getActualTypeArguments(), paramType1.getActualTypeArguments())))
        {
          AppMethodBeat.o(147550);
          return true;
        }
        AppMethodBeat.o(147550);
        return false;
      }
      if (!(localType instanceof GenericArrayType)) {
        break;
      }
      if (!(paramType1 instanceof GenericArrayType))
      {
        AppMethodBeat.o(147550);
        return false;
      }
      paramType2 = (GenericArrayType)localType;
      paramType1 = (GenericArrayType)paramType1;
      localType = paramType2.getGenericComponentType();
    }
    if ((localType instanceof WildcardType))
    {
      if (!(paramType1 instanceof WildcardType))
      {
        AppMethodBeat.o(147550);
        return false;
      }
      paramType2 = (WildcardType)localType;
      paramType1 = (WildcardType)paramType1;
      if ((Arrays.equals(paramType2.getUpperBounds(), paramType1.getUpperBounds())) && (Arrays.equals(paramType2.getLowerBounds(), paramType1.getLowerBounds())))
      {
        AppMethodBeat.o(147550);
        return true;
      }
      AppMethodBeat.o(147550);
      return false;
    }
    if ((localType instanceof TypeVariable))
    {
      if (!(paramType1 instanceof TypeVariable))
      {
        AppMethodBeat.o(147550);
        return false;
      }
      paramType2 = (TypeVariable)localType;
      paramType1 = (TypeVariable)paramType1;
      if ((paramType2.getGenericDeclaration() == paramType1.getGenericDeclaration()) && (paramType2.getName().equals(paramType1.getName())))
      {
        AppMethodBeat.o(147550);
        return true;
      }
      AppMethodBeat.o(147550);
      return false;
    }
    AppMethodBeat.o(147550);
    return false;
  }
  
  private static int b(Object paramObject)
  {
    AppMethodBeat.i(147551);
    if (paramObject != null)
    {
      int i = paramObject.hashCode();
      AppMethodBeat.o(147551);
      return i;
    }
    AppMethodBeat.o(147551);
    return 0;
  }
  
  static Type b(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    AppMethodBeat.i(147554);
    eh.a(paramClass2.isAssignableFrom(paramClass1));
    paramType = a(paramType, paramClass1, a(paramType, paramClass1, paramClass2));
    AppMethodBeat.o(147554);
    return paramType;
  }
  
  public static WildcardType b(Type paramType)
  {
    AppMethodBeat.i(147545);
    Type[] arrayOfType = a;
    paramType = new ei.c(new Type[] { paramType }, arrayOfType);
    AppMethodBeat.o(147545);
    return paramType;
  }
  
  public static Type[] b(Type paramType, Class<?> paramClass)
  {
    AppMethodBeat.i(147557);
    if (paramType == Properties.class)
    {
      AppMethodBeat.o(147557);
      return new Type[] { String.class, String.class };
    }
    paramType = b(paramType, paramClass, Map.class);
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments();
      AppMethodBeat.o(147557);
      return paramType;
    }
    AppMethodBeat.o(147557);
    return new Type[] { Object.class, Object.class };
  }
  
  public static WildcardType c(Type paramType)
  {
    AppMethodBeat.i(147546);
    paramType = new ei.c(new Type[] { Object.class }, new Type[] { paramType });
    AppMethodBeat.o(147546);
    return paramType;
  }
  
  public static Type d(Type paramType)
  {
    AppMethodBeat.i(147547);
    if ((paramType instanceof Class))
    {
      paramType = (Class)paramType;
      if (paramType.isArray()) {
        paramType = new ei.a(d(paramType.getComponentType()));
      }
      for (;;)
      {
        paramType = (Type)paramType;
        AppMethodBeat.o(147547);
        return paramType;
      }
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)paramType;
      paramType = new ei.b(paramType.getOwnerType(), paramType.getRawType(), paramType.getActualTypeArguments());
      AppMethodBeat.o(147547);
      return paramType;
    }
    if ((paramType instanceof GenericArrayType))
    {
      paramType = new ei.a(((GenericArrayType)paramType).getGenericComponentType());
      AppMethodBeat.o(147547);
      return paramType;
    }
    if ((paramType instanceof WildcardType))
    {
      paramType = (WildcardType)paramType;
      paramType = new ei.c(paramType.getUpperBounds(), paramType.getLowerBounds());
      AppMethodBeat.o(147547);
      return paramType;
    }
    AppMethodBeat.o(147547);
    return paramType;
  }
  
  public static Class<?> e(Type paramType)
  {
    AppMethodBeat.i(147548);
    for (;;)
    {
      if ((paramType instanceof Class))
      {
        paramType = (Class)paramType;
        AppMethodBeat.o(147548);
        return paramType;
      }
      if ((paramType instanceof ParameterizedType))
      {
        paramType = ((ParameterizedType)paramType).getRawType();
        eh.a(paramType instanceof Class);
        paramType = (Class)paramType;
        AppMethodBeat.o(147548);
        return paramType;
      }
      if ((paramType instanceof GenericArrayType))
      {
        paramType = Array.newInstance(e(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
        AppMethodBeat.o(147548);
        return paramType;
      }
      if ((paramType instanceof TypeVariable))
      {
        AppMethodBeat.o(147548);
        return Object.class;
      }
      if (!(paramType instanceof WildcardType)) {
        break;
      }
      paramType = ((WildcardType)paramType).getUpperBounds()[0];
    }
    if (paramType == null) {}
    for (String str = "null";; str = paramType.getClass().getName())
    {
      paramType = new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + paramType + "> is of type " + str);
      AppMethodBeat.o(147548);
      throw paramType;
    }
  }
  
  public static String f(Type paramType)
  {
    AppMethodBeat.i(147552);
    if ((paramType instanceof Class))
    {
      paramType = ((Class)paramType).getName();
      AppMethodBeat.o(147552);
      return paramType;
    }
    paramType = paramType.toString();
    AppMethodBeat.o(147552);
    return paramType;
  }
  
  public static Type g(Type paramType)
  {
    AppMethodBeat.i(147555);
    if ((paramType instanceof GenericArrayType))
    {
      paramType = ((GenericArrayType)paramType).getGenericComponentType();
      AppMethodBeat.o(147555);
      return paramType;
    }
    paramType = ((Class)paramType).getComponentType();
    AppMethodBeat.o(147555);
    return paramType;
  }
  
  private static void i(Type paramType)
  {
    AppMethodBeat.i(147562);
    if ((!(paramType instanceof Class)) || (!((Class)paramType).isPrimitive())) {}
    for (boolean bool = true;; bool = false)
    {
      eh.a(bool);
      AppMethodBeat.o(147562);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ei
 * JD-Core Version:    0.7.0.1
 */