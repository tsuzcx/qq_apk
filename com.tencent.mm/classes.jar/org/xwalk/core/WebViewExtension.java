package org.xwalk.core;

import android.content.res.Resources;
import java.util.ArrayList;
import java.util.Map;

public class WebViewExtension
{
  public static final String EXTENSION_ADD_FILTER_RESOURCES = "AddFilterResources";
  private static final String TAG = "XWalkLib.WebViewExtension";
  private static WebViewExtensionInterface mWebViewExtensionInterface;
  private static WebViewExtensionListener mWebViewExtensionListener;
  private static WebViewExtension sInstance;
  private ReflectMethod SetExtensionMethod = new ReflectMethod(null, "SetExtension", new Class[0]);
  private Object bridge;
  private ArrayList<Object> constructorParams = new ArrayList();
  private ArrayList<Object> constructorTypes = new ArrayList();
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod postWrapperMethod;
  
  static
  {
    if (!WebViewExtension.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public WebViewExtension()
  {
    reflectionInit();
  }
  
  public static void SetExtension(WebViewExtensionListener paramWebViewExtensionListener)
  {
    Log.i("XWalkLib.WebViewExtension", "SetExtension WebViewExtensionInterface");
    mWebViewExtensionListener = paramWebViewExtensionListener;
    try
    {
      updateExtension(true);
      return;
    }
    catch (Exception paramWebViewExtensionListener)
    {
      Log.i("XWalkLib.WebViewExtension", "SetExtension refelction not ready, updateExtension when available:" + paramWebViewExtensionListener.getMessage());
    }
  }
  
  public static boolean addFilterResources(Resources paramResources, Map<Long, Integer> paramMap)
  {
    return invokeExtensionMethod("AddFilterResources", new Object[] { paramResources, paramMap });
  }
  
  private static WebViewExtension getInstance()
  {
    if (sInstance == null) {
      sInstance = new WebViewExtension();
    }
    return sInstance;
  }
  
  public static boolean invokeExtensionMethod(String paramString, Object... paramVarArgs)
  {
    if (mWebViewExtensionListener != null)
    {
      mWebViewExtensionListener.onMiscCallBack(paramString, paramVarArgs);
      return true;
    }
    Log.e("XWalkLib.WebViewExtension", "InvokeExtensionMethod interface is null,method:" + paramString);
    return false;
  }
  
  public static void updateExtension(boolean paramBoolean)
  {
    if ((mWebViewExtensionListener != null) && ((paramBoolean == true) || (mWebViewExtensionInterface == null)))
    {
      getInstance();
      Log.i("XWalkLib.WebViewExtension", "updateExtension");
      mWebViewExtensionInterface = new WebViewExtension.1();
      getInstance().SetExtensionMethod.invoke(new Object[] { mWebViewExtensionInterface.getBridge() });
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
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
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("WebViewExtensionBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      if (this.postWrapperMethod != null) {
        this.postWrapperMethod.invoke(new Object[0]);
      }
      this.SetExtensionMethod.init(this.bridge, null, "SetExtensionSuper", new Class[] { this.coreWrapper.getBridgeClass("WebViewExtensionInterfaceBridge") });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.xwalk.core.WebViewExtension
 * JD-Core Version:    0.7.0.1
 */