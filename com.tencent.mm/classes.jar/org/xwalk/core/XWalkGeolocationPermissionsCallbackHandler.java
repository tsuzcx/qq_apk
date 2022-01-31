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
    AppMethodBeat.i(85639);
    this.invokeStringbooleanbooleanMethod = new ReflectMethod(null, "invoke", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(85639);
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(85640);
    try
    {
      this.invokeStringbooleanbooleanMethod.invoke(new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(85640);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85640);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85640);
    }
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(85641);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(85641);
      return;
    }
    this.invokeStringbooleanbooleanMethod.init(this.bridge, null, "invokeSuper", new Class[] { String.class, Boolean.TYPE, Boolean.TYPE });
    AppMethodBeat.o(85641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkGeolocationPermissionsCallbackHandler
 * JD-Core Version:    0.7.0.1
 */