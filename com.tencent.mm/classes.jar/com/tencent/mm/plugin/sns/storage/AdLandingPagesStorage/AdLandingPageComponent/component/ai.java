package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import com.tencent.mm.g.a.oi;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.vfs.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class ai
  extends ah
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, com.tencent.mm.plugin.sight.decode.ui.b, i.b, i.d
{
  private Context context;
  private ap gIf;
  private ProgressBar gWg;
  private View gZU;
  private GestureDetector iKD;
  private boolean isAutoPlay;
  private volatile boolean isWaiting;
  private int length;
  private ImageView tCh;
  private long wiC;
  private int wji;
  private VideoPlayerSeekBar zFA;
  private ImageView zFB;
  private boolean zFC;
  private ImageView zFD;
  private TextView zFE;
  private Runnable zFF;
  private boolean zFG;
  private boolean zFH;
  private boolean zFI;
  private boolean zFJ;
  private boolean zFK;
  private boolean zFL;
  private boolean zFM;
  private boolean zFN;
  private boolean zFO;
  private boolean zFP;
  private int zFQ;
  private int zFR;
  private int zFS;
  private int zFT;
  private int zFU;
  private al zFV;
  private View.OnClickListener zFW;
  private View.OnClickListener zFX;
  private View.OnClickListener zFY;
  private View.OnClickListener zFZ;
  AdLandingVideoWrapper zFz;
  private ImageView zGG;
  private View zGH;
  private volatile boolean zGI;
  private Runnable zGJ;
  private int zGK;
  private int zGL;
  private View zGO;
  private volatile int zHq;
  private b zHr;
  
  public ai(final Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj paramaj, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaj, paramViewGroup);
    AppMethodBeat.i(96774);
    this.zFG = false;
    this.zFH = false;
    this.zFI = false;
    this.zFJ = true;
    this.zFK = true;
    this.zFL = false;
    this.zFM = true;
    this.isAutoPlay = false;
    this.zFN = false;
    this.zFO = false;
    this.zFP = false;
    this.zFQ = 0;
    this.wiC = 0L;
    this.zFR = 0;
    this.wji = 0;
    this.zFS = 0;
    this.zFT = 0;
    this.zFU = 0;
    this.zFV = null;
    this.zFW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96769);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(ai.this.zFz.isPlaying()) });
        ai.a(ai.this, ai.h(ai.this));
        if (ai.this.zFz.isPlaying())
        {
          ai.i(ai.this);
          ai.a(ai.this, 4);
          if (ai.l(ai.this)) {
            ai.m(ai.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96769);
          return;
        }
        if (ai.j(ai.this)) {
          ai.this.dWl();
        }
        for (;;)
        {
          ai.k(ai.this);
          ai.a(ai.this, 3);
          break;
          ai.this.dWo();
          ai.this.dWn();
        }
      }
    };
    this.zFX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96771);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ai.n(ai.this);
        ai.a(ai.this, ai.h(ai.this));
        if (ai.j(ai.this))
        {
          ai.this.dWo();
          ai.this.dWn();
        }
        for (;;)
        {
          ai.o(ai.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96771);
          return;
          ai.this.dWl();
        }
      }
    };
    this.zFY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96772);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ai.k(ai.this);
        ai.p(ai.this);
        ai.q(ai.this);
        ai.a(ai.this, 3);
        ai.this.dWn();
        ai.a(ai.this, true);
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198056);
            if (ai.r(ai.this))
            {
              AppMethodBeat.o(198056);
              return;
            }
            ai.a(ai.this, false);
            AppMethodBeat.o(198056);
          }
        }, 10000L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(96772);
      }
    };
    this.zFZ = new ai.13(this);
    this.zGI = false;
    this.isWaiting = false;
    this.zHq = 0;
    this.zGK = 0;
    this.zGL = 0;
    this.context = paramContext;
    this.gIf = new ap(Looper.getMainLooper());
    try
    {
      this.iKD = new GestureDetector(this);
      this.zGJ = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96762);
          ai.a(ai.this).setVisibility(8);
          AppMethodBeat.o(96762);
        }
      };
      this.zFF = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198051);
          ai.a(ai.this, false);
          AppMethodBeat.o(198051);
        }
      };
      this.zFV = new al()
      {
        public final void rD(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(198052);
          Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
          if (paramAnonymousBoolean) {}
          for (int i = 1;; i = 0)
          {
            localIntent.putExtra("show", i);
            localIntent.putExtra("activity_code", ai.b(ai.this));
            d.U(paramContext).b(localIntent);
            AppMethodBeat.o(198052);
            return;
          }
        }
      };
      AppMethodBeat.o(96774);
      return;
    }
    catch (Throwable paramaj)
    {
      for (;;)
      {
        ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramaj.toString());
      }
    }
  }
  
  private void Qs(int paramInt)
  {
    AppMethodBeat.i(96779);
    if (this.zFz != null)
    {
      this.zFD.setVisibility(8);
      if (this.tCh.getVisibility() == 0) {
        this.gWg.setVisibility(0);
      }
      this.zFz.c(paramInt, true);
    }
    AppMethodBeat.o(96779);
  }
  
  private void aq(Runnable paramRunnable)
  {
    AppMethodBeat.i(198059);
    try
    {
      this.gIf.removeCallbacks(paramRunnable);
      this.gIf.postDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(198059);
      return;
    }
    catch (Throwable paramRunnable)
    {
      ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramRunnable.toString());
      AppMethodBeat.o(198059);
    }
  }
  
  private void can()
  {
    AppMethodBeat.i(96776);
    ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "starting play, downFailed=" + this.zFN);
    if (this.zFN)
    {
      ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "last download fail ,try again");
      if ((this.zFA != null) && (this.zFA.getParent() != null)) {
        ((ViewGroup)this.zFA.getParent()).removeView(this.zFA);
      }
      this.zFz.setFullScreen(false);
      this.zFz.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zzS, 0);
      try
      {
        int i = this.ltA;
        if ((this.zFA != null) && (this.zFA.getParent() != null)) {
          ((ViewGroup)this.zFA.getParent()).removeView(this.zFA);
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i - com.tencent.mm.cc.a.fromDPToPix(this.context, 75), -2);
        localLayoutParams.addRule(12);
        localLayoutParams.bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 3);
        this.zFA.setLayoutParams(localLayoutParams);
        ((ViewGroup)this.contentView.findViewById(2131298770)).addView(this.zFA, localLayoutParams);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "startPlay exp=" + bt.n(localException));
        }
      }
      Qs(0);
      this.zFz.dXw();
      AppMethodBeat.o(96776);
      return;
    }
    this.gIf.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96763);
        if (!ai.this.zFz.isPlaying())
        {
          if (ai.s(ai.this).getCurrPosSec() != ai.s(ai.this).getVideoDurationSec()) {
            break label65;
          }
          ai.b(ai.this, 0);
        }
        for (;;)
        {
          ai.s(ai.this).dXw();
          AppMethodBeat.o(96763);
          return;
          label65:
          ai.b(ai.this, ai.s(ai.this).getCurrPosSec());
        }
      }
    });
    this.wiC = System.currentTimeMillis();
    this.wji += 1;
    AppMethodBeat.o(96776);
  }
  
  private void rE(boolean paramBoolean)
  {
    AppMethodBeat.i(198058);
    try
    {
      this.zFA.setIsPlay(paramBoolean);
      this.zFA.getPlayBtn().getLayoutParams().width = this.length;
      this.zFA.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "startPlay");
        this.zFA.getPlayBtn().setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691470));
        AppMethodBeat.o(198058);
        return;
      }
      ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "pausePlay");
      this.zFA.getPlayBtn().setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691469));
      AppMethodBeat.o(198058);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(198058);
    }
  }
  
  private void rF(final boolean paramBoolean)
  {
    AppMethodBeat.i(198060);
    ad.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "pause play");
    this.gIf.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96764);
        ai.s(ai.this).pause();
        try
        {
          if ((ai.t(ai.this).getVisibility() != 0) && (paramBoolean))
          {
            ai.a(ai.this).setVisibility(0);
            ai.a(ai.this, ai.u(ai.this));
          }
          ai.b(ai.this, false);
          AppMethodBeat.o(96764);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(96764);
        }
      }
    });
    if (this.wiC != 0L)
    {
      this.zFR = ((int)(this.zFR + (System.currentTimeMillis() - this.wiC)));
      this.wiC = 0L;
    }
    AppMethodBeat.o(198060);
  }
  
  private void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(96778);
    if (paramBoolean)
    {
      this.zFA.setVisibility(0);
      this.zFB.setVisibility(0);
      this.gZU.setVisibility(0);
      this.zGG.setVisibility(0);
      if (this.zFV != null) {
        this.zFV.rD(true);
      }
      aq(this.zFF);
      AppMethodBeat.o(96778);
      return;
    }
    this.zFI = false;
    this.zFA.setVisibility(4);
    this.zFB.setVisibility(8);
    this.gZU.setVisibility(4);
    this.zGG.setVisibility(8);
    if (this.zFV != null) {
      this.zFV.rD(false);
    }
    this.gIf.removeCallbacks(this.zFF);
    AppMethodBeat.o(96778);
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, boolean paramBoolean3, int paramInt7, String paramString)
  {
    AppMethodBeat.i(198070);
    for (;;)
    {
      try
      {
        this.zFQ = 6;
        this.zGI = paramBoolean2;
        this.zGL += 1;
        this.zFT += paramInt2;
        this.zGK += paramInt3;
        this.zFU += paramInt4;
        this.zFS += paramInt5;
        this.wji += paramInt6;
        this.zFR = ((int)(this.zFR + paramLong));
        boolean bool = bt.isNullOrNil(paramString);
        if (!bool) {}
        try
        {
          paramString = new JSONObject(paramString);
          if (this.zHr == null) {
            this.zHr = new b();
          }
          b localb = this.zHr;
          localb.zDL += paramString.optInt("exposureCount");
          localb = this.zHr;
          localb.dBD += paramString.optLong("stayTime");
          localb = this.zHr;
          localb.clickCount += paramString.optInt("clickCount");
          paramString = paramString.optJSONObject("btnInfo");
          this.zHr.zGY = paramString.optString("cid");
          localb = this.zHr;
          localb.zGZ += paramString.optInt("exposureCount");
          localb = this.zHr;
          localb.zHa += paramString.optLong("stayTime");
          localb = this.zHr;
          paramInt2 = localb.zHb;
          localb.zHb = (paramString.optInt("clickCount") + paramInt2);
        }
        catch (Throwable paramString)
        {
          this.zHr = null;
          ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", paramString.toString());
          continue;
        }
        if (paramBoolean2) {
          this.wiC = System.currentTimeMillis();
        }
        this.gIf.removeCallbacks(this.zGJ);
        this.zGH.setVisibility(8);
        ad.i("NonFullOrFullVideoType", "currPosSec = " + paramInt1 + ", isPlaying = " + paramBoolean2 + ", bNoVoice = " + paramBoolean1);
        if (!paramBoolean3) {
          break;
        }
        if ((paramInt7 == this.zFz.getVideoDurationSec()) || (paramInt7 < 0))
        {
          this.zFA.seek(0);
          this.zFz.c(0.0D, true);
          this.wiC = System.currentTimeMillis();
          rE(true);
          if (!paramBoolean1) {
            break label594;
          }
          dWl();
          AppMethodBeat.o(198070);
          return;
        }
      }
      catch (Throwable paramString)
      {
        ad.e("NonFullOrFullVideoType", paramString.toString());
        AppMethodBeat.o(198070);
        return;
      }
      this.zFA.seek(this.zFz.getCacheTimeSec());
      this.zFz.c(this.zFz.getCacheTimeSec(), true);
    }
    if ((paramInt1 == this.zFz.getVideoDurationSec()) || (paramInt1 < 0))
    {
      this.zFA.seek(0);
      this.zFz.c(0.0D, paramBoolean2);
    }
    for (;;)
    {
      rE(paramBoolean2);
      break;
      this.zFA.seek(paramInt1);
      this.zFz.c(paramInt1, paramBoolean2);
    }
    label594:
    dWn();
    AppMethodBeat.o(198070);
  }
  
  public final boolean aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96786);
    if (!super.aQ(paramJSONObject))
    {
      AppMethodBeat.o(96786);
      return false;
    }
    try
    {
      paramJSONObject.put("streamVideoDuraion", this.zFz.getVideoDurationSec() * 1000);
      paramJSONObject.put("playTimeInterval", this.zFR);
      paramJSONObject.put("playCount", this.wji);
      paramJSONObject.put("playCompletedCount", this.zFS);
      paramJSONObject.put("clickFullscreenBtnCount", this.zGL);
      paramJSONObject.put("doubleClickCount", this.zGK);
      paramJSONObject.put("clickPlayControlCount", this.zFT);
      paramJSONObject.put("clickVoiceControlCount", this.zFU);
      if (this.isAutoPlay) {}
      for (Object localObject = "1";; localObject = "0")
      {
        paramJSONObject.put("isAutoPlay", localObject);
        JSONObject localJSONObject;
        if (!this.zFO)
        {
          localObject = com.tencent.mm.sdk.platformtools.ai.ee(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zAV);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        if (!this.zFP)
        {
          localObject = com.tencent.mm.sdk.platformtools.ai.ee(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zzS);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("streamVideoUrlInfo", localJSONObject);
        }
        if (this.zHr != null)
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("cid", this.zHr.zGY);
          ((JSONObject)localObject).put("exposureCount", this.zHr.zGZ);
          ((JSONObject)localObject).put("stayTime", this.zHr.zHa);
          ((JSONObject)localObject).put("clickCount", this.zHr.zHb);
          localJSONObject = new JSONObject();
          localJSONObject.put("exposureCount", this.zHr.zDL);
          localJSONObject.put("stayTime", this.zHr.dBD);
          localJSONObject.put("clickCount", this.zHr.clickCount);
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
      ad.printErrStackTrace("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96786);
    }
  }
  
  public final void aqD()
  {
    AppMethodBeat.i(198062);
    this.zFI = true;
    aq(this.zFF);
    AppMethodBeat.o(198062);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96790);
    ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "online play error, %s", new Object[] { paramString3 });
    this.zFN = true;
    AppMethodBeat.o(96790);
  }
  
  public final void cxt()
  {
    AppMethodBeat.i(198071);
    rF(false);
    this.zFQ = 4;
    AppMethodBeat.o(198071);
  }
  
  public final void cxu()
  {
    AppMethodBeat.i(198072);
    this.zFQ = 3;
    can();
    AppMethodBeat.o(198072);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dRk()
  {
    boolean bool2 = true;
    AppMethodBeat.i(96775);
    Object localObject1 = this.contentView.findViewById(2131298770);
    this.zGO = ((View)localObject1);
    ((View)localObject1).setBackgroundColor(-16777216);
    int k = this.ltA;
    int j = this.ltB;
    int i = j;
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zAW == 1)
    {
      i = j;
      if ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).width > 0) {
        i = k * (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).height / (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).width;
      }
    }
    else
    {
      ((View)localObject1).setPadding((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).paddingLeft, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).paddingTop, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).paddingRight, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).paddingBottom);
    }
    ((View)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(k, i));
    ((View)localObject1).setMinimumHeight(i);
    ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "createView, displayType=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zAW + ", containerW=" + k + ", vH=" + i + ", padding=" + j.eS((View)localObject1));
    this.zFz = ((AdLandingVideoWrapper)((View)localObject1).findViewById(2131306410));
    this.zFz.setIMMVideoViewCallback(this);
    this.zFz.setOnClickListener(this.zFZ);
    this.zFz.setFullScreen(false);
    this.zFz.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zzS, 0);
    this.zFz.setIsShowBasicControls(true);
    Object localObject2;
    if (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zzY)
    {
      ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "fixVideoBlackline, enable=false");
      this.gWg = ((ProgressBar)((View)localObject1).findViewById(2131303535));
      this.tCh = ((ImageView)((View)localObject1).findViewById(2131305798));
      localObject2 = h.jF("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zAV);
      if (!i.fv((String)localObject2)) {
        this.zFO = false;
      }
      if (!this.zFO) {
        break label1351;
      }
      this.tCh.setImageBitmap(g.decodeFile((String)localObject2));
      label409:
      this.zFE = ((TextView)((View)localObject1).findViewById(2131299517));
      this.zFE.setText(this.context.getString(2131758104));
      this.gZU = ((View)localObject1).findViewById(2131304920);
      this.gZU.setVisibility(4);
      this.zFA = new VideoPlayerSeekBar(this.context);
      this.zFA.setVisibility(4);
      if (this.zFV != null)
      {
        localObject2 = this.zFV;
        if (this.zFA.getVisibility() != 0) {
          break label1382;
        }
      }
    }
    label1294:
    label1351:
    label1382:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((al)localObject2).rD(bool1);
      this.zFA.setIplaySeekCallback(this);
      this.zFA.setOnPlayButtonClickListener(this.zFW);
      localObject2 = new RelativeLayout.LayoutParams(k - com.tencent.mm.cc.a.fromDPToPix(this.context, 75), -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      this.zFA.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.zFz.setVideoFooterView(this.zFA);
      this.zFB = ((ImageView)((View)localObject1).findViewById(2131304921));
      this.zFB.setVisibility(4);
      this.zFB.setOnClickListener(this.zFX);
      try
      {
        localObject3 = this.zFB.getParent();
        if ((localObject3 instanceof ViewGroup)) {
          ((ViewGroup)localObject3).removeView(this.zFB);
        }
        localObject3 = (RelativeLayout.LayoutParams)this.zFB.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject3).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localObject1).addView(this.zFB, (ViewGroup.LayoutParams)localObject3);
        ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "init voiceTypeBtn and visible");
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          Object localObject3;
          ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable4.toString());
        }
      }
      this.zFD = ((ImageView)((View)localObject1).findViewById(2131305196));
      this.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
      this.zFD.setVisibility(8);
      this.zFD.setOnClickListener(this.zFY);
      ((ViewGroup)this.zFA.getParent()).removeView(this.zFA);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((ViewGroup)localObject1).addView(this.zFA, (ViewGroup.LayoutParams)localObject2);
      this.zFz.setVideoPlayCallback(new AdLandingVideoWrapper.a()
      {
        public final void tt(int paramAnonymousInt)
        {
          AppMethodBeat.i(198055);
          ai.d(ai.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198054);
              ai.b(ai.this, ai.this.zFz.isPlaying());
              AppMethodBeat.o(198054);
            }
          });
          if ((ai.e(ai.this).zzX != null) && (paramAnonymousInt * 1000 >= ai.e(ai.this).zzX.zAT) && (!ai.f(ai.this)))
          {
            ai.g(ai.this);
            oi localoi = new oi();
            localoi.dCj.dCk = ai.e(ai.this).zzX.dCk;
            com.tencent.mm.sdk.b.a.IbL.l(localoi);
          }
          AppMethodBeat.o(198055);
        }
      });
      localObject1 = this.zGO;
      try
      {
        this.length = com.tencent.mm.cc.a.fromDPToPix(this.context, 32);
        this.zFz.setOnTouchListener(this);
        this.zGG = ((ImageView)((View)localObject1).findViewById(2131307246));
        localObject2 = this.zGG.getParent();
        if ((localObject2 instanceof ViewGroup)) {
          ((ViewGroup)localObject2).removeView(this.zGG);
        }
        localObject2 = (RelativeLayout.LayoutParams)this.zGG.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localObject1).addView(this.zGG, (ViewGroup.LayoutParams)localObject2);
        this.zGG.setOnClickListener(this);
        this.zGG.setVisibility(8);
        ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "init fullScreenBtn and visible");
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          label1150:
          ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable1.toString());
          continue;
          bool1 = false;
        }
      }
      try
      {
        this.zFz.setLoop(true);
        this.zFz.setLoopCompletionCallback(this);
        localObject1 = this.zFA.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.zFA);
        }
        localObject1 = new RelativeLayout.LayoutParams(this.zGO.getLayoutParams().width - com.tencent.mm.cc.a.fromDPToPix(this.context, 75), -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 3);
        this.zFA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((ViewGroup)this.contentView.findViewById(2131298770)).addView(this.zFA, (ViewGroup.LayoutParams)localObject1);
        this.zFA.setVisibility(4);
        rE(false);
        if (this.zFV != null)
        {
          localObject1 = this.zFV;
          if (this.zFA.getVisibility() != 0) {
            break label1418;
          }
          bool1 = bool2;
          ((al)localObject1).rD(bool1);
        }
        ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "init progressBar and visible");
      }
      catch (Throwable localThrowable2)
      {
        ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable2.toString());
        break label1150;
      }
      localObject1 = this.zGO;
      try
      {
        this.zGH = ((View)localObject1).findViewById(2131307220);
        this.zGH.setVisibility(8);
        AppMethodBeat.o(96775);
        return;
      }
      catch (Throwable localThrowable3)
      {
        ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable3.toString());
        AppMethodBeat.o(96775);
      }
      localObject2 = this.zFz.getInnerVideoView();
      localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK;
      if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject3).paddingLeft != 0.0F) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject3).paddingTop != 0.0F) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject3).paddingRight != 0.0F) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject3).paddingBottom != 0.0F)) {}
      for (bool1 = true;; bool1 = false)
      {
        if ((!(localObject2 instanceof VideoPlayerTextureView)) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zAW != 1) || (bool1)) {
          break label1294;
        }
        ((View)localObject2).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
        {
          public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            AppMethodBeat.i(198050);
            try
            {
              paramAnonymousInt1 = paramAnonymousView.getWidth();
              paramAnonymousInt2 = paramAnonymousView.getHeight();
              paramAnonymousInt3 = ai.v(ai.this).getWidth();
              paramAnonymousInt4 = ai.v(ai.this).getHeight();
              if ((paramAnonymousInt2 <= 1) || (paramAnonymousInt1 <= 1) || (paramAnonymousInt3 == 0) || (paramAnonymousInt4 == 0))
              {
                AppMethodBeat.o(198050);
                return;
              }
              ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, videoW=" + paramAnonymousInt1 + ", videoH=" + paramAnonymousInt2 + ", containerW=" + paramAnonymousInt3 + ", containH=" + paramAnonymousInt4 + ", container.padding=" + j.eS(ai.v(ai.this)));
              if (paramAnonymousInt2 == paramAnonymousInt4)
              {
                AppMethodBeat.o(198050);
                return;
              }
              if ((paramAnonymousInt2 >= paramAnonymousInt1) && (paramAnonymousInt4 >= paramAnonymousInt3) && (Math.abs(paramAnonymousInt2 - paramAnonymousInt4) < 2))
              {
                paramAnonymousView = ai.v(ai.this).getLayoutParams();
                paramAnonymousView.height = paramAnonymousInt2;
                ai.v(ai.this).setLayoutParams(paramAnonymousView);
                ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, reset VideoContainer.height");
              }
              AppMethodBeat.o(198050);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, exp=" + paramAnonymousView.toString());
              AppMethodBeat.o(198050);
            }
          }
        });
        break;
      }
      ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, innerVideoView=" + localObject2 + ", displayType=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zAW + ", hasPadding=" + bool1);
      break;
      h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zAV, false, 1000000001, new f.a()
      {
        public final void axG(String paramAnonymousString)
        {
          AppMethodBeat.i(198053);
          if (ai.c(ai.this).getVisibility() == 0) {
            ai.c(ai.this).setImageBitmap(g.decodeFile(paramAnonymousString));
          }
          AppMethodBeat.o(198053);
        }
        
        public final void dRW() {}
        
        public final void dRX() {}
      });
      break label409;
    }
    label1418:
  }
  
  protected final void dRl() {}
  
  public final void dRm()
  {
    AppMethodBeat.i(96782);
    super.dRm();
    AppMethodBeat.o(96782);
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(96783);
    super.dRn();
    rF(false);
    if ((!this.zFL) && (!this.zFM))
    {
      AppMethodBeat.o(96783);
      return;
    }
    this.zFM = false;
    this.zFL = false;
    if (this.zFQ == 1) {
      this.zFQ = 2;
    }
    AppMethodBeat.o(96783);
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(96784);
    super.dRo();
    try
    {
      this.gIf.removeCallbacks(this.zFF);
      this.gIf.removeCallbacks(this.zGJ);
      this.zFz.onUIDestroy();
      AppMethodBeat.o(96784);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable.toString());
      }
    }
  }
  
  public final void dWX()
  {
    AppMethodBeat.i(96791);
    super.dWX();
    rF(false);
    String str = h.jF("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zAV);
    if (i.fv(str))
    {
      this.tCh.setImageBitmap(g.decodeFile(str));
      this.tCh.setVisibility(0);
    }
    AppMethodBeat.o(96791);
  }
  
  public final void dWl()
  {
    AppMethodBeat.i(96780);
    super.dWl();
    this.zFB.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131690341));
    this.zFz.setMute(true);
    this.zFJ = true;
    AppMethodBeat.o(96780);
  }
  
  public final void dWm()
  {
    AppMethodBeat.i(96785);
    super.dWm();
    int i = dWT();
    int j = getView().getHeight();
    ad.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 0) || (j == 0))
    {
      AppMethodBeat.o(96785);
      return;
    }
    if (i < 0)
    {
      AppMethodBeat.o(96785);
      return;
    }
    if (i >= j * 0.5F)
    {
      if ((this.zFL) && (!this.zFM))
      {
        AppMethodBeat.o(96785);
        return;
      }
      this.zFM = false;
      this.zFL = true;
      if (this.zFQ == 6)
      {
        if (this.zGI)
        {
          this.zFQ = 1;
          if (this.zFD.getVisibility() == 0)
          {
            this.zFD.setVisibility(8);
            AppMethodBeat.o(96785);
          }
        }
        else
        {
          this.zFQ = 4;
        }
        AppMethodBeat.o(96785);
        return;
      }
      this.tCh.setVisibility(0);
      NetworkInfo localNetworkInfo = ((ConnectivityManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if ((!this.zFK) || ((this.zFK) && (localNetworkInfo != null) && (localNetworkInfo.getType() == 1)))
      {
        setFocus(true);
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198049);
            if (ai.r(ai.this))
            {
              AppMethodBeat.o(198049);
              return;
            }
            ai.a(ai.this, false);
            AppMethodBeat.o(198049);
          }
        }, 3000L);
      }
      if (this.zFK)
      {
        if ((localNetworkInfo == null) || ((localNetworkInfo != null) && (localNetworkInfo.getType() != 1)))
        {
          this.zFD.setVisibility(0);
          this.isAutoPlay = false;
          this.zFK = false;
          AppMethodBeat.o(96785);
          return;
        }
        this.isAutoPlay = true;
        this.zFK = false;
      }
      if (this.zFQ == 0) {
        if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1))
        {
          if (!this.zFJ) {
            break label351;
          }
          dWl();
          this.zFQ = 1;
        }
      }
      for (;;)
      {
        can();
        label351:
        do
        {
          AppMethodBeat.o(96785);
          return;
          dWn();
          break;
          if (this.zFQ == 2)
          {
            if (this.zFJ) {
              dWl();
            }
            for (;;)
            {
              can();
              this.zFQ = 1;
              AppMethodBeat.o(96785);
              return;
              dWn();
            }
          }
        } while (this.zFQ != 3);
        if (this.zFJ) {
          dWl();
        } else {
          dWn();
        }
      }
    }
    this.zFM = false;
    this.zFL = false;
    rF(false);
    if (this.zFQ == 1) {
      this.zFQ = 2;
    }
    AppMethodBeat.o(96785);
  }
  
  public final void dWn()
  {
    AppMethodBeat.i(96781);
    super.dWn();
    this.zFB.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131690342));
    this.zFz.setMute(false);
    this.zFJ = false;
    AppMethodBeat.o(96781);
  }
  
  public final void dXu()
  {
    AppMethodBeat.i(198063);
    ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLoopCompletion");
    this.zFS += 1;
    if (this.zxX != null) {
      this.zxX.yXA = true;
    }
    AppMethodBeat.o(198063);
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    this.zFN = false;
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96788);
    ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onVideoEnded");
    this.zFS += 1;
    setFocus(true);
    this.zFz.zHS.stopTimer();
    if (this.wiC != 0L)
    {
      this.zFR = ((int)(this.zFR + (System.currentTimeMillis() - this.wiC)));
      this.wiC = 0L;
    }
    this.zFQ = 5;
    this.zFz.onUIPause();
    AppMethodBeat.o(96788);
  }
  
  public final void ds(String paramString1, String paramString2) {}
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96789);
    ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "the onVideoPlay is called!");
    if (this.zxX != null) {
      this.zxX.sendMessage();
    }
    this.tCh.setVisibility(8);
    this.gWg.setVisibility(8);
    try
    {
      this.gIf.removeCallbacks(this.zGJ);
      this.zGH.setVisibility(8);
      rE(true);
      AppMethodBeat.o(96789);
      return;
    }
    catch (Throwable paramString1)
    {
      ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramString1.toString());
      AppMethodBeat.o(96789);
    }
  }
  
  public final void du(String paramString1, String paramString2)
  {
    this.isWaiting = true;
  }
  
  public final void dv(String paramString1, String paramString2)
  {
    this.isWaiting = false;
    this.zHq = 0;
  }
  
  public final void eT(String paramString1, String paramString2) {}
  
  protected final int getLayout()
  {
    return 2131495505;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(198061);
    boolean bool = this.zFz.isPlaying();
    AppMethodBeat.o(198061);
    return bool;
  }
  
  public final void nM(int paramInt)
  {
    AppMethodBeat.i(96787);
    ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onSeek time ".concat(String.valueOf(paramInt)));
    this.zHq = paramInt;
    if (this.zFJ) {
      dWl();
    }
    for (;;)
    {
      this.gIf.removeCallbacks(this.zGJ);
      this.zGH.setVisibility(8);
      Qs(paramInt);
      this.zFQ = 3;
      AppMethodBeat.o(96787);
      return;
      dWo();
      dWn();
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(198065);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    if (paramView.getId() == 2131307246) {
      ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "click full screen btn");
    }
    try
    {
      if ((this.context instanceof SnsAdNativeLandingPagesUI))
      {
        this.zGL += 1;
        this.gIf.removeCallbacks(this.zGJ);
        this.zGH.setVisibility(8);
        paramView = (SnsAdNativeLandingPagesUI)this.context;
        a.zHv = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK;
        com.tencent.mm.plugin.sns.model.ac.ziT = dWZ();
        localObject = new Intent(paramView, VideoFullScreenActivity.class);
        ((Intent)localObject).putExtra("KComponentVideoType", 1);
        ((Intent)localObject).putExtra("KComponentCid", dWV());
        ((Intent)localObject).putExtra("KComponentCurrentTime", this.zFz.getCurrPosSec());
        ((Intent)localObject).putExtra("KComponentTotalTime", this.zFz.getVideoDurationSec());
        ((Intent)localObject).putExtra("KComponentVoiceType", this.zFJ);
        ((Intent)localObject).putExtra("KComponentProgressType", this.zFz.isPlaying());
        ((Intent)localObject).putExtra("KComponentStreamVideoUrlPath", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zzS);
        ((Intent)localObject).putExtra("KComponentIsWaiting", this.isWaiting);
        ((Intent)localObject).putExtra("KComponentSeekTimeDueWaiting", this.zHq);
        ((Intent)localObject).putExtra("KComponentKComponentCacheTime", this.zFz.getCacheTimeSec());
        paramView.startActivityForResult((Intent)localObject, SnsAdNativeLandingPagesUI.zYt);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198065);
        return;
        this.zGG.setVisibility(8);
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        this.zGG.setVisibility(8);
        ad.e("NonFullOrFullVideoType", paramView.toString());
      }
    }
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198067);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "onDoubleTap");
        aq(this.zFF);
        if (!this.zFN) {
          this.zGK += 1;
        }
        if (!this.zFz.isPlaying()) {
          continue;
        }
        rF(true);
        this.zFQ = 4;
      }
      catch (Throwable paramMotionEvent)
      {
        ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        dWo();
        dWn();
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(198067);
      return false;
      if (!this.zFJ) {
        continue;
      }
      dWl();
      can();
      this.zFQ = 3;
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
    AppMethodBeat.i(198069);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(198069);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198066);
    try
    {
      ad.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "onSingleTapConfirmed");
      if (!this.zFI)
      {
        this.zFI = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(198066);
        return false;
        this.zFI = false;
        setFocus(false);
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        ad.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramMotionEvent.toString());
      }
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198068);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(198068);
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198064);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    paramView = this.iKD;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.ahp(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.mq(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(198064);
    return bool;
  }
  
  public static final class a
  {
    public static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj zHv;
  }
  
  static final class b
  {
    int clickCount;
    long dBD;
    int zDL;
    String zGY;
    int zGZ;
    long zHa;
    int zHb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai
 * JD-Core Version:    0.7.0.1
 */