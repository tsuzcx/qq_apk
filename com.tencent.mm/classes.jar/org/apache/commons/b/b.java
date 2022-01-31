package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b
{
  public static final String COS;
  public static final String COT;
  private static final Map COU;
  private static final Map COV;
  private static final Map COW;
  private static final Map COX;
  static Class COY;
  static Class COZ;
  static Class CPa;
  static Class CPb;
  static Class CPc;
  static Class CPd;
  static Class CPe;
  static Class CPf;
  
  static
  {
    AppMethodBeat.i(142947);
    COS = ".";
    COT = "$";
    Object localObject2 = new HashMap();
    COU = (Map)localObject2;
    Class localClass = Boolean.TYPE;
    Object localObject1;
    if (COY == null)
    {
      localObject1 = azH("java.lang.Boolean");
      COY = (Class)localObject1;
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = COU;
      localClass = Byte.TYPE;
      if (COZ != null) {
        break label389;
      }
      localObject1 = azH("java.lang.Byte");
      COZ = (Class)localObject1;
      label80:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = COU;
      localClass = Character.TYPE;
      if (CPa != null) {
        break label396;
      }
      localObject1 = azH("java.lang.Character");
      CPa = (Class)localObject1;
      label113:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = COU;
      localClass = Short.TYPE;
      if (CPb != null) {
        break label403;
      }
      localObject1 = azH("java.lang.Short");
      CPb = (Class)localObject1;
      label146:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = COU;
      localClass = Integer.TYPE;
      if (CPc != null) {
        break label410;
      }
      localObject1 = azH("java.lang.Integer");
      CPc = (Class)localObject1;
      label179:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = COU;
      localClass = Long.TYPE;
      if (CPd != null) {
        break label417;
      }
      localObject1 = azH("java.lang.Long");
      CPd = (Class)localObject1;
      label212:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = COU;
      localClass = Double.TYPE;
      if (CPe != null) {
        break label424;
      }
      localObject1 = azH("java.lang.Double");
      CPe = (Class)localObject1;
      label245:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = COU;
      localClass = Float.TYPE;
      if (CPf != null) {
        break label431;
      }
      localObject1 = azH("java.lang.Float");
      CPf = (Class)localObject1;
    }
    for (;;)
    {
      ((Map)localObject2).put(localClass, localObject1);
      localObject1 = COU;
      localObject2 = Void.TYPE;
      ((Map)localObject1).put(localObject2, localObject2);
      COV = new HashMap();
      localObject1 = COU.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Class)((Iterator)localObject1).next();
        localClass = (Class)COU.get(localObject2);
        if (!localObject2.equals(localClass)) {
          COV.put(localClass, localObject2);
        }
      }
      localObject1 = COY;
      break;
      label389:
      localObject1 = COZ;
      break label80;
      label396:
      localObject1 = CPa;
      break label113;
      label403:
      localObject1 = CPb;
      break label146;
      label410:
      localObject1 = CPc;
      break label179;
      label417:
      localObject1 = CPd;
      break label212;
      label424:
      localObject1 = CPe;
      break label245;
      label431:
      localObject1 = CPf;
    }
    COW = new HashMap();
    COX = new HashMap();
    jF("int", "I");
    jF("boolean", "Z");
    jF("float", "F");
    jF("long", "J");
    jF("short", "S");
    jF("byte", "B");
    jF("double", "D");
    jF("char", "C");
    AppMethodBeat.o(142947);
  }
  
  private static boolean a(Class paramClass1, Class paramClass2, boolean paramBoolean)
  {
    AppMethodBeat.i(142943);
    if (paramClass2 == null)
    {
      AppMethodBeat.o(142943);
      return false;
    }
    if (paramClass1 == null)
    {
      if (!paramClass2.isPrimitive())
      {
        AppMethodBeat.o(142943);
        return true;
      }
      AppMethodBeat.o(142943);
      return false;
    }
    Object localObject = paramClass1;
    if (paramBoolean)
    {
      Class localClass = paramClass1;
      if (paramClass1.isPrimitive())
      {
        localClass = paramClass1;
        if (!paramClass2.isPrimitive())
        {
          paramClass1 = aY(paramClass1);
          localClass = paramClass1;
          if (paramClass1 == null)
          {
            AppMethodBeat.o(142943);
            return false;
          }
        }
      }
      localObject = localClass;
      if (paramClass2.isPrimitive())
      {
        localObject = localClass;
        if (!localClass.isPrimitive())
        {
          paramClass1 = aZ(localClass);
          localObject = paramClass1;
          if (paramClass1 == null)
          {
            AppMethodBeat.o(142943);
            return false;
          }
        }
      }
    }
    if (localObject.equals(paramClass2))
    {
      AppMethodBeat.o(142943);
      return true;
    }
    if (((Class)localObject).isPrimitive())
    {
      if (!paramClass2.isPrimitive())
      {
        AppMethodBeat.o(142943);
        return false;
      }
      if (Integer.TYPE.equals(localObject))
      {
        if ((Long.TYPE.equals(paramClass2)) || (Float.TYPE.equals(paramClass2)) || (Double.TYPE.equals(paramClass2)))
        {
          AppMethodBeat.o(142943);
          return true;
        }
        AppMethodBeat.o(142943);
        return false;
      }
      if (Long.TYPE.equals(localObject))
      {
        if ((Float.TYPE.equals(paramClass2)) || (Double.TYPE.equals(paramClass2)))
        {
          AppMethodBeat.o(142943);
          return true;
        }
        AppMethodBeat.o(142943);
        return false;
      }
      if (Boolean.TYPE.equals(localObject))
      {
        AppMethodBeat.o(142943);
        return false;
      }
      if (Double.TYPE.equals(localObject))
      {
        AppMethodBeat.o(142943);
        return false;
      }
      if (Float.TYPE.equals(localObject))
      {
        paramBoolean = Double.TYPE.equals(paramClass2);
        AppMethodBeat.o(142943);
        return paramBoolean;
      }
      if (Character.TYPE.equals(localObject))
      {
        if ((Integer.TYPE.equals(paramClass2)) || (Long.TYPE.equals(paramClass2)) || (Float.TYPE.equals(paramClass2)) || (Double.TYPE.equals(paramClass2)))
        {
          AppMethodBeat.o(142943);
          return true;
        }
        AppMethodBeat.o(142943);
        return false;
      }
      if (Short.TYPE.equals(localObject))
      {
        if ((Integer.TYPE.equals(paramClass2)) || (Long.TYPE.equals(paramClass2)) || (Float.TYPE.equals(paramClass2)) || (Double.TYPE.equals(paramClass2)))
        {
          AppMethodBeat.o(142943);
          return true;
        }
        AppMethodBeat.o(142943);
        return false;
      }
      if (Byte.TYPE.equals(localObject))
      {
        if ((Short.TYPE.equals(paramClass2)) || (Integer.TYPE.equals(paramClass2)) || (Long.TYPE.equals(paramClass2)) || (Float.TYPE.equals(paramClass2)) || (Double.TYPE.equals(paramClass2)))
        {
          AppMethodBeat.o(142943);
          return true;
        }
        AppMethodBeat.o(142943);
        return false;
      }
      AppMethodBeat.o(142943);
      return false;
    }
    paramBoolean = paramClass2.isAssignableFrom((Class)localObject);
    AppMethodBeat.o(142943);
    return paramBoolean;
  }
  
  public static boolean a(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2)
  {
    AppMethodBeat.i(142941);
    if (!a.b(paramArrayOfClass1, paramArrayOfClass2))
    {
      AppMethodBeat.o(142941);
      return false;
    }
    Class[] arrayOfClass = paramArrayOfClass1;
    if (paramArrayOfClass1 == null) {
      arrayOfClass = a.COI;
    }
    paramArrayOfClass1 = paramArrayOfClass2;
    if (paramArrayOfClass2 == null) {
      paramArrayOfClass1 = a.COI;
    }
    int i = 0;
    while (i < arrayOfClass.length)
    {
      if (!a(arrayOfClass[i], paramArrayOfClass1[i], true))
      {
        AppMethodBeat.o(142941);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(142941);
    return true;
  }
  
  public static String aX(Class paramClass)
  {
    int i = 0;
    AppMethodBeat.i(142940);
    if (paramClass == null)
    {
      AppMethodBeat.o(142940);
      return "";
    }
    Object localObject = paramClass.getName();
    if (localObject == null)
    {
      AppMethodBeat.o(142940);
      return "";
    }
    if (((String)localObject).length() == 0)
    {
      AppMethodBeat.o(142940);
      return "";
    }
    org.apache.commons.b.d.a locala = new org.apache.commons.b.d.a();
    paramClass = (Class)localObject;
    if (((String)localObject).startsWith("["))
    {
      while (((String)localObject).charAt(0) == '[')
      {
        localObject = ((String)localObject).substring(1);
        locala.azP("[]");
      }
      paramClass = (Class)localObject;
      if (((String)localObject).charAt(0) == 'L')
      {
        paramClass = (Class)localObject;
        if (((String)localObject).charAt(((String)localObject).length() - 1) == ';') {
          paramClass = ((String)localObject).substring(1, ((String)localObject).length() - 1);
        }
      }
    }
    localObject = paramClass;
    if (COX.containsKey(paramClass)) {
      localObject = (String)COX.get(paramClass);
    }
    int j = ((String)localObject).lastIndexOf('.');
    if (j == -1) {}
    for (;;)
    {
      i = ((String)localObject).indexOf('$', i);
      localObject = ((String)localObject).substring(j + 1);
      paramClass = (Class)localObject;
      if (i != -1) {
        paramClass = ((String)localObject).replace('$', '.');
      }
      paramClass = paramClass + locala;
      AppMethodBeat.o(142940);
      return paramClass;
      i = j + 1;
    }
  }
  
  private static Class aY(Class paramClass)
  {
    AppMethodBeat.i(142944);
    Class localClass = paramClass;
    if (paramClass != null)
    {
      localClass = paramClass;
      if (paramClass.isPrimitive()) {
        localClass = (Class)COU.get(paramClass);
      }
    }
    AppMethodBeat.o(142944);
    return localClass;
  }
  
  public static Class aZ(Class paramClass)
  {
    AppMethodBeat.i(142945);
    paramClass = (Class)COV.get(paramClass);
    AppMethodBeat.o(142945);
    return paramClass;
  }
  
  private static Class azH(String paramString)
  {
    AppMethodBeat.i(142946);
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(142946);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      paramString = new NoClassDefFoundError(paramString.getMessage());
      AppMethodBeat.o(142946);
      throw paramString;
    }
  }
  
  public static boolean f(Class paramClass1, Class paramClass2)
  {
    AppMethodBeat.i(142942);
    boolean bool = a(paramClass1, paramClass2, false);
    AppMethodBeat.o(142942);
    return bool;
  }
  
  private static void jF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(142939);
    COW.put(paramString1, paramString2);
    COX.put(paramString2, paramString1);
    AppMethodBeat.o(142939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.apache.commons.b.b
 * JD-Core Version:    0.7.0.1
 */