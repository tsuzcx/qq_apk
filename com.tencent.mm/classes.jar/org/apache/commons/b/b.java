package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.b.c.a;

public final class b
{
  public static final String NSR;
  public static final String NSS;
  private static final Map NST;
  private static final Map NSU;
  private static final Map NSV;
  private static final Map NSW;
  static Class NSX;
  static Class NSY;
  static Class NSZ;
  static Class NTa;
  static Class NTb;
  static Class NTc;
  static Class NTd;
  static Class NTe;
  
  static
  {
    AppMethodBeat.i(40703);
    NSR = ".";
    NSS = "$";
    Object localObject2 = new HashMap();
    NST = (Map)localObject2;
    Class localClass = Boolean.TYPE;
    Object localObject1;
    if (NSX == null)
    {
      localObject1 = bdI("java.lang.Boolean");
      NSX = (Class)localObject1;
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = NST;
      localClass = Byte.TYPE;
      if (NSY != null) {
        break label389;
      }
      localObject1 = bdI("java.lang.Byte");
      NSY = (Class)localObject1;
      label80:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = NST;
      localClass = Character.TYPE;
      if (NSZ != null) {
        break label396;
      }
      localObject1 = bdI("java.lang.Character");
      NSZ = (Class)localObject1;
      label113:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = NST;
      localClass = Short.TYPE;
      if (NTa != null) {
        break label403;
      }
      localObject1 = bdI("java.lang.Short");
      NTa = (Class)localObject1;
      label146:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = NST;
      localClass = Integer.TYPE;
      if (NTb != null) {
        break label410;
      }
      localObject1 = bdI("java.lang.Integer");
      NTb = (Class)localObject1;
      label179:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = NST;
      localClass = Long.TYPE;
      if (NTc != null) {
        break label417;
      }
      localObject1 = bdI("java.lang.Long");
      NTc = (Class)localObject1;
      label212:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = NST;
      localClass = Double.TYPE;
      if (NTd != null) {
        break label424;
      }
      localObject1 = bdI("java.lang.Double");
      NTd = (Class)localObject1;
      label245:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = NST;
      localClass = Float.TYPE;
      if (NTe != null) {
        break label431;
      }
      localObject1 = bdI("java.lang.Float");
      NTe = (Class)localObject1;
    }
    for (;;)
    {
      ((Map)localObject2).put(localClass, localObject1);
      localObject1 = NST;
      localObject2 = Void.TYPE;
      ((Map)localObject1).put(localObject2, localObject2);
      NSU = new HashMap();
      localObject1 = NST.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Class)((Iterator)localObject1).next();
        localClass = (Class)NST.get(localObject2);
        if (!localObject2.equals(localClass)) {
          NSU.put(localClass, localObject2);
        }
      }
      localObject1 = NSX;
      break;
      label389:
      localObject1 = NSY;
      break label80;
      label396:
      localObject1 = NSZ;
      break label113;
      label403:
      localObject1 = NTa;
      break label146;
      label410:
      localObject1 = NTb;
      break label179;
      label417:
      localObject1 = NTc;
      break label212;
      label424:
      localObject1 = NTd;
      break label245;
      label431:
      localObject1 = NTe;
    }
    NSV = new HashMap();
    NSW = new HashMap();
    nK("int", "I");
    nK("boolean", "Z");
    nK("float", "F");
    nK("long", "J");
    nK("short", "S");
    nK("byte", "B");
    nK("double", "D");
    nK("char", "C");
    AppMethodBeat.o(40703);
  }
  
  public static String bE(Class paramClass)
  {
    int i = 0;
    AppMethodBeat.i(40701);
    if (paramClass == null)
    {
      AppMethodBeat.o(40701);
      return "";
    }
    Object localObject = paramClass.getName();
    if (localObject == null)
    {
      AppMethodBeat.o(40701);
      return "";
    }
    if (((String)localObject).length() == 0)
    {
      AppMethodBeat.o(40701);
      return "";
    }
    a locala = new a();
    paramClass = (Class)localObject;
    if (((String)localObject).startsWith("["))
    {
      while (((String)localObject).charAt(0) == '[')
      {
        localObject = ((String)localObject).substring(1);
        locala.bdU("[]");
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
    if (NSW.containsKey(paramClass)) {
      localObject = (String)NSW.get(paramClass);
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
      AppMethodBeat.o(40701);
      return paramClass;
      i = j + 1;
    }
  }
  
  private static Class bdI(String paramString)
  {
    AppMethodBeat.i(40702);
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(40702);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      paramString = new NoClassDefFoundError(paramString.getMessage());
      AppMethodBeat.o(40702);
      throw paramString;
    }
  }
  
  private static void nK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40700);
    NSV.put(paramString1, paramString2);
    NSW.put(paramString2, paramString1);
    AppMethodBeat.o(40700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.b
 * JD-Core Version:    0.7.0.1
 */