package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

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
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.py;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.ad.landingpage.component.view.AdLandingGeneralVideoWrapper;
import com.tencent.mm.plugin.sns.ad.landingpage.component.view.AdLandingGeneralVideoWrapper.2;
import com.tencent.mm.plugin.sns.ad.landingpage.component.view.AdLandingGeneralVideoWrapper.a;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.c.a.a;
import com.tencent.mm.plugin.sns.ad.widget.advideo.AdLandingVideoPlayerSeekBar;
import com.tencent.mm.plugin.sns.ad.widget.advideo.AdLandingVideoPlayerToolBar;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.9;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj
  implements AdLandingGeneralVideoWrapper.a
{
  int JAI;
  protected View JAJ;
  protected AdLandingGeneralVideoWrapper JAK;
  protected ImageView JAL;
  protected AdLandingVideoPlayerToolBar JAM;
  protected AdLandingVideoPlayerSeekBar JAN;
  private boolean JAO;
  private boolean JAP;
  private boolean JAQ;
  private boolean JAR;
  boolean JAS;
  boolean JAT;
  public boolean JAU;
  private boolean JAV;
  private int JAW;
  int JAX;
  int JAY;
  private int JAZ;
  int JBa;
  private int JBb;
  int JBc;
  private an JBd;
  private View.OnClickListener JBe;
  private View.OnClickListener JBf;
  private a JBg;
  private View.OnClickListener JBh;
  private View.OnClickListener JBi;
  float JBj;
  float JBk;
  Runnable JBl;
  private boolean isAutoPlay;
  Context mContext;
  protected View maskView;
  
  public f(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f paramf, ViewGroup paramViewGroup)
  {
    super(paramContext, paramf, paramViewGroup);
    AppMethodBeat.i(243790);
    this.JAI = 0;
    this.JAO = false;
    this.JAP = false;
    this.JAQ = false;
    this.JAR = true;
    this.isAutoPlay = false;
    this.JAS = true;
    this.JAU = false;
    this.JAW = 0;
    this.JAX = 0;
    this.JAY = 0;
    this.JAZ = 0;
    this.JBa = 0;
    this.JBb = 0;
    this.JBc = 0;
    this.JBd = null;
    this.JBe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(214127);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingGeneralVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(f.this.isPlaying()) });
        f.aE(f.this.JBl);
        if (f.this.isPlaying()) {
          f.this.dmi();
        }
        for (f.this.JAI = 4;; f.this.JAI = 3)
        {
          if (f.this.KkF)
          {
            paramAnonymousView = f.this;
            paramAnonymousView.JAX += 1;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingGeneralVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(214127);
          return;
          f.a(f.this);
        }
      }
    };
    this.JBf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198067);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingGeneralVideoComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)f.this.KqB).Klm) {
          f.aE(f.this.JBl);
        }
        paramAnonymousView = f.this;
        paramAnonymousView.JAY += 1;
        if (f.this.JAS)
        {
          f.this.fQC();
          f.this.fKs();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingGeneralVideoComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198067);
          return;
          f.this.fKr();
        }
      }
    };
    this.JBg = new a()
    {
      public final void AS(int paramAnonymousInt)
      {
        AppMethodBeat.i(219350);
        if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)f.this.KqB).Klq != null) && (f.this.isPlaying()) && (!f.this.JAT) && (f.this.JAM != null) && (!f.this.JAM.QT()))
        {
          int i = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)f.this.KqB).Klq.Knx;
          f.this.jv(i, paramAnonymousInt * 1000);
        }
        AppMethodBeat.o(219350);
      }
    };
    this.JBh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(253174);
        Object localObject1 = new b();
        ((b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingGeneralVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
        Object localObject2;
        if (!f.this.JAM.QT())
        {
          paramAnonymousView = (SnsAdNativeLandingPagesUI)f.this.context;
          localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)f.this.KqB;
          localObject2 = f.this.JAK;
          if ((localObject1 == null) || (localObject2 == null))
          {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "enterFullScreenVideo but info or videoViewWrapper is null");
            com.tencent.mm.plugin.report.service.h.IzE.el(1720, 3);
          }
        }
        for (;;)
        {
          paramAnonymousView = f.this;
          paramAnonymousView.JBa += 1;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingGeneralVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(253174);
          return;
          paramAnonymousView.KvC = true;
          paramAnonymousView.JAK = ((AdLandingGeneralVideoWrapper)localObject2);
          paramAnonymousView.JAK.setFullScreen(paramAnonymousView.KvC);
          Object localObject3 = paramAnonymousView.JAK.getVideoCompContainer();
          localObject2 = paramAnonymousView.JAK.getToolBar();
          ((AdLandingVideoPlayerToolBar)localObject2).yt(true);
          ((ViewGroup)localObject3).removeView(paramAnonymousView.JAK);
          ((ViewGroup)localObject3).removeView((View)localObject2);
          localObject3 = new FrameLayout(paramAnonymousView);
          ((FrameLayout)localObject3).setBackgroundColor(-16777216);
          ((FrameLayout)localObject3).setClipChildren(false);
          Object localObject4 = new FrameLayout.LayoutParams(-1, -1);
          paramAnonymousView.KLO.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          localObject4 = paramAnonymousView.JAK;
          ak localak = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).Klr;
          FrameLayout localFrameLayout = paramAnonymousView.KLO;
          if ((localak == null) || (localFrameLayout == null) || (Util.isNullOrNil(localak.desc)) || (localak.Knc == null))
          {
            localObject4 = new FrameLayout.LayoutParams(-1, -1);
            ((FrameLayout.LayoutParams)localObject4).gravity = 17;
            ((FrameLayout)localObject3).addView(paramAnonymousView.JAK, (ViewGroup.LayoutParams)localObject4);
            localObject4 = new FrameLayout.LayoutParams(-1, -2);
            ((FrameLayout.LayoutParams)localObject4).gravity = 80;
            ((FrameLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
            localObject2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).KmB;
            androidx.h.a.a.V(paramAnonymousView).unregisterReceiver(paramAnonymousView.KMo);
            EventCenter.instance.removeListener(paramAnonymousView.KMu);
            if ((paramAnonymousView.KLY != null) && (paramAnonymousView.KLY.isShowing())) {
              paramAnonymousView.KLY.fKl();
            }
            localObject3 = paramAnonymousView.fVx();
            ((ContentFragment)localObject3).dgo = false;
            ((ContentFragment)localObject3).KvC = true;
            ((ContentFragment)localObject3).KvD = ((String)localObject2);
            ((ContentFragment)localObject3).Kvr.dgo = ((ContentFragment)localObject3).dgo;
            if ((((ContentFragment)localObject3).Kvr != null) && (((ContentFragment)localObject3).getUserVisibleHint())) {
              ((ContentFragment)localObject3).Kvr.b(((ContentFragment)localObject3).Kvn, ((ContentFragment)localObject3).KvD);
            }
            paramAnonymousView.getSwipeBackLayout().setEnableGesture(false);
            paramAnonymousView.JAK.fKB();
            paramAnonymousView.JAK.setAnimImmediately(false);
            if (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).Klp) {
              break label573;
            }
            paramAnonymousView.JAK.aeN(90);
            MMHandlerThread.postToMainThreadDelayed(new SnsAdNativeLandingPagesUI.9(paramAnonymousView, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1), 5000L);
            break;
          }
          if (((AdLandingGeneralVideoWrapper)localObject4).JCx == null) {
            ((AdLandingGeneralVideoWrapper)localObject4).JCx = new g(((AdLandingGeneralVideoWrapper)localObject4).getContext(), localak, localFrameLayout, 1);
          }
          for (;;)
          {
            ((AdLandingGeneralVideoWrapper)localObject4).JCx.FO = 0;
            break;
            ((AdLandingGeneralVideoWrapper)localObject4).JCx.refreshView();
          }
          label573:
          a.a.fKM().start(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).KmB);
          break;
          ((SnsAdNativeLandingPagesUI)f.this.context).fVo();
        }
      }
    };
    this.JBi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(223694);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingGeneralVideoComponent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        f.this.JAI = 3;
        paramAnonymousView = f.this;
        paramAnonymousView.JBc += 1;
        f.this.JAL.setVisibility(8);
        f.a(f.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingGeneralVideoComponent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(223694);
      }
    };
    this.JBl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197620);
        f.this.setFocus(false);
        AppMethodBeat.o(197620);
      }
    };
    this.mContext = paramContext;
    this.JBd = new an()
    {
      public final void yj(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(268433);
        Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
        if (paramAnonymousBoolean) {}
        for (int i = 1;; i = 0)
        {
          localIntent.putExtra("show", i);
          localIntent.putExtra("activity_code", f.this.fQD());
          androidx.h.a.a.V(f.this.mContext).c(localIntent);
          AppMethodBeat.o(268433);
          return;
        }
      }
    };
    AppMethodBeat.o(243790);
  }
  
  static void aE(Runnable paramRunnable)
  {
    AppMethodBeat.i(243801);
    MMHandlerThread.removeRunnable(paramRunnable);
    MMHandlerThread.postToMainThreadDelayed(paramRunnable, 4000L);
    AppMethodBeat.o(243801);
  }
  
  private void aeL(int paramInt)
  {
    AppMethodBeat.i(243794);
    if ((this.JAK != null) && (this.JAL != null))
    {
      this.JAL.setVisibility(8);
      if (!isPlaying()) {
        this.JAK.fKy();
      }
      this.JAK.aeM(paramInt);
    }
    AppMethodBeat.o(243794);
  }
  
  private void yd(boolean paramBoolean)
  {
    AppMethodBeat.i(243808);
    if (this.JAS) {
      fKr();
    }
    for (;;)
    {
      this.JAL.setVisibility(8);
      this.JAK.cNW();
      AppMethodBeat.o(243808);
      return;
      if (paramBoolean) {
        fQC();
      }
      fKs();
    }
  }
  
  public final void aRo()
  {
    AppMethodBeat.i(243816);
    aE(this.JBl);
    AppMethodBeat.o(243816);
  }
  
  public final void aYv(String paramString)
  {
    AppMethodBeat.i(243819);
    if (this.KkD != null) {
      this.KkD.sendMessage();
    }
    AdLandingGeneralVideoWrapper localAdLandingGeneralVideoWrapper = this.JAK;
    if (localAdLandingGeneralVideoWrapper.sUi != null) {
      localAdLandingGeneralVideoWrapper.sUi.a(localAdLandingGeneralVideoWrapper);
    }
    if (!this.JAV)
    {
      dmi();
      Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "onVideoPlay, but is not appear, pausePlay");
    }
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "player callback onVideoPlay, %s", new Object[] { paramString });
    AppMethodBeat.o(243819);
  }
  
  public final void aYw(String paramString)
  {
    AppMethodBeat.i(243820);
    this.JAK.fKx();
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "player callback onVideoPause, %s", new Object[] { paramString });
    AppMethodBeat.o(243820);
  }
  
  public final boolean by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(243814);
    if (!super.by(paramJSONObject))
    {
      AppMethodBeat.o(243814);
      return false;
    }
    try
    {
      paramJSONObject.put("videoDuration", this.JAK.getVideoDurationSec());
      paramJSONObject.put("playTimeInterval", this.JAK.getPlayTimeInterval());
      paramJSONObject.put("playCount", this.JAK.getPlayCount());
      paramJSONObject.put("playCompletedCount", this.JAW);
      paramJSONObject.put("clickFullscreenBtnCount", this.JBa);
      paramJSONObject.put("doubleClickCount", this.JAZ);
      paramJSONObject.put("clickPlayControlCount", this.JAX);
      paramJSONObject.put("clickVoiceControlCount", this.JAY);
      paramJSONObject.put("clickSightCount", this.JBb);
      paramJSONObject.put("clickSightIconCount", this.JBc);
      if (this.isAutoPlay) {}
      for (Object localObject = "1";; localObject = "0")
      {
        paramJSONObject.put("isAutoPlay", localObject);
        JSONObject localJSONObject1;
        if (!this.JAO)
        {
          localObject = MD5Util.getMD5String(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).thumbUrl);
          localJSONObject1 = new JSONObject();
          localJSONObject1.put("urlMd5", localObject);
          localJSONObject1.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject1);
        }
        if (!this.JAP)
        {
          localObject = MD5Util.getMD5String(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).videoUrl);
          localJSONObject1 = new JSONObject();
          localJSONObject1.put("urlMd5", localObject);
          localJSONObject1.put("needDownload", 1);
          paramJSONObject.put("videoUrlInfo", localJSONObject1);
        }
        localObject = this.JAK.getAdLandingVideoFullScreenFloatBarReportInfo();
        if (localObject != null)
        {
          localJSONObject1 = new JSONObject();
          localJSONObject1.put("cid", ((com.tencent.mm.plugin.sns.ad.f.a.a)localObject).JGz);
          localJSONObject1.put("exposureCount", ((com.tencent.mm.plugin.sns.ad.f.a.a)localObject).JGA);
          localJSONObject1.put("stayTime", ((com.tencent.mm.plugin.sns.ad.f.a.a)localObject).JGB);
          localJSONObject1.put("clickCount", ((com.tencent.mm.plugin.sns.ad.f.a.a)localObject).JGC);
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("exposureCount", ((com.tencent.mm.plugin.sns.ad.f.a.a)localObject).JGy);
          localJSONObject2.put("stayTime", ((com.tencent.mm.plugin.sns.ad.f.a.a)localObject).fOa);
          localJSONObject2.put("clickCount", ((com.tencent.mm.plugin.sns.ad.f.a.a)localObject).clickCount);
          localJSONObject2.put("btnInfo", localJSONObject1);
          paramJSONObject.put("fullVideoFloatBarInfo", localJSONObject2);
        }
        AppMethodBeat.o(243814);
        return true;
      }
      return false;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.Sns.AdLandingGeneralVideoComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(243814);
    }
  }
  
  public final void dmf()
  {
    AppMethodBeat.i(243802);
    dmi();
    this.JAI = 4;
    AppMethodBeat.o(243802);
  }
  
  public final void dmg()
  {
    AppMethodBeat.i(243803);
    this.JAI = 3;
    yd(false);
    AppMethodBeat.o(243803);
  }
  
  protected final void dmi()
  {
    AppMethodBeat.i(243796);
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "pause play");
    AdLandingGeneralVideoWrapper localAdLandingGeneralVideoWrapper = this.JAK;
    MMHandlerThread.postToMainThread(new AdLandingGeneralVideoWrapper.2(localAdLandingGeneralVideoWrapper));
    if (localAdLandingGeneralVideoWrapper.FOL != 0L)
    {
      localAdLandingGeneralVideoWrapper.JCy = ((int)(localAdLandingGeneralVideoWrapper.JCy + (System.currentTimeMillis() - localAdLandingGeneralVideoWrapper.FOL)));
      localAdLandingGeneralVideoWrapper.FOL = 0L;
    }
    AppMethodBeat.o(243796);
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(243804);
    super.fKk();
    AppMethodBeat.o(243804);
  }
  
  public final void fKl()
  {
    AppMethodBeat.i(243809);
    super.fKl();
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "viewWillDisappear, before handleType = " + this.JAI);
    dmi();
    this.JAV = false;
    if ((!this.JAQ) && (!this.JAR))
    {
      AppMethodBeat.o(243809);
      return;
    }
    this.JAR = false;
    this.JAQ = false;
    if ((this.JAI == 1) || (this.JAI == 3)) {
      this.JAI = 2;
    }
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "viewWillDisappear, after handleType = " + this.JAI);
    AppMethodBeat.o(243809);
  }
  
  public final void fKm()
  {
    AppMethodBeat.i(243807);
    super.fKm();
    int i = fRi();
    int j = getView().getHeight();
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i <= 0) || (j == 0))
    {
      AppMethodBeat.o(243807);
      return;
    }
    if (i >= j * 0.5F)
    {
      if ((this.JAQ) && (!this.JAR))
      {
        AppMethodBeat.o(243807);
        return;
      }
      this.JAQ = true;
      this.JAR = false;
      Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "viewAppeared, inScreenHeight over 0.5 percent, before handleType = " + this.JAI);
      this.JAV = true;
      if (this.JAI == 0)
      {
        i = (int)fRp().Knu / 1000;
        if ((this.context instanceof SnsAdNativeLandingPagesUI))
        {
          ((SnsAdNativeLandingPagesUI)this.context).fVn();
          Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "snsId = " + fRp().getSnsId() + ", cid = " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).KmB + ", isFirstSightVideoComp = " + this.JAU);
          if ((this.JAU) && (i > 0))
          {
            this.JAI = 1;
            aeL(i);
            this.isAutoPlay = true;
            AppMethodBeat.o(243807);
            return;
          }
        }
        if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).Kln))
        {
          i = 1;
          if (i == 0) {
            break label350;
          }
          yd(false);
          this.JAI = 1;
          this.isAutoPlay = true;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "viewAppeared, inScreenHeight over 0.5 percent, after handleType = " + this.JAI);
        AppMethodBeat.o(243807);
        return;
        i = 0;
        break;
        label350:
        this.JAL.setVisibility(0);
        this.isAutoPlay = false;
        AppMethodBeat.o(243807);
        return;
        if (this.JAI == 2)
        {
          yd(false);
          this.JAI = 1;
        }
      }
    }
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "viewAppeared, inScreenHeight less 0.5 percent, before handleType = " + this.JAI);
    this.JAR = false;
    this.JAQ = false;
    dmi();
    this.JAV = false;
    if ((this.JAI == 1) || (this.JAI == 3)) {
      this.JAI = 2;
    }
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "viewAppeared, inScreenHeight less 0.5 percent, after handleType = " + this.JAI);
    AppMethodBeat.o(243807);
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(243810);
    super.fKo();
    MMHandlerThread.removeRunnable(this.JBl);
    this.JAK.fKx();
    this.JAK.onUIDestroy();
    AppMethodBeat.o(243810);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(243793);
    this.JAJ = this.contentView.findViewById(i.f.content_root);
    this.JAK = ((AdLandingGeneralVideoWrapper)this.JAJ.findViewById(i.f.video_view));
    this.maskView = this.JAJ.findViewById(i.f.sns_ad_native_landing_pages_sight_background);
    this.JAL = ((ImageView)this.JAJ.findViewById(i.f.status_btn));
    Object localObject1;
    Object localObject2;
    AdLandingGeneralVideoWrapper localAdLandingGeneralVideoWrapper;
    if ((this.JAJ == null) || (this.JAK == null))
    {
      Log.e("MicroMsg.Sns.AdLandingGeneralVideoComponent", "mVideoContainer or mVideoViewWrapper is null");
      this.JAK.a(this);
      this.JAK.setPlayerMode(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).Klj);
      localObject1 = a.a.fKM();
      localObject2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).KmB;
      localAdLandingGeneralVideoWrapper = this.JAK;
      if ((localAdLandingGeneralVideoWrapper != null) && (!Util.isNullOrNil((String)localObject2))) {
        break label1278;
      }
      Log.e("ScreenSwitchManager", "componentId or view is null");
      label160:
      this.JAM = new AdLandingVideoPlayerToolBar(this.mContext);
      this.JAK.a(this.JAM);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((ViewGroup)this.JAJ).addView(this.JAM, (ViewGroup.LayoutParams)localObject1);
      this.JAK.setVideoToolBar(this.JAM);
      this.JAK.setVideoContainer((ViewGroup)this.JAJ);
      this.JAM.setVisibility(4);
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).Klm) {
        this.JAM.fMa();
      }
      this.JAM.setOnVoiceButtonClickListener(this.JBf);
      this.JAM.setUpdateTimeListener(this.JBg);
      this.JAM.setOnFullScreenClickListener(this.JBh);
      this.JAL.setOnClickListener(this.JBi);
      this.JAN = this.JAM.getSeekBar();
      if (this.JAN != null)
      {
        this.JAN.setIplaySeekCallback(this.JAK);
        this.JAN.setOnPlayButtonClickListener(this.JBe);
      }
      if (this.JBd != null) {
        this.JBd.yj(false);
      }
      localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).thumbUrl);
      if (u.agG((String)localObject1))
      {
        this.JAO = true;
        Log.d("MicroMsg.Sns.AdLandingGeneralVideoComponent", "thumb resource is exist");
      }
      if (!this.JAO) {
        break label1353;
      }
      this.JAK.setCover(BitmapUtil.decodeFile((String)localObject1));
    }
    for (;;)
    {
      boolean bool = com.tencent.mm.plugin.sns.ad.d.d.fJQ();
      if (u.agG(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.fSq() + "AdLandingGeneralVideo_" + com.tencent.mm.plugin.sns.ad.d.d.co(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).videoUrl, bool).hashCode() + ".mp4"))
      {
        this.JAP = true;
        Log.d("MicroMsg.Sns.AdLandingGeneralVideoComponent", "video resource is exist");
      }
      this.JAK.aYy(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).videoUrl);
      AppMethodBeat.o(243793);
      return;
      localObject1 = this.JAK.getVideoView();
      if (localObject1 == null)
      {
        Log.e("MicroMsg.Sns.AdLandingGeneralVideoComponent", "videoView is null");
        break;
      }
      this.JAJ.setPadding((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).paddingLeft, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).paddingTop, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).paddingRight, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).paddingBottom);
      int i;
      int j;
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).KjH == 0)
      {
        if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).width > 0.0F) && (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).height > 0.0F))
        {
          i = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).width;
          j = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).height;
          this.JBj = i;
          this.JBk = j;
          localObject2 = new RelativeLayout.LayoutParams(i, j);
          ((RelativeLayout.LayoutParams)localObject2).addRule(13);
          Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "createView, displayType = " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).KjH + ", containerW = " + i + ", containerH = " + j + ", padding = " + m.gn(this.JAJ));
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.JAK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.JAJ.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        for (;;)
        {
          this.JAK.u(this.JBj, this.JBk, this.pEj, this.pEk);
          localObject1 = this.JAK.getInnerVideoView();
          if (!(localObject1 instanceof VideoPlayerTextureView)) {
            break label1233;
          }
          ((View)localObject1).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
          {
            public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
            {
              AppMethodBeat.i(255295);
              try
              {
                paramAnonymousInt1 = paramAnonymousView.getHeight();
                paramAnonymousInt2 = paramAnonymousView.getWidth();
                paramAnonymousInt3 = f.this.JAJ.getWidth();
                paramAnonymousInt4 = f.this.JAJ.getHeight();
                if ((paramAnonymousInt2 <= 1) || (paramAnonymousInt1 <= 1) || (paramAnonymousInt3 == 0) || (paramAnonymousInt4 == 0))
                {
                  AppMethodBeat.o(255295);
                  return;
                }
                Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "onLayoutChange, video.w=" + paramAnonymousView.getWidth() + ", h=" + paramAnonymousView.getHeight() + ", container.w=" + paramAnonymousInt3 + ", h=" + paramAnonymousInt4 + ", container.padding=" + m.gn(f.this.JAJ));
                paramAnonymousView = f.this.JAK.getThumbView();
                if (paramAnonymousView != null)
                {
                  RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramAnonymousInt2, paramAnonymousInt1);
                  localLayoutParams.addRule(13);
                  paramAnonymousView.setLayoutParams(localLayoutParams);
                }
                f.this.JBj = paramAnonymousInt2;
                f.this.JBk = paramAnonymousInt1;
                f.this.JAK.u(f.this.JBj, f.this.JBk, f.this.pEj, f.this.pEk);
                if (paramAnonymousInt1 == paramAnonymousInt4)
                {
                  this.JBn.removeOnLayoutChangeListener(this);
                  AppMethodBeat.o(255295);
                  return;
                }
                if ((paramAnonymousInt1 >= paramAnonymousInt2) && (paramAnonymousInt4 >= paramAnonymousInt3) && (Math.abs(paramAnonymousInt1 - paramAnonymousInt4) < 2))
                {
                  paramAnonymousView = f.this.JAJ.getLayoutParams();
                  paramAnonymousView.height = paramAnonymousInt1;
                  f.this.JAJ.setLayoutParams(paramAnonymousView);
                  Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "onLayoutChange, reset VideoContainer.height");
                }
                this.JBn.removeOnLayoutChangeListener(this);
                AppMethodBeat.o(255295);
                return;
              }
              catch (Exception paramAnonymousView)
              {
                Log.e("MicroMsg.Sns.AdLandingGeneralVideoComponent", "onLayoutChange, exp=" + paramAnonymousView.toString());
                AppMethodBeat.o(255295);
              }
            }
          });
          break;
          this.JBj = this.pEj;
          this.JBk = this.pEk;
          ((View)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.pEj, this.pEk));
          this.JAK.setLayoutParams(new RelativeLayout.LayoutParams(this.pEj, this.pEk));
          this.JAJ.setLayoutParams(new RelativeLayout.LayoutParams(this.pEj, this.pEk));
        }
      }
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).width / this.pEj > ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).height / this.pEk)
      {
        j = this.pEj;
        i = (int)(j * ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).height / ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).width) + 1;
      }
      for (;;)
      {
        this.JBj = j;
        this.JBk = i;
        localObject2 = new RelativeLayout.LayoutParams(j, i);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((this.pEj - j) / 2);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((RelativeLayout.LayoutParams)localObject2).leftMargin;
        ((RelativeLayout.LayoutParams)localObject2).topMargin = ((this.pEk - i) / 2);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((RelativeLayout.LayoutParams)localObject2).topMargin;
        Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "createView, displayType = " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).KjH + ", containerW = " + j + ", containerH = " + i + ", padding = " + m.gn(this.JAJ));
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.JAK.setLayoutParams(new RelativeLayout.LayoutParams(this.pEj, this.pEk));
        this.JAJ.setLayoutParams(new RelativeLayout.LayoutParams(this.pEj, this.pEk));
        break;
        i = this.pEk;
        j = (int)(i * ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).width / ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).height) + 1;
      }
      label1233:
      Log.e("MicroMsg.Sns.AdLandingGeneralVideoComponent", "onLayoutChange, innerVideoView=" + localObject1 + ", displayType=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).KjH);
      break;
      label1278:
      WeakReference localWeakReference = new WeakReference(localAdLandingGeneralVideoWrapper);
      ((com.tencent.mm.plugin.sns.ad.landingpage.helper.c.a)localObject1).JDD.put(localObject2, localWeakReference);
      localObject2 = localAdLandingGeneralVideoWrapper.getContext();
      if (localObject2 == null)
      {
        Log.e("ScreenSwitchManager", "view getContext is null");
        break label160;
      }
      if (((com.tencent.mm.plugin.sns.ad.landingpage.helper.c.a)localObject1).JDE != null) {
        break label160;
      }
      ((com.tencent.mm.plugin.sns.ad.landingpage.helper.c.a)localObject1).JDE = new com.tencent.mm.plugin.mmsight.model.d((Context)localObject2);
      break label160;
      label1353:
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).thumbUrl, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a()
      {
        public final void aYs(String paramAnonymousString)
        {
          AppMethodBeat.i(255959);
          f.this.JAK.setCover(BitmapUtil.decodeFile(paramAnonymousString));
          AppMethodBeat.o(255959);
        }
        
        public final void fJU() {}
        
        public final void fJV() {}
      });
    }
  }
  
  public final void fKr()
  {
    AppMethodBeat.i(243797);
    super.fKr();
    this.JAM.ys(false);
    this.JAK.setMute(true);
    this.JAS = true;
    AppMethodBeat.o(243797);
  }
  
  public final void fKs()
  {
    AppMethodBeat.i(243798);
    super.fKs();
    this.JAM.ys(true);
    this.JAK.setMute(false);
    this.JAS = false;
    AppMethodBeat.o(243798);
  }
  
  public final void fKt()
  {
    AppMethodBeat.i(243821);
    this.JAW += 1;
    if (this.KkD != null) {
      this.KkD.JDG = true;
    }
    if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).Klq != null) && (!this.JAT) && (this.JAM != null) && (!this.JAM.QT()))
    {
      int i = this.JAK.getVideoDurationSec() * 1000;
      int j = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).Klq.Knx;
      Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "OpenSnsAdFloatPageEvent, onLoopCompletion totalMs = " + i + ", floatStartTime = " + j + ", hasShowFloat = " + this.JAT);
      jv(i, j);
    }
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "player callback onLoopCompletion");
    AppMethodBeat.o(243821);
  }
  
  public final boolean fKu()
  {
    AppMethodBeat.i(243822);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).Klm)
    {
      AppMethodBeat.o(243822);
      return true;
    }
    this.JBb += 1;
    int i;
    if ((this.JAM != null) && (this.JAM.getVisibility() == 0))
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
      AppMethodBeat.o(243822);
      return true;
      i = 0;
      break;
    }
  }
  
  public final boolean fKv()
  {
    AppMethodBeat.i(243823);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).Klm)
    {
      AppMethodBeat.o(243823);
      return true;
    }
    aE(this.JBl);
    this.JAZ += 1;
    if (isPlaying()) {
      dmi();
    }
    for (this.JAI = 4;; this.JAI = 3)
    {
      AppMethodBeat.o(243823);
      return true;
      yd(true);
    }
  }
  
  public final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_general_video;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(243811);
    if ((this.JAK != null) && (this.JAK.isPlaying()))
    {
      AppMethodBeat.o(243811);
      return true;
    }
    AppMethodBeat.o(243811);
    return false;
  }
  
  final void jv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(243815);
    if (paramInt1 <= paramInt2)
    {
      this.JAT = true;
      py localpy = new py();
      localpy.fOF.fOG = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)this.KqB).Klq.fOG;
      EventCenter.instance.publish(localpy);
    }
    AppMethodBeat.o(243815);
  }
  
  protected final void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(243799);
    if (paramBoolean)
    {
      this.JAK.yk(paramBoolean);
      this.JAM.setVisibility(0);
      this.maskView.setVisibility(0);
      if (this.JBd != null) {
        this.JBd.yj(true);
      }
      aE(this.JBl);
      AppMethodBeat.o(243799);
      return;
    }
    this.JAM.setVisibility(4);
    this.maskView.setVisibility(4);
    if (this.JBd != null) {
      this.JBd.yj(false);
    }
    this.JAK.yk(paramBoolean);
    MMHandlerThread.removeRunnable(this.JBl);
    AppMethodBeat.o(243799);
  }
  
  public final void tY(int paramInt)
  {
    AppMethodBeat.i(243817);
    aeL(paramInt);
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoComponent", "player callback onSeekTo time ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(243817);
  }
  
  public static abstract interface a
  {
    public abstract void AS(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.a.f
 * JD-Core Version:    0.7.0.1
 */