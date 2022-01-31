package org.xwalk.core;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Map;

public class XWalkUIClient
{
  private ReflectMethod OnGetSampleStringXWalkViewInternalMapCallbackMethod;
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod enumConsoleMessageTypeClassValueOfMethod;
  private ReflectMethod enumInitiateByClassValueOfMethod;
  private ReflectMethod enumJavascriptMessageTypeClassValueOfMethod;
  private ReflectMethod enumLoadStatusClassValueOfMethod;
  private ReflectMethod getVideoLoadingProgressViewMethod;
  private ReflectMethod isSearchableMethod;
  private ReflectMethod onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod;
  private ReflectMethod onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod;
  private ReflectMethod onDidChangeThemeColorXWalkViewInternalStringMessageMethod;
  private ReflectMethod onFullscreenToggledXWalkViewInternalbooleanMethod;
  private ReflectMethod onGeolocationPermissionsHidePromptMethod;
  private ReflectMethod onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod;
  private ReflectMethod onGetTranslateStringXWalkViewInternalMapCallbackMethod;
  private ReflectMethod onHideCustomViewMethod;
  private ReflectMethod onIconAvailableXWalkViewInternalStringMessageMethod;
  private ReflectMethod onJavascriptCloseWindowXWalkViewInternalMethod;
  private ReflectMethod onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod;
  private ReflectMethod onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod;
  private ReflectMethod onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod;
  private ReflectMethod onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod;
  private ReflectMethod onPageLoadStartedXWalkViewInternalStringMethod;
  private ReflectMethod onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod;
  private ReflectMethod onReceivedIconXWalkViewInternalStringBitmapMethod;
  private ReflectMethod onReceivedTitleXWalkViewInternalStringMethod;
  private ReflectMethod onRequestFocusXWalkViewInternalMethod;
  private ReflectMethod onScaleChangedXWalkViewInternalfloatfloatMethod;
  private ReflectMethod onSearchWordXWalkViewInternalStringStringStringCallbackMethod;
  private ReflectMethod onSelectInfoChangedXWalkViewInternallongStringStringStringCallbackMethod;
  private ReflectMethod onShowCustomViewViewCustomViewCallbackInternalMethod;
  private ReflectMethod onShowCustomViewViewintCustomViewCallbackInternalMethod;
  private ReflectMethod onShowSosMethod;
  private ReflectMethod onUnhandledKeyEventXWalkViewInternalKeyEventMethod;
  private ReflectMethod openFileChooserXWalkViewInternalValueCallbackStringStringMethod;
  private ReflectMethod postWrapperMethod;
  private ReflectMethod shouldOverrideKeyEventXWalkViewInternalKeyEventMethod;
  
  static
  {
    AppMethodBeat.i(85895);
    if (!XWalkUIClient.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(85895);
      return;
    }
  }
  
