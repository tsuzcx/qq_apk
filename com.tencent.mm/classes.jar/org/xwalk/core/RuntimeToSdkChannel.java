package org.xwalk.core;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.b;
import com.tencent.xweb.m;
import com.tencent.xweb.pinus.e;
import com.tencent.xweb.util.k;
import com.tencent.xweb.xwalk.r;
import com.tencent.xweb.xwalk.r.a;
import java.util.Arrays;
import java.util.concurrent.ConcurrentMap;

public class RuntimeToSdkChannel
{
  public static final String KEY_GET_CONFIG_CMD = "GET_CONFIG_CMD";
  public static final String KEY_GET_CONFIG_CMD_EXTEND = "GET_CONFIG_CMD_EXTEND";
  public static final String KEY_INVOKE_METHOD = "INVOKE_INSTANCE_METHOD";
  public static final String KEY_REPORT_JAVA_EXCEPTION = "REPORT_JAVA_EXCEPTION";
  public static final String KEY_STATIC_METHOD = "INVOKE_STATIC_METHOD";
  public static final String KEY_XPROFILE_RESULT_FORWARD_TO_SDK = "KEY_XPROFILE_RESULT_FORWARD_TO_SDK";
  public static final String KEY_XPROFILE_TRACING_FRAME_COST_RESULT = "KEY_XPROFILE_TRACING_FRAME_COST_RESULT";
  private static final String TAG = "RuntimeToSdkChannel";
  
  private static Object[] createRuntimeToSdkChannelObject()
  {
    AppMethodBeat.i(187746);
    ValueCallback local1 = new ValueCallback()
    {
      public void onReceiveValue(Object paramAnonymousObject)
      {
        AppMethodBeat.i(154612);
        if (!(paramAnonymousObject instanceof Object[]))
        {
          Log.w("RuntimeToSdkChannel", "RuntimeToSdkChannel, invalid args");
          AppMethodBeat.o(154612);
          return;
        }
        paramAnonymousObject = (Object[])paramAnonymousObject;
        if (paramAnonymousObject.length < 3)
        {
          Log.w("RuntimeToSdkChannel", "RuntimeToSdkChannel, invalid args length");
          AppMethodBeat.o(154612);
          return;
        }
        if (!(paramAnonymousObject[0] instanceof String))
        {
          Log.w("RuntimeToSdkChannel", "RuntimeToSdkChannel, invalid args[0]");
          AppMethodBeat.o(154612);
          return;
        }
        paramAnonymousObject[2] = RuntimeToSdkChannel.onRuntimeCalled((String)paramAnonymousObject[0], paramAnonymousObject[1]);
        AppMethodBeat.o(154612);
      }
    };
    AppMethodBeat.o(187746);
    return new Object[] { local1 };
  }
  
