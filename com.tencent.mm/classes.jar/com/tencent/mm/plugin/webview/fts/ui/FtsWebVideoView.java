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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public class FtsWebVideoView
  extends RelativeLayout
{
  private ImageView AIc;
  private FtsWebVideoView.b AQe;
  public FtsVideoWrapper AQf;
  public WebSearchWebVideoViewControlBar AQg;
  private View AQh;
  private View AQi;
  private WebSearchDotPercentIndicator AQj;
  private View AQk;
  private Button AQl;
  private TextView AQm;
  private TextView AQn;
  private boolean AQo;
  private a AQp;
  private a AQq;
  private d AQr;
  private b.a AQs;
  private int AQt;
  private boolean AQu;
  private long AQv;
  private View AQw;
  private View AQx;
  private FtsWebVideoView.c AQy;
  public BroadcastReceiver AQz;
  private boolean ckP;
  public boolean fqj;
  private boolean isLoading;
  private TextView kmL;
  private LinearLayout kmR;
  private TextView kmT;
  private ImageView kmU;
  private ImageView kmV;
  private String kmZ;
  private int kna;
  private boolean knc;
  private boolean kne;
  private boolean kni;
  private boolean knj;
  private String knl;
  private String mAppId;
  private int nop;
  private String url;
  private ImageView yOr;
  
  public FtsWebVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(78077);
    this.AQe = FtsWebVideoView.b.AQB;
    this.AQy = FtsWebVideoView.c.AQF;
    this.AQz = new BroadcastReceiver()
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
    this.AQe = FtsWebVideoView.b.AQB;
    this.AQy = FtsWebVideoView.c.AQF;
    this.AQz = new BroadcastReceiver()
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
    this.AQe = FtsWebVideoView.b.AQB;
    this.AQy = FtsWebVideoView.c.AQF;
    this.AQz = new BroadcastReceiver()
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
  
  private boolean aXf()
  {
    AppMethodBeat.i(78116);
    ad.i("MicroMsg.FtsWebVideoView", "isLive %b %b", new Object[] { Boolean.valueOf(this.kni), Boolean.valueOf(this.AQf.aXf()) });
    if ((this.kni) || (this.AQf.aXf()))
    {
      AppMethodBeat.o(78116);
      return true;
    }
    AppMethodBeat.o(78116);
    return false;
  }
  
  private void bcd()
  {
    AppMethodBeat.i(78106);
    this.AQp = new a(getContext(), this, new a.b()
    {
      public final void av(float paramAnonymousFloat)
      {
        AppMethodBeat.i(78057);
        ad.d("MicroMsg.FtsWebVideoView", "onAdjustVolume:".concat(String.valueOf(paramAnonymousFloat)));
        FtsWebVideoView.j(FtsWebVideoView.this).setPercent(paramAnonymousFloat);
        FtsWebVideoView.k(FtsWebVideoView.this).setText(2131759742);
        FtsWebVideoView.l(FtsWebVideoView.this).setImageResource(2131690275);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(0);
        AppMethodBeat.o(78057);
      }
      
      public final void aw(float paramAnonymousFloat)
      {
        AppMethodBeat.i(78058);
        ad.d("MicroMsg.FtsWebVideoView", "onAdjustBrightness:".concat(String.valueOf(paramAnonymousFloat)));
        FtsWebVideoView.j(FtsWebVideoView.this).setPercent(paramAnonymousFloat);
        FtsWebVideoView.k(FtsWebVideoView.this).setText(2131759739);
        FtsWebVideoView.l(FtsWebVideoView.this).setImageResource(2131690267);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(0);
        AppMethodBeat.o(78058);
      }
      
      public final void bcn()
      {
        AppMethodBeat.i(78050);
        ad.d("MicroMsg.FtsWebVideoView", "onSingleTap");
        if (FtsWebVideoView.e(FtsWebVideoView.this)) {
          FtsWebVideoView.c(FtsWebVideoView.this).td(FtsWebVideoView.f(FtsWebVideoView.this));
        }
        AppMethodBeat.o(78050);
      }
      
      public final void bco()
      {
        AppMethodBeat.i(78051);
        ad.d("MicroMsg.FtsWebVideoView", "onDoubleTap");
        AppMethodBeat.o(78051);
      }
      
      public final void bcp()
      {
        AppMethodBeat.i(78052);
        if (FtsWebVideoView.d(FtsWebVideoView.this).aXf())
        {
          ad.i("MicroMsg.FtsWebVideoView", "onStartDragProgress isLive: no seek");
          AppMethodBeat.o(78052);
          return;
        }
        FtsWebVideoView.g(FtsWebVideoView.this).setVisibility(0);
        FtsWebVideoView.c(FtsWebVideoView.this).dPU();
        AppMethodBeat.o(78052);
      }
      
      public final void bcq()
      {
        AppMethodBeat.i(78059);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(8);
        AppMethodBeat.o(78059);
      }
      
      public final void bcr()
      {
        AppMethodBeat.i(78060);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(8);
        AppMethodBeat.o(78060);
      }
      
      public final boolean dOY()
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
        if (FtsWebVideoView.d(FtsWebVideoView.this).aXf())
        {
          ad.i("MicroMsg.FtsWebVideoView", "onDragProgress isLive: no seek");
          AppMethodBeat.o(78053);
          return 0;
        }
        ad.i("MicroMsg.FtsWebVideoView", "onDragProgress:" + paramAnonymousInt + "/" + paramAnonymousFloat);
        paramAnonymousFloat /= FtsWebVideoView.this.getMeasuredWidth();
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getVideoDurationSec();
        paramAnonymousInt = getCurrentPosition();
        paramAnonymousInt = (int)(paramAnonymousFloat * i) + paramAnonymousInt;
        if (paramAnonymousInt < 0) {
          paramAnonymousInt = j;
        }
        for (;;)
        {
          String str = c.mz(i * 1000L);
          FtsWebVideoView.g(FtsWebVideoView.this).setText(c.mz(paramAnonymousInt * 1000L) + "/" + str);
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
        FtsWebVideoView.c(FtsWebVideoView.this).dPV();
        FtsWebVideoView.g(FtsWebVideoView.this).setVisibility(8);
        ad.i("MicroMsg.FtsWebVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(FtsWebVideoView.d(FtsWebVideoView.this).getCurrPosSec()), Float.valueOf(paramAnonymousFloat) });
        if (FtsWebVideoView.d(FtsWebVideoView.this).aXf())
        {
          ad.i("MicroMsg.FtsWebVideoView", "onEndDragProgress isLive: no seek");
          AppMethodBeat.o(78054);
          return;
        }
        FtsWebVideoView.this.U(paramAnonymousInt, false);
        FtsWebVideoView.c(FtsWebVideoView.this).dPV();
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null) {
          FtsWebVideoView.h(FtsWebVideoView.this).eki();
        }
        AppMethodBeat.o(78054);
      }
    });
    AppMethodBeat.o(78106);
  }
  
  private void bcf()
  {
    AppMethodBeat.i(78107);
    this.AQf.setIMMVideoViewCallback(new h.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(78061);
        ad.i("MicroMsg.FtsWebVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        h.vKh.f(14911, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), FtsWebVideoView.n(FtsWebVideoView.this), ay.iw(FtsWebVideoView.this.getContext()) });
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          ad.e("MicroMsg.JsApiVideoCallback", "onError what %d, extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          paramAnonymousString1.clean();
        }
        try
        {
          paramAnonymousString2 = new JSONObject();
          paramAnonymousString2.put("errCode", paramAnonymousInt1);
          paramAnonymousString2.put("errMsg", String.valueOf(paramAnonymousInt2));
          paramAnonymousString1.bp(paramAnonymousString1.a(7, paramAnonymousString2));
          FtsWebVideoView.this.pause();
          FtsWebVideoView.a(FtsWebVideoView.this, FtsWebVideoView.this.getContext().getString(2131764672, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), FtsWebVideoView.this.getContext().getString(2131764699));
          AppMethodBeat.o(78061);
          return;
        }
        catch (JSONException paramAnonymousString1)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
        }
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(78064);
        ad.i("MicroMsg.FtsWebVideoView", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (FtsWebVideoView.s(FtsWebVideoView.this) == FtsWebVideoView.b.AQB)
        {
          paramAnonymousString2 = FtsWebVideoView.this;
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label92;
          }
        }
        label92:
        for (paramAnonymousString1 = FtsWebVideoView.b.AQD;; paramAnonymousString1 = FtsWebVideoView.b.AQC)
        {
          FtsWebVideoView.a(paramAnonymousString2, paramAnonymousString1);
          ad.i("MicroMsg.FtsWebVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { FtsWebVideoView.s(FtsWebVideoView.this) });
          AppMethodBeat.o(78064);
          return;
        }
      }
      
      public final void db(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78062);
        ad.i("MicroMsg.FtsWebVideoView", "onPrepared");
        paramAnonymousString1 = FtsWebVideoView.o(FtsWebVideoView.this);
        paramAnonymousString1.kuc = -1;
        paramAnonymousString1.kud = 0;
        paramAnonymousString1.kub = 0.0F;
        FtsWebVideoView.c(FtsWebVideoView.this).td(FtsWebVideoView.f(FtsWebVideoView.this));
        AppMethodBeat.o(78062);
      }
      
      public final void dc(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78063);
        ad.i("MicroMsg.FtsWebVideoView", "onVideoEnded");
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          ad.d("MicroMsg.JsApiVideoCallback", "onVideoEnded %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.bdD();
        }
        try
        {
          paramAnonymousString1.bp(paramAnonymousString1.a(3, null));
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
            ad.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
          FtsWebVideoView.this.U(0, false);
          FtsWebVideoView.this.pause();
          FtsWebVideoView.q(FtsWebVideoView.this);
          FtsWebVideoView.r(FtsWebVideoView.this).setImageResource(2131232470);
          FtsWebVideoView.c(FtsWebVideoView.this).setVisibility(8);
          AppMethodBeat.o(78063);
        }
      }
      
      public final void dd(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78065);
        ad.i("MicroMsg.FtsWebVideoView", "onVideoPause");
        if ((FtsWebVideoView.h(FtsWebVideoView.this) != null) && (FtsWebVideoView.h(FtsWebVideoView.this) != null))
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          ad.d("MicroMsg.JsApiVideoCallback", "onVideoPause %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.bdD();
          try
          {
            paramAnonymousString1.bp(paramAnonymousString1.a(2, null));
            AppMethodBeat.o(78065);
            return;
          }
          catch (JSONException paramAnonymousString1)
          {
            ad.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
        }
        AppMethodBeat.o(78065);
      }
      
      public final void de(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78066);
        ad.i("MicroMsg.FtsWebVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(FtsWebVideoView.t(FtsWebVideoView.this)) });
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          ad.d("MicroMsg.JsApiVideoCallback", "onVideoPlay %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.krT = 0;
          if (paramAnonymousString1.krS == null) {
            paramAnonymousString1.krS = new av(new d.1(paramAnonymousString1), true);
          }
          paramAnonymousString1.krS.av(250L, 250L);
        }
        try
        {
          paramAnonymousString1.bp(paramAnonymousString1.a(1, null));
          if ((FtsWebVideoView.u(FtsWebVideoView.this) > 0L) && (FtsWebVideoView.u(FtsWebVideoView.this) != 9223372036854775807L))
          {
            long l = System.currentTimeMillis() - FtsWebVideoView.u(FtsWebVideoView.this);
            h.vKh.f(14909, new Object[] { Long.valueOf(l), Long.valueOf(System.currentTimeMillis()), Long.valueOf(l), ay.iw(FtsWebVideoView.this.getContext()), FtsWebVideoView.n(FtsWebVideoView.this) });
          }
          AppMethodBeat.o(78066);
          return;
        }
        catch (JSONException paramAnonymousString1)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
        }
      }
      
      public final void dg(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78067);
        ad.i("MicroMsg.FtsWebVideoView", "onVideoWaiting");
        FtsWebVideoView.c(FtsWebVideoView.this).dPU();
        FtsWebVideoView.a(FtsWebVideoView.this, true);
        AppMethodBeat.o(78067);
      }
      
      public final void dh(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78068);
        ad.i("MicroMsg.FtsWebVideoView", "onVideoWaitingEnd");
        FtsWebVideoView.a(FtsWebVideoView.this, false);
        FtsWebVideoView.c(FtsWebVideoView.this).dPV();
        FtsWebVideoView.c(FtsWebVideoView.this).bcH();
        AppMethodBeat.o(78068);
      }
      
      public final void jw(String paramAnonymousString1, String paramAnonymousString2) {}
    });
    AppMethodBeat.o(78107);
  }
  
  private void eka()
  {
    AppMethodBeat.i(78084);
    if (bcg())
    {
      this.AIc.setVisibility(0);
      AppMethodBeat.o(78084);
      return;
    }
    this.AIc.setVisibility(8);
    AppMethodBeat.o(78084);
  }
  
  private void ekb()
  {
    AppMethodBeat.i(78090);
    this.AQh.setVisibility(8);
    AppMethodBeat.o(78090);
  }
  
  private boolean ekc()
  {
    AppMethodBeat.i(78110);
    if ((this.knc) && (!ekd()))
    {
      AppMethodBeat.o(78110);
      return true;
    }
    AppMethodBeat.o(78110);
    return false;
  }
  
  private boolean ekd()
  {
    AppMethodBeat.i(78111);
    if (this.AQh.getVisibility() == 0)
    {
      AppMethodBeat.o(78111);
      return true;
    }
    AppMethodBeat.o(78111);
    return false;
  }
  
  private void eke()
  {
    AppMethodBeat.i(78114);
    this.AQg = new WebSearchWebVideoViewControlBar(getContext());
    this.AQg.setVisibility(8);
    this.AQg.setEnterFullScreenBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78069);
        if (!FtsWebVideoView.this.bcg()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.tf(bool);
          AppMethodBeat.o(78069);
          return;
        }
      }
    });
    this.AQg.setExitFullScreenBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78037);
        if (!FtsWebVideoView.this.bcg()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.tf(bool);
          AppMethodBeat.o(78037);
          return;
        }
      }
    });
    this.AQg.setMuteBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78038);
        FtsWebVideoView.v(FtsWebVideoView.this);
        FtsWebVideoView.c(FtsWebVideoView.this).bcH();
        AppMethodBeat.o(78038);
      }
    });
    this.AQg.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void bcv()
      {
        AppMethodBeat.i(78039);
        ad.i("MicroMsg.FtsWebVideoView", "onSeekPre");
        FtsWebVideoView.c(FtsWebVideoView.this).bGT();
        AppMethodBeat.o(78039);
      }
      
      public final void rZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(78040);
        ad.i("MicroMsg.FtsWebVideoView", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        FtsWebVideoView.this.U(paramAnonymousInt, false);
        FtsWebVideoView.c(FtsWebVideoView.this).bcH();
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null) {
          FtsWebVideoView.h(FtsWebVideoView.this).eki();
        }
        AppMethodBeat.o(78040);
      }
    });
    this.AQg.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78041);
        if (FtsWebVideoView.d(FtsWebVideoView.this).isPlaying())
        {
          FtsWebVideoView.c(FtsWebVideoView.this).bGT();
          FtsWebVideoView.this.pause();
          AppMethodBeat.o(78041);
          return;
        }
        FtsWebVideoView.c(FtsWebVideoView.this).bcH();
        FtsWebVideoView.this.start(true);
        AppMethodBeat.o(78041);
      }
    });
    this.AQg.setStatePorter(new WebSearchWebVideoViewControlBar.a()
    {
      public final int bcl()
      {
        AppMethodBeat.i(78042);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getCacheTimeSec();
        AppMethodBeat.o(78042);
        return i;
      }
      
      public final int bcm()
      {
        AppMethodBeat.i(78043);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getVideoDurationSec();
        AppMethodBeat.o(78043);
        return i;
      }
      
      public final int eiw()
      {
        AppMethodBeat.i(78044);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getCurrPosMs();
        AppMethodBeat.o(78044);
        return i;
      }
    });
    this.AQf.setVideoFooterView(this.AQg);
    AppMethodBeat.o(78114);
  }
  
  private boolean gB(final Context paramContext)
  {
    AppMethodBeat.i(78080);
    Object localObject = this.AQy;
    if (ay.isConnected(paramContext))
    {
      if ((!this.AQu) && (!ay.isWifi(paramContext)))
      {
        pause();
        this.AQy = FtsWebVideoView.c.AQG;
        this.AQg.setVisibility(8);
        localObject = getNetUnavailableTip();
        String str = paramContext.getString(2131764669);
        paramContext.getString(2131764666);
        jT((String)localObject, str);
        AppMethodBeat.o(78080);
        return false;
      }
    }
    else
    {
      if (localObject == FtsWebVideoView.c.AQH)
      {
        this.AQw.setVisibility(0);
        this.AQx.setVisibility(8);
        this.AQh.setVisibility(0);
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
        gC(paramContext);
      }
    }
    AppMethodBeat.o(78080);
    return true;
  }
  
  private void gC(Context paramContext)
  {
    AppMethodBeat.i(78081);
    this.AQy = FtsWebVideoView.c.AQH;
    pause();
    jT(paramContext.getString(2131764685), paramContext.getString(2131764699));
    AppMethodBeat.o(78081);
  }
  
  private String getNetUnavailableTip()
  {
    AppMethodBeat.i(78082);
    Object localObject;
    if (this.AQt == 0)
    {
      localObject = getContext().getString(2131764687);
      AppMethodBeat.o(78082);
      return localObject;
    }
    Context localContext = getContext();
    long l = this.AQt;
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
    this.AQf = ((FtsVideoWrapper)findViewById(2131306410));
    this.kmL = ((TextView)findViewById(2131303515));
    this.AQh = findViewById(2131305866);
    this.AQi = findViewById(2131305891);
    this.kmR = ((LinearLayout)findViewById(2131296505));
    this.AQj = ((WebSearchDotPercentIndicator)findViewById(2131296506));
    this.kmT = ((TextView)findViewById(2131296502));
    this.kmU = ((ImageView)findViewById(2131296504));
    this.kmV = ((ImageView)findViewById(2131298813));
    this.AQw = findViewById(2131306352);
    this.AQx = findViewById(2131305892);
    this.AQj.setDotsNum(8);
    this.yOr = ((ImageView)findViewById(2131298815));
    this.AQk = findViewById(2131298829);
    this.AQm = ((TextView)findViewById(2131305867));
    this.AQl = ((Button)findViewById(2131305868));
    this.AQn = ((TextView)findViewById(2131305870));
    this.AIc = ((ImageView)findViewById(2131299599));
    this.AQm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78036);
        FtsWebVideoView.this.pause();
        AppMethodBeat.o(78036);
      }
    });
    this.AIc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78045);
        if (!FtsWebVideoView.this.bcg()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.tf(bool);
          AppMethodBeat.o(78045);
          return;
        }
      }
    });
    this.AQl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78046);
        if (FtsWebVideoView.a(FtsWebVideoView.this) == FtsWebVideoView.c.AQG) {
          FtsWebVideoView.b(FtsWebVideoView.this);
        }
        FtsWebVideoView.this.start(true);
        AppMethodBeat.o(78046);
      }
    });
    this.AQk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78047);
        FtsWebVideoView.this.start(true);
        FtsWebVideoView.c(FtsWebVideoView.this).bcH();
        AppMethodBeat.o(78047);
      }
    });
    bcd();
    bcf();
    eke();
    paramContext.registerReceiver(this.AQz, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    ekb();
    AppMethodBeat.o(78079);
  }
  
  private void jT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78083);
    ekb();
    this.AQw.setVisibility(8);
    this.AQx.setVisibility(0);
    this.AQg.setVisibility(8);
    this.AQh.setVisibility(0);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.AQn.setText(paramString1);
      this.AQn.setVisibility(0);
      if (TextUtils.isEmpty(paramString2)) {
        break label139;
      }
      this.AQl.setText(paramString2);
      this.AQl.setVisibility(0);
    }
    for (;;)
    {
      this.AQi.setVisibility(0);
      this.AQk.setVisibility(8);
      this.AQm.setVisibility(8);
      eka();
      AppMethodBeat.o(78083);
      return;
      this.AQn.setVisibility(8);
      break;
      label139:
      this.AQl.setVisibility(8);
    }
  }
  
  private void setCover(String paramString)
  {
    AppMethodBeat.i(78097);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78097);
      return;
    }
    if (!bt.isNullOrNil(this.knl))
    {
      ad.i("MicroMsg.FtsWebVideoView", "setCover mCoverUrl not null");
      AppMethodBeat.o(78097);
      return;
    }
    AppMethodBeat.o(78097);
  }
  
  public final void U(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(78094);
    ad.i("MicroMsg.FtsWebVideoView", "seek to position=%d current=%d isLive=%b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.AQf.getCurrPosSec()), Boolean.valueOf(this.kni) });
    if (aXf())
    {
      AppMethodBeat.o(78094);
      return;
    }
    if (paramBoolean)
    {
      this.AQf.c(paramInt, paramBoolean);
      AppMethodBeat.o(78094);
      return;
    }
    this.AQf.p(paramInt);
    AppMethodBeat.o(78094);
  }
  
  public final boolean bcg()
  {
    AppMethodBeat.i(78113);
    if (this.AQq == null)
    {
      ad.w("MicroMsg.FtsWebVideoView", "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(78113);
      return false;
    }
    boolean bool = this.AQq.isFullScreen();
    AppMethodBeat.o(78113);
    return bool;
  }
  
  public final void cv(String paramString, int paramInt)
  {
    AppMethodBeat.i(78093);
    ad.i("MicroMsg.FtsWebVideoView", "setVideoPath path=%s isLive=%s", new Object[] { paramString, Boolean.FALSE });
    this.url = paramString;
    if (bt.isNullOrNil(paramString))
    {
      ad.v("MicroMsg.FtsWebVideoView", "setVideoPath videoPath empty");
      AppMethodBeat.o(78093);
      return;
    }
    stop();
    this.kni = false;
    this.AQf.c(false, paramString, paramInt);
    if (this.AQg != null) {
      this.AQg.setVideoTotalTime(paramInt);
    }
    if (this.nop > 0) {
      this.AQf.p(this.nop);
    }
    if (this.ckP)
    {
      ad.i("MicroMsg.FtsWebVideoView", "setVideoPath autoPlay");
      start(false);
    }
    if (paramString.startsWith("wxfile://")) {
      setCover(paramString);
    }
    AppMethodBeat.o(78093);
  }
  
  public d getCallback()
  {
    return this.AQr;
  }
  
  public String getCookieData()
  {
    return this.kmZ;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(78101);
    int i = this.AQf.getCurrPosMs();
    AppMethodBeat.o(78101);
    return i;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(78100);
    int i = this.AQf.getCurrPosSec();
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
    return this.AQs;
  }
  
  public int getVideoSizeByte()
  {
    return this.AQt;
  }
  
  public int getmVideoPlayerId()
  {
    return this.kna;
  }
  
  public final void gn(boolean paramBoolean)
  {
    AppMethodBeat.i(78115);
    if (this.AQr == null)
    {
      AppMethodBeat.o(78115);
      return;
    }
    if (this.AQe == FtsWebVideoView.b.AQD) {}
    for (String str = "vertical";; str = "horizontal")
    {
      this.AQr.d(this.kna, paramBoolean, str);
      eka();
      AppMethodBeat.o(78115);
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78108);
    if ((this.kne) || (bcg()))
    {
      a locala;
      if (this.AQp != null)
      {
        locala = this.AQp;
        if (locala.APX.dOY())
        {
          int i = paramMotionEvent.getActionMasked();
          if (i == 0)
          {
            locala.kub = paramMotionEvent.getRawX();
            locala.JT = ((AudioManager)locala.mContext.getSystemService("audio")).getStreamVolume(3);
            locala.klO = c.dp(locala.mContext);
          }
          locala.ktZ.onTouchEvent(paramMotionEvent);
          if ((i != 1) && (i != 3)) {
            break label182;
          }
          if (locala.APW != a.a.AQc) {
            break label190;
          }
          locala.APX.k(locala.kud, paramMotionEvent.getRawX() - locala.kub);
          locala.kuc = -1;
          locala.kud = 0;
          locala.kub = 0.0F;
        }
      }
      for (;;)
      {
        locala.APW = a.a.APZ;
        label182:
        AppMethodBeat.o(78108);
        return true;
        label190:
        if (locala.APW == a.a.AQa)
        {
          ((AudioManager)locala.mContext.getSystemService("audio")).getStreamMaxVolume(3);
          locala.APX.bcq();
        }
        else if (locala.APW == a.a.AQb)
        {
          locala.APX.bcr();
        }
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (ekc())) {
      this.AQg.td(this.isLoading);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(78108);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(78091);
    ad.i("MicroMsg.FtsWebVideoView", "pause");
    ekb();
    if (!this.AQf.isPlaying())
    {
      AppMethodBeat.o(78091);
      return;
    }
    this.AQf.pause();
    AppMethodBeat.o(78091);
  }
  
  public void setAllowMobileNetPlay(boolean paramBoolean)
  {
    this.AQu = paramBoolean;
  }
  
  public void setAppId(String paramString)
  {
    AppMethodBeat.i(78085);
    ad.i("MicroMsg.FtsWebVideoView", "setAppId appid=%s", new Object[] { paramString });
    this.mAppId = paramString;
    AppMethodBeat.o(78085);
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(78086);
    ad.i("MicroMsg.FtsWebVideoView", "setAutoPlay =%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ckP = paramBoolean;
    AppMethodBeat.o(78086);
  }
  
  public void setCallback(d paramd)
  {
    this.AQr = paramd;
  }
  
  public void setCookieData(String paramString)
  {
    this.kmZ = paramString;
  }
  
  public final void setCover$16da05f7(String paramString)
  {
    AppMethodBeat.i(78096);
    ad.i("MicroMsg.FtsWebVideoView", "setCover coverUrl=%s", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78096);
      return;
    }
    this.knl = paramString;
    com.tencent.mm.modelappbrand.a.b.aub().a(this.kmV, paramString, null, null);
    AppMethodBeat.o(78096);
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(78103);
    ad.i("MicroMsg.FtsWebVideoView", "setDisableScroll isDisableScroll=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.AQo = paramBoolean;
    AppMethodBeat.o(78103);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(78087);
    if (paramInt <= 0)
    {
      ad.i("MicroMsg.FtsWebVideoView", "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(78087);
      return;
    }
    AppMethodBeat.o(78087);
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.AQq = parama;
  }
  
  public void setFullScreenDirection(String paramString)
  {
    AppMethodBeat.i(78102);
    ad.i("MicroMsg.FtsWebVideoView", "setFullScreenDirection %s", new Object[] { paramString });
    if ("horizontal".equalsIgnoreCase(paramString))
    {
      this.AQe = FtsWebVideoView.b.AQC;
      AppMethodBeat.o(78102);
      return;
    }
    if ("vertical".equalsIgnoreCase(paramString))
    {
      this.AQe = FtsWebVideoView.b.AQD;
      AppMethodBeat.o(78102);
      return;
    }
    this.AQe = FtsWebVideoView.b.AQB;
    AppMethodBeat.o(78102);
  }
  
  public void setInitialTime(int paramInt)
  {
    AppMethodBeat.i(78105);
    ad.i("MicroMsg.FtsWebVideoView", "setInitialTime initialTime=%d", new Object[] { Integer.valueOf(paramInt) });
    this.nop = paramInt;
    AppMethodBeat.o(78105);
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(78095);
    ad.i("MicroMsg.FtsWebVideoView", "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knc = paramBoolean;
    AppMethodBeat.o(78095);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(78088);
    ad.i("MicroMsg.FtsWebVideoView", "setLoop loop=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knj = paramBoolean;
    AppMethodBeat.o(78088);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(78099);
    ad.i("MicroMsg.FtsWebVideoView", "setMute isMute=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.fqj = paramBoolean;
    this.AQf.setMute(paramBoolean);
    if (paramBoolean)
    {
      this.AQg.Zx();
      AppMethodBeat.o(78099);
      return;
    }
    this.AQg.eiv();
    AppMethodBeat.o(78099);
  }
  
  public void setObjectFit(String paramString)
  {
    AppMethodBeat.i(78098);
    ad.i("MicroMsg.FtsWebVideoView", "setObjectFit objectFit=%s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.AQf.setScaleType(h.e.BVr);
      this.kmV.setScaleType(ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(78098);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.AQf.setScaleType(h.e.BVt);
      this.kmV.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(78098);
      return;
    }
    this.AQf.setScaleType(h.e.BVs);
    this.kmV.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(78098);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(78104);
    ad.i("MicroMsg.FtsWebVideoView", "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kne = paramBoolean;
    AppMethodBeat.o(78104);
  }
  
  public void setUiLifecycleListener(b.a parama)
  {
    this.AQs = parama;
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.kna = paramInt;
  }
  
  public void setVideoSizeByte(int paramInt)
  {
    this.AQt = paramInt;
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(78089);
    ad.i("MicroMsg.FtsWebVideoView", "start");
    ekb();
    if ((paramBoolean) && (!gB(getContext())))
    {
      ad.i("MicroMsg.FtsWebVideoView", "start network is not wifi");
      AppMethodBeat.o(78089);
      return;
    }
    this.AQy = FtsWebVideoView.c.AQF;
    if (this.AQf.isPlaying())
    {
      AppMethodBeat.o(78089);
      return;
    }
    if (this.knc)
    {
      WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.AQg;
      if (localWebSearchWebVideoViewControlBar.krU == null) {
        localWebSearchWebVideoViewControlBar.krU = new av(new WebSearchWebVideoViewControlBar.2(localWebSearchWebVideoViewControlBar), true);
      }
      localWebSearchWebVideoViewControlBar.bec();
      localWebSearchWebVideoViewControlBar.krU.stopTimer();
      localWebSearchWebVideoViewControlBar.krU.av(500L, 500L);
    }
    this.AQf.start();
    if (this.AQv == 0L)
    {
      this.AQv = System.currentTimeMillis();
      AppMethodBeat.o(78089);
      return;
    }
    this.AQv = 9223372036854775807L;
    AppMethodBeat.o(78089);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(78092);
    ad.i("MicroMsg.FtsWebVideoView", "stop");
    if (!this.AQf.isPlaying())
    {
      AppMethodBeat.o(78092);
      return;
    }
    this.AQf.stop();
    WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.AQg;
    if (localWebSearchWebVideoViewControlBar.krU != null) {
      localWebSearchWebVideoViewControlBar.krU.stopTimer();
    }
    AppMethodBeat.o(78092);
  }
  
  public final void tf(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(78112);
    ad.i("MicroMsg.FtsWebVideoView", "operateFullScreen toFullScreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.AQq == null)
    {
      ad.w("MicroMsg.FtsWebVideoView", "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(78112);
      return;
    }
    if (paramBoolean == bcg())
    {
      ad.i("MicroMsg.FtsWebVideoView", "operateFullScreen current same");
      AppMethodBeat.o(78112);
      return;
    }
    if (paramBoolean)
    {
      Object localObject = this.AQq;
      paramBoolean = bool;
      if (this.AQe != FtsWebVideoView.b.AQD) {
        paramBoolean = true;
      }
      ((a)localObject).tg(paramBoolean);
      localObject = this.AQg;
      ((WebSearchWebVideoViewControlBar)localObject).ktF = true;
      ((WebSearchWebVideoViewControlBar)localObject).bdY();
      gn(true);
      AppMethodBeat.o(78112);
      return;
    }
    this.AQq.bah();
    this.AQg.bah();
    AppMethodBeat.o(78112);
  }
  
  public static abstract interface a
  {
    public abstract void bah();
    
    public abstract boolean isFullScreen();
    
    public abstract void tg(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView
 * JD-Core Version:    0.7.0.1
 */