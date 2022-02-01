package com.tencent.mm.plugin.websearch.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emojisearch.ui.b;
import com.tencent.mm.plugin.websearch.ui.a.d;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.e;
import com.tencent.mm.plugin.websearch.webview.e.a;
import com.tencent.mm.plugin.websearch.webview.i;
import com.tencent.mm.plugin.websearch.webview.j;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.ag;
import com.tencent.xweb.z;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/emojisearch/ui/EmojiSearchMoreTab;", "Lcom/tencent/mm/plugin/websearch/emojisearch/ui/IEmojiSearchUIComponent;", "dialog", "Lcom/tencent/mm/plugin/websearch/emojisearch/ui/EmojiSearchDialog;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/EmojiSearchHomeContext;", "listener", "Lcom/tencent/mm/emojisearch/ui/IEmojiSearchDialogListener;", "dialogView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/websearch/emojisearch/ui/EmojiSearchDialog;Lcom/tencent/mm/protocal/protobuf/EmojiSearchHomeContext;Lcom/tencent/mm/emojisearch/ui/IEmojiSearchDialogListener;Landroid/view/View;)V", "TAG", "", "getDialog", "()Lcom/tencent/mm/plugin/websearch/emojisearch/ui/EmojiSearchDialog;", "emojiSearchWebData", "Lcom/tencent/mm/plugin/websearch/emojisearch/EmojiSearchWebData;", "emojiSearchWebView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "emojiSearchWebViewJSApi", "Lcom/tencent/mm/plugin/websearch/emojisearch/EmojiSearchJSApi;", "getHomeContext", "()Lcom/tencent/mm/protocal/protobuf/EmojiSearchHomeContext;", "setHomeContext", "(Lcom/tencent/mm/protocal/protobuf/EmojiSearchHomeContext;)V", "getListener", "()Lcom/tencent/mm/emojisearch/ui/IEmojiSearchDialogListener;", "moreTabView", "kotlin.jvm.PlatformType", "webviewContainer", "Landroid/widget/FrameLayout;", "exitMoreTab", "", "getActivityContext", "Landroid/content/Context;", "getDataContext", "getWebSearchData", "getWebSearchJSApi", "getWebView", "hideVKB", "onDismiss", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "query", "onSearchInputChange", "isInputChange", "", "onStartSearchShareCgi", "id", "showVKB", "startMoreTab", "moreContext", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements d
{
  private final String TAG;
  amr WqC;
  private final b WqD;
  private final a WqK;
  private com.tencent.mm.plugin.websearch.a.a WqL;
  com.tencent.mm.plugin.websearch.a.d WqM;
  WebSearchWebView WqN;
  View WqO;
  private FrameLayout vAf;
  
  public c(a parama, amr paramamr, b paramb, View paramView)
  {
    AppMethodBeat.i(315057);
    this.WqK = parama;
    this.WqC = paramamr;
    this.WqD = paramb;
    this.TAG = "MicroMsg.WebSearch.EmojiSearchMoreTab";
    this.WqO = paramView.findViewById(a.d.more_tab_view);
    parama = paramView.findViewById(a.d.more_webview_container);
    s.s(parama, "dialogView.findViewById(…d.more_webview_container)");
    this.vAf = ((FrameLayout)parama);
    this.WqL = new com.tencent.mm.plugin.websearch.a.a((d)this);
    this.WqM = new com.tencent.mm.plugin.websearch.a.d((d)this);
    this.WqN = new WebSearchWebView(getActivityContext());
    parama = new i();
    paramamr = new j(6);
    this.WqN.a((z)parama, (ag)paramamr);
    this.WqN.addJavascriptInterface(this.WqL, "emojiWebSearchJSApi");
    this.vAf.addView((View)this.WqN);
    AppMethodBeat.o(315057);
  }
  
  public final void a(amr paramamr)
  {
    int i = 1;
    AppMethodBeat.i(315081);
    s.u(paramamr, "moreContext");
    Log.i(this.TAG, "start to load url %s", new Object[] { this.WqC.url });
    this.WqN.loadUrl(this.WqC.url);
    if (this.WqO.getX() == 0.0F) {}
    for (;;)
    {
      if (i != 0) {
        this.WqO.setX(com.tencent.mm.cd.a.ms(getActivityContext()));
      }
      this.WqO.animate().translationX(0.0F).setStartDelay(200L).setDuration(300L).start();
      this.WqO.setVisibility(0);
      AppMethodBeat.o(315081);
      return;
      i = 0;
    }
  }
  
  public final void a(cry paramcry, String paramString)
  {
    AppMethodBeat.i(315098);
    s.u(paramcry, "shareContent");
    this.WqK.a(paramcry, paramString);
    AppMethodBeat.o(315098);
  }
  
  public final void biF(String paramString)
  {
    AppMethodBeat.i(315095);
    s.u(paramString, "id");
    this.WqK.biF(paramString);
    AppMethodBeat.o(315095);
  }
  
  public final void cd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(315074);
    s.u(paramString, "query");
    AppMethodBeat.o(315074);
  }
  
  public final Context getActivityContext()
  {
    AppMethodBeat.i(315085);
    Context localContext = this.WqK.getContext();
    s.s(localContext, "dialog.context");
    AppMethodBeat.o(315085);
    return localContext;
  }
  
  public final WebSearchWebView getWebView()
  {
    return this.WqN;
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(315089);
    d locald = (d)this;
    s.u(locald, "this");
    e.a.a((e)locald);
    AppMethodBeat.o(315089);
  }
  
  public final com.tencent.mm.plugin.websearch.a.d iqB()
  {
    return this.WqM;
  }
  
  public final com.tencent.mm.plugin.websearch.a.a iqC()
  {
    return this.WqL;
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(315087);
    d locald = (d)this;
    s.u(locald, "this");
    e.a.b((e)locald);
    AppMethodBeat.o(315087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.c
 * JD-Core Version:    0.7.0.1
 */