package com.tencent.mm.plugin.webview.fts.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
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
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.fts.b.b.a;
import com.tencent.mm.plugin.webview.fts.b.c;
import com.tencent.mm.plugin.webview.fts.b.d;
import com.tencent.mm.plugin.webview.fts.b.d.1;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.math.BigDecimal;
import org.json.JSONException;

public class FtsWebVideoView
  extends RelativeLayout
{
  private ImageView TLs;
  private TextView WCA;
  private boolean WCB;
  private a WCC;
  private a WCD;
  private int WCE;
  private d WCF;
  private b.a WCG;
  private int WCH;
  private boolean WCI;
  private long WCJ;
  private View WCK;
  private View WCL;
  private FtsWebVideoView.c WCM;
  public BroadcastReceiver WCN;
  private FtsWebVideoView.b WCr;
  public FtsVideoWrapper WCs;
  public WebSearchWebVideoViewControlBar WCt;
  private View WCu;
  private View WCv;
  private WebSearchDotPercentIndicator WCw;
  private View WCx;
  private Button WCy;
  private TextView WCz;
  private ImageView Wrv;
  private boolean eyT;
  private boolean isLoading;
  public boolean lAj;
  private String mAppId;
  private boolean mLoop;
  private ImageView szA;
  private String szE;
  private int szF;
  private boolean szH;
  private boolean szJ;
  private boolean szN;
  private String szP;
  private TextView szq;
  private LinearLayout szw;
  private TextView szy;
  private ImageView szz;
  private String url;
  
  public FtsWebVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(78077);
    this.WCr = FtsWebVideoView.b.WCP;
    this.WCM = FtsWebVideoView.c.WCT;
    this.WCN = new FtsWebVideoView.10(this);
    init(paramContext);
    AppMethodBeat.o(78077);
  }
  
  public FtsWebVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(78078);
    this.WCr = FtsWebVideoView.b.WCP;
    this.WCM = FtsWebVideoView.c.WCT;
    this.WCN = new FtsWebVideoView.10(this);
    init(paramContext);
    AppMethodBeat.o(78078);
  }
  
  public FtsWebVideoView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(78076);
    this.WCr = FtsWebVideoView.b.WCP;
    this.WCM = FtsWebVideoView.c.WCT;
    this.WCN = new FtsWebVideoView.10(this);
    setAutoPlay(paramBoolean);
    init(paramContext);
    AppMethodBeat.o(78076);
  }
  
  private void cuW()
  {
    AppMethodBeat.i(78106);
    this.WCC = new a(getContext(), this, new a.b()
    {
      public final void bK(float paramAnonymousFloat)
      {
        AppMethodBeat.i(78057);
        Log.d("MicroMsg.FtsWebVideoView", "onAdjustVolume:".concat(String.valueOf(paramAnonymousFloat)));
        FtsWebVideoView.j(FtsWebVideoView.this).setPercent(paramAnonymousFloat);
        FtsWebVideoView.k(FtsWebVideoView.this).setText(c.i.fts_web_video_volume);
        FtsWebVideoView.l(FtsWebVideoView.this).setImageResource(c.h.fts_web_video_volume_icon);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(0);
        AppMethodBeat.o(78057);
      }
      
      public final void bL(float paramAnonymousFloat)
      {
        AppMethodBeat.i(78058);
        Log.d("MicroMsg.FtsWebVideoView", "onAdjustBrightness:".concat(String.valueOf(paramAnonymousFloat)));
        FtsWebVideoView.j(FtsWebVideoView.this).setPercent(paramAnonymousFloat);
        FtsWebVideoView.k(FtsWebVideoView.this).setText(c.i.fts_web_video_brightness);
        FtsWebVideoView.l(FtsWebVideoView.this).setImageResource(c.h.fts_web_video_brightness_icon);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(0);
        AppMethodBeat.o(78058);
      }
      
      public final void cvh()
      {
        AppMethodBeat.i(78050);
        Log.d("MicroMsg.FtsWebVideoView", "onSingleTap");
        if (FtsWebVideoView.e(FtsWebVideoView.this)) {
          FtsWebVideoView.c(FtsWebVideoView.this).Iq(FtsWebVideoView.f(FtsWebVideoView.this));
        }
        AppMethodBeat.o(78050);
      }
      
      public final void cvi()
      {
        AppMethodBeat.i(78051);
        Log.d("MicroMsg.FtsWebVideoView", "onDoubleTap");
        AppMethodBeat.o(78051);
      }
      
      public final void cvj()
      {
        AppMethodBeat.i(78052);
        if (FtsWebVideoView.d(FtsWebVideoView.this).isLive())
        {
          Log.i("MicroMsg.FtsWebVideoView", "onStartDragProgress isLive: no seek");
          AppMethodBeat.o(78052);
          return;
        }
        FtsWebVideoView.g(FtsWebVideoView.this).setVisibility(0);
        FtsWebVideoView.c(FtsWebVideoView.this).hOO();
        AppMethodBeat.o(78052);
      }
      
      public final boolean cvk()
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
      
      public final void cvl()
      {
        AppMethodBeat.i(78059);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(8);
        AppMethodBeat.o(78059);
      }
      
      public final void cvm()
      {
        AppMethodBeat.i(78060);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(8);
        AppMethodBeat.o(78060);
      }
      
      public final int getCurrentPosition()
      {
        AppMethodBeat.i(78056);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getCurrPosSec();
        AppMethodBeat.o(78056);
        return i;
      }
      
      public final int p(int paramAnonymousInt, float paramAnonymousFloat)
      {
        int j = 0;
        AppMethodBeat.i(78053);
        if (FtsWebVideoView.d(FtsWebVideoView.this).isLive())
        {
          Log.i("MicroMsg.FtsWebVideoView", "onDragProgress isLive: no seek");
          AppMethodBeat.o(78053);
          return 0;
        }
        Log.i("MicroMsg.FtsWebVideoView", "onDragProgress:" + paramAnonymousInt + "/" + paramAnonymousFloat);
        paramAnonymousFloat /= FtsWebVideoView.this.getMeasuredWidth();
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getVideoDurationSec();
        paramAnonymousInt = getCurrentPosition();
        paramAnonymousInt = (int)(paramAnonymousFloat * i) + paramAnonymousInt;
        if (paramAnonymousInt < 0) {
          paramAnonymousInt = j;
        }
        for (;;)
        {
          String str = c.iY(i * 1000L);
          FtsWebVideoView.g(FtsWebVideoView.this).setText(c.iY(paramAnonymousInt * 1000L) + "/" + str);
          AppMethodBeat.o(78053);
          return paramAnonymousInt;
          if (paramAnonymousInt > i) {
            paramAnonymousInt = i;
          }
        }
      }
      
      public final void q(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(78054);
        FtsWebVideoView.c(FtsWebVideoView.this).hOP();
        FtsWebVideoView.g(FtsWebVideoView.this).setVisibility(8);
        Log.i("MicroMsg.FtsWebVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(FtsWebVideoView.d(FtsWebVideoView.this).getCurrPosSec()), Float.valueOf(paramAnonymousFloat) });
        if (FtsWebVideoView.d(FtsWebVideoView.this).isLive())
        {
          Log.i("MicroMsg.FtsWebVideoView", "onEndDragProgress isLive: no seek");
          AppMethodBeat.o(78054);
          return;
        }
        FtsWebVideoView.this.as(paramAnonymousInt, false);
        FtsWebVideoView.c(FtsWebVideoView.this).hOP();
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null) {
          FtsWebVideoView.h(FtsWebVideoView.this).itp();
        }
        AppMethodBeat.o(78054);
      }
    });
    AppMethodBeat.o(78106);
  }
  
  private void cuY()
  {
    AppMethodBeat.i(78107);
    this.WCs.setIMMVideoViewCallback(new i.b()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(78061);
        Log.i("MicroMsg.FtsWebVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        h.OAn.b(14911, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), FtsWebVideoView.n(FtsWebVideoView.this), NetStatusUtil.getFormatedNetType(FtsWebVideoView.this.getContext()) });
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          Log.e("MicroMsg.JsApiVideoCallback", "onError what %d, extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          paramAnonymousString1.clean();
        }
        try
        {
          paramAnonymousString1.cF(paramAnonymousString1.f(7, d.ng(paramAnonymousInt1, paramAnonymousInt2)));
          FtsWebVideoView.this.pause();
          FtsWebVideoView.a(FtsWebVideoView.this, FtsWebVideoView.this.getContext().getString(c.i.video_error_warnning, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), FtsWebVideoView.this.getContext().getString(c.i.video_retry_play));
          AppMethodBeat.o(78061);
          return;
        }
        catch (JSONException paramAnonymousString1)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
        }
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(78064);
        Log.i("MicroMsg.FtsWebVideoView", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (FtsWebVideoView.s(FtsWebVideoView.this) == FtsWebVideoView.b.WCP)
        {
          paramAnonymousString2 = FtsWebVideoView.this;
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label92;
          }
        }
        label92:
        for (paramAnonymousString1 = FtsWebVideoView.b.WCR;; paramAnonymousString1 = FtsWebVideoView.b.WCQ)
        {
          FtsWebVideoView.a(paramAnonymousString2, paramAnonymousString1);
          Log.i("MicroMsg.FtsWebVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { FtsWebVideoView.s(FtsWebVideoView.this) });
          AppMethodBeat.o(78064);
          return;
        }
      }
      
      public final void el(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78062);
        Log.i("MicroMsg.FtsWebVideoView", "onPrepared");
        paramAnonymousString1 = FtsWebVideoView.o(FtsWebVideoView.this);
        paramAnonymousString1.sIj = -1;
        paramAnonymousString1.sIk = 0;
        paramAnonymousString1.sIi = 0.0F;
        FtsWebVideoView.c(FtsWebVideoView.this).Iq(FtsWebVideoView.f(FtsWebVideoView.this));
        AppMethodBeat.o(78062);
      }
      
      public final void em(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78063);
        Log.i("MicroMsg.FtsWebVideoView", "onVideoEnded");
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          Log.d("MicroMsg.JsApiVideoCallback", "onVideoEnded %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.cwt();
        }
        try
        {
          paramAnonymousString1.cF(paramAnonymousString1.f(3, null));
          if (FtsWebVideoView.p(FtsWebVideoView.this))
          {
            FtsWebVideoView.this.as(0, true);
            AppMethodBeat.o(78063);
            return;
          }
        }
        catch (JSONException paramAnonymousString1)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
          FtsWebVideoView.this.as(0, false);
          FtsWebVideoView.this.pause();
          FtsWebVideoView.q(FtsWebVideoView.this);
          FtsWebVideoView.r(FtsWebVideoView.this).setImageResource(c.e.fts_video_replay_btn);
          FtsWebVideoView.c(FtsWebVideoView.this).setVisibility(8);
          AppMethodBeat.o(78063);
        }
      }
      
      public final void en(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78065);
        Log.i("MicroMsg.FtsWebVideoView", "onVideoPause");
        if ((FtsWebVideoView.h(FtsWebVideoView.this) != null) && (FtsWebVideoView.h(FtsWebVideoView.this) != null))
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          Log.d("MicroMsg.JsApiVideoCallback", "onVideoPause %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.cwt();
          try
          {
            paramAnonymousString1.cF(paramAnonymousString1.f(2, null));
            AppMethodBeat.o(78065);
            return;
          }
          catch (JSONException paramAnonymousString1)
          {
            Log.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
        }
        AppMethodBeat.o(78065);
      }
      
      public final void eo(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78066);
        Log.i("MicroMsg.FtsWebVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(FtsWebVideoView.t(FtsWebVideoView.this)) });
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          Log.d("MicroMsg.JsApiVideoCallback", "onVideoPlay %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.sEo = 0;
          if (paramAnonymousString1.sEn == null) {
            paramAnonymousString1.sEn = new MTimerHandler(new d.1(paramAnonymousString1), true);
          }
          paramAnonymousString1.sEn.startTimer(250L);
        }
        try
        {
          paramAnonymousString1.cF(paramAnonymousString1.f(1, null));
          if ((FtsWebVideoView.u(FtsWebVideoView.this) > 0L) && (FtsWebVideoView.u(FtsWebVideoView.this) != 9223372036854775807L))
          {
            long l = System.currentTimeMillis() - FtsWebVideoView.u(FtsWebVideoView.this);
            h.OAn.b(14909, new Object[] { Long.valueOf(l), Long.valueOf(System.currentTimeMillis()), Long.valueOf(l), NetStatusUtil.getFormatedNetType(FtsWebVideoView.this.getContext()), FtsWebVideoView.n(FtsWebVideoView.this) });
          }
          AppMethodBeat.o(78066);
          return;
        }
        catch (JSONException paramAnonymousString1)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
        }
      }
      
      public final void ep(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78067);
        Log.i("MicroMsg.FtsWebVideoView", "onVideoWaiting");
        FtsWebVideoView.c(FtsWebVideoView.this).hOO();
        FtsWebVideoView.a(FtsWebVideoView.this, true);
        AppMethodBeat.o(78067);
      }
      
      public final void eq(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78068);
        Log.i("MicroMsg.FtsWebVideoView", "onVideoWaitingEnd");
        FtsWebVideoView.a(FtsWebVideoView.this, false);
        FtsWebVideoView.c(FtsWebVideoView.this).hOP();
        FtsWebVideoView.c(FtsWebVideoView.this).cvy();
        AppMethodBeat.o(78068);
      }
      
      public final void gE(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void onSeekComplete(ITPPlayer paramAnonymousITPPlayer) {}
    });
    AppMethodBeat.o(78107);
  }
  
  private String getNetUnavailableTip()
  {
    AppMethodBeat.i(78082);
    Object localObject;
    if (this.WCH == 0)
    {
      localObject = getContext().getString(c.i.video_net_warnning_no_size);
      AppMethodBeat.o(78082);
      return localObject;
    }
    Context localContext = getContext();
    int i = c.i.video_net_warnning;
    long l = this.WCH;
    if (l < 0L) {
      localObject = "";
    }
    for (;;)
    {
      localObject = localContext.getString(i, new Object[] { localObject });
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
    LayoutInflater.from(paramContext).inflate(c.g.fts_web_video_container, this);
    this.WCs = ((FtsVideoWrapper)findViewById(c.f.video_view));
    this.szq = ((TextView)findViewById(c.f.progress));
    this.WCu = findViewById(c.f.tip_cover_area);
    this.WCv = findViewById(c.f.tips_container);
    this.szw = ((LinearLayout)findViewById(c.f.adjust_info_layout));
    this.WCw = ((WebSearchDotPercentIndicator)findViewById(c.f.adjust_percent_indicator));
    this.szy = ((TextView)findViewById(c.f.adjust_content));
    this.szz = ((ImageView)findViewById(c.f.adjust_icon));
    this.szA = ((ImageView)findViewById(c.f.cover));
    this.WCK = findViewById(c.f.video_loading);
    this.WCL = findViewById(c.f.tips_container_op);
    this.WCw.setDotsNum(8);
    this.TLs = ((ImageView)findViewById(c.f.cover_area_play_btn));
    this.WCx = findViewById(c.f.cover_replay);
    this.WCz = ((TextView)findViewById(c.f.tip_cover_cancel));
    this.WCy = ((Button)findViewById(c.f.tip_cover_paly));
    this.WCA = ((TextView)findViewById(c.f.tip_cover_warning));
    this.Wrv = ((ImageView)findViewById(c.f.exit_fullscreen_btn));
    this.WCz.setOnClickListener(new FtsWebVideoView.1(this));
    this.Wrv.setOnClickListener(new FtsWebVideoView.7(this));
    this.WCy.setOnClickListener(new FtsWebVideoView.8(this));
    this.WCx.setOnClickListener(new FtsWebVideoView.9(this));
    cuW();
    cuY();
    itl();
    paramContext.registerReceiver(this.WCN, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    iti();
    AppMethodBeat.o(78079);
  }
  
  private boolean isLive()
  {
    AppMethodBeat.i(78116);
    Log.i("MicroMsg.FtsWebVideoView", "isLive %b %b", new Object[] { Boolean.valueOf(this.szN), Boolean.valueOf(this.WCs.isLive()) });
    if ((this.szN) || (this.WCs.isLive()))
    {
      AppMethodBeat.o(78116);
      return true;
    }
    AppMethodBeat.o(78116);
    return false;
  }
  
  private void ith()
  {
    AppMethodBeat.i(78084);
    if (cuZ())
    {
      this.Wrv.setVisibility(0);
      AppMethodBeat.o(78084);
      return;
    }
    this.Wrv.setVisibility(8);
    AppMethodBeat.o(78084);
  }
  
  private void iti()
  {
    AppMethodBeat.i(78090);
    this.WCu.setVisibility(8);
    AppMethodBeat.o(78090);
  }
  
  private boolean itj()
  {
    AppMethodBeat.i(78110);
    if ((this.szH) && (!itk()))
    {
      AppMethodBeat.o(78110);
      return true;
    }
    AppMethodBeat.o(78110);
    return false;
  }
  
  private boolean itk()
  {
    AppMethodBeat.i(78111);
    if (this.WCu.getVisibility() == 0)
    {
      AppMethodBeat.o(78111);
      return true;
    }
    AppMethodBeat.o(78111);
    return false;
  }
  
  private void itl()
  {
    AppMethodBeat.i(78114);
    this.WCt = new WebSearchWebVideoViewControlBar(getContext());
    this.WCt.setVisibility(8);
    this.WCt.setEnterFullScreenBtnClickListener(new FtsWebVideoView.14(this));
    this.WCt.setExitFullScreenBtnClickListener(new FtsWebVideoView.2(this));
    this.WCt.setMuteBtnOnClickListener(new FtsWebVideoView.3(this));
    this.WCt.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void blc()
      {
        AppMethodBeat.i(78039);
        Log.i("MicroMsg.FtsWebVideoView", "onSeekPre");
        FtsWebVideoView.c(FtsWebVideoView.this).hON();
        AppMethodBeat.o(78039);
      }
      
      public final void tS(int paramAnonymousInt)
      {
        AppMethodBeat.i(78040);
        Log.i("MicroMsg.FtsWebVideoView", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        FtsWebVideoView.this.as(paramAnonymousInt, false);
        FtsWebVideoView.c(FtsWebVideoView.this).cvy();
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null) {
          FtsWebVideoView.h(FtsWebVideoView.this).itp();
        }
        AppMethodBeat.o(78040);
      }
      
      public final void tT(int paramAnonymousInt) {}
    });
    this.WCt.setOnPlayButtonClickListener(new FtsWebVideoView.5(this));
    this.WCt.setStatePorter(new WebSearchWebVideoViewControlBar.a()
    {
      public final int cvf()
      {
        AppMethodBeat.i(78042);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getCacheTimeSec();
        AppMethodBeat.o(78042);
        return i;
      }
      
      public final int cvg()
      {
        AppMethodBeat.i(78043);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getVideoDurationSec();
        AppMethodBeat.o(78043);
        return i;
      }
      
      public final int iqN()
      {
        AppMethodBeat.i(78044);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getCurrPosMs();
        AppMethodBeat.o(78044);
        return i;
      }
    });
    this.WCs.setVideoFooterView(this.WCt);
    AppMethodBeat.o(78114);
  }
  
  private boolean kN(final Context paramContext)
  {
    AppMethodBeat.i(78080);
    Object localObject = this.WCM;
    if (NetStatusUtil.isConnected(paramContext))
    {
      if ((!this.WCI) && (!NetStatusUtil.isWifi(paramContext)))
      {
        pause();
        this.WCM = FtsWebVideoView.c.WCU;
        this.WCt.setVisibility(8);
        localObject = getNetUnavailableTip();
        String str = paramContext.getString(c.i.video_continue_play);
        paramContext.getString(c.i.video_cancel);
        oh((String)localObject, str);
        AppMethodBeat.o(78080);
        return false;
      }
    }
    else
    {
      if (localObject == FtsWebVideoView.c.WCV)
      {
        this.WCK.setVisibility(0);
        this.WCL.setVisibility(8);
        this.WCu.setVisibility(0);
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
        kO(paramContext);
      }
    }
    AppMethodBeat.o(78080);
    return true;
  }
  
  private void kO(Context paramContext)
  {
    AppMethodBeat.i(78081);
    this.WCM = FtsWebVideoView.c.WCV;
    pause();
    oh(paramContext.getString(c.i.video_net_disable_warnning), paramContext.getString(c.i.video_retry_play));
    AppMethodBeat.o(78081);
  }
  
  private void oh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78083);
    iti();
    this.WCK.setVisibility(8);
    this.WCL.setVisibility(0);
    this.WCt.setVisibility(8);
    this.WCu.setVisibility(0);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.WCA.setText(paramString1);
      this.WCA.setVisibility(0);
      if (TextUtils.isEmpty(paramString2)) {
        break label139;
      }
      this.WCy.setText(paramString2);
      this.WCy.setVisibility(0);
    }
    for (;;)
    {
      this.WCv.setVisibility(0);
      this.WCx.setVisibility(8);
      this.WCz.setVisibility(8);
      ith();
      AppMethodBeat.o(78083);
      return;
      this.WCA.setVisibility(8);
      break;
      label139:
      this.WCy.setVisibility(8);
    }
  }
  
  private void setCover(String paramString)
  {
    AppMethodBeat.i(78097);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78097);
      return;
    }
    if (!Util.isNullOrNil(this.szP))
    {
      Log.i("MicroMsg.FtsWebVideoView", "setCover mCoverUrl not null");
      AppMethodBeat.o(78097);
      return;
    }
    AppMethodBeat.o(78097);
  }
  
  public final void Iv(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(78112);
    Log.i("MicroMsg.FtsWebVideoView", "operateFullScreen toFullScreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.WCD == null)
    {
      Log.w("MicroMsg.FtsWebVideoView", "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(78112);
      return;
    }
    if (paramBoolean == cuZ())
    {
      Log.i("MicroMsg.FtsWebVideoView", "operateFullScreen current same");
      AppMethodBeat.o(78112);
      return;
    }
    if (paramBoolean)
    {
      Object localObject = this.WCD;
      paramBoolean = bool;
      if (this.WCr != FtsWebVideoView.b.WCR) {
        paramBoolean = true;
      }
      ((a)localObject).Iw(paramBoolean);
      localObject = this.WCt;
      ((WebSearchWebVideoViewControlBar)localObject).sHM = true;
      ((WebSearchWebVideoViewControlBar)localObject).cxg();
      jH(true);
      AppMethodBeat.o(78112);
      return;
    }
    this.WCD.csz();
    this.WCt.csz();
    AppMethodBeat.o(78112);
  }
  
  public final void abL(String paramString)
  {
    AppMethodBeat.i(78096);
    Log.i("MicroMsg.FtsWebVideoView", "setCover coverUrl=%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78096);
      return;
    }
    this.szP = paramString;
    com.tencent.mm.modelappbrand.a.b.bEY().a(this.szA, paramString, null, null);
    AppMethodBeat.o(78096);
  }
  
  public final void as(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(78094);
    Log.i("MicroMsg.FtsWebVideoView", "seek to position=%d current=%d isLive=%b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.WCs.getCurrPosSec()), Boolean.valueOf(this.szN) });
    if (isLive())
    {
      AppMethodBeat.o(78094);
      return;
    }
    if (paramBoolean)
    {
      this.WCs.b(paramInt, paramBoolean);
      AppMethodBeat.o(78094);
      return;
    }
    this.WCs.G(paramInt);
    AppMethodBeat.o(78094);
  }
  
  public final boolean cuZ()
  {
    AppMethodBeat.i(78113);
    if (this.WCD == null)
    {
      Log.w("MicroMsg.FtsWebVideoView", "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(78113);
      return false;
    }
    boolean bool = this.WCD.isFullScreen();
    AppMethodBeat.o(78113);
    return bool;
  }
  
  public d getCallback()
  {
    return this.WCF;
  }
  
  public String getCookieData()
  {
    return this.szE;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(78101);
    int i = this.WCs.getCurrPosMs();
    AppMethodBeat.o(78101);
    return i;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(78100);
    int i = this.WCs.getCurrPosSec();
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
    return this.WCG;
  }
  
  public int getVideoSizeByte()
  {
    return this.WCH;
  }
  
  public int getmVideoPlayerId()
  {
    return this.szF;
  }
  
  public final void hQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(78093);
    Log.i("MicroMsg.FtsWebVideoView", "setVideoPath path=%s isLive=%s", new Object[] { paramString, Boolean.FALSE });
    this.url = paramString;
    if (Util.isNullOrNil(paramString))
    {
      Log.v("MicroMsg.FtsWebVideoView", "setVideoPath videoPath empty");
      AppMethodBeat.o(78093);
      return;
    }
    stop();
    this.szN = false;
    this.WCs.b(false, paramString, paramInt);
    if (this.WCt != null) {
      this.WCt.setVideoTotalTime(paramInt);
    }
    if (this.WCE > 0) {
      this.WCs.G(this.WCE);
    }
    if (this.eyT)
    {
      Log.i("MicroMsg.FtsWebVideoView", "setVideoPath autoPlay");
      start(false);
    }
    if (paramString.startsWith("wxfile://")) {
      setCover(paramString);
    }
    AppMethodBeat.o(78093);
  }
  
  public final void jH(boolean paramBoolean)
  {
    AppMethodBeat.i(78115);
    if (this.WCF == null)
    {
      AppMethodBeat.o(78115);
      return;
    }
    if (this.WCr == FtsWebVideoView.b.WCR) {}
    for (String str = "vertical";; str = "horizontal")
    {
      this.WCF.d(this.szF, paramBoolean, str);
      ith();
      AppMethodBeat.o(78115);
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78108);
    if ((this.szJ) || (cuZ()))
    {
      a locala;
      if (this.WCC != null)
      {
        locala = this.WCC;
        if (locala.WCk.cvk())
        {
          int i = paramMotionEvent.getActionMasked();
          if (i == 0)
          {
            locala.sIi = paramMotionEvent.getRawX();
            locala.dG = ((AudioManager)locala.mContext.getSystemService("audio")).getStreamVolume(3);
            locala.sxi = c.eN(locala.mContext);
          }
          GestureDetector localGestureDetector = locala.mQj;
          com.tencent.mm.hellhoundlib.b.a locala1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala1.aYi(), "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala1.sb(0)), "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          if ((i != 1) && (i != 3)) {
            break label258;
          }
          if (locala.WCj != a.a.WCp) {
            break label266;
          }
          locala.WCk.q(locala.sIk, paramMotionEvent.getRawX() - locala.sIi);
          locala.sIj = -1;
          locala.sIk = 0;
          locala.sIi = 0.0F;
        }
      }
      for (;;)
      {
        locala.WCj = a.a.WCm;
        label258:
        AppMethodBeat.o(78108);
        return true;
        label266:
        if (locala.WCj == a.a.WCn)
        {
          ((AudioManager)locala.mContext.getSystemService("audio")).getStreamMaxVolume(3);
          locala.WCk.cvl();
        }
        else if (locala.WCj == a.a.WCo)
        {
          locala.WCk.cvm();
        }
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (itj())) {
      this.WCt.Iq(this.isLoading);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(78108);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(78091);
    Log.i("MicroMsg.FtsWebVideoView", "pause");
    iti();
    if (!this.WCs.isPlaying())
    {
      AppMethodBeat.o(78091);
      return;
    }
    this.WCs.pause();
    AppMethodBeat.o(78091);
  }
  
  public void setAllowMobileNetPlay(boolean paramBoolean)
  {
    this.WCI = paramBoolean;
  }
  
  public void setAppId(String paramString)
  {
    AppMethodBeat.i(78085);
    Log.i("MicroMsg.FtsWebVideoView", "setAppId appid=%s", new Object[] { paramString });
    this.mAppId = paramString;
    AppMethodBeat.o(78085);
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(78086);
    Log.i("MicroMsg.FtsWebVideoView", "setAutoPlay =%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.eyT = paramBoolean;
    AppMethodBeat.o(78086);
  }
  
  public void setCallback(d paramd)
  {
    this.WCF = paramd;
  }
  
  public void setCookieData(String paramString)
  {
    this.szE = paramString;
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(78103);
    Log.i("MicroMsg.FtsWebVideoView", "setDisableScroll isDisableScroll=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.WCB = paramBoolean;
    AppMethodBeat.o(78103);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(78087);
    if (paramInt <= 0)
    {
      Log.i("MicroMsg.FtsWebVideoView", "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(78087);
      return;
    }
    AppMethodBeat.o(78087);
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.WCD = parama;
  }
  
  public void setFullScreenDirection(String paramString)
  {
    AppMethodBeat.i(78102);
    Log.i("MicroMsg.FtsWebVideoView", "setFullScreenDirection %s", new Object[] { paramString });
    if ("horizontal".equalsIgnoreCase(paramString))
    {
      this.WCr = FtsWebVideoView.b.WCQ;
      AppMethodBeat.o(78102);
      return;
    }
    if ("vertical".equalsIgnoreCase(paramString))
    {
      this.WCr = FtsWebVideoView.b.WCR;
      AppMethodBeat.o(78102);
      return;
    }
    this.WCr = FtsWebVideoView.b.WCP;
    AppMethodBeat.o(78102);
  }
  
  public void setInitialTime(int paramInt)
  {
    AppMethodBeat.i(78105);
    Log.i("MicroMsg.FtsWebVideoView", "setInitialTime initialTime=%d", new Object[] { Integer.valueOf(paramInt) });
    this.WCE = paramInt;
    AppMethodBeat.o(78105);
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(78095);
    Log.i("MicroMsg.FtsWebVideoView", "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.szH = paramBoolean;
    AppMethodBeat.o(78095);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(78088);
    Log.i("MicroMsg.FtsWebVideoView", "setLoop loop=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mLoop = paramBoolean;
    AppMethodBeat.o(78088);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(78099);
    Log.i("MicroMsg.FtsWebVideoView", "setMute isMute=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lAj = paramBoolean;
    this.WCs.setMute(paramBoolean);
    if (paramBoolean)
    {
      this.WCt.aSd();
      AppMethodBeat.o(78099);
      return;
    }
    this.WCt.iqM();
    AppMethodBeat.o(78099);
  }
  
  public void setObjectFit(String paramString)
  {
    AppMethodBeat.i(78098);
    Log.i("MicroMsg.FtsWebVideoView", "setObjectFit objectFit=%s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.WCs.setScaleType(i.e.XYL);
      this.szA.setScaleType(ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(78098);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.WCs.setScaleType(i.e.XYN);
      this.szA.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(78098);
      return;
    }
    this.WCs.setScaleType(i.e.XYM);
    this.szA.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(78098);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(78104);
    Log.i("MicroMsg.FtsWebVideoView", "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.szJ = paramBoolean;
    AppMethodBeat.o(78104);
  }
  
  public void setUiLifecycleListener(b.a parama)
  {
    this.WCG = parama;
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.szF = paramInt;
  }
  
  public void setVideoSizeByte(int paramInt)
  {
    this.WCH = paramInt;
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(78089);
    Log.i("MicroMsg.FtsWebVideoView", "start");
    iti();
    if ((paramBoolean) && (!kN(getContext())))
    {
      Log.i("MicroMsg.FtsWebVideoView", "start network is not wifi");
      AppMethodBeat.o(78089);
      return;
    }
    this.WCM = FtsWebVideoView.c.WCT;
    if (this.WCs.isPlaying())
    {
      AppMethodBeat.o(78089);
      return;
    }
    if (this.szH)
    {
      WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.WCt;
      if (localWebSearchWebVideoViewControlBar.sAc == null) {
        localWebSearchWebVideoViewControlBar.sAc = new MTimerHandler(new WebSearchWebVideoViewControlBar.2(localWebSearchWebVideoViewControlBar), true);
      }
      localWebSearchWebVideoViewControlBar.cxk();
      localWebSearchWebVideoViewControlBar.sAc.stopTimer();
      localWebSearchWebVideoViewControlBar.sAc.startTimer(500L);
    }
    this.WCs.start();
    if (this.WCJ == 0L)
    {
      this.WCJ = System.currentTimeMillis();
      AppMethodBeat.o(78089);
      return;
    }
    this.WCJ = 9223372036854775807L;
    AppMethodBeat.o(78089);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(78092);
    Log.i("MicroMsg.FtsWebVideoView", "stop");
    if (!this.WCs.isPlaying())
    {
      AppMethodBeat.o(78092);
      return;
    }
    this.WCs.stop();
    WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.WCt;
    if (localWebSearchWebVideoViewControlBar.sAc != null) {
      localWebSearchWebVideoViewControlBar.sAc.stopTimer();
    }
    AppMethodBeat.o(78092);
  }
  
  public static abstract interface a
  {
    public abstract void Iw(boolean paramBoolean);
    
    public abstract void csz();
    
    public abstract boolean isFullScreen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView
 * JD-Core Version:    0.7.0.1
 */