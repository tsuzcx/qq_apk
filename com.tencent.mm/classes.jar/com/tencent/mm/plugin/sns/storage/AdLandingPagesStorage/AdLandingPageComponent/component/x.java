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
import com.tencent.mm.g.a.oi;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.vfs.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class x
  extends ah
  implements com.tencent.mm.plugin.sight.decode.ui.b, i.b
{
  private Context context;
  private ap gIf;
  private ProgressBar gWg;
  private View gZU;
  private boolean isAutoPlay;
  ImageView tCh;
  private long wiC;
  private int wji;
  private VideoPlayerSeekBar zFA;
  private ImageView zFB;
  boolean zFC;
  private ImageView zFD;
  private TextView zFE;
  private Runnable zFF;
  boolean zFG;
  boolean zFH;
  boolean zFI;
  boolean zFJ;
  boolean zFK;
  private boolean zFL;
  private boolean zFM;
  private boolean zFN;
  private boolean zFO;
  private boolean zFP;
  int zFQ;
  private int zFR;
  private int zFS;
  int zFT;
  int zFU;
  private al zFV;
  private View.OnClickListener zFW;
  private View.OnClickListener zFX;
  private View.OnClickListener zFY;
  private View.OnClickListener zFZ;
  AdLandingVideoWrapper zFz;
  
  public x(final Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj paramaj, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaj, paramViewGroup);
    AppMethodBeat.i(96637);
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
        AppMethodBeat.i(96631);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(x.this.zFz.isPlaying()) });
        if (x.this.zFz.isPlaying())
        {
          x.this.cxw();
          x.this.zFQ = 4;
          if (x.this.zxZ)
          {
            paramAnonymousView = x.this;
            paramAnonymousView.zFT += 1;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96631);
          return;
        }
        if (x.this.zFJ) {
          x.this.dWl();
        }
        for (;;)
        {
          x.b(x.this);
          x.this.zFQ = 3;
          break;
          x.this.dWo();
          x.this.dWn();
        }
      }
    };
    this.zFX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96632);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = x.this;
        paramAnonymousView.zFU += 1;
        if (x.this.zFJ)
        {
          x.this.dWo();
          x.this.dWn();
        }
        for (;;)
        {
          x.this.zFG = true;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96632);
          return;
          x.this.dWl();
        }
      }
    };
    this.zFY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96634);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        x.b(x.this);
        x.this.zFK = false;
        x.this.zFH = true;
        x.this.zFQ = 3;
        x.this.dWn();
        x.this.setFocus(true);
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96633);
            if (x.this.zFI)
            {
              AppMethodBeat.o(96633);
              return;
            }
            x.this.setFocus(false);
            AppMethodBeat.o(96633);
          }
        }, 10000L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(96634);
      }
    };
    this.zFZ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96635);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (!x.this.zFI)
        {
          x.this.zFI = true;
          x.this.setFocus(true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(96635);
      }
    };
    this.context = paramContext;
    this.gIf = new ap(Looper.getMainLooper());
    this.zFF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96625);
        x.this.setFocus(false);
        AppMethodBeat.o(96625);
      }
    };
    this.zFV = new al()
    {
      public final void rD(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96628);
        Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
        if (paramAnonymousBoolean) {}
        for (int i = 1;; i = 0)
        {
          localIntent.putExtra("show", i);
          localIntent.putExtra("activity_code", x.this.dWp());
          d.U(paramContext).b(localIntent);
          AppMethodBeat.o(96628);
          return;
        }
      }
    };
    AppMethodBeat.o(96637);
  }
  
  private void can()
  {
    AppMethodBeat.i(96639);
    ad.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "starting play");
    if (this.zFN)
    {
      ad.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "last download fail ,try again");
      this.zFz.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zzS, 0);
      Qs(0);
      this.zFz.dXw();
      AppMethodBeat.o(96639);
      return;
    }
    this.gIf.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96636);
        if (!x.this.zFz.isPlaying())
        {
          if (x.this.zFz.getCurrPosSec() != x.this.zFz.getVideoDurationSec()) {
            break label65;
          }
          x.this.Qs(0);
        }
        for (;;)
        {
          x.this.zFz.dXw();
          AppMethodBeat.o(96636);
          return;
          label65:
          x.this.Qs(x.this.zFz.getCurrPosSec());
        }
      }
    });
    this.wiC = System.currentTimeMillis();
    this.wji += 1;
    AppMethodBeat.o(96639);
  }
  
  final void Qs(int paramInt)
  {
    AppMethodBeat.i(96642);
    if (this.zFz != null)
    {
      this.zFD.setVisibility(8);
      if (this.tCh.getVisibility() == 0) {
        this.gWg.setVisibility(0);
      }
      this.zFz.c(paramInt, true);
    }
    AppMethodBeat.o(96642);
  }
  
  public final boolean aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96649);
    if (!super.aQ(paramJSONObject))
    {
      AppMethodBeat.o(96649);
      return false;
    }
    try
    {
      paramJSONObject.put("streamVideoDuraion", this.zFz.getVideoDurationSec() * 1000);
      paramJSONObject.put("playTimeInterval", this.zFR);
      paramJSONObject.put("playCount", this.wji);
      paramJSONObject.put("playCompletedCount", this.zFS);
      paramJSONObject.put("clickPlayControlCount", this.zFT);
      paramJSONObject.put("clickVoiceControlCount", this.zFU);
      if (this.isAutoPlay) {}
      for (String str = "1";; str = "0")
      {
        paramJSONObject.put("isAutoPlay", str);
        JSONObject localJSONObject;
        if (!this.zFO)
        {
          str = ai.ee(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zAV);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        if (!this.zFP)
        {
          str = ai.ee(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zzS);
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
  
  public final void aqD()
  {
    this.zFI = true;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96653);
    ad.e("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "online play error, %s", new Object[] { paramString3 });
    this.zFN = true;
    AppMethodBeat.o(96653);
  }
  
  final void cxw()
  {
    AppMethodBeat.i(96640);
    ad.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "pause play");
    this.gIf.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96626);
        x.this.zFz.pause();
        AppMethodBeat.o(96626);
      }
    });
    if (this.wiC != 0L)
    {
      this.zFR = ((int)(this.zFR + (System.currentTimeMillis() - this.wiC)));
      this.wiC = 0L;
    }
    AppMethodBeat.o(96640);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dRk()
  {
    AppMethodBeat.i(96638);
    super.dRk();
    View localView = this.contentView.findViewById(2131298770);
    localView.setBackgroundColor(-16777216);
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
      localView.setPadding((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).paddingLeft, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).paddingTop, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).paddingRight, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).paddingBottom);
    }
    localView.setLayoutParams(new RelativeLayout.LayoutParams(k, i));
    localView.setMinimumHeight(i);
    this.zFz = ((AdLandingVideoWrapper)localView.findViewById(2131306410));
    this.zFz.setIMMVideoViewCallback(this);
    this.zFz.setOnClickListener(this.zFZ);
    this.zFz.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zzS, 0);
    this.zFz.setIsShowBasicControls(true);
    this.gWg = ((ProgressBar)localView.findViewById(2131303535));
    this.tCh = ((ImageView)localView.findViewById(2131305798));
    Object localObject = h.jF("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zAV);
    if (!i.fv((String)localObject)) {
      this.zFO = false;
    }
    if (this.zFO)
    {
      this.tCh.setImageBitmap(g.decodeFile((String)localObject));
      this.zFE = ((TextView)localView.findViewById(2131299517));
      this.zFE.setText(this.context.getString(2131758104));
      this.gZU = localView.findViewById(2131304920);
      this.gZU.setVisibility(4);
      this.zFA = new VideoPlayerSeekBar(this.context);
      this.zFA.setVisibility(4);
      if (this.zFV != null)
      {
        localObject = this.zFV;
        if (this.zFA.getVisibility() != 0) {
          break label681;
        }
      }
    }
    label681:
    for (boolean bool = true;; bool = false)
    {
      ((al)localObject).rD(bool);
      this.zFA.setIplaySeekCallback(this);
      this.zFA.setOnPlayButtonClickListener(this.zFW);
      localObject = new RelativeLayout.LayoutParams(k - com.tencent.mm.cc.a.fromDPToPix(this.context, 30), -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.zFA.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.zFz.setVideoFooterView(this.zFA);
      this.zFB = ((ImageView)localView.findViewById(2131304921));
      this.zFB.setVisibility(4);
      this.zFB.setOnClickListener(this.zFX);
      this.zFB.setPadding(0, 0, com.tencent.mm.cc.a.fromDPToPix(this.context, 8), 0);
      this.zFD = ((ImageView)localView.findViewById(2131305196));
      this.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
      this.zFD.setVisibility(8);
      this.zFD.setOnClickListener(this.zFY);
      ((ViewGroup)this.zFA.getParent()).removeView(this.zFA);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
      ((ViewGroup)localView).addView(this.zFA, (ViewGroup.LayoutParams)localObject);
      this.zFz.setVideoPlayCallback(new AdLandingVideoWrapper.a()
      {
        public final void tt(int paramAnonymousInt)
        {
          AppMethodBeat.i(96630);
          if ((x.a(x.this).zzX != null) && (paramAnonymousInt * 1000 >= x.a(x.this).zzX.zAT) && (!x.this.zFC))
          {
            x.this.zFC = true;
            oi localoi = new oi();
            localoi.dCj.dCk = x.a(x.this).zzX.dCk;
            com.tencent.mm.sdk.b.a.IbL.l(localoi);
          }
          AppMethodBeat.o(96630);
        }
      });
      AppMethodBeat.o(96638);
      return;
      h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zAV, false, 1000000001, new f.a()
      {
        public final void axG(String paramAnonymousString)
        {
          AppMethodBeat.i(96629);
          if (x.this.tCh.getVisibility() == 0) {
            x.this.tCh.setImageBitmap(g.decodeFile(paramAnonymousString));
          }
          AppMethodBeat.o(96629);
        }
        
        public final void dRW() {}
        
        public final void dRX() {}
      });
      break;
    }
  }
  
  protected final void dRl() {}
  
  public final void dRm()
  {
    AppMethodBeat.i(96645);
    super.dRm();
    AppMethodBeat.o(96645);
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(96646);
    super.dRn();
    cxw();
    if ((!this.zFL) && (!this.zFM))
    {
      AppMethodBeat.o(96646);
      return;
    }
    this.zFM = false;
    this.zFL = false;
    if (this.zFQ == 1) {
      this.zFQ = 2;
    }
    AppMethodBeat.o(96646);
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(96647);
    super.dRo();
    this.zFz.onUIDestroy();
    AppMethodBeat.o(96647);
  }
  
  public final void dWX()
  {
    AppMethodBeat.i(96654);
    super.dWX();
    cxw();
    String str = h.jF("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)this.zDK).zAV);
    if (i.fv(str))
    {
      this.tCh.setImageBitmap(g.decodeFile(str));
      this.tCh.setVisibility(0);
    }
    AppMethodBeat.o(96654);
  }
  
  public final void dWl()
  {
    AppMethodBeat.i(96643);
    super.dWl();
    this.zFB.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131232840));
    this.zFz.setMute(true);
    this.zFJ = true;
    AppMethodBeat.o(96643);
  }
  
  public final void dWm()
  {
    AppMethodBeat.i(96648);
    super.dWm();
    int i = dWT();
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
      if ((this.zFL) && (!this.zFM))
      {
        AppMethodBeat.o(96648);
        return;
      }
      this.zFM = false;
      this.zFL = true;
      this.tCh.setVisibility(0);
      NetworkInfo localNetworkInfo = ((ConnectivityManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if ((!this.zFK) || ((this.zFK) && (localNetworkInfo != null) && (localNetworkInfo.getType() == 1)))
      {
        setFocus(true);
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96627);
            if (x.this.zFI)
            {
              AppMethodBeat.o(96627);
              return;
            }
            x.this.setFocus(false);
            AppMethodBeat.o(96627);
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
          AppMethodBeat.o(96648);
          return;
        }
        this.isAutoPlay = true;
        this.zFK = false;
      }
      if (this.zFQ == 0) {
        if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1))
        {
          if (!this.zFJ) {
            break label291;
          }
          dWl();
          this.zFQ = 1;
        }
      }
      for (;;)
      {
        can();
        label291:
        do
        {
          AppMethodBeat.o(96648);
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
              AppMethodBeat.o(96648);
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
    cxw();
    if (this.zFQ == 1) {
      this.zFQ = 2;
    }
    AppMethodBeat.o(96648);
  }
  
  public final void dWn()
  {
    AppMethodBeat.i(96644);
    super.dWn();
    this.zFB.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131232841));
    this.zFz.setMute(false);
    this.zFJ = false;
    AppMethodBeat.o(96644);
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    this.zFN = false;
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96651);
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
    AppMethodBeat.o(96651);
  }
  
  public final void ds(String paramString1, String paramString2) {}
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96652);
    this.tCh.setVisibility(8);
    this.gWg.setVisibility(8);
    AppMethodBeat.o(96652);
  }
  
  public final void du(String paramString1, String paramString2) {}
  
  public final void dv(String paramString1, String paramString2) {}
  
  public final void eT(String paramString1, String paramString2) {}
  
  protected final int getLayout()
  {
    return 2131495505;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(197983);
    boolean bool = this.zFz.isPlaying();
    AppMethodBeat.o(197983);
    return bool;
  }
  
  public final void nM(int paramInt)
  {
    AppMethodBeat.i(96650);
    ad.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "onSeek time ".concat(String.valueOf(paramInt)));
    if (this.zFJ) {
      dWl();
    }
    for (;;)
    {
      Qs(paramInt);
      AppMethodBeat.o(96650);
      return;
      dWo();
      dWn();
    }
  }
  
  final void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(96641);
    if (paramBoolean)
    {
      this.zFA.setVisibility(0);
      this.zFB.setVisibility(0);
      this.gZU.setVisibility(0);
      if (this.zFV != null) {
        this.zFV.rD(true);
      }
      this.gIf.postDelayed(this.zFF, 5000L);
      AppMethodBeat.o(96641);
      return;
    }
    this.zFI = false;
    this.zFA.setVisibility(4);
    this.zFB.setVisibility(8);
    this.gZU.setVisibility(4);
    if (this.zFV != null) {
      this.zFV.rD(false);
    }
    this.gIf.removeCallbacks(this.zFF);
    AppMethodBeat.o(96641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x
 * JD-Core Version:    0.7.0.1
 */