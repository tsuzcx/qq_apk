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
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
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
  public static final WebView.c JaZ;
  public static String Jba;
  public static String Jbb;
  public static int Jbc;
  public static long Jbd;
  private static Vector<WeakReference<MMWebView>> Jbf;
  private View.OnTouchListener AKw;
  private q CRG;
  private String CjA;
  protected boolean Jbe;
  private boolean Jbg;
  private ViewGroup Jbh;
  private View.OnTouchListener Jbi;
  public e Jbj;
  private LinkedList<e> Jbk;
  private boolean Jbl;
  private List<i> Jbm;
  public boolean fJw;
  private boolean jSK;
  public boolean mDestroyed;
  
  static
  {
    AppMethodBeat.i(197233);
    JaZ = WebView.c.KAa;
    Jba = null;
    Jbb = null;
    Jbc = 3600000;
    Jbd = 3600000L;
    Jbf = new Vector();
    AppMethodBeat.o(197233);
  }
  
  public MMWebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, WebView.c.KzY);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, WebView.c.KzY);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, WebView.c paramc)
  {
    super(paramContext, paramAttributeSet, paramInt, paramc);
    AppMethodBeat.i(143424);
    this.CRG = new q();
    this.fJw = false;
    this.Jbe = false;
    this.Jbg = false;
    this.Jbj = null;
    this.Jbk = new LinkedList();
    this.Jbl = false;
    this.Jbm = new ArrayList();
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      ac.e("MicroMsg.MMWebView", "alvinluo MMWebView create not in main thread, stack: %s", new Object[] { bs.eWi() });
      if (h.IS_FLAVOR_RED)
      {
        paramContext = new IllegalStateException("Create MMWebView must be in main thread");
        AppMethodBeat.o(143424);
        throw paramContext;
      }
    }
    setBackgroundColor(paramContext.getResources().getColor(2131101179));
    fuL();
    Jbf.add(new WeakReference(this));
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
      ac.e("MicroMsg.MMWebView", "reflectJSExec, e = %s", new Object[] { paramMMWebView });
      AppMethodBeat.o(143431);
    }
    return false;
  }
  
  public static void kt(Context paramContext)
  {
    AppMethodBeat.i(143440);
    paramContext = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    String str1 = paramContext.getString("tbs_webview_disable", "0");
    String str2 = paramContext.getString("tbs_webview_min_sdk_version", null);
    String str3 = paramContext.getString("tbs_webview_max_sdk_version", null);
    ac.i("MicroMsg.MMWebView", "initTbsSettings, tbsDisable = %s, minSdkVersion = %s, maxSdkVersion = %s", new Object[] { str1, str2, str3 });
    if ("1".equals(str1))
    {
      int i = bs.getInt(str2, 0);
      int j = bs.getInt(str3, 0);
      int k = Build.VERSION.SDK_INT;
      if ((k >= i) && ((k <= j) || (j == 0))) {
        ac.i("MicroMsg.MMWebView", "in selection, disable x5");
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      ac.i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", new Object[] { Boolean.valueOf(bool1) });
      if (!bool1) {
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
      }
      bool1 = paramContext.getBoolean("tbs_download_oversea", false);
      boolean bool2 = com.tencent.mm.sdk.platformtools.i.eUv();
      ac.i("MicroMsg.MMWebView", "initTbsSettings, tbs_download_oversea = %b, isGPVersion = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (bool2)) {
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
      }
      AppMethodBeat.o(143440);
      return;
    }
  }
  
  public static void xW(boolean paramBoolean)
  {
    AppMethodBeat.i(197228);
    Iterator localIterator = Jbf.iterator();
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
    AppMethodBeat.o(197228);
  }
  
  public final void S(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143439);
    super.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.Jbk.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(143439);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(143441);
    this.Jbk.add(parame);
    AppMethodBeat.o(143441);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(197230);
    this.Jbm.add(parami);
    AppMethodBeat.o(197230);
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
        if (this.Jbg) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(143434);
      return bool1;
      this.Jbg = false;
      break;
      if (this.Jbh == null) {
        break;
      }
      if (this.Jbg)
      {
        this.Jbh.requestDisallowInterceptTouchEvent(false);
        break;
      }
      this.Jbh.requestDisallowInterceptTouchEvent(true);
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
  
  public final void aw(Context paramContext)
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
      this.Jbg = true;
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
      Iterator localIterator = Jbf.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((MMWebView)localWeakReference.get() == this) {
          Jbf.remove(localWeakReference);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("MicroMsg.MMWebView", localThrowable, "catch in destroy()", new Object[0]);
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
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(143429);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.kZ(19)) || (this.isX5Kernel)) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(143429);
      return;
    }
    if ((this.Jbe) && (b(this, paramString)))
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
      ac.i("MicroMsg.MMWebView", "evaluateJavascript failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(143429);
    }
  }
  
  @TargetApi(11)
  protected final void fuL()
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
      ac.e("MicroMsg.MMWebView", "removeConfigJsInterface, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(143427);
    }
  }
  
  public final void fuM()
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
  
  public final void fuN()
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
  public final void fuO()
  {
    AppMethodBeat.i(143438);
    super.super_computeScroll();
    AppMethodBeat.o(143438);
  }
  
  public final boolean fuP()
  {
    return this.jSK;
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
    AppMethodBeat.i(197229);
    if ((getContext() instanceof MutableContextWrapper)) {}
    for (Context localContext = ((MutableContextWrapper)getContext()).getBaseContext();; localContext = getContext())
    {
      AppMethodBeat.o(197229);
      return localContext;
    }
  }
  
  public boolean getIsX5Kernel()
  {
    return this.isX5Kernel;
  }
  
  public float getMMDensity()
  {
    AppMethodBeat.i(197232);
    float f2 = a.eSs();
    float f1 = f2;
    if (getWebCoreType() == WebView.c.KzZ)
    {
      f1 = f2;
      if (XWalkEnvironment.getUsingCustomContext()) {
        f1 = getResources().getDisplayMetrics().density;
      }
    }
    AppMethodBeat.o(197232);
    return f1;
  }
  
  public q getPerformanceHelper()
  {
    return this.CRG;
  }
  
  public String getRandomStr()
  {
    return this.CjA;
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
    if (this.Jbl)
    {
      AppMethodBeat.o(143444);
      return;
    }
    super.onHide();
    this.Jbl = true;
    AppMethodBeat.o(143444);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(143443);
    super.onShow();
    this.Jbl = false;
    AppMethodBeat.o(143443);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143442);
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.Jbj != null) {
      this.Jbj.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    Iterator localIterator = this.Jbk.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(143442);
  }
  
  public void setCompetitorView(ViewGroup paramViewGroup)
  {
    this.Jbh = paramViewGroup;
  }
  
  public void setOnCustomTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.Jbi = paramOnTouchListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.AKw = paramOnTouchListener;
  }
  
  public void setPreload(boolean paramBoolean)
  {
    this.jSK = paramBoolean;
  }
  
  public void setRandomStr(String paramString)
  {
    this.CjA = paramString;
  }
  
  public void setWebChromeClient(x paramx)
  {
    AppMethodBeat.i(197231);
    if ((paramx instanceof b)) {
      ((b)paramx).Jbo = this.Jbm;
    }
    if (paramx == null) {
      this.Jbm.clear();
    }
    super.setWebChromeClient(paramx);
    AppMethodBeat.o(197231);
  }
  
  public static final class a
  {
    public static MMWebView a(Context paramContext, View paramView, int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(143422);
      MMWebView.kt(paramContext);
      paramContext = (MMWebView)paramView.findViewById(paramInt);
      paramContext.fJw = true;
      if (paramContext.getX5WebViewExtension() != null) {}
      for (;;)
      {
        MMWebView.e(paramContext, bool);
        AppMethodBeat.o(143422);
        return paramContext;
        bool = false;
      }
    }
    
    public static MMWebView ku(Context paramContext)
    {
      AppMethodBeat.i(143419);
      try
      {
        ac.i("MMWebView", "TRACE_ORDER:MMWebView.java");
        WebView.initWebviewCore(paramContext, MMWebView.JaZ, "tools", null);
        MMWebView.kt(paramContext);
        paramContext = new MMWebView(paramContext, null, 0, WebView.c.KAb);
        paramContext.fJw = true;
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
    
    public static MMWebView kv(Context paramContext)
    {
      AppMethodBeat.i(143420);
      ac.i("MMWebView", "TRACE_ORDER:MMWebView.java");
      WebView.initWebviewCore(paramContext, MMWebView.JaZ, "tools", null);
      MMWebView.kt(paramContext);
      paramContext = new MMWebView(paramContext);
      paramContext.fJw = true;
      MMWebView.c(paramContext, paramContext.getIsX5Kernel());
      AppMethodBeat.o(143420);
      return paramContext;
    }
    
    public static MMWebView s(Activity paramActivity, int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(143421);
      MMWebView.kt(paramActivity);
      paramActivity = (MMWebView)paramActivity.findViewById(paramInt);
      paramActivity.fJw = true;
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
    private x Clg;
    List<i> Jbo;
    
    public b(x paramx)
    {
      AppMethodBeat.i(197208);
      this.Jbo = new ArrayList();
      this.Clg = paramx;
      AppMethodBeat.o(197208);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(197222);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).a(paramWebView, paramInt);
      }
      this.Clg.a(paramWebView, paramInt);
      AppMethodBeat.o(197222);
    }
    
    public final boolean a(long paramLong, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(197210);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Clg.a(paramLong, paramString1, paramString2, paramString3);
      AppMethodBeat.o(197210);
      return bool;
    }
    
    public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(197225);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Clg.a(paramView, paramCustomViewCallback);
      AppMethodBeat.o(197225);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, x.a parama)
    {
      AppMethodBeat.i(197221);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Clg.a(paramWebView, paramValueCallback, parama);
      AppMethodBeat.o(197221);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      AppMethodBeat.i(197215);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Clg.a(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(197215);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, o paramo)
    {
      AppMethodBeat.i(197217);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Clg.a(paramWebView, paramString1, paramString2, paramString3, paramo);
      AppMethodBeat.o(197217);
      return bool;
    }
    
    public final void b(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(197220);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.Clg.b(paramWebView, paramInt);
      AppMethodBeat.o(197220);
    }
    
    public final boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      AppMethodBeat.i(197216);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Clg.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(197216);
      return bool;
    }
    
    public final boolean blz()
    {
      AppMethodBeat.i(197226);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Clg.blz();
      AppMethodBeat.o(197226);
      return bool;
    }
    
    public final boolean c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      AppMethodBeat.i(197211);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Clg.c(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
      AppMethodBeat.o(197211);
      return bool;
    }
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(197223);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.Clg.d(paramWebView, paramString);
      AppMethodBeat.o(197223);
    }
    
    public final View getVideoLoadingProgressView()
    {
      AppMethodBeat.i(197218);
      Object localObject = this.Jbo.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
      localObject = this.Clg.getVideoLoadingProgressView();
      AppMethodBeat.o(197218);
      return localObject;
    }
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(197209);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.Clg.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(197209);
      return bool;
    }
    
    public final void onExitFullscreenVideo(Bitmap paramBitmap)
    {
      AppMethodBeat.i(197227);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.Clg.onExitFullscreenVideo(paramBitmap);
      AppMethodBeat.o(197227);
    }
    
    public final void onGeolocationPermissionsHidePrompt()
    {
      AppMethodBeat.i(197213);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.Clg.onGeolocationPermissionsHidePrompt();
      AppMethodBeat.o(197213);
    }
    
    public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(197212);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.Clg.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
      AppMethodBeat.o(197212);
    }
    
    public final void onHideCustomView()
    {
      AppMethodBeat.i(197214);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.Clg.onHideCustomView();
      AppMethodBeat.o(197214);
    }
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(197224);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.Clg.onShowCustomView(paramView, paramCustomViewCallback);
      AppMethodBeat.o(197224);
    }
    
    public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      AppMethodBeat.i(197219);
      Iterator localIterator = this.Jbo.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.Clg.openFileChooser(paramValueCallback, paramString1, paramString2);
      AppMethodBeat.o(197219);
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