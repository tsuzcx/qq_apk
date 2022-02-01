package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x5.export.external.extension.proxy.a;
import java.util.ArrayList;

public class XWalkProxyWebViewClientExtension
  extends a
{
  private static final String TAG = "XWalkProxyWebViewClientExtension";
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod postWrapperMethod;
  
  static
  {
    AppMethodBeat.i(154840);
    if (!XWalkProxyWebViewClientExtension.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(154840);
      return;
    }
  }
  
  public XWalkProxyWebViewClientExtension()
  {
    AppMethodBeat.i(154838);
    this.constructorTypes = new ArrayList();
    this.constructorParams = new ArrayList();
    reflectionInit();
    AppMethodBeat.o(154838);
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(154839);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(154839);
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
      AppMethodBeat.o(154839);
      throw ((Throwable)localObject1);
    }
    localObject1[j] = Object.class;
    this.constructorParams.add(this);
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkProxyWebViewClientExtensionBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      if (this.postWrapperMethod != null) {
        this.postWrapperMethod.invoke(new Object[0]);
      }
      AppMethodBeat.o(154839);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      AppMethodBeat.o(154839);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.XWalkProxyWebViewClientExtension
 * JD-Core Version:    0.7.0.1
 */