package org.xwalk.core;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebViewExtension
{
  public static final String EXTENSION_ADD_FILTER_RESOURCES = "AddFilterResources";
  private static final String TAG = "XWalkLib.WebViewExtension";
  private static WebViewExtensionInterface mWebViewExtensionInterface;
  private static WebViewExtensionListener mWebViewExtensionListener;
  private static WebViewExtension sInstance;
  private ReflectMethod SetExtensionMethod;
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod postWrapperMethod;
  
  static
  {
    AppMethodBeat.i(154624);
    if (!WebViewExtension.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(154624);
      return;
    }
  }
  
  public WebViewExtension()
  {
    AppMethodBeat.i(154618);
    this.SetExtensionMethod = new ReflectMethod(null, "SetExtension", new Class[0]);
    this.constructorTypes = new ArrayList();
    this.constructorParams = new ArrayList();
    reflectionInit();
    AppMethodBeat.o(154618);
  }
  
  public static void SetExtension(WebViewExtensionListener paramWebViewExtensionListener)
  {
    AppMethodBeat.i(154619);
    Log.i("XWalkLib.WebViewExtension", "SetExtension WebViewExtensionInterface");
    mWebViewExtensionListener = paramWebViewExtensionListener;
    try
    {
      updateExtension(true);
      AppMethodBeat.o(154619);
      return;
    }
    catch (Exception paramWebViewExtensionListener)
    {
      Log.i("XWalkLib.WebViewExtension", "SetExtension refelction not ready, updateExtension when available:" + paramWebViewExtensionListener.getMessage());
      AppMethodBeat.o(154619);
    }
  }
  
  public static boolean addFilterResources(Resources paramResources, Map<Long, Integer> paramMap)
  {
    AppMethodBeat.i(154621);
    boolean bool = invokeExtensionMethod("AddFilterResources", new Object[] { paramResources, paramMap });
    AppMethodBeat.o(154621);
    return bool;
  }
  
  private static WebViewExtension getInstance()
  {
    AppMethodBeat.i(154617);
    if (sInstance == null) {
      sInstance = new WebViewExtension();
    }
    WebViewExtension localWebViewExtension = sInstance;
    AppMethodBeat.o(154617);
    return localWebViewExtension;
  }
  
  public static boolean invokeExtensionMethod(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(154622);
    if (mWebViewExtensionListener != null)
    {
      mWebViewExtensionListener.onMiscCallBack(paramString, paramVarArgs);
      AppMethodBeat.o(154622);
      return true;
    }
    Log.e("XWalkLib.WebViewExtension", "InvokeExtensionMethod interface is null,method:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(154622);
    return false;
  }
  
  public static void updateExtension(boolean paramBoolean)
  {
    AppMethodBeat.i(154620);
    if ((mWebViewExtensionListener != null) && ((paramBoolean == true) || (mWebViewExtensionInterface == null)))
    {
      getInstance();
      Log.i("XWalkLib.WebViewExtension", "updateExtension");
      mWebViewExtensionInterface = new WebViewExtensionInterface()
      {
        public final int getHostByName(String paramAnonymousString, List<String> paramAnonymousList)
        {
          AppMethodBeat.i(154616);
          if (WebViewExtension.mWebViewExtensionListener != null)
          {
            int i = WebViewExtension.mWebViewExtensionListener.getHostByName(paramAnonymousString, paramAnonymousList);
            AppMethodBeat.o(154616);
            return i;
          }
          AppMethodBeat.o(154616);
          return 0;
        }
        
        public final Object onMiscCallBack(String paramAnonymousString, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(154615);
          if (WebViewExtension.mWebViewExtensionListener != null)
          {
            paramAnonymousString = WebViewExtension.mWebViewExtensionListener.onMiscCallBack(paramAnonymousString, paramAnonymousVarArgs);
            AppMethodBeat.o(154615);
            return paramAnonymousString;
          }
          AppMethodBeat.o(154615);
          return null;
        }
      };
      getInstance().SetExtensionMethod.invoke(new Object[] { mWebViewExtensionInterface.getBridge() });
    }
    AppMethodBeat.o(154620);
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(154623);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(154623);
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
      AppMethodBeat.o(154623);
      throw ((Throwable)localObject1);
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
      AppMethodBeat.o(154623);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      AppMethodBeat.o(154623);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.WebViewExtension
 * JD-Core Version:    0.7.0.1
 */