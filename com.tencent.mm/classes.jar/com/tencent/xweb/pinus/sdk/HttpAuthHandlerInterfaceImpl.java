package com.tencent.xweb.pinus.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.ReflectMethod;

public class HttpAuthHandlerInterfaceImpl
  implements HttpAuthHandlerInterface
{
  private static final String TAG = "HttpAuthHandlerInterfaceImpl";
  private ReflectMethod cancelMethod;
  private Object inner;
  private ReflectMethod proceedStringStringMethod;
  private ReflectMethod useHttpAuthUsernamePasswordMethod;
  
  public HttpAuthHandlerInterfaceImpl(Object paramObject)
  {
    this.inner = paramObject;
  }
  
  private ReflectMethod getCancelMethod()
  {
    try
    {
      AppMethodBeat.i(213401);
      ReflectMethod localReflectMethod2 = this.cancelMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "cancel", new Class[0]);
        this.cancelMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213401);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getProceedStringStringMethod()
  {
    try
    {
      AppMethodBeat.i(213388);
      ReflectMethod localReflectMethod2 = this.proceedStringStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "proceed", new Class[] { String.class, String.class });
        this.proceedStringStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213388);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getUseHttpAuthUsernamePasswordMethod()
  {
    try
    {
      AppMethodBeat.i(213414);
      ReflectMethod localReflectMethod2 = this.useHttpAuthUsernamePasswordMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "useHttpAuthUsernamePassword", new Class[0]);
        this.useHttpAuthUsernamePasswordMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213414);
      return localReflectMethod1;
    }
    finally {}
  }
  
  public static void handleRuntimeError(Exception paramException) {}
  
  public void cancel()
  {
    AppMethodBeat.i(213443);
    try
    {
      getCancelMethod().invoke(new Object[0]);
      AppMethodBeat.o(213443);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(213443);
    }
  }
  
  public void proceed(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213432);
    try
    {
      getProceedStringStringMethod().invoke(new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(213432);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      handleRuntimeError(paramString1);
      AppMethodBeat.o(213432);
    }
  }
  
  public boolean useHttpAuthUsernamePassword()
  {
    AppMethodBeat.i(213453);
    try
    {
      bool = ((Boolean)getUseHttpAuthUsernamePasswordMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(213453);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.HttpAuthHandlerInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */