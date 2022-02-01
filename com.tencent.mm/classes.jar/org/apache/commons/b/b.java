package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.b.c.a;

public final class b
{
  static Class LYA;
  static Class LYB;
  static Class LYC;
  static Class LYD;
  static Class LYE;
  static Class LYF;
  public static final String LYs;
  public static final String LYt;
  private static final Map LYu;
  private static final Map LYv;
  private static final Map LYw;
  private static final Map LYx;
  static Class LYy;
  static Class LYz;
  
  static
  {
    AppMethodBeat.i(40703);
    LYs = ".";
    LYt = "$";
    Object localObject2 = new HashMap();
    LYu = (Map)localObject2;
    Class localClass = Boolean.TYPE;
    Object localObject1;
    if (LYy == null)
    {
      localObject1 = aXo("java.lang.Boolean");
      LYy = (Class)localObject1;
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = LYu;
      localClass = Byte.TYPE;
      if (LYz != null) {
        break label389;
      }
      localObject1 = aXo("java.lang.Byte");
      LYz = (Class)localObject1;
      label80:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = LYu;
      localClass = Character.TYPE;
      if (LYA != null) {
        break label396;
      }
      localObject1 = aXo("java.lang.Character");
      LYA = (Class)localObject1;
      label113:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = LYu;
      localClass = Short.TYPE;
      if (LYB != null) {
        break label403;
      }
      localObject1 = aXo("java.lang.Short");
      LYB = (Class)localObject1;
      label146:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = LYu;
      localClass = Integer.TYPE;
      if (LYC != null) {
        break label410;
      }
      localObject1 = aXo("java.lang.Integer");
      LYC = (Class)localObject1;
      label179:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = LYu;
      localClass = Long.TYPE;
      if (LYD != null) {
        break label417;
      }
      localObject1 = aXo("java.lang.Long");
      LYD = (Class)localObject1;
      label212:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = LYu;
      localClass = Double.TYPE;
      if (LYE != null) {
        break label424;
      }
      localObject1 = aXo("java.lang.Double");
      LYE = (Class)localObject1;
      label245:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = LYu;
      localClass = Float.TYPE;
      if (LYF != null) {
        break label431;
      }
      localObject1 = aXo("java.lang.Float");
      LYF = (Class)localObject1;
    }
    for (;;)
    {
      ((Map)localObject2).put(localClass, localObject1);
      localObject1 = LYu;
      localObject2 = Void.TYPE;
      ((Map)localObject1).put(localObject2, localObject2);
      LYv = new HashMap();
      localObject1 = LYu.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Class)((Iterator)localObject1).next();
        localClass = (Class)LYu.get(localObject2);
        if (!localObject2.equals(localClass)) {
          LYv.put(localClass, localObject2);
        }
      }
      localObject1 = LYy;
      break;
      label389:
      localObject1 = LYz;
      break label80;
      label396:
      localObject1 = LYA;
      break label113;
      label403:
      localObject1 = LYB;
      break label146;
      label410:
      localObject1 = LYC;
      break label179;
      label417:
      localObject1 = LYD;
      break label212;
      label424:
      localObject1 = LYE;
      break label245;
      label431:
      localObject1 = LYF;
    }
    LYw = new HashMap();
    LYx = new HashMap();
    nl("int", "I");
    nl("boolean", "Z");
    nl("float", "F");
    nl("long", "J");
    nl("short", "S");
    nl("byte", "B");
    nl("double", "D");
    nl("char", "C");
    AppMethodBeat.o(40703);
  }
  
  private static Class aXo(String paramString)
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
  
  public static String bC(Class paramClass)
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
        locala.aXA("[]");
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
    if (LYx.containsKey(paramClass)) {
      localObject = (String)LYx.get(paramClass);
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
  
  private static void nl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40700);
    LYw.put(paramString1, paramString2);
    LYx.put(paramString2, paramString1);
    AppMethodBeat.o(40700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.apache.commons.b.b
 * JD-Core Version:    0.7.0.1
 */