  public static boolean initPinusRuntimeToSdkChannel()
  {
    try
    {
      AppMethodBeat.i(187741);
      Log.i("RuntimeToSdkChannel", "initPinusRuntimeToSdkChannel start");
      e.khp().invokeRuntimeChannel(80005, createRuntimeToSdkChannelObject());
      AppMethodBeat.o(187741);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean initRuntimeToSdkChannel()
  {
    try
    {
      AppMethodBeat.i(187734);
      Log.i("RuntimeToSdkChannel", "initRuntimeToSdkChannel start");
      XWalkStandAloneChannel.getInstance().invokeRuntimeChannel(80005, createRuntimeToSdkChannelObject());
      AppMethodBeat.o(187734);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static Object onRuntimeCalled(String paramString, Object paramObject)
  {
    AppMethodBeat.i(154614);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(154614);
        return null;
        if (paramString.equals("GET_CONFIG_CMD"))
        {
          i = 0;
          continue;
          if (paramString.equals("GET_CONFIG_CMD_EXTEND"))
          {
            i = 1;
            continue;
            if (paramString.equals("INVOKE_INSTANCE_METHOD"))
            {
              i = 2;
              continue;
              if (paramString.equals("INVOKE_STATIC_METHOD"))
              {
                i = 3;
                continue;
                if (paramString.equals("REPORT_JAVA_EXCEPTION"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("KEY_XPROFILE_RESULT_FORWARD_TO_SDK"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("KEY_XPROFILE_TRACING_FRAME_COST_RESULT")) {
                      i = 6;
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    if (!(paramObject instanceof String[]))
    {
      Log.w("RuntimeToSdkChannel", "onRuntimeCalled, KEY_GET_CONFIG_CMD, invalid args");
      AppMethodBeat.o(154614);
      return "";
    }
    paramString = (String[])paramObject;
    if (paramString.length < 2)
    {
      Log.w("RuntimeToSdkChannel", "onRuntimeCalled, KEY_GET_CONFIG_CMD, invalid args length");
      AppMethodBeat.o(154614);
      return "";
    }
    if (TextUtils.isEmpty(paramString[1]))
    {
      paramString = a.keX().bHl(paramString[0]);
      AppMethodBeat.o(154614);
      return paramString;
    }
    paramString = a.keX().qM(paramString[0], paramString[1]);
    AppMethodBeat.o(154614);
    return paramString;
    if (!(paramObject instanceof String[]))
    {
      Log.w("RuntimeToSdkChannel", "onRuntimeCalled, KEY_GET_CONFIG_CMD_EXTEND, invalid args");
      AppMethodBeat.o(154614);
      return "";
    }
    paramString = (String[])paramObject;
    if (paramString.length < 2)
    {
      Log.w("RuntimeToSdkChannel", "onRuntimeCalled, KEY_GET_CONFIG_CMD_EXTEND, invalid args length");
      AppMethodBeat.o(154614);
      return "";
    }
    if (TextUtils.isEmpty(paramString[1]))
    {
      paramString = b.kfi().bHl(paramString[0]);
      AppMethodBeat.o(154614);
      return paramString;
    }
    paramString = b.kfi().qM(paramString[0], paramString[1]);
    AppMethodBeat.o(154614);
    return paramString;
    if (!(paramObject instanceof Object[]))
    {
      Log.w("RuntimeToSdkChannel", "onRuntimeCalled, KEY_INVOKE_METHOD, invalid args");
      AppMethodBeat.o(154614);
      return null;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject == null) || (paramObject.length < 2))
    {
      Log.w("RuntimeToSdkChannel", "onRuntimeCalled, KEY_INVOKE_METHOD, invalid args length");
      AppMethodBeat.o(154614);
      return null;
    }
    if (!(paramObject[0] instanceof Object))
    {
      Log.w("RuntimeToSdkChannel", "onRuntimeCalled, KEY_INVOKE_METHOD, invalid args[0]");
      AppMethodBeat.o(154614);
      return null;
    }
    if (!(paramObject[1] instanceof String))
    {
      Log.w("RuntimeToSdkChannel", "onRuntimeCalled, KEY_INVOKE_METHOD, invalid args[1]");
      AppMethodBeat.o(154614);
      return null;
    }
    paramString = paramObject[0];
    if ((paramObject[0] instanceof String)) {
      paramString = k.bId((String)paramObject[0]);
    }
    for (;;)
    {
      if (paramString == null)
      {
        Log.w("RuntimeToSdkChannel", "onRuntimeCalled, KEY_INVOKE_METHOD, instance is null");
        AppMethodBeat.o(154614);
        return null;
      }
      String str = (String)paramObject[1];
      if (2 == paramObject.length)
      {
        paramString = k.q(paramString, str);
        AppMethodBeat.o(154614);
        return paramString;
      }
      if (4 == paramObject.length)
      {
        if (!(paramObject[2] instanceof Class[]))
        {
          paramString = k.q(paramString, str);
          AppMethodBeat.o(154614);
          return paramString;
        }
        if (!(paramObject[3] instanceof Object[]))
        {
          paramString = k.q(paramString, str);
          AppMethodBeat.o(154614);
          return paramString;
        }
        paramString = k.c(paramString, str, (Class[])paramObject[2], (Object[])paramObject[3]);
        AppMethodBeat.o(154614);
        return paramString;
      }
      paramString = k.q(paramString, str);
      AppMethodBeat.o(154614);
      return paramString;
      if (!(paramObject instanceof Object[]))
      {
        Log.w("RuntimeToSdkChannel", "onRuntimeCalled, KEY_STATIC_METHOD, invalid args");
        AppMethodBeat.o(154614);
        return null;
      }
      paramString = (Object[])paramObject;
      if ((paramString == null) || (paramString.length < 2))
      {
        Log.w("RuntimeToSdkChannel", "onRuntimeCalled, KEY_STATIC_METHOD, invalid args length");
        AppMethodBeat.o(154614);
        return null;
      }
      if (!(paramString[0] instanceof String))
      {
        Log.w("RuntimeToSdkChannel", "onRuntimeCalled, KEY_STATIC_METHOD, invalid args[0]");
        AppMethodBeat.o(154614);
        return null;
      }
      if (!(paramString[1] instanceof String))
      {
        Log.w("RuntimeToSdkChannel", "onRuntimeCalled, KEY_STATIC_METHOD, invalid args[1]");
        AppMethodBeat.o(154614);
        return null;
      }
      paramObject = (String)paramString[0];
      str = (String)paramString[1];
      if (2 == paramString.length)
      {
        paramString = k.rc(paramObject, str);
        AppMethodBeat.o(154614);
        return paramString;
      }
      if (4 == paramString.length)
      {
        if (!(paramString[2] instanceof Class[]))
        {
          paramString = k.rc(paramObject, str);
          AppMethodBeat.o(154614);
          return paramString;
        }
        if (!(paramString[3] instanceof Object[]))
        {
          paramString = k.rc(paramObject, str);
          AppMethodBeat.o(154614);
          return paramString;
        }
        paramString = k.b(paramObject, str, (Class[])paramString[2], (Object[])paramString[3]);
        AppMethodBeat.o(154614);
        return paramString;
      }
      paramString = k.q(paramObject, str);
      AppMethodBeat.o(154614);
      return paramString;
      if (!(paramObject instanceof Object[]))
      {
        Log.w("RuntimeToSdkChannel", "onRuntimeCalled, KEY_REPORT_JAVA_EXCEPTION, invalid args");
        AppMethodBeat.o(154614);
        return null;
      }
      paramString = (Object[])paramObject;
      if (paramString.length <= 0)
      {
        Log.w("RuntimeToSdkChannel", "onRuntimeCalled, KEY_REPORT_JAVA_EXCEPTION, invalid args length");
        AppMethodBeat.o(154614);
        return null;
      }
      if (!(paramString[0] instanceof Throwable))
      {
        Log.w("RuntimeToSdkChannel", "onRuntimeCalled, KEY_REPORT_JAVA_EXCEPTION, invalid args[0]");
        AppMethodBeat.o(154614);
        return null;
      }
      paramString = (Throwable)paramString[0];
      Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), paramString);
      AppMethodBeat.o(154614);
      return null;
      paramString = r.a.kjn();
      if ((paramString.aipB == null) && ((paramObject instanceof Object[])))
      {
        paramObject = (Object[])paramObject;
        if (((paramObject[0] instanceof String)) && (paramObject.length >= 2)) {
          break label1021;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(154614);
        return null;
        label1021:
        str = (String)paramObject[0];
        if ((m)paramString.aipA.get(str) != null) {
          Arrays.copyOfRange(paramObject, 1, paramObject.length);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.RuntimeToSdkChannel
 * JD-Core Version:    0.7.0.1
 */