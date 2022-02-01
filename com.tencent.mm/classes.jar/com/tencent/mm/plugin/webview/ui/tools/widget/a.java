package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Outline;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.api.ab;
import com.tencent.mm.autogen.a.mi;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.d;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.b;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.pulldown.NestedBounceView;
import com.tencent.mm.ui.widget.pulldown.f.a;
import com.tencent.mm.ui.widget.pulldown.g;
import com.tencent.threadpool.i;
import com.tencent.xweb.WebView;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.ah;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkView.OverScrolledListener;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView;", "Lcom/tencent/mm/ui/dialog/HalfScreenDialog;", "Lcom/tencent/mm/plugin/webview/core/IWebViewJsApiContext;", "Lcom/tencent/mm/ui/MMActivity$OnConfigurationChangedListener;", "activityContext", "Landroid/content/Context;", "url", "", "wv", "Lcom/tencent/mm/ui/widget/MMWebView;", "option", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebViewOption;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebViewOption;)V", "getActivityContext", "()Landroid/content/Context;", "arrowContainerLayout", "Landroid/view/View;", "arrowIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "arrowLayout", "cacheController", "", "containerLayout", "Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView;", "contentLayout", "halfScreenCallback", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewHalfScreenCallback;", "halfScreenDialogDragUtil", "Lcom/tencent/mm/ui/dialog/HalfScreenDialogDragHelper;", "getHalfScreenDialogDragUtil", "()Lcom/tencent/mm/ui/dialog/HalfScreenDialogDragHelper;", "halfScreenDialogDragUtil$delegate", "Lkotlin/Lazy;", "halfScreenWebViewCloseEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "immersiveStyle", "menuIcon", "getOption", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebViewOption;", "padding8Dp", "", "progressBar", "Landroid/widget/ProgressBar;", "refreshMask", "titleBarLayout", "webView", "webViewCallback", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/PreloadWebViewStubCallback;", "getWebViewCallback", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/PreloadWebViewStubCallback;", "webViewCallback$delegate", "webViewController", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getWebViewController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setWebViewController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "webViewControllerListener", "com/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView$webViewControllerListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView$webViewControllerListener$1;", "webViewInterceptor", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebViewInterceptor;", "getWebViewInterceptor", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebViewInterceptor;", "webViewInterceptor$delegate", "getWv", "()Lcom/tencent/mm/ui/widget/MMWebView;", "xwScrollGap", "", "closeWindow", "", "data", "Landroid/os/Bundle;", "disableBounceScroll", "doSetBounceBackground", "color", "doUpdateVisitedHistory", "webview", "Lcom/tencent/xweb/WebView;", "isReload", "getDefaultActionBgColor", "getDefaultBgColor", "getEmptyViewHeight", "handleSetNavigationBarColor", "hideCreateProgressbar", "inflateContentView", "initActionBar", "initContentView", "initDragView", "initFont", "initImmersiveStyle", "initOrientation", "initOverScrollMode", "initView", "initWebView", "initWebViewStubCallback", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDismiss", "onOuterViewClick", "onPageCommitVisible", "onPageFinished", "onPageStarted", "onWindowFocusChanged", "hasFocus", "refresh", "force", "roundCorner", "view", "cornerRadius", "setActionBarBackgroundColor", "setFontSize", "fontSize", "setHalfScreenCallback", "callback", "showCreateProgressbar", "showRefreshMask", "updateBackBtn", "updateEmptyViewHeight", "updateView", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.ui.f.a
  implements com.tencent.mm.plugin.webview.core.b, MMActivity.b
{
  public static final a XoU;
  BaseWebViewController GXZ;
  private final MMWebView WDz;
  private boolean WGL;
  private View WXQ;
  final c XoV;
  private View XoW;
  private View XoX;
  private View XoY;
  private WeImageView XoZ;
  private View Xpa;
  NestedBounceView Xpb;
  private WeImageView Xpc;
  private final kotlin.j Xpd;
  private final float Xpe;
  private boolean Xpf;
  private u Xpg;
  private final IListener<?> Xph;
  private final kotlin.j Xpi;
  private j Xpj;
  private final kotlin.j Xpk;
  private int Xpl;
  final Context hOx;
  private ProgressBar progressBar;
  private final String url;
  private MMWebView webView;
  
  static
  {
    AppMethodBeat.i(298208);
    XoU = new a((byte)0);
    AppMethodBeat.o(298208);
  }
  
  private a(Context paramContext, String paramString, c paramc)
  {
    super(paramContext);
    AppMethodBeat.i(298110);
    this.hOx = paramContext;
    this.WDz = null;
    this.XoV = paramc;
    this.url = paramString;
    this.Xpd = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.Xpe = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    this.Xph = ((IListener)new HalfScreenWebView.halfScreenWebViewCloseEventListener.1(this, com.tencent.mm.app.f.hfK));
    this.Xpi = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.Xpj = new j(this);
    this.Xpk = kotlin.k.cm((kotlin.g.a.a)new i(paramString, this));
    AppMethodBeat.o(298110);
  }
  
  private static void C(View paramView, float paramFloat)
  {
    AppMethodBeat.i(298124);
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new h(paramFloat));
    }
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    AppMethodBeat.o(298124);
  }
  
  private static final void a(a parama)
  {
    boolean bool2 = true;
    Object localObject2 = null;
    AppMethodBeat.i(298168);
    kotlin.g.b.s.u(parama, "this$0");
    Object localObject1 = com.tencent.mm.plugin.webview.k.l.Xtf;
    parama.GXZ = com.tencent.mm.plugin.webview.k.l.dN(parama.url, parama.XoV.Xpr);
    Object localObject4 = parama.GXZ;
    Object localObject3;
    if (localObject4 != null)
    {
      parama.Xpf = true;
      parama.webView = ((BaseWebViewController)localObject4).sMP;
      localObject3 = parama.webView;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("webView");
        localObject1 = null;
      }
      ((MMWebView)localObject1).bm(parama.hOx);
      ((BaseWebViewController)localObject4).a((com.tencent.mm.plugin.webview.core.l)parama.Xpj);
      ((BaseWebViewController)localObject4).a((m)parama.iCd());
      if (((BaseWebViewController)localObject4).Wxm.contains(Integer.valueOf(((BaseWebViewController)localObject4).WwZ))) {
        parama.iyW();
      }
    }
    boolean bool1;
    if (parama.GXZ == null)
    {
      localObject3 = parama.WDz;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = MMWebView.a.nL((Context)new MutableContextWrapper(parama.hOx));
        kotlin.g.b.s.s(localObject1, "create(MutableContextWrapper(activityContext))");
      }
      parama.webView = ((MMWebView)localObject1);
      localObject3 = (ab)com.tencent.mm.kernel.h.ax(ab.class);
      localObject1 = parama.webView;
      if (localObject1 != null) {
        break label1158;
      }
      kotlin.g.b.s.bIx("webView");
      localObject1 = null;
      parama.GXZ = ((ab)localObject3).a((MMWebView)localObject1, new BaseWebViewController.d(null, false, false, false, false, false, 105), null);
      localObject1 = parama.GXZ;
      if (localObject1 != null)
      {
        if (parama.XoV.Xpr)
        {
          localObject3 = com.tencent.mm.plugin.webview.k.l.Xtf;
          localObject3 = parama.url;
          kotlin.g.b.s.u(localObject3, "url");
          kotlin.g.b.s.u(localObject1, "controller");
          if (com.tencent.mm.plugin.webview.k.l.Xtg.size() < 2) {
            break label1161;
          }
          Log.w("MicroMsg.WebViewControllerPreloadMrg", "addToCache, do not cache more than 2 WebViewController!!!");
          bool1 = false;
          label329:
          parama.Xpf = bool1;
        }
        ((BaseWebViewController)localObject1).a((com.tencent.mm.plugin.webview.core.l)parama.Xpj);
        ((BaseWebViewController)localObject1).a((m)parama.iCd());
        ((BaseWebViewController)localObject1).init();
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra("rawUrl", parama.url);
        ((Intent)localObject3).putExtra("useJs", true);
        localObject4 = ah.aiuX;
        ((BaseWebViewController)localObject1).bJ((Intent)localObject3);
      }
    }
    localObject1 = parama.GXZ;
    int i;
    if (localObject1 != null)
    {
      ((BaseWebViewController)localObject1).Wwm.WFl = true;
      ((BaseWebViewController)localObject1).Wwp = ((Dialog)parama);
      ((BaseWebViewController)localObject1).Wwm.extData = parama.XoV.extData;
      ((BaseWebViewController)localObject1).Wwm.heightPercent = parama.XoV.heightPercent;
      localObject3 = ((BaseWebViewController)localObject1).Wwm;
      if (parama.WGL)
      {
        i = 1;
        label482:
        ((com.tencent.mm.plugin.webview.jsapi.b.b)localObject3).WFk = i;
        ((BaseWebViewController)localObject1).getJsapi().GXZ = ((BaseWebViewController)localObject1);
      }
    }
    else
    {
      i = (int)(com.tencent.mm.cd.a.mt(parama.getContext()) * (parama.XoV.heightPercent * 0.3F));
      com.tencent.mm.ui.f.b.a(parama.iBZ(), parama.XoX, parama.jBi(), i, 0.5F, null, 16);
      localObject4 = parama.iBZ();
      View localView1 = parama.Xpa;
      View localView2 = parama.jBi();
      if (parama.WGL)
      {
        localObject3 = parama.webView;
        localObject1 = localObject3;
        if (localObject3 == null) {
          kotlin.g.b.s.bIx("webView");
        }
      }
      else
      {
        localObject1 = null;
      }
      com.tencent.mm.ui.f.b.a((com.tencent.mm.ui.f.b)localObject4, localView1, localView2, i, 0.0F, (View)localObject1, 8);
      localObject3 = parama.webView;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("webView");
        localObject1 = null;
      }
      localObject1 = ((MMWebView)localObject1).getParent();
      if (!(localObject1 instanceof ViewGroup)) {
        break label1230;
      }
      localObject1 = (ViewGroup)localObject1;
      label655:
      if (localObject1 != null) {
        ((ViewGroup)localObject1).removeAllViews();
      }
      localObject4 = parama.Xpb;
      if (localObject4 != null)
      {
        localObject3 = parama.webView;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("webView");
          localObject1 = null;
        }
        ((NestedBounceView)localObject4).addView((View)localObject1, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      }
      localObject3 = parama.webView;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("webView");
        localObject1 = null;
      }
      ((MMWebView)localObject1).setBackgroundColor(parama.iCa());
      localObject1 = parama.GXZ;
      if ((localObject1 == null) || (((BaseWebViewController)localObject1).isb())) {
        break label1236;
      }
      i = 1;
      label776:
      if (i != 0) {
        parama.iyY();
      }
      localObject1 = parama.GXZ;
      if (localObject1 == null) {
        break label1241;
      }
      localObject1 = ((BaseWebViewController)localObject1).getJsapi();
      if ((localObject1 == null) || (((com.tencent.mm.plugin.webview.jsapi.j)localObject1).UcS != true)) {
        break label1241;
      }
      i = 1;
      label818:
      if (i != 0)
      {
        localObject1 = parama.GXZ;
        if (localObject1 != null)
        {
          localObject1 = ((BaseWebViewController)localObject1).getJsapi();
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.webview.jsapi.j)localObject1).iF("onCreate", parama.XoV.extData);
          }
        }
      }
      if (parama.iCe().Xrt != null)
      {
        parama.bl(parama.iCe().Xrt);
        parama.atr(parama.iCe().Xrv);
      }
      localObject1 = parama.Xpb;
      if (localObject1 != null)
      {
        if (parama.iCe().Xru) {
          break label1246;
        }
        bool1 = bool2;
        label915:
        ((NestedBounceView)localObject1).setBounce(bool1);
      }
      localObject1 = parama.iCe();
      localObject3 = parama.hOx;
      kotlin.g.b.s.u(localObject3, "context");
      ((s)localObject1).context = new WeakReference(localObject3);
      localObject1 = parama.iCe();
      localObject3 = (com.tencent.mm.plugin.webview.core.b)parama;
      kotlin.g.b.s.u(localObject3, "context");
      ((s)localObject1).Xrs = new WeakReference(localObject3);
      localObject1 = parama.GXZ;
      if (localObject1 != null)
      {
        localObject1 = ((BaseWebViewController)localObject1).getJsapi();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.webview.jsapi.j)localObject1).WDH = ((com.tencent.mm.plugin.webview.stub.f)parama.iCe());
        }
      }
      localObject3 = parama.webView;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("webView");
        localObject1 = null;
      }
      ((MMWebView)localObject1).setOverScrollMode(2);
      localObject1 = parama.webView;
      if (localObject1 != null) {
        break label1251;
      }
      kotlin.g.b.s.bIx("webView");
      localObject1 = localObject2;
    }
    label1158:
    label1161:
    label1230:
    label1236:
    label1241:
    label1246:
    label1251:
    for (;;)
    {
      localObject1 = ((MMWebView)localObject1).getWebViewUI();
      if ((localObject1 instanceof XWalkView)) {
        ((XWalkView)localObject1).setCustomOnOverScrolledListener((XWalkView.OverScrolledListener)new c(parama));
      }
      localObject1 = parama.Xpb;
      if (localObject1 != null)
      {
        ((NestedBounceView)localObject1).setCustomNestedChild((g)new d(parama));
        ((NestedBounceView)localObject1).a((f.a)new e());
      }
      AppMethodBeat.o(298168);
      return;
      break;
      if (!com.tencent.mm.plugin.webview.k.l.bmX((String)localObject3))
      {
        Log.w("MicroMsg.WebViewControllerPreloadMrg", "addToCache, url=" + (String)localObject3 + " has cached!");
        bool1 = false;
        break label329;
      }
      ((Map)com.tencent.mm.plugin.webview.k.l.Xtg).put(localObject3, localObject1);
      bool1 = true;
      break label329;
      i = 0;
      break label482;
      localObject1 = null;
      break label655;
      i = 0;
      break label776;
      i = 0;
      break label818;
      bool1 = false;
      break label915;
    }
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(298147);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    parama.irV();
    parama.iyY();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(298147);
  }
  
  private static final boolean a(a parama, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(298171);
    kotlin.g.b.s.u(parama, "this$0");
    parama.iCc();
    AppMethodBeat.o(298171);
    return true;
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(298173);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    localObject = parama.Xpg;
    if (localObject != null)
    {
      paramView = parama.webView;
      parama = paramView;
      if (paramView == null)
      {
        kotlin.g.b.s.bIx("webView");
        parama = null;
      }
      parama.getUrl();
      ((u)localObject).dcJ();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(298173);
  }
  
  private static final void c(a parama, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(298178);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    localObject2 = parama.webView;
    paramView = (View)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("webView");
      paramView = null;
    }
    if (paramView.canGoBack()) {
      if (parama.XoV.Xps != 1)
      {
        if (parama.XoV.Xps != 0) {
          break label197;
        }
        paramView = parama.XoZ;
        if (paramView == null)
        {
          paramView = null;
          if (!kotlin.g.b.s.a(paramView, 180.0F)) {
            break label197;
          }
        }
      }
      else
      {
        parama = parama.webView;
        if (parama != null) {
          break label194;
        }
        kotlin.g.b.s.bIx("webView");
        parama = localObject1;
        label150:
        parama.goBack();
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(298178);
      return;
      paramView = Float.valueOf(paramView.getRotation());
      break;
      label194:
      break label150;
      label197:
      parama.cancel();
    }
  }
  
  private final com.tencent.mm.ui.f.b iBZ()
  {
    AppMethodBeat.i(298115);
    com.tencent.mm.ui.f.b localb = (com.tencent.mm.ui.f.b)this.Xpd.getValue();
    AppMethodBeat.o(298115);
    return localb;
  }
  
  private final b iCd()
  {
    AppMethodBeat.i(298142);
    b localb = (b)this.Xpi.getValue();
    AppMethodBeat.o(298142);
    return localb;
  }
  
  private final void irV()
  {
    AppMethodBeat.i(298131);
    Object localObject = this.GXZ;
    if (localObject != null) {
      ((BaseWebViewController)localObject).irV();
    }
    if (this.WXQ != null)
    {
      localObject = this.WXQ;
      kotlin.g.b.s.checkNotNull(localObject);
      ((View)localObject).setVisibility(8);
    }
    AppMethodBeat.o(298131);
  }
  
  private void iyY()
  {
    AppMethodBeat.i(298137);
    ProgressBar localProgressBar = this.progressBar;
    if (localProgressBar != null) {
      localProgressBar.setVisibility(0);
    }
    AppMethodBeat.o(298137);
  }
  
  private final void updateView()
  {
    AppMethodBeat.i(298121);
    Object localObject = ao.mX(getContext());
    int i;
    if (localObject != null)
    {
      i = kotlin.k.k.qv(((ao.a)localObject).width, ((ao.a)localObject).height);
      localObject = this.XoW;
      if (localObject != null) {
        break label71;
      }
    }
    label71:
    for (localObject = null;; localObject = ((View)localObject).getLayoutParams())
    {
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).width = i;
      }
      View localView = this.XoW;
      if (localView != null) {
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(298121);
      return;
    }
  }
  
  public final void a(u paramu)
  {
    AppMethodBeat.i(298334);
    kotlin.g.b.s.u(paramu, "callback");
    this.Xpg = paramu;
    AppMethodBeat.o(298334);
  }
  
  public final void atr(int paramInt)
  {
    AppMethodBeat.i(298288);
    NestedBounceView localNestedBounceView = this.Xpb;
    if (localNestedBounceView != null) {
      localNestedBounceView.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(298288);
  }
  
  public final void ats(int paramInt)
  {
    AppMethodBeat.i(298292);
    BaseWebViewController localBaseWebViewController = this.GXZ;
    if (localBaseWebViewController != null) {
      localBaseWebViewController.atq(paramInt);
    }
    AppMethodBeat.o(298292);
  }
  
  final void auS(int paramInt)
  {
    AppMethodBeat.i(298260);
    Object localObject = this.Xpa;
    if (localObject != null) {
      ((View)localObject).setBackgroundColor(paramInt);
    }
    C(this.XoW, this.Xpe);
    if (bb.aAG(paramInt))
    {
      if (this.XoV.rvh)
      {
        localObject = this.XoY;
        if (localObject != null) {
          ((View)localObject).setBackgroundResource(com.tencent.mm.plugin.ba.a.b.webview_half_screen_arrow_round_light_bg);
        }
      }
      for (;;)
      {
        localObject = this.XoZ;
        if (localObject != null) {
          ((WeImageView)localObject).setIconColor(com.tencent.mm.cd.a.w(getContext(), com.tencent.mm.plugin.ba.a.a.UN_BW_0_Alpha_0_9));
        }
        localObject = this.Xpc;
        if (localObject == null) {
          break;
        }
        ((WeImageView)localObject).setIconColor(com.tencent.mm.cd.a.w(getContext(), com.tencent.mm.plugin.ba.a.a.UN_BW_0_Alpha_0_9));
        AppMethodBeat.o(298260);
        return;
        localObject = this.XoY;
        if (localObject != null) {
          ((View)localObject).setBackgroundResource(com.tencent.mm.plugin.ba.a.b.webview_half_screen_arrow_light_bg);
        }
      }
    }
    if (this.XoV.rvh)
    {
      localObject = this.XoY;
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(com.tencent.mm.plugin.ba.a.b.webview_half_screen_arrow_round_bg);
      }
    }
    for (;;)
    {
      localObject = this.XoZ;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(com.tencent.mm.cd.a.w(getContext(), com.tencent.mm.plugin.ba.a.a.BW_100_Alpha_0_9));
      }
      localObject = this.Xpc;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(com.tencent.mm.cd.a.w(getContext(), com.tencent.mm.plugin.ba.a.a.BW_100_Alpha_0_9));
      }
      AppMethodBeat.o(298260);
      return;
      localObject = this.XoY;
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(com.tencent.mm.plugin.ba.a.b.webview_half_screen_arrow_bg);
      }
    }
  }
  
  public final View bZy()
  {
    AppMethodBeat.i(298311);
    View localView = LayoutInflater.from(getContext()).inflate(com.tencent.mm.plugin.ba.a.d.webview_half_screen_dialog_layout, null);
    kotlin.g.b.s.s(localView, "from(context).inflate(R.…reen_dialog_layout, null)");
    AppMethodBeat.o(298311);
    return localView;
  }
  
  public final void bl(Bundle paramBundle)
  {
    AppMethodBeat.i(298277);
    if (paramBundle == null)
    {
      AppMethodBeat.o(298277);
      return;
    }
    int i;
    if (paramBundle.getBoolean("set_navigation_bar_color_reset", false)) {
      i = iCb();
    }
    for (int j = 255;; j = paramBundle.getInt("set_navigation_bar_color_alpha"))
    {
      auS(i & 0xFFFFFF | j << 24);
      AppMethodBeat.o(298277);
      return;
      i = paramBundle.getInt("set_navigation_bar_color_color");
    }
  }
  
  final void d(WebView paramWebView)
  {
    int i = 1;
    AppMethodBeat.i(298323);
    if (this.XoV.Xps == 0)
    {
      if ((paramWebView != null) && (paramWebView.canGoBack() == true)) {}
      while (i != 0)
      {
        paramWebView = this.XoZ;
        if (paramWebView == null) {
          break label78;
        }
        paramWebView.setRotation(180.0F);
        AppMethodBeat.o(298323);
        return;
        i = 0;
      }
      paramWebView = this.XoZ;
      if (paramWebView != null) {
        paramWebView.setRotation(90.0F);
      }
    }
    label78:
    AppMethodBeat.o(298323);
  }
  
  public final void dG()
  {
    AppMethodBeat.i(298320);
    Object localObject = jBi();
    if (localObject != null)
    {
      localObject = ((View)localObject).getViewTreeObserver();
      if (localObject != null) {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new f(this));
      }
    }
    AppMethodBeat.o(298320);
  }
  
  public final int fcr()
  {
    AppMethodBeat.i(298316);
    int i = (int)(com.tencent.mm.cd.a.mt(getContext()) * (1.0F - this.XoV.heightPercent));
    AppMethodBeat.o(298316);
    return i;
  }
  
  final int iCa()
  {
    AppMethodBeat.i(298269);
    int i = com.tencent.mm.cd.a.w(getContext(), com.tencent.mm.plugin.ba.a.a.white);
    AppMethodBeat.o(298269);
    return i;
  }
  
  final int iCb()
  {
    AppMethodBeat.i(298273);
    if (this.WGL)
    {
      i = com.tencent.mm.cd.a.w(getContext(), com.tencent.mm.plugin.ba.a.a.white_transparent_color);
      AppMethodBeat.o(298273);
      return i;
    }
    int i = com.tencent.mm.cd.a.w(getContext(), com.tencent.mm.plugin.ba.a.a.white);
    AppMethodBeat.o(298273);
    return i;
  }
  
  public final void iCc()
  {
    AppMethodBeat.i(298307);
    this.Xph.dead();
    mi localmi = new mi();
    localmi.hOw.hOx = this.hOx;
    if (localmi.publish())
    {
      com.tencent.luggage.l.c.a(200L, (kotlin.g.a.a)new g(this));
      AppMethodBeat.o(298307);
      return;
    }
    cancel();
    AppMethodBeat.o(298307);
  }
  
  public final s iCe()
  {
    AppMethodBeat.i(298331);
    s locals = (s)this.Xpk.getValue();
    AppMethodBeat.o(298331);
    return locals;
  }
  
  public final void initContentView()
  {
    AppMethodBeat.i(298254);
    Log.i("MicroMsg.HalfScreenWebView", "initContentView url= " + this.url + " heightPercent=" + this.XoV.heightPercent + " reuse=" + this.XoV.Xpr);
    bU();
    super.initContentView();
    setCanceledOnTouchOutside(true);
    Object localObject1 = getWindow();
    if (localObject1 != null) {
      ((Window)localObject1).addFlags(100729856);
    }
    localObject1 = getWindow();
    if (localObject1 != null) {
      ((Window)localObject1).setDimAmount(0.0F);
    }
    label164:
    int i;
    if (1 == this.XoV.icP)
    {
      localObject1 = getWindow();
      if (localObject1 != null) {
        ((Window)localObject1).setWindowAnimations(a.l.RightToLeftAnimation);
      }
      localObject1 = getWindow();
      if (localObject1 != null)
      {
        View localView = ((Window)localObject1).getDecorView();
        if (localView != null)
        {
          localObject1 = localView.getContext();
          if (localObject1 != null) {
            break label496;
          }
          localObject1 = null;
          if (localObject1 != null) {
            break label535;
          }
          i = com.tencent.mm.cd.a.ms(localView.getContext());
          label176:
          localView.setMinimumWidth(i);
          localView.setPadding(0, 0, 0, 0);
        }
      }
      localObject1 = getWindow();
      if (localObject1 != null)
      {
        localObject1 = ((Window)localObject1).getAttributes();
        if (localObject1 != null)
        {
          ((WindowManager.LayoutParams)localObject1).width = -1;
          ((WindowManager.LayoutParams)localObject1).height = -1;
          ((WindowManager.LayoutParams)localObject1).gravity = 80;
        }
      }
      if ((this.hOx instanceof MMActivity))
      {
        localObject1 = this.hOx;
        if (!(localObject1 instanceof MMActivity)) {
          break label543;
        }
        localObject1 = (MMActivity)localObject1;
        label250:
        if (localObject1 != null) {
          ((MMActivity)localObject1).addOnConfigurationChangedListener((MMActivity.b)this);
        }
      }
      localObject1 = jBk();
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = jBj();
      if (localObject1 != null) {
        break label548;
      }
      localObject1 = null;
      label288:
      this.XoX = ((View)localObject1);
      localObject1 = jBj();
      if (localObject1 != null) {
        break label559;
      }
      localObject1 = null;
      label304:
      this.XoW = ((View)localObject1);
      localObject1 = jBj();
      if (localObject1 != null) {
        break label570;
      }
      localObject1 = null;
      label320:
      this.XoY = ((View)localObject1);
      localObject1 = jBj();
      if (localObject1 != null) {
        break label581;
      }
      localObject1 = null;
      label336:
      this.XoZ = ((WeImageView)localObject1);
      localObject1 = jBj();
      if (localObject1 != null) {
        break label595;
      }
      localObject1 = null;
      label352:
      this.Xpa = ((View)localObject1);
      localObject1 = jBj();
      if (localObject1 != null) {
        break label606;
      }
      localObject1 = null;
      label368:
      this.Xpb = ((NestedBounceView)localObject1);
      localObject1 = jBj();
      if (localObject1 != null) {
        break label620;
      }
      localObject1 = null;
      label384:
      this.progressBar = ((ProgressBar)localObject1);
      localObject1 = jBj();
      if (localObject1 != null) {
        break label634;
      }
      localObject1 = null;
      label400:
      this.WXQ = ((View)localObject1);
      localObject1 = jBj();
      if (localObject1 != null) {
        break label645;
      }
      localObject1 = null;
      label416:
      this.Xpc = ((WeImageView)localObject1);
      if (!this.XoV.Xpt) {
        break label659;
      }
      this.WGL = true;
      label436:
      if (this.WGL) {
        break label727;
      }
      localObject1 = this.Xpb;
      if (localObject1 != null) {
        break label708;
      }
    }
    label535:
    label543:
    label548:
    label559:
    label570:
    label708:
    for (localObject1 = null;; localObject2 = localException.getLayoutParams())
    {
      for (;;)
      {
        if (localObject1 != null) {
          break label716;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(298254);
        throw ((Throwable)localObject1);
        localObject1 = getWindow();
        if (localObject1 == null) {
          break;
        }
        ((Window)localObject1).setWindowAnimations(a.l.BottomToTopSlowAnimation);
        break;
        label496:
        localObject1 = ((Context)localObject1).getResources();
        if (localObject1 == null)
        {
          localObject1 = null;
          break label164;
        }
        localObject1 = ((Resources)localObject1).getDisplayMetrics();
        if (localObject1 == null)
        {
          localObject1 = null;
          break label164;
        }
        localObject1 = Integer.valueOf(((DisplayMetrics)localObject1).widthPixels);
        break label164;
        i = ((Integer)localObject1).intValue();
        break label176;
        localObject1 = null;
        break label250;
        localObject1 = ((View)localObject1).findViewById(com.tencent.mm.plugin.ba.a.c.webview_half_screen_arrow_layout);
        break label288;
        localObject1 = ((View)localObject1).findViewById(com.tencent.mm.plugin.ba.a.c.webview_half_screen_content_view);
        break label304;
        localObject1 = ((View)localObject1).findViewById(com.tencent.mm.plugin.ba.a.c.webview_half_screen_arrow_container_layout);
        break label320;
        label581:
        localObject1 = (WeImageView)((View)localObject1).findViewById(com.tencent.mm.plugin.ba.a.c.webview_half_screen_arrow_icon);
        break label336;
        label595:
        localObject1 = ((View)localObject1).findViewById(com.tencent.mm.plugin.ba.a.c.webview_half_screen_title_bar_layout);
        break label352;
        label606:
        localObject1 = (NestedBounceView)((View)localObject1).findViewById(com.tencent.mm.plugin.ba.a.c.webview_half_screen_wv_container_layout);
        break label368;
        label620:
        localObject1 = (ProgressBar)((View)localObject1).findViewById(com.tencent.mm.plugin.ba.a.c.webview_half_screen_create_progress_bar);
        break label384;
        label634:
        localObject1 = ((View)localObject1).findViewById(com.tencent.mm.plugin.ba.a.c.webview_half_screen_refresh_mask);
        break label400;
        localObject1 = (WeImageView)((View)localObject1).findViewById(com.tencent.mm.plugin.ba.a.c.webview_half_screen_arrow_more);
        break label416;
        try
        {
          this.WGL = kotlin.g.b.s.p(Util.nullAsNil(Uri.parse(this.url).getQueryParameter("immersiveUIStyle")), "1");
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.HalfScreenWebView", kotlin.g.b.s.X("initImmersiveStyle ex ", localException.getMessage()));
        }
      }
      break label436;
    }
    label645:
    label659:
    label716:
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, com.tencent.mm.plugin.ba.a.c.webview_half_screen_title_bar_layout);
    label727:
    updateView();
    Object localObject2 = jBj();
    if (localObject2 != null) {
      ((View)localObject2).setOnTouchListener(new a..ExternalSyntheticLambda3(this));
    }
    if ((this.XoV.rvh) && (this.XoV.Xps != -1))
    {
      localObject2 = this.Xpc;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setVisibility(0);
      }
      o.F((View)this.Xpc, 0.5F);
      localObject2 = this.Xpc;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setOnClickListener(new a..ExternalSyntheticLambda0(this));
      }
      if (this.XoV.Xps == -1) {
        break label981;
      }
      localObject2 = this.XoX;
      if (localObject2 != null) {
        break label884;
      }
    }
    label884:
    for (localObject2 = null;; localObject2 = ((View)localObject2).getLayoutParams())
    {
      if (localObject2 != null) {
        break label892;
      }
      localObject2 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(298254);
      throw ((Throwable)localObject2);
      localObject2 = this.Xpc;
      if (localObject2 == null) {
        break;
      }
      ((WeImageView)localObject2).setVisibility(8);
      break;
    }
    label892:
    ((RelativeLayout.LayoutParams)localObject2).removeRule(14);
    localObject2 = this.XoY;
    if (localObject2 == null)
    {
      localObject2 = null;
      if (!(localObject2 instanceof FrameLayout.LayoutParams)) {
        break label1078;
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      label924:
      if (localObject2 != null)
      {
        ((FrameLayout.LayoutParams)localObject2).width = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
        ((FrameLayout.LayoutParams)localObject2).height = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
      }
      if (this.XoV.Xps != 1) {
        break label1083;
      }
      localObject2 = this.XoZ;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setRotation(180.0F);
      }
    }
    for (;;)
    {
      label981:
      localObject2 = this.XoX;
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener(new a..ExternalSyntheticLambda2(this));
      }
      auS(iCb());
      atr(iCa());
      localObject2 = this.WXQ;
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener(new a..ExternalSyntheticLambda1(this));
      }
      this.Xph.alive();
      com.tencent.threadpool.h.ahAA.bk(new a..ExternalSyntheticLambda4(this));
      AppMethodBeat.o(298254);
      return;
      localObject2 = ((View)localObject2).getLayoutParams();
      break;
      label1078:
      localObject2 = null;
      break label924;
      label1083:
      localObject2 = this.XoZ;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setRotation(90.0F);
      }
    }
  }
  
  public final void isg()
  {
    AppMethodBeat.i(298282);
    cancel();
    AppMethodBeat.o(298282);
  }
  
  public final void ish()
  {
    AppMethodBeat.i(298328);
    NestedBounceView localNestedBounceView = this.Xpb;
    if (localNestedBounceView != null) {
      localNestedBounceView.setBounce(false);
    }
    AppMethodBeat.o(298328);
  }
  
  public final void iyW()
  {
    AppMethodBeat.i(298296);
    View localView = this.WXQ;
    if (localView != null) {
      localView.setVisibility(0);
    }
    iyX();
    AppMethodBeat.o(298296);
  }
  
  public final void iyX()
  {
    AppMethodBeat.i(298299);
    ProgressBar localProgressBar = this.progressBar;
    if ((localProgressBar != null) && (localProgressBar.getVisibility() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localProgressBar = this.progressBar;
        if (localProgressBar != null) {
          localProgressBar.setVisibility(8);
        }
      }
      AppMethodBeat.o(298299);
      return;
    }
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(298304);
    super.onDismiss();
    this.Xph.dead();
    if ((this.hOx instanceof MMActivity)) {
      ((MMActivity)this.hOx).removeOnConfigurationChangedListener((MMActivity.b)this);
    }
    Object localObject = this.GXZ;
    if (localObject != null)
    {
      localObject = ((BaseWebViewController)localObject).getJsapi();
      if (localObject != null) {
        ((com.tencent.mm.plugin.webview.jsapi.j)localObject).iF("onDestroy", this.XoV.extData);
      }
    }
    localObject = iCd();
    ((b)localObject).getController().b((m)localObject);
    ((b)localObject).getController().b((com.tencent.mm.plugin.webview.core.h)((b)localObject).Xpo);
    this.Xpg = null;
    MMWebView localMMWebView = this.webView;
    localObject = localMMWebView;
    if (localMMWebView == null)
    {
      kotlin.g.b.s.bIx("webView");
      localObject = null;
    }
    localObject = ((MMWebView)localObject).getParent();
    if ((localObject instanceof ViewGroup)) {}
    for (localObject = (ViewGroup)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewGroup)localObject).removeAllViews();
      }
      if ((!this.XoV.Xpr) || (!this.Xpf))
      {
        localMMWebView = this.webView;
        localObject = localMMWebView;
        if (localMMWebView == null)
        {
          kotlin.g.b.s.bIx("webView");
          localObject = null;
        }
        ((MMWebView)localObject).destroy();
        localObject = this.GXZ;
        if (localObject != null) {
          ((BaseWebViewController)localObject).onDestroy();
        }
      }
      localObject = this.GXZ;
      if (localObject != null) {
        ((BaseWebViewController)localObject).Wwp = null;
      }
      Log.i("MicroMsg.HalfScreenWebView", "onDismiss url= " + this.url + " cacheController=" + this.Xpf);
      AppMethodBeat.o(298304);
      return;
    }
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(298265);
    super.onWindowFocusChanged(paramBoolean);
    Log.d("MicroMsg.HalfScreenWebView", kotlin.g.b.s.X("onWindowFocusChanged hasFocus=", Boolean.valueOf(paramBoolean)));
    Object localObject = this.GXZ;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((BaseWebViewController)localObject).getJsapi())
    {
      if (localObject != null)
      {
        localObject = this.GXZ;
        if (localObject != null)
        {
          localObject = ((BaseWebViewController)localObject).getJsapi();
          if (localObject != null) {
            ((com.tencent.mm.plugin.webview.jsapi.j)localObject).bB(paramBoolean, true);
          }
        }
      }
      AppMethodBeat.o(298265);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView$Companion;", "", "()V", "TAG", "", "backRotation", "", "downRotation", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/dialog/HalfScreenDialogDragHelper;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.ui.f.b>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView$initOverScrollMode$1", "Lorg/xwalk/core/XWalkView$OverScrolledListener;", "onOverScrolled", "", "value", "", "scrollX", "", "scrollY", "clampedX", "clampedY", "webContentView", "Landroid/view/View;", "overScrollBy", "deltaX", "deltaY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements XWalkView.OverScrolledListener
  {
    c(a parama) {}
    
    public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
    {
      Object localObject2 = null;
      AppMethodBeat.i(297932);
      Object localObject3;
      Object localObject1;
      if (paramInt2 > 0)
      {
        localObject3 = a.e(this.Xpm);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("webView");
          localObject1 = null;
        }
        if ((paramInt2 > ((MMWebView)localObject1).getWebScrollY()) && (paramBoolean2))
        {
          localObject3 = this.Xpm;
          localObject1 = a.e((a)localObject3);
          if (localObject1 != null) {
            break label177;
          }
          kotlin.g.b.s.bIx("webView");
          localObject1 = localObject2;
        }
      }
      label177:
      for (;;)
      {
        a.a((a)localObject3, paramInt2 - ((MMWebView)localObject1).getWebScrollY());
        if (Log.getLogLevel() <= 0) {
          Log.d("MicroMsg.HalfScreenWebView", "onOverScrolled() called with: scrollX = " + paramInt1 + ", scrollY = " + paramInt2 + ", clampedX = " + paramBoolean1 + ", clampedY = " + paramBoolean2 + ", webContentView = " + paramView + ", xwScrollGap = " + a.f(this.Xpm));
        }
        AppMethodBeat.o(297932);
        return;
      }
    }
    
    public final void onOverScrolled(boolean paramBoolean)
    {
      AppMethodBeat.i(297929);
      if (Log.getLogLevel() <= 0) {
        Log.d("MicroMsg.HalfScreenWebView", kotlin.g.b.s.X("onOverScrolled() called with: value = ", Boolean.valueOf(paramBoolean)));
      }
      AppMethodBeat.o(297929);
    }
    
    public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
    {
      AppMethodBeat.i(297936);
      if (Log.getLogLevel() <= 0) {
        Log.d("MicroMsg.HalfScreenWebView", "overScrollBy() called with: deltaX = " + paramInt1 + ", deltaY = " + paramInt2 + ", scrollX = " + paramInt3 + ", scrollY = " + paramInt4 + ", scrollRangeX = " + paramInt5 + ", scrollRangeY = " + paramInt6 + ", maxOverScrollX = " + paramInt7 + ", maxOverScrollY = " + paramInt8 + ", isTouchEvent = " + paramBoolean + ", webContentView = " + paramView);
      }
      AppMethodBeat.o(297936);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView$initOverScrollMode$2$1", "Lcom/tencent/mm/ui/widget/pulldown/ICustomNestedChild;", "customView", "Landroid/view/View;", "isAtEnd", "", "isAtStart", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements g
  {
    d(a parama) {}
    
    public final boolean aau()
    {
      Object localObject2 = null;
      AppMethodBeat.i(297957);
      MMWebView localMMWebView = a.e(this.Xpm);
      Object localObject1 = localMMWebView;
      if (localMMWebView == null)
      {
        kotlin.g.b.s.bIx("webView");
        localObject1 = null;
      }
      int i = ((MMWebView)localObject1).getMeasuredHeight();
      localMMWebView = a.e(this.Xpm);
      localObject1 = localMMWebView;
      if (localMMWebView == null)
      {
        kotlin.g.b.s.bIx("webView");
        localObject1 = null;
      }
      int k = ((MMWebView)localObject1).getWebScrollY();
      int m = a.f(this.Xpm);
      localMMWebView = a.e(this.Xpm);
      localObject1 = localMMWebView;
      if (localMMWebView == null)
      {
        kotlin.g.b.s.bIx("webView");
        localObject1 = null;
      }
      int j = ((MMWebView)localObject1).getScrollHeight();
      boolean bool;
      if (i + (m + k) >= j)
      {
        bool = true;
        if (Log.getLogLevel() <= 0)
        {
          localMMWebView = a.e(this.Xpm);
          localObject1 = localMMWebView;
          if (localMMWebView == null)
          {
            kotlin.g.b.s.bIx("webView");
            localObject1 = null;
          }
          k = ((MMWebView)localObject1).getContentHeight();
          localObject1 = a.e(this.Xpm);
          if (localObject1 != null) {
            break label266;
          }
          kotlin.g.b.s.bIx("webView");
          localObject1 = localObject2;
        }
      }
      label266:
      for (;;)
      {
        Log.d("MicroMsg.HalfScreenWebView", "isOverScrollEnd ContentHeight:%s, WebScrollY:%s, ScrollHeight:%s, MeasuredHeight:%s, gap:%s, res:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(((MMWebView)localObject1).getWebScrollY()), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(a.f(this.Xpm)), Boolean.valueOf(bool) });
        AppMethodBeat.o(297957);
        return bool;
        bool = false;
        break;
      }
    }
    
    public final boolean grG()
    {
      Object localObject2 = null;
      AppMethodBeat.i(297952);
      MMWebView localMMWebView = a.e(this.Xpm);
      Object localObject1 = localMMWebView;
      if (localMMWebView == null)
      {
        kotlin.g.b.s.bIx("webView");
        localObject1 = null;
      }
      localObject1 = ((MMWebView)localObject1).getWebViewUI();
      kotlin.g.b.s.s(localObject1, "webView.webViewUI");
      boolean bool;
      if ((localObject1 instanceof XWalkView))
      {
        if (((XWalkView)localObject1).computeVerticalScrollOffset() == 0) {}
        for (bool = true;; bool = false)
        {
          if (Log.getLogLevel() <= 1) {
            Log.d("MicroMsg.HalfScreenWebView", kotlin.g.b.s.X("isAtStart() called res:", Boolean.valueOf(bool)));
          }
          AppMethodBeat.o(297952);
          return bool;
        }
      }
      localObject1 = a.e(this.Xpm);
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("webView");
        localObject1 = localObject2;
      }
      for (;;)
      {
        bool = ((MMWebView)localObject1).isOverScrollStart();
        break;
      }
    }
    
    public final View iCf()
    {
      AppMethodBeat.i(297945);
      MMWebView localMMWebView = a.e(this.Xpm);
      Object localObject = localMMWebView;
      if (localMMWebView == null)
      {
        kotlin.g.b.s.bIx("webView");
        localObject = null;
      }
      localObject = (View)localObject;
      AppMethodBeat.o(297945);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView$initOverScrollMode$2$2", "Lcom/tencent/mm/ui/widget/pulldown/IBounceView$BounceOffsetChangedListener;", "onBounceOffsetChanged", "", "offset", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements f.a
  {
    public final void Wm(int paramInt) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView$onConfigurationChanged$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "counter", "", "onGlobalLayout", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private int evg;
    
    f(a parama) {}
    
    private static final void h(a parama)
    {
      AppMethodBeat.i(297927);
      kotlin.g.b.s.u(parama, "this$0");
      a.c(parama);
      a.d(parama);
      parama = a.b(parama);
      if (parama != null) {
        parama.requestLayout();
      }
      AppMethodBeat.o(297927);
    }
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(297934);
      this.evg += 1;
      if (this.evg < 2)
      {
        AppMethodBeat.o(297934);
        return;
      }
      Object localObject = a.b(this.Xpm);
      if (localObject != null)
      {
        localObject = ((View)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      a.c(this.Xpm);
      localObject = a.b(this.Xpm);
      if (localObject != null) {
        ((View)localObject).post(new a.f..ExternalSyntheticLambda0(this.Xpm));
      }
      AppMethodBeat.o(297934);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView$roundCorner$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends ViewOutlineProvider
  {
    h(float paramFloat) {}
    
    public final void getOutline(View paramView, Outline paramOutline)
    {
      AppMethodBeat.i(297940);
      kotlin.g.b.s.u(paramView, "view");
      kotlin.g.b.s.u(paramOutline, "outline");
      paramOutline.setRoundRect(0, 0, paramView.getWidth(), (int)(paramView.getHeight() + this.vtJ), this.vtJ);
      AppMethodBeat.o(297940);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/PreloadWebViewStubCallback;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<s>
  {
    i(String paramString, a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView$webViewControllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onBinded", "", "onJsReady", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    extends com.tencent.mm.plugin.webview.core.l
  {
    j(a parama) {}
    
    public final void cxT()
    {
      AppMethodBeat.i(297942);
      super.cxT();
      Object localObject = this.Xpm.GXZ;
      if (localObject != null)
      {
        localObject = ((BaseWebViewController)localObject).getJsapi();
        if (localObject != null) {
          ((com.tencent.mm.plugin.webview.jsapi.j)localObject).iF("onCreate", this.Xpm.XoV.extData);
        }
      }
      AppMethodBeat.o(297942);
    }
    
    public final void cxX()
    {
      AppMethodBeat.i(297937);
      try
      {
        Object localObject1 = this.Xpm.GXZ;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = ((BaseWebViewController)localObject1).irJ();
          if (localObject1 != null)
          {
            localObject2 = this.Xpm.GXZ;
            if (localObject2 != null) {
              break label116;
            }
            i = 0;
            ((e)localObject1).auf(i);
          }
        }
        localObject1 = this.Xpm.GXZ;
        BaseWebViewController localBaseWebViewController;
        if (localObject1 != null)
        {
          localObject1 = ((BaseWebViewController)localObject1).irJ();
          if (localObject1 != null)
          {
            localObject2 = (com.tencent.mm.plugin.webview.stub.f)this.Xpm.iCe();
            localBaseWebViewController = this.Xpm.GXZ;
            if (localBaseWebViewController != null) {
              break label124;
            }
          }
        }
        label116:
        label124:
        for (int i = 0;; i = localBaseWebViewController.irL())
        {
          ((e)localObject1).a((com.tencent.mm.plugin.webview.stub.f)localObject2, i);
          a.g(this.Xpm);
          AppMethodBeat.o(297937);
          return;
          i = ((BaseWebViewController)localObject2).irL();
          break;
        }
        return;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.HalfScreenWebView", localThrowable, "alvinluo initWebViewController exception", new Object[0]);
        AppMethodBeat.o(297937);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebViewInterceptor;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<b>
  {
    k(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.a
 * JD-Core Version:    0.7.0.1
 */