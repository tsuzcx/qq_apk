package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a
{
  private static ClassLoader a = null;
  private static boolean b = true;
  
  public static Object a(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(98400);
    Iterator localIterator = a(paramString).iterator();
    paramString = null;
    Object localObject2 = null;
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      paramString = b((String)localIterator.next(), paramBoolean, paramClassLoader);
      String str;
      if ((paramString instanceof String))
      {
        if ("Array".equals((String)paramString))
        {
          if (localObject1 != null) {
            break label302;
          }
          paramString = Array.newInstance(Byte.class, 0);
        }
        else
        {
          if ("?".equals((String)paramString)) {
            break label302;
          }
          if (localObject1 == null)
          {
            localObject1 = paramString;
            str = paramString;
            paramString = (String)localObject1;
            localObject1 = str;
          }
          else
          {
            localObject2 = paramString;
            str = paramString;
            paramString = (String)localObject2;
            localObject2 = localObject1;
            localObject1 = str;
          }
        }
      }
      else if ((paramString instanceof List))
      {
        if ((localObject1 != null) && ((localObject1 instanceof Byte)))
        {
          paramString = Array.newInstance(Byte.class, 1);
          Array.set(paramString, 0, localObject1);
        }
        else
        {
          if (localObject1 != null) {
            ((List)paramString).add(localObject1);
          }
          localObject1 = null;
        }
      }
      else
      {
        if ((paramString instanceof Map))
        {
          int i;
          if (localObject1 != null)
          {
            i = 1;
            label215:
            if (localObject2 == null) {
              break label258;
            }
          }
          label258:
          for (int j = 1;; j = 0)
          {
            if ((j & i) != 0) {
              ((Map)paramString).put(localObject1, localObject2);
            }
            localObject2 = null;
            localObject1 = null;
            break;
            i = 0;
            break label215;
          }
        }
        if (localObject1 == null)
        {
          localObject1 = paramString;
          str = paramString;
          paramString = (String)localObject1;
          localObject1 = str;
        }
        else
        {
          localObject2 = localObject1;
          localObject1 = paramString;
        }
      }
    }
    label302:
    for (;;)
    {
      break;
      AppMethodBeat.o(98400);
      return paramString;
    }
  }
  
  public static String a(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(98399);
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayList.size())
    {
      paramArrayList.set(i, b((String)paramArrayList.get(i)));
      i += 1;
    }
    Collections.reverse(paramArrayList);
    i = 0;
    if (i < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i);
      if (str.equals("list"))
      {
        paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1));
        paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
      }
      for (;;)
      {
        i += 1;
        break;
        if (str.equals("map"))
        {
          paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1) + ",");
          paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
        }
        else if (str.equals("Array"))
        {
          paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1));
          paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
        }
      }
    }
    Collections.reverse(paramArrayList);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localStringBuffer.append((String)paramArrayList.next());
    }
    paramArrayList = localStringBuffer.toString();
    AppMethodBeat.o(98399);
    return paramArrayList;
  }
  
  public static ArrayList<String> a(String paramString)
  {
    AppMethodBeat.i(98398);
    ArrayList localArrayList = new ArrayList();
    int j = paramString.indexOf("<");
    int m = 0;
    while (m < j)
    {
      a(localArrayList, paramString.substring(m, j));
      int n = j + 1;
      j = paramString.indexOf("<", n);
      int k = paramString.indexOf(",", n);
      int i = j;
      if (j == -1) {
        i = k;
      }
      j = i;
      m = n;
      if (k != -1)
      {
        j = i;
        m = n;
        if (k < i)
        {
          j = k;
          m = n;
        }
      }
    }
    a(localArrayList, paramString.substring(m, paramString.length()));
    AppMethodBeat.o(98398);
    return localArrayList;
  }
  
  private static void a(ArrayList<String> paramArrayList, String paramString)
  {
    AppMethodBeat.i(98397);
    int i = paramString.length();
    int j;
    do
    {
      j = i;
      if (paramString.charAt(i - 1) != '>') {
        break;
      }
      j = i - 1;
      i = j;
    } while (j != 0);
    paramArrayList.add(0, c(paramString.substring(0, j)));
    AppMethodBeat.o(98397);
  }
  
  public static Object b(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(98401);
    if (paramString.equals("java.lang.Integer"))
    {
      AppMethodBeat.o(98401);
      return Integer.valueOf(0);
    }
    if (paramString.equals("java.lang.Boolean"))
    {
      paramString = Boolean.FALSE;
      AppMethodBeat.o(98401);
      return paramString;
    }
    if (paramString.equals("java.lang.Byte"))
    {
      AppMethodBeat.o(98401);
      return Byte.valueOf((byte)0);
    }
    if (paramString.equals("java.lang.Double"))
    {
      AppMethodBeat.o(98401);
      return Double.valueOf(0.0D);
    }
    if (paramString.equals("java.lang.Float"))
    {
      AppMethodBeat.o(98401);
      return Float.valueOf(0.0F);
    }
    if (paramString.equals("java.lang.Long"))
    {
      AppMethodBeat.o(98401);
      return Long.valueOf(0L);
    }
    if (paramString.equals("java.lang.Short"))
    {
      AppMethodBeat.o(98401);
      return Short.valueOf((short)0);
    }
    if (paramString.equals("java.lang.Character"))
    {
      paramString = new IllegalArgumentException("can not support java.lang.Character");
      AppMethodBeat.o(98401);
      throw paramString;
    }
    if (paramString.equals("java.lang.String"))
    {
      AppMethodBeat.o(98401);
      return "";
    }
    if (paramString.equals("java.util.List"))
    {
      paramString = new ArrayList();
      AppMethodBeat.o(98401);
      return paramString;
    }
    if (paramString.equals("java.util.Map"))
    {
      paramString = new HashMap();
      AppMethodBeat.o(98401);
      return paramString;
    }
    if (paramString.equals("Array"))
    {
      AppMethodBeat.o(98401);
      return "Array";
    }
    if (paramString.equals("?"))
    {
      AppMethodBeat.o(98401);
      return paramString;
    }
    if (paramClassLoader != null) {}
    for (;;)
    {
      try
      {
        paramString = Class.forName(paramString, paramBoolean, paramClassLoader);
        paramString = paramString.getConstructor(new Class[0]).newInstance(new Object[0]);
        AppMethodBeat.o(98401);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString = new b(paramString);
        AppMethodBeat.o(98401);
        throw paramString;
      }
      if (a != null) {
        paramString = Class.forName(paramString, b, a);
      } else {
        paramString = Class.forName(paramString);
      }
    }
  }
  
  public static String b(String paramString)
  {
    AppMethodBeat.i(98402);
    if ((paramString.equals("java.lang.Integer")) || (paramString.equals("int")))
    {
      AppMethodBeat.o(98402);
      return "int32";
    }
    if ((paramString.equals("java.lang.Boolean")) || (paramString.equals("boolean")))
    {
      AppMethodBeat.o(98402);
      return "bool";
    }
    if ((paramString.equals("java.lang.Byte")) || (paramString.equals("byte")))
    {
      AppMethodBeat.o(98402);
      return "char";
    }
    if ((paramString.equals("java.lang.Double")) || (paramString.equals("double")))
    {
      AppMethodBeat.o(98402);
      return "double";
    }
    if ((paramString.equals("java.lang.Float")) || (paramString.equals("float")))
    {
      AppMethodBeat.o(98402);
      return "float";
    }
    if ((paramString.equals("java.lang.Long")) || (paramString.equals("long")))
    {
      AppMethodBeat.o(98402);
      return "int64";
    }
    if ((paramString.equals("java.lang.Short")) || (paramString.equals("short")))
    {
      AppMethodBeat.o(98402);
      return "short";
    }
    if (paramString.equals("java.lang.Character"))
    {
      paramString = new IllegalArgumentException("can not support java.lang.Character");
      AppMethodBeat.o(98402);
      throw paramString;
    }
    if (paramString.equals("java.lang.String"))
    {
      AppMethodBeat.o(98402);
      return "string";
    }
    if (paramString.equals("java.util.List"))
    {
      AppMethodBeat.o(98402);
      return "list";
    }
    if (paramString.equals("java.util.Map"))
    {
      AppMethodBeat.o(98402);
      return "map";
    }
    AppMethodBeat.o(98402);
    return paramString;
  }
  
  public static String c(String paramString)
  {
    AppMethodBeat.i(98403);
    if (paramString.equals("int32"))
    {
      AppMethodBeat.o(98403);
      return "java.lang.Integer";
    }
    if (paramString.equals("bool"))
    {
      AppMethodBeat.o(98403);
      return "java.lang.Boolean";
    }
    if (paramString.equals("char"))
    {
      AppMethodBeat.o(98403);
      return "java.lang.Byte";
    }
    if (paramString.equals("double"))
    {
      AppMethodBeat.o(98403);
      return "java.lang.Double";
    }
    if (paramString.equals("float"))
    {
      AppMethodBeat.o(98403);
      return "java.lang.Float";
    }
    if (paramString.equals("int64"))
    {
      AppMethodBeat.o(98403);
      return "java.lang.Long";
    }
    if (paramString.equals("short"))
    {
      AppMethodBeat.o(98403);
      return "java.lang.Short";
    }
    if (paramString.equals("string"))
    {
      AppMethodBeat.o(98403);
      return "java.lang.String";
    }
    if (paramString.equals("list"))
    {
      AppMethodBeat.o(98403);
      return "java.util.List";
    }
    if (paramString.equals("map"))
    {
      AppMethodBeat.o(98403);
      return "java.util.Map";
    }
    AppMethodBeat.o(98403);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.a
 * JD-Core Version:    0.7.0.1
 */