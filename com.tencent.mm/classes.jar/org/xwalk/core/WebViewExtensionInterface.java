package org.xwalk.core;

import java.util.ArrayList;
import java.util.List;

public abstract class WebViewExtensionInterface
{
  private Object bridge;
  private ArrayList<Object> constructorParams = new ArrayList();
  private ArrayList<Object> constructorTypes = new ArrayList();
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod postWrapperMethod;
  
  static
  {
    if (!WebViewExtensionInterface.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public WebViewExtensionInterface()
  {
    reflectionInit();
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public abstract int getHostByName(String paramString, List<String> paramList);
  
  public abstract Object onMiscCallBack(String paramString, Object... paramVarArgs);
  
  void reflectionInit()
  {
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null) {
      XWalkCoreWrapper.reserveReflectObject(this);
    }
    for (;;)
    {
      return;
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
      localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("WebViewExtensionInterfaceBridge"), (Class[])localObject1);
      try
      {
        this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
        if (this.postWrapperMethod != null)
        {
          this.postWrapperMethod.invoke(new Object[0]);
          return;
        }
      }
      catch (UnsupportedOperationException localUnsupportedOperationException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.xwalk.core.WebViewExtensionInterface
 * JD-Core Version:    0.7.0.1
 */