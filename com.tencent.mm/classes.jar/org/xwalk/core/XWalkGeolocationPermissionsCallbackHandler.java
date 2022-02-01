package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkGeolocationPermissionsCallbackHandler
  implements XWalkGeolocationPermissionsCallback
{
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod invokeStringbooleanbooleanMethod;
  private ReflectMethod postWrapperMethod;
  
  public XWalkGeolocationPermissionsCallbackHandler(Object paramObject)
  {
    AppMethodBeat.i(154734);
    this.invokeStringbooleanbooleanMethod = new ReflectMethod(null, "invoke", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(154734);
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(154735);
    try
    {
      this.invokeStringbooleanbooleanMethod.invoke(new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(154735);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154735);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154735);
    }
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(154736);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(154736);
      return;
    }
    this.invokeStringbooleanbooleanMethod.init(this.bridge, null, "invokeSuper", new Class[] { String.class, Boolean.TYPE, Boolean.TYPE });
    AppMethodBeat.o(154736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkGeolocationPermissionsCallbackHandler
 * JD-Core Version:    0.7.0.1
 */