  public XWalkUIClient(XWalkView paramXWalkView)
  {
    AppMethodBeat.i(85864);
    this.enumJavascriptMessageTypeClassValueOfMethod = new ReflectMethod();
    this.enumConsoleMessageTypeClassValueOfMethod = new ReflectMethod();
    this.enumInitiateByClassValueOfMethod = new ReflectMethod();
    this.enumLoadStatusClassValueOfMethod = new ReflectMethod();
    this.onSelectInfoChangedXWalkViewInternallongStringStringStringCallbackMethod = new ReflectMethod(null, "onSelectInfoChanged", new Class[0]);
    this.isSearchableMethod = new ReflectMethod(null, "isSearchable", new Class[0]);
    this.onShowSosMethod = new ReflectMethod(null, "onShowSos", new Class[0]);
    this.onSearchWordXWalkViewInternalStringStringStringCallbackMethod = new ReflectMethod(null, "onSearchWord", new Class[0]);
    this.onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod = new ReflectMethod(null, "onCreateWindowRequested", new Class[0]);
    this.onDidChangeThemeColorXWalkViewInternalStringMessageMethod = new ReflectMethod(null, "onDidChangeThemeColor", new Class[0]);
    this.onIconAvailableXWalkViewInternalStringMessageMethod = new ReflectMethod(null, "onIconAvailable", new Class[0]);
    this.onReceivedIconXWalkViewInternalStringBitmapMethod = new ReflectMethod(null, "onReceivedIcon", new Class[0]);
    this.onRequestFocusXWalkViewInternalMethod = new ReflectMethod(null, "onRequestFocus", new Class[0]);
    this.onJavascriptCloseWindowXWalkViewInternalMethod = new ReflectMethod(null, "onJavascriptCloseWindow", new Class[0]);
    this.onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod = new ReflectMethod(null, "onJavascriptModalDialog", new Class[0]);
    this.onFullscreenToggledXWalkViewInternalbooleanMethod = new ReflectMethod(null, "onFullscreenToggled", new Class[0]);
    this.openFileChooserXWalkViewInternalValueCallbackStringStringMethod = new ReflectMethod(null, "openFileChooser", new Class[0]);
    this.onScaleChangedXWalkViewInternalfloatfloatMethod = new ReflectMethod(null, "onScaleChanged", new Class[0]);
    this.shouldOverrideKeyEventXWalkViewInternalKeyEventMethod = new ReflectMethod(null, "shouldOverrideKeyEvent", new Class[0]);
    this.onUnhandledKeyEventXWalkViewInternalKeyEventMethod = new ReflectMethod(null, "onUnhandledKeyEvent", new Class[0]);
    this.onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod = new ReflectMethod(null, "onConsoleMessage", new Class[0]);
    this.onReceivedTitleXWalkViewInternalStringMethod = new ReflectMethod(null, "onReceivedTitle", new Class[0]);
    this.onPageLoadStartedXWalkViewInternalStringMethod = new ReflectMethod(null, "onPageLoadStarted", new Class[0]);
    this.onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod = new ReflectMethod(null, "onPageLoadStopped", new Class[0]);
    this.onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod = new ReflectMethod(null, "onJsAlert", new Class[0]);
    this.onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod = new ReflectMethod(null, "onJsConfirm", new Class[0]);
    this.onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod = new ReflectMethod(null, "onJsPrompt", new Class[0]);
    this.onShowCustomViewViewCustomViewCallbackInternalMethod = new ReflectMethod(null, "onShowCustomView", new Class[0]);
    this.onShowCustomViewViewintCustomViewCallbackInternalMethod = new ReflectMethod(null, "onShowCustomView", new Class[0]);
    this.onHideCustomViewMethod = new ReflectMethod(null, "onHideCustomView", new Class[0]);
    this.onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod = new ReflectMethod(null, "onGeolocationPermissionsShowPrompt", new Class[0]);
    this.getVideoLoadingProgressViewMethod = new ReflectMethod(null, "getVideoLoadingProgressView", new Class[0]);
    this.onGeolocationPermissionsHidePromptMethod = new ReflectMethod(null, "onGeolocationPermissionsHidePrompt", new Class[0]);
    this.onGetTranslateStringXWalkViewInternalMapCallbackMethod = new ReflectMethod(null, "onGetTranslateString", new Class[0]);
    this.OnGetSampleStringXWalkViewInternalMapCallbackMethod = new ReflectMethod(null, "OnGetSampleString", new Class[0]);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add("XWalkViewBridge");
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramXWalkView);
    reflectionInit();
    AppMethodBeat.o(85864);
  }
  
  private Object ConvertConsoleMessageType(XWalkUIClient.ConsoleMessageType paramConsoleMessageType)
  {
    AppMethodBeat.i(85861);
    paramConsoleMessageType = this.enumConsoleMessageTypeClassValueOfMethod.invoke(new Object[] { paramConsoleMessageType.toString() });
    AppMethodBeat.o(85861);
    return paramConsoleMessageType;
  }
  
  private Object ConvertInitiateBy(XWalkUIClient.InitiateBy paramInitiateBy)
  {
    AppMethodBeat.i(85862);
    paramInitiateBy = this.enumInitiateByClassValueOfMethod.invoke(new Object[] { paramInitiateBy.toString() });
    AppMethodBeat.o(85862);
    return paramInitiateBy;
  }
  
  private Object ConvertJavascriptMessageType(XWalkUIClient.JavascriptMessageType paramJavascriptMessageType)
  {
    AppMethodBeat.i(85860);
    paramJavascriptMessageType = this.enumJavascriptMessageTypeClassValueOfMethod.invoke(new Object[] { paramJavascriptMessageType.toString() });
    AppMethodBeat.o(85860);
    return paramJavascriptMessageType;
  }
  
  private Object ConvertLoadStatus(XWalkUIClient.LoadStatus paramLoadStatus)
  {
    AppMethodBeat.i(85863);
    paramLoadStatus = this.enumLoadStatusClassValueOfMethod.invoke(new Object[] { paramLoadStatus.toString() });
    AppMethodBeat.o(85863);
    return paramLoadStatus;
  }
  
  public boolean OnGetSampleString(XWalkView paramXWalkView, Map<String, String> paramMap)
  {
    AppMethodBeat.i(139612);
    try
    {
      boolean bool = ((Boolean)this.OnGetSampleStringXWalkViewInternalMapCallbackMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramMap })).booleanValue();
      AppMethodBeat.o(139612);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(139612);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(139612);
    }
    return false;
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public View getVideoLoadingProgressView()
  {
    AppMethodBeat.i(85893);
    try
    {
      View localView = (View)this.getVideoLoadingProgressViewMethod.invoke(new Object[0]);
      AppMethodBeat.o(85893);
      return localView;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85893);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85893);
    }
    return null;
  }
  
  public boolean isSearchable()
  {
    AppMethodBeat.i(85866);
    try
    {
      boolean bool = ((Boolean)this.isSearchableMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85866);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85866);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85866);
    }
    return false;
  }
  
  public void onClearCurrentPage() {}
  
  public boolean onConsoleMessage(XWalkView paramXWalkView, String paramString1, int paramInt, String paramString2, XWalkUIClient.ConsoleMessageType paramConsoleMessageType)
  {
    AppMethodBeat.i(85881);
    try
    {
      boolean bool = ((Boolean)this.onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString1, Integer.valueOf(paramInt), paramString2, ConvertConsoleMessageType(paramConsoleMessageType) })).booleanValue();
      AppMethodBeat.o(85881);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85881);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85881);
    }
    return false;
  }
  
  public boolean onCreateWindowRequested(XWalkView paramXWalkView, XWalkUIClient.InitiateBy paramInitiateBy, ValueCallback<XWalkView> paramValueCallback)
  {
    AppMethodBeat.i(85869);
    try
    {
      boolean bool = ((Boolean)this.onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod.invoke(new Object[] { paramXWalkView.getBridge(), ConvertInitiateBy(paramInitiateBy), paramValueCallback })).booleanValue();
      AppMethodBeat.o(85869);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85869);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85869);
    }
    return false;
  }
  
  public void onDidChangeThemeColor(XWalkView paramXWalkView, int paramInt)
  {
    AppMethodBeat.i(85870);
    try
    {
      this.onDidChangeThemeColorXWalkViewInternalStringMessageMethod.invoke(new Object[] { paramXWalkView.getBridge(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(85870);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85870);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85870);
    }
  }
  
  public void onFullscreenToggled(XWalkView paramXWalkView, boolean paramBoolean)
  {
    AppMethodBeat.i(85876);
    try
    {
      this.onFullscreenToggledXWalkViewInternalbooleanMethod.invoke(new Object[] { paramXWalkView.getBridge(), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85876);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85876);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85876);
    }
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    AppMethodBeat.i(85892);
    try
    {
      this.onGeolocationPermissionsHidePromptMethod.invoke(new Object[0]);
      AppMethodBeat.o(85892);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85892);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85892);
    }
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, XWalkGeolocationPermissionsCallback paramXWalkGeolocationPermissionsCallback)
  {
    AppMethodBeat.i(85891);
    try
    {
      this.onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod.invoke(new Object[] { paramString, ((XWalkGeolocationPermissionsCallbackHandler)paramXWalkGeolocationPermissionsCallback).getBridge() });
      AppMethodBeat.o(85891);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85891);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85891);
    }
  }
  
  public boolean onGetTranslateString(XWalkView paramXWalkView, Map<String, String> paramMap)
  {
    AppMethodBeat.i(139611);
    try
    {
      boolean bool = ((Boolean)this.onGetTranslateStringXWalkViewInternalMapCallbackMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramMap })).booleanValue();
      AppMethodBeat.o(139611);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(139611);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(139611);
    }
    return false;
  }
  
  public void onHideCustomView()
  {
    AppMethodBeat.i(85890);
    try
    {
      this.onHideCustomViewMethod.invoke(new Object[0]);
      AppMethodBeat.o(85890);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85890);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85890);
    }
  }
  
  public void onIconAvailable(XWalkView paramXWalkView, String paramString, Message paramMessage)
  {
    AppMethodBeat.i(85871);
    try
    {
      this.onIconAvailableXWalkViewInternalStringMessageMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString, paramMessage });
      AppMethodBeat.o(85871);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85871);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85871);
    }
  }
  
  public void onJavascriptCloseWindow(XWalkView paramXWalkView)
  {
    AppMethodBeat.i(85874);
    try
    {
      this.onJavascriptCloseWindowXWalkViewInternalMethod.invoke(new Object[] { paramXWalkView.getBridge() });
      AppMethodBeat.o(85874);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85874);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85874);
    }
  }
  
  public boolean onJavascriptModalDialog(XWalkView paramXWalkView, XWalkUIClient.JavascriptMessageType paramJavascriptMessageType, String paramString1, String paramString2, String paramString3, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(85875);
    try
    {
      boolean bool = ((Boolean)this.onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), ConvertJavascriptMessageType(paramJavascriptMessageType), paramString1, paramString2, paramString3, ((XWalkJavascriptResultHandler)paramXWalkJavascriptResult).getBridge() })).booleanValue();
      AppMethodBeat.o(85875);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85875);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85875);
    }
    return false;
  }
  
  public boolean onJsAlert(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(85885);
    try
    {
      boolean bool = ((Boolean)this.onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString1, paramString2, ((XWalkJavascriptResultHandler)paramXWalkJavascriptResult).getBridge() })).booleanValue();
      AppMethodBeat.o(85885);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85885);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85885);
    }
    return false;
  }
  
  public boolean onJsConfirm(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(85886);
    try
    {
      boolean bool = ((Boolean)this.onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString1, paramString2, ((XWalkJavascriptResultHandler)paramXWalkJavascriptResult).getBridge() })).booleanValue();
      AppMethodBeat.o(85886);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85886);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85886);
    }
    return false;
  }
  
  public boolean onJsPrompt(XWalkView paramXWalkView, String paramString1, String paramString2, String paramString3, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(85887);
    try
    {
      boolean bool = ((Boolean)this.onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString1, paramString2, paramString3, ((XWalkJavascriptResultHandler)paramXWalkJavascriptResult).getBridge() })).booleanValue();
      AppMethodBeat.o(85887);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85887);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85887);
    }
    return false;
  }
  
  public void onPageLoadStarted(XWalkView paramXWalkView, String paramString)
  {
    AppMethodBeat.i(85883);
    try
    {
      this.onPageLoadStartedXWalkViewInternalStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString });
      AppMethodBeat.o(85883);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85883);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85883);
    }
  }
  
  public void onPageLoadStopped(XWalkView paramXWalkView, String paramString, XWalkUIClient.LoadStatus paramLoadStatus)
  {
    AppMethodBeat.i(85884);
    try
    {
      this.onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString, ConvertLoadStatus(paramLoadStatus) });
      AppMethodBeat.o(85884);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85884);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85884);
    }
  }
  
  public void onReceivedIcon(XWalkView paramXWalkView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(85872);
    try
    {
      this.onReceivedIconXWalkViewInternalStringBitmapMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString, paramBitmap });
      AppMethodBeat.o(85872);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85872);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85872);
    }
  }
  
  public void onReceivedTitle(XWalkView paramXWalkView, String paramString)
  {
    AppMethodBeat.i(85882);
    try
    {
      this.onReceivedTitleXWalkViewInternalStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString });
      AppMethodBeat.o(85882);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85882);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85882);
    }
  }
  
  public void onRequestFocus(XWalkView paramXWalkView)
  {
    AppMethodBeat.i(85873);
    try
    {
      this.onRequestFocusXWalkViewInternalMethod.invoke(new Object[] { paramXWalkView.getBridge() });
      AppMethodBeat.o(85873);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85873);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85873);
    }
  }
  
  public void onScaleChanged(XWalkView paramXWalkView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(85878);
    try
    {
      this.onScaleChangedXWalkViewInternalfloatfloatMethod.invoke(new Object[] { paramXWalkView.getBridge(), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
      AppMethodBeat.o(85878);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85878);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85878);
    }
  }
  
  public boolean onSearchWord(XWalkView paramXWalkView, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(85868);
    try
    {
      boolean bool = ((Boolean)this.onSearchWordXWalkViewInternalStringStringStringCallbackMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString1, paramString2, paramString3 })).booleanValue();
      AppMethodBeat.o(85868);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85868);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85868);
    }
    return false;
  }
  
  public boolean onSelectInfoChanged(XWalkView paramXWalkView, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(85865);
    try
    {
      boolean bool = ((Boolean)this.onSelectInfoChangedXWalkViewInternallongStringStringStringCallbackMethod.invoke(new Object[] { paramXWalkView.getBridge(), Long.valueOf(paramLong), paramString1, paramString2, paramString3 })).booleanValue();
      AppMethodBeat.o(85865);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85865);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85865);
    }
    return false;
  }
  
  public void onShowCustomView(View paramView, int paramInt, CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(85889);
    try
    {
      this.onShowCustomViewViewintCustomViewCallbackInternalMethod.invoke(new Object[] { paramView, Integer.valueOf(paramInt), ((CustomViewCallbackHandler)paramCustomViewCallback).getBridge() });
      AppMethodBeat.o(85889);
      return;
    }
    catch (UnsupportedOperationException paramView)
    {
      if (this.coreWrapper == null)
      {
        paramView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85889);
        throw paramView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramView);
      AppMethodBeat.o(85889);
    }
  }
  
  public void onShowCustomView(View paramView, CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(85888);
    try
    {
      this.onShowCustomViewViewCustomViewCallbackInternalMethod.invoke(new Object[] { paramView, ((CustomViewCallbackHandler)paramCustomViewCallback).getBridge() });
      AppMethodBeat.o(85888);
      return;
    }
    catch (UnsupportedOperationException paramView)
    {
      if (this.coreWrapper == null)
      {
        paramView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85888);
        throw paramView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramView);
      AppMethodBeat.o(85888);
    }
  }
  
  public void onShowSos()
  {
    AppMethodBeat.i(85867);
    try
    {
      this.onShowSosMethod.invoke(new Object[0]);
      AppMethodBeat.o(85867);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85867);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85867);
    }
  }
  
  public void onUnhandledKeyEvent(XWalkView paramXWalkView, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(85880);
    try
    {
      this.onUnhandledKeyEventXWalkViewInternalKeyEventMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramKeyEvent });
      AppMethodBeat.o(85880);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85880);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85880);
    }
  }
  
  public void openFileChooser(XWalkView paramXWalkView, ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(85877);
    try
    {
      this.openFileChooserXWalkViewInternalValueCallbackStringStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramValueCallback, paramString1, paramString2 });
      AppMethodBeat.o(85877);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85877);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85877);
    }
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(85894);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(85894);
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
      label139:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof Class)) {
            break label139;
          }
          localObject1[i] = ((Class)localObject2);
        }
      } while ($assertionsDisabled);
      localObject1 = new AssertionError();
      AppMethodBeat.o(85894);
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
      this.onScaleChangedXWalkViewInternalfloatfloatMethod.init(this.bridge, null, "onScaleChangedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Float.TYPE, Float.TYPE });
      this.shouldOverrideKeyEventXWalkViewInternalKeyEventMethod.init(this.bridge, null, "shouldOverrideKeyEventSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), KeyEvent.class });
      this.onUnhandledKeyEventXWalkViewInternalKeyEventMethod.init(this.bridge, null, "onUnhandledKeyEventSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), KeyEvent.class });
      this.onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod.init(this.bridge, null, "onConsoleMessageSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Integer.TYPE, String.class, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$ConsoleMessageType") });
      this.onReceivedTitleXWalkViewInternalStringMethod.init(this.bridge, null, "onReceivedTitleSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class });
      this.onPageLoadStartedXWalkViewInternalStringMethod.init(this.bridge, null, "onPageLoadStartedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class });
      this.onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod.init(this.bridge, null, "onPageLoadStoppedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$LoadStatusInternal") });
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
      AppMethodBeat.o(85894);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      AppMethodBeat.o(85894);
    }
  }
  
  public boolean shouldDiscardCurrentPage()
  {
    return false;
  }
  
  public boolean shouldOverrideKeyEvent(XWalkView paramXWalkView, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(85879);
    try
    {
      boolean bool = ((Boolean)this.shouldOverrideKeyEventXWalkViewInternalKeyEventMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramKeyEvent })).booleanValue();
      AppMethodBeat.o(85879);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85879);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(85879);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.xwalk.core.XWalkUIClient
 * JD-Core Version:    0.7.0.1
 */