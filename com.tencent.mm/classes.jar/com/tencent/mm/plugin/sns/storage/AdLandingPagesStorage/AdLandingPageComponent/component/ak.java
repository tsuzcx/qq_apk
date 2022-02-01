package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.py;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import org.json.JSONException;
import org.json.JSONObject;

public final class ak
  extends aj
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, com.tencent.mm.plugin.sight.decode.ui.b, i.b, i.d
{
  private ImageView BPW;
  private long FOL;
  private int FPs;
  private int JAI;
  private View JAJ;
  private ImageView JAL;
  private boolean JAO;
  private boolean JAP;
  private boolean JAQ;
  private boolean JAR;
  private boolean JAS;
  private boolean JAT;
  private int JAW;
  private int JAX;
  private int JAY;
  private int JAZ;
  private int JBa;
  private an JBd;
  private Runnable JBl;
  private int JCy;
  private AdLandingVideoWrapper KtN;
  private boolean KtO;
  private boolean KtP;
  private boolean KtQ;
  private boolean KtR;
  private View.OnClickListener KtS;
  private View.OnClickListener KtT;
  private View.OnClickListener KtU;
  private volatile int KtV;
  private b KtW;
  private TextView Ktc;
  private ImageView Kte;
  private boolean Ktg;
  private VideoPlayerSeekBar Kth;
  private ImageView Kti;
  private View Ktj;
  private volatile boolean Ktk;
  private Runnable Ktl;
  private View.OnClickListener Ktm;
  private long Kto;
  private Context context;
  private boolean isAutoPlay;
  private volatile boolean isWaiting;
  private ProgressBar kGl;
  private MMHandler knk;
  private int length;
  private GestureDetector mBn;
  private View maskView;
  
  public ak(final Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an paraman, ViewGroup paramViewGroup)
  {
    super(paramContext, paraman, paramViewGroup);
    AppMethodBeat.i(96774);
    this.KtO = false;
    this.KtP = false;
    this.KtQ = false;
    this.JAS = true;
    this.KtR = true;
    this.JAQ = false;
    this.JAR = true;
    this.isAutoPlay = false;
    this.Ktg = false;
    this.JAO = false;
    this.JAP = false;
    this.JAI = 0;
    this.FOL = 0L;
    this.JCy = 0;
    this.FPs = 0;
    this.JAW = 0;
    this.JAX = 0;
    this.JAY = 0;
    this.JBd = null;
    this.Ktm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96769);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(ak.this.isPlaying()) });
        ak.a(ak.this, ak.h(ak.this));
        if (ak.this.isPlaying())
        {
          ak.i(ak.this);
          ak.a(ak.this, 4);
          if (ak.l(ak.this)) {
            ak.m(ak.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96769);
          return;
        }
        if (ak.j(ak.this)) {
          ak.this.fKr();
        }
        for (;;)
        {
          ak.k(ak.this);
          ak.a(ak.this, 3);
          break;
          ak.this.fQC();
          ak.this.fKs();
        }
      }
    };
    this.KtS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96771);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ak.n(ak.this);
        ak.a(ak.this, ak.h(ak.this));
        if (ak.j(ak.this))
        {
          ak.this.fQC();
          ak.this.fKs();
        }
        for (;;)
        {
          ak.o(ak.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96771);
          return;
          ak.this.fKr();
        }
      }
    };
    this.KtT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96772);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ak.k(ak.this);
        ak.p(ak.this);
        ak.q(ak.this);
        ak.a(ak.this, 3);
        ak.this.fKs();
        ak.a(ak.this, true);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(243321);
            if (ak.r(ak.this))
            {
              AppMethodBeat.o(243321);
              return;
            }
            ak.a(ak.this, false);
            AppMethodBeat.o(243321);
          }
        }, 10000L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(96772);
      }
    };
    this.KtU = new ak.13(this);
    this.Ktk = false;
    this.isWaiting = false;
    this.KtV = 0;
    this.JAZ = 0;
    this.JBa = 0;
    this.Kto = 0L;
    this.context = paramContext;
    this.knk = new MMHandler(Looper.getMainLooper());
    try
    {
      this.mBn = new GestureDetector(this);
      this.Ktl = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96762);
          ak.a(ak.this).setVisibility(8);
          AppMethodBeat.o(96762);
        }
      };
      this.JBl = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198109);
          ak.a(ak.this, false);
          AppMethodBeat.o(198109);
        }
      };
      this.JBd = new an()
      {
        public final void yj(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(198070);
          Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
          if (paramAnonymousBoolean) {}
          for (int i = 1;; i = 0)
          {
            localIntent.putExtra("show", i);
            localIntent.putExtra("activity_code", ak.b(ak.this));
            androidx.h.a.a.V(paramContext).c(localIntent);
            AppMethodBeat.o(198070);
            return;
          }
        }
      };
      AppMethodBeat.o(96774);
      return;
    }
    catch (Throwable paraman)
    {
      for (;;)
      {
        Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paraman.toString());
      }
    }
  }
  
  private void aE(Runnable paramRunnable)
  {
    AppMethodBeat.i(197793);
    try
    {
      this.knk.removeCallbacks(paramRunnable);
      this.knk.postDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(197793);
      return;
    }
    catch (Throwable paramRunnable)
    {
      Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramRunnable.toString());
      AppMethodBeat.o(197793);
    }
  }
  
  private void aeL(int paramInt)
  {
    AppMethodBeat.i(96779);
    if (this.KtN != null)
    {
      this.JAL.setVisibility(8);
      if (this.BPW.getVisibility() == 0) {
        this.kGl.setVisibility(0);
      }
      this.KtN.a(paramInt, true);
    }
    AppMethodBeat.o(96779);
  }
  
  private void cNW()
  {
    AppMethodBeat.i(96776);
    Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "starting play, downFailed=" + this.Ktg);
    if (this.Ktg)
    {
      Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "last download fail ,try again");
      if ((this.Kth != null) && (this.Kth.getParent() != null)) {
        ((ViewGroup)this.Kth.getParent()).removeView(this.Kth);
      }
      this.KtN.setFullScreen(false);
      this.KtN.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).JCf, 0);
      try
      {
        int i = this.pEj;
        if ((this.Kth != null) && (this.Kth.getParent() != null)) {
          ((ViewGroup)this.Kth.getParent()).removeView(this.Kth);
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i - com.tencent.mm.ci.a.fromDPToPix(this.context, 75), -2);
        localLayoutParams.addRule(12);
        localLayoutParams.bottomMargin = com.tencent.mm.ci.a.fromDPToPix(this.context, 3);
        this.Kth.setLayoutParams(localLayoutParams);
        ((ViewGroup)this.contentView.findViewById(i.f.content_root)).addView(this.Kth, localLayoutParams);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "startPlay exp=" + Util.stackTraceToString(localException));
        }
      }
      aeL(0);
      this.KtN.fRI();
      AppMethodBeat.o(96776);
      return;
    }
    this.knk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96763);
        if (!ak.this.isPlaying())
        {
          if (ak.s(ak.this).getCurrPosSec() != ak.s(ak.this).getVideoDurationSec()) {
            break label62;
          }
          ak.b(ak.this, 0);
        }
        for (;;)
        {
          ak.s(ak.this).fRI();
          AppMethodBeat.o(96763);
          return;
          label62:
          ak.b(ak.this, ak.s(ak.this).getCurrPosSec());
        }
      }
    });
    this.FOL = System.currentTimeMillis();
    this.FPs += 1;
    AppMethodBeat.o(96776);
  }
  
  private boolean fRG()
  {
    AppMethodBeat.i(197818);
    if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).KnB))
    {
      AppMethodBeat.o(197818);
      return true;
    }
    AppMethodBeat.o(197818);
    return false;
  }
  
  private void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(96778);
    if (paramBoolean)
    {
      this.Kth.setVisibility(0);
      this.Kte.setVisibility(0);
      this.maskView.setVisibility(0);
      this.Kti.setVisibility(0);
      if (this.JBd != null) {
        this.JBd.yj(true);
      }
      aE(this.JBl);
      AppMethodBeat.o(96778);
      return;
    }
    this.KtQ = false;
    this.Kth.setVisibility(4);
    this.Kte.setVisibility(8);
    this.maskView.setVisibility(4);
    this.Kti.setVisibility(8);
    if (this.JBd != null) {
      this.JBd.yj(false);
    }
    this.knk.removeCallbacks(this.JBl);
    AppMethodBeat.o(96778);
  }
  
  private void yM(boolean paramBoolean)
  {
    AppMethodBeat.i(197792);
    try
    {
      this.Kth.setIsPlay(paramBoolean);
      this.Kth.getPlayBtn().getLayoutParams().width = this.length;
      this.Kth.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "startPlay");
        this.Kth.getPlayBtn().setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.media_player_btn_cur_status_on));
        AppMethodBeat.o(197792);
        return;
      }
      Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "pausePlay");
      this.Kth.getPlayBtn().setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.media_player_btn_cur_status_off));
      AppMethodBeat.o(197792);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(197792);
    }
  }
  
  private void yp(final boolean paramBoolean)
  {
    AppMethodBeat.i(197803);
    Log.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "pause play");
    this.knk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96764);
        ak.s(ak.this).pause();
        try
        {
          if ((ak.t(ak.this).getVisibility() != 0) && (paramBoolean))
          {
            ak.a(ak.this).setVisibility(0);
            ak.a(ak.this, ak.u(ak.this));
          }
          ak.b(ak.this, false);
          AppMethodBeat.o(96764);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(96764);
        }
      }
    });
    if (this.FOL != 0L)
    {
      this.JCy = ((int)(this.JCy + (System.currentTimeMillis() - this.FOL)));
      this.FOL = 0L;
    }
    AppMethodBeat.o(197803);
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, boolean paramBoolean3, int paramInt7, String paramString, long paramLong2)
  {
    AppMethodBeat.i(197883);
    for (;;)
    {
      try
      {
        this.KtN.setNeedPause(false);
        this.JAI = 6;
        this.Kto += paramLong2;
        this.Ktk = paramBoolean2;
        this.JBa += 1;
        this.JAX += paramInt2;
        this.JAZ += paramInt3;
        this.JAY += paramInt4;
        this.JAW += paramInt5;
        this.FPs += paramInt6;
        this.JCy = ((int)(this.JCy + paramLong1));
        boolean bool = Util.isNullOrNil(paramString);
        if (!bool) {}
        try
        {
          paramString = new JSONObject(paramString);
          if (this.KtW == null) {
            this.KtW = new b();
          }
          b localb = this.KtW;
          localb.JGy += paramString.optInt("exposureCount");
          localb = this.KtW;
          localb.fOa += paramString.optLong("stayTime");
          localb = this.KtW;
          localb.clickCount += paramString.optInt("clickCount");
          paramString = paramString.optJSONObject("btnInfo");
          this.KtW.JGz = paramString.optString("cid");
          localb = this.KtW;
          localb.JGA += paramString.optInt("exposureCount");
          localb = this.KtW;
          localb.JGB += paramString.optLong("stayTime");
          localb = this.KtW;
          paramInt2 = localb.JGC;
          localb.JGC = (paramString.optInt("clickCount") + paramInt2);
        }
        catch (Throwable paramString)
        {
          this.KtW = null;
          Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", paramString.toString());
          continue;
        }
        if (paramBoolean2) {
          this.FOL = System.currentTimeMillis();
        }
        this.knk.removeCallbacks(this.Ktl);
        this.Ktj.setVisibility(8);
        Log.i("VideoFullScreenActivity", "currPosSec = " + paramInt1 + ", isPlaying = " + paramBoolean2 + ", bNoVoice = " + paramBoolean1);
        if (!paramBoolean3) {
          break;
        }
        if ((paramInt7 == this.KtN.getVideoDurationSec()) || (paramInt7 < 0))
        {
          this.Kth.seek(0);
          this.KtN.a(0.0D, true);
          this.FOL = System.currentTimeMillis();
          yM(true);
          if (!paramBoolean1) {
            break label613;
          }
          fKr();
          AppMethodBeat.o(197883);
          return;
        }
      }
      catch (Throwable paramString)
      {
        Log.e("VideoFullScreenActivity", paramString.toString());
        AppMethodBeat.o(197883);
        return;
      }
      this.Kth.seek(this.KtN.getCacheTimeSec());
      this.KtN.a(this.KtN.getCacheTimeSec(), true);
    }
    if ((paramInt1 == this.KtN.getVideoDurationSec()) || (paramInt1 < 0))
    {
      this.Kth.seek(0);
      this.KtN.a(0.0D, paramBoolean2);
    }
    for (;;)
    {
      yM(paramBoolean2);
      break;
      this.Kth.seek(paramInt1);
      this.KtN.a(paramInt1, paramBoolean2);
    }
    label613:
    fKs();
    AppMethodBeat.o(197883);
  }
  
  public final void aRo()
  {
    AppMethodBeat.i(197827);
    this.KtQ = true;
    aE(this.JBl);
    AppMethodBeat.o(197827);
  }
  
  public final boolean by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96786);
    if (!super.by(paramJSONObject))
    {
      AppMethodBeat.o(96786);
      return false;
    }
    try
    {
      paramJSONObject.put("streamVideoDuraion", this.KtN.getVideoDurationSec() * 1000);
      paramJSONObject.put("playTimeInterval", this.JCy);
      paramJSONObject.put("playCount", this.FPs);
      paramJSONObject.put("playCompletedCount", this.JAW);
      paramJSONObject.put("clickFullscreenBtnCount", this.JBa);
      paramJSONObject.put("doubleClickCount", this.JAZ);
      paramJSONObject.put("clickPlayControlCount", this.JAX);
      paramJSONObject.put("clickVoiceControlCount", this.JAY);
      if (this.isAutoPlay) {}
      for (Object localObject = "1";; localObject = "0")
      {
        paramJSONObject.put("isAutoPlay", localObject);
        JSONObject localJSONObject;
        if (!this.JAO)
        {
          localObject = MD5Util.getMD5String(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).Knz);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        if (!this.JAP)
        {
          localObject = MD5Util.getMD5String(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).JCf);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("streamVideoUrlInfo", localJSONObject);
        }
        if (this.KtW != null)
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("cid", this.KtW.JGz);
          ((JSONObject)localObject).put("exposureCount", this.KtW.JGA);
          ((JSONObject)localObject).put("stayTime", this.KtW.JGB);
          ((JSONObject)localObject).put("clickCount", this.KtW.JGC);
          localJSONObject = new JSONObject();
          localJSONObject.put("exposureCount", this.KtW.JGy);
          localJSONObject.put("stayTime", this.KtW.fOa);
          localJSONObject.put("clickCount", this.KtW.clickCount);
          localJSONObject.put("btnInfo", localObject);
          paramJSONObject.put("fullVideoFloatBarInfo", localJSONObject);
        }
        AppMethodBeat.o(96786);
        return true;
      }
      return false;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96786);
    }
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96790);
    Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "online play error, %s", new Object[] { paramString3 });
    this.Ktg = true;
    AppMethodBeat.o(96790);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dS(String paramString1, String paramString2)
  {
    this.Ktg = false;
  }
  
  public final void dT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96788);
    Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onVideoEnded");
    this.JAW += 1;
    setFocus(true);
    this.KtN.Kux.stopTimer();
    if (this.FOL != 0L)
    {
      this.JCy = ((int)(this.JCy + (System.currentTimeMillis() - this.FOL)));
      this.FOL = 0L;
    }
    this.JAI = 5;
    this.KtN.onUIPause();
    AppMethodBeat.o(96788);
  }
  
  public final void dU(String paramString1, String paramString2) {}
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96789);
    Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "the onVideoPlay is called!");
    if (this.KkD != null) {
      this.KkD.sendMessage();
    }
    this.BPW.setVisibility(8);
    this.kGl.setVisibility(8);
    try
    {
      this.knk.removeCallbacks(this.Ktl);
      this.Ktj.setVisibility(8);
      yM(true);
      AppMethodBeat.o(96789);
      return;
    }
    catch (Throwable paramString1)
    {
      Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramString1.toString());
      AppMethodBeat.o(96789);
    }
  }
  
  public final void dW(String paramString1, String paramString2)
  {
    this.isWaiting = true;
  }
  
  public final void dX(String paramString1, String paramString2)
  {
    this.isWaiting = false;
    this.KtV = 0;
  }
  
  public final void dmf()
  {
    AppMethodBeat.i(197884);
    yp(false);
    this.JAI = 4;
    AppMethodBeat.o(197884);
  }
  
  public final void dmg()
  {
    AppMethodBeat.i(197885);
    this.JAI = 3;
    cNW();
    AppMethodBeat.o(197885);
  }
  
  public final void fC(String paramString1, String paramString2) {}
  
  protected final void fKe() {}
  
  public final void fKk()
  {
    AppMethodBeat.i(96782);
    super.fKk();
    AppMethodBeat.o(96782);
  }
  
  public final void fKl()
  {
    AppMethodBeat.i(96783);
    super.fKl();
    this.KtN.setNeedPause(true);
    yp(false);
    if ((!this.JAQ) && (!this.JAR))
    {
      AppMethodBeat.o(96783);
      return;
    }
    this.JAR = false;
    this.JAQ = false;
    if (this.JAI == 1) {
      this.JAI = 2;
    }
    AppMethodBeat.o(96783);
  }
  
  public final void fKm()
  {
    AppMethodBeat.i(96785);
    super.fKm();
    int i = fRi();
    int j = getView().getHeight();
    Log.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 0) || (j == 0))
    {
      this.KtN.setNeedPause(true);
      AppMethodBeat.o(96785);
      return;
    }
    if (i < 0)
    {
      this.KtN.setNeedPause(true);
      AppMethodBeat.o(96785);
      return;
    }
    if (i >= j * 0.5F)
    {
      if ((this.JAQ) && (!this.JAR))
      {
        AppMethodBeat.o(96785);
        return;
      }
      this.KtN.setNeedPause(false);
      this.JAR = false;
      this.JAQ = true;
      if (this.JAI == 6)
      {
        if (this.Ktk)
        {
          this.JAI = 1;
          if (this.JAL.getVisibility() == 0)
          {
            this.JAL.setVisibility(8);
            AppMethodBeat.o(96785);
          }
        }
        else
        {
          this.JAI = 4;
        }
        AppMethodBeat.o(96785);
        return;
      }
      this.BPW.setVisibility(0);
      if ((!this.KtR) || ((this.KtR) && (fRG())))
      {
        setFocus(true);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(233627);
            if (ak.r(ak.this))
            {
              AppMethodBeat.o(233627);
              return;
            }
            ak.a(ak.this, false);
            AppMethodBeat.o(233627);
          }
        }, 3000L);
      }
      if (this.KtR)
      {
        if (!fRG())
        {
          this.JAL.setVisibility(0);
          this.isAutoPlay = false;
          this.KtR = false;
          AppMethodBeat.o(96785);
          return;
        }
        this.isAutoPlay = true;
        this.KtR = false;
      }
      if (this.JAI == 0)
      {
        if (fRG())
        {
          if (this.JAS) {
            fKr();
          }
          for (;;)
          {
            this.JAI = 1;
            cNW();
            AppMethodBeat.o(96785);
            return;
            fKs();
          }
        }
      }
      else
      {
        if (this.JAI == 2)
        {
          if (this.JAS) {
            fKr();
          }
          for (;;)
          {
            cNW();
            this.JAI = 1;
            AppMethodBeat.o(96785);
            return;
            fKs();
          }
        }
        if (this.JAI == 3)
        {
          if (this.JAS) {
            fKr();
          }
          for (;;)
          {
            cNW();
            AppMethodBeat.o(96785);
            return;
            fKs();
          }
        }
      }
    }
    else
    {
      this.JAR = false;
      this.JAQ = false;
      this.KtN.setNeedPause(true);
      yp(false);
      if (this.JAI == 1) {
        this.JAI = 2;
      }
    }
    AppMethodBeat.o(96785);
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(96784);
    super.fKo();
    try
    {
      this.KtN.Kux.stopTimer();
      this.knk.removeCallbacks(this.JBl);
      this.knk.removeCallbacks(this.Ktl);
      this.KtN.onUIDestroy();
      AppMethodBeat.o(96784);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable.toString());
      }
    }
  }
  
  public final void fKp()
  {
    boolean bool2 = true;
    AppMethodBeat.i(96775);
    Object localObject1 = this.contentView.findViewById(i.f.content_root);
    this.JAJ = ((View)localObject1);
    ((View)localObject1).setBackgroundColor(-16777216);
    int k = this.pEj;
    int j = this.pEk;
    int i = j;
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).KnA == 1)
    {
      i = j;
      if ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).width > 0) {
        i = k * (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).height / (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).width;
      }
    }
    else
    {
      ((View)localObject1).setPadding((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).paddingLeft, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).paddingTop, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).paddingRight, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).paddingBottom);
    }
    ((View)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(k, i));
    ((View)localObject1).setMinimumHeight(i);
    Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "createView, displayType=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).KnA + ", containerW=" + k + ", vH=" + i + ", padding=" + com.tencent.mm.plugin.sns.data.m.gn((View)localObject1));
    this.KtN = ((AdLandingVideoWrapper)((View)localObject1).findViewById(i.f.video_view));
    this.KtN.setIMMVideoViewCallback(this);
    this.KtN.setOnClickListener(this.KtU);
    this.KtN.setFullScreen(false);
    this.KtN.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).JCf, 0);
    this.KtN.setIsShowBasicControls(true);
    Object localObject2;
    if (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).Kmr)
    {
      Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "fixVideoBlackline, enable=false");
      this.kGl = ((ProgressBar)((View)localObject1).findViewById(i.f.progressbar));
      this.BPW = ((ImageView)((View)localObject1).findViewById(i.f.thumb_iv));
      localObject2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).Knz);
      if (!u.agG((String)localObject2)) {
        this.JAO = false;
      }
      if (!this.JAO) {
        break label1351;
      }
      this.BPW.setImageBitmap(BitmapUtil.decodeFile((String)localObject2));
      label409:
      this.Ktc = ((TextView)((View)localObject1).findViewById(i.f.errorTv));
      this.Ktc.setText(this.context.getString(i.j.download_fail));
      this.maskView = ((View)localObject1).findViewById(i.f.sns_ad_native_landing_pages_sight_background);
      this.maskView.setVisibility(4);
      this.Kth = new VideoPlayerSeekBar(this.context);
      this.Kth.setVisibility(4);
      if (this.JBd != null)
      {
        localObject2 = this.JBd;
        if (this.Kth.getVisibility() != 0) {
          break label1378;
        }
      }
    }
    label1294:
    label1351:
    label1378:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((an)localObject2).yj(bool1);
      this.Kth.setIplaySeekCallback(this);
      this.Kth.setOnPlayButtonClickListener(this.Ktm);
      localObject2 = new RelativeLayout.LayoutParams(k - com.tencent.mm.ci.a.fromDPToPix(this.context, 75), -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      this.Kth.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.KtN.setVideoFooterView(this.Kth);
      this.Kte = ((ImageView)((View)localObject1).findViewById(i.f.sns_ad_native_landing_pages_sight_voice_btn));
      this.Kte.setVisibility(4);
      this.Kte.setOnClickListener(this.KtS);
      try
      {
        localObject3 = this.Kte.getParent();
        if ((localObject3 instanceof ViewGroup)) {
          ((ViewGroup)localObject3).removeView(this.Kte);
        }
        localObject3 = (RelativeLayout.LayoutParams)this.Kte.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject3).rightMargin = com.tencent.mm.ci.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localObject1).addView(this.Kte, (ViewGroup.LayoutParams)localObject3);
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "init voiceTypeBtn and visible");
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          Object localObject3;
          Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable4.toString());
        }
      }
      this.JAL = ((ImageView)((View)localObject1).findViewById(i.f.status_btn));
      this.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.shortvideo_play_btn));
      this.JAL.setVisibility(8);
      this.JAL.setOnClickListener(this.KtT);
      ((ViewGroup)this.Kth.getParent()).removeView(this.Kth);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((ViewGroup)localObject1).addView(this.Kth, (ViewGroup.LayoutParams)localObject2);
      this.KtN.setVideoPlayCallback(new AdLandingVideoWrapper.a()
      {
        public final void AS(int paramAnonymousInt)
        {
          AppMethodBeat.i(253051);
          ak.d(ak.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(270539);
              ak.b(ak.this, ak.this.isPlaying());
              AppMethodBeat.o(270539);
            }
          });
          if ((ak.e(ak.this).Klq != null) && (paramAnonymousInt * 1000 >= ak.e(ak.this).Klq.Knx) && (!ak.f(ak.this)))
          {
            ak.g(ak.this);
            py localpy = new py();
            localpy.fOF.fOG = ak.e(ak.this).Klq.fOG;
            EventCenter.instance.publish(localpy);
          }
          AppMethodBeat.o(253051);
        }
      });
      localObject1 = this.JAJ;
      try
      {
        this.length = com.tencent.mm.ci.a.fromDPToPix(this.context, 32);
        this.KtN.setOnTouchListener(this);
        this.Kti = ((ImageView)((View)localObject1).findViewById(i.f.sns_ad_native_landing_pages_sight_video_full_screen_btn));
        localObject2 = this.Kti.getParent();
        if ((localObject2 instanceof ViewGroup)) {
          ((ViewGroup)localObject2).removeView(this.Kti);
        }
        localObject2 = (RelativeLayout.LayoutParams)this.Kti.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = com.tencent.mm.ci.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localObject1).addView(this.Kti, (ViewGroup.LayoutParams)localObject2);
        this.Kti.setOnClickListener(this);
        this.Kti.setVisibility(8);
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "init fullScreenBtn and visible");
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          label1150:
          Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable1.toString());
          continue;
          bool1 = false;
        }
      }
      try
      {
        this.KtN.setLoop(true);
        this.KtN.setLoopCompletionCallback(this);
        localObject1 = this.Kth.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.Kth);
        }
        localObject1 = new RelativeLayout.LayoutParams(this.JAJ.getLayoutParams().width - com.tencent.mm.ci.a.fromDPToPix(this.context, 75), -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(this.context, 3);
        this.Kth.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((ViewGroup)this.contentView.findViewById(i.f.content_root)).addView(this.Kth, (ViewGroup.LayoutParams)localObject1);
        this.Kth.setVisibility(4);
        yM(false);
        if (this.JBd != null)
        {
          localObject1 = this.JBd;
          if (this.Kth.getVisibility() != 0) {
            break label1414;
          }
          bool1 = bool2;
          ((an)localObject1).yj(bool1);
        }
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "init progressBar and visible");
      }
      catch (Throwable localThrowable2)
      {
        Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable2.toString());
        break label1150;
      }
      localObject1 = this.JAJ;
      try
      {
        this.Ktj = ((View)localObject1).findViewById(i.f.pause_video_container);
        this.Ktj.setVisibility(8);
        AppMethodBeat.o(96775);
        return;
      }
      catch (Throwable localThrowable3)
      {
        Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable3.toString());
        AppMethodBeat.o(96775);
      }
      localObject2 = this.KtN.getInnerVideoView();
      localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB;
      if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)localObject3).paddingLeft != 0.0F) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)localObject3).paddingTop != 0.0F) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)localObject3).paddingRight != 0.0F) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)localObject3).paddingBottom != 0.0F)) {}
      for (bool1 = true;; bool1 = false)
      {
        if ((!(localObject2 instanceof VideoPlayerTextureView)) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).KnA != 1) || (bool1)) {
          break label1294;
        }
        ((View)localObject2).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
        {
          public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            AppMethodBeat.i(270633);
            try
            {
              paramAnonymousInt1 = paramAnonymousView.getWidth();
              paramAnonymousInt2 = paramAnonymousView.getHeight();
              paramAnonymousInt3 = ak.v(ak.this).getWidth();
              paramAnonymousInt4 = ak.v(ak.this).getHeight();
              if ((paramAnonymousInt2 <= 1) || (paramAnonymousInt1 <= 1) || (paramAnonymousInt3 == 0) || (paramAnonymousInt4 == 0))
              {
                AppMethodBeat.o(270633);
                return;
              }
              Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, videoW=" + paramAnonymousInt1 + ", videoH=" + paramAnonymousInt2 + ", containerW=" + paramAnonymousInt3 + ", containH=" + paramAnonymousInt4 + ", container.padding=" + com.tencent.mm.plugin.sns.data.m.gn(ak.v(ak.this)));
              if (paramAnonymousInt2 == paramAnonymousInt4)
              {
                AppMethodBeat.o(270633);
                return;
              }
              if ((paramAnonymousInt2 >= paramAnonymousInt1) && (paramAnonymousInt4 >= paramAnonymousInt3) && (Math.abs(paramAnonymousInt2 - paramAnonymousInt4) < 2))
              {
                paramAnonymousView = ak.v(ak.this).getLayoutParams();
                paramAnonymousView.height = paramAnonymousInt2;
                ak.v(ak.this).setLayoutParams(paramAnonymousView);
                Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, reset VideoContainer.height");
              }
              AppMethodBeat.o(270633);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, exp=" + paramAnonymousView.toString());
              AppMethodBeat.o(270633);
            }
          }
        });
        break;
      }
      Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, innerVideoView=" + localObject2 + ", displayType=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).KnA + ", hasPadding=" + bool1);
      break;
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).Knz, new f.a()
      {
        public final void aYs(String paramAnonymousString)
        {
          AppMethodBeat.i(218860);
          if (ak.c(ak.this).getVisibility() == 0) {
            ak.c(ak.this).setImageBitmap(BitmapUtil.decodeFile(paramAnonymousString));
          }
          AppMethodBeat.o(218860);
        }
        
        public final void fJU() {}
        
        public final void fJV() {}
      });
      break label409;
    }
    label1414:
  }
  
  public final void fKr()
  {
    AppMethodBeat.i(96780);
    super.fKr();
    this.Kte.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.icon_volume_off));
    this.KtN.setMute(true);
    this.JAS = true;
    AppMethodBeat.o(96780);
  }
  
  public final void fKs()
  {
    AppMethodBeat.i(96781);
    super.fKs();
    this.Kte.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.icon_volume_on));
    this.KtN.setMute(false);
    this.JAS = false;
    AppMethodBeat.o(96781);
  }
  
  public final void fKt()
  {
    AppMethodBeat.i(197832);
    Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLoopCompletion");
    this.JAW += 1;
    if (this.KkD != null) {
      this.KkD.JDG = true;
    }
    AppMethodBeat.o(197832);
  }
  
  public final long fRk()
  {
    AppMethodBeat.i(197887);
    long l1 = super.fRk();
    long l2 = this.Kto;
    AppMethodBeat.o(197887);
    return l1 + l2;
  }
  
  public final void fRn()
  {
    AppMethodBeat.i(96791);
    super.fRn();
    yp(false);
    String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).Knz);
    if (u.agG(str))
    {
      this.BPW.setImageBitmap(BitmapUtil.decodeFile(str));
      this.BPW.setVisibility(0);
    }
    AppMethodBeat.o(96791);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_new_stream;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(197813);
    boolean bool = this.KtN.isPlaying();
    AppMethodBeat.o(197813);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(197855);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if (paramView.getId() == i.f.sns_ad_native_landing_pages_sight_video_full_screen_btn) {
      Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "click full screen btn");
    }
    try
    {
      if ((this.context instanceof SnsAdNativeLandingPagesUI))
      {
        this.JBa += 1;
        this.knk.removeCallbacks(this.Ktl);
        this.Ktj.setVisibility(8);
        paramView = (SnsAdNativeLandingPagesUI)this.context;
        a.Kua = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB;
        com.tencent.mm.plugin.sns.model.ae.JWV = fRp();
        localObject = new Intent(paramView, VideoFullScreenActivity.class);
        ((Intent)localObject).putExtra("KComponentVideoType", 1);
        ((Intent)localObject).putExtra("KComponentCid", this.KqB.KmB);
        ((Intent)localObject).putExtra("KComponentCurrentTime", this.KtN.getCurrPosSec());
        ((Intent)localObject).putExtra("KComponentTotalTime", this.KtN.getVideoDurationSec());
        ((Intent)localObject).putExtra("KComponentVoiceType", this.JAS);
        ((Intent)localObject).putExtra("KComponentProgressType", this.KtN.isPlaying());
        ((Intent)localObject).putExtra("KComponentStreamVideoUrlPath", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).JCf);
        ((Intent)localObject).putExtra("KComponentIsWaiting", this.isWaiting);
        ((Intent)localObject).putExtra("KComponentSeekTimeDueWaiting", this.KtV);
        ((Intent)localObject).putExtra("KComponentKComponentCacheTime", this.KtN.getCacheTimeSec());
        ((Intent)localObject).putExtra("KComponentForceLandMode", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)this.KqB).Klp);
        this.KtN.setNeedPause(true);
        paramView.startActivityForResult((Intent)localObject, 2000);
        com.tencent.mm.plugin.report.service.h.IzE.el(1720, 2);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(197855);
        return;
        this.Kti.setVisibility(8);
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        this.Kti.setVisibility(8);
        Log.e("VideoFullScreenActivity", paramView.toString());
      }
    }
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(197864);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "onDoubleTap");
        aE(this.JBl);
        if (!this.Ktg) {
          this.JAZ += 1;
        }
        if (!this.KtN.isPlaying()) {
          continue;
        }
        yp(true);
        this.JAI = 4;
      }
      catch (Throwable paramMotionEvent)
      {
        Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        fQC();
        fKs();
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(197864);
      return false;
      if (!this.JAS) {
        continue;
      }
      fKr();
      cNW();
      this.JAI = 3;
    }
  }
  
  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(197870);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(197870);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(197858);
    try
    {
      Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "onSingleTapConfirmed");
      if (!this.KtQ)
      {
        this.KtQ = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(197858);
        return false;
        this.KtQ = false;
        setFocus(false);
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramMotionEvent.toString());
      }
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(197869);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(197869);
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(197844);
    paramView = this.mBn;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, paramMotionEvent.aFh(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(197844);
    return bool;
  }
  
  public final void tY(int paramInt)
  {
    AppMethodBeat.i(96787);
    Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onSeek time ".concat(String.valueOf(paramInt)));
    this.KtV = paramInt;
    if (this.JAS) {
      fKr();
    }
    for (;;)
    {
      this.knk.removeCallbacks(this.Ktl);
      this.Ktj.setVisibility(8);
      aeL(paramInt);
      this.JAI = 3;
      AppMethodBeat.o(96787);
      return;
      fQC();
      fKs();
    }
  }
  
  public static final class a
  {
    public static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an Kua;
  }
  
  static final class b
  {
    int JGA;
    long JGB;
    int JGC;
    int JGy;
    String JGz;
    int clickCount;
    long fOa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ak
 * JD-Core Version:    0.7.0.1
 */