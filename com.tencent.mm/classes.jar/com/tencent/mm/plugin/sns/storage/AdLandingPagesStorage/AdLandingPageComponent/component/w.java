package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.support.v4.content.d;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class w
  extends ag
  implements b, h.b
{
  private Context context;
  private ap gAC;
  private ProgressBar iiH;
  private boolean isAutoPlay;
  private View lRB;
  ImageView rww;
  private long tUy;
  private int tVe;
  AdLandingVideoWrapper xbP;
  private VideoPlayerSeekBar xbQ;
  private ImageView xbR;
  boolean xbS;
  private ImageView xbT;
  private TextView xbU;
  private Runnable xbV;
  boolean xbW;
  boolean xbX;
  boolean xbY;
  boolean xbZ;
  boolean xca;
  private boolean xcb;
  private boolean xcc;
  private boolean xce;
  private boolean xcf;
  private boolean xcg;
  int xch;
  private int xci;
  private int xcj;
  int xck;
  int xcl;
  private ak xcm;
  private View.OnClickListener xcn;
  private View.OnClickListener xco;
  private View.OnClickListener xcp;
  private View.OnClickListener xcq;
  
  public w(final Context paramContext, ah paramah, ViewGroup paramViewGroup)
  {
    super(paramContext, paramah, paramViewGroup);
    AppMethodBeat.i(96637);
    this.xbW = false;
    this.xbX = false;
    this.xbY = false;
    this.xbZ = true;
    this.xca = true;
    this.xcb = false;
    this.xcc = true;
    this.isAutoPlay = false;
    this.xce = false;
    this.xcf = false;
    this.xcg = false;
    this.xch = 0;
    this.tUy = 0L;
    this.xci = 0;
    this.tVe = 0;
    this.xcj = 0;
    this.xck = 0;
    this.xcl = 0;
    this.xcm = null;
    this.xcn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96631);
        ad.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(w.this.xbP.isPlaying()) });
        if (w.this.xbP.isPlaying())
        {
          w.this.ckd();
          w.this.xch = 4;
          if (w.this.wVd)
          {
            paramAnonymousView = w.this;
            paramAnonymousView.xck += 1;
          }
          AppMethodBeat.o(96631);
          return;
        }
        if (w.this.xbZ) {
          w.this.dvw();
        }
        for (;;)
        {
          w.b(w.this);
          w.this.xch = 3;
          break;
          w.this.dvD();
          w.this.dvC();
        }
      }
    };
    this.xco = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96632);
        paramAnonymousView = w.this;
        paramAnonymousView.xcl += 1;
        if (w.this.xbZ)
        {
          w.this.dvD();
          w.this.dvC();
        }
        for (;;)
        {
          w.this.xbW = true;
          AppMethodBeat.o(96632);
          return;
          w.this.dvw();
        }
      }
    };
    this.xcp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96634);
        w.b(w.this);
        w.this.xca = false;
        w.this.xbX = true;
        w.this.xch = 3;
        w.this.dvC();
        w.this.setFocus(true);
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96633);
            if (w.this.xbY)
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
    this.xcq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96635);
        if (!w.this.xbY)
        {
          w.this.xbY = true;
          w.this.setFocus(true);
        }
        AppMethodBeat.o(96635);
      }
    };
    this.context = paramContext;
    this.gAC = new ap(Looper.getMainLooper());
    this.xbV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96625);
        w.this.setFocus(false);
        AppMethodBeat.o(96625);
      }
    };
    this.xcm = new ak()
    {
      public final void qa(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96628);
        Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
        if (paramAnonymousBoolean) {}
        for (int i = 1;; i = 0)
        {
          localIntent.putExtra("show", i);
          d.T(paramContext).b(localIntent);
          AppMethodBeat.o(96628);
          return;
        }
      }
    };
    AppMethodBeat.o(96637);
  }
  
  private void bOu()
  {
    AppMethodBeat.i(96639);
    ad.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "starting play");
    if (this.xce)
    {
      ad.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "last download fail ,try again");
      this.xbP.c(false, ((ah)this.xab).wWw, 0);
      MI(0);
      this.xbP.dwG();
      AppMethodBeat.o(96639);
      return;
    }
    this.gAC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96636);
        if (!w.this.xbP.isPlaying())
        {
          if (w.this.xbP.getCurrPosSec() != w.this.xbP.getVideoDurationSec()) {
            break label65;
          }
          w.this.MI(0);
        }
        for (;;)
        {
          w.this.xbP.dwG();
          AppMethodBeat.o(96636);
          return;
          label65:
          w.this.MI(w.this.xbP.getCurrPosSec());
        }
      }
    });
    this.tUy = System.currentTimeMillis();
    this.tVe += 1;
    AppMethodBeat.o(96639);
  }
  
  final void MI(int paramInt)
  {
    AppMethodBeat.i(96642);
    if (this.xbP != null)
    {
      this.xbT.setVisibility(8);
      if (this.rww.getVisibility() == 0) {
        this.iiH.setVisibility(0);
      }
      this.xbP.c(paramInt, true);
    }
    AppMethodBeat.o(96642);
  }
  
  public final boolean aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96649);
    if (!super.aG(paramJSONObject))
    {
      AppMethodBeat.o(96649);
      return false;
    }
    try
    {
      paramJSONObject.put("streamVideoDuraion", this.xbP.getVideoDurationSec() * 1000);
      paramJSONObject.put("playTimeInterval", this.xci);
      paramJSONObject.put("playCount", this.tVe);
      paramJSONObject.put("playCompletedCount", this.xcj);
      paramJSONObject.put("clickPlayControlCount", this.xck);
      paramJSONObject.put("clickVoiceControlCount", this.xcl);
      if (this.isAutoPlay) {}
      for (String str = "1";; str = "0")
      {
        paramJSONObject.put("isAutoPlay", str);
        JSONObject localJSONObject;
        if (!this.xcf)
        {
          str = ai.du(((ah)this.xab).wXs);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        if (!this.xcg)
        {
          str = ai.du(((ah)this.xab).wWw);
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
      ad.printErrStackTrace("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96649);
    }
  }
  
  public final void bcv()
  {
    this.xbY = true;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96653);
    ad.e("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "online play error, %s", new Object[] { paramString3 });
    this.xce = true;
    AppMethodBeat.o(96653);
  }
  
  final void ckd()
  {
    AppMethodBeat.i(96640);
    ad.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "pause play");
    this.gAC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96626);
        w.this.xbP.pause();
        AppMethodBeat.o(96626);
      }
    });
    if (this.tUy != 0L)
    {
      this.xci = ((int)(this.xci + (System.currentTimeMillis() - this.tUy)));
      this.tUy = 0L;
    }
    AppMethodBeat.o(96640);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void db(String paramString1, String paramString2)
  {
    this.xce = false;
  }
  
  public final void dc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96651);
    this.xcj += 1;
    setFocus(true);
    this.xbP.xdT.stopTimer();
    if (this.tUy != 0L)
    {
      this.xci = ((int)(this.xci + (System.currentTimeMillis() - this.tUy)));
      this.tUy = 0L;
    }
    this.xch = 5;
    this.xbP.onUIPause();
    AppMethodBeat.o(96651);
  }
  
  public final void dd(String paramString1, String paramString2) {}
  
  public final void de(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96652);
    this.rww.setVisibility(8);
    this.iiH.setVisibility(8);
    AppMethodBeat.o(96652);
  }
  
  public final void dg(String paramString1, String paramString2) {}
  
  public final void dh(String paramString1, String paramString2) {}
  
  public final void dvA()
  {
    AppMethodBeat.i(96646);
    super.dvA();
    ckd();
    if ((!this.xcb) && (!this.xcc))
    {
      AppMethodBeat.o(96646);
      return;
    }
    this.xcc = false;
    this.xcb = false;
    if (this.xch == 1) {
      this.xch = 2;
    }
    AppMethodBeat.o(96646);
  }
  
  public final void dvB()
  {
    AppMethodBeat.i(96648);
    super.dvB();
    int i = dwc();
    int j = getView().getHeight();
    ad.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
      if ((this.xcb) && (!this.xcc))
      {
        AppMethodBeat.o(96648);
        return;
      }
      this.xcc = false;
      this.xcb = true;
      this.rww.setVisibility(0);
      NetworkInfo localNetworkInfo = ((ConnectivityManager)aj.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if ((!this.xca) || ((this.xca) && (localNetworkInfo != null) && (localNetworkInfo.getType() == 1)))
      {
        setFocus(true);
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96627);
            if (w.this.xbY)
            {
              AppMethodBeat.o(96627);
              return;
            }
            w.this.setFocus(false);
            AppMethodBeat.o(96627);
          }
        }, 3000L);
      }
      if (this.xca)
      {
        if ((localNetworkInfo == null) || ((localNetworkInfo != null) && (localNetworkInfo.getType() != 1)))
        {
          this.xbT.setVisibility(0);
          this.isAutoPlay = false;
          this.xca = false;
          AppMethodBeat.o(96648);
          return;
        }
        this.isAutoPlay = true;
        this.xca = false;
      }
      if (this.xch == 0) {
        if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1))
        {
          if (!this.xbZ) {
            break label291;
          }
          dvw();
          this.xch = 1;
        }
      }
      for (;;)
      {
        bOu();
        label291:
        do
        {
          AppMethodBeat.o(96648);
          return;
          dvC();
          break;
          if (this.xch == 2)
          {
            if (this.xbZ) {
              dvw();
            }
            for (;;)
            {
              bOu();
              this.xch = 1;
              AppMethodBeat.o(96648);
              return;
              dvC();
            }
          }
        } while (this.xch != 3);
        if (this.xbZ) {
          dvw();
        } else {
          dvC();
        }
      }
    }
    this.xcc = false;
    this.xcb = false;
    ckd();
    if (this.xch == 1) {
      this.xch = 2;
    }
    AppMethodBeat.o(96648);
  }
  
  public final void dvC()
  {
    AppMethodBeat.i(96644);
    super.dvC();
    this.xbR.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131232841));
    this.xbP.setMute(false);
    this.xbZ = false;
    AppMethodBeat.o(96644);
  }
  
  protected final void dvN() {}
  
  public final void dvw()
  {
    AppMethodBeat.i(96643);
    super.dvw();
    this.xbR.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131232840));
    this.xbP.setMute(true);
    this.xbZ = true;
    AppMethodBeat.o(96643);
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(96638);
    super.dvx();
    View localView = this.contentView.findViewById(2131298770);
    localView.setBackgroundColor(-16777216);
    int k = this.kvn;
    int j = this.kvo;
    int i = j;
    if (((ah)this.xab).wXt == 1)
    {
      i = j;
      if ((int)((ah)this.xab).width > 0) {
        i = k * (int)((ah)this.xab).height / (int)((ah)this.xab).width;
      }
    }
    else
    {
      localView.setPadding((int)((ah)this.xab).paddingLeft, (int)((ah)this.xab).paddingTop, (int)((ah)this.xab).paddingRight, (int)((ah)this.xab).paddingBottom);
    }
    localView.setLayoutParams(new RelativeLayout.LayoutParams(k, i));
    localView.setMinimumHeight(i);
    this.xbP = ((AdLandingVideoWrapper)localView.findViewById(2131306410));
    this.xbP.setIMMVideoViewCallback(this);
    this.xbP.setOnClickListener(this.xcq);
    this.xbP.c(false, ((ah)this.xab).wWw, 0);
    this.xbP.setIsShowBasicControls(true);
    this.iiH = ((ProgressBar)localView.findViewById(2131303535));
    this.rww = ((ImageView)localView.findViewById(2131305798));
    Object localObject = h.iU("adId", ((ah)this.xab).wXs);
    if (!i.eK((String)localObject)) {
      this.xcf = false;
    }
    if (this.xcf)
    {
      this.rww.setImageBitmap(f.decodeFile((String)localObject));
      this.xbU = ((TextView)localView.findViewById(2131299517));
      this.xbU.setText(this.context.getString(2131758104));
      this.lRB = localView.findViewById(2131304920);
      this.lRB.setVisibility(4);
      this.xbQ = new VideoPlayerSeekBar(this.context);
      this.xbQ.setVisibility(4);
      if (this.xcm != null)
      {
        localObject = this.xcm;
        if (this.xbQ.getVisibility() != 0) {
          break label681;
        }
      }
    }
    label681:
    for (boolean bool = true;; bool = false)
    {
      ((ak)localObject).qa(bool);
      this.xbQ.setIplaySeekCallback(this);
      this.xbQ.setOnPlayButtonClickListener(this.xcn);
      localObject = new RelativeLayout.LayoutParams(k - com.tencent.mm.cd.a.fromDPToPix(this.context, 30), -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.xbQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.xbP.setVideoFooterView(this.xbQ);
      this.xbR = ((ImageView)localView.findViewById(2131304921));
      this.xbR.setVisibility(4);
      this.xbR.setOnClickListener(this.xco);
      this.xbR.setPadding(0, 0, com.tencent.mm.cd.a.fromDPToPix(this.context, 8), 0);
      this.xbT = ((ImageView)localView.findViewById(2131305196));
      this.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691166));
      this.xbT.setVisibility(8);
      this.xbT.setOnClickListener(this.xcp);
      ((ViewGroup)this.xbQ.getParent()).removeView(this.xbQ);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
      ((ViewGroup)localView).addView(this.xbQ, (ViewGroup.LayoutParams)localObject);
      this.xbP.setVideoPlayCallback(new AdLandingVideoWrapper.a()
      {
        public final void sa(int paramAnonymousInt)
        {
          AppMethodBeat.i(96630);
          if ((w.a(w.this).wWB != null) && (paramAnonymousInt * 1000 >= w.a(w.this).wWB.wXq) && (!w.this.xbS))
          {
            w.this.xbS = true;
            nr localnr = new nr();
            localnr.dsM.dsN = w.a(w.this).wWB.dsN;
            com.tencent.mm.sdk.b.a.ESL.l(localnr);
          }
          AppMethodBeat.o(96630);
        }
      });
      AppMethodBeat.o(96638);
      return;
      h.c("adId", ((ah)this.xab).wXs, false, 1000000001, new f.a()
      {
        public final void apm(String paramAnonymousString)
        {
          AppMethodBeat.i(96629);
          if (w.this.rww.getVisibility() == 0) {
            w.this.rww.setImageBitmap(f.decodeFile(paramAnonymousString));
          }
          AppMethodBeat.o(96629);
        }
        
        public final void dsA() {}
        
        public final void duP() {}
      });
      break;
    }
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(96647);
    super.dvy();
    this.xbP.onUIDestroy();
    AppMethodBeat.o(96647);
  }
  
  public final void dvz()
  {
    AppMethodBeat.i(96645);
    super.dvz();
    AppMethodBeat.o(96645);
  }
  
  public final void dwg()
  {
    AppMethodBeat.i(96654);
    super.dwg();
    ckd();
    String str = h.iU("adId", ((ah)this.xab).wXs);
    if (i.eK(str))
    {
      this.rww.setImageBitmap(f.decodeFile(str));
      this.rww.setVisibility(0);
    }
    AppMethodBeat.o(96654);
  }
  
  protected final int getLayout()
  {
    return 2131495505;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(187412);
    boolean bool = this.xbP.isPlaying();
    AppMethodBeat.o(187412);
    return bool;
  }
  
  public final void jw(String paramString1, String paramString2) {}
  
  public final void rZ(int paramInt)
  {
    AppMethodBeat.i(96650);
    ad.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "onSeek time ".concat(String.valueOf(paramInt)));
    if (this.xbZ) {
      dvw();
    }
    for (;;)
    {
      MI(paramInt);
      AppMethodBeat.o(96650);
      return;
      dvD();
      dvC();
    }
  }
  
  final void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(96641);
    if (paramBoolean)
    {
      this.xbQ.setVisibility(0);
      this.xbR.setVisibility(0);
      this.lRB.setVisibility(0);
      if (this.xcm != null) {
        this.xcm.qa(true);
      }
      this.gAC.postDelayed(this.xbV, 5000L);
      AppMethodBeat.o(96641);
      return;
    }
    this.xbY = false;
    this.xbQ.setVisibility(4);
    this.xbR.setVisibility(8);
    this.lRB.setVisibility(4);
    if (this.xcm != null) {
      this.xcm.qa(false);
    }
    this.gAC.removeCallbacks(this.xbV);
    AppMethodBeat.o(96641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w
 * JD-Core Version:    0.7.0.1
 */