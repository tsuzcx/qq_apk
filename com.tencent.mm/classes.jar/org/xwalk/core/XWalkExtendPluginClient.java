package org.xwalk.core;

import android.graphics.SurfaceTexture;
import java.util.ArrayList;

public class XWalkExtendPluginClient
{
  private static final String TAG = "XWalkExtendPluginClient";
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes = new ArrayList();
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod postWrapperMethod;
  private ReflectMethod setPluginTextureScaleStringintfloatfloatMethod = new ReflectMethod(null, "setPluginTextureScale", new Class[0]);
  
  static
  {
    if (!XWalkExtendPluginClient.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public XWalkExtendPluginClient(XWalkView paramXWalkView)
  {
    this.constructorTypes.add("XWalkViewBridge");
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramXWalkView);
    reflectionInit();
  }
  
  private float[] calScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4, XWalkExtendPluginClient.ObjectFit paramObjectFit)
  {
    float[] arrayOfFloat = new float[2];
    float[] tmp7_5 = arrayOfFloat;
    tmp7_5[0] = 1.0F;
    float[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 1.0F;
    tmp11_7;
    try
    {
      Log.i("XWalkExtendPluginClient", "calScale htmlWidth:" + paramInt1 + ",htmlHeight:" + paramInt2 + ",videoWidth:" + paramInt3 + ",videoHeight:" + paramInt4 + ",objectFit:" + paramObjectFit);
      switch (1.$SwitchMap$org$xwalk$core$XWalkExtendPluginClient$ObjectFit[paramObjectFit.ordinal()])
      {
      case 2: 
        arrayOfFloat[0] = 1.0F;
        arrayOfFloat[1] = (paramInt4 * 1.0F / paramInt3);
        return arrayOfFloat;
      }
    }
    catch (Exception paramObjectFit)
    {
      Log.e("XWalkExtendPluginClient", "calScale error:");
      return arrayOfFloat;
    }
    float f = paramInt3 * 1.0F / paramInt4;
    arrayOfFloat[0] = f;
    arrayOfFloat[1] = 1.0F;
    return arrayOfFloat;
    arrayOfFloat[0] = (paramInt3 * 1.0F / paramInt1);
    arrayOfFloat[1] = (paramInt4 * 1.0F / paramInt2);
    return arrayOfFloat;
    return arrayOfFloat;
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public void onPluginDestroy(String paramString, int paramInt) {}
  
  public void onPluginReady(String paramString, int paramInt, SurfaceTexture paramSurfaceTexture) {}
  
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
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExtendPluginClientBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      if (this.postWrapperMethod != null) {
        this.postWrapperMethod.invoke(new Object[0]);
      }
      this.setPluginTextureScaleStringintfloatfloatMethod.init(this.bridge, null, "setPluginTextureScale", new Class[] { String.class, Integer.TYPE, Float.TYPE, Float.TYPE });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
  }
  
  public void setPluginTextureScale(String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    try
    {
      Log.i("XWalkExtendPluginClient", "setPluginTextureScale embed_type:" + paramString + ",embed_id:" + paramInt + ",xScale:" + paramFloat1 + ",yScale:" + paramFloat2);
      this.setPluginTextureScaleStringintfloatfloatMethod.invoke(new Object[] { paramString, Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
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
  
  public void setPluginTextureScale(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, XWalkExtendPluginClient.ObjectFit paramObjectFit)
  {
    paramObjectFit = calScale(paramInt2, paramInt3, paramInt4, paramInt5, paramObjectFit);
    setPluginTextureScale(paramString, paramInt1, paramObjectFit[0], paramObjectFit[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.xwalk.core.XWalkExtendPluginClient
 * JD-Core Version:    0.7.0.1
 */