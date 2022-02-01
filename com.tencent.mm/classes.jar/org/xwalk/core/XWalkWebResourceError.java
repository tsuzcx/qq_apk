package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkWebResourceError
{
  private Object bridge;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod getDescriptionMethod;
  private ReflectMethod getErrorCodeMethod;
  
  public XWalkWebResourceError(Object paramObject)
  {
    AppMethodBeat.i(205055);
    this.getErrorCodeMethod = new ReflectMethod(null, "getErrorCode", new Class[0]);
    this.getDescriptionMethod = new ReflectMethod(null, "getDescription", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(205055);
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public CharSequence getDescription()
  {
    AppMethodBeat.i(205060);
    try
    {
      CharSequence localCharSequence = (CharSequence)this.getDescriptionMethod.invoke(new Object[0]);
      AppMethodBeat.o(205060);
      return localCharSequence;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(205060);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(205060);
    }
    return "";
  }
  
  public int getErrorCode()
  {
    AppMethodBeat.i(205058);
    try
    {
      int i = ((Integer)this.getErrorCodeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(205058);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(205058);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(205058);
    }
    return -1;
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(205057);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(205057);
      return;
    }
    this.getErrorCodeMethod.init(this.bridge, null, "getErrorCodeSuper", new Class[0]);
    this.getDescriptionMethod.init(this.bridge, null, "getDescriptionSuper", new Class[0]);
    AppMethodBeat.o(205057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkWebResourceError
 * JD-Core Version:    0.7.0.1
 */