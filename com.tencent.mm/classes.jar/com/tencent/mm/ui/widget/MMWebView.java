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
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  public static final WebView.c QDR;
  private static Vector<WeakReference<MMWebView>> QDT;
  private View.OnTouchListener HeV;
  private r JDX;
  protected boolean QDS;
  private boolean QDU;
  private ViewGroup QDV;
  private View.OnTouchListener QDW;
  public e QDX;
  private LinkedList<e> QDY;
  private boolean QDZ;
  private List<i> QEa;
  public boolean gKM;
  private boolean ltW;
  public boolean mDestroyed;
  private String zpY;
  
  static
  {
    AppMethodBeat.i(205438);
    QDR = WebView.c.SAu;
    QDT = new Vector();
    AppMethodBeat.o(205438);
  }
  
  public MMWebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, WebView.c.SAs);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, WebView.c.SAs);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, WebView.c paramc)
  {
    super(paramContext, paramAttributeSet, paramInt, paramc);
    AppMethodBeat.i(143424);
    this.JDX = new r();
    this.gKM = false;
    this.QDS = false;
    this.QDU = false;
    this.QDX = null;
    this.QDY = new LinkedList();
    this.QDZ = false;
    this.QEa = new ArrayList();
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
    setBackgroundColor(paramContext.getResources().getColor(2131101424));
    gYV();
    QDT.add(new WeakReference(this));
    AppMethodBeat.o(143424);
  }
  
  public static void CU(boolean paramBoolean)
  {
    AppMethodBeat.i(205431);
    Iterator localIterator = QDT.iterator();
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
    AppMethodBeat.o(205431);
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
      Log.e("MicroMsg.MMWebView", "reflectJSExec, e = %s", new Object[] { paramMMWebView });
      AppMethodBeat.o(143431);
    }
    return false;
  }
  
  private static void gYZ()
  {
    AppMethodBeat.i(205432);
    String str = ((b)g.af(b.class)).a(b.a.rSP, "");
    if (!Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.MMWebView", "setNewDnsHostList %s", new Object[] { str });
      com.tencent.xweb.x5.sdk.d.setNewDnsHostList(str);
    }
    AppMethodBeat.o(205432);
  }
  
  public static void kI(Context paramContext)
  {
    AppMethodBeat.i(143440);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    String str1 = localSharedPreferences.getString("tbs_webview_disable", "0");
    String str2 = localSharedPreferences.getString("tbs_webview_min_sdk_version", null);
    String str3 = localSharedPreferences.getString("tbs_webview_max_sdk_version", null);
    Log.i("MicroMsg.MMWebView", "initTbsSettings, tbsDisable = %s, minSdkVersion = %s, maxSdkVersion = %s", new Object[] { str1, str2, str3 });
    if ("1".equals(str1))
    {
      int i = Util.getInt(str2, 0);
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
      bool1 = localSharedPreferences.getBoolean("tbs_download_oversea", false);
      boolean bool2 = ChannelUtil.isGPVersion();
      Log.i("MicroMsg.MMWebView", "initTbsSettings, tbs_download_oversea = %b, isGPVersion = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (bool2)) {
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
      }
      gYZ();
      kJ(paramContext);
      AppMethodBeat.o(143440);
      return;
    }
  }
  
  private static void kJ(Context paramContext)
  {
    AppMethodBeat.i(205433);
    int i = com.tencent.xweb.x5.sdk.d.getTbsVersion(paramContext);
    if ((Build.VERSION.SDK_INT > 28) && (paramContext.getApplicationInfo().targetSdkVersion > 28) && (i > 0) && (i < 45114)) {
      com.tencent.xweb.x5.sdk.d.forceSysWebView();
    }
    AppMethodBeat.o(205433);
  }
  
  public final void R(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143439);
    super.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.QDY.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(143439);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(143441);
    this.QDY.add(parame);
    AppMethodBeat.o(143441);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(205435);
    this.QEa.add(parami);
    AppMethodBeat.o(205435);
  }
  
  public void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(143430);
    super.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(143430);
  }
  
  public final void aG(Context paramContext)
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
  
  public final boolean am(MotionEvent paramMotionEvent)
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
        if (this.QDU) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(143434);
      return bool1;
      this.QDU = false;
      break;
      if (this.QDV == null) {
        break;
      }
      if (this.QDU)
      {
        this.QDV.requestDisallowInterceptTouchEvent(false);
        break;
      }
      this.QDV.requestDisallowInterceptTouchEvent(true);
      break;
      bool1 = false;
      continue;
      bool1 = bool2;
    }
  }
  
  public final boolean an(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143436);
    boolean bool = super.super_dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143436);
    return bool;
  }
  
  public final boolean ao(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143437);
    boolean bool = super.super_onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143437);
    return bool;
  }
  
  @TargetApi(9)
  public final boolean c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(143433);
    paramBoolean = super.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    if ((paramInt4 < 0) || ((paramInt4 == 0) && (paramInt2 < 0))) {
      this.QDU = true;
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
      Iterator localIterator = QDT.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((MMWebView)localWeakReference.get() == this) {
          QDT.remove(localWeakReference);
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
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(143429);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(143429);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.oD(19)) || (this.isX5Kernel)) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(143429);
      return;
    }
    if ((this.QDS) && (b(this, paramString)))
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
  
  public final boolean gYU()
  {
    AppMethodBeat.i(205430);
    if ((isSysKernel()) || (isX5WrappedSysKernel()))
    {
      AppMethodBeat.o(205430);
      return true;
    }
    AppMethodBeat.o(205430);
    return false;
  }
  
  @TargetApi(11)
  protected final void gYV()
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
  
  public final void gYW()
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
  
  public final void gYX()
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
  public final void gYY()
  {
    AppMethodBeat.i(143438);
    super.super_computeScroll();
    AppMethodBeat.o(143438);
  }
  
  public final boolean gZa()
  {
    return this.ltW;
  }
  
  public Context getActivityContextIfHas()
  {
    AppMethodBeat.i(205434);
    if ((getContext() instanceof MutableContextWrapper)) {}
    for (Context localContext = ((MutableContextWrapper)getContext()).getBaseContext();; localContext = getContext())
    {
      AppMethodBeat.o(205434);
      return localContext;
    }
  }
  
  public boolean getIsX5Kernel()
  {
    return this.isX5Kernel;
  }
  
  public float getMMDensity()
  {
    AppMethodBeat.i(205437);
    float f2 = a.gvp();
    float f1 = f2;
    if (getWebCoreType() == WebView.c.SAt)
    {
      f1 = f2;
      if (XWalkEnvironment.getUsingCustomContext()) {
        f1 = getResources().getDisplayMetrics().density;
      }
    }
    AppMethodBeat.o(205437);
    return f1;
  }
  
  public r getPerformanceHelper()
  {
    return this.JDX;
  }
  
  public String getRandomStr()
  {
    return this.zpY;
  }
  
  @TargetApi(9)
  public final void h(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143435);
    super.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(143435);
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
    if (this.QDZ)
    {
      AppMethodBeat.o(143444);
      return;
    }
    super.onHide();
    this.QDZ = true;
    AppMethodBeat.o(143444);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(143443);
    super.onShow();
    this.QDZ = false;
    AppMethodBeat.o(143443);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143442);
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.QDX != null) {
      this.QDX.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    Iterator localIterator = this.QDY.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(143442);
  }
  
  public void setCleanOnDetached(boolean paramBoolean) {}
  
  public void setCompetitorView(ViewGroup paramViewGroup)
  {
    this.QDV = paramViewGroup;
  }
  
  public void setOnCustomTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.QDW = paramOnTouchListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.HeV = paramOnTouchListener;
  }
  
  public void setPreload(boolean paramBoolean)
  {
    this.ltW = paramBoolean;
  }
  
  public void setRandomStr(String paramString)
  {
    this.zpY = paramString;
  }
  
  public void setWebChromeClient(x paramx)
  {
    AppMethodBeat.i(205436);
    if ((paramx instanceof b)) {
      ((b)paramx).QEc = this.QEa;
    }
    if (paramx == null) {
      this.QEa.clear();
    }
    super.setWebChromeClient(paramx);
    AppMethodBeat.o(205436);
  }
  
  public static final class a
  {
    public static MMWebView a(Context paramContext, View paramView, int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(143422);
      MMWebView.kI(paramContext);
      paramContext = (MMWebView)paramView.findViewById(paramInt);
      paramContext.gKM = true;
      if (paramContext.getX5WebViewExtension() != null) {}
      for (;;)
      {
        MMWebView.e(paramContext, bool);
        AppMethodBeat.o(143422);
        return paramContext;
        bool = false;
      }
    }
    
    public static MMWebView kK(Context paramContext)
    {
      AppMethodBeat.i(143419);
      try
      {
        Log.i("MMWebView", "TRACE_ORDER:MMWebView.java");
        WebView.initWebviewCore(paramContext, MMWebView.QDR, "tools", null);
        MMWebView.kI(paramContext);
        paramContext = new MMWebView(paramContext, null, 0, WebView.c.SAv);
        paramContext.gKM = true;
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
    
    public static MMWebView kL(Context paramContext)
    {
      AppMethodBeat.i(143420);
      Log.i("MMWebView", "TRACE_ORDER:MMWebView.java");
      WebView.initWebviewCore(paramContext, MMWebView.QDR, "tools", null);
      MMWebView.kI(paramContext);
      paramContext = new MMWebView(paramContext);
      paramContext.gKM = true;
      MMWebView.c(paramContext, paramContext.getIsX5Kernel());
      AppMethodBeat.o(143420);
      return paramContext;
    }
    
    public static MMWebView r(Activity paramActivity, int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(143421);
      MMWebView.kI(paramActivity);
      paramActivity = (MMWebView)paramActivity.findViewById(paramInt);
      paramActivity.gKM = true;
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
    private x ITc;
    List<i> QEc;
    
    public b(x paramx)
    {
      AppMethodBeat.i(205410);
      this.QEc = new ArrayList();
      this.ITc = paramx;
      AppMethodBeat.o(205410);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(205424);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).a(paramWebView, paramInt);
      }
      this.ITc.a(paramWebView, paramInt);
      AppMethodBeat.o(205424);
    }
    
    public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(205427);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.ITc.a(paramView, paramCustomViewCallback);
      AppMethodBeat.o(205427);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, x.a parama)
    {
      AppMethodBeat.i(205423);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.ITc.a(paramWebView, paramValueCallback, parama);
      AppMethodBeat.o(205423);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      AppMethodBeat.i(205417);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.ITc.a(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(205417);
      return bool;
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, o paramo)
    {
      AppMethodBeat.i(205419);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.ITc.a(paramWebView, paramString1, paramString2, paramString3, paramo);
      AppMethodBeat.o(205419);
      return bool;
    }
    
    public final void b(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(205422);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.ITc.b(paramWebView, paramInt);
      AppMethodBeat.o(205422);
    }
    
    public final boolean b(long paramLong, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(205412);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.ITc.b(paramLong, paramString1, paramString2, paramString3);
      AppMethodBeat.o(205412);
      return bool;
    }
    
    public final boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      AppMethodBeat.i(205418);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.ITc.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(205418);
      return bool;
    }
    
    public final boolean bLA()
    {
      AppMethodBeat.i(205428);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.ITc.bLA();
      AppMethodBeat.o(205428);
      return bool;
    }
    
    public final boolean c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      AppMethodBeat.i(205413);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.ITc.c(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
      AppMethodBeat.o(205413);
      return bool;
    }
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(205425);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.ITc.d(paramWebView, paramString);
      AppMethodBeat.o(205425);
    }
    
    public final View getVideoLoadingProgressView()
    {
      AppMethodBeat.i(205420);
      Object localObject = this.QEc.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
      localObject = this.ITc.getVideoLoadingProgressView();
      AppMethodBeat.o(205420);
      return localObject;
    }
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(205411);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      boolean bool = this.ITc.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(205411);
      return bool;
    }
    
    public final void onExitFullscreenVideo(Bitmap paramBitmap)
    {
      AppMethodBeat.i(205429);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.ITc.onExitFullscreenVideo(paramBitmap);
      AppMethodBeat.o(205429);
    }
    
    public final void onGeolocationPermissionsHidePrompt()
    {
      AppMethodBeat.i(205415);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.ITc.onGeolocationPermissionsHidePrompt();
      AppMethodBeat.o(205415);
    }
    
    public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(205414);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.ITc.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
      AppMethodBeat.o(205414);
    }
    
    public final void onHideCustomView()
    {
      AppMethodBeat.i(205416);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.ITc.onHideCustomView();
      AppMethodBeat.o(205416);
    }
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(205426);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.ITc.onShowCustomView(paramView, paramCustomViewCallback);
      AppMethodBeat.o(205426);
    }
    
    public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      AppMethodBeat.i(205421);
      Iterator localIterator = this.QEc.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.ITc.openFileChooser(paramValueCallback, paramString1, paramString2);
      AppMethodBeat.o(205421);
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