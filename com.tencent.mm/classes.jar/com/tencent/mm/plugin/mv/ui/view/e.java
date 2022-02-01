package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.f;
import com.tencent.mm.plugin.music.model.l;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.plugin.webview.core.m.a;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebView;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvWebViewController;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;Lcom/tencent/mm/ui/widget/MMWebView;)V", "MV_TAG", "", "getMV_TAG", "()Ljava/lang/String;", "MV_TAG$delegate", "Lkotlin/Lazy;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "initEnviroment", "", "MvWebViewInterceptor", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.plugin.webview.core.k
{
  private final boo LWI;
  private final kotlin.j Mkd;
  
  public e(boo paramboo, MMWebView paramMMWebView)
  {
    super(paramMMWebView);
    AppMethodBeat.i(287209);
    this.LWI = paramboo;
    this.Mkd = kotlin.k.cm((a)new a(this));
    AppMethodBeat.o(287209);
  }
  
  public final void cxS()
  {
    AppMethodBeat.i(287211);
    a((m)new b(this.LWI, this.sMP));
    super.cxS();
    AppMethodBeat.o(287211);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<String>
  {
    a(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvWebViewController$MvWebViewInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;Lcom/tencent/mm/ui/widget/MMWebView;)V", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "doJumpToApp", "", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "url", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    extends m
  {
    private final boo LWI;
    private final MMWebView sMP;
    
    public b(boo paramboo, MMWebView paramMMWebView)
    {
      AppMethodBeat.i(287011);
      this.LWI = paramboo;
      this.sMP = paramMMWebView;
      AppMethodBeat.o(287011);
    }
    
    private final int d(boo paramboo)
    {
      AppMethodBeat.i(287016);
      f localf = com.tencent.mm.plugin.music.logic.j.gnw().gng();
      if (localf != null)
      {
        Object localObject = l.LMH;
        localObject = this.sMP.getContext();
        s.s(localObject, "viewWV.context");
        int i = l.a((Context)localObject, localf, paramboo, null);
        AppMethodBeat.o(287016);
        return i;
      }
      AppMethodBeat.o(287016);
      return -1;
    }
    
    public final m.a c(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(287023);
      s.u(paramWebView, "webView");
      s.u(paramWebResourceRequest, "request");
      d(this.LWI);
      paramWebView = new m.a(true, true);
      AppMethodBeat.o(287023);
      return paramWebView;
    }
    
    public final m.a j(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(287030);
      s.u(paramWebView, "webView");
      s.u(paramString, "url");
      d(this.LWI);
      paramWebView = new m.a(true, true);
      AppMethodBeat.o(287030);
      return paramWebView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.e
 * JD-Core Version:    0.7.0.1
 */