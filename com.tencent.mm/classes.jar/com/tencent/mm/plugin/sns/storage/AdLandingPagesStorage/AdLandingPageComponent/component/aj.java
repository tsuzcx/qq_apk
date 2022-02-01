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
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import org.json.JSONException;
import org.json.JSONObject;

public final class aj
  extends ai
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, com.tencent.mm.plugin.sight.decode.ui.b, i.b, i.d
{
  private Context context;
  private aq gKO;
  private ProgressBar gYT;
  private View hcH;
  private GestureDetector iNw;
  private boolean isAutoPlay;
  private volatile boolean isWaiting;
  private int length;
  private ImageView tMY;
  private int wyN;
  private long wyh;
  AdLandingVideoWrapper zWF;
  private VideoPlayerSeekBar zWG;
  private ImageView zWH;
  private boolean zWI;
  private ImageView zWJ;
  private TextView zWK;
  private Runnable zWL;
  private boolean zWM;
  private boolean zWN;
  private boolean zWO;
  private boolean zWP;
  private boolean zWQ;
  private boolean zWR;
  private boolean zWS;
  private boolean zWT;
  private boolean zWU;
  private boolean zWV;
  private int zWW;
  private int zWX;
  private int zWY;
  private int zWZ;
  private ImageView zXO;
  private View zXP;
  private volatile boolean zXQ;
  private Runnable zXR;
  private int zXS;
  private int zXT;
  private View zXW;
  private int zXa;
  private am zXb;
  private View.OnClickListener zXc;
  private View.OnClickListener zXd;
  private View.OnClickListener zXe;
  private View.OnClickListener zXf;
  private volatile int zYx;
  private b zYy;
  
  public aj(final Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak paramak, ViewGroup paramViewGroup)
  {
    super(paramContext, paramak, paramViewGroup);
    AppMethodBeat.i(96774);
    this.zWM = false;
    this.zWN = false;
    this.zWO = false;
    this.zWP = true;
    this.zWQ = true;
    this.zWR = false;
    this.zWS = true;
    this.isAutoPlay = false;
    this.zWT = false;
    this.zWU = false;
    this.zWV = false;
    this.zWW = 0;
    this.wyh = 0L;
    this.zWX = 0;
    this.wyN = 0;
    this.zWY = 0;
    this.zWZ = 0;
    this.zXa = 0;
    this.zXb = null;
    this.zXc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96769);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(aj.this.zWF.isPlaying()) });
        aj.a(aj.this, aj.h(aj.this));
        if (aj.this.zWF.isPlaying())
        {
          aj.i(aj.this);
          aj.a(aj.this, 4);
          if (aj.l(aj.this)) {
            aj.m(aj.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96769);
          return;
        }
        if (aj.j(aj.this)) {
          aj.this.dZN();
        }
        for (;;)
        {
          aj.k(aj.this);
          aj.a(aj.this, 3);
          break;
          aj.this.dZQ();
          aj.this.dZP();
        }
      }
    };
    this.zXd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96771);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        aj.n(aj.this);
        aj.a(aj.this, aj.h(aj.this));
        if (aj.j(aj.this))
        {
          aj.this.dZQ();
          aj.this.dZP();
        }
        for (;;)
        {
          aj.o(aj.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96771);
          return;
          aj.this.dZN();
        }
      }
    };
    this.zXe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96772);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        aj.k(aj.this);
        aj.p(aj.this);
        aj.q(aj.this);
        aj.a(aj.this, 3);
        aj.this.dZP();
        aj.a(aj.this, true);
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219568);
            if (aj.r(aj.this))
            {
              AppMethodBeat.o(219568);
              return;
            }
            aj.a(aj.this, false);
            AppMethodBeat.o(219568);
          }
        }, 10000L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(96772);
      }
    };
    this.zXf = new aj.13(this);
    this.zXQ = false;
    this.isWaiting = false;
    this.zYx = 0;
    this.zXS = 0;
    this.zXT = 0;
    this.context = paramContext;
    this.gKO = new aq(Looper.getMainLooper());
    try
    {
      this.iNw = new GestureDetector(this);
      this.zXR = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96762);
          aj.a(aj.this).setVisibility(8);
          AppMethodBeat.o(96762);
        }
      };
      this.zWL = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219563);
          aj.a(aj.this, false);
          AppMethodBeat.o(219563);
        }
      };
      this.zXb = new am()
      {
        public final void rK(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(219564);
          Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
          if (paramAnonymousBoolean) {}
          for (int i = 1;; i = 0)
          {
            localIntent.putExtra("show", i);
            localIntent.putExtra("activity_code", aj.b(aj.this));
            d.V(paramContext).b(localIntent);
            AppMethodBeat.o(219564);
            return;
          }
        }
      };
      AppMethodBeat.o(96774);
      return;
    }
    catch (Throwable paramak)
    {
      for (;;)
      {
        ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramak.toString());
      }
    }
  }
  
  private void QZ(int paramInt)
  {
    AppMethodBeat.i(96779);
    if (this.zWF != null)
    {
      this.zWJ.setVisibility(8);
      if (this.tMY.getVisibility() == 0) {
        this.gYT.setVisibility(0);
      }
      this.zWF.c(paramInt, true);
    }
    AppMethodBeat.o(96779);
  }
  
  private void ao(Runnable paramRunnable)
  {
    AppMethodBeat.i(219571);
    try
    {
      this.gKO.removeCallbacks(paramRunnable);
      this.gKO.postDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(219571);
      return;
    }
    catch (Throwable paramRunnable)
    {
      ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramRunnable.toString());
      AppMethodBeat.o(219571);
    }
  }
  
  private void cbC()
  {
    AppMethodBeat.i(96776);
    ae.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "starting play, downFailed=" + this.zWT);
    if (this.zWT)
    {
      ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "last download fail ,try again");
      if ((this.zWG != null) && (this.zWG.getParent() != null)) {
        ((ViewGroup)this.zWG.getParent()).removeView(this.zWG);
      }
      this.zWF.setFullScreen(false);
      this.zWF.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zQR, 0);
      try
      {
        int i = this.lxZ;
        if ((this.zWG != null) && (this.zWG.getParent() != null)) {
          ((ViewGroup)this.zWG.getParent()).removeView(this.zWG);
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i - com.tencent.mm.cb.a.fromDPToPix(this.context, 75), -2);
        localLayoutParams.addRule(12);
        localLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 3);
        this.zWG.setLayoutParams(localLayoutParams);
        ((ViewGroup)this.contentView.findViewById(2131298770)).addView(this.zWG, localLayoutParams);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "startPlay exp=" + bu.o(localException));
        }
      }
      QZ(0);
      this.zWF.eaZ();
      AppMethodBeat.o(96776);
      return;
    }
    this.gKO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96763);
        if (!aj.this.zWF.isPlaying())
        {
          if (aj.s(aj.this).getCurrPosSec() != aj.s(aj.this).getVideoDurationSec()) {
            break label65;
          }
          aj.b(aj.this, 0);
        }
        for (;;)
        {
          aj.s(aj.this).eaZ();
          AppMethodBeat.o(96763);
          return;
          label65:
          aj.b(aj.this, aj.s(aj.this).getCurrPosSec());
        }
      }
    });
    this.wyh = System.currentTimeMillis();
    this.wyN += 1;
    AppMethodBeat.o(96776);
  }
  
  private void rL(boolean paramBoolean)
  {
    AppMethodBeat.i(219570);
    try
    {
      this.zWG.setIsPlay(paramBoolean);
      this.zWG.getPlayBtn().getLayoutParams().width = this.length;
      this.zWG.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        ae.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "startPlay");
        this.zWG.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691470));
        AppMethodBeat.o(219570);
        return;
      }
      ae.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "pausePlay");
      this.zWG.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691469));
      AppMethodBeat.o(219570);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(219570);
    }
  }
  
  private void rM(final boolean paramBoolean)
  {
    AppMethodBeat.i(219572);
    ae.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "pause play");
    this.gKO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96764);
        aj.s(aj.this).pause();
        try
        {
          if ((aj.t(aj.this).getVisibility() != 0) && (paramBoolean))
          {
            aj.a(aj.this).setVisibility(0);
            aj.a(aj.this, aj.u(aj.this));
          }
          aj.b(aj.this, false);
          AppMethodBeat.o(96764);
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(96764);
        }
      }
    });
    if (this.wyh != 0L)
    {
      this.zWX = ((int)(this.zWX + (System.currentTimeMillis() - this.wyh)));
      this.wyh = 0L;
    }
    AppMethodBeat.o(219572);
  }
  
  private void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(96778);
    if (paramBoolean)
    {
      this.zWG.setVisibility(0);
      this.zWH.setVisibility(0);
      this.hcH.setVisibility(0);
      this.zXO.setVisibility(0);
      if (this.zXb != null) {
        this.zXb.rK(true);
      }
      ao(this.zWL);
      AppMethodBeat.o(96778);
      return;
    }
    this.zWO = false;
    this.zWG.setVisibility(4);
    this.zWH.setVisibility(8);
    this.hcH.setVisibility(4);
    this.zXO.setVisibility(8);
    if (this.zXb != null) {
      this.zXb.rK(false);
    }
    this.gKO.removeCallbacks(this.zWL);
    AppMethodBeat.o(96778);
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, boolean paramBoolean3, int paramInt7, String paramString)
  {
    AppMethodBeat.i(219582);
    for (;;)
    {
      try
      {
        this.zWW = 6;
        this.zXQ = paramBoolean2;
        this.zXT += 1;
        this.zWZ += paramInt2;
        this.zXS += paramInt3;
        this.zXa += paramInt4;
        this.zWY += paramInt5;
        this.wyN += paramInt6;
        this.zWX = ((int)(this.zWX + paramLong));
        boolean bool = bu.isNullOrNil(paramString);
        if (!bool) {}
        try
        {
          paramString = new JSONObject(paramString);
          if (this.zYy == null) {
            this.zYy = new b();
          }
          b localb = this.zYy;
          localb.zUQ += paramString.optInt("exposureCount");
          localb = this.zYy;
          localb.dCI += paramString.optLong("stayTime");
          localb = this.zYy;
          localb.clickCount += paramString.optInt("clickCount");
          paramString = paramString.optJSONObject("btnInfo");
          this.zYy.zYf = paramString.optString("cid");
          localb = this.zYy;
          localb.zYg += paramString.optInt("exposureCount");
          localb = this.zYy;
          localb.zYh += paramString.optLong("stayTime");
          localb = this.zYy;
          paramInt2 = localb.zYi;
          localb.zYi = (paramString.optInt("clickCount") + paramInt2);
        }
        catch (Throwable paramString)
        {
          this.zYy = null;
          ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", paramString.toString());
          continue;
        }
        if (paramBoolean2) {
          this.wyh = System.currentTimeMillis();
        }
        this.gKO.removeCallbacks(this.zXR);
        this.zXP.setVisibility(8);
        ae.i("NonFullOrFullVideoType", "currPosSec = " + paramInt1 + ", isPlaying = " + paramBoolean2 + ", bNoVoice = " + paramBoolean1);
        if (!paramBoolean3) {
          break;
        }
        if ((paramInt7 == this.zWF.getVideoDurationSec()) || (paramInt7 < 0))
        {
          this.zWG.seek(0);
          this.zWF.c(0.0D, true);
          this.wyh = System.currentTimeMillis();
          rL(true);
          if (!paramBoolean1) {
            break label594;
          }
          dZN();
          AppMethodBeat.o(219582);
          return;
        }
      }
      catch (Throwable paramString)
      {
        ae.e("NonFullOrFullVideoType", paramString.toString());
        AppMethodBeat.o(219582);
        return;
      }
      this.zWG.seek(this.zWF.getCacheTimeSec());
      this.zWF.c(this.zWF.getCacheTimeSec(), true);
    }
    if ((paramInt1 == this.zWF.getVideoDurationSec()) || (paramInt1 < 0))
    {
      this.zWG.seek(0);
      this.zWF.c(0.0D, paramBoolean2);
    }
    for (;;)
    {
      rL(paramBoolean2);
      break;
      this.zWG.seek(paramInt1);
      this.zWF.c(paramInt1, paramBoolean2);
    }
    label594:
    dZP();
    AppMethodBeat.o(219582);
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
      paramJSONObject.put("streamVideoDuraion", this.zWF.getVideoDurationSec() * 1000);
      paramJSONObject.put("playTimeInterval", this.zWX);
      paramJSONObject.put("playCount", this.wyN);
      paramJSONObject.put("playCompletedCount", this.zWY);
      paramJSONObject.put("clickFullscreenBtnCount", this.zXT);
      paramJSONObject.put("doubleClickCount", this.zXS);
      paramJSONObject.put("clickPlayControlCount", this.zWZ);
      paramJSONObject.put("clickVoiceControlCount", this.zXa);
      if (this.isAutoPlay) {}
      for (Object localObject = "1";; localObject = "0")
      {
        paramJSONObject.put("isAutoPlay", localObject);
        JSONObject localJSONObject;
        if (!this.zWU)
        {
          localObject = com.tencent.mm.sdk.platformtools.aj.ej(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zRV);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        if (!this.zWV)
        {
          localObject = com.tencent.mm.sdk.platformtools.aj.ej(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zQR);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("streamVideoUrlInfo", localJSONObject);
        }
        if (this.zYy != null)
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("cid", this.zYy.zYf);
          ((JSONObject)localObject).put("exposureCount", this.zYy.zYg);
          ((JSONObject)localObject).put("stayTime", this.zYy.zYh);
          ((JSONObject)localObject).put("clickCount", this.zYy.zYi);
          localJSONObject = new JSONObject();
          localJSONObject.put("exposureCount", this.zYy.zUQ);
          localJSONObject.put("stayTime", this.zYy.dCI);
          localJSONObject.put("clickCount", this.zYy.clickCount);
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
      ae.printErrStackTrace("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96786);
    }
  }
  
  public final void aqS()
  {
    AppMethodBeat.i(219574);
    this.zWO = true;
    ao(this.zWL);
    AppMethodBeat.o(219574);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96790);
    ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "online play error, %s", new Object[] { paramString3 });
    this.zWT = true;
    AppMethodBeat.o(96790);
  }
  
  public final void cyU()
  {
    AppMethodBeat.i(219583);
    rM(false);
    this.zWW = 4;
    AppMethodBeat.o(219583);
  }
  
  public final void cyV()
  {
    AppMethodBeat.i(219584);
    this.zWW = 3;
    cbC();
    AppMethodBeat.o(219584);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dUI()
  {
    boolean bool2 = true;
    AppMethodBeat.i(96775);
    Object localObject1 = this.contentView.findViewById(2131298770);
    this.zXW = ((View)localObject1);
    ((View)localObject1).setBackgroundColor(-16777216);
    int k = this.lxZ;
    int j = this.lya;
    int i = j;
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zRW == 1)
    {
      i = j;
      if ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).width > 0) {
        i = k * (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).height / (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).width;
      }
    }
    else
    {
      ((View)localObject1).setPadding((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).paddingLeft, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).paddingTop, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).paddingRight, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).paddingBottom);
    }
    ((View)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(k, i));
    ((View)localObject1).setMinimumHeight(i);
    ae.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "createView, displayType=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zRW + ", containerW=" + k + ", vH=" + i + ", padding=" + k.eR((View)localObject1));
    this.zWF = ((AdLandingVideoWrapper)((View)localObject1).findViewById(2131306410));
    this.zWF.setIMMVideoViewCallback(this);
    this.zWF.setOnClickListener(this.zXf);
    this.zWF.setFullScreen(false);
    this.zWF.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zQR, 0);
    this.zWF.setIsShowBasicControls(true);
    Object localObject2;
    if (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zQX)
    {
      ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "fixVideoBlackline, enable=false");
      this.gYT = ((ProgressBar)((View)localObject1).findViewById(2131303535));
      this.tMY = ((ImageView)((View)localObject1).findViewById(2131305798));
      localObject2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zRV);
      if (!o.fB((String)localObject2)) {
        this.zWU = false;
      }
      if (!this.zWU) {
        break label1351;
      }
      this.tMY.setImageBitmap(com.tencent.mm.sdk.platformtools.h.decodeFile((String)localObject2));
      label409:
      this.zWK = ((TextView)((View)localObject1).findViewById(2131299517));
      this.zWK.setText(this.context.getString(2131758104));
      this.hcH = ((View)localObject1).findViewById(2131304920);
      this.hcH.setVisibility(4);
      this.zWG = new VideoPlayerSeekBar(this.context);
      this.zWG.setVisibility(4);
      if (this.zXb != null)
      {
        localObject2 = this.zXb;
        if (this.zWG.getVisibility() != 0) {
          break label1382;
        }
      }
    }
    label1294:
    label1351:
    label1382:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((am)localObject2).rK(bool1);
      this.zWG.setIplaySeekCallback(this);
      this.zWG.setOnPlayButtonClickListener(this.zXc);
      localObject2 = new RelativeLayout.LayoutParams(k - com.tencent.mm.cb.a.fromDPToPix(this.context, 75), -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      this.zWG.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.zWF.setVideoFooterView(this.zWG);
      this.zWH = ((ImageView)((View)localObject1).findViewById(2131304921));
      this.zWH.setVisibility(4);
      this.zWH.setOnClickListener(this.zXd);
      try
      {
        localObject3 = this.zWH.getParent();
        if ((localObject3 instanceof ViewGroup)) {
          ((ViewGroup)localObject3).removeView(this.zWH);
        }
        localObject3 = (RelativeLayout.LayoutParams)this.zWH.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject3).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localObject1).addView(this.zWH, (ViewGroup.LayoutParams)localObject3);
        ae.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "init voiceTypeBtn and visible");
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          Object localObject3;
          ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable4.toString());
        }
      }
      this.zWJ = ((ImageView)((View)localObject1).findViewById(2131305196));
      this.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691166));
      this.zWJ.setVisibility(8);
      this.zWJ.setOnClickListener(this.zXe);
      ((ViewGroup)this.zWG.getParent()).removeView(this.zWG);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((ViewGroup)localObject1).addView(this.zWG, (ViewGroup.LayoutParams)localObject2);
      this.zWF.setVideoPlayCallback(new AdLandingVideoWrapper.a()
      {
        public final void tx(int paramAnonymousInt)
        {
          AppMethodBeat.i(219567);
          aj.d(aj.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219566);
              aj.b(aj.this, aj.this.zWF.isPlaying());
              AppMethodBeat.o(219566);
            }
          });
          if ((aj.e(aj.this).zQW != null) && (paramAnonymousInt * 1000 >= aj.e(aj.this).zQW.zRT) && (!aj.f(aj.this)))
          {
            aj.g(aj.this);
            oj localoj = new oj();
            localoj.dDo.dDp = aj.e(aj.this).zQW.dDp;
            com.tencent.mm.sdk.b.a.IvT.l(localoj);
          }
          AppMethodBeat.o(219567);
        }
      });
      localObject1 = this.zXW;
      try
      {
        this.length = com.tencent.mm.cb.a.fromDPToPix(this.context, 32);
        this.zWF.setOnTouchListener(this);
        this.zXO = ((ImageView)((View)localObject1).findViewById(2131307246));
        localObject2 = this.zXO.getParent();
        if ((localObject2 instanceof ViewGroup)) {
          ((ViewGroup)localObject2).removeView(this.zXO);
        }
        localObject2 = (RelativeLayout.LayoutParams)this.zXO.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localObject1).addView(this.zXO, (ViewGroup.LayoutParams)localObject2);
        this.zXO.setOnClickListener(this);
        this.zXO.setVisibility(8);
        ae.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "init fullScreenBtn and visible");
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          label1150:
          ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable1.toString());
          continue;
          bool1 = false;
        }
      }
      try
      {
        this.zWF.setLoop(true);
        this.zWF.setLoopCompletionCallback(this);
        localObject1 = this.zWG.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.zWG);
        }
        localObject1 = new RelativeLayout.LayoutParams(this.zXW.getLayoutParams().width - com.tencent.mm.cb.a.fromDPToPix(this.context, 75), -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 3);
        this.zWG.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((ViewGroup)this.contentView.findViewById(2131298770)).addView(this.zWG, (ViewGroup.LayoutParams)localObject1);
        this.zWG.setVisibility(4);
        rL(false);
        if (this.zXb != null)
        {
          localObject1 = this.zXb;
          if (this.zWG.getVisibility() != 0) {
            break label1418;
          }
          bool1 = bool2;
          ((am)localObject1).rK(bool1);
        }
        ae.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "init progressBar and visible");
      }
      catch (Throwable localThrowable2)
      {
        ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable2.toString());
        break label1150;
      }
      localObject1 = this.zXW;
      try
      {
        this.zXP = ((View)localObject1).findViewById(2131307220);
        this.zXP.setVisibility(8);
        AppMethodBeat.o(96775);
        return;
      }
      catch (Throwable localThrowable3)
      {
        ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable3.toString());
        AppMethodBeat.o(96775);
      }
      localObject2 = this.zWF.getInnerVideoView();
      localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP;
      if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject3).paddingLeft != 0.0F) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject3).paddingTop != 0.0F) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject3).paddingRight != 0.0F) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject3).paddingBottom != 0.0F)) {}
      for (bool1 = true;; bool1 = false)
      {
        if ((!(localObject2 instanceof VideoPlayerTextureView)) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zRW != 1) || (bool1)) {
          break label1294;
        }
        ((View)localObject2).addOnLayoutChangeListener(new aj.5(this));
        break;
      }
      ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, innerVideoView=" + localObject2 + ", displayType=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zRW + ", hasPadding=" + bool1);
      break;
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zRV, false, 1000000001, new f.a()
      {
        public final void ayY(String paramAnonymousString)
        {
          AppMethodBeat.i(219565);
          if (aj.c(aj.this).getVisibility() == 0) {
            aj.c(aj.this).setImageBitmap(com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString));
          }
          AppMethodBeat.o(219565);
        }
        
        public final void dVu() {}
        
        public final void dVv() {}
      });
      break label409;
    }
    label1418:
  }
  
  protected final void dUJ() {}
  
  public final void dUK()
  {
    AppMethodBeat.i(96782);
    super.dUK();
    AppMethodBeat.o(96782);
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(96783);
    super.dUL();
    rM(false);
    if ((!this.zWR) && (!this.zWS))
    {
      AppMethodBeat.o(96783);
      return;
    }
    this.zWS = false;
    this.zWR = false;
    if (this.zWW == 1) {
      this.zWW = 2;
    }
    AppMethodBeat.o(96783);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(96784);
    super.dUM();
    try
    {
      this.gKO.removeCallbacks(this.zWL);
      this.gKO.removeCallbacks(this.zXR);
      this.zWF.onUIDestroy();
      AppMethodBeat.o(96784);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable.toString());
      }
    }
  }
  
  public final void dZN()
  {
    AppMethodBeat.i(96780);
    super.dZN();
    this.zWH.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131690341));
    this.zWF.setMute(true);
    this.zWP = true;
    AppMethodBeat.o(96780);
  }
  
  public final void dZO()
  {
    AppMethodBeat.i(96785);
    super.dZO();
    int i = eax();
    int j = getView().getHeight();
    ae.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
      if ((this.zWR) && (!this.zWS))
      {
        AppMethodBeat.o(96785);
        return;
      }
      this.zWS = false;
      this.zWR = true;
      if (this.zWW == 6)
      {
        if (this.zXQ)
        {
          this.zWW = 1;
          if (this.zWJ.getVisibility() == 0)
          {
            this.zWJ.setVisibility(8);
            AppMethodBeat.o(96785);
          }
        }
        else
        {
          this.zWW = 4;
        }
        AppMethodBeat.o(96785);
        return;
      }
      this.tMY.setVisibility(0);
      NetworkInfo localNetworkInfo = ((ConnectivityManager)com.tencent.mm.sdk.platformtools.ak.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if ((!this.zWQ) || ((this.zWQ) && (localNetworkInfo != null) && (localNetworkInfo.getType() == 1)))
      {
        setFocus(true);
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219561);
            if (aj.r(aj.this))
            {
              AppMethodBeat.o(219561);
              return;
            }
            aj.a(aj.this, false);
            AppMethodBeat.o(219561);
          }
        }, 3000L);
      }
      if (this.zWQ)
      {
        if ((localNetworkInfo == null) || ((localNetworkInfo != null) && (localNetworkInfo.getType() != 1)))
        {
          this.zWJ.setVisibility(0);
          this.isAutoPlay = false;
          this.zWQ = false;
          AppMethodBeat.o(96785);
          return;
        }
        this.isAutoPlay = true;
        this.zWQ = false;
      }
      if (this.zWW == 0) {
        if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1))
        {
          if (!this.zWP) {
            break label351;
          }
          dZN();
          this.zWW = 1;
        }
      }
      for (;;)
      {
        cbC();
        label351:
        do
        {
          AppMethodBeat.o(96785);
          return;
          dZP();
          break;
          if (this.zWW == 2)
          {
            if (this.zWP) {
              dZN();
            }
            for (;;)
            {
              cbC();
              this.zWW = 1;
              AppMethodBeat.o(96785);
              return;
              dZP();
            }
          }
        } while (this.zWW != 3);
        if (this.zWP) {
          dZN();
        } else {
          dZP();
        }
      }
    }
    this.zWS = false;
    this.zWR = false;
    rM(false);
    if (this.zWW == 1) {
      this.zWW = 2;
    }
    AppMethodBeat.o(96785);
  }
  
  public final void dZP()
  {
    AppMethodBeat.i(96781);
    super.dZP();
    this.zWH.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131690342));
    this.zWF.setMute(false);
    this.zWP = false;
    AppMethodBeat.o(96781);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    this.zWT = false;
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96788);
    ae.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onVideoEnded");
    this.zWY += 1;
    setFocus(true);
    this.zWF.zYZ.stopTimer();
    if (this.wyh != 0L)
    {
      this.zWX = ((int)(this.zWX + (System.currentTimeMillis() - this.wyh)));
      this.wyh = 0L;
    }
    this.zWW = 5;
    this.zWF.onUIPause();
    AppMethodBeat.o(96788);
  }
  
  public final void du(String paramString1, String paramString2) {}
  
  public final void dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96789);
    ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "the onVideoPlay is called!");
    if (this.zPw != null) {
      this.zPw.sendMessage();
    }
    this.tMY.setVisibility(8);
    this.gYT.setVisibility(8);
    try
    {
      this.gKO.removeCallbacks(this.zXR);
      this.zXP.setVisibility(8);
      rL(true);
      AppMethodBeat.o(96789);
      return;
    }
    catch (Throwable paramString1)
    {
      ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramString1.toString());
      AppMethodBeat.o(96789);
    }
  }
  
  public final void dw(String paramString1, String paramString2)
  {
    this.isWaiting = true;
  }
  
  public final void dx(String paramString1, String paramString2)
  {
    this.isWaiting = false;
    this.zYx = 0;
  }
  
  public final void eX(String paramString1, String paramString2) {}
  
  public final void eaB()
  {
    AppMethodBeat.i(96791);
    super.eaB();
    rM(false);
    String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zRV);
    if (o.fB(str))
    {
      this.tMY.setImageBitmap(com.tencent.mm.sdk.platformtools.h.decodeFile(str));
      this.tMY.setVisibility(0);
    }
    AppMethodBeat.o(96791);
  }
  
  public final void eaX()
  {
    AppMethodBeat.i(219575);
    ae.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLoopCompletion");
    this.zWY += 1;
    if (this.zPw != null) {
      this.zPw.zoc = true;
    }
    AppMethodBeat.o(219575);
  }
  
  protected final int getLayout()
  {
    return 2131495505;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(219573);
    boolean bool = this.zWF.isPlaying();
    AppMethodBeat.o(219573);
    return bool;
  }
  
  public final void nP(int paramInt)
  {
    AppMethodBeat.i(96787);
    ae.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onSeek time ".concat(String.valueOf(paramInt)));
    this.zYx = paramInt;
    if (this.zWP) {
      dZN();
    }
    for (;;)
    {
      this.gKO.removeCallbacks(this.zXR);
      this.zXP.setVisibility(8);
      QZ(paramInt);
      this.zWW = 3;
      AppMethodBeat.o(96787);
      return;
      dZQ();
      dZP();
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(219577);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if (paramView.getId() == 2131307246) {
      ae.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "click full screen btn");
    }
    try
    {
      if ((this.context instanceof SnsAdNativeLandingPagesUI))
      {
        this.zXT += 1;
        this.gKO.removeCallbacks(this.zXR);
        this.zXP.setVisibility(8);
        paramView = (SnsAdNativeLandingPagesUI)this.context;
        a.zYC = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP;
        com.tencent.mm.plugin.sns.model.ad.zAi = eaD();
        localObject = new Intent(paramView, VideoFullScreenActivity.class);
        ((Intent)localObject).putExtra("KComponentVideoType", 1);
        ((Intent)localObject).putExtra("KComponentCid", eaz());
        ((Intent)localObject).putExtra("KComponentCurrentTime", this.zWF.getCurrPosSec());
        ((Intent)localObject).putExtra("KComponentTotalTime", this.zWF.getVideoDurationSec());
        ((Intent)localObject).putExtra("KComponentVoiceType", this.zWP);
        ((Intent)localObject).putExtra("KComponentProgressType", this.zWF.isPlaying());
        ((Intent)localObject).putExtra("KComponentStreamVideoUrlPath", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zQR);
        ((Intent)localObject).putExtra("KComponentIsWaiting", this.isWaiting);
        ((Intent)localObject).putExtra("KComponentSeekTimeDueWaiting", this.zYx);
        ((Intent)localObject).putExtra("KComponentKComponentCacheTime", this.zWF.getCacheTimeSec());
        paramView.startActivityForResult((Intent)localObject, 2000);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(219577);
        return;
        this.zXO.setVisibility(8);
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        this.zXO.setVisibility(8);
        ae.e("NonFullOrFullVideoType", paramView.toString());
      }
    }
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219579);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    for (;;)
    {
      try
      {
        ae.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "onDoubleTap");
        ao(this.zWL);
        if (!this.zWT) {
          this.zXS += 1;
        }
        if (!this.zWF.isPlaying()) {
          continue;
        }
        rM(true);
        this.zWW = 4;
      }
      catch (Throwable paramMotionEvent)
      {
        ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        dZQ();
        dZP();
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(219579);
      return false;
      if (!this.zWP) {
        continue;
      }
      dZN();
      cbC();
      this.zWW = 3;
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
    AppMethodBeat.i(219581);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(219581);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219578);
    try
    {
      ae.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "onSingleTapConfirmed");
      if (!this.zWO)
      {
        this.zWO = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(219578);
        return false;
        this.zWO = false;
        setFocus(false);
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramMotionEvent.toString());
      }
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219580);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(219580);
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219576);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    paramView = this.iNw;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.ahE(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.mt(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(219576);
    return bool;
  }
  
  public static final class a
  {
    public static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak zYC;
  }
  
  static final class b
  {
    int clickCount;
    long dCI;
    int zUQ;
    String zYf;
    int zYg;
    long zYh;
    int zYi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj
 * JD-Core Version:    0.7.0.1
 */