package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import com.tencent.mm.g.a.oa;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class ah
  extends ag
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, b, h.b, h.d
{
  private Context context;
  private ProgressBar gCw;
  private View gGk;
  private ao gox;
  private GestureDetector irA;
  private boolean isAutoPlay;
  private volatile boolean isWaiting;
  private int length;
  private ImageView sFo;
  private int vdM;
  private long vdg;
  AdLandingVideoWrapper yoE;
  private VideoPlayerSeekBar yoF;
  private ImageView yoG;
  private boolean yoH;
  private ImageView yoI;
  private TextView yoJ;
  private Runnable yoK;
  private boolean yoL;
  private boolean yoM;
  private boolean yoN;
  private boolean yoO;
  private boolean yoP;
  private boolean yoQ;
  private boolean yoR;
  private boolean yoS;
  private boolean yoT;
  private boolean yoU;
  private int yoV;
  private int yoW;
  private int yoX;
  private int yoY;
  private int yoZ;
  private ImageView ypE;
  private View ypF;
  private volatile boolean ypG;
  private Runnable ypH;
  private int ypI;
  private int ypJ;
  private View ypL;
  private ak ypa;
  private View.OnClickListener ypb;
  private View.OnClickListener ypc;
  private View.OnClickListener ypd;
  private View.OnClickListener ype;
  private volatile int yqi;
  
  public ah(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai paramai, ViewGroup paramViewGroup)
  {
    super(paramContext, paramai, paramViewGroup);
    AppMethodBeat.i(96774);
    this.yoL = false;
    this.yoM = false;
    this.yoN = false;
    this.yoO = true;
    this.yoP = true;
    this.yoQ = false;
    this.yoR = true;
    this.isAutoPlay = false;
    this.yoS = false;
    this.yoT = false;
    this.yoU = false;
    this.yoV = 0;
    this.vdg = 0L;
    this.yoW = 0;
    this.vdM = 0;
    this.yoX = 0;
    this.yoY = 0;
    this.yoZ = 0;
    this.ypa = null;
    this.ypb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96769);
        ac.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(ah.this.yoE.isPlaying()) });
        ah.a(ah.this, ah.g(ah.this));
        if (ah.this.yoE.isPlaying())
        {
          ah.h(ah.this);
          ah.a(ah.this, 4);
          if (ah.k(ah.this)) {
            ah.l(ah.this);
          }
          AppMethodBeat.o(96769);
          return;
        }
        if (ah.i(ah.this)) {
          ah.this.dJV();
        }
        for (;;)
        {
          ah.j(ah.this);
          ah.a(ah.this, 3);
          break;
          ah.this.dKc();
          ah.this.dKb();
        }
      }
    };
    this.ypc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96771);
        ah.m(ah.this);
        ah.a(ah.this, ah.g(ah.this));
        if (ah.i(ah.this))
        {
          ah.this.dKc();
          ah.this.dKb();
        }
        for (;;)
        {
          ah.n(ah.this);
          AppMethodBeat.o(96771);
          return;
          ah.this.dJV();
        }
      }
    };
    this.ypd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96772);
        ah.j(ah.this);
        ah.o(ah.this);
        ah.p(ah.this);
        ah.a(ah.this, 3);
        ah.this.dKb();
        ah.a(ah.this, true);
        ap.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200275);
            if (ah.q(ah.this))
            {
              AppMethodBeat.o(200275);
              return;
            }
            ah.a(ah.this, false);
            AppMethodBeat.o(200275);
          }
        }, 10000L);
        AppMethodBeat.o(96772);
      }
    };
    this.ype = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView) {}
    };
    this.ypG = false;
    this.isWaiting = false;
    this.yqi = 0;
    this.ypI = 0;
    this.ypJ = 0;
    this.context = paramContext;
    this.gox = new ao(Looper.getMainLooper());
    try
    {
      this.irA = new GestureDetector(this);
      this.ypH = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96762);
          ah.a(ah.this).setVisibility(8);
          AppMethodBeat.o(96762);
        }
      };
      this.yoK = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200270);
          ah.a(ah.this, false);
          AppMethodBeat.o(200270);
        }
      };
      this.ypa = new ah.7(this, paramContext);
      AppMethodBeat.o(96774);
      return;
    }
    catch (Throwable paramai)
    {
      for (;;)
      {
        ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramai.toString());
      }
    }
  }
  
  private void OK(int paramInt)
  {
    AppMethodBeat.i(96779);
    if (this.yoE != null)
    {
      this.yoI.setVisibility(8);
      if (this.sFo.getVisibility() == 0) {
        this.gCw.setVisibility(0);
      }
      this.yoE.c(paramInt, true);
    }
    AppMethodBeat.o(96779);
  }
  
  private void ar(Runnable paramRunnable)
  {
    AppMethodBeat.i(200277);
    try
    {
      this.gox.removeCallbacks(paramRunnable);
      this.gox.postDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(200277);
      return;
    }
    catch (Throwable paramRunnable)
    {
      ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramRunnable.toString());
      AppMethodBeat.o(200277);
    }
  }
  
  private void bVK()
  {
    AppMethodBeat.i(96776);
    ac.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "starting play, downFailed=" + this.yoS);
    if (this.yoS)
    {
      ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "last download fail ,try again");
      if ((this.yoF != null) && (this.yoF.getParent() != null)) {
        ((ViewGroup)this.yoF.getParent()).removeView(this.yoF);
      }
      this.yoE.setFullScreen(false);
      this.yoE.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).yjk, 0);
      try
      {
        int i = this.kWB;
        if ((this.yoF != null) && (this.yoF.getParent() != null)) {
          ((ViewGroup)this.yoF.getParent()).removeView(this.yoF);
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i - com.tencent.mm.cc.a.fromDPToPix(this.context, 75), -2);
        localLayoutParams.addRule(12);
        localLayoutParams.bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 3);
        this.yoF.setLayoutParams(localLayoutParams);
        ((ViewGroup)this.contentView.findViewById(2131298770)).addView(this.yoF, localLayoutParams);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "startPlay exp=" + bs.m(localException));
        }
      }
      OK(0);
      this.yoE.dLf();
      AppMethodBeat.o(96776);
      return;
    }
    this.gox.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96763);
        if (!ah.this.yoE.isPlaying())
        {
          if (ah.r(ah.this).getCurrPosSec() != ah.r(ah.this).getVideoDurationSec()) {
            break label65;
          }
          ah.b(ah.this, 0);
        }
        for (;;)
        {
          ah.r(ah.this).dLf();
          AppMethodBeat.o(96763);
          return;
          label65:
          ah.b(ah.this, ah.r(ah.this).getCurrPosSec());
        }
      }
    });
    this.vdg = System.currentTimeMillis();
    this.vdM += 1;
    AppMethodBeat.o(96776);
  }
  
  private void ra(boolean paramBoolean)
  {
    AppMethodBeat.i(200276);
    try
    {
      this.yoF.setIsPlay(paramBoolean);
      this.yoF.getPlayBtn().getLayoutParams().width = this.length;
      this.yoF.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        ac.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "startPlay");
        this.yoF.getPlayBtn().setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691470));
        AppMethodBeat.o(200276);
        return;
      }
      ac.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "pausePlay");
      this.yoF.getPlayBtn().setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691469));
      AppMethodBeat.o(200276);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable.toString());
      AppMethodBeat.o(200276);
    }
  }
  
  private void rb(final boolean paramBoolean)
  {
    AppMethodBeat.i(200278);
    ac.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "pause play");
    this.gox.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96764);
        ah.r(ah.this).pause();
        try
        {
          if ((ah.s(ah.this).getVisibility() != 0) && (paramBoolean))
          {
            ah.a(ah.this).setVisibility(0);
            ah.a(ah.this, ah.t(ah.this));
          }
          ah.b(ah.this, false);
          AppMethodBeat.o(96764);
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable.toString());
          AppMethodBeat.o(96764);
        }
      }
    });
    if (this.vdg != 0L)
    {
      this.yoW = ((int)(this.yoW + (System.currentTimeMillis() - this.vdg)));
      this.vdg = 0L;
    }
    AppMethodBeat.o(200278);
  }
  
  private void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(96778);
    if (paramBoolean)
    {
      this.yoF.setVisibility(0);
      this.yoG.setVisibility(0);
      this.gGk.setVisibility(0);
      this.ypE.setVisibility(0);
      if (this.ypa != null) {
        this.ypa.qZ(true);
      }
      ar(this.yoK);
      AppMethodBeat.o(96778);
      return;
    }
    this.yoN = false;
    this.yoF.setVisibility(4);
    this.yoG.setVisibility(8);
    this.gGk.setVisibility(4);
    this.ypE.setVisibility(8);
    if (this.ypa != null) {
      this.ypa.qZ(false);
    }
    this.gox.removeCallbacks(this.yoK);
    AppMethodBeat.o(96778);
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, boolean paramBoolean3, int paramInt7)
  {
    AppMethodBeat.i(200286);
    try
    {
      this.yoV = 6;
      this.ypG = paramBoolean2;
      this.ypJ += 1;
      this.yoY += paramInt2;
      this.ypI += paramInt3;
      this.yoZ += paramInt4;
      this.yoX += paramInt5;
      this.vdM += paramInt6;
      this.yoW = ((int)(this.yoW + paramLong));
      if (paramBoolean2) {
        this.vdg = System.currentTimeMillis();
      }
      this.gox.removeCallbacks(this.ypH);
      this.ypF.setVisibility(8);
      ac.i("NonFullOrFullVideoType", "currPosSec = " + paramInt1 + ", isPlaying = " + paramBoolean2 + ", bNoVoice = " + paramBoolean1);
      if (paramBoolean3)
      {
        if ((paramInt7 > 0) && (paramInt7 <= this.yoE.getVideoDurationSec()))
        {
          this.yoF.seek(this.yoE.getCacheTimeSec());
          this.yoE.c(this.yoE.getCacheTimeSec(), true);
        }
        for (;;)
        {
          this.vdg = System.currentTimeMillis();
          ra(true);
          if (!paramBoolean1) {
            break;
          }
          dJV();
          AppMethodBeat.o(200286);
          return;
          this.yoF.seek(0);
          this.yoE.c(0.0D, true);
        }
      }
      if (paramInt1 >= this.yoE.getVideoDurationSec()) {
        break label305;
      }
    }
    catch (Throwable localThrowable)
    {
      ac.e("NonFullOrFullVideoType", localThrowable.toString());
      AppMethodBeat.o(200286);
      return;
    }
    if (paramInt1 < 0)
    {
      label305:
      this.yoF.seek(0);
      this.yoE.c(0.0D, paramBoolean2);
    }
    for (;;)
    {
      ra(paramBoolean2);
      break;
      this.yoF.seek(paramInt1);
      this.yoE.c(paramInt1, paramBoolean2);
    }
    dKb();
    AppMethodBeat.o(200286);
  }
  
  public final boolean aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96786);
    if (!super.aH(paramJSONObject))
    {
      AppMethodBeat.o(96786);
      return false;
    }
    try
    {
      paramJSONObject.put("streamVideoDuraion", this.yoE.getVideoDurationSec() * 1000);
      paramJSONObject.put("playTimeInterval", this.yoW);
      paramJSONObject.put("playCount", this.vdM);
      paramJSONObject.put("playCompletedCount", this.yoX);
      paramJSONObject.put("clickFullscreenBtnCount", this.ypJ);
      paramJSONObject.put("doubleClickCount", this.ypI);
      paramJSONObject.put("clickPlayControlCount", this.yoY);
      paramJSONObject.put("clickVoiceControlCount", this.yoZ);
      if (this.isAutoPlay) {}
      for (String str = "1";; str = "0")
      {
        paramJSONObject.put("isAutoPlay", str);
        JSONObject localJSONObject;
        if (!this.yoT)
        {
          str = com.tencent.mm.sdk.platformtools.ah.dg(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).ykg);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        if (!this.yoU)
        {
          str = com.tencent.mm.sdk.platformtools.ah.dg(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).yjk);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("streamVideoUrlInfo", localJSONObject);
        }
        AppMethodBeat.o(96786);
        return true;
      }
      return false;
    }
    catch (JSONException paramJSONObject)
    {
      ac.printErrStackTrace("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96786);
    }
  }
  
  public final void anR()
  {
    AppMethodBeat.i(200280);
    this.yoN = true;
    ar(this.yoK);
    AppMethodBeat.o(200280);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96790);
    ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "online play error, %s", new Object[] { paramString3 });
    this.yoS = true;
    AppMethodBeat.o(96790);
  }
  
  public final void crH()
  {
    AppMethodBeat.i(200287);
    rb(false);
    this.yoV = 4;
    AppMethodBeat.o(200287);
  }
  
  public final void crI()
  {
    AppMethodBeat.i(200288);
    this.yoV = 3;
    bVK();
    AppMethodBeat.o(200288);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dJV()
  {
    AppMethodBeat.i(96780);
    super.dJV();
    this.yoG.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131690341));
    this.yoE.setMute(true);
    this.yoO = true;
    AppMethodBeat.o(96780);
  }
  
  public final void dJW()
  {
    boolean bool2 = true;
    AppMethodBeat.i(96775);
    Object localObject1 = this.contentView.findViewById(2131298770);
    this.ypL = ((View)localObject1);
    ((View)localObject1).setBackgroundColor(-16777216);
    int k = this.kWB;
    int j = this.kWC;
    int i = j;
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).ykh == 1)
    {
      i = j;
      if ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).width > 0) {
        i = k * (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).height / (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).width;
      }
    }
    else
    {
      ((View)localObject1).setPadding((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).paddingLeft, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).paddingTop, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).paddingRight, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).paddingBottom);
    }
    ((View)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(k, i));
    ((View)localObject1).setMinimumHeight(i);
    ac.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "createView, displayType=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).ykh + ", containerW=" + k + ", vH=" + i + ", padding=" + j.eC((View)localObject1));
    this.yoE = ((AdLandingVideoWrapper)((View)localObject1).findViewById(2131306410));
    this.yoE.setIMMVideoViewCallback(this);
    this.yoE.setOnClickListener(this.ype);
    this.yoE.setFullScreen(false);
    this.yoE.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).yjk, 0);
    this.yoE.setIsShowBasicControls(true);
    Object localObject2;
    if (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).yjq)
    {
      ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "fixVideoBlackline, enable=false");
      this.gCw = ((ProgressBar)((View)localObject1).findViewById(2131303535));
      this.sFo = ((ImageView)((View)localObject1).findViewById(2131305798));
      localObject2 = h.js("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).ykg);
      if (!i.eA((String)localObject2)) {
        this.yoT = false;
      }
      if (!this.yoT) {
        break label1351;
      }
      this.sFo.setImageBitmap(f.decodeFile((String)localObject2));
      label409:
      this.yoJ = ((TextView)((View)localObject1).findViewById(2131299517));
      this.yoJ.setText(this.context.getString(2131758104));
      this.gGk = ((View)localObject1).findViewById(2131304920);
      this.gGk.setVisibility(4);
      this.yoF = new VideoPlayerSeekBar(this.context);
      this.yoF.setVisibility(4);
      if (this.ypa != null)
      {
        localObject2 = this.ypa;
        if (this.yoF.getVisibility() != 0) {
          break label1382;
        }
      }
    }
    label1294:
    label1351:
    label1382:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((ak)localObject2).qZ(bool1);
      this.yoF.setIplaySeekCallback(this);
      this.yoF.setOnPlayButtonClickListener(this.ypb);
      localObject2 = new RelativeLayout.LayoutParams(k - com.tencent.mm.cc.a.fromDPToPix(this.context, 75), -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      this.yoF.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.yoE.setVideoFooterView(this.yoF);
      this.yoG = ((ImageView)((View)localObject1).findViewById(2131304921));
      this.yoG.setVisibility(4);
      this.yoG.setOnClickListener(this.ypc);
      try
      {
        localObject3 = this.yoG.getParent();
        if ((localObject3 instanceof ViewGroup)) {
          ((ViewGroup)localObject3).removeView(this.yoG);
        }
        localObject3 = (RelativeLayout.LayoutParams)this.yoG.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject3).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localObject1).addView(this.yoG, (ViewGroup.LayoutParams)localObject3);
        ac.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "init voiceTypeBtn and visible");
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          Object localObject3;
          ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable4.toString());
        }
      }
      this.yoI = ((ImageView)((View)localObject1).findViewById(2131305196));
      this.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
      this.yoI.setVisibility(8);
      this.yoI.setOnClickListener(this.ypd);
      ((ViewGroup)this.yoF.getParent()).removeView(this.yoF);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((ViewGroup)localObject1).addView(this.yoF, (ViewGroup.LayoutParams)localObject2);
      this.yoE.setVideoPlayCallback(new AdLandingVideoWrapper.a()
      {
        public final void sQ(int paramAnonymousInt)
        {
          AppMethodBeat.i(200274);
          ah.c(ah.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200273);
              ah.b(ah.this, ah.this.yoE.isPlaying());
              AppMethodBeat.o(200273);
            }
          });
          if ((ah.d(ah.this).yjp != null) && (paramAnonymousInt * 1000 >= ah.d(ah.this).yjp.yke) && (!ah.e(ah.this)))
          {
            ah.f(ah.this);
            oa localoa = new oa();
            localoa.dqw.dqx = ah.d(ah.this).yjp.dqx;
            com.tencent.mm.sdk.b.a.GpY.l(localoa);
          }
          AppMethodBeat.o(200274);
        }
      });
      localObject1 = this.ypL;
      try
      {
        this.length = com.tencent.mm.cc.a.fromDPToPix(this.context, 32);
        this.yoE.setOnTouchListener(this);
        this.ypE = ((ImageView)((View)localObject1).findViewById(2131307246));
        localObject2 = this.ypE.getParent();
        if ((localObject2 instanceof ViewGroup)) {
          ((ViewGroup)localObject2).removeView(this.ypE);
        }
        localObject2 = (RelativeLayout.LayoutParams)this.ypE.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 8);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 10);
        ((ViewGroup)localObject1).addView(this.ypE, (ViewGroup.LayoutParams)localObject2);
        this.ypE.setOnClickListener(this);
        this.ypE.setVisibility(8);
        ac.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "init fullScreenBtn and visible");
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          label1150:
          ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable1.toString());
          continue;
          bool1 = false;
        }
      }
      try
      {
        this.yoE.setLoop(true);
        this.yoE.setLoopCompletionCallback(this);
        localObject1 = this.yoF.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.yoF);
        }
        localObject1 = new RelativeLayout.LayoutParams(this.ypL.getLayoutParams().width - com.tencent.mm.cc.a.fromDPToPix(this.context, 75), -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 3);
        this.yoF.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((ViewGroup)this.contentView.findViewById(2131298770)).addView(this.yoF, (ViewGroup.LayoutParams)localObject1);
        this.yoF.setVisibility(4);
        ra(false);
        if (this.ypa != null)
        {
          localObject1 = this.ypa;
          if (this.yoF.getVisibility() != 0) {
            break label1418;
          }
          bool1 = bool2;
          ((ak)localObject1).qZ(bool1);
        }
        ac.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "init progressBar and visible");
      }
      catch (Throwable localThrowable2)
      {
        ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable2.toString());
        break label1150;
      }
      localObject1 = this.ypL;
      try
      {
        this.ypF = ((View)localObject1).findViewById(2131307220);
        this.ypF.setVisibility(8);
        AppMethodBeat.o(96775);
        return;
      }
      catch (Throwable localThrowable3)
      {
        ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable3.toString());
        AppMethodBeat.o(96775);
      }
      localObject2 = this.yoE.getInnerVideoView();
      localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ;
      if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject3).paddingLeft != 0.0F) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject3).paddingTop != 0.0F) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject3).paddingRight != 0.0F) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject3).paddingBottom != 0.0F)) {}
      for (bool1 = true;; bool1 = false)
      {
        if ((!(localObject2 instanceof VideoPlayerTextureView)) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).ykh != 1) || (bool1)) {
          break label1294;
        }
        ((View)localObject2).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
        {
          public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            AppMethodBeat.i(200269);
            try
            {
              paramAnonymousInt1 = paramAnonymousView.getWidth();
              paramAnonymousInt2 = paramAnonymousView.getHeight();
              paramAnonymousInt3 = ah.u(ah.this).getWidth();
              paramAnonymousInt4 = ah.u(ah.this).getHeight();
              if ((paramAnonymousInt2 <= 1) || (paramAnonymousInt1 <= 1) || (paramAnonymousInt3 == 0) || (paramAnonymousInt4 == 0))
              {
                AppMethodBeat.o(200269);
                return;
              }
              ac.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, videoW=" + paramAnonymousInt1 + ", videoH=" + paramAnonymousInt2 + ", containerW=" + paramAnonymousInt3 + ", containH=" + paramAnonymousInt4 + ", container.padding=" + j.eC(ah.u(ah.this)));
              if (paramAnonymousInt2 == paramAnonymousInt4)
              {
                AppMethodBeat.o(200269);
                return;
              }
              if ((paramAnonymousInt2 >= paramAnonymousInt1) && (paramAnonymousInt4 >= paramAnonymousInt3) && (Math.abs(paramAnonymousInt2 - paramAnonymousInt4) < 2))
              {
                paramAnonymousView = ah.u(ah.this).getLayoutParams();
                paramAnonymousView.height = paramAnonymousInt2;
                ah.u(ah.this).setLayoutParams(paramAnonymousView);
                ac.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, reset VideoContainer.height");
              }
              AppMethodBeat.o(200269);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, exp=" + paramAnonymousView.toString());
              AppMethodBeat.o(200269);
            }
          }
        });
        break;
      }
      ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, innerVideoView=" + localObject2 + ", displayType=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).ykh + ", hasPadding=" + bool1);
      break;
      h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).ykg, false, 1000000001, new f.a()
      {
        public final void asD(String paramAnonymousString)
        {
          AppMethodBeat.i(200272);
          if (ah.b(ah.this).getVisibility() == 0) {
            ah.b(ah.this).setImageBitmap(f.decodeFile(paramAnonymousString));
          }
          AppMethodBeat.o(200272);
        }
        
        public final void dFC() {}
        
        public final void dFD() {}
      });
      break label409;
    }
    label1418:
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(96784);
    super.dJX();
    try
    {
      this.gox.removeCallbacks(this.yoK);
      this.gox.removeCallbacks(this.ypH);
      this.yoE.onUIDestroy();
      AppMethodBeat.o(96784);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localThrowable.toString());
      }
    }
  }
  
  public final void dJY()
  {
    AppMethodBeat.i(96782);
    super.dJY();
    AppMethodBeat.o(96782);
  }
  
  public final void dJZ()
  {
    AppMethodBeat.i(96783);
    super.dJZ();
    rb(false);
    if ((!this.yoQ) && (!this.yoR))
    {
      AppMethodBeat.o(96783);
      return;
    }
    this.yoR = false;
    this.yoQ = false;
    if (this.yoV == 1) {
      this.yoV = 2;
    }
    AppMethodBeat.o(96783);
  }
  
  public final void dKF()
  {
    AppMethodBeat.i(96791);
    super.dKF();
    rb(false);
    String str = h.js("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).ykg);
    if (i.eA(str))
    {
      this.sFo.setImageBitmap(f.decodeFile(str));
      this.sFo.setVisibility(0);
    }
    AppMethodBeat.o(96791);
  }
  
  public final void dKa()
  {
    AppMethodBeat.i(96785);
    super.dKa();
    int i = dKB();
    int j = getView().getHeight();
    ac.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
      if ((this.yoQ) && (!this.yoR))
      {
        AppMethodBeat.o(96785);
        return;
      }
      this.yoR = false;
      this.yoQ = true;
      if (this.yoV == 6)
      {
        if (this.ypG)
        {
          this.yoV = 1;
          AppMethodBeat.o(96785);
          return;
        }
        this.yoV = 4;
        AppMethodBeat.o(96785);
        return;
      }
      this.sFo.setVisibility(0);
      NetworkInfo localNetworkInfo = ((ConnectivityManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if ((!this.yoP) || ((this.yoP) && (localNetworkInfo != null) && (localNetworkInfo.getType() == 1)))
      {
        setFocus(true);
        ap.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200268);
            if (ah.q(ah.this))
            {
              AppMethodBeat.o(200268);
              return;
            }
            ah.a(ah.this, false);
            AppMethodBeat.o(200268);
          }
        }, 3000L);
      }
      if (this.yoP)
      {
        if ((localNetworkInfo == null) || ((localNetworkInfo != null) && (localNetworkInfo.getType() != 1)))
        {
          this.yoI.setVisibility(0);
          this.isAutoPlay = false;
          this.yoP = false;
          AppMethodBeat.o(96785);
          return;
        }
        this.isAutoPlay = true;
        this.yoP = false;
      }
      if (this.yoV == 0) {
        if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1))
        {
          if (!this.yoO) {
            break label332;
          }
          dJV();
          this.yoV = 1;
        }
      }
      for (;;)
      {
        bVK();
        label332:
        do
        {
          AppMethodBeat.o(96785);
          return;
          dKb();
          break;
          if (this.yoV == 2)
          {
            if (this.yoO) {
              dJV();
            }
            for (;;)
            {
              bVK();
              this.yoV = 1;
              AppMethodBeat.o(96785);
              return;
              dKb();
            }
          }
        } while (this.yoV != 3);
        if (this.yoO) {
          dJV();
        } else {
          dKb();
        }
      }
    }
    this.yoR = false;
    this.yoQ = false;
    rb(false);
    if (this.yoV == 1) {
      this.yoV = 2;
    }
    AppMethodBeat.o(96785);
  }
  
  public final void dKb()
  {
    AppMethodBeat.i(96781);
    super.dKb();
    this.yoG.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131690342));
    this.yoE.setMute(false);
    this.yoO = false;
    AppMethodBeat.o(96781);
  }
  
  protected final void dKm() {}
  
  public final void dLd()
  {
    AppMethodBeat.i(200281);
    ac.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLoopCompletion");
    this.yoX += 1;
    AppMethodBeat.o(200281);
  }
  
  public final void jdMethod_do(String paramString1, String paramString2)
  {
    this.yoS = false;
  }
  
  public final void dp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96788);
    this.yoX += 1;
    setFocus(true);
    this.yoE.yqI.stopTimer();
    if (this.vdg != 0L)
    {
      this.yoW = ((int)(this.yoW + (System.currentTimeMillis() - this.vdg)));
      this.vdg = 0L;
    }
    this.yoV = 5;
    this.yoE.onUIPause();
    AppMethodBeat.o(96788);
  }
  
  public final void dq(String paramString1, String paramString2) {}
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96789);
    this.sFo.setVisibility(8);
    this.gCw.setVisibility(8);
    try
    {
      this.gox.removeCallbacks(this.ypH);
      this.ypF.setVisibility(8);
      ra(true);
      AppMethodBeat.o(96789);
      return;
    }
    catch (Throwable paramString1)
    {
      ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramString1.toString());
      AppMethodBeat.o(96789);
    }
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    this.isWaiting = true;
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    this.isWaiting = false;
    this.yqi = 0;
  }
  
  public final void eJ(String paramString1, String paramString2) {}
  
  protected final int getLayout()
  {
    return 2131495505;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(200279);
    boolean bool = this.yoE.isPlaying();
    AppMethodBeat.o(200279);
    return bool;
  }
  
  public final void nn(int paramInt)
  {
    AppMethodBeat.i(96787);
    ac.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onSeek time ".concat(String.valueOf(paramInt)));
    this.yqi = paramInt;
    if (this.yoO) {
      dJV();
    }
    for (;;)
    {
      this.gox.removeCallbacks(this.ypH);
      this.ypF.setVisibility(8);
      OK(paramInt);
      this.yoV = 3;
      AppMethodBeat.o(96787);
      return;
      dKc();
      dKb();
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(200283);
    if (paramView.getId() == 2131307246)
    {
      ac.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "click full screen btn");
      try
      {
        if ((this.context instanceof SnsAdNativeLandingPagesUI))
        {
          this.ypJ += 1;
          this.gox.removeCallbacks(this.ypH);
          this.ypF.setVisibility(8);
          paramView = (SnsAdNativeLandingPagesUI)this.context;
          Intent localIntent = new Intent(paramView, VideoFullScreenActivity.class);
          localIntent.putExtra("KComponentVideoType", 1);
          localIntent.putExtra("KComponentCid", dKD());
          localIntent.putExtra("KComponentCurrentTime", this.yoE.getCurrPosSec());
          localIntent.putExtra("KComponentTotalTime", this.yoE.getVideoDurationSec());
          localIntent.putExtra("KComponentVoiceType", this.yoO);
          localIntent.putExtra("KComponentProgressType", this.yoE.isPlaying());
          localIntent.putExtra("KComponentStreamVideoUrlPath", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).yjk);
          localIntent.putExtra("KComponentIsWaiting", this.isWaiting);
          localIntent.putExtra("KComponentSeekTimeDueWaiting", this.yqi);
          localIntent.putExtra("KComponentKComponentCacheTime", this.yoE.getCacheTimeSec());
          paramView.startActivityForResult(localIntent, SnsAdNativeLandingPagesUI.yHa);
          AppMethodBeat.o(200283);
          return;
        }
        this.ypE.setVisibility(8);
        AppMethodBeat.o(200283);
        return;
      }
      catch (Throwable paramView)
      {
        this.ypE.setVisibility(8);
        ac.e("NonFullOrFullVideoType", paramView.toString());
      }
    }
    AppMethodBeat.o(200283);
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200285);
    for (;;)
    {
      try
      {
        ac.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "onDoubleTap");
        ar(this.yoK);
        if (!this.yoS) {
          this.ypI += 1;
        }
        if (!this.yoE.isPlaying()) {
          continue;
        }
        rb(true);
        this.yoV = 4;
      }
      catch (Throwable paramMotionEvent)
      {
        ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        dKc();
        dKb();
        continue;
      }
      AppMethodBeat.o(200285);
      return false;
      if (!this.yoO) {
        continue;
      }
      dJV();
      bVK();
      this.yoV = 3;
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
  
  public final void onLongPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200284);
    try
    {
      ac.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "onSingleTapConfirmed");
      if (!this.yoN)
      {
        this.yoN = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(200284);
        return false;
        this.yoN = false;
        setFocus(false);
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        ac.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramMotionEvent.toString());
      }
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200282);
    boolean bool = this.irA.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(200282);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah
 * JD-Core Version:    0.7.0.1
 */