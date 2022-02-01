package com.tencent.mm.plugin.websearch.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.rw;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.ui.a.d;
import com.tencent.mm.plugin.websearch.ui.a.g;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.i;
import com.tencent.mm.plugin.websearch.webview.j;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.flp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchMainTab;", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "dialog", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "listener", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "dialogView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;Landroid/view/View;)V", "TAG", "", "getDialog", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "ftsEditTextView", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "getHomeContext", "()Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "setHomeContext", "(Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;)V", "getListener", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "tagSearchWebData", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchWebData;", "tagSearchWebView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "tagSearchWebViewJSApi", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi;", "webviewContainer", "Landroid/widget/FrameLayout;", "appendSearchTag", "", "tag", "sessionId", "searchId", "requestId", "getActivityContext", "Landroid/content/Context;", "getDataContext", "getWebSearchData", "getWebSearchJSApi", "getWebView", "hideVKB", "onClickClearTextBtn", "view", "onDismiss", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "cropBitmap", "Landroid/graphics/Bitmap;", "query", "onSearchInputChange", "isInputChange", "onSearchKeyDown", "onStartSearchShareCgi", "id", "onTagClick", "index", "", "showVKB", "startMoreTab", "moreContext", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements b, FTSEditTextView.c
{
  FTSEditTextView FWg;
  final String TAG;
  flp WqT;
  final a WqU;
  final c WqZ;
  private com.tencent.mm.plugin.websearch.b.a Wra;
  com.tencent.mm.plugin.websearch.b.d Wrb;
  WebSearchWebView Wrc;
  private FrameLayout vAf;
  
  public d(c paramc, flp paramflp, a parama, View paramView)
  {
    AppMethodBeat.i(315414);
    this.WqZ = paramc;
    this.WqT = paramflp;
    this.WqU = parama;
    this.TAG = "MicroMsg.WebSearch.TagSearchMainTab";
    paramc = paramView.findViewById(a.d.main_webview_container);
    s.s(paramc, "dialogView.findViewById(…d.main_webview_container)");
    this.vAf = ((FrameLayout)paramc);
    paramc = paramView.findViewById(a.d.fts_edittext);
    s.s(paramc, "dialogView.findViewById(R.id.fts_edittext)");
    this.FWg = ((FTSEditTextView)paramc);
    this.Wra = new com.tencent.mm.plugin.websearch.b.a((b)this);
    this.Wrb = new com.tencent.mm.plugin.websearch.b.d((b)this);
    this.Wrc = new WebSearchWebView(getActivityContext());
    this.FWg.jBL();
    this.FWg.setFtsEditTextListener((FTSEditTextView.c)this);
    this.FWg.aWT();
    this.FWg.aWS();
    this.FWg.setHint(this.FWg.getContext().getResources().getString(a.g.app_search));
    paramc = new i();
    paramflp = new j(6);
    this.Wrc.a((z)paramc, (ag)paramflp);
    this.Wrc.addJavascriptInterface(this.Wra, "tagWebSearchJSApi");
    this.vAf.addView((View)this.Wrc);
    Log.i(this.TAG, "start to load url %s", new Object[] { this.WqT.url });
    this.Wrc.loadUrl(this.WqT.url);
    AppMethodBeat.o(315414);
  }
  
  public final void N(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(315426);
    s.u(paramString1, "tag");
    s.u(paramString2, "sessionId");
    s.u(paramString3, "searchId");
    s.u(paramString4, "requestId");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d.a(this, paramString1));
    rw localrw = new rw();
    localrw.ioV = 4L;
    localrw.izR = cn.getSyncServerTimeSecond();
    localrw.aIX();
    localrw.yD(paramString1);
    if (au.bwE(this.WqT.talker)) {}
    for (long l = 2L;; l = 1L)
    {
      localrw.jwH = l;
      localrw.yE(this.WqT.talker);
      localrw.yF(paramString2);
      localrw.yG(paramString3);
      localrw.yH(paramString4);
      localrw.yI("");
      localrw.bMH();
      as.a((com.tencent.mm.plugin.report.a)localrw);
      AppMethodBeat.o(315426);
      return;
    }
  }
  
  public final void a(cry paramcry, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(315453);
    s.u(paramcry, "shareContent");
    this.WqZ.a(paramcry, paramBitmap, paramString);
    AppMethodBeat.o(315453);
  }
  
  public final void a(flp paramflp)
  {
    AppMethodBeat.i(315429);
    s.u(paramflp, "moreContext");
    c localc = this.WqZ;
    s.u(paramflp, "moreContext");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c.b(localc, paramflp));
    AppMethodBeat.o(315429);
  }
  
  public final boolean aWU()
  {
    AppMethodBeat.i(315436);
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
        localObject = this.Wra;
        String str2 = localFTSEditTextView.getInEditTextQuery();
        s.s(str2, "view.inEditTextQuery");
        ((com.tencent.mm.plugin.websearch.b.a)localObject).nW(str1, str2);
        localFTSEditTextView.hideVKB();
      }
      AppMethodBeat.o(315436);
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
    AppMethodBeat.i(315452);
    s.u(paramString, "id");
    this.WqZ.biF(paramString);
    AppMethodBeat.o(315452);
  }
  
  public final void cd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(315423);
    s.u(paramString, "query");
    this.FWg.V(paramString, null);
    if (paramBoolean)
    {
      this.FWg.aWT();
      this.FWg.showVKB();
      Object localObject = this.FWg;
      paramString = this.Wra;
      String str = ((FTSEditTextView)localObject).getTotalQuery();
      s.s(str, "it.totalQuery");
      localObject = ((FTSEditTextView)localObject).getInEditTextQuery();
      s.s(localObject, "it.inEditTextQuery");
      paramString.nX(str, (String)localObject);
      AppMethodBeat.o(315423);
      return;
    }
    this.FWg.dzv.clearFocus();
    this.FWg.hideVKB();
    AppMethodBeat.o(315423);
  }
  
  public final void eeU() {}
  
  public final void fq(boolean paramBoolean)
  {
    AppMethodBeat.i(315440);
    if (paramBoolean)
    {
      Object localObject = this.FWg;
      com.tencent.mm.plugin.websearch.b.a locala = this.Wra;
      String str = ((FTSEditTextView)localObject).getTotalQuery();
      s.s(str, "it.totalQuery");
      localObject = ((FTSEditTextView)localObject).getInEditTextQuery();
      s.s(localObject, "it.inEditTextQuery");
      locala.nX(str, (String)localObject);
    }
    AppMethodBeat.o(315440);
  }
  
  public final Context getActivityContext()
  {
    AppMethodBeat.i(315434);
    Context localContext = this.WqZ.getContext();
    s.s(localContext, "dialog.context");
    AppMethodBeat.o(315434);
    return localContext;
  }
  
  public final WebSearchWebView getWebView()
  {
    return this.Wrc;
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(315447);
    this.FWg.aWT();
    this.FWg.hideVKB();
    AppMethodBeat.o(315447);
  }
  
  public final com.tencent.mm.plugin.websearch.b.d iqF()
  {
    return this.Wrb;
  }
  
  public final com.tencent.mm.plugin.websearch.b.a iqG()
  {
    return this.Wra;
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(315442);
    this.FWg.aWT();
    this.FWg.showVKB();
    AppMethodBeat.o(315442);
  }
  
  public final void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(315438);
    if ((paramd == FTSEditTextView.d.afCj) || (paramd == FTSEditTextView.d.afCk))
    {
      paramList = this.FWg;
      paramString1 = this.Wra;
      paramString2 = paramList.getTotalQuery();
      s.s(paramString2, "it.totalQuery");
      paramList = paramList.getInEditTextQuery();
      s.s(paramList, "it.inEditTextQuery");
      paramString1.nX(paramString2, paramList);
    }
    AppMethodBeat.o(315438);
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(315444);
    this.FWg.showVKB();
    AppMethodBeat.o(315444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.a.d
 * JD-Core Version:    0.7.0.1
 */