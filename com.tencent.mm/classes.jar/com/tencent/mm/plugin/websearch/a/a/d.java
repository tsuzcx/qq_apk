package com.tencent.mm.plugin.websearch.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.oe;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.ui.a.f;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.e;
import com.tencent.mm.plugin.websearch.webview.f;
import com.tencent.mm.plugin.websearch.webview.i;
import com.tencent.mm.protocal.protobuf.ccn;
import com.tencent.mm.protocal.protobuf.eql;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.xweb.ad;
import com.tencent.xweb.x;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchMainTab;", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "dialog", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "listener", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "dialogView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;Landroid/view/View;)V", "TAG", "", "getDialog", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "ftsEditTextView", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "getHomeContext", "()Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "setHomeContext", "(Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;)V", "getListener", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "mainTabView", "kotlin.jvm.PlatformType", "tagSearchWebData", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchWebData;", "tagSearchWebView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "tagSearchWebViewJSApi", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi;", "webviewContainer", "Landroid/widget/FrameLayout;", "appendSearchTag", "", "tag", "sessionId", "searchId", "requestId", "getActivityContext", "Landroid/content/Context;", "getDataContext", "getWebSearchData", "getWebSearchJSApi", "getWebView", "onClickClearTextBtn", "view", "onDismiss", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "cropBitmap", "Landroid/graphics/Bitmap;", "query", "onSearchInputChange", "isInputChange", "onSearchKeyDown", "onStartSearchShareCgi", "id", "onTagClick", "index", "", "startMoreTab", "moreContext", "ui-websearch_release"})
public final class d
  implements b, FTSEditTextView.b
{
  private View PAF;
  FTSEditTextView PAG;
  private com.tencent.mm.plugin.websearch.a.a PAH;
  com.tencent.mm.plugin.websearch.a.d PAI;
  WebSearchWebView PAJ;
  final c PAK;
  eql PAx;
  final a PAy;
  final String TAG;
  private FrameLayout soh;
  
  public d(c paramc, eql parameql, a parama, View paramView)
  {
    AppMethodBeat.i(198501);
    this.PAK = paramc;
    this.PAx = parameql;
    this.PAy = parama;
    this.TAG = "MicroMsg.WebSearch.TagSearchMainTab";
    this.PAF = paramView.findViewById(com.tencent.mm.plugin.websearch.ui.a.c.main_tab_view);
    paramc = paramView.findViewById(com.tencent.mm.plugin.websearch.ui.a.c.main_webview_container);
    p.j(paramc, "dialogView.findViewById(…d.main_webview_container)");
    this.soh = ((FrameLayout)paramc);
    paramc = paramView.findViewById(com.tencent.mm.plugin.websearch.ui.a.c.fts_edittext);
    p.j(paramc, "dialogView.findViewById(R.id.fts_edittext)");
    this.PAG = ((FTSEditTextView)paramc);
    this.PAH = new com.tencent.mm.plugin.websearch.a.a((b)this);
    this.PAI = new com.tencent.mm.plugin.websearch.a.d((b)this);
    this.PAJ = new WebSearchWebView(getActivityContext());
    this.PAG.hXB();
    this.PAG.setFtsEditTextListener((FTSEditTextView.b)this);
    this.PAG.aDU();
    this.PAG.aDT();
    paramc = this.PAG;
    parameql = this.PAG.getContext();
    p.j(parameql, "ftsEditTextView.context");
    paramc.setHint(parameql.getResources().getString(a.f.app_search));
    paramc = new e();
    parameql = new f(6);
    this.PAJ.a((x)paramc, (ad)parameql);
    this.PAJ.addJavascriptInterface(this.PAH, "tagWebSearchJSApi");
    this.soh.addView((View)this.PAJ);
    Log.i(this.TAG, "start to load url %s", new Object[] { this.PAx.url });
    this.PAJ.loadUrl(this.PAx.url);
    AppMethodBeat.o(198501);
  }
  
  public final void L(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(198465);
    p.k(paramString1, "tag");
    p.k(paramString2, "sessionId");
    p.k(paramString3, "searchId");
    p.k(paramString4, "requestId");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d.a(this, paramString1));
    oe localoe = new oe();
    localoe.AB(4L);
    localoe.AC(cm.bfF());
    localoe.aod();
    localoe.EV(paramString1);
    if (ab.Lj(this.PAx.talker)) {}
    for (long l = 2L;; l = 1L)
    {
      localoe.AD(l);
      localoe.EW(this.PAx.talker);
      localoe.EX(paramString2);
      localoe.EY(paramString3);
      localoe.EZ(paramString4);
      localoe.Fa("");
      localoe.bpa();
      ar.a((com.tencent.mm.plugin.report.a)localoe);
      AppMethodBeat.o(198465);
      return;
    }
  }
  
  public final void a(ccn paramccn, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(198492);
    p.k(paramccn, "shareContent");
    this.PAK.a(paramccn, paramBitmap, paramString);
    AppMethodBeat.o(198492);
  }
  
  public final void a(eql parameql)
  {
    AppMethodBeat.i(198468);
    p.k(parameql, "moreContext");
    c localc = this.PAK;
    p.k(parameql, "moreContext");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c.g(localc, parameql));
    AppMethodBeat.o(198468);
  }
  
  public final void a(String paramString1, String paramString2, List<com.tencent.mm.ui.search.a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(198484);
    if ((paramc == FTSEditTextView.c.XLV) || (paramc == FTSEditTextView.c.XLW))
    {
      paramList = this.PAG;
      if (paramList != null)
      {
        paramString1 = this.PAH;
        if (paramString1 != null)
        {
          paramString2 = paramList.getTotalQuery();
          p.j(paramString2, "it.totalQuery");
          paramList = paramList.getInEditTextQuery();
          p.j(paramList, "it.inEditTextQuery");
          paramString1.mk(paramString2, paramList);
          AppMethodBeat.o(198484);
          return;
        }
        AppMethodBeat.o(198484);
        return;
      }
    }
    AppMethodBeat.o(198484);
  }
  
  public final boolean aDV()
  {
    AppMethodBeat.i(198482);
    FTSEditTextView localFTSEditTextView = this.PAG;
    Object localObject1;
    Object localObject2;
    int i;
    if (localFTSEditTextView != null)
    {
      localObject1 = localFTSEditTextView.getTotalQuery();
      if (localObject1 != null)
      {
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(198482);
          throw ((Throwable)localObject1);
        }
        localObject2 = (CharSequence)n.bb((CharSequence)localObject1).toString();
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label225;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label85:
      Object localObject3;
      String str;
      if (i == 0)
      {
        i = 1;
        if (i == 0) {
          break label235;
        }
        if (localObject1 != null)
        {
          localObject3 = this.PAH;
          if (localObject3 != null)
          {
            str = localFTSEditTextView.getInEditTextQuery();
            p.j(str, "view.inEditTextQuery");
            p.k(localObject1, "query");
            p.k(str, "custom");
            localObject2 = new JSONObject();
          }
        }
      }
      try
      {
        ((JSONObject)localObject2).put("query", localObject1);
        ((JSONObject)localObject2).put("custom", str);
        label163:
        localObject1 = ((com.tencent.mm.plugin.websearch.webview.b)localObject3).PBs;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.websearch.webview.d)localObject1).esG();
          if (localObject1 != null)
          {
            localObject3 = i.PBA;
            localObject2 = ((JSONObject)localObject2).toString();
            p.j(localObject2, "requestObj.toString()");
            i.a((WebSearchWebView)localObject1, "onSearchInputConfirm", (String)localObject2);
          }
        }
        localFTSEditTextView.hideVKB();
        AppMethodBeat.o(198482);
        return false;
        label225:
        i = 0;
        continue;
        i = 0;
        break label85;
        label235:
        localObject1 = null;
      }
      catch (Exception localException)
      {
        break label163;
      }
    }
  }
  
  public final void biY(String paramString)
  {
    AppMethodBeat.i(198491);
    p.k(paramString, "id");
    this.PAK.biY(paramString);
    AppMethodBeat.o(198491);
  }
  
  public final void cY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(198461);
    p.k(paramString, "query");
    Object localObject1 = this.PAG;
    if (localObject1 != null) {
      ((FTSEditTextView)localObject1).O(paramString, null);
    }
    if (paramBoolean)
    {
      paramString = this.PAG;
      if (paramString != null) {
        paramString.aDU();
      }
      paramString = this.PAG;
      if (paramString != null) {
        paramString.showVKB();
      }
      Object localObject2 = this.PAG;
      if (localObject2 != null)
      {
        paramString = this.PAH;
        if (paramString != null)
        {
          localObject1 = ((FTSEditTextView)localObject2).getTotalQuery();
          p.j(localObject1, "it.totalQuery");
          localObject2 = ((FTSEditTextView)localObject2).getInEditTextQuery();
          p.j(localObject2, "it.inEditTextQuery");
          paramString.mk((String)localObject1, (String)localObject2);
          AppMethodBeat.o(198461);
          return;
        }
        AppMethodBeat.o(198461);
        return;
      }
      AppMethodBeat.o(198461);
      return;
    }
    paramString = this.PAG;
    if (paramString != null) {
      paramString.hUu();
    }
    paramString = this.PAG;
    if (paramString != null)
    {
      paramString.hideVKB();
      AppMethodBeat.o(198461);
      return;
    }
    AppMethodBeat.o(198461);
  }
  
  public final void dvg() {}
  
  public final void eF(boolean paramBoolean)
  {
    AppMethodBeat.i(198485);
    if (paramBoolean)
    {
      Object localObject = this.PAG;
      if (localObject != null)
      {
        com.tencent.mm.plugin.websearch.a.a locala = this.PAH;
        if (locala != null)
        {
          String str = ((FTSEditTextView)localObject).getTotalQuery();
          p.j(str, "it.totalQuery");
          localObject = ((FTSEditTextView)localObject).getInEditTextQuery();
          p.j(localObject, "it.inEditTextQuery");
          locala.mk(str, (String)localObject);
          AppMethodBeat.o(198485);
          return;
        }
        AppMethodBeat.o(198485);
        return;
      }
    }
    AppMethodBeat.o(198485);
  }
  
  public final WebSearchWebView esG()
  {
    return this.PAJ;
  }
  
  public final com.tencent.mm.plugin.websearch.a.d gRr()
  {
    return this.PAI;
  }
  
  public final com.tencent.mm.plugin.websearch.a.a gRs()
  {
    return this.PAH;
  }
  
  public final Context getActivityContext()
  {
    AppMethodBeat.i(198471);
    Context localContext = this.PAK.getContext();
    p.j(localContext, "dialog.context");
    AppMethodBeat.o(198471);
    return localContext;
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(198487);
    paramView = this.PAG;
    if (paramView != null) {
      paramView.aDU();
    }
    paramView = this.PAG;
    if (paramView != null)
    {
      paramView.showVKB();
      AppMethodBeat.o(198487);
      return;
    }
    AppMethodBeat.o(198487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.d
 * JD-Core Version:    0.7.0.1
 */