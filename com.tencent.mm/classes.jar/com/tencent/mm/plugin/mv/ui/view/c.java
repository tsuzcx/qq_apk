package com.tencent.mm.plugin.mv.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.mv.b.c;
import com.tencent.mm.plugin.mv.model.a.m;
import com.tencent.mm.plugin.mv.model.o;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog;", "", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "MARGIN4A", "", "cardHeight", "cardMarginTop", "getCardMarginTop", "()I", "setCardMarginTop", "(I)V", "cardWidth", "collapseLayout", "Lcom/tencent/mm/ui/blur/BlurView;", "kotlin.jvm.PlatformType", "getCollapseLayout", "()Lcom/tencent/mm/ui/blur/BlurView;", "collapseLayout$delegate", "Lkotlin/Lazy;", "copyrightFromTv", "Landroid/widget/TextView;", "getCopyrightFromTv", "()Landroid/widget/TextView;", "copyrightFromTv$delegate", "copyrightInfoLayout", "getCopyrightInfoLayout", "copyrightInfoLayout$delegate", "copyrightIv", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "getCopyrightIv", "()Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "copyrightIv$delegate", "coverAreaFl", "getCoverAreaFl", "()Landroid/view/ViewGroup;", "coverAreaFl$delegate", "coverIv", "Lcom/tencent/mm/ui/MMImageView;", "getCoverIv", "()Lcom/tencent/mm/ui/MMImageView;", "coverIv$delegate", "defaultCoverFl", "Landroid/view/View;", "getDefaultCoverFl", "()Landroid/view/View;", "defaultCoverFl$delegate", "dialogRootLayout", "Landroid/widget/FrameLayout;", "getDialogRootLayout", "()Landroid/widget/FrameLayout;", "dialogRootLayout$delegate", "h5Title", "getH5Title", "h5Title$delegate", "isDialogShow", "", "()Z", "setDialogShow", "(Z)V", "isShowH5Page", "jumpQQLayout", "getJumpQQLayout", "jumpQQLayout$delegate", "jumpView", "getJumpView", "jumpView$delegate", "lastWebViewScrollY", "layoutHeight", "getLayoutHeight", "setLayoutHeight", "layoutWidth", "getLayoutWidth", "setLayoutWidth", "listener", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$OnCloseBtnClickListener;", "maxTranslateY", "musicInfoNormalLL", "Landroid/widget/LinearLayout;", "getMusicInfoNormalLL", "()Landroid/widget/LinearLayout;", "musicInfoNormalLL$delegate", "musicInfoWithH5LL", "getMusicInfoWithH5LL", "musicInfoWithH5LL$delegate", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "musicNoWebViewRl", "Landroid/widget/RelativeLayout;", "getMusicNoWebViewRl", "()Landroid/widget/RelativeLayout;", "musicNoWebViewRl$delegate", "mvMainUIC", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC;", "getParent", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "progressBar$delegate", "singerTv", "getSingerTv", "singerTv$delegate", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "songInfoFullScreenRoot", "getSongInfoFullScreenRoot", "songInfoFullScreenRoot$delegate", "songNameTv", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "getSongNameTv", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "songNameTv$delegate", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "webViewCallback", "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$webViewCallback$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$webViewCallback$1;", "webViewClientListener", "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$webViewClientListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$webViewClientListener$1;", "webViewContainer", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "getWebViewContainer", "()Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "webViewContainer$delegate", "webViewController", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvWebViewController;", "webViewControllerListener", "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$webViewControllerListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$webViewControllerListener$1;", "webViewReady", "Landroidx/lifecycle/MutableLiveData;", "attachWebView", "", "hide", "isShow", "passParameters", "release", "reset", "roundCorner", "view", "cornerRadius", "", "setHtmlMaginTopOnWebViewReady", "setListener", "show", "showWebView", "mvOperationUrl", "", "startLoadUrl", "url", "updateMv", "Companion", "OnCloseBtnClickListener", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a Mja;
  public static final String TAG;
  public boo LWI;
  public com.tencent.mm.plugin.mv.model.f Mcj;
  private final int MjA;
  public int MjB;
  public x<Boolean> MjC;
  private final com.tencent.mm.plugin.mv.ui.uic.i MjD;
  public b MjE;
  public c.z MjF;
  public c.ab MjG;
  private c.y MjH;
  private final j Mjb;
  private final j Mjc;
  private final j Mjd;
  private final j Mje;
  private final j Mjf;
  private final j Mjg;
  private final j Mjh;
  private final j Mji;
  private final j Mjj;
  private final j Mjk;
  private final j Mjl;
  private final j Mjm;
  private final j Mjn;
  private final j Mjo;
  private final j Mjp;
  private final j Mjq;
  private final j Mjr;
  private final j Mjs;
  private final j Mjt;
  public e Mju;
  public int Mjv;
  private int Mjw;
  private int Mjx;
  public boolean Mjy;
  public boolean Mjz;
  public int afd;
  public int layoutWidth;
  public final ViewGroup parent;
  public int uGn;
  public MMWebView webView;
  
  static
  {
    AppMethodBeat.i(287062);
    Mja = new c.a((byte)0);
    TAG = kotlin.g.b.s.X("MicroMsg.Mv.MusicMvSongInfoDialog@", Integer.valueOf(Mja.hashCode()));
    AppMethodBeat.o(287062);
  }
  
  public c(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(286936);
    this.parent = paramViewGroup;
    this.Mjb = kotlin.k.cm((kotlin.g.a.a)new w(this));
    this.Mjc = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.Mjd = kotlin.k.cm((kotlin.g.a.a)new x(this));
    this.Mje = kotlin.k.cm((kotlin.g.a.a)new v(this));
    this.Mjf = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.Mjg = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.Mjh = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.Mji = kotlin.k.cm((kotlin.g.a.a)new q(this));
    this.Mjj = kotlin.k.cm((kotlin.g.a.a)new o(this));
    this.Mjk = kotlin.k.cm((kotlin.g.a.a)new p(this));
    this.Mjl = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Mjm = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.Mjn = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.Mjo = kotlin.k.cm((kotlin.g.a.a)new aa(this));
    this.Mjp = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.Mjq = kotlin.k.cm((kotlin.g.a.a)new s(this));
    this.Mjr = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.Mjs = kotlin.k.cm((kotlin.g.a.a)new m(this));
    this.Mjt = kotlin.k.cm((kotlin.g.a.a)new n(this));
    this.MjA = MMApplicationContext.getContext().getResources().getDimensionPixelSize(b.c.Edge_4A);
    this.MjC = new x();
    paramViewGroup = com.tencent.mm.ui.component.k.aeZF;
    paramViewGroup = this.parent.getContext();
    kotlin.g.b.s.s(paramViewGroup, "parent.context");
    paramViewGroup = com.tencent.mm.ui.component.k.nq(paramViewGroup).q(com.tencent.mm.plugin.mv.ui.uic.i.class);
    kotlin.g.b.s.s(paramViewGroup, "UICProvider.of(parent.co…sicMvMainUIC::class.java)");
    this.MjD = ((com.tencent.mm.plugin.mv.ui.uic.i)paramViewGroup);
    paramViewGroup = aw.iQ(this.parent.getContext());
    this.afd = paramViewGroup.y;
    this.layoutWidth = paramViewGroup.x;
    Object localObject = grL().getLayoutParams();
    this.Mjw = (this.layoutWidth - this.MjA);
    this.Mjx = (this.Mjw * 5 / 3);
    ((ViewGroup.LayoutParams)localObject).width = this.Mjw;
    ((ViewGroup.LayoutParams)localObject).height = this.Mjx;
    grL().setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.MjB = ((this.afd - this.Mjx) / 2);
    this.Mjv = this.MjB;
    localObject = grO().getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.Mjw;
    ((ViewGroup.LayoutParams)localObject).height = this.Mjw;
    grO().setLayoutParams((ViewGroup.LayoutParams)localObject);
    gsc().setOnClickListener(new c..ExternalSyntheticLambda1(this));
    grU().setOnClickListener(new c..ExternalSyntheticLambda2(this));
    grL().setAlpha(0.0F);
    grL().setTranslationY(-1.0F * this.MjB);
    Log.i(TAG, "init layout height:" + this.afd + ", screenSize:" + paramViewGroup);
    localObject = grP().getDrawable();
    paramViewGroup = gsa();
    if (paramViewGroup != null)
    {
      localObject = paramViewGroup.ad((ViewGroup)grL()).V((Drawable)localObject).b((com.tencent.mm.ui.blur.b)new com.tencent.mm.ui.blur.f(paramViewGroup.getContext())).eb(50.0F);
      ((BlurView)localObject).aedd = true;
      ((BlurView)localObject).Rx = com.tencent.mm.cd.a.br(paramViewGroup.getContext(), b.c.Edge_A);
      ((BlurView)localObject).joa();
    }
    paramViewGroup = gsa();
    if (paramViewGroup != null) {
      paramViewGroup.setOnClickListener(new c..ExternalSyntheticLambda0(this));
    }
    this.Mjy = false;
    this.MjF = new c.z(this);
    this.MjG = new c.ab(this);
    this.MjH = new c.y(this);
    AppMethodBeat.o(286936);
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(287007);
    kotlin.g.b.s.u(paramc, "this$0");
    Object localObject1 = new int[2];
    Object localObject2 = new int[2];
    paramc.grR().getLocationInWindow((int[])localObject1);
    paramc.grY().getLocationInWindow((int[])localObject2);
    int i = localObject2[1];
    int j = localObject1[1];
    int k = paramc.grY().getHeight();
    int m = com.tencent.mm.cd.a.fromDPToPix(paramc.parent.getContext(), 16);
    localObject1 = paramc.webView;
    if (localObject1 != null)
    {
      float f = (i - j + k + m) / ((MMWebView)localObject1).getMMDensity();
      localObject2 = "document.body.style.marginTop='" + f + "px';document.body.style.background='#ffffff'";
      ((MMWebView)localObject1).evaluateJavascript((String)localObject2, new c..ExternalSyntheticLambda3((String)localObject2, paramc, (MMWebView)localObject1));
    }
    AppMethodBeat.o(287007);
  }
  
  private static final void a(c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(286983);
    kotlin.g.b.s.u(paramc, "this$0");
    Log.v(TAG, "felixzhou onWebViewScrollChanged l: %d, t: %d, oldl: %d, oldt: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    paramc.uGn += paramInt2 - paramInt4;
    paramc.grR().scrollTo(0, paramInt2);
    AppMethodBeat.o(286983);
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(286957);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramc = paramc.MjD;
    paramView = com.tencent.mm.aw.a.bLn();
    localObject = com.tencent.mm.kernel.h.aZW();
    kotlin.g.b.s.s(paramView, "wrapper");
    ((com.tencent.mm.am.s)localObject).a((p)new m(paramView, paramc.getActivity().hashCode()), 0);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286957);
  }
  
  private static final void a(boo paramboo, c paramc, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(286965);
    kotlin.g.b.s.u(paramboo, "$songInfo");
    kotlin.g.b.s.u(paramc, "this$0");
    com.tencent.mm.plugin.mv.model.f localf = paramc.Mcj;
    if (localf != null)
    {
      Object localObject;
      if (paramBoolean1)
      {
        localObject = o.LYk;
        localObject = paramc.parent.getContext();
        kotlin.g.b.s.s(localObject, "parent.context");
        o.a((Context)localObject, paramboo, localf, 2, 1, 1);
      }
      if (paramBoolean2)
      {
        localObject = o.LYk;
        paramc = paramc.parent.getContext();
        kotlin.g.b.s.s(paramc, "parent.context");
        o.a(paramc, paramboo, localf, 2, 3, 1);
      }
    }
    AppMethodBeat.o(286965);
  }
  
  private static final void a(String paramString1, c paramc, MMWebView paramMMWebView, String paramString2)
  {
    AppMethodBeat.i(286998);
    kotlin.g.b.s.u(paramString1, "$strJs");
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramMMWebView, "$webView");
    Log.i(TAG, kotlin.g.b.s.X("setHtmlMaginTopOnWebViewReady, js:", paramString1));
    paramString1 = (View)paramMMWebView;
    float f = com.tencent.mm.cd.a.fromDPToPix(paramc.parent.getContext(), 24.0F);
    if (paramString1 != null) {
      paramString1.setOutlineProvider((ViewOutlineProvider)new c.t(f));
    }
    if (paramString1 != null) {
      paramString1.setClipToOutline(true);
    }
    paramMMWebView.setVisibility(0);
    paramMMWebView.animate().alpha(1.0F).setDuration(300L).start();
    paramc.grZ().setVisibility(8);
    AppMethodBeat.o(286998);
  }
  
  private static final void a(String paramString, e parame)
  {
    AppMethodBeat.i(286988);
    kotlin.g.b.s.u(paramString, "$url");
    Log.i(TAG, kotlin.g.b.s.X("startLoadUrl, url:", paramString));
    if (parame != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("useJs", true);
      paramString = ah.aiuX;
      parame.bJ(localIntent);
    }
    AppMethodBeat.o(286988);
  }
  
  private static final void b(c paramc, View paramView)
  {
    AppMethodBeat.i(286969);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramc);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    if (!paramc.Mjy)
    {
      Log.i(TAG, "copyrightInfoLayout.setOnClickListener, isShow:false, return ");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286969);
      return;
    }
    if (paramc.Mjz)
    {
      Log.i(TAG, "copyrightInfoLayout.setOnClickListener, hasH5Page = true, return ");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286969);
      return;
    }
    paramView = com.tencent.mm.ui.component.k.aeZF;
    paramView = paramc.parent.getContext();
    kotlin.g.b.s.s(paramView, "parent.context");
    paramView = ((com.tencent.mm.plugin.mv.ui.uic.e)com.tencent.mm.ui.component.k.nq(paramView).q(com.tencent.mm.plugin.mv.ui.uic.e.class)).LWI;
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = paramc.parent.getContext();
    kotlin.g.b.s.s(localObject1, "parent.context");
    int i = ((com.tencent.mm.plugin.mv.ui.uic.i)com.tencent.mm.ui.component.k.nq((Context)localObject1).q(com.tencent.mm.plugin.mv.ui.uic.i.class)).a(paramView, new c..ExternalSyntheticLambda4(paramView, paramc));
    if (i != 7)
    {
      localObject1 = paramc.Mcj;
      if ((paramView != null) && (localObject1 != null))
      {
        localObject2 = o.LYk;
        paramc = paramc.parent.getContext();
        kotlin.g.b.s.s(paramc, "parent.context");
        o.a(paramc, paramView, (com.tencent.mm.plugin.mv.model.f)localObject1, 2, i, 1);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286969);
  }
  
  private static final void c(c paramc, View paramView)
  {
    AppMethodBeat.i(286976);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramc = paramc.MjE;
    if (paramc != null) {
      paramc.fTj();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286976);
  }
  
  private final ViewGroup grO()
  {
    AppMethodBeat.i(286944);
    ViewGroup localViewGroup = (ViewGroup)this.Mjf.getValue();
    AppMethodBeat.o(286944);
    return localViewGroup;
  }
  
  private final BlurView gsa()
  {
    AppMethodBeat.i(286951);
    BlurView localBlurView = (BlurView)this.Mjr.getValue();
    AppMethodBeat.o(286951);
    return localBlurView;
  }
  
  public final void aPH(String paramString)
  {
    AppMethodBeat.i(287179);
    if (this.Mju == null)
    {
      AppMethodBeat.o(287179);
      return;
    }
    e locale = this.Mju;
    com.tencent.threadpool.h.ahAA.bk(new c..ExternalSyntheticLambda7(paramString, locale));
    AppMethodBeat.o(287179);
  }
  
  public final void e(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(287177);
    Log.i(TAG, "attachWebView");
    this.webView = paramMMWebView;
    paramMMWebView.a(new c..ExternalSyntheticLambda5(this));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    grX().addView((View)paramMMWebView, (ViewGroup.LayoutParams)localLayoutParams);
    AppMethodBeat.o(287177);
  }
  
  public final ViewGroup grK()
  {
    AppMethodBeat.i(287114);
    ViewGroup localViewGroup = (ViewGroup)this.Mjb.getValue();
    AppMethodBeat.o(287114);
    return localViewGroup;
  }
  
  public final FrameLayout grL()
  {
    AppMethodBeat.i(287119);
    FrameLayout localFrameLayout = (FrameLayout)this.Mjc.getValue();
    AppMethodBeat.o(287119);
    return localFrameLayout;
  }
  
  public final MusicMvMarqueeTextView grM()
  {
    AppMethodBeat.i(287125);
    MusicMvMarqueeTextView localMusicMvMarqueeTextView = (MusicMvMarqueeTextView)this.Mjd.getValue();
    AppMethodBeat.o(287125);
    return localMusicMvMarqueeTextView;
  }
  
  public final TextView grN()
  {
    AppMethodBeat.i(287131);
    TextView localTextView = (TextView)this.Mje.getValue();
    AppMethodBeat.o(287131);
    return localTextView;
  }
  
  public final MMImageView grP()
  {
    AppMethodBeat.i(287137);
    MMImageView localMMImageView = (MMImageView)this.Mjg.getValue();
    AppMethodBeat.o(287137);
    return localMMImageView;
  }
  
  public final View grQ()
  {
    AppMethodBeat.i(287148);
    View localView = (View)this.Mjh.getValue();
    AppMethodBeat.o(287148);
    return localView;
  }
  
  public final RelativeLayout grR()
  {
    AppMethodBeat.i(287150);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Mji.getValue();
    AppMethodBeat.o(287150);
    return localRelativeLayout;
  }
  
  public final LinearLayout grS()
  {
    AppMethodBeat.i(287152);
    LinearLayout localLinearLayout = (LinearLayout)this.Mjj.getValue();
    AppMethodBeat.o(287152);
    return localLinearLayout;
  }
  
  public final LinearLayout grT()
  {
    AppMethodBeat.i(287155);
    LinearLayout localLinearLayout = (LinearLayout)this.Mjk.getValue();
    AppMethodBeat.o(287155);
    return localLinearLayout;
  }
  
  public final BlurView grU()
  {
    AppMethodBeat.i(287157);
    BlurView localBlurView = (BlurView)this.Mjl.getValue();
    AppMethodBeat.o(287157);
    return localBlurView;
  }
  
  public final MMRoundCornerImageView grV()
  {
    AppMethodBeat.i(287158);
    MMRoundCornerImageView localMMRoundCornerImageView = (MMRoundCornerImageView)this.Mjm.getValue();
    AppMethodBeat.o(287158);
    return localMMRoundCornerImageView;
  }
  
  public final TextView grW()
  {
    AppMethodBeat.i(287160);
    TextView localTextView = (TextView)this.Mjn.getValue();
    AppMethodBeat.o(287160);
    return localTextView;
  }
  
  public final RoundCornerRelativeLayout grX()
  {
    AppMethodBeat.i(287162);
    RoundCornerRelativeLayout localRoundCornerRelativeLayout = (RoundCornerRelativeLayout)this.Mjo.getValue();
    AppMethodBeat.o(287162);
    return localRoundCornerRelativeLayout;
  }
  
  public final TextView grY()
  {
    AppMethodBeat.i(287166);
    TextView localTextView = (TextView)this.Mjp.getValue();
    AppMethodBeat.o(287166);
    return localTextView;
  }
  
  public final ProgressBar grZ()
  {
    AppMethodBeat.i(287168);
    ProgressBar localProgressBar = (ProgressBar)this.Mjq.getValue();
    AppMethodBeat.o(287168);
    return localProgressBar;
  }
  
  public final View gsb()
  {
    AppMethodBeat.i(287170);
    View localView = (View)this.Mjs.getValue();
    AppMethodBeat.o(287170);
    return localView;
  }
  
  public final View gsc()
  {
    AppMethodBeat.i(287175);
    View localView = (View)this.Mjt.getValue();
    AppMethodBeat.o(287175);
    return localView;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class aa
    extends u
    implements kotlin.g.a.a<RoundCornerRelativeLayout>
  {
    aa(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$OnCloseBtnClickListener;", "", "onClicked", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void fTj();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/blur/BlurView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<BlurView>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<TextView>
  {
    d(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/blur/BlurView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<BlurView>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<MMRoundCornerImageView>
  {
    f(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    g(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/MMImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<MMImageView>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<View>
  {
    i(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<FrameLayout>
  {
    j(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<TextView>
  {
    k(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    extends AnimatorListenerAdapter
  {
    public l(c paramc) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(287028);
      Log.i(c.access$getTAG$cp(), "onHide animate end");
      c.f(this.MjI).setTranslationY(-1.0F * c.g(this.MjI));
      c.h(this.MjI).setVisibility(8);
      this.MjI.Mjy = false;
      AppMethodBeat.o(287028);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<View>
  {
    m(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<View>
  {
    n(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    o(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    p(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    q(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ProgressBar;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends u
    implements kotlin.g.a.a<ProgressBar>
  {
    s(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$show$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class u
    extends AnimatorListenerAdapter
  {
    public u(c paramc) {}
    
    private static final void a(MMWebView paramMMWebView, String paramString)
    {
      AppMethodBeat.i(286995);
      kotlin.g.b.s.u(paramMMWebView, "$webView");
      paramMMWebView.postDelayed(new c.u..ExternalSyntheticLambda1(paramMMWebView), 300L);
      AppMethodBeat.o(286995);
    }
    
    private static final void f(MMWebView paramMMWebView)
    {
      AppMethodBeat.i(286989);
      kotlin.g.b.s.u(paramMMWebView, "$webView");
      paramMMWebView.animate().alpha(1.0F).setDuration(300L).start();
      AppMethodBeat.o(286989);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(287017);
      Log.i(c.access$getTAG$cp(), "onShow animate end, isShowH5Page:" + c.b(this.MjI) + ", lastWebViewScrollY:" + c.c(this.MjI));
      this.MjI.Mjy = true;
      if ((c.b(this.MjI)) && (c.c(this.MjI) != 0))
      {
        c.d(this.MjI).scrollTo(0, 0);
        c.d(this.MjI).animate().alpha(1.0F).setDuration(300L).start();
        paramAnimator = c.e(this.MjI);
        if (paramAnimator != null) {
          paramAnimator.evaluateJavascript("window.scroll(0,0)", new c.u..ExternalSyntheticLambda0(paramAnimator));
        }
      }
      AppMethodBeat.o(287017);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends u
    implements kotlin.g.a.a<TextView>
  {
    v(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    w(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends u
    implements kotlin.g.a.a<MusicMvMarqueeTextView>
  {
    x(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.c
 * JD-Core Version:    0.7.0.1
 */