package org.xwalk.core;

import java.util.ArrayList;

public class CustomViewCallbackHandler
  implements CustomViewCallback
{
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod onCustomViewHiddenMethod = new ReflectMethod(null, "onCustomViewHidden", new Class[0]);
  private ReflectMethod postWrapperMethod;
  
  public CustomViewCallbackHandler(Object paramObject)
  {
    this.bridge = paramObject;
    reflectionInit();
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public void onCustomViewHidden()
  {
    try
    {
      this.onCustomViewHiddenMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  void reflectionInit()
  {
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      return;
    }
    this.onCustomViewHiddenMethod.init(this.bridge, null, "onCustomViewHiddenSuper", new Class[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.xwalk.core.CustomViewCallbackHandler
 * JD-Core Version:    0.7.0.1
 */