package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkHttpAuthHandler
  implements XWalkHttpAuth
{
  private Object bridge;
  private ReflectMethod cancelMethod;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod isFirstAttemptMethod;
  private ReflectMethod postWrapperMethod;
  private ReflectMethod proceedStringStringMethod;
  
  public XWalkHttpAuthHandler(Object paramObject)
  {
    AppMethodBeat.i(154745);
    this.proceedStringStringMethod = new ReflectMethod(null, "proceed", new Class[0]);
    this.cancelMethod = new ReflectMethod(null, "cancel", new Class[0]);
    this.isFirstAttemptMethod = new ReflectMethod(null, "isFirstAttempt", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(154745);
  }
  
  public void cancel()
  {
    AppMethodBeat.i(154747);
    try
    {
      this.cancelMethod.invoke(new Object[0]);
      AppMethodBeat.o(154747);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154747);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154747);
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public boolean isFirstAttempt()
  {
    AppMethodBeat.i(154748);
    try
    {
      boolean bool = ((Boolean)this.isFirstAttemptMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154748);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154748);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154748);
    }
    return false;
  }
  
  public void proceed(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154746);
    try
    {
      this.proceedStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(154746);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154746);
        throw paramString1;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(154746);
    }
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(154749);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(154749);
      return;
    }
    this.proceedStringStringMethod.init(this.bridge, null, "proceedSuper", new Class[] { String.class, String.class });
    this.cancelMethod.init(this.bridge, null, "cancelSuper", new Class[0]);
    this.isFirstAttemptMethod.init(this.bridge, null, "isFirstAttemptSuper", new Class[0]);
    AppMethodBeat.o(154749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkHttpAuthHandler
 * JD-Core Version:    0.7.0.1
 */