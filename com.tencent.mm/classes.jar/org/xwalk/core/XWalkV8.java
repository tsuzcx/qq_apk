package org.xwalk.core;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkV8
{
  private ReflectMethod addJavascriptInterfaceObjectStringMethod;
  private Object bridge;
  private ReflectMethod cleanupMethod;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod evaluateJavascriptStringValueCallbackMethod;
  private ReflectMethod initintMethod;
  private ReflectMethod postWrapperMethod;
  
  static
  {
    AppMethodBeat.i(155042);
    if (!XWalkV8.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(155042);
      return;
    }
  }
  
  public XWalkV8()
  {
    AppMethodBeat.i(155036);
    this.initintMethod = new ReflectMethod(null, "init", new Class[0]);
    this.evaluateJavascriptStringValueCallbackMethod = new ReflectMethod(null, "evaluateJavascript", new Class[0]);
    this.cleanupMethod = new ReflectMethod(null, "cleanup", new Class[0]);
    this.addJavascriptInterfaceObjectStringMethod = new ReflectMethod(null, "addJavascriptInterface", new Class[0]);
    this.constructorTypes = new ArrayList();
    this.constructorParams = new ArrayList();
    reflectionInit();
    AppMethodBeat.o(155036);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(155040);
    try
    {
      this.addJavascriptInterfaceObjectStringMethod.invoke(new Object[] { paramObject, paramString });
      AppMethodBeat.o(155040);
      return;
    }
    catch (UnsupportedOperationException paramObject)
    {
      if (this.coreWrapper == null)
      {
        paramObject = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155040);
        throw paramObject;
      }
      XWalkCoreWrapper.handleRuntimeError(paramObject);
      AppMethodBeat.o(155040);
    }
  }
  
  public void cleanup()
  {
    AppMethodBeat.i(155039);
    try
    {
      this.cleanupMethod.invoke(new Object[0]);
      AppMethodBeat.o(155039);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155039);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155039);
    }
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(155038);
    try
    {
      this.evaluateJavascriptStringValueCallbackMethod.invoke(new Object[] { paramString, paramValueCallback });
      AppMethodBeat.o(155038);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155038);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(155038);
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public void init(int paramInt)
  {
    AppMethodBeat.i(155037);
    try
    {
      this.initintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(155037);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155037);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155037);
    }
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(155041);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(155041);
      return;
    }
    int j = this.constructorTypes.size();
    Object localObject1 = new Class[j + 1];
    int i = 0;
    if (i < j)
    {
      Object localObject2 = this.constructorTypes.get(i);
      if ((localObject2 instanceof String))
      {
        localObject1[i] = this.coreWrapper.getBridgeClass((String)localObject2);
        this.constructorParams.set(i, this.coreWrapper.getBridgeObject(this.constructorParams.get(i)));
      }
      label137:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof Class)) {
            break label137;
          }
          localObject1[i] = ((Class)localObject2);
        }
      } while ($assertionsDisabled);
      localObject1 = new AssertionError();
      AppMethodBeat.o(155041);
      throw ((Throwable)localObject1);
    }
    localObject1[j] = Object.class;
    this.constructorParams.add(this);
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkV8Bridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      if (this.postWrapperMethod != null) {
        this.postWrapperMethod.invoke(new Object[0]);
      }
      this.initintMethod.init(this.bridge, null, "initSuper", new Class[] { Integer.TYPE });
      this.evaluateJavascriptStringValueCallbackMethod.init(this.bridge, null, "evaluateJavascriptSuper", new Class[] { String.class, ValueCallback.class });
      this.cleanupMethod.init(this.bridge, null, "cleanupSuper", new Class[0]);
      this.addJavascriptInterfaceObjectStringMethod.init(this.bridge, null, "addJavascriptInterfaceSuper", new Class[] { Object.class, String.class });
      AppMethodBeat.o(155041);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      AppMethodBeat.o(155041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.XWalkV8
 * JD-Core Version:    0.7.0.1
 */