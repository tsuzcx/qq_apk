package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.plugin.appbrand.i.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import java.lang.reflect.Method;
import java.net.URL;

public class MMWebView
  extends WebView
  implements f
{
  public static final WebView.d wkp = WebView.d.xhp;
  public static final String wkq = null;
  public boolean dyX = false;
  private View.OnTouchListener pXl;
  private String rxJ;
  private boolean wko;
  protected boolean wkr = false;
  private boolean wks = false;
  private ViewGroup wkt;
  public MMWebView.d wku = null;
  
  public MMWebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, WebView.d.xhn);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, WebView.d.xhn);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, WebView.d paramd)
  {
    super(paramContext, paramAttributeSet, paramInt, paramd);
    setBackgroundColor(-1);
    cJR();
  }
  
  private static boolean b(MMWebView paramMMWebView, String paramString)
  {
    try
    {
      paramMMWebView = new c(new c(new c(paramMMWebView, "mSysWebView", null).get(), "mProvider", null).get(), "mWebViewCore", null).get();
      Method localMethod = paramMMWebView.getClass().getDeclaredMethod("sendMessage", new Class[] { Message.class });
      localMethod.setAccessible(true);
      localMethod.invoke(paramMMWebView, new Object[] { Message.obtain(null, 194, paramString) });
      return true;
    }
    catch (Exception paramMMWebView)
    {
      y.e("MicroMsg.MMWebView", "reflectJSExec, e = %s", new Object[] { paramMMWebView });
    }
    return false;
  }
  
  public static void hi(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    String str1 = paramContext.getString("tbs_webview_disable", "0");
    String str2 = paramContext.getString("tbs_webview_min_sdk_version", null);
    String str3 = paramContext.getString("tbs_webview_max_sdk_version", null);
    y.i("MicroMsg.MMWebView", "initTbsSettings, tbsDisable = %s, minSdkVersion = %s, maxSdkVersion = %s", new Object[] { str1, str2, str3 });
    if ("1".equals(str1))
    {
      int i = bk.getInt(str2, 0);
      int j = bk.getInt(str3, 0);
      int k = Build.VERSION.SDK_INT;
      if ((k >= i) && ((k <= j) || (j == 0))) {
        y.i("MicroMsg.MMWebView", "in selection, disable x5");
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      y.i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", new Object[] { Boolean.valueOf(bool1) });
      if (!bool1) {
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
      }
      bool1 = paramContext.getBoolean("tbs_download_oversea", false);
      boolean bool2 = com.tencent.mm.sdk.platformtools.e.cqq();
      y.i("MicroMsg.MMWebView", "initTbsSettings, tbs_download_oversea = %b, isGPVersion = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (bool2)) {
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
      }
      return;
    }
  }
  
  public final void F(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public <T extends g> T I(Class<T> paramClass)
  {
    return null;
  }
  
  public final boolean L(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool = super.super_onTouchEvent(paramMotionEvent);
    switch (i & 0xFF)
    {
    }
    while (bool) {
      if (!this.wks)
      {
        return true;
        this.wks = false;
        continue;
        if (this.wkt != null) {
          if (this.wks) {
            this.wkt.requestDisallowInterceptTouchEvent(false);
          } else {
            this.wkt.requestDisallowInterceptTouchEvent(true);
          }
        }
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  public final boolean M(MotionEvent paramMotionEvent)
  {
    return super.super_dispatchTouchEvent(paramMotionEvent);
  }
  
  public final boolean N(MotionEvent paramMotionEvent)
  {
    return super.super_onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    super.evaluateJavascript(paramString, paramValueCallback);
  }
  
  public void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback)
  {
    super.evaluateJavascript(paramString3, paramValueCallback);
  }
  
  @TargetApi(9)
  public final boolean c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    paramBoolean = super.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    if ((paramInt4 < 0) || ((paramInt4 == 0) && (paramInt2 < 0))) {
      this.wks = true;
    }
    return paramBoolean;
  }
  
  @TargetApi(11)
  public final void cJR()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        super.removeJavascriptInterface("searchBoxJavaBridge_");
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMWebView", "removeConfigJsInterface, ex = %s", new Object[] { localException.getMessage() });
    }
  }
  
  public final void cJS()
  {
    if (Build.VERSION.SDK_INT >= 5)
    {
      new c((byte)0);
      setScrollbarFadingEnabled(true);
      setScrollBarStyle(0);
      return;
    }
    new MMWebView.b(this, (byte)0);
    setScrollBarStyle(0);
  }
  
  public final void cJT()
  {
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (MMWebView.this.getIsX5Kernel())
        {
          int i = paramAnonymousMotionEvent.getAction();
          if (MMWebView.c(MMWebView.this) != null) {
            switch (i & 0xFF)
            {
            default: 
              MMWebView.c(MMWebView.this).requestDisallowInterceptTouchEvent(true);
            }
          }
        }
        for (;;)
        {
          bool1 = bool2;
          if (MMWebView.d(MMWebView.this) != null) {
            bool1 = MMWebView.d(MMWebView.this).onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          }
          return bool1;
          MMWebView.c(MMWebView.this).requestDisallowInterceptTouchEvent(true);
          continue;
          MMWebView.c(MMWebView.this).requestDisallowInterceptTouchEvent(false);
        }
      }
    });
  }
  
  @TargetApi(9)
  public final void cJU()
  {
    super.super_computeScroll();
  }
  
  @TargetApi(9)
  public final void e(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return;
      if ((com.tencent.mm.compatible.util.d.gF(19)) || (this.isX5Kernel)) {}
      for (int i = 1; i != 0; i = 0)
      {
        super.evaluateJavascript(paramString, paramValueCallback);
        return;
      }
    } while ((this.wkr) && (b(this, paramString)));
    paramValueCallback = paramString;
    try
    {
      if (!paramString.startsWith("javascript:")) {
        paramValueCallback = "javascript:" + paramString;
      }
      super.loadUrl(paramValueCallback);
      return;
    }
    catch (Exception paramString)
    {
      y.i("MicroMsg.MMWebView", "evaluateJavascript failed : %s", new Object[] { paramString.getMessage() });
    }
  }
  
  public boolean getIsX5Kernel()
  {
    return this.isX5Kernel;
  }
  
  public String getRandomStr()
  {
    return this.rxJ;
  }
  
  public void loadUrl(String paramString)
  {
    super.loadUrl(paramString);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.wku != null) {
      this.wku.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setCompetitorView(ViewGroup paramViewGroup)
  {
    this.wkt = paramViewGroup;
  }
  
  public void setJsExceptionHandler(com.tencent.mm.plugin.appbrand.i.e parame) {}
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.pXl = paramOnTouchListener;
  }
  
  public void setPreload(boolean paramBoolean)
  {
    this.wko = paramBoolean;
  }
  
  public void setRandomStr(String paramString)
  {
    this.rxJ = paramString;
  }
  
  private final class c
  {
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMWebView
 * JD-Core Version:    0.7.0.1
 */