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
import android.view.View.OnSystemUiVisibilityChangeListener;
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
import com.tencent.mm.ah.y;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.bo.a.a;
import com.tencent.mm.bo.a.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.tools.e.b;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.tools.e.d;
import com.tencent.mm.ui.tools.e.e;
import com.tencent.mm.ui.tools.e.f;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.u;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ENTER_HIDE_MIL_SEC", "", "INVALID_ORIENTATION", "", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/view/View;", "centerPlayIv", "closeIv", "currentPlayTime", "", "enterId", "getEnterId", "()I", "setEnterId", "(I)V", "enterTimeInMs", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "footerLayout", "forbidForward", "", "getForbidForward", "()Z", "setForbidForward", "(Z)V", "forwardUiVisibility", "hasAddVideoView", "hasAdjustOrientation", "hideToolBarTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "imagePreviewAnimation", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;", "isLandScapeVideo", "isPlaying", "isRunningExitAnimation", "loadingBar", "Landroid/widget/ProgressBar;", "mCurrentOrientation", "mIsShowOpLayout", "mPreOrientation", "moreIv", "moreLayout", "mpInfoLayout", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "mpShareVideoReport", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "getMpShareVideoReport", "()Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "needDoAnimation", "nicknameTv", "Landroid/widget/TextView;", "orientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "preDeltaX", "preDeltaY", "preScale", "", "shareIv", "subScene", "getSubScene", "()Ljava/lang/Integer;", "setSubScene", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "toolBarMask", "touchLayout", "videoContainerLayout", "Landroid/view/ViewGroup;", "videoControl", "Lcom/tencent/xweb/VideoControl;", "videoPlayOpLayout", "videoPlayRootLayout", "videoPlayerSeekBar", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "videoRootLayout", "addVideoView", "", "view", "adjustOrientation", "exit", "fadeInAnimation", "Landroid/view/animation/Animation;", "fadeInOpLayout", "fadeOutAnimation", "duration", "fadeOutOpLayout", "force", "handleAnimation", "handleFullScreenStatusBar", "fullScreen", "handleHorizontalUI", "handleScreenSize", "handleVerticalUI", "hideLoading", "hideToolBar", "initData", "initReportData", "initSeekBar", "initVideoController", "initView", "isInFullScreen", "loadAvatar", "onClick", "v", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onExit", "onExitMpVideoFullPage", "onResume", "opPlay", "postHandleVerticalUI", "removeVideoView", "resetOrientation", "runDragAnimation", "runEnterAnimation", "runExitAnimation", "bm", "Landroid/graphics/Bitmap;", "callback", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "showLoading", "showToolBar", "starHideToolBar", "startHideToolBarTimer", "stopHideToolBarTimer", "supportFullScreen", "updatePlayBtn", "playing", "plugin-webview_release"})
public final class MPVideoPlayFullScreenView
  extends RelativeLayout
  implements View.OnClickListener
{
  public int ArA;
  public float Ary;
  public int Arz;
  private RedesignVideoPlayerSeekBar BAO;
  public boolean BAY;
  private boolean EGA;
  public View EGe;
  private View EGf;
  private ViewGroup EGg;
  public ViewGroup EGh;
  private View EGi;
  private View EGj;
  private View EGk;
  private View EGl;
  private View EGm;
  private View EGn;
  public u EGo;
  private double EGp;
  private final int EGq;
  private int EGr;
  private boolean EGs;
  private boolean EGt;
  private boolean EGu;
  private final h EGv;
  private boolean EGw;
  private Integer EGx;
  private aw EGy;
  private final long EGz;
  private com.tencent.mm.bo.a EuP;
  private View Jip;
  public final String TAG;
  private ImageView fTj;
  private ProgressBar gYT;
  public y hCc;
  private boolean hGJ;
  private boolean lVw;
  private int mCurrentOrientation;
  private int oAb;
  public com.tencent.mm.ui.tools.e oMQ;
  private View ojN;
  private View oln;
  private int otX;
  private TextView ovs;
  private MMNeat7extView ovt;
  private long oyj;
  private View rYg;
  
  public MPVideoPlayFullScreenView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82641);
    this.TAG = "MicroMsg.MPVideoPlayFullScreenView";
    this.EGq = -3;
    this.EGr = this.EGq;
    this.mCurrentOrientation = -1;
    this.EuP = new com.tencent.mm.bo.a(paramContext, (a.b)new j(this, paramContext));
    this.EGv = new h();
    View.inflate(paramContext, 2131494955, (ViewGroup)this);
    paramAttributeSet = findViewById(2131306368);
    p.g(paramAttributeSet, "findViewById(R.id.video_play_root_layout)");
    this.EGe = paramAttributeSet;
    paramAttributeSet = findViewById(2131306366);
    p.g(paramAttributeSet, "findViewById(R.id.video_play_op_layout)");
    this.EGf = paramAttributeSet;
    paramAttributeSet = findViewById(2131306318);
    p.g(paramAttributeSet, "findViewById(R.id.video_container_layout)");
    this.EGg = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131306372);
    p.g(paramAttributeSet, "findViewById(R.id.video_player_footer)");
    this.EGi = paramAttributeSet;
    paramAttributeSet = findViewById(2131302495);
    p.g(paramAttributeSet, "findViewById(R.id.mp_info_layout)");
    this.EGj = paramAttributeSet;
    paramAttributeSet = findViewById(2131306408);
    p.g(paramAttributeSet, "findViewById(R.id.video_touch_layout)");
    this.EGk = paramAttributeSet;
    paramAttributeSet = findViewById(2131302498);
    p.g(paramAttributeSet, "findViewById(R.id.mp_video_avatar_layout)");
    this.rYg = paramAttributeSet;
    paramAttributeSet = findViewById(2131302497);
    p.g(paramAttributeSet, "findViewById(R.id.mp_video_avatar_iv)");
    this.fTj = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131302508);
    p.g(paramAttributeSet, "findViewById(R.id.mp_video_nickname_tv)");
    this.ovs = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131302513);
    p.g(paramAttributeSet, "findViewById(R.id.mp_video_title_tv)");
    this.ovt = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131302514);
    p.g(paramAttributeSet, "findViewById(R.id.mp_video_view_article_layout)");
    this.oln = paramAttributeSet;
    this.BAO = ((RedesignVideoPlayerSeekBar)findViewById(2131306375));
    this.Jip = findViewById(2131308530);
    this.gYT = ((ProgressBar)findViewById(2131306374));
    paramAttributeSet = this.BAO;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)this);
    }
    paramAttributeSet = this.EGi;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)1.EGB);
    }
    paramAttributeSet = this.EGj;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)2.EGC);
    }
    this.rYg.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        Object localObject1 = null;
        AppMethodBeat.i(82585);
        Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject2).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).ahF());
        if (MPVideoPlayFullScreenView.g(this.EGD) != null)
        {
          paramAnonymousView = MPVideoPlayFullScreenView.g(this.EGD);
          if (paramAnonymousView == null) {
            break label203;
          }
        }
        label203:
        for (paramAnonymousView = paramAnonymousView.dpP;; paramAnonymousView = null)
        {
          if (bu.isNullOrNil(paramAnonymousView)) {
            ae.w(MPVideoPlayFullScreenView.a(this.EGD), "srcUserName is null");
          }
          localObject2 = new Intent();
          y localy = MPVideoPlayFullScreenView.g(this.EGD);
          paramAnonymousView = localObject1;
          if (localy != null) {
            paramAnonymousView = localy.dpP;
          }
          ((Intent)localObject2).putExtra("Contact_User", paramAnonymousView);
          ((Intent)localObject2).putExtra("Contact_Scene", 163);
          ((Intent)localObject2).putExtra("force_get_contact", true);
          ((Intent)localObject2).putExtra("key_use_new_contact_profile", true);
          com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
          com.tencent.mm.plugin.report.service.g.yxI.f(18589, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(82585);
          return;
        }
      }
    });
    o.gY(this.rYg);
    paramAttributeSet = findViewById(2131306371);
    p.g(paramAttributeSet, "findViewById(R.id.video_player_close)");
    this.ojN = paramAttributeSet;
    this.ojN.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82586);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        this.EGD.exit();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82586);
      }
    });
    paramAttributeSet = findViewById(2131306373);
    p.g(paramAttributeSet, "findViewById(R.id.video_player_more_iv)");
    this.EGl = paramAttributeSet;
    this.EGl.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82587);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = MPVideoPlayFullScreenView.g(this.EGD);
        if (paramAnonymousView != null)
        {
          localObject = g.EHb;
          g.a(paramContext, paramAnonymousView, 4);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82587);
      }
    });
    paramAttributeSet = findViewById(2131306376);
    p.g(paramAttributeSet, "findViewById(R.id.video_player_share_iv)");
    this.EGn = paramAttributeSet;
    this.EGn.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82588);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        paramAnonymousView = paramContext;
        if (((paramAnonymousView instanceof WebViewUI)) && (MPVideoPlayFullScreenView.g(this.EGD) != null)) {
          if (x.fjm())
          {
            localObject1 = g.EHb;
            localObject1 = MPVideoPlayFullScreenView.g(this.EGD);
            if (localObject1 == null) {
              p.gkB();
            }
            g.a(paramAnonymousView, (y)localObject1, 5);
            com.tencent.mm.plugin.report.service.g.yxI.f(18589, new Object[] { Integer.valueOf(16), Integer.valueOf(3) });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(82588);
          return;
          ((WebViewUI)paramAnonymousView).Ewq.hCc = MPVideoPlayFullScreenView.g(this.EGD);
          localObject1 = d.EGT;
          localObject1 = MPVideoPlayFullScreenView.g(this.EGD);
          if (localObject1 == null) {
            p.gkB();
          }
          localObject1 = ((y)localObject1).hGe;
          Object localObject2 = MPVideoPlayFullScreenView.g(this.EGD);
          if (localObject2 == null) {
            p.gkB();
          }
          localObject2 = ((y)localObject2).title;
          y localy = MPVideoPlayFullScreenView.g(this.EGD);
          if (localy == null) {
            p.gkB();
          }
          d.a(paramAnonymousView, (String)localObject1, "", (String)localObject2, localy.FUw, 2);
          break;
          ae.w(MPVideoPlayFullScreenView.a(this.EGD), "should not be here");
        }
      }
    });
    paramContext = findViewById(2131306413);
    p.g(paramContext, "findViewById(R.id.video_wait_play_btn)");
    this.EGm = paramContext;
    this.EGm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82589);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        MPVideoPlayFullScreenView.B(this.EGD);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82589);
      }
    });
    this.oln.setVisibility(8);
    paramContext = this.BAO;
    if (paramContext != null) {
      paramContext.setPlayBtnOnClickListener((View.OnClickListener)this);
    }
    paramContext = this.BAO;
    if (paramContext != null) {
      paramContext.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new h(this));
    }
    this.Ary = 1.0F;
    this.EGy = new aw((aw.a)new g(this), true);
    this.EGz = 4000L;
    AppMethodBeat.o(82641);
  }
  
  private final void eYC()
  {
    AppMethodBeat.i(82626);
    if (this.oMQ == null) {
      this.oMQ = new com.tencent.mm.ui.tools.e(getContext());
    }
    if (this.hCc == null)
    {
      this.EGw = true;
      AppMethodBeat.o(82626);
      return;
    }
    this.EGw = false;
    Object localObject = this.hCc;
    if (localObject == null) {
      p.gkB();
    }
    int i = ((y)localObject).hGC;
    localObject = this.hCc;
    if (localObject == null) {
      p.gkB();
    }
    int j = ((y)localObject).hGD;
    localObject = this.hCc;
    if (localObject == null) {
      p.gkB();
    }
    int k = ((y)localObject).hGE;
    localObject = this.hCc;
    if (localObject == null) {
      p.gkB();
    }
    int m = ((y)localObject).hGF;
    localObject = this.oMQ;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.e)localObject).R(i, j, k, m);
    }
    localObject = this.oMQ;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.e)localObject).fOM();
    }
    localObject = this.oMQ;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.e)localObject).ki(0, 0);
    }
    eYD();
    AppMethodBeat.o(82626);
  }
  
  private final void eYD()
  {
    AppMethodBeat.i(82627);
    Object localObject = this.EGh;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getViewTreeObserver();
      if (localObject != null)
      {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new p(this));
        AppMethodBeat.o(82627);
        return;
      }
    }
    AppMethodBeat.o(82627);
  }
  
  private final void eYE()
  {
    AppMethodBeat.i(82631);
    if (this.lVw)
    {
      localu = this.EGo;
      if (localu != null)
      {
        localu.ewR();
        AppMethodBeat.o(82631);
        return;
      }
      AppMethodBeat.o(82631);
      return;
    }
    u localu = this.EGo;
    if (localu != null)
    {
      localu.gfi();
      AppMethodBeat.o(82631);
      return;
    }
    AppMethodBeat.o(82631);
  }
  
  private final void eYF()
  {
    try
    {
      AppMethodBeat.i(199366);
      Object localObject1 = getContext();
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(199366);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    Activity localActivity = (Activity)localObject2;
    if (this.hCc == null)
    {
      ae.d(this.TAG, "adjustOrientation mpShareVideoInfo is null");
      AppMethodBeat.o(199366);
    }
    for (;;)
    {
      return;
      if ((!this.EGt) && (this.EGu)) {
        break;
      }
      ae.i(this.TAG, "adjustOrientation hasAdjustOrientation=" + this.EGt + ", hasAddVideoView=" + this.EGu);
      AppMethodBeat.o(199366);
    }
    this.EGt = true;
    if (this.EGr == this.EGq) {
      this.EGr = localActivity.getRequestedOrientation();
    }
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("adjustOrientation width = ");
    y localy = this.hCc;
    if (localy == null) {
      p.gkB();
    }
    localStringBuilder = localStringBuilder.append(localy.width).append(", height=");
    localy = this.hCc;
    if (localy == null) {
      p.gkB();
    }
    ae.i((String)localObject3, localy.height);
    localObject3 = this.hCc;
    if (localObject3 == null) {
      p.gkB();
    }
    int i = ((y)localObject3).width;
    localObject3 = this.hCc;
    if (localObject3 == null) {
      p.gkB();
    }
    if (i <= ((y)localObject3).height)
    {
      this.mCurrentOrientation = 1;
      localActivity.setRequestedOrientation(this.mCurrentOrientation);
      this.EGs = false;
    }
    for (;;)
    {
      eYM();
      AppMethodBeat.o(199366);
      break;
      this.EGs = true;
      this.mCurrentOrientation = 0;
      localActivity.setRequestedOrientation(this.mCurrentOrientation);
      this.EuP.enable();
    }
  }
  
  private final void eYI()
  {
    boolean bool = true;
    AppMethodBeat.i(82635);
    Object localObject = this.TAG;
    if (this.EGf.getVisibility() == 0) {}
    for (;;)
    {
      ae.d((String)localObject, "fadeOutOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = eYJ();
      ((Animation)localObject).setFillAfter(false);
      ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this));
      this.EGf.clearAnimation();
      this.EGf.startAnimation((Animation)localObject);
      AppMethodBeat.o(82635);
      return;
      bool = false;
    }
  }
  
  private static Animation eYJ()
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
  
  private final void eYK()
  {
    AppMethodBeat.i(82638);
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(82638);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getWindow();
    p.g(localObject, "(context as Activity).window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "contentRoot");
    ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new e(this, (View)localObject));
    AppMethodBeat.o(82638);
  }
  
  private final void eYL()
  {
    AppMethodBeat.i(82639);
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(82639);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getWindow();
    p.g(localObject, "(context as Activity).window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "contentRoot");
    ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new d(this, (View)localObject));
    AppMethodBeat.o(82639);
  }
  
  private final void eYM()
  {
    AppMethodBeat.i(182654);
    if ((this.mCurrentOrientation == 0) || (this.mCurrentOrientation == 8))
    {
      eYL();
      AppMethodBeat.o(182654);
      return;
    }
    eYK();
    AppMethodBeat.o(182654);
  }
  
  private final int getSubScene$1385f2()
  {
    Object localObject2 = null;
    AppMethodBeat.i(82633);
    Object localObject1 = getContext();
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type android.app.Activity");
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
        localObject1 = ((com.tencent.mm.plugin.webview.core.b)localObject3).bRn();
      }
    }
    for (;;)
    {
      try
      {
        int j = bu.getInt(Uri.parse((String)localObject1).getQueryParameter("scene"), 10000);
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
    this.EGg.removeAllViews();
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
      AppMethodBeat.o(82632);
      throw ((Throwable)localObject);
    }
    ((WebViewUI)localObject).setMMOrientation();
    AppMethodBeat.o(82632);
  }
  
  private final void vw(boolean paramBoolean)
  {
    AppMethodBeat.i(182653);
    ae.i(this.TAG, "handleFullScreenStatusBar forwardUiVisibility " + this.oAb);
    if (paramBoolean)
    {
      localObject1 = getContext();
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(182653);
        throw ((Throwable)localObject1);
      }
      localObject1 = (Activity)localObject1;
      localObject2 = ((Activity)localObject1).getWindow();
      p.g(localObject2, "activity.window");
      localObject2 = ((Window)localObject2).getDecorView();
      if (localObject2 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(182653);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup)localObject2;
      this.oAb = ((ViewGroup)localObject2).getSystemUiVisibility();
      ((ViewGroup)localObject2).setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)new c(this, (ViewGroup)localObject2));
      ((ViewGroup)localObject2).setSystemUiVisibility(4102);
      ((Activity)localObject1).getWindow().addFlags(1024);
      AppMethodBeat.o(182653);
      return;
    }
    Object localObject1 = getContext();
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(182653);
      throw ((Throwable)localObject1);
    }
    localObject1 = (Activity)localObject1;
    Object localObject2 = ((Activity)localObject1).getWindow();
    p.g(localObject2, "activity.window");
    localObject2 = ((Window)localObject2).getDecorView();
    if (localObject2 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(182653);
      throw ((Throwable)localObject1);
    }
    ((ViewGroup)localObject2).setSystemUiVisibility(this.oAb);
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
        AppMethodBeat.i(199363);
        p.h(paramy, "mpShareVideoInfo");
        this.hCc = paramy;
        this.hGJ = paramy.hGJ;
        paramy = this.ovt.getPaint();
        p.g(paramy, "titleTv.paint");
        paramy.setFakeBoldText(true);
        paramy = this.ovs.getPaint();
        p.g(paramy, "nicknameTv.paint");
        paramy.setFakeBoldText(true);
        localObject = this.ovt;
        paramy = this.hCc;
        if (paramy != null)
        {
          paramy = paramy.title;
          ((MMNeat7extView)localObject).aq((CharSequence)paramy);
          localObject = this.ovs;
          Context localContext = getContext();
          paramy = this.hCc;
          if (paramy != null)
          {
            paramy = paramy.hFW;
            ((TextView)localObject).setText((CharSequence)k.b(localContext, (CharSequence)paramy, this.ovs.getTextSize()));
            if (!this.hGJ) {
              continue;
            }
            this.EGl.setVisibility(8);
            this.EGn.setVisibility(8);
            localObject = getContext();
            if ((localObject instanceof WebViewUI))
            {
              paramy = this.hCc;
              if (paramy == null) {
                break label311;
              }
              paramy = paramy.hGI;
              if (bu.isNullOrNil(paramy)) {
                break label321;
              }
              paramy = this.hCc;
              if (paramy == null) {
                break label316;
              }
              paramy = paramy.hGI;
              com.tencent.mm.av.a.a.aJh().a(paramy, this.fTj, new c.a().aJs().pK(2131231342).aJu());
            }
            if (this.EGw) {
              eYC();
            }
            ae.d(this.TAG, "initData");
            eYF();
            AppMethodBeat.o(199363);
          }
        }
        else
        {
          paramy = null;
          continue;
        }
        paramy = null;
        continue;
        this.EGl.setVisibility(0);
        this.EGn.setVisibility(0);
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
      paramy = ((WebViewUI)localObject).eWi();
      if (paramy != null)
      {
        paramy = paramy.bLE();
        if (paramy != null)
        {
          paramy = paramy.dEM;
          continue;
        }
      }
      paramy = null;
    }
  }
  
  public final boolean bnx()
  {
    AppMethodBeat.i(199365);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(199365);
      return true;
    }
    AppMethodBeat.o(199365);
    return false;
  }
  
  @SuppressLint({"WrongConstant"})
  public final void eYG()
  {
    AppMethodBeat.i(182652);
    if (this.EGr != this.EGq)
    {
      Object localObject = getContext();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(182652);
        throw ((Throwable)localObject);
      }
      ((Activity)localObject).setRequestedOrientation(this.EGr);
      this.EGr = this.EGq;
      this.EuP.disable();
    }
    vw(false);
    AppMethodBeat.o(182652);
  }
  
  public final void eYH()
  {
    AppMethodBeat.i(82634);
    if (j.IS_FLAVOR_RED) {
      ae.d(this.TAG, "hideOpLayer %s", new Object[] { bu.fpN() });
    }
    if (!this.EGA)
    {
      AppMethodBeat.o(82634);
      return;
    }
    this.EGA = false;
    eYI();
    AppMethodBeat.o(82634);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(82628);
    Context localContext = getContext();
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).eWY() != null))
    {
      if (((WebViewUI)localContext).eWY() != null)
      {
        ae.i(this.TAG, "close click");
        eYG();
        ((WebViewUI)localContext).eWY().leaveFullscreen();
        com.tencent.mm.sdk.platformtools.ar.o((Runnable)new a(this), 500L);
        AppMethodBeat.o(82628);
      }
    }
    else {
      ae.w(this.TAG, "should not be here");
    }
    AppMethodBeat.o(82628);
  }
  
  public final void fN(View paramView)
  {
    try
    {
      AppMethodBeat.i(199364);
      p.h(paramView, "view");
      if (this.hCc == null) {
        break label209;
      }
      localObject1 = this.hCc;
      if (localObject1 == null) {
        p.gkB();
      }
      ((y)localObject1).hGG = this.otX;
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramView = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        AppMethodBeat.o(199364);
        throw paramView;
      }
    }
    finally {}
    Object localObject2 = (WebViewUI)localObject1;
    Object localObject1 = ((WebViewUI)localObject2).lzT;
    if (localObject1 != null) {}
    try
    {
      localObject1 = this.EGv;
      localObject2 = ((WebViewUI)localObject2).lzT;
      y localy = this.hCc;
      if (localy == null) {
        p.gkB();
      }
      ((h)localObject1).oya = ((com.tencent.mm.plugin.webview.stub.e)localObject2).An(localy.dpP);
      this.EGv.scene = 141;
      this.EGv.otZ = getSubScene$1385f2();
    }
    catch (Exception localException)
    {
      label149:
      break label149;
    }
    this.oyj = System.currentTimeMillis();
    this.otX = ((int)(this.oyj / 1000L));
    this.EGv.a(this.hCc, 1, this.otX);
    this.EGv.a(this.hCc, 5, this.otX);
    this.EGv.iuK = 0;
    label209:
    removeVideoView();
    vw(true);
    this.EGe.setAlpha(1.0F);
    this.EGe.setBackgroundColor(-16777216);
    setVisibility(0);
    localObject1 = new FrameLayout(getContext());
    ((FrameLayout)localObject1).addView(paramView, new ViewGroup.LayoutParams(-1, -2));
    this.EGh = ((ViewGroup)localObject1);
    paramView = this.EGg;
    localObject1 = (View)this.EGh;
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    eYC();
    this.BAY = false;
    ae.d(this.TAG, "addVideoView");
    this.EGu = true;
    eYF();
    AppMethodBeat.o(199364);
  }
  
  public final int getEnterId()
  {
    return this.otX;
  }
  
  public final long getEnterTimeInMs()
  {
    return this.oyj;
  }
  
  public final boolean getForbidForward()
  {
    return this.hGJ;
  }
  
  public final h getMpShareVideoReport()
  {
    return this.EGv;
  }
  
  public final Integer getSubScene()
  {
    return this.EGx;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(82630);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((paramView != null) && (paramView.getId() == 2131303281)) {
      eYE();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(82630);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(82637);
    p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      ae.d(this.TAG, "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      eYK();
      AppMethodBeat.o(82637);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ae.d(this.TAG, "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
      eYL();
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
    ae.i(this.TAG, "onExitMpVideoFullPage");
    this.EGt = false;
    this.EGu = false;
    if (this.hCc != null)
    {
      this.EGv.oxY = ((int)(System.currentTimeMillis() - this.oyj));
      this.EGv.oxX = ((int)(this.EGp * 1000.0D));
      this.EGv.a(this.hCc, 6, this.otX);
      this.EGv.a(this.hCc, 2, this.otX);
      Object localObject = getContext();
      if (((localObject instanceof WebViewUI)) && (((WebViewUI)localObject).DRx != null))
      {
        localObject = ((WebViewUI)localObject).DRx;
        y localy = this.hCc;
        if (localy == null) {
          p.gkB();
        }
        ((f)localObject).fK(localy.FUx, (int)this.EGp);
      }
      this.hCc = null;
    }
    AppMethodBeat.o(82629);
  }
  
  public final void setEnterId(int paramInt)
  {
    this.otX = paramInt;
  }
  
  public final void setEnterTimeInMs(long paramLong)
  {
    this.oyj = paramLong;
  }
  
  public final void setForbidForward(boolean paramBoolean)
  {
    this.hGJ = paramBoolean;
  }
  
  public final void setSubScene(Integer paramInteger)
  {
    this.EGx = paramInteger;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82590);
      this.EGD.onExit();
      AppMethodBeat.o(82590);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$fadeOutOpLayout$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(82592);
      p.h(paramAnimation, "animation");
      if (!MPVideoPlayFullScreenView.r(this.EGD)) {
        MPVideoPlayFullScreenView.s(this.EGD);
      }
      AppMethodBeat.o(82592);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(82593);
      p.h(paramAnimation, "animation");
      AppMethodBeat.o(82593);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(82591);
      p.h(paramAnimation, "animation");
      AppMethodBeat.o(82591);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "visibility", "", "onSystemUiVisibilityChange"})
  static final class c
    implements View.OnSystemUiVisibilityChangeListener
  {
    c(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, ViewGroup paramViewGroup) {}
    
    public final void onSystemUiVisibilityChange(int paramInt)
    {
      AppMethodBeat.i(199362);
      if (((paramInt & 0x4) == 0) && (this.EGD.bnx())) {
        this.EGE.setSystemUiVisibility(5894);
      }
      AppMethodBeat.o(199362);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$handleHorizontalUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class d
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    d(View paramView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82594);
      Object localObject1 = this.EGF;
      p.g(localObject1, "contentRoot");
      ((View)localObject1).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      if (com.tencent.mm.compatible.util.d.lA(24))
      {
        localObject1 = this.EGD.getContext();
        if (localObject1 == null)
        {
          localObject1 = new d.v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(82594);
          throw ((Throwable)localObject1);
        }
        if (((Activity)localObject1).isInMultiWindowMode())
        {
          MPVideoPlayFullScreenView.t(this.EGD);
          AppMethodBeat.o(82594);
          return;
        }
      }
      int n = com.tencent.mm.ui.ar.en(this.EGD.getContext());
      int i = com.tencent.mm.cb.a.ay(this.EGD.getContext(), 2131165303);
      int j = i * 3;
      int k = i * 4;
      int m = i * 7;
      n = Math.max(n - i * 3, 0);
      MPVideoPlayFullScreenView.u(this.EGD).setPadding(n, i * 2, n - i, i * 2);
      localObject1 = MPVideoPlayFullScreenView.C(this.EGD);
      if (localObject1 != null)
      {
        ((View)localObject1).setPadding(0, 0, 0, 0);
        localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(82594);
          throw ((Throwable)localObject1);
        }
        localObject2 = (RelativeLayout.LayoutParams)localObject2;
        ((RelativeLayout.LayoutParams)localObject2).height = com.tencent.mm.cb.a.ax(this.EGD.getContext(), 2131165279);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject1 = MPVideoPlayFullScreenView.v(this.EGD).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(k, j, 0, j);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      MPVideoPlayFullScreenView.v(this.EGD).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = MPVideoPlayFullScreenView.w(this.EGD).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, j, k, j);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      MPVideoPlayFullScreenView.w(this.EGD).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = MPVideoPlayFullScreenView.x(this.EGD).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, j, k, j);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      MPVideoPlayFullScreenView.x(this.EGD).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = MPVideoPlayFullScreenView.m(this.EGD);
      if (localObject1 == null) {
        p.gkB();
      }
      localObject1 = ((RedesignVideoPlayerSeekBar)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131306371);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131306376);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(m, j, m, j);
      Object localObject2 = MPVideoPlayFullScreenView.m(this.EGD);
      if (localObject2 != null)
      {
        ((RedesignVideoPlayerSeekBar)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(82594);
        return;
      }
      AppMethodBeat.o(82594);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$handleVerticalUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class e
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    e(View paramView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82595);
      View localView = this.EGF;
      p.g(localView, "contentRoot");
      localView.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      MPVideoPlayFullScreenView.t(this.EGD);
      AppMethodBeat.o(82595);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82596);
      ProgressBar localProgressBar = MPVideoPlayFullScreenView.l(this.EGD);
      if ((localProgressBar != null) && (localProgressBar.getVisibility() == 0))
      {
        localProgressBar = MPVideoPlayFullScreenView.l(this.EGD);
        if (localProgressBar != null) {
          localProgressBar.setVisibility(8);
        }
      }
      if (!MPVideoPlayFullScreenView.n(this.EGD)) {
        MPVideoPlayFullScreenView.k(this.EGD).setVisibility(0);
      }
      AppMethodBeat.o(82596);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class g
    implements aw.a
  {
    g(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(82597);
      MPVideoPlayFullScreenView.i(this.EGD);
      AppMethodBeat.o(82597);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$initSeekBar$1", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-webview_release"})
  public static final class h
    implements com.tencent.mm.plugin.sight.decode.ui.b
  {
    public final void aqS() {}
    
    public final void nP(int paramInt)
    {
      AppMethodBeat.i(82598);
      ae.i(MPVideoPlayFullScreenView.a(this.EGD), "initSeekBar onSeekTo ".concat(String.valueOf(paramInt)));
      u localu = MPVideoPlayFullScreenView.o(this.EGD);
      if (localu != null)
      {
        localu.G(paramInt);
        AppMethodBeat.o(82598);
        return;
      }
      AppMethodBeat.o(82598);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$initVideoController$1", "Lcom/tencent/xweb/VideoJsCallback;", "lastUpdateTime", "", "getLastUpdateTime", "()J", "setLastUpdateTime", "(J)V", "onSetRequestedOrientation", "", "orientation", "", "onVideoEmptied", "", "onVideoEnded", "onVideoEnterFullscreen", "isVideoTag", "id", "width", "", "height", "paused", "seeking", "currentTime", "duration", "buffered", "", "onVideoError", "error", "msg", "", "onVideoExitFullscreen", "onVideoPause", "onVideoPlay", "onVideoPlaying", "onVideoSeeked", "onVideoSeeking", "onVideoSizeUpdate", "onVideoTimeUpdate", "onVideoWaiting", "plugin-webview_release"})
  public static final class i
    implements com.tencent.xweb.v
  {
    private long lastUpdateTime;
    
    public final void bpR()
    {
      AppMethodBeat.i(82602);
      ae.i(MPVideoPlayFullScreenView.a(this.EGD), "onVideoEmptied");
      MPVideoPlayFullScreenView.p(this.EGD);
      AppMethodBeat.o(82602);
    }
    
    public final void onVideoEnded()
    {
      AppMethodBeat.i(82600);
      ae.i(MPVideoPlayFullScreenView.a(this.EGD), "onVideoEnded");
      MPVideoPlayFullScreenView.c(this.EGD, false);
      MPVideoPlayFullScreenView.p(this.EGD);
      this.EGD.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.EGD), 7, this.EGD.getEnterId());
      this.EGD.getMpShareVideoReport().iuK = 4;
      AppMethodBeat.o(82600);
    }
    
    public final void onVideoEnterFullscreen(boolean paramBoolean1, long paramLong, double paramDouble1, double paramDouble2, boolean paramBoolean2, boolean paramBoolean3, double paramDouble3, double paramDouble4, double[] paramArrayOfDouble)
    {
      AppMethodBeat.i(82609);
      ae.i(MPVideoPlayFullScreenView.a(this.EGD), "onVideoEnterFullscreen isVideoTag:" + paramBoolean1 + ", id:" + paramLong + ", width:" + paramDouble1 + ", height:" + paramDouble2 + ", paused:" + paramBoolean2 + ", seeking:" + paramBoolean3 + ", currentTime:" + paramDouble3 + ", duration:" + paramDouble4 + ", buffered:" + Arrays.toString(paramArrayOfDouble));
      paramArrayOfDouble = this.EGD;
      if (!paramBoolean2) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        MPVideoPlayFullScreenView.b(paramArrayOfDouble, paramBoolean1);
        MPVideoPlayFullScreenView.c(this.EGD, MPVideoPlayFullScreenView.n(this.EGD));
        if (MPVideoPlayFullScreenView.n(this.EGD))
        {
          this.EGD.getMpShareVideoReport().iuK = 1;
          this.EGD.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.EGD), this.EGD.getMpShareVideoReport().eYQ(), this.EGD.getEnterId());
        }
        AppMethodBeat.o(82609);
        return;
      }
    }
    
    public final void onVideoError(int paramInt, String paramString)
    {
      AppMethodBeat.i(82601);
      ae.e(MPVideoPlayFullScreenView.a(this.EGD), "onVideoError " + paramInt + ", " + paramString);
      MPVideoPlayFullScreenView.c(this.EGD, false);
      MPVideoPlayFullScreenView.p(this.EGD);
      this.EGD.getMpShareVideoReport().iuK = 4;
      this.EGD.getMpShareVideoReport().oxZ = paramString;
      this.EGD.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.EGD), 11, this.EGD.getEnterId());
      AppMethodBeat.o(82601);
    }
    
    public final void onVideoExitFullscreen()
    {
      AppMethodBeat.i(82610);
      ae.i(MPVideoPlayFullScreenView.a(this.EGD), "onVideoExitFullscreen");
      AppMethodBeat.o(82610);
    }
    
    public final void onVideoPause()
    {
      AppMethodBeat.i(82608);
      ae.i(MPVideoPlayFullScreenView.a(this.EGD), "onVideoPause");
      MPVideoPlayFullScreenView.c(this.EGD, false);
      MPVideoPlayFullScreenView.p(this.EGD);
      if (this.EGD.getMpShareVideoReport().iuK != 3) {
        this.EGD.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.EGD), 8, this.EGD.getEnterId());
      }
      this.EGD.getMpShareVideoReport().iuK = 3;
      AppMethodBeat.o(82608);
    }
    
    public final void onVideoPlay()
    {
      AppMethodBeat.i(82607);
      ae.i(MPVideoPlayFullScreenView.a(this.EGD), "onVideoPlay");
      MPVideoPlayFullScreenView.c(this.EGD, true);
      MPVideoPlayFullScreenView.p(this.EGD);
      if (this.EGD.getMpShareVideoReport().iuK != 2) {
        this.EGD.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.EGD), this.EGD.getMpShareVideoReport().eYQ(), this.EGD.getEnterId());
      }
      this.EGD.getMpShareVideoReport().iuK = 2;
      AppMethodBeat.o(82607);
    }
    
    public final void onVideoPlaying()
    {
      AppMethodBeat.i(82603);
      ae.d(MPVideoPlayFullScreenView.a(this.EGD), "onVideoPlaying");
      if (!MPVideoPlayFullScreenView.n(this.EGD))
      {
        MPVideoPlayFullScreenView.c(this.EGD, true);
        MPVideoPlayFullScreenView.p(this.EGD);
      }
      this.EGD.getMpShareVideoReport().iuK = 2;
      AppMethodBeat.o(82603);
    }
    
    public final void onVideoSeeked()
    {
      AppMethodBeat.i(82606);
      ae.i(MPVideoPlayFullScreenView.a(this.EGD), "onVideoSeeked");
      MPVideoPlayFullScreenView.p(this.EGD);
      this.EGD.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.EGD), 13, this.EGD.getEnterId());
      AppMethodBeat.o(82606);
    }
    
    public final void onVideoSeeking()
    {
      AppMethodBeat.i(82605);
      ae.i(MPVideoPlayFullScreenView.a(this.EGD), "onVideoSeeking");
      MPVideoPlayFullScreenView.q(this.EGD);
      AppMethodBeat.o(82605);
    }
    
    public final void onVideoSizeUpdate(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(82612);
      y localy = MPVideoPlayFullScreenView.g(this.EGD);
      if ((localy == null) || (localy.width != 0))
      {
        localy = MPVideoPlayFullScreenView.g(this.EGD);
        if (localy != null) {
          if (localy.height != 0) {
            break label103;
          }
        }
      }
      else
      {
        localy = MPVideoPlayFullScreenView.g(this.EGD);
        if (localy != null) {
          localy.width = ((int)paramDouble1);
        }
        localy = MPVideoPlayFullScreenView.g(this.EGD);
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
        com.tencent.mm.sdk.platformtools.ar.f((Runnable)new a(this, paramDouble2, paramDouble1, paramArrayOfDouble));
      }
      MPVideoPlayFullScreenView.a(this.EGD, paramDouble1);
      MPVideoPlayFullScreenView.p(this.EGD);
      AppMethodBeat.o(82611);
    }
    
    public final void onVideoWaiting()
    {
      AppMethodBeat.i(82604);
      ae.i(MPVideoPlayFullScreenView.a(this.EGD), "onVideoWaiting");
      MPVideoPlayFullScreenView.q(this.EGD);
      AppMethodBeat.o(82604);
    }
    
    public final boolean tL(int paramInt)
    {
      return false;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoPlayFullScreenView.i parami, double paramDouble1, double paramDouble2, double[] paramArrayOfDouble) {}
      
      public final void run()
      {
        int j = 1;
        AppMethodBeat.i(82599);
        Object localObject = MPVideoPlayFullScreenView.m(this.EGG.EGD);
        if (localObject != null) {
          ((RedesignVideoPlayerSeekBar)localObject).setVideoTotalTime((int)paramDouble2);
        }
        localObject = MPVideoPlayFullScreenView.m(this.EGG.EGD);
        if (localObject != null) {
          ((RedesignVideoPlayerSeekBar)localObject).tx((int)paramArrayOfDouble);
        }
        localObject = this.EGJ;
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
            RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = MPVideoPlayFullScreenView.m(this.EGG.EGD);
            if (localRedesignVideoPlayerSeekBar == null) {
              break label133;
            }
            p.h(localObject, "$this$lastIndex");
            localRedesignVideoPlayerSeekBar.aac((int)localObject[(localObject.length - 1)]);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class j
    implements a.b
  {
    j(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, Context paramContext) {}
    
    public final void a(a.a parama1, a.a parama2)
    {
      AppMethodBeat.i(182651);
      if (MPVideoPlayFullScreenView.y(this.EGD))
      {
        parama1 = this.EGD;
        if (parama2 == null)
        {
          AppMethodBeat.o(182651);
          return;
        }
        switch (b.cqt[parama2.ordinal()])
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
          parama1 = new d.v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(182651);
          throw parama1;
        }
        ((Activity)parama1).setRequestedOrientation(MPVideoPlayFullScreenView.z(this.EGD));
        MPVideoPlayFullScreenView.A(this.EGD);
      }
      AppMethodBeat.o(182651);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onExit"})
  static final class k
    implements e.b
  {
    k(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void onExit()
    {
      AppMethodBeat.i(82613);
      this.EGD.exit();
      AppMethodBeat.o(82613);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "longClickOver"})
  static final class l
    implements e.d
  {
    l(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void aRP()
    {
      AppMethodBeat.i(82614);
      if (!this.EGD.getForbidForward())
      {
        y localy = MPVideoPlayFullScreenView.g(this.EGD);
        if (localy != null)
        {
          Object localObject = g.EHb;
          localObject = this.EGD.getContext();
          p.g(localObject, "context");
          g.a((Context)localObject, localy, 3);
          AppMethodBeat.o(82614);
          return;
        }
      }
      AppMethodBeat.o(82614);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onClick"})
  static final class m
    implements e.f
  {
    m(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(82615);
      if (MPVideoPlayFullScreenView.h(this.EGD).getVisibility() == 0)
      {
        MPVideoPlayFullScreenView.i(this.EGD);
        AppMethodBeat.o(82615);
        return;
      }
      MPVideoPlayFullScreenView.f(this.EGD);
      AppMethodBeat.o(82615);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "tx", "", "ty", "onGalleryScale"})
  static final class n
    implements e.e
  {
    n(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void O(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(82616);
      if ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F))
      {
        MPVideoPlayFullScreenView.f(this.EGD);
        AppMethodBeat.o(82616);
        return;
      }
      if ((Math.abs(paramFloat1) > 10.0F) || (Math.abs(paramFloat2) > 10.0F)) {
        MPVideoPlayFullScreenView.i(this.EGD);
      }
      AppMethodBeat.o(82616);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    public static final o EGK;
    
    static
    {
      AppMethodBeat.i(82618);
      EGK = new o();
      AppMethodBeat.o(82618);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(82617);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runDragAnimation$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runDragAnimation$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(82617);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runEnterAnimation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class p
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82620);
      ae.d(MPVideoPlayFullScreenView.a(this.EGD), "runEnterAnimation");
      Object localObject = MPVideoPlayFullScreenView.b(this.EGD);
      if (localObject != null)
      {
        localObject = ((ViewGroup)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      localObject = MPVideoPlayFullScreenView.b(this.EGD);
      if (localObject != null) {}
      for (localObject = Integer.valueOf(((ViewGroup)localObject).getHeight());; localObject = null)
      {
        if (localObject == null) {
          p.gkB();
        }
        if (((Integer)localObject).intValue() > 0) {
          break;
        }
        MPVideoPlayFullScreenView.c(this.EGD);
        AppMethodBeat.o(82620);
        return;
      }
      MPVideoPlayFullScreenView.d(this.EGD);
      localObject = MPVideoPlayFullScreenView.e(this.EGD);
      if (localObject != null)
      {
        ViewGroup localViewGroup = MPVideoPlayFullScreenView.b(this.EGD);
        if (localViewGroup == null) {
          p.gkB();
        }
        ((com.tencent.mm.ui.tools.e)localObject).a((View)localViewGroup, null, (e.c)new a(this));
        AppMethodBeat.o(82620);
        return;
      }
      AppMethodBeat.o(82620);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runEnterAnimation$1$onGlobalLayout$1", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-webview_release"})
    public static final class a
      implements e.c
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(82619);
        MPVideoPlayFullScreenView.f(this.EGL.EGD);
        AppMethodBeat.o(82619);
      }
      
      public final void onAnimationStart() {}
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runExitAnimation$2", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-webview_release"})
  public static final class q
    implements e.c
  {
    public q(e.c paramc) {}
    
    public final void onAnimationEnd()
    {
      AppMethodBeat.i(82623);
      e.c localc = this.EGM;
      if (localc != null) {
        localc.onAnimationEnd();
      }
      MPVideoPlayFullScreenView.j(this.EGD).post((Runnable)new a(this));
      MPVideoPlayFullScreenView.a(this.EGD, false);
      this.EGD.onExit();
      AppMethodBeat.o(82623);
    }
    
    public final void onAnimationStart()
    {
      AppMethodBeat.i(82622);
      MPVideoPlayFullScreenView.a(this.EGD, true);
      e.c localc = this.EGM;
      if (localc != null)
      {
        localc.onAnimationStart();
        AppMethodBeat.o(82622);
        return;
      }
      AppMethodBeat.o(82622);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoPlayFullScreenView.q paramq) {}
      
      public final void run()
      {
        AppMethodBeat.i(82621);
        Object localObject = this.EGO.EGD.getContext();
        if (((localObject instanceof WebViewUI)) && (((WebViewUI)localObject).eWY() != null))
        {
          localObject = this.EGO.EGD.getContext();
          if (localObject == null)
          {
            localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
            AppMethodBeat.o(82621);
            throw ((Throwable)localObject);
          }
          ((WebViewUI)localObject).eWY().leaveFullscreen();
        }
        MPVideoPlayFullScreenView.j(this.EGO.EGD).setLayoutParams(this.EGO.EGN);
        AppMethodBeat.o(82621);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82624);
      ProgressBar localProgressBar = MPVideoPlayFullScreenView.l(this.EGD);
      if ((localProgressBar == null) || (localProgressBar.getVisibility() != 0))
      {
        localProgressBar = MPVideoPlayFullScreenView.l(this.EGD);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(82625);
      if (this.EGP) {
        MPVideoPlayFullScreenView.k(this.EGD).setVisibility(8);
      }
      for (;;)
      {
        Object localObject = MPVideoPlayFullScreenView.m(this.EGD);
        if (localObject == null) {
          break;
        }
        ((RedesignVideoPlayerSeekBar)localObject).gS(MPVideoPlayFullScreenView.n(this.EGD));
        AppMethodBeat.o(82625);
        return;
        localObject = MPVideoPlayFullScreenView.l(this.EGD);
        if ((localObject == null) || (((ProgressBar)localObject).getVisibility() != 0)) {
          MPVideoPlayFullScreenView.k(this.EGD).setVisibility(0);
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