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
import com.tencent.mm.ah.y;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.bo.a.a;
import com.tencent.mm.bo.a.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.tools.e.b;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.tools.e.d;
import com.tencent.mm.ui.tools.e.e;
import com.tencent.mm.ui.tools.e.f;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.u;
import d.l;
import java.util.Arrays;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ENTER_HIDE_MIL_SEC", "", "INVALID_ORIENTATION", "", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/view/View;", "centerPlayIv", "closeIv", "currentPlayTime", "", "enterId", "getEnterId", "()I", "setEnterId", "(I)V", "enterTimeInMs", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "footerLayout", "forbidForward", "", "getForbidForward", "()Z", "setForbidForward", "(Z)V", "forwardUiVisibility", "hasAddVideoView", "hasAdjustOrientation", "hideToolBarTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "imagePreviewAnimation", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;", "isLandScapeVideo", "isPlaying", "isRunningExitAnimation", "loadingBar", "Landroid/widget/ProgressBar;", "mCurrentOrientation", "mIsShowOpLayout", "mPreOrientation", "moreIv", "moreLayout", "mpInfoLayout", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "mpShareVideoReport", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "getMpShareVideoReport", "()Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "needDoAnimation", "nicknameTv", "Landroid/widget/TextView;", "orientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "preDeltaX", "preDeltaY", "preScale", "", "shareIv", "subScene", "getSubScene", "()Ljava/lang/Integer;", "setSubScene", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "touchLayout", "videoContainerLayout", "Landroid/view/ViewGroup;", "videoControl", "Lcom/tencent/xweb/VideoControl;", "videoPlayOpLayout", "videoPlayRootLayout", "videoPlayerSeekBar", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "videoRootLayout", "addVideoView", "", "view", "adjustOrientation", "exit", "fadeInAnimation", "Landroid/view/animation/Animation;", "fadeInOpLayout", "fadeOutAnimation", "duration", "fadeOutOpLayout", "force", "handleAnimation", "handleFullScreenStatusBar", "fullScreen", "handleHorizontalUI", "handleScreenSize", "handleVerticalUI", "hideLoading", "hideToolBar", "initData", "initReportData", "initSeekBar", "initVideoController", "initView", "loadAvatar", "onClick", "v", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onExit", "onExitMpVideoFullPage", "onResume", "opPlay", "postHandleVerticalUI", "removeVideoView", "resetOrientation", "runDragAnimation", "runEnterAnimation", "runExitAnimation", "bm", "Landroid/graphics/Bitmap;", "callback", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "showLoading", "showToolBar", "starHideToolBar", "startHideToolBarTimer", "stopHideToolBarTimer", "supportFullScreen", "updatePlayBtn", "playing", "plugin-webview_release"})
public final class MPVideoPlayFullScreenView
  extends RelativeLayout
  implements View.OnClickListener
{
  private int CKA;
  private boolean CKB;
  private boolean CKC;
  private boolean CKD;
  private final g CKE;
  private boolean CKF;
  private Integer CKG;
  private au CKH;
  private final long CKI;
  private boolean CKJ;
  public View CKn;
  private View CKo;
  private ViewGroup CKp;
  public ViewGroup CKq;
  private View CKr;
  private View CKs;
  private View CKt;
  private View CKu;
  private View CKv;
  private View CKw;
  public u CKx;
  private double CKy;
  private final int CKz;
  private com.tencent.mm.bo.a Cze;
  public final String TAG;
  private ImageView fxQ;
  private ProgressBar gCw;
  public y hhf;
  private boolean hlH;
  private boolean lrL;
  private int mCurrentOrientation;
  private View nBI;
  private View nCP;
  private int nLA;
  private TextView nMU;
  private MMNeat7extView nMV;
  private long nPh;
  private int nQT;
  public com.tencent.mm.ui.tools.e ocV;
  private View rcw;
  public float yIR;
  public int yIS;
  public int yIT;
  private RedesignVideoPlayerSeekBar zRK;
  public boolean zRU;
  
  public MPVideoPlayFullScreenView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82641);
    this.TAG = "MicroMsg.MPVideoPlayFullScreenView";
    this.CKz = -3;
    this.CKA = this.CKz;
    this.mCurrentOrientation = -1;
    this.Cze = new com.tencent.mm.bo.a(paramContext, (a.b)new i(this, paramContext));
    this.CKE = new g();
    View.inflate(paramContext, 2131494955, (ViewGroup)this);
    paramAttributeSet = findViewById(2131306368);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_play_root_layout)");
    this.CKn = paramAttributeSet;
    paramAttributeSet = findViewById(2131306366);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_play_op_layout)");
    this.CKo = paramAttributeSet;
    paramAttributeSet = findViewById(2131306318);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_container_layout)");
    this.CKp = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131306372);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_player_footer)");
    this.CKr = paramAttributeSet;
    paramAttributeSet = findViewById(2131302495);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.mp_info_layout)");
    this.CKs = paramAttributeSet;
    paramAttributeSet = findViewById(2131306408);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_touch_layout)");
    this.CKt = paramAttributeSet;
    paramAttributeSet = findViewById(2131302498);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.mp_video_avatar_layout)");
    this.rcw = paramAttributeSet;
    paramAttributeSet = findViewById(2131302497);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.mp_video_avatar_iv)");
    this.fxQ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131302508);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.mp_video_nickname_tv)");
    this.nMU = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131302513);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.mp_video_title_tv)");
    this.nMV = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131302514);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.mp_video_view_article_layout)");
    this.nCP = paramAttributeSet;
    this.zRK = ((RedesignVideoPlayerSeekBar)findViewById(2131306375));
    this.gCw = ((ProgressBar)findViewById(2131306374));
    paramAttributeSet = this.zRK;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)this);
    }
    paramAttributeSet = this.CKr;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)1.CKK);
    }
    paramAttributeSet = this.CKs;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)2.CKL);
    }
    this.rcw.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        Object localObject = null;
        AppMethodBeat.i(82585);
        if (MPVideoPlayFullScreenView.g(this.CKM) != null)
        {
          paramAnonymousView = MPVideoPlayFullScreenView.g(this.CKM);
          if (paramAnonymousView == null) {
            break label162;
          }
        }
        label162:
        for (paramAnonymousView = paramAnonymousView.ddo;; paramAnonymousView = null)
        {
          if (bs.isNullOrNil(paramAnonymousView)) {
            ac.w(MPVideoPlayFullScreenView.a(this.CKM), "srcUserName is null");
          }
          Intent localIntent = new Intent();
          y localy = MPVideoPlayFullScreenView.g(this.CKM);
          paramAnonymousView = localObject;
          if (localy != null) {
            paramAnonymousView = localy.ddo;
          }
          localIntent.putExtra("Contact_User", paramAnonymousView);
          localIntent.putExtra("Contact_Scene", 163);
          localIntent.putExtra("force_get_contact", true);
          localIntent.putExtra("key_use_new_contact_profile", true);
          com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
          com.tencent.mm.plugin.report.service.h.wUl.f(18589, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
          AppMethodBeat.o(82585);
          return;
        }
      }
    });
    o.gC(this.rcw);
    paramAttributeSet = findViewById(2131306371);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_player_close)");
    this.nBI = paramAttributeSet;
    this.nBI.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82586);
        this.CKM.exit();
        AppMethodBeat.o(82586);
      }
    });
    paramAttributeSet = findViewById(2131306373);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_player_more_iv)");
    this.CKu = paramAttributeSet;
    this.CKu.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82587);
        paramAnonymousView = MPVideoPlayFullScreenView.g(this.CKM);
        if (paramAnonymousView != null)
        {
          f localf = f.CLf;
          f.a(paramContext, paramAnonymousView, 3);
          AppMethodBeat.o(82587);
          return;
        }
        AppMethodBeat.o(82587);
      }
    });
    paramAttributeSet = findViewById(2131306376);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_player_share_iv)");
    this.CKw = paramAttributeSet;
    this.CKw.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82588);
        paramAnonymousView = paramContext;
        if (((paramAnonymousView instanceof WebViewUI)) && (MPVideoPlayFullScreenView.g(this.CKM) != null))
        {
          ((WebViewUI)paramAnonymousView).CAG.hhf = MPVideoPlayFullScreenView.g(this.CKM);
          Object localObject1 = c.CKY;
          localObject1 = MPVideoPlayFullScreenView.g(this.CKM);
          if (localObject1 == null) {
            d.g.b.k.fOy();
          }
          localObject1 = ((y)localObject1).hld;
          Object localObject2 = MPVideoPlayFullScreenView.g(this.CKM);
          if (localObject2 == null) {
            d.g.b.k.fOy();
          }
          localObject2 = ((y)localObject2).title;
          y localy = MPVideoPlayFullScreenView.g(this.CKM);
          if (localy == null) {
            d.g.b.k.fOy();
          }
          c.a(paramAnonymousView, (String)localObject1, "", (String)localObject2, localy.DWF, 2);
          com.tencent.mm.plugin.report.service.h.wUl.f(18589, new Object[] { Integer.valueOf(16), Integer.valueOf(3) });
          AppMethodBeat.o(82588);
          return;
        }
        ac.w(MPVideoPlayFullScreenView.a(this.CKM), "should not be here");
        AppMethodBeat.o(82588);
      }
    });
    paramContext = findViewById(2131306413);
    d.g.b.k.g(paramContext, "findViewById(R.id.video_wait_play_btn)");
    this.CKv = paramContext;
    this.CKv.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82589);
        MPVideoPlayFullScreenView.B(this.CKM);
        AppMethodBeat.o(82589);
      }
    });
    this.nCP.setVisibility(8);
    paramContext = this.zRK;
    if (paramContext != null) {
      paramContext.setPlayBtnOnClickListener((View.OnClickListener)this);
    }
    paramContext = this.zRK;
    if (paramContext != null) {
      paramContext.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new g(this));
    }
    this.yIR = 1.0F;
    this.CKH = new au((au.a)new f(this), true);
    this.CKI = 4000L;
    AppMethodBeat.o(82641);
  }
  
  private final void eFT()
  {
    AppMethodBeat.i(82626);
    if (this.ocV == null) {
      this.ocV = new com.tencent.mm.ui.tools.e(getContext());
    }
    if (this.hhf == null)
    {
      this.CKF = true;
      AppMethodBeat.o(82626);
      return;
    }
    this.CKF = false;
    Object localObject = this.hhf;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    int i = ((y)localObject).hlA;
    localObject = this.hhf;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    int j = ((y)localObject).hlB;
    localObject = this.hhf;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    int k = ((y)localObject).hlC;
    localObject = this.hhf;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    int m = ((y)localObject).hlD;
    localObject = this.ocV;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.e)localObject).R(i, j, k, m);
    }
    localObject = this.ocV;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.e)localObject).ftI();
    }
    localObject = this.ocV;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.e)localObject).jP(0, 0);
    }
    eFU();
    AppMethodBeat.o(82626);
  }
  
  private final void eFU()
  {
    AppMethodBeat.i(82627);
    Object localObject = this.CKq;
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
  
  private final void eFV()
  {
    AppMethodBeat.i(82631);
    if (this.lrL)
    {
      localu = this.CKx;
      if (localu != null)
      {
        localu.fJm();
        AppMethodBeat.o(82631);
        return;
      }
      AppMethodBeat.o(82631);
      return;
    }
    u localu = this.CKx;
    if (localu != null)
    {
      localu.fJl();
      AppMethodBeat.o(82631);
      return;
    }
    AppMethodBeat.o(82631);
  }
  
  private final void eFW()
  {
    try
    {
      AppMethodBeat.i(189473);
      Object localObject1 = getContext();
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(189473);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    Activity localActivity = (Activity)localObject2;
    if (this.hhf == null)
    {
      ac.d(this.TAG, "adjustOrientation mpShareVideoInfo is null");
      AppMethodBeat.o(189473);
    }
    for (;;)
    {
      return;
      if ((!this.CKC) && (this.CKD)) {
        break;
      }
      ac.i(this.TAG, "adjustOrientation hasAdjustOrientation=" + this.CKC + ", hasAddVideoView=" + this.CKD);
      AppMethodBeat.o(189473);
    }
    this.CKC = true;
    if (this.CKA == this.CKz) {
      this.CKA = localActivity.getRequestedOrientation();
    }
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("adjustOrientation width = ");
    y localy = this.hhf;
    if (localy == null) {
      d.g.b.k.fOy();
    }
    localStringBuilder = localStringBuilder.append(localy.width).append(", height=");
    localy = this.hhf;
    if (localy == null) {
      d.g.b.k.fOy();
    }
    ac.i((String)localObject3, localy.height);
    localObject3 = this.hhf;
    if (localObject3 == null) {
      d.g.b.k.fOy();
    }
    int i = ((y)localObject3).width;
    localObject3 = this.hhf;
    if (localObject3 == null) {
      d.g.b.k.fOy();
    }
    if (i <= ((y)localObject3).height)
    {
      this.mCurrentOrientation = 1;
      localActivity.setRequestedOrientation(this.mCurrentOrientation);
      this.CKB = false;
    }
    for (;;)
    {
      eGd();
      AppMethodBeat.o(189473);
      break;
      this.CKB = true;
      this.mCurrentOrientation = 0;
      localActivity.setRequestedOrientation(this.mCurrentOrientation);
      this.Cze.enable();
    }
  }
  
  private final void eFZ()
  {
    boolean bool = true;
    AppMethodBeat.i(82635);
    Object localObject = this.TAG;
    if (this.CKo.getVisibility() == 0) {}
    for (;;)
    {
      ac.d((String)localObject, "fadeOutOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = eGa();
      ((Animation)localObject).setFillAfter(false);
      ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this));
      this.CKo.clearAnimation();
      this.CKo.startAnimation((Animation)localObject);
      AppMethodBeat.o(82635);
      return;
      bool = false;
    }
  }
  
  private static Animation eGa()
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
  
  private final void eGb()
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
    d.g.b.k.g(localObject, "(context as Activity).window");
    localObject = ((Window)localObject).getDecorView();
    d.g.b.k.g(localObject, "contentRoot");
    ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new d(this, (View)localObject));
    AppMethodBeat.o(82638);
  }
  
  private final void eGc()
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
    d.g.b.k.g(localObject, "(context as Activity).window");
    localObject = ((Window)localObject).getDecorView();
    d.g.b.k.g(localObject, "contentRoot");
    ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new c(this, (View)localObject));
    AppMethodBeat.o(82639);
  }
  
  private final void eGd()
  {
    AppMethodBeat.i(182654);
    if ((this.mCurrentOrientation == 0) || (this.mCurrentOrientation == 8))
    {
      eGc();
      AppMethodBeat.o(182654);
      return;
    }
    eGb();
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
        localObject1 = ((com.tencent.mm.plugin.webview.core.b)localObject3).bLL();
      }
    }
    for (;;)
    {
      try
      {
        int j = bs.getInt(Uri.parse((String)localObject1).getQueryParameter("scene"), 10000);
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
    this.CKp.removeAllViews();
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
  
  private final void uC(boolean paramBoolean)
  {
    AppMethodBeat.i(182653);
    ac.i(this.TAG, "handleFullScreenStatusBar forwardUiVisibility " + this.nQT);
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
      d.g.b.k.g(localObject2, "activity.window");
      localObject2 = ((Window)localObject2).getDecorView();
      if (localObject2 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(182653);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup)localObject2;
      this.nQT = ((ViewGroup)localObject2).getSystemUiVisibility();
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
    d.g.b.k.g(localObject2, "activity.window");
    localObject2 = ((Window)localObject2).getDecorView();
    if (localObject2 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(182653);
      throw ((Throwable)localObject1);
    }
    ((ViewGroup)localObject2).setSystemUiVisibility(this.nQT);
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
        AppMethodBeat.i(189471);
        d.g.b.k.h(paramy, "mpShareVideoInfo");
        this.hhf = paramy;
        this.hlH = paramy.hlH;
        paramy = this.nMV.getPaint();
        d.g.b.k.g(paramy, "titleTv.paint");
        paramy.setFakeBoldText(true);
        paramy = this.nMU.getPaint();
        d.g.b.k.g(paramy, "nicknameTv.paint");
        paramy.setFakeBoldText(true);
        localObject = this.nMV;
        paramy = this.hhf;
        if (paramy != null)
        {
          paramy = paramy.title;
          ((MMNeat7extView)localObject).ar((CharSequence)paramy);
          localObject = this.nMU;
          Context localContext = getContext();
          paramy = this.hhf;
          if (paramy != null)
          {
            paramy = paramy.hkV;
            ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(localContext, (CharSequence)paramy, this.nMU.getTextSize()));
            if (!this.hlH) {
              continue;
            }
            this.CKu.setVisibility(8);
            this.CKw.setVisibility(8);
            localObject = getContext();
            if ((localObject instanceof WebViewUI))
            {
              paramy = this.hhf;
              if (paramy == null) {
                break label311;
              }
              paramy = paramy.hlG;
              if (bs.isNullOrNil(paramy)) {
                break label321;
              }
              paramy = this.hhf;
              if (paramy == null) {
                break label316;
              }
              paramy = paramy.hlG;
              com.tencent.mm.av.a.a.aFG().a(paramy, this.fxQ, new c.a().aFR().pe(2131231342).aFT());
            }
            if (this.CKF) {
              eFT();
            }
            ac.d(this.TAG, "initData");
            eFW();
            AppMethodBeat.o(189471);
          }
        }
        else
        {
          paramy = null;
          continue;
        }
        paramy = null;
        continue;
        this.CKu.setVisibility(0);
        this.CKw.setVisibility(0);
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
      paramy = ((WebViewUI)localObject).eDE();
      if (paramy != null)
      {
        paramy = paramy.bGw();
        if (paramy != null)
        {
          paramy = paramy.drM;
          continue;
        }
      }
      paramy = null;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public final void eFX()
  {
    AppMethodBeat.i(182652);
    if (this.CKA != this.CKz)
    {
      Object localObject = getContext();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(182652);
        throw ((Throwable)localObject);
      }
      ((Activity)localObject).setRequestedOrientation(this.CKA);
      this.CKA = this.CKz;
      this.Cze.disable();
    }
    uC(false);
    AppMethodBeat.o(182652);
  }
  
  public final void eFY()
  {
    AppMethodBeat.i(82634);
    if (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) {
      ac.d(this.TAG, "hideOpLayer %s", new Object[] { bs.eWi() });
    }
    if (!this.CKJ)
    {
      AppMethodBeat.o(82634);
      return;
    }
    this.CKJ = false;
    eFZ();
    AppMethodBeat.o(82634);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(82628);
    Context localContext = getContext();
    if (((localContext instanceof WebViewUI)) && (((WebViewUI)localContext).eEt() != null))
    {
      if (((WebViewUI)localContext).eEt() != null)
      {
        ac.i(this.TAG, "close click");
        eFX();
        ((WebViewUI)localContext).eEt().leaveFullscreen();
        com.tencent.mm.sdk.platformtools.ap.n((Runnable)new a(this), 500L);
        AppMethodBeat.o(82628);
      }
    }
    else {
      ac.w(this.TAG, "should not be here");
    }
    AppMethodBeat.o(82628);
  }
  
  public final void fz(View paramView)
  {
    try
    {
      AppMethodBeat.i(189472);
      d.g.b.k.h(paramView, "view");
      if (this.hhf == null) {
        break label209;
      }
      localObject1 = this.hhf;
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      ((y)localObject1).hlE = this.nLA;
      localObject1 = getContext();
      if (localObject1 == null)
      {
        paramView = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        AppMethodBeat.o(189472);
        throw paramView;
      }
    }
    finally {}
    Object localObject2 = (WebViewUI)localObject1;
    Object localObject1 = ((WebViewUI)localObject2).kYt;
    if (localObject1 != null) {}
    try
    {
      localObject1 = this.CKE;
      localObject2 = ((WebViewUI)localObject2).kYt;
      y localy = this.hhf;
      if (localy == null) {
        d.g.b.k.fOy();
      }
      ((g)localObject1).nOY = ((com.tencent.mm.plugin.webview.stub.e)localObject2).wG(localy.ddo);
      this.CKE.scene = 141;
      this.CKE.nLC = getSubScene$1385f2();
    }
    catch (Exception localException)
    {
      label149:
      break label149;
    }
    this.nPh = System.currentTimeMillis();
    this.nLA = ((int)(this.nPh / 1000L));
    this.CKE.a(this.hhf, 1, this.nLA);
    this.CKE.a(this.hhf, 5, this.nLA);
    this.CKE.hYu = 0;
    label209:
    removeVideoView();
    uC(true);
    this.CKn.setAlpha(1.0F);
    this.CKn.setBackgroundColor(-16777216);
    setVisibility(0);
    localObject1 = new FrameLayout(getContext());
    ((FrameLayout)localObject1).addView(paramView, new ViewGroup.LayoutParams(-1, -2));
    this.CKq = ((ViewGroup)localObject1);
    paramView = this.CKp;
    localObject1 = (View)this.CKq;
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    eFT();
    this.zRU = false;
    ac.d(this.TAG, "addVideoView");
    this.CKD = true;
    eFW();
    AppMethodBeat.o(189472);
  }
  
  public final int getEnterId()
  {
    return this.nLA;
  }
  
  public final long getEnterTimeInMs()
  {
    return this.nPh;
  }
  
  public final boolean getForbidForward()
  {
    return this.hlH;
  }
  
  public final g getMpShareVideoReport()
  {
    return this.CKE;
  }
  
  public final Integer getSubScene()
  {
    return this.CKG;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(82630);
    if (paramView != null)
    {
      if (paramView.getId() == 2131303281) {
        eFV();
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
      ac.d(this.TAG, "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      eGb();
      AppMethodBeat.o(82637);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ac.d(this.TAG, "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
      eGc();
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
    ac.i(this.TAG, "onExitMpVideoFullPage");
    this.CKC = false;
    this.CKD = false;
    if (this.hhf != null)
    {
      this.CKE.nOW = ((int)(System.currentTimeMillis() - this.nPh));
      this.CKE.nOV = ((int)(this.CKy * 1000.0D));
      this.CKE.a(this.hhf, 6, this.nLA);
      this.CKE.a(this.hhf, 2, this.nLA);
      Object localObject = getContext();
      if (((localObject instanceof WebViewUI)) && (((WebViewUI)localObject).Cjc != null))
      {
        localObject = ((WebViewUI)localObject).Cjc;
        y localy = this.hhf;
        if (localy == null) {
          d.g.b.k.fOy();
        }
        ((com.tencent.mm.plugin.webview.c.f)localObject).fc(localy.DWG, (int)this.CKy);
      }
      this.hhf = null;
    }
    AppMethodBeat.o(82629);
  }
  
  public final void setEnterId(int paramInt)
  {
    this.nLA = paramInt;
  }
  
  public final void setEnterTimeInMs(long paramLong)
  {
    this.nPh = paramLong;
  }
  
  public final void setForbidForward(boolean paramBoolean)
  {
    this.hlH = paramBoolean;
  }
  
  public final void setSubScene(Integer paramInteger)
  {
    this.CKG = paramInteger;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82590);
      this.CKM.onExit();
      AppMethodBeat.o(82590);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$fadeOutOpLayout$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(82592);
      d.g.b.k.h(paramAnimation, "animation");
      if (!MPVideoPlayFullScreenView.r(this.CKM)) {
        MPVideoPlayFullScreenView.s(this.CKM);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$handleHorizontalUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class c
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    c(View paramView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82594);
      Object localObject = this.CKN;
      d.g.b.k.g(localObject, "contentRoot");
      ((View)localObject).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      if (com.tencent.mm.compatible.util.d.kZ(24))
      {
        localObject = this.CKM.getContext();
        if (localObject == null)
        {
          localObject = new d.v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(82594);
          throw ((Throwable)localObject);
        }
        if (((Activity)localObject).isInMultiWindowMode())
        {
          MPVideoPlayFullScreenView.t(this.CKM);
          AppMethodBeat.o(82594);
          return;
        }
      }
      int n = com.tencent.mm.ui.ap.ej(this.CKM.getContext());
      int i = com.tencent.mm.cc.a.av(this.CKM.getContext(), 2131165303);
      int j = i * 3;
      int k = i * 4;
      int m = i * 7;
      n = Math.max(n - i * 3, 0);
      MPVideoPlayFullScreenView.u(this.CKM).setPadding(n, i * 2, n - i, i * 2);
      localObject = MPVideoPlayFullScreenView.v(this.CKM).getLayoutParams();
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
      MPVideoPlayFullScreenView.v(this.CKM).setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = MPVideoPlayFullScreenView.w(this.CKM).getLayoutParams();
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
      MPVideoPlayFullScreenView.w(this.CKM).setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = MPVideoPlayFullScreenView.x(this.CKM).getLayoutParams();
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
      MPVideoPlayFullScreenView.x(this.CKM).setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = MPVideoPlayFullScreenView.m(this.CKM);
      if (localObject == null) {
        d.g.b.k.fOy();
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
      RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = MPVideoPlayFullScreenView.m(this.CKM);
      if (localRedesignVideoPlayerSeekBar != null)
      {
        localRedesignVideoPlayerSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(82594);
        return;
      }
      AppMethodBeat.o(82594);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$handleVerticalUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class d
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    d(View paramView) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82595);
      View localView = this.CKN;
      d.g.b.k.g(localView, "contentRoot");
      localView.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      MPVideoPlayFullScreenView.t(this.CKM);
      AppMethodBeat.o(82595);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82596);
      ProgressBar localProgressBar = MPVideoPlayFullScreenView.l(this.CKM);
      if ((localProgressBar != null) && (localProgressBar.getVisibility() == 0))
      {
        localProgressBar = MPVideoPlayFullScreenView.l(this.CKM);
        if (localProgressBar != null) {
          localProgressBar.setVisibility(8);
        }
      }
      if (!MPVideoPlayFullScreenView.n(this.CKM)) {
        MPVideoPlayFullScreenView.k(this.CKM).setVisibility(0);
      }
      AppMethodBeat.o(82596);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class f
    implements au.a
  {
    f(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(82597);
      MPVideoPlayFullScreenView.i(this.CKM);
      AppMethodBeat.o(82597);
      return false;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$initSeekBar$1", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-webview_release"})
  public static final class g
    implements com.tencent.mm.plugin.sight.decode.ui.b
  {
    public final void anR() {}
    
    public final void nn(int paramInt)
    {
      AppMethodBeat.i(82598);
      ac.i(MPVideoPlayFullScreenView.a(this.CKM), "initSeekBar onSeekTo ".concat(String.valueOf(paramInt)));
      u localu = MPVideoPlayFullScreenView.o(this.CKM);
      if (localu != null)
      {
        localu.F(paramInt);
        AppMethodBeat.o(82598);
        return;
      }
      AppMethodBeat.o(82598);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$initVideoController$1", "Lcom/tencent/xweb/VideoJsCallback;", "lastUpdateTime", "", "getLastUpdateTime", "()J", "setLastUpdateTime", "(J)V", "onSetRequestedOrientation", "", "orientation", "", "onVideoEmptied", "", "onVideoEnded", "onVideoEnterFullscreen", "isVideoTag", "id", "width", "", "height", "paused", "seeking", "currentTime", "duration", "buffered", "", "onVideoError", "error", "msg", "", "onVideoExitFullscreen", "onVideoPause", "onVideoPlay", "onVideoPlaying", "onVideoSeeked", "onVideoSeeking", "onVideoSizeUpdate", "onVideoTimeUpdate", "onVideoWaiting", "plugin-webview_release"})
  public static final class h
    implements com.tencent.xweb.v
  {
    private long lastUpdateTime;
    
    public final void blw()
    {
      AppMethodBeat.i(82602);
      ac.i(MPVideoPlayFullScreenView.a(this.CKM), "onVideoEmptied");
      MPVideoPlayFullScreenView.p(this.CKM);
      AppMethodBeat.o(82602);
    }
    
    public final void onVideoEnded()
    {
      AppMethodBeat.i(82600);
      ac.i(MPVideoPlayFullScreenView.a(this.CKM), "onVideoEnded");
      MPVideoPlayFullScreenView.c(this.CKM, false);
      MPVideoPlayFullScreenView.p(this.CKM);
      this.CKM.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.CKM), 7, this.CKM.getEnterId());
      this.CKM.getMpShareVideoReport().hYu = 4;
      AppMethodBeat.o(82600);
    }
    
    public final void onVideoEnterFullscreen(boolean paramBoolean1, long paramLong, double paramDouble1, double paramDouble2, boolean paramBoolean2, boolean paramBoolean3, double paramDouble3, double paramDouble4, double[] paramArrayOfDouble)
    {
      AppMethodBeat.i(82609);
      ac.i(MPVideoPlayFullScreenView.a(this.CKM), "onVideoEnterFullscreen isVideoTag:" + paramBoolean1 + ", id:" + paramLong + ", width:" + paramDouble1 + ", height:" + paramDouble2 + ", paused:" + paramBoolean2 + ", seeking:" + paramBoolean3 + ", currentTime:" + paramDouble3 + ", duration:" + paramDouble4 + ", buffered:" + Arrays.toString(paramArrayOfDouble));
      paramArrayOfDouble = this.CKM;
      if (!paramBoolean2) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        MPVideoPlayFullScreenView.b(paramArrayOfDouble, paramBoolean1);
        MPVideoPlayFullScreenView.c(this.CKM, MPVideoPlayFullScreenView.n(this.CKM));
        if (MPVideoPlayFullScreenView.n(this.CKM))
        {
          this.CKM.getMpShareVideoReport().hYu = 1;
          this.CKM.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.CKM), this.CKM.getMpShareVideoReport().eGg(), this.CKM.getEnterId());
        }
        AppMethodBeat.o(82609);
        return;
      }
    }
    
    public final void onVideoError(int paramInt, String paramString)
    {
      AppMethodBeat.i(82601);
      ac.e(MPVideoPlayFullScreenView.a(this.CKM), "onVideoError " + paramInt + ", " + paramString);
      MPVideoPlayFullScreenView.c(this.CKM, false);
      MPVideoPlayFullScreenView.p(this.CKM);
      this.CKM.getMpShareVideoReport().hYu = 4;
      this.CKM.getMpShareVideoReport().nOX = paramString;
      this.CKM.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.CKM), 11, this.CKM.getEnterId());
      AppMethodBeat.o(82601);
    }
    
    public final void onVideoExitFullscreen()
    {
      AppMethodBeat.i(82610);
      ac.i(MPVideoPlayFullScreenView.a(this.CKM), "onVideoExitFullscreen");
      AppMethodBeat.o(82610);
    }
    
    public final void onVideoPause()
    {
      AppMethodBeat.i(82608);
      ac.i(MPVideoPlayFullScreenView.a(this.CKM), "onVideoPause");
      MPVideoPlayFullScreenView.c(this.CKM, false);
      MPVideoPlayFullScreenView.p(this.CKM);
      if (this.CKM.getMpShareVideoReport().hYu != 3) {
        this.CKM.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.CKM), 8, this.CKM.getEnterId());
      }
      this.CKM.getMpShareVideoReport().hYu = 3;
      AppMethodBeat.o(82608);
    }
    
    public final void onVideoPlay()
    {
      AppMethodBeat.i(82607);
      ac.i(MPVideoPlayFullScreenView.a(this.CKM), "onVideoPlay");
      MPVideoPlayFullScreenView.c(this.CKM, true);
      MPVideoPlayFullScreenView.p(this.CKM);
      if (this.CKM.getMpShareVideoReport().hYu != 2) {
        this.CKM.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.CKM), this.CKM.getMpShareVideoReport().eGg(), this.CKM.getEnterId());
      }
      this.CKM.getMpShareVideoReport().hYu = 2;
      AppMethodBeat.o(82607);
    }
    
    public final void onVideoPlaying()
    {
      AppMethodBeat.i(82603);
      ac.d(MPVideoPlayFullScreenView.a(this.CKM), "onVideoPlaying");
      if (!MPVideoPlayFullScreenView.n(this.CKM))
      {
        MPVideoPlayFullScreenView.c(this.CKM, true);
        MPVideoPlayFullScreenView.p(this.CKM);
      }
      this.CKM.getMpShareVideoReport().hYu = 2;
      AppMethodBeat.o(82603);
    }
    
    public final void onVideoSeeked()
    {
      AppMethodBeat.i(82606);
      ac.i(MPVideoPlayFullScreenView.a(this.CKM), "onVideoSeeked");
      MPVideoPlayFullScreenView.p(this.CKM);
      this.CKM.getMpShareVideoReport().a(MPVideoPlayFullScreenView.g(this.CKM), 13, this.CKM.getEnterId());
      AppMethodBeat.o(82606);
    }
    
    public final void onVideoSeeking()
    {
      AppMethodBeat.i(82605);
      ac.i(MPVideoPlayFullScreenView.a(this.CKM), "onVideoSeeking");
      MPVideoPlayFullScreenView.q(this.CKM);
      AppMethodBeat.o(82605);
    }
    
    public final void onVideoSizeUpdate(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(82612);
      y localy = MPVideoPlayFullScreenView.g(this.CKM);
      if ((localy == null) || (localy.width != 0))
      {
        localy = MPVideoPlayFullScreenView.g(this.CKM);
        if (localy != null) {
          if (localy.height != 0) {
            break label103;
          }
        }
      }
      else
      {
        localy = MPVideoPlayFullScreenView.g(this.CKM);
        if (localy != null) {
          localy.width = ((int)paramDouble1);
        }
        localy = MPVideoPlayFullScreenView.g(this.CKM);
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
        com.tencent.mm.sdk.platformtools.ap.f((Runnable)new a(this, paramDouble2, paramDouble1, paramArrayOfDouble));
      }
      MPVideoPlayFullScreenView.a(this.CKM, paramDouble1);
      MPVideoPlayFullScreenView.p(this.CKM);
      AppMethodBeat.o(82611);
    }
    
    public final void onVideoWaiting()
    {
      AppMethodBeat.i(82604);
      ac.i(MPVideoPlayFullScreenView.a(this.CKM), "onVideoWaiting");
      MPVideoPlayFullScreenView.q(this.CKM);
      AppMethodBeat.o(82604);
    }
    
    public final boolean td(int paramInt)
    {
      return false;
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoPlayFullScreenView.h paramh, double paramDouble1, double paramDouble2, double[] paramArrayOfDouble) {}
      
      public final void run()
      {
        int j = 1;
        AppMethodBeat.i(82599);
        Object localObject = MPVideoPlayFullScreenView.m(this.CKO.CKM);
        if (localObject != null) {
          ((RedesignVideoPlayerSeekBar)localObject).setVideoTotalTime((int)paramDouble2);
        }
        localObject = MPVideoPlayFullScreenView.m(this.CKO.CKM);
        if (localObject != null) {
          ((RedesignVideoPlayerSeekBar)localObject).sQ((int)paramArrayOfDouble);
        }
        localObject = this.CKR;
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
            RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = MPVideoPlayFullScreenView.m(this.CKO.CKM);
            if (localRedesignVideoPlayerSeekBar == null) {
              break label133;
            }
            d.g.b.k.h(localObject, "$this$lastIndex");
            localRedesignVideoPlayerSeekBar.XA((int)localObject[(localObject.length - 1)]);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class i
    implements a.b
  {
    i(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, Context paramContext) {}
    
    public final void a(a.a parama1, a.a parama2)
    {
      AppMethodBeat.i(182651);
      if (MPVideoPlayFullScreenView.y(this.CKM))
      {
        parama1 = this.CKM;
        if (parama2 == null)
        {
          AppMethodBeat.o(182651);
          return;
        }
        switch (b.cfA[parama2.ordinal()])
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
        ((Activity)parama1).setRequestedOrientation(MPVideoPlayFullScreenView.z(this.CKM));
        MPVideoPlayFullScreenView.A(this.CKM);
      }
      AppMethodBeat.o(182651);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onExit"})
  static final class j
    implements e.b
  {
    j(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void onExit()
    {
      AppMethodBeat.i(82613);
      this.CKM.exit();
      AppMethodBeat.o(82613);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "longClickOver"})
  static final class k
    implements e.d
  {
    k(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void aOe()
    {
      AppMethodBeat.i(82614);
      if (!this.CKM.getForbidForward())
      {
        y localy = MPVideoPlayFullScreenView.g(this.CKM);
        if (localy != null)
        {
          Object localObject = f.CLf;
          localObject = this.CKM.getContext();
          d.g.b.k.g(localObject, "context");
          f.a((Context)localObject, localy, 2);
          AppMethodBeat.o(82614);
          return;
        }
      }
      AppMethodBeat.o(82614);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onClick"})
  static final class l
    implements e.f
  {
    l(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(82615);
      if (MPVideoPlayFullScreenView.h(this.CKM).getVisibility() == 0)
      {
        MPVideoPlayFullScreenView.i(this.CKM);
        AppMethodBeat.o(82615);
        return;
      }
      MPVideoPlayFullScreenView.f(this.CKM);
      AppMethodBeat.o(82615);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "tx", "", "ty", "onGalleryScale"})
  static final class m
    implements e.e
  {
    m(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void M(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(82616);
      if ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F))
      {
        MPVideoPlayFullScreenView.f(this.CKM);
        AppMethodBeat.o(82616);
        return;
      }
      if ((Math.abs(paramFloat1) > 10.0F) || (Math.abs(paramFloat2) > 10.0F)) {
        MPVideoPlayFullScreenView.i(this.CKM);
      }
      AppMethodBeat.o(82616);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    public static final n CKS;
    
    static
    {
      AppMethodBeat.i(82618);
      CKS = new n();
      AppMethodBeat.o(82618);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(82617);
      AppMethodBeat.o(82617);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runEnterAnimation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-webview_release"})
  public static final class o
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(82620);
      ac.d(MPVideoPlayFullScreenView.a(this.CKM), "runEnterAnimation");
      Object localObject = MPVideoPlayFullScreenView.b(this.CKM);
      if (localObject != null)
      {
        localObject = ((ViewGroup)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      localObject = MPVideoPlayFullScreenView.b(this.CKM);
      if (localObject != null) {}
      for (localObject = Integer.valueOf(((ViewGroup)localObject).getHeight());; localObject = null)
      {
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        if (((Integer)localObject).intValue() > 0) {
          break;
        }
        MPVideoPlayFullScreenView.c(this.CKM);
        AppMethodBeat.o(82620);
        return;
      }
      MPVideoPlayFullScreenView.d(this.CKM);
      localObject = MPVideoPlayFullScreenView.e(this.CKM);
      if (localObject != null)
      {
        ViewGroup localViewGroup = MPVideoPlayFullScreenView.b(this.CKM);
        if (localViewGroup == null) {
          d.g.b.k.fOy();
        }
        ((com.tencent.mm.ui.tools.e)localObject).a((View)localViewGroup, null, (e.c)new a(this));
        AppMethodBeat.o(82620);
        return;
      }
      AppMethodBeat.o(82620);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runEnterAnimation$1$onGlobalLayout$1", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-webview_release"})
    public static final class a
      implements e.c
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(82619);
        MPVideoPlayFullScreenView.f(this.CKT.CKM);
        AppMethodBeat.o(82619);
      }
      
      public final void onAnimationStart() {}
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/media/MPVideoPlayFullScreenView$runExitAnimation$2", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-webview_release"})
  public static final class p
    implements e.c
  {
    public p(e.c paramc) {}
    
    public final void onAnimationEnd()
    {
      AppMethodBeat.i(82623);
      e.c localc = this.CKU;
      if (localc != null) {
        localc.onAnimationEnd();
      }
      MPVideoPlayFullScreenView.j(this.CKM).post((Runnable)new a(this));
      MPVideoPlayFullScreenView.a(this.CKM, false);
      this.CKM.onExit();
      AppMethodBeat.o(82623);
    }
    
    public final void onAnimationStart()
    {
      AppMethodBeat.i(82622);
      MPVideoPlayFullScreenView.a(this.CKM, true);
      e.c localc = this.CKU;
      if (localc != null)
      {
        localc.onAnimationStart();
        AppMethodBeat.o(82622);
        return;
      }
      AppMethodBeat.o(82622);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoPlayFullScreenView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(82621);
        Object localObject = this.CKW.CKM.getContext();
        if (((localObject instanceof WebViewUI)) && (((WebViewUI)localObject).eEt() != null))
        {
          localObject = this.CKW.CKM.getContext();
          if (localObject == null)
          {
            localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
            AppMethodBeat.o(82621);
            throw ((Throwable)localObject);
          }
          ((WebViewUI)localObject).eEt().leaveFullscreen();
        }
        MPVideoPlayFullScreenView.j(this.CKW.CKM).setLayoutParams(this.CKW.CKV);
        AppMethodBeat.o(82621);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView) {}
    
    public final void run()
    {
      AppMethodBeat.i(82624);
      ProgressBar localProgressBar = MPVideoPlayFullScreenView.l(this.CKM);
      if ((localProgressBar == null) || (localProgressBar.getVisibility() != 0))
      {
        localProgressBar = MPVideoPlayFullScreenView.l(this.CKM);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(MPVideoPlayFullScreenView paramMPVideoPlayFullScreenView, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(82625);
      if (this.CKX) {
        MPVideoPlayFullScreenView.k(this.CKM).setVisibility(8);
      }
      for (;;)
      {
        Object localObject = MPVideoPlayFullScreenView.m(this.CKM);
        if (localObject == null) {
          break;
        }
        ((RedesignVideoPlayerSeekBar)localObject).gL(MPVideoPlayFullScreenView.n(this.CKM));
        AppMethodBeat.o(82625);
        return;
        localObject = MPVideoPlayFullScreenView.l(this.CKM);
        if ((localObject == null) || (((ProgressBar)localObject).getVisibility() != 0)) {
          MPVideoPlayFullScreenView.k(this.CKM).setVisibility(0);
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