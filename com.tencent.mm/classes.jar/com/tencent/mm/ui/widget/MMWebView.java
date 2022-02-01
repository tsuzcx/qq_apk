package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
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
import com.tencent.mm.cj.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.aa;
import com.tencent.xweb.o;
import com.tencent.xweb.x;
import com.tencent.xweb.x.a;
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
  public static final WebView.c Yct;
  private static Vector<WeakReference<MMWebView>> Ycv;
  private String EVx;
  private r QCL;
  public f YcA;
  private LinkedList<f> YcB;
  private boolean YcC;
  private List<k> YcD;
  protected boolean Ycu;
  private boolean Ycw;
  private boolean Ycx;
  private ViewGroup Ycy;
  private View.OnTouchListener Ycz;
  public int gco;
  public boolean jvb;
  public boolean mDestroyed;
  private View.OnTouchListener nan;
  private boolean ooW;
  
  static
  {
    AppMethodBeat.i(190545);
    Yct = WebView.c.aabn;
    Ycv = new Vector();
    AppMethodBeat.o(190545);
  }
  
  public MMWebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, WebView.c.aabl);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, WebView.c.aabl);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, WebView.c paramc)
  {
    super(paramContext, paramAttributeSet, paramInt, paramc);
    AppMethodBeat.i(143424);
    this.QCL = new r();
    this.gco = 0;
    this.jvb = false;
    this.Ycu = false;
    this.Ycw = false;
    this.Ycx = false;
    this.YcA = null;
    this.YcB = new LinkedList();
    this.YcC = false;
    this.YcD = new ArrayList();
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
    hZM();
    Ycv.add(new WeakReference(this));
    AppMethodBeat.o(143424);
  }
  
  public static void Ho(boolean paramBoolean)
  {
    AppMethodBeat.i(190429);
    Iterator localIterator = Ycv.iterator();
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
    AppMethodBeat.o(190429);
  }
  
  private static boolean c(MMWebView paramMMWebView, String paramString)
  {
    AppMethodBeat.i(143431);
    try
    {
      paramMMWebView = new com.tencent.mm.compatible.loader.b(new com.tencent.mm.compatible.loader.b(new com.tencent.mm.compatible.loader.b(paramMMWebView, "mSysWebView", null).get(), "mProvider", null).get(), "mWebViewCore", null).get();
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
  
  private boolean hZO()
  {
    AppMethodBeat.i(190450);
    if (this.mDestroyed)
    {
      Log.w("MicroMsg.MMWebView", "EvaluateJavascript can not after destroy. %s", new Object[] { Util.getStack() });
      AppMethodBeat.o(190450);
      return false;
    }
    AppMethodBeat.o(190450);
    return true;
  }
  
  public static void lF(Context paramContext)
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
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
      }
      bool1 = ((SharedPreferences)localObject).getBoolean("tbs_download_oversea", false);
      boolean bool2 = ChannelUtil.isGPVersion();
      Log.i("MicroMsg.MMWebView", "initTbsSettings, tbs_download_oversea = %b, isGPVersion = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (bool2)) {
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
      }
      localObject = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzo, "");
      if (!Util.isNullOrNil((String)localObject))
      {
        Log.i("MicroMsg.MMWebView", "setNewDnsHostList %s", new Object[] { localObject });
        com.tencent.xweb.x5.sdk.d.setNewDnsHostList((String)localObject);
      }
      i = com.tencent.xweb.x5.sdk.d.getTbsVersion(paramContext);
      if ((Build.VERSION.SDK_INT > 28) && (paramContext.getApplicationInfo().targetSdkVersion > 28) && (i > 0) && (i < 45114)) {
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
      }
      AppMethodBeat.o(143440);
      return;
    }
  }
  
  public final void W(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143439);
    super.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.YcB.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(143439);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(143441);
    this.YcB.add(paramf);
    AppMethodBeat.o(143441);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(190517);
    this.YcD.add(paramk);
    AppMethodBeat.o(190517);
  }
  
  public void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(143430);
    if (!hZO())
    {
      AppMethodBeat.o(143430);
      return;
    }
    super.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(143430);
  }
  
  public void aD(Context paramContext)
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
  
  public final boolean au(MotionEvent paramMotionEvent)
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
        if (this.Ycw) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(143434);
      return bool1;
      this.Ycw = false;
      this.Ycx = false;
      break;
      if (this.Ycy == null) {
        break;
      }
      if ((this.Ycw) || (this.Ycx))
      {
        this.Ycy.requestDisallowInterceptTouchEvent(false);
        break;
      }
      this.Ycy.requestDisallowInterceptTouchEvent(true);
      break;
      bool1 = false;
      continue;
      bool1 = bool2;
    }
  }
  
  public final boolean av(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143436);
    boolean bool = super.super_dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143436);
    return bool;
  }
  
  public final boolean aw(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143437);
    boolean bool = super.super_onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143437);
    return bool;
  }
  
  @TargetApi(9)
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(143433);
    paramBoolean = super.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    Log.d("MicroMsg.MMWebView", "tbs_overScrollBy, deltaX: %d, deltaY: %d, scrollX: %b, scrollY: %b, r: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean) });
    if ((paramInt4 < 0) || ((paramInt4 == 0) && (paramInt2 < 0))) {
      this.Ycw = true;
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
      Iterator localIterator = Ycv.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((MMWebView)localWeakReference.get() == this) {
          Ycv.remove(localWeakReference);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
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
  
  public final boolean dwQ()
  {
    return this.ooW;
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(143429);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(143429);
      return;
    }
    if (!hZO())
    {
      AppMethodBeat.o(143429);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.qV(19)) || (this.aabd)) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(143429);
      return;
    }
    if ((this.Ycu) && (c(this, paramString)))
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
  
  @TargetApi(9)
  public final void g(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143435);
    Log.d("MicroMsg.MMWebView", "tbs_onOverScrolled, scrollX: %d, scrollY: %d, clampedX: %b, clampedY: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    super.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(143435);
  }
  
  public Context getActivityContextIfHas()
  {
    AppMethodBeat.i(190509);
    if ((getContext() instanceof MutableContextWrapper)) {}
    for (Context localContext = ((MutableContextWrapper)getContext()).getBaseContext();; localContext = getContext())
    {
      AppMethodBeat.o(190509);
      return localContext;
    }
  }
  
  public boolean getIsX5Kernel()
  {
    return this.aabd;
  }
  
  public float getMMDensity()
  {
    AppMethodBeat.i(190522);
    float f2 = a.hrl();
    float f1 = f2;
    if (getWebCoreType() == WebView.c.aabm)
    {
      f1 = f2;
      if (XWalkEnvironment.getUsingCustomContext()) {
        f1 = getResources().getDisplayMetrics().density;
      }
    }
    AppMethodBeat.o(190522);
    return f1;
  }
  
  public r getPerformanceHelper()
  {
    return this.QCL;
  }
  
  public String getRandomStr()
  {
    return this.EVx;
  }
  
  public final boolean hZL()
  {
    AppMethodBeat.i(190424);
    if ((isSysKernel()) || (isX5WrappedSysKernel()))
    {
      AppMethodBeat.o(190424);
      return true;
    }
    AppMethodBeat.o(190424);
    return false;
  }
  
  @TargetApi(11)
  protected final void hZM()
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
  
  public final void hZN()
  {
    AppMethodBeat.i(143428);
    if (Build.VERSION.SDK_INT >= 5)
    {
      new e((byte)0);
      e.e(this);
      AppMethodBeat.o(143428);
      return;
    }
    new d((byte)0);
    setScrollBarStyle(0);
    AppMethodBeat.o(143428);
  }
  
  public final void hZP()
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
          if (MMWebView.i(MMWebView.this) != null) {
            switch (i & 0xFF)
            {
            default: 
              MMWebView.i(MMWebView.this).requestDisallowInterceptTouchEvent(true);
            }
          }
        }
        while ((MMWebView.j(MMWebView.this) != null) && (MMWebView.j(MMWebView.this).onTouch(paramAnonymousView, paramAnonymousMotionEvent)))
        {
          AppMethodBeat.o(143418);
          return true;
          MMWebView.i(MMWebView.this).requestDisallowInterceptTouchEvent(true);
          continue;
          MMWebView.i(MMWebView.this).requestDisallowInterceptTouchEvent(false);
        }
        if (MMWebView.k(MMWebView.this) != null)
        {
          boolean bool = MMWebView.k(MMWebView.this).onTouch(paramAnonymousView, paramAnonymousMotionEvent);
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
  public final void hZQ()
  {
    AppMethodBeat.i(143438);
    super.super_computeScroll();
    AppMethodBeat.o(143438);
  }
  
  public final boolean isDestroyed()
  {
    return this.mDestroyed;
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
    if (this.YcC)
    {
      AppMethodBeat.o(143444);
      return;
    }
    super.onHide();
    this.YcC = true;
    AppMethodBeat.o(143444);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(143443);
    super.onShow();
    this.YcC = false;
    AppMethodBeat.o(143443);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143442);
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.YcA != null) {
      this.YcA.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    Iterator localIterator = this.YcB.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(143442);
  }
  
  public void setCleanOnDetached(boolean paramBoolean) {}
  
  public void setCompetitorView(ViewGroup paramViewGroup)
  {
    this.Ycy = paramViewGroup;
  }
  
  public void setHorizontalScrollPage(boolean paramBoolean)
  {
    this.Ycx = paramBoolean;
  }
  
  public void setOnCustomTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.Ycz = paramOnTouchListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.nan = paramOnTouchListener;
  }
  
  public void setPreload(boolean paramBoolean)
  {
    this.ooW = paramBoolean;
  }
  
  public void setRandomStr(String paramString)
  {
    this.EVx = paramString;
  }
  
  public void setWebChromeClient(x paramx)
  {
    AppMethodBeat.i(190520);
    if ((paramx instanceof c)) {
      ((c)paramx).YcF = this.YcD;
    }
    if (paramx == null) {
      this.YcD.clear();
    }
    super.setWebChromeClient(paramx);
    AppMethodBeat.o(190520);
  }
  
  public static final class a
  {
    public static MMWebView a(Context paramContext, View paramView, int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(143422);
      MMWebView.lF(paramContext);
      paramContext = (MMWebView)paramView.findViewById(paramInt);
      paramContext.jvb = true;
      if (paramContext.getX5WebViewExtension() != null) {}
      for (;;)
      {
        MMWebView.e(paramContext, bool);
        AppMethodBeat.o(143422);
        return paramContext;
        bool = false;
      }
    }
    
    public static MMWebView eN(Context paramContext)
    {
      AppMethodBeat.i(293115);
      paramContext = lH(paramContext);
      AppMethodBeat.o(293115);
      return paramContext;
    }
    
    public static MMWebView lG(Context paramContext)
    {
      AppMethodBeat.i(143419);
      try
      {
        Log.i("MMWebView", "TRACE_ORDER:MMWebView.java");
        WebView.initWebviewCore(paramContext, MMWebView.Yct, "tools", null);
        MMWebView.lF(paramContext);
        paramContext = new MMWebView(paramContext, null, 0, WebView.c.aabo);
        paramContext.jvb = true;
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
    
    public static MMWebView lH(Context paramContext)
    {
      AppMethodBeat.i(143420);
      Log.i("MMWebView", "TRACE_ORDER:MMWebView.java");
      WebView.initWebviewCore(paramContext, MMWebView.Yct, "tools", null);
      MMWebView.lF(paramContext);
      paramContext = new MMWebView(paramContext);
      paramContext.jvb = true;
      MMWebView.c(paramContext, paramContext.getIsX5Kernel());
      AppMethodBeat.o(143420);
      return paramContext;
    }
    
    public static MMWebView s(Activity paramActivity, int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(143421);
      MMWebView.lF(paramActivity);
      paramActivity = (MMWebView)paramActivity.findViewById(paramInt);
      paramActivity.jvb = true;
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
    public abstract boolean I(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static final class c
    extends x
  {
    private x PPu;
    List<k> YcF;
    
    public c(x paramx)
    {
      AppMethodBeat.i(187686);
      this.YcF = new ArrayList();
      this.PPu = paramx;
      AppMethodBeat.o(187686);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(187716);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        ((k)localIterator.next()).a(paramWebView, paramInt);
      }
      this.PPu.a(paramWebView, paramInt);
      AppMethodBeat.o(187716);
    }
    
    public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(187719);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.PPu.a(paramView, paramCustomViewCallback);
      AppMethodBeat.o(187719);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, x.a parama)
    {
      AppMethodBeat.i(187715);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.PPu.a(paramWebView, paramValueCallback, parama);
      AppMethodBeat.o(187715);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      AppMethodBeat.i(187707);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.PPu.a(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(187707);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, o paramo)
    {
      AppMethodBeat.i(187710);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.PPu.a(paramWebView, paramString1, paramString2, paramString3, paramo);
      AppMethodBeat.o(187710);
      return bool;
    }
    
    public final void b(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(187714);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.PPu.b(paramWebView, paramInt);
      AppMethodBeat.o(187714);
    }
    
    public final boolean b(long paramLong, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(187694);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.PPu.b(paramLong, paramString1, paramString2, paramString3);
      AppMethodBeat.o(187694);
      return bool;
    }
    
    public final boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      AppMethodBeat.i(187709);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.PPu.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(187709);
      return bool;
    }
    
    public final boolean bXA()
    {
      AppMethodBeat.i(187720);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.PPu.bXA();
      AppMethodBeat.o(187720);
      return bool;
    }
    
    public final boolean c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      AppMethodBeat.i(187696);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.PPu.c(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
      AppMethodBeat.o(187696);
      return bool;
    }
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(187717);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.PPu.d(paramWebView, paramString);
      AppMethodBeat.o(187717);
    }
    
    public final View getVideoLoadingProgressView()
    {
      AppMethodBeat.i(187711);
      Object localObject = this.YcF.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
      localObject = this.PPu.getVideoLoadingProgressView();
      AppMethodBeat.o(187711);
      return localObject;
    }
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(187689);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.PPu.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(187689);
      return bool;
    }
    
    public final void onExitFullscreenVideo(Bitmap paramBitmap)
    {
      AppMethodBeat.i(187722);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.PPu.onExitFullscreenVideo(paramBitmap);
      AppMethodBeat.o(187722);
    }
    
    public final void onGeolocationPermissionsHidePrompt()
    {
      AppMethodBeat.i(187700);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.PPu.onGeolocationPermissionsHidePrompt();
      AppMethodBeat.o(187700);
    }
    
    public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(187698);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.PPu.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
      AppMethodBeat.o(187698);
    }
    
    public final void onHideCustomView()
    {
      AppMethodBeat.i(187706);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.PPu.onHideCustomView();
      AppMethodBeat.o(187706);
    }
    
    public final void onPermissionRequest(PermissionRequest paramPermissionRequest)
    {
      AppMethodBeat.i(187702);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.PPu.onPermissionRequest(paramPermissionRequest);
      AppMethodBeat.o(187702);
    }
    
    public final void onPermissionRequestCanceled(PermissionRequest paramPermissionRequest)
    {
      AppMethodBeat.i(187704);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.PPu.onPermissionRequestCanceled(paramPermissionRequest);
      AppMethodBeat.o(187704);
    }
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(187718);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.PPu.onShowCustomView(paramView, paramCustomViewCallback);
      AppMethodBeat.o(187718);
    }
    
    public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      AppMethodBeat.i(187712);
      Iterator localIterator = this.YcF.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.PPu.openFileChooser(paramValueCallback, paramString1, paramString2);
      AppMethodBeat.o(187712);
    }
  }
  
  final class d
  {
    private d() {}
  }
  
  final class e
  {
    private e() {}
    
    public static void e(WebView paramWebView)
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