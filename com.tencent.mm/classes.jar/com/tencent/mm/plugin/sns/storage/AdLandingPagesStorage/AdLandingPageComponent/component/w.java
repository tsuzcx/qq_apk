package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class w
  extends ag
  implements b, h.b
{
  private Context context;
  private ProgressBar gCw;
  private View gGk;
  private ao gox;
  private boolean isAutoPlay;
  ImageView sFo;
  private int vdM;
  private long vdg;
  AdLandingVideoWrapper yoE;
  private VideoPlayerSeekBar yoF;
  private ImageView yoG;
  boolean yoH;
  private ImageView yoI;
  private TextView yoJ;
  private Runnable yoK;
  boolean yoL;
  boolean yoM;
  boolean yoN;
  boolean yoO;
  boolean yoP;
  private boolean yoQ;
  private boolean yoR;
  private boolean yoS;
  private boolean yoT;
  private boolean yoU;
  int yoV;
  private int yoW;
  private int yoX;
  int yoY;
  int yoZ;
  private ak ypa;
  private View.OnClickListener ypb;
  private View.OnClickListener ypc;
  private View.OnClickListener ypd;
  private View.OnClickListener ype;
  
  public w(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai paramai, ViewGroup paramViewGroup)
  {
    super(paramContext, paramai, paramViewGroup);
    AppMethodBeat.i(96637);
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
        AppMethodBeat.i(96631);
        ac.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(w.this.yoE.isPlaying()) });
        if (w.this.yoE.isPlaying())
        {
          w.this.crK();
          w.this.yoV = 4;
          if (w.this.yhR)
          {
            paramAnonymousView = w.this;
            paramAnonymousView.yoY += 1;
          }
          AppMethodBeat.o(96631);
          return;
        }
        if (w.this.yoO) {
          w.this.dJV();
        }
        for (;;)
        {
          w.b(w.this);
          w.this.yoV = 3;
          break;
          w.this.dKc();
          w.this.dKb();
        }
      }
    };
    this.ypc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96632);
        paramAnonymousView = w.this;
        paramAnonymousView.yoZ += 1;
        if (w.this.yoO)
        {
          w.this.dKc();
          w.this.dKb();
        }
        for (;;)
        {
          w.this.yoL = true;
          AppMethodBeat.o(96632);
          return;
          w.this.dJV();
        }
      }
    };
    this.ypd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96634);
        w.b(w.this);
        w.this.yoP = false;
        w.this.yoM = true;
        w.this.yoV = 3;
        w.this.dKb();
        w.this.setFocus(true);
        ap.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96633);
            if (w.this.yoN)
            {
              AppMethodBeat.o(96633);
              return;
            }
            w.this.setFocus(false);
            AppMethodBeat.o(96633);
          }
        }, 10000L);
        AppMethodBeat.o(96634);
      }
    };
    this.ype = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96635);
        if (!w.this.yoN)
        {
          w.this.yoN = true;
          w.this.setFocus(true);
        }
        AppMethodBeat.o(96635);
      }
    };
    this.context = paramContext;
    this.gox = new ao(Looper.getMainLooper());
    this.yoK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96625);
        w.this.setFocus(false);
        AppMethodBeat.o(96625);
      }
    };
    this.ypa = new w.4(this, paramContext);
    AppMethodBeat.o(96637);
  }
  
  private void bVK()
  {
    AppMethodBeat.i(96639);
    ac.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "starting play");
    if (this.yoS)
    {
      ac.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "last download fail ,try again");
      this.yoE.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).yjk, 0);
      OK(0);
      this.yoE.dLf();
      AppMethodBeat.o(96639);
      return;
    }
    this.gox.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96636);
        if (!w.this.yoE.isPlaying())
        {
          if (w.this.yoE.getCurrPosSec() != w.this.yoE.getVideoDurationSec()) {
            break label65;
          }
          w.this.OK(0);
        }
        for (;;)
        {
          w.this.yoE.dLf();
          AppMethodBeat.o(96636);
          return;
          label65:
          w.this.OK(w.this.yoE.getCurrPosSec());
        }
      }
    });
    this.vdg = System.currentTimeMillis();
    this.vdM += 1;
    AppMethodBeat.o(96639);
  }
  
  final void OK(int paramInt)
  {
    AppMethodBeat.i(96642);
    if (this.yoE != null)
    {
      this.yoI.setVisibility(8);
      if (this.sFo.getVisibility() == 0) {
        this.gCw.setVisibility(0);
      }
      this.yoE.c(paramInt, true);
    }
    AppMethodBeat.o(96642);
  }
  
  public final boolean aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96649);
    if (!super.aH(paramJSONObject))
    {
      AppMethodBeat.o(96649);
      return false;
    }
    try
    {
      paramJSONObject.put("streamVideoDuraion", this.yoE.getVideoDurationSec() * 1000);
      paramJSONObject.put("playTimeInterval", this.yoW);
      paramJSONObject.put("playCount", this.vdM);
      paramJSONObject.put("playCompletedCount", this.yoX);
      paramJSONObject.put("clickPlayControlCount", this.yoY);
      paramJSONObject.put("clickVoiceControlCount", this.yoZ);
      if (this.isAutoPlay) {}
      for (String str = "1";; str = "0")
      {
        paramJSONObject.put("isAutoPlay", str);
        JSONObject localJSONObject;
        if (!this.yoT)
        {
          str = ah.dg(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).ykg);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        if (!this.yoU)
        {
          str = ah.dg(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).yjk);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("streamVideoUrlInfo", localJSONObject);
        }
        AppMethodBeat.o(96649);
        return true;
      }
      return false;
    }
    catch (JSONException paramJSONObject)
    {
      ac.printErrStackTrace("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96649);
    }
  }
  
  public final void anR()
  {
    this.yoN = true;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96653);
    ac.e("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "online play error, %s", new Object[] { paramString3 });
    this.yoS = true;
    AppMethodBeat.o(96653);
  }
  
  final void crK()
  {
    AppMethodBeat.i(96640);
    ac.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "pause play");
    this.gox.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96626);
        w.this.yoE.pause();
        AppMethodBeat.o(96626);
      }
    });
    if (this.vdg != 0L)
    {
      this.yoW = ((int)(this.yoW + (System.currentTimeMillis() - this.vdg)));
      this.vdg = 0L;
    }
    AppMethodBeat.o(96640);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dJV()
  {
    AppMethodBeat.i(96643);
    super.dJV();
    this.yoG.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131232840));
    this.yoE.setMute(true);
    this.yoO = true;
    AppMethodBeat.o(96643);
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(96638);
    super.dJW();
    View localView = this.contentView.findViewById(2131298770);
    localView.setBackgroundColor(-16777216);
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
      localView.setPadding((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).paddingLeft, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).paddingTop, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).paddingRight, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).paddingBottom);
    }
    localView.setLayoutParams(new RelativeLayout.LayoutParams(k, i));
    localView.setMinimumHeight(i);
    this.yoE = ((AdLandingVideoWrapper)localView.findViewById(2131306410));
    this.yoE.setIMMVideoViewCallback(this);
    this.yoE.setOnClickListener(this.ype);
    this.yoE.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).yjk, 0);
    this.yoE.setIsShowBasicControls(true);
    this.gCw = ((ProgressBar)localView.findViewById(2131303535));
    this.sFo = ((ImageView)localView.findViewById(2131305798));
    Object localObject = h.js("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).ykg);
    if (!i.eA((String)localObject)) {
      this.yoT = false;
    }
    if (this.yoT)
    {
      this.sFo.setImageBitmap(f.decodeFile((String)localObject));
      this.yoJ = ((TextView)localView.findViewById(2131299517));
      this.yoJ.setText(this.context.getString(2131758104));
      this.gGk = localView.findViewById(2131304920);
      this.gGk.setVisibility(4);
      this.yoF = new VideoPlayerSeekBar(this.context);
      this.yoF.setVisibility(4);
      if (this.ypa != null)
      {
        localObject = this.ypa;
        if (this.yoF.getVisibility() != 0) {
          break label681;
        }
      }
    }
    label681:
    for (boolean bool = true;; bool = false)
    {
      ((ak)localObject).qZ(bool);
      this.yoF.setIplaySeekCallback(this);
      this.yoF.setOnPlayButtonClickListener(this.ypb);
      localObject = new RelativeLayout.LayoutParams(k - com.tencent.mm.cc.a.fromDPToPix(this.context, 30), -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.yoF.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.yoE.setVideoFooterView(this.yoF);
      this.yoG = ((ImageView)localView.findViewById(2131304921));
      this.yoG.setVisibility(4);
      this.yoG.setOnClickListener(this.ypc);
      this.yoG.setPadding(0, 0, com.tencent.mm.cc.a.fromDPToPix(this.context, 8), 0);
      this.yoI = ((ImageView)localView.findViewById(2131305196));
      this.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
      this.yoI.setVisibility(8);
      this.yoI.setOnClickListener(this.ypd);
      ((ViewGroup)this.yoF.getParent()).removeView(this.yoF);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
      ((ViewGroup)localView).addView(this.yoF, (ViewGroup.LayoutParams)localObject);
      this.yoE.setVideoPlayCallback(new AdLandingVideoWrapper.a()
      {
        public final void sQ(int paramAnonymousInt)
        {
          AppMethodBeat.i(96630);
          if ((w.a(w.this).yjp != null) && (paramAnonymousInt * 1000 >= w.a(w.this).yjp.yke) && (!w.this.yoH))
          {
            w.this.yoH = true;
            oa localoa = new oa();
            localoa.dqw.dqx = w.a(w.this).yjp.dqx;
            com.tencent.mm.sdk.b.a.GpY.l(localoa);
          }
          AppMethodBeat.o(96630);
        }
      });
      AppMethodBeat.o(96638);
      return;
      h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).ykg, false, 1000000001, new f.a()
      {
        public final void asD(String paramAnonymousString)
        {
          AppMethodBeat.i(96629);
          if (w.this.sFo.getVisibility() == 0) {
            w.this.sFo.setImageBitmap(f.decodeFile(paramAnonymousString));
          }
          AppMethodBeat.o(96629);
        }
        
        public final void dFC() {}
        
        public final void dFD() {}
      });
      break;
    }
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(96647);
    super.dJX();
    this.yoE.onUIDestroy();
    AppMethodBeat.o(96647);
  }
  
  public final void dJY()
  {
    AppMethodBeat.i(96645);
    super.dJY();
    AppMethodBeat.o(96645);
  }
  
  public final void dJZ()
  {
    AppMethodBeat.i(96646);
    super.dJZ();
    crK();
    if ((!this.yoQ) && (!this.yoR))
    {
      AppMethodBeat.o(96646);
      return;
    }
    this.yoR = false;
    this.yoQ = false;
    if (this.yoV == 1) {
      this.yoV = 2;
    }
    AppMethodBeat.o(96646);
  }
  
  public final void dKF()
  {
    AppMethodBeat.i(96654);
    super.dKF();
    crK();
    String str = h.js("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)this.ymQ).ykg);
    if (i.eA(str))
    {
      this.sFo.setImageBitmap(f.decodeFile(str));
      this.sFo.setVisibility(0);
    }
    AppMethodBeat.o(96654);
  }
  
  public final void dKa()
  {
    AppMethodBeat.i(96648);
    super.dKa();
    int i = dKB();
    int j = getView().getHeight();
    ac.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 0) || (j == 0))
    {
      AppMethodBeat.o(96648);
      return;
    }
    if (i < 0)
    {
      AppMethodBeat.o(96648);
      return;
    }
    if (i >= j * 0.5F)
    {
      if ((this.yoQ) && (!this.yoR))
      {
        AppMethodBeat.o(96648);
        return;
      }
      this.yoR = false;
      this.yoQ = true;
      this.sFo.setVisibility(0);
      NetworkInfo localNetworkInfo = ((ConnectivityManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if ((!this.yoP) || ((this.yoP) && (localNetworkInfo != null) && (localNetworkInfo.getType() == 1)))
      {
        setFocus(true);
        ap.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96627);
            if (w.this.yoN)
            {
              AppMethodBeat.o(96627);
              return;
            }
            w.this.setFocus(false);
            AppMethodBeat.o(96627);
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
          AppMethodBeat.o(96648);
          return;
        }
        this.isAutoPlay = true;
        this.yoP = false;
      }
      if (this.yoV == 0) {
        if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1))
        {
          if (!this.yoO) {
            break label291;
          }
          dJV();
          this.yoV = 1;
        }
      }
      for (;;)
      {
        bVK();
        label291:
        do
        {
          AppMethodBeat.o(96648);
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
              AppMethodBeat.o(96648);
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
    crK();
    if (this.yoV == 1) {
      this.yoV = 2;
    }
    AppMethodBeat.o(96648);
  }
  
  public final void dKb()
  {
    AppMethodBeat.i(96644);
    super.dKb();
    this.yoG.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131232841));
    this.yoE.setMute(false);
    this.yoO = false;
    AppMethodBeat.o(96644);
  }
  
  protected final void dKm() {}
  
  public final void jdMethod_do(String paramString1, String paramString2)
  {
    this.yoS = false;
  }
  
  public final void dp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96651);
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
    AppMethodBeat.o(96651);
  }
  
  public final void dq(String paramString1, String paramString2) {}
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96652);
    this.sFo.setVisibility(8);
    this.gCw.setVisibility(8);
    AppMethodBeat.o(96652);
  }
  
  public final void ds(String paramString1, String paramString2) {}
  
  public final void dt(String paramString1, String paramString2) {}
  
  public final void eJ(String paramString1, String paramString2) {}
  
  protected final int getLayout()
  {
    return 2131495505;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(200212);
    boolean bool = this.yoE.isPlaying();
    AppMethodBeat.o(200212);
    return bool;
  }
  
  public final void nn(int paramInt)
  {
    AppMethodBeat.i(96650);
    ac.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "onSeek time ".concat(String.valueOf(paramInt)));
    if (this.yoO) {
      dJV();
    }
    for (;;)
    {
      OK(paramInt);
      AppMethodBeat.o(96650);
      return;
      dKc();
      dKb();
    }
  }
  
  final void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(96641);
    if (paramBoolean)
    {
      this.yoF.setVisibility(0);
      this.yoG.setVisibility(0);
      this.gGk.setVisibility(0);
      if (this.ypa != null) {
        this.ypa.qZ(true);
      }
      this.gox.postDelayed(this.yoK, 5000L);
      AppMethodBeat.o(96641);
      return;
    }
    this.yoN = false;
    this.yoF.setVisibility(4);
    this.yoG.setVisibility(8);
    this.gGk.setVisibility(4);
    if (this.ypa != null) {
      this.ypa.qZ(false);
    }
    this.gox.removeCallbacks(this.yoK);
    AppMethodBeat.o(96641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w
 * JD-Core Version:    0.7.0.1
 */