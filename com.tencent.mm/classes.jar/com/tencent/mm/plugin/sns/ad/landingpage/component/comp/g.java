package com.tencent.mm.plugin.sns.ad.landingpage.component.comp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.rl;
import com.tencent.mm.plugin.sns.ad.d.e;
import com.tencent.mm.plugin.sns.ad.landingpage.component.view.AdLandingGeneralVideoView;
import com.tencent.mm.plugin.sns.ad.landingpage.component.view.AdLandingGeneralVideoWrapper;
import com.tencent.mm.plugin.sns.ad.landingpage.component.view.AdLandingGeneralVideoWrapper.2;
import com.tencent.mm.plugin.sns.ad.landingpage.component.view.AdLandingGeneralVideoWrapper.a;
import com.tencent.mm.plugin.sns.ad.widget.advideo.AdLandingVideoPlayerSeekBar;
import com.tencent.mm.plugin.sns.ad.widget.advideo.AdLandingVideoPlayerToolBar;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aq;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.12;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends am
  implements AdLandingGeneralVideoWrapper.a
{
  private boolean PQA;
  boolean PQB;
  boolean PQC;
  public boolean PQD;
  private int PQE;
  int PQF;
  int PQG;
  private int PQH;
  int PQI;
  private int PQJ;
  int PQK;
  private aq PQL;
  private View.OnClickListener PQM;
  private View.OnClickListener PQN;
  private a PQO;
  private View.OnClickListener PQP;
  private View.OnClickListener PQQ;
  Runnable PQR;
  private final View.OnLayoutChangeListener PQS;
  int PQr;
  protected View PQs;
  protected AdLandingGeneralVideoWrapper PQt;
  protected ImageView PQu;
  protected AdLandingVideoPlayerToolBar PQv;
  protected AdLandingVideoPlayerSeekBar PQw;
  private boolean PQx;
  private boolean PQy;
  private boolean PQz;
  private boolean isAutoPlay;
  Context mContext;
  protected View maskView;
  
  public g(Context paramContext, f paramf, ViewGroup paramViewGroup)
  {
    super(paramContext, paramf, paramViewGroup);
    AppMethodBeat.i(310735);
    this.PQr = 0;
    this.PQx = false;
    this.PQy = false;
    this.PQz = false;
    this.PQA = true;
    this.isAutoPlay = false;
    this.PQB = true;
    this.PQD = false;
    this.PQE = 0;
    this.PQF = 0;
    this.PQG = 0;
    this.PQH = 0;
    this.PQI = 0;
    this.PQJ = 0;
    this.PQK = 0;
    this.PQL = null;
    this.PQM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(310806);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingGeneralVideoComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(g.this.isPlaying()) });
        g.aN(g.this.PQR);
        if (g.this.isPlaying()) {
          g.this.bck();
        }
        for (g.this.PQr = 4;; g.this.PQr = 3)
        {
          if (g.this.QIM)
          {
            paramAnonymousView = g.this;
            paramAnonymousView.PQF += 1;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingGeneralVideoComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(310806);
          return;
          g.a(g.this);
        }
      }
    };
    this.PQN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(310789);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingGeneralVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (!((f)g.this.QOV).QJt) {
          g.aN(g.this.PQR);
        }
        paramAnonymousView = g.this;
        paramAnonymousView.PQG += 1;
        if (g.this.PQB)
        {
          g.this.hiA();
          g.this.hax();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingGeneralVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(310789);
          return;
          g.this.haw();
        }
      }
    };
    this.PQO = new a()
    {
      public final void Bh(int paramAnonymousInt)
      {
        AppMethodBeat.i(310793);
        if ((((f)g.this.QOV).QJx != null) && (g.this.isPlaying()) && (!g.this.PQC) && (g.this.PQv != null) && (!g.this.PQv.isFullScreen()))
        {
          int i = ((f)g.this.QOV).QJx.QLD;
          g.this.le(i, paramAnonymousInt * 1000);
        }
        AppMethodBeat.o(310793);
      }
    };
    this.PQP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(310690);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingGeneralVideoComponent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        Object localObject2;
        if (!g.this.PQv.isFullScreen())
        {
          g.a(g.this, true);
          paramAnonymousView = (SnsAdNativeLandingPagesUI)g.this.context;
          localObject1 = (f)g.this.QOV;
          localObject2 = g.this.PQt;
          if ((localObject1 == null) || (localObject2 == null))
          {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "enterFullScreenVideo but info or videoViewWrapper is null");
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 3);
          }
        }
        for (;;)
        {
          paramAnonymousView = g.this;
          paramAnonymousView.PQI += 1;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingGeneralVideoComponent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(310690);
          return;
          paramAnonymousView.QUm = true;
          paramAnonymousView.PQt = ((AdLandingGeneralVideoWrapper)localObject2);
          paramAnonymousView.PQt.setFullScreen(paramAnonymousView.QUm);
          Object localObject3 = paramAnonymousView.PQt.getVideoCompContainer();
          localObject2 = paramAnonymousView.PQt.getToolBar();
          ((AdLandingVideoPlayerToolBar)localObject2).Dy(true);
          ((ViewGroup)localObject3).removeView(paramAnonymousView.PQt);
          ((ViewGroup)localObject3).removeView((View)localObject2);
          localObject3 = new FrameLayout(paramAnonymousView);
          ((FrameLayout)localObject3).setBackgroundColor(-16777216);
          ((FrameLayout)localObject3).setClipChildren(false);
          Object localObject4 = new FrameLayout.LayoutParams(-1, -1);
          paramAnonymousView.RlA.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          localObject4 = paramAnonymousView.PQt;
          al localal = ((f)localObject1).QJy;
          FrameLayout localFrameLayout = paramAnonymousView.RlA;
          if ((localal == null) || (localFrameLayout == null) || (Util.isNullOrNil(localal.desc)) || (localal.QLh == null))
          {
            localObject4 = new FrameLayout.LayoutParams(-1, -1);
            ((FrameLayout.LayoutParams)localObject4).gravity = 17;
            ((FrameLayout)localObject3).addView(paramAnonymousView.PQt, (ViewGroup.LayoutParams)localObject4);
            localObject4 = new FrameLayout.LayoutParams(-1, -2);
            ((FrameLayout.LayoutParams)localObject4).gravity = 80;
            ((FrameLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
            localObject2 = ((f)localObject1).QKG;
            androidx.i.a.a.al(paramAnonymousView).unregisterReceiver(paramAnonymousView.Rmb);
            paramAnonymousView.PUc.dead();
            if ((paramAnonymousView.RlK != null) && (paramAnonymousView.RlK.isShowing())) {
              paramAnonymousView.RlK.hap();
            }
            localObject3 = paramAnonymousView.hnN();
            ((ContentFragment)localObject3).ffv = false;
            ((ContentFragment)localObject3).QUm = true;
            ((ContentFragment)localObject3).QUn = ((String)localObject2);
            ((ContentFragment)localObject3).QUb.ffv = ((ContentFragment)localObject3).ffv;
            if ((((ContentFragment)localObject3).QUb != null) && (((ContentFragment)localObject3).getUserVisibleHint())) {
              ((ContentFragment)localObject3).QUb.b(((ContentFragment)localObject3).QTX, ((ContentFragment)localObject3).QUn);
            }
            paramAnonymousView.getSwipeBackLayout().setEnableGesture(false);
            paramAnonymousView.PQt.Dp(true);
            paramAnonymousView.PQt.setAnimImmediately(false);
            if (!((f)localObject1).QJw) {
              break label578;
            }
            paramAnonymousView.PQt.ajv(90);
            MMHandlerThread.postToMainThreadDelayed(new SnsAdNativeLandingPagesUI.12(paramAnonymousView, (f)localObject1), 5000L);
            break;
          }
          if (((AdLandingGeneralVideoWrapper)localObject4).PSV == null) {
            ((AdLandingGeneralVideoWrapper)localObject4).PSV = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g(((AdLandingGeneralVideoWrapper)localObject4).getContext(), localal, localFrameLayout, 1);
          }
          for (;;)
          {
            ((AdLandingGeneralVideoWrapper)localObject4).PSV.orientation = 0;
            break;
            ((AdLandingGeneralVideoWrapper)localObject4).PSV.refreshView();
          }
          label578:
          com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a.hbb().start(((f)localObject1).QKG);
          break;
          g.a(g.this, false);
          ((SnsAdNativeLandingPagesUI)g.this.context).hnE();
        }
      }
    };
    this.PQQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(310783);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingGeneralVideoComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        g.this.PQr = 3;
        paramAnonymousView = g.this;
        paramAnonymousView.PQK += 1;
        g.this.PQu.setVisibility(8);
        g.a(g.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingGeneralVideoComponent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(310783);
      }
    };
    this.PQR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310800);
        g.this.setFocus(false);
        AppMethodBeat.o(310800);
      }
    };
    this.PQS = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(310786);
        if ((g.this.PQt == null) || (paramAnonymousView == null))
        {
          AppMethodBeat.o(310786);
          return;
        }
        paramAnonymousInt1 = paramAnonymousView.getHeight();
        paramAnonymousInt2 = paramAnonymousView.getWidth();
        if ((paramAnonymousInt2 <= 1) || (paramAnonymousInt1 <= 1))
        {
          AppMethodBeat.o(310786);
          return;
        }
        paramAnonymousView = g.this.PQt.getThumbView();
        if (paramAnonymousView != null)
        {
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramAnonymousInt2, paramAnonymousInt1);
          localLayoutParams.addRule(13);
          paramAnonymousView.setLayoutParams(localLayoutParams);
          paramAnonymousView.removeOnLayoutChangeListener(this);
          Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "thumb onLayout change, videoW is " + paramAnonymousInt2 + ", videoH is " + paramAnonymousInt1);
        }
        AppMethodBeat.o(310786);
      }
    };
    this.mContext = paramContext;
    this.PQL = new aq()
    {
      public final void Do(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(310774);
        Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
        if (paramAnonymousBoolean) {}
        for (int i = 1;; i = 0)
        {
          localIntent.putExtra("show", i);
          localIntent.putExtra("activity_code", g.this.hiB());
          androidx.i.a.a.al(g.this.mContext).d(localIntent);
          AppMethodBeat.o(310774);
          return;
        }
      }
    };
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 6);
    AppMethodBeat.o(310735);
  }
  
  private void Dh(boolean paramBoolean)
  {
    AppMethodBeat.i(310784);
    if (this.PQB) {
      haw();
    }
    for (;;)
    {
      this.PQu.setVisibility(8);
      this.PQt.drB();
      AppMethodBeat.o(310784);
      return;
      if (paramBoolean) {
        hiA();
      }
      hax();
    }
  }
  
  static void aN(Runnable paramRunnable)
  {
    AppMethodBeat.i(310772);
    MMHandlerThread.removeRunnable(paramRunnable);
    MMHandlerThread.postToMainThreadDelayed(paramRunnable, 4000L);
    AppMethodBeat.o(310772);
  }
  
  private void as(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(310760);
    if ((this.PQt != null) && (this.PQu != null))
    {
      this.PQu.setVisibility(8);
      if ((!isPlaying()) && (paramBoolean)) {
        this.PQt.haG();
      }
      this.PQt.X(paramInt, paramBoolean);
    }
    AppMethodBeat.o(310760);
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(310855);
    this.PQs = this.contentView.findViewById(b.f.content_root);
    this.PQt = ((AdLandingGeneralVideoWrapper)this.PQs.findViewById(b.f.video_view));
    this.maskView = this.PQs.findViewById(b.f.sns_ad_native_landing_pages_sight_background);
    this.PQu = ((ImageView)this.PQs.findViewById(b.f.status_btn));
    Object localObject1;
    Object localObject2;
    AdLandingGeneralVideoWrapper localAdLandingGeneralVideoWrapper;
    if ((this.PQs == null) || (this.PQt == null))
    {
      Log.e("MicroMsg.Sns.AdLandingGeneralVideoComponent", "mVideoContainer or mVideoViewWrapper is null");
      this.PQt.a(this);
      this.PQt.setPlayerMode(((f)this.QOV).QJq);
      localObject1 = com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a.hbb();
      localObject2 = ((f)this.QOV).QKG;
      localAdLandingGeneralVideoWrapper = this.PQt;
      if ((localAdLandingGeneralVideoWrapper != null) && (!Util.isNullOrNil((String)localObject2))) {
        break label1614;
      }
      Log.e("ScreenSwitchManager", "componentId or view is null");
      label160:
      this.PQv = new AdLandingVideoPlayerToolBar(this.mContext);
      this.PQt.a(this.PQv);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((ViewGroup)this.PQs).addView(this.PQv, (ViewGroup.LayoutParams)localObject1);
      this.PQt.setVideoToolBar(this.PQv);
      this.PQt.setVideoContainer((ViewGroup)this.PQs);
      this.PQv.setVisibility(4);
      if (((f)this.QOV).QJt) {
        this.PQv.hcD();
      }
      this.PQv.setOnVoiceButtonClickListener(this.PQN);
      this.PQv.setUpdateTimeListener(this.PQO);
      this.PQv.setOnFullScreenClickListener(this.PQP);
      this.PQu.setOnClickListener(this.PQQ);
      this.PQw = this.PQv.getSeekBar();
      if (this.PQw != null)
      {
        this.PQw.setIplaySeekCallback(this.PQt);
        this.PQw.setOnPlayButtonClickListener(this.PQM);
      }
      if (this.PQL != null) {
        this.PQL.Do(false);
      }
      localObject1 = k.mC("adId", ((f)this.QOV).thumbUrl);
      if (y.ZC((String)localObject1))
      {
        this.PQx = true;
        Log.d("MicroMsg.Sns.AdLandingGeneralVideoComponent", "thumb resource is exist");
      }
      if (!this.PQx) {
        break label1689;
      }
      this.PQt.setCover(BitmapUtil.decodeFile((String)localObject1));
    }
    for (;;)
    {
      boolean bool = e.gZH();
      if (y.ZC(k.hkC() + "AdLandingGeneralVideo_" + e.cO(((f)this.QOV).videoUrl, bool).hashCode() + ".mp4"))
      {
        this.PQy = true;
        Log.d("MicroMsg.Sns.AdLandingGeneralVideoComponent", "video resource is exist");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 8);
      }
      this.PQt.aWA(((f)this.QOV).videoUrl);
      AppMethodBeat.o(310855);
      return;
      localObject1 = this.PQt.getVideoView();
      if (localObject1 == null)
      {
        Log.e("MicroMsg.Sns.AdLandingGeneralVideoComponent", "videoView is null");
        break;
      }
      this.PQs.setPadding((int)((f)this.QOV).paddingLeft, (int)((f)this.QOV).paddingTop, (int)((f)this.QOV).paddingRight, (int)((f)this.QOV).paddingBottom);
      int j;
      if (((f)this.QOV).QHE == 0) {
        if ((((f)this.QOV).width > 0.0F) && (((f)this.QOV).height > 0.0F))
        {
          i = (int)((f)this.QOV).width;
          j = (int)((f)this.QOV).height;
          localObject2 = new RelativeLayout.LayoutParams(i, j);
          ((RelativeLayout.LayoutParams)localObject2).addRule(13);
          Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "createView, displayType = " + ((f)this.QOV).QHE + ", containerW = " + i + ", containerH = " + j + ", padding = " + m.jr(this.PQs));
          ((AdLandingGeneralVideoView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.PQt.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.PQs.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          label792:
          this.PQt.z(((f)this.QOV).width, ((f)this.QOV).height, this.sJv, this.pvg);
          localObject1 = (f)this.QOV;
          if ((((f)localObject1).paddingLeft == 0.0F) && (((f)localObject1).paddingTop == 0.0F) && (((f)localObject1).paddingRight == 0.0F) && (((f)localObject1).paddingBottom == 0.0F)) {
            break label1564;
          }
        }
      }
      label1564:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label1567;
        }
        localObject1 = this.PQt.getInnerVideoView();
        if (!(localObject1 instanceof VideoPlayerTextureView)) {
          break label1569;
        }
        ((View)localObject1).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
        {
          public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            AppMethodBeat.i(310788);
            try
            {
              paramAnonymousInt1 = paramAnonymousView.getHeight();
              paramAnonymousInt2 = paramAnonymousView.getWidth();
              paramAnonymousInt3 = g.this.PQs.getWidth();
              paramAnonymousInt4 = g.this.PQs.getHeight();
              if ((paramAnonymousInt2 <= 1) || (paramAnonymousInt1 <= 1) || (paramAnonymousInt3 == 0) || (paramAnonymousInt4 == 0))
              {
                AppMethodBeat.o(310788);
                return;
              }
              Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "onLayoutChange, video.w=" + paramAnonymousView.getWidth() + ", h=" + paramAnonymousView.getHeight() + ", container.w=" + paramAnonymousInt3 + ", h=" + paramAnonymousInt4 + ", container.padding=" + m.jr(g.this.PQs));
              paramAnonymousView = g.this.PQt.getThumbView();
              if (paramAnonymousView != null)
              {
                RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramAnonymousInt2, paramAnonymousInt1);
                localLayoutParams.addRule(13);
                paramAnonymousView.setLayoutParams(localLayoutParams);
              }
              if (paramAnonymousInt1 == paramAnonymousInt4)
              {
                this.PQU.removeOnLayoutChangeListener(this);
                AppMethodBeat.o(310788);
                return;
              }
              if ((paramAnonymousInt1 >= paramAnonymousInt2) && (paramAnonymousInt4 >= paramAnonymousInt3) && (Math.abs(paramAnonymousInt1 - paramAnonymousInt4) < 2))
              {
                paramAnonymousView = g.this.PQs.getLayoutParams();
                paramAnonymousView.height = paramAnonymousInt1;
                g.this.PQs.setLayoutParams(paramAnonymousView);
                Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "onLayoutChange, reset VideoContainer.height");
              }
              this.PQU.removeOnLayoutChangeListener(this);
              AppMethodBeat.o(310788);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              Log.e("MicroMsg.Sns.AdLandingGeneralVideoComponent", "onLayoutChange, exp=" + paramAnonymousView.toString());
              AppMethodBeat.o(310788);
            }
          }
        });
        break;
        ((AdLandingGeneralVideoView)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.sJv, this.pvg));
        this.PQt.setLayoutParams(new RelativeLayout.LayoutParams(this.sJv, this.pvg));
        this.PQs.setLayoutParams(new RelativeLayout.LayoutParams(this.sJv, this.pvg));
        break label792;
        if (((f)this.QOV).QHE == 1)
        {
          if (((f)this.QOV).width / this.sJv > ((f)this.QOV).height / this.pvg)
          {
            j = this.sJv;
            i = (int)(j * ((f)this.QOV).height / ((f)this.QOV).width) + 1;
          }
          for (;;)
          {
            localObject2 = new RelativeLayout.LayoutParams(j, i);
            ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((this.sJv - j) / 2);
            ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((RelativeLayout.LayoutParams)localObject2).leftMargin;
            ((RelativeLayout.LayoutParams)localObject2).topMargin = ((this.pvg - i) / 2);
            ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((RelativeLayout.LayoutParams)localObject2).topMargin;
            Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "createView, displayType = " + ((f)this.QOV).QHE + ", containerW = " + j + ", containerH = " + i + ", padding = " + m.jr(this.PQs));
            ((AdLandingGeneralVideoView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            this.PQt.setLayoutParams(new RelativeLayout.LayoutParams(this.sJv, this.pvg));
            this.PQs.setLayoutParams(new RelativeLayout.LayoutParams(this.sJv, this.pvg));
            break;
            i = this.pvg;
            j = (int)(i * ((f)this.QOV).width / ((f)this.QOV).height) + 1;
          }
        }
        if (((f)this.QOV).QHE != 2) {
          break label792;
        }
        if (((f)this.QOV).width / this.sJv < ((f)this.QOV).height / this.pvg)
        {
          j = this.sJv;
          i = (int)(j * ((f)this.QOV).height / ((f)this.QOV).width) + 1;
        }
        for (;;)
        {
          localObject2 = this.PQt.getThumbView();
          if (localObject2 != null) {
            ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
          }
          localObject2 = new RelativeLayout.LayoutParams(j, i);
          Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "createView, displayType = " + ((f)this.QOV).QHE + ", containerW = " + j + ", containerH = " + i + ", padding = " + m.jr(this.PQs));
          ((AdLandingGeneralVideoView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((AdLandingGeneralVideoView)localObject1).setScaleType(i.e.XYN);
          this.PQt.setLayoutParams(new RelativeLayout.LayoutParams(this.sJv, this.pvg));
          this.PQs.setLayoutParams(new RelativeLayout.LayoutParams(this.sJv, this.pvg));
          break;
          i = this.pvg;
          j = (int)(i * ((f)this.QOV).width / ((f)this.QOV).height) + 1;
        }
      }
      label1567:
      break;
      label1569:
      Log.e("MicroMsg.Sns.AdLandingGeneralVideoComponent", "onLayoutChange, innerVideoView=" + localObject1 + ", displayType=" + ((f)this.QOV).QHE);
      break;
      label1614:
      WeakReference localWeakReference = new WeakReference(localAdLandingGeneralVideoWrapper);
      ((com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a)localObject1).PUC.put(localObject2, localWeakReference);
      localObject2 = localAdLandingGeneralVideoWrapper.getContext();
      if (localObject2 == null)
      {
        Log.e("ScreenSwitchManager", "view getContext is null");
        break label160;
      }
      if (((com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a)localObject1).PUE != null) {
        break label160;
      }
      ((com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a)localObject1).PUE = new com.tencent.mm.plugin.mmsight.model.d((Context)localObject2);
      break label160;
      label1689:
      k.b("adId", ((f)this.QOV).thumbUrl, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a()
      {
        public final void aWn(String paramAnonymousString)
        {
          AppMethodBeat.i(310798);
          g.this.PQt.setCover(BitmapUtil.decodeFile(paramAnonymousString));
          AppMethodBeat.o(310798);
        }
        
        public final void gZM() {}
        
        public final void gZN() {}
      });
    }
  }
  
  public final void aWx(String paramString)
  {
    AppMethodBeat.i(311066);
    if (this.QIK != null) {
      this.QIK.hbe();
    }
    AdLandingGeneralVideoWrapper localAdLandingGeneralVideoWrapper = this.PQt;
    if (localAdLandingGeneralVideoWrapper.vZw != null) {
      localAdLandingGeneralVideoWrapper.vZw.a(localAdLandingGeneralVideoWrapper);
    }
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "player callback onVideoPlay, %s", new Object[] { paramString });
    AppMethodBeat.o(311066);
  }
  
  public final void aWy(String paramString)
  {
    AppMethodBeat.i(311075);
    this.PQt.haF();
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "player callback onVideoPause, %s", new Object[] { paramString });
    AppMethodBeat.o(311075);
  }
  
  public final boolean bP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(311012);
    if (!super.bP(paramJSONObject))
    {
      AppMethodBeat.o(311012);
      return false;
    }
    try
    {
      int i = this.PQt.getPlayTimeInterval();
      paramJSONObject.put("videoDuration", this.PQt.getVideoDurationSec());
      paramJSONObject.put("playTimeInterval", i);
      paramJSONObject.put("playCount", this.PQt.getPlayCount());
      paramJSONObject.put("playCompletedCount", this.PQE);
      paramJSONObject.put("clickFullscreenBtnCount", this.PQI);
      paramJSONObject.put("doubleClickCount", this.PQH);
      paramJSONObject.put("clickPlayControlCount", this.PQF);
      paramJSONObject.put("clickVoiceControlCount", this.PQG);
      paramJSONObject.put("clickSightCount", this.PQJ);
      paramJSONObject.put("clickSightIconCount", this.PQK);
      if (this.isAutoPlay) {}
      for (Object localObject = "1";; localObject = "0")
      {
        paramJSONObject.put("isAutoPlay", localObject);
        JSONObject localJSONObject1;
        if (!this.PQx)
        {
          localObject = MD5Util.getMD5String(((f)this.QOV).thumbUrl);
          localJSONObject1 = new JSONObject();
          localJSONObject1.put("urlMd5", localObject);
          localJSONObject1.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject1);
        }
        if (!this.PQy)
        {
          localObject = MD5Util.getMD5String(((f)this.QOV).videoUrl);
          localJSONObject1 = new JSONObject();
          localJSONObject1.put("urlMd5", localObject);
          localJSONObject1.put("needDownload", 1);
          paramJSONObject.put("videoUrlInfo", localJSONObject1);
        }
        localObject = this.PQt.getAdLandingVideoFullScreenFloatBarReportInfo();
        if (localObject != null)
        {
          localJSONObject1 = new JSONObject();
          localJSONObject1.put("cid", ((com.tencent.mm.plugin.sns.ad.g.a.a)localObject).PXz);
          localJSONObject1.put("exposureCount", ((com.tencent.mm.plugin.sns.ad.g.a.a)localObject).PXA);
          localJSONObject1.put("stayTime", ((com.tencent.mm.plugin.sns.ad.g.a.a)localObject).PXB);
          localJSONObject1.put("clickCount", ((com.tencent.mm.plugin.sns.ad.g.a.a)localObject).PXC);
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("exposureCount", ((com.tencent.mm.plugin.sns.ad.g.a.a)localObject).PXy);
          localJSONObject2.put("stayTime", ((com.tencent.mm.plugin.sns.ad.g.a.a)localObject).hTS);
          localJSONObject2.put("clickCount", ((com.tencent.mm.plugin.sns.ad.g.a.a)localObject).clickCount);
          localJSONObject2.put("btnInfo", localJSONObject1);
          paramJSONObject.put("fullVideoFloatBarInfo", localJSONObject2);
        }
        long l = hjj();
        com.tencent.mm.plugin.sns.ad.d.h.a(142, hjn(), l, i, "MicroMsg.Sns.AdLandingGeneralVideoComponent");
        AppMethodBeat.o(311012);
        return true;
      }
      return false;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.Sns.AdLandingGeneralVideoComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(311012);
    }
  }
  
  protected final void bck()
  {
    AppMethodBeat.i(310879);
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "pause play");
    AdLandingGeneralVideoWrapper localAdLandingGeneralVideoWrapper = this.PQt;
    MMHandlerThread.postToMainThread(new AdLandingGeneralVideoWrapper.2(localAdLandingGeneralVideoWrapper));
    if (localAdLandingGeneralVideoWrapper.LJG != 0L)
    {
      localAdLandingGeneralVideoWrapper.PSW = ((int)(localAdLandingGeneralVideoWrapper.PSW + (System.currentTimeMillis() - localAdLandingGeneralVideoWrapper.LJG)));
      localAdLandingGeneralVideoWrapper.LJG = 0L;
    }
    AppMethodBeat.o(310879);
  }
  
  public final void blc()
  {
    AppMethodBeat.i(311041);
    aN(this.PQR);
    AppMethodBeat.o(311041);
  }
  
  public final void dSW()
  {
    AppMethodBeat.i(310918);
    bck();
    this.PQr = 4;
    AppMethodBeat.o(310918);
  }
  
  public final void dSX()
  {
    AppMethodBeat.i(310932);
    this.PQr = 3;
    Dh(false);
    AppMethodBeat.o(310932);
  }
  
  public final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_general_video;
  }
  
  public final boolean haA()
  {
    AppMethodBeat.i(311112);
    if (((f)this.QOV).QJt)
    {
      AppMethodBeat.o(311112);
      return true;
    }
    aN(this.PQR);
    this.PQH += 1;
    if (isPlaying()) {
      bck();
    }
    for (this.PQr = 4;; this.PQr = 3)
    {
      AppMethodBeat.o(311112);
      return true;
      Dh(true);
    }
  }
  
  public final void hao()
  {
    AppMethodBeat.i(310942);
    super.hao();
    AppMethodBeat.o(310942);
  }
  
  public final void hap()
  {
    AppMethodBeat.i(310969);
    super.hap();
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "viewWillDisappear, before handleType = " + this.PQr);
    bck();
    if ((!this.PQz) && (!this.PQA))
    {
      AppMethodBeat.o(310969);
      return;
    }
    this.PQA = false;
    this.PQz = false;
    if ((this.PQr == 1) || (this.PQr == 3)) {
      this.PQr = 2;
    }
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "viewWillDisappear, after handleType = " + this.PQr);
    AppMethodBeat.o(310969);
  }
  
  public final void haq()
  {
    AppMethodBeat.i(310959);
    super.haq();
    int i = hjh();
    int j = getView().getHeight();
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i <= 0) || (j == 0))
    {
      AppMethodBeat.o(310959);
      return;
    }
    if (i >= j * 0.5F)
    {
      if ((this.PQz) && (!this.PQA))
      {
        AppMethodBeat.o(310959);
        return;
      }
      this.PQz = true;
      this.PQA = false;
      Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "viewAppeared, inScreenHeight over 0.5 percent, before handleType = " + this.PQr);
      if (this.PQr == 0)
      {
        i = (int)hjn().QLA / 1000;
        if ((this.context instanceof SnsAdNativeLandingPagesUI))
        {
          ((SnsAdNativeLandingPagesUI)this.context).hnD();
          Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "snsId = " + hjn().getSnsId() + ", cid = " + ((f)this.QOV).QKG + ", isFirstSightVideoComp = " + this.PQD);
          if ((this.PQD) && (i > 0))
          {
            this.PQr = 1;
            as(i, true);
            this.isAutoPlay = true;
            AppMethodBeat.o(310959);
            return;
          }
        }
        if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (!((f)this.QOV).QJu))
        {
          i = 1;
          if (i == 0) {
            break label346;
          }
          Dh(false);
          this.PQr = 1;
          this.isAutoPlay = true;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "viewAppeared, inScreenHeight over 0.5 percent, after handleType = " + this.PQr);
        AppMethodBeat.o(310959);
        return;
        i = 0;
        break;
        label346:
        this.PQu.setVisibility(0);
        this.isAutoPlay = false;
        AppMethodBeat.o(310959);
        return;
        if (this.PQr == 2)
        {
          Dh(false);
          this.PQr = 1;
        }
      }
    }
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "viewAppeared, inScreenHeight less 0.5 percent, before handleType = " + this.PQr);
    this.PQA = false;
    this.PQz = false;
    bck();
    if ((this.PQr == 1) || (this.PQr == 3)) {
      this.PQr = 2;
    }
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "viewAppeared, inScreenHeight less 0.5 percent, after handleType = " + this.PQr);
    AppMethodBeat.o(310959);
  }
  
  public final void has()
  {
    AppMethodBeat.i(310981);
    super.has();
    MMHandlerThread.removeRunnable(this.PQR);
    this.PQt.haF();
    this.PQt.onUIDestroy();
    AppMethodBeat.o(310981);
  }
  
  public final void hav()
  {
    AppMethodBeat.i(310865);
    as(0, false);
    AppMethodBeat.o(310865);
  }
  
  public final void haw()
  {
    AppMethodBeat.i(310889);
    super.haw();
    this.PQv.Dx(false);
    this.PQt.setMute(true);
    this.PQB = true;
    AppMethodBeat.o(310889);
  }
  
  public final void hax()
  {
    AppMethodBeat.i(310899);
    super.hax();
    this.PQv.Dx(true);
    this.PQt.setMute(false);
    this.PQB = false;
    AppMethodBeat.o(310899);
  }
  
  public final void hay()
  {
    AppMethodBeat.i(311097);
    this.PQE += 1;
    if (this.QIK != null) {
      this.QIK.PUG = true;
    }
    if ((((f)this.QOV).QJx != null) && (!this.PQC) && (this.PQv != null) && (!this.PQv.isFullScreen()))
    {
      int i = this.PQt.getVideoDurationSec() * 1000;
      int j = ((f)this.QOV).QJx.QLD;
      Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "OpenSnsAdFloatPageEvent, onLoopCompletion totalMs = " + i + ", floatStartTime = " + j + ", hasShowFloat = " + this.PQC);
      le(i, j);
    }
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "player callback onLoopCompletion");
    AppMethodBeat.o(311097);
  }
  
  public final boolean haz()
  {
    AppMethodBeat.i(311106);
    if (((f)this.QOV).QJt)
    {
      AppMethodBeat.o(311106);
      return true;
    }
    this.PQJ += 1;
    int i;
    if ((this.PQv != null) && (this.PQv.getVisibility() == 0))
    {
      i = 1;
      if (i != 0) {
        break label80;
      }
    }
    label80:
    for (boolean bool = true;; bool = false)
    {
      setFocus(bool);
      AppMethodBeat.o(311106);
      return true;
      i = 0;
      break;
    }
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(310989);
    if ((this.PQt != null) && (this.PQt.isPlaying()))
    {
      AppMethodBeat.o(310989);
      return true;
    }
    AppMethodBeat.o(310989);
    return false;
  }
  
  final void le(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(311030);
    if (paramInt1 <= paramInt2)
    {
      this.PQC = true;
      rl localrl = new rl();
      localrl.hUy.hUz = ((f)this.QOV).QJx.hUz;
      localrl.publish();
    }
    AppMethodBeat.o(311030);
  }
  
  protected final void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(310910);
    if (paramBoolean)
    {
      this.PQt.Dq(paramBoolean);
      this.PQv.setVisibility(0);
      this.maskView.setVisibility(0);
      if (this.PQL != null) {
        this.PQL.Do(true);
      }
      aN(this.PQR);
      AppMethodBeat.o(310910);
      return;
    }
    this.PQv.setVisibility(4);
    this.maskView.setVisibility(4);
    if (this.PQL != null) {
      this.PQL.Do(false);
    }
    this.PQt.Dq(paramBoolean);
    MMHandlerThread.removeRunnable(this.PQR);
    AppMethodBeat.o(310910);
  }
  
  public final void tS(int paramInt)
  {
    AppMethodBeat.i(311051);
    as(paramInt, true);
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "player callback onSeekTo time ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(311051);
  }
  
  public static abstract interface a
  {
    public abstract void Bh(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.comp.g
 * JD-Core Version:    0.7.0.1
 */