package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkJavascriptResultHandler
  implements XWalkJavascriptResult
{
  private Object bridge;
  private ReflectMethod cancelMethod;
  private ReflectMethod confirmMethod;
  private ReflectMethod confirmWithResultStringMethod;
  private XWalkCoreWrapper coreWrapper;
  
  public XWalkJavascriptResultHandler(Object paramObject)
  {
    AppMethodBeat.i(154761);
    this.confirmMethod = new ReflectMethod(null, "confirm", new Class[0]);
    this.confirmWithResultStringMethod = new ReflectMethod(null, "confirmWithResult", new Class[0]);
    this.cancelMethod = new ReflectMethod(null, "cancel", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(154761);
  }
  
  private void reflectionInit()
  {
    AppMethodBeat.i(154765);
    if (XWalkCoreWrapper.getInstance() == null)
    {
      XWalkReflectionInitHandler.reserveReflectObject(this);
      AppMethodBeat.o(154765);
      return;
    }
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    this.confirmMethod.init(this.bridge, null, "confirmSuper", new Class[0]);
    this.confirmWithResultStringMethod.init(this.bridge, null, "confirmWithResultSuper", new Class[] { String.class });
    this.cancelMethod.init(this.bridge, null, "cancelSuper", new Class[0]);
    AppMethodBeat.o(154765);
  }
  
  public void cancel()
  {
    AppMethodBeat.i(154764);
    try
    {
      this.cancelMethod.invoke(new Object[0]);
      AppMethodBeat.o(154764);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154764);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154764);
    }
  }
  
  public void confirm()
  {
    AppMethodBeat.i(154762);
    try
    {
      this.confirmMethod.invoke(new Object[0]);
      AppMethodBeat.o(154762);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154762);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154762);
    }
  }
  
  public void confirmWithResult(String paramString)
  {
    AppMethodBeat.i(154763);
    try
    {
      this.confirmWithResultStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(154763);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154763);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154763);
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkJavascriptResultHandler
 * JD-Core Version:    0.7.0.1
 */