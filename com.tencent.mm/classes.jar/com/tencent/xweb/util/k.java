package com.tencent.xweb.util;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.xwalk.core.Log;

public final class k
{
  public static Object b(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(157010);
    try
    {
      paramString1 = Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass);
      paramString1.setAccessible(true);
      paramString1 = paramString1.invoke(null, paramVarArgs);
      AppMethodBeat.o(157010);
      return paramString1;
    }
    finally
    {
      Log.e("ReflectionUtils", "invokeStatic, error:".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(157010);
    }
    return null;
  }
  
  public static Object bId(String paramString)
  {
    AppMethodBeat.i(157011);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(157011);
      return null;
    }
    try
    {
      paramString = Class.forName(paramString).newInstance();
      AppMethodBeat.o(157011);
      return paramString;
    }
    finally
    {
      Log.e("ReflectionUtils", "instanceFromName, error:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(157011);
    }
    return null;
  }
  
  public static Object c(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(157013);
    if (paramObject == null)
    {
      AppMethodBeat.o(157013);
      return null;
    }
    try
    {
      Object localObject = paramObject.getClass();
      if (Build.VERSION.SDK_INT > 10) {}
      for (paramArrayOfClass = ((Class)localObject).getMethod(paramString, paramArrayOfClass);; paramArrayOfClass = ((Class)localObject).getDeclaredMethod(paramString, paramArrayOfClass))
      {
        paramArrayOfClass.setAccessible(true);
        localObject = paramVarArgs;
        if (paramVarArgs.length == 0) {
          localObject = null;
        }
        paramObject = paramArrayOfClass.invoke(paramObject, (Object[])localObject);
        AppMethodBeat.o(157013);
        return paramObject;
      }
      return null;
    }
    finally
    {
      Log.e("ReflectionUtils", "invokeInstance, error:".concat(String.valueOf(paramObject)));
      if ((paramObject.getCause() != null) && (paramObject.getCause().toString().contains("AuthenticationFail")))
      {
        paramObject = new String("AuthenticationFail");
        AppMethodBeat.o(157013);
        return paramObject;
      }
      if ((paramString == null) || ((!paramString.equalsIgnoreCase("canLoadX5Core")) && (!paramString.equalsIgnoreCase("initTesRuntimeEnvironment"))))
      {
        paramString = new StringWriter();
        paramObject.printStackTrace(new PrintWriter(paramString));
        Log.e("ReflectionUtils", "invokeInstance, error:" + paramString.toString());
        AppMethodBeat.o(157013);
        return null;
      }
      AppMethodBeat.o(157013);
    }
  }
  
  public static Object q(Object paramObject, String paramString)
  {
    AppMethodBeat.i(157012);
    paramObject = c(paramObject, paramString, null, new Object[0]);
    AppMethodBeat.o(157012);
    return paramObject;
  }
  
  public static Object rc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157009);
    try
    {
      paramString1 = Class.forName(paramString1).getMethod(paramString2, new Class[0]).invoke(null, new Object[0]);
      AppMethodBeat.o(157009);
      return paramString1;
    }
    finally
    {
      Log.e("ReflectionUtils", "invokeStatic, error:".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(157009);
    }
    return null;
  }
  
  public static Object rd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212649);
    try
    {
      paramString1 = Class.forName(paramString1).getField(paramString2).get(null);
      AppMethodBeat.o(212649);
      return paramString1;
    }
    finally
    {
      Log.e("ReflectionUtils", "getFieldStatic, error:".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(212649);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.util.k
 * JD-Core Version:    0.7.0.1
 */