package com.tencent.xweb.pinus.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Message;
import android.print.PrintDocumentAdapter;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeProvider;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebExtendInterface;
import java.util.ArrayList;
import java.util.Map;
import org.xwalk.core.ReflectConstructor;
import org.xwalk.core.XWalkExtendInputClient;
import org.xwalk.core.XWalkExtendPluginClient;
import org.xwalk.core.XWalkExtendTextAreaClient;
import org.xwalk.core.XWalkProxyWebViewClientExtension;

public class WebView
  extends FrameLayout
  implements XWebExtendInterface, WebViewInterface
{
  private static final String TAG = "Pinus.Webview";
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private PSCoreWrapper coreWrapper;
  private Object inner;
  private OverScrolledListener mOverScrolledListener;
  private ScrollChangedListener mScrollChangedListener;
  private WebViewInterface reflectInterface;
  private WebSettingsInterface webSettings;
  
  static
  {
    AppMethodBeat.i(213587);
    if (!WebView.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(213587);
      return;
    }
  }
  
  public WebView(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(213545);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add(Context.class);
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramContext);
    init();
    AppMethodBeat.o(213545);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, null);
    AppMethodBeat.i(213557);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add(Context.class);
    this.constructorTypes.add(AttributeSet.class);
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramContext);
    this.constructorParams.add(paramAttributeSet);
    init();
    AppMethodBeat.o(213557);
  }
  
  private void init()
  {
    AppMethodBeat.i(213570);
    this.coreWrapper = PSCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      AppMethodBeat.o(213570);
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
      label130:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof Class)) {
            break label130;
          }
          localObject1[i] = ((Class)localObject2);
        }
      } while ($assertionsDisabled);
      localObject1 = new AssertionError();
      AppMethodBeat.o(213570);
      throw ((Throwable)localObject1);
    }
    localObject1[j] = Object.class;
    this.constructorParams.add(this);
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("PSWebview"), (Class[])localObject1);
    try
    {
      this.inner = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      addView((FrameLayout)this.inner, new FrameLayout.LayoutParams(-1, -1));
      this.reflectInterface = new WebViewInterfaceImpl(this.inner);
      this.webSettings = new WebSettingsInterfaceImpl(this.reflectInterface.getSettingsInner());
      AppMethodBeat.o(213570);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      AppMethodBeat.o(213570);
    }
  }
  
  private boolean performLongClickDelegate()
  {
    AppMethodBeat.i(213578);
    boolean bool = performLongClick();
    AppMethodBeat.o(213578);
    return bool;
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(213620);
    this.reflectInterface.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(213620);
  }
  
  public boolean canGoBack()
  {
    AppMethodBeat.i(213629);
    boolean bool = this.reflectInterface.canGoBack();
    AppMethodBeat.o(213629);
    return bool;
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    AppMethodBeat.i(213639);
    boolean bool = this.reflectInterface.canGoBackOrForward(paramInt);
    AppMethodBeat.o(213639);
    return bool;
  }
  
  public boolean canGoForward()
  {
    AppMethodBeat.i(213649);
    boolean bool = this.reflectInterface.canGoForward();
    AppMethodBeat.o(213649);
    return bool;
  }
  
  public void clearCache(boolean paramBoolean)
  {
    AppMethodBeat.i(213655);
    this.reflectInterface.clearCache(paramBoolean);
    AppMethodBeat.o(213655);
  }
  
  public void clearFormData()
  {
    AppMethodBeat.i(213663);
    this.reflectInterface.clearFormData();
    AppMethodBeat.o(213663);
  }
  
  public void clearHistory()
  {
    AppMethodBeat.i(213672);
    this.reflectInterface.clearHistory();
    AppMethodBeat.o(213672);
  }
  
  public void clearMatches()
  {
    AppMethodBeat.i(213678);
    this.reflectInterface.clearMatches();
    AppMethodBeat.o(213678);
  }
  
  public void clearSslPreferences()
  {
    AppMethodBeat.i(213685);
    this.reflectInterface.clearSslPreferences();
    AppMethodBeat.o(213685);
  }
  
  public void clearView()
  {
    AppMethodBeat.i(213693);
    this.reflectInterface.clearView();
    AppMethodBeat.o(213693);
  }
  
  public int computeHorizontalScrollOffset()
  {
    AppMethodBeat.i(214424);
    int i = view_computeHorizontalScrollOffset();
    AppMethodBeat.o(214424);
    return i;
  }
  
  public int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(214433);
    int i = view_computeHorizontalScrollRange();
    AppMethodBeat.o(214433);
    return i;
  }
  
  public int computeVerticalScrollExtent()
  {
    AppMethodBeat.i(214446);
    int i = view_computeVerticalScrollExtent();
    AppMethodBeat.o(214446);
    return i;
  }
  
  public int computeVerticalScrollOffset()
  {
    AppMethodBeat.i(214460);
    int i = view_computeVerticalScrollOffset();
    AppMethodBeat.o(214460);
    return i;
  }
  
  public int computeVerticalScrollRange()
  {
    AppMethodBeat.i(214472);
    int i = view_computeVerticalScrollRange();
    AppMethodBeat.o(214472);
    return i;
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(213700);
    WebBackForwardList localWebBackForwardList = this.reflectInterface.copyBackForwardList();
    AppMethodBeat.o(213700);
    return localWebBackForwardList;
  }
  
  public PrintDocumentAdapter createPrintDocumentAdapter(String paramString)
  {
    AppMethodBeat.i(213707);
    paramString = this.reflectInterface.createPrintDocumentAdapter(paramString);
    AppMethodBeat.o(213707);
    return paramString;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(213715);
    this.reflectInterface.destroy();
    AppMethodBeat.o(213715);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(213724);
    boolean bool = this.reflectInterface.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(213724);
    return bool;
  }
  
  public void documentHasImages(Message paramMessage)
  {
    AppMethodBeat.i(213730);
    this.reflectInterface.documentHasImages(paramMessage);
    AppMethodBeat.o(213730);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(213740);
    this.reflectInterface.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(213740);
  }
  
  public void findAllAsync(String paramString)
  {
    AppMethodBeat.i(213753);
    this.reflectInterface.findAllAsync(paramString);
    AppMethodBeat.o(213753);
  }
  
  public void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(213761);
    this.reflectInterface.findNext(paramBoolean);
    AppMethodBeat.o(213761);
  }
  
  public void flingScroll(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213767);
    this.reflectInterface.flingScroll(paramInt1, paramInt2);
    AppMethodBeat.o(213767);
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider()
  {
    AppMethodBeat.i(213778);
    AccessibilityNodeProvider localAccessibilityNodeProvider = this.reflectInterface.getAccessibilityNodeProvider();
    AppMethodBeat.o(213778);
    return localAccessibilityNodeProvider;
  }
  
  public Object getBridge()
  {
    return this.inner;
  }
  
  public SslCertificate getCertificate()
  {
    AppMethodBeat.i(213787);
    SslCertificate localSslCertificate = this.reflectInterface.getCertificate();
    AppMethodBeat.o(213787);
    return localSslCertificate;
  }
  
  public int getContentHeight()
  {
    AppMethodBeat.i(213795);
    int i = this.reflectInterface.getContentHeight();
    AppMethodBeat.o(213795);
    return i;
  }
  
  public ViewGroup getContentView()
  {
    AppMethodBeat.i(214133);
    ViewGroup localViewGroup = this.reflectInterface.getContentView();
    AppMethodBeat.o(214133);
    return localViewGroup;
  }
  
  public Bitmap getFavicon()
  {
    AppMethodBeat.i(213805);
    Bitmap localBitmap = this.reflectInterface.getFavicon();
    AppMethodBeat.o(213805);
    return localBitmap;
  }
  
  public HitTestResultInterface getHitTestResult()
  {
    AppMethodBeat.i(213611);
    HitTestResultInterfaceImpl localHitTestResultInterfaceImpl = new HitTestResultInterfaceImpl(this.reflectInterface.getHitTestResultInner());
    AppMethodBeat.o(213611);
    return localHitTestResultInterfaceImpl;
  }
  
  public Object getHitTestResultInner()
  {
    AppMethodBeat.i(213812);
    Object localObject = this.reflectInterface.getHitTestResultInner();
    AppMethodBeat.o(213812);
    return localObject;
  }
  
  public boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    AppMethodBeat.i(214247);
    boolean bool = this.reflectInterface.getImageBitmapToFile(paramString1, paramString2, paramString3, paramObject);
    AppMethodBeat.o(214247);
    return bool;
  }
  
  public String getOriginalUrl()
  {
    AppMethodBeat.i(213820);
    String str = this.reflectInterface.getOriginalUrl();
    AppMethodBeat.o(213820);
    return str;
  }
  
  public int getProgress()
  {
    AppMethodBeat.i(213829);
    int i = this.reflectInterface.getProgress();
    AppMethodBeat.o(213829);
    return i;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(213837);
    float f = this.reflectInterface.getScale();
    AppMethodBeat.o(213837);
    return f;
  }
  
  public WebSettingsInterface getSettings()
  {
    return this.webSettings;
  }
  
  public Object getSettingsInner()
  {
    AppMethodBeat.i(213842);
    Object localObject = this.reflectInterface.getSettingsInner();
    AppMethodBeat.o(213842);
    return localObject;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(213847);
    String str = this.reflectInterface.getTitle();
    AppMethodBeat.o(213847);
    return str;
  }
  
  public void getTranslateSampleString(int paramInt)
  {
    AppMethodBeat.i(214335);
    this.reflectInterface.getTranslateSampleString(paramInt);
    AppMethodBeat.o(214335);
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(213854);
    String str = this.reflectInterface.getUrl();
    AppMethodBeat.o(213854);
    return str;
  }
  
  public void goBack()
  {
    AppMethodBeat.i(213861);
    this.reflectInterface.goBack();
    AppMethodBeat.o(213861);
  }
  
  public void goBackOrForward(int paramInt)
  {
    AppMethodBeat.i(213870);
    this.reflectInterface.goBackOrForward(paramInt);
    AppMethodBeat.o(213870);
  }
  
  public void goForward()
  {
    AppMethodBeat.i(213875);
    this.reflectInterface.goForward();
    AppMethodBeat.o(213875);
  }
  
  public void invokeZoomPicker()
  {
    AppMethodBeat.i(213880);
    this.reflectInterface.invokeZoomPicker();
    AppMethodBeat.o(213880);
  }
  
  public boolean isPrivateBrowsingEnabled()
  {
    AppMethodBeat.i(213886);
    boolean bool = this.reflectInterface.isPrivateBrowsingEnabled();
    AppMethodBeat.o(213886);
    return bool;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(213890);
    this.reflectInterface.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(213890);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(213896);
    this.reflectInterface.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(213896);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(213902);
    this.reflectInterface.loadUrl(paramString);
    AppMethodBeat.o(213902);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(213908);
    this.reflectInterface.loadUrl(paramString, paramMap);
    AppMethodBeat.o(213908);
  }
  
  public boolean onCheckIsTextEditor()
  {
    AppMethodBeat.i(213912);
    boolean bool = this.reflectInterface.onCheckIsTextEditor();
    AppMethodBeat.o(213912);
    return bool;
  }
  
  public void onExtendTextAreaKeyboardHeightChanged(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(214237);
    this.reflectInterface.onExtendTextAreaKeyboardHeightChanged(paramBoolean1, paramInt, paramBoolean2);
    AppMethodBeat.o(214237);
  }
  
  public void onHide()
  {
    AppMethodBeat.i(214506);
    this.reflectInterface.onHide();
    AppMethodBeat.o(214506);
  }
  
  public void onOverScrolledDelegate(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(214414);
    if (this.mOverScrolledListener != null) {
      this.mOverScrolledListener.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    }
    AppMethodBeat.o(214414);
  }
  
  public void onOverscrollRefresh(boolean paramBoolean)
  {
    AppMethodBeat.i(214391);
    if (this.mOverScrolledListener != null) {
      this.mOverScrolledListener.onOverScrolled(paramBoolean);
    }
    AppMethodBeat.o(214391);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(213917);
    this.reflectInterface.onPause();
    AppMethodBeat.o(213917);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(213920);
    this.reflectInterface.onResume();
    AppMethodBeat.o(213920);
  }
  
  public void onScrollChangedDelegate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(214373);
    onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mScrollChangedListener != null) {
      this.mScrollChangedListener.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(214373);
  }
  
  public void onShow()
  {
    AppMethodBeat.i(214520);
    this.reflectInterface.onShow();
    AppMethodBeat.o(214520);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(214592);
    boolean bool = this.reflectInterface.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(214592);
    return bool;
  }
  
  public boolean overScrollByDelegate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(214403);
    if (this.mOverScrolledListener != null)
    {
      paramBoolean = this.mOverScrolledListener.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
      AppMethodBeat.o(214403);
      return paramBoolean;
    }
    AppMethodBeat.o(214403);
    return false;
  }
  
  public boolean pageDown(boolean paramBoolean)
  {
    AppMethodBeat.i(213928);
    paramBoolean = this.reflectInterface.pageDown(paramBoolean);
    AppMethodBeat.o(213928);
    return paramBoolean;
  }
  
  public boolean pageUp(boolean paramBoolean)
  {
    AppMethodBeat.i(213936);
    paramBoolean = this.reflectInterface.pageUp(paramBoolean);
    AppMethodBeat.o(213936);
    return paramBoolean;
  }
  
  public void pauseTimers()
  {
    AppMethodBeat.i(213944);
    this.reflectInterface.pauseTimers();
    AppMethodBeat.o(213944);
  }
  
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(213951);
    this.reflectInterface.postUrl(paramString, paramArrayOfByte);
    AppMethodBeat.o(213951);
  }
  
  public void reload()
  {
    AppMethodBeat.i(213956);
    this.reflectInterface.reload();
    AppMethodBeat.o(213956);
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(213965);
    this.reflectInterface.removeJavascriptInterface(paramString);
    AppMethodBeat.o(213965);
  }
  
  public void replaceTranslatedString(Map<String, String> paramMap)
  {
    AppMethodBeat.i(214356);
    this.reflectInterface.replaceTranslatedString(paramMap);
    AppMethodBeat.o(214356);
  }
  
  public void requestFocusNodeHref(Message paramMessage)
  {
    AppMethodBeat.i(213972);
    this.reflectInterface.requestFocusNodeHref(paramMessage);
    AppMethodBeat.o(213972);
  }
  
  public void requestImageRef(Message paramMessage)
  {
    AppMethodBeat.i(213980);
    this.reflectInterface.requestImageRef(paramMessage);
    AppMethodBeat.o(213980);
  }
  
  public WebBackForwardList restoreState(Bundle paramBundle)
  {
    AppMethodBeat.i(213984);
    paramBundle = this.reflectInterface.restoreState(paramBundle);
    AppMethodBeat.o(213984);
    return paramBundle;
  }
  
  public void resumeTimers()
  {
    AppMethodBeat.i(213992);
    this.reflectInterface.resumeTimers();
    AppMethodBeat.o(213992);
  }
  
  public boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(214543);
    boolean bool = this.reflectInterface.savePage(paramString1, paramString2, paramInt);
    AppMethodBeat.o(214543);
    return bool;
  }
  
  public WebBackForwardList saveState(Bundle paramBundle)
  {
    AppMethodBeat.i(214001);
    paramBundle = this.reflectInterface.saveState(paramBundle);
    AppMethodBeat.o(214001);
    return paramBundle;
  }
  
  public void saveWebArchive(String paramString)
  {
    AppMethodBeat.i(214007);
    this.reflectInterface.saveWebArchive(paramString);
    AppMethodBeat.o(214007);
  }
  
  public void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(214016);
    this.reflectInterface.saveWebArchive(paramString, paramBoolean, paramValueCallback);
    AppMethodBeat.o(214016);
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214496);
    view_scrollBy(paramInt1, paramInt2);
    AppMethodBeat.o(214496);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214482);
    view_scrollTo(paramInt1, paramInt2);
    AppMethodBeat.o(214482);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(214023);
    this.reflectInterface.setBackgroundColor(paramInt);
    AppMethodBeat.o(214023);
  }
  
  public void setBottomHeight(int paramInt)
  {
    AppMethodBeat.i(214534);
    this.reflectInterface.setBottomHeight(paramInt);
    AppMethodBeat.o(214534);
  }
  
  public void setCustomOnOverScrolledListener(OverScrolledListener paramOverScrolledListener)
  {
    this.mOverScrolledListener = paramOverScrolledListener;
  }
  
  public void setCustomOnScrollChangedListener(ScrollChangedListener paramScrollChangedListener)
  {
    this.mScrollChangedListener = paramScrollChangedListener;
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(214031);
    this.reflectInterface.setDownloadListener(paramDownloadListener);
    AppMethodBeat.o(214031);
  }
  
  public void setExtendInputClient(XWalkExtendInputClient paramXWalkExtendInputClient) {}
  
  public void setExtendPluginClient(Object paramObject)
  {
    AppMethodBeat.i(214144);
    this.reflectInterface.setExtendPluginClient(paramObject);
    AppMethodBeat.o(214144);
  }
  
  public void setExtendPluginClient(XWalkExtendPluginClient paramXWalkExtendPluginClient)
  {
    AppMethodBeat.i(214152);
    setExtendPluginClient(paramXWalkExtendPluginClient);
    AppMethodBeat.o(214152);
  }
  
  public void setExtendTextAreaClient(Object paramObject)
  {
    AppMethodBeat.i(214185);
    this.reflectInterface.setExtendTextAreaClient(paramObject);
    AppMethodBeat.o(214185);
  }
  
  public void setExtendTextAreaClient(XWalkExtendTextAreaClient paramXWalkExtendTextAreaClient)
  {
    AppMethodBeat.i(214195);
    setExtendTextAreaClient(paramXWalkExtendTextAreaClient);
    AppMethodBeat.o(214195);
  }
  
  public void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(214037);
    this.reflectInterface.setFindListener(paramFindListener);
    AppMethodBeat.o(214037);
  }
  
  public void setHorizontalScrollBarEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(214571);
    this.reflectInterface.setHorizontalScrollBarEnable(paramBoolean);
    AppMethodBeat.o(214571);
  }
  
  public void setInitialScale(int paramInt)
  {
    AppMethodBeat.i(214046);
    this.reflectInterface.setInitialScale(paramInt);
    AppMethodBeat.o(214046);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    AppMethodBeat.i(214057);
    this.reflectInterface.setNetworkAvailable(paramBoolean);
    AppMethodBeat.o(214057);
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(214552);
    this.reflectInterface.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(214552);
  }
  
  public void setPluginTextureScale(String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(214164);
    this.reflectInterface.setPluginTextureScale(paramString, paramInt, paramFloat1, paramFloat2);
    AppMethodBeat.o(214164);
  }
  
  public void setProxyWebViewClientExtension(Object paramObject)
  {
    AppMethodBeat.i(214216);
    this.reflectInterface.setProxyWebViewClientExtension(paramObject);
    AppMethodBeat.o(214216);
  }
  
  public void setProxyWebViewClientExtension(XWalkProxyWebViewClientExtension paramXWalkProxyWebViewClientExtension)
  {
    AppMethodBeat.i(214227);
    setProxyWebViewClientExtension(paramXWalkProxyWebViewClientExtension);
    AppMethodBeat.o(214227);
  }
  
  public void setTranslateMode(boolean paramBoolean)
  {
    AppMethodBeat.i(214345);
    this.reflectInterface.setTranslateMode(paramBoolean);
    AppMethodBeat.o(214345);
  }
  
  public void setVerticalScrollBarEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(214561);
    this.reflectInterface.setVerticalScrollBarEnable(paramBoolean);
    AppMethodBeat.o(214561);
  }
  
  public void setWebChromeClient(Object paramObject)
  {
    AppMethodBeat.i(214065);
    this.reflectInterface.setWebChromeClient(paramObject);
    AppMethodBeat.o(214065);
  }
  
  public void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(214074);
    this.reflectInterface.setWebContentsDebuggingEnabled(paramBoolean);
    AppMethodBeat.o(214074);
  }
  
  public void setWebContentsSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214584);
    this.reflectInterface.setWebContentsSize(paramInt1, paramInt2);
    AppMethodBeat.o(214584);
  }
  
  public void setWebViewClient(Object paramObject)
  {
    AppMethodBeat.i(214087);
    this.reflectInterface.setWebViewClient(paramObject);
    AppMethodBeat.o(214087);
  }
  
  public void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(214324);
    this.reflectInterface.smoothScroll(paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(214324);
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(214096);
    this.reflectInterface.stopLoading();
    AppMethodBeat.o(214096);
  }
  
  public void takePluginScreenshot(String paramString, int paramInt)
  {
    AppMethodBeat.i(214175);
    this.reflectInterface.takePluginScreenshot(paramString, paramInt);
    AppMethodBeat.o(214175);
  }
  
  public int view_computeHorizontalScrollOffset()
  {
    AppMethodBeat.i(214264);
    int i = this.reflectInterface.view_computeHorizontalScrollOffset();
    AppMethodBeat.o(214264);
    return i;
  }
  
  public int view_computeHorizontalScrollRange()
  {
    AppMethodBeat.i(214272);
    int i = this.reflectInterface.view_computeHorizontalScrollRange();
    AppMethodBeat.o(214272);
    return i;
  }
  
  public int view_computeVerticalScrollExtent()
  {
    AppMethodBeat.i(214283);
    int i = this.reflectInterface.view_computeVerticalScrollExtent();
    AppMethodBeat.o(214283);
    return i;
  }
  
  public int view_computeVerticalScrollOffset()
  {
    AppMethodBeat.i(214255);
    int i = this.reflectInterface.view_computeVerticalScrollOffset();
    AppMethodBeat.o(214255);
    return i;
  }
  
  public int view_computeVerticalScrollRange()
  {
    AppMethodBeat.i(214294);
    int i = this.reflectInterface.view_computeVerticalScrollRange();
    AppMethodBeat.o(214294);
    return i;
  }
  
  public void view_scrollBy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214315);
    this.reflectInterface.view_scrollBy(paramInt1, paramInt2);
    AppMethodBeat.o(214315);
  }
  
  public void view_scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214302);
    this.reflectInterface.view_scrollTo(paramInt1, paramInt2);
    AppMethodBeat.o(214302);
  }
  
  public void zoomBy(float paramFloat)
  {
    AppMethodBeat.i(214105);
    this.reflectInterface.zoomBy(paramFloat);
    AppMethodBeat.o(214105);
  }
  
  public boolean zoomIn()
  {
    AppMethodBeat.i(214115);
    boolean bool = this.reflectInterface.zoomIn();
    AppMethodBeat.o(214115);
    return bool;
  }
  
  public boolean zoomOut()
  {
    AppMethodBeat.i(214126);
    boolean bool = this.reflectInterface.zoomOut();
    AppMethodBeat.o(214126);
    return bool;
  }
  
  public static abstract interface OverScrolledListener
  {
    public abstract void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView);
    
    public abstract void onOverScrolled(boolean paramBoolean);
    
    public abstract boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView);
  }
  
  public static abstract interface ScrollChangedListener
  {
    public abstract void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.WebView
 * JD-Core Version:    0.7.0.1
 */