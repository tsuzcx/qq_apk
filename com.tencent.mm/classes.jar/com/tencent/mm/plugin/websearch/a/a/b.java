package com.tencent.mm.plugin.websearch.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.ui.a.d;
import com.tencent.mm.plugin.websearch.ui.a.g;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.i;
import com.tencent.mm.plugin.websearch.webview.j;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.xweb.ag;
import com.tencent.xweb.z;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/emojisearch/ui/EmojiSearchMainTab;", "Lcom/tencent/mm/plugin/websearch/emojisearch/ui/IEmojiSearchUIComponent;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "dialog", "Lcom/tencent/mm/plugin/websearch/emojisearch/ui/EmojiSearchDialog;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/EmojiSearchHomeContext;", "listener", "Lcom/tencent/mm/emojisearch/ui/IEmojiSearchDialogListener;", "dialogView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/websearch/emojisearch/ui/EmojiSearchDialog;Lcom/tencent/mm/protocal/protobuf/EmojiSearchHomeContext;Lcom/tencent/mm/emojisearch/ui/IEmojiSearchDialogListener;Landroid/view/View;)V", "TAG", "", "getDialog", "()Lcom/tencent/mm/plugin/websearch/emojisearch/ui/EmojiSearchDialog;", "emojiSearchWebData", "Lcom/tencent/mm/plugin/websearch/emojisearch/EmojiSearchWebData;", "emojiSearchWebView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "emojiSearchWebViewJSApi", "Lcom/tencent/mm/plugin/websearch/emojisearch/EmojiSearchJSApi;", "ftsEditTextView", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "getHomeContext", "()Lcom/tencent/mm/protocal/protobuf/EmojiSearchHomeContext;", "setHomeContext", "(Lcom/tencent/mm/protocal/protobuf/EmojiSearchHomeContext;)V", "getListener", "()Lcom/tencent/mm/emojisearch/ui/IEmojiSearchDialogListener;", "webviewContainer", "Landroid/widget/FrameLayout;", "getActivityContext", "Landroid/content/Context;", "getDataContext", "getWebSearchData", "getWebSearchJSApi", "getWebView", "hideVKB", "", "onClickClearTextBtn", "view", "onDismiss", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "query", "onSearchInputChange", "isInputChange", "onSearchKeyDown", "onStartSearchShareCgi", "id", "onTagClick", "index", "", "tag", "showVKB", "startMoreTab", "moreContext", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements d, FTSEditTextView.c
{
  FTSEditTextView FWg;
  final String TAG;
  amr WqC;
  final com.tencent.mm.emojisearch.ui.b WqD;
  private final a WqK;
  private com.tencent.mm.plugin.websearch.a.a WqL;
  com.tencent.mm.plugin.websearch.a.d WqM;
  WebSearchWebView WqN;
  private FrameLayout vAf;
  
  public b(a parama, amr paramamr, com.tencent.mm.emojisearch.ui.b paramb, View paramView)
  {
    AppMethodBeat.i(315078);
    this.WqK = parama;
    this.WqC = paramamr;
    this.WqD = paramb;
    this.TAG = "MicroMsg.WebSearch.EmojiSearchMainTab";
    parama = paramView.findViewById(a.d.main_webview_container);
    s.s(parama, "dialogView.findViewById(…d.main_webview_container)");
    this.vAf = ((FrameLayout)parama);
    parama = paramView.findViewById(a.d.fts_edittext);
    s.s(parama, "dialogView.findViewById(R.id.fts_edittext)");
    this.FWg = ((FTSEditTextView)parama);
    this.WqL = new com.tencent.mm.plugin.websearch.a.a((d)this);
    this.WqM = new com.tencent.mm.plugin.websearch.a.d((d)this);
    this.WqN = new WebSearchWebView(getActivityContext());
    this.FWg.jBL();
    this.FWg.setFtsEditTextListener((FTSEditTextView.c)this);
    if (Util.isNullOrNil(this.WqC.mps))
    {
      this.FWg.aWT();
      this.FWg.aWS();
    }
    this.FWg.setHint(this.FWg.getContext().getResources().getString(a.g.app_search));
    parama = new i();
    paramamr = new j(6);
    this.WqN.a((z)parama, (ag)paramamr);
    this.WqN.addJavascriptInterface(this.WqL, "emojiWebSearchJSApi");
    this.vAf.addView((View)this.WqN);
    Log.i(this.TAG, "start to load url %s", new Object[] { this.WqC.url });
    this.WqN.loadUrl(this.WqC.url);
    AppMethodBeat.o(315078);
  }
  
  public final void a(amr paramamr)
  {
    AppMethodBeat.i(315099);
    s.u(paramamr, "moreContext");
    a locala = this.WqK;
    s.u(paramamr, "moreContext");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a.b(locala, paramamr));
    AppMethodBeat.o(315099);
  }
  
  public final void a(cry paramcry, String paramString)
  {
    AppMethodBeat.i(315129);
    s.u(paramcry, "shareContent");
    this.WqK.a(paramcry, paramString);
    AppMethodBeat.o(315129);
  }
  
  public final boolean aWU()
  {
    AppMethodBeat.i(315118);
    FTSEditTextView localFTSEditTextView = this.FWg;
    String str1 = localFTSEditTextView.getTotalQuery();
    Object localObject;
    int i;
    if (str1 != null)
    {
      localObject = (CharSequence)n.bq((CharSequence)str1).toString();
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label106;
      }
      i = 1;
      if (i != 0) {
        break label111;
      }
      i = 1;
      label58:
      if (i == 0) {
        break label116;
      }
    }
    for (;;)
    {
      if (str1 != null)
      {
        localObject = this.WqL;
        String str2 = localFTSEditTextView.getInEditTextQuery();
        s.s(str2, "view.inEditTextQuery");
        ((com.tencent.mm.plugin.websearch.a.a)localObject).nW(str1, str2);
        localFTSEditTextView.hideVKB();
      }
      AppMethodBeat.o(315118);
      return false;
      label106:
      i = 0;
      break;
      label111:
      i = 0;
      break label58;
      label116:
      str1 = null;
    }
  }
  
  public final void biF(String paramString)
  {
    AppMethodBeat.i(315128);
    s.u(paramString, "id");
    this.WqK.biF(paramString);
    AppMethodBeat.o(315128);
  }
  
  public final void cd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(315091);
    s.u(paramString, "query");
    this.FWg.V(paramString, null);
    if (paramBoolean)
    {
      this.FWg.aWT();
      this.FWg.showVKB();
      Object localObject = this.FWg;
      paramString = this.WqL;
      if (paramString != null)
      {
        String str = ((FTSEditTextView)localObject).getTotalQuery();
        s.s(str, "it.totalQuery");
        localObject = ((FTSEditTextView)localObject).getInEditTextQuery();
        s.s(localObject, "it.inEditTextQuery");
        paramString.nX(str, (String)localObject);
      }
      AppMethodBeat.o(315091);
      return;
    }
    this.FWg.dzv.clearFocus();
    this.FWg.hideVKB();
    AppMethodBeat.o(315091);
  }
  
  public final void eeU() {}
  
  public final void fq(boolean paramBoolean)
  {
    AppMethodBeat.i(315122);
    if (paramBoolean)
    {
      Object localObject = this.FWg;
      com.tencent.mm.plugin.websearch.a.a locala = this.WqL;
      String str = ((FTSEditTextView)localObject).getTotalQuery();
      s.s(str, "it.totalQuery");
      localObject = ((FTSEditTextView)localObject).getInEditTextQuery();
      s.s(localObject, "it.inEditTextQuery");
      locala.nX(str, (String)localObject);
    }
    AppMethodBeat.o(315122);
  }
  
  public final Context getActivityContext()
  {
    AppMethodBeat.i(315107);
    Context localContext = this.WqK.getContext();
    s.s(localContext, "dialog.context");
    AppMethodBeat.o(315107);
    return localContext;
  }
  
  public final WebSearchWebView getWebView()
  {
    return this.WqN;
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(315111);
    this.FWg.hideVKB();
    AppMethodBeat.o(315111);
  }
  
  public final com.tencent.mm.plugin.websearch.a.d iqB()
  {
    return this.WqM;
  }
  
  public final com.tencent.mm.plugin.websearch.a.a iqC()
  {
    return this.WqL;
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(315125);
    this.FWg.aWT();
    this.FWg.showVKB();
    AppMethodBeat.o(315125);
  }
  
  public final void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(315120);
    if ((paramd == FTSEditTextView.d.afCj) || (paramd == FTSEditTextView.d.afCk))
    {
      paramList = this.FWg;
      paramString1 = this.WqL;
      paramString2 = paramList.getTotalQuery();
      s.s(paramString2, "it.totalQuery");
      paramList = paramList.getInEditTextQuery();
      s.s(paramList, "it.inEditTextQuery");
      paramString1.nX(paramString2, paramList);
    }
    AppMethodBeat.o(315120);
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(315114);
    this.FWg.aWT();
    this.FWg.showVKB();
    AppMethodBeat.o(315114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.b
 * JD-Core Version:    0.7.0.1
 */