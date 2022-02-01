package com.tencent.xweb.pinus.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.ReflectMethod;

public class JsResultInterfaceImpl
  implements JsResultInterface
{
  private static final String TAG = "JsResultInterfaceImpl";
  private ReflectMethod cancelMethod;
  private ReflectMethod confirmMethod;
  private ReflectMethod confirmStringMethod;
  private Object inner;
  
  public JsResultInterfaceImpl(Object paramObject)
  {
    this.inner = paramObject;
  }
  
  private ReflectMethod getCancelMethod()
  {
    try
    {
      AppMethodBeat.i(213584);
      ReflectMethod localReflectMethod2 = this.cancelMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "cancel", new Class[0]);
        this.cancelMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213584);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getConfirmMethod()
  {
    try
    {
      AppMethodBeat.i(213592);
      ReflectMethod localReflectMethod2 = this.confirmMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "confirm", new Class[0]);
        this.confirmMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213592);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getConfirmStringMethod()
  {
    try
    {
      AppMethodBeat.i(213597);
      ReflectMethod localReflectMethod2 = this.confirmStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "confirm", new Class[] { String.class });
        this.confirmStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213597);
      return localReflectMethod1;
    }
    finally {}
  }
  
  public static void handleRuntimeError(Exception paramException) {}
  
  public void cancel()
  {
    AppMethodBeat.i(213614);
    try
    {
      getCancelMethod().invoke(new Object[0]);
      AppMethodBeat.o(213614);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(213614);
    }
  }
  
  public void confirm()
  {
    AppMethodBeat.i(213623);
    try
    {
      getConfirmMethod().invoke(new Object[0]);
      AppMethodBeat.o(213623);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(213623);
    }
  }
  
  public void confirm(String paramString)
  {
    AppMethodBeat.i(213633);
    try
    {
      getConfirmStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(213633);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(213633);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.JsResultInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */