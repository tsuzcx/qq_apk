package com.tencent.mm.plugin.webview.luggage;

import android.os.Build.VERSION;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.tencent.mm.R.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;

final class e$14
  extends j
{
  e$14(e parame) {}
  
  public final void d(WebView paramWebView, String paramString)
  {
    int j = 1;
    y.i("MicroMsg.LuggageMMWebPage", "onReceivedTitle, title = %s", new Object[] { paramString });
    if (!bk.bl(paramString))
    {
      i = j;
      if (!URLUtil.isHttpsUrl(paramString)) {
        if (!URLUtil.isHttpUrl(paramString)) {
          break label61;
        }
      }
    }
    label61:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        this.rca.rbE.setTitleText(paramString);
      }
      return;
    }
  }
  
  public final View getVideoLoadingProgressView()
  {
    y.i("MicroMsg.LuggageMMWebPage", "getVideoLoadingProgressView");
    if (e.g(this.rca) == null)
    {
      e.a(this.rca, new ProgressBar(this.rca.mContext));
      e.g(this.rca).setIndeterminate(true);
    }
    return e.g(this.rca);
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return e.caU();
  }
  
  public final void onHideCustomView()
  {
    y.i("MicroMsg.LuggageMMWebPage", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
    if (e.e(this.rca) == null) {
      return;
    }
    try
    {
      this.rca.rbB.setVisibility(0);
      if (e.f(this.rca) != null) {
        e.f(this.rca).onCustomViewHidden();
      }
      this.rca.rbE.setVisibility(0);
      if (e.e(this.rca) != null) {
        this.rca.rbC.removeView(e.e(this.rca));
      }
      e.e(this.rca).removeAllViews();
      e.a(this.rca, null);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.LuggageMMWebPage", "onHideCustomView error " + localException.getMessage());
    }
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    y.i("MicroMsg.LuggageMMWebPage", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
    try
    {
      if (e.e(this.rca) != null)
      {
        paramCustomViewCallback.onCustomViewHidden();
        return;
      }
      e.a(this.rca, new FrameLayout(this.rca.mContext));
      e.e(this.rca).setBackgroundResource(R.e.webview_logo_bg_color);
      e.e(this.rca).addView(paramView);
      e.a(this.rca, paramCustomViewCallback);
      this.rca.rbB.setVisibility(8);
      this.rca.rbE.setVisibility(8);
      this.rca.rbC.addView(e.e(this.rca));
      return;
    }
    catch (Exception paramView)
    {
      y.e("MicroMsg.LuggageMMWebPage", "onShowCustomView error " + paramView.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.14
 * JD-Core Version:    0.7.0.1
 */