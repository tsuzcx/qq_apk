package com.tencent.mm.plugin.webview.ui.tools.media;

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
import com.tencent.mm.bj.a.a;
import com.tencent.mm.message.y;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.w;
import com.tencent.xweb.x;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ENTER_HIDE_MIL_SEC", "", "INVALID_ORIENTATION", "", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/view/View;", "centerPlayIv", "closeIv", "currentPlayTime", "", "enterId", "getEnterId", "()I", "setEnterId", "(I)V", "enterTimeInMs", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "footerLayout", "forbidForward", "", "getForbidForward", "()Z", "setForbidForward", "(Z)V", "forwardUiVisibility", "hasAddVideoView", "hasAdjustOrientation", "hideToolBarTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "imagePreviewAnimation", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;", "isLandScapeVideo", "isPlaying", "isRunningExitAnimation", "loadingBar", "Landroid/widget/ProgressBar;", "mCurrentOrientation", "mIsShowOpLayout", "mPreOrientation", "moreIv", "moreLayout", "mpInfoLayout", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "mpShareVideoReport", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "getMpShareVideoReport", "()Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "needDoAnimation", "nicknameTv", "Landroid/widget/TextView;", "orientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "preDeltaX", "preDeltaY", "preScale", "", "shareIv", "subScene", "getSubScene", "()Ljava/lang/Integer;", "setSubScene", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "toolBarMask", "touchLayout", "videoContainerLayout", "Landroid/view/ViewGroup;", "videoControl", "Lcom/tencent/xweb/VideoControl;", "videoPlayOpLayout", "videoPlayRootLayout", "videoPlayerSeekBar", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "videoRootLayout", "addVideoView", "", "view", "adjustOrientation", "exit", "fadeInAnimation", "Landroid/view/animation/Animation;", "fadeInOpLayout", "fadeOutAnimation", "duration", "fadeOutOpLayout", "force", "handleAnimation", "handleFullScreenStatusBar", "fullScreen", "handleHorizontalUI", "handleScreenSize", "handleVerticalUI", "hideLoading", "hideToolBar", "initData", "initReportData", "initSeekBar", "initVideoController", "initView", "isInFullScreen", "loadAvatar", "onClick", "v", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onExit", "onExitMpVideoFullPage", "onResume", "opPlay", "postHandleVerticalUI", "removeVideoView", "resetOrientation", "runDragAnimation", "runEnterAnimation", "runExitAnimation", "bm", "Landroid/graphics/Bitmap;", "callback", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "showLoading", "showToolBar", "starHideToolBar", "startHideToolBarTimer", "stopHideToolBarTimer", "supportFullScreen", "updatePlayBtn", "playing", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MPVideoPlayFullScreenView
  extends RelativeLayout
  implements View.OnClickListener
{
  private View AMj;
  private MMNeat7extView Ilr;
  public float Roh;
  public int Roi;
  public int Roj;
  private RedesignVideoPlayerSeekBar SGW;
  public boolean SHh;
  public final String TAG;
  private com.tencent.mm.bj.a WXe;
  public View XlF;
  private View XlG;
  private ViewGroup XlH;
  public ViewGroup XlI;
  private View XlJ;
  private View XlK;
  private View XlL;
  private View XlM;
  private View XlN;
  private View XlO;
  public w XlP;
  private View XlQ;
  private double XlR;
  private int XlS;
  private long XlT;
  private final int XlU;
  private int XlV;
  private boolean XlW;
  private int XlX;
  private boolean XlY;
  private boolean XlZ;
  private final g Xma;
  private boolean Xmb;
  private Integer Xmc;
  private MTimerHandler Xmd;
  private final long Xme;
  private boolean Xmf;
  private boolean hLy;
  private ImageView lKK;
  private int mCurrentOrientation;
  public y nQs;
  private boolean nVt;
  private TextView nicknameTv;
  private ProgressBar njj;
  private View vKH;
  private View vME;
  public com.tencent.mm.ui.tools.f wAY;
  
  public MPVideoPlayFullScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82641);
    this.TAG = "MicroMsg.MPVideoPlayFullScreenView";
    this.XlU = -3;
    this.XlV = this.XlU;
    this.mCurrentOrientation = -1;
    this.WXe = new com.tencent.mm.bj.a(paramContext, new MPVideoPlayFullScreenView..ExternalSyntheticLambda9(this, paramContext));
    this.Xma = new g();
    View.inflate(paramContext, c.g.mp_video_play_fullscreen_layout, (ViewGroup)this);
    paramAttributeSet = findViewById(c.f.video_play_root_layout);
    s.s(paramAttributeSet, "findViewById(R.id.video_play_root_layout)");
    this.XlF = paramAttributeSet;
    paramAttributeSet = findViewById(c.f.video_play_op_layout);
    s.s(paramAttributeSet, "findViewById(R.id.video_play_op_layout)");
    this.XlG = paramAttributeSet;
    paramAttributeSet = findViewById(c.f.video_container_layout);
    s.s(paramAttributeSet, "findViewById(R.id.video_container_layout)");
    this.XlH = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(c.f.video_player_footer);
    s.s(paramAttributeSet, "findViewById(R.id.video_player_footer)");
    this.XlJ = paramAttributeSet;
    paramAttributeSet = findViewById(c.f.mp_info_layout);
    s.s(paramAttributeSet, "findViewById(R.id.mp_info_layout)");
    this.XlK = paramAttributeSet;
    paramAttributeSet = findViewById(c.f.video_touch_layout);
    s.s(paramAttributeSet, "findViewById(R.id.video_touch_layout)");
    this.XlL = paramAttributeSet;
    paramAttributeSet = findViewById(c.f.mp_video_avatar_layout);
    s.s(paramAttributeSet, "findViewById(R.id.mp_video_avatar_layout)");
    this.AMj = paramAttributeSet;
    paramAttributeSet = findViewById(c.f.mp_video_avatar_iv);
    s.s(paramAttributeSet, "findViewById(R.id.mp_video_avatar_iv)");
    this.lKK = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(c.f.mp_video_nickname_tv);
    s.s(paramAttributeSet, "findViewById(R.id.mp_video_nickname_tv)");
    this.nicknameTv = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(c.f.mp_video_title_tv);
    s.s(paramAttributeSet, "findViewById(R.id.mp_video_title_tv)");
    this.Ilr = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(c.f.mp_video_view_article_layout);
    s.s(paramAttributeSet, "findViewById(R.id.mp_video_view_article_layout)");
    this.vME = paramAttributeSet;
    this.SGW = ((RedesignVideoPlayerSeekBar)findViewById(c.f.video_player_seek_bar));
    this.XlQ = findViewById(c.f.tool_bar_mask);
    this.njj = ((ProgressBar)findViewById(c.f.video_player_progressbar));
    paramAttributeSet = this.SGW;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)this);
    }
    paramAttributeSet = this.XlJ;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener(MPVideoPlayFullScreenView..ExternalSyntheticLambda5.INSTANCE);
    }
    paramAttributeSet = this.XlK;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener(MPVideoPlayFullScreenView..ExternalSyntheticLambda7.INSTANCE);
    }
    this.AMj.setOnClickListener(new MPVideoPlayFullScreenView..ExternalSyntheticLambda4(this, paramContext));
    o.F(this.AMj, 0.7F);
    paramAttributeSet = findViewById(c.f.video_player_close);
    s.s(paramAttributeSet, "findViewById(R.id.video_player_close)");
    this.vKH = paramAttributeSet;
    this.vKH.setOnClickListener(new MPVideoPlayFullScreenView..ExternalSyntheticLambda2(this));
    paramAttributeSet = findViewById(c.f.video_player_more_iv);
    s.s(paramAttributeSet, "findViewById(R.id.video_player_more_iv)");
    this.XlM = paramAttributeSet;
    this.XlM.setOnClickListener(new MPVideoPlayFullScreenView..ExternalSyntheticLambda3(this, paramContext));
    paramAttributeSet = findViewById(c.f.video_player_share_iv);
    s.s(paramAttributeSet, "findViewById(R.id.video_player_share_iv)");
    this.XlO = paramAttributeSet;
    this.XlO.setOnClickListener(new MPVideoPlayFullScreenView..ExternalSyntheticLambda0(paramContext, this));
    paramContext = findViewById(c.f.video_wait_play_btn);
    s.s(paramContext, "findViewById(R.id.video_wait_play_btn)");
    this.XlN = paramContext;
    this.XlN.setOnClickListener(new MPVideoPlayFullScreenView..ExternalSyntheticLambda1(this));
    this.vME.setVisibility(8);
    paramContext = this.SGW;
    if (paramContext != null) {
      paramContext.setPlayBtnOnClickListener((View.OnClickListener)this);
    }
    paramContext = this.SGW;
    if (paramContext != null) {
      paramContext.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new e(this));
    }
    this.Roh = 1.0F;
    this.Xmd = new MTimerHandler(new MPVideoPlayFullScreenView..ExternalSyntheticLambda10(this), true);
    this.Xme = 4000L;
    AppMethodBeat.o(82641);
  }
  
  private final void IW(boolean paramBoolean)
  {
    AppMethodBeat.i(182653);
    Log.i(this.TAG, s.X("handleFullScreenStatusBar forwardUiVisibility ", Integer.valueOf(this.XlX)));
    if (paramBoolean)
    {
      localObject = getContext();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(182653);
        throw ((Throwable)localObject);
      }
      localObject = (Activity)localObject;
      ViewGroup localViewGroup = (ViewGroup)((Activity)localObject).getWindow().getDecorView();
      this.XlX = localViewGroup.getSystemUiVisibility();
      localViewGroup.setOnSystemUiVisibilityChangeListener(new MPVideoPlayFullScreenView..ExternalSyntheticLambda8(this, localViewGroup));
      localViewGroup.setSystemUiVisibility(4102);
      ((Activity)localObject).getWindow().addFlags(1024);
      AppMethodBeat.o(182653);
      return;
    }
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(182653);
      throw ((Throwable)localObject);
    }
    localObject = (Activity)localObject;
    ((ViewGroup)((Activity)localObject).getWindow().getDecorView()).setSystemUiVisibility(this.XlX);
    ((Activity)localObject).getWindow().clearFlags(1024);
    AppMethodBeat.o(182653);
  }
  
  private static final void a(Context paramContext, MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, View paramView)
  {
    AppMethodBeat.i(296789);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramContext);
    localb.cH(paramMPVideoPlayFullScreenView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramContext, "$context");
    s.u(paramMPVideoPlayFullScreenView, "this$0");
    if (((paramContext instanceof WebViewUI)) && (paramMPVideoPlayFullScreenView.nQs != null)) {
      if (aa.iOM())
      {
        paramView = f.Xmo;
        paramMPVideoPlayFullScreenView = paramMPVideoPlayFullScreenView.nQs;
        s.checkNotNull(paramMPVideoPlayFullScreenView);
        f.a(paramContext, paramMPVideoPlayFullScreenView, 5);
        h.OAn.b(18589, new Object[] { Integer.valueOf(16), Integer.valueOf(3) });
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(296789);
      return;
      ((WebViewUI)paramContext).WYF.nQs = paramMPVideoPlayFullScreenView.nQs;
      paramView = c.Xmk;
      paramView = paramMPVideoPlayFullScreenView.nQs;
      s.checkNotNull(paramView);
      paramView = paramView.nUM;
      localObject = paramMPVideoPlayFullScreenView.nQs;
      s.checkNotNull(localObject);
      localObject = ((y)localObject).title;
      paramMPVideoPlayFullScreenView = paramMPVideoPlayFullScreenView.nQs;
      s.checkNotNull(paramMPVideoPlayFullScreenView);
      c.a(paramContext, paramView, "", (String)localObject, paramMPVideoPlayFullScreenView.YMm, 2);
      break;
      Log.w(paramMPVideoPlayFullScreenView.TAG, "should not be here");
    }
  }
  
  private static final void a(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView)
  {
    AppMethodBeat.i(296797);
    s.u(paramMPVideoPlayFullScreenView, "this$0");
    paramMPVideoPlayFullScreenView.exit();
    AppMethodBeat.o(296797);
  }
  
  private static final void a(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, float paramFloat1, float paramFloat2)
  {
    int j = 1;
    AppMethodBeat.i(296811);
    s.u(paramMPVideoPlayFullScreenView, "this$0");
    if (paramFloat1 == 0.0F)
    {
      i = 1;
      if (i == 0) {
        break label62;
      }
      if (paramFloat2 != 0.0F) {
        break label57;
      }
    }
    label57:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label62;
      }
      paramMPVideoPlayFullScreenView.iBy();
      AppMethodBeat.o(296811);
      return;
      i = 0;
      break;
    }
    label62:
    if ((Math.abs(paramFloat1) > 10.0F) || (Math.abs(paramFloat2) > 10.0F)) {
      paramMPVideoPlayFullScreenView.iBz();
    }
    AppMethodBeat.o(296811);
  }
  
  private static final void a(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, Context paramContext, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(296774);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMPVideoPlayFullScreenView);
    localb.cH(paramContext);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
    s.u(paramMPVideoPlayFullScreenView, "this$0");
    s.u(paramContext, "$context");
    if (paramMPVideoPlayFullScreenView.nQs != null)
    {
      paramView = paramMPVideoPlayFullScreenView.nQs;
      if (paramView != null) {
        break label239;
      }
      paramView = null;
      if (!Util.isNullOrNil(paramView)) {}
    }
    else
    {
      Log.w(paramMPVideoPlayFullScreenView.TAG, "srcUserName is null");
    }
    paramView = new Intent();
    paramMPVideoPlayFullScreenView = paramMPVideoPlayFullScreenView.nQs;
    if (paramMPVideoPlayFullScreenView == null) {}
    for (paramMPVideoPlayFullScreenView = localObject1;; paramMPVideoPlayFullScreenView = paramMPVideoPlayFullScreenView.hEE)
    {
      paramView.putExtra("Contact_User", paramMPVideoPlayFullScreenView);
      paramView.putExtra("Contact_Scene", 163);
      paramView.putExtra("force_get_contact", true);
      paramView.putExtra("key_use_new_contact_profile", true);
      com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", paramView);
      h.OAn.b(18589, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(296774);
      return;
      label239:
      paramView = paramView.hEE;
      break;
    }
  }
  
  private static final void a(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, Context paramContext, a.a parama1, a.a parama2)
  {
    AppMethodBeat.i(296759);
    s.u(paramMPVideoPlayFullScreenView, "this$0");
    s.u(paramContext, "$context");
    if (paramMPVideoPlayFullScreenView.XlW)
    {
      if (parama2 == null) {}
      for (i = -1;; i = MPVideoPlayFullScreenView.a.$EnumSwitchMapping$0[parama2.ordinal()]) {
        switch (i)
        {
        default: 
          AppMethodBeat.o(296759);
          return;
        }
      }
    }
    for (int i = 0;; i = 8)
    {
      paramMPVideoPlayFullScreenView.mCurrentOrientation = i;
      ((Activity)paramContext).setRequestedOrientation(paramMPVideoPlayFullScreenView.mCurrentOrientation);
      paramMPVideoPlayFullScreenView.iBE();
      AppMethodBeat.o(296759);
      return;
    }
  }
  
  private static final void a(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, View paramView)
  {
    AppMethodBeat.i(296779);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMPVideoPlayFullScreenView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMPVideoPlayFullScreenView, "this$0");
    paramMPVideoPlayFullScreenView.exit();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(296779);
  }
  
  private static final void a(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(296822);
    s.u(paramMPVideoPlayFullScreenView, "this$0");
    s.u(paramViewGroup, "$decor");
    if (((paramInt & 0x4) == 0) && (paramMPVideoPlayFullScreenView.cuZ())) {
      paramViewGroup.setSystemUiVisibility(5894);
    }
    AppMethodBeat.o(296822);
  }
  
  private static final void a(boolean paramBoolean, MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView)
  {
    AppMethodBeat.i(296821);
    s.u(paramMPVideoPlayFullScreenView, "this$0");
    if (paramBoolean) {
      paramMPVideoPlayFullScreenView.XlN.setVisibility(8);
    }
    label86:
    for (;;)
    {
      Object localObject = paramMPVideoPlayFullScreenView.SGW;
      if (localObject != null) {
        ((RedesignVideoPlayerSeekBar)localObject).jJ(paramMPVideoPlayFullScreenView.hLy);
      }
      AppMethodBeat.o(296821);
      return;
      localObject = paramMPVideoPlayFullScreenView.njj;
      if ((localObject != null) && (((ProgressBar)localObject).getVisibility() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label86;
        }
        paramMPVideoPlayFullScreenView.XlN.setVisibility(0);
        break;
      }
    }
  }
  
  private static final void b(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView)
  {
    AppMethodBeat.i(296801);
    s.u(paramMPVideoPlayFullScreenView, "this$0");
    if (!paramMPVideoPlayFullScreenView.getForbidForward())
    {
      y localy = paramMPVideoPlayFullScreenView.nQs;
      if (localy != null)
      {
        f localf = f.Xmo;
        paramMPVideoPlayFullScreenView = paramMPVideoPlayFullScreenView.getContext();
        s.s(paramMPVideoPlayFullScreenView, "context");
        f.a(paramMPVideoPlayFullScreenView, localy, 3);
      }
    }
    AppMethodBeat.o(296801);
  }
  
  private static final void b(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, Context paramContext, View paramView)
  {
    AppMethodBeat.i(296784);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMPVideoPlayFullScreenView);
    localb.cH(paramContext);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMPVideoPlayFullScreenView, "this$0");
    s.u(paramContext, "$context");
    paramMPVideoPlayFullScreenView = paramMPVideoPlayFullScreenView.nQs;
    if (paramMPVideoPlayFullScreenView != null)
    {
      paramView = f.Xmo;
      f.a(paramContext, paramMPVideoPlayFullScreenView, 4);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(296784);
  }
  
  private static final void b(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, View paramView)
  {
    AppMethodBeat.i(296793);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMPVideoPlayFullScreenView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMPVideoPlayFullScreenView, "this$0");
    paramMPVideoPlayFullScreenView.iBu();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(296793);
  }
  
  private static final void c(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView)
  {
    AppMethodBeat.i(296805);
    s.u(paramMPVideoPlayFullScreenView, "this$0");
    if (paramMPVideoPlayFullScreenView.XlG.getVisibility() == 0)
    {
      paramMPVideoPlayFullScreenView.iBz();
      AppMethodBeat.o(296805);
      return;
    }
    paramMPVideoPlayFullScreenView.iBy();
    AppMethodBeat.o(296805);
  }
  
  private static final void d(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView)
  {
    AppMethodBeat.i(296819);
    s.u(paramMPVideoPlayFullScreenView, "this$0");
    paramMPVideoPlayFullScreenView.onExit();
    AppMethodBeat.o(296819);
  }
  
  private static final void de(View paramView)
  {
    AppMethodBeat.i(296763);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(296763);
  }
  
  private static final void df(View paramView)
  {
    AppMethodBeat.i(296767);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(296767);
  }
  
  private static final void e(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView)
  {
    AppMethodBeat.i(296825);
    s.u(paramMPVideoPlayFullScreenView, "this$0");
    ProgressBar localProgressBar = paramMPVideoPlayFullScreenView.njj;
    if ((localProgressBar != null) && (localProgressBar.getVisibility() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramMPVideoPlayFullScreenView = paramMPVideoPlayFullScreenView.njj;
        if (paramMPVideoPlayFullScreenView != null) {
          paramMPVideoPlayFullScreenView.setVisibility(0);
        }
      }
      AppMethodBeat.o(296825);
      return;
    }
  }
  
  private static final void f(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView)
  {
    AppMethodBeat.i(296827);
    s.u(paramMPVideoPlayFullScreenView, "this$0");
    ProgressBar localProgressBar = paramMPVideoPlayFullScreenView.njj;
    if ((localProgressBar != null) && (localProgressBar.getVisibility() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localProgressBar = paramMPVideoPlayFullScreenView.njj;
        if (localProgressBar != null) {
          localProgressBar.setVisibility(8);
        }
      }
      if (!paramMPVideoPlayFullScreenView.hLy) {
        paramMPVideoPlayFullScreenView.XlN.setVisibility(0);
      }
      AppMethodBeat.o(296827);
      return;
    }
  }
  
  private static final boolean g(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView)
  {
    AppMethodBeat.i(296829);
    s.u(paramMPVideoPlayFullScreenView, "this$0");
    paramMPVideoPlayFullScreenView.iBz();
    AppMethodBeat.o(296829);
    return false;
  }
  
  private final void iBA()
  {
    boolean bool = true;
    AppMethodBeat.i(82635);
    Object localObject = this.TAG;
    if (this.XlG.getVisibility() == 0) {}
    for (;;)
    {
      Log.d((String)localObject, "fadeOutOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = iBB();
      ((Animation)localObject).setFillAfter(false);
      ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this));
      this.XlG.clearAnimation();
      this.XlG.startAnimation((Animation)localObject);
      AppMethodBeat.o(82635);
      return;
      bool = false;
    }
  }
  
  private static Animation iBB()
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
  
  private final void iBC()
  {
    AppMethodBeat.i(82638);
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(82638);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getWindow().getDecorView();
    s.s(localObject, "context as Activity).window.decorView");
    ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new d((View)localObject, this));
    AppMethodBeat.o(82638);
  }
  
  private final void iBD()
  {
    AppMethodBeat.i(82639);
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(82639);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getWindow().getDecorView();
    s.s(localObject, "context as Activity).window.decorView");
    ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new c((View)localObject, this));
    AppMethodBeat.o(82639);
  }
  
  private final void iBE()
  {
    AppMethodBeat.i(182654);
    if ((this.mCurrentOrientation == 0) || (this.mCurrentOrientation == 8))
    {
      iBD();
      AppMethodBeat.o(182654);
      return;
    }
    iBC();
    AppMethodBeat.o(182654);
  }
  
  private final void iBs()
  {
    AppMethodBeat.i(82626);
    if (this.wAY == null) {
      this.wAY = new com.tencent.mm.ui.tools.f(getContext());
    }
    if (this.nQs == null)
    {
      this.Xmb = true;
      AppMethodBeat.o(82626);
      return;
    }
    this.Xmb = false;
    Object localObject = this.nQs;
    s.checkNotNull(localObject);
    int i = ((y)localObject).nVm;
    localObject = this.nQs;
    s.checkNotNull(localObject);
    int j = ((y)localObject).nVn;
    localObject = this.nQs;
    s.checkNotNull(localObject);
    int k = ((y)localObject).nVo;
    localObject = this.nQs;
    s.checkNotNull(localObject);
    int m = ((y)localObject).nVp;
    localObject = this.wAY;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.f)localObject).af(i, j, k, m);
    }
    localObject = this.wAY;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.f)localObject).afIg = 1.0F;
    }
    localObject = this.wAY;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.f)localObject).oE(0, 0);
    }
    iBt();
    AppMethodBeat.o(82626);
  }
  
  private final void iBt()
  {
    AppMethodBeat.i(82627);
    Object localObject = this.XlI;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getViewTreeObserver();
      if (localObject != null) {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new g(this));
      }
    }
    AppMethodBeat.o(82627);
  }
  
  private final void iBu()
  {
    AppMethodBeat.i(82631);
    w localw;
    if (this.hLy)
    {
      localw = this.XlP;
      if (localw != null)
      {
        localw.hSS();
        AppMethodBeat.o(82631);
      }
    }
    else
    {
      localw = this.XlP;
      if (localw != null) {
        localw.kfv();
      }
    }
    AppMethodBeat.o(82631);
  }
  
  private final void iBv()
  {
    try
    {
      AppMethodBeat.i(296717);
      Object localObject1 = getContext();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(296717);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    Activity localActivity = (Activity)localObject2;
    if (this.nQs == null)
    {
      Log.d(this.TAG, "adjustOrientation mpShareVideoInfo is null");
      AppMethodBeat.o(296717);
    }
    for (;;)
    {
      return;
      if ((!this.XlY) && (this.XlZ)) {
        break;
      }
      Log.i(this.TAG, "adjustOrientation hasAdjustOrientation=" + this.XlY + ", hasAddVideoView=" + this.XlZ);
      AppMethodBeat.o(296717);
    }
    this.XlY = true;
    if (this.XlV == this.XlU) {
      this.XlV = localActivity.getRequestedOrientation();
    }
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("adjustOrientation width = ");
    y localy = this.nQs;
    s.checkNotNull(localy);
    localStringBuilder = localStringBuilder.append(localy.width).append(", height=");
    localy = this.nQs;
    s.checkNotNull(localy);
    Log.i((String)localObject3, localy.height);
    localObject3 = this.nQs;
    s.checkNotNull(localObject3);
    int i = ((y)localObject3).width;
    localObject3 = this.nQs;
    s.checkNotNull(localObject3);
    if (i <= ((y)localObject3).height)
    {
      this.mCurrentOrientation = 1;
      localActivity.setRequestedOrientation(this.mCurrentOrientation);
      this.XlW = false;
    }
    for (;;)
    {
      iBE();
      AppMethodBeat.o(296717);
      break;
      this.XlW = true;
      this.mCurrentOrientation = 0;
      localActivity.setRequestedOrientation(this.mCurrentOrientation);
      this.WXe.enable();
    }
  }
  
  private final int iBx()
  {
    AppMethodBeat.i(82633);
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(82633);
      throw ((Throwable)localObject);
    }
    int i = ((Activity)localObject).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
    if (i == 10000)
    {
      localObject = getContext();
      if ((localObject instanceof com.tencent.mm.plugin.webview.core.d))
      {
        localObject = (com.tencent.mm.plugin.webview.core.d)localObject;
        if (localObject != null) {
          break label113;
        }
        localObject = null;
      }
    }
    for (;;)
    {
      label113:
      try
      {
        int j = Util.getInt(Uri.parse((String)localObject).getQueryParameter("scene"), 10000);
        i = j;
        AppMethodBeat.o(82633);
        return i;
      }
      catch (Exception localException) {}
      localObject = null;
      break;
      localObject = ((com.tencent.mm.plugin.webview.core.d)localObject).dgY();
    }
  }
  
  private final void iBy()
  {
    AppMethodBeat.i(296736);
    if (BuildInfo.IS_FLAVOR_RED) {
      Log.d(this.TAG, "showToolBar %s", new Object[] { Util.getStack() });
    }
    if (this.Xmf)
    {
      AppMethodBeat.o(296736);
      return;
    }
    this.Xmf = true;
    Object localObject = this.TAG;
    if (this.XlG.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d((String)localObject, "fadeInOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      this.XlG.clearAnimation();
      localObject = this.XlG;
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(150L);
      localAlphaAnimation.setFillAfter(true);
      ((View)localObject).startAnimation((Animation)localAlphaAnimation);
      Log.d(this.TAG, "start timer");
      if (!this.Xmd.stopped())
      {
        Log.d(this.TAG, "stop timer");
        this.Xmd.stopTimer();
      }
      this.Xmd.startTimer(this.Xme);
      this.XlK.setVisibility(0);
      localObject = this.XlJ;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.XlG;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      AppMethodBeat.o(296736);
      return;
    }
  }
  
  private static final void kE(View paramView)
  {
    AppMethodBeat.i(296815);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(296815);
  }
  
  private void removeVideoView()
  {
    AppMethodBeat.i(82632);
    this.XlH.removeAllViews();
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
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
      Object localObject1;
      try
      {
        AppMethodBeat.i(296957);
        s.u(paramy, "mpShareVideoInfo");
        this.nQs = paramy;
        this.nVt = paramy.nVt;
        this.Ilr.getPaint().setFakeBoldText(true);
        this.nicknameTv.getPaint().setFakeBoldText(true);
        localObject1 = this.Ilr;
        paramy = this.nQs;
        if (paramy == null)
        {
          paramy = null;
          ((MMNeat7extView)localObject1).aZ((CharSequence)paramy);
          localObject1 = this.nicknameTv;
          Object localObject2 = getContext();
          paramy = this.nQs;
          if (paramy == null)
          {
            paramy = null;
            ((TextView)localObject1).setText((CharSequence)p.b((Context)localObject2, (CharSequence)paramy, this.nicknameTv.getTextSize()));
            if (!this.nVt) {
              continue;
            }
            this.XlM.setVisibility(8);
            this.XlO.setVisibility(8);
            localObject1 = getContext();
            if ((localObject1 instanceof WebViewUI))
            {
              paramy = this.nQs;
              if (paramy != null) {
                break label300;
              }
              paramy = null;
              if (Util.isNullOrNil(paramy)) {
                break label316;
              }
              paramy = this.nQs;
              if (paramy != null) {
                break label308;
              }
              paramy = null;
              localObject1 = com.tencent.mm.modelimage.loader.a.bKl();
              localObject2 = this.lKK;
              c.a locala = new c.a();
              locala.nrc = true;
              locala.oKB = c.e.brand_default_head;
              ((com.tencent.mm.modelimage.loader.a)localObject1).a(paramy, (ImageView)localObject2, locala.bKx());
            }
            if (this.Xmb) {
              iBs();
            }
            Log.d(this.TAG, "initData");
            iBv();
            AppMethodBeat.o(296957);
          }
        }
        else
        {
          paramy = paramy.title;
          continue;
        }
        paramy = paramy.nUF;
        continue;
        this.XlM.setVisibility(0);
        this.XlO.setVisibility(0);
        continue;
        paramy = paramy.nVs;
      }
      finally {}
      label300:
      continue;
      label308:
      paramy = paramy.nVs;
      continue;
      label316:
      paramy = ((WebViewUI)localObject1).WYr;
      if (paramy == null)
      {
        paramy = null;
      }
      else
      {
        paramy = paramy.LCE;
        if (paramy == null)
        {
          paramy = null;
        }
        else
        {
          paramy = paramy.gkh();
          if (paramy == null) {
            paramy = null;
          } else {
            paramy = paramy.aaXP;
          }
        }
      }
    }
  }
  
  public final boolean cuZ()
  {
    AppMethodBeat.i(296980);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(296980);
      return true;
    }
    AppMethodBeat.o(296980);
    return false;
  }
  
  public final void exit()
  {
    AppMethodBeat.i(82628);
    Context localContext = getContext();
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).sMP != null))
    {
      if (((WebViewUI)localContext).sMP != null)
      {
        Log.i(this.TAG, "close click");
        iBw();
        ((WebViewUI)localContext).sMP.leaveFullscreen();
        MMHandlerThread.postToMainThreadDelayed(new MPVideoPlayFullScreenView..ExternalSyntheticLambda17(this), 500L);
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
    return this.XlS;
  }
  
  public final long getEnterTimeInMs()
  {
    return this.XlT;
  }
  
  public final boolean getForbidForward()
  {
    return this.nVt;
  }
  
  public final g getMpShareVideoReport()
  {
    return this.Xma;
  }
  
  public final Integer getSubScene()
  {
    return this.Xmc;
  }
  
  public final void iBw()
  {
    AppMethodBeat.i(182652);
    if (this.XlV != this.XlU)
    {
      Object localObject = getContext();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(182652);
        throw ((Throwable)localObject);
      }
      ((Activity)localObject).setRequestedOrientation(this.XlV);
      this.XlV = this.XlU;
      this.WXe.disable();
    }
    IW(false);
    AppMethodBeat.o(182652);
  }
  
  public final void iBz()
  {
    AppMethodBeat.i(82634);
    if (BuildInfo.IS_FLAVOR_RED) {
      Log.d(this.TAG, "hideOpLayer %s", new Object[] { Util.getStack() });
    }
    if (!this.Xmf)
    {
      AppMethodBeat.o(82634);
      return;
    }
    this.Xmf = false;
    iBA();
    AppMethodBeat.o(82634);
  }
  
  public final void kD(View paramView)
  {
    try
    {
      AppMethodBeat.i(296976);
      s.u(paramView, "view");
      if (this.nQs == null) {
        break label203;
      }
      localObject1 = this.nQs;
      s.checkNotNull(localObject1);
      ((y)localObject1).nVq = this.XlS;
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        AppMethodBeat.o(296976);
        throw paramView;
      }
    }
    finally {}
    Object localObject2 = (WebViewUI)localObject1;
    Object localObject1 = ((WebViewUI)localObject2).sLC;
    if (localObject1 != null) {}
    try
    {
      localObject1 = this.Xma;
      localObject2 = ((WebViewUI)localObject2).sLC;
      Object localObject3 = this.nQs;
      s.checkNotNull(localObject3);
      ((g)localObject1).Xmw = ((e)localObject2).IR(((y)localObject3).hEE);
      this.Xma.scene = 141;
      this.Xma.AcJ = iBx();
      label143:
      this.XlT = System.currentTimeMillis();
      this.XlS = ((int)(this.XlT / 1000L));
      this.Xma.a(this.nQs, 1, this.XlS);
      this.Xma.a(this.nQs, 5, this.XlS);
      this.Xma.oYt = 0;
      label203:
      removeVideoView();
      IW(true);
      this.XlF.setAlpha(1.0F);
      this.XlF.setBackgroundColor(-16777216);
      setVisibility(0);
      localObject1 = new FrameLayout(getContext());
      ((FrameLayout)localObject1).addView(paramView, new ViewGroup.LayoutParams(-1, -2));
      paramView = ah.aiuX;
      this.XlI = ((ViewGroup)localObject1);
      paramView = this.XlH;
      localObject1 = (View)this.XlI;
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      localObject3 = ah.aiuX;
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      iBs();
      this.SHh = false;
      Log.d(this.TAG, "addVideoView");
      this.XlZ = true;
      iBv();
      AppMethodBeat.o(296976);
      return;
    }
    catch (Exception localException)
    {
      break label143;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(82630);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((paramView != null) && (paramView.getId() == c.f.play_btn)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        iBu();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(82630);
      return;
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(82637);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      Log.d(this.TAG, "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      iBC();
      AppMethodBeat.o(82637);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      Log.d(this.TAG, "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
      iBD();
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
    this.XlY = false;
    this.XlZ = false;
    if (this.nQs != null)
    {
      this.Xma.Xmu = ((int)(System.currentTimeMillis() - this.XlT));
      this.Xma.Xmt = ((int)(this.XlR * 1000.0D));
      this.Xma.a(this.nQs, 6, this.XlS);
      this.Xma.a(this.nQs, 2, this.XlS);
      Object localObject1 = getContext();
      if (((localObject1 instanceof WebViewUI)) && (((WebViewUI)localObject1).WlX != null))
      {
        localObject1 = ((WebViewUI)localObject1).WlX;
        Object localObject2 = this.nQs;
        s.checkNotNull(localObject2);
        localObject2 = ((y)localObject2).YMn;
        int i = (int)this.XlR;
        if (((j)localObject1).UcS)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("videoVid", localObject2);
          localHashMap.put("videoCurrTime", Integer.valueOf(i));
          localHashMap.put("action", "onExitMpVideoFullPage");
          localObject2 = p.a.b("onMPPageAction", localHashMap, ((j)localObject1).WDI, ((j)localObject1).KQY);
          ((j)localObject1).WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject2 + ")", null);
        }
      }
      this.nQs = null;
    }
    AppMethodBeat.o(82629);
  }
  
  public final void setEnterId(int paramInt)
  {
    this.XlS = paramInt;
  }
  
  public final void setEnterTimeInMs(long paramLong)
  {
    this.XlT = paramLong;
  }
  
  public final void setForbidForward(boolean paramBoolean)
  {
    this.nVt = paramBoolean;
  }
  
  public final void setSubScene(Integer paramInteger)
  {
    this.Xmc = paramInteger;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$fadeOutOpLayout$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animation.AnimationListener
  {
    b(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(82592);
      s.u(paramAnimation, "animation");
      if (!MPVideoPlayFullScreenView.u(this.Xmg)) {
        MPVideoPlayFullScreenView.v(this.Xmg);
      }
      AppMethodBeat.o(82592);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(82593);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(82593);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(82591);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(82591);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$handleHorizontalUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    c(View paramView, MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82594);
      this.vPJ.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      if (com.tencent.mm.compatible.util.d.rb(24))
      {
        localObject1 = jdField_this.getContext();
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(82594);
          throw ((Throwable)localObject1);
        }
        if (((Activity)localObject1).isInMultiWindowMode())
        {
          MPVideoPlayFullScreenView.w(jdField_this);
          AppMethodBeat.o(82594);
          return;
        }
      }
      int n = bf.bk(jdField_this.getContext());
      int i = com.tencent.mm.cd.a.bs(jdField_this.getContext(), c.d.Edge_A);
      int j = i * 3;
      int k = i * 4;
      int m = i * 7;
      n = Math.max(n - j, 0);
      MPVideoPlayFullScreenView.x(jdField_this).setPadding(n, i * 2, n - i, i * 2);
      Object localObject1 = MPVideoPlayFullScreenView.y(jdField_this);
      if (localObject1 != null)
      {
        localObject2 = jdField_this;
        ((View)localObject1).setPadding(0, 0, 0, 0);
        Object localObject3 = ((View)localObject1).getLayoutParams();
        if (localObject3 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(82594);
          throw ((Throwable)localObject1);
        }
        localObject3 = (RelativeLayout.LayoutParams)localObject3;
        ((RelativeLayout.LayoutParams)localObject3).height = com.tencent.mm.cd.a.br(((MPVideoPlayFullScreenView)localObject2).getContext(), c.d.Edge_14A);
        localObject2 = ah.aiuX;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      }
      localObject1 = MPVideoPlayFullScreenView.z(jdField_this).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(k, j, 0, j);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      MPVideoPlayFullScreenView.z(jdField_this).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = MPVideoPlayFullScreenView.A(jdField_this).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, j, k, j);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      MPVideoPlayFullScreenView.A(jdField_this).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = MPVideoPlayFullScreenView.B(jdField_this).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, j, k, j);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      MPVideoPlayFullScreenView.B(jdField_this).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = MPVideoPlayFullScreenView.t(jdField_this);
      s.checkNotNull(localObject1);
      localObject1 = ((RedesignVideoPlayerSeekBar)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, c.f.video_player_close);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, c.f.video_player_share_iv);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(m, j, m, j);
      Object localObject2 = MPVideoPlayFullScreenView.t(jdField_this);
      if (localObject2 != null) {
        ((RedesignVideoPlayerSeekBar)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      AppMethodBeat.o(82594);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$handleVerticalUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    d(View paramView, MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82595);
      this.vPJ.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      MPVideoPlayFullScreenView.w(jdField_this);
      AppMethodBeat.o(82595);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$initSeekBar$1", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "onSeeking", "currentTime", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.plugin.sight.decode.ui.b
  {
    e(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void blc() {}
    
    public final void tS(int paramInt)
    {
      AppMethodBeat.i(82598);
      Log.i(MPVideoPlayFullScreenView.h(this.Xmg), s.X("initSeekBar onSeekTo ", Integer.valueOf(paramInt)));
      w localw = MPVideoPlayFullScreenView.o(this.Xmg);
      if (localw != null) {
        localw.Z(paramInt);
      }
      AppMethodBeat.o(82598);
    }
    
    public final void tT(int paramInt) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$initVideoController$1", "Lcom/tencent/xweb/VideoJsCallback;", "lastUpdateTime", "", "getLastUpdateTime", "()J", "setLastUpdateTime", "(J)V", "onSetRequestedOrientation", "", "orientation", "", "onVideoEmptied", "", "onVideoEnded", "onVideoEnterFullscreen", "isVideoTag", "id", "width", "", "height", "paused", "seeking", "currentTime", "duration", "buffered", "", "onVideoError", "error", "msg", "", "onVideoExitFullscreen", "onVideoPause", "onVideoPlay", "onVideoPlaying", "onVideoRateChange", "rate", "onVideoSeeked", "onVideoSeeking", "onVideoSizeUpdate", "onVideoTimeUpdate", "onVideoVolumeChange", "muted", "onVideoWaiting", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements x
  {
    private long lastUpdateTime;
    
    public f(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    private static final void a(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, double paramDouble1, double paramDouble2, double[] paramArrayOfDouble)
    {
      int j = 1;
      AppMethodBeat.i(296672);
      s.u(paramMPVideoPlayFullScreenView, "this$0");
      RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = MPVideoPlayFullScreenView.t(paramMPVideoPlayFullScreenView);
      if (localRedesignVideoPlayerSeekBar != null) {
        localRedesignVideoPlayerSeekBar.setVideoTotalTime((int)paramDouble1);
      }
      localRedesignVideoPlayerSeekBar = MPVideoPlayFullScreenView.t(paramMPVideoPlayFullScreenView);
      if (localRedesignVideoPlayerSeekBar != null) {
        localRedesignVideoPlayerSeekBar.Bh((int)paramDouble2);
      }
      if (paramArrayOfDouble != null)
      {
        if (paramArrayOfDouble.length != 0) {
          break label114;
        }
        i = 1;
        if (i != 0) {
          break label120;
        }
      }
      label114:
      label120:
      for (int i = j;; i = 0)
      {
        if (i != 0)
        {
          paramMPVideoPlayFullScreenView = MPVideoPlayFullScreenView.t(paramMPVideoPlayFullScreenView);
          if (paramMPVideoPlayFullScreenView != null)
          {
            s.u(paramArrayOfDouble, "$this$lastIndex");
            paramMPVideoPlayFullScreenView.axi((int)paramArrayOfDouble[(paramArrayOfDouble.length - 1)]);
          }
        }
        AppMethodBeat.o(296672);
        return;
        i = 0;
        break;
      }
    }
    
    public final boolean Bu(int paramInt)
    {
      return false;
    }
    
    public final void cxJ()
    {
      AppMethodBeat.i(82602);
      Log.i(MPVideoPlayFullScreenView.h(this.Xmg), "onVideoEmptied");
      MPVideoPlayFullScreenView.p(this.Xmg);
      AppMethodBeat.o(82602);
    }
    
    public final void onVideoEnded()
    {
      AppMethodBeat.i(82600);
      Log.i(MPVideoPlayFullScreenView.h(this.Xmg), "onVideoEnded");
      MPVideoPlayFullScreenView.b(this.Xmg, false);
      MPVideoPlayFullScreenView.p(this.Xmg);
      this.Xmg.getMpShareVideoReport().a(MPVideoPlayFullScreenView.q(this.Xmg), 7, this.Xmg.getEnterId());
      this.Xmg.getMpShareVideoReport().oYt = 4;
      AppMethodBeat.o(82600);
    }
    
    public final void onVideoEnterFullscreen(boolean paramBoolean1, long paramLong, double paramDouble1, double paramDouble2, boolean paramBoolean2, boolean paramBoolean3, double paramDouble3, double paramDouble4, double[] paramArrayOfDouble)
    {
      AppMethodBeat.i(82609);
      Log.i(MPVideoPlayFullScreenView.h(this.Xmg), "onVideoEnterFullscreen isVideoTag:" + paramBoolean1 + ", id:" + paramLong + ", width:" + paramDouble1 + ", height:" + paramDouble2 + ", paused:" + paramBoolean2 + ", seeking:" + paramBoolean3 + ", currentTime:" + paramDouble3 + ", duration:" + paramDouble4 + ", buffered:" + Arrays.toString(paramArrayOfDouble));
      paramArrayOfDouble = this.Xmg;
      if (!paramBoolean2) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        MPVideoPlayFullScreenView.c(paramArrayOfDouble, paramBoolean1);
        MPVideoPlayFullScreenView.b(this.Xmg, MPVideoPlayFullScreenView.r(this.Xmg));
        if (MPVideoPlayFullScreenView.r(this.Xmg))
        {
          this.Xmg.getMpShareVideoReport().oYt = 1;
          this.Xmg.getMpShareVideoReport().a(MPVideoPlayFullScreenView.q(this.Xmg), this.Xmg.getMpShareVideoReport().getPlayType(), this.Xmg.getEnterId());
        }
        AppMethodBeat.o(82609);
        return;
      }
    }
    
    public final void onVideoError(int paramInt, String paramString)
    {
      AppMethodBeat.i(82601);
      Log.e(MPVideoPlayFullScreenView.h(this.Xmg), "onVideoError " + paramInt + ", " + paramString);
      MPVideoPlayFullScreenView.b(this.Xmg, false);
      MPVideoPlayFullScreenView.p(this.Xmg);
      this.Xmg.getMpShareVideoReport().oYt = 4;
      this.Xmg.getMpShareVideoReport().Xmv = paramString;
      this.Xmg.getMpShareVideoReport().a(MPVideoPlayFullScreenView.q(this.Xmg), 11, this.Xmg.getEnterId());
      AppMethodBeat.o(82601);
    }
    
    public final void onVideoExitFullscreen()
    {
      AppMethodBeat.i(82610);
      Log.i(MPVideoPlayFullScreenView.h(this.Xmg), "onVideoExitFullscreen");
      AppMethodBeat.o(82610);
    }
    
    public final void onVideoPause()
    {
      AppMethodBeat.i(82608);
      Log.i(MPVideoPlayFullScreenView.h(this.Xmg), "onVideoPause");
      MPVideoPlayFullScreenView.b(this.Xmg, false);
      MPVideoPlayFullScreenView.p(this.Xmg);
      if (this.Xmg.getMpShareVideoReport().oYt != 3) {
        this.Xmg.getMpShareVideoReport().a(MPVideoPlayFullScreenView.q(this.Xmg), 8, this.Xmg.getEnterId());
      }
      this.Xmg.getMpShareVideoReport().oYt = 3;
      AppMethodBeat.o(82608);
    }
    
    public final void onVideoPlay()
    {
      AppMethodBeat.i(82607);
      Log.i(MPVideoPlayFullScreenView.h(this.Xmg), "onVideoPlay");
      MPVideoPlayFullScreenView.b(this.Xmg, true);
      MPVideoPlayFullScreenView.p(this.Xmg);
      if (this.Xmg.getMpShareVideoReport().oYt != 2) {
        this.Xmg.getMpShareVideoReport().a(MPVideoPlayFullScreenView.q(this.Xmg), this.Xmg.getMpShareVideoReport().getPlayType(), this.Xmg.getEnterId());
      }
      this.Xmg.getMpShareVideoReport().oYt = 2;
      AppMethodBeat.o(82607);
    }
    
    public final void onVideoPlaying()
    {
      AppMethodBeat.i(82603);
      Log.d(MPVideoPlayFullScreenView.h(this.Xmg), "onVideoPlaying");
      if (!MPVideoPlayFullScreenView.r(this.Xmg))
      {
        MPVideoPlayFullScreenView.b(this.Xmg, true);
        MPVideoPlayFullScreenView.p(this.Xmg);
      }
      this.Xmg.getMpShareVideoReport().oYt = 2;
      AppMethodBeat.o(82603);
    }
    
    public final void onVideoSeeked()
    {
      AppMethodBeat.i(82606);
      Log.i(MPVideoPlayFullScreenView.h(this.Xmg), "onVideoSeeked");
      MPVideoPlayFullScreenView.p(this.Xmg);
      this.Xmg.getMpShareVideoReport().a(MPVideoPlayFullScreenView.q(this.Xmg), 13, this.Xmg.getEnterId());
      AppMethodBeat.o(82606);
    }
    
    public final void onVideoSeeking()
    {
      AppMethodBeat.i(82605);
      Log.i(MPVideoPlayFullScreenView.h(this.Xmg), "onVideoSeeking");
      MPVideoPlayFullScreenView.s(this.Xmg);
      AppMethodBeat.o(82605);
    }
    
    public final void onVideoSizeUpdate(double paramDouble1, double paramDouble2)
    {
      int j = 1;
      AppMethodBeat.i(82612);
      y localy = MPVideoPlayFullScreenView.q(this.Xmg);
      if ((localy != null) && (localy.width == 0))
      {
        i = 1;
        if (i == 0)
        {
          localy = MPVideoPlayFullScreenView.q(this.Xmg);
          if ((localy == null) || (localy.height != 0)) {
            break label123;
          }
        }
      }
      label123:
      for (int i = j;; i = 0)
      {
        if (i != 0)
        {
          localy = MPVideoPlayFullScreenView.q(this.Xmg);
          if (localy != null) {
            localy.width = ((int)paramDouble1);
          }
          localy = MPVideoPlayFullScreenView.q(this.Xmg);
          if (localy != null) {
            localy.height = ((int)paramDouble2);
          }
        }
        AppMethodBeat.o(82612);
        return;
        i = 0;
        break;
      }
    }
    
    public final void onVideoTimeUpdate(double paramDouble1, double paramDouble2, double[] paramArrayOfDouble)
    {
      AppMethodBeat.i(82611);
      if (System.currentTimeMillis() - this.lastUpdateTime >= 500L)
      {
        this.lastUpdateTime = System.currentTimeMillis();
        MMHandlerThread.postToMainThread(new MPVideoPlayFullScreenView.f..ExternalSyntheticLambda0(this.Xmg, paramDouble2, paramDouble1, paramArrayOfDouble));
      }
      MPVideoPlayFullScreenView.a(this.Xmg, paramDouble1);
      MPVideoPlayFullScreenView.p(this.Xmg);
      AppMethodBeat.o(82611);
    }
    
    public final void onVideoWaiting()
    {
      AppMethodBeat.i(82604);
      Log.i(MPVideoPlayFullScreenView.h(this.Xmg), "onVideoWaiting");
      MPVideoPlayFullScreenView.s(this.Xmg);
      AppMethodBeat.o(82604);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runEnterAnimation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    g(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82620);
      Log.d(MPVideoPlayFullScreenView.h(this.Xmg), "runEnterAnimation");
      Object localObject = MPVideoPlayFullScreenView.i(this.Xmg);
      if (localObject != null)
      {
        localObject = ((ViewGroup)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      localObject = MPVideoPlayFullScreenView.i(this.Xmg);
      if (localObject == null) {}
      for (localObject = null;; localObject = Integer.valueOf(((ViewGroup)localObject).getHeight()))
      {
        s.checkNotNull(localObject);
        if (((Integer)localObject).intValue() > 0) {
          break;
        }
        MPVideoPlayFullScreenView.j(this.Xmg);
        AppMethodBeat.o(82620);
        return;
      }
      MPVideoPlayFullScreenView.k(this.Xmg);
      localObject = MPVideoPlayFullScreenView.l(this.Xmg);
      if (localObject != null)
      {
        ViewGroup localViewGroup = MPVideoPlayFullScreenView.i(this.Xmg);
        s.checkNotNull(localViewGroup);
        ((com.tencent.mm.ui.tools.f)localObject).a((View)localViewGroup, null, (f.c)new a(this.Xmg));
      }
      AppMethodBeat.o(82620);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runEnterAnimation$1$onGlobalLayout$1", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements f.c
    {
      a(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(82619);
        MPVideoPlayFullScreenView.m(this.Xmg);
        AppMethodBeat.o(82619);
      }
      
      public final void onAnimationStart() {}
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runExitAnimation$2", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements f.c
  {
    public h(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, ViewGroup.LayoutParams paramLayoutParams) {}
    
    private static final void a(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, ViewGroup.LayoutParams paramLayoutParams)
    {
      AppMethodBeat.i(296670);
      s.u(paramMPVideoPlayFullScreenView, "this$0");
      Context localContext = paramMPVideoPlayFullScreenView.getContext();
      if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).sMP != null))
      {
        localContext = paramMPVideoPlayFullScreenView.getContext();
        if (localContext == null)
        {
          paramMPVideoPlayFullScreenView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
          AppMethodBeat.o(296670);
          throw paramMPVideoPlayFullScreenView;
        }
        ((WebViewUI)localContext).sMP.leaveFullscreen();
      }
      MPVideoPlayFullScreenView.n(paramMPVideoPlayFullScreenView).setLayoutParams(paramLayoutParams);
      AppMethodBeat.o(296670);
    }
    
    public final void onAnimationEnd()
    {
      AppMethodBeat.i(82623);
      f.c localc = this.Xmh;
      if (localc != null) {
        localc.onAnimationEnd();
      }
      MPVideoPlayFullScreenView.n(this.Xmg).post(new MPVideoPlayFullScreenView.h..ExternalSyntheticLambda0(this.Xmg, this.Xmi));
      MPVideoPlayFullScreenView.a(this.Xmg, false);
      this.Xmg.onExit();
      AppMethodBeat.o(82623);
    }
    
    public final void onAnimationStart()
    {
      AppMethodBeat.i(82622);
      MPVideoPlayFullScreenView.a(this.Xmg, true);
      f.c localc = this.Xmh;
      if (localc != null) {
        localc.onAnimationStart();
      }
      AppMethodBeat.o(82622);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView
 * JD-Core Version:    0.7.0.1
 */