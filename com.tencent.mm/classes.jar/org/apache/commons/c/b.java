package org.apache.commons.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.c.c.a;

public final class b
{
  public static final String ajVe;
  public static final String ajVf;
  private static final Map ajVg;
  private static final Map ajVh;
  private static final Map ajVi;
  private static final Map ajVj;
  static Class ajVk;
  static Class ajVl;
  static Class ajVm;
  static Class ajVn;
  static Class ajVo;
  static Class ajVp;
  static Class ajVq;
  static Class ajVr;
  
  static
  {
    AppMethodBeat.i(40703);
    ajVe = ".";
    ajVf = "$";
    Object localObject2 = new HashMap();
    ajVg = (Map)localObject2;
    Class localClass = Boolean.TYPE;
    Object localObject1;
    if (ajVk == null)
    {
      localObject1 = bLa("java.lang.Boolean");
      ajVk = (Class)localObject1;
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = ajVg;
      localClass = Byte.TYPE;
      if (ajVl != null) {
        break label389;
      }
      localObject1 = bLa("java.lang.Byte");
      ajVl = (Class)localObject1;
      label80:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = ajVg;
      localClass = Character.TYPE;
      if (ajVm != null) {
        break label396;
      }
      localObject1 = bLa("java.lang.Character");
      ajVm = (Class)localObject1;
      label113:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = ajVg;
      localClass = Short.TYPE;
      if (ajVn != null) {
        break label403;
      }
      localObject1 = bLa("java.lang.Short");
      ajVn = (Class)localObject1;
      label146:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = ajVg;
      localClass = Integer.TYPE;
      if (ajVo != null) {
        break label410;
      }
      localObject1 = bLa("java.lang.Integer");
      ajVo = (Class)localObject1;
      label179:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = ajVg;
      localClass = Long.TYPE;
      if (ajVp != null) {
        break label417;
      }
      localObject1 = bLa("java.lang.Long");
      ajVp = (Class)localObject1;
      label212:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = ajVg;
      localClass = Double.TYPE;
      if (ajVq != null) {
        break label424;
      }
      localObject1 = bLa("java.lang.Double");
      ajVq = (Class)localObject1;
      label245:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = ajVg;
      localClass = Float.TYPE;
      if (ajVr != null) {
        break label431;
      }
      localObject1 = bLa("java.lang.Float");
      ajVr = (Class)localObject1;
    }
    for (;;)
    {
      ((Map)localObject2).put(localClass, localObject1);
      localObject1 = ajVg;
      localObject2 = Void.TYPE;
      ((Map)localObject1).put(localObject2, localObject2);
      ajVh = new HashMap();
      localObject1 = ajVg.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Class)((Iterator)localObject1).next();
        localClass = (Class)ajVg.get(localObject2);
        if (!localObject2.equals(localClass)) {
          ajVh.put(localClass, localObject2);
        }
      }
      localObject1 = ajVk;
      break;
      label389:
      localObject1 = ajVl;
      break label80;
      label396:
      localObject1 = ajVm;
      break label113;
      label403:
      localObject1 = ajVn;
      break label146;
      label410:
      localObject1 = ajVo;
      break label179;
      label417:
      localObject1 = ajVp;
      break label212;
      label424:
      localObject1 = ajVq;
      break label245;
      label431:
      localObject1 = ajVr;
    }
    ajVi = new HashMap();
    ajVj = new HashMap();
    rI("int", "I");
    rI("boolean", "Z");
    rI("float", "F");
    rI("long", "J");
    rI("short", "S");
    rI("byte", "B");
    rI("double", "D");
    rI("char", "C");
    AppMethodBeat.o(40703);
  }
  
  private static Class bLa(String paramString)
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
  
  public static String cP(Class paramClass)
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
        locala.bLo("[]");
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
    if (ajVj.containsKey(paramClass)) {
      localObject = (String)ajVj.get(paramClass);
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
  
  private static void rI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40700);
    ajVi.put(paramString1, paramString2);
    ajVj.put(paramString2, paramString1);
    AppMethodBeat.o(40700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.apache.commons.c.b
 * JD-Core Version:    0.7.0.1
 */