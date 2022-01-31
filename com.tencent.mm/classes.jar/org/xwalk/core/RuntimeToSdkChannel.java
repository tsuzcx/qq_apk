package org.xwalk.core;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.util.e;

public class RuntimeToSdkChannel
{
  public static final String KEY_GET_CONFIG_CMD = "GET_CONFIG_CMD";
  public static final String KEY_INVOKE_METHOD = "INVOKE_INSTANCE_METHOD";
  public static final String KEY_REPORT_JAVA_EXCEPTION = "REPORT_JAVA_EXCEPTION";
  public static final String KEY_STATIC_METHOD = "INVOKE_STATIC_METHOD";
  
  /* Error */
  public static void initRuntimeToSdkChannel()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 24
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 36	org/xwalk/core/XWalkCoreWrapper:getInstance	()Lorg/xwalk/core/XWalkCoreWrapper;
    //   11: ifnonnull +12 -> 23
    //   14: ldc 24
    //   16: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 36	org/xwalk/core/XWalkCoreWrapper:getInstance	()Lorg/xwalk/core/XWalkCoreWrapper;
    //   26: pop
    //   27: ldc 40
    //   29: iconst_1
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: new 42	org/xwalk/core/RuntimeToSdkChannel$1
    //   38: dup
    //   39: invokespecial 43	org/xwalk/core/RuntimeToSdkChannel$1:<init>	()V
    //   42: aastore
    //   43: invokestatic 47	org/xwalk/core/XWalkCoreWrapper:invokeRuntimeChannel	(I[Ljava/lang/Object;)Ljava/lang/Object;
    //   46: pop
    //   47: ldc 24
    //   49: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -33 -> 19
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   55	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	55	finally
    //   23	52	55	finally
  }
  
  public static Object onRuntimeCalled(String paramString, Object paramObject)
  {
    AppMethodBeat.i(85524);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(85524);
        return null;
        if (paramString.equals("GET_CONFIG_CMD"))
        {
          i = 0;
          continue;
          if (paramString.equals("INVOKE_INSTANCE_METHOD"))
          {
            i = 1;
            continue;
            if (paramString.equals("INVOKE_STATIC_METHOD"))
            {
              i = 2;
              continue;
              if (paramString.equals("REPORT_JAVA_EXCEPTION")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    if (!(paramObject instanceof String[]))
    {
      AppMethodBeat.o(85524);
      return "";
    }
    paramString = (String[])paramObject;
    if (paramString.length < 2)
    {
      AppMethodBeat.o(85524);
      return "";
    }
    if (TextUtils.isEmpty(paramString[1]))
    {
      paramString = a.axN(paramString[0]);
      AppMethodBeat.o(85524);
      return paramString;
    }
    paramString = a.iW(paramString[0], paramString[1]);
    AppMethodBeat.o(85524);
    return paramString;
    if (!(paramObject instanceof Object[]))
    {
      AppMethodBeat.o(85524);
      return null;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject == null) || (paramObject.length < 2))
    {
      AppMethodBeat.o(85524);
      return null;
    }
    if (!(paramObject[0] instanceof Object))
    {
      AppMethodBeat.o(85524);
      return null;
    }
    if (!(paramObject[1] instanceof String))
    {
      AppMethodBeat.o(85524);
      return null;
    }
    paramString = paramObject[0];
    if ((paramObject[0] instanceof String)) {
      paramString = e.ayg((String)paramObject[0]);
    }
    for (;;)
    {
      if (paramString == null)
      {
        AppMethodBeat.o(85524);
        return null;
      }
      String str = (String)paramObject[1];
      if (2 == paramObject.length)
      {
        paramString = e.o(paramString, str);
        AppMethodBeat.o(85524);
        return paramString;
      }
      if (4 == paramObject.length)
      {
        if (!(paramObject[2] instanceof Class[]))
        {
          paramString = e.o(paramString, str);
          AppMethodBeat.o(85524);
          return paramString;
        }
        if (!(paramObject[3] instanceof Object[]))
        {
          paramString = e.o(paramString, str);
          AppMethodBeat.o(85524);
          return paramString;
        }
        paramString = e.c(paramString, str, (Class[])paramObject[2], (Object[])paramObject[3]);
        AppMethodBeat.o(85524);
        return paramString;
      }
      paramString = e.o(paramString, str);
      AppMethodBeat.o(85524);
      return paramString;
      if (!(paramObject instanceof Object[]))
      {
        AppMethodBeat.o(85524);
        return null;
      }
      paramString = (Object[])paramObject;
      if ((paramString == null) || (paramString.length < 2))
      {
        AppMethodBeat.o(85524);
        return null;
      }
      if (!(paramString[0] instanceof String))
      {
        AppMethodBeat.o(85524);
        return null;
      }
      if (!(paramString[1] instanceof String))
      {
        AppMethodBeat.o(85524);
        return null;
      }
      paramObject = (String)paramString[0];
      str = (String)paramString[1];
      if (2 == paramString.length)
      {
        paramString = e.je(paramObject, str);
        AppMethodBeat.o(85524);
        return paramString;
      }
      if (4 == paramString.length)
      {
        if (!(paramString[2] instanceof Class[]))
        {
          paramString = e.je(paramObject, str);
          AppMethodBeat.o(85524);
          return paramString;
        }
        if (!(paramString[3] instanceof Object[]))
        {
          paramString = e.je(paramObject, str);
          AppMethodBeat.o(85524);
          return paramString;
        }
        paramString = e.b(paramObject, str, (Class[])paramString[2], (Object[])paramString[3]);
        AppMethodBeat.o(85524);
        return paramString;
      }
      paramString = e.o(paramObject, str);
      AppMethodBeat.o(85524);
      return paramString;
      if (!(paramObject instanceof Object[]))
      {
        AppMethodBeat.o(85524);
        return null;
      }
      paramString = (Object[])paramObject;
      if (paramString.length <= 0)
      {
        AppMethodBeat.o(85524);
        return null;
      }
      if (!(paramString[0] instanceof Throwable))
      {
        AppMethodBeat.o(85524);
        return null;
      }
      paramString = (Throwable)paramString[0];
      Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), paramString);
      AppMethodBeat.o(85524);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.RuntimeToSdkChannel
 * JD-Core Version:    0.7.0.1
 */