package org.xwalk.core;

import java.util.ArrayList;

public abstract class XWalkGetImageBitmapToFileFinishedCallback
{
  private static final String TAG = "XWalkGetImageBitmapToFileFinishedCallback";
  private Object bridge;
  private ArrayList<Object> constructorParams = new ArrayList();
  private ArrayList<Object> constructorTypes = new ArrayList();
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod postWrapperMethod;
  
  static
  {
    if (!XWalkGetImageBitmapToFileFinishedCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public XWalkGetImageBitmapToFileFinishedCallback()
  {
    reflectionInit();
  }
  
  private void reflectionInit()
  {
    if (XWalkCoreWrapper.getInstance() == null) {
      XWalkReflectionInitHandler.reserveReflectObject(this);
    }
    for (;;)
    {
      return;
      this.coreWrapper = XWalkCoreWrapper.getInstance();
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
        label123:
        do
        {
          for (;;)
          {
            i += 1;
            break;
            if (!(localObject2 instanceof Class)) {
              break label123;
            }
            localObject1[i] = ((Class)localObject2);
          }
        } while ($assertionsDisabled);
        throw new AssertionError();
      }
      localObject1[j] = Object.class;
      this.constructorParams.add(this);
      localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkGetImageBitmapToFileFinishedCallbackBridge"), (Class[])localObject1);
      try
      {
        this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
        if (this.postWrapperMethod != null)
        {
          this.postWrapperMethod.invoke(new Object[0]);
          return;
        }
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        Log.e("XWalkGetImageBitmapToFileFinishedCallback", "reflectionInit, error:".concat(String.valueOf(localUnsupportedOperationException)));
      }
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public abstract void onFinishImageBitmapToFile(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkGetImageBitmapToFileFinishedCallback
 * JD-Core Version:    0.7.0.1
 */