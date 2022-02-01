package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkWebResourceError
{
  private static final String TAG = "XWalkWebResourceError";
  private Object bridge;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod getDescriptionMethod;
  private ReflectMethod getErrorCodeMethod;
  
  public XWalkWebResourceError(Object paramObject)
  {
    AppMethodBeat.i(187551);
    this.getErrorCodeMethod = new ReflectMethod(null, "getErrorCode", new Class[0]);
    this.getDescriptionMethod = new ReflectMethod(null, "getDescription", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(187551);
  }
  
  private void reflectionInit()
  {
    AppMethodBeat.i(187556);
    if (XWalkCoreWrapper.getInstance() == null)
    {
      XWalkReflectionInitHandler.reserveReflectObject(this);
      AppMethodBeat.o(187556);
      return;
    }
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    this.getErrorCodeMethod.init(this.bridge, null, "getErrorCodeSuper", new Class[0]);
    this.getDescriptionMethod.init(this.bridge, null, "getDescriptionSuper", new Class[0]);
    AppMethodBeat.o(187556);
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public CharSequence getDescription()
  {
    AppMethodBeat.i(187568);
    try
    {
      CharSequence localCharSequence = (CharSequence)this.getDescriptionMethod.invoke(new Object[0]);
      AppMethodBeat.o(187568);
      return localCharSequence;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(187568);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(187568);
    }
    return "";
  }
  
  public int getErrorCode()
  {
    AppMethodBeat.i(187563);
    try
    {
      int i = ((Integer)this.getErrorCodeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(187563);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(187563);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(187563);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkWebResourceError
 * JD-Core Version:    0.7.0.1
 */