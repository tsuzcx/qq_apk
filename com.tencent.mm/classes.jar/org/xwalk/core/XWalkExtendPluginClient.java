package org.xwalk.core;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.Surface;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebExtendInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.xwalk.core.compatible.PinusAdaptClient;

public class XWalkExtendPluginClient
  extends PinusAdaptClient
{
  public static final String NATIVE_VIEW_TYPE = "native_view";
  private static final String TAG = "XWalkExtendPluginClient";
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private HashMap<Integer, XWalkExtendPluginNativeViewClient> mNativeViewClientMap;
  public com.tencent.xweb.WebView obj;
  private ReflectMethod postWrapperMethod;
  private ReflectMethod setPluginTextureScaleStringintfloatfloatMethod;
  private ReflectMethod takePluginScreenshotStringintMethod;
  
  static
  {
    AppMethodBeat.i(154724);
    if (!XWalkExtendPluginClient.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(154724);
      return;
    }
  }
  
  public XWalkExtendPluginClient(XWebExtendInterface paramXWebExtendInterface)
  {
    AppMethodBeat.i(187545);
    this.mNativeViewClientMap = new HashMap();
    this.setPluginTextureScaleStringintfloatfloatMethod = new ReflectMethod(null, "setPluginTextureScale", new Class[0]);
    this.takePluginScreenshotStringintMethod = new ReflectMethod(null, "takePluginScreenshot", new Class[0]);
    super.init(paramXWebExtendInterface);
    AppMethodBeat.o(187545);
  }
  
  private void reflectionInit()
  {
    AppMethodBeat.i(154723);
    if (XWalkCoreWrapper.getInstance() == null)
    {
      XWalkReflectionInitHandler.reserveReflectObject(this);
      AppMethodBeat.o(154723);
      return;
    }
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
      label133:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof Class)) {
            break label133;
          }
          localObject1[i] = ((Class)localObject2);
        }
      } while ($assertionsDisabled);
      localObject1 = new AssertionError();
      AppMethodBeat.o(154723);
      throw ((Throwable)localObject1);
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
      this.takePluginScreenshotStringintMethod.init(this.bridge, null, "takePluginScreenshot", new Class[] { String.class, Integer.TYPE });
      AppMethodBeat.o(154723);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      Log.e("XWalkExtendPluginClient", "reflectionInit, error:".concat(String.valueOf(localUnsupportedOperationException)));
      AppMethodBeat.o(154723);
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public void initPSWebView(com.tencent.xweb.pinus.sdk.WebView paramWebView)
  {
    AppMethodBeat.i(187572);
    super.initPSWebView(paramWebView);
    AppMethodBeat.o(187572);
  }
  
  public void initXWalkView(XWalkView paramXWalkView)
  {
    AppMethodBeat.i(187567);
    super.initXWalkView(paramXWalkView);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add("XWalkViewBridge");
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramXWalkView);
    reflectionInit();
    AppMethodBeat.o(187567);
  }
  
  public XWalkExtendPluginNativeViewDelegate onNativeViewReady(int paramInt)
  {
    return null;
  }
  
  public void onPluginDestroy(String paramString, int paramInt)
  {
    AppMethodBeat.i(183752);
    if (("native_view".equals(paramString)) && (this.mNativeViewClientMap.containsKey(Integer.valueOf(paramInt))))
    {
      ((XWalkExtendPluginNativeViewClient)this.mNativeViewClientMap.get(Integer.valueOf(paramInt))).dispose();
      this.mNativeViewClientMap.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(183752);
  }
  
  public void onPluginManagerDestroy()
  {
    AppMethodBeat.i(183750);
    Log.i("XWalkExtendPluginClient", "[onPluginManagerDestroy]");
    Iterator localIterator = this.mNativeViewClientMap.values().iterator();
    while (localIterator.hasNext()) {
      ((XWalkExtendPluginNativeViewClient)localIterator.next()).dispose();
    }
    this.mNativeViewClientMap.clear();
    AppMethodBeat.o(183750);
  }
  
  public void onPluginReady(String paramString, int paramInt, SurfaceTexture paramSurfaceTexture) {}
  
  public void onPluginReadyForGPUProcess(String paramString, int paramInt, Surface paramSurface) {}
  
  public void onPluginScreenshotTaken(String paramString, int paramInt, Bitmap paramBitmap) {}
  
  public void onPluginSizeChanged(String paramString, int paramInt1, int paramInt2, int paramInt3, SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(183751);
    if ("native_view".equals(paramString))
    {
      if (!this.mNativeViewClientMap.containsKey(Integer.valueOf(paramInt1)))
      {
        XWalkExtendPluginNativeViewDelegate localXWalkExtendPluginNativeViewDelegate = onNativeViewReady(paramInt1);
        if (localXWalkExtendPluginNativeViewDelegate != null)
        {
          XWalkExtendPluginNativeViewClient localXWalkExtendPluginNativeViewClient = new XWalkExtendPluginNativeViewClient(null, paramSurfaceTexture, paramInt2, paramInt3);
          this.mNativeViewClientMap.put(Integer.valueOf(paramInt1), localXWalkExtendPluginNativeViewClient);
          localXWalkExtendPluginNativeViewDelegate.setClient(localXWalkExtendPluginNativeViewClient);
          localXWalkExtendPluginNativeViewClient.setDelegate(localXWalkExtendPluginNativeViewDelegate);
        }
      }
      else
      {
        ((XWalkExtendPluginNativeViewClient)this.mNativeViewClientMap.get(Integer.valueOf(paramInt1))).onSizeChanged(paramInt2, paramInt3);
      }
    }
    else
    {
      Log.i("XWalkExtendPluginClient", "onPluginSizeChanged type:" + paramString + ", embed_id:" + paramInt1 + ", width:" + paramInt2 + ", height:" + paramInt3);
      if ((paramSurfaceTexture != null) && (paramInt2 > 0) && (paramInt3 > 0)) {
        paramSurfaceTexture.setDefaultBufferSize(paramInt2, paramInt3);
      }
      AppMethodBeat.o(183751);
      return;
    }
    Log.e("XWalkExtendPluginClient", "onPluginSizeChanged, onNativeViewReady return null");
    AppMethodBeat.o(183751);
  }
  
  public void onPluginSizeChangedForGPUProcess(String paramString, int paramInt1, int paramInt2, int paramInt3, Surface paramSurface)
  {
    AppMethodBeat.i(187600);
    if ("native_view".equals(paramString))
    {
      if (!this.mNativeViewClientMap.containsKey(Integer.valueOf(paramInt1)))
      {
        paramString = onNativeViewReady(paramInt1);
        if (paramString != null)
        {
          paramSurface = new XWalkExtendPluginNativeViewClient(null, paramSurface, paramInt2, paramInt3);
          this.mNativeViewClientMap.put(Integer.valueOf(paramInt1), paramSurface);
          paramString.setClient(paramSurface);
          paramSurface.setDelegate(paramString);
        }
      }
      else
      {
        ((XWalkExtendPluginNativeViewClient)this.mNativeViewClientMap.get(Integer.valueOf(paramInt1))).onSizeChanged(paramInt2, paramInt3);
      }
    }
    else
    {
      AppMethodBeat.o(187600);
      return;
    }
    Log.e("XWalkExtendPluginClient", "onPluginSizeChanged onNativeViewReady return null");
    AppMethodBeat.o(187600);
  }
  
  public void onPluginTouch(String paramString, int paramInt, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(183753);
    if (("native_view".equals(paramString)) && (this.mNativeViewClientMap.containsKey(Integer.valueOf(paramInt)))) {
      ((XWalkExtendPluginNativeViewClient)this.mNativeViewClientMap.get(Integer.valueOf(paramInt))).getRootView().dispatchTouchEvent(paramMotionEvent);
    }
    AppMethodBeat.o(183753);
  }
  
  public void onPluginTouch(String paramString1, int paramInt, String paramString2) {}
  
  public void setPluginTextureScale(String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(154722);
    if (this.xwebType == 0) {
      try
      {
        Log.i("XWalkExtendPluginClient", "setPluginTextureScale, embed_type:" + paramString + ",embed_id:" + paramInt + ",xScale:" + paramFloat1 + ",yScale:" + paramFloat2);
        this.setPluginTextureScaleStringintfloatfloatMethod.invoke(new Object[] { paramString, Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
        AppMethodBeat.o(154722);
        return;
      }
      catch (UnsupportedOperationException paramString)
      {
        if (this.coreWrapper == null)
        {
          paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
          AppMethodBeat.o(154722);
          throw paramString;
        }
        XWalkCoreWrapper.handleRuntimeError(paramString);
        AppMethodBeat.o(154722);
        return;
      }
    }
    if (this.xwebType == 1) {
      this.psWebview.setPluginTextureScale(paramString, paramInt, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(154722);
  }
  
  public void takePluginScreenshot(String paramString, int paramInt)
  {
    AppMethodBeat.i(183754);
    if (this.xwebType == 0) {
      try
      {
        this.takePluginScreenshotStringintMethod.invoke(new Object[] { paramString, Integer.valueOf(paramInt) });
        AppMethodBeat.o(183754);
        return;
      }
      catch (UnsupportedOperationException paramString)
      {
        if (this.coreWrapper == null)
        {
          paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
          AppMethodBeat.o(183754);
          throw paramString;
        }
        XWalkCoreWrapper.handleRuntimeError(paramString);
        AppMethodBeat.o(183754);
        return;
      }
    }
    if (this.xwebType == 1) {
      this.psWebview.takePluginScreenshot(paramString, paramInt);
    }
    AppMethodBeat.o(183754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkExtendPluginClient
 * JD-Core Version:    0.7.0.1
 */