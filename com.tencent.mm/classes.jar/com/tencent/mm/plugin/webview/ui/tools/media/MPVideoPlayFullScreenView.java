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
import com.tencent.mm.aj.y;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.br.a.a;
import com.tencent.mm.br.a.b;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.b;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.ui.tools.f.d;
import com.tencent.mm.ui.tools.f.e;
import com.tencent.mm.ui.tools.f.f;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.u;
import com.tencent.xweb.v;
import java.util.Arrays;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ENTER_HIDE_MIL_SEC", "", "INVALID_ORIENTATION", "", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/view/View;", "centerPlayIv", "closeIv", "currentPlayTime", "", "enterId", "getEnterId", "()I", "setEnterId", "(I)V", "enterTimeInMs", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "footerLayout", "forbidForward", "", "getForbidForward", "()Z", "setForbidForward", "(Z)V", "forwardUiVisibility", "hasAddVideoView", "hasAdjustOrientation", "hideToolBarTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "imagePreviewAnimation", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;", "isLandScapeVideo", "isPlaying", "isRunningExitAnimation", "loadingBar", "Landroid/widget/ProgressBar;", "mCurrentOrientation", "mIsShowOpLayout", "mPreOrientation", "moreIv", "moreLayout", "mpInfoLayout", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "mpShareVideoReport", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "getMpShareVideoReport", "()Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "needDoAnimation", "nicknameTv", "Landroid/widget/TextView;", "orientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "preDeltaX", "preDeltaY", "preScale", "", "shareIv", "subScene", "getSubScene", "()Ljava/lang/Integer;", "setSubScene", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "toolBarMask", "touchLayout", "videoContainerLayout", "Landroid/view/ViewGroup;", "videoControl", "Lcom/tencent/xweb/VideoControl;", "videoPlayOpLayout", "videoPlayRootLayout", "videoPlayerSeekBar", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "videoRootLayout", "addVideoView", "", "view", "adjustOrientation", "exit", "fadeInAnimation", "Landroid/view/animation/Animation;", "fadeInOpLayout", "fadeOutAnimation", "duration", "fadeOutOpLayout", "force", "handleAnimation", "handleFullScreenStatusBar", "fullScreen", "handleHorizontalUI", "handleScreenSize", "handleVerticalUI", "hideLoading", "hideToolBar", "initData", "initReportData", "initSeekBar", "initVideoController", "initView", "isInFullScreen", "loadAvatar", "onClick", "v", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onExit", "onExitMpVideoFullPage", "onResume", "opPlay", "postHandleVerticalUI", "removeVideoView", "resetOrientation", "runDragAnimation", "runEnterAnimation", "runExitAnimation", "bm", "Landroid/graphics/Bitmap;", "callback", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "showLoading", "showToolBar", "starHideToolBar", "startHideToolBarTimer", "stopHideToolBarTimer", "supportFullScreen", "updatePlayBtn", "playing", "plugin-webview_release"})
public final class MPVideoPlayFullScreenView
  extends RelativeLayout
  implements View.OnClickListener
{
  private MMNeat7extView HyV;
  public float KOu;
  public int KOv;
  public int KOw;
  public boolean MfK;
  private RedesignVideoPlayerSeekBar Mfz;
  private com.tencent.mm.br.a Qfg;
  private double QtA;
  private int QtB;
  private long QtC;
  private final int QtD;
  private int QtE;
  private boolean QtF;
  private int QtG;
  private boolean QtH;
  private boolean QtI;
  private final h QtJ;
  private boolean QtK;
  private Integer QtL;
  private MTimerHandler QtM;
  private final long QtN;
  private boolean QtO;
  public View Qto;
  private View Qtp;
  private ViewGroup Qtq;
  public ViewGroup Qtr;
  private View Qts;
  private View Qtt;
  private View Qtu;
  private View Qtv;
  private View Qtw;
  private View Qtx;
  public u Qty;
  private View Qtz;
  public final String TAG;
  private boolean fGh;
  private ImageView jiu;
  private ProgressBar kGl;
  public y llv;
  private boolean lqq;
  private int mCurrentOrientation;
  private View sFa;
  private View sHh;
  public f twB;
  private View xoJ;
  private TextView xoK;
  
  public MPVideoPlayFullScreenView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82641);
    this.TAG = "MicroMsg.MPVideoPlayFullScreenView";
    this.QtD = -3;
    this.QtE = this.QtD;
    this.mCurrentOrientation = -1;
    this.Qfg = new com.tencent.mm.br.a(paramContext, (a.b)new j(this, paramContext));
    this.QtJ = new h();
    View.inflate(paramContext, c.g.mp_video_play_fullscreen_layout, (ViewGroup)this);
    paramAttributeSet = findViewById(c.f.video_play_root_layout);
    kotlin.g.b.p.j(paramAttributeSet, "findViewById(R.id.video_play_root_layout)");
    this.Qto = paramAttributeSet;
    paramAttributeSet = findViewById(c.f.video_play_op_layout);
    kotlin.g.b.p.j(paramAttributeSet, "findViewById(R.id.video_play_op_layout)");
    this.Qtp = paramAttributeSet;
    paramAttributeSet = findViewById(c.f.video_container_layout);
    kotlin.g.b.p.j(paramAttributeSet, "findViewById(R.id.video_container_layout)");
    this.Qtq = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(c.f.video_player_footer);
    kotlin.g.b.p.j(paramAttributeSet, "findViewById(R.id.video_player_footer)");
    this.Qts = paramAttributeSet;
    paramAttributeSet = findViewById(c.f.mp_info_layout);
    kotlin.g.b.p.j(paramAttributeSet, "findViewById(R.id.mp_info_layout)");
    this.Qtt = paramAttributeSet;
    paramAttributeSet = findViewById(c.f.video_touch_layout);
    kotlin.g.b.p.j(paramAttributeSet, "findViewById(R.id.video_touch_layout)");
    this.Qtu = paramAttributeSet;
    paramAttributeSet = findViewById(c.f.mp_video_avatar_layout);
    kotlin.g.b.p.j(paramAttributeSet, "findViewById(R.id.mp_video_avatar_layout)");
    this.xoJ = paramAttributeSet;
    paramAttributeSet = findViewById(c.f.mp_video_avatar_iv);
    kotlin.g.b.p.j(paramAttributeSet, "findViewById(R.id.mp_video_avatar_iv)");
    this.jiu = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(c.f.mp_video_nickname_tv);
    kotlin.g.b.p.j(paramAttributeSet, "findViewById(R.id.mp_video_nickname_tv)");
    this.xoK = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(c.f.mp_video_title_tv);
    kotlin.g.b.p.j(paramAttributeSet, "findViewById(R.id.mp_video_title_tv)");
    this.HyV = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(c.f.mp_video_view_article_layout);
    kotlin.g.b.p.j(paramAttributeSet, "findViewById(R.id.mp_video_view_article_layout)");
    this.sHh = paramAttributeSet;
    this.Mfz = ((RedesignVideoPlayerSeekBar)findViewById(c.f.video_player_seek_bar));
    this.Qtz = findViewById(c.f.tool_bar_mask);
    this.kGl = ((ProgressBar)findViewById(c.f.video_player_progressbar));
    paramAttributeSet = this.Mfz;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)this);
    }
    paramAttributeSet = this.Qts;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)1.QtP);
    }
    paramAttributeSet = this.Qtt;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)2.QtQ);
    }
    this.xoJ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        Object localObject1 = null;
        AppMethodBeat.i(82585);
        Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject2).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aFi());
        if (MPVideoPlayFullScreenView.g(this.QtR) != null)
        {
          paramAnonymousView = MPVideoPlayFullScreenView.g(this.QtR);
          if (paramAnonymousView == null) {
            break label203;
          }
        }
        label203:
        for (paramAnonymousView = paramAnonymousView.fzT;; paramAnonymousView = null)
        {
          if (Util.isNullOrNil(paramAnonymousView)) {
            Log.w(MPVideoPlayFullScreenView.a(this.QtR), "srcUserName is null");
          }
          localObject2 = new Intent();
          y localy = MPVideoPlayFullScreenView.g(this.QtR);
          paramAnonymousView = localObject1;
          if (localy != null) {
            paramAnonymousView = localy.fzT;
          }
          ((Intent)localObject2).putExtra("Contact_User", paramAnonymousView);
          ((Intent)localObject2).putExtra("Contact_Scene", 163);
          ((Intent)localObject2).putExtra("force_get_contact", true);
          ((Intent)localObject2).putExtra("key_use_new_contact_profile", true);
          c.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
          com.tencent.mm.plugin.report.service.h.IzE.a(18589, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(82585);
          return;
        }
      }
    });
    com.tencent.mm.ui.tools.p.iF(this.xoJ);
    paramAttributeSet = findViewById(c.f.video_player_close);
    kotlin.g.b.p.j(paramAttributeSet, "findViewById(R.id.video_player_close)");
    this.sFa = paramAttributeSet;
    this.sFa.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82586);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.QtR.exit();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82586);
      }
    });
    paramAttributeSet = findViewById(c.f.video_player_more_iv);
    kotlin.g.b.p.j(paramAttributeSet, "findViewById(R.id.video_player_more_iv)");
    this.Qtv = paramAttributeSet;
    this.Qtv.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82587);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = MPVideoPlayFullScreenView.g(this.QtR);
        if (paramAnonymousView != null)
        {
          localObject = g.Qur;
          g.a(paramContext, paramAnonymousView, 4);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82587);
      }
    });
    paramAttributeSet = findViewById(c.f.video_player_share_iv);
    kotlin.g.b.p.j(paramAttributeSet, "findViewById(R.id.video_player_share_iv)");
    this.Qtx = paramAttributeSet;
    this.Qtx.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82588);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        paramAnonymousView = paramContext;
        if (((paramAnonymousView instanceof WebViewUI)) && (MPVideoPlayFullScreenView.g(this.QtR) != null)) {
          if (ab.hnU())
          {
            localObject1 = g.Qur;
            localObject1 = MPVideoPlayFullScreenView.g(this.QtR);
            if (localObject1 == null) {
              kotlin.g.b.p.iCn();
            }
            g.a(paramAnonymousView, (y)localObject1, 5);
            com.tencent.mm.plugin.report.service.h.IzE.a(18589, new Object[] { Integer.valueOf(16), Integer.valueOf(3) });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(82588);
          return;
          ((WebViewUI)paramAnonymousView).QgI.llv = MPVideoPlayFullScreenView.g(this.QtR);
          localObject1 = d.Qug;
          localObject1 = MPVideoPlayFullScreenView.g(this.QtR);
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          localObject1 = ((y)localObject1).lpK;
          Object localObject2 = MPVideoPlayFullScreenView.g(this.QtR);
          if (localObject2 == null) {
            kotlin.g.b.p.iCn();
          }
          localObject2 = ((y)localObject2).title;
          y localy = MPVideoPlayFullScreenView.g(this.QtR);
          if (localy == null) {
            kotlin.g.b.p.iCn();
          }
          d.a(paramAnonymousView, (String)localObject1, "", (String)localObject2, localy.ROZ, 2);
          break;
          Log.w(MPVideoPlayFullScreenView.a(this.QtR), "should not be here");
        }
      }
    });
    paramContext = findViewById(c.f.video_wait_play_btn);
    kotlin.g.b.p.j(paramContext, "findViewById(R.id.video_wait_play_btn)");
    this.Qtw = paramContext;
    this.Qtw.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82589);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        MPVideoPlayFullScreenView.C(this.QtR);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82589);
      }
    });
    this.sHh.setVisibility(8);
    paramContext = this.Mfz;
    if (paramContext != null) {
      paramContext.setPlayBtnOnClickListener((View.OnClickListener)this);
    }
    paramContext = this.Mfz;
    if (paramContext != null) {
      paramContext.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new h(this));
    }
    this.KOu = 1.0F;
    this.QtM = new MTimerHandler((MTimerHandler.CallBack)new g(this), true);
    this.QtN = 4000L;
    AppMethodBeat.o(82641);
  }
  
  private final void Do(boolean paramBoolean)
  {
    AppMethodBeat.i(182653);
    Log.i(this.TAG, "handleFullScreenStatusBar forwardUiVisibility " + this.QtG);
    if (paramBoolean)
    {
      localObject1 = getContext();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(182653);
        throw ((Throwable)localObject1);
      }
      localObject1 = (Activity)localObject1;
      localObject2 = ((Activity)localObject1).getWindow();
      kotlin.g.b.p.j(localObject2, "activity.window");
      localObject2 = ((Window)localObject2).getDecorView();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(182653);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup)localObject2;
      this.QtG = ((ViewGroup)localObject2).getSystemUiVisibility();
      ((ViewGroup)localObject2).setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)new c(this, (ViewGroup)localObject2));
      ((ViewGroup)localObject2).setSystemUiVisibility(4102);
      ((Activity)localObject1).getWindow().addFlags(1024);
      AppMethodBeat.o(182653);
      return;
    }
    Object localObject1 = getContext();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(182653);
      throw ((Throwable)localObject1);
    }
    localObject1 = (Activity)localObject1;
    Object localObject2 = ((Activity)localObject1).getWindow();
    kotlin.g.b.p.j(localObject2, "activity.window");
    localObject2 = ((Window)localObject2).getDecorView();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(182653);
      throw ((Throwable)localObject1);
    }
    ((ViewGroup)localObject2).setSystemUiVisibility(this.QtG);
    ((Activity)localObject1).getWindow().clearFlags(1024);
    AppMethodBeat.o(182653);
  }
  
  private final void hbe()
  {
    AppMethodBeat.i(82626);
    if (this.twB == null) {
      this.twB = new f(getContext());
    }
    if (this.llv == null)
    {
      this.QtK = true;
      AppMethodBeat.o(82626);
      return;
    }
    this.QtK = false;
    Object localObject = this.llv;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    int i = ((y)localObject).lqj;
    localObject = this.llv;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    int j = ((y)localObject).lqk;
    localObject = this.llv;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    int k = ((y)localObject).lql;
    localObject = this.llv;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    int m = ((y)localObject).lqm;
    localObject = this.twB;
    if (localObject != null) {
      ((f)localObject).V(i, j, k, m);
    }
    localObject = this.twB;
    if (localObject != null) {
      ((f)localObject).hYr();
    }
    localObject = this.twB;
    if (localObject != null) {
      ((f)localObject).mL(0, 0);
    }
    hbf();
    AppMethodBeat.o(82626);
  }
  
  private final void hbf()
  {
    AppMethodBeat.i(82627);
    Object localObject = this.Qtr;
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
  
  private final void hbg()
  {
    AppMethodBeat.i(82631);
    if (this.fGh)
    {
      localu = this.Qty;
      if (localu != null)
      {
        localu.gvc();
        AppMethodBeat.o(82631);
        return;
      }
      AppMethodBeat.o(82631);
      return;
    }
    u localu = this.Qty;
    if (localu != null)
    {
      localu.iwh();
      AppMethodBeat.o(82631);
      return;
    }
    AppMethodBeat.o(82631);
  }
  
  private final void hbh()
  {
    try
    {
      AppMethodBeat.i(266229);
      Object localObject1 = getContext();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(266229);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    Activity localActivity = (Activity)localObject2;
    if (this.llv == null)
    {
      Log.d(this.TAG, "adjustOrientation mpShareVideoInfo is null");
      AppMethodBeat.o(266229);
    }
    for (;;)
    {
      return;
      if ((!this.QtH) && (this.QtI)) {
        break;
      }
      Log.i(this.TAG, "adjustOrientation hasAdjustOrientation=" + this.QtH + ", hasAddVideoView=" + this.QtI);
      AppMethodBeat.o(266229);
    }
    this.QtH = true;
    if (this.QtE == this.QtD) {
      this.QtE = localActivity.getRequestedOrientation();
    }
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("adjustOrientation width = ");
    y localy = this.llv;
    if (localy == null) {
      kotlin.g.b.p.iCn();
    }
    localStringBuilder = localStringBuilder.append(localy.width).append(", height=");
    localy = this.llv;
    if (localy == null) {
      kotlin.g.b.p.iCn();
    }
    Log.i((String)localObject3, localy.height);
    localObject3 = this.llv;
    if (localObject3 == null) {
      kotlin.g.b.p.iCn();
    }
    int i = ((y)localObject3).width;
    localObject3 = this.llv;
    if (localObject3 == null) {
      kotlin.g.b.p.iCn();
    }
    if (i <= ((y)localObject3).height)
    {
      this.mCurrentOrientation = 1;
      localActivity.setRequestedOrientation(this.mCurrentOrientation);
      this.QtF = false;
    }
    for (;;)
    {
      hbp();
      AppMethodBeat.o(266229);
      break;
      this.QtF = true;
      this.mCurrentOrientation = 0;
      localActivity.setRequestedOrientation(this.mCurrentOrientation);
      this.Qfg.enable();
    }
  }
  
  private final int hbj()
  {
    Object localObject2 = null;
    AppMethodBeat.i(82633);
    Object localObject1 = getContext();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.app.Activity");
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
        localObject1 = ((com.tencent.mm.plugin.webview.core.b)localObject3).cDu();
      }
    }
    for (;;)
    {
      try
      {
        int j = Util.getInt(Uri.parse((String)localObject1).getQueryParameter("scene"), 10000);
        i = j;
        AppMethodBeat.o(82633);
        return i;
      }
      catch (Exception localException) {}
    }
  }
  
  private final void hbl()
  {
    boolean bool = true;
    AppMethodBeat.i(82635);
    Object localObject = this.TAG;
    if (this.Qtp.getVisibility() == 0) {}
    for (;;)
    {
      Log.d((String)localObject, "fadeOutOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = hbm();
      ((Animation)localObject).setFillAfter(false);
      ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this));
      this.Qtp.clearAnimation();
      this.Qtp.startAnimation((Animation)localObject);
      AppMethodBeat.o(82635);
      return;
      bool = false;
    }
  }
  
  private static Animation hbm()
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
  
  private final void hbn()
  {
    AppMethodBeat.i(82638);
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(82638);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getWindow();
    kotlin.g.b.p.j(localObject, "(context as Activity).window");
    localObject = ((Window)localObject).getDecorView();
    kotlin.g.b.p.j(localObject, "(context as Activity).window.decorView");
    ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new e(this, (View)localObject));
    AppMethodBeat.o(82638);
  }
  
  private final void hbo()
  {
    AppMethodBeat.i(82639);
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(82639);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getWindow();
    kotlin.g.b.p.j(localObject, "(context as Activity).window");
    localObject = ((Window)localObject).getDecorView();
    kotlin.g.b.p.j(localObject, "(context as Activity).window.decorView");
    ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new d(this, (View)localObject));
    AppMethodBeat.o(82639);
  }
  
  private final void hbp()
  {
    AppMethodBeat.i(182654);
    if ((this.mCurrentOrientation == 0) || (this.mCurrentOrientation == 8))
    {
      hbo();
      AppMethodBeat.o(182654);
      return;
    }
    hbn();
    AppMethodBeat.o(182654);
  }
  
  private void removeVideoView()
  {
    AppMethodBeat.i(82632);
    this.Qtq.removeAllViews();
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
      AppMethodBeat.o(82632);
      throw ((Throwable)localObject);
    }
    ((WebViewUI)localObject).setMMOrientation();
    AppMethodBeat.o(82632);
  }
  
  public final void a(y paramy)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(266225);
        kotlin.g.b.p.k(paramy, "mpShareVideoInfo");
        this.llv = paramy;
        this.lqq = paramy.lqq;
        paramy = this.HyV.getPaint();
        kotlin.g.b.p.j(paramy, "titleTv.paint");
        paramy.setFakeBoldText(true);
        paramy = this.xoK.getPaint();
        kotlin.g.b.p.j(paramy, "nicknameTv.paint");
        paramy.setFakeBoldText(true);
        localObject = this.HyV;
        paramy = this.llv;
        if (paramy != null)
        {
          paramy = paramy.title;
          ((MMNeat7extView)localObject).aL((CharSequence)paramy);
          localObject = this.xoK;
          Context localContext = getContext();
          paramy = this.llv;
          if (paramy != null)
          {
            paramy = paramy.lpC;
            ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(localContext, (CharSequence)paramy, this.xoK.getTextSize()));
            if (!this.lqq) {
              continue;
            }
            this.Qtv.setVisibility(8);
            this.Qtx.setVisibility(8);
            localObject = getContext();
            if ((localObject instanceof WebViewUI))
            {
              paramy = this.llv;
              if (paramy == null) {
                break label311;
              }
              paramy = paramy.lqp;
              if (Util.isNullOrNil(paramy)) {
                break label321;
              }
              paramy = this.llv;
              if (paramy == null) {
                break label316;
              }
              paramy = paramy.lqp;
              com.tencent.mm.ay.a.a.bms().a(paramy, this.jiu, new c.a().bmJ().wy(c.e.brand_default_head).bmL());
            }
            if (this.QtK) {
              hbe();
            }
            Log.d(this.TAG, "initData");
            hbh();
            AppMethodBeat.o(266225);
          }
        }
        else
        {
          paramy = null;
          continue;
        }
        paramy = null;
        continue;
        this.Qtv.setVisibility(0);
        this.Qtx.setVisibility(0);
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
      paramy = ((WebViewUI)localObject).gYo();
      if (paramy != null)
      {
        paramy = paramy.FHd;
        if (paramy != null)
        {
          paramy = paramy.fbc();
          if (paramy != null)
          {
            paramy = paramy.TIg;
            continue;
          }
        }
      }
      paramy = null;
    }
  }
  
  public final boolean bUK()
  {
    AppMethodBeat.i(266228);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(266228);
      return true;
    }
    AppMethodBeat.o(266228);
    return false;
  }
  
  public final void exit()
  {
    AppMethodBeat.i(82628);
    Context localContext = getContext();
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).gZh() != null))
    {
      if (((WebViewUI)localContext).gZh() != null)
      {
        Log.i(this.TAG, "close click");
        hbi();
        ((WebViewUI)localContext).gZh().leaveFullscreen();
        MMHandlerThread.postToMainThreadDelayed((Runnable)new a(this), 500L);
        AppMethodBeat.o(82628);
      }
    }
    else {
      Log.w(this.TAG, "should not be here");
    }
    AppMethodBeat.o(82628);
  }
  
  public final int getEnterId()
  {
    return this.QtB;
  }
  
  public final long getEnterTimeInMs()
  {
    return this.QtC;
  }
  
  public final boolean getForbidForward()
  {
    return this.lqq;
  }
  
  public final h getMpShareVideoReport()
  {
    return this.QtJ;
  }
  
  public final Integer getSubScene()
  {
    return this.QtL;
  }
  
  @SuppressLint({"WrongConstant"})
  public final void hbi()
  {
    AppMethodBeat.i(182652);
    if (this.QtE != this.QtD)
    {
      Object localObject = getContext();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(182652);
        throw ((Throwable)localObject);
      }
      ((Activity)localObject).setRequestedOrientation(this.QtE);
      this.QtE = this.QtD;
      this.Qfg.disable();
    }
    Do(false);
    AppMethodBeat.o(182652);
  }
  
  public final void hbk()
  {
    AppMethodBeat.i(82634);
    if (BuildInfo.IS_FLAVOR_RED) {
      Log.d(this.TAG, "hideOpLayer %s", new Object[] { Util.getStack() });
    }
    if (!this.QtO)
    {
      AppMethodBeat.o(82634);
      return;
    }
    this.QtO = false;
    hbl();
    AppMethodBeat.o(82634);
  }
  
  public final void hp(View paramView)
  {
    try
    {
      AppMethodBeat.i(266227);
      kotlin.g.b.p.k(paramView, "view");
      if (this.llv == null) {
        break label209;
      }
      localObject1 = this.llv;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      ((y)localObject1).lqn = this.QtB;
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        AppMethodBeat.o(266227);
        throw paramView;
      }
    }
    finally {}
    Object localObject2 = (WebViewUI)localObject1;
    Object localObject1 = ((WebViewUI)localObject2).pGC;
    if (localObject1 != null) {}
    try
    {
      localObject1 = this.QtJ;
      localObject2 = ((WebViewUI)localObject2).pGC;
      y localy = this.llv;
      if (localy == null) {
        kotlin.g.b.p.iCn();
      }
      ((h)localObject1).Quw = ((e)localObject2).Ql(localy.fzT);
      this.QtJ.scene = 141;
      this.QtJ.wGA = hbj();
    }
    catch (Exception localException)
    {
      label149:
      break label149;
    }
    this.QtC = System.currentTimeMillis();
    this.QtB = ((int)(this.QtC / 1000L));
    this.QtJ.a(this.llv, 1, this.QtB);
    this.QtJ.a(this.llv, 5, this.QtB);
    this.QtJ.mfx = 0;
    label209:
    removeVideoView();
    Do(true);
    this.Qto.setAlpha(1.0F);
    this.Qto.setBackgroundColor(-16777216);
    setVisibility(0);
    localObject1 = new FrameLayout(getContext());
    ((FrameLayout)localObject1).addView(paramView, new ViewGroup.LayoutParams(-1, -2));
    this.Qtr = ((ViewGroup)localObject1);
    paramView = this.Qtq;
    localObject1 = (View)this.Qtr;
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    hbe();
    this.MfK = false;
    Log.d(this.TAG, "addVideoView");
    this.QtI = true;
    hbh();
    AppMethodBeat.o(266227);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(82630);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((paramView != null) && (paramView.getId() == c.f.play_btn)) {
      hbg();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(82630);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(82637);
    kotlin.g.b.p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      Log.d(this.TAG, "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      hbn();
      AppMethodBeat.o(82637);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      Log.d(this.TAG, "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
      hbo();
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
    Log.i(this.TAG, "onExitMpVideoFullPage");
    this.QtH = false;
    this.QtI = false;
    if (this.llv != null)
    {
      this.QtJ.Quu = ((int)(System.currentTimeMillis() - this.QtC));
      this.QtJ.Qut = ((int)(this.QtA * 1000.0D));
      this.QtJ.a(this.llv, 6, this.QtB);
      this.QtJ.a(this.llv, 2, this.QtB);
      Object localObject = getContext();
      if (((localObject instanceof WebViewUI)) && (((WebViewUI)localObject).PvJ != null))
      {
        localObject = ((WebViewUI)localObject).PvJ;
        y localy = this.llv;
        if (localy == null) {
          kotlin.g.b.p.iCn();
        }
        ((com.tencent.mm.plugin.webview.d.h)localObject).gQ(localy.RPa, (int)this.QtA);
      }
      this.llv = null;
    }
    AppMethodBeat.o(82629);
  }
  
  public final void setEnterId(int paramInt)
  {
    this.QtB = paramInt;
  }
  
  public final void setEnterTimeInMs(long paramLong)
  {
    this.QtC = paramLong;
  }
  
  public final void setForbidForward(boolean paramBoolean)
  {
    this.lqq = paramBoolean;
  }
  
  public final void setSubScene(Integer paramInteger)
  {
    this.QtL = paramInteger;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82590);
      this.QtR.onExit();
      AppMethodBeat.o(82590);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$fadeOutOpLayout$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(82592);
      kotlin.g.b.p.k(paramAnimation, "animation");
      if (!MPVideoPlayFullScreenView.r(this.QtR)) {
        MPVideoPlayFullScreenView.s(this.QtR);
      }
      AppMethodBeat.o(82592);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(82593);
      kotlin.g.b.p.k(paramAnimation, "animation");
      AppMethodBeat.o(82593);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(82591);
      kotlin.g.b.p.k(paramAnimation, "animation");
      AppMethodBeat.o(82591);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "visibility", "", "onSystemUiVisibilityChange"})
  static final class c
    implements View.OnSystemUiVisibilityChangeListener
  {
    c(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, ViewGroup paramViewGroup) {}
    
    public final void onSystemUiVisibilityChange(int paramInt)
    {
      AppMethodBeat.i(216088);
      if (((paramInt & 0x4) == 0) && (this.QtR.bUK())) {
        this.QtS.setSystemUiVisibility(5894);
      }
      AppMethodBeat.o(216088);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$handleHorizontalUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class d
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    d(View paramView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82594);
      this.sJL.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      if (com.tencent.mm.compatible.util.d.qV(24))
      {
        localObject1 = this.QtR.getContext();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(82594);
          throw ((Throwable)localObject1);
        }
        if (((Activity)localObject1).isInMultiWindowMode())
        {
          MPVideoPlayFullScreenView.t(this.QtR);
          AppMethodBeat.o(82594);
          return;
        }
      }
      int n = ax.aB(this.QtR.getContext());
      int i = com.tencent.mm.ci.a.aZ(this.QtR.getContext(), c.d.Edge_A);
      int j = i * 3;
      int k = i * 4;
      int m = i * 7;
      n = Math.max(n - i * 3, 0);
      MPVideoPlayFullScreenView.u(this.QtR).setPadding(n, i * 2, n - i, i * 2);
      Object localObject1 = MPVideoPlayFullScreenView.v(this.QtR);
      if (localObject1 != null)
      {
        ((View)localObject1).setPadding(0, 0, 0, 0);
        localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(82594);
          throw ((Throwable)localObject1);
        }
        localObject2 = (RelativeLayout.LayoutParams)localObject2;
        ((RelativeLayout.LayoutParams)localObject2).height = com.tencent.mm.ci.a.aY(this.QtR.getContext(), c.d.Edge_14A);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject1 = MPVideoPlayFullScreenView.w(this.QtR).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(k, j, 0, j);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      MPVideoPlayFullScreenView.w(this.QtR).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = MPVideoPlayFullScreenView.x(this.QtR).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, j, k, j);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      MPVideoPlayFullScreenView.x(this.QtR).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = MPVideoPlayFullScreenView.y(this.QtR).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, j, k, j);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      MPVideoPlayFullScreenView.y(this.QtR).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = MPVideoPlayFullScreenView.m(this.QtR);
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      localObject1 = ((RedesignVideoPlayerSeekBar)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, c.f.video_player_close);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, c.f.video_player_share_iv);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(m, j, m, j);
      Object localObject2 = MPVideoPlayFullScreenView.m(this.QtR);
      if (localObject2 != null)
      {
        ((RedesignVideoPlayerSeekBar)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(82594);
        return;
      }
      AppMethodBeat.o(82594);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$handleVerticalUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class e
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    e(View paramView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82595);
      this.sJL.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      MPVideoPlayFullScreenView.t(this.QtR);
      AppMethodBeat.o(82595);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82596);
      ProgressBar localProgressBar = MPVideoPlayFullScreenView.l(this.QtR);
      if ((localProgressBar != null) && (localProgressBar.getVisibility() == 0))
      {
        localProgressBar = MPVideoPlayFullScreenView.l(this.QtR);
        if (localProgressBar != null) {
          localProgressBar.setVisibility(8);
        }
      }
      if (!MPVideoPlayFullScreenView.n(this.QtR)) {
        MPVideoPlayFullScreenView.k(this.QtR).setVisibility(0);
      }
      AppMethodBeat.o(82596);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class g
    implements MTimerHandler.CallBack
  {
    g(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(82597);
      MPVideoPlayFullScreenView.i(this.QtR);
      AppMethodBeat.o(82597);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$initSeekBar$1", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-webview_release"})
  public static final class h
    implements com.tencent.mm.plugin.sight.decode.ui.b
  {
    public final void aRo() {}
    
    public final void tY(int paramInt)
    {
      AppMethodBeat.i(82598);
      Log.i(MPVideoPlayFullScreenView.a(this.QtR), "initSeekBar onSeekTo ".concat(String.valueOf(paramInt)));
      u localu = MPVideoPlayFullScreenView.o(this.QtR);
      if (localu != null)
      {
        localu.H(paramInt);
        AppMethodBeat.o(82598);
        return;
      }
      AppMethodBeat.o(82598);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$initVideoController$1", "Lcom/tencent/xweb/VideoJsCallback;", "lastUpdateTime", "", "getLastUpdateTime", "()J", "setLastUpdateTime", "(J)V", "onSetRequestedOrientation", "", "orientation", "", "onVideoEmptied", "", "onVideoEnded", "onVideoEnterFullscreen", "isVideoTag", "id", "width", "", "height", "paused", "seeking", "currentTime", "duration", "buffered", "", "onVideoError", "error", "msg", "", "onVideoExitFullscreen", "onVideoPause", "onVideoPlay", "onVideoPlaying", "onVideoSeeked", "onVideoSeeking", "onVideoSizeUpdate", "onVideoTimeUpdate", "onVideoWaiting", "plugin-webview_release"})
  public static final class i
    implements v
  {
    private long lastUpdateTime;
    
    public final boolean Bh(int paramInt)
    {
      return false;
    }
    
    public final void bXx()
    {
      AppMethodBeat.i(82602);
      Log.i(MPVideoPlayFullScreenView.a(this.QtR), "onVideoEmptied");
      MPVideoPlayFullScreenView.p(this.QtR);
      AppMethodBeat.o(82602);
    }
    
    public final void onVideoEnded()
    {
      AppMethodBeat.i(82600);
      Log.i(MPVideoPlayFullScreenView.a(this.QtR), "onVideoEnded");
      MPVideoPlayFullScreenView.c(this.QtR, false);
      MPVideoPlayFullScreenView.p(this.QtR);
      this.QtR.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.QtR), 7, this.QtR.getEnterId());
      this.QtR.getMpShareVideoReport().mfx = 4;
      AppMethodBeat.o(82600);
    }
    
    public final void onVideoEnterFullscreen(boolean paramBoolean1, long paramLong, double paramDouble1, double paramDouble2, boolean paramBoolean2, boolean paramBoolean3, double paramDouble3, double paramDouble4, double[] paramArrayOfDouble)
    {
      AppMethodBeat.i(82609);
      Log.i(MPVideoPlayFullScreenView.a(this.QtR), "onVideoEnterFullscreen isVideoTag:" + paramBoolean1 + ", id:" + paramLong + ", width:" + paramDouble1 + ", height:" + paramDouble2 + ", paused:" + paramBoolean2 + ", seeking:" + paramBoolean3 + ", currentTime:" + paramDouble3 + ", duration:" + paramDouble4 + ", buffered:" + Arrays.toString(paramArrayOfDouble));
      paramArrayOfDouble = this.QtR;
      if (!paramBoolean2) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        MPVideoPlayFullScreenView.b(paramArrayOfDouble, paramBoolean1);
        MPVideoPlayFullScreenView.c(this.QtR, MPVideoPlayFullScreenView.n(this.QtR));
        if (MPVideoPlayFullScreenView.n(this.QtR))
        {
          this.QtR.getMpShareVideoReport().mfx = 1;
          this.QtR.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.QtR), this.QtR.getMpShareVideoReport().getPlayType(), this.QtR.getEnterId());
        }
        AppMethodBeat.o(82609);
        return;
      }
    }
    
    public final void onVideoError(int paramInt, String paramString)
    {
      AppMethodBeat.i(82601);
      Log.e(MPVideoPlayFullScreenView.a(this.QtR), "onVideoError " + paramInt + ", " + paramString);
      MPVideoPlayFullScreenView.c(this.QtR, false);
      MPVideoPlayFullScreenView.p(this.QtR);
      this.QtR.getMpShareVideoReport().mfx = 4;
      this.QtR.getMpShareVideoReport().Quv = paramString;
      this.QtR.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.QtR), 11, this.QtR.getEnterId());
      AppMethodBeat.o(82601);
    }
    
    public final void onVideoExitFullscreen()
    {
      AppMethodBeat.i(82610);
      Log.i(MPVideoPlayFullScreenView.a(this.QtR), "onVideoExitFullscreen");
      AppMethodBeat.o(82610);
    }
    
    public final void onVideoPause()
    {
      AppMethodBeat.i(82608);
      Log.i(MPVideoPlayFullScreenView.a(this.QtR), "onVideoPause");
      MPVideoPlayFullScreenView.c(this.QtR, false);
      MPVideoPlayFullScreenView.p(this.QtR);
      if (this.QtR.getMpShareVideoReport().mfx != 3) {
        this.QtR.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.QtR), 8, this.QtR.getEnterId());
      }
      this.QtR.getMpShareVideoReport().mfx = 3;
      AppMethodBeat.o(82608);
    }
    
    public final void onVideoPlay()
    {
      AppMethodBeat.i(82607);
      Log.i(MPVideoPlayFullScreenView.a(this.QtR), "onVideoPlay");
      MPVideoPlayFullScreenView.c(this.QtR, true);
      MPVideoPlayFullScreenView.p(this.QtR);
      if (this.QtR.getMpShareVideoReport().mfx != 2) {
        this.QtR.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.QtR), this.QtR.getMpShareVideoReport().getPlayType(), this.QtR.getEnterId());
      }
      this.QtR.getMpShareVideoReport().mfx = 2;
      AppMethodBeat.o(82607);
    }
    
    public final void onVideoPlaying()
    {
      AppMethodBeat.i(82603);
      Log.d(MPVideoPlayFullScreenView.a(this.QtR), "onVideoPlaying");
      if (!MPVideoPlayFullScreenView.n(this.QtR))
      {
        MPVideoPlayFullScreenView.c(this.QtR, true);
        MPVideoPlayFullScreenView.p(this.QtR);
      }
      this.QtR.getMpShareVideoReport().mfx = 2;
      AppMethodBeat.o(82603);
    }
    
    public final void onVideoSeeked()
    {
      AppMethodBeat.i(82606);
      Log.i(MPVideoPlayFullScreenView.a(this.QtR), "onVideoSeeked");
      MPVideoPlayFullScreenView.p(this.QtR);
      this.QtR.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.QtR), 13, this.QtR.getEnterId());
      AppMethodBeat.o(82606);
    }
    
    public final void onVideoSeeking()
    {
      AppMethodBeat.i(82605);
      Log.i(MPVideoPlayFullScreenView.a(this.QtR), "onVideoSeeking");
      MPVideoPlayFullScreenView.q(this.QtR);
      AppMethodBeat.o(82605);
    }
    
    public final void onVideoSizeUpdate(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(82612);
      y localy = MPVideoPlayFullScreenView.g(this.QtR);
      if ((localy == null) || (localy.width != 0))
      {
        localy = MPVideoPlayFullScreenView.g(this.QtR);
        if (localy != null) {
          if (localy.height != 0) {
            break label103;
          }
        }
      }
      else
      {
        localy = MPVideoPlayFullScreenView.g(this.QtR);
        if (localy != null) {
          localy.width = ((int)paramDouble1);
        }
        localy = MPVideoPlayFullScreenView.g(this.QtR);
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
        MMHandlerThread.postToMainThread((Runnable)new a(this, paramDouble2, paramDouble1, paramArrayOfDouble));
      }
      MPVideoPlayFullScreenView.a(this.QtR, paramDouble1);
      MPVideoPlayFullScreenView.p(this.QtR);
      AppMethodBeat.o(82611);
    }
    
    public final void onVideoWaiting()
    {
      AppMethodBeat.i(82604);
      Log.i(MPVideoPlayFullScreenView.a(this.QtR), "onVideoWaiting");
      MPVideoPlayFullScreenView.q(this.QtR);
      AppMethodBeat.o(82604);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoPlayFullScreenView.i parami, double paramDouble1, double paramDouble2, double[] paramArrayOfDouble) {}
      
      public final void run()
      {
        int j = 1;
        AppMethodBeat.i(82599);
        Object localObject = MPVideoPlayFullScreenView.m(this.QtT.QtR);
        if (localObject != null) {
          ((RedesignVideoPlayerSeekBar)localObject).setVideoTotalTime((int)paramDouble2);
        }
        localObject = MPVideoPlayFullScreenView.m(this.QtT.QtR);
        if (localObject != null) {
          ((RedesignVideoPlayerSeekBar)localObject).AS((int)paramArrayOfDouble);
        }
        localObject = this.QtW;
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
            RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = MPVideoPlayFullScreenView.m(this.QtT.QtR);
            if (localRedesignVideoPlayerSeekBar == null) {
              break label133;
            }
            kotlin.g.b.p.k(localObject, "$this$lastIndex");
            localRedesignVideoPlayerSeekBar.arc((int)localObject[(localObject.length - 1)]);
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class j
    implements a.b
  {
    j(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, Context paramContext) {}
    
    public final void a(a.a parama1, a.a parama2)
    {
      AppMethodBeat.i(182651);
      if (MPVideoPlayFullScreenView.z(this.QtR))
      {
        parama1 = this.QtR;
        if (parama2 == null)
        {
          AppMethodBeat.o(182651);
          return;
        }
        switch (b.$EnumSwitchMapping$0[parama2.ordinal()])
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
          parama1 = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(182651);
          throw parama1;
        }
        ((Activity)parama1).setRequestedOrientation(MPVideoPlayFullScreenView.A(this.QtR));
        MPVideoPlayFullScreenView.B(this.QtR);
      }
      AppMethodBeat.o(182651);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onExit"})
  static final class k
    implements f.b
  {
    k(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void onExit()
    {
      AppMethodBeat.i(82613);
      this.QtR.exit();
      AppMethodBeat.o(82613);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "longClickOver"})
  static final class l
    implements f.d
  {
    l(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void bwC()
    {
      AppMethodBeat.i(82614);
      if (!this.QtR.getForbidForward())
      {
        y localy = MPVideoPlayFullScreenView.g(this.QtR);
        if (localy != null)
        {
          Object localObject = g.Qur;
          localObject = this.QtR.getContext();
          kotlin.g.b.p.j(localObject, "context");
          g.a((Context)localObject, localy, 3);
          AppMethodBeat.o(82614);
          return;
        }
      }
      AppMethodBeat.o(82614);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick"})
  static final class m
    implements f.f
  {
    m(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(82615);
      if (MPVideoPlayFullScreenView.h(this.QtR).getVisibility() == 0)
      {
        MPVideoPlayFullScreenView.i(this.QtR);
        AppMethodBeat.o(82615);
        return;
      }
      MPVideoPlayFullScreenView.f(this.QtR);
      AppMethodBeat.o(82615);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "tx", "", "ty", "onGalleryScale"})
  static final class n
    implements f.e
  {
    n(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void U(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(82616);
      if ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F))
      {
        MPVideoPlayFullScreenView.f(this.QtR);
        AppMethodBeat.o(82616);
        return;
      }
      if ((Math.abs(paramFloat1) > 10.0F) || (Math.abs(paramFloat2) > 10.0F)) {
        MPVideoPlayFullScreenView.i(this.QtR);
      }
      AppMethodBeat.o(82616);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    public static final o QtX;
    
    static
    {
      AppMethodBeat.i(82618);
      QtX = new o();
      AppMethodBeat.o(82618);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(82617);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runDragAnimation$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runDragAnimation$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(82617);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runEnterAnimation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class p
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82620);
      Log.d(MPVideoPlayFullScreenView.a(this.QtR), "runEnterAnimation");
      Object localObject = MPVideoPlayFullScreenView.b(this.QtR);
      if (localObject != null)
      {
        localObject = ((ViewGroup)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      localObject = MPVideoPlayFullScreenView.b(this.QtR);
      if (localObject != null) {}
      for (localObject = Integer.valueOf(((ViewGroup)localObject).getHeight());; localObject = null)
      {
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        if (((Integer)localObject).intValue() > 0) {
          break;
        }
        MPVideoPlayFullScreenView.c(this.QtR);
        AppMethodBeat.o(82620);
        return;
      }
      MPVideoPlayFullScreenView.d(this.QtR);
      localObject = MPVideoPlayFullScreenView.e(this.QtR);
      if (localObject != null)
      {
        ViewGroup localViewGroup = MPVideoPlayFullScreenView.b(this.QtR);
        if (localViewGroup == null) {
          kotlin.g.b.p.iCn();
        }
        ((f)localObject).a((View)localViewGroup, null, (f.c)new a(this));
        AppMethodBeat.o(82620);
        return;
      }
      AppMethodBeat.o(82620);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runEnterAnimation$1$onGlobalLayout$1", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-webview_release"})
    public static final class a
      implements f.c
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(82619);
        MPVideoPlayFullScreenView.f(this.QtY.QtR);
        AppMethodBeat.o(82619);
      }
      
      public final void onAnimationStart() {}
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runExitAnimation$2", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-webview_release"})
  public static final class q
    implements f.c
  {
    public q(ViewGroup.LayoutParams paramLayoutParams) {}
    
    public final void onAnimationEnd()
    {
      AppMethodBeat.i(82623);
      f.c localc = this.QtZ;
      if (localc != null) {
        localc.onAnimationEnd();
      }
      MPVideoPlayFullScreenView.j(this.QtR).post((Runnable)new a(this));
      MPVideoPlayFullScreenView.a(this.QtR, false);
      this.QtR.onExit();
      AppMethodBeat.o(82623);
    }
    
    public final void onAnimationStart()
    {
      AppMethodBeat.i(82622);
      MPVideoPlayFullScreenView.a(this.QtR, true);
      f.c localc = this.QtZ;
      if (localc != null)
      {
        localc.onAnimationStart();
        AppMethodBeat.o(82622);
        return;
      }
      AppMethodBeat.o(82622);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoPlayFullScreenView.q paramq) {}
      
      public final void run()
      {
        AppMethodBeat.i(82621);
        Object localObject = this.Qub.QtR.getContext();
        if (((localObject instanceof WebViewUI)) && (((WebViewUI)localObject).gZh() != null))
        {
          localObject = this.Qub.QtR.getContext();
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
            AppMethodBeat.o(82621);
            throw ((Throwable)localObject);
          }
          ((WebViewUI)localObject).gZh().leaveFullscreen();
        }
        MPVideoPlayFullScreenView.j(this.Qub.QtR).setLayoutParams(this.Qub.Qua);
        AppMethodBeat.o(82621);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82624);
      ProgressBar localProgressBar = MPVideoPlayFullScreenView.l(this.QtR);
      if ((localProgressBar == null) || (localProgressBar.getVisibility() != 0))
      {
        localProgressBar = MPVideoPlayFullScreenView.l(this.QtR);
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(82625);
      if (this.Quc) {
        MPVideoPlayFullScreenView.k(this.QtR).setVisibility(8);
      }
      for (;;)
      {
        Object localObject = MPVideoPlayFullScreenView.m(this.QtR);
        if (localObject == null) {
          break;
        }
        ((RedesignVideoPlayerSeekBar)localObject).iF(MPVideoPlayFullScreenView.n(this.QtR));
        AppMethodBeat.o(82625);
        return;
        localObject = MPVideoPlayFullScreenView.l(this.QtR);
        if ((localObject == null) || (((ProgressBar)localObject).getVisibility() != 0)) {
          MPVideoPlayFullScreenView.k(this.QtR).setVisibility(0);
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