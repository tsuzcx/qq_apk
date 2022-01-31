package com.tencent.xweb.xwalk;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.a;
import com.tencent.xweb.c.f;
import com.tencent.xweb.c.i;
import com.tencent.xweb.c.i.a;
import com.tencent.xweb.extension.video.d;
import com.tencent.xweb.p;
import com.tencent.xweb.t;
import com.tencent.xweb.v;
import com.tencent.xweb.w;
import com.tencent.xweb.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkHitTestResult;
import org.xwalk.core.XWalkHitTestResult.type;
import org.xwalk.core.XWalkLibraryLoader;
import org.xwalk.core.XWalkNavigationHistory;
import org.xwalk.core.XWalkNavigationHistory.Direction;
import org.xwalk.core.XWalkNavigationItem;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkProxyWebViewClientExtension;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkView;
import org.xwalk.core.resource.XWalkContextWrapper;

public final class j
  implements i, com.tencent.xweb.c.j
{
  static int BJU = 0;
  private com.tencent.xweb.extension.video.b BHA;
  WebView BHt;
  long BHz;
  l BJD;
  m BJE;
  XWalkView BJF;
  k BJL;
  AbsoluteLayout BJM;
  g BJN;
  boolean BJO;
  private String BJP;
  private com.tencent.xweb.x5.a.a.a.a.b BJQ;
  private x BJR;
  private boolean BJS;
  private boolean BJT;
  private boolean BJV;
  v igO;
  w iyq;
  p iyr;
  int mApkVersion;
  private int type;
  private final int uNE;
  private final int uNF;
  private final int uNG;
  
  public j(WebView paramWebView)
  {
    AppMethodBeat.i(85299);
    this.iyq = new w();
    this.iyr = new p();
    this.BHz = 0L;
    this.type = 0;
    this.BJO = false;
    this.BJP = null;
    this.BJQ = new com.tencent.xweb.x5.a.a.a.a.b();
    this.BJR = null;
    this.uNE = 0;
    this.uNF = 1;
    this.uNG = 2;
    this.BJS = false;
    this.BJT = false;
    this.BJV = false;
    this.mApkVersion = XWalkEnvironment.getAvailableVersion();
    XWalkContextWrapper localXWalkContextWrapper = new XWalkContextWrapper(paramWebView.getContext(), this.mApkVersion);
    XWalkLibraryLoader.prepareToInit(localXWalkContextWrapper);
    try
    {
      XWalkPreferences.setValue("xweb-version", String.valueOf(this.mApkVersion));
      XWalkPreferences.setValue("xwebsdk-version", "190503");
      this.BJF = new j.a(this, localXWalkContextWrapper);
      this.BJM = new AbsoluteLayout(localXWalkContextWrapper);
      this.BJF.getXWalkContentView().addView(this.BJM);
      this.BJF.setCustomOnScrollChangedListener(new j.4(this));
      this.BJF.setCustomOnOverScrolledListener(new j.5(this));
      this.BJN = new g(this.BJF);
      this.BHt = paramWebView;
      this.BJL = new k(this.BJF);
      this.BJF.getSettings().SetLogCallBack(new j.6(this));
      paramWebView = this.BJF.getContext();
      Log.i("XWWebView", "initFullscreenVideo:" + getFullscreenVideoKind());
      this.BHA = com.tencent.xweb.extension.video.e.a(paramWebView, this.BHt, this.BJF, d.dYG());
      if (getFullscreenVideoKind() == WebView.a.BEn) {
        this.BHA.da(this.BJF);
      }
      AppMethodBeat.o(85299);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("XWWebView", localException.getMessage());
      }
    }
  }
  
  private void dau()
  {
    AppMethodBeat.i(139601);
    this.BJQ.onMiscCallBack("onTranslateFinish", new Bundle());
    AppMethodBeat.o(139601);
  }
  
  private void eag()
  {
    AppMethodBeat.i(85298);
    if (this.BJD != null)
    {
      AppMethodBeat.o(85298);
      return;
    }
    this.BJD = new j.1(this, this.BJF);
    this.BJN.BJD = this.BJD;
    this.BJF.setUIClient(this.BJD);
    this.BJE = new j.2(this, this.BJF);
    this.BJN.BJE = this.BJE;
    this.BJF.setResourceClient(this.BJE);
    XWalkProxyWebViewClientExtension local3 = new XWalkProxyWebViewClientExtension()
    {
      public final Object onMiscCallBack(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(85290);
        if (j.f(j.this) != null)
        {
          paramAnonymousString = j.f(j.this).onMiscCallBack(paramAnonymousString, paramAnonymousBundle);
          AppMethodBeat.o(85290);
          return paramAnonymousString;
        }
        AppMethodBeat.o(85290);
        return null;
      }
    };
    this.BJF.setProxyWebViewClientExtension(local3);
    AppMethodBeat.o(85298);
  }
  
  public static boolean fL(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(85297);
      com.tencent.xweb.xwalk.b.e.jY(paramContext);
      boolean bool = com.tencent.xweb.xwalk.b.e.isXWalkReady();
      AppMethodBeat.o(85297);
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public final void a(View paramView, boolean paramBoolean, com.tencent.xweb.l paraml)
  {
    AppMethodBeat.i(139599);
    if (XWalkCoreWrapper.getInstance().hasFeature(2)) {
      try
      {
        Class localClass = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.screenshot.LongScreenShotManager");
        if (localClass == null)
        {
          AppMethodBeat.o(139599);
          return;
        }
        new ReflectMethod(localClass, "startLongScreenShot", new Class[] { View.class, Boolean.TYPE, Object.class }).invoke(new Object[] { paramView, Boolean.valueOf(paramBoolean), XWalkCoreWrapper.getInstance().getBridgeObject(new f.d(paraml)) });
        AppMethodBeat.o(139599);
        return;
      }
      catch (Exception paramView)
      {
        Log.e("XWWebView", "startLongScreenShot reflect failed");
      }
    }
    AppMethodBeat.o(139599);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(85322);
    this.BJF.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(85322);
  }
  
  public final boolean canGoBack()
  {
    AppMethodBeat.i(85306);
    if ((!this.BJO) && (this.BJF.getNavigationHistory().canGoBack()))
    {
      AppMethodBeat.o(85306);
      return true;
    }
    AppMethodBeat.o(85306);
    return false;
  }
  
  public final boolean canGoForward()
  {
    AppMethodBeat.i(85343);
    if (this.BJF.getNavigationHistory() != null)
    {
      boolean bool = this.BJF.getNavigationHistory().canGoForward();
      AppMethodBeat.o(85343);
      return bool;
    }
    AppMethodBeat.o(85343);
    return false;
  }
  
  public final void captureBitmap(i.a parama)
  {
    AppMethodBeat.i(139597);
    View localView = ((ViewGroup)((ViewGroup)this.BJF.getChildAt(0)).getChildAt(0)).getChildAt(0);
    if ((localView instanceof TextureView)) {
      new Thread(new j.7(this, localView, parama)).start();
    }
    AppMethodBeat.o(139597);
  }
  
  public final void clearHistory()
  {
    AppMethodBeat.i(85342);
    if (this.BJF.getNavigationHistory() != null) {
      this.BJF.getNavigationHistory().clear();
    }
    AppMethodBeat.o(85342);
  }
  
  public final void clearMatches()
  {
    AppMethodBeat.i(85328);
    this.BJF.clearMatches();
    AppMethodBeat.o(85328);
  }
  
  public final void clearSslPreferences()
  {
    AppMethodBeat.i(85313);
    this.BJF.clearSslPreferences();
    AppMethodBeat.o(85313);
  }
  
  public final void clearView() {}
  
  public final void destroy()
  {
    AppMethodBeat.i(85310);
    this.BJF.onDestroy();
    AppMethodBeat.o(85310);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(85311);
    this.BJF.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(85311);
  }
  
  public final void findAllAsync(String paramString)
  {
    AppMethodBeat.i(85330);
    this.BJF.findAllAsync(paramString);
    AppMethodBeat.o(85330);
  }
  
  public final void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(85329);
    this.BJF.findNext(paramBoolean);
    AppMethodBeat.o(85329);
  }
  
  public final void fk(String paramString, int paramInt)
  {
    AppMethodBeat.i(85341);
    if (XWalkCoreWrapper.getInstance().hasFeature(0)) {
      try
      {
        Object localObject = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
        if (localObject == null)
        {
          AppMethodBeat.o(85341);
          return;
        }
        localObject = new ReflectMethod((Class)localObject, "setProfileConfig", new Class[] { Bundle.class });
        Bundle localBundle = new Bundle();
        localBundle.putString("enabledTraceCategory", paramString);
        localBundle.putInt("traceSampleRatio", paramInt);
        ((ReflectMethod)localObject).invoke(new Object[] { localBundle });
        AppMethodBeat.o(85341);
        return;
      }
      catch (Exception paramString)
      {
        Log.e("XWWebView", "setProfileConfig reflect failed");
      }
    }
    AppMethodBeat.o(85341);
  }
  
  public final String getAbstractInfo()
  {
    AppMethodBeat.i(85332);
    String str = "webviewtype = xwalk, sdkver = 190503\n apkver = " + XWalkEnvironment.getAvailableVersion();
    AppMethodBeat.o(85332);
    return str;
  }
  
  public final int getContentHeight()
  {
    AppMethodBeat.i(85315);
    int i = this.BJF.getContentHeight();
    AppMethodBeat.o(85315);
    return i;
  }
  
  public final p getCurWebChromeClient()
  {
    return this.iyr;
  }
  
  public final w getCurWebviewClient()
  {
    return this.iyq;
  }
  
  public final f getDefalutOpProvider()
  {
    return this.BJN;
  }
  
  public final WebView.a getFullscreenVideoKind()
  {
    AppMethodBeat.i(85339);
    WebView.a locala = a.axJ(WebView.getCurStrModule());
    AppMethodBeat.o(85339);
    return locala;
  }
  
  public final WebView.b getHitTestResult()
  {
    AppMethodBeat.i(85326);
    WebView.b localb = new WebView.b();
    XWalkHitTestResult localXWalkHitTestResult = this.BJF.getHitTestResult();
    localb.mType = localXWalkHitTestResult.getType().ordinal();
    localb.mExtra = localXWalkHitTestResult.getExtra();
    AppMethodBeat.o(85326);
    return localb;
  }
  
  public final boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, com.tencent.xweb.g paramg)
  {
    AppMethodBeat.i(139602);
    boolean bool = this.BJF.getImageBitmapToFile(paramString1, paramString2, paramString3, new j.8(this, paramg));
    AppMethodBeat.o(139602);
    return bool;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(85316);
    float f = this.BJF.getScale();
    AppMethodBeat.o(85316);
    return f;
  }
  
  public final t getSettings()
  {
    return this.BJL;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(85327);
    String str = this.BJF.getTitle();
    AppMethodBeat.o(85327);
    return str;
  }
  
  public final ViewGroup getTopView()
  {
    return this.BJM;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(85323);
    String str = this.BJF.getUrl();
    AppMethodBeat.o(85323);
    return str;
  }
  
  public final String getVersionInfo()
  {
    AppMethodBeat.i(85331);
    String str = "webviewType = WV_KIND_CW,V8 type=" + com.tencent.xweb.k.dYk() + " ,apkversion = " + this.mApkVersion + " , " + XWalkEnvironment.getAvailableVersionDetail() + " sdk = 190503";
    AppMethodBeat.o(85331);
    return str;
  }
  
  public final View getView()
  {
    return this.BJF;
  }
  
  public final int getVisibleTitleHeight()
  {
    return 0;
  }
  
  public final int getWebScrollX()
  {
    AppMethodBeat.i(85335);
    View localView = getWebViewUI();
    if ((localView instanceof XWalkView))
    {
      i = ((XWalkView)localView).computeHorizontalScrollOffset();
      AppMethodBeat.o(85335);
      return i;
    }
    int i = localView.getScrollX();
    AppMethodBeat.o(85335);
    return i;
  }
  
  public final int getWebScrollY()
  {
    AppMethodBeat.i(85334);
    int i = this.BJF.computeVerticalScrollOffset();
    AppMethodBeat.o(85334);
    return i;
  }
  
  public final View getWebViewUI()
  {
    return this.BJF;
  }
  
  public final Object getX5WebViewExtension()
  {
    return null;
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(85307);
    if (this.BJF.getNavigationHistory().canGoBack())
    {
      this.BJF.getNavigationHistory().navigate(XWalkNavigationHistory.Direction.BACKWARD, 1);
      if ((this.BJF.getNavigationHistory() != null) && (this.BJF.getNavigationHistory().getCurrentItem() != null)) {
        this.iyr.d(this.BHt, this.BJF.getNavigationHistory().getCurrentItem().getTitle());
      }
    }
    AppMethodBeat.o(85307);
  }
  
  public final boolean hasEnteredFullscreen()
  {
    AppMethodBeat.i(85308);
    boolean bool = this.BJF.hasEnteredFullscreen();
    AppMethodBeat.o(85308);
    return bool;
  }
  
  public final Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(139600);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.d("XWWebView", " method string is null or empty");
      AppMethodBeat.o(139600);
      return null;
    }
    Log.d("XWWebView", " method string is ".concat(String.valueOf(paramString)));
    boolean bool;
    if (paramString.equals("supportTranslateWebSite"))
    {
      bool = XWalkCoreWrapper.getInstance().isSupportTranslateWebSite();
      paramString = new Bundle();
      paramString.putBoolean("result", bool);
      Log.i("XWWebView", "translate: xweb is supportTranslateWebSite = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(139600);
      return paramString;
    }
    if (paramString.equals("getTranslateSampleString"))
    {
      Log.i("XWWebView", "translate: xweb is detectTranslateWebSiteIsNeeded ,getTranslateSampleString");
      this.BJF.getTranslateSampleString(0);
      AppMethodBeat.o(139600);
      return null;
    }
    if (paramString.equals("translateWebSite"))
    {
      Log.i("XWWebView", "translate: do translateWebSite");
      paramString = paramBundle.getString("url");
      this.BJS = true;
      this.BJF.loadUrl(paramString);
      AppMethodBeat.o(139600);
      return null;
    }
    if (paramString.equals("replaceTranslatedString"))
    {
      Log.i("XWWebView", "translate: replaceTranslatedString mIsTranslateMode =" + this.BJS);
      if (!this.BJS)
      {
        AppMethodBeat.o(139600);
        return null;
      }
      Object localObject = (HashMap)paramBundle.getSerializable("translate_hashmap");
      bool = paramBundle.getBoolean("is_mp_url");
      paramString = paramBundle.getString("translate_tips");
      paramBundle = new HashMap();
      Iterator localIterator = ((HashMap)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)((HashMap)localObject).get(str1);
        if ((str1 == null) || (str1.isEmpty()) || (str2 == null) || (str2.isEmpty())) {
          Log.d("XWWebView", "translate: string is err !!!  key = " + str1 + " value = " + str2);
        } else if ((str2.trim().length() == 0) || (str2.trim().equals("\n")) || (str2.trim().equals("\r"))) {
          Log.d("XWWebView", "translate: string is space  or change line  value = ".concat(String.valueOf(str2)));
        } else {
          paramBundle.put(str1, str2);
        }
      }
      Log.d("XWWebView", "translate: replaceTranslatedString orghashmap size = " + ((HashMap)localObject).size() + " resultHashMap size = " + paramBundle.size());
      this.BJF.replaceTranslatedString(paramBundle);
      bool = Boolean.valueOf(bool).booleanValue();
      if ((this.BJS) && (!this.BJT))
      {
        this.BJT = true;
        Log.i("XWWebView", "getTranslateTipsView");
        paramBundle = new FrameLayout.LayoutParams(-1, 144);
        paramBundle.gravity = 51;
        localObject = new TextView(this.BHt.getContext());
        ((TextView)localObject).setGravity(17);
        ((TextView)localObject).setText(paramString);
        ((TextView)localObject).setTextColor(Color.argb(127, 0, 0, 0));
        ((TextView)localObject).setTextSize(0, 42.0F);
        if (!bool) {
          break label672;
        }
        ((TextView)localObject).setBackgroundColor(-328966);
      }
      for (;;)
      {
        ((ViewGroup)this.BHt.getParent()).addView((View)localObject, paramBundle);
        ((FrameLayout.LayoutParams)this.BHt.getLayoutParams()).topMargin = 144;
        this.BHt.requestLayout();
        Log.d("XWWebView", "translate: onTranslateFinish ");
        dau();
        AppMethodBeat.o(139600);
        return null;
        label672:
        ((TextView)localObject).setBackgroundColor(-855310);
      }
    }
    AppMethodBeat.o(139600);
    return null;
  }
  
  public final boolean isOverScrollStart()
  {
    AppMethodBeat.i(85336);
    boolean bool = this.BJV;
    View localView = getWebViewUI();
    if ((localView instanceof XWalkView)) {}
    for (int i = ((XWalkView)localView).computeVerticalScrollOffset(); (i == 0) && (bool); i = localView.getScrollY())
    {
      AppMethodBeat.o(85336);
      return true;
    }
    AppMethodBeat.o(85336);
    return false;
  }
  
  public final boolean isSupportExtendPluginForAppbrand()
  {
    AppMethodBeat.i(85333);
    boolean bool = this.BJF.isSupportExtendPluginForAppbrand();
    AppMethodBeat.o(85333);
    return bool;
  }
  
  public final void leaveFullscreen()
  {
    AppMethodBeat.i(85309);
    this.BJF.leaveFullscreen();
    AppMethodBeat.o(85309);
  }
  
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(85314);
    this.BJF.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(85314);
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(85318);
    this.BJF.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(85318);
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(85305);
    if ((paramString != null) && (paramString.trim().startsWith("javascript:")))
    {
      this.BJF.evaluateJavascript(paramString, null);
      AppMethodBeat.o(85305);
      return;
    }
    this.BJO = false;
    this.BJF.loadUrl(paramString);
    AppMethodBeat.o(85305);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(85321);
    this.BJF.loadUrl(paramString, paramMap);
    AppMethodBeat.o(85321);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(85338);
    this.BJF.onPause();
    AppMethodBeat.o(85338);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(85337);
    this.BJF.onResume();
    AppMethodBeat.o(85337);
  }
  
  public final boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(85317);
    int i = this.BJF.getScrollBarStyle();
    if ((i == 0) || (i == 33554432))
    {
      AppMethodBeat.o(85317);
      return true;
    }
    AppMethodBeat.o(85317);
    return false;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(85312);
    this.BJF.reload(0);
    AppMethodBeat.o(85312);
  }
  
  public final void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(85324);
    this.BJF.removeJavascriptInterface(paramString);
    AppMethodBeat.o(85324);
  }
  
  public final boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(85340);
    View localView = getWebViewUI();
    if ((localView instanceof XWalkView))
    {
      boolean bool = ((XWalkView)localView).savePage(paramString1, paramString2, paramInt);
      AppMethodBeat.o(85340);
      return bool;
    }
    AppMethodBeat.o(85340);
    return false;
  }
  
  public final void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(85303);
    this.BJF.setDownloadListener(new f.f(this.BHt.getContext(), paramDownloadListener));
    AppMethodBeat.o(85303);
  }
  
  public final void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(85304);
    this.BJF.setFindListener(new f.g(paramFindListener));
    AppMethodBeat.o(85304);
  }
  
  public final void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(85346);
    this.BJF.setHorizontalScrollBarEnable(paramBoolean);
    AppMethodBeat.o(85346);
  }
  
  public final void setJSExceptionListener(x paramx)
  {
    this.BJR = paramx;
  }
  
  public final void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(85345);
    this.BJF.setVerticalScrollBarEnable(paramBoolean);
    AppMethodBeat.o(85345);
  }
  
  public final void setWebChromeClient(p paramp)
  {
    AppMethodBeat.i(85302);
    if (paramp == null)
    {
      this.iyr = new p();
      AppMethodBeat.o(85302);
      return;
    }
    eag();
    this.iyr = paramp;
    AppMethodBeat.o(85302);
  }
  
  public final void setWebViewCallbackClient(v paramv)
  {
    this.igO = paramv;
  }
  
  public final void setWebViewClient(w paramw)
  {
    AppMethodBeat.i(85301);
    if (paramw == null)
    {
      this.iyq = new w();
      this.iyq.BDF = this.BJN;
      AppMethodBeat.o(85301);
      return;
    }
    eag();
    this.iyq = paramw;
    AppMethodBeat.o(85301);
  }
  
  public final void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b paramb)
  {
    this.BJQ = paramb;
  }
  
  public final void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(139598);
    this.BJF.smoothScroll(paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(139598);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(85325);
    this.BJF.stopLoading();
    AppMethodBeat.o(85325);
  }
  
  public final void super_computeScroll() {}
  
  public final boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean supportFeature(int paramInt)
  {
    AppMethodBeat.i(85344);
    boolean bool = XWalkCoreWrapper.getInstance().hasFeature(paramInt);
    AppMethodBeat.o(85344);
    return bool;
  }
  
  public final boolean zoomIn()
  {
    AppMethodBeat.i(85320);
    boolean bool = this.BJF.zoomIn();
    AppMethodBeat.o(85320);
    return bool;
  }
  
  public final boolean zoomOut()
  {
    AppMethodBeat.i(85319);
    boolean bool = this.BJF.zoomOut();
    AppMethodBeat.o(85319);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.j
 * JD-Core Version:    0.7.0.1
 */