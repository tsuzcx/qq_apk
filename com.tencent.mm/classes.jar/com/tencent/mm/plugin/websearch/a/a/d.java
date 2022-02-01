package com.tencent.mm.plugin.websearch.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.li;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.e;
import com.tencent.mm.plugin.websearch.webview.f;
import com.tencent.mm.plugin.websearch.webview.i;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.xweb.ac;
import com.tencent.xweb.x;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchMainTab;", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "dialog", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "listener", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "dialogView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;Landroid/view/View;)V", "TAG", "", "getDialog", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "ftsEditTextView", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "getHomeContext", "()Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "setHomeContext", "(Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;)V", "getListener", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "mainTabView", "kotlin.jvm.PlatformType", "tagSearchWebData", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchWebData;", "tagSearchWebView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "tagSearchWebViewJSApi", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi;", "webviewContainer", "Landroid/widget/FrameLayout;", "appendSearchTag", "", "tag", "sessionId", "searchId", "requestId", "getActivityContext", "Landroid/content/Context;", "getDataContext", "getWebSearchData", "getWebSearchJSApi", "getWebView", "onClickClearTextBtn", "view", "onDismiss", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "cropBitmap", "Landroid/graphics/Bitmap;", "query", "onSearchInputChange", "isInputChange", "onSearchKeyDown", "onStartSearchShareCgi", "id", "onTagClick", "index", "", "startMoreTab", "moreContext", "ui-websearch_release"})
public final class d
  implements b, FTSEditTextView.a
{
  egj IGg;
  final a IGh;
  private View IGo;
  FTSEditTextView IGp;
  private com.tencent.mm.plugin.websearch.a.a IGq;
  com.tencent.mm.plugin.websearch.a.d IGr;
  WebSearchWebView IGs;
  final c IGt;
  final String TAG;
  private FrameLayout plP;
  
  public d(c paramc, egj paramegj, a parama, View paramView)
  {
    AppMethodBeat.i(197980);
    this.IGt = paramc;
    this.IGg = paramegj;
    this.IGh = parama;
    this.TAG = "MicroMsg.WebSearch.TagSearchMainTab";
    this.IGo = paramView.findViewById(2131304335);
    paramc = paramView.findViewById(2131304343);
    p.g(paramc, "dialogView.findViewById(…d.main_webview_container)");
    this.plP = ((FrameLayout)paramc);
    paramc = paramView.findViewById(2131301807);
    p.g(paramc, "dialogView.findViewById(R.id.fts_edittext)");
    this.IGp = ((FTSEditTextView)paramc);
    this.IGq = new com.tencent.mm.plugin.websearch.a.a((b)this);
    this.IGr = new com.tencent.mm.plugin.websearch.a.d((b)this);
    this.IGs = new WebSearchWebView(getActivityContext());
    this.IGp.gWY();
    this.IGp.setFtsEditTextListener((FTSEditTextView.a)this);
    this.IGp.awD();
    this.IGp.awC();
    paramc = this.IGp;
    paramegj = this.IGp.getContext();
    p.g(paramegj, "ftsEditTextView.context");
    paramc.setHint(paramegj.getResources().getString(2131755972));
    paramc = new e();
    paramegj = new f(6);
    this.IGs.a((x)paramc, (ac)paramegj);
    this.IGs.addJavascriptInterface(this.IGq, "tagWebSearchJSApi");
    this.plP.addView((View)this.IGs);
    Log.i(this.TAG, "start to load url %s", new Object[] { this.IGg.url });
    this.IGs.loadUrl(this.IGg.url);
    AppMethodBeat.o(197980);
  }
  
  public final void F(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(197971);
    p.h(paramString1, "tag");
    p.h(paramString2, "sessionId");
    p.h(paramString3, "searchId");
    p.h(paramString4, "requestId");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new d.a(this, paramString1));
    li localli = new li();
    localli.uM(4L);
    localli.uN(cl.aWB());
    localli.aiA();
    localli.yx(paramString1);
    if (ab.Eq(this.IGg.talker)) {}
    for (long l = 2L;; l = 1L)
    {
      localli.uO(l);
      localli.yy(this.IGg.talker);
      localli.yz(paramString2);
      localli.yA(paramString3);
      localli.yB(paramString4);
      localli.yC("");
      localli.bfK();
      ar.a((com.tencent.mm.plugin.report.a)localli);
      AppMethodBeat.o(197971);
      return;
    }
  }
  
  public final void a(buv parambuv, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(197979);
    p.h(parambuv, "shareContent");
    this.IGt.a(parambuv, paramBitmap, paramString);
    AppMethodBeat.o(197979);
  }
  
  public final void a(egj paramegj)
  {
    AppMethodBeat.i(197972);
    p.h(paramegj, "moreContext");
    c localc = this.IGt;
    p.h(paramegj, "moreContext");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new c.g(localc, paramegj));
    AppMethodBeat.o(197972);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(197975);
    if ((paramb == FTSEditTextView.b.QnQ) || (paramb == FTSEditTextView.b.QnR))
    {
      paramList = this.IGp;
      if (paramList != null)
      {
        paramString1 = this.IGq;
        if (paramString1 != null)
        {
          paramString2 = paramList.getTotalQuery();
          p.g(paramString2, "it.totalQuery");
          paramList = paramList.getInEditTextQuery();
          p.g(paramList, "it.inEditTextQuery");
          paramString1.lK(paramString2, paramList);
          AppMethodBeat.o(197975);
          return;
        }
        AppMethodBeat.o(197975);
        return;
      }
    }
    AppMethodBeat.o(197975);
  }
  
  public final void aXn(String paramString)
  {
    AppMethodBeat.i(197978);
    p.h(paramString, "id");
    this.IGt.aXn(paramString);
    AppMethodBeat.o(197978);
  }
  
  public final boolean awE()
  {
    AppMethodBeat.i(197974);
    FTSEditTextView localFTSEditTextView = this.IGp;
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
          AppMethodBeat.o(197974);
          throw ((Throwable)localObject1);
        }
        localObject2 = (CharSequence)n.trim((CharSequence)localObject1).toString();
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
          localObject3 = this.IGq;
          if (localObject3 != null)
          {
            str = localFTSEditTextView.getInEditTextQuery();
            p.g(str, "view.inEditTextQuery");
            p.h(localObject1, "query");
            p.h(str, "custom");
            localObject2 = new JSONObject();
          }
        }
      }
      try
      {
        ((JSONObject)localObject2).put("query", localObject1);
        ((JSONObject)localObject2).put("custom", str);
        label163:
        localObject1 = ((com.tencent.mm.plugin.websearch.webview.b)localObject3).IHe;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.websearch.webview.d)localObject1).dQg();
          if (localObject1 != null)
          {
            localObject3 = i.IHk;
            localObject2 = ((JSONObject)localObject2).toString();
            p.g(localObject2, "requestObj.toString()");
            i.a((WebSearchWebView)localObject1, "onSearchInputConfirm", (String)localObject2);
          }
        }
        localFTSEditTextView.hideVKB();
        AppMethodBeat.o(197974);
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
  
  public final void cK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197970);
    p.h(paramString, "query");
    Object localObject1 = this.IGp;
    if (localObject1 != null) {
      ((FTSEditTextView)localObject1).O(paramString, null);
    }
    if (paramBoolean)
    {
      paramString = this.IGp;
      if (paramString != null) {
        paramString.awD();
      }
      paramString = this.IGp;
      if (paramString != null) {
        paramString.showVKB();
      }
      Object localObject2 = this.IGp;
      if (localObject2 != null)
      {
        paramString = this.IGq;
        if (paramString != null)
        {
          localObject1 = ((FTSEditTextView)localObject2).getTotalQuery();
          p.g(localObject1, "it.totalQuery");
          localObject2 = ((FTSEditTextView)localObject2).getInEditTextQuery();
          p.g(localObject2, "it.inEditTextQuery");
          paramString.lK((String)localObject1, (String)localObject2);
          AppMethodBeat.o(197970);
          return;
        }
        AppMethodBeat.o(197970);
        return;
      }
      AppMethodBeat.o(197970);
      return;
    }
    paramString = this.IGp;
    if (paramString != null) {
      paramString.gUA();
    }
    paramString = this.IGp;
    if (paramString != null)
    {
      paramString.hideVKB();
      AppMethodBeat.o(197970);
      return;
    }
    AppMethodBeat.o(197970);
  }
  
  public final WebSearchWebView dQg()
  {
    return this.IGs;
  }
  
  public final void dpw() {}
  
  public final void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(197976);
    if (paramBoolean)
    {
      Object localObject = this.IGp;
      if (localObject != null)
      {
        com.tencent.mm.plugin.websearch.a.a locala = this.IGq;
        if (locala != null)
        {
          String str = ((FTSEditTextView)localObject).getTotalQuery();
          p.g(str, "it.totalQuery");
          localObject = ((FTSEditTextView)localObject).getInEditTextQuery();
          p.g(localObject, "it.inEditTextQuery");
          locala.lK(str, (String)localObject);
          AppMethodBeat.o(197976);
          return;
        }
        AppMethodBeat.o(197976);
        return;
      }
    }
    AppMethodBeat.o(197976);
  }
  
  public final com.tencent.mm.plugin.websearch.a.d fYG()
  {
    return this.IGr;
  }
  
  public final com.tencent.mm.plugin.websearch.a.a fYH()
  {
    return this.IGq;
  }
  
  public final Context getActivityContext()
  {
    AppMethodBeat.i(197973);
    Context localContext = this.IGt.getContext();
    p.g(localContext, "dialog.context");
    AppMethodBeat.o(197973);
    return localContext;
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(197977);
    paramView = this.IGp;
    if (paramView != null) {
      paramView.awD();
    }
    paramView = this.IGp;
    if (paramView != null)
    {
      paramView.showVKB();
      AppMethodBeat.o(197977);
      return;
    }
    AppMethodBeat.o(197977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.d
 * JD-Core Version:    0.7.0.1
 */