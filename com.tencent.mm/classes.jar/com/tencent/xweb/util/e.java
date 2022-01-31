package com.tencent.xweb.util;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import org.xwalk.core.Log;

public final class e
{
  public static Object ayg(String paramString)
  {
    AppMethodBeat.i(4020);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(4020);
      return null;
    }
    try
    {
      paramString = Class.forName(paramString).newInstance();
      AppMethodBeat.o(4020);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(4020);
    }
    return null;
  }
  
  public static Object b(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(4019);
    try
    {
      paramString1 = Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass);
      paramString1.setAccessible(true);
      paramString1 = paramString1.invoke(null, paramVarArgs);
      AppMethodBeat.o(4019);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(4019);
    }
    return null;
  }
  
  public static Object c(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(4022);
    if (paramObject == null)
    {
      AppMethodBeat.o(4022);
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
        AppMethodBeat.o(4022);
        return paramObject;
      }
      return null;
    }
    catch (Throwable paramObject)
    {
      if ((paramObject.getCause() != null) && (paramObject.getCause().toString().contains("AuthenticationFail")))
      {
        paramObject = new String("AuthenticationFail");
        AppMethodBeat.o(4022);
        return paramObject;
      }
      if ((paramString == null) || ((!paramString.equalsIgnoreCase("canLoadX5Core")) && (!paramString.equalsIgnoreCase("initTesRuntimeEnvironment"))))
      {
        paramString = new StringWriter();
        paramObject.printStackTrace(new PrintWriter(paramString));
        Log.e("ReflectionUtils", "invokeInstance -- exceptions:" + paramString.toString());
        AppMethodBeat.o(4022);
        return null;
      }
      AppMethodBeat.o(4022);
    }
  }
  
  public static Object je(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4018);
    try
    {
      paramString1 = Class.forName(paramString1).getMethod(paramString2, new Class[0]).invoke(null, new Object[0]);
      AppMethodBeat.o(4018);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(4018);
    }
    return null;
  }
  
  public static Object o(Object paramObject, String paramString)
  {
    AppMethodBeat.i(4021);
    paramObject = c(paramObject, paramString, null, new Object[0]);
    AppMethodBeat.o(4021);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.util.e
 * JD-Core Version:    0.7.0.1
 */