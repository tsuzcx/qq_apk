package com.tencent.mm.plugin.mv.ui.view;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$webViewClientListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "forbidAutoPlay", "", "onPageCommitVisible", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "onPageFinished", "onPageStarted", "webViewReady", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$z
  extends h
{
  c$z(c paramc) {}
  
  private static final void n(c paramc)
  {
    AppMethodBeat.i(286971);
    s.u(paramc, "this$0");
    c.k(paramc);
    AppMethodBeat.o(286971);
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(287002);
    super.b(paramWebView, paramString);
    Log.i(c.access$getTAG$cp(), s.X("webViewReady, already:", c.j(this.MjI).getValue()));
    if (!s.p(c.j(this.MjI).getValue(), Boolean.TRUE))
    {
      Log.i(c.access$getTAG$cp(), "forbidAutoPlay");
      paramWebView = c.e(this.MjI);
      if (paramWebView != null)
      {
        paramWebView = paramWebView.getSettings();
        if (paramWebView != null)
        {
          paramWebView.setMediaPlaybackRequiresUserGesture(true);
          paramWebView.setVideoPlaybackRequiresUserGesture(true);
          paramWebView.setAudioPlaybackRequiresUserGesture(true);
        }
      }
      c.j(this.MjI).setValue(Boolean.TRUE);
      paramWebView = c.e(this.MjI);
      if (paramWebView != null) {
        paramWebView.postDelayed(new c.z..ExternalSyntheticLambda0(this.MjI), 300L);
      }
    }
    AppMethodBeat.o(287002);
  }
  
  public final void e(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(286982);
    super.e(paramWebView, paramString);
    AppMethodBeat.o(286982);
  }
  
  public final void h(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(286991);
    super.h(paramWebView, paramString);
    AppMethodBeat.o(286991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.c.z
 * JD-Core Version:    0.7.0.1
 */