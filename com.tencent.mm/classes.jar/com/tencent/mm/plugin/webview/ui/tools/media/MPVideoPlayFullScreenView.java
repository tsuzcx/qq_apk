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
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.ar;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ENTER_HIDE_MIL_SEC", "", "INVALID_ORIENTATION", "", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/view/View;", "centerPlayIv", "closeIv", "currentPlayTime", "", "enterId", "getEnterId", "()I", "setEnterId", "(I)V", "enterTimeInMs", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "footerLayout", "forbidForward", "", "getForbidForward", "()Z", "setForbidForward", "(Z)V", "forwardUiVisibility", "hasAddVideoView", "hasAdjustOrientation", "hideToolBarTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "imagePreviewAnimation", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;", "isLandScapeVideo", "isPlaying", "isRunningExitAnimation", "loadingBar", "Landroid/widget/ProgressBar;", "mCurrentOrientation", "mIsShowOpLayout", "mPreOrientation", "moreIv", "moreLayout", "mpInfoLayout", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "mpShareVideoReport", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "getMpShareVideoReport", "()Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "needDoAnimation", "nicknameTv", "Landroid/widget/TextView;", "orientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "preDeltaX", "preDeltaY", "preScale", "", "shareIv", "subScene", "getSubScene", "()Ljava/lang/Integer;", "setSubScene", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "touchLayout", "videoContainerLayout", "Landroid/view/ViewGroup;", "videoControl", "Lcom/tencent/xweb/VideoControl;", "videoPlayOpLayout", "videoPlayRootLayout", "videoPlayerSeekBar", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "videoRootLayout", "addVideoView", "", "view", "adjustOrientation", "exit", "fadeInAnimation", "Landroid/view/animation/Animation;", "fadeInOpLayout", "fadeOutAnimation", "duration", "fadeOutOpLayout", "force", "handleAnimation", "handleFullScreenStatusBar", "fullScreen", "handleHorizontalUI", "handleScreenSize", "handleVerticalUI", "hideLoading", "hideToolBar", "initData", "initReportData", "initSeekBar", "initVideoController", "initView", "loadAvatar", "onClick", "v", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onExit", "onExitMpVideoFullPage", "onResume", "opPlay", "postHandleVerticalUI", "removeVideoView", "resetOrientation", "runDragAnimation", "runEnterAnimation", "runExitAnimation", "bm", "Landroid/graphics/Bitmap;", "callback", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "showLoading", "showToolBar", "starHideToolBar", "startHideToolBarTimer", "stopHideToolBarTimer", "supportFullScreen", "updatePlayBtn", "playing", "plugin-webview_release"})
public final class MPVideoPlayFullScreenView
  extends RelativeLayout
  implements View.OnClickListener
{
  public float Aal;
  public int Aam;
  public int Aan;
  private RedesignVideoPlayerSeekBar Bjp;
  public boolean Bjz;
  private com.tencent.mm.bp.a EcN;
  public View Eoa;
  private View Eob;
  private ViewGroup Eoc;
  public ViewGroup Eod;
  private View Eoe;
  private View Eof;
  private View Eog;
  private View Eoh;
  private View Eoi;
  private View Eoj;
  public u Eok;
  private double Eol;
  private final int Eom;
  private int Eon;
  private boolean Eoo;
  private boolean Eop;
  private boolean Eoq;
  private final h Eor;
  private boolean Eos;
  private Integer Eot;
  private av Eou;
  private final long Eov;
  private boolean Eow;
  public final String TAG;
  private ImageView fRd;
  private ProgressBar gWg;
  private boolean hDR;
  public y hzo;
  private boolean lQV;
  private int mCurrentOrientation;
  public com.tencent.mm.ui.tools.e oGo;
  private View odX;
  private View ofo;
  private int oog;
  private TextView opA;
  private MMNeat7extView opB;
  private long orN;
  private int otA;
  private View rPF;
  
  public MPVideoPlayFullScreenView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82641);
    this.TAG = "MicroMsg.MPVideoPlayFullScreenView";
    this.Eom = -3;
    this.Eon = this.Eom;
    this.mCurrentOrientation = -1;
    this.EcN = new com.tencent.mm.bp.a(paramContext, (a.b)new i(this, paramContext));
    this.Eor = new h();
    View.inflate(paramContext, 2131494955, (ViewGroup)this);
    paramAttributeSet = findViewById(2131306368);
    p.g(paramAttributeSet, "findViewById(R.id.video_play_root_layout)");
    this.Eoa = paramAttributeSet;
    paramAttributeSet = findViewById(2131306366);
    p.g(paramAttributeSet, "findViewById(R.id.video_play_op_layout)");
    this.Eob = paramAttributeSet;
    paramAttributeSet = findViewById(2131306318);
    p.g(paramAttributeSet, "findViewById(R.id.video_container_layout)");
    this.Eoc = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131306372);
    p.g(paramAttributeSet, "findViewById(R.id.video_player_footer)");
    this.Eoe = paramAttributeSet;
    paramAttributeSet = findViewById(2131302495);
    p.g(paramAttributeSet, "findViewById(R.id.mp_info_layout)");
    this.Eof = paramAttributeSet;
    paramAttributeSet = findViewById(2131306408);
    p.g(paramAttributeSet, "findViewById(R.id.video_touch_layout)");
    this.Eog = paramAttributeSet;
    paramAttributeSet = findViewById(2131302498);
    p.g(paramAttributeSet, "findViewById(R.id.mp_video_avatar_layout)");
    this.rPF = paramAttributeSet;
    paramAttributeSet = findViewById(2131302497);
    p.g(paramAttributeSet, "findViewById(R.id.mp_video_avatar_iv)");
    this.fRd = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131302508);
    p.g(paramAttributeSet, "findViewById(R.id.mp_video_nickname_tv)");
    this.opA = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131302513);
    p.g(paramAttributeSet, "findViewById(R.id.mp_video_title_tv)");
    this.opB = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131302514);
    p.g(paramAttributeSet, "findViewById(R.id.mp_video_view_article_layout)");
    this.ofo = paramAttributeSet;
    this.Bjp = ((RedesignVideoPlayerSeekBar)findViewById(2131306375));
    this.gWg = ((ProgressBar)findViewById(2131306374));
    paramAttributeSet = this.Bjp;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)this);
    }
    paramAttributeSet = this.Eoe;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)1.Eox);
    }
    paramAttributeSet = this.Eof;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)2.Eoy);
    }
    this.rPF.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        Object localObject1 = null;
        AppMethodBeat.i(82585);
        Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject2).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).ahq());
        if (MPVideoPlayFullScreenView.g(this.Eoz) != null)
        {
          paramAnonymousView = MPVideoPlayFullScreenView.g(this.Eoz);
          if (paramAnonymousView == null) {
            break label203;
          }
        }
        label203:
        for (paramAnonymousView = paramAnonymousView.doK;; paramAnonymousView = null)
        {
          if (bt.isNullOrNil(paramAnonymousView)) {
            ad.w(MPVideoPlayFullScreenView.a(this.Eoz), "srcUserName is null");
          }
          localObject2 = new Intent();
          y localy = MPVideoPlayFullScreenView.g(this.Eoz);
          paramAnonymousView = localObject1;
          if (localy != null) {
            paramAnonymousView = localy.doK;
          }
          ((Intent)localObject2).putExtra("Contact_User", paramAnonymousView);
          ((Intent)localObject2).putExtra("Contact_Scene", 163);
          ((Intent)localObject2).putExtra("force_get_contact", true);
          ((Intent)localObject2).putExtra("key_use_new_contact_profile", true);
          com.tencent.mm.bs.d.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
          com.tencent.mm.plugin.report.service.g.yhR.f(18589, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(82585);
          return;
        }
      }
    });
    o.gT(this.rPF);
    paramAttributeSet = findViewById(2131306371);
    p.g(paramAttributeSet, "findViewById(R.id.video_player_close)");
    this.odX = paramAttributeSet;
    this.odX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82586);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.Eoz.exit();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82586);
      }
    });
    paramAttributeSet = findViewById(2131306373);
    p.g(paramAttributeSet, "findViewById(R.id.video_player_more_iv)");
    this.Eoh = paramAttributeSet;
    this.Eoh.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82587);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = MPVideoPlayFullScreenView.g(this.Eoz);
        if (paramAnonymousView != null)
        {
          localObject = g.EoW;
          g.a(paramContext, paramAnonymousView, 4);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82587);
      }
    });
    paramAttributeSet = findViewById(2131306376);
    p.g(paramAttributeSet, "findViewById(R.id.video_player_share_iv)");
    this.Eoj = paramAttributeSet;
    this.Eoj.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82588);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        paramAnonymousView = paramContext;
        if (((paramAnonymousView instanceof WebViewUI)) && (MPVideoPlayFullScreenView.g(this.Eoz) != null)) {
          if (x.ffw())
          {
            localObject1 = g.EoW;
            localObject1 = MPVideoPlayFullScreenView.g(this.Eoz);
            if (localObject1 == null) {
              p.gfZ();
            }
            g.a(paramAnonymousView, (y)localObject1, 5);
            com.tencent.mm.plugin.report.service.g.yhR.f(18589, new Object[] { Integer.valueOf(16), Integer.valueOf(3) });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(82588);
          return;
          ((WebViewUI)paramAnonymousView).Eeo.hzo = MPVideoPlayFullScreenView.g(this.Eoz);
          localObject1 = d.EoO;
          localObject1 = MPVideoPlayFullScreenView.g(this.Eoz);
          if (localObject1 == null) {
            p.gfZ();
          }
          localObject1 = ((y)localObject1).hDm;
          Object localObject2 = MPVideoPlayFullScreenView.g(this.Eoz);
          if (localObject2 == null) {
            p.gfZ();
          }
          localObject2 = ((y)localObject2).title;
          y localy = MPVideoPlayFullScreenView.g(this.Eoz);
          if (localy == null) {
            p.gfZ();
          }
          d.a(paramAnonymousView, (String)localObject1, "", (String)localObject2, localy.FCb, 2);
          break;
          ad.w(MPVideoPlayFullScreenView.a(this.Eoz), "should not be here");
        }
      }
    });
    paramContext = findViewById(2131306413);
    p.g(paramContext, "findViewById(R.id.video_wait_play_btn)");
    this.Eoi = paramContext;
    this.Eoi.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82589);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        MPVideoPlayFullScreenView.B(this.Eoz);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82589);
      }
    });
    this.ofo.setVisibility(8);
    paramContext = this.Bjp;
    if (paramContext != null) {
      paramContext.setPlayBtnOnClickListener((View.OnClickListener)this);
    }
    paramContext = this.Bjp;
    if (paramContext != null) {
      paramContext.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new g(this));
    }
    this.Aal = 1.0F;
    this.Eou = new av((av.a)new f(this), true);
    this.Eov = 4000L;
    AppMethodBeat.o(82641);
  }
  
  private final void eUP()
  {
    AppMethodBeat.i(82626);
    if (this.oGo == null) {
      this.oGo = new com.tencent.mm.ui.tools.e(getContext());
    }
    if (this.hzo == null)
    {
      this.Eos = true;
      AppMethodBeat.o(82626);
      return;
    }
    this.Eos = false;
    Object localObject = this.hzo;
    if (localObject == null) {
      p.gfZ();
    }
    int i = ((y)localObject).hDK;
    localObject = this.hzo;
    if (localObject == null) {
      p.gfZ();
    }
    int j = ((y)localObject).hDL;
    localObject = this.hzo;
    if (localObject == null) {
      p.gfZ();
    }
    int k = ((y)localObject).hDM;
    localObject = this.hzo;
    if (localObject == null) {
      p.gfZ();
    }
    int m = ((y)localObject).hDN;
    localObject = this.oGo;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.e)localObject).R(i, j, k, m);
    }
    localObject = this.oGo;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.e)localObject).fKv();
    }
    localObject = this.oGo;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.e)localObject).kb(0, 0);
    }
    eUQ();
    AppMethodBeat.o(82626);
  }
  
  private final void eUQ()
  {
    AppMethodBeat.i(82627);
    Object localObject = this.Eod;
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
  
  private final void eUR()
  {
    AppMethodBeat.i(82631);
    if (this.lQV)
    {
      localu = this.Eok;
      if (localu != null)
      {
        localu.etk();
        AppMethodBeat.o(82631);
        return;
      }
      AppMethodBeat.o(82631);
      return;
    }
    u localu = this.Eok;
    if (localu != null)
    {
      localu.gaG();
      AppMethodBeat.o(82631);
      return;
    }
    AppMethodBeat.o(82631);
  }
  
  private final void eUS()
  {
    try
    {
      AppMethodBeat.i(207608);
      Object localObject1 = getContext();
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(207608);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    Activity localActivity = (Activity)localObject2;
    if (this.hzo == null)
    {
      ad.d(this.TAG, "adjustOrientation mpShareVideoInfo is null");
      AppMethodBeat.o(207608);
    }
    for (;;)
    {
      return;
      if ((!this.Eop) && (this.Eoq)) {
        break;
      }
      ad.i(this.TAG, "adjustOrientation hasAdjustOrientation=" + this.Eop + ", hasAddVideoView=" + this.Eoq);
      AppMethodBeat.o(207608);
    }
    this.Eop = true;
    if (this.Eon == this.Eom) {
      this.Eon = localActivity.getRequestedOrientation();
    }
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("adjustOrientation width = ");
    y localy = this.hzo;
    if (localy == null) {
      p.gfZ();
    }
    localStringBuilder = localStringBuilder.append(localy.width).append(", height=");
    localy = this.hzo;
    if (localy == null) {
      p.gfZ();
    }
    ad.i((String)localObject3, localy.height);
    localObject3 = this.hzo;
    if (localObject3 == null) {
      p.gfZ();
    }
    int i = ((y)localObject3).width;
    localObject3 = this.hzo;
    if (localObject3 == null) {
      p.gfZ();
    }
    if (i <= ((y)localObject3).height)
    {
      this.mCurrentOrientation = 1;
      localActivity.setRequestedOrientation(this.mCurrentOrientation);
      this.Eoo = false;
    }
    for (;;)
    {
      eUZ();
      AppMethodBeat.o(207608);
      break;
      this.Eoo = true;
      this.mCurrentOrientation = 0;
      localActivity.setRequestedOrientation(this.mCurrentOrientation);
      this.EcN.enable();
    }
  }
  
  private final void eUV()
  {
    boolean bool = true;
    AppMethodBeat.i(82635);
    Object localObject = this.TAG;
    if (this.Eob.getVisibility() == 0) {}
    for (;;)
    {
      ad.d((String)localObject, "fadeOutOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = eUW();
      ((Animation)localObject).setFillAfter(false);
      ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this));
      this.Eob.clearAnimation();
      this.Eob.startAnimation((Animation)localObject);
      AppMethodBeat.o(82635);
      return;
      bool = false;
    }
  }
  
  private static Animation eUW()
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
  
  private final void eUX()
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
    ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new d(this, (View)localObject));
    AppMethodBeat.o(82638);
  }
  
  private final void eUY()
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
    ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new c(this, (View)localObject));
    AppMethodBeat.o(82639);
  }
  
  private final void eUZ()
  {
    AppMethodBeat.i(182654);
    if ((this.mCurrentOrientation == 0) || (this.mCurrentOrientation == 8))
    {
      eUY();
      AppMethodBeat.o(182654);
      return;
    }
    eUX();
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
        localObject1 = ((com.tencent.mm.plugin.webview.core.b)localObject3).bQm();
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
    this.Eoc.removeAllViews();
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
  
  private final void vn(boolean paramBoolean)
  {
    AppMethodBeat.i(182653);
    ad.i(this.TAG, "handleFullScreenStatusBar forwardUiVisibility " + this.otA);
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
      this.otA = ((ViewGroup)localObject2).getSystemUiVisibility();
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
    ((ViewGroup)localObject2).setSystemUiVisibility(this.otA);
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
        AppMethodBeat.i(207606);
        p.h(paramy, "mpShareVideoInfo");
        this.hzo = paramy;
        this.hDR = paramy.hDR;
        paramy = this.opB.getPaint();
        p.g(paramy, "titleTv.paint");
        paramy.setFakeBoldText(true);
        paramy = this.opA.getPaint();
        p.g(paramy, "nicknameTv.paint");
        paramy.setFakeBoldText(true);
        localObject = this.opB;
        paramy = this.hzo;
        if (paramy != null)
        {
          paramy = paramy.title;
          ((MMNeat7extView)localObject).ar((CharSequence)paramy);
          localObject = this.opA;
          Context localContext = getContext();
          paramy = this.hzo;
          if (paramy != null)
          {
            paramy = paramy.hDe;
            ((TextView)localObject).setText((CharSequence)k.b(localContext, (CharSequence)paramy, this.opA.getTextSize()));
            if (!this.hDR) {
              continue;
            }
            this.Eoh.setVisibility(8);
            this.Eoj.setVisibility(8);
            localObject = getContext();
            if ((localObject instanceof WebViewUI))
            {
              paramy = this.hzo;
              if (paramy == null) {
                break label311;
              }
              paramy = paramy.hDQ;
              if (bt.isNullOrNil(paramy)) {
                break label321;
              }
              paramy = this.hzo;
              if (paramy == null) {
                break label316;
              }
              paramy = paramy.hDQ;
              com.tencent.mm.aw.a.a.aIP().a(paramy, this.fRd, new c.a().aJa().pH(2131231342).aJc());
            }
            if (this.Eos) {
              eUP();
            }
            ad.d(this.TAG, "initData");
            eUS();
            AppMethodBeat.o(207606);
          }
        }
        else
        {
          paramy = null;
          continue;
        }
        paramy = null;
        continue;
        this.Eoh.setVisibility(0);
        this.Eoj.setVisibility(0);
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
      paramy = ((WebViewUI)localObject).eSw();
      if (paramy != null)
      {
        paramy = paramy.bKH();
        if (paramy != null)
        {
          paramy = paramy.dDH;
          continue;
        }
      }
      paramy = null;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public final void eUT()
  {
    AppMethodBeat.i(182652);
    if (this.Eon != this.Eom)
    {
      Object localObject = getContext();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(182652);
        throw ((Throwable)localObject);
      }
      ((Activity)localObject).setRequestedOrientation(this.Eon);
      this.Eon = this.Eom;
      this.EcN.disable();
    }
    vn(false);
    AppMethodBeat.o(182652);
  }
  
  public final void eUU()
  {
    AppMethodBeat.i(82634);
    if (i.IS_FLAVOR_RED) {
      ad.d(this.TAG, "hideOpLayer %s", new Object[] { bt.flS() });
    }
    if (!this.Eow)
    {
      AppMethodBeat.o(82634);
      return;
    }
    this.Eow = false;
    eUV();
    AppMethodBeat.o(82634);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(82628);
    Context localContext = getContext();
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).eTl() != null))
    {
      if (((WebViewUI)localContext).eTl() != null)
      {
        ad.i(this.TAG, "close click");
        eUT();
        ((WebViewUI)localContext).eTl().leaveFullscreen();
        aq.o((Runnable)new a(this), 500L);
        AppMethodBeat.o(82628);
      }
    }
    else {
      ad.w(this.TAG, "should not be here");
    }
    AppMethodBeat.o(82628);
  }
  
  public final void fO(View paramView)
  {
    try
    {
      AppMethodBeat.i(207607);
      p.h(paramView, "view");
      if (this.hzo == null) {
        break label209;
      }
      localObject1 = this.hzo;
      if (localObject1 == null) {
        p.gfZ();
      }
      ((y)localObject1).hDO = this.oog;
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramView = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        AppMethodBeat.o(207607);
        throw paramView;
      }
    }
    finally {}
    Object localObject2 = (WebViewUI)localObject1;
    Object localObject1 = ((WebViewUI)localObject2).lvv;
    if (localObject1 != null) {}
    try
    {
      localObject1 = this.Eor;
      localObject2 = ((WebViewUI)localObject2).lvv;
      y localy = this.hzo;
      if (localy == null) {
        p.gfZ();
      }
      ((h)localObject1).orE = ((com.tencent.mm.plugin.webview.stub.e)localObject2).zD(localy.doK);
      this.Eor.scene = 141;
      this.Eor.ooi = getSubScene$1385f2();
    }
    catch (Exception localException)
    {
      label149:
      break label149;
    }
    this.orN = System.currentTimeMillis();
    this.oog = ((int)(this.orN / 1000L));
    this.Eor.a(this.hzo, 1, this.oog);
    this.Eor.a(this.hzo, 5, this.oog);
    this.Eor.irQ = 0;
    label209:
    removeVideoView();
    vn(true);
    this.Eoa.setAlpha(1.0F);
    this.Eoa.setBackgroundColor(-16777216);
    setVisibility(0);
    localObject1 = new FrameLayout(getContext());
    ((FrameLayout)localObject1).addView(paramView, new ViewGroup.LayoutParams(-1, -2));
    this.Eod = ((ViewGroup)localObject1);
    paramView = this.Eoc;
    localObject1 = (View)this.Eod;
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    eUP();
    this.Bjz = false;
    ad.d(this.TAG, "addVideoView");
    this.Eoq = true;
    eUS();
    AppMethodBeat.o(207607);
  }
  
  public final int getEnterId()
  {
    return this.oog;
  }
  
  public final long getEnterTimeInMs()
  {
    return this.orN;
  }
  
  public final boolean getForbidForward()
  {
    return this.hDR;
  }
  
  public final h getMpShareVideoReport()
  {
    return this.Eor;
  }
  
  public final Integer getSubScene()
  {
    return this.Eot;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(82630);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((paramView != null) && (paramView.getId() == 2131303281)) {
      eUR();
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
      ad.d(this.TAG, "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      eUX();
      AppMethodBeat.o(82637);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ad.d(this.TAG, "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
      eUY();
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
    this.Eop = false;
    this.Eoq = false;
    if (this.hzo != null)
    {
      this.Eor.orC = ((int)(System.currentTimeMillis() - this.orN));
      this.Eor.orB = ((int)(this.Eol * 1000.0D));
      this.Eor.a(this.hzo, 6, this.oog);
      this.Eor.a(this.hzo, 2, this.oog);
      Object localObject = getContext();
      if (((localObject instanceof WebViewUI)) && (((WebViewUI)localObject).DzP != null))
      {
        localObject = ((WebViewUI)localObject).DzP;
        y localy = this.hzo;
        if (localy == null) {
          p.gfZ();
        }
        ((f)localObject).fz(localy.FCc, (int)this.Eol);
      }
      this.hzo = null;
    }
    AppMethodBeat.o(82629);
  }
  
  public final void setEnterId(int paramInt)
  {
    this.oog = paramInt;
  }
  
  public final void setEnterTimeInMs(long paramLong)
  {
    this.orN = paramLong;
  }
  
  public final void setForbidForward(boolean paramBoolean)
  {
    this.hDR = paramBoolean;
  }
  
  public final void setSubScene(Integer paramInteger)
  {
    this.Eot = paramInteger;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82590);
      this.Eoz.onExit();
      AppMethodBeat.o(82590);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$fadeOutOpLayout$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(82592);
      p.h(paramAnimation, "animation");
      if (!MPVideoPlayFullScreenView.r(this.Eoz)) {
        MPVideoPlayFullScreenView.s(this.Eoz);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$handleHorizontalUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class c
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    c(View paramView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82594);
      Object localObject = this.EoA;
      p.g(localObject, "contentRoot");
      ((View)localObject).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      if (com.tencent.mm.compatible.util.d.ly(24))
      {
        localObject = this.Eoz.getContext();
        if (localObject == null)
        {
          localObject = new d.v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(82594);
          throw ((Throwable)localObject);
        }
        if (((Activity)localObject).isInMultiWindowMode())
        {
          MPVideoPlayFullScreenView.t(this.Eoz);
          AppMethodBeat.o(82594);
          return;
        }
      }
      int n = ar.ej(this.Eoz.getContext());
      int i = com.tencent.mm.cc.a.ay(this.Eoz.getContext(), 2131165303);
      int j = i * 3;
      int k = i * 4;
      int m = i * 7;
      n = Math.max(n - i * 3, 0);
      MPVideoPlayFullScreenView.u(this.Eoz).setPadding(n, i * 2, n - i, i * 2);
      localObject = MPVideoPlayFullScreenView.v(this.Eoz).getLayoutParams();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject).setMargins(k, j, 0, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      MPVideoPlayFullScreenView.v(this.Eoz).setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = MPVideoPlayFullScreenView.w(this.Eoz).getLayoutParams();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, j, k, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      MPVideoPlayFullScreenView.w(this.Eoz).setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = MPVideoPlayFullScreenView.x(this.Eoz).getLayoutParams();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, j, k, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      MPVideoPlayFullScreenView.x(this.Eoz).setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = MPVideoPlayFullScreenView.m(this.Eoz);
      if (localObject == null) {
        p.gfZ();
      }
      localObject = ((RedesignVideoPlayerSeekBar)localObject).getLayoutParams();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(82594);
        throw ((Throwable)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131306371);
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131306376);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      ((RelativeLayout.LayoutParams)localObject).setMargins(m, j, m, j);
      RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = MPVideoPlayFullScreenView.m(this.Eoz);
      if (localRedesignVideoPlayerSeekBar != null)
      {
        localRedesignVideoPlayerSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(82594);
        return;
      }
      AppMethodBeat.o(82594);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$handleVerticalUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class d
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    d(View paramView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82595);
      View localView = this.EoA;
      p.g(localView, "contentRoot");
      localView.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      MPVideoPlayFullScreenView.t(this.Eoz);
      AppMethodBeat.o(82595);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82596);
      ProgressBar localProgressBar = MPVideoPlayFullScreenView.l(this.Eoz);
      if ((localProgressBar != null) && (localProgressBar.getVisibility() == 0))
      {
        localProgressBar = MPVideoPlayFullScreenView.l(this.Eoz);
        if (localProgressBar != null) {
          localProgressBar.setVisibility(8);
        }
      }
      if (!MPVideoPlayFullScreenView.n(this.Eoz)) {
        MPVideoPlayFullScreenView.k(this.Eoz).setVisibility(0);
      }
      AppMethodBeat.o(82596);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTimerExpired"})
  static final class f
    implements av.a
  {
    f(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(82597);
      MPVideoPlayFullScreenView.i(this.Eoz);
      AppMethodBeat.o(82597);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$initSeekBar$1", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-webview_release"})
  public static final class g
    implements com.tencent.mm.plugin.sight.decode.ui.b
  {
    public final void aqD() {}
    
    public final void nM(int paramInt)
    {
      AppMethodBeat.i(82598);
      ad.i(MPVideoPlayFullScreenView.a(this.Eoz), "initSeekBar onSeekTo ".concat(String.valueOf(paramInt)));
      u localu = MPVideoPlayFullScreenView.o(this.Eoz);
      if (localu != null)
      {
        localu.G(paramInt);
        AppMethodBeat.o(82598);
        return;
      }
      AppMethodBeat.o(82598);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$initVideoController$1", "Lcom/tencent/xweb/VideoJsCallback;", "lastUpdateTime", "", "getLastUpdateTime", "()J", "setLastUpdateTime", "(J)V", "onSetRequestedOrientation", "", "orientation", "", "onVideoEmptied", "", "onVideoEnded", "onVideoEnterFullscreen", "isVideoTag", "id", "width", "", "height", "paused", "seeking", "currentTime", "duration", "buffered", "", "onVideoError", "error", "msg", "", "onVideoExitFullscreen", "onVideoPause", "onVideoPlay", "onVideoPlaying", "onVideoSeeked", "onVideoSeeking", "onVideoSizeUpdate", "onVideoTimeUpdate", "onVideoWaiting", "plugin-webview_release"})
  public static final class h
    implements com.tencent.xweb.v
  {
    private long lastUpdateTime;
    
    public final void bph()
    {
      AppMethodBeat.i(82602);
      ad.i(MPVideoPlayFullScreenView.a(this.Eoz), "onVideoEmptied");
      MPVideoPlayFullScreenView.p(this.Eoz);
      AppMethodBeat.o(82602);
    }
    
    public final void onVideoEnded()
    {
      AppMethodBeat.i(82600);
      ad.i(MPVideoPlayFullScreenView.a(this.Eoz), "onVideoEnded");
      MPVideoPlayFullScreenView.c(this.Eoz, false);
      MPVideoPlayFullScreenView.p(this.Eoz);
      this.Eoz.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.Eoz), 7, this.Eoz.getEnterId());
      this.Eoz.getMpShareVideoReport().irQ = 4;
      AppMethodBeat.o(82600);
    }
    
    public final void onVideoEnterFullscreen(boolean paramBoolean1, long paramLong, double paramDouble1, double paramDouble2, boolean paramBoolean2, boolean paramBoolean3, double paramDouble3, double paramDouble4, double[] paramArrayOfDouble)
    {
      AppMethodBeat.i(82609);
      ad.i(MPVideoPlayFullScreenView.a(this.Eoz), "onVideoEnterFullscreen isVideoTag:" + paramBoolean1 + ", id:" + paramLong + ", width:" + paramDouble1 + ", height:" + paramDouble2 + ", paused:" + paramBoolean2 + ", seeking:" + paramBoolean3 + ", currentTime:" + paramDouble3 + ", duration:" + paramDouble4 + ", buffered:" + Arrays.toString(paramArrayOfDouble));
      paramArrayOfDouble = this.Eoz;
      if (!paramBoolean2) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        MPVideoPlayFullScreenView.b(paramArrayOfDouble, paramBoolean1);
        MPVideoPlayFullScreenView.c(this.Eoz, MPVideoPlayFullScreenView.n(this.Eoz));
        if (MPVideoPlayFullScreenView.n(this.Eoz))
        {
          this.Eoz.getMpShareVideoReport().irQ = 1;
          this.Eoz.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.Eoz), this.Eoz.getMpShareVideoReport().eVd(), this.Eoz.getEnterId());
        }
        AppMethodBeat.o(82609);
        return;
      }
    }
    
    public final void onVideoError(int paramInt, String paramString)
    {
      AppMethodBeat.i(82601);
      ad.e(MPVideoPlayFullScreenView.a(this.Eoz), "onVideoError " + paramInt + ", " + paramString);
      MPVideoPlayFullScreenView.c(this.Eoz, false);
      MPVideoPlayFullScreenView.p(this.Eoz);
      this.Eoz.getMpShareVideoReport().irQ = 4;
      this.Eoz.getMpShareVideoReport().orD = paramString;
      this.Eoz.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.Eoz), 11, this.Eoz.getEnterId());
      AppMethodBeat.o(82601);
    }
    
    public final void onVideoExitFullscreen()
    {
      AppMethodBeat.i(82610);
      ad.i(MPVideoPlayFullScreenView.a(this.Eoz), "onVideoExitFullscreen");
      AppMethodBeat.o(82610);
    }
    
    public final void onVideoPause()
    {
      AppMethodBeat.i(82608);
      ad.i(MPVideoPlayFullScreenView.a(this.Eoz), "onVideoPause");
      MPVideoPlayFullScreenView.c(this.Eoz, false);
      MPVideoPlayFullScreenView.p(this.Eoz);
      if (this.Eoz.getMpShareVideoReport().irQ != 3) {
        this.Eoz.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.Eoz), 8, this.Eoz.getEnterId());
      }
      this.Eoz.getMpShareVideoReport().irQ = 3;
      AppMethodBeat.o(82608);
    }
    
    public final void onVideoPlay()
    {
      AppMethodBeat.i(82607);
      ad.i(MPVideoPlayFullScreenView.a(this.Eoz), "onVideoPlay");
      MPVideoPlayFullScreenView.c(this.Eoz, true);
      MPVideoPlayFullScreenView.p(this.Eoz);
      if (this.Eoz.getMpShareVideoReport().irQ != 2) {
        this.Eoz.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.Eoz), this.Eoz.getMpShareVideoReport().eVd(), this.Eoz.getEnterId());
      }
      this.Eoz.getMpShareVideoReport().irQ = 2;
      AppMethodBeat.o(82607);
    }
    
    public final void onVideoPlaying()
    {
      AppMethodBeat.i(82603);
      ad.d(MPVideoPlayFullScreenView.a(this.Eoz), "onVideoPlaying");
      if (!MPVideoPlayFullScreenView.n(this.Eoz))
      {
        MPVideoPlayFullScreenView.c(this.Eoz, true);
        MPVideoPlayFullScreenView.p(this.Eoz);
      }
      this.Eoz.getMpShareVideoReport().irQ = 2;
      AppMethodBeat.o(82603);
    }
    
    public final void onVideoSeeked()
    {
      AppMethodBeat.i(82606);
      ad.i(MPVideoPlayFullScreenView.a(this.Eoz), "onVideoSeeked");
      MPVideoPlayFullScreenView.p(this.Eoz);
      this.Eoz.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.Eoz), 13, this.Eoz.getEnterId());
      AppMethodBeat.o(82606);
    }
    
    public final void onVideoSeeking()
    {
      AppMethodBeat.i(82605);
      ad.i(MPVideoPlayFullScreenView.a(this.Eoz), "onVideoSeeking");
      MPVideoPlayFullScreenView.q(this.Eoz);
      AppMethodBeat.o(82605);
    }
    
    public final void onVideoSizeUpdate(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(82612);
      y localy = MPVideoPlayFullScreenView.g(this.Eoz);
      if ((localy == null) || (localy.width != 0))
      {
        localy = MPVideoPlayFullScreenView.g(this.Eoz);
        if (localy != null) {
          if (localy.height != 0) {
            break label103;
          }
        }
      }
      else
      {
        localy = MPVideoPlayFullScreenView.g(this.Eoz);
        if (localy != null) {
          localy.width = ((int)paramDouble1);
        }
        localy = MPVideoPlayFullScreenView.g(this.Eoz);
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
      MPVideoPlayFullScreenView.a(this.Eoz, paramDouble1);
      MPVideoPlayFullScreenView.p(this.Eoz);
      AppMethodBeat.o(82611);
    }
    
    public final void onVideoWaiting()
    {
      AppMethodBeat.i(82604);
      ad.i(MPVideoPlayFullScreenView.a(this.Eoz), "onVideoWaiting");
      MPVideoPlayFullScreenView.q(this.Eoz);
      AppMethodBeat.o(82604);
    }
    
    public final boolean tG(int paramInt)
    {
      return false;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoPlayFullScreenView.h paramh, double paramDouble1, double paramDouble2, double[] paramArrayOfDouble) {}
      
      public final void run()
      {
        int j = 1;
        AppMethodBeat.i(82599);
        Object localObject = MPVideoPlayFullScreenView.m(this.EoB.Eoz);
        if (localObject != null) {
          ((RedesignVideoPlayerSeekBar)localObject).setVideoTotalTime((int)paramDouble2);
        }
        localObject = MPVideoPlayFullScreenView.m(this.EoB.Eoz);
        if (localObject != null) {
          ((RedesignVideoPlayerSeekBar)localObject).tt((int)paramArrayOfDouble);
        }
        localObject = this.EoE;
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
            RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = MPVideoPlayFullScreenView.m(this.EoB.Eoz);
            if (localRedesignVideoPlayerSeekBar == null) {
              break label133;
            }
            p.h(localObject, "$this$lastIndex");
            localRedesignVideoPlayerSeekBar.Zw((int)localObject[(localObject.length - 1)]);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class i
    implements a.b
  {
    i(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, Context paramContext) {}
    
    public final void a(a.a parama1, a.a parama2)
    {
      AppMethodBeat.i(182651);
      if (MPVideoPlayFullScreenView.y(this.Eoz))
      {
        parama1 = this.Eoz;
        if (parama2 == null)
        {
          AppMethodBeat.o(182651);
          return;
        }
        switch (b.cpQ[parama2.ordinal()])
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
        ((Activity)parama1).setRequestedOrientation(MPVideoPlayFullScreenView.z(this.Eoz));
        MPVideoPlayFullScreenView.A(this.Eoz);
      }
      AppMethodBeat.o(182651);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onExit"})
  static final class j
    implements e.b
  {
    j(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void onExit()
    {
      AppMethodBeat.i(82613);
      this.Eoz.exit();
      AppMethodBeat.o(82613);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "longClickOver"})
  static final class k
    implements e.d
  {
    k(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void aRq()
    {
      AppMethodBeat.i(82614);
      if (!this.Eoz.getForbidForward())
      {
        y localy = MPVideoPlayFullScreenView.g(this.Eoz);
        if (localy != null)
        {
          Object localObject = g.EoW;
          localObject = this.Eoz.getContext();
          p.g(localObject, "context");
          g.a((Context)localObject, localy, 3);
          AppMethodBeat.o(82614);
          return;
        }
      }
      AppMethodBeat.o(82614);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onClick"})
  static final class l
    implements e.f
  {
    l(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(82615);
      if (MPVideoPlayFullScreenView.h(this.Eoz).getVisibility() == 0)
      {
        MPVideoPlayFullScreenView.i(this.Eoz);
        AppMethodBeat.o(82615);
        return;
      }
      MPVideoPlayFullScreenView.f(this.Eoz);
      AppMethodBeat.o(82615);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "tx", "", "ty", "onGalleryScale"})
  static final class m
    implements e.e
  {
    m(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void O(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(82616);
      if ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F))
      {
        MPVideoPlayFullScreenView.f(this.Eoz);
        AppMethodBeat.o(82616);
        return;
      }
      if ((Math.abs(paramFloat1) > 10.0F) || (Math.abs(paramFloat2) > 10.0F)) {
        MPVideoPlayFullScreenView.i(this.Eoz);
      }
      AppMethodBeat.o(82616);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    public static final n EoF;
    
    static
    {
      AppMethodBeat.i(82618);
      EoF = new n();
      AppMethodBeat.o(82618);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(82617);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runDragAnimation$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runDragAnimation$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(82617);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runEnterAnimation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class o
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82620);
      ad.d(MPVideoPlayFullScreenView.a(this.Eoz), "runEnterAnimation");
      Object localObject = MPVideoPlayFullScreenView.b(this.Eoz);
      if (localObject != null)
      {
        localObject = ((ViewGroup)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      localObject = MPVideoPlayFullScreenView.b(this.Eoz);
      if (localObject != null) {}
      for (localObject = Integer.valueOf(((ViewGroup)localObject).getHeight());; localObject = null)
      {
        if (localObject == null) {
          p.gfZ();
        }
        if (((Integer)localObject).intValue() > 0) {
          break;
        }
        MPVideoPlayFullScreenView.c(this.Eoz);
        AppMethodBeat.o(82620);
        return;
      }
      MPVideoPlayFullScreenView.d(this.Eoz);
      localObject = MPVideoPlayFullScreenView.e(this.Eoz);
      if (localObject != null)
      {
        ViewGroup localViewGroup = MPVideoPlayFullScreenView.b(this.Eoz);
        if (localViewGroup == null) {
          p.gfZ();
        }
        ((com.tencent.mm.ui.tools.e)localObject).a((View)localViewGroup, null, (e.c)new a(this));
        AppMethodBeat.o(82620);
        return;
      }
      AppMethodBeat.o(82620);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runEnterAnimation$1$onGlobalLayout$1", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-webview_release"})
    public static final class a
      implements e.c
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(82619);
        MPVideoPlayFullScreenView.f(this.EoG.Eoz);
        AppMethodBeat.o(82619);
      }
      
      public final void onAnimationStart() {}
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runExitAnimation$2", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-webview_release"})
  public static final class p
    implements e.c
  {
    public p(e.c paramc) {}
    
    public final void onAnimationEnd()
    {
      AppMethodBeat.i(82623);
      e.c localc = this.EoH;
      if (localc != null) {
        localc.onAnimationEnd();
      }
      MPVideoPlayFullScreenView.j(this.Eoz).post((Runnable)new a(this));
      MPVideoPlayFullScreenView.a(this.Eoz, false);
      this.Eoz.onExit();
      AppMethodBeat.o(82623);
    }
    
    public final void onAnimationStart()
    {
      AppMethodBeat.i(82622);
      MPVideoPlayFullScreenView.a(this.Eoz, true);
      e.c localc = this.EoH;
      if (localc != null)
      {
        localc.onAnimationStart();
        AppMethodBeat.o(82622);
        return;
      }
      AppMethodBeat.o(82622);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoPlayFullScreenView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(82621);
        Object localObject = this.EoJ.Eoz.getContext();
        if (((localObject instanceof WebViewUI)) && (((WebViewUI)localObject).eTl() != null))
        {
          localObject = this.EoJ.Eoz.getContext();
          if (localObject == null)
          {
            localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
            AppMethodBeat.o(82621);
            throw ((Throwable)localObject);
          }
          ((WebViewUI)localObject).eTl().leaveFullscreen();
        }
        MPVideoPlayFullScreenView.j(this.EoJ.Eoz).setLayoutParams(this.EoJ.EoI);
        AppMethodBeat.o(82621);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82624);
      ProgressBar localProgressBar = MPVideoPlayFullScreenView.l(this.Eoz);
      if ((localProgressBar == null) || (localProgressBar.getVisibility() != 0))
      {
        localProgressBar = MPVideoPlayFullScreenView.l(this.Eoz);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(82625);
      if (this.EoK) {
        MPVideoPlayFullScreenView.k(this.Eoz).setVisibility(8);
      }
      for (;;)
      {
        Object localObject = MPVideoPlayFullScreenView.m(this.Eoz);
        if (localObject == null) {
          break;
        }
        ((RedesignVideoPlayerSeekBar)localObject).gS(MPVideoPlayFullScreenView.n(this.Eoz));
        AppMethodBeat.o(82625);
        return;
        localObject = MPVideoPlayFullScreenView.l(this.Eoz);
        if ((localObject == null) || (((ProgressBar)localObject).getVisibility() != 0)) {
          MPVideoPlayFullScreenView.k(this.Eoz).setVisibility(0);
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