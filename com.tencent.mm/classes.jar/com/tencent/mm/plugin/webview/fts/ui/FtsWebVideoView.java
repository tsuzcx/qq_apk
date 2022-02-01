package com.tencent.mm.plugin.webview.fts.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.ui.WebSearchDotPercentIndicator;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar.2;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar.a;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.c;
import com.tencent.mm.plugin.webview.fts.c.d;
import com.tencent.mm.plugin.webview.fts.c.d.1;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public class FtsWebVideoView
  extends RelativeLayout
{
  private ImageView Aci;
  private ImageView Cat;
  private TextView CiA;
  private boolean CiB;
  private a CiC;
  private a CiD;
  private d CiE;
  private b.a CiF;
  private int CiG;
  private boolean CiH;
  private long CiI;
  private View CiJ;
  private View CiK;
  private FtsWebVideoView.c CiL;
  public BroadcastReceiver CiM;
  private FtsWebVideoView.b Cir;
  public FtsVideoWrapper Cis;
  public WebSearchWebVideoViewControlBar Cit;
  private View Ciu;
  private View Civ;
  private WebSearchDotPercentIndicator Ciw;
  private View Cix;
  private Button Ciy;
  private TextView Ciz;
  private boolean chR;
  public boolean ftN;
  private boolean isLoading;
  private boolean kOA;
  private boolean kOB;
  private String kOD;
  private TextView kOd;
  private LinearLayout kOj;
  private TextView kOl;
  private ImageView kOm;
  private ImageView kOn;
  private String kOr;
  private int kOs;
  private boolean kOu;
  private boolean kOw;
  private String mAppId;
  private int nRp;
  private String url;
  
  public FtsWebVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(78077);
    this.Cir = FtsWebVideoView.b.CiO;
    this.CiL = FtsWebVideoView.c.CiS;
    this.CiM = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(78048);
        if (FtsWebVideoView.d(FtsWebVideoView.this).isPlaying()) {
          FtsWebVideoView.a(FtsWebVideoView.this, paramAnonymousContext);
        }
        AppMethodBeat.o(78048);
      }
    };
    init(paramContext);
    AppMethodBeat.o(78077);
  }
  
  public FtsWebVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(78078);
    this.Cir = FtsWebVideoView.b.CiO;
    this.CiL = FtsWebVideoView.c.CiS;
    this.CiM = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(78048);
        if (FtsWebVideoView.d(FtsWebVideoView.this).isPlaying()) {
          FtsWebVideoView.a(FtsWebVideoView.this, paramAnonymousContext);
        }
        AppMethodBeat.o(78048);
      }
    };
    init(paramContext);
    AppMethodBeat.o(78078);
  }
  
  public FtsWebVideoView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(78076);
    this.Cir = FtsWebVideoView.b.CiO;
    this.CiL = FtsWebVideoView.c.CiS;
    this.CiM = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(78048);
        if (FtsWebVideoView.d(FtsWebVideoView.this).isPlaying()) {
          FtsWebVideoView.a(FtsWebVideoView.this, paramAnonymousContext);
        }
        AppMethodBeat.o(78048);
      }
    };
    setAutoPlay(paramBoolean);
    init(paramContext);
    AppMethodBeat.o(78076);
  }
  
  private boolean bed()
  {
    AppMethodBeat.i(78116);
    ac.i("MicroMsg.FtsWebVideoView", "isLive %b %b", new Object[] { Boolean.valueOf(this.kOA), Boolean.valueOf(this.Cis.bed()) });
    if ((this.kOA) || (this.Cis.bed()))
    {
      AppMethodBeat.o(78116);
      return true;
    }
    AppMethodBeat.o(78116);
    return false;
  }
  
  private void biY()
  {
    AppMethodBeat.i(78106);
    this.CiC = new a(getContext(), this, new a.b()
    {
      public final void aA(float paramAnonymousFloat)
      {
        AppMethodBeat.i(78058);
        ac.d("MicroMsg.FtsWebVideoView", "onAdjustBrightness:".concat(String.valueOf(paramAnonymousFloat)));
        FtsWebVideoView.j(FtsWebVideoView.this).setPercent(paramAnonymousFloat);
        FtsWebVideoView.k(FtsWebVideoView.this).setText(2131759739);
        FtsWebVideoView.l(FtsWebVideoView.this).setImageResource(2131690267);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(0);
        AppMethodBeat.o(78058);
      }
      
      public final void az(float paramAnonymousFloat)
      {
        AppMethodBeat.i(78057);
        ac.d("MicroMsg.FtsWebVideoView", "onAdjustVolume:".concat(String.valueOf(paramAnonymousFloat)));
        FtsWebVideoView.j(FtsWebVideoView.this).setPercent(paramAnonymousFloat);
        FtsWebVideoView.k(FtsWebVideoView.this).setText(2131759742);
        FtsWebVideoView.l(FtsWebVideoView.this).setImageResource(2131690275);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(0);
        AppMethodBeat.o(78057);
      }
      
      public final void bjj()
      {
        AppMethodBeat.i(78050);
        ac.d("MicroMsg.FtsWebVideoView", "onSingleTap");
        if (FtsWebVideoView.e(FtsWebVideoView.this)) {
          FtsWebVideoView.c(FtsWebVideoView.this).ue(FtsWebVideoView.f(FtsWebVideoView.this));
        }
        AppMethodBeat.o(78050);
      }
      
      public final void bjk()
      {
        AppMethodBeat.i(78051);
        ac.d("MicroMsg.FtsWebVideoView", "onDoubleTap");
        AppMethodBeat.o(78051);
      }
      
      public final void bjl()
      {
        AppMethodBeat.i(78052);
        if (FtsWebVideoView.d(FtsWebVideoView.this).bed())
        {
          ac.i("MicroMsg.FtsWebVideoView", "onStartDragProgress isLive: no seek");
          AppMethodBeat.o(78052);
          return;
        }
        FtsWebVideoView.g(FtsWebVideoView.this).setVisibility(0);
        FtsWebVideoView.c(FtsWebVideoView.this).eet();
        AppMethodBeat.o(78052);
      }
      
      public final void bjm()
      {
        AppMethodBeat.i(78059);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(8);
        AppMethodBeat.o(78059);
      }
      
      public final void bjn()
      {
        AppMethodBeat.i(78060);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(8);
        AppMethodBeat.o(78060);
      }
      
      public final boolean edy()
      {
        AppMethodBeat.i(78055);
        if (FtsWebVideoView.i(FtsWebVideoView.this))
        {
          AppMethodBeat.o(78055);
          return false;
        }
        AppMethodBeat.o(78055);
        return true;
      }
      
      public final int getCurrentPosition()
      {
        AppMethodBeat.i(78056);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getCurrPosSec();
        AppMethodBeat.o(78056);
        return i;
      }
      
      public final int j(int paramAnonymousInt, float paramAnonymousFloat)
      {
        int j = 0;
        AppMethodBeat.i(78053);
        if (FtsWebVideoView.d(FtsWebVideoView.this).bed())
        {
          ac.i("MicroMsg.FtsWebVideoView", "onDragProgress isLive: no seek");
          AppMethodBeat.o(78053);
          return 0;
        }
        ac.i("MicroMsg.FtsWebVideoView", "onDragProgress:" + paramAnonymousInt + "/" + paramAnonymousFloat);
        paramAnonymousFloat /= FtsWebVideoView.this.getMeasuredWidth();
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getVideoDurationSec();
        paramAnonymousInt = getCurrentPosition();
        paramAnonymousInt = (int)(paramAnonymousFloat * i) + paramAnonymousInt;
        if (paramAnonymousInt < 0) {
          paramAnonymousInt = j;
        }
        for (;;)
        {
          String str = c.qn(i * 1000L);
          FtsWebVideoView.g(FtsWebVideoView.this).setText(c.qn(paramAnonymousInt * 1000L) + "/" + str);
          AppMethodBeat.o(78053);
          return paramAnonymousInt;
          if (paramAnonymousInt > i) {
            paramAnonymousInt = i;
          }
        }
      }
      
      public final void k(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(78054);
        FtsWebVideoView.c(FtsWebVideoView.this).eeu();
        FtsWebVideoView.g(FtsWebVideoView.this).setVisibility(8);
        ac.i("MicroMsg.FtsWebVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(FtsWebVideoView.d(FtsWebVideoView.this).getCurrPosSec()), Float.valueOf(paramAnonymousFloat) });
        if (FtsWebVideoView.d(FtsWebVideoView.this).bed())
        {
          ac.i("MicroMsg.FtsWebVideoView", "onEndDragProgress isLive: no seek");
          AppMethodBeat.o(78054);
          return;
        }
        FtsWebVideoView.this.U(paramAnonymousInt, false);
        FtsWebVideoView.c(FtsWebVideoView.this).eeu();
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null) {
          FtsWebVideoView.h(FtsWebVideoView.this).ezD();
        }
        AppMethodBeat.o(78054);
      }
    });
    AppMethodBeat.o(78106);
  }
  
  private void bja()
  {
    AppMethodBeat.i(78107);
    this.Cis.setIMMVideoViewCallback(new h.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(78061);
        ac.i("MicroMsg.FtsWebVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        h.wUl.f(14911, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), FtsWebVideoView.n(FtsWebVideoView.this), ax.iH(FtsWebVideoView.this.getContext()) });
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          ac.e("MicroMsg.JsApiVideoCallback", "onError what %d, extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          paramAnonymousString1.clean();
        }
        try
        {
          paramAnonymousString2 = new JSONObject();
          paramAnonymousString2.put("errCode", paramAnonymousInt1);
          paramAnonymousString2.put("errMsg", String.valueOf(paramAnonymousInt2));
          paramAnonymousString1.bq(paramAnonymousString1.a(7, paramAnonymousString2));
          FtsWebVideoView.this.pause();
          FtsWebVideoView.a(FtsWebVideoView.this, FtsWebVideoView.this.getContext().getString(2131764672, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), FtsWebVideoView.this.getContext().getString(2131764699));
          AppMethodBeat.o(78061);
          return;
        }
        catch (JSONException paramAnonymousString1)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
        }
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(78064);
        ac.i("MicroMsg.FtsWebVideoView", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (FtsWebVideoView.s(FtsWebVideoView.this) == FtsWebVideoView.b.CiO)
        {
          paramAnonymousString2 = FtsWebVideoView.this;
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label92;
          }
        }
        label92:
        for (paramAnonymousString1 = FtsWebVideoView.b.CiQ;; paramAnonymousString1 = FtsWebVideoView.b.CiP)
        {
          FtsWebVideoView.a(paramAnonymousString2, paramAnonymousString1);
          ac.i("MicroMsg.FtsWebVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { FtsWebVideoView.s(FtsWebVideoView.this) });
          AppMethodBeat.o(78064);
          return;
        }
      }
      
      public final void jdMethod_do(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78062);
        ac.i("MicroMsg.FtsWebVideoView", "onPrepared");
        paramAnonymousString1 = FtsWebVideoView.o(FtsWebVideoView.this);
        paramAnonymousString1.kVr = -1;
        paramAnonymousString1.kVs = 0;
        paramAnonymousString1.kVq = 0.0F;
        FtsWebVideoView.c(FtsWebVideoView.this).ue(FtsWebVideoView.f(FtsWebVideoView.this));
        AppMethodBeat.o(78062);
      }
      
      public final void dp(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78063);
        ac.i("MicroMsg.FtsWebVideoView", "onVideoEnded");
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          ac.d("MicroMsg.JsApiVideoCallback", "onVideoEnded %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.bky();
        }
        try
        {
          paramAnonymousString1.bq(paramAnonymousString1.a(3, null));
          if (FtsWebVideoView.p(FtsWebVideoView.this))
          {
            FtsWebVideoView.this.U(0, true);
            AppMethodBeat.o(78063);
            return;
          }
        }
        catch (JSONException paramAnonymousString1)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
          FtsWebVideoView.this.U(0, false);
          FtsWebVideoView.this.pause();
          FtsWebVideoView.q(FtsWebVideoView.this);
          FtsWebVideoView.r(FtsWebVideoView.this).setImageResource(2131232470);
          FtsWebVideoView.c(FtsWebVideoView.this).setVisibility(8);
          AppMethodBeat.o(78063);
        }
      }
      
      public final void dq(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78065);
        ac.i("MicroMsg.FtsWebVideoView", "onVideoPause");
        if ((FtsWebVideoView.h(FtsWebVideoView.this) != null) && (FtsWebVideoView.h(FtsWebVideoView.this) != null))
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          ac.d("MicroMsg.JsApiVideoCallback", "onVideoPause %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.bky();
          try
          {
            paramAnonymousString1.bq(paramAnonymousString1.a(2, null));
            AppMethodBeat.o(78065);
            return;
          }
          catch (JSONException paramAnonymousString1)
          {
            ac.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
        }
        AppMethodBeat.o(78065);
      }
      
      public final void dr(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78066);
        ac.i("MicroMsg.FtsWebVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(FtsWebVideoView.t(FtsWebVideoView.this)) });
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          ac.d("MicroMsg.JsApiVideoCallback", "onVideoPlay %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.kTl = 0;
          if (paramAnonymousString1.kTk == null) {
            paramAnonymousString1.kTk = new au(new d.1(paramAnonymousString1), true);
          }
          paramAnonymousString1.kTk.au(250L, 250L);
        }
        try
        {
          paramAnonymousString1.bq(paramAnonymousString1.a(1, null));
          if ((FtsWebVideoView.u(FtsWebVideoView.this) > 0L) && (FtsWebVideoView.u(FtsWebVideoView.this) != 9223372036854775807L))
          {
            long l = System.currentTimeMillis() - FtsWebVideoView.u(FtsWebVideoView.this);
            h.wUl.f(14909, new Object[] { Long.valueOf(l), Long.valueOf(System.currentTimeMillis()), Long.valueOf(l), ax.iH(FtsWebVideoView.this.getContext()), FtsWebVideoView.n(FtsWebVideoView.this) });
          }
          AppMethodBeat.o(78066);
          return;
        }
        catch (JSONException paramAnonymousString1)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
        }
      }
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78067);
        ac.i("MicroMsg.FtsWebVideoView", "onVideoWaiting");
        FtsWebVideoView.c(FtsWebVideoView.this).eet();
        FtsWebVideoView.a(FtsWebVideoView.this, true);
        AppMethodBeat.o(78067);
      }
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78068);
        ac.i("MicroMsg.FtsWebVideoView", "onVideoWaitingEnd");
        FtsWebVideoView.a(FtsWebVideoView.this, false);
        FtsWebVideoView.c(FtsWebVideoView.this).eeu();
        FtsWebVideoView.c(FtsWebVideoView.this).bjC();
        AppMethodBeat.o(78068);
      }
      
      public final void eJ(String paramAnonymousString1, String paramAnonymousString2) {}
    });
    AppMethodBeat.o(78107);
  }
  
  private void ezv()
  {
    AppMethodBeat.i(78084);
    if (bjb())
    {
      this.Cat.setVisibility(0);
      AppMethodBeat.o(78084);
      return;
    }
    this.Cat.setVisibility(8);
    AppMethodBeat.o(78084);
  }
  
  private void ezw()
  {
    AppMethodBeat.i(78090);
    this.Ciu.setVisibility(8);
    AppMethodBeat.o(78090);
  }
  
  private boolean ezx()
  {
    AppMethodBeat.i(78110);
    if ((this.kOu) && (!ezy()))
    {
      AppMethodBeat.o(78110);
      return true;
    }
    AppMethodBeat.o(78110);
    return false;
  }
  
  private boolean ezy()
  {
    AppMethodBeat.i(78111);
    if (this.Ciu.getVisibility() == 0)
    {
      AppMethodBeat.o(78111);
      return true;
    }
    AppMethodBeat.o(78111);
    return false;
  }
  
  private void ezz()
  {
    AppMethodBeat.i(78114);
    this.Cit = new WebSearchWebVideoViewControlBar(getContext());
    this.Cit.setVisibility(8);
    this.Cit.setEnterFullScreenBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78069);
        if (!FtsWebVideoView.this.bjb()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.ug(bool);
          AppMethodBeat.o(78069);
          return;
        }
      }
    });
    this.Cit.setExitFullScreenBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78037);
        if (!FtsWebVideoView.this.bjb()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.ug(bool);
          AppMethodBeat.o(78037);
          return;
        }
      }
    });
    this.Cit.setMuteBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78038);
        FtsWebVideoView.v(FtsWebVideoView.this);
        FtsWebVideoView.c(FtsWebVideoView.this).bjC();
        AppMethodBeat.o(78038);
      }
    });
    this.Cit.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void anR()
      {
        AppMethodBeat.i(78039);
        ac.i("MicroMsg.FtsWebVideoView", "onSeekPre");
        FtsWebVideoView.c(FtsWebVideoView.this).bOg();
        AppMethodBeat.o(78039);
      }
      
      public final void nn(int paramAnonymousInt)
      {
        AppMethodBeat.i(78040);
        ac.i("MicroMsg.FtsWebVideoView", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        FtsWebVideoView.this.U(paramAnonymousInt, false);
        FtsWebVideoView.c(FtsWebVideoView.this).bjC();
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null) {
          FtsWebVideoView.h(FtsWebVideoView.this).ezD();
        }
        AppMethodBeat.o(78040);
      }
    });
    this.Cit.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78041);
        if (FtsWebVideoView.d(FtsWebVideoView.this).isPlaying())
        {
          FtsWebVideoView.c(FtsWebVideoView.this).bOg();
          FtsWebVideoView.this.pause();
          AppMethodBeat.o(78041);
          return;
        }
        FtsWebVideoView.c(FtsWebVideoView.this).bjC();
        FtsWebVideoView.this.start(true);
        AppMethodBeat.o(78041);
      }
    });
    this.Cit.setStatePorter(new WebSearchWebVideoViewControlBar.a()
    {
      public final int bjh()
      {
        AppMethodBeat.i(78042);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getCacheTimeSec();
        AppMethodBeat.o(78042);
        return i;
      }
      
      public final int bji()
      {
        AppMethodBeat.i(78043);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getVideoDurationSec();
        AppMethodBeat.o(78043);
        return i;
      }
      
      public final int exQ()
      {
        AppMethodBeat.i(78044);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getCurrPosMs();
        AppMethodBeat.o(78044);
        return i;
      }
    });
    this.Cis.setVideoFooterView(this.Cit);
    AppMethodBeat.o(78114);
  }
  
  private boolean gM(final Context paramContext)
  {
    AppMethodBeat.i(78080);
    Object localObject = this.CiL;
    if (ax.isConnected(paramContext))
    {
      if ((!this.CiH) && (!ax.isWifi(paramContext)))
      {
        pause();
        this.CiL = FtsWebVideoView.c.CiT;
        this.Cit.setVisibility(8);
        localObject = getNetUnavailableTip();
        String str = paramContext.getString(2131764669);
        paramContext.getString(2131764666);
        kp((String)localObject, str);
        AppMethodBeat.o(78080);
        return false;
      }
    }
    else
    {
      if (localObject == FtsWebVideoView.c.CiU)
      {
        this.CiJ.setVisibility(0);
        this.CiK.setVisibility(8);
        this.Ciu.setVisibility(0);
        postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(78049);
            FtsWebVideoView.b(FtsWebVideoView.this, paramContext);
            AppMethodBeat.o(78049);
          }
        }, 200L);
      }
      for (;;)
      {
        AppMethodBeat.o(78080);
        return false;
        gN(paramContext);
      }
    }
    AppMethodBeat.o(78080);
    return true;
  }
  
  private void gN(Context paramContext)
  {
    AppMethodBeat.i(78081);
    this.CiL = FtsWebVideoView.c.CiU;
    pause();
    kp(paramContext.getString(2131764685), paramContext.getString(2131764699));
    AppMethodBeat.o(78081);
  }
  
  private String getNetUnavailableTip()
  {
    AppMethodBeat.i(78082);
    Object localObject;
    if (this.CiG == 0)
    {
      localObject = getContext().getString(2131764687);
      AppMethodBeat.o(78082);
      return localObject;
    }
    Context localContext = getContext();
    long l = this.CiG;
    if (l < 0L) {
      localObject = "";
    }
    for (;;)
    {
      localObject = localContext.getString(2131764686, new Object[] { localObject });
      AppMethodBeat.o(78082);
      return localObject;
      localObject = new BigDecimal(l);
      float f = ((BigDecimal)localObject).divide(new BigDecimal(1048576), 2, 0).floatValue();
      if (f > 1.0F)
      {
        localObject = (int)f + "M";
      }
      else
      {
        f = ((BigDecimal)localObject).divide(new BigDecimal(1024), 2, 0).floatValue();
        localObject = (int)f + "K";
      }
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(78079);
    LayoutInflater.from(paramContext).inflate(2131494226, this);
    this.Cis = ((FtsVideoWrapper)findViewById(2131306410));
    this.kOd = ((TextView)findViewById(2131303515));
    this.Ciu = findViewById(2131305866);
    this.Civ = findViewById(2131305891);
    this.kOj = ((LinearLayout)findViewById(2131296505));
    this.Ciw = ((WebSearchDotPercentIndicator)findViewById(2131296506));
    this.kOl = ((TextView)findViewById(2131296502));
    this.kOm = ((ImageView)findViewById(2131296504));
    this.kOn = ((ImageView)findViewById(2131298813));
    this.CiJ = findViewById(2131306352);
    this.CiK = findViewById(2131305892);
    this.Ciw.setDotsNum(8);
    this.Aci = ((ImageView)findViewById(2131298815));
    this.Cix = findViewById(2131298829);
    this.Ciz = ((TextView)findViewById(2131305867));
    this.Ciy = ((Button)findViewById(2131305868));
    this.CiA = ((TextView)findViewById(2131305870));
    this.Cat = ((ImageView)findViewById(2131299599));
    this.Ciz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78036);
        FtsWebVideoView.this.pause();
        AppMethodBeat.o(78036);
      }
    });
    this.Cat.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78045);
        if (!FtsWebVideoView.this.bjb()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.ug(bool);
          AppMethodBeat.o(78045);
          return;
        }
      }
    });
    this.Ciy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78046);
        if (FtsWebVideoView.a(FtsWebVideoView.this) == FtsWebVideoView.c.CiT) {
          FtsWebVideoView.b(FtsWebVideoView.this);
        }
        FtsWebVideoView.this.start(true);
        AppMethodBeat.o(78046);
      }
    });
    this.Cix.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78047);
        FtsWebVideoView.this.start(true);
        FtsWebVideoView.c(FtsWebVideoView.this).bjC();
        AppMethodBeat.o(78047);
      }
    });
    biY();
    bja();
    ezz();
    paramContext.registerReceiver(this.CiM, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    ezw();
    AppMethodBeat.o(78079);
  }
  
  private void kp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78083);
    ezw();
    this.CiJ.setVisibility(8);
    this.CiK.setVisibility(0);
    this.Cit.setVisibility(8);
    this.Ciu.setVisibility(0);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.CiA.setText(paramString1);
      this.CiA.setVisibility(0);
      if (TextUtils.isEmpty(paramString2)) {
        break label139;
      }
      this.Ciy.setText(paramString2);
      this.Ciy.setVisibility(0);
    }
    for (;;)
    {
      this.Civ.setVisibility(0);
      this.Cix.setVisibility(8);
      this.Ciz.setVisibility(8);
      ezv();
      AppMethodBeat.o(78083);
      return;
      this.CiA.setVisibility(8);
      break;
      label139:
      this.Ciy.setVisibility(8);
    }
  }
  
  private void setCover(String paramString)
  {
    AppMethodBeat.i(78097);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78097);
      return;
    }
    if (!bs.isNullOrNil(this.kOD))
    {
      ac.i("MicroMsg.FtsWebVideoView", "setCover mCoverUrl not null");
      AppMethodBeat.o(78097);
      return;
    }
    AppMethodBeat.o(78097);
  }
  
  public final void U(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(78094);
    ac.i("MicroMsg.FtsWebVideoView", "seek to position=%d current=%d isLive=%b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Cis.getCurrPosSec()), Boolean.valueOf(this.kOA) });
    if (bed())
    {
      AppMethodBeat.o(78094);
      return;
    }
    if (paramBoolean)
    {
      this.Cis.c(paramInt, paramBoolean);
      AppMethodBeat.o(78094);
      return;
    }
    this.Cis.o(paramInt);
    AppMethodBeat.o(78094);
  }
  
  public final boolean bjb()
  {
    AppMethodBeat.i(78113);
    if (this.CiD == null)
    {
      ac.w("MicroMsg.FtsWebVideoView", "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(78113);
      return false;
    }
    boolean bool = this.CiD.isFullScreen();
    AppMethodBeat.o(78113);
    return bool;
  }
  
  public final void cA(String paramString, int paramInt)
  {
    AppMethodBeat.i(78093);
    ac.i("MicroMsg.FtsWebVideoView", "setVideoPath path=%s isLive=%s", new Object[] { paramString, Boolean.FALSE });
    this.url = paramString;
    if (bs.isNullOrNil(paramString))
    {
      ac.v("MicroMsg.FtsWebVideoView", "setVideoPath videoPath empty");
      AppMethodBeat.o(78093);
      return;
    }
    stop();
    this.kOA = false;
    this.Cis.c(false, paramString, paramInt);
    if (this.Cit != null) {
      this.Cit.setVideoTotalTime(paramInt);
    }
    if (this.nRp > 0) {
      this.Cis.o(this.nRp);
    }
    if (this.chR)
    {
      ac.i("MicroMsg.FtsWebVideoView", "setVideoPath autoPlay");
      start(false);
    }
    if (paramString.startsWith("wxfile://")) {
      setCover(paramString);
    }
    AppMethodBeat.o(78093);
  }
  
  public final void gJ(boolean paramBoolean)
  {
    AppMethodBeat.i(78115);
    if (this.CiE == null)
    {
      AppMethodBeat.o(78115);
      return;
    }
    if (this.Cir == FtsWebVideoView.b.CiQ) {}
    for (String str = "vertical";; str = "horizontal")
    {
      this.CiE.d(this.kOs, paramBoolean, str);
      ezv();
      AppMethodBeat.o(78115);
      return;
    }
  }
  
  public d getCallback()
  {
    return this.CiE;
  }
  
  public String getCookieData()
  {
    return this.kOr;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(78101);
    int i = this.Cis.getCurrPosMs();
    AppMethodBeat.o(78101);
    return i;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(78100);
    int i = this.Cis.getCurrPosSec();
    AppMethodBeat.o(78100);
    return i;
  }
  
  public int getSystemVolume()
  {
    AppMethodBeat.i(78109);
    int i = ((AudioManager)getContext().getSystemService("audio")).getStreamVolume(3);
    AppMethodBeat.o(78109);
    return i;
  }
  
  public b.a getUiLifecycleListener()
  {
    return this.CiF;
  }
  
  public int getVideoSizeByte()
  {
    return this.CiG;
  }
  
  public int getmVideoPlayerId()
  {
    return this.kOs;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78108);
    if ((this.kOw) || (bjb()))
    {
      a locala;
      if (this.CiC != null)
      {
        locala = this.CiC;
        if (locala.Cik.edy())
        {
          int i = paramMotionEvent.getActionMasked();
          if (i == 0)
          {
            locala.kVq = paramMotionEvent.getRawX();
            locala.KO = ((AudioManager)locala.mContext.getSystemService("audio")).getStreamVolume(3);
            locala.kNg = c.dy(locala.mContext);
          }
          locala.kVo.onTouchEvent(paramMotionEvent);
          if ((i != 1) && (i != 3)) {
            break label182;
          }
          if (locala.Cij != a.a.Cip) {
            break label190;
          }
          locala.Cik.k(locala.kVs, paramMotionEvent.getRawX() - locala.kVq);
          locala.kVr = -1;
          locala.kVs = 0;
          locala.kVq = 0.0F;
        }
      }
      for (;;)
      {
        locala.Cij = a.a.Cim;
        label182:
        AppMethodBeat.o(78108);
        return true;
        label190:
        if (locala.Cij == a.a.Cin)
        {
          ((AudioManager)locala.mContext.getSystemService("audio")).getStreamMaxVolume(3);
          locala.Cik.bjm();
        }
        else if (locala.Cij == a.a.Cio)
        {
          locala.Cik.bjn();
        }
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (ezx())) {
      this.Cit.ue(this.isLoading);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(78108);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(78091);
    ac.i("MicroMsg.FtsWebVideoView", "pause");
    ezw();
    if (!this.Cis.isPlaying())
    {
      AppMethodBeat.o(78091);
      return;
    }
    this.Cis.pause();
    AppMethodBeat.o(78091);
  }
  
  public void setAllowMobileNetPlay(boolean paramBoolean)
  {
    this.CiH = paramBoolean;
  }
  
  public void setAppId(String paramString)
  {
    AppMethodBeat.i(78085);
    ac.i("MicroMsg.FtsWebVideoView", "setAppId appid=%s", new Object[] { paramString });
    this.mAppId = paramString;
    AppMethodBeat.o(78085);
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(78086);
    ac.i("MicroMsg.FtsWebVideoView", "setAutoPlay =%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.chR = paramBoolean;
    AppMethodBeat.o(78086);
  }
  
  public void setCallback(d paramd)
  {
    this.CiE = paramd;
  }
  
  public void setCookieData(String paramString)
  {
    this.kOr = paramString;
  }
  
  public final void setCover$16da05f7(String paramString)
  {
    AppMethodBeat.i(78096);
    ac.i("MicroMsg.FtsWebVideoView", "setCover coverUrl=%s", new Object[] { paramString });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78096);
      return;
    }
    this.kOD = paramString;
    com.tencent.mm.modelappbrand.a.b.aAS().a(this.kOn, paramString, null, null);
    AppMethodBeat.o(78096);
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(78103);
    ac.i("MicroMsg.FtsWebVideoView", "setDisableScroll isDisableScroll=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.CiB = paramBoolean;
    AppMethodBeat.o(78103);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(78087);
    if (paramInt <= 0)
    {
      ac.i("MicroMsg.FtsWebVideoView", "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(78087);
      return;
    }
    AppMethodBeat.o(78087);
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.CiD = parama;
  }
  
  public void setFullScreenDirection(String paramString)
  {
    AppMethodBeat.i(78102);
    ac.i("MicroMsg.FtsWebVideoView", "setFullScreenDirection %s", new Object[] { paramString });
    if ("horizontal".equalsIgnoreCase(paramString))
    {
      this.Cir = FtsWebVideoView.b.CiP;
      AppMethodBeat.o(78102);
      return;
    }
    if ("vertical".equalsIgnoreCase(paramString))
    {
      this.Cir = FtsWebVideoView.b.CiQ;
      AppMethodBeat.o(78102);
      return;
    }
    this.Cir = FtsWebVideoView.b.CiO;
    AppMethodBeat.o(78102);
  }
  
  public void setInitialTime(int paramInt)
  {
    AppMethodBeat.i(78105);
    ac.i("MicroMsg.FtsWebVideoView", "setInitialTime initialTime=%d", new Object[] { Integer.valueOf(paramInt) });
    this.nRp = paramInt;
    AppMethodBeat.o(78105);
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(78095);
    ac.i("MicroMsg.FtsWebVideoView", "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOu = paramBoolean;
    AppMethodBeat.o(78095);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(78088);
    ac.i("MicroMsg.FtsWebVideoView", "setLoop loop=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOB = paramBoolean;
    AppMethodBeat.o(78088);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(78099);
    ac.i("MicroMsg.FtsWebVideoView", "setMute isMute=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ftN = paramBoolean;
    this.Cis.setMute(paramBoolean);
    if (paramBoolean)
    {
      this.Cit.aas();
      AppMethodBeat.o(78099);
      return;
    }
    this.Cit.exP();
    AppMethodBeat.o(78099);
  }
  
  public void setObjectFit(String paramString)
  {
    AppMethodBeat.i(78098);
    ac.i("MicroMsg.FtsWebVideoView", "setObjectFit objectFit=%s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.Cis.setScaleType(h.e.DnI);
      this.kOn.setScaleType(ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(78098);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.Cis.setScaleType(h.e.DnK);
      this.kOn.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(78098);
      return;
    }
    this.Cis.setScaleType(h.e.DnJ);
    this.kOn.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(78098);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(78104);
    ac.i("MicroMsg.FtsWebVideoView", "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOw = paramBoolean;
    AppMethodBeat.o(78104);
  }
  
  public void setUiLifecycleListener(b.a parama)
  {
    this.CiF = parama;
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.kOs = paramInt;
  }
  
  public void setVideoSizeByte(int paramInt)
  {
    this.CiG = paramInt;
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(78089);
    ac.i("MicroMsg.FtsWebVideoView", "start");
    ezw();
    if ((paramBoolean) && (!gM(getContext())))
    {
      ac.i("MicroMsg.FtsWebVideoView", "start network is not wifi");
      AppMethodBeat.o(78089);
      return;
    }
    this.CiL = FtsWebVideoView.c.CiS;
    if (this.Cis.isPlaying())
    {
      AppMethodBeat.o(78089);
      return;
    }
    if (this.kOu)
    {
      WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.Cit;
      if (localWebSearchWebVideoViewControlBar.kOQ == null) {
        localWebSearchWebVideoViewControlBar.kOQ = new au(new WebSearchWebVideoViewControlBar.2(localWebSearchWebVideoViewControlBar), true);
      }
      localWebSearchWebVideoViewControlBar.bkW();
      localWebSearchWebVideoViewControlBar.kOQ.stopTimer();
      localWebSearchWebVideoViewControlBar.kOQ.au(500L, 500L);
    }
    this.Cis.start();
    if (this.CiI == 0L)
    {
      this.CiI = System.currentTimeMillis();
      AppMethodBeat.o(78089);
      return;
    }
    this.CiI = 9223372036854775807L;
    AppMethodBeat.o(78089);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(78092);
    ac.i("MicroMsg.FtsWebVideoView", "stop");
    if (!this.Cis.isPlaying())
    {
      AppMethodBeat.o(78092);
      return;
    }
    this.Cis.stop();
    WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.Cit;
    if (localWebSearchWebVideoViewControlBar.kOQ != null) {
      localWebSearchWebVideoViewControlBar.kOQ.stopTimer();
    }
    AppMethodBeat.o(78092);
  }
  
  public final void ug(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(78112);
    ac.i("MicroMsg.FtsWebVideoView", "operateFullScreen toFullScreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.CiD == null)
    {
      ac.w("MicroMsg.FtsWebVideoView", "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(78112);
      return;
    }
    if (paramBoolean == bjb())
    {
      ac.i("MicroMsg.FtsWebVideoView", "operateFullScreen current same");
      AppMethodBeat.o(78112);
      return;
    }
    if (paramBoolean)
    {
      Object localObject = this.CiD;
      paramBoolean = bool;
      if (this.Cir != FtsWebVideoView.b.CiQ) {
        paramBoolean = true;
      }
      ((a)localObject).uh(paramBoolean);
      localObject = this.Cit;
      ((WebSearchWebVideoViewControlBar)localObject).kUU = true;
      ((WebSearchWebVideoViewControlBar)localObject).bkS();
      gJ(true);
      AppMethodBeat.o(78112);
      return;
    }
    this.CiD.bha();
    this.Cit.bha();
    AppMethodBeat.o(78112);
  }
  
  public static abstract interface a
  {
    public abstract void bha();
    
    public abstract boolean isFullScreen();
    
    public abstract void uh(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView
 * JD-Core Version:    0.7.0.1
 */