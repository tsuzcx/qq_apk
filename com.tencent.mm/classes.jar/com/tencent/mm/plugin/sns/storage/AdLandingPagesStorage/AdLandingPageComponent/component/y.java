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
import com.tencent.mm.g.a.oj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.vfs.o;
import org.json.JSONException;
import org.json.JSONObject;

public final class y
  extends ai
  implements com.tencent.mm.plugin.sight.decode.ui.b, i.b
{
  private Context context;
  private aq gKO;
  private ProgressBar gYT;
  private View hcH;
  private boolean isAutoPlay;
  ImageView tMY;
  private int wyN;
  private long wyh;
  AdLandingVideoWrapper zWF;
  private VideoPlayerSeekBar zWG;
  private ImageView zWH;
  boolean zWI;
  private ImageView zWJ;
  private TextView zWK;
  private Runnable zWL;
  boolean zWM;
  boolean zWN;
  boolean zWO;
  boolean zWP;
  boolean zWQ;
  private boolean zWR;
  private boolean zWS;
  private boolean zWT;
  private boolean zWU;
  private boolean zWV;
  int zWW;
  private int zWX;
  private int zWY;
  int zWZ;
  int zXa;
  private am zXb;
  private View.OnClickListener zXc;
  private View.OnClickListener zXd;
  private View.OnClickListener zXe;
  private View.OnClickListener zXf;
  
  public y(final Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak paramak, ViewGroup paramViewGroup)
  {
    super(paramContext, paramak, paramViewGroup);
    AppMethodBeat.i(96637);
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
        AppMethodBeat.i(96631);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(y.this.zWF.isPlaying()) });
        if (y.this.zWF.isPlaying())
        {
          y.this.cyX();
          y.this.zWW = 4;
          if (y.this.zPy)
          {
            paramAnonymousView = y.this;
            paramAnonymousView.zWZ += 1;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96631);
          return;
        }
        if (y.this.zWP) {
          y.this.dZN();
        }
        for (;;)
        {
          y.b(y.this);
          y.this.zWW = 3;
          break;
          y.this.dZQ();
          y.this.dZP();
        }
      }
    };
    this.zXd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96632);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = y.this;
        paramAnonymousView.zXa += 1;
        if (y.this.zWP)
        {
          y.this.dZQ();
          y.this.dZP();
        }
        for (;;)
        {
          y.this.zWM = true;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96632);
          return;
          y.this.dZN();
        }
      }
    };
    this.zXe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96634);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        y.b(y.this);
        y.this.zWQ = false;
        y.this.zWN = true;
        y.this.zWW = 3;
        y.this.dZP();
        y.this.setFocus(true);
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96633);
            if (y.this.zWO)
            {
              AppMethodBeat.o(96633);
              return;
            }
            y.this.setFocus(false);
            AppMethodBeat.o(96633);
          }
        }, 10000L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(96634);
      }
    };
    this.zXf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96635);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!y.this.zWO)
        {
          y.this.zWO = true;
          y.this.setFocus(true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(96635);
      }
    };
    this.context = paramContext;
    this.gKO = new aq(Looper.getMainLooper());
    this.zWL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96625);
        y.this.setFocus(false);
        AppMethodBeat.o(96625);
      }
    };
    this.zXb = new am()
    {
      public final void rK(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96628);
        Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
        if (paramAnonymousBoolean) {}
        for (int i = 1;; i = 0)
        {
          localIntent.putExtra("show", i);
          localIntent.putExtra("activity_code", y.this.dZR());
          d.V(paramContext).b(localIntent);
          AppMethodBeat.o(96628);
          return;
        }
      }
    };
    AppMethodBeat.o(96637);
  }
  
  private void cbC()
  {
    AppMethodBeat.i(96639);
    ae.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "starting play");
    if (this.zWT)
    {
      ae.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "last download fail ,try again");
      this.zWF.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zQR, 0);
      QZ(0);
      this.zWF.eaZ();
      AppMethodBeat.o(96639);
      return;
    }
    this.gKO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96636);
        if (!y.this.zWF.isPlaying())
        {
          if (y.this.zWF.getCurrPosSec() != y.this.zWF.getVideoDurationSec()) {
            break label65;
          }
          y.this.QZ(0);
        }
        for (;;)
        {
          y.this.zWF.eaZ();
          AppMethodBeat.o(96636);
          return;
          label65:
          y.this.QZ(y.this.zWF.getCurrPosSec());
        }
      }
    });
    this.wyh = System.currentTimeMillis();
    this.wyN += 1;
    AppMethodBeat.o(96639);
  }
  
  final void QZ(int paramInt)
  {
    AppMethodBeat.i(96642);
    if (this.zWF != null)
    {
      this.zWJ.setVisibility(8);
      if (this.tMY.getVisibility() == 0) {
        this.gYT.setVisibility(0);
      }
      this.zWF.c(paramInt, true);
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
      paramJSONObject.put("streamVideoDuraion", this.zWF.getVideoDurationSec() * 1000);
      paramJSONObject.put("playTimeInterval", this.zWX);
      paramJSONObject.put("playCount", this.wyN);
      paramJSONObject.put("playCompletedCount", this.zWY);
      paramJSONObject.put("clickPlayControlCount", this.zWZ);
      paramJSONObject.put("clickVoiceControlCount", this.zXa);
      if (this.isAutoPlay) {}
      for (String str = "1";; str = "0")
      {
        paramJSONObject.put("isAutoPlay", str);
        JSONObject localJSONObject;
        if (!this.zWU)
        {
          str = aj.ej(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zRV);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        if (!this.zWV)
        {
          str = aj.ej(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zQR);
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
      ae.printErrStackTrace("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96649);
    }
  }
  
  public final void aqS()
  {
    this.zWO = true;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96653);
    ae.e("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "online play error, %s", new Object[] { paramString3 });
    this.zWT = true;
    AppMethodBeat.o(96653);
  }
  
  final void cyX()
  {
    AppMethodBeat.i(96640);
    ae.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "pause play");
    this.gKO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96626);
        y.this.zWF.pause();
        AppMethodBeat.o(96626);
      }
    });
    if (this.wyh != 0L)
    {
      this.zWX = ((int)(this.zWX + (System.currentTimeMillis() - this.wyh)));
      this.wyh = 0L;
    }
    AppMethodBeat.o(96640);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dUI()
  {
    AppMethodBeat.i(96638);
    super.dUI();
    View localView = this.contentView.findViewById(2131298770);
    localView.setBackgroundColor(-16777216);
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
      localView.setPadding((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).paddingLeft, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).paddingTop, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).paddingRight, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).paddingBottom);
    }
    localView.setLayoutParams(new RelativeLayout.LayoutParams(k, i));
    localView.setMinimumHeight(i);
    this.zWF = ((AdLandingVideoWrapper)localView.findViewById(2131306410));
    this.zWF.setIMMVideoViewCallback(this);
    this.zWF.setOnClickListener(this.zXf);
    this.zWF.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zQR, 0);
    this.zWF.setIsShowBasicControls(true);
    this.gYT = ((ProgressBar)localView.findViewById(2131303535));
    this.tMY = ((ImageView)localView.findViewById(2131305798));
    Object localObject = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zRV);
    if (!o.fB((String)localObject)) {
      this.zWU = false;
    }
    if (this.zWU)
    {
      this.tMY.setImageBitmap(com.tencent.mm.sdk.platformtools.h.decodeFile((String)localObject));
      this.zWK = ((TextView)localView.findViewById(2131299517));
      this.zWK.setText(this.context.getString(2131758104));
      this.hcH = localView.findViewById(2131304920);
      this.hcH.setVisibility(4);
      this.zWG = new VideoPlayerSeekBar(this.context);
      this.zWG.setVisibility(4);
      if (this.zXb != null)
      {
        localObject = this.zXb;
        if (this.zWG.getVisibility() != 0) {
          break label681;
        }
      }
    }
    label681:
    for (boolean bool = true;; bool = false)
    {
      ((am)localObject).rK(bool);
      this.zWG.setIplaySeekCallback(this);
      this.zWG.setOnPlayButtonClickListener(this.zXc);
      localObject = new RelativeLayout.LayoutParams(k - com.tencent.mm.cb.a.fromDPToPix(this.context, 30), -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.zWG.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.zWF.setVideoFooterView(this.zWG);
      this.zWH = ((ImageView)localView.findViewById(2131304921));
      this.zWH.setVisibility(4);
      this.zWH.setOnClickListener(this.zXd);
      this.zWH.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.context, 8), 0);
      this.zWJ = ((ImageView)localView.findViewById(2131305196));
      this.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691166));
      this.zWJ.setVisibility(8);
      this.zWJ.setOnClickListener(this.zXe);
      ((ViewGroup)this.zWG.getParent()).removeView(this.zWG);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
      ((ViewGroup)localView).addView(this.zWG, (ViewGroup.LayoutParams)localObject);
      this.zWF.setVideoPlayCallback(new AdLandingVideoWrapper.a()
      {
        public final void tx(int paramAnonymousInt)
        {
          AppMethodBeat.i(96630);
          if ((y.a(y.this).zQW != null) && (paramAnonymousInt * 1000 >= y.a(y.this).zQW.zRT) && (!y.this.zWI))
          {
            y.this.zWI = true;
            oj localoj = new oj();
            localoj.dDo.dDp = y.a(y.this).zQW.dDp;
            com.tencent.mm.sdk.b.a.IvT.l(localoj);
          }
          AppMethodBeat.o(96630);
        }
      });
      AppMethodBeat.o(96638);
      return;
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zRV, false, 1000000001, new f.a()
      {
        public final void ayY(String paramAnonymousString)
        {
          AppMethodBeat.i(96629);
          if (y.this.tMY.getVisibility() == 0) {
            y.this.tMY.setImageBitmap(com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString));
          }
          AppMethodBeat.o(96629);
        }
        
        public final void dVu() {}
        
        public final void dVv() {}
      });
      break;
    }
  }
  
  protected final void dUJ() {}
  
  public final void dUK()
  {
    AppMethodBeat.i(96645);
    super.dUK();
    AppMethodBeat.o(96645);
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(96646);
    super.dUL();
    cyX();
    if ((!this.zWR) && (!this.zWS))
    {
      AppMethodBeat.o(96646);
      return;
    }
    this.zWS = false;
    this.zWR = false;
    if (this.zWW == 1) {
      this.zWW = 2;
    }
    AppMethodBeat.o(96646);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(96647);
    super.dUM();
    this.zWF.onUIDestroy();
    AppMethodBeat.o(96647);
  }
  
  public final void dZN()
  {
    AppMethodBeat.i(96643);
    super.dZN();
    this.zWH.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131232840));
    this.zWF.setMute(true);
    this.zWP = true;
    AppMethodBeat.o(96643);
  }
  
  public final void dZO()
  {
    AppMethodBeat.i(96648);
    super.dZO();
    int i = eax();
    int j = getView().getHeight();
    ae.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
      if ((this.zWR) && (!this.zWS))
      {
        AppMethodBeat.o(96648);
        return;
      }
      this.zWS = false;
      this.zWR = true;
      this.tMY.setVisibility(0);
      NetworkInfo localNetworkInfo = ((ConnectivityManager)com.tencent.mm.sdk.platformtools.ak.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if ((!this.zWQ) || ((this.zWQ) && (localNetworkInfo != null) && (localNetworkInfo.getType() == 1)))
      {
        setFocus(true);
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96627);
            if (y.this.zWO)
            {
              AppMethodBeat.o(96627);
              return;
            }
            y.this.setFocus(false);
            AppMethodBeat.o(96627);
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
          AppMethodBeat.o(96648);
          return;
        }
        this.isAutoPlay = true;
        this.zWQ = false;
      }
      if (this.zWW == 0) {
        if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1))
        {
          if (!this.zWP) {
            break label291;
          }
          dZN();
          this.zWW = 1;
        }
      }
      for (;;)
      {
        cbC();
        label291:
        do
        {
          AppMethodBeat.o(96648);
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
              AppMethodBeat.o(96648);
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
    cyX();
    if (this.zWW == 1) {
      this.zWW = 2;
    }
    AppMethodBeat.o(96648);
  }
  
  public final void dZP()
  {
    AppMethodBeat.i(96644);
    super.dZP();
    this.zWH.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131232841));
    this.zWF.setMute(false);
    this.zWP = false;
    AppMethodBeat.o(96644);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    this.zWT = false;
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96651);
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
    AppMethodBeat.o(96651);
  }
  
  public final void du(String paramString1, String paramString2) {}
  
  public final void dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96652);
    this.tMY.setVisibility(8);
    this.gYT.setVisibility(8);
    AppMethodBeat.o(96652);
  }
  
  public final void dw(String paramString1, String paramString2) {}
  
  public final void dx(String paramString1, String paramString2) {}
  
  public final void eX(String paramString1, String paramString2) {}
  
  public final void eaB()
  {
    AppMethodBeat.i(96654);
    super.eaB();
    cyX();
    String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)this.zUP).zRV);
    if (o.fB(str))
    {
      this.tMY.setImageBitmap(com.tencent.mm.sdk.platformtools.h.decodeFile(str));
      this.tMY.setVisibility(0);
    }
    AppMethodBeat.o(96654);
  }
  
  protected final int getLayout()
  {
    return 2131495505;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(219490);
    boolean bool = this.zWF.isPlaying();
    AppMethodBeat.o(219490);
    return bool;
  }
  
  public final void nP(int paramInt)
  {
    AppMethodBeat.i(96650);
    ae.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "onSeek time ".concat(String.valueOf(paramInt)));
    if (this.zWP) {
      dZN();
    }
    for (;;)
    {
      QZ(paramInt);
      AppMethodBeat.o(96650);
      return;
      dZQ();
      dZP();
    }
  }
  
  final void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(96641);
    if (paramBoolean)
    {
      this.zWG.setVisibility(0);
      this.zWH.setVisibility(0);
      this.hcH.setVisibility(0);
      if (this.zXb != null) {
        this.zXb.rK(true);
      }
      this.gKO.postDelayed(this.zWL, 5000L);
      AppMethodBeat.o(96641);
      return;
    }
    this.zWO = false;
    this.zWG.setVisibility(4);
    this.zWH.setVisibility(8);
    this.hcH.setVisibility(4);
    if (this.zXb != null) {
      this.zXb.rK(false);
    }
    this.gKO.removeCallbacks(this.zWL);
    AppMethodBeat.o(96641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y
 * JD-Core Version:    0.7.0.1
 */