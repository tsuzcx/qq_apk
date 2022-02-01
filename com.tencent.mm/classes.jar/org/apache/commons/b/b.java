package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.b.c.a;

public final class b
{
  public static final String abIj;
  public static final String abIk;
  private static final Map abIl;
  private static final Map abIm;
  private static final Map abIn;
  private static final Map abIo;
  static Class abIp;
  static Class abIq;
  static Class abIr;
  static Class abIs;
  static Class abIt;
  static Class abIu;
  static Class abIv;
  static Class abIw;
  
  static
  {
    AppMethodBeat.i(40703);
    abIj = ".";
    abIk = "$";
    Object localObject2 = new HashMap();
    abIl = (Map)localObject2;
    Class localClass = Boolean.TYPE;
    Object localObject1;
    if (abIp == null)
    {
      localObject1 = bIg("java.lang.Boolean");
      abIp = (Class)localObject1;
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = abIl;
      localClass = Byte.TYPE;
      if (abIq != null) {
        break label389;
      }
      localObject1 = bIg("java.lang.Byte");
      abIq = (Class)localObject1;
      label80:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = abIl;
      localClass = Character.TYPE;
      if (abIr != null) {
        break label396;
      }
      localObject1 = bIg("java.lang.Character");
      abIr = (Class)localObject1;
      label113:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = abIl;
      localClass = Short.TYPE;
      if (abIs != null) {
        break label403;
      }
      localObject1 = bIg("java.lang.Short");
      abIs = (Class)localObject1;
      label146:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = abIl;
      localClass = Integer.TYPE;
      if (abIt != null) {
        break label410;
      }
      localObject1 = bIg("java.lang.Integer");
      abIt = (Class)localObject1;
      label179:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = abIl;
      localClass = Long.TYPE;
      if (abIu != null) {
        break label417;
      }
      localObject1 = bIg("java.lang.Long");
      abIu = (Class)localObject1;
      label212:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = abIl;
      localClass = Double.TYPE;
      if (abIv != null) {
        break label424;
      }
      localObject1 = bIg("java.lang.Double");
      abIv = (Class)localObject1;
      label245:
      ((Map)localObject2).put(localClass, localObject1);
      localObject2 = abIl;
      localClass = Float.TYPE;
      if (abIw != null) {
        break label431;
      }
      localObject1 = bIg("java.lang.Float");
      abIw = (Class)localObject1;
    }
    for (;;)
    {
      ((Map)localObject2).put(localClass, localObject1);
      localObject1 = abIl;
      localObject2 = Void.TYPE;
      ((Map)localObject1).put(localObject2, localObject2);
      abIm = new HashMap();
      localObject1 = abIl.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Class)((Iterator)localObject1).next();
        localClass = (Class)abIl.get(localObject2);
        if (!localObject2.equals(localClass)) {
          abIm.put(localClass, localObject2);
        }
      }
      localObject1 = abIp;
      break;
      label389:
      localObject1 = abIq;
      break label80;
      label396:
      localObject1 = abIr;
      break label113;
      label403:
      localObject1 = abIs;
      break label146;
      label410:
      localObject1 = abIt;
      break label179;
      label417:
      localObject1 = abIu;
      break label212;
      label424:
      localObject1 = abIv;
      break label245;
      label431:
      localObject1 = abIw;
    }
    abIn = new HashMap();
    abIo = new HashMap();
    pE("int", "I");
    pE("boolean", "Z");
    pE("float", "F");
    pE("long", "J");
    pE("short", "S");
    pE("byte", "B");
    pE("double", "D");
    pE("char", "C");
    AppMethodBeat.o(40703);
  }
  
  private static Class bIg(String paramString)
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
  
  public static String cd(Class paramClass)
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
        locala.bIt("[]");
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
    if (abIo.containsKey(paramClass)) {
      localObject = (String)abIo.get(paramClass);
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
  
  private static void pE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40700);
    abIn.put(paramString1, paramString2);
    abIo.put(paramString2, paramString1);
    AppMethodBeat.o(40700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.b
 * JD-Core Version:    0.7.0.1
 */