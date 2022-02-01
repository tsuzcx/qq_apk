package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.a;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.n;
import com.tencent.xweb.w;
import com.tencent.xweb.w.a;
import com.tencent.xweb.y;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import org.xwalk.core.XWalkEnvironment;

public class MMWebView
  extends WebView
{
  public static final WebView.c HAC;
  public static String HAD;
  public static String HAE;
  public static int HAF;
  public static long HAG;
  private static Vector<WeakReference<MMWebView>> HAI;
  private String ARn;
  private q Bzy;
  protected boolean HAH;
  private boolean HAJ;
  private ViewGroup HAK;
  private View.OnTouchListener HAL;
  public e HAM;
  private LinkedList<e> HAN;
  private boolean HAO;
  private List<i> HAP;
  public boolean fFP;
  private boolean jsq;
  public boolean mDestroyed;
  private View.OnTouchListener zrL;
  
  static
  {
    AppMethodBeat.i(191020);
    HAC = WebView.c.IND;
    HAD = null;
    HAE = null;
    HAF = 3600000;
    HAG = 3600000L;
    HAI = new Vector();
    AppMethodBeat.o(191020);
  }
  
  public MMWebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, WebView.c.INB);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, WebView.c.INB);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, WebView.c paramc)
  {
    super(paramContext, paramAttributeSet, paramInt, paramc);
    AppMethodBeat.i(143424);
    this.Bzy = new q();
    this.fFP = false;
    this.HAH = false;
    this.HAJ = false;
    this.HAM = null;
    this.HAN = new LinkedList();
    this.HAO = false;
    this.HAP = new ArrayList();
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      ad.e("MicroMsg.MMWebView", "alvinluo MMWebView create not in main thread, stack: %s", new Object[] { bt.eGN() });
      if (h.IS_FLAVOR_RED)
      {
        paramContext = new IllegalStateException("Create MMWebView must be in main thread");
        AppMethodBeat.o(143424);
        throw paramContext;
      }
    }
    setBackgroundColor(paramContext.getResources().getColor(2131101179));
    feQ();
    HAI.add(new WeakReference(this));
    AppMethodBeat.o(143424);
  }
  
  private static boolean a(MMWebView paramMMWebView, String paramString)
  {
    AppMethodBeat.i(143431);
    try
    {
      paramMMWebView = new c(new c(new c(paramMMWebView, "mSysWebView", null).get(), "mProvider", null).get(), "mWebViewCore", null).get();
      Method localMethod = paramMMWebView.getClass().getDeclaredMethod("sendMessage", new Class[] { Message.class });
      localMethod.setAccessible(true);
      localMethod.invoke(paramMMWebView, new Object[] { Message.obtain(null, 194, paramString) });
      AppMethodBeat.o(143431);
      return true;
    }
    catch (Exception paramMMWebView)
    {
      ad.e("MicroMsg.MMWebView", "reflectJSExec, e = %s", new Object[] { paramMMWebView });
      AppMethodBeat.o(143431);
    }
    return false;
  }
  
  public static void ki(Context paramContext)
  {
    AppMethodBeat.i(143440);
    paramContext = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    String str1 = paramContext.getString("tbs_webview_disable", "0");
    String str2 = paramContext.getString("tbs_webview_min_sdk_version", null);
    String str3 = paramContext.getString("tbs_webview_max_sdk_version", null);
    ad.i("MicroMsg.MMWebView", "initTbsSettings, tbsDisable = %s, minSdkVersion = %s, maxSdkVersion = %s", new Object[] { str1, str2, str3 });
    if ("1".equals(str1))
    {
      int i = bt.getInt(str2, 0);
      int j = bt.getInt(str3, 0);
      int k = Build.VERSION.SDK_INT;
      if ((k >= i) && ((k <= j) || (j == 0))) {
        ad.i("MicroMsg.MMWebView", "in selection, disable x5");
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      ad.i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", new Object[] { Boolean.valueOf(bool1) });
      if (!bool1) {
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
      }
      bool1 = paramContext.getBoolean("tbs_download_oversea", false);
      boolean bool2 = com.tencent.mm.sdk.platformtools.i.eFb();
      ad.i("MicroMsg.MMWebView", "initTbsSettings, tbs_download_oversea = %b, isGPVersion = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (bool2)) {
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
      }
      AppMethodBeat.o(143440);
      return;
    }
  }
  
  public static void wP(boolean paramBoolean)
  {
    AppMethodBeat.i(191015);
    Iterator localIterator = HAI.iterator();
    while (localIterator.hasNext())
    {
      MMWebView localMMWebView = (MMWebView)((WeakReference)localIterator.next()).get();
      if (localMMWebView != null) {
        if (paramBoolean) {
          localMMWebView.getSettings().setForceDarkMode(2);
        } else {
          localMMWebView.getSettings().setForceDarkMode(0);
        }
      }
    }
    AppMethodBeat.o(191015);
  }
  
  public final void Q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143439);
    super.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.HAN.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(143439);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(143441);
    this.HAN.add(parame);
    AppMethodBeat.o(143441);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(191017);
    this.HAP.add(parami);
    AppMethodBeat.o(191017);
  }
  
  public void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(143430);
    super.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(143430);
  }
  
  public final boolean af(MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    AppMethodBeat.i(143434);
    int i = paramMotionEvent.getAction();
    boolean bool2 = super.super_onTouchEvent(paramMotionEvent);
    switch (i & 0xFF)
    {
    case 1: 
    default: 
      if (bool2) {
        if (this.HAJ) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(143434);
      return bool1;
      this.HAJ = false;
      break;
      if (this.HAK == null) {
        break;
      }
      if (this.HAJ)
      {
        this.HAK.requestDisallowInterceptTouchEvent(false);
        break;
      }
      this.HAK.requestDisallowInterceptTouchEvent(true);
      break;
      bool1 = false;
      continue;
      bool1 = bool2;
    }
  }
  
  public final boolean ag(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143436);
    boolean bool = super.super_dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143436);
    return bool;
  }
  
  public final boolean ah(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143437);
    boolean bool = super.super_onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143437);
    return bool;
  }
  
  public final void av(Context paramContext)
  {
    AppMethodBeat.i(182573);
    if (!(getContext() instanceof MutableContextWrapper))
    {
      AppMethodBeat.o(182573);
      return;
    }
    MutableContextWrapper localMutableContextWrapper = (MutableContextWrapper)getContext();
    if (localMutableContextWrapper.getBaseContext() == paramContext)
    {
      AppMethodBeat.o(182573);
      return;
    }
    localMutableContextWrapper.setBaseContext(paramContext);
    AppMethodBeat.o(182573);
  }
  
  @TargetApi(9)
  public final boolean c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(143433);
    paramBoolean = super.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    if ((paramInt4 < 0) || ((paramInt4 == 0) && (paramInt2 < 0))) {
      this.HAJ = true;
    }
    AppMethodBeat.o(143433);
    return paramBoolean;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(143425);
    try
    {
      super.destroy();
      Iterator localIterator = HAI.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((MMWebView)localWeakReference.get() == this) {
          HAI.remove(localWeakReference);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.MMWebView", localThrowable, "catch in destroy()", new Object[0]);
      return;
    }
    finally
    {
      this.mDestroyed = true;
      AppMethodBeat.o(143425);
    }
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(143429);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(143429);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.lf(19)) || (this.isX5Kernel)) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(143429);
      return;
    }
    if ((this.HAH) && (a(this, paramString)))
    {
      AppMethodBeat.o(143429);
      return;
    }
    paramValueCallback = paramString;
    try
    {
      if (!paramString.startsWith("javascript:")) {
        paramValueCallback = "javascript:".concat(String.valueOf(paramString));
      }
      super.loadUrl(paramValueCallback);
      AppMethodBeat.o(143429);
      return;
    }
    catch (Exception paramString)
    {
      ad.i("MicroMsg.MMWebView", "evaluateJavascript failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(143429);
    }
  }
  
  @TargetApi(11)
  protected final void feQ()
  {
    AppMethodBeat.i(143427);
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        super.removeJavascriptInterface("searchBoxJavaBridge_");
      }
      AppMethodBeat.o(143427);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MMWebView", "removeConfigJsInterface, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(143427);
    }
  }
  
  public final void feR()
  {
    AppMethodBeat.i(143428);
    if (Build.VERSION.SDK_INT >= 5)
    {
      new d((byte)0);
      d.d(this);
      AppMethodBeat.o(143428);
      return;
    }
    new c((byte)0);
    setScrollBarStyle(0);
    AppMethodBeat.o(143428);
  }
  
  public final void feS()
  {
    AppMethodBeat.i(143432);
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143418);
        if (MMWebView.this.getIsX5Kernel())
        {
          int i = paramAnonymousMotionEvent.getAction();
          if (MMWebView.g(MMWebView.this) != null) {
            switch (i & 0xFF)
            {
            default: 
              MMWebView.g(MMWebView.this).requestDisallowInterceptTouchEvent(true);
            }
          }
        }
        while ((MMWebView.h(MMWebView.this) != null) && (MMWebView.h(MMWebView.this).onTouch(paramAnonymousView, paramAnonymousMotionEvent)))
        {
          AppMethodBeat.o(143418);
          return true;
          MMWebView.g(MMWebView.this).requestDisallowInterceptTouchEvent(true);
          continue;
          MMWebView.g(MMWebView.this).requestDisallowInterceptTouchEvent(false);
        }
        if (MMWebView.i(MMWebView.this) != null)
        {
          boolean bool = MMWebView.i(MMWebView.this).onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          AppMethodBeat.o(143418);
          return bool;
        }
        AppMethodBeat.o(143418);
        return false;
      }
    });
    AppMethodBeat.o(143432);
  }
  
  @TargetApi(9)
  public final void feT()
  {
    AppMethodBeat.i(143438);
    super.super_computeScroll();
    AppMethodBeat.o(143438);
  }
  
  public final boolean feU()
  {
    return this.jsq;
  }
  
  @TargetApi(9)
  public final void g(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143435);
    super.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(143435);
  }
  
  public Context getActivityContextIfHas()
  {
    AppMethodBeat.i(191016);
    if ((getContext() instanceof MutableContextWrapper)) {}
    for (Context localContext = ((MutableContextWrapper)getContext()).getBaseContext();; localContext = getContext())
    {
      AppMethodBeat.o(191016);
      return localContext;
    }
  }
  
  public boolean getIsX5Kernel()
  {
    return this.isX5Kernel;
  }
  
  public float getMMDensity()
  {
    AppMethodBeat.i(191019);
    float f2 = a.eCY();
    float f1 = f2;
    if (getWebCoreType() == WebView.c.INC)
    {
      f1 = f2;
      if (XWalkEnvironment.getUsingCustomContext()) {
        f1 = getResources().getDisplayMetrics().density;
      }
    }
    AppMethodBeat.o(191019);
    return f1;
  }
  
  public q getPerformanceHelper()
  {
    return this.Bzy;
  }
  
  public String getRandomStr()
  {
    return this.ARn;
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(143426);
    super.loadUrl(paramString);
    AppMethodBeat.o(143426);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(143444);
    if (this.HAO)
    {
      AppMethodBeat.o(143444);
      return;
    }
    super.onHide();
    this.HAO = true;
    AppMethodBeat.o(143444);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(143443);
    super.onShow();
    this.HAO = false;
    AppMethodBeat.o(143443);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143442);
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.HAM != null) {
      this.HAM.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    Iterator localIterator = this.HAN.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(143442);
  }
  
  public void setCompetitorView(ViewGroup paramViewGroup)
  {
    this.HAK = paramViewGroup;
  }
  
  public void setOnCustomTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.HAL = paramOnTouchListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.zrL = paramOnTouchListener;
  }
  
  public void setPreload(boolean paramBoolean)
  {
    this.jsq = paramBoolean;
  }
  
  public void setRandomStr(String paramString)
  {
    this.ARn = paramString;
  }
  
  public void setWebChromeClient(w paramw)
  {
    AppMethodBeat.i(191018);
    if ((paramw instanceof b)) {
      ((b)paramw).HAR = this.HAP;
    }
    if (paramw == null) {
      this.HAP.clear();
    }
    super.setWebChromeClient(paramw);
    AppMethodBeat.o(191018);
  }
  
  public static final class a
  {
    public static MMWebView a(Context paramContext, View paramView, int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(143422);
      MMWebView.ki(paramContext);
      paramContext = (MMWebView)paramView.findViewById(paramInt);
      paramContext.fFP = true;
      if (paramContext.getX5WebViewExtension() != null) {}
      for (;;)
      {
        MMWebView.e(paramContext, bool);
        AppMethodBeat.o(143422);
        return paramContext;
        bool = false;
      }
    }
    
    public static MMWebView kj(Context paramContext)
    {
      AppMethodBeat.i(143419);
      try
      {
        ad.i("MMWebView", "TRACE_ORDER:MMWebView.java");
        WebView.initWebviewCore(paramContext, MMWebView.HAC, "tools", null);
        MMWebView.ki(paramContext);
        paramContext = new MMWebView(paramContext, null, 0, WebView.c.INE);
        paramContext.fFP = true;
        MMWebView.b(paramContext, paramContext.getIsX5Kernel());
        AppMethodBeat.o(143419);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(143419);
      }
      return null;
    }
    
    public static MMWebView kk(Context paramContext)
    {
      AppMethodBeat.i(143420);
      ad.i("MMWebView", "TRACE_ORDER:MMWebView.java");
      WebView.initWebviewCore(paramContext, MMWebView.HAC, "tools", null);
      MMWebView.ki(paramContext);
      paramContext = new MMWebView(paramContext);
      paramContext.fFP = true;
      MMWebView.c(paramContext, paramContext.getIsX5Kernel());
      AppMethodBeat.o(143420);
      return paramContext;
    }
    
    public static MMWebView s(Activity paramActivity, int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(143421);
      MMWebView.ki(paramActivity);
      paramActivity = (MMWebView)paramActivity.findViewById(paramInt);
      paramActivity.fFP = true;
      if (paramActivity.getX5WebViewExtension() != null) {}
      for (;;)
      {
        MMWebView.d(paramActivity, bool);
        AppMethodBeat.o(143421);
        return paramActivity;
        bool = false;
      }
    }
  }
  
  public static final class b
    extends w
  {
    private w AST;
    List<i> HAR;
    
    public b(w paramw)
    {
      AppMethodBeat.i(190995);
      this.HAR = new ArrayList();
      this.AST = paramw;
      AppMethodBeat.o(190995);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(191009);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).a(paramWebView, paramInt);
      }
      this.AST.a(paramWebView, paramInt);
      AppMethodBeat.o(191009);
    }
    
    public final boolean a(long paramLong, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(190997);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.AST.a(paramLong, paramString1, paramString2, paramString3);
      AppMethodBeat.o(190997);
      return bool;
    }
    
    public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(191012);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.AST.a(paramView, paramCustomViewCallback);
      AppMethodBeat.o(191012);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, w.a parama)
    {
      AppMethodBeat.i(191008);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.AST.a(paramWebView, paramValueCallback, parama);
      AppMethodBeat.o(191008);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      AppMethodBeat.i(191002);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.AST.a(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(191002);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, n paramn)
    {
      AppMethodBeat.i(191004);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.AST.a(paramWebView, paramString1, paramString2, paramString3, paramn);
      AppMethodBeat.o(191004);
      return bool;
    }
    
    public final void b(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(191007);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.AST.b(paramWebView, paramInt);
      AppMethodBeat.o(191007);
    }
    
    public final boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      AppMethodBeat.i(191003);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.AST.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(191003);
      return bool;
    }
    
    public final boolean beF()
    {
      AppMethodBeat.i(191013);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.AST.beF();
      AppMethodBeat.o(191013);
      return bool;
    }
    
    public final boolean c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      AppMethodBeat.i(190998);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.AST.c(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
      AppMethodBeat.o(190998);
      return bool;
    }
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(191010);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.AST.d(paramWebView, paramString);
      AppMethodBeat.o(191010);
    }
    
    public final View getVideoLoadingProgressView()
    {
      AppMethodBeat.i(191005);
      Object localObject = this.HAR.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
      localObject = this.AST.getVideoLoadingProgressView();
      AppMethodBeat.o(191005);
      return localObject;
    }
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(190996);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.AST.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(190996);
      return bool;
    }
    
    public final void onExitFullscreenVideo(Bitmap paramBitmap)
    {
      AppMethodBeat.i(191014);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.AST.onExitFullscreenVideo(paramBitmap);
      AppMethodBeat.o(191014);
    }
    
    public final void onGeolocationPermissionsHidePrompt()
    {
      AppMethodBeat.i(191000);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.AST.onGeolocationPermissionsHidePrompt();
      AppMethodBeat.o(191000);
    }
    
    public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(190999);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.AST.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
      AppMethodBeat.o(190999);
    }
    
    public final void onHideCustomView()
    {
      AppMethodBeat.i(191001);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.AST.onHideCustomView();
      AppMethodBeat.o(191001);
    }
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(191011);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.AST.onShowCustomView(paramView, paramCustomViewCallback);
      AppMethodBeat.o(191011);
    }
    
    public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      AppMethodBeat.i(191006);
      Iterator localIterator = this.HAR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.AST.openFileChooser(paramValueCallback, paramString1, paramString2);
      AppMethodBeat.o(191006);
    }
  }
  
  final class c
  {
    private c() {}
  }
  
  final class d
  {
    private d() {}
    
    public static void d(WebView paramWebView)
    {
      AppMethodBeat.i(143423);
      paramWebView.setScrollbarFadingEnabled(true);
      paramWebView.setScrollBarStyle(0);
      AppMethodBeat.o(143423);
    }
  }
  
  public static abstract interface e
  {
    public abstract void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMWebView
 * JD-Core Version:    0.7.0.1
 */