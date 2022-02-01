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
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.o;
import com.tencent.xweb.x;
import com.tencent.xweb.x.a;
import com.tencent.xweb.z;
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
  public static final WebView.c LoI;
  private static Vector<WeakReference<MMWebView>> LoK;
  private View.OnTouchListener CBc;
  private r EOf;
  protected boolean LoJ;
  private boolean LoL;
  private ViewGroup LoM;
  private View.OnTouchListener LoN;
  public e LoO;
  private LinkedList<e> LoP;
  private boolean LoQ;
  private List<i> LoR;
  public boolean gff;
  private boolean kqo;
  public boolean mDestroyed;
  private String vVT;
  
  static
  {
    AppMethodBeat.i(193796);
    LoI = WebView.c.MNz;
    LoK = new Vector();
    AppMethodBeat.o(193796);
  }
  
  public MMWebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, WebView.c.MNx);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, WebView.c.MNx);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, WebView.c paramc)
  {
    super(paramContext, paramAttributeSet, paramInt, paramc);
    AppMethodBeat.i(143424);
    this.EOf = new r();
    this.gff = false;
    this.LoJ = false;
    this.LoL = false;
    this.LoO = null;
    this.LoP = new LinkedList();
    this.LoQ = false;
    this.LoR = new ArrayList();
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      ae.e("MicroMsg.MMWebView", "alvinluo MMWebView create not in main thread, stack: %s", new Object[] { bu.fpN() });
      if (j.IS_FLAVOR_RED)
      {
        paramContext = new IllegalStateException("Create MMWebView must be in main thread");
        AppMethodBeat.o(143424);
        throw paramContext;
      }
    }
    setBackgroundColor(paramContext.getResources().getColor(2131101179));
    fPS();
    LoK.add(new WeakReference(this));
    AppMethodBeat.o(143424);
  }
  
  private static boolean b(MMWebView paramMMWebView, String paramString)
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
      ae.e("MicroMsg.MMWebView", "reflectJSExec, e = %s", new Object[] { paramMMWebView });
      AppMethodBeat.o(143431);
    }
    return false;
  }
  
  public static void kM(Context paramContext)
  {
    AppMethodBeat.i(143440);
    paramContext = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    String str1 = paramContext.getString("tbs_webview_disable", "0");
    String str2 = paramContext.getString("tbs_webview_min_sdk_version", null);
    String str3 = paramContext.getString("tbs_webview_max_sdk_version", null);
    ae.i("MicroMsg.MMWebView", "initTbsSettings, tbsDisable = %s, minSdkVersion = %s, maxSdkVersion = %s", new Object[] { str1, str2, str3 });
    if ("1".equals(str1))
    {
      int i = bu.getInt(str2, 0);
      int j = bu.getInt(str3, 0);
      int k = Build.VERSION.SDK_INT;
      if ((k >= i) && ((k <= j) || (j == 0))) {
        ae.i("MicroMsg.MMWebView", "in selection, disable x5");
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      ae.i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", new Object[] { Boolean.valueOf(bool1) });
      if (!bool1) {
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
      }
      bool1 = paramContext.getBoolean("tbs_download_oversea", false);
      boolean bool2 = k.fnT();
      ae.i("MicroMsg.MMWebView", "initTbsSettings, tbs_download_oversea = %b, isGPVersion = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (bool2)) {
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
      }
      AppMethodBeat.o(143440);
      return;
    }
  }
  
  public static void yY(boolean paramBoolean)
  {
    AppMethodBeat.i(193791);
    Iterator localIterator = LoK.iterator();
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
    AppMethodBeat.o(193791);
  }
  
  public final void S(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143439);
    super.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.LoP.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(143439);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(143441);
    this.LoP.add(parame);
    AppMethodBeat.o(143441);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(193793);
    this.LoR.add(parami);
    AppMethodBeat.o(193793);
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
        if (this.LoL) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(143434);
      return bool1;
      this.LoL = false;
      break;
      if (this.LoM == null) {
        break;
      }
      if (this.LoL)
      {
        this.LoM.requestDisallowInterceptTouchEvent(false);
        break;
      }
      this.LoM.requestDisallowInterceptTouchEvent(true);
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
  
  public final void ax(Context paramContext)
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
      this.LoL = true;
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
      Iterator localIterator = LoK.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((MMWebView)localWeakReference.get() == this) {
          LoK.remove(localWeakReference);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.MMWebView", localThrowable, "catch in destroy()", new Object[0]);
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
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(143429);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.lA(19)) || (this.isX5Kernel)) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(143429);
      return;
    }
    if ((this.LoJ) && (b(this, paramString)))
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
      ae.i("MicroMsg.MMWebView", "evaluateJavascript failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(143429);
    }
  }
  
  @TargetApi(11)
  protected final void fPS()
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
      ae.e("MicroMsg.MMWebView", "removeConfigJsInterface, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(143427);
    }
  }
  
  public final void fPT()
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
  
  public final void fPU()
  {
    AppMethodBeat.i(143432);
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143418);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMWebView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (MMWebView.this.getIsX5Kernel())
        {
          int i = paramAnonymousMotionEvent.getAction();
          if (MMWebView.h(MMWebView.this) != null) {
            switch (i & 0xFF)
            {
            default: 
              MMWebView.h(MMWebView.this).requestDisallowInterceptTouchEvent(true);
            }
          }
        }
        while ((MMWebView.i(MMWebView.this) != null) && (MMWebView.i(MMWebView.this).onTouch(paramAnonymousView, paramAnonymousMotionEvent)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/MMWebView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143418);
          return true;
          MMWebView.h(MMWebView.this).requestDisallowInterceptTouchEvent(true);
          continue;
          MMWebView.h(MMWebView.this).requestDisallowInterceptTouchEvent(false);
        }
        if (MMWebView.j(MMWebView.this) != null)
        {
          boolean bool = MMWebView.j(MMWebView.this).onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMWebView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143418);
          return bool;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/MMWebView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(143418);
        return false;
      }
    });
    AppMethodBeat.o(143432);
  }
  
  @TargetApi(9)
  public final void fPV()
  {
    AppMethodBeat.i(143438);
    super.super_computeScroll();
    AppMethodBeat.o(143438);
  }
  
  public final boolean fPW()
  {
    return this.kqo;
  }
  
  public Context getActivityContextIfHas()
  {
    AppMethodBeat.i(193792);
    if ((getContext() instanceof MutableContextWrapper)) {}
    for (Context localContext = ((MutableContextWrapper)getContext()).getBaseContext();; localContext = getContext())
    {
      AppMethodBeat.o(193792);
      return localContext;
    }
  }
  
  public boolean getIsX5Kernel()
  {
    return this.isX5Kernel;
  }
  
  public float getMMDensity()
  {
    AppMethodBeat.i(193795);
    float f2 = com.tencent.mm.cc.a.flD();
    float f1 = f2;
    if (getWebCoreType() == WebView.c.MNy)
    {
      f1 = f2;
      if (XWalkEnvironment.getUsingCustomContext()) {
        f1 = getResources().getDisplayMetrics().density;
      }
    }
    AppMethodBeat.o(193795);
    return f1;
  }
  
  public r getPerformanceHelper()
  {
    return this.EOf;
  }
  
  public String getRandomStr()
  {
    return this.vVT;
  }
  
  @TargetApi(9)
  public final void i(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143435);
    super.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(143435);
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
    if (this.LoQ)
    {
      AppMethodBeat.o(143444);
      return;
    }
    super.onHide();
    this.LoQ = true;
    AppMethodBeat.o(143444);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(143443);
    super.onShow();
    this.LoQ = false;
    AppMethodBeat.o(143443);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143442);
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.LoO != null) {
      this.LoO.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    Iterator localIterator = this.LoP.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(143442);
  }
  
  public void setCleanOnDetached(boolean paramBoolean) {}
  
  public void setCompetitorView(ViewGroup paramViewGroup)
  {
    this.LoM = paramViewGroup;
  }
  
  public void setOnCustomTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.LoN = paramOnTouchListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.CBc = paramOnTouchListener;
  }
  
  public void setPreload(boolean paramBoolean)
  {
    this.kqo = paramBoolean;
  }
  
  public void setRandomStr(String paramString)
  {
    this.vVT = paramString;
  }
  
  public void setWebChromeClient(x paramx)
  {
    AppMethodBeat.i(193794);
    if ((paramx instanceof b)) {
      ((b)paramx).LoT = this.LoR;
    }
    if (paramx == null) {
      this.LoR.clear();
    }
    super.setWebChromeClient(paramx);
    AppMethodBeat.o(193794);
  }
  
  public static final class a
  {
    public static MMWebView a(Context paramContext, View paramView, int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(143422);
      MMWebView.kM(paramContext);
      paramContext = (MMWebView)paramView.findViewById(paramInt);
      paramContext.gff = true;
      if (paramContext.getX5WebViewExtension() != null) {}
      for (;;)
      {
        MMWebView.e(paramContext, bool);
        AppMethodBeat.o(143422);
        return paramContext;
        bool = false;
      }
    }
    
    public static MMWebView kN(Context paramContext)
    {
      AppMethodBeat.i(143419);
      try
      {
        ae.i("MMWebView", "TRACE_ORDER:MMWebView.java");
        WebView.initWebviewCore(paramContext, MMWebView.LoI, "tools", null);
        MMWebView.kM(paramContext);
        paramContext = new MMWebView(paramContext, null, 0, WebView.c.MNA);
        paramContext.gff = true;
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
    
    public static MMWebView kO(Context paramContext)
    {
      AppMethodBeat.i(143420);
      ae.i("MMWebView", "TRACE_ORDER:MMWebView.java");
      WebView.initWebviewCore(paramContext, MMWebView.LoI, "tools", null);
      MMWebView.kM(paramContext);
      paramContext = new MMWebView(paramContext);
      paramContext.gff = true;
      MMWebView.c(paramContext, paramContext.getIsX5Kernel());
      AppMethodBeat.o(143420);
      return paramContext;
    }
    
    public static MMWebView s(Activity paramActivity, int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(143421);
      MMWebView.kM(paramActivity);
      paramActivity = (MMWebView)paramActivity.findViewById(paramInt);
      paramActivity.gff = true;
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
    extends x
  {
    private x Egs;
    List<i> LoT;
    
    public b(x paramx)
    {
      AppMethodBeat.i(193771);
      this.LoT = new ArrayList();
      this.Egs = paramx;
      AppMethodBeat.o(193771);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(193785);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).a(paramWebView, paramInt);
      }
      this.Egs.a(paramWebView, paramInt);
      AppMethodBeat.o(193785);
    }
    
    public final boolean a(long paramLong, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(193773);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Egs.a(paramLong, paramString1, paramString2, paramString3);
      AppMethodBeat.o(193773);
      return bool;
    }
    
    public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(193788);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Egs.a(paramView, paramCustomViewCallback);
      AppMethodBeat.o(193788);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, x.a parama)
    {
      AppMethodBeat.i(193784);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Egs.a(paramWebView, paramValueCallback, parama);
      AppMethodBeat.o(193784);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      AppMethodBeat.i(193778);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Egs.a(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(193778);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, o paramo)
    {
      AppMethodBeat.i(193780);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Egs.a(paramWebView, paramString1, paramString2, paramString3, paramo);
      AppMethodBeat.o(193780);
      return bool;
    }
    
    public final void b(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(193783);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.Egs.b(paramWebView, paramInt);
      AppMethodBeat.o(193783);
    }
    
    public final boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      AppMethodBeat.i(193779);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Egs.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(193779);
      return bool;
    }
    
    public final boolean bpU()
    {
      AppMethodBeat.i(193789);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Egs.bpU();
      AppMethodBeat.o(193789);
      return bool;
    }
    
    public final boolean c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      AppMethodBeat.i(193774);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Egs.c(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
      AppMethodBeat.o(193774);
      return bool;
    }
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(193786);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.Egs.d(paramWebView, paramString);
      AppMethodBeat.o(193786);
    }
    
    public final View getVideoLoadingProgressView()
    {
      AppMethodBeat.i(193781);
      Object localObject = this.LoT.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
      localObject = this.Egs.getVideoLoadingProgressView();
      AppMethodBeat.o(193781);
      return localObject;
    }
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(193772);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Egs.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(193772);
      return bool;
    }
    
    public final void onExitFullscreenVideo(Bitmap paramBitmap)
    {
      AppMethodBeat.i(193790);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.Egs.onExitFullscreenVideo(paramBitmap);
      AppMethodBeat.o(193790);
    }
    
    public final void onGeolocationPermissionsHidePrompt()
    {
      AppMethodBeat.i(193776);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.Egs.onGeolocationPermissionsHidePrompt();
      AppMethodBeat.o(193776);
    }
    
    public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(193775);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.Egs.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
      AppMethodBeat.o(193775);
    }
    
    public final void onHideCustomView()
    {
      AppMethodBeat.i(193777);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.Egs.onHideCustomView();
      AppMethodBeat.o(193777);
    }
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(193787);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.Egs.onShowCustomView(paramView, paramCustomViewCallback);
      AppMethodBeat.o(193787);
    }
    
    public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      AppMethodBeat.i(193782);
      Iterator localIterator = this.LoT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.Egs.openFileChooser(paramValueCallback, paramString1, paramString2);
      AppMethodBeat.o(193782);
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