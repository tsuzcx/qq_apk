package com.tencent.tencentmap.mapsdk.a;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class al
{
  private static ClassLoader a = null;
  private static boolean b = true;
  
  public static Object a(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
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
            break label292;
          }
          paramString = Array.newInstance(Byte.class, 0);
        }
        else
        {
          if ("?".equals((String)paramString)) {
            break label292;
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
            label210:
            if (localObject2 == null) {
              break label253;
            }
          }
          label253:
          for (int j = 1;; j = 0)
          {
            if ((j & i) != 0) {
              ((Map)paramString).put(localObject1, localObject2);
            }
            localObject2 = null;
            localObject1 = null;
            break;
            i = 0;
            break label210;
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
    label292:
    for (;;)
    {
      break;
      return paramString;
    }
  }
  
  public static String a(ArrayList<String> paramArrayList)
  {
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
    return localStringBuffer.toString();
  }
  
  public static ArrayList<String> a(String paramString)
  {
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
    return localArrayList;
  }
  
  private static void a(ArrayList<String> paramArrayList, String paramString)
  {
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
  }
  
  public static Object b(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    Object localObject;
    if (paramString.equals("java.lang.Integer")) {
      localObject = Integer.valueOf(0);
    }
    do
    {
      return localObject;
      if (paramString.equals("java.lang.Boolean")) {
        return Boolean.valueOf(false);
      }
      if (paramString.equals("java.lang.Byte")) {
        return Byte.valueOf((byte)0);
      }
      if (paramString.equals("java.lang.Double")) {
        return Double.valueOf(0.0D);
      }
      if (paramString.equals("java.lang.Float")) {
        return Float.valueOf(0.0F);
      }
      if (paramString.equals("java.lang.Long")) {
        return Long.valueOf(0L);
      }
      if (paramString.equals("java.lang.Short")) {
        return Short.valueOf((short)0);
      }
      if (paramString.equals("java.lang.Character")) {
        throw new IllegalArgumentException("can not support java.lang.Character");
      }
      if (paramString.equals("java.lang.String")) {
        return "";
      }
      if (paramString.equals("java.util.List")) {
        return new ArrayList();
      }
      if (paramString.equals("java.util.Map")) {
        return new HashMap();
      }
      if (paramString.equals("Array")) {
        return "Array";
      }
      localObject = paramString;
    } while (paramString.equals("?"));
    if (paramClassLoader != null) {}
    for (;;)
    {
      try
      {
        paramString = Class.forName(paramString, paramBoolean, paramClassLoader);
        return paramString.getConstructor(new Class[0]).newInstance(new Object[0]);
      }
      catch (Exception paramString)
      {
        throw new bm(paramString);
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
    String str;
    if ((paramString.equals("java.lang.Integer")) || (paramString.equals("int"))) {
      str = "int32";
    }
    do
    {
      return str;
      if ((paramString.equals("java.lang.Boolean")) || (paramString.equals("boolean"))) {
        return "bool";
      }
      if ((paramString.equals("java.lang.Byte")) || (paramString.equals("byte"))) {
        return "char";
      }
      if ((paramString.equals("java.lang.Double")) || (paramString.equals("double"))) {
        return "double";
      }
      if ((paramString.equals("java.lang.Float")) || (paramString.equals("float"))) {
        return "float";
      }
      if ((paramString.equals("java.lang.Long")) || (paramString.equals("long"))) {
        return "int64";
      }
      if ((paramString.equals("java.lang.Short")) || (paramString.equals("short"))) {
        return "short";
      }
      if (paramString.equals("java.lang.Character")) {
        throw new IllegalArgumentException("can not support java.lang.Character");
      }
      if (paramString.equals("java.lang.String")) {
        return "string";
      }
      if (paramString.equals("java.util.List")) {
        return "list";
      }
      str = paramString;
    } while (!paramString.equals("java.util.Map"));
    return "map";
  }
  
  public static String c(String paramString)
  {
    String str;
    if (paramString.equals("int32")) {
      str = "java.lang.Integer";
    }
    do
    {
      return str;
      if (paramString.equals("bool")) {
        return "java.lang.Boolean";
      }
      if (paramString.equals("char")) {
        return "java.lang.Byte";
      }
      if (paramString.equals("double")) {
        return "java.lang.Double";
      }
      if (paramString.equals("float")) {
        return "java.lang.Float";
      }
      if (paramString.equals("int64")) {
        return "java.lang.Long";
      }
      if (paramString.equals("short")) {
        return "java.lang.Short";
      }
      if (paramString.equals("string")) {
        return "java.lang.String";
      }
      if (paramString.equals("list")) {
        return "java.util.List";
      }
      str = paramString;
    } while (!paramString.equals("map"));
    return "java.util.Map";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.al
 * JD-Core Version:    0.7.0.1
 */