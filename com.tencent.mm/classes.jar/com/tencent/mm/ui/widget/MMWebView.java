package com.tencent.mm.ui.widget;

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
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.compatible.loader.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.ad;
import com.tencent.xweb.ao;
import com.tencent.xweb.q;
import com.tencent.xweb.x5.a.e;
import com.tencent.xweb.z;
import com.tencent.xweb.z.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class MMWebView
  extends WebView
{
  public static final WebView.WebViewKind afUn;
  private static Vector<WeakReference<MMWebView>> afUp;
  private String KQY;
  private s XvU;
  protected boolean afUo;
  private boolean afUq;
  private ViewGroup afUr;
  private View.OnTouchListener afUs;
  public f afUt;
  private LinkedList<f> afUu;
  private boolean afUv;
  public List<m> afUw;
  public int iiA;
  public boolean lYs;
  public boolean mDestroyed;
  private View.OnTouchListener pWX;
  public boolean rsE;
  private boolean tzc;
  
  static
  {
    AppMethodBeat.i(251566);
    afUn = WebView.WebViewKind.aifI;
    afUp = new Vector();
    AppMethodBeat.o(251566);
  }
  
  public MMWebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, WebView.WebViewKind.aifH);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, WebView.WebViewKind.aifH);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, WebView.WebViewKind paramWebViewKind)
  {
    super(paramContext, paramAttributeSet, paramInt, paramWebViewKind);
    AppMethodBeat.i(143424);
    this.XvU = new s();
    this.iiA = 0;
    this.lYs = false;
    this.afUo = false;
    this.tzc = false;
    this.afUq = false;
    this.afUt = null;
    this.afUu = new LinkedList();
    this.afUv = false;
    this.afUw = new ArrayList();
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      Log.e("MicroMsg.MMWebView", "alvinluo MMWebView create not in main thread, stack: %s", new Object[] { Util.getStack() });
      if (BuildInfo.IS_FLAVOR_RED)
      {
        paramContext = new IllegalStateException("Create MMWebView must be in main thread");
        AppMethodBeat.o(143424);
        throw paramContext;
      }
    }
    setBackgroundColor(paramContext.getResources().getColor(a.d.white));
    jET();
    afUp.add(new WeakReference(this));
    AppMethodBeat.o(143424);
  }
  
  public static void Nk(boolean paramBoolean)
  {
    AppMethodBeat.i(251529);
    Iterator localIterator = afUp.iterator();
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
    AppMethodBeat.o(251529);
  }
  
  private static boolean d(MMWebView paramMMWebView, String paramString)
  {
    AppMethodBeat.i(143431);
    try
    {
      paramMMWebView = new b(new b(new b(paramMMWebView, "mSysWebView", null).get(), "mProvider", null).get(), "mWebViewCore", null).get();
      Method localMethod = paramMMWebView.getClass().getDeclaredMethod("sendMessage", new Class[] { Message.class });
      localMethod.setAccessible(true);
      localMethod.invoke(paramMMWebView, new Object[] { Message.obtain(null, 194, paramString) });
      AppMethodBeat.o(143431);
      return true;
    }
    catch (Exception paramMMWebView)
    {
      Log.e("MicroMsg.MMWebView", "reflectJSExec, e = %s", new Object[] { paramMMWebView });
      AppMethodBeat.o(143431);
    }
    return false;
  }
  
  public static void nJ(Context paramContext)
  {
    AppMethodBeat.i(143440);
    Object localObject = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    String str1 = ((SharedPreferences)localObject).getString("tbs_webview_disable", "0");
    String str2 = ((SharedPreferences)localObject).getString("tbs_webview_min_sdk_version", null);
    String str3 = ((SharedPreferences)localObject).getString("tbs_webview_max_sdk_version", null);
    Log.i("MicroMsg.MMWebView", "initTbsSettings, tbsDisable = %s, minSdkVersion = %s, maxSdkVersion = %s", new Object[] { str1, str2, str3 });
    int i;
    if ("1".equals(str1))
    {
      i = Util.getInt(str2, 0);
      int j = Util.getInt(str3, 0);
      int k = Build.VERSION.SDK_INT;
      if ((k >= i) && ((k <= j) || (j == 0))) {
        Log.i("MicroMsg.MMWebView", "in selection, disable x5");
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      Log.i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", new Object[] { Boolean.valueOf(bool1) });
      if (!bool1) {
        e.forceSysWebView();
      }
      bool1 = ((SharedPreferences)localObject).getBoolean("tbs_download_oversea", false);
      boolean bool2 = ChannelUtil.isGPVersion();
      Log.i("MicroMsg.MMWebView", "initTbsSettings, tbs_download_oversea = %b, isGPVersion = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (bool2)) {
        e.forceSysWebView();
      }
      localObject = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yMT, "");
      if (!Util.isNullOrNil((String)localObject))
      {
        Log.i("MicroMsg.MMWebView", "setNewDnsHostList %s", new Object[] { localObject });
        e.setNewDnsHostList((String)localObject);
      }
      i = e.getTbsVersion(paramContext);
      if ((i > 0) && (i < 45912)) {
        e.forceSysWebView();
      }
      AppMethodBeat.o(143440);
      return;
    }
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(143441);
    this.afUu.add(paramf);
    AppMethodBeat.o(143441);
  }
  
  public final void ag(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143439);
    super.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.afUu.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(143439);
  }
  
  public final boolean ax(MotionEvent paramMotionEvent)
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
        if (this.tzc) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(143434);
      return bool1;
      this.tzc = false;
      this.afUq = false;
      break;
      if (this.afUr == null) {
        break;
      }
      if ((this.tzc) || (this.afUq))
      {
        this.afUr.requestDisallowInterceptTouchEvent(false);
        break;
      }
      this.afUr.requestDisallowInterceptTouchEvent(true);
      break;
      bool1 = false;
      continue;
      bool1 = bool2;
    }
  }
  
  public final boolean ay(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143436);
    boolean bool = super.super_dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143436);
    return bool;
  }
  
  public final boolean az(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143437);
    boolean bool = super.super_onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143437);
    return bool;
  }
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(143433);
    paramBoolean = super.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    Log.d("MicroMsg.MMWebView", "tbs_overScrollBy, deltaX: %d, deltaY: %d, scrollX: %b, scrollY: %b, r: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean) });
    if ((paramInt4 < 0) || ((paramInt4 == 0) && (paramInt2 < 0))) {
      this.tzc = true;
    }
    AppMethodBeat.o(143433);
    return paramBoolean;
  }
  
  public final void bm(Context paramContext)
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
  
  public void destroy()
  {
    AppMethodBeat.i(143425);
    try
    {
      super.destroy();
      Iterator localIterator = afUp.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((MMWebView)localWeakReference.get() == this) {
          afUp.remove(localWeakReference);
        }
      }
      this.mDestroyed = true;
      AppMethodBeat.o(143425);
      return;
    }
    finally
    {
      try
      {
        Log.printErrStackTrace("MicroMsg.MMWebView", localThrowable, "catch in destroy()", new Object[0]);
        return;
      }
      finally
      {
        this.mDestroyed = true;
        AppMethodBeat.o(143425);
      }
    }
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(143429);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(143429);
      return;
    }
    if (this.mDestroyed) {
      Log.w("MicroMsg.MMWebView", "EvaluateJavascript can not after destroy. %s", new Object[] { Util.getStack() });
    }
    for (int i = 0; i == 0; i = 1)
    {
      AppMethodBeat.o(143429);
      return;
    }
    if ((d.rb(19)) || (this.aifv)) {}
    for (i = 1; i != 0; i = 0)
    {
      super.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(143429);
      return;
    }
    if ((this.afUo) && (d(this, paramString)))
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
      Log.i("MicroMsg.MMWebView", "evaluateJavascript failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(143429);
    }
  }
  
  public Context getActivityContextIfHas()
  {
    AppMethodBeat.i(251654);
    if ((getContext() instanceof MutableContextWrapper)) {}
    for (Context localContext = ((MutableContextWrapper)getContext()).getBaseContext();; localContext = getContext())
    {
      AppMethodBeat.o(251654);
      return localContext;
    }
  }
  
  public boolean getIsX5Kernel()
  {
    return this.aifv;
  }
  
  public float getMMDensity()
  {
    AppMethodBeat.i(251683);
    float f2 = com.tencent.mm.ce.c.iRA();
    float f1;
    if (getWebCoreType() != WebView.WebViewKind.aifI)
    {
      f1 = f2;
      if (getWebCoreType() != WebView.WebViewKind.aifL) {}
    }
    else
    {
      f1 = f2;
      if (ao.getUsingCustomContext()) {
        f1 = getResources().getDisplayMetrics().density;
      }
    }
    AppMethodBeat.o(251683);
    return f1;
  }
  
  public s getPerformanceHelper()
  {
    return this.XvU;
  }
  
  public String getRandomStr()
  {
    return this.KQY;
  }
  
  public final void i(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143435);
    Log.d("MicroMsg.MMWebView", "tbs_onOverScrolled, scrollX: %d, scrollY: %d, clampedX: %b, clampedY: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    super.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(143435);
  }
  
  public final boolean jES()
  {
    AppMethodBeat.i(251572);
    if ((isSysKernel()) || (isX5WrappedSysKernel()))
    {
      AppMethodBeat.o(251572);
      return true;
    }
    AppMethodBeat.o(251572);
    return false;
  }
  
  protected final void jET()
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
      Log.e("MicroMsg.MMWebView", "removeConfigJsInterface, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(143427);
    }
  }
  
  public final void jEU()
  {
    AppMethodBeat.i(143428);
    if (Build.VERSION.SDK_INT >= 5)
    {
      new e((byte)0);
      e.f(this);
      AppMethodBeat.o(143428);
      return;
    }
    new d((byte)0);
    setScrollBarStyle(0);
    AppMethodBeat.o(143428);
  }
  
  public final void jEV()
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
          if (MMWebView.k(MMWebView.this) != null) {
            switch (i & 0xFF)
            {
            default: 
              MMWebView.k(MMWebView.this).requestDisallowInterceptTouchEvent(true);
            }
          }
        }
        while ((MMWebView.l(MMWebView.this) != null) && (MMWebView.l(MMWebView.this).onTouch(paramAnonymousView, paramAnonymousMotionEvent)))
        {
          AppMethodBeat.o(143418);
          return true;
          MMWebView.k(MMWebView.this).requestDisallowInterceptTouchEvent(true);
          continue;
          MMWebView.k(MMWebView.this).requestDisallowInterceptTouchEvent(false);
        }
        if (MMWebView.m(MMWebView.this) != null)
        {
          boolean bool = MMWebView.m(MMWebView.this).onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          AppMethodBeat.o(143418);
          return bool;
        }
        AppMethodBeat.o(143418);
        return false;
      }
    });
    AppMethodBeat.o(143432);
  }
  
  public final void jEW()
  {
    AppMethodBeat.i(143438);
    super.super_computeScroll();
    AppMethodBeat.o(143438);
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
    if (this.afUv)
    {
      AppMethodBeat.o(143444);
      return;
    }
    super.onHide();
    this.afUv = true;
    AppMethodBeat.o(143444);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(143443);
    super.onShow();
    this.afUv = false;
    AppMethodBeat.o(143443);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143442);
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.afUt != null) {
      this.afUt.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    Iterator localIterator = this.afUu.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(143442);
  }
  
  public void setCleanOnDetached(boolean paramBoolean) {}
  
  public void setCompetitorView(ViewGroup paramViewGroup)
  {
    this.afUr = paramViewGroup;
  }
  
  public void setHorizontalScrollPage(boolean paramBoolean)
  {
    this.afUq = paramBoolean;
  }
  
  public void setOnCustomTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.afUs = paramOnTouchListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.pWX = paramOnTouchListener;
  }
  
  public void setPreload(boolean paramBoolean)
  {
    this.rsE = paramBoolean;
  }
  
  public void setRandomStr(String paramString)
  {
    this.KQY = paramString;
  }
  
  public void setWebChromeClient(z paramz)
  {
    AppMethodBeat.i(251678);
    if ((paramz instanceof c)) {
      ((c)paramz).afUy = this.afUw;
    }
    if (paramz == null) {
      this.afUw.clear();
    }
    super.setWebChromeClient(paramz);
    AppMethodBeat.o(251678);
  }
  
  public static final class a
  {
    public static MMWebView b(Context paramContext, View paramView, int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(143422);
      MMWebView.nJ(paramContext);
      paramContext = (MMWebView)paramView.findViewById(paramInt);
      paramContext.lYs = true;
      if (paramContext.getX5WebViewExtension() != null) {}
      for (;;)
      {
        MMWebView.e(paramContext, bool);
        AppMethodBeat.o(143422);
        return paramContext;
        bool = false;
      }
    }
    
    public static MMWebView nK(Context paramContext)
    {
      AppMethodBeat.i(143419);
      try
      {
        Log.i("MMWebView", "TRACE_ORDER:MMWebView.java");
        ao.initWebviewCore(paramContext, MMWebView.afUn, "tools", null);
        MMWebView.nJ(paramContext);
        paramContext = new MMWebView(paramContext, null, 0, WebView.WebViewKind.aifK);
        paramContext.lYs = true;
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
    
    public static MMWebView nL(Context paramContext)
    {
      AppMethodBeat.i(143420);
      Log.i("MMWebView", "TRACE_ORDER:MMWebView.java");
      ao.initWebviewCore(paramContext, MMWebView.afUn, "tools", null);
      MMWebView.nJ(paramContext);
      paramContext = new MMWebView(paramContext);
      paramContext.lYs = true;
      MMWebView.c(paramContext, paramContext.getIsX5Kernel());
      AppMethodBeat.o(143420);
      return paramContext;
    }
    
    public static MMWebView u(Activity paramActivity, int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(143421);
      MMWebView.nJ(paramActivity);
      paramActivity = (MMWebView)paramActivity.findViewById(paramInt);
      paramActivity.lYs = true;
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
  
  public static abstract interface b
  {
    public abstract boolean S(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static final class c
    extends z
  {
    private z WFN;
    List<m> afUy;
    
    public c(z paramz)
    {
      AppMethodBeat.i(251595);
      this.afUy = new ArrayList();
      this.WFN = paramz;
      AppMethodBeat.o(251595);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(251665);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        ((m)localIterator.next()).a(paramWebView, paramInt);
      }
      this.WFN.a(paramWebView, paramInt);
      AppMethodBeat.o(251665);
    }
    
    public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(251675);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.WFN.a(paramView, paramCustomViewCallback);
      AppMethodBeat.o(251675);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, z.a parama)
    {
      AppMethodBeat.i(251661);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.WFN.a(paramWebView, paramValueCallback, parama);
      AppMethodBeat.o(251661);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      AppMethodBeat.i(251634);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.WFN.a(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(251634);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, q paramq)
    {
      AppMethodBeat.i(251643);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.WFN.a(paramWebView, paramString1, paramString2, paramString3, paramq);
      AppMethodBeat.o(251643);
      return bool;
    }
    
    public final void b(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(251655);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.WFN.b(paramWebView, paramInt);
      AppMethodBeat.o(251655);
    }
    
    public final boolean b(long paramLong, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(251602);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.WFN.b(paramLong, paramString1, paramString2, paramString3);
      AppMethodBeat.o(251602);
      return bool;
    }
    
    public final boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      AppMethodBeat.i(251639);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.WFN.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(251639);
      return bool;
    }
    
    public final boolean cxL()
    {
      AppMethodBeat.i(251680);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.WFN.cxL();
      AppMethodBeat.o(251680);
      return bool;
    }
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(251668);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.WFN.d(paramWebView, paramString);
      AppMethodBeat.o(251668);
    }
    
    public final boolean e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      AppMethodBeat.i(251604);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.WFN.e(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
      AppMethodBeat.o(251604);
      return bool;
    }
    
    public final View getVideoLoadingProgressView()
    {
      AppMethodBeat.i(251647);
      Object localObject = this.afUy.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
      localObject = this.WFN.getVideoLoadingProgressView();
      AppMethodBeat.o(251647);
      return localObject;
    }
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(251598);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.WFN.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(251598);
      return bool;
    }
    
    public final void onExitFullscreenVideo(Bitmap paramBitmap)
    {
      AppMethodBeat.i(251684);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.WFN.onExitFullscreenVideo(paramBitmap);
      AppMethodBeat.o(251684);
    }
    
    public final void onGeolocationPermissionsHidePrompt()
    {
      AppMethodBeat.i(251610);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.WFN.onGeolocationPermissionsHidePrompt();
      AppMethodBeat.o(251610);
    }
    
    public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(251606);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.WFN.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
      AppMethodBeat.o(251606);
    }
    
    public final void onHideCustomView()
    {
      AppMethodBeat.i(251626);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.WFN.onHideCustomView();
      AppMethodBeat.o(251626);
    }
    
    public final void onPermissionRequest(PermissionRequest paramPermissionRequest)
    {
      AppMethodBeat.i(251615);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.WFN.onPermissionRequest(paramPermissionRequest);
      AppMethodBeat.o(251615);
    }
    
    public final void onPermissionRequestCanceled(PermissionRequest paramPermissionRequest)
    {
      AppMethodBeat.i(251619);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.WFN.onPermissionRequestCanceled(paramPermissionRequest);
      AppMethodBeat.o(251619);
    }
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(251673);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.WFN.onShowCustomView(paramView, paramCustomViewCallback);
      AppMethodBeat.o(251673);
    }
    
    public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      AppMethodBeat.i(251651);
      Iterator localIterator = this.afUy.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.WFN.openFileChooser(paramValueCallback, paramString1, paramString2);
      AppMethodBeat.o(251651);
    }
  }
  
  final class d
  {
    private d() {}
  }
  
  final class e
  {
    private e() {}
    
    public static void f(WebView paramWebView)
    {
      AppMethodBeat.i(143423);
      paramWebView.setScrollbarFadingEnabled(true);
      paramWebView.setScrollBarStyle(0);
      AppMethodBeat.o(143423);
    }
  }
  
  public static abstract interface f
  {
    public abstract void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMWebView
 * JD-Core Version:    0.7.0.1
 */