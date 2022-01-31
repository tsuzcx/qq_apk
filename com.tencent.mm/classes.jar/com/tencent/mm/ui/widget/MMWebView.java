package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;

public class MMWebView
  extends WebView
{
  public static final WebView.d ADX = WebView.d.BEr;
  public static String ADY = null;
  public static String ADZ = null;
  public static int AEa = -1;
  private s ADW;
  protected boolean AEb;
  private boolean AEc;
  private ViewGroup AEd;
  public MMWebView.d AEe;
  private LinkedList<MMWebView.d> AEf;
  private boolean hud;
  public boolean inited;
  private View.OnTouchListener kjL;
  private String voC;
  
  public MMWebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, WebView.d.BEp);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, WebView.d.BEp);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, WebView.d paramd)
  {
    super(paramContext, paramAttributeSet, paramInt, paramd);
    AppMethodBeat.i(107940);
    this.ADW = new s();
    this.inited = false;
    this.AEb = false;
    this.AEc = false;
    this.AEe = null;
    this.AEf = new LinkedList();
    setBackgroundColor(-1);
    dOK();
    AppMethodBeat.o(107940);
  }
  
  private static boolean a(MMWebView paramMMWebView, String paramString)
  {
    AppMethodBeat.i(107948);
    try
    {
      paramMMWebView = new c(new c(new c(paramMMWebView, "mSysWebView", null).get(), "mProvider", null).get(), "mWebViewCore", null).get();
      Method localMethod = paramMMWebView.getClass().getDeclaredMethod("sendMessage", new Class[] { Message.class });
      localMethod.setAccessible(true);
      localMethod.invoke(paramMMWebView, new Object[] { Message.obtain(null, 194, paramString) });
      AppMethodBeat.o(107948);
      return true;
    }
    catch (Exception paramMMWebView)
    {
      ab.e("MicroMsg.MMWebView", "reflectJSExec, e = %s", new Object[] { paramMMWebView });
      AppMethodBeat.o(107948);
    }
    return false;
  }
  
  public static void iG(Context paramContext)
  {
    AppMethodBeat.i(107957);
    paramContext = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    String str1 = paramContext.getString("tbs_webview_disable", "0");
    String str2 = paramContext.getString("tbs_webview_min_sdk_version", null);
    String str3 = paramContext.getString("tbs_webview_max_sdk_version", null);
    ab.i("MicroMsg.MMWebView", "initTbsSettings, tbsDisable = %s, minSdkVersion = %s, maxSdkVersion = %s", new Object[] { str1, str2, str3 });
    if ("1".equals(str1))
    {
      int i = bo.getInt(str2, 0);
      int j = bo.getInt(str3, 0);
      int k = Build.VERSION.SDK_INT;
      if ((k >= i) && ((k <= j) || (j == 0))) {
        ab.i("MicroMsg.MMWebView", "in selection, disable x5");
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      ab.i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", new Object[] { Boolean.valueOf(bool1) });
      if (!bool1) {
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
      }
      bool1 = paramContext.getBoolean("tbs_download_oversea", false);
      boolean bool2 = g.dsn();
      ab.i("MicroMsg.MMWebView", "initTbsSettings, tbs_download_oversea = %b, isGPVersion = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (bool2)) {
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
      }
      AppMethodBeat.o(107957);
      return;
    }
  }
  
  public final void M(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107956);
    super.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.AEf.iterator();
    while (localIterator.hasNext()) {
      ((MMWebView.d)localIterator.next()).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(107956);
  }
  
  public final boolean V(MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    AppMethodBeat.i(107951);
    int i = paramMotionEvent.getAction();
    boolean bool2 = super.super_onTouchEvent(paramMotionEvent);
    switch (i & 0xFF)
    {
    case 1: 
    default: 
      if (bool2) {
        if (this.AEc) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(107951);
      return bool1;
      this.AEc = false;
      break;
      if (this.AEd == null) {
        break;
      }
      if (this.AEc)
      {
        this.AEd.requestDisallowInterceptTouchEvent(false);
        break;
      }
      this.AEd.requestDisallowInterceptTouchEvent(true);
      break;
      bool1 = false;
      continue;
      bool1 = bool2;
    }
  }
  
  public final boolean W(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107953);
    boolean bool = super.super_dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(107953);
    return bool;
  }
  
  public final boolean X(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107954);
    boolean bool = super.super_onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(107954);
    return bool;
  }
  
  public final void a(MMWebView.d paramd)
  {
    AppMethodBeat.i(142775);
    this.AEf.add(paramd);
    AppMethodBeat.o(142775);
  }
  
  public void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(107946);
    super.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(107946);
  }
  
  public void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(107947);
    super.evaluateJavascript(paramString3, paramValueCallback);
    AppMethodBeat.o(107947);
  }
  
  @TargetApi(9)
  public final boolean c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(107950);
    paramBoolean = super.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    if ((paramInt4 < 0) || ((paramInt4 == 0) && (paramInt2 < 0))) {
      this.AEc = true;
    }
    AppMethodBeat.o(107950);
    return paramBoolean;
  }
  
  @TargetApi(11)
  protected final void dOK()
  {
    AppMethodBeat.i(107942);
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        super.removeJavascriptInterface("searchBoxJavaBridge_");
      }
      AppMethodBeat.o(107942);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMWebView", "removeConfigJsInterface, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(107942);
    }
  }
  
  public final void dOL()
  {
    AppMethodBeat.i(107943);
    if (Build.VERSION.SDK_INT >= 5)
    {
      new MMWebView.c(this, (byte)0);
      MMWebView.c.e(this);
      AppMethodBeat.o(107943);
      return;
    }
    new MMWebView.b(this, (byte)0);
    setScrollBarStyle(0);
    AppMethodBeat.o(107943);
  }
  
  public final void dOM()
  {
    AppMethodBeat.i(107949);
    super.setOnTouchListener(new MMWebView.1(this));
    AppMethodBeat.o(107949);
  }
  
  @TargetApi(9)
  public final void dON()
  {
    AppMethodBeat.i(107955);
    super.super_computeScroll();
    AppMethodBeat.o(107955);
  }
  
  @TargetApi(9)
  public final void e(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(107952);
    super.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(107952);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(107945);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(107945);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.fv(19)) || (this.isX5Kernel)) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(107945);
      return;
    }
    if ((this.AEb) && (a(this, paramString)))
    {
      AppMethodBeat.o(107945);
      return;
    }
    paramValueCallback = paramString;
    try
    {
      if (!paramString.startsWith("javascript:")) {
        paramValueCallback = "javascript:".concat(String.valueOf(paramString));
      }
      super.loadUrl(paramValueCallback);
      AppMethodBeat.o(107945);
      return;
    }
    catch (Exception paramString)
    {
      ab.i("MicroMsg.MMWebView", "evaluateJavascript failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(107945);
    }
  }
  
  public boolean getIsX5Kernel()
  {
    return this.isX5Kernel;
  }
  
  public s getPerformanceHelper()
  {
    return this.ADW;
  }
  
  public String getRandomStr()
  {
    return this.voC;
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(107941);
    super.loadUrl(paramString);
    AppMethodBeat.o(107941);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107958);
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.AEe != null) {
      this.AEe.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    Iterator localIterator = this.AEf.iterator();
    while (localIterator.hasNext()) {
      ((MMWebView.d)localIterator.next()).onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(107958);
  }
  
  public void setCompetitorView(ViewGroup paramViewGroup)
  {
    this.AEd = paramViewGroup;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.kjL = paramOnTouchListener;
  }
  
  public void setPreload(boolean paramBoolean)
  {
    this.hud = paramBoolean;
  }
  
  public void setRandomStr(String paramString)
  {
    this.voC = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMWebView
 * JD-Core Version:    0.7.0.1
 */