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
import com.tencent.mm.ag.y;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.bo.a.a;
import com.tencent.mm.bo.a.b;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.tools.e.b;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.tools.e.d;
import com.tencent.mm.ui.tools.e.e;
import com.tencent.mm.ui.tools.e.f;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.u;
import com.tencent.xweb.v;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ENTER_HIDE_MIL_SEC", "", "INVALID_ORIENTATION", "", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/view/View;", "centerPlayIv", "closeIv", "currentPlayTime", "", "enterId", "getEnterId", "()I", "setEnterId", "(I)V", "enterTimeInMs", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "footerLayout", "forbidForward", "", "getForbidForward", "()Z", "setForbidForward", "(Z)V", "forwardUiVisibility", "hasAddVideoView", "hasAdjustOrientation", "hideToolBarTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "imagePreviewAnimation", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;", "isLandScapeVideo", "isPlaying", "isRunningExitAnimation", "loadingBar", "Landroid/widget/ProgressBar;", "mCurrentOrientation", "mIsShowOpLayout", "mPreOrientation", "moreIv", "moreLayout", "mpInfoLayout", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "mpShareVideoReport", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "getMpShareVideoReport", "()Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "needDoAnimation", "nicknameTv", "Landroid/widget/TextView;", "orientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "preDeltaX", "preDeltaY", "preScale", "", "shareIv", "subScene", "getSubScene", "()Ljava/lang/Integer;", "setSubScene", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "toolBarMask", "touchLayout", "videoContainerLayout", "Landroid/view/ViewGroup;", "videoControl", "Lcom/tencent/xweb/VideoControl;", "videoPlayOpLayout", "videoPlayRootLayout", "videoPlayerSeekBar", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "videoRootLayout", "addVideoView", "", "view", "adjustOrientation", "exit", "fadeInAnimation", "Landroid/view/animation/Animation;", "fadeInOpLayout", "fadeOutAnimation", "duration", "fadeOutOpLayout", "force", "handleAnimation", "handleFullScreenStatusBar", "fullScreen", "handleHorizontalUI", "handleScreenSize", "handleVerticalUI", "hideLoading", "hideToolBar", "initData", "initReportData", "initSeekBar", "initVideoController", "initView", "isInFullScreen", "loadAvatar", "onClick", "v", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onExit", "onExitMpVideoFullPage", "onResume", "opPlay", "postHandleVerticalUI", "removeVideoView", "resetOrientation", "runDragAnimation", "runEnterAnimation", "runExitAnimation", "bm", "Landroid/graphics/Bitmap;", "callback", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "showLoading", "showToolBar", "starHideToolBar", "startHideToolBarTimer", "stopHideToolBarTimer", "supportFullScreen", "updatePlayBtn", "playing", "plugin-webview_release"})
public final class MPVideoPlayFullScreenView
  extends RelativeLayout
  implements View.OnClickListener
{
  public float EAC;
  public int EAD;
  public int EAE;
  public boolean FLK;
  private RedesignVideoPlayerSeekBar FLz;
  private com.tencent.mm.bo.a Jii;
  public View JvH;
  private View JvI;
  private ViewGroup JvJ;
  public ViewGroup JvK;
  private View JvL;
  private View JvM;
  private View JvN;
  private View JvO;
  private View JvP;
  private View JvQ;
  public u JvR;
  private View JvS;
  private double JvT;
  private final int JvU;
  private int JvV;
  private boolean JvW;
  private boolean JvX;
  private boolean JvY;
  private final h JvZ;
  private boolean Jwa;
  private Integer Jwb;
  private MTimerHandler Jwc;
  private final long Jwd;
  private boolean Jwe;
  public final String TAG;
  private boolean gVd;
  private ImageView gyr;
  private ProgressBar hRO;
  private boolean iAS;
  public y iwi;
  private int mCurrentOrientation;
  private int pHu;
  private TextView pIN;
  private MMNeat7extView pIO;
  private long pLN;
  private int pNM;
  private View pvJ;
  private View pxG;
  public com.tencent.mm.ui.tools.e qaE;
  private View tFX;
  
  public MPVideoPlayFullScreenView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82641);
    this.TAG = "MicroMsg.MPVideoPlayFullScreenView";
    this.JvU = -3;
    this.JvV = this.JvU;
    this.mCurrentOrientation = -1;
    this.Jii = new com.tencent.mm.bo.a(paramContext, (a.b)new j(this, paramContext));
    this.JvZ = new h();
    View.inflate(paramContext, 2131495698, (ViewGroup)this);
    paramAttributeSet = findViewById(2131309797);
    p.g(paramAttributeSet, "findViewById(R.id.video_play_root_layout)");
    this.JvH = paramAttributeSet;
    paramAttributeSet = findViewById(2131309795);
    p.g(paramAttributeSet, "findViewById(R.id.video_play_op_layout)");
    this.JvI = paramAttributeSet;
    paramAttributeSet = findViewById(2131309737);
    p.g(paramAttributeSet, "findViewById(R.id.video_container_layout)");
    this.JvJ = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131309801);
    p.g(paramAttributeSet, "findViewById(R.id.video_player_footer)");
    this.JvL = paramAttributeSet;
    paramAttributeSet = findViewById(2131304922);
    p.g(paramAttributeSet, "findViewById(R.id.mp_info_layout)");
    this.JvM = paramAttributeSet;
    paramAttributeSet = findViewById(2131309839);
    p.g(paramAttributeSet, "findViewById(R.id.video_touch_layout)");
    this.JvN = paramAttributeSet;
    paramAttributeSet = findViewById(2131304926);
    p.g(paramAttributeSet, "findViewById(R.id.mp_video_avatar_layout)");
    this.tFX = paramAttributeSet;
    paramAttributeSet = findViewById(2131304925);
    p.g(paramAttributeSet, "findViewById(R.id.mp_video_avatar_iv)");
    this.gyr = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131304936);
    p.g(paramAttributeSet, "findViewById(R.id.mp_video_nickname_tv)");
    this.pIN = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131304941);
    p.g(paramAttributeSet, "findViewById(R.id.mp_video_title_tv)");
    this.pIO = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131304942);
    p.g(paramAttributeSet, "findViewById(R.id.mp_video_view_article_layout)");
    this.pxG = paramAttributeSet;
    this.FLz = ((RedesignVideoPlayerSeekBar)findViewById(2131309804));
    this.JvS = findViewById(2131309282);
    this.hRO = ((ProgressBar)findViewById(2131309803));
    paramAttributeSet = this.FLz;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)this);
    }
    paramAttributeSet = this.JvL;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)1.Jwf);
    }
    paramAttributeSet = this.JvM;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)2.Jwg);
    }
    this.tFX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        Object localObject1 = null;
        AppMethodBeat.i(82585);
        Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject2).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).axR());
        if (MPVideoPlayFullScreenView.g(this.Jwh) != null)
        {
          paramAnonymousView = MPVideoPlayFullScreenView.g(this.Jwh);
          if (paramAnonymousView == null) {
            break label203;
          }
        }
        label203:
        for (paramAnonymousView = paramAnonymousView.dHc;; paramAnonymousView = null)
        {
          if (Util.isNullOrNil(paramAnonymousView)) {
            Log.w(MPVideoPlayFullScreenView.a(this.Jwh), "srcUserName is null");
          }
          localObject2 = new Intent();
          y localy = MPVideoPlayFullScreenView.g(this.Jwh);
          paramAnonymousView = localObject1;
          if (localy != null) {
            paramAnonymousView = localy.dHc;
          }
          ((Intent)localObject2).putExtra("Contact_User", paramAnonymousView);
          ((Intent)localObject2).putExtra("Contact_Scene", 163);
          ((Intent)localObject2).putExtra("force_get_contact", true);
          ((Intent)localObject2).putExtra("key_use_new_contact_profile", true);
          c.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
          com.tencent.mm.plugin.report.service.h.CyF.a(18589, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(82585);
          return;
        }
      }
    });
    o.hp(this.tFX);
    paramAttributeSet = findViewById(2131309800);
    p.g(paramAttributeSet, "findViewById(R.id.video_player_close)");
    this.pvJ = paramAttributeSet;
    this.pvJ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82586);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.Jwh.exit();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82586);
      }
    });
    paramAttributeSet = findViewById(2131309802);
    p.g(paramAttributeSet, "findViewById(R.id.video_player_more_iv)");
    this.JvO = paramAttributeSet;
    this.JvO.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82587);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = MPVideoPlayFullScreenView.g(this.Jwh);
        if (paramAnonymousView != null)
        {
          localObject = g.JwF;
          g.a(paramContext, paramAnonymousView, 4);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82587);
      }
    });
    paramAttributeSet = findViewById(2131309805);
    p.g(paramAttributeSet, "findViewById(R.id.video_player_share_iv)");
    this.JvQ = paramAttributeSet;
    this.JvQ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82588);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        paramAnonymousView = paramContext;
        if (((paramAnonymousView instanceof WebViewUI)) && (MPVideoPlayFullScreenView.g(this.Jwh) != null)) {
          if (z.gsM())
          {
            localObject1 = g.JwF;
            localObject1 = MPVideoPlayFullScreenView.g(this.Jwh);
            if (localObject1 == null) {
              p.hyc();
            }
            g.a(paramAnonymousView, (y)localObject1, 5);
            com.tencent.mm.plugin.report.service.h.CyF.a(18589, new Object[] { Integer.valueOf(16), Integer.valueOf(3) });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(82588);
          return;
          ((WebViewUI)paramAnonymousView).JjJ.iwi = MPVideoPlayFullScreenView.g(this.Jwh);
          localObject1 = d.Jwx;
          localObject1 = MPVideoPlayFullScreenView.g(this.Jwh);
          if (localObject1 == null) {
            p.hyc();
          }
          localObject1 = ((y)localObject1).iAo;
          Object localObject2 = MPVideoPlayFullScreenView.g(this.Jwh);
          if (localObject2 == null) {
            p.hyc();
          }
          localObject2 = ((y)localObject2).title;
          y localy = MPVideoPlayFullScreenView.g(this.Jwh);
          if (localy == null) {
            p.hyc();
          }
          d.a(paramAnonymousView, (String)localObject1, "", (String)localObject2, localy.KOe, 2);
          break;
          Log.w(MPVideoPlayFullScreenView.a(this.Jwh), "should not be here");
        }
      }
    });
    paramContext = findViewById(2131309844);
    p.g(paramContext, "findViewById(R.id.video_wait_play_btn)");
    this.JvP = paramContext;
    this.JvP.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82589);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        MPVideoPlayFullScreenView.C(this.Jwh);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82589);
      }
    });
    this.pxG.setVisibility(8);
    paramContext = this.FLz;
    if (paramContext != null) {
      paramContext.setPlayBtnOnClickListener((View.OnClickListener)this);
    }
    paramContext = this.FLz;
    if (paramContext != null) {
      paramContext.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new h(this));
    }
    this.EAC = 1.0F;
    this.Jwc = new MTimerHandler((MTimerHandler.CallBack)new g(this), true);
    this.Jwd = 4000L;
    AppMethodBeat.o(82641);
  }
  
  private final int getSubScene$1385f2()
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
        localObject1 = ((com.tencent.mm.plugin.webview.core.b)localObject3).coX();
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
  
  private final void ghH()
  {
    AppMethodBeat.i(82626);
    if (this.qaE == null) {
      this.qaE = new com.tencent.mm.ui.tools.e(getContext());
    }
    if (this.iwi == null)
    {
      this.Jwa = true;
      AppMethodBeat.o(82626);
      return;
    }
    this.Jwa = false;
    Object localObject = this.iwi;
    if (localObject == null) {
      p.hyc();
    }
    int i = ((y)localObject).iAL;
    localObject = this.iwi;
    if (localObject == null) {
      p.hyc();
    }
    int j = ((y)localObject).iAM;
    localObject = this.iwi;
    if (localObject == null) {
      p.hyc();
    }
    int k = ((y)localObject).iAN;
    localObject = this.iwi;
    if (localObject == null) {
      p.hyc();
    }
    int m = ((y)localObject).iAO;
    localObject = this.qaE;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.e)localObject).Q(i, j, k, m);
    }
    localObject = this.qaE;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.e)localObject).gXF();
    }
    localObject = this.qaE;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.e)localObject).lu(0, 0);
    }
    ghI();
    AppMethodBeat.o(82626);
  }
  
  private final void ghI()
  {
    AppMethodBeat.i(82627);
    Object localObject = this.JvK;
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
  
  private final void ghJ()
  {
    AppMethodBeat.i(82631);
    if (this.gVd)
    {
      localu = this.JvR;
      if (localu != null)
      {
        localu.fDd();
        AppMethodBeat.o(82631);
        return;
      }
      AppMethodBeat.o(82631);
      return;
    }
    u localu = this.JvR;
    if (localu != null)
    {
      localu.hsz();
      AppMethodBeat.o(82631);
      return;
    }
    AppMethodBeat.o(82631);
  }
  
  private final void ghK()
  {
    try
    {
      AppMethodBeat.i(210558);
      Object localObject1 = getContext();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(210558);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    Activity localActivity = (Activity)localObject2;
    if (this.iwi == null)
    {
      Log.d(this.TAG, "adjustOrientation mpShareVideoInfo is null");
      AppMethodBeat.o(210558);
    }
    for (;;)
    {
      return;
      if ((!this.JvX) && (this.JvY)) {
        break;
      }
      Log.i(this.TAG, "adjustOrientation hasAdjustOrientation=" + this.JvX + ", hasAddVideoView=" + this.JvY);
      AppMethodBeat.o(210558);
    }
    this.JvX = true;
    if (this.JvV == this.JvU) {
      this.JvV = localActivity.getRequestedOrientation();
    }
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("adjustOrientation width = ");
    y localy = this.iwi;
    if (localy == null) {
      p.hyc();
    }
    localStringBuilder = localStringBuilder.append(localy.width).append(", height=");
    localy = this.iwi;
    if (localy == null) {
      p.hyc();
    }
    Log.i((String)localObject3, localy.height);
    localObject3 = this.iwi;
    if (localObject3 == null) {
      p.hyc();
    }
    int i = ((y)localObject3).width;
    localObject3 = this.iwi;
    if (localObject3 == null) {
      p.hyc();
    }
    if (i <= ((y)localObject3).height)
    {
      this.mCurrentOrientation = 1;
      localActivity.setRequestedOrientation(this.mCurrentOrientation);
      this.JvW = false;
    }
    for (;;)
    {
      ghR();
      AppMethodBeat.o(210558);
      break;
      this.JvW = true;
      this.mCurrentOrientation = 0;
      localActivity.setRequestedOrientation(this.mCurrentOrientation);
      this.Jii.enable();
    }
  }
  
  private final void ghN()
  {
    boolean bool = true;
    AppMethodBeat.i(82635);
    Object localObject = this.TAG;
    if (this.JvI.getVisibility() == 0) {}
    for (;;)
    {
      Log.d((String)localObject, "fadeOutOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = ghO();
      ((Animation)localObject).setFillAfter(false);
      ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this));
      this.JvI.clearAnimation();
      this.JvI.startAnimation((Animation)localObject);
      AppMethodBeat.o(82635);
      return;
      bool = false;
    }
  }
  
  private static Animation ghO()
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
  
  private final void ghP()
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
    p.g(localObject, "(context as Activity).window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "(context as Activity).window.decorView");
    ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new e(this, (View)localObject));
    AppMethodBeat.o(82638);
  }
  
  private final void ghQ()
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
    p.g(localObject, "(context as Activity).window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "(context as Activity).window.decorView");
    ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new d(this, (View)localObject));
    AppMethodBeat.o(82639);
  }
  
  private final void ghR()
  {
    AppMethodBeat.i(182654);
    if ((this.mCurrentOrientation == 0) || (this.mCurrentOrientation == 8))
    {
      ghQ();
      AppMethodBeat.o(182654);
      return;
    }
    ghP();
    AppMethodBeat.o(182654);
  }
  
  private void removeVideoView()
  {
    AppMethodBeat.i(82632);
    this.JvJ.removeAllViews();
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
  
  private final void zq(boolean paramBoolean)
  {
    AppMethodBeat.i(182653);
    Log.i(this.TAG, "handleFullScreenStatusBar forwardUiVisibility " + this.pNM);
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
      p.g(localObject2, "activity.window");
      localObject2 = ((Window)localObject2).getDecorView();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(182653);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup)localObject2;
      this.pNM = ((ViewGroup)localObject2).getSystemUiVisibility();
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
    p.g(localObject2, "activity.window");
    localObject2 = ((Window)localObject2).getDecorView();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(182653);
      throw ((Throwable)localObject1);
    }
    ((ViewGroup)localObject2).setSystemUiVisibility(this.pNM);
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
        AppMethodBeat.i(210555);
        p.h(paramy, "mpShareVideoInfo");
        this.iwi = paramy;
        this.iAS = paramy.iAS;
        paramy = this.pIO.getPaint();
        p.g(paramy, "titleTv.paint");
        paramy.setFakeBoldText(true);
        paramy = this.pIN.getPaint();
        p.g(paramy, "nicknameTv.paint");
        paramy.setFakeBoldText(true);
        localObject = this.pIO;
        paramy = this.iwi;
        if (paramy != null)
        {
          paramy = paramy.title;
          ((MMNeat7extView)localObject).aw((CharSequence)paramy);
          localObject = this.pIN;
          Context localContext = getContext();
          paramy = this.iwi;
          if (paramy != null)
          {
            paramy = paramy.iAg;
            ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(localContext, (CharSequence)paramy, this.pIN.getTextSize()));
            if (!this.iAS) {
              continue;
            }
            this.JvO.setVisibility(8);
            this.JvQ.setVisibility(8);
            localObject = getContext();
            if ((localObject instanceof WebViewUI))
            {
              paramy = this.iwi;
              if (paramy == null) {
                break label311;
              }
              paramy = paramy.iAR;
              if (Util.isNullOrNil(paramy)) {
                break label321;
              }
              paramy = this.iwi;
              if (paramy == null) {
                break label316;
              }
              paramy = paramy.iAR;
              com.tencent.mm.av.a.a.bdb().a(paramy, this.gyr, new c.a().bdt().ty(2131231405).bdv());
            }
            if (this.Jwa) {
              ghH();
            }
            Log.d(this.TAG, "initData");
            ghK();
            AppMethodBeat.o(210555);
          }
        }
        else
        {
          paramy = null;
          continue;
        }
        paramy = null;
        continue;
        this.JvO.setVisibility(0);
        this.JvQ.setVisibility(0);
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
      paramy = ((WebViewUI)localObject).gff();
      if (paramy != null)
      {
        paramy = paramy.Abp;
        if (paramy != null)
        {
          paramy = paramy.erh();
          if (paramy != null)
          {
            paramy = paramy.MwR;
            continue;
          }
        }
      }
      paramy = null;
    }
  }
  
  public final boolean bJb()
  {
    AppMethodBeat.i(210557);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(210557);
      return true;
    }
    AppMethodBeat.o(210557);
    return false;
  }
  
  public final void exit()
  {
    AppMethodBeat.i(82628);
    Context localContext = getContext();
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).gfW() != null))
    {
      if (((WebViewUI)localContext).gfW() != null)
      {
        Log.i(this.TAG, "close click");
        ghL();
        ((WebViewUI)localContext).gfW().leaveFullscreen();
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
    return this.pHu;
  }
  
  public final long getEnterTimeInMs()
  {
    return this.pLN;
  }
  
  public final boolean getForbidForward()
  {
    return this.iAS;
  }
  
  public final h getMpShareVideoReport()
  {
    return this.JvZ;
  }
  
  public final Integer getSubScene()
  {
    return this.Jwb;
  }
  
  public final void gg(View paramView)
  {
    try
    {
      AppMethodBeat.i(210556);
      p.h(paramView, "view");
      if (this.iwi == null) {
        break label209;
      }
      localObject1 = this.iwi;
      if (localObject1 == null) {
        p.hyc();
      }
      ((y)localObject1).iAP = this.pHu;
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        AppMethodBeat.o(210556);
        throw paramView;
      }
    }
    finally {}
    Object localObject2 = (WebViewUI)localObject1;
    Object localObject1 = ((WebViewUI)localObject2).mHh;
    if (localObject1 != null) {}
    try
    {
      localObject1 = this.JvZ;
      localObject2 = ((WebViewUI)localObject2).mHh;
      y localy = this.iwi;
      if (localy == null) {
        p.hyc();
      }
      ((h)localObject1).pLE = ((com.tencent.mm.plugin.webview.stub.e)localObject2).IS(localy.dHc);
      this.JvZ.scene = 141;
      this.JvZ.pHw = getSubScene$1385f2();
    }
    catch (Exception localException)
    {
      label149:
      break label149;
    }
    this.pLN = System.currentTimeMillis();
    this.pHu = ((int)(this.pLN / 1000L));
    this.JvZ.a(this.iwi, 1, this.pHu);
    this.JvZ.a(this.iwi, 5, this.pHu);
    this.JvZ.jpW = 0;
    label209:
    removeVideoView();
    zq(true);
    this.JvH.setAlpha(1.0F);
    this.JvH.setBackgroundColor(-16777216);
    setVisibility(0);
    localObject1 = new FrameLayout(getContext());
    ((FrameLayout)localObject1).addView(paramView, new ViewGroup.LayoutParams(-1, -2));
    this.JvK = ((ViewGroup)localObject1);
    paramView = this.JvJ;
    localObject1 = (View)this.JvK;
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    ghH();
    this.FLK = false;
    Log.d(this.TAG, "addVideoView");
    this.JvY = true;
    ghK();
    AppMethodBeat.o(210556);
  }
  
  @SuppressLint({"WrongConstant"})
  public final void ghL()
  {
    AppMethodBeat.i(182652);
    if (this.JvV != this.JvU)
    {
      Object localObject = getContext();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(182652);
        throw ((Throwable)localObject);
      }
      ((Activity)localObject).setRequestedOrientation(this.JvV);
      this.JvV = this.JvU;
      this.Jii.disable();
    }
    zq(false);
    AppMethodBeat.o(182652);
  }
  
  public final void ghM()
  {
    AppMethodBeat.i(82634);
    if (BuildInfo.IS_FLAVOR_RED) {
      Log.d(this.TAG, "hideOpLayer %s", new Object[] { Util.getStack() });
    }
    if (!this.Jwe)
    {
      AppMethodBeat.o(82634);
      return;
    }
    this.Jwe = false;
    ghN();
    AppMethodBeat.o(82634);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(82630);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((paramView != null) && (paramView.getId() == 2131305954)) {
      ghJ();
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
      Log.d(this.TAG, "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      ghP();
      AppMethodBeat.o(82637);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      Log.d(this.TAG, "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
      ghQ();
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
    this.JvX = false;
    this.JvY = false;
    if (this.iwi != null)
    {
      this.JvZ.pLC = ((int)(System.currentTimeMillis() - this.pLN));
      this.JvZ.pLB = ((int)(this.JvT * 1000.0D));
      this.JvZ.a(this.iwi, 6, this.pHu);
      this.JvZ.a(this.iwi, 2, this.pHu);
      Object localObject = getContext();
      if (((localObject instanceof WebViewUI)) && (((WebViewUI)localObject).IBw != null))
      {
        localObject = ((WebViewUI)localObject).IBw;
        y localy = this.iwi;
        if (localy == null) {
          p.hyc();
        }
        ((com.tencent.mm.plugin.webview.d.h)localObject).gh(localy.KOf, (int)this.JvT);
      }
      this.iwi = null;
    }
    AppMethodBeat.o(82629);
  }
  
  public final void setEnterId(int paramInt)
  {
    this.pHu = paramInt;
  }
  
  public final void setEnterTimeInMs(long paramLong)
  {
    this.pLN = paramLong;
  }
  
  public final void setForbidForward(boolean paramBoolean)
  {
    this.iAS = paramBoolean;
  }
  
  public final void setSubScene(Integer paramInteger)
  {
    this.Jwb = paramInteger;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82590);
      this.Jwh.onExit();
      AppMethodBeat.o(82590);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$fadeOutOpLayout$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(82592);
      p.h(paramAnimation, "animation");
      if (!MPVideoPlayFullScreenView.r(this.Jwh)) {
        MPVideoPlayFullScreenView.s(this.Jwh);
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "visibility", "", "onSystemUiVisibilityChange"})
  static final class c
    implements View.OnSystemUiVisibilityChangeListener
  {
    c(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, ViewGroup paramViewGroup) {}
    
    public final void onSystemUiVisibilityChange(int paramInt)
    {
      AppMethodBeat.i(210554);
      if (((paramInt & 0x4) == 0) && (this.Jwh.bJb())) {
        this.Jwi.setSystemUiVisibility(5894);
      }
      AppMethodBeat.o(210554);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$handleHorizontalUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class d
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    d(View paramView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82594);
      this.Jwj.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      if (com.tencent.mm.compatible.util.d.oD(24))
      {
        localObject1 = this.Jwh.getContext();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(82594);
          throw ((Throwable)localObject1);
        }
        if (((Activity)localObject1).isInMultiWindowMode())
        {
          MPVideoPlayFullScreenView.t(this.Jwh);
          AppMethodBeat.o(82594);
          return;
        }
      }
      int n = au.aD(this.Jwh.getContext());
      int i = com.tencent.mm.cb.a.aH(this.Jwh.getContext(), 2131165314);
      int j = i * 3;
      int k = i * 4;
      int m = i * 7;
      n = Math.max(n - i * 3, 0);
      MPVideoPlayFullScreenView.u(this.Jwh).setPadding(n, i * 2, n - i, i * 2);
      Object localObject1 = MPVideoPlayFullScreenView.v(this.Jwh);
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
        ((RelativeLayout.LayoutParams)localObject2).height = com.tencent.mm.cb.a.aG(this.Jwh.getContext(), 2131165283);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject1 = MPVideoPlayFullScreenView.w(this.Jwh).getLayoutParams();
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
      MPVideoPlayFullScreenView.w(this.Jwh).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = MPVideoPlayFullScreenView.x(this.Jwh).getLayoutParams();
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
      MPVideoPlayFullScreenView.x(this.Jwh).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = MPVideoPlayFullScreenView.y(this.Jwh).getLayoutParams();
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
      MPVideoPlayFullScreenView.y(this.Jwh).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = MPVideoPlayFullScreenView.m(this.Jwh);
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((RedesignVideoPlayerSeekBar)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131309800);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131309805);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(m, j, m, j);
      Object localObject2 = MPVideoPlayFullScreenView.m(this.Jwh);
      if (localObject2 != null)
      {
        ((RedesignVideoPlayerSeekBar)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(82594);
        return;
      }
      AppMethodBeat.o(82594);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$handleVerticalUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class e
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    e(View paramView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82595);
      this.Jwj.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      MPVideoPlayFullScreenView.t(this.Jwh);
      AppMethodBeat.o(82595);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82596);
      ProgressBar localProgressBar = MPVideoPlayFullScreenView.l(this.Jwh);
      if ((localProgressBar != null) && (localProgressBar.getVisibility() == 0))
      {
        localProgressBar = MPVideoPlayFullScreenView.l(this.Jwh);
        if (localProgressBar != null) {
          localProgressBar.setVisibility(8);
        }
      }
      if (!MPVideoPlayFullScreenView.n(this.Jwh)) {
        MPVideoPlayFullScreenView.k(this.Jwh).setVisibility(0);
      }
      AppMethodBeat.o(82596);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class g
    implements MTimerHandler.CallBack
  {
    g(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(82597);
      MPVideoPlayFullScreenView.i(this.Jwh);
      AppMethodBeat.o(82597);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$initSeekBar$1", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-webview_release"})
  public static final class h
    implements com.tencent.mm.plugin.sight.decode.ui.b
  {
    public final void aJq() {}
    
    public final void rk(int paramInt)
    {
      AppMethodBeat.i(82598);
      Log.i(MPVideoPlayFullScreenView.a(this.Jwh), "initSeekBar onSeekTo ".concat(String.valueOf(paramInt)));
      u localu = MPVideoPlayFullScreenView.o(this.Jwh);
      if (localu != null)
      {
        localu.F(paramInt);
        AppMethodBeat.o(82598);
        return;
      }
      AppMethodBeat.o(82598);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$initVideoController$1", "Lcom/tencent/xweb/VideoJsCallback;", "lastUpdateTime", "", "getLastUpdateTime", "()J", "setLastUpdateTime", "(J)V", "onSetRequestedOrientation", "", "orientation", "", "onVideoEmptied", "", "onVideoEnded", "onVideoEnterFullscreen", "isVideoTag", "id", "width", "", "height", "paused", "seeking", "currentTime", "duration", "buffered", "", "onVideoError", "error", "msg", "", "onVideoExitFullscreen", "onVideoPause", "onVideoPlay", "onVideoPlaying", "onVideoSeeked", "onVideoSeeking", "onVideoSizeUpdate", "onVideoTimeUpdate", "onVideoWaiting", "plugin-webview_release"})
  public static final class i
    implements v
  {
    private long lastUpdateTime;
    
    public final void bLx()
    {
      AppMethodBeat.i(82602);
      Log.i(MPVideoPlayFullScreenView.a(this.Jwh), "onVideoEmptied");
      MPVideoPlayFullScreenView.p(this.Jwh);
      AppMethodBeat.o(82602);
    }
    
    public final void onVideoEnded()
    {
      AppMethodBeat.i(82600);
      Log.i(MPVideoPlayFullScreenView.a(this.Jwh), "onVideoEnded");
      MPVideoPlayFullScreenView.c(this.Jwh, false);
      MPVideoPlayFullScreenView.p(this.Jwh);
      this.Jwh.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.Jwh), 7, this.Jwh.getEnterId());
      this.Jwh.getMpShareVideoReport().jpW = 4;
      AppMethodBeat.o(82600);
    }
    
    public final void onVideoEnterFullscreen(boolean paramBoolean1, long paramLong, double paramDouble1, double paramDouble2, boolean paramBoolean2, boolean paramBoolean3, double paramDouble3, double paramDouble4, double[] paramArrayOfDouble)
    {
      AppMethodBeat.i(82609);
      Log.i(MPVideoPlayFullScreenView.a(this.Jwh), "onVideoEnterFullscreen isVideoTag:" + paramBoolean1 + ", id:" + paramLong + ", width:" + paramDouble1 + ", height:" + paramDouble2 + ", paused:" + paramBoolean2 + ", seeking:" + paramBoolean3 + ", currentTime:" + paramDouble3 + ", duration:" + paramDouble4 + ", buffered:" + Arrays.toString(paramArrayOfDouble));
      paramArrayOfDouble = this.Jwh;
      if (!paramBoolean2) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        MPVideoPlayFullScreenView.b(paramArrayOfDouble, paramBoolean1);
        MPVideoPlayFullScreenView.c(this.Jwh, MPVideoPlayFullScreenView.n(this.Jwh));
        if (MPVideoPlayFullScreenView.n(this.Jwh))
        {
          this.Jwh.getMpShareVideoReport().jpW = 1;
          this.Jwh.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.Jwh), this.Jwh.getMpShareVideoReport().getPlayType(), this.Jwh.getEnterId());
        }
        AppMethodBeat.o(82609);
        return;
      }
    }
    
    public final void onVideoError(int paramInt, String paramString)
    {
      AppMethodBeat.i(82601);
      Log.e(MPVideoPlayFullScreenView.a(this.Jwh), "onVideoError " + paramInt + ", " + paramString);
      MPVideoPlayFullScreenView.c(this.Jwh, false);
      MPVideoPlayFullScreenView.p(this.Jwh);
      this.Jwh.getMpShareVideoReport().jpW = 4;
      this.Jwh.getMpShareVideoReport().pLD = paramString;
      this.Jwh.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.Jwh), 11, this.Jwh.getEnterId());
      AppMethodBeat.o(82601);
    }
    
    public final void onVideoExitFullscreen()
    {
      AppMethodBeat.i(82610);
      Log.i(MPVideoPlayFullScreenView.a(this.Jwh), "onVideoExitFullscreen");
      AppMethodBeat.o(82610);
    }
    
    public final void onVideoPause()
    {
      AppMethodBeat.i(82608);
      Log.i(MPVideoPlayFullScreenView.a(this.Jwh), "onVideoPause");
      MPVideoPlayFullScreenView.c(this.Jwh, false);
      MPVideoPlayFullScreenView.p(this.Jwh);
      if (this.Jwh.getMpShareVideoReport().jpW != 3) {
        this.Jwh.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.Jwh), 8, this.Jwh.getEnterId());
      }
      this.Jwh.getMpShareVideoReport().jpW = 3;
      AppMethodBeat.o(82608);
    }
    
    public final void onVideoPlay()
    {
      AppMethodBeat.i(82607);
      Log.i(MPVideoPlayFullScreenView.a(this.Jwh), "onVideoPlay");
      MPVideoPlayFullScreenView.c(this.Jwh, true);
      MPVideoPlayFullScreenView.p(this.Jwh);
      if (this.Jwh.getMpShareVideoReport().jpW != 2) {
        this.Jwh.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.Jwh), this.Jwh.getMpShareVideoReport().getPlayType(), this.Jwh.getEnterId());
      }
      this.Jwh.getMpShareVideoReport().jpW = 2;
      AppMethodBeat.o(82607);
    }
    
    public final void onVideoPlaying()
    {
      AppMethodBeat.i(82603);
      Log.d(MPVideoPlayFullScreenView.a(this.Jwh), "onVideoPlaying");
      if (!MPVideoPlayFullScreenView.n(this.Jwh))
      {
        MPVideoPlayFullScreenView.c(this.Jwh, true);
        MPVideoPlayFullScreenView.p(this.Jwh);
      }
      this.Jwh.getMpShareVideoReport().jpW = 2;
      AppMethodBeat.o(82603);
    }
    
    public final void onVideoSeeked()
    {
      AppMethodBeat.i(82606);
      Log.i(MPVideoPlayFullScreenView.a(this.Jwh), "onVideoSeeked");
      MPVideoPlayFullScreenView.p(this.Jwh);
      this.Jwh.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.Jwh), 13, this.Jwh.getEnterId());
      AppMethodBeat.o(82606);
    }
    
    public final void onVideoSeeking()
    {
      AppMethodBeat.i(82605);
      Log.i(MPVideoPlayFullScreenView.a(this.Jwh), "onVideoSeeking");
      MPVideoPlayFullScreenView.q(this.Jwh);
      AppMethodBeat.o(82605);
    }
    
    public final void onVideoSizeUpdate(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(82612);
      y localy = MPVideoPlayFullScreenView.g(this.Jwh);
      if ((localy == null) || (localy.width != 0))
      {
        localy = MPVideoPlayFullScreenView.g(this.Jwh);
        if (localy != null) {
          if (localy.height != 0) {
            break label103;
          }
        }
      }
      else
      {
        localy = MPVideoPlayFullScreenView.g(this.Jwh);
        if (localy != null) {
          localy.width = ((int)paramDouble1);
        }
        localy = MPVideoPlayFullScreenView.g(this.Jwh);
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
      MPVideoPlayFullScreenView.a(this.Jwh, paramDouble1);
      MPVideoPlayFullScreenView.p(this.Jwh);
      AppMethodBeat.o(82611);
    }
    
    public final void onVideoWaiting()
    {
      AppMethodBeat.i(82604);
      Log.i(MPVideoPlayFullScreenView.a(this.Jwh), "onVideoWaiting");
      MPVideoPlayFullScreenView.q(this.Jwh);
      AppMethodBeat.o(82604);
    }
    
    public final boolean xJ(int paramInt)
    {
      return false;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoPlayFullScreenView.i parami, double paramDouble1, double paramDouble2, double[] paramArrayOfDouble) {}
      
      public final void run()
      {
        int j = 1;
        AppMethodBeat.i(82599);
        Object localObject = MPVideoPlayFullScreenView.m(this.Jwk.Jwh);
        if (localObject != null) {
          ((RedesignVideoPlayerSeekBar)localObject).setVideoTotalTime((int)paramDouble2);
        }
        localObject = MPVideoPlayFullScreenView.m(this.Jwk.Jwh);
        if (localObject != null) {
          ((RedesignVideoPlayerSeekBar)localObject).xv((int)paramArrayOfDouble);
        }
        localObject = this.Jwn;
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
            RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = MPVideoPlayFullScreenView.m(this.Jwk.Jwh);
            if (localRedesignVideoPlayerSeekBar == null) {
              break label133;
            }
            p.h(localObject, "$this$lastIndex");
            localRedesignVideoPlayerSeekBar.aiS((int)localObject[(localObject.length - 1)]);
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class j
    implements a.b
  {
    j(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, Context paramContext) {}
    
    public final void a(a.a parama1, a.a parama2)
    {
      AppMethodBeat.i(182651);
      if (MPVideoPlayFullScreenView.z(this.Jwh))
      {
        parama1 = this.Jwh;
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
        ((Activity)parama1).setRequestedOrientation(MPVideoPlayFullScreenView.A(this.Jwh));
        MPVideoPlayFullScreenView.B(this.Jwh);
      }
      AppMethodBeat.o(182651);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onExit"})
  static final class k
    implements e.b
  {
    k(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void onExit()
    {
      AppMethodBeat.i(82613);
      this.Jwh.exit();
      AppMethodBeat.o(82613);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "longClickOver"})
  static final class l
    implements e.d
  {
    l(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void bmu()
    {
      AppMethodBeat.i(82614);
      if (!this.Jwh.getForbidForward())
      {
        y localy = MPVideoPlayFullScreenView.g(this.Jwh);
        if (localy != null)
        {
          Object localObject = g.JwF;
          localObject = this.Jwh.getContext();
          p.g(localObject, "context");
          g.a((Context)localObject, localy, 3);
          AppMethodBeat.o(82614);
          return;
        }
      }
      AppMethodBeat.o(82614);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onClick"})
  static final class m
    implements e.f
  {
    m(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(82615);
      if (MPVideoPlayFullScreenView.h(this.Jwh).getVisibility() == 0)
      {
        MPVideoPlayFullScreenView.i(this.Jwh);
        AppMethodBeat.o(82615);
        return;
      }
      MPVideoPlayFullScreenView.f(this.Jwh);
      AppMethodBeat.o(82615);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "tx", "", "ty", "onGalleryScale"})
  static final class n
    implements e.e
  {
    n(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void S(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(82616);
      if ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F))
      {
        MPVideoPlayFullScreenView.f(this.Jwh);
        AppMethodBeat.o(82616);
        return;
      }
      if ((Math.abs(paramFloat1) > 10.0F) || (Math.abs(paramFloat2) > 10.0F)) {
        MPVideoPlayFullScreenView.i(this.Jwh);
      }
      AppMethodBeat.o(82616);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    public static final o Jwo;
    
    static
    {
      AppMethodBeat.i(82618);
      Jwo = new o();
      AppMethodBeat.o(82618);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(82617);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runDragAnimation$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runDragAnimation$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(82617);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runEnterAnimation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class p
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82620);
      Log.d(MPVideoPlayFullScreenView.a(this.Jwh), "runEnterAnimation");
      Object localObject = MPVideoPlayFullScreenView.b(this.Jwh);
      if (localObject != null)
      {
        localObject = ((ViewGroup)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      localObject = MPVideoPlayFullScreenView.b(this.Jwh);
      if (localObject != null) {}
      for (localObject = Integer.valueOf(((ViewGroup)localObject).getHeight());; localObject = null)
      {
        if (localObject == null) {
          p.hyc();
        }
        if (((Integer)localObject).intValue() > 0) {
          break;
        }
        MPVideoPlayFullScreenView.c(this.Jwh);
        AppMethodBeat.o(82620);
        return;
      }
      MPVideoPlayFullScreenView.d(this.Jwh);
      localObject = MPVideoPlayFullScreenView.e(this.Jwh);
      if (localObject != null)
      {
        ViewGroup localViewGroup = MPVideoPlayFullScreenView.b(this.Jwh);
        if (localViewGroup == null) {
          p.hyc();
        }
        ((com.tencent.mm.ui.tools.e)localObject).a((View)localViewGroup, null, (e.c)new a(this));
        AppMethodBeat.o(82620);
        return;
      }
      AppMethodBeat.o(82620);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runEnterAnimation$1$onGlobalLayout$1", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-webview_release"})
    public static final class a
      implements e.c
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(82619);
        MPVideoPlayFullScreenView.f(this.Jwp.Jwh);
        AppMethodBeat.o(82619);
      }
      
      public final void onAnimationStart() {}
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runExitAnimation$2", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-webview_release"})
  public static final class q
    implements e.c
  {
    public q(e.c paramc) {}
    
    public final void onAnimationEnd()
    {
      AppMethodBeat.i(82623);
      e.c localc = this.Jwq;
      if (localc != null) {
        localc.onAnimationEnd();
      }
      MPVideoPlayFullScreenView.j(this.Jwh).post((Runnable)new a(this));
      MPVideoPlayFullScreenView.a(this.Jwh, false);
      this.Jwh.onExit();
      AppMethodBeat.o(82623);
    }
    
    public final void onAnimationStart()
    {
      AppMethodBeat.i(82622);
      MPVideoPlayFullScreenView.a(this.Jwh, true);
      e.c localc = this.Jwq;
      if (localc != null)
      {
        localc.onAnimationStart();
        AppMethodBeat.o(82622);
        return;
      }
      AppMethodBeat.o(82622);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoPlayFullScreenView.q paramq) {}
      
      public final void run()
      {
        AppMethodBeat.i(82621);
        Object localObject = this.Jws.Jwh.getContext();
        if (((localObject instanceof WebViewUI)) && (((WebViewUI)localObject).gfW() != null))
        {
          localObject = this.Jws.Jwh.getContext();
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
            AppMethodBeat.o(82621);
            throw ((Throwable)localObject);
          }
          ((WebViewUI)localObject).gfW().leaveFullscreen();
        }
        MPVideoPlayFullScreenView.j(this.Jws.Jwh).setLayoutParams(this.Jws.Jwr);
        AppMethodBeat.o(82621);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82624);
      ProgressBar localProgressBar = MPVideoPlayFullScreenView.l(this.Jwh);
      if ((localProgressBar == null) || (localProgressBar.getVisibility() != 0))
      {
        localProgressBar = MPVideoPlayFullScreenView.l(this.Jwh);
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(82625);
      if (this.Jwt) {
        MPVideoPlayFullScreenView.k(this.Jwh).setVisibility(8);
      }
      for (;;)
      {
        Object localObject = MPVideoPlayFullScreenView.m(this.Jwh);
        if (localObject == null) {
          break;
        }
        ((RedesignVideoPlayerSeekBar)localObject).hP(MPVideoPlayFullScreenView.n(this.Jwh));
        AppMethodBeat.o(82625);
        return;
        localObject = MPVideoPlayFullScreenView.l(this.Jwh);
        if ((localObject == null) || (((ProgressBar)localObject).getVisibility() != 0)) {
          MPVideoPlayFullScreenView.k(this.Jwh).setVisibility(0);
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