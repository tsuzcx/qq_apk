package com.tencent.mm.plugin.websearch.b.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.b.d;
import com.tencent.mm.plugin.websearch.ui.a.d;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.e.a;
import com.tencent.mm.plugin.websearch.webview.i;
import com.tencent.mm.plugin.websearch.webview.j;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.flp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.ag;
import com.tencent.xweb.z;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchMoreTab;", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "dialog", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "listener", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "dialogView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;Landroid/view/View;)V", "TAG", "", "getDialog", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "getHomeContext", "()Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "setHomeContext", "(Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;)V", "getListener", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "moreTabView", "kotlin.jvm.PlatformType", "tagSearchWebData", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchWebData;", "tagSearchWebView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "tagSearchWebViewJSApi", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi;", "webviewContainer", "Landroid/widget/FrameLayout;", "appendSearchTag", "", "tag", "sessionId", "searchId", "requestId", "exitMoreTab", "getActivityContext", "Landroid/content/Context;", "getDataContext", "getWebSearchData", "getWebSearchJSApi", "getWebView", "hideVKB", "onDismiss", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "cropBitmap", "Landroid/graphics/Bitmap;", "query", "onSearchInputChange", "isInputChange", "", "onStartSearchShareCgi", "id", "showVKB", "startMoreTab", "moreContext", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements b
{
  private final String TAG;
  View WqO;
  flp WqT;
  private final a WqU;
  private final c WqZ;
  private com.tencent.mm.plugin.websearch.b.a Wra;
  d Wrb;
  WebSearchWebView Wrc;
  private FrameLayout vAf;
  
  public e(c paramc, flp paramflp, a parama, View paramView)
  {
    AppMethodBeat.i(315402);
    this.WqZ = paramc;
    this.WqT = paramflp;
    this.WqU = parama;
    this.TAG = "MicroMsg.WebSearch.TagSearchMoreTab";
    this.WqO = paramView.findViewById(a.d.more_tab_view);
    paramc = paramView.findViewById(a.d.more_webview_container);
    s.s(paramc, "dialogView.findViewById(…d.more_webview_container)");
    this.vAf = ((FrameLayout)paramc);
    this.Wra = new com.tencent.mm.plugin.websearch.b.a((b)this);
    this.Wrb = new d((b)this);
    this.Wrc = new WebSearchWebView(getActivityContext());
    paramc = new i();
    paramflp = new j(6);
    this.Wrc.a((z)paramc, (ag)paramflp);
    this.Wrc.addJavascriptInterface(this.Wra, "tagWebSearchJSApi");
    this.vAf.addView((View)this.Wrc);
    AppMethodBeat.o(315402);
  }
  
  public final void N(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(315415);
    s.u(paramString1, "tag");
    s.u(paramString2, "sessionId");
    s.u(paramString3, "searchId");
    s.u(paramString4, "requestId");
    AppMethodBeat.o(315415);
  }
  
  public final void a(cry paramcry, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(315430);
    s.u(paramcry, "shareContent");
    this.WqZ.a(paramcry, paramBitmap, paramString);
    AppMethodBeat.o(315430);
  }
  
  public final void a(flp paramflp)
  {
    int i = 1;
    AppMethodBeat.i(315419);
    s.u(paramflp, "moreContext");
    Log.i(this.TAG, "start to load url %s", new Object[] { this.WqT.url });
    this.Wrc.loadUrl(this.WqT.url);
    if (this.WqO.getX() == 0.0F) {}
    for (;;)
    {
      if (i != 0) {
        this.WqO.setX(com.tencent.mm.cd.a.ms(getActivityContext()));
      }
      this.WqO.animate().translationX(0.0F).setStartDelay(200L).setDuration(300L).start();
      this.WqO.setVisibility(0);
      AppMethodBeat.o(315419);
      return;
      i = 0;
    }
  }
  
  public final void biF(String paramString)
  {
    AppMethodBeat.i(315427);
    s.u(paramString, "id");
    this.WqZ.biF(paramString);
    AppMethodBeat.o(315427);
  }
  
  public final void cd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(315408);
    s.u(paramString, "query");
    AppMethodBeat.o(315408);
  }
  
  public final Context getActivityContext()
  {
    AppMethodBeat.i(315425);
    Context localContext = this.WqZ.getContext();
    s.s(localContext, "dialog.context");
    AppMethodBeat.o(315425);
    return localContext;
  }
  
  public final WebSearchWebView getWebView()
  {
    return this.Wrc;
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(315435);
    b localb = (b)this;
    s.u(localb, "this");
    e.a.a((com.tencent.mm.plugin.websearch.webview.e)localb);
    AppMethodBeat.o(315435);
  }
  
  public final d iqF()
  {
    return this.Wrb;
  }
  
  public final com.tencent.mm.plugin.websearch.b.a iqG()
  {
    return this.Wra;
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(315432);
    b localb = (b)this;
    s.u(localb, "this");
    e.a.b((com.tencent.mm.plugin.websearch.webview.e)localb);
    AppMethodBeat.o(315432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.a.e
 * JD-Core Version:    0.7.0.1
 */