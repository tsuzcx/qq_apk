package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.b.c.a;

public final class b
{
  public static final String OpX;
  public static final String OpY;
  private static final Map OpZ;
  private static final Map Oqa;
  private static final Map Oqb;
  private static final Map Oqc;
  static Class Oqd;
  static Class Oqe;
  static Class Oqf;
  static Class Oqg;
  static Class Oqh;
  static Class Oqi;
  static Class Oqj;
  static Class Oqk;
  
  static
  {
    AppMethodBeat.i(40703);
    OpX = ".";
    OpY = "$";
    Object localObject2 = new HashMap();
    OpZ = (Map)localObject2;
    Class localClass = Boolean.TYPE;
    Object localObject1;
    if (Oqd == null)
    {
      localObject1 = bfm("java.lang.Boolean");
      Oqd = (Class)localObject1;
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = OpZ;
      localClass = Byte.TYPE;
      if (Oqe != null) {
        break label389;
      }
      localObject1 = bfm("java.lang.Byte");
      Oqe = (Class)localObject1;
      label80:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = OpZ;
      localClass = Character.TYPE;
      if (Oqf != null) {
        break label396;
      }
      localObject1 = bfm("java.lang.Character");
      Oqf = (Class)localObject1;
      label113:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = OpZ;
      localClass = Short.TYPE;
      if (Oqg != null) {
        break label403;
      }
      localObject1 = bfm("java.lang.Short");
      Oqg = (Class)localObject1;
      label146:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = OpZ;
      localClass = Integer.TYPE;
      if (Oqh != null) {
        break label410;
      }
      localObject1 = bfm("java.lang.Integer");
      Oqh = (Class)localObject1;
      label179:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = OpZ;
      localClass = Long.TYPE;
      if (Oqi != null) {
        break label417;
      }
      localObject1 = bfm("java.lang.Long");
      Oqi = (Class)localObject1;
      label212:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = OpZ;
      localClass = Double.TYPE;
      if (Oqj != null) {
        break label424;
      }
      localObject1 = bfm("java.lang.Double");
      Oqj = (Class)localObject1;
      label245:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = OpZ;
      localClass = Float.TYPE;
      if (Oqk != null) {
        break label431;
      }
      localObject1 = bfm("java.lang.Float");
      Oqk = (Class)localObject1;
    }
    for (;;)
    {
      ((Map)localObject2).put(localClass, localObject1);
      localObject1 = OpZ;
      localObject2 = Void.TYPE;
      ((Map)localObject1).put(localObject2, localObject2);
      Oqa = new HashMap();
      localObject1 = OpZ.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Class)((Iterator)localObject1).next();
        localClass = (Class)OpZ.get(localObject2);
        if (!localObject2.equals(localClass)) {
          Oqa.put(localClass, localObject2);
        }
      }
      localObject1 = Oqd;
      break;
      label389:
      localObject1 = Oqe;
      break label80;
      label396:
      localObject1 = Oqf;
      break label113;
      label403:
      localObject1 = Oqg;
      break label146;
      label410:
      localObject1 = Oqh;
      break label179;
      label417:
      localObject1 = Oqi;
      break label212;
      label424:
      localObject1 = Oqj;
      break label245;
      label431:
      localObject1 = Oqk;
    }
    Oqb = new HashMap();
    Oqc = new HashMap();
    nQ("int", "I");
    nQ("boolean", "Z");
    nQ("float", "F");
    nQ("long", "J");
    nQ("short", "S");
    nQ("byte", "B");
    nQ("double", "D");
    nQ("char", "C");
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
        locala.bfy("[]");
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
    if (Oqc.containsKey(paramClass)) {
      localObject = (String)Oqc.get(paramClass);
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
  
  private static Class bfm(String paramString)
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
  
  private static void nQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40700);
    Oqb.put(paramString1, paramString2);
    Oqc.put(paramString2, paramString1);
    AppMethodBeat.o(40700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.apache.commons.b.b
 * JD-Core Version:    0.7.0.1
 */