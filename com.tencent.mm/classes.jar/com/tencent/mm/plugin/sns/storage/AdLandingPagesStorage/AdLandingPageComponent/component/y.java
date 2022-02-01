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
import com.tencent.mm.g.a.pb;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.vfs.s;
import org.json.JSONException;
import org.json.JSONObject;

public final class y
  extends ak
  implements com.tencent.mm.plugin.sight.decode.ui.b, i.b
{
  private long AhP;
  private int Aiv;
  AdLandingVideoWrapper EeO;
  private VideoPlayerSeekBar EeP;
  private ImageView EeQ;
  boolean EeR;
  private ImageView EeS;
  private TextView EeT;
  private Runnable EeU;
  boolean EeV;
  boolean EeW;
  boolean EeX;
  boolean EeY;
  boolean EeZ;
  private boolean Efa;
  private boolean Efb;
  private boolean Efc;
  private boolean Efd;
  private boolean Efe;
  int Eff;
  private int Efg;
  private int Efh;
  int Efi;
  int Efj;
  private ao Efk;
  private View.OnClickListener Efl;
  private View.OnClickListener Efm;
  private View.OnClickListener Efn;
  private View.OnClickListener Efo;
  private Context context;
  private MMHandler hAk;
  private ProgressBar hRO;
  private boolean isAutoPlay;
  private View maskView;
  ImageView xdY;
  
  public y(final Context paramContext, am paramam, ViewGroup paramViewGroup)
  {
    super(paramContext, paramam, paramViewGroup);
    AppMethodBeat.i(96637);
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
        AppMethodBeat.i(96631);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(y.this.EeO.isPlaying()) });
        if (y.this.EeO.isPlaying())
        {
          y.this.cXa();
          y.this.Eff = 4;
          if (y.this.DXw)
          {
            paramAnonymousView = y.this;
            paramAnonymousView.Efi += 1;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96631);
          return;
        }
        if (y.this.EeY) {
          y.this.fcJ();
        }
        for (;;)
        {
          y.b(y.this);
          y.this.Eff = 3;
          break;
          y.this.fcL();
          y.this.fcK();
        }
      }
    };
    this.Efm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96632);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = y.this;
        paramAnonymousView.Efj += 1;
        if (y.this.EeY)
        {
          y.this.fcL();
          y.this.fcK();
        }
        for (;;)
        {
          y.this.EeV = true;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96632);
          return;
          y.this.fcJ();
        }
      }
    };
    this.Efn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96634);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        y.b(y.this);
        y.this.EeZ = false;
        y.this.EeW = true;
        y.this.Eff = 3;
        y.this.fcK();
        y.this.setFocus(true);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96633);
            if (y.this.EeX)
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
    this.Efo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96635);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!y.this.EeX)
        {
          y.this.EeX = true;
          y.this.setFocus(true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(96635);
      }
    };
    this.context = paramContext;
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.EeU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96625);
        y.this.setFocus(false);
        AppMethodBeat.o(96625);
      }
    };
    this.Efk = new ao()
    {
      public final void vg(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96628);
        Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
        if (paramAnonymousBoolean) {}
        for (int i = 1;; i = 0)
        {
          localIntent.putExtra("show", i);
          localIntent.putExtra("activity_code", y.this.fcM());
          d.W(paramContext).b(localIntent);
          AppMethodBeat.o(96628);
          return;
        }
      }
    };
    AppMethodBeat.o(96637);
  }
  
  private void czw()
  {
    AppMethodBeat.i(96639);
    Log.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "starting play");
    if (this.Efc)
    {
      Log.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "last download fail ,try again");
      this.EeO.c(false, ((am)this.EcX).DYS, 0);
      YX(0);
      this.EeO.fdQ();
      AppMethodBeat.o(96639);
      return;
    }
    this.hAk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96636);
        if (!y.this.EeO.isPlaying())
        {
          if (y.this.EeO.getCurrPosSec() != y.this.EeO.getVideoDurationSec()) {
            break label65;
          }
          y.this.YX(0);
        }
        for (;;)
        {
          y.this.EeO.fdQ();
          AppMethodBeat.o(96636);
          return;
          label65:
          y.this.YX(y.this.EeO.getCurrPosSec());
        }
      }
    });
    this.AhP = System.currentTimeMillis();
    this.Aiv += 1;
    AppMethodBeat.o(96639);
  }
  
  final void YX(int paramInt)
  {
    AppMethodBeat.i(96642);
    if (this.EeO != null)
    {
      this.EeS.setVisibility(8);
      if (this.xdY.getVisibility() == 0) {
        this.hRO.setVisibility(0);
      }
      this.EeO.c(paramInt, true);
    }
    AppMethodBeat.o(96642);
  }
  
  public final void aJq()
  {
    this.EeX = true;
  }
  
  public final boolean bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96649);
    if (!super.bp(paramJSONObject))
    {
      AppMethodBeat.o(96649);
      return false;
    }
    try
    {
      paramJSONObject.put("streamVideoDuraion", this.EeO.getVideoDurationSec() * 1000);
      paramJSONObject.put("playTimeInterval", this.Efg);
      paramJSONObject.put("playCount", this.Aiv);
      paramJSONObject.put("playCompletedCount", this.Efh);
      paramJSONObject.put("clickPlayControlCount", this.Efi);
      paramJSONObject.put("clickVoiceControlCount", this.Efj);
      if (this.isAutoPlay) {}
      for (String str = "1";; str = "0")
      {
        paramJSONObject.put("isAutoPlay", str);
        JSONObject localJSONObject;
        if (!this.Efd)
        {
          str = MD5Util.getMD5String(((am)this.EcX).Ead);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        if (!this.Efe)
        {
          str = MD5Util.getMD5String(((am)this.EcX).DYS);
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
      Log.printErrStackTrace("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96649);
    }
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96653);
    Log.e("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "online play error, %s", new Object[] { paramString3 });
    this.Efc = true;
    AppMethodBeat.o(96653);
  }
  
  final void cXa()
  {
    AppMethodBeat.i(96640);
    Log.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "pause play");
    this.hAk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96626);
        y.this.EeO.pause();
        AppMethodBeat.o(96626);
      }
    });
    if (this.AhP != 0L)
    {
      this.Efg = ((int)(this.Efg + (System.currentTimeMillis() - this.AhP)));
      this.AhP = 0L;
    }
    AppMethodBeat.o(96640);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dH(String paramString1, String paramString2)
  {
    this.Efc = false;
  }
  
  public final void dI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96651);
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
    AppMethodBeat.o(96651);
  }
  
  public final void dJ(String paramString1, String paramString2) {}
  
  public final void dK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96652);
    this.xdY.setVisibility(8);
    this.hRO.setVisibility(8);
    AppMethodBeat.o(96652);
  }
  
  public final void dL(String paramString1, String paramString2) {}
  
  public final void dM(String paramString1, String paramString2) {}
  
  protected final void eWT() {}
  
  public final void eWZ()
  {
    AppMethodBeat.i(96645);
    super.eWZ();
    AppMethodBeat.o(96645);
  }
  
  public final void eXa()
  {
    AppMethodBeat.i(96646);
    super.eXa();
    cXa();
    if ((!this.Efa) && (!this.Efb))
    {
      AppMethodBeat.o(96646);
      return;
    }
    this.Efb = false;
    this.Efa = false;
    if (this.Eff == 1) {
      this.Eff = 2;
    }
    AppMethodBeat.o(96646);
  }
  
  public final void eXb()
  {
    AppMethodBeat.i(96648);
    super.eXb();
    int i = fdl();
    int j = getView().getHeight();
    Log.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
      if ((this.Efa) && (!this.Efb))
      {
        AppMethodBeat.o(96648);
        return;
      }
      this.Efb = false;
      this.Efa = true;
      this.xdY.setVisibility(0);
      NetworkInfo localNetworkInfo = ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if ((!this.EeZ) || ((this.EeZ) && (localNetworkInfo != null) && (localNetworkInfo.getType() == 1)))
      {
        setFocus(true);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96627);
            if (y.this.EeX)
            {
              AppMethodBeat.o(96627);
              return;
            }
            y.this.setFocus(false);
            AppMethodBeat.o(96627);
          }
        }, 3000L);
      }
      if (this.EeZ)
      {
        if ((localNetworkInfo == null) || ((localNetworkInfo != null) && (localNetworkInfo.getType() != 1)))
        {
          this.EeS.setVisibility(0);
          this.isAutoPlay = false;
          this.EeZ = false;
          AppMethodBeat.o(96648);
          return;
        }
        this.isAutoPlay = true;
        this.EeZ = false;
      }
      if (this.Eff == 0) {
        if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1))
        {
          if (!this.EeY) {
            break label291;
          }
          fcJ();
          this.Eff = 1;
        }
      }
      for (;;)
      {
        czw();
        label291:
        do
        {
          AppMethodBeat.o(96648);
          return;
          fcK();
          break;
          if (this.Eff == 2)
          {
            if (this.EeY) {
              fcJ();
            }
            for (;;)
            {
              czw();
              this.Eff = 1;
              AppMethodBeat.o(96648);
              return;
              fcK();
            }
          }
        } while (this.Eff != 3);
        if (this.EeY) {
          fcJ();
        } else {
          fcK();
        }
      }
    }
    this.Efb = false;
    this.Efa = false;
    cXa();
    if (this.Eff == 1) {
      this.Eff = 2;
    }
    AppMethodBeat.o(96648);
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(96647);
    super.eXd();
    this.EeO.onUIDestroy();
    AppMethodBeat.o(96647);
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(96638);
    super.eXe();
    View localView = this.contentView.findViewById(2131299214);
    localView.setBackgroundColor(-16777216);
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
      localView.setPadding((int)((am)this.EcX).paddingLeft, (int)((am)this.EcX).paddingTop, (int)((am)this.EcX).paddingRight, (int)((am)this.EcX).paddingBottom);
    }
    localView.setLayoutParams(new RelativeLayout.LayoutParams(k, i));
    localView.setMinimumHeight(i);
    this.EeO = ((AdLandingVideoWrapper)localView.findViewById(2131309841));
    this.EeO.setIMMVideoViewCallback(this);
    this.EeO.setOnClickListener(this.Efo);
    this.EeO.c(false, ((am)this.EcX).DYS, 0);
    this.EeO.setIsShowBasicControls(true);
    this.hRO = ((ProgressBar)localView.findViewById(2131306302));
    this.xdY = ((ImageView)localView.findViewById(2131309073));
    Object localObject = h.kz("adId", ((am)this.EcX).Ead);
    if (!s.YS((String)localObject)) {
      this.Efd = false;
    }
    if (this.Efd)
    {
      this.xdY.setImageBitmap(BitmapUtil.decodeFile((String)localObject));
      this.EeT = ((TextView)localView.findViewById(2131300154));
      this.EeT.setText(this.context.getString(2131758370));
      this.maskView = localView.findViewById(2131308056);
      this.maskView.setVisibility(4);
      this.EeP = new VideoPlayerSeekBar(this.context);
      this.EeP.setVisibility(4);
      if (this.Efk != null)
      {
        localObject = this.Efk;
        if (this.EeP.getVisibility() != 0) {
          break label681;
        }
      }
    }
    label681:
    for (boolean bool = true;; bool = false)
    {
      ((ao)localObject).vg(bool);
      this.EeP.setIplaySeekCallback(this);
      this.EeP.setOnPlayButtonClickListener(this.Efl);
      localObject = new RelativeLayout.LayoutParams(k - com.tencent.mm.cb.a.fromDPToPix(this.context, 30), -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.EeP.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.EeO.setVideoFooterView(this.EeP);
      this.EeQ = ((ImageView)localView.findViewById(2131308058));
      this.EeQ.setVisibility(4);
      this.EeQ.setOnClickListener(this.Efm);
      this.EeQ.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.context, 8), 0);
      this.EeS = ((ImageView)localView.findViewById(2131308392));
      this.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691480));
      this.EeS.setVisibility(8);
      this.EeS.setOnClickListener(this.Efn);
      ((ViewGroup)this.EeP.getParent()).removeView(this.EeP);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
      ((ViewGroup)localView).addView(this.EeP, (ViewGroup.LayoutParams)localObject);
      this.EeO.setVideoPlayCallback(new AdLandingVideoWrapper.a()
      {
        public final void xv(int paramAnonymousInt)
        {
          AppMethodBeat.i(96630);
          if ((y.a(y.this).DYX != null) && (paramAnonymousInt * 1000 >= y.a(y.this).DYX.Eab) && (!y.this.EeR))
          {
            y.this.EeR = true;
            pb localpb = new pb();
            localpb.dVd.dVe = y.a(y.this).DYX.dVe;
            EventCenter.instance.publish(localpb);
          }
          AppMethodBeat.o(96630);
        }
      });
      AppMethodBeat.o(96638);
      return;
      h.a("adId", ((am)this.EcX).Ead, false, 1000000001, new f.a()
      {
        public final void aNH(String paramAnonymousString)
        {
          AppMethodBeat.i(96629);
          if (y.this.xdY.getVisibility() == 0) {
            y.this.xdY.setImageBitmap(BitmapUtil.decodeFile(paramAnonymousString));
          }
          AppMethodBeat.o(96629);
        }
        
        public final void eWN() {}
        
        public final void eWO() {}
      });
      break;
    }
  }
  
  public final void fcJ()
  {
    AppMethodBeat.i(96643);
    super.fcJ();
    this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131233294));
    this.EeO.setMute(true);
    this.EeY = true;
    AppMethodBeat.o(96643);
  }
  
  public final void fcK()
  {
    AppMethodBeat.i(96644);
    super.fcK();
    this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131233295));
    this.EeO.setMute(false);
    this.EeY = false;
    AppMethodBeat.o(96644);
  }
  
  public final void fdq()
  {
    AppMethodBeat.i(96654);
    super.fdq();
    cXa();
    String str = h.kz("adId", ((am)this.EcX).Ead);
    if (s.YS(str))
    {
      this.xdY.setImageBitmap(BitmapUtil.decodeFile(str));
      this.xdY.setVisibility(0);
    }
    AppMethodBeat.o(96654);
  }
  
  public final void fo(String paramString1, String paramString2) {}
  
  protected final int getLayout()
  {
    return 2131496390;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(202986);
    boolean bool = this.EeO.isPlaying();
    AppMethodBeat.o(202986);
    return bool;
  }
  
  public final void rk(int paramInt)
  {
    AppMethodBeat.i(96650);
    Log.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "onSeek time ".concat(String.valueOf(paramInt)));
    if (this.EeY) {
      fcJ();
    }
    for (;;)
    {
      YX(paramInt);
      AppMethodBeat.o(96650);
      return;
      fcL();
      fcK();
    }
  }
  
  final void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(96641);
    if (paramBoolean)
    {
      this.EeP.setVisibility(0);
      this.EeQ.setVisibility(0);
      this.maskView.setVisibility(0);
      if (this.Efk != null) {
        this.Efk.vg(true);
      }
      this.hAk.postDelayed(this.EeU, 5000L);
      AppMethodBeat.o(96641);
      return;
    }
    this.EeX = false;
    this.EeP.setVisibility(4);
    this.EeQ.setVisibility(8);
    this.maskView.setVisibility(4);
    if (this.Efk != null) {
      this.Efk.vg(false);
    }
    this.hAk.removeCallbacks(this.EeU);
    AppMethodBeat.o(96641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y
 * JD-Core Version:    0.7.0.1
 */