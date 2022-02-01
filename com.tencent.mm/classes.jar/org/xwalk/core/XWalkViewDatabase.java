package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkViewDatabase
{
  private static ReflectMethod clearFormDataMethod;
  private static XWalkCoreWrapper coreWrapper;
  private static ReflectMethod hasFormDataMethod;
  
  static
  {
    AppMethodBeat.i(155162);
    hasFormDataMethod = new ReflectMethod(null, "hasFormData", new Class[0]);
    clearFormDataMethod = new ReflectMethod(null, "clearFormData", new Class[0]);
    AppMethodBeat.o(155162);
  }
  
  public static void clearFormData()
  {
    AppMethodBeat.i(155160);
    reflectionInit();
    try
    {
      clearFormDataMethod.invoke(new Object[0]);
      AppMethodBeat.o(155160);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (coreWrapper == null)
      {
        clearFormDataMethod.setArguments(new Object[0]);
        XWalkCoreWrapper.reserveReflectMethod(clearFormDataMethod);
        AppMethodBeat.o(155160);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(155160);
    }
  }
  
  public static boolean hasFormData()
  {
    AppMethodBeat.i(155159);
    reflectionInit();
    try
    {
      boolean bool = ((Boolean)hasFormDataMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(155159);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155159);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155159);
    }
    return false;
  }
  
  static void reflectionInit()
  {
    AppMethodBeat.i(155161);
    if (coreWrapper != null)
    {
      AppMethodBeat.o(155161);
      return;
    }
    XWalkCoreWrapper.initEmbeddedMode();
    Object localObject = XWalkCoreWrapper.getInstance();
    coreWrapper = (XWalkCoreWrapper)localObject;
    if (localObject == null)
    {
      XWalkCoreWrapper.reserveReflectClass(XWalkViewDatabase.class);
      AppMethodBeat.o(155161);
      return;
    }
    localObject = coreWrapper.getBridgeClass("XWalkViewDatabaseBridge");
    hasFormDataMethod.init(null, (Class)localObject, "hasFormData", new Class[0]);
    clearFormDataMethod.init(null, (Class)localObject, "clearFormData", new Class[0]);
    AppMethodBeat.o(155161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.XWalkViewDatabase
 * JD-Core Version:    0.7.0.1
 */