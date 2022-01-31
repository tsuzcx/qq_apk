package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

public class r
{
  public static Object a(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(65287);
    try
    {
      paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
      paramClass.setAccessible(true);
      paramClass = paramClass.invoke(null, paramVarArgs);
      AppMethodBeat.o(65287);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      TbsLog.addLog(997, String.valueOf(paramClass), new Object[0]);
      AppMethodBeat.o(65287);
    }
    return null;
  }
  
  public static Object a(Object paramObject, String paramString)
  {
    AppMethodBeat.i(65288);
    paramObject = a(paramObject, paramString, null, new Object[0]);
    AppMethodBeat.o(65288);
    return paramObject;
  }
  
  public static Object a(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(65289);
    if (paramObject == null)
    {
      AppMethodBeat.o(65289);
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
        AppMethodBeat.o(65289);
        return paramObject;
      }
      return null;
    }
    catch (Throwable paramObject)
    {
      TbsLog.addLog(997, String.valueOf(paramObject), new Object[0]);
      if ((paramObject.getCause() != null) && (paramObject.getCause().toString().contains("AuthenticationFail")))
      {
        paramObject = new String("AuthenticationFail");
        AppMethodBeat.o(65289);
        return paramObject;
      }
      if ((paramString != null) && ((paramString.equalsIgnoreCase("canLoadX5Core")) || (paramString.equalsIgnoreCase("initTesRuntimeEnvironment"))))
      {
        AppMethodBeat.o(65289);
        return null;
      }
      paramString = new StringWriter();
      paramObject.printStackTrace(new PrintWriter(paramString));
      new StringBuilder("invokeInstance -- exceptions:").append(paramString.toString());
      AppMethodBeat.o(65289);
    }
  }
  
  public static Object a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65286);
    try
    {
      paramString1 = Class.forName(paramString1).getMethod(paramString2, new Class[0]).invoke(null, new Object[0]);
      AppMethodBeat.o(65286);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      TbsLog.addLog(997, String.valueOf(paramString1), new Object[0]);
      AppMethodBeat.o(65286);
    }
    return null;
  }
  
  public static Method a(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(65290);
    paramObject = paramObject.getClass();
    while (paramObject != Object.class)
    {
      if (paramObject == null)
      {
        AppMethodBeat.o(65290);
        return null;
      }
      try
      {
        Method localMethod = paramObject.getDeclaredMethod(paramString, paramVarArgs);
        AppMethodBeat.o(65290);
        return localMethod;
      }
      catch (Exception localException)
      {
        paramObject = paramObject.getSuperclass();
      }
    }
    AppMethodBeat.o(65290);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.utils.r
 * JD-Core Version:    0.7.0.1
 */