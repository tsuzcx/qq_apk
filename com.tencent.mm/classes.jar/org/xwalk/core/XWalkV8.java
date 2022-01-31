package org.xwalk.core;

import android.webkit.ValueCallback;
import java.util.ArrayList;

public class XWalkV8
{
  private ReflectMethod addJavascriptInterfaceObjectStringMethod = new ReflectMethod(null, "addJavascriptInterface", new Class[0]);
  private Object bridge;
  private ReflectMethod cleanupMethod = new ReflectMethod(null, "cleanup", new Class[0]);
  private ArrayList<Object> constructorParams = new ArrayList();
  private ArrayList<Object> constructorTypes = new ArrayList();
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod evaluateJavascriptStringValueCallbackMethod = new ReflectMethod(null, "evaluateJavascript", new Class[0]);
  private ReflectMethod initintMethod = new ReflectMethod(null, "init", new Class[0]);
  private ReflectMethod postWrapperMethod;
  
  static
  {
    if (!XWalkV8.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public XWalkV8()
  {
    reflectionInit();
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    try
    {
      this.addJavascriptInterfaceObjectStringMethod.invoke(new Object[] { paramObject, paramString });
      return;
    }
    catch (UnsupportedOperationException paramObject)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramObject);
    }
  }
  
  public void cleanup()
  {
    try
    {
      this.cleanupMethod.invoke(new Object[0]);
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
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    try
    {
      this.evaluateJavascriptStringValueCallbackMethod.invoke(new Object[] { paramString, paramValueCallback });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public void init(int paramInt)
  {
    try
    {
      this.initintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
      label127:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof Class)) {
            break label127;
          }
          localObject1[i] = ((Class)localObject2);
        }
      } while ($assertionsDisabled);
      throw new AssertionError();
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
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.xwalk.core.XWalkV8
 * JD-Core Version:    0.7.0.1
 */