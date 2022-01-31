package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Dialog;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.modelcache.p;
import com.tencent.mm.plugin.webview.modeltools.d;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.xweb.WebView;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.j;
import com.tencent.xweb.j.a;
import java.util.LinkedList;
import java.util.List;

public class WebViewUI$h
  extends j
{
  public volatile boolean dCs = false;
  private Dialog kXe = null;
  private final List<String> rqG = new LinkedList();
  
  public WebViewUI$h(WebViewUI paramWebViewUI) {}
  
  public final void a(WebView paramWebView, int paramInt)
  {
    if (paramInt < 100) {
      WebViewUI.d(this.rpH, false);
    }
    while (paramInt < 100) {
      return;
    }
    WebViewUI.d(this.rpH, true);
  }
  
  public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, j.a parama)
  {
    boolean bool = false;
    if ((parama.getMode() == 0) || (parama.getMode() == 1))
    {
      if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
      {
        y.i("MicroMsg.WebViewUI", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
        bool = true;
      }
    }
    else {
      return bool;
    }
    String str2 = parama.getAcceptTypes()[0];
    String str1 = "*";
    paramWebView = str1;
    if (parama.isCaptureEnabled())
    {
      if (!"image/*".equalsIgnoreCase(str2)) {
        break label109;
      }
      paramWebView = "camera";
    }
    for (;;)
    {
      WebViewUI.ax(this.rpH).a(this.rpH, this.rpH.gGo, null, paramValueCallback, str2, paramWebView);
      return true;
      label109:
      paramWebView = str1;
      if ("video/*".equalsIgnoreCase(str2)) {
        paramWebView = "camcorder";
      }
    }
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, f paramf)
  {
    y.d("MicroMsg.WebViewUI", "onJsAlert");
    PBool localPBool = new PBool();
    localPBool.value = false;
    if ((this.rpH.isFinishing()) || (this.rpH.uMr))
    {
      y.d("MicroMsg.WebViewUI", "onJsAlert finish");
      paramf.cancel();
      return true;
    }
    WebViewUI.ay(this.rpH);
    if (WebViewUI.az(this.rpH) > 2) {}
    for (c localc = h.a(this.rpH, paramString2, "", this.rpH.getString(R.l.wv_close_webview), this.rpH.getString(R.l.app_ok), new WebViewUI.h.10(this, paramString1, paramf), new WebViewUI.h.11(this, localPBool, paramf), R.e.link_color); localc != null; localc = h.a(this.rpH, paramString2, "", this.rpH.getString(R.l.app_ok), new WebViewUI.h.2(this, localPBool, paramf)))
    {
      localc.setOnDismissListener(new WebViewUI.h.3(this, localPBool, paramf));
      localc.setCanceledOnTouchOutside(false);
      localc.nT(false);
      return true;
    }
    return super.a(paramWebView, paramString1, paramString2, paramf);
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, e parame)
  {
    return super.a(paramWebView, paramString1, paramString2, paramString3, parame);
  }
  
  public final void ajc()
  {
    super.ajc();
    y.i("MicroMsg.WebViewUI", "WebChromeClient onExitFullscreen");
  }
  
  public final void anw()
  {
    super.anw();
    y.i("MicroMsg.WebViewUI", "WebChromeClient onEnterFullscreen");
  }
  
  public final boolean b(WebView paramWebView, String paramString1, String paramString2, f paramf)
  {
    y.d("MicroMsg.WebViewUI", "onJsConfirm");
    PBool localPBool = new PBool();
    localPBool.value = false;
    if ((this.rpH.isFinishing()) || (this.rpH.uMr))
    {
      y.d("MicroMsg.WebViewUI", "onJsConfirm finish");
      paramf.cancel();
      return true;
    }
    WebViewUI.ay(this.rpH);
    if (WebViewUI.az(this.rpH) > 2) {}
    for (this.kXe = h.a(this.rpH, paramString2, "", this.rpH.getString(R.l.wv_close_webview), this.rpH.getString(R.l.app_ok), new WebViewUI.h.5(this, paramString1, paramf), new WebViewUI.h.6(this, localPBool, paramf), R.e.btn_green_color_normal); this.kXe != null; this.kXe = h.a(this.rpH.mController.uMN, false, paramString2, "", this.rpH.getString(R.l.app_ok), this.rpH.getString(R.l.app_cancel), new WebViewUI.h.7(this, localPBool, paramf), new WebViewUI.h.8(this, paramf)))
    {
      this.kXe.setOnDismissListener(new WebViewUI.h.9(this, localPBool, paramf));
      this.kXe.setCancelable(false);
      this.kXe.setCanceledOnTouchOutside(false);
      return true;
    }
    return super.b(paramWebView, paramString1, paramString2, paramf);
  }
  
  public final void d(WebView paramWebView, String paramString)
  {
    y.i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", new Object[] { paramString, WebViewUI.am(this.rpH) });
    super.d(paramWebView, paramString);
    if (this.rpH.rnr) {
      y.i("MicroMsg.WebViewUI", "fixed title, ignore received title: " + paramString);
    }
    do
    {
      return;
      if (paramString == null)
      {
        y.e("MicroMsg.WebViewUI", "null title");
        return;
      }
    } while ((!WebViewUI.q(this.rpH)) || (bk.pm(WebViewUI.am(this.rpH)).equals(paramString)) || (p.wD(paramString)));
    this.rpH.setMMTitle(paramString);
  }
  
  public final View getVideoLoadingProgressView()
  {
    if (WebViewUI.aw(this.rpH) == null)
    {
      WebViewUI.a(this.rpH, new ProgressBar(this.rpH));
      WebViewUI.aw(this.rpH).setIndeterminate(true);
    }
    return WebViewUI.aw(this.rpH);
  }
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    y.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[] { paramString });
    h.a(this.rpH, false, this.rpH.getString(R.l.wv_get_location_msg, new Object[] { paramString }), this.rpH.getString(R.l.wv_get_location_title), this.rpH.getString(R.l.app_ok), this.rpH.getString(R.l.app_cancel), new WebViewUI.h.1(this, paramCallback, paramString), new WebViewUI.h.4(this, paramCallback, paramString));
  }
  
  public final void onHideCustomView()
  {
    y.i("MicroMsg.WebViewUI", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
    if (WebViewUI.at(this.rpH) == null) {
      return;
    }
    for (;;)
    {
      try
      {
        WebViewUI.a(this.rpH, false);
        if (!this.rpH.niQ.isXWalkKernel())
        {
          this.rpH.niQ.setVisibility(0);
          this.rpH.setTitleVisibility(0);
          if (this.rpH.rny != null) {
            this.rpH.rny.removeView(WebViewUI.at(this.rpH));
          }
          WebViewUI.a(this.rpH, null);
          if (WebViewUI.av(this.rpH) == null) {
            break;
          }
          WebViewUI.av(this.rpH).onCustomViewHidden();
          return;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.WebViewUI", "onHideCustomView error " + localException.getMessage());
        return;
      }
      this.rpH.fullScreenNoTitleBar(false);
      this.rpH.setStatusBarColor(this.rpH.getResources().getColor(R.e.status_bar_color));
      if (this.rpH.kXV != null)
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.rpH.kXV.getLayoutParams();
        int i = WebViewUI.au(this.rpH);
        if (i != localMarginLayoutParams.topMargin)
        {
          localMarginLayoutParams.topMargin = i;
          this.rpH.kXV.setLayoutParams(localMarginLayoutParams);
        }
      }
    }
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    y.i("MicroMsg.WebViewUI", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
    try
    {
      if (WebViewUI.at(this.rpH) != null)
      {
        paramCustomViewCallback.onCustomViewHidden();
        return;
      }
      WebViewUI.a(this.rpH, false);
      WebViewUI.a(this.rpH, paramView);
      WebViewUI.a(this.rpH, paramCustomViewCallback);
      if (!this.rpH.niQ.isXWalkKernel())
      {
        this.rpH.niQ.setVisibility(8);
        this.rpH.rny.addView(paramView);
        this.rpH.setTitleVisibility(4);
        return;
      }
    }
    catch (Exception paramView)
    {
      y.e("MicroMsg.WebViewUI", "onShowCustomView error " + paramView.getMessage());
      return;
    }
    this.rpH.rny.addView(paramView, 0);
    this.rpH.fullScreenNoTitleBar(true);
    this.rpH.setStatusBarColor(0);
    if (this.rpH.kXV != null)
    {
      paramView = (ViewGroup.MarginLayoutParams)this.rpH.kXV.getLayoutParams();
      paramView.topMargin = 0;
      this.rpH.kXV.setLayoutParams(paramView);
    }
  }
  
  public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    WebViewUI.ax(this.rpH).a(this.rpH, this.rpH.gGo, paramValueCallback, null, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h
 * JD-Core Version:    0.7.0.1
 */