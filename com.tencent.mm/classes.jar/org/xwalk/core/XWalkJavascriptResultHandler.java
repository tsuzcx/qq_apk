package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkJavascriptResultHandler
  implements XWalkJavascriptResult
{
  private Object bridge;
  private ReflectMethod cancelMethod;
  private ReflectMethod confirmMethod;
  private ReflectMethod confirmWithResultStringMethod;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod postWrapperMethod;
  
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
  
  void reflectionInit()
  {
    AppMethodBeat.i(154765);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(154765);
      return;
    }
    this.confirmMethod.init(this.bridge, null, "confirmSuper", new Class[0]);
    this.confirmWithResultStringMethod.init(this.bridge, null, "confirmWithResultSuper", new Class[] { String.class });
    this.cancelMethod.init(this.bridge, null, "cancelSuper", new Class[0]);
    AppMethodBeat.o(154765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.XWalkJavascriptResultHandler
 * JD-Core Version:    0.7.0.1
 */