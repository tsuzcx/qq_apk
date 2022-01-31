package com.tencent.mm.plugin.webview.luggage;

import android.os.Build.VERSION;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

final class e$10
  extends p
{
  e$10(e parame) {}
  
  public final void d(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(153093);
    ab.i("MicroMsg.LuggageMMWebPage", "onReceivedTitle, title = %s", new Object[] { paramString });
    if (!b.Fl(paramString)) {
      this.uRQ.cr(paramString, 0);
    }
    AppMethodBeat.o(153093);
  }
  
  public final View getVideoLoadingProgressView()
  {
    AppMethodBeat.i(153096);
    ab.i("MicroMsg.LuggageMMWebPage", "getVideoLoadingProgressView");
    if (e.i(this.uRQ) == null)
    {
      e.a(this.uRQ, new ProgressBar(this.uRQ.mContext));
      e.i(this.uRQ).setIndeterminate(true);
    }
    ProgressBar localProgressBar = e.i(this.uRQ);
    AppMethodBeat.o(153096);
    return localProgressBar;
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return false;
  }
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(153095);
    ab.i("MicroMsg.LuggageMMWebPage", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
    if (e.g(this.uRQ) == null)
    {
      AppMethodBeat.o(153095);
      return;
    }
    try
    {
      this.uRQ.uRl.setVisibility(0);
      if (e.h(this.uRQ) != null) {
        e.h(this.uRQ).onCustomViewHidden();
      }
      this.uRQ.uRn.setVisibility(0);
      if (e.g(this.uRQ) != null) {
        this.uRQ.osU.removeView(e.g(this.uRQ));
      }
      e.g(this.uRQ).removeAllViews();
      e.a(this.uRQ, null);
      AppMethodBeat.o(153095);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.LuggageMMWebPage", "onHideCustomView error " + localException.getMessage());
      AppMethodBeat.o(153095);
    }
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(153094);
    ab.i("MicroMsg.LuggageMMWebPage", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
    try
    {
      if (e.g(this.uRQ) != null)
      {
        paramCustomViewCallback.onCustomViewHidden();
        AppMethodBeat.o(153094);
        return;
      }
      e.a(this.uRQ, new FrameLayout(this.uRQ.mContext));
      e.g(this.uRQ).setBackgroundResource(2131690695);
      e.g(this.uRQ).addView(paramView);
      e.a(this.uRQ, paramCustomViewCallback);
      this.uRQ.uRl.setVisibility(8);
      this.uRQ.uRn.setVisibility(8);
      this.uRQ.osU.addView(e.g(this.uRQ));
      AppMethodBeat.o(153094);
      return;
    }
    catch (Exception paramView)
    {
      ab.e("MicroMsg.LuggageMMWebPage", "onShowCustomView error " + paramView.getMessage());
      AppMethodBeat.o(153094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.10
 * JD-Core Version:    0.7.0.1
 */