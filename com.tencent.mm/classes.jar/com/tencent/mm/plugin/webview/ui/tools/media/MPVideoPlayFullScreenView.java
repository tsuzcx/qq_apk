package com.tencent.mm.plugin.webview.ui.tools.media;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.y;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.bp.a.a;
import com.tencent.mm.bp.a.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.tools.e.b;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.tools.e.d;
import com.tencent.mm.ui.tools.e.e;
import com.tencent.mm.ui.tools.e.f;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.t;
import com.tencent.xweb.u;
import d.l;
import d.v;
import java.util.Arrays;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ENTER_HIDE_MIL_SEC", "", "INVALID_ORIENTATION", "", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/view/View;", "centerPlayIv", "closeIv", "currentPlayTime", "", "enterId", "getEnterId", "()I", "setEnterId", "(I)V", "enterTimeInMs", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "footerLayout", "forbidForward", "", "getForbidForward", "()Z", "setForbidForward", "(Z)V", "forwardUiVisibility", "hasAddVideoView", "hasAdjustOrientation", "hideToolBarTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "imagePreviewAnimation", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;", "isLandScapeVideo", "isPlaying", "isRunningExitAnimation", "loadingBar", "Landroid/widget/ProgressBar;", "mCurrentOrientation", "mIsShowOpLayout", "mPreOrientation", "moreIv", "moreLayout", "mpInfoLayout", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "mpShareVideoReport", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "getMpShareVideoReport", "()Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "needDoAnimation", "nicknameTv", "Landroid/widget/TextView;", "orientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "preDeltaX", "preDeltaY", "preScale", "", "shareIv", "subScene", "getSubScene", "()Ljava/lang/Integer;", "setSubScene", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "touchLayout", "videoContainerLayout", "Landroid/view/ViewGroup;", "videoControl", "Lcom/tencent/xweb/VideoControl;", "videoPlayOpLayout", "videoPlayRootLayout", "videoPlayerSeekBar", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "videoRootLayout", "addVideoView", "", "view", "adjustOrientation", "exit", "fadeInAnimation", "Landroid/view/animation/Animation;", "fadeInOpLayout", "fadeOutAnimation", "duration", "fadeOutOpLayout", "force", "handleAnimation", "handleFullScreenStatusBar", "fullScreen", "handleHorizontalUI", "handleScreenSize", "handleVerticalUI", "hideLoading", "hideToolBar", "initData", "initReportData", "initSeekBar", "initVideoController", "initView", "loadAvatar", "onClick", "v", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onExit", "onExitMpVideoFullPage", "onResume", "opPlay", "postHandleVerticalUI", "removeVideoView", "resetOrientation", "runDragAnimation", "runEnterAnimation", "runExitAnimation", "bm", "Landroid/graphics/Bitmap;", "callback", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "showLoading", "showToolBar", "starHideToolBar", "startHideToolBarTimer", "stopHideToolBarTimer", "supportFullScreen", "updatePlayBtn", "playing", "plugin-webview_release"})
public final class MPVideoPlayFullScreenView
  extends RelativeLayout
  implements View.OnClickListener
{
  private com.tencent.mm.bp.a BgR;
  private Integer BsA;
  private av BsB;
  private final long BsC;
  private boolean BsD;
  public View Bsh;
  private View Bsi;
  private ViewGroup Bsj;
  public ViewGroup Bsk;
  private View Bsl;
  private View Bsm;
  private View Bsn;
  private View Bso;
  private View Bsp;
  private View Bsq;
  public t Bsr;
  private double Bss;
  private final int Bst;
  private int Bsu;
  private boolean Bsv;
  private boolean Bsw;
  private boolean Bsx;
  private final g Bsy;
  private boolean Bsz;
  public final String TAG;
  private ImageView fuj;
  public y gGE;
  private boolean gLh;
  private ProgressBar iiH;
  private boolean kQm;
  private int mCurrentOrientation;
  private View mZk;
  private View nar;
  private int niH;
  private TextView nkb;
  private MMNeat7extView nkc;
  private long nmh;
  private int nnT;
  public com.tencent.mm.ui.tools.e nzV;
  private View qrN;
  public float xwb;
  public int xwc;
  public int xwd;
  public boolean yEG;
  private RedesignVideoPlayerSeekBar yEw;
  
  public MPVideoPlayFullScreenView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82641);
    this.TAG = "MicroMsg.MPVideoPlayFullScreenView";
    this.Bst = -3;
    this.Bsu = this.Bst;
    this.mCurrentOrientation = -1;
    this.BgR = new com.tencent.mm.bp.a(paramContext, (a.b)new i(this, paramContext));
    this.Bsy = new g();
    View.inflate(paramContext, 2131494955, (ViewGroup)this);
    paramAttributeSet = findViewById(2131306368);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_play_root_layout)");
    this.Bsh = paramAttributeSet;
    paramAttributeSet = findViewById(2131306366);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_play_op_layout)");
    this.Bsi = paramAttributeSet;
    paramAttributeSet = findViewById(2131306318);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_container_layout)");
    this.Bsj = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131306372);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_player_footer)");
    this.Bsl = paramAttributeSet;
    paramAttributeSet = findViewById(2131302495);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.mp_info_layout)");
    this.Bsm = paramAttributeSet;
    paramAttributeSet = findViewById(2131306408);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_touch_layout)");
    this.Bsn = paramAttributeSet;
    paramAttributeSet = findViewById(2131302498);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.mp_video_avatar_layout)");
    this.qrN = paramAttributeSet;
    paramAttributeSet = findViewById(2131302497);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.mp_video_avatar_iv)");
    this.fuj = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131302508);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.mp_video_nickname_tv)");
    this.nkb = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131302513);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.mp_video_title_tv)");
    this.nkc = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131302514);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.mp_video_view_article_layout)");
    this.nar = paramAttributeSet;
    this.yEw = ((RedesignVideoPlayerSeekBar)findViewById(2131306375));
    this.iiH = ((ProgressBar)findViewById(2131306374));
    paramAttributeSet = this.yEw;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)this);
    }
    paramAttributeSet = this.Bsl;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)1.BsE);
    }
    paramAttributeSet = this.Bsm;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)2.BsF);
    }
    this.qrN.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        Object localObject = null;
        AppMethodBeat.i(82585);
        if (MPVideoPlayFullScreenView.g(this.BsG) != null)
        {
          paramAnonymousView = MPVideoPlayFullScreenView.g(this.BsG);
          if (paramAnonymousView == null) {
            break label162;
          }
        }
        label162:
        for (paramAnonymousView = paramAnonymousView.dfT;; paramAnonymousView = null)
        {
          if (bt.isNullOrNil(paramAnonymousView)) {
            ad.w(MPVideoPlayFullScreenView.a(this.BsG), "srcUserName is null");
          }
          Intent localIntent = new Intent();
          y localy = MPVideoPlayFullScreenView.g(this.BsG);
          paramAnonymousView = localObject;
          if (localy != null) {
            paramAnonymousView = localy.dfT;
          }
          localIntent.putExtra("Contact_User", paramAnonymousView);
          localIntent.putExtra("Contact_Scene", 163);
          localIntent.putExtra("force_get_contact", true);
          localIntent.putExtra("key_use_new_contact_profile", true);
          com.tencent.mm.bs.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
          com.tencent.mm.plugin.report.service.h.vKh.f(18589, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
          AppMethodBeat.o(82585);
          return;
        }
      }
    });
    o.go(this.qrN);
    paramAttributeSet = findViewById(2131306371);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_player_close)");
    this.mZk = paramAttributeSet;
    this.mZk.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82586);
        this.BsG.exit();
        AppMethodBeat.o(82586);
      }
    });
    paramAttributeSet = findViewById(2131306373);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_player_more_iv)");
    this.Bso = paramAttributeSet;
    this.Bso.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82587);
        paramAnonymousView = MPVideoPlayFullScreenView.g(this.BsG);
        if (paramAnonymousView != null)
        {
          f localf = f.BsZ;
          f.a(paramContext, paramAnonymousView, 3);
          AppMethodBeat.o(82587);
          return;
        }
        AppMethodBeat.o(82587);
      }
    });
    paramAttributeSet = findViewById(2131306376);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_player_share_iv)");
    this.Bsq = paramAttributeSet;
    this.Bsq.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82588);
        paramAnonymousView = paramContext;
        if (((paramAnonymousView instanceof WebViewUI)) && (MPVideoPlayFullScreenView.g(this.BsG) != null))
        {
          ((WebViewUI)paramAnonymousView).Bit.gGE = MPVideoPlayFullScreenView.g(this.BsG);
          Object localObject1 = c.BsS;
          localObject1 = MPVideoPlayFullScreenView.g(this.BsG);
          if (localObject1 == null) {
            d.g.b.k.fvU();
          }
          localObject1 = ((y)localObject1).gKD;
          Object localObject2 = MPVideoPlayFullScreenView.g(this.BsG);
          if (localObject2 == null) {
            d.g.b.k.fvU();
          }
          localObject2 = ((y)localObject2).title;
          y localy = MPVideoPlayFullScreenView.g(this.BsG);
          if (localy == null) {
            d.g.b.k.fvU();
          }
          c.a(paramAnonymousView, (String)localObject1, "", (String)localObject2, localy.CEf, 2);
          com.tencent.mm.plugin.report.service.h.vKh.f(18589, new Object[] { Integer.valueOf(16), Integer.valueOf(3) });
          AppMethodBeat.o(82588);
          return;
        }
        ad.w(MPVideoPlayFullScreenView.a(this.BsG), "should not be here");
        AppMethodBeat.o(82588);
      }
    });
    paramContext = findViewById(2131306413);
    d.g.b.k.g(paramContext, "findViewById(R.id.video_wait_play_btn)");
    this.Bsp = paramContext;
    this.Bsp.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82589);
        MPVideoPlayFullScreenView.B(this.BsG);
        AppMethodBeat.o(82589);
      }
    });
    this.nar.setVisibility(8);
    paramContext = this.yEw;
    if (paramContext != null) {
      paramContext.setPlayBtnOnClickListener((View.OnClickListener)this);
    }
    paramContext = this.yEw;
    if (paramContext != null) {
      paramContext.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new g(this));
    }
    this.xwb = 1.0F;
    this.BsB = new av((av.a)new f(this), true);
    this.BsC = 4000L;
    AppMethodBeat.o(82641);
  }
  
  private final void eqA()
  {
    AppMethodBeat.i(82627);
    Object localObject = this.Bsk;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getViewTreeObserver();
      if (localObject != null)
      {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new o(this));
        AppMethodBeat.o(82627);
        return;
      }
    }
    AppMethodBeat.o(82627);
  }
  
  private final void eqB()
  {
    AppMethodBeat.i(82631);
    if (this.kQm)
    {
      localt = this.Bsr;
      if (localt != null)
      {
        localt.fqM();
        AppMethodBeat.o(82631);
        return;
      }
      AppMethodBeat.o(82631);
      return;
    }
    t localt = this.Bsr;
    if (localt != null)
    {
      localt.fqL();
      AppMethodBeat.o(82631);
      return;
    }
    AppMethodBeat.o(82631);
  }
  
  private final void eqC()
  {
    try
    {
      AppMethodBeat.i(188904);
      Object localObject1 = getContext();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(188904);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    Activity localActivity = (Activity)localObject2;
    if (this.gGE == null)
    {
      ad.d(this.TAG, "adjustOrientation mpShareVideoInfo is null");
      AppMethodBeat.o(188904);
    }
    for (;;)
    {
      return;
      if ((!this.Bsw) && (this.Bsx)) {
        break;
      }
      ad.i(this.TAG, "adjustOrientation hasAdjustOrientation=" + this.Bsw + ", hasAddVideoView=" + this.Bsx);
      AppMethodBeat.o(188904);
    }
    this.Bsw = true;
    if (this.Bsu == this.Bst) {
      this.Bsu = localActivity.getRequestedOrientation();
    }
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("adjustOrientation width = ");
    y localy = this.gGE;
    if (localy == null) {
      d.g.b.k.fvU();
    }
    localStringBuilder = localStringBuilder.append(localy.width).append(", height=");
    localy = this.gGE;
    if (localy == null) {
      d.g.b.k.fvU();
    }
    ad.i((String)localObject3, localy.height);
    localObject3 = this.gGE;
    if (localObject3 == null) {
      d.g.b.k.fvU();
    }
    int i = ((y)localObject3).width;
    localObject3 = this.gGE;
    if (localObject3 == null) {
      d.g.b.k.fvU();
    }
    if (i <= ((y)localObject3).height)
    {
      this.mCurrentOrientation = 1;
      localActivity.setRequestedOrientation(this.mCurrentOrientation);
      this.Bsv = false;
    }
    for (;;)
    {
      eqJ();
      AppMethodBeat.o(188904);
      break;
      this.Bsv = true;
      this.mCurrentOrientation = 0;
      localActivity.setRequestedOrientation(this.mCurrentOrientation);
      this.BgR.enable();
    }
  }
  
  private final void eqF()
  {
    boolean bool = true;
    AppMethodBeat.i(82635);
    Object localObject = this.TAG;
    if (this.Bsi.getVisibility() == 0) {}
    for (;;)
    {
      ad.d((String)localObject, "fadeOutOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = eqG();
      ((Animation)localObject).setFillAfter(false);
      ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this));
      this.Bsi.clearAnimation();
      this.Bsi.startAnimation((Animation)localObject);
      AppMethodBeat.o(82635);
      return;
      bool = false;
    }
  }
  
  private static Animation eqG()
  {
    AppMethodBeat.i(82636);
    Object localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(150L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setInterpolator((Interpolator)new AccelerateInterpolator(10.0F));
    localObject = (Animation)localObject;
    AppMethodBeat.o(82636);
    return localObject;
  }
  
  private final void eqH()
  {
    AppMethodBeat.i(82638);
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(82638);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getWindow();
    d.g.b.k.g(localObject, "(context as Activity).window");
    localObject = ((Window)localObject).getDecorView();
    d.g.b.k.g(localObject, "contentRoot");
    ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new d(this, (View)localObject));
    AppMethodBeat.o(82638);
  }
  
  private final void eqI()
  {
    AppMethodBeat.i(82639);
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(82639);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getWindow();
    d.g.b.k.g(localObject, "(context as Activity).window");
    localObject = ((Window)localObject).getDecorView();
    d.g.b.k.g(localObject, "contentRoot");
    ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new c(this, (View)localObject));
    AppMethodBeat.o(82639);
  }
  
  private final void eqJ()
  {
    AppMethodBeat.i(182654);
    if ((this.mCurrentOrientation == 0) || (this.mCurrentOrientation == 8))
    {
      eqI();
      AppMethodBeat.o(182654);
      return;
    }
    eqH();
    AppMethodBeat.o(182654);
  }
  
  private final void eqz()
  {
    AppMethodBeat.i(82626);
    if (this.nzV == null) {
      this.nzV = new com.tencent.mm.ui.tools.e(getContext());
    }
    if (this.gGE == null)
    {
      this.Bsz = true;
      AppMethodBeat.o(82626);
      return;
    }
    this.Bsz = false;
    Object localObject = this.gGE;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    int i = ((y)localObject).gLa;
    localObject = this.gGE;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    int j = ((y)localObject).gLb;
    localObject = this.gGE;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    int k = ((y)localObject).gLc;
    localObject = this.gGE;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    int m = ((y)localObject).gLd;
    localObject = this.nzV;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.e)localObject).P(i, j, k, m);
    }
    localObject = this.nzV;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.e)localObject).fdN();
    }
    localObject = this.nzV;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.e)localObject).jD(0, 0);
    }
    eqA();
    AppMethodBeat.o(82626);
  }
  
  private final int getSubScene$1385f2()
  {
    Object localObject2 = null;
    AppMethodBeat.i(82633);
    Object localObject1 = getContext();
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(82633);
      throw ((Throwable)localObject1);
    }
    int i = ((Activity)localObject1).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
    if (i == 10000)
    {
      Object localObject3 = getContext();
      localObject1 = localObject3;
      if (!(localObject3 instanceof com.tencent.mm.plugin.webview.core.b)) {
        localObject1 = null;
      }
      localObject3 = (com.tencent.mm.plugin.webview.core.b)localObject1;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((com.tencent.mm.plugin.webview.core.b)localObject3).bEx();
      }
    }
    for (;;)
    {
      try
      {
        int j = bt.getInt(Uri.parse((String)localObject1).getQueryParameter("scene"), 10000);
        i = j;
        AppMethodBeat.o(82633);
        return i;
      }
      catch (Exception localException) {}
    }
  }
  
  private void removeVideoView()
  {
    AppMethodBeat.i(82632);
    this.Bsj.removeAllViews();
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
      AppMethodBeat.o(82632);
      throw ((Throwable)localObject);
    }
    ((WebViewUI)localObject).setMMOrientation();
    AppMethodBeat.o(82632);
  }
  
  private final void tA(boolean paramBoolean)
  {
    AppMethodBeat.i(182653);
    ad.i(this.TAG, "handleFullScreenStatusBar forwardUiVisibility " + this.nnT);
    if (paramBoolean)
    {
      localObject1 = getContext();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(182653);
        throw ((Throwable)localObject1);
      }
      localObject1 = (Activity)localObject1;
      localObject2 = ((Activity)localObject1).getWindow();
      d.g.b.k.g(localObject2, "activity.window");
      localObject2 = ((Window)localObject2).getDecorView();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(182653);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup)localObject2;
      this.nnT = ((ViewGroup)localObject2).getSystemUiVisibility();
      ((ViewGroup)localObject2).setSystemUiVisibility(4102);
      ((Activity)localObject1).getWindow().addFlags(1024);
      AppMethodBeat.o(182653);
      return;
    }
    Object localObject1 = getContext();
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(182653);
      throw ((Throwable)localObject1);
    }
    localObject1 = (Activity)localObject1;
    Object localObject2 = ((Activity)localObject1).getWindow();
    d.g.b.k.g(localObject2, "activity.window");
    localObject2 = ((Window)localObject2).getDecorView();
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(182653);
      throw ((Throwable)localObject1);
    }
    ((ViewGroup)localObject2).setSystemUiVisibility(this.nnT);
    ((Activity)localObject1).getWindow().clearFlags(1024);
    AppMethodBeat.o(182653);
  }
  
  public final void a(y paramy)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(188902);
        d.g.b.k.h(paramy, "mpShareVideoInfo");
        this.gGE = paramy;
        this.gLh = paramy.gLh;
        paramy = this.nkc.getPaint();
        d.g.b.k.g(paramy, "titleTv.paint");
        paramy.setFakeBoldText(true);
        paramy = this.nkb.getPaint();
        d.g.b.k.g(paramy, "nicknameTv.paint");
        paramy.setFakeBoldText(true);
        localObject = this.nkc;
        paramy = this.gGE;
        if (paramy != null)
        {
          paramy = paramy.title;
          ((MMNeat7extView)localObject).aq((CharSequence)paramy);
          localObject = this.nkb;
          Context localContext = getContext();
          paramy = this.gGE;
          if (paramy != null)
          {
            paramy = paramy.gKv;
            ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(localContext, (CharSequence)paramy, this.nkb.getTextSize()));
            if (!this.gLh) {
              continue;
            }
            this.Bso.setVisibility(8);
            this.Bsq.setVisibility(8);
            localObject = getContext();
            if ((localObject instanceof WebViewUI))
            {
              paramy = this.gGE;
              if (paramy == null) {
                break label311;
              }
              paramy = paramy.gLg;
              if (bt.isNullOrNil(paramy)) {
                break label321;
              }
              paramy = this.gGE;
              if (paramy == null) {
                break label316;
              }
              paramy = paramy.gLg;
              com.tencent.mm.aw.a.a.ayO().a(paramy, this.fuj, new c.a().aza().oq(2131231342).azc());
            }
            if (this.Bsz) {
              eqz();
            }
            ad.d(this.TAG, "initData");
            eqC();
            AppMethodBeat.o(188902);
          }
        }
        else
        {
          paramy = null;
          continue;
        }
        paramy = null;
        continue;
        this.Bso.setVisibility(0);
        this.Bsq.setVisibility(0);
        continue;
        paramy = null;
      }
      finally {}
      label311:
      continue;
      label316:
      paramy = null;
      continue;
      label321:
      paramy = ((WebViewUI)localObject).eoj();
      if (paramy != null)
      {
        paramy = paramy.bzA();
        if (paramy != null)
        {
          paramy = paramy.dub;
          continue;
        }
      }
      paramy = null;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public final void eqD()
  {
    AppMethodBeat.i(182652);
    if (this.Bsu != this.Bst)
    {
      Object localObject = getContext();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(182652);
        throw ((Throwable)localObject);
      }
      ((Activity)localObject).setRequestedOrientation(this.Bsu);
      this.Bsu = this.Bst;
      this.BgR.disable();
    }
    tA(false);
    AppMethodBeat.o(182652);
  }
  
  public final void eqE()
  {
    AppMethodBeat.i(82634);
    if (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) {
      ad.d(this.TAG, "hideOpLayer %s", new Object[] { bt.eGN() });
    }
    if (!this.BsD)
    {
      AppMethodBeat.o(82634);
      return;
    }
    this.BsD = false;
    eqF();
    AppMethodBeat.o(82634);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(82628);
    Context localContext = getContext();
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).eoY() != null))
    {
      if (((WebViewUI)localContext).eoY() != null)
      {
        ad.i(this.TAG, "close click");
        eqD();
        ((WebViewUI)localContext).eoY().leaveFullscreen();
        aq.n((Runnable)new a(this), 500L);
        AppMethodBeat.o(82628);
      }
    }
    else {
      ad.w(this.TAG, "should not be here");
    }
    AppMethodBeat.o(82628);
  }
  
  public final void fm(View paramView)
  {
    try
    {
      AppMethodBeat.i(188903);
      d.g.b.k.h(paramView, "view");
      if (this.gGE == null) {
        break label209;
      }
      localObject1 = this.gGE;
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      ((y)localObject1).gLe = this.niH;
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        AppMethodBeat.o(188903);
        throw paramView;
      }
    }
    finally {}
    Object localObject2 = (WebViewUI)localObject1;
    Object localObject1 = ((WebViewUI)localObject2).kxf;
    if (localObject1 != null) {}
    try
    {
      localObject1 = this.Bsy;
      localObject2 = ((WebViewUI)localObject2).kxf;
      y localy = this.gGE;
      if (localy == null) {
        d.g.b.k.fvU();
      }
      ((g)localObject1).nlY = ((com.tencent.mm.plugin.webview.stub.e)localObject2).sD(localy.dfT);
      this.Bsy.scene = 141;
      this.Bsy.niJ = getSubScene$1385f2();
    }
    catch (Exception localException)
    {
      label149:
      break label149;
    }
    this.nmh = System.currentTimeMillis();
    this.niH = ((int)(this.nmh / 1000L));
    this.Bsy.a(this.gGE, 1, this.niH);
    this.Bsy.a(this.gGE, 5, this.niH);
    this.Bsy.hxT = 0;
    label209:
    removeVideoView();
    tA(true);
    this.Bsh.setAlpha(1.0F);
    this.Bsh.setBackgroundColor(-16777216);
    setVisibility(0);
    localObject1 = new FrameLayout(getContext());
    ((FrameLayout)localObject1).addView(paramView, new ViewGroup.LayoutParams(-1, -2));
    this.Bsk = ((ViewGroup)localObject1);
    paramView = this.Bsj;
    localObject1 = (View)this.Bsk;
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    eqz();
    this.yEG = false;
    ad.d(this.TAG, "addVideoView");
    this.Bsx = true;
    eqC();
    AppMethodBeat.o(188903);
  }
  
  public final int getEnterId()
  {
    return this.niH;
  }
  
  public final long getEnterTimeInMs()
  {
    return this.nmh;
  }
  
  public final boolean getForbidForward()
  {
    return this.gLh;
  }
  
  public final g getMpShareVideoReport()
  {
    return this.Bsy;
  }
  
  public final Integer getSubScene()
  {
    return this.BsA;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(82630);
    if (paramView != null)
    {
      if (paramView.getId() == 2131303281) {
        eqB();
      }
      AppMethodBeat.o(82630);
      return;
    }
    AppMethodBeat.o(82630);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(82637);
    d.g.b.k.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      ad.d(this.TAG, "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      eqH();
      AppMethodBeat.o(82637);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ad.d(this.TAG, "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
      eqI();
      AppMethodBeat.o(82637);
      return;
    }
    AppMethodBeat.o(82637);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(82629);
    if (getVisibility() == 8)
    {
      AppMethodBeat.o(82629);
      return;
    }
    setVisibility(8);
    removeVideoView();
    ad.i(this.TAG, "onExitMpVideoFullPage");
    this.Bsw = false;
    this.Bsx = false;
    if (this.gGE != null)
    {
      this.Bsy.nlW = ((int)(System.currentTimeMillis() - this.nmh));
      this.Bsy.nlV = ((int)(this.Bss * 1000.0D));
      this.Bsy.a(this.gGE, 6, this.niH);
      this.Bsy.a(this.gGE, 2, this.niH);
      Object localObject = getContext();
      if (((localObject instanceof WebViewUI)) && (((WebViewUI)localObject).AQP != null))
      {
        localObject = ((WebViewUI)localObject).AQP;
        y localy = this.gGE;
        if (localy == null) {
          d.g.b.k.fvU();
        }
        ((com.tencent.mm.plugin.webview.c.f)localObject).eU(localy.CEg, (int)this.Bss);
      }
      this.gGE = null;
    }
    AppMethodBeat.o(82629);
  }
  
  public final void setEnterId(int paramInt)
  {
    this.niH = paramInt;
  }
  
  public final void setEnterTimeInMs(long paramLong)
  {
    this.nmh = paramLong;
  }
  
  public final void setForbidForward(boolean paramBoolean)
  {
    this.gLh = paramBoolean;
  }
  
  public final void setSubScene(Integer paramInteger)
  {
    this.BsA = paramInteger;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82590);
      this.BsG.onExit();
      AppMethodBeat.o(82590);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$fadeOutOpLayout$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(82592);
      d.g.b.k.h(paramAnimation, "animation");
      if (!MPVideoPlayFullScreenView.r(this.BsG)) {
        MPVideoPlayFullScreenView.s(this.BsG);
      }
      AppMethodBeat.o(82592);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(82593);
      d.g.b.k.h(paramAnimation, "animation");
      AppMethodBeat.o(82593);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(82591);
      d.g.b.k.h(paramAnimation, "animation");
      AppMethodBeat.o(82591);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$handleHorizontalUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class c
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    c(View paramView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82594);
      Object localObject = this.BsH;
      d.g.b.k.g(localObject, "contentRoot");
      ((View)localObject).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      if (com.tencent.mm.compatible.util.d.lf(24))
      {
        localObject = this.BsG.getContext();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(82594);
          throw ((Throwable)localObject);
        }
        if (((Activity)localObject).isInMultiWindowMode())
        {
          MPVideoPlayFullScreenView.t(this.BsG);
          AppMethodBeat.o(82594);
          return;
        }
      }
      int n = ap.eb(this.BsG.getContext());
      int i = com.tencent.mm.cd.a.ap(this.BsG.getContext(), 2131165303);
      int j = i * 3;
      int k = i * 4;
      int m = i * 7;
      n = Math.max(n - i * 3, 0);
      MPVideoPlayFullScreenView.u(this.BsG).setPadding(n, i * 2, n - i, i * 2);
      localObject = MPVideoPlayFullScreenView.v(this.BsG).getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject).setMargins(k, j, 0, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      MPVideoPlayFullScreenView.v(this.BsG).setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = MPVideoPlayFullScreenView.w(this.BsG).getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, j, k, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      MPVideoPlayFullScreenView.w(this.BsG).setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = MPVideoPlayFullScreenView.x(this.BsG).getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, j, k, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      MPVideoPlayFullScreenView.x(this.BsG).setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = MPVideoPlayFullScreenView.m(this.BsG);
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      localObject = ((RedesignVideoPlayerSeekBar)localObject).getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131306371);
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131306376);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      ((RelativeLayout.LayoutParams)localObject).setMargins(m, j, m, j);
      RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = MPVideoPlayFullScreenView.m(this.BsG);
      if (localRedesignVideoPlayerSeekBar != null)
      {
        localRedesignVideoPlayerSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(82594);
        return;
      }
      AppMethodBeat.o(82594);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$handleVerticalUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class d
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    d(View paramView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82595);
      View localView = this.BsH;
      d.g.b.k.g(localView, "contentRoot");
      localView.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      MPVideoPlayFullScreenView.t(this.BsG);
      AppMethodBeat.o(82595);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82596);
      ProgressBar localProgressBar = MPVideoPlayFullScreenView.l(this.BsG);
      if ((localProgressBar != null) && (localProgressBar.getVisibility() == 0))
      {
        localProgressBar = MPVideoPlayFullScreenView.l(this.BsG);
        if (localProgressBar != null) {
          localProgressBar.setVisibility(8);
        }
      }
      if (!MPVideoPlayFullScreenView.n(this.BsG)) {
        MPVideoPlayFullScreenView.k(this.BsG).setVisibility(0);
      }
      AppMethodBeat.o(82596);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
  static final class f
    implements av.a
  {
    f(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(82597);
      MPVideoPlayFullScreenView.i(this.BsG);
      AppMethodBeat.o(82597);
      return false;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$initSeekBar$1", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-webview_release"})
  public static final class g
    implements com.tencent.mm.plugin.sight.decode.ui.b
  {
    public final void bcv() {}
    
    public final void rZ(int paramInt)
    {
      AppMethodBeat.i(82598);
      ad.i(MPVideoPlayFullScreenView.a(this.BsG), "initSeekBar onSeekTo ".concat(String.valueOf(paramInt)));
      t localt = MPVideoPlayFullScreenView.o(this.BsG);
      if (localt != null)
      {
        localt.G(paramInt);
        AppMethodBeat.o(82598);
        return;
      }
      AppMethodBeat.o(82598);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$initVideoController$1", "Lcom/tencent/xweb/VideoJsCallback;", "lastUpdateTime", "", "getLastUpdateTime", "()J", "setLastUpdateTime", "(J)V", "onSetRequestedOrientation", "", "orientation", "", "onVideoEmptied", "", "onVideoEnded", "onVideoEnterFullscreen", "isVideoTag", "id", "width", "", "height", "paused", "seeking", "currentTime", "duration", "buffered", "", "onVideoError", "error", "msg", "", "onVideoExitFullscreen", "onVideoPause", "onVideoPlay", "onVideoPlaying", "onVideoSeeked", "onVideoSeeking", "onVideoSizeUpdate", "onVideoTimeUpdate", "onVideoWaiting", "plugin-webview_release"})
  public static final class h
    implements u
  {
    private long lastUpdateTime;
    
    public final void beC()
    {
      AppMethodBeat.i(82602);
      ad.i(MPVideoPlayFullScreenView.a(this.BsG), "onVideoEmptied");
      MPVideoPlayFullScreenView.p(this.BsG);
      AppMethodBeat.o(82602);
    }
    
    public final void onVideoEnded()
    {
      AppMethodBeat.i(82600);
      ad.i(MPVideoPlayFullScreenView.a(this.BsG), "onVideoEnded");
      MPVideoPlayFullScreenView.c(this.BsG, false);
      MPVideoPlayFullScreenView.p(this.BsG);
      this.BsG.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.BsG), 7, this.BsG.getEnterId());
      this.BsG.getMpShareVideoReport().hxT = 4;
      AppMethodBeat.o(82600);
    }
    
    public final void onVideoEnterFullscreen(boolean paramBoolean1, long paramLong, double paramDouble1, double paramDouble2, boolean paramBoolean2, boolean paramBoolean3, double paramDouble3, double paramDouble4, double[] paramArrayOfDouble)
    {
      AppMethodBeat.i(82609);
      ad.i(MPVideoPlayFullScreenView.a(this.BsG), "onVideoEnterFullscreen isVideoTag:" + paramBoolean1 + ", id:" + paramLong + ", width:" + paramDouble1 + ", height:" + paramDouble2 + ", paused:" + paramBoolean2 + ", seeking:" + paramBoolean3 + ", currentTime:" + paramDouble3 + ", duration:" + paramDouble4 + ", buffered:" + Arrays.toString(paramArrayOfDouble));
      paramArrayOfDouble = this.BsG;
      if (!paramBoolean2) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        MPVideoPlayFullScreenView.b(paramArrayOfDouble, paramBoolean1);
        MPVideoPlayFullScreenView.c(this.BsG, MPVideoPlayFullScreenView.n(this.BsG));
        if (MPVideoPlayFullScreenView.n(this.BsG))
        {
          this.BsG.getMpShareVideoReport().hxT = 1;
          this.BsG.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.BsG), this.BsG.getMpShareVideoReport().eqM(), this.BsG.getEnterId());
        }
        AppMethodBeat.o(82609);
        return;
      }
    }
    
    public final void onVideoError(int paramInt, String paramString)
    {
      AppMethodBeat.i(82601);
      ad.e(MPVideoPlayFullScreenView.a(this.BsG), "onVideoError " + paramInt + ", " + paramString);
      MPVideoPlayFullScreenView.c(this.BsG, false);
      MPVideoPlayFullScreenView.p(this.BsG);
      this.BsG.getMpShareVideoReport().hxT = 4;
      this.BsG.getMpShareVideoReport().nlX = paramString;
      this.BsG.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.BsG), 11, this.BsG.getEnterId());
      AppMethodBeat.o(82601);
    }
    
    public final void onVideoExitFullscreen()
    {
      AppMethodBeat.i(82610);
      ad.i(MPVideoPlayFullScreenView.a(this.BsG), "onVideoExitFullscreen");
      AppMethodBeat.o(82610);
    }
    
    public final void onVideoPause()
    {
      AppMethodBeat.i(82608);
      ad.i(MPVideoPlayFullScreenView.a(this.BsG), "onVideoPause");
      MPVideoPlayFullScreenView.c(this.BsG, false);
      MPVideoPlayFullScreenView.p(this.BsG);
      if (this.BsG.getMpShareVideoReport().hxT != 3) {
        this.BsG.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.BsG), 8, this.BsG.getEnterId());
      }
      this.BsG.getMpShareVideoReport().hxT = 3;
      AppMethodBeat.o(82608);
    }
    
    public final void onVideoPlay()
    {
      AppMethodBeat.i(82607);
      ad.i(MPVideoPlayFullScreenView.a(this.BsG), "onVideoPlay");
      MPVideoPlayFullScreenView.c(this.BsG, true);
      MPVideoPlayFullScreenView.p(this.BsG);
      if (this.BsG.getMpShareVideoReport().hxT != 2) {
        this.BsG.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.BsG), this.BsG.getMpShareVideoReport().eqM(), this.BsG.getEnterId());
      }
      this.BsG.getMpShareVideoReport().hxT = 2;
      AppMethodBeat.o(82607);
    }
    
    public final void onVideoPlaying()
    {
      AppMethodBeat.i(82603);
      ad.d(MPVideoPlayFullScreenView.a(this.BsG), "onVideoPlaying");
      if (!MPVideoPlayFullScreenView.n(this.BsG))
      {
        MPVideoPlayFullScreenView.c(this.BsG, true);
        MPVideoPlayFullScreenView.p(this.BsG);
      }
      this.BsG.getMpShareVideoReport().hxT = 2;
      AppMethodBeat.o(82603);
    }
    
    public final void onVideoSeeked()
    {
      AppMethodBeat.i(82606);
      ad.i(MPVideoPlayFullScreenView.a(this.BsG), "onVideoSeeked");
      MPVideoPlayFullScreenView.p(this.BsG);
      this.BsG.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.BsG), 13, this.BsG.getEnterId());
      AppMethodBeat.o(82606);
    }
    
    public final void onVideoSeeking()
    {
      AppMethodBeat.i(82605);
      ad.i(MPVideoPlayFullScreenView.a(this.BsG), "onVideoSeeking");
      MPVideoPlayFullScreenView.q(this.BsG);
      AppMethodBeat.o(82605);
    }
    
    public final void onVideoSizeUpdate(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(82612);
      y localy = MPVideoPlayFullScreenView.g(this.BsG);
      if ((localy == null) || (localy.width != 0))
      {
        localy = MPVideoPlayFullScreenView.g(this.BsG);
        if (localy != null) {
          if (localy.height != 0) {
            break label103;
          }
        }
      }
      else
      {
        localy = MPVideoPlayFullScreenView.g(this.BsG);
        if (localy != null) {
          localy.width = ((int)paramDouble1);
        }
        localy = MPVideoPlayFullScreenView.g(this.BsG);
        if (localy == null) {
          break label103;
        }
        localy.height = ((int)paramDouble2);
        AppMethodBeat.o(82612);
        return;
      }
      AppMethodBeat.o(82612);
      return;
      label103:
      AppMethodBeat.o(82612);
    }
    
    public final void onVideoTimeUpdate(double paramDouble1, final double paramDouble2, final double[] paramArrayOfDouble)
    {
      AppMethodBeat.i(82611);
      if (System.currentTimeMillis() - this.lastUpdateTime >= 500L)
      {
        this.lastUpdateTime = System.currentTimeMillis();
        aq.f((Runnable)new a(this, paramDouble2, paramDouble1, paramArrayOfDouble));
      }
      MPVideoPlayFullScreenView.a(this.BsG, paramDouble1);
      MPVideoPlayFullScreenView.p(this.BsG);
      AppMethodBeat.o(82611);
    }
    
    public final void onVideoWaiting()
    {
      AppMethodBeat.i(82604);
      ad.i(MPVideoPlayFullScreenView.a(this.BsG), "onVideoWaiting");
      MPVideoPlayFullScreenView.q(this.BsG);
      AppMethodBeat.o(82604);
    }
    
    public final boolean sn(int paramInt)
    {
      return false;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoPlayFullScreenView.h paramh, double paramDouble1, double paramDouble2, double[] paramArrayOfDouble) {}
      
      public final void run()
      {
        int j = 1;
        AppMethodBeat.i(82599);
        Object localObject = MPVideoPlayFullScreenView.m(this.BsI.BsG);
        if (localObject != null) {
          ((RedesignVideoPlayerSeekBar)localObject).setVideoTotalTime((int)paramDouble2);
        }
        localObject = MPVideoPlayFullScreenView.m(this.BsI.BsG);
        if (localObject != null) {
          ((RedesignVideoPlayerSeekBar)localObject).sa((int)paramArrayOfDouble);
        }
        localObject = this.BsL;
        if (localObject != null)
        {
          if (localObject.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label128;
            }
          }
          label128:
          for (int i = j;; i = 0)
          {
            if (i == 0) {
              break label133;
            }
            RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = MPVideoPlayFullScreenView.m(this.BsI.BsG);
            if (localRedesignVideoPlayerSeekBar == null) {
              break label133;
            }
            d.g.b.k.h(localObject, "$this$lastIndex");
            localRedesignVideoPlayerSeekBar.Vr((int)localObject[(localObject.length - 1)]);
            AppMethodBeat.o(82599);
            return;
            i = 0;
            break;
          }
          label133:
          AppMethodBeat.o(82599);
          return;
        }
        AppMethodBeat.o(82599);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class i
    implements a.b
  {
    i(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, Context paramContext) {}
    
    public final void a(a.a parama1, a.a parama2)
    {
      AppMethodBeat.i(182651);
      if (MPVideoPlayFullScreenView.y(this.BsG))
      {
        parama1 = this.BsG;
        if (parama2 == null)
        {
          AppMethodBeat.o(182651);
          return;
        }
        switch (b.ciE[parama2.ordinal()])
        {
        default: 
          AppMethodBeat.o(182651);
          return;
        }
        for (int i = 0;; i = 8)
        {
          MPVideoPlayFullScreenView.a(parama1, i);
          parama1 = paramContext;
          if (parama1 != null) {
            break;
          }
          parama1 = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(182651);
          throw parama1;
        }
        ((Activity)parama1).setRequestedOrientation(MPVideoPlayFullScreenView.z(this.BsG));
        MPVideoPlayFullScreenView.A(this.BsG);
      }
      AppMethodBeat.o(182651);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onExit"})
  static final class j
    implements e.b
  {
    j(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void onExit()
    {
      AppMethodBeat.i(82613);
      this.BsG.exit();
      AppMethodBeat.o(82613);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "longClickOver"})
  static final class k
    implements e.d
  {
    k(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void aHp()
    {
      AppMethodBeat.i(82614);
      if (!this.BsG.getForbidForward())
      {
        y localy = MPVideoPlayFullScreenView.g(this.BsG);
        if (localy != null)
        {
          Object localObject = f.BsZ;
          localObject = this.BsG.getContext();
          d.g.b.k.g(localObject, "context");
          f.a((Context)localObject, localy, 2);
          AppMethodBeat.o(82614);
          return;
        }
      }
      AppMethodBeat.o(82614);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onClick"})
  static final class l
    implements e.f
  {
    l(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(82615);
      if (MPVideoPlayFullScreenView.h(this.BsG).getVisibility() == 0)
      {
        MPVideoPlayFullScreenView.i(this.BsG);
        AppMethodBeat.o(82615);
        return;
      }
      MPVideoPlayFullScreenView.f(this.BsG);
      AppMethodBeat.o(82615);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "tx", "", "ty", "onGalleryScale"})
  static final class m
    implements e.e
  {
    m(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void J(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(82616);
      if ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F))
      {
        MPVideoPlayFullScreenView.f(this.BsG);
        AppMethodBeat.o(82616);
        return;
      }
      if ((Math.abs(paramFloat1) > 10.0F) || (Math.abs(paramFloat2) > 10.0F)) {
        MPVideoPlayFullScreenView.i(this.BsG);
      }
      AppMethodBeat.o(82616);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    public static final n BsM;
    
    static
    {
      AppMethodBeat.i(82618);
      BsM = new n();
      AppMethodBeat.o(82618);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(82617);
      AppMethodBeat.o(82617);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runEnterAnimation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class o
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82620);
      ad.d(MPVideoPlayFullScreenView.a(this.BsG), "runEnterAnimation");
      Object localObject = MPVideoPlayFullScreenView.b(this.BsG);
      if (localObject != null)
      {
        localObject = ((ViewGroup)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      localObject = MPVideoPlayFullScreenView.b(this.BsG);
      if (localObject != null) {}
      for (localObject = Integer.valueOf(((ViewGroup)localObject).getHeight());; localObject = null)
      {
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        if (((Integer)localObject).intValue() > 0) {
          break;
        }
        MPVideoPlayFullScreenView.c(this.BsG);
        AppMethodBeat.o(82620);
        return;
      }
      MPVideoPlayFullScreenView.d(this.BsG);
      localObject = MPVideoPlayFullScreenView.e(this.BsG);
      if (localObject != null)
      {
        ViewGroup localViewGroup = MPVideoPlayFullScreenView.b(this.BsG);
        if (localViewGroup == null) {
          d.g.b.k.fvU();
        }
        ((com.tencent.mm.ui.tools.e)localObject).a((View)localViewGroup, null, (e.c)new a(this));
        AppMethodBeat.o(82620);
        return;
      }
      AppMethodBeat.o(82620);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runEnterAnimation$1$onGlobalLayout$1", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-webview_release"})
    public static final class a
      implements e.c
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(82619);
        MPVideoPlayFullScreenView.f(this.BsN.BsG);
        AppMethodBeat.o(82619);
      }
      
      public final void onAnimationStart() {}
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runExitAnimation$2", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-webview_release"})
  public static final class p
    implements e.c
  {
    public p(e.c paramc) {}
    
    public final void onAnimationEnd()
    {
      AppMethodBeat.i(82623);
      e.c localc = this.BsO;
      if (localc != null) {
        localc.onAnimationEnd();
      }
      MPVideoPlayFullScreenView.j(this.BsG).post((Runnable)new a(this));
      MPVideoPlayFullScreenView.a(this.BsG, false);
      this.BsG.onExit();
      AppMethodBeat.o(82623);
    }
    
    public final void onAnimationStart()
    {
      AppMethodBeat.i(82622);
      MPVideoPlayFullScreenView.a(this.BsG, true);
      e.c localc = this.BsO;
      if (localc != null)
      {
        localc.onAnimationStart();
        AppMethodBeat.o(82622);
        return;
      }
      AppMethodBeat.o(82622);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoPlayFullScreenView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(82621);
        Object localObject = this.BsQ.BsG.getContext();
        if (((localObject instanceof WebViewUI)) && (((WebViewUI)localObject).eoY() != null))
        {
          localObject = this.BsQ.BsG.getContext();
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
            AppMethodBeat.o(82621);
            throw ((Throwable)localObject);
          }
          ((WebViewUI)localObject).eoY().leaveFullscreen();
        }
        MPVideoPlayFullScreenView.j(this.BsQ.BsG).setLayoutParams(this.BsQ.BsP);
        AppMethodBeat.o(82621);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82624);
      ProgressBar localProgressBar = MPVideoPlayFullScreenView.l(this.BsG);
      if ((localProgressBar == null) || (localProgressBar.getVisibility() != 0))
      {
        localProgressBar = MPVideoPlayFullScreenView.l(this.BsG);
        if (localProgressBar != null)
        {
          localProgressBar.setVisibility(0);
          AppMethodBeat.o(82624);
          return;
        }
      }
      AppMethodBeat.o(82624);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(82625);
      if (this.BsR) {
        MPVideoPlayFullScreenView.k(this.BsG).setVisibility(8);
      }
      for (;;)
      {
        Object localObject = MPVideoPlayFullScreenView.m(this.BsG);
        if (localObject == null) {
          break;
        }
        ((RedesignVideoPlayerSeekBar)localObject).gp(MPVideoPlayFullScreenView.n(this.BsG));
        AppMethodBeat.o(82625);
        return;
        localObject = MPVideoPlayFullScreenView.l(this.BsG);
        if ((localObject == null) || (((ProgressBar)localObject).getVisibility() != 0)) {
          MPVideoPlayFullScreenView.k(this.BsG).setVisibility(0);
        }
      }
      AppMethodBeat.o(82625);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView
 * JD-Core Version:    0.7.0.1
 */