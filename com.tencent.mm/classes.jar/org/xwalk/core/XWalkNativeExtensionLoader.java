package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkNativeExtensionLoader
{
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod postWrapperMethod;
  private ReflectMethod registerNativeExtensionsInPathStringMethod;
  
  static
  {
    AppMethodBeat.i(154808);
    if (!XWalkNativeExtensionLoader.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(154808);
      return;
    }
  }
  
  public XWalkNativeExtensionLoader()
  {
    AppMethodBeat.i(154805);
    this.registerNativeExtensionsInPathStringMethod = new ReflectMethod(null, "registerNativeExtensionsInPath", new Class[0]);
    this.constructorTypes = new ArrayList();
    this.constructorParams = new ArrayList();
    reflectionInit();
    AppMethodBeat.o(154805);
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(154807);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(154807);
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
      AppMethodBeat.o(154807);
      throw ((Throwable)localObject1);
    }
    localObject1[j] = Object.class;
    this.constructorParams.add(this);
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkNativeExtensionLoaderBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      if (this.postWrapperMethod != null) {
        this.postWrapperMethod.invoke(new Object[0]);
      }
      this.registerNativeExtensionsInPathStringMethod.init(this.bridge, null, "registerNativeExtensionsInPathSuper", new Class[] { String.class });
      AppMethodBeat.o(154807);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      AppMethodBeat.o(154807);
    }
  }
  
  public void registerNativeExtensionsInPath(String paramString)
  {
    AppMethodBeat.i(154806);
    try
    {
      this.registerNativeExtensionsInPathStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(154806);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154806);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154806);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.XWalkNativeExtensionLoader
 * JD-Core Version:    0.7.0.1
 */