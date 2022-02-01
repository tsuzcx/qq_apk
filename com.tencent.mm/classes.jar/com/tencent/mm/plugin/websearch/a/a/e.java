package com.tencent.mm.plugin.websearch.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.a.d;
import com.tencent.mm.plugin.websearch.ui.a.c;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.f;
import com.tencent.mm.protocal.protobuf.ccn;
import com.tencent.mm.protocal.protobuf.eql;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.ad;
import com.tencent.xweb.x;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchMoreTab;", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "dialog", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "listener", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "dialogView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;Landroid/view/View;)V", "TAG", "", "getDialog", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "getHomeContext", "()Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "setHomeContext", "(Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;)V", "getListener", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "moreTabView", "kotlin.jvm.PlatformType", "tagSearchWebData", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchWebData;", "tagSearchWebView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "tagSearchWebViewJSApi", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi;", "webviewContainer", "Landroid/widget/FrameLayout;", "appendSearchTag", "", "tag", "sessionId", "searchId", "requestId", "exitMoreTab", "getActivityContext", "Landroid/content/Context;", "getDataContext", "getWebSearchData", "getWebSearchJSApi", "getWebView", "onDismiss", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "cropBitmap", "Landroid/graphics/Bitmap;", "query", "onSearchInputChange", "isInputChange", "", "onStartSearchShareCgi", "id", "startMoreTab", "moreContext", "ui-websearch_release"})
public final class e
  implements b
{
  private com.tencent.mm.plugin.websearch.a.a PAH;
  d PAI;
  WebSearchWebView PAJ;
  private final c PAK;
  View PAM;
  eql PAx;
  private final a PAy;
  private final String TAG;
  private FrameLayout soh;
  
  public e(c paramc, eql parameql, a parama, View paramView)
  {
    AppMethodBeat.i(197992);
    this.PAK = paramc;
    this.PAx = parameql;
    this.PAy = parama;
    this.TAG = "MicroMsg.WebSearch.TagSearchMoreTab";
    this.PAM = paramView.findViewById(a.c.more_tab_view);
    paramc = paramView.findViewById(a.c.more_webview_container);
    p.j(paramc, "dialogView.findViewById(…d.more_webview_container)");
    this.soh = ((FrameLayout)paramc);
    this.PAH = new com.tencent.mm.plugin.websearch.a.a((b)this);
    this.PAI = new d((b)this);
    this.PAJ = new WebSearchWebView(getActivityContext());
    paramc = new com.tencent.mm.plugin.websearch.webview.e();
    parameql = new f(6);
    this.PAJ.a((x)paramc, (ad)parameql);
    this.PAJ.addJavascriptInterface(this.PAH, "tagWebSearchJSApi");
    this.soh.addView((View)this.PAJ);
    AppMethodBeat.o(197992);
  }
  
  public final void L(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(197954);
    p.k(paramString1, "tag");
    p.k(paramString2, "sessionId");
    p.k(paramString3, "searchId");
    p.k(paramString4, "requestId");
    AppMethodBeat.o(197954);
  }
  
  public final void a(ccn paramccn, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(197977);
    p.k(paramccn, "shareContent");
    this.PAK.a(paramccn, paramBitmap, paramString);
    AppMethodBeat.o(197977);
  }
  
  public final void a(eql parameql)
  {
    AppMethodBeat.i(197968);
    p.k(parameql, "moreContext");
    Log.i(this.TAG, "start to load url %s", new Object[] { this.PAx.url });
    this.PAJ.loadUrl(this.PAx.url);
    parameql = this.PAM;
    p.j(parameql, "moreTabView");
    if (parameql.getX() == 0.0F)
    {
      parameql = this.PAM;
      p.j(parameql, "moreTabView");
      parameql.setX(com.tencent.mm.ci.a.kr(getActivityContext()));
    }
    this.PAM.animate().translationX(0.0F).setStartDelay(200L).setDuration(300L).start();
    parameql = this.PAM;
    p.j(parameql, "moreTabView");
    parameql.setVisibility(0);
    AppMethodBeat.o(197968);
  }
  
  public final void biY(String paramString)
  {
    AppMethodBeat.i(197975);
    p.k(paramString, "id");
    this.PAK.biY(paramString);
    AppMethodBeat.o(197975);
  }
  
  public final void cY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197951);
    p.k(paramString, "query");
    AppMethodBeat.o(197951);
  }
  
  public final WebSearchWebView esG()
  {
    return this.PAJ;
  }
  
  public final d gRr()
  {
    return this.PAI;
  }
  
  public final com.tencent.mm.plugin.websearch.a.a gRs()
  {
    return this.PAH;
  }
  
  public final Context getActivityContext()
  {
    AppMethodBeat.i(197971);
    Context localContext = this.PAK.getContext();
    p.j(localContext, "dialog.context");
    AppMethodBeat.o(197971);
    return localContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.e
 * JD-Core Version:    0.7.0.1
 */