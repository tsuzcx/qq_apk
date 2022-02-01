package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomViewCallbackHandler
  implements CustomViewCallback
{
  private Object bridge;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod onCustomViewHiddenMethod;
  
  public CustomViewCallbackHandler(Object paramObject)
  {
    AppMethodBeat.i(154599);
    this.onCustomViewHiddenMethod = new ReflectMethod(null, "onCustomViewHidden", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(154599);
  }
  
  private void reflectionInit()
  {
    AppMethodBeat.i(154601);
    if (XWalkCoreWrapper.getInstance() == null)
    {
      XWalkReflectionInitHandler.reserveReflectObject(this);
      AppMethodBeat.o(154601);
      return;
    }
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    this.onCustomViewHiddenMethod.init(this.bridge, null, "onCustomViewHiddenSuper", new Class[0]);
    AppMethodBeat.o(154601);
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public void onCustomViewHidden()
  {
    AppMethodBeat.i(154600);
    try
    {
      this.onCustomViewHiddenMethod.invoke(new Object[0]);
      AppMethodBeat.o(154600);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154600);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154600);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.CustomViewCallbackHandler
 * JD-Core Version:    0.7.0.1
 */