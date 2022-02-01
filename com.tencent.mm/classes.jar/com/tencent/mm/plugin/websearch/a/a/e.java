package com.tencent.mm.plugin.websearch.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.a.d;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.f;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.ac;
import com.tencent.xweb.x;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchMoreTab;", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "dialog", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "listener", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "dialogView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;Landroid/view/View;)V", "TAG", "", "getDialog", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "getHomeContext", "()Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "setHomeContext", "(Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;)V", "getListener", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "moreTabView", "kotlin.jvm.PlatformType", "tagSearchWebData", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchWebData;", "tagSearchWebView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "tagSearchWebViewJSApi", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi;", "webviewContainer", "Landroid/widget/FrameLayout;", "appendSearchTag", "", "tag", "sessionId", "searchId", "requestId", "exitMoreTab", "getActivityContext", "Landroid/content/Context;", "getDataContext", "getWebSearchData", "getWebSearchJSApi", "getWebView", "onDismiss", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "cropBitmap", "Landroid/graphics/Bitmap;", "query", "onSearchInputChange", "isInputChange", "", "onStartSearchShareCgi", "id", "startMoreTab", "moreContext", "ui-websearch_release"})
public final class e
  implements b
{
  egj IGg;
  private final a IGh;
  private com.tencent.mm.plugin.websearch.a.a IGq;
  d IGr;
  WebSearchWebView IGs;
  private final c IGt;
  View IGv;
  private final String TAG;
  private FrameLayout plP;
  
  public e(c paramc, egj paramegj, a parama, View paramView)
  {
    AppMethodBeat.i(197987);
    this.IGt = paramc;
    this.IGg = paramegj;
    this.IGh = parama;
    this.TAG = "MicroMsg.WebSearch.TagSearchMoreTab";
    this.IGv = paramView.findViewById(2131304902);
    paramc = paramView.findViewById(2131304914);
    p.g(paramc, "dialogView.findViewById(…d.more_webview_container)");
    this.plP = ((FrameLayout)paramc);
    this.IGq = new com.tencent.mm.plugin.websearch.a.a((b)this);
    this.IGr = new d((b)this);
    this.IGs = new WebSearchWebView(getActivityContext());
    paramc = new com.tencent.mm.plugin.websearch.webview.e();
    paramegj = new f(6);
    this.IGs.a((x)paramc, (ac)paramegj);
    this.IGs.addJavascriptInterface(this.IGq, "tagWebSearchJSApi");
    this.plP.addView((View)this.IGs);
    AppMethodBeat.o(197987);
  }
  
  public final void F(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(197982);
    p.h(paramString1, "tag");
    p.h(paramString2, "sessionId");
    p.h(paramString3, "searchId");
    p.h(paramString4, "requestId");
    AppMethodBeat.o(197982);
  }
  
  public final void a(buv parambuv, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(197986);
    p.h(parambuv, "shareContent");
    this.IGt.a(parambuv, paramBitmap, paramString);
    AppMethodBeat.o(197986);
  }
  
  public final void a(egj paramegj)
  {
    AppMethodBeat.i(197983);
    p.h(paramegj, "moreContext");
    Log.i(this.TAG, "start to load url %s", new Object[] { this.IGg.url });
    this.IGs.loadUrl(this.IGg.url);
    paramegj = this.IGv;
    p.g(paramegj, "moreTabView");
    if (paramegj.getX() == 0.0F)
    {
      paramegj = this.IGv;
      p.g(paramegj, "moreTabView");
      paramegj.setX(com.tencent.mm.cb.a.jn(getActivityContext()));
    }
    this.IGv.animate().translationX(0.0F).setStartDelay(200L).setDuration(300L).start();
    paramegj = this.IGv;
    p.g(paramegj, "moreTabView");
    paramegj.setVisibility(0);
    AppMethodBeat.o(197983);
  }
  
  public final void aXn(String paramString)
  {
    AppMethodBeat.i(197985);
    p.h(paramString, "id");
    this.IGt.aXn(paramString);
    AppMethodBeat.o(197985);
  }
  
  public final void cK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197981);
    p.h(paramString, "query");
    AppMethodBeat.o(197981);
  }
  
  public final WebSearchWebView dQg()
  {
    return this.IGs;
  }
  
  public final d fYG()
  {
    return this.IGr;
  }
  
  public final com.tencent.mm.plugin.websearch.a.a fYH()
  {
    return this.IGq;
  }
  
  public final Context getActivityContext()
  {
    AppMethodBeat.i(197984);
    Context localContext = this.IGt.getContext();
    p.g(localContext, "dialog.context");
    AppMethodBeat.o(197984);
    return localContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.e
 * JD-Core Version:    0.7.0.1
 */