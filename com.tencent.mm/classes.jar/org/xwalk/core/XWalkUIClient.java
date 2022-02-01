package org.xwalk.core;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Map;

public class XWalkUIClient
{
  private static final String TAG = "XWalkUIClient";
  private LazyReflectMethod OnGetSampleStringXWalkViewInternalMapCallbackMethod;
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private LazyReflectMethod enumConsoleMessageTypeClassValueOfMethod;
  private LazyReflectMethod enumInitiateByClassValueOfMethod;
  private LazyReflectMethod enumJavascriptMessageTypeClassValueOfMethod;
  private LazyReflectMethod enumLoadStatusClassValueOfMethod;
  private LazyReflectMethod getVideoLoadingProgressViewMethod;
  private LazyReflectMethod isSearchableMethod;
  private LazyReflectMethod onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod;
  private LazyReflectMethod onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod;
  private LazyReflectMethod onDidChangeThemeColorXWalkViewInternalStringMessageMethod;
  private LazyReflectMethod onFullscreenToggledXWalkViewInternalbooleanMethod;
  private LazyReflectMethod onGeolocationPermissionsHidePromptMethod;
  private LazyReflectMethod onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod;
  private LazyReflectMethod onGetTranslateStringXWalkViewInternalMapCallbackMethod;
  private LazyReflectMethod onHideCustomViewMethod;
  private LazyReflectMethod onIconAvailableXWalkViewInternalStringMessageMethod;
  private LazyReflectMethod onJavascriptCloseWindowXWalkViewInternalMethod;
  private LazyReflectMethod onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod;
  private LazyReflectMethod onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod;
  private LazyReflectMethod onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod;
  private LazyReflectMethod onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod;
  private LazyReflectMethod onPageCommitVisibleXWalkViewInternalStringMethod;
  private LazyReflectMethod onPageLoadStartedXWalkViewInternalStringMethod;
  private LazyReflectMethod onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod;
  private LazyReflectMethod onReceivedIconXWalkViewInternalStringBitmapMethod;
  private LazyReflectMethod onReceivedTitleXWalkViewInternalStringMethod;
  private LazyReflectMethod onRequestFocusXWalkViewInternalMethod;
  private LazyReflectMethod onScaleChangedXWalkViewInternalfloatfloatMethod;
  private LazyReflectMethod onSearchWordXWalkViewInternalStringStringStringCallbackMethod;
  private LazyReflectMethod onSelectInfoChangedXWalkViewInternallongStringStringStringCallbackMethod;
  private LazyReflectMethod onShowCustomViewViewCustomViewCallbackInternalMethod;
  private LazyReflectMethod onShowCustomViewViewintCustomViewCallbackInternalMethod;
  private LazyReflectMethod onShowFileChooserXWalkViewInternalValueCallbackStringStringMethod;
  private LazyReflectMethod onShowSosMethod;
  private LazyReflectMethod onUnhandledKeyEventXWalkViewInternalKeyEventMethod;
  private LazyReflectMethod openFileChooserXWalkViewInternalValueCallbackStringStringMethod;
  private LazyReflectMethod postWrapperMethod;
  private LazyReflectMethod shouldOverrideKeyEventXWalkViewInternalKeyEventMethod;
  
  static
  {
    AppMethodBeat.i(154999);
    if (!XWalkUIClient.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(154999);
      return;
    }
  }
  
