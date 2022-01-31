package org.apache.commons.b.c;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.b.a;
import org.apache.commons.b.h;

abstract class b
{
  private static final Method CRv;
  private static final Class[] CRw;
  static Class CRx;
  
  static
  {
    localObject3 = null;
    Object localObject1 = localObject3;
    if (h.erq()) {}
    for (;;)
    {
      try
      {
        if (CRx != null) {
          continue;
        }
        localObject1 = azH("java.lang.reflect.Member");
        CRx = (Class)localObject1;
        localObject1 = ((Class)localObject1).getMethod("isSynthetic", a.COI);
      }
      catch (Exception localException)
      {
        Object localObject2 = localObject3;
        continue;
      }
      CRv = (Method)localObject1;
      CRw = new Class[] { Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE };
      return;
      localObject1 = CRx;
    }
  }
  
  static int a(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2, Class[] paramArrayOfClass3)
  {
    float f1 = b(paramArrayOfClass3, paramArrayOfClass1);
    float f2 = b(paramArrayOfClass3, paramArrayOfClass2);
    if (f1 < f2) {
      return -1;
    }
    if (f2 < f1) {
      return 1;
    }
    return 0;
  }
  
  static void a(AccessibleObject paramAccessibleObject)
  {
    if ((paramAccessibleObject == null) || (paramAccessibleObject.isAccessible())) {}
    for (;;)
    {
      return;
      Member localMember = (Member)paramAccessibleObject;
      if (Modifier.isPublic(localMember.getModifiers()))
      {
        if ((localMember.getDeclaringClass().getModifiers() & 0x7) == 0) {}
        for (int i = 1; i != 0; i = 0) {
          try
          {
            paramAccessibleObject.setAccessible(true);
            return;
          }
          catch (SecurityException paramAccessibleObject)
          {
            return;
          }
        }
      }
    }
  }
  
  private static Class azH(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new NoClassDefFoundError(paramString.getMessage());
    }
  }
  
  private static float b(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2)
  {
    float f = 0.0F;
    int i = 0;
    while (i < paramArrayOfClass1.length)
    {
      f += g(paramArrayOfClass1[i], paramArrayOfClass2[i]);
      i += 1;
    }
    return f;
  }
  
  static boolean c(Member paramMember)
  {
    return (paramMember != null) && (Modifier.isPublic(paramMember.getModifiers())) && (!d(paramMember));
  }
  
  private static boolean d(Member paramMember)
  {
    if (CRv != null) {
      try
      {
        boolean bool = ((Boolean)CRv.invoke(paramMember, null)).booleanValue();
        return bool;
      }
      catch (Exception paramMember) {}
    }
    return false;
  }
  
  private static float g(Class paramClass1, Class paramClass2)
  {
    if (paramClass2.isPrimitive())
    {
      f2 = h(paramClass1, paramClass2);
      return f2;
    }
    float f2 = 0.0F;
    for (;;)
    {
      float f1 = f2;
      if (paramClass1 != null)
      {
        f1 = f2;
        if (!paramClass2.equals(paramClass1))
        {
          if ((!paramClass2.isInterface()) || (!org.apache.commons.b.b.f(paramClass1, paramClass2))) {
            break label64;
          }
          f1 = f2 + 0.25F;
        }
      }
      f2 = f1;
      if (paramClass1 != null) {
        break;
      }
      return f1 + 1.5F;
      label64:
      f2 += 1.0F;
      paramClass1 = paramClass1.getSuperclass();
    }
  }
  
  private static float h(Class paramClass1, Class paramClass2)
  {
    float f1 = 0.0F;
    Class localClass = paramClass1;
    if (!paramClass1.isPrimitive())
    {
      localClass = org.apache.commons.b.b.aZ(paramClass1);
      f1 = 0.1F;
    }
    int i = 0;
    paramClass1 = localClass;
    float f2 = f1;
    while ((paramClass1 != paramClass2) && (i < CRw.length))
    {
      f1 = f2;
      localClass = paramClass1;
      if (paramClass1 == CRw[i])
      {
        f2 += 0.1F;
        f1 = f2;
        localClass = paramClass1;
        if (i < CRw.length - 1)
        {
          localClass = CRw[(i + 1)];
          f1 = f2;
        }
      }
      i += 1;
      f2 = f1;
      paramClass1 = localClass;
    }
    return f2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.apache.commons.b.c.b
 * JD-Core Version:    0.7.0.1
 */