package com.tencent.mm.plugin.webview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j.a;
import androidx.lifecycle.j.b;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUIStyleHelper;
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
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.r;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/WebViewTransHelper;", "Landroidx/lifecycle/LifecycleObserver;", "webViewUIHelper", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;)V", "liveDataMerger", "Landroidx/lifecycle/MediatorLiveData;", "getLiveDataMerger", "()Landroidx/lifecycle/MediatorLiveData;", "setLiveDataMerger", "(Landroidx/lifecycle/MediatorLiveData;)V", "liveScrollNewLocation", "Landroidx/lifecycle/MutableLiveData;", "", "getLiveScrollNewLocation", "()Landroidx/lifecycle/MutableLiveData;", "setLiveScrollNewLocation", "(Landroidx/lifecycle/MutableLiveData;)V", "liveUserTransStatus", "Lcom/tencent/mm/plugin/webview/WebTransStatus;", "getLiveUserTransStatus", "setLiveUserTransStatus", "localRandomID", "", "getLocalRandomID", "()Ljava/lang/String;", "setLocalRandomID", "(Ljava/lang/String;)V", "mainControlFlagOpen", "", "getMainControlFlagOpen", "()Z", "mainControlFlagOpen$delegate", "Lkotlin/Lazy;", "pageLogicController", "Lcom/tencent/mm/plugin/webview/WebTransPageLogic;", "getPageLogicController", "()Lcom/tencent/mm/plugin/webview/WebTransPageLogic;", "setPageLogicController", "(Lcom/tencent/mm/plugin/webview/WebTransPageLogic;)V", "pageLogicHasInitialized", "getPageLogicHasInitialized", "setPageLogicHasInitialized", "(Z)V", "transCache", "", "getTransCache", "()Ljava/util/Map;", "setTransCache", "(Ljava/util/Map;)V", "destroyPageLogicController", "", "getContentFromWebpage", "content", "initObserver", "initPage", "webview", "Lcom/tencent/xweb/WebView;", "onChangeTransStatus", "scene", "Lcom/tencent/mm/plugin/webview/WebTransEntryScene;", "onWebViewScrollChanged", "l", "t", "oldl", "oldt", "report", "action", "Lcom/tencent/mm/plugin/webview/WebTransReportAction;", "Lcom/tencent/mm/plugin/webview/WebTransReportScene;", "revertTrans", "startTrans", "titleViewCalculator", "Companion", "WebTransClientListener", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WebViewTransHelper
  implements p
{
  public static final a WvA;
  private final WebViewUIStyleHelper WvB;
  public k WvC;
  Map<String, String> WvD;
  public x<n> WvE;
  public x<Integer> WvF;
  private androidx.lifecycle.v<?> WvG;
  boolean WvH;
  public String WvI;
  private final j WvJ;
  
  static
  {
    AppMethodBeat.i(294631);
    WvA = new a((byte)0);
    AppMethodBeat.o(294631);
  }
  
  public WebViewTransHelper(WebViewUIStyleHelper paramWebViewUIStyleHelper)
  {
    AppMethodBeat.i(294575);
    this.WvB = paramWebViewUIStyleHelper;
    this.WvD = ((Map)new LinkedHashMap());
    this.WvE = new x();
    this.WvF = new x();
    this.WvG = new androidx.lifecycle.v();
    this.WvI = "";
    this.WvJ = kotlin.k.cm((kotlin.g.a.a)e.WvM);
    if (irx())
    {
      this.WvH = false;
      paramWebViewUIStyleHelper = this.WvB.WUm.Wzl;
      if (paramWebViewUIStyleHelper.Wxm.contains(Integer.valueOf(paramWebViewUIStyleHelper.Wxa)))
      {
        com.tencent.e.f.h.jXD();
        a((WebView)this.WvB.webView);
        irw().onStart();
      }
    }
    AppMethodBeat.o(294575);
  }
  
  private static final void a(WebViewTransHelper paramWebViewTransHelper, e parame)
  {
    AppMethodBeat.i(294603);
    kotlin.g.b.s.u(paramWebViewTransHelper, "this$0");
    paramWebViewTransHelper.WvG.setValue(parame);
    AppMethodBeat.o(294603);
  }
  
  private static final void a(WebViewTransHelper paramWebViewTransHelper, n paramn)
  {
    AppMethodBeat.i(294609);
    kotlin.g.b.s.u(paramWebViewTransHelper, "this$0");
    paramWebViewTransHelper.WvG.setValue(paramn);
    AppMethodBeat.o(294609);
  }
  
  private static final void a(WebViewTransHelper paramWebViewTransHelper, o paramo)
  {
    AppMethodBeat.i(294601);
    kotlin.g.b.s.u(paramWebViewTransHelper, "this$0");
    WebViewUIStyleHelper localWebViewUIStyleHelper = paramWebViewTransHelper.WvB;
    String str = paramWebViewTransHelper.irw().WuQ;
    if (localWebViewUIStyleHelper.WUm == null)
    {
      AppMethodBeat.o(294601);
      return;
    }
    Log.i("MicroMsg.WebViewUIStyleHelper", "trans tips status is %s", new Object[] { paramo.name() });
    paramWebViewTransHelper = localWebViewUIStyleHelper.WUm.findViewById(c.f.trans_tips);
    paramWebViewTransHelper.setBackgroundColor(localWebViewUIStyleHelper.izv());
    TextView localTextView = (TextView)paramWebViewTransHelper.findViewById(c.f.trans_tips_text);
    ProgressBar localProgressBar = (ProgressBar)paramWebViewTransHelper.findViewById(c.f.trans_tips_loading);
    switch (com.tencent.mm.plugin.webview.ui.tools.WebViewUIStyleHelper.4.WZD[paramo.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(294601);
      return;
      paramWebViewTransHelper.setVisibility(8);
      AppMethodBeat.o(294601);
      return;
      paramWebViewTransHelper.setVisibility(0);
      localTextView.setText(c.i.webview_menu_tranlate_waiting_tips);
      localProgressBar.setVisibility(0);
      AppMethodBeat.o(294601);
      return;
      paramWebViewTransHelper.setVisibility(0);
      paramWebViewTransHelper = str;
      if (Util.isNullOrNil(str)) {
        paramWebViewTransHelper = localWebViewUIStyleHelper.WUm.getResources().getString(c.i.webview_menu_tranlate_tips_brand);
      }
      localTextView.setText(paramWebViewTransHelper + localWebViewUIStyleHelper.WUm.getResources().getString(c.i.webview_menu_tranlate_tips));
      localProgressBar.setVisibility(4);
      AppMethodBeat.o(294601);
      return;
      paramWebViewTransHelper.setVisibility(0);
      localTextView.setText(localWebViewUIStyleHelper.WUm.getResources().getString(c.i.webview_menu_tranlate_tips_no_trans));
      localProgressBar.setVisibility(4);
    }
  }
  
  private static final void a(WebViewTransHelper paramWebViewTransHelper, Object paramObject)
  {
    AppMethodBeat.i(294621);
    kotlin.g.b.s.u(paramWebViewTransHelper, "this$0");
    kotlin.g.b.s.X("liveDataMerger -> ", paramObject);
    com.tencent.e.f.h.jXD();
    if ((paramObject instanceof e))
    {
      if ((paramObject == e.Wuu) || (paramObject == e.Wuw))
      {
        com.tencent.e.f.h.jXD();
        paramWebViewTransHelper.WvE.setValue(n.Wvr);
        paramWebViewTransHelper.irw().irt();
      }
    }
    else
    {
      paramWebViewTransHelper.iry();
      AppMethodBeat.o(294621);
      return;
    }
    if (paramWebViewTransHelper.irw().Wvc.getValue() == e.Wuv)
    {
      com.tencent.mm.ui.base.k.c((Context)paramWebViewTransHelper.WvB.WUm.getContext(), paramWebViewTransHelper.WvB.WUm.getContext().getString(c.i.webview_menu_no_need_to_tranlate), "", true);
      AppMethodBeat.o(294621);
      return;
    }
    com.tencent.mm.ui.base.k.c((Context)paramWebViewTransHelper.WvB.WUm.getContext(), paramWebViewTransHelper.WvB.WUm.getContext().getString(c.i.webview_menu_tranlate_bad_network), "", true);
    AppMethodBeat.o(294621);
  }
  
  private static final void a(WebViewTransHelper paramWebViewTransHelper, String paramString)
  {
    AppMethodBeat.i(294591);
    kotlin.g.b.s.u(paramWebViewTransHelper, "this$0");
    kotlin.g.b.s.u(paramString, "$content");
    k localk;
    ArrayList localArrayList;
    String str1;
    f localf;
    int k;
    if (paramWebViewTransHelper.WvC != null)
    {
      localk = paramWebViewTransHelper.irw();
      kotlin.g.b.s.u(paramString, "content");
      localArrayList = new ArrayList();
      try
      {
        paramString = new com.tencent.mm.ad.i(paramString);
        str1 = paramString.optString("randomID");
        paramWebViewTransHelper = localk.WuV;
        if (paramWebViewTransHelper == null) {}
        for (paramWebViewTransHelper = null; !kotlin.g.b.s.p(paramWebViewTransHelper, str1); paramWebViewTransHelper = paramWebViewTransHelper.irp())
        {
          Log.e(localk.TAG, "localRandomID != randomID");
          AppMethodBeat.o(294591);
          return;
        }
        localf = new f(paramString.optString("data"));
        if (localf.length() == 0)
        {
          Log.w(localk.TAG, "get nothing from webpage!");
          AppMethodBeat.o(294591);
          return;
        }
      }
      catch (Exception paramWebViewTransHelper)
      {
        Log.e(localk.TAG, com.tencent.mm.videocomposition.d.e.stackTraceToString((Throwable)paramWebViewTransHelper));
        AppMethodBeat.o(294591);
        return;
      }
      k = localf.length();
      if (k <= 0) {}
    }
    int j;
    label239:
    label370:
    label373:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      paramWebViewTransHelper = localf.st(i).optString("text");
      if (paramWebViewTransHelper == null)
      {
        paramWebViewTransHelper = "";
        paramString = localf.st(i).optString("hashID");
        if (paramString != null) {
          break label367;
        }
        paramString = "";
        str1 = localf.st(i).optString("isFirstScreen");
        if (str1 != null) {
          break label370;
        }
        str1 = "";
      }
      for (;;)
      {
        String str3 = localf.st(i).optString("isTitle");
        String str2 = str3;
        if (str3 == null) {
          str2 = "";
        }
        localArrayList.add(ak.e(new r[] { kotlin.v.Y("text", paramWebViewTransHelper), kotlin.v.Y("hashID", paramString), kotlin.v.Y("isFirstScreen", str1), kotlin.v.Y("title", str2) }));
        if (j < k) {
          break label373;
        }
        localk.bO(localArrayList);
        AppMethodBeat.o(294591);
        return;
        break;
        break label239;
      }
    }
  }
  
  private void b(k paramk)
  {
    AppMethodBeat.i(294579);
    kotlin.g.b.s.u(paramk, "<set-?>");
    this.WvC = paramk;
    AppMethodBeat.o(294579);
  }
  
  private final void iry()
  {
    AppMethodBeat.i(294585);
    if (!this.WvB.WUm.isOptionMenuShow(0))
    {
      this.WvB.a(h.WuH, i.WuL);
      com.tencent.e.f.h.jXD();
      AppMethodBeat.o(294585);
      return;
    }
    Object localObject = (n)this.WvE.getValue();
    if (localObject == null)
    {
      i = -1;
      switch (i)
      {
      default: 
        localObject = i.WuL;
      }
    }
    for (;;)
    {
      if ((irw().Wvc.getValue() == e.Wuu) || (irw().WuU) || (this.WvE.getValue() == n.Wvr)) {
        break label171;
      }
      this.WvB.a(h.WuH, (i)localObject);
      AppMethodBeat.o(294585);
      return;
      i = c.$EnumSwitchMapping$0[localObject.ordinal()];
      break;
      localObject = i.WuM;
      continue;
      localObject = i.WuL;
    }
    label171:
    if (this.WvE.getValue() == n.Wvr) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.WvB.a(h.WuI, (i)localObject);
      AppMethodBeat.o(294585);
      return;
    }
    Integer localInteger;
    if (this.WvF.getValue() == null) {
      localInteger = Integer.valueOf(0);
    }
    while (localInteger != null) {
      if (localInteger.intValue() < 100)
      {
        this.WvB.a(h.WuI, (i)localObject);
        AppMethodBeat.o(294585);
        return;
        localInteger = (Integer)this.WvF.getValue();
      }
      else
      {
        this.WvB.a(h.WuH, (i)localObject);
      }
    }
    AppMethodBeat.o(294585);
  }
  
  private void irz()
  {
    AppMethodBeat.i(294588);
    if (this.WvC == null)
    {
      com.tencent.e.f.h.jXD();
      AppMethodBeat.o(294588);
      return;
    }
    com.tencent.e.f.h.jXD();
    irw().WuW.a((q)this.WvB.WUm, new WebViewTransHelper..ExternalSyntheticLambda3(this));
    this.WvG.b((LiveData)irw().Wvc);
    this.WvG.a((LiveData)irw().Wvc, new WebViewTransHelper..ExternalSyntheticLambda1(this));
    this.WvG.b((LiveData)this.WvE);
    this.WvG.a((LiveData)this.WvE, new WebViewTransHelper..ExternalSyntheticLambda2(this));
    this.WvG.j((q)this.WvB.WUm);
    this.WvG.a((q)this.WvB.WUm, new WebViewTransHelper..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(294588);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(294687);
    kotlin.g.b.s.u(paramg, "scene");
    if (this.WvC == null)
    {
      com.tencent.e.f.h.jXD();
      AppMethodBeat.o(294687);
      return;
    }
    kotlin.g.b.s.X("onChangeTransStatus Entry Scene ", paramg);
    com.tencent.e.f.h.jXD();
    Object localObject = (n)this.WvE.getValue();
    if (localObject == null) {}
    for (int i = -1;; i = c.$EnumSwitchMapping$0[localObject.ordinal()]) {
      switch (i)
      {
      case 0: 
      default: 
        AppMethodBeat.o(294687);
        return;
      }
    }
    if (paramg == g.WuE) {}
    for (paramg = m.Wvk;; paramg = m.Wvl)
    {
      a(l.Wvh, paramg);
      irw().irv();
      AppMethodBeat.o(294687);
      return;
    }
    if (paramg == g.WuE) {}
    for (paramg = m.Wvo;; paramg = m.Wvn)
    {
      a(l.Wvh, paramg);
      com.tencent.e.f.h.jXD();
      this.WvE.setValue(n.Wvs);
      paramg = irw();
      paramg.WuW.setValue(o.Wvu);
      localObject = paramg.WuR;
      ((d)localObject).Wuo.clear();
      ((d)localObject).nvu.e(j.b.bHg);
      localObject = paramg.WuX;
      if (localObject != null) {
        ((cb)localObject).a(null);
      }
      paramg.b(paramg.webView, "window.WeixinTranslate.revertTrans()");
      break;
    }
  }
  
  public final void a(l paraml, m paramm)
  {
    AppMethodBeat.i(294699);
    kotlin.g.b.s.u(paraml, "action");
    kotlin.g.b.s.u(paramm, "scene");
    String str1 = this.WvB.webView.getUrl();
    kotlin.g.b.s.s(str1, "webViewUIHelper.webView.url");
    str1 = com.tencent.mm.plugin.webview.l.a.bne(str1);
    if (this.WvB.izu()) {}
    for (int i = 1;; i = 0)
    {
      String str2 = LocaleUtil.getApplicationLanguage();
      int j = paraml.ordinal();
      int k = paramm.ordinal();
      paraml = j + ',' + k + ',' + str1 + ',' + i + ',' + str2;
      kotlin.g.b.s.X("webTrans reportStr:", paraml);
      com.tencent.e.f.h.jXD();
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(21129, paraml);
      AppMethodBeat.o(294699);
      return;
    }
  }
  
  public final void a(WebView paramWebView)
  {
    AppMethodBeat.i(294674);
    com.tencent.e.f.h.jXD();
    if (paramWebView == null)
    {
      paramWebView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMWebView");
      AppMethodBeat.o(294674);
      throw paramWebView;
    }
    paramWebView = new k((MMWebView)paramWebView);
    paramWebView.a((b)new d(this));
    ah localah = ah.aiuX;
    b(paramWebView);
    this.WvH = true;
    if (!irx())
    {
      com.tencent.e.f.h.jXD();
      AppMethodBeat.o(294674);
      return;
    }
    irz();
    AppMethodBeat.o(294674);
  }
  
  public final void biV(String paramString)
  {
    AppMethodBeat.i(294660);
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.WvI = paramString;
    AppMethodBeat.o(294660);
  }
  
  @z(Ho=j.a.ON_DESTROY)
  public final void destroyPageLogicController()
  {
    AppMethodBeat.i(294669);
    com.tencent.e.f.h.jXD();
    if (this.WvC != null) {
      irw().nvu.e(j.b.bHg);
    }
    AppMethodBeat.o(294669);
  }
  
  public final void getContentFromWebpage(String paramString)
  {
    AppMethodBeat.i(294679);
    kotlin.g.b.s.u(paramString, "content");
    if (!irx())
    {
      com.tencent.e.f.h.jXD();
      AppMethodBeat.o(294679);
      return;
    }
    kotlin.g.b.s.X("get web page content: ", paramString);
    com.tencent.e.f.h.jXD();
    new Handler(Looper.getMainLooper()).post(new WebViewTransHelper..ExternalSyntheticLambda4(this, paramString));
    AppMethodBeat.o(294679);
  }
  
  public final k irw()
  {
    AppMethodBeat.i(294657);
    k localk = this.WvC;
    if (localk != null)
    {
      AppMethodBeat.o(294657);
      return localk;
    }
    kotlin.g.b.s.bIx("pageLogicController");
    AppMethodBeat.o(294657);
    return null;
  }
  
  public final boolean irx()
  {
    AppMethodBeat.i(294662);
    boolean bool = ((Boolean)this.WvJ.getValue()).booleanValue();
    AppMethodBeat.o(294662);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/WebViewTransHelper$Companion;", "", "()V", "NOTICE_KV_NAME", "", "NOTICE_KV_PARAM", "TAG", "WBETRANS_SCROLL_THRESH", "", "WEBTRANS_FORBID_HELPBTN_TRANS", "", "WEBTRANS_FORBID_HELPBTN_TRANS_AND_REVERT", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/WebViewTransHelper$WebTransClientListener;", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "weakWebViewTransHelper", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/WebViewTransHelper;", "(Ljava/lang/ref/WeakReference;)V", "onPageCommitVisible", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "onPageStarted", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends com.tencent.mm.plugin.webview.core.h
  {
    private final WeakReference<WebViewTransHelper> WvK;
    
    public b(WeakReference<WebViewTransHelper> paramWeakReference)
    {
      AppMethodBeat.i(294570);
      this.WvK = paramWeakReference;
      AppMethodBeat.o(294570);
    }
    
    public final void e(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(294583);
      super.e(paramWebView, paramString);
      com.tencent.e.f.h.jXD();
      paramString = (WebViewTransHelper)this.WvK.get();
      if ((paramString != null) && (paramString.WvH == true)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramString = (WebViewTransHelper)this.WvK.get();
          if (paramString != null) {
            paramString.destroyPageLogicController();
          }
        }
        paramString = (WebViewTransHelper)this.WvK.get();
        if (paramString != null) {
          paramString.a(paramWebView);
        }
        paramWebView = (WebViewTransHelper)this.WvK.get();
        if (paramWebView != null) {
          paramWebView.irw().onStart();
        }
        AppMethodBeat.o(294583);
        return;
      }
    }
    
    public final void h(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(294577);
      super.h(paramWebView, paramString);
      com.tencent.e.f.h.jXD();
      paramWebView = (WebViewTransHelper)this.WvK.get();
      if ((paramWebView != null) && (!paramWebView.WvH)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(294577);
        return;
      }
      paramWebView = (WebViewTransHelper)this.WvK.get();
      if (paramWebView == null) {}
      for (paramWebView = null;; paramWebView = (n)paramWebView.WvE.getValue())
      {
        if (paramWebView == n.Wvr)
        {
          paramWebView = (WebViewTransHelper)this.WvK.get();
          if (paramWebView != null) {
            WebViewTransHelper.a(paramWebView);
          }
        }
        AppMethodBeat.o(294577);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/WebViewTransHelper$initPage$1$1", "Lcom/tencent/mm/plugin/webview/PageLogicCallback;", "getLocalRandomID", "", "getTransCache", "", "getUserTransStatus", "Lcom/tencent/mm/plugin/webview/WebTransStatus;", "storeTransCache", "", "key", "value", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements b
  {
    d(WebViewTransHelper paramWebViewTransHelper) {}
    
    public final String irp()
    {
      return this.WvL.WvI;
    }
    
    public final n irq()
    {
      AppMethodBeat.i(294581);
      if (this.WvL.WvE.getValue() == null)
      {
        localObject = n.Wvq;
        AppMethodBeat.o(294581);
        return localObject;
      }
      Object localObject = this.WvL.WvE.getValue();
      kotlin.g.b.s.checkNotNull(localObject);
      kotlin.g.b.s.s(localObject, "{\n                      …e!!\n                    }");
      localObject = (n)localObject;
      AppMethodBeat.o(294581);
      return localObject;
    }
    
    public final Map<String, String> irr()
    {
      return this.WvL.WvD;
    }
    
    public final void nY(String paramString1, String paramString2)
    {
      AppMethodBeat.i(294584);
      kotlin.g.b.s.u(paramString1, "key");
      kotlin.g.b.s.u(paramString2, "value");
      this.WvL.WvD.put(paramString1, paramString2);
      AppMethodBeat.o(294584);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final e WvM;
    
    static
    {
      AppMethodBeat.i(294574);
      WvM = new e();
      AppMethodBeat.o(294574);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.WebViewTransHelper
 * JD-Core Version:    0.7.0.1
 */