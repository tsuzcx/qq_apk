package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.content.d;
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
import com.tencent.mm.g.a.pb;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
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
import com.tencent.mm.vfs.s;
import org.json.JSONException;
import org.json.JSONObject;

public final class al
  extends ak
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, com.tencent.mm.plugin.sight.decode.ui.b, i.b, i.d
{
  private long AhP;
  private int Aiv;
  AdLandingVideoWrapper EeO;
  private VideoPlayerSeekBar EeP;
  private ImageView EeQ;
  private boolean EeR;
  private ImageView EeS;
  private TextView EeT;
  private Runnable EeU;
  private boolean EeV;
  private boolean EeW;
  private boolean EeX;
  private boolean EeY;
  private boolean EeZ;
  private boolean Efa;
  private boolean Efb;
  private boolean Efc;
  private boolean Efd;
  private boolean Efe;
  private int Eff;
  private int Efg;
  private int Efh;
  private int Efi;
  private int Efj;
  private ao Efk;
  private View.OnClickListener Efl;
  private View.OnClickListener Efm;
  private View.OnClickListener Efn;
  private View.OnClickListener Efo;
  private volatile int EgO;
  private b EgP;
  private ImageView Egd;
  private View Ege;
  private volatile boolean Egf;
  private Runnable Egg;
  private int Egh;
  private int Egi;
  private long Egk;
  private View Egn;
  private Context context;
  private MMHandler hAk;
  private ProgressBar hRO;
  private boolean isAutoPlay;
  private volatile boolean isWaiting;
  private GestureDetector jKk;
  private int length;
  private View maskView;
  private ImageView xdY;
  
  public al(final Context paramContext, am paramam, ViewGroup paramViewGroup)
  {
    super(paramContext, paramam, paramViewGroup);
    AppMethodBeat.i(96774);
    this.EeV = false;
    this.EeW = false;
    this.EeX = false;
    this.EeY = true;
    this.EeZ = true;
    this.Efa = false;
    this.Efb = true;
    this.isAutoPlay = false;
    this.Efc = false;
    this.Efd = false;
    this.Efe = false;
    this.Eff = 0;
    this.AhP = 0L;
    this.Efg = 0;
    this.Aiv = 0;
    this.Efh = 0;
    this.Efi = 0;
    this.Efj = 0;
    this.Efk = null;
    this.Efl = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96769);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(al.this.EeO.isPlaying()) });
        al.a(al.this, al.h(al.this));
        if (al.this.EeO.isPlaying())
        {
          al.i(al.this);
          al.a(al.this, 4);
          if (al.l(al.this)) {
            al.m(al.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96769);
          return;
        }
        if (al.j(al.this)) {
          al.this.fcJ();
        }
        for (;;)
        {
          al.k(al.this);
          al.a(al.this, 3);
          break;
          al.this.fcL();
          al.this.fcK();
        }
      }
    };
    this.Efm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96771);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        al.n(al.this);
        al.a(al.this, al.h(al.this));
        if (al.j(al.this))
        {
          al.this.fcL();
          al.this.fcK();
        }
        for (;;)
        {
          al.o(al.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96771);
          return;
          al.this.fcJ();
        }
      }
    };
    this.Efn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96772);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        al.k(al.this);
        al.p(al.this);
        al.q(al.this);
        al.a(al.this, 3);
        al.this.fcK();
        al.a(al.this, true);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(203083);
            if (al.r(al.this))
            {
              AppMethodBeat.o(203083);
              return;
            }
            al.a(al.this, false);
            AppMethodBeat.o(203083);
          }
        }, 10000L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(96772);
      }
    };
    this.Efo = new al.13(this);
    this.Egf = false;
    this.isWaiting = false;
    this.EgO = 0;
    this.Egh = 0;
    this.Egi = 0;
    this.Egk = 0L;
    this.context = paramContext;
    this.hAk = new MMHandler(Looper.getMainLooper());
    try
    {
      this.jKk = new GestureDetector(this);
      this.Egg = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96762);
          al.a(al.this).setVisibility(8);
          AppMethodBeat.o(96762);
        }
      };
      this.EeU = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203078);
          al.a(al.this, false);
          AppMethodBeat.o(203078);
        }
      };
      this.Efk = new ao()
      {
        public final void vg(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(203079);
          Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
          if (paramAnonymousBoolean) {}
          for (int i = 1;; i = 0)
          {
            localIntent.putExtra("show", i);
            localIntent.putExtra("activity_code", al.b(al.this));
            d.W(paramContext).b(localIntent);
            AppMethodBeat.o(203079);
            return;
          }
        }
      };
      AppMethodBeat.o(96774);
      return;
    }
    catch (Throwable paramam)
    {
      for (;;)
      {
        Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramam.toString());
      }
    }
  }
  
  private void YX(int paramInt)
  {
    AppMethodBeat.i(96779);
    if (this.EeO != null)
    {
      this.EeS.setVisibility(8);
      if (this.xdY.getVisibility() == 0) {
        this.hRO.setVisibility(0);
      }
      this.EeO.c(paramInt, true);
    }
    AppMethodBeat.o(96779);
  }
  
  private void ay(Runnable paramRunnable)
  {
    AppMethodBeat.i(203086);
    try
    {
      this.hAk.removeCallbacks(paramRunnable);
      this.hAk.postDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(203086);
      return;
    }
    catch (Throwable paramRunnable)
    {
      Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramRunnable.toString());
      AppMethodBeat.o(203086);
    }
  }
  
  private void czw()
  {
    AppMethodBeat.i(96776);
    Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "starting play, downFailed=" + this.Efc);
    if (this.Efc)
    {
      Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "last download fail ,try again");
      if ((this.EeP != null) && (this.EeP.getParent() != null)) {
        ((ViewGroup)this.EeP.getParent()).removeView(this.EeP);
      }
      this.EeO.setFullScreen(false);
      this.EeO.c(false, ((am)this.EcX).DYS, 0);
      try
      {
        int i = this.mEX;
        if ((this.EeP != null) && (this.EeP.getParent() != null)) {
          ((ViewGroup)this.EeP.getParent()).removeView(this.EeP);
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i - com.tencent.mm.cb.a.fromDPToPix(this.context, 75), -2);
        localLayoutParams.addRule(12);
        localLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 3);
        this.EeP.setLayoutParams(localLayoutParams);
        ((ViewGroup)this.contentView.findViewById(2131299214)).addView(this.EeP, localLayoutParams);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "startPlay exp=" + Util.stackTraceToString(localException));
        }
      }
      YX(0);
      this.EeO.fdQ();
      AppMethodBeat.o(96776);
      return;
    }
    this.hAk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96763);
        if (!al.this.EeO.isPlaying())
        {
          if (al.s(al.this).getCurrPosSec() != al.s(al.this).getVideoDurationSec()) {
            break label65;
          }
          al.b(al.this, 0);
        }
        for (;;)
        {
          al.s(al.this).fdQ();
          AppMethodBeat.o(96763);
          return;
          label65:
          al.b(al.this, al.s(al.this).getCurrPosSec());
        }
      }
    });
    this.AhP = System.currentTimeMillis();
    this.Aiv += 1;
    AppMethodBeat.o(96776);
  }
  
  private boolean fdN()
  {
    AppMethodBeat.i(203089);
    if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (((am)this.EcX).Eaf))
    {
      AppMethodBeat.o(203089);
      return true;
    }
    AppMethodBeat.o(203089);
    return false;
  }
  
  private void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(96778);
    if (paramBoolean)
    {
      this.EeP.setVisibility(0);
      this.EeQ.setVisibility(0);
      this.maskView.setVisibility(0);
      this.Egd.setVisibility(0);
      if (this.Efk != null) {
        this.Efk.vg(true);
      }
      ay(this.EeU);
      AppMethodBeat.o(96778);
      return;
    }
    this.EeX = false;
    this.EeP.setVisibility(4);
    this.EeQ.setVisibility(8);
    this.maskView.setVisibility(4);
    this.Egd.setVisibility(8);
    if (this.Efk != null) {
      this.Efk.vg(false);
    }
    this.hAk.removeCallbacks(this.EeU);
    AppMethodBeat.o(96778);
  }
  
  private void vh(boolean paramBoolean)
  {
    AppMethodBeat.i(203085);
    try
    {
      this.EeP.setIsPlay(paramBoolean);
      this.EeP.getPlayBtn().getLayoutParams().width = this.length;
      this.EeP.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "startPlay");
        this.EeP.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691079));
        AppMethodBeat.o(203085);
        return;
      }
      Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "pausePlay");
      this.EeP.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691078));
      AppMethodBeat.o(203085);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(203085);
    }
  }
  
  private void vi(final boolean paramBoolean)
  {
    AppMethodBeat.i(203087);
    Log.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "pause play");
    this.hAk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96764);
        al.s(al.this).pause();
        try
        {
          if ((al.t(al.this).getVisibility() != 0) && (paramBoolean))
          {
            al.a(al.this).setVisibility(0);
            al.a(al.this, al.u(al.this));
          }
          al.b(al.this, false);
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
    if (this.AhP != 0L)
    {
      this.Efg = ((int)(this.Efg + (System.currentTimeMillis() - this.AhP)));
      this.AhP = 0L;
    }
    AppMethodBeat.o(203087);
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, boolean paramBoolean3, int paramInt7, String paramString, long paramLong2)
  {
    AppMethodBeat.i(203098);
    for (;;)
    {
      try
      {
        this.EeO.setNeedPause(false);
        this.Eff = 6;
        this.Egk += paramLong2;
        this.Egf = paramBoolean2;
        this.Egi += 1;
        this.Efi += paramInt2;
        this.Egh += paramInt3;
        this.Efj += paramInt4;
        this.Efh += paramInt5;
        this.Aiv += paramInt6;
        this.Efg = ((int)(this.Efg + paramLong1));
        boolean bool = Util.isNullOrNil(paramString);
        if (!bool) {}
        try
        {
          paramString = new JSONObject(paramString);
          if (this.EgP == null) {
            this.EgP = new b();
          }
          b localb = this.EgP;
          localb.Dzo += paramString.optInt("exposureCount");
          localb = this.EgP;
          localb.dUy += paramString.optLong("stayTime");
          localb = this.EgP;
          localb.clickCount += paramString.optInt("clickCount");
          paramString = paramString.optJSONObject("btnInfo");
          this.EgP.Egw = paramString.optString("cid");
          localb = this.EgP;
          localb.Egx += paramString.optInt("exposureCount");
          localb = this.EgP;
          localb.Egy += paramString.optLong("stayTime");
          localb = this.EgP;
          paramInt2 = localb.Egz;
          localb.Egz = (paramString.optInt("clickCount") + paramInt2);
        }
        catch (Throwable paramString)
        {
          this.EgP = null;
          Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", paramString.toString());
          continue;
        }
        if (paramBoolean2) {
          this.AhP = System.currentTimeMillis();
        }
        this.hAk.removeCallbacks(this.Egg);
        this.Ege.setVisibility(8);
        Log.i("VideoFullScreenActivity", "currPosSec = " + paramInt1 + ", isPlaying = " + paramBoolean2 + ", bNoVoice = " + paramBoolean1);
        if (!paramBoolean3) {
          break;
        }
        if ((paramInt7 == this.EeO.getVideoDurationSec()) || (paramInt7 < 0))
        {
          this.EeP.seek(0);
          this.EeO.c(0.0D, true);
          this.AhP = System.currentTimeMillis();
          vh(true);
          if (!paramBoolean1) {
            break label613;
          }
          fcJ();
          AppMethodBeat.o(203098);
          return;
        }
      }
      catch (Throwable paramString)
      {
        Log.e("VideoFullScreenActivity", paramString.toString());
        AppMethodBeat.o(203098);
        return;
      }
      this.EeP.seek(this.EeO.getCacheTimeSec());
      this.EeO.c(this.EeO.getCacheTimeSec(), true);
    }
    if ((paramInt1 == this.EeO.getVideoDurationSec()) || (paramInt1 < 0))
    {
      this.EeP.seek(0);
      this.EeO.c(0.0D, paramBoolean2);
    }
    for (;;)
    {
      vh(paramBoolean2);
      break;
      this.EeP.seek(paramInt1);
      this.EeO.c(paramInt1, paramBoolean2);
    }
    label613:
    fcK();
    AppMethodBeat.o(203098);
  }
  
  public final void aJq()
  {
    AppMethodBeat.i(203090);
    this.EeX = true;
    ay(this.EeU);
    AppMethodBeat.o(203090);
  }
  
  public final boolean bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96786);
    if (!super.bp(paramJSONObject))
    {
      AppMethodBeat.o(96786);
      return false;
    }
    try
    {
      paramJSONObject.put("streamVideoDuraion", this.EeO.getVideoDurationSec() * 1000);
      paramJSONObject.put("playTimeInterval", this.Efg);
      paramJSONObject.put("playCount", this.Aiv);
      paramJSONObject.put("playCompletedCount", this.Efh);
      paramJSONObject.put("clickFullscreenBtnCount", this.Egi);
      paramJSONObject.put("doubleClickCount", this.Egh);
      paramJSONObject.put("clickPlayControlCount", this.Efi);
      paramJSONObject.put("clickVoiceControlCount", this.Efj);
      if (this.isAutoPlay) {}
      for (Object localObject = "1";; localObject = "0")
      {
        paramJSONObject.put("isAutoPlay", localObject);
        JSONObject localJSONObject;
        if (!this.Efd)
        {
          localObject = MD5Util.getMD5String(((am)this.EcX).Ead);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        if (!this.Efe)
        {
          localObject = MD5Util.getMD5String(((am)this.EcX).DYS);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("streamVideoUrlInfo", localJSONObject);
        }
        if (this.EgP != null)
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("cid", this.EgP.Egw);
          ((JSONObject)localObject).put("exposureCount", this.EgP.Egx);
          ((JSONObject)localObject).put("stayTime", this.EgP.Egy);
          ((JSONObject)localObject).put("clickCount", this.EgP.Egz);
          localJSONObject = new JSONObject();
          localJSONObject.put("exposureCount", this.EgP.Dzo);
          localJSONObject.put("stayTime", this.EgP.dUy);
          localJSONObject.put("clickCount", this.EgP.clickCount);
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
    this.Efc = true;
    AppMethodBeat.o(96790);
  }
  
  public final void cWX()
  {
    AppMethodBeat.i(203099);
    vi(false);
    this.Eff = 4;
    AppMethodBeat.o(203099);
  }
  
  public final void cWY()
  {
    AppMethodBeat.i(203100);
    this.Eff = 3;
    czw();
    AppMethodBeat.o(203100);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dH(String paramString1, String paramString2)
  {
    this.Efc = false;
  }
  
  public final void dI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96788);
    Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onVideoEnded");
    this.Efh += 1;
    setFocus(true);
    this.EeO.Ehq.stopTimer();
    if (this.AhP != 0L)
    {
      this.Efg = ((int)(this.Efg + (System.currentTimeMillis() - this.AhP)));
      this.AhP = 0L;
    }
    this.Eff = 5;
    this.EeO.onUIPause();
    AppMethodBeat.o(96788);
  }
  
  public final void dJ(String paramString1, String paramString2) {}
  
  public final void dK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96789);
    Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "the onVideoPlay is called!");
    if (this.DXu != null) {
      this.DXu.sendMessage();
    }
    this.xdY.setVisibility(8);
    this.hRO.setVisibility(8);
    try
    {
      this.hAk.removeCallbacks(this.Egg);
      this.Ege.setVisibility(8);
      vh(true);
      AppMethodBeat.o(96789);
      return;
    }
    catch (Throwable paramString1)
    {
      Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramString1.toString());
      AppMethodBeat.o(96789);
    }
  }
  
  public final void dL(String paramString1, String paramString2)
  {
    this.isWaiting = true;
  }
  
  public final void dM(String paramString1, String paramString2)
  {
    this.isWaiting = false;
    this.EgO = 0;
  }
  
  protected final void eWT() {}
  
  public final void eWZ()
  {
    AppMethodBeat.i(96782);
    super.eWZ();
    AppMethodBeat.o(96782);
  }
  
  public final void eXa()
  {
    AppMethodBeat.i(96783);
    super.eXa();
    this.EeO.setNeedPause(true);
    vi(false);
    if ((!this.Efa) && (!this.Efb))
    {
      AppMethodBeat.o(96783);
      return;
    }
    this.Efb = false;
    this.Efa = false;
    if (this.Eff == 1) {
      this.Eff = 2;
    }
    AppMethodBeat.o(96783);
  }
  
  public final void eXb()
  {
    AppMethodBeat.i(96785);
    super.eXb();
    int i = fdl();
    int j = getView().getHeight();
    Log.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 0) || (j == 0))
    {
      this.EeO.setNeedPause(true);
      AppMethodBeat.o(96785);
      return;
    }
    if (i < 0)
    {
      this.EeO.setNeedPause(true);
      AppMethodBeat.o(96785);
      return;
    }
    if (i >= j * 0.5F)
    {
      if ((this.Efa) && (!this.Efb))
      {
        AppMethodBeat.o(96785);
        return;
      }
      this.EeO.setNeedPause(false);
      this.Efb = false;
      this.Efa = true;
      if (this.Eff == 6)
      {
        if (this.Egf)
        {
          this.Eff = 1;
          if (this.EeS.getVisibility() == 0)
          {
            this.EeS.setVisibility(8);
            AppMethodBeat.o(96785);
          }
        }
        else
        {
          this.Eff = 4;
        }
        AppMethodBeat.o(96785);
        return;
      }
      this.xdY.setVisibility(0);
      if ((!this.EeZ) || ((this.EeZ) && (fdN())))
      {
        setFocus(true);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(203076);
            if (al.r(al.this))
            {
              AppMethodBeat.o(203076);
              return;
            }
            al.a(al.this, false);
            AppMethodBeat.o(203076);
          }
        }, 3000L);
      }
      if (this.EeZ)
      {
        if (!fdN())
        {
          this.EeS.setVisibility(0);
          this.isAutoPlay = false;
          this.EeZ = false;
          AppMethodBeat.o(96785);
          return;
        }
        this.isAutoPlay = true;
        this.EeZ = false;
      }
      if (this.Eff == 0)
      {
        if (fdN())
        {
          if (this.EeY) {
            fcJ();
          }
          for (;;)
          {
            this.Eff = 1;
            czw();
            AppMethodBeat.o(96785);
            return;
            fcK();
          }
        }
      }
      else
      {
        if (this.Eff == 2)
        {
          if (this.EeY) {
            fcJ();
          }
          for (;;)
          {
            czw();
            this.Eff = 1;
            AppMethodBeat.o(96785);
            return;
            fcK();
          }
        }
        if (this.Eff == 3)
        {
          if (this.EeY) {
            fcJ();
          }
          for (;;)
          {
            czw();
            AppMethodBeat.o(96785);
            return;
            fcK();
          }
        }
      }
    }
    else
    {
      this.Efb = false;
      this.Efa = false;
      this.EeO.setNeedPause(true);
      vi(false);
      if (this.Eff == 1) {
        this.Eff = 2;
      }
    }
    AppMethodBeat.o(96785);
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(96784);
    super.eXd();
    try
    {
      this.hAk.removeCallbacks(this.EeU);
      this.hAk.removeCallbacks(this.Egg);
      this.EeO.onUIDestroy();
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
  
  public final void eXe()
  {
    boolean bool2 = true;
    AppMethodBeat.i(96775);
    Object localObject1 = this.contentView.findViewById(2131299214);
    this.Egn = ((View)localObject1);
    ((View)localObject1).setBackgroundColor(-16777216);
    int k = this.mEX;
    int j = this.mEY;
    int i = j;
    if (((am)this.EcX).Eae == 1)
    {
      i = j;
      if ((int)((am)this.EcX).width > 0) {
        i = k * (int)((am)this.EcX).height / (int)((am)this.EcX).width;
      }
    }
    else
    {
      ((View)localObject1).setPadding((int)((am)this.EcX).paddingLeft, (int)((am)this.EcX).paddingTop, (int)((am)this.EcX).paddingRight, (int)((am)this.EcX).paddingBottom);
    }
    ((View)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(k, i));
    ((View)localObject1).setMinimumHeight(i);
    Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "createView, displayType=" + ((am)this.EcX).Eae + ", containerW=" + k + ", vH=" + i + ", padding=" + k.fg((View)localObject1));
    this.EeO = ((AdLandingVideoWrapper)((View)localObject1).findViewById(2131309841));
    this.EeO.setIMMVideoViewCallback(this);
    this.EeO.setOnClickListener(this.Efo);
    this.EeO.setFullScreen(false);
    this.EeO.c(false, ((am)this.EcX).DYS, 0);
    this.EeO.setIsShowBasicControls(true);
    Object localObject2;
    if (!((am)this.EcX).DYY)
    {
      Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "fixVideoBlackline, enable=false");
      this.hRO = ((ProgressBar)((View)localObject1).findViewById(2131306302));
      this.xdY = ((ImageView)((View)localObject1).findViewById(2131309073));
      localObject2 = h.kz("adId", ((am)this.EcX).Ead);
      if (!s.YS((String)localObject2)) {
        this.Efd = false;
      }
      if (!this.Efd) {
        break label1351;
      }
      this.xdY.setImageBitmap(BitmapUtil.decodeFile((String)localObject2));
      label409:
      this.EeT = ((TextView)((View)localObject1).findViewById(2131300154));
      this.EeT.setText(this.context.getString(2131758370));
      this.maskView = ((View)localObject1).findViewById(2131308056);
      this.maskView.setVisibility(4);
      this.EeP = new VideoPlayerSeekBar(this.context);
      this.EeP.setVisibility(4);
      if (this.Efk != null)
      {
        localObject2 = this.Efk;
        if (this.EeP.getVisibility() != 0) {
          break label1382;
        }
      }
    }
    label1294:
    label1351:
    label1382:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((ao)localObject2).vg(bool1);
      this.EeP.setIplaySeekCallback(this);
      this.EeP.setOnPlayButtonClickListener(this.Efl);
      localObject2 = new RelativeLayout.LayoutParams(k - com.tencent.mm.cb.a.fromDPToPix(this.context, 75), -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      this.EeP.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.EeO.setVideoFooterView(this.EeP);
      this.EeQ = ((ImageView)((View)localObject1).findViewById(2131308058));
      this.EeQ.setVisibility(4);
      this.EeQ.setOnClickListener(this.Efm);
      try
      {
        localObject3 = this.EeQ.getParent();
        if ((localObject3 instanceof ViewGroup)) {
          ((ViewGroup)localObject3).removeView(this.EeQ);
        }
        localObject3 = (RelativeLayout.LayoutParams)this.EeQ.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject3).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localObject1).addView(this.EeQ, (ViewGroup.LayoutParams)localObject3);
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
      this.EeS = ((ImageView)((View)localObject1).findViewById(2131308392));
      this.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691480));
      this.EeS.setVisibility(8);
      this.EeS.setOnClickListener(this.Efn);
      ((ViewGroup)this.EeP.getParent()).removeView(this.EeP);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((ViewGroup)localObject1).addView(this.EeP, (ViewGroup.LayoutParams)localObject2);
      this.EeO.setVideoPlayCallback(new AdLandingVideoWrapper.a()
      {
        public final void xv(int paramAnonymousInt)
        {
          AppMethodBeat.i(203082);
          al.d(al.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(203081);
              al.b(al.this, al.this.EeO.isPlaying());
              AppMethodBeat.o(203081);
            }
          });
          if ((al.e(al.this).DYX != null) && (paramAnonymousInt * 1000 >= al.e(al.this).DYX.Eab) && (!al.f(al.this)))
          {
            al.g(al.this);
            pb localpb = new pb();
            localpb.dVd.dVe = al.e(al.this).DYX.dVe;
            EventCenter.instance.publish(localpb);
          }
          AppMethodBeat.o(203082);
        }
      });
      localObject1 = this.Egn;
      try
      {
        this.length = com.tencent.mm.cb.a.fromDPToPix(this.context, 32);
        this.EeO.setOnTouchListener(this);
        this.Egd = ((ImageView)((View)localObject1).findViewById(2131308057));
        localObject2 = this.Egd.getParent();
        if ((localObject2 instanceof ViewGroup)) {
          ((ViewGroup)localObject2).removeView(this.Egd);
        }
        localObject2 = (RelativeLayout.LayoutParams)this.Egd.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localObject1).addView(this.Egd, (ViewGroup.LayoutParams)localObject2);
        this.Egd.setOnClickListener(this);
        this.Egd.setVisibility(8);
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
        this.EeO.setLoop(true);
        this.EeO.setLoopCompletionCallback(this);
        localObject1 = this.EeP.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.EeP);
        }
        localObject1 = new RelativeLayout.LayoutParams(this.Egn.getLayoutParams().width - com.tencent.mm.cb.a.fromDPToPix(this.context, 75), -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 3);
        this.EeP.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((ViewGroup)this.contentView.findViewById(2131299214)).addView(this.EeP, (ViewGroup.LayoutParams)localObject1);
        this.EeP.setVisibility(4);
        vh(false);
        if (this.Efk != null)
        {
          localObject1 = this.Efk;
          if (this.EeP.getVisibility() != 0) {
            break label1418;
          }
          bool1 = bool2;
          ((ao)localObject1).vg(bool1);
        }
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "init progressBar and visible");
      }
      catch (Throwable localThrowable2)
      {
        Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable2.toString());
        break label1150;
      }
      localObject1 = this.Egn;
      try
      {
        this.Ege = ((View)localObject1).findViewById(2131305803);
        this.Ege.setVisibility(8);
        AppMethodBeat.o(96775);
        return;
      }
      catch (Throwable localThrowable3)
      {
        Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable3.toString());
        AppMethodBeat.o(96775);
      }
      localObject2 = this.EeO.getInnerVideoView();
      localObject3 = (am)this.EcX;
      if ((((am)localObject3).paddingLeft != 0.0F) || (((am)localObject3).paddingTop != 0.0F) || (((am)localObject3).paddingRight != 0.0F) || (((am)localObject3).paddingBottom != 0.0F)) {}
      for (bool1 = true;; bool1 = false)
      {
        if ((!(localObject2 instanceof VideoPlayerTextureView)) || (((am)this.EcX).Eae != 1) || (bool1)) {
          break label1294;
        }
        ((View)localObject2).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
        {
          public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            AppMethodBeat.i(203077);
            try
            {
              paramAnonymousInt1 = paramAnonymousView.getWidth();
              paramAnonymousInt2 = paramAnonymousView.getHeight();
              paramAnonymousInt3 = al.v(al.this).getWidth();
              paramAnonymousInt4 = al.v(al.this).getHeight();
              if ((paramAnonymousInt2 <= 1) || (paramAnonymousInt1 <= 1) || (paramAnonymousInt3 == 0) || (paramAnonymousInt4 == 0))
              {
                AppMethodBeat.o(203077);
                return;
              }
              Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, videoW=" + paramAnonymousInt1 + ", videoH=" + paramAnonymousInt2 + ", containerW=" + paramAnonymousInt3 + ", containH=" + paramAnonymousInt4 + ", container.padding=" + k.fg(al.v(al.this)));
              if (paramAnonymousInt2 == paramAnonymousInt4)
              {
                AppMethodBeat.o(203077);
                return;
              }
              if ((paramAnonymousInt2 >= paramAnonymousInt1) && (paramAnonymousInt4 >= paramAnonymousInt3) && (Math.abs(paramAnonymousInt2 - paramAnonymousInt4) < 2))
              {
                paramAnonymousView = al.v(al.this).getLayoutParams();
                paramAnonymousView.height = paramAnonymousInt2;
                al.v(al.this).setLayoutParams(paramAnonymousView);
                Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, reset VideoContainer.height");
              }
              AppMethodBeat.o(203077);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, exp=" + paramAnonymousView.toString());
              AppMethodBeat.o(203077);
            }
          }
        });
        break;
      }
      Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, innerVideoView=" + localObject2 + ", displayType=" + ((am)this.EcX).Eae + ", hasPadding=" + bool1);
      break;
      h.a("adId", ((am)this.EcX).Ead, false, 1000000001, new f.a()
      {
        public final void aNH(String paramAnonymousString)
        {
          AppMethodBeat.i(203080);
          if (al.c(al.this).getVisibility() == 0) {
            al.c(al.this).setImageBitmap(BitmapUtil.decodeFile(paramAnonymousString));
          }
          AppMethodBeat.o(203080);
        }
        
        public final void eWN() {}
        
        public final void eWO() {}
      });
      break label409;
    }
    label1418:
  }
  
  public final void fcJ()
  {
    AppMethodBeat.i(96780);
    super.fcJ();
    this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131690469));
    this.EeO.setMute(true);
    this.EeY = true;
    AppMethodBeat.o(96780);
  }
  
  public final void fcK()
  {
    AppMethodBeat.i(96781);
    super.fcK();
    this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131690470));
    this.EeO.setMute(false);
    this.EeY = false;
    AppMethodBeat.o(96781);
  }
  
  public final void fdO()
  {
    AppMethodBeat.i(203091);
    Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLoopCompletion");
    this.Efh += 1;
    if (this.DXu != null) {
      this.DXu.Duo = true;
    }
    AppMethodBeat.o(203091);
  }
  
  public final long fdo()
  {
    AppMethodBeat.i(203101);
    long l1 = super.fdo();
    long l2 = this.Egk;
    AppMethodBeat.o(203101);
    return l1 + l2;
  }
  
  public final void fdq()
  {
    AppMethodBeat.i(96791);
    super.fdq();
    vi(false);
    String str = h.kz("adId", ((am)this.EcX).Ead);
    if (s.YS(str))
    {
      this.xdY.setImageBitmap(BitmapUtil.decodeFile(str));
      this.xdY.setVisibility(0);
    }
    AppMethodBeat.o(96791);
  }
  
  public final void fo(String paramString1, String paramString2) {}
  
  protected final int getLayout()
  {
    return 2131496390;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(203088);
    boolean bool = this.EeO.isPlaying();
    AppMethodBeat.o(203088);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203093);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (paramView.getId() == 2131308057) {
      Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "click full screen btn");
    }
    try
    {
      if ((this.context instanceof SnsAdNativeLandingPagesUI))
      {
        this.Egi += 1;
        this.hAk.removeCallbacks(this.Egg);
        this.Ege.setVisibility(8);
        paramView = (SnsAdNativeLandingPagesUI)this.context;
        a.EgT = (am)this.EcX;
        com.tencent.mm.plugin.sns.model.ae.DJT = fds();
        localObject = new Intent(paramView, VideoFullScreenActivity.class);
        ((Intent)localObject).putExtra("KComponentVideoType", 1);
        ((Intent)localObject).putExtra("KComponentCid", fdn());
        ((Intent)localObject).putExtra("KComponentCurrentTime", this.EeO.getCurrPosSec());
        ((Intent)localObject).putExtra("KComponentTotalTime", this.EeO.getVideoDurationSec());
        ((Intent)localObject).putExtra("KComponentVoiceType", this.EeY);
        ((Intent)localObject).putExtra("KComponentProgressType", this.EeO.isPlaying());
        ((Intent)localObject).putExtra("KComponentStreamVideoUrlPath", ((am)this.EcX).DYS);
        ((Intent)localObject).putExtra("KComponentIsWaiting", this.isWaiting);
        ((Intent)localObject).putExtra("KComponentSeekTimeDueWaiting", this.EgO);
        ((Intent)localObject).putExtra("KComponentKComponentCacheTime", this.EeO.getCacheTimeSec());
        ((Intent)localObject).putExtra("KComponentForceLandMode", ((am)this.EcX).Eag);
        this.EeO.setNeedPause(true);
        paramView.startActivityForResult((Intent)localObject, 2000);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203093);
        return;
        this.Egd.setVisibility(8);
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        this.Egd.setVisibility(8);
        Log.e("VideoFullScreenActivity", paramView.toString());
      }
    }
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(203095);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "onDoubleTap");
        ay(this.EeU);
        if (!this.Efc) {
          this.Egh += 1;
        }
        if (!this.EeO.isPlaying()) {
          continue;
        }
        vi(true);
        this.Eff = 4;
      }
      catch (Throwable paramMotionEvent)
      {
        Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        fcL();
        fcK();
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(203095);
      return false;
      if (!this.EeY) {
        continue;
      }
      fcJ();
      czw();
      this.Eff = 3;
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
    AppMethodBeat.i(203097);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(203097);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(203094);
    try
    {
      Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "onSingleTapConfirmed");
      if (!this.EeX)
      {
        this.EeX = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(203094);
        return false;
        this.EeX = false;
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
    AppMethodBeat.i(203096);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(203096);
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(203092);
    paramView = this.jKk;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.axQ(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(203092);
    return bool;
  }
  
  public final void rk(int paramInt)
  {
    AppMethodBeat.i(96787);
    Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onSeek time ".concat(String.valueOf(paramInt)));
    this.EgO = paramInt;
    if (this.EeY) {
      fcJ();
    }
    for (;;)
    {
      this.hAk.removeCallbacks(this.Egg);
      this.Ege.setVisibility(8);
      YX(paramInt);
      this.Eff = 3;
      AppMethodBeat.o(96787);
      return;
      fcL();
      fcK();
    }
  }
  
  public static final class a
  {
    public static am EgT;
  }
  
  static final class b
  {
    int Dzo;
    String Egw;
    int Egx;
    long Egy;
    int Egz;
    int clickCount;
    long dUy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al
 * JD-Core Version:    0.7.0.1
 */