package com.tencent.xweb.xwalk;

import android.support.annotation.Keep;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class JsClassUtils
{
  private static void getDescriptor(StringBuilder paramStringBuilder, Class<?> paramClass)
  {
    AppMethodBeat.i(4162);
    char c1;
    for (;;)
    {
      if (paramClass.isPrimitive())
      {
        if (paramClass == Integer.TYPE) {
          c1 = 'I';
        }
        for (;;)
        {
          paramStringBuilder.append(c1);
          AppMethodBeat.o(4162);
          return;
          if (paramClass == Void.TYPE) {
            c1 = 'V';
          } else if (paramClass == Boolean.TYPE) {
            c1 = 'Z';
          } else if (paramClass == Byte.TYPE) {
            c1 = 'B';
          } else if (paramClass == Character.TYPE) {
            c1 = 'C';
          } else if (paramClass == Short.TYPE) {
            c1 = 'S';
          } else if (paramClass == Double.TYPE) {
            c1 = 'D';
          } else if (paramClass == Float.TYPE) {
            c1 = 'F';
          } else {
            c1 = 'J';
          }
        }
      }
      if (!paramClass.isArray()) {
        break;
      }
      paramStringBuilder.append('[');
      paramClass = paramClass.getComponentType();
    }
    paramStringBuilder.append('L');
    paramClass = paramClass.getName();
    int j = paramClass.length();
    int i = 0;
    while (i < j)
    {
      char c2 = paramClass.charAt(i);
      c1 = c2;
      if (c2 == '.') {
        c1 = '/';
      }
      paramStringBuilder.append(c1);
      i += 1;
    }
    paramStringBuilder.append(';');
    AppMethodBeat.o(4162);
  }
  
  private static int getJavaType(Class<?> paramClass)
  {
    AppMethodBeat.i(4163);
    if (paramClass == Integer.TYPE)
    {
      AppMethodBeat.o(4163);
      return 5;
    }
    if (paramClass == Void.TYPE)
    {
      AppMethodBeat.o(4163);
      return 0;
    }
    if (paramClass == Boolean.TYPE)
    {
      AppMethodBeat.o(4163);
      return 1;
    }
    if (paramClass == Byte.TYPE)
    {
      AppMethodBeat.o(4163);
      return 3;
    }
    if (paramClass == Character.TYPE)
    {
      AppMethodBeat.o(4163);
      return 2;
    }
    if (paramClass == Short.TYPE)
    {
      AppMethodBeat.o(4163);
      return 4;
    }
    if (paramClass == Double.TYPE)
    {
      AppMethodBeat.o(4163);
      return 8;
    }
    if (paramClass == Float.TYPE)
    {
      AppMethodBeat.o(4163);
      return 6;
    }
    if (paramClass == Long.TYPE)
    {
      AppMethodBeat.o(4163);
      return 7;
    }
    if (paramClass.getCanonicalName().equals("java.lang.String"))
    {
      AppMethodBeat.o(4163);
      return 9;
    }
    AppMethodBeat.o(4163);
    return 10;
  }
  
  @Keep
  public static Method[] getJavascriptInterfaceMethod(Object paramObject)
  {
    AppMethodBeat.i(4159);
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramObject = paramObject.getClass().getMethods();
      int j = paramObject.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramObject[i];
        if (localObject.isAnnotationPresent(JavascriptInterface.class)) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject = (Method[])localArrayList.toArray(new Method[localArrayList.size()]);
      AppMethodBeat.o(4159);
    }
  }
  
  @Keep
  public static String getMethodName(Method paramMethod)
  {
    AppMethodBeat.i(4161);
    paramMethod = paramMethod.getName();
    AppMethodBeat.o(4161);
    return paramMethod;
  }
  
  @Keep
  public static String getMethodSignature(Method paramMethod)
  {
    AppMethodBeat.i(4160);
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    int i = 0;
    while (i < arrayOfClass.length)
    {
      getDescriptor(localStringBuilder, arrayOfClass[i]);
      i += 1;
    }
    localStringBuilder.append(')');
    getDescriptor(localStringBuilder, paramMethod.getReturnType());
    paramMethod = localStringBuilder.toString();
    AppMethodBeat.o(4160);
    return paramMethod;
  }
  
  @Keep
  public static int[] getMethodType(Method paramMethod)
  {
    int i = 0;
    AppMethodBeat.i(4164);
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int[] arrayOfInt = new int[arrayOfClass.length + 2];
    arrayOfInt[0] = arrayOfClass.length;
    arrayOfInt[1] = getJavaType(paramMethod.getReturnType());
    while (i < arrayOfClass.length)
    {
      arrayOfInt[(i + 2)] = getJavaType(arrayOfClass[i]);
      i += 1;
    }
    AppMethodBeat.o(4164);
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.JsClassUtils
 * JD-Core Version:    0.7.0.1
 */