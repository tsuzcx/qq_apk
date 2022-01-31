package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class CustomViewCallbackHandler
  implements CustomViewCallback
{
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod onCustomViewHiddenMethod;
  private ReflectMethod postWrapperMethod;
  
  public CustomViewCallbackHandler(Object paramObject)
  {
    AppMethodBeat.i(85509);
    this.onCustomViewHiddenMethod = new ReflectMethod(null, "onCustomViewHidden", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(85509);
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public void onCustomViewHidden()
  {
    AppMethodBeat.i(85510);
    try
    {
      this.onCustomViewHiddenMethod.invoke(new Object[0]);
      AppMethodBeat.o(85510);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85510);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85510);
    }
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(85511);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(85511);
      return;
    }
    this.onCustomViewHiddenMethod.init(this.bridge, null, "onCustomViewHiddenSuper", new Class[0]);
    AppMethodBeat.o(85511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.xwalk.core.CustomViewCallbackHandler
 * JD-Core Version:    0.7.0.1
 */