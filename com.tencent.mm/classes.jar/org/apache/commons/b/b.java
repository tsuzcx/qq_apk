package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.b.c.a;

public final class b
{
  public static final String KkJ;
  public static final String KkK;
  private static final Map KkL;
  private static final Map KkM;
  private static final Map KkN;
  private static final Map KkO;
  static Class KkP;
  static Class KkQ;
  static Class KkR;
  static Class KkS;
  static Class KkT;
  static Class KkU;
  static Class KkV;
  static Class KkW;
  
  static
  {
    AppMethodBeat.i(40703);
    KkJ = ".";
    KkK = "$";
    Object localObject2 = new HashMap();
    KkL = (Map)localObject2;
    Class localClass = Boolean.TYPE;
    Object localObject1;
    if (KkP == null)
    {
      localObject1 = aRo("java.lang.Boolean");
      KkP = (Class)localObject1;
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = KkL;
      localClass = Byte.TYPE;
      if (KkQ != null) {
        break label389;
      }
      localObject1 = aRo("java.lang.Byte");
      KkQ = (Class)localObject1;
      label80:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = KkL;
      localClass = Character.TYPE;
      if (KkR != null) {
        break label396;
      }
      localObject1 = aRo("java.lang.Character");
      KkR = (Class)localObject1;
      label113:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = KkL;
      localClass = Short.TYPE;
      if (KkS != null) {
        break label403;
      }
      localObject1 = aRo("java.lang.Short");
      KkS = (Class)localObject1;
      label146:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = KkL;
      localClass = Integer.TYPE;
      if (KkT != null) {
        break label410;
      }
      localObject1 = aRo("java.lang.Integer");
      KkT = (Class)localObject1;
      label179:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = KkL;
      localClass = Long.TYPE;
      if (KkU != null) {
        break label417;
      }
      localObject1 = aRo("java.lang.Long");
      KkU = (Class)localObject1;
      label212:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = KkL;
      localClass = Double.TYPE;
      if (KkV != null) {
        break label424;
      }
      localObject1 = aRo("java.lang.Double");
      KkV = (Class)localObject1;
      label245:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = KkL;
      localClass = Float.TYPE;
      if (KkW != null) {
        break label431;
      }
      localObject1 = aRo("java.lang.Float");
      KkW = (Class)localObject1;
    }
    for (;;)
    {
      ((Map)localObject2).put(localClass, localObject1);
      localObject1 = KkL;
      localObject2 = Void.TYPE;
      ((Map)localObject1).put(localObject2, localObject2);
      KkM = new HashMap();
      localObject1 = KkL.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Class)((Iterator)localObject1).next();
        localClass = (Class)KkL.get(localObject2);
        if (!localObject2.equals(localClass)) {
          KkM.put(localClass, localObject2);
        }
      }
      localObject1 = KkP;
      break;
      label389:
      localObject1 = KkQ;
      break label80;
      label396:
      localObject1 = KkR;
      break label113;
      label403:
      localObject1 = KkS;
      break label146;
      label410:
      localObject1 = KkT;
      break label179;
      label417:
      localObject1 = KkU;
      break label212;
      label424:
      localObject1 = KkV;
      break label245;
      label431:
      localObject1 = KkW;
    }
    KkN = new HashMap();
    KkO = new HashMap();
    mL("int", "I");
    mL("boolean", "Z");
    mL("float", "F");
    mL("long", "J");
    mL("short", "S");
    mL("byte", "B");
    mL("double", "D");
    mL("char", "C");
    AppMethodBeat.o(40703);
  }
  
  private static Class aRo(String paramString)
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
  
  public static String bz(Class paramClass)
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
        locala.aRA("[]");
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
    if (KkO.containsKey(paramClass)) {
      localObject = (String)KkO.get(paramClass);
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
  
  private static void mL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40700);
    KkN.put(paramString1, paramString2);
    KkO.put(paramString2, paramString1);
    AppMethodBeat.o(40700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.b
 * JD-Core Version:    0.7.0.1
 */