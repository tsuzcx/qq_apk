package com.tencent.mm.plugin.webview;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.h.a;
import androidx.lifecycle.h.b;
import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.a.ae;
import kotlin.g.b.q;
import kotlinx.coroutines.by;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/WebViewTransHelper;", "Landroidx/lifecycle/LifecycleObserver;", "webViewUIHelper", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;)V", "liveDataMerger", "Landroidx/lifecycle/MediatorLiveData;", "getLiveDataMerger", "()Landroidx/lifecycle/MediatorLiveData;", "setLiveDataMerger", "(Landroidx/lifecycle/MediatorLiveData;)V", "liveScrollNewLocation", "Landroidx/lifecycle/MutableLiveData;", "", "getLiveScrollNewLocation", "()Landroidx/lifecycle/MutableLiveData;", "setLiveScrollNewLocation", "(Landroidx/lifecycle/MutableLiveData;)V", "liveUserTransStatus", "Lcom/tencent/mm/plugin/webview/WebTransStatus;", "getLiveUserTransStatus", "setLiveUserTransStatus", "localRandomID", "", "getLocalRandomID", "()Ljava/lang/String;", "setLocalRandomID", "(Ljava/lang/String;)V", "mainControlFlagOpen", "", "getMainControlFlagOpen", "()Z", "mainControlFlagOpen$delegate", "Lkotlin/Lazy;", "pageLogicController", "Lcom/tencent/mm/plugin/webview/WebTransPageLogic;", "getPageLogicController", "()Lcom/tencent/mm/plugin/webview/WebTransPageLogic;", "setPageLogicController", "(Lcom/tencent/mm/plugin/webview/WebTransPageLogic;)V", "pageLogicHasInitialized", "getPageLogicHasInitialized", "setPageLogicHasInitialized", "(Z)V", "transCache", "", "getTransCache", "()Ljava/util/Map;", "setTransCache", "(Ljava/util/Map;)V", "destroyPageLogicController", "", "getContentFromWebpage", "content", "initObserver", "initPage", "webview", "Lcom/tencent/xweb/WebView;", "onChangeTransStatus", "scene", "Lcom/tencent/mm/plugin/webview/WebTransEntryScene;", "onWebViewScrollChanged", "l", "t", "oldl", "oldt", "report", "action", "Lcom/tencent/mm/plugin/webview/WebTransReportAction;", "Lcom/tencent/mm/plugin/webview/WebTransReportScene;", "revertTrans", "startTrans", "titleViewCalculator", "Companion", "WebTransClientListener", "plugin-webview_release"})
public final class WebViewTransHelper
  implements androidx.lifecycle.k
{
  public static final a PFj;
  public k PFa;
  Map<String, String> PFb;
  public r<n> PFc;
  public r<Integer> PFd;
  androidx.lifecycle.p<?> PFe;
  boolean PFf;
  public String PFg;
  private final kotlin.f PFh;
  private final com.tencent.mm.plugin.webview.ui.tools.p PFi;
  
  static
  {
    AppMethodBeat.i(219552);
    PFj = new a((byte)0);
    AppMethodBeat.o(219552);
  }
  
  public WebViewTransHelper(com.tencent.mm.plugin.webview.ui.tools.p paramp)
  {
    AppMethodBeat.i(219549);
    this.PFi = paramp;
    this.PFb = ((Map)new LinkedHashMap());
    this.PFc = new r();
    this.PFd = new r();
    this.PFe = new androidx.lifecycle.p();
    this.PFg = "";
    this.PFh = kotlin.g.ar((kotlin.g.a.a)i.PFm);
    if (!gSf())
    {
      this.PFf = false;
      paramp = this.PFi.QcD.PIQ;
      if (paramp.PGz.contains(Integer.valueOf(paramp.PGn)))
      {
        com.tencent.d.f.h.ioq();
        a((WebView)this.PFi.webView);
        paramp = this.PFa;
        if (paramp == null) {
          kotlin.g.b.p.bGy("pageLogicController");
        }
        paramp.onStart();
      }
    }
    AppMethodBeat.o(219549);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(219535);
    kotlin.g.b.p.k(paramg, "scene");
    if (((WebViewTransHelper)this).PFa == null)
    {
      com.tencent.d.f.h.ioq();
      AppMethodBeat.o(219535);
      return;
    }
    "onChangeTransStatus Entry Scene ".concat(String.valueOf(paramg));
    com.tencent.d.f.h.ioq();
    Object localObject = (n)this.PFc.getValue();
    if (localObject == null) {
      if (paramg != g.PEb) {
        break label167;
      }
    }
    label167:
    for (paramg = m.PEK;; paramg = m.PEL)
    {
      a(l.PEH, paramg);
      paramg = this.PFa;
      if (paramg == null) {
        kotlin.g.b.p.bGy("pageLogicController");
      }
      localObject = k.bjj(paramg.PEq);
      if (!Util.isNullOrNil((String)localObject)) {
        break;
      }
      Log.e("MicroMsg.WebViewTransHelper", "check js script is null, inject fail!");
      AppMethodBeat.o(219535);
      return;
      switch (q.jLJ[localObject.ordinal()])
      {
      case 1: 
      case 2: 
      default: 
        AppMethodBeat.o(219535);
        return;
      }
    }
    paramg.PEx = 0;
    paramg.bjh((String)localObject);
    AppMethodBeat.o(219535);
    return;
    if (paramg == g.PEb) {}
    for (paramg = m.PEO;; paramg = m.PEN)
    {
      a(l.PEH, paramg);
      com.tencent.d.f.h.ioq();
      this.PFc.setValue(n.PES);
      paramg = this.PFa;
      if (paramg == null) {
        kotlin.g.b.p.bGy("pageLogicController");
      }
      paramg.PEt.setValue(o.PEU);
      localObject = paramg.PEo;
      ((d)localObject).PDJ.clear();
      ((d)localObject).PDH.b(h.b.ZO);
      localObject = paramg.PEu;
      if (localObject != null) {
        ((by)localObject).a(null);
      }
      paramg.a(paramg.webView, "window.WeixinTranslate.revertTrans()");
      break;
    }
  }
  
  public final void a(l paraml, m paramm)
  {
    AppMethodBeat.i(219545);
    kotlin.g.b.p.k(paraml, "action");
    kotlin.g.b.p.k(paramm, "scene");
    Object localObject = this.PFi.webView;
    kotlin.g.b.p.j(localObject, "webViewUIHelper.webView");
    localObject = ((MMWebView)localObject).getUrl();
    kotlin.g.b.p.j(localObject, "webViewUIHelper.webView.url");
    localObject = com.tencent.mm.plugin.webview.l.a.bnr((String)localObject);
    if (this.PFi.gZv()) {}
    for (int i = 1;; i = 0)
    {
      String str = LocaleUtil.getApplicationLanguage();
      int j = paraml.ordinal();
      int k = paramm.ordinal();
      paraml = j + ',' + k + ',' + (String)localObject + ',' + i + ',' + str;
      "webTrans reportStr:".concat(String.valueOf(paraml));
      com.tencent.d.f.h.ioq();
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(21129, paraml);
      AppMethodBeat.o(219545);
      return;
    }
  }
  
  public final void a(WebView paramWebView)
  {
    AppMethodBeat.i(219521);
    com.tencent.d.f.h.ioq();
    if (paramWebView == null)
    {
      paramWebView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMWebView");
      AppMethodBeat.o(219521);
      throw paramWebView;
    }
    paramWebView = new k((MMWebView)paramWebView);
    Object localObject = (b)new h(this);
    kotlin.g.b.p.k(localObject, "callback");
    paramWebView.PEs = ((b)localObject);
    this.PFa = paramWebView;
    this.PFf = true;
    if (!gSf())
    {
      com.tencent.d.f.h.ioq();
      AppMethodBeat.o(219521);
      return;
    }
    if (((WebViewTransHelper)this).PFa == null)
    {
      com.tencent.d.f.h.ioq();
      AppMethodBeat.o(219521);
      return;
    }
    com.tencent.d.f.h.ioq();
    paramWebView = this.PFa;
    if (paramWebView == null) {
      kotlin.g.b.p.bGy("pageLogicController");
    }
    paramWebView.PEt.a((androidx.lifecycle.l)this.PFi.QcD, (androidx.lifecycle.s)new d(this));
    paramWebView = this.PFe;
    localObject = this.PFa;
    if (localObject == null) {
      kotlin.g.b.p.bGy("pageLogicController");
    }
    paramWebView.a((LiveData)((k)localObject).PEz);
    paramWebView = this.PFe;
    localObject = this.PFa;
    if (localObject == null) {
      kotlin.g.b.p.bGy("pageLogicController");
    }
    paramWebView.a((LiveData)((k)localObject).PEz, (androidx.lifecycle.s)new e(this));
    this.PFe.a((LiveData)this.PFc);
    this.PFe.a((LiveData)this.PFc, (androidx.lifecycle.s)new f(this));
    this.PFe.c((androidx.lifecycle.l)this.PFi.QcD);
    this.PFe.a((androidx.lifecycle.l)this.PFi.QcD, (androidx.lifecycle.s)new g(this));
    AppMethodBeat.o(219521);
  }
  
  public final void bjk(String paramString)
  {
    AppMethodBeat.i(219506);
    kotlin.g.b.p.k(paramString, "<set-?>");
    this.PFg = paramString;
    AppMethodBeat.o(219506);
  }
  
  @androidx.lifecycle.t(jl=h.a.ON_DESTROY)
  public final void destroyPageLogicController()
  {
    AppMethodBeat.i(219512);
    com.tencent.d.f.h.ioq();
    if (((WebViewTransHelper)this).PFa != null)
    {
      k localk = this.PFa;
      if (localk == null) {
        kotlin.g.b.p.bGy("pageLogicController");
      }
      localk.PDH.b(h.b.ZO);
    }
    AppMethodBeat.o(219512);
  }
  
  public final k gSe()
  {
    AppMethodBeat.i(219502);
    k localk = this.PFa;
    if (localk == null) {
      kotlin.g.b.p.bGy("pageLogicController");
    }
    AppMethodBeat.o(219502);
    return localk;
  }
  
  public final boolean gSf()
  {
    AppMethodBeat.i(219508);
    boolean bool = ((Boolean)this.PFh.getValue()).booleanValue();
    AppMethodBeat.o(219508);
    return bool;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/WebViewTransHelper$Companion;", "", "()V", "NOTICE_KV_NAME", "", "NOTICE_KV_PARAM", "TAG", "WBETRANS_SCROLL_THRESH", "", "WEBTRANS_FORBID_HELPBTN_TRANS", "", "WEBTRANS_FORBID_HELPBTN_TRANS_AND_REVERT", "plugin-webview_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/WebViewTransHelper$WebTransClientListener;", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "weakWebViewTransHelper", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/WebViewTransHelper;", "(Ljava/lang/ref/WeakReference;)V", "onPageCommitVisible", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "onPageStarted", "plugin-webview_release"})
  public static final class b
    extends com.tencent.mm.plugin.webview.core.f
  {
    private final WeakReference<WebViewTransHelper> PFk;
    
    public b(WeakReference<WebViewTransHelper> paramWeakReference)
    {
      AppMethodBeat.i(256354);
      this.PFk = paramWeakReference;
      AppMethodBeat.o(256354);
    }
    
    public final void e(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(256353);
      super.e(paramWebView, paramString);
      com.tencent.d.f.h.ioq();
      paramString = (WebViewTransHelper)this.PFk.get();
      if ((paramString != null) && (paramString.PFf == true))
      {
        paramString = (WebViewTransHelper)this.PFk.get();
        if (paramString != null) {
          paramString.destroyPageLogicController();
        }
      }
      paramString = (WebViewTransHelper)this.PFk.get();
      if (paramString != null) {
        paramString.a(paramWebView);
      }
      paramWebView = (WebViewTransHelper)this.PFk.get();
      if (paramWebView != null)
      {
        paramWebView = paramWebView.gSe();
        if (paramWebView != null)
        {
          paramWebView.onStart();
          AppMethodBeat.o(256353);
          return;
        }
      }
      AppMethodBeat.o(256353);
    }
    
    public final void h(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(256350);
      super.h(paramWebView, paramString);
      com.tencent.d.f.h.ioq();
      paramWebView = (WebViewTransHelper)this.PFk.get();
      if ((paramWebView != null) && (!paramWebView.PFf))
      {
        AppMethodBeat.o(256350);
        return;
      }
      paramWebView = (WebViewTransHelper)this.PFk.get();
      if (paramWebView != null)
      {
        paramWebView = paramWebView.PFc;
        if (paramWebView == null) {}
      }
      for (paramWebView = (n)paramWebView.getValue(); paramWebView == n.PER; paramWebView = null)
      {
        paramWebView = (WebViewTransHelper)this.PFk.get();
        if (paramWebView == null) {
          break;
        }
        WebViewTransHelper.a(paramWebView);
        AppMethodBeat.o(256350);
        return;
      }
      AppMethodBeat.o(256350);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(WebViewTransHelper paramWebViewTransHelper, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(228245);
      k localk;
      Object localObject1;
      ArrayList localArrayList;
      if (this.PFl.PFa != null)
      {
        localk = this.PFl.gSe();
        localObject1 = this.iVV;
        kotlin.g.b.p.k(localObject1, "content");
        localArrayList = new ArrayList();
      }
      for (;;)
      {
        Object localObject2;
        String str2;
        com.tencent.mm.ad.f localf;
        try
        {
          localObject2 = new i((String)localObject1);
          str2 = ((i)localObject2).optString("randomID");
          localObject1 = localk.PEs;
          if (localObject1 == null) {
            break label352;
          }
          localObject1 = ((b)localObject1).gRY();
          if ((kotlin.g.b.p.h(localObject1, str2) ^ true))
          {
            Log.e(localk.TAG, "localRandomID != randomID");
            AppMethodBeat.o(228245);
            return;
          }
          localf = new com.tencent.mm.ad.f(((i)localObject2).optString("data"));
          if (localf.length() == 0)
          {
            Log.w(localk.TAG, "get nothing from webpage!");
            AppMethodBeat.o(228245);
            return;
          }
        }
        catch (Exception localException)
        {
          Log.e(localk.TAG, com.tencent.mm.videocomposition.c.e.stackTraceToString((Throwable)localException));
          AppMethodBeat.o(228245);
          return;
        }
        int j = localf.length();
        int i = 0;
        if (i < j)
        {
          str1 = localf.sx(i).optString("text");
          if (str1 != null) {
            break label349;
          }
          str1 = "";
        }
        label349:
        for (;;)
        {
          localObject2 = localf.sx(i).optString("hashID");
          if (localObject2 == null) {
            localObject2 = "";
          }
          for (;;)
          {
            str2 = localf.sx(i).optString("isFirstScreen");
            if (str2 == null) {
              str2 = "";
            }
            for (;;)
            {
              String str4 = localf.sx(i).optString("isTitle");
              String str3 = str4;
              if (str4 == null) {
                str3 = "";
              }
              localArrayList.add(ae.e(new kotlin.o[] { kotlin.s.M("text", str1), kotlin.s.M("hashID", localObject2), kotlin.s.M("isFirstScreen", str2), kotlin.s.M("title", str3) }));
              i += 1;
              break;
              localk.bn(localArrayList);
              AppMethodBeat.o(228245);
              return;
            }
          }
        }
        label352:
        String str1 = null;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/webview/WebTransTipsStatus;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class d<T>
    implements androidx.lifecycle.s<o>
  {
    d(WebViewTransHelper paramWebViewTransHelper) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/webview/WebTransCheckResult;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class e<T>
    implements androidx.lifecycle.s<S>
  {
    e(WebViewTransHelper paramWebViewTransHelper) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/webview/WebTransStatus;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class f<T>
    implements androidx.lifecycle.s<S>
  {
    f(WebViewTransHelper paramWebViewTransHelper) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"})
  static final class g<T>
    implements androidx.lifecycle.s<Object>
  {
    g(WebViewTransHelper paramWebViewTransHelper) {}
    
    public final void onChanged(Object paramObject)
    {
      AppMethodBeat.i(234933);
      "liveDataMerger -> ".concat(String.valueOf(paramObject));
      com.tencent.d.f.h.ioq();
      if ((paramObject instanceof e))
      {
        if ((paramObject == e.PDR) || (paramObject == e.PDT))
        {
          paramObject = this.PFl;
          com.tencent.d.f.h.ioq();
          paramObject.PFc.setValue(n.PER);
          paramObject = paramObject.PFa;
          if (paramObject == null) {
            kotlin.g.b.p.bGy("pageLogicController");
          }
          paramObject.gSc();
        }
      }
      else
      {
        WebViewTransHelper.a(this.PFl);
        AppMethodBeat.o(234933);
        return;
      }
      if ((e)this.PFl.gSe().PEz.getValue() == e.PDS)
      {
        paramObject = WebViewTransHelper.b(this.PFl).QcD;
        kotlin.g.b.p.j(paramObject, "webViewUIHelper.webViewUI");
        paramObject = (Context)paramObject.getContext();
        localWebViewUI = WebViewTransHelper.b(this.PFl).QcD;
        kotlin.g.b.p.j(localWebViewUI, "webViewUIHelper.webViewUI");
        com.tencent.mm.ui.base.h.af(paramObject, localWebViewUI.getContext().getString(c.i.webview_menu_no_need_to_tranlate), "");
        AppMethodBeat.o(234933);
        return;
      }
      paramObject = WebViewTransHelper.b(this.PFl).QcD;
      kotlin.g.b.p.j(paramObject, "webViewUIHelper.webViewUI");
      paramObject = (Context)paramObject.getContext();
      WebViewUI localWebViewUI = WebViewTransHelper.b(this.PFl).QcD;
      kotlin.g.b.p.j(localWebViewUI, "webViewUIHelper.webViewUI");
      com.tencent.mm.ui.base.h.af(paramObject, localWebViewUI.getContext().getString(c.i.webview_menu_tranlate_bad_network), "");
      AppMethodBeat.o(234933);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/WebViewTransHelper$initPage$1$1", "Lcom/tencent/mm/plugin/webview/PageLogicCallback;", "getLocalRandomID", "", "getTransCache", "", "getUserTransStatus", "Lcom/tencent/mm/plugin/webview/WebTransStatus;", "storeTransCache", "", "key", "value", "plugin-webview_release"})
  public static final class h
    implements b
  {
    h(WebViewTransHelper paramWebViewTransHelper) {}
    
    public final String gRY()
    {
      return this.PFl.PFg;
    }
    
    public final n gRZ()
    {
      AppMethodBeat.i(267256);
      if (this.PFl.PFc.getValue() == null)
      {
        localObject = n.PEQ;
        AppMethodBeat.o(267256);
        return localObject;
      }
      Object localObject = this.PFl.PFc.getValue();
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      kotlin.g.b.p.j(localObject, "liveUserTransStatus.value!!");
      localObject = (n)localObject;
      AppMethodBeat.o(267256);
      return localObject;
    }
    
    public final Map<String, String> gSa()
    {
      return this.PFl.PFb;
    }
    
    public final void ml(String paramString1, String paramString2)
    {
      AppMethodBeat.i(267257);
      kotlin.g.b.p.k(paramString1, "key");
      kotlin.g.b.p.k(paramString2, "value");
      this.PFl.PFb.put(paramString1, paramString2);
      AppMethodBeat.o(267257);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final i PFm;
    
    static
    {
      AppMethodBeat.i(264485);
      PFm = new i();
      AppMethodBeat.o(264485);
    }
    
    i()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.WebViewTransHelper
 * JD-Core Version:    0.7.0.1
 */