  public XWalkUIClient(XWalkView paramXWalkView)
  {
    AppMethodBeat.i(154965);
    this.enumJavascriptMessageTypeClassValueOfMethod = new LazyReflectMethod();
    this.enumConsoleMessageTypeClassValueOfMethod = new LazyReflectMethod();
    this.enumInitiateByClassValueOfMethod = new LazyReflectMethod();
    this.enumLoadStatusClassValueOfMethod = new LazyReflectMethod();
    this.onSelectInfoChangedXWalkViewInternallongStringStringStringCallbackMethod = new LazyReflectMethod(null, "onSelectInfoChanged", new Class[0]);
    this.isSearchableMethod = new LazyReflectMethod(null, "isSearchable", new Class[0]);
    this.onShowSosMethod = new LazyReflectMethod(null, "onShowSos", new Class[0]);
    this.onSearchWordXWalkViewInternalStringStringStringCallbackMethod = new LazyReflectMethod(null, "onSearchWord", new Class[0]);
    this.onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod = new LazyReflectMethod(null, "onCreateWindowRequested", new Class[0]);
    this.onDidChangeThemeColorXWalkViewInternalStringMessageMethod = new LazyReflectMethod(null, "onDidChangeThemeColor", new Class[0]);
    this.onIconAvailableXWalkViewInternalStringMessageMethod = new LazyReflectMethod(null, "onIconAvailable", new Class[0]);
    this.onReceivedIconXWalkViewInternalStringBitmapMethod = new LazyReflectMethod(null, "onReceivedIcon", new Class[0]);
    this.onRequestFocusXWalkViewInternalMethod = new LazyReflectMethod(null, "onRequestFocus", new Class[0]);
    this.onJavascriptCloseWindowXWalkViewInternalMethod = new LazyReflectMethod(null, "onJavascriptCloseWindow", new Class[0]);
    this.onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod = new LazyReflectMethod(null, "onJavascriptModalDialog", new Class[0]);
    this.onFullscreenToggledXWalkViewInternalbooleanMethod = new LazyReflectMethod(null, "onFullscreenToggled", new Class[0]);
    this.openFileChooserXWalkViewInternalValueCallbackStringStringMethod = new LazyReflectMethod(null, "openFileChooser", new Class[0]);
    this.onShowFileChooserXWalkViewInternalValueCallbackStringStringMethod = new LazyReflectMethod(null, "onShowFileChooser", new Class[0]);
    this.onScaleChangedXWalkViewInternalfloatfloatMethod = new LazyReflectMethod(null, "onScaleChanged", new Class[0]);
    this.shouldOverrideKeyEventXWalkViewInternalKeyEventMethod = new LazyReflectMethod(null, "shouldOverrideKeyEvent", new Class[0]);
    this.onUnhandledKeyEventXWalkViewInternalKeyEventMethod = new LazyReflectMethod(null, "onUnhandledKeyEvent", new Class[0]);
    this.onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod = new LazyReflectMethod(null, "onConsoleMessage", new Class[0]);
    this.onReceivedTitleXWalkViewInternalStringMethod = new LazyReflectMethod(null, "onReceivedTitle", new Class[0]);
    this.onPageLoadStartedXWalkViewInternalStringMethod = new LazyReflectMethod(null, "onPageLoadStarted", new Class[0]);
    this.onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod = new LazyReflectMethod(null, "onPageLoadStopped", new Class[0]);
    this.onPageCommitVisibleXWalkViewInternalStringMethod = new LazyReflectMethod(null, "onPageCommitVisible", new Class[0]);
    this.onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod = new LazyReflectMethod(null, "onJsAlert", new Class[0]);
    this.onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod = new LazyReflectMethod(null, "onJsConfirm", new Class[0]);
    this.onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod = new LazyReflectMethod(null, "onJsPrompt", new Class[0]);
    this.onShowCustomViewViewCustomViewCallbackInternalMethod = new LazyReflectMethod(null, "onShowCustomView", new Class[0]);
    this.onShowCustomViewViewintCustomViewCallbackInternalMethod = new LazyReflectMethod(null, "onShowCustomView", new Class[0]);
    this.onHideCustomViewMethod = new LazyReflectMethod(null, "onHideCustomView", new Class[0]);
    this.onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod = new LazyReflectMethod(null, "onGeolocationPermissionsShowPrompt", new Class[0]);
    this.onGeolocationPermissionsHidePromptMethod = new LazyReflectMethod(null, "onGeolocationPermissionsHidePrompt", new Class[0]);
    this.getVideoLoadingProgressViewMethod = new LazyReflectMethod(null, "getVideoLoadingProgressView", new Class[0]);
    this.onGetTranslateStringXWalkViewInternalMapCallbackMethod = new LazyReflectMethod(null, "onGetTranslateString", new Class[0]);
    this.OnGetSampleStringXWalkViewInternalMapCallbackMethod = new LazyReflectMethod(null, "OnGetSampleString", new Class[0]);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add("XWalkViewBridge");
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramXWalkView);
    reflectionInit();
    AppMethodBeat.o(154965);
  }
  
  private Object ConvertConsoleMessageType(ConsoleMessageType paramConsoleMessageType)
  {
    AppMethodBeat.i(154962);
    paramConsoleMessageType = this.enumConsoleMessageTypeClassValueOfMethod.invoke(new Object[] { paramConsoleMessageType.toString() });
    AppMethodBeat.o(154962);
    return paramConsoleMessageType;
  }
  
  private Object ConvertInitiateBy(XWalkUIClient.InitiateBy paramInitiateBy)
  {
    AppMethodBeat.i(154963);
    paramInitiateBy = this.enumInitiateByClassValueOfMethod.invoke(new Object[] { paramInitiateBy.toString() });
    AppMethodBeat.o(154963);
    return paramInitiateBy;
  }
  
  private Object ConvertJavascriptMessageType(XWalkUIClient.JavascriptMessageType paramJavascriptMessageType)
  {
    AppMethodBeat.i(154961);
    paramJavascriptMessageType = this.enumJavascriptMessageTypeClassValueOfMethod.invoke(new Object[] { paramJavascriptMessageType.toString() });
    AppMethodBeat.o(154961);
    return paramJavascriptMessageType;
  }
  
  private Object ConvertLoadStatus(XWalkUIClient.LoadStatus paramLoadStatus)
  {
    AppMethodBeat.i(154964);
    paramLoadStatus = this.enumLoadStatusClassValueOfMethod.invoke(new Object[] { paramLoadStatus.toString() });
    AppMethodBeat.o(154964);
    return paramLoadStatus;
  }
  
  private void reflectionInit()
  {
    AppMethodBeat.i(154998);
    if (XWalkCoreWrapper.getInstance() == null)
    {
      XWalkReflectionInitHandler.reserveReflectObject(this);
      AppMethodBeat.o(154998);
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
      label135:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof Class)) {
            break label135;
          }
          localObject1[i] = ((Class)localObject2);
        }
      } while ($assertionsDisabled);
      localObject1 = new AssertionError();
      AppMethodBeat.o(154998);
      throw ((Throwable)localObject1);
    }
    localObject1[j] = Object.class;
    this.constructorParams.add(this);
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkUIClientBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      if (this.postWrapperMethod != null) {
        this.postWrapperMethod.invoke(new Object[0]);
      }
      this.enumJavascriptMessageTypeClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$JavascriptMessageTypeInternal"), "valueOf", new Class[] { String.class });
      this.enumConsoleMessageTypeClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$ConsoleMessageType"), "valueOf", new Class[] { String.class });
      this.enumInitiateByClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$InitiateByInternal"), "valueOf", new Class[] { String.class });
      this.enumLoadStatusClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$LoadStatusInternal"), "valueOf", new Class[] { String.class });
      this.onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod.init(this.bridge, null, "onCreateWindowRequestedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkUIClientInternal$InitiateByInternal"), ValueCallback.class });
      this.onDidChangeThemeColorXWalkViewInternalStringMessageMethod.init(this.bridge, null, "onDidChangeThemeColorSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Integer.TYPE });
      this.onIconAvailableXWalkViewInternalStringMessageMethod.init(this.bridge, null, "onIconAvailableSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Message.class });
      this.onReceivedIconXWalkViewInternalStringBitmapMethod.init(this.bridge, null, "onReceivedIconSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Bitmap.class });
      this.onRequestFocusXWalkViewInternalMethod.init(this.bridge, null, "onRequestFocusSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge") });
      this.onJavascriptCloseWindowXWalkViewInternalMethod.init(this.bridge, null, "onJavascriptCloseWindowSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge") });
      this.onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJavascriptModalDialogSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkUIClientInternal$JavascriptMessageTypeInternal"), String.class, String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge") });
      this.onFullscreenToggledXWalkViewInternalbooleanMethod.init(this.bridge, null, "onFullscreenToggledSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Boolean.TYPE });
      this.openFileChooserXWalkViewInternalValueCallbackStringStringMethod.init(this.bridge, null, "openFileChooserSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), ValueCallback.class, String.class, String.class });
      this.onShowFileChooserXWalkViewInternalValueCallbackStringStringMethod.init(this.bridge, null, "onShowFileChooser", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), ValueCallback.class, WebChromeClient.FileChooserParams.class });
      this.onScaleChangedXWalkViewInternalfloatfloatMethod.init(this.bridge, null, "onScaleChangedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Float.TYPE, Float.TYPE });
      this.shouldOverrideKeyEventXWalkViewInternalKeyEventMethod.init(this.bridge, null, "shouldOverrideKeyEventSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), KeyEvent.class });
      this.onUnhandledKeyEventXWalkViewInternalKeyEventMethod.init(this.bridge, null, "onUnhandledKeyEventSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), KeyEvent.class });
      this.onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod.init(this.bridge, null, "onConsoleMessageSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Integer.TYPE, String.class, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$ConsoleMessageType") });
      this.onReceivedTitleXWalkViewInternalStringMethod.init(this.bridge, null, "onReceivedTitleSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class });
      this.onPageLoadStartedXWalkViewInternalStringMethod.init(this.bridge, null, "onPageLoadStartedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class });
      this.onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod.init(this.bridge, null, "onPageLoadStoppedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$LoadStatusInternal") });
      this.onPageCommitVisibleXWalkViewInternalStringMethod.init(this.bridge, null, "onPageCommitVisibleSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class });
      this.onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJsAlertSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge") });
      this.onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJsConfirmSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge") });
      this.onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJsPromptSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge") });
      this.onShowCustomViewViewCustomViewCallbackInternalMethod.init(this.bridge, null, "onShowCustomViewSuper", new Class[] { View.class, this.coreWrapper.getBridgeClass("CustomViewCallbackHandlerBridge") });
      this.onShowCustomViewViewintCustomViewCallbackInternalMethod.init(this.bridge, null, "onShowCustomViewSuper", new Class[] { View.class, Integer.TYPE, this.coreWrapper.getBridgeClass("CustomViewCallbackHandlerBridge") });
      this.onHideCustomViewMethod.init(this.bridge, null, "onHideCustomViewSuper", new Class[0]);
      this.onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod.init(this.bridge, null, "onGeolocationPermissionsShowPromptSuper", new Class[] { String.class, this.coreWrapper.getBridgeClass("XWalkGeolocationPermissionsCallbackHandlerBridge") });
      this.onGeolocationPermissionsHidePromptMethod.init(this.bridge, null, "onGeolocationPermissionsHidePromptSuper", new Class[0]);
      this.getVideoLoadingProgressViewMethod.init(this.bridge, null, "getVideoLoadingProgressView", new Class[0]);
      this.onSelectInfoChangedXWalkViewInternallongStringStringStringCallbackMethod.init(this.bridge, null, "onSelectInfoChanged", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Long.TYPE, String.class, String.class, String.class });
      this.isSearchableMethod.init(this.bridge, null, "isSearchable", new Class[0]);
      this.onShowSosMethod.init(this.bridge, null, "onShowSos", new Class[0]);
      this.onSearchWordXWalkViewInternalStringStringStringCallbackMethod.init(this.bridge, null, "onSearchWord", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, String.class });
      this.onGetTranslateStringXWalkViewInternalMapCallbackMethod.init(this.bridge, null, "onGetTranslateString", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Map.class });
      this.OnGetSampleStringXWalkViewInternalMapCallbackMethod.init(this.bridge, null, "OnGetSampleString", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Map.class });
      AppMethodBeat.o(154998);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      Log.e("XWalkUIClient", "reflectionInit, error:".concat(String.valueOf(localUnsupportedOperationException)));
      AppMethodBeat.o(154998);
    }
  }
  
  public boolean OnGetSampleString(XWalkView paramXWalkView, Map<String, String> paramMap)
  {
    AppMethodBeat.i(154997);
    try
    {
      boolean bool = ((Boolean)this.OnGetSampleStringXWalkViewInternalMapCallbackMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramMap })).booleanValue();
      AppMethodBeat.o(154997);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154997);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154997);
    }
    return false;
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public View getVideoLoadingProgressView()
  {
    AppMethodBeat.i(154995);
    try
    {
      View localView = (View)this.getVideoLoadingProgressViewMethod.invoke(new Object[0]);
      AppMethodBeat.o(154995);
      return localView;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154995);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154995);
    }
    return null;
  }
  
  public boolean isSearchable()
  {
    AppMethodBeat.i(154967);
    try
    {
      boolean bool = ((Boolean)this.isSearchableMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154967);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154967);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154967);
    }
    return false;
  }
  
  public void onClearCurrentPage() {}
  
  public boolean onConsoleMessage(XWalkView paramXWalkView, String paramString1, int paramInt, String paramString2, ConsoleMessageType paramConsoleMessageType)
  {
    AppMethodBeat.i(154982);
    try
    {
      boolean bool = ((Boolean)this.onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString1, Integer.valueOf(paramInt), paramString2, ConvertConsoleMessageType(paramConsoleMessageType) })).booleanValue();
      AppMethodBeat.o(154982);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154982);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154982);
    }
    return false;
  }
  
  public boolean onCreateWindowRequested(XWalkView paramXWalkView, XWalkUIClient.InitiateBy paramInitiateBy, ValueCallback<XWalkView> paramValueCallback)
  {
    AppMethodBeat.i(154970);
    try
    {
      boolean bool = ((Boolean)this.onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod.invoke(new Object[] { paramXWalkView.getBridge(), ConvertInitiateBy(paramInitiateBy), paramValueCallback })).booleanValue();
      AppMethodBeat.o(154970);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154970);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154970);
    }
    return false;
  }
  
  public void onDidChangeThemeColor(XWalkView paramXWalkView, int paramInt)
  {
    AppMethodBeat.i(154971);
    try
    {
      this.onDidChangeThemeColorXWalkViewInternalStringMessageMethod.invoke(new Object[] { paramXWalkView.getBridge(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(154971);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154971);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154971);
    }
  }
  
  public void onExitFullscreenVideo(Bitmap paramBitmap) {}
  
  public void onFullscreenToggled(XWalkView paramXWalkView, boolean paramBoolean)
  {
    AppMethodBeat.i(154977);
    try
    {
      this.onFullscreenToggledXWalkViewInternalbooleanMethod.invoke(new Object[] { paramXWalkView.getBridge(), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154977);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154977);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154977);
    }
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    AppMethodBeat.i(154994);
    try
    {
      this.onGeolocationPermissionsHidePromptMethod.invoke(new Object[0]);
      AppMethodBeat.o(154994);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154994);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154994);
    }
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, XWalkGeolocationPermissionsCallback paramXWalkGeolocationPermissionsCallback)
  {
    AppMethodBeat.i(154993);
    try
    {
      this.onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod.invoke(new Object[] { paramString, ((XWalkGeolocationPermissionsCallbackHandler)paramXWalkGeolocationPermissionsCallback).getBridge() });
      AppMethodBeat.o(154993);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154993);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154993);
    }
  }
  
  public boolean onGetTranslateString(XWalkView paramXWalkView, Map<String, String> paramMap)
  {
    AppMethodBeat.i(154996);
    try
    {
      boolean bool = ((Boolean)this.onGetTranslateStringXWalkViewInternalMapCallbackMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramMap })).booleanValue();
      AppMethodBeat.o(154996);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154996);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154996);
    }
    return false;
  }
  
  public void onHideCustomView()
  {
    AppMethodBeat.i(154992);
    try
    {
      this.onHideCustomViewMethod.invoke(new Object[0]);
      AppMethodBeat.o(154992);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154992);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154992);
    }
  }
  
  public void onIconAvailable(XWalkView paramXWalkView, String paramString, Message paramMessage)
  {
    AppMethodBeat.i(154972);
    try
    {
      this.onIconAvailableXWalkViewInternalStringMessageMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString, paramMessage });
      AppMethodBeat.o(154972);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154972);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154972);
    }
  }
  
  public void onJavascriptCloseWindow(XWalkView paramXWalkView)
  {
    AppMethodBeat.i(154975);
    try
    {
      this.onJavascriptCloseWindowXWalkViewInternalMethod.invoke(new Object[] { paramXWalkView.getBridge() });
      AppMethodBeat.o(154975);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154975);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154975);
    }
  }
  
  public boolean onJavascriptModalDialog(XWalkView paramXWalkView, XWalkUIClient.JavascriptMessageType paramJavascriptMessageType, String paramString1, String paramString2, String paramString3, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(154976);
    try
    {
      boolean bool = ((Boolean)this.onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), ConvertJavascriptMessageType(paramJavascriptMessageType), paramString1, paramString2, paramString3, ((XWalkJavascriptResultHandler)paramXWalkJavascriptResult).getBridge() })).booleanValue();
      AppMethodBeat.o(154976);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154976);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154976);
    }
    return false;
  }
  
  public boolean onJsAlert(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(154987);
    try
    {
      boolean bool = ((Boolean)this.onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString1, paramString2, ((XWalkJavascriptResultHandler)paramXWalkJavascriptResult).getBridge() })).booleanValue();
      AppMethodBeat.o(154987);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154987);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154987);
    }
    return false;
  }
  
  public boolean onJsConfirm(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(154988);
    try
    {
      boolean bool = ((Boolean)this.onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString1, paramString2, ((XWalkJavascriptResultHandler)paramXWalkJavascriptResult).getBridge() })).booleanValue();
      AppMethodBeat.o(154988);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154988);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154988);
    }
    return false;
  }
  
  public boolean onJsPrompt(XWalkView paramXWalkView, String paramString1, String paramString2, String paramString3, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(154989);
    try
    {
      boolean bool = ((Boolean)this.onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString1, paramString2, paramString3, ((XWalkJavascriptResultHandler)paramXWalkJavascriptResult).getBridge() })).booleanValue();
      AppMethodBeat.o(154989);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154989);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154989);
    }
    return false;
  }
  
  public void onPageCommitVisible(XWalkView paramXWalkView, String paramString)
  {
    AppMethodBeat.i(154986);
    try
    {
      this.onPageCommitVisibleXWalkViewInternalStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString });
      AppMethodBeat.o(154986);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154986);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154986);
    }
  }
  
  public void onPageLoadStarted(XWalkView paramXWalkView, String paramString)
  {
    AppMethodBeat.i(154984);
    try
    {
      this.onPageLoadStartedXWalkViewInternalStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString });
      AppMethodBeat.o(154984);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154984);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154984);
    }
  }
  
  public void onPageLoadStopped(XWalkView paramXWalkView, String paramString, XWalkUIClient.LoadStatus paramLoadStatus)
  {
    AppMethodBeat.i(154985);
    try
    {
      this.onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString, ConvertLoadStatus(paramLoadStatus) });
      AppMethodBeat.o(154985);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154985);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154985);
    }
  }
  
  public void onPermissionRequest(PermissionRequest paramPermissionRequest)
  {
    AppMethodBeat.i(187687);
    paramPermissionRequest.deny();
    AppMethodBeat.o(187687);
  }
  
  public void onPermissionRequestCanceled(PermissionRequest paramPermissionRequest) {}
  
  public void onReceivedIcon(XWalkView paramXWalkView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(154973);
    try
    {
      this.onReceivedIconXWalkViewInternalStringBitmapMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString, paramBitmap });
      AppMethodBeat.o(154973);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154973);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154973);
    }
  }
  
  public void onReceivedTitle(XWalkView paramXWalkView, String paramString)
  {
    AppMethodBeat.i(154983);
    try
    {
      this.onReceivedTitleXWalkViewInternalStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString });
      AppMethodBeat.o(154983);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154983);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154983);
    }
  }
  
  public void onRequestFocus(XWalkView paramXWalkView)
  {
    AppMethodBeat.i(154974);
    try
    {
      this.onRequestFocusXWalkViewInternalMethod.invoke(new Object[] { paramXWalkView.getBridge() });
      AppMethodBeat.o(154974);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154974);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154974);
    }
  }
  
  public void onScaleChanged(XWalkView paramXWalkView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(154979);
    try
    {
      this.onScaleChangedXWalkViewInternalfloatfloatMethod.invoke(new Object[] { paramXWalkView.getBridge(), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
      AppMethodBeat.o(154979);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154979);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154979);
    }
  }
  
  public boolean onSearchWord(XWalkView paramXWalkView, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(154969);
    try
    {
      boolean bool = ((Boolean)this.onSearchWordXWalkViewInternalStringStringStringCallbackMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString1, paramString2, paramString3 })).booleanValue();
      AppMethodBeat.o(154969);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154969);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154969);
    }
    return false;
  }
  
  public boolean onSelectInfoChanged(XWalkView paramXWalkView, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(154966);
    try
    {
      boolean bool = ((Boolean)this.onSelectInfoChangedXWalkViewInternallongStringStringStringCallbackMethod.invoke(new Object[] { paramXWalkView.getBridge(), Long.valueOf(paramLong), paramString1, paramString2, paramString3 })).booleanValue();
      AppMethodBeat.o(154966);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154966);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154966);
    }
    return false;
  }
  
  public void onShowCustomView(View paramView, int paramInt, CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(154991);
    try
    {
      this.onShowCustomViewViewintCustomViewCallbackInternalMethod.invoke(new Object[] { paramView, Integer.valueOf(paramInt), ((CustomViewCallbackHandler)paramCustomViewCallback).getBridge() });
      AppMethodBeat.o(154991);
      return;
    }
    catch (UnsupportedOperationException paramView)
    {
      if (this.coreWrapper == null)
      {
        paramView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154991);
        throw paramView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramView);
      AppMethodBeat.o(154991);
    }
  }
  
  public void onShowCustomView(View paramView, CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(154990);
    try
    {
      this.onShowCustomViewViewCustomViewCallbackInternalMethod.invoke(new Object[] { paramView, ((CustomViewCallbackHandler)paramCustomViewCallback).getBridge() });
      AppMethodBeat.o(154990);
      return;
    }
    catch (UnsupportedOperationException paramView)
    {
      if (this.coreWrapper == null)
      {
        paramView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154990);
        throw paramView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramView);
      AppMethodBeat.o(154990);
    }
  }
  
  public boolean onShowFileChooser(XWalkView paramXWalkView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    AppMethodBeat.i(187604);
    try
    {
      boolean bool = ((Boolean)this.onShowFileChooserXWalkViewInternalValueCallbackStringStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramValueCallback, paramFileChooserParams })).booleanValue();
      AppMethodBeat.o(187604);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(187604);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(187604);
    }
    return false;
  }
  
  public void onShowSos()
  {
    AppMethodBeat.i(154968);
    try
    {
      this.onShowSosMethod.invoke(new Object[0]);
      AppMethodBeat.o(154968);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154968);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154968);
    }
  }
  
  public void onUnhandledKeyEvent(XWalkView paramXWalkView, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(154981);
    try
    {
      this.onUnhandledKeyEventXWalkViewInternalKeyEventMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramKeyEvent });
      AppMethodBeat.o(154981);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154981);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154981);
    }
  }
  
  public void openFileChooser(XWalkView paramXWalkView, ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(154978);
    try
    {
      this.openFileChooserXWalkViewInternalValueCallbackStringStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramValueCallback, paramString1, paramString2 });
      AppMethodBeat.o(154978);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154978);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154978);
    }
  }
  
  public boolean shouldDiscardCurrentPage()
  {
    return false;
  }
  
  public boolean shouldOverrideKeyEvent(XWalkView paramXWalkView, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(154980);
    try
    {
      boolean bool = ((Boolean)this.shouldOverrideKeyEventXWalkViewInternalKeyEventMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramKeyEvent })).booleanValue();
      AppMethodBeat.o(154980);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154980);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154980);
    }
    return false;
  }
  
  public static enum ConsoleMessageType
  {
    static
    {
      AppMethodBeat.i(154951);
      DEBUG = new ConsoleMessageType("DEBUG", 0);
      ERROR = new ConsoleMessageType("ERROR", 1);
      LOG = new ConsoleMessageType("LOG", 2);
      INFO = new ConsoleMessageType("INFO", 3);
      WARNING = new ConsoleMessageType("WARNING", 4);
      $VALUES = new ConsoleMessageType[] { DEBUG, ERROR, LOG, INFO, WARNING };
      AppMethodBeat.o(154951);
    }
    
    private ConsoleMessageType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkUIClient
 * JD-Core Version:    0.7.0.1
 */