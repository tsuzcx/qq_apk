package org.xwalk.core;

import java.util.ArrayList;

public abstract class XWalkLogMessageListener
{
  private Object bridge;
  private ArrayList<Object> constructorParams = new ArrayList();
  private ArrayList<Object> constructorTypes = new ArrayList();
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod postWrapperMethod;
  
  static
  {
    if (!XWalkLogMessageListener.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public XWalkLogMessageListener()
  {
    reflectionInit();
  }
  
  public XWalkLogMessageListener(XWalkCoreWrapper paramXWalkCoreWrapper)
  {
    this.coreWrapper = paramXWalkCoreWrapper;
    reflectionInit();
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public abstract void onLogMessage(int paramInt1, String paramString1, int paramInt2, String paramString2);
  
  void reflectionInit()
  {
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.initEmbeddedMode();
      this.coreWrapper = XWalkCoreWrapper.getInstance();
    }
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
        label134:
        do
        {
          for (;;)
          {
            i += 1;
            break;
            if (!(localObject2 instanceof Class)) {
              break label134;
            }
            localObject1[i] = ((Class)localObject2);
          }
        } while ($assertionsDisabled);
        throw new AssertionError();
      }
      localObject1[j] = Object.class;
      this.constructorParams.add(this);
      localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkLogMessageListenerBridge"), (Class[])localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkLogMessageListener
 * JD-Core Version:    0.7.0.1
 */