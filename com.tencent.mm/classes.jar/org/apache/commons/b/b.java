package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.b.c.a;

public final class b
{
  public static final String UeV;
  public static final String UeW;
  private static final Map UeX;
  private static final Map UeY;
  private static final Map UeZ;
  private static final Map Ufa;
  static Class Ufb;
  static Class Ufc;
  static Class Ufd;
  static Class Ufe;
  static Class Uff;
  static Class Ufg;
  static Class Ufh;
  static Class Ufi;
  
  static
  {
    AppMethodBeat.i(40703);
    UeV = ".";
    UeW = "$";
    Object localObject2 = new HashMap();
    UeX = (Map)localObject2;
    Class localClass = Boolean.TYPE;
    Object localObject1;
    if (Ufb == null)
    {
      localObject1 = bvc("java.lang.Boolean");
      Ufb = (Class)localObject1;
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = UeX;
      localClass = Byte.TYPE;
      if (Ufc != null) {
        break label389;
      }
      localObject1 = bvc("java.lang.Byte");
      Ufc = (Class)localObject1;
      label80:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = UeX;
      localClass = Character.TYPE;
      if (Ufd != null) {
        break label396;
      }
      localObject1 = bvc("java.lang.Character");
      Ufd = (Class)localObject1;
      label113:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = UeX;
      localClass = Short.TYPE;
      if (Ufe != null) {
        break label403;
      }
      localObject1 = bvc("java.lang.Short");
      Ufe = (Class)localObject1;
      label146:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = UeX;
      localClass = Integer.TYPE;
      if (Uff != null) {
        break label410;
      }
      localObject1 = bvc("java.lang.Integer");
      Uff = (Class)localObject1;
      label179:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = UeX;
      localClass = Long.TYPE;
      if (Ufg != null) {
        break label417;
      }
      localObject1 = bvc("java.lang.Long");
      Ufg = (Class)localObject1;
      label212:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = UeX;
      localClass = Double.TYPE;
      if (Ufh != null) {
        break label424;
      }
      localObject1 = bvc("java.lang.Double");
      Ufh = (Class)localObject1;
      label245:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = UeX;
      localClass = Float.TYPE;
      if (Ufi != null) {
        break label431;
      }
      localObject1 = bvc("java.lang.Float");
      Ufi = (Class)localObject1;
    }
    for (;;)
    {
      ((Map)localObject2).put(localClass, localObject1);
      localObject1 = UeX;
      localObject2 = Void.TYPE;
      ((Map)localObject1).put(localObject2, localObject2);
      UeY = new HashMap();
      localObject1 = UeX.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Class)((Iterator)localObject1).next();
        localClass = (Class)UeX.get(localObject2);
        if (!localObject2.equals(localClass)) {
          UeY.put(localClass, localObject2);
        }
      }
      localObject1 = Ufb;
      break;
      label389:
      localObject1 = Ufc;
      break label80;
      label396:
      localObject1 = Ufd;
      break label113;
      label403:
      localObject1 = Ufe;
      break label146;
      label410:
      localObject1 = Uff;
      break label179;
      label417:
      localObject1 = Ufg;
      break label212;
      label424:
      localObject1 = Ufh;
      break label245;
      label431:
      localObject1 = Ufi;
    }
    UeZ = new HashMap();
    Ufa = new HashMap();
    oI("int", "I");
    oI("boolean", "Z");
    oI("float", "F");
    oI("long", "J");
    oI("short", "S");
    oI("byte", "B");
    oI("double", "D");
    oI("char", "C");
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
        locala.bvo("[]");
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
    if (Ufa.containsKey(paramClass)) {
      localObject = (String)Ufa.get(paramClass);
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
  
  private static Class bvc(String paramString)
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
  
  private static void oI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40700);
    UeZ.put(paramString1, paramString2);
    Ufa.put(paramString2, paramString1);
    AppMethodBeat.o(40700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.apache.commons.b.b
 * JD-Core Version:    0.7.0.1
 */