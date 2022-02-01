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
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.c;
import com.tencent.mm.plugin.webview.fts.c.d;
import com.tencent.mm.plugin.webview.fts.c.d.1;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigDecimal;
import org.json.JSONException;

public class FtsWebVideoView
  extends RelativeLayout
{
  private ImageView MYJ;
  private ImageView PBk;
  private int PMA;
  private boolean PMB;
  private long PMC;
  private View PMD;
  private View PME;
  private FtsWebVideoView.c PMF;
  public BroadcastReceiver PMG;
  private FtsWebVideoView.b PMl;
  public FtsVideoWrapper PMm;
  public WebSearchWebVideoViewControlBar PMn;
  private View PMo;
  private View PMp;
  private WebSearchDotPercentIndicator PMq;
  private View PMr;
  private Button PMs;
  private TextView PMt;
  private TextView PMu;
  private boolean PMv;
  private a PMw;
  private a PMx;
  private d PMy;
  private b.a PMz;
  private boolean cFF;
  public boolean iYs;
  private boolean isLoading;
  private String mAppId;
  private boolean mLoop;
  private boolean puB;
  private boolean puD;
  private boolean puH;
  private String puJ;
  private TextView puk;
  private LinearLayout puq;
  private TextView pus;
  private ImageView put;
  private ImageView puu;
  private String puy;
  private int puz;
  private int sVf;
  private String url;
  
  public FtsWebVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(78077);
    this.PMl = FtsWebVideoView.b.PMI;
    this.PMF = FtsWebVideoView.c.PMM;
    this.PMG = new BroadcastReceiver()
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
    this.PMl = FtsWebVideoView.b.PMI;
    this.PMF = FtsWebVideoView.c.PMM;
    this.PMG = new BroadcastReceiver()
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
    this.PMl = FtsWebVideoView.b.PMI;
    this.PMF = FtsWebVideoView.c.PMM;
    this.PMG = new BroadcastReceiver()
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
  
  private void bUH()
  {
    AppMethodBeat.i(78106);
    this.PMw = new a(getContext(), this, new a.b()
    {
      public final void aM(float paramAnonymousFloat)
      {
        AppMethodBeat.i(78057);
        Log.d("MicroMsg.FtsWebVideoView", "onAdjustVolume:".concat(String.valueOf(paramAnonymousFloat)));
        FtsWebVideoView.j(FtsWebVideoView.this).setPercent(paramAnonymousFloat);
        FtsWebVideoView.k(FtsWebVideoView.this).setText(c.i.fts_web_video_volume);
        FtsWebVideoView.l(FtsWebVideoView.this).setImageResource(c.h.fts_web_video_volume_icon);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(0);
        AppMethodBeat.o(78057);
      }
      
      public final void aN(float paramAnonymousFloat)
      {
        AppMethodBeat.i(78058);
        Log.d("MicroMsg.FtsWebVideoView", "onAdjustBrightness:".concat(String.valueOf(paramAnonymousFloat)));
        FtsWebVideoView.j(FtsWebVideoView.this).setPercent(paramAnonymousFloat);
        FtsWebVideoView.k(FtsWebVideoView.this).setText(c.i.fts_web_video_brightness);
        FtsWebVideoView.l(FtsWebVideoView.this).setImageResource(c.h.fts_web_video_brightness_icon);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(0);
        AppMethodBeat.o(78058);
      }
      
      public final void bUS()
      {
        AppMethodBeat.i(78050);
        Log.d("MicroMsg.FtsWebVideoView", "onSingleTap");
        if (FtsWebVideoView.e(FtsWebVideoView.this)) {
          FtsWebVideoView.c(FtsWebVideoView.this).CL(FtsWebVideoView.f(FtsWebVideoView.this));
        }
        AppMethodBeat.o(78050);
      }
      
      public final void bUT()
      {
        AppMethodBeat.i(78051);
        Log.d("MicroMsg.FtsWebVideoView", "onDoubleTap");
        AppMethodBeat.o(78051);
      }
      
      public final void bUU()
      {
        AppMethodBeat.i(78052);
        if (FtsWebVideoView.d(FtsWebVideoView.this).isLive())
        {
          Log.i("MicroMsg.FtsWebVideoView", "onStartDragProgress isLive: no seek");
          AppMethodBeat.o(78052);
          return;
        }
        FtsWebVideoView.g(FtsWebVideoView.this).setVisibility(0);
        FtsWebVideoView.c(FtsWebVideoView.this).grN();
        AppMethodBeat.o(78052);
      }
      
      public final void bUV()
      {
        AppMethodBeat.i(78059);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(8);
        AppMethodBeat.o(78059);
      }
      
      public final void bUW()
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
      
      public final boolean gqQ()
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
      
      public final int l(int paramAnonymousInt, float paramAnonymousFloat)
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
          String str = c.GN(i * 1000L);
          FtsWebVideoView.g(FtsWebVideoView.this).setText(c.GN(paramAnonymousInt * 1000L) + "/" + str);
          AppMethodBeat.o(78053);
          return paramAnonymousInt;
          if (paramAnonymousInt > i) {
            paramAnonymousInt = i;
          }
        }
      }
      
      public final void m(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(78054);
        FtsWebVideoView.c(FtsWebVideoView.this).grO();
        FtsWebVideoView.g(FtsWebVideoView.this).setVisibility(8);
        Log.i("MicroMsg.FtsWebVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(FtsWebVideoView.d(FtsWebVideoView.this).getCurrPosSec()), Float.valueOf(paramAnonymousFloat) });
        if (FtsWebVideoView.d(FtsWebVideoView.this).isLive())
        {
          Log.i("MicroMsg.FtsWebVideoView", "onEndDragProgress isLive: no seek");
          AppMethodBeat.o(78054);
          return;
        }
        FtsWebVideoView.this.ab(paramAnonymousInt, false);
        FtsWebVideoView.c(FtsWebVideoView.this).grO();
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null) {
          FtsWebVideoView.h(FtsWebVideoView.this).gTH();
        }
        AppMethodBeat.o(78054);
      }
    });
    AppMethodBeat.o(78106);
  }
  
  private void bUJ()
  {
    AppMethodBeat.i(78107);
    this.PMm.setIMMVideoViewCallback(new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(78061);
        Log.i("MicroMsg.FtsWebVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        h.IzE.a(14911, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), FtsWebVideoView.n(FtsWebVideoView.this), NetStatusUtil.getFormatedNetType(FtsWebVideoView.this.getContext()) });
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          Log.e("MicroMsg.JsApiVideoCallback", "onError what %d, extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          paramAnonymousString1.clean();
        }
        try
        {
          paramAnonymousString1.cj(paramAnonymousString1.d(7, d.lw(paramAnonymousInt1, paramAnonymousInt2)));
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
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(78064);
        Log.i("MicroMsg.FtsWebVideoView", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (FtsWebVideoView.s(FtsWebVideoView.this) == FtsWebVideoView.b.PMI)
        {
          paramAnonymousString2 = FtsWebVideoView.this;
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label92;
          }
        }
        label92:
        for (paramAnonymousString1 = FtsWebVideoView.b.PMK;; paramAnonymousString1 = FtsWebVideoView.b.PMJ)
        {
          FtsWebVideoView.a(paramAnonymousString2, paramAnonymousString1);
          Log.i("MicroMsg.FtsWebVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { FtsWebVideoView.s(FtsWebVideoView.this) });
          AppMethodBeat.o(78064);
          return;
        }
      }
      
      public final void dS(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78062);
        Log.i("MicroMsg.FtsWebVideoView", "onPrepared");
        paramAnonymousString1 = FtsWebVideoView.o(FtsWebVideoView.this);
        paramAnonymousString1.pCX = -1;
        paramAnonymousString1.pCY = 0;
        paramAnonymousString1.pCW = 0.0F;
        FtsWebVideoView.c(FtsWebVideoView.this).CL(FtsWebVideoView.f(FtsWebVideoView.this));
        AppMethodBeat.o(78062);
      }
      
      public final void dT(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78063);
        Log.i("MicroMsg.FtsWebVideoView", "onVideoEnded");
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          Log.d("MicroMsg.JsApiVideoCallback", "onVideoEnded %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.bWh();
        }
        try
        {
          paramAnonymousString1.cj(paramAnonymousString1.d(3, null));
          if (FtsWebVideoView.p(FtsWebVideoView.this))
          {
            FtsWebVideoView.this.ab(0, true);
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
          FtsWebVideoView.this.ab(0, false);
          FtsWebVideoView.this.pause();
          FtsWebVideoView.q(FtsWebVideoView.this);
          FtsWebVideoView.r(FtsWebVideoView.this).setImageResource(c.e.fts_video_replay_btn);
          FtsWebVideoView.c(FtsWebVideoView.this).setVisibility(8);
          AppMethodBeat.o(78063);
        }
      }
      
      public final void dU(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78065);
        Log.i("MicroMsg.FtsWebVideoView", "onVideoPause");
        if ((FtsWebVideoView.h(FtsWebVideoView.this) != null) && (FtsWebVideoView.h(FtsWebVideoView.this) != null))
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          Log.d("MicroMsg.JsApiVideoCallback", "onVideoPause %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.bWh();
          try
          {
            paramAnonymousString1.cj(paramAnonymousString1.d(2, null));
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
      
      public final void dV(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78066);
        Log.i("MicroMsg.FtsWebVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(FtsWebVideoView.t(FtsWebVideoView.this)) });
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          Log.d("MicroMsg.JsApiVideoCallback", "onVideoPlay %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.pzj = 0;
          if (paramAnonymousString1.pzi == null) {
            paramAnonymousString1.pzi = new MTimerHandler(new d.1(paramAnonymousString1), true);
          }
          paramAnonymousString1.pzi.startTimer(250L);
        }
        try
        {
          paramAnonymousString1.cj(paramAnonymousString1.d(1, null));
          if ((FtsWebVideoView.u(FtsWebVideoView.this) > 0L) && (FtsWebVideoView.u(FtsWebVideoView.this) != 9223372036854775807L))
          {
            long l = System.currentTimeMillis() - FtsWebVideoView.u(FtsWebVideoView.this);
            h.IzE.a(14909, new Object[] { Long.valueOf(l), Long.valueOf(System.currentTimeMillis()), Long.valueOf(l), NetStatusUtil.getFormatedNetType(FtsWebVideoView.this.getContext()), FtsWebVideoView.n(FtsWebVideoView.this) });
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
      
      public final void dW(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78067);
        Log.i("MicroMsg.FtsWebVideoView", "onVideoWaiting");
        FtsWebVideoView.c(FtsWebVideoView.this).grN();
        FtsWebVideoView.a(FtsWebVideoView.this, true);
        AppMethodBeat.o(78067);
      }
      
      public final void dX(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78068);
        Log.i("MicroMsg.FtsWebVideoView", "onVideoWaitingEnd");
        FtsWebVideoView.a(FtsWebVideoView.this, false);
        FtsWebVideoView.c(FtsWebVideoView.this).grO();
        FtsWebVideoView.c(FtsWebVideoView.this).bVi();
        AppMethodBeat.o(78068);
      }
      
      public final void fC(String paramAnonymousString1, String paramAnonymousString2) {}
    });
    AppMethodBeat.o(78107);
  }
  
  private void gTA()
  {
    AppMethodBeat.i(78090);
    this.PMo.setVisibility(8);
    AppMethodBeat.o(78090);
  }
  
  private boolean gTB()
  {
    AppMethodBeat.i(78110);
    if ((this.puB) && (!gTC()))
    {
      AppMethodBeat.o(78110);
      return true;
    }
    AppMethodBeat.o(78110);
    return false;
  }
  
  private boolean gTC()
  {
    AppMethodBeat.i(78111);
    if (this.PMo.getVisibility() == 0)
    {
      AppMethodBeat.o(78111);
      return true;
    }
    AppMethodBeat.o(78111);
    return false;
  }
  
  private void gTD()
  {
    AppMethodBeat.i(78114);
    this.PMn = new WebSearchWebVideoViewControlBar(getContext());
    this.PMn.setVisibility(8);
    this.PMn.setEnterFullScreenBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78069);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (!FtsWebVideoView.this.bUK()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.CO(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78069);
          return;
        }
      }
    });
    this.PMn.setExitFullScreenBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78037);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (!FtsWebVideoView.this.bUK()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.CO(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78037);
          return;
        }
      }
    });
    this.PMn.setMuteBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78038);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        FtsWebVideoView.v(FtsWebVideoView.this);
        FtsWebVideoView.c(FtsWebVideoView.this).bVi();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78038);
      }
    });
    this.PMn.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aRo()
      {
        AppMethodBeat.i(78039);
        Log.i("MicroMsg.FtsWebVideoView", "onSeekPre");
        FtsWebVideoView.c(FtsWebVideoView.this).cEO();
        AppMethodBeat.o(78039);
      }
      
      public final void tY(int paramAnonymousInt)
      {
        AppMethodBeat.i(78040);
        Log.i("MicroMsg.FtsWebVideoView", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        FtsWebVideoView.this.ab(paramAnonymousInt, false);
        FtsWebVideoView.c(FtsWebVideoView.this).bVi();
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null) {
          FtsWebVideoView.h(FtsWebVideoView.this).gTH();
        }
        AppMethodBeat.o(78040);
      }
    });
    this.PMn.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78041);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (FtsWebVideoView.d(FtsWebVideoView.this).isPlaying())
        {
          FtsWebVideoView.c(FtsWebVideoView.this).cEO();
          FtsWebVideoView.this.pause();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78041);
          return;
          FtsWebVideoView.c(FtsWebVideoView.this).bVi();
          FtsWebVideoView.this.start(true);
        }
      }
    });
    this.PMn.setStatePorter(new WebSearchWebVideoViewControlBar.a()
    {
      public final int bUQ()
      {
        AppMethodBeat.i(78042);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getCacheTimeSec();
        AppMethodBeat.o(78042);
        return i;
      }
      
      public final int bUR()
      {
        AppMethodBeat.i(78043);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getVideoDurationSec();
        AppMethodBeat.o(78043);
        return i;
      }
      
      public final int gRz()
      {
        AppMethodBeat.i(78044);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getCurrPosMs();
        AppMethodBeat.o(78044);
        return i;
      }
    });
    this.PMm.setVideoFooterView(this.PMn);
    AppMethodBeat.o(78114);
  }
  
  private void gTz()
  {
    AppMethodBeat.i(78084);
    if (bUK())
    {
      this.PBk.setVisibility(0);
      AppMethodBeat.o(78084);
      return;
    }
    this.PBk.setVisibility(8);
    AppMethodBeat.o(78084);
  }
  
  private String getNetUnavailableTip()
  {
    AppMethodBeat.i(78082);
    Object localObject;
    if (this.PMA == 0)
    {
      localObject = getContext().getString(c.i.video_net_warnning_no_size);
      AppMethodBeat.o(78082);
      return localObject;
    }
    Context localContext = getContext();
    int i = c.i.video_net_warnning;
    long l = this.PMA;
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
  
  private boolean iX(final Context paramContext)
  {
    AppMethodBeat.i(78080);
    Object localObject = this.PMF;
    if (NetStatusUtil.isConnected(paramContext))
    {
      if ((!this.PMB) && (!NetStatusUtil.isWifi(paramContext)))
      {
        pause();
        this.PMF = FtsWebVideoView.c.PMN;
        this.PMn.setVisibility(8);
        localObject = getNetUnavailableTip();
        String str = paramContext.getString(c.i.video_continue_play);
        paramContext.getString(c.i.video_cancel);
        mt((String)localObject, str);
        AppMethodBeat.o(78080);
        return false;
      }
    }
    else
    {
      if (localObject == FtsWebVideoView.c.PMO)
      {
        this.PMD.setVisibility(0);
        this.PME.setVisibility(8);
        this.PMo.setVisibility(0);
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
        iY(paramContext);
      }
    }
    AppMethodBeat.o(78080);
    return true;
  }
  
  private void iY(Context paramContext)
  {
    AppMethodBeat.i(78081);
    this.PMF = FtsWebVideoView.c.PMO;
    pause();
    mt(paramContext.getString(c.i.video_net_disable_warnning), paramContext.getString(c.i.video_retry_play));
    AppMethodBeat.o(78081);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(78079);
    LayoutInflater.from(paramContext).inflate(c.g.fts_web_video_container, this);
    this.PMm = ((FtsVideoWrapper)findViewById(c.f.video_view));
    this.puk = ((TextView)findViewById(c.f.progress));
    this.PMo = findViewById(c.f.tip_cover_area);
    this.PMp = findViewById(c.f.tips_container);
    this.puq = ((LinearLayout)findViewById(c.f.adjust_info_layout));
    this.PMq = ((WebSearchDotPercentIndicator)findViewById(c.f.adjust_percent_indicator));
    this.pus = ((TextView)findViewById(c.f.adjust_content));
    this.put = ((ImageView)findViewById(c.f.adjust_icon));
    this.puu = ((ImageView)findViewById(c.f.cover));
    this.PMD = findViewById(c.f.video_loading);
    this.PME = findViewById(c.f.tips_container_op);
    this.PMq.setDotsNum(8);
    this.MYJ = ((ImageView)findViewById(c.f.cover_area_play_btn));
    this.PMr = findViewById(c.f.cover_replay);
    this.PMt = ((TextView)findViewById(c.f.tip_cover_cancel));
    this.PMs = ((Button)findViewById(c.f.tip_cover_paly));
    this.PMu = ((TextView)findViewById(c.f.tip_cover_warning));
    this.PBk = ((ImageView)findViewById(c.f.exit_fullscreen_btn));
    this.PMt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78036);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        FtsWebVideoView.this.pause();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78036);
      }
    });
    this.PBk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78045);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (!FtsWebVideoView.this.bUK()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.CO(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78045);
          return;
        }
      }
    });
    this.PMs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78046);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (FtsWebVideoView.a(FtsWebVideoView.this) == FtsWebVideoView.c.PMN) {
          FtsWebVideoView.b(FtsWebVideoView.this);
        }
        FtsWebVideoView.this.start(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78046);
      }
    });
    this.PMr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78047);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        FtsWebVideoView.this.start(true);
        FtsWebVideoView.c(FtsWebVideoView.this).bVi();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78047);
      }
    });
    bUH();
    bUJ();
    gTD();
    paramContext.registerReceiver(this.PMG, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    gTA();
    AppMethodBeat.o(78079);
  }
  
  private boolean isLive()
  {
    AppMethodBeat.i(78116);
    Log.i("MicroMsg.FtsWebVideoView", "isLive %b %b", new Object[] { Boolean.valueOf(this.puH), Boolean.valueOf(this.PMm.isLive()) });
    if ((this.puH) || (this.PMm.isLive()))
    {
      AppMethodBeat.o(78116);
      return true;
    }
    AppMethodBeat.o(78116);
    return false;
  }
  
  private void mt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78083);
    gTA();
    this.PMD.setVisibility(8);
    this.PME.setVisibility(0);
    this.PMn.setVisibility(8);
    this.PMo.setVisibility(0);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.PMu.setText(paramString1);
      this.PMu.setVisibility(0);
      if (TextUtils.isEmpty(paramString2)) {
        break label139;
      }
      this.PMs.setText(paramString2);
      this.PMs.setVisibility(0);
    }
    for (;;)
    {
      this.PMp.setVisibility(0);
      this.PMr.setVisibility(8);
      this.PMt.setVisibility(8);
      gTz();
      AppMethodBeat.o(78083);
      return;
      this.PMu.setVisibility(8);
      break;
      label139:
      this.PMs.setVisibility(8);
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
    if (!Util.isNullOrNil(this.puJ))
    {
      Log.i("MicroMsg.FtsWebVideoView", "setCover mCoverUrl not null");
      AppMethodBeat.o(78097);
      return;
    }
    AppMethodBeat.o(78097);
  }
  
  public final void CO(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(78112);
    Log.i("MicroMsg.FtsWebVideoView", "operateFullScreen toFullScreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.PMx == null)
    {
      Log.w("MicroMsg.FtsWebVideoView", "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(78112);
      return;
    }
    if (paramBoolean == bUK())
    {
      Log.i("MicroMsg.FtsWebVideoView", "operateFullScreen current same");
      AppMethodBeat.o(78112);
      return;
    }
    if (paramBoolean)
    {
      Object localObject = this.PMx;
      paramBoolean = bool;
      if (this.PMl != FtsWebVideoView.b.PMK) {
        paramBoolean = true;
      }
      ((a)localObject).CP(paramBoolean);
      localObject = this.PMn;
      ((WebSearchWebVideoViewControlBar)localObject).pCA = true;
      ((WebSearchWebVideoViewControlBar)localObject).bWT();
      iD(true);
      AppMethodBeat.o(78112);
      return;
    }
    this.PMx.bSs();
    this.PMn.bSs();
    AppMethodBeat.o(78112);
  }
  
  public final void ab(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(78094);
    Log.i("MicroMsg.FtsWebVideoView", "seek to position=%d current=%d isLive=%b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.PMm.getCurrPosSec()), Boolean.valueOf(this.puH) });
    if (isLive())
    {
      AppMethodBeat.o(78094);
      return;
    }
    if (paramBoolean)
    {
      this.PMm.a(paramInt, paramBoolean);
      AppMethodBeat.o(78094);
      return;
    }
    this.PMm.p(paramInt);
    AppMethodBeat.o(78094);
  }
  
  public final void aiL(String paramString)
  {
    AppMethodBeat.i(78096);
    Log.i("MicroMsg.FtsWebVideoView", "setCover coverUrl=%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78096);
      return;
    }
    this.puJ = paramString;
    com.tencent.mm.modelappbrand.a.b.bhh().a(this.puu, paramString, null, null);
    AppMethodBeat.o(78096);
  }
  
  public final boolean bUK()
  {
    AppMethodBeat.i(78113);
    if (this.PMx == null)
    {
      Log.w("MicroMsg.FtsWebVideoView", "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(78113);
      return false;
    }
    boolean bool = this.PMx.QT();
    AppMethodBeat.o(78113);
    return bool;
  }
  
  public final void dh(String paramString, int paramInt)
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
    this.puH = false;
    this.PMm.c(false, paramString, paramInt);
    if (this.PMn != null) {
      this.PMn.setVideoTotalTime(paramInt);
    }
    if (this.sVf > 0) {
      this.PMm.p(this.sVf);
    }
    if (this.cFF)
    {
      Log.i("MicroMsg.FtsWebVideoView", "setVideoPath autoPlay");
      start(false);
    }
    if (paramString.startsWith("wxfile://")) {
      setCover(paramString);
    }
    AppMethodBeat.o(78093);
  }
  
  public d getCallback()
  {
    return this.PMy;
  }
  
  public String getCookieData()
  {
    return this.puy;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(78101);
    int i = this.PMm.getCurrPosMs();
    AppMethodBeat.o(78101);
    return i;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(78100);
    int i = this.PMm.getCurrPosSec();
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
    return this.PMz;
  }
  
  public int getVideoSizeByte()
  {
    return this.PMA;
  }
  
  public int getmVideoPlayerId()
  {
    return this.puz;
  }
  
  public final void iD(boolean paramBoolean)
  {
    AppMethodBeat.i(78115);
    if (this.PMy == null)
    {
      AppMethodBeat.o(78115);
      return;
    }
    if (this.PMl == FtsWebVideoView.b.PMK) {}
    for (String str = "vertical";; str = "horizontal")
    {
      this.PMy.d(this.puz, paramBoolean, str);
      gTz();
      AppMethodBeat.o(78115);
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78108);
    if ((this.puD) || (bUK()))
    {
      a locala;
      if (this.PMw != null)
      {
        locala = this.PMw;
        if (locala.PMe.gqQ())
        {
          int i = paramMotionEvent.getActionMasked();
          if (i == 0)
          {
            locala.pCW = paramMotionEvent.getRawX();
            locala.dG = ((AudioManager)locala.mContext.getSystemService("audio")).getStreamVolume(3);
            locala.psp = c.dT(locala.mContext);
          }
          GestureDetector localGestureDetector = locala.pCU;
          com.tencent.mm.hellhoundlib.b.a locala1 = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala1.aFh(), "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala1.sf(0)), "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          if ((i != 1) && (i != 3)) {
            break label258;
          }
          if (locala.PMd != a.a.PMj) {
            break label266;
          }
          locala.PMe.m(locala.pCY, paramMotionEvent.getRawX() - locala.pCW);
          locala.pCX = -1;
          locala.pCY = 0;
          locala.pCW = 0.0F;
        }
      }
      for (;;)
      {
        locala.PMd = a.a.PMg;
        label258:
        AppMethodBeat.o(78108);
        return true;
        label266:
        if (locala.PMd == a.a.PMh)
        {
          ((AudioManager)locala.mContext.getSystemService("audio")).getStreamMaxVolume(3);
          locala.PMe.bUV();
        }
        else if (locala.PMd == a.a.PMi)
        {
          locala.PMe.bUW();
        }
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (gTB())) {
      this.PMn.CL(this.isLoading);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(78108);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(78091);
    Log.i("MicroMsg.FtsWebVideoView", "pause");
    gTA();
    if (!this.PMm.isPlaying())
    {
      AppMethodBeat.o(78091);
      return;
    }
    this.PMm.pause();
    AppMethodBeat.o(78091);
  }
  
  public void setAllowMobileNetPlay(boolean paramBoolean)
  {
    this.PMB = paramBoolean;
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
    this.cFF = paramBoolean;
    AppMethodBeat.o(78086);
  }
  
  public void setCallback(d paramd)
  {
    this.PMy = paramd;
  }
  
  public void setCookieData(String paramString)
  {
    this.puy = paramString;
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(78103);
    Log.i("MicroMsg.FtsWebVideoView", "setDisableScroll isDisableScroll=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.PMv = paramBoolean;
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
    this.PMx = parama;
  }
  
  public void setFullScreenDirection(String paramString)
  {
    AppMethodBeat.i(78102);
    Log.i("MicroMsg.FtsWebVideoView", "setFullScreenDirection %s", new Object[] { paramString });
    if ("horizontal".equalsIgnoreCase(paramString))
    {
      this.PMl = FtsWebVideoView.b.PMJ;
      AppMethodBeat.o(78102);
      return;
    }
    if ("vertical".equalsIgnoreCase(paramString))
    {
      this.PMl = FtsWebVideoView.b.PMK;
      AppMethodBeat.o(78102);
      return;
    }
    this.PMl = FtsWebVideoView.b.PMI;
    AppMethodBeat.o(78102);
  }
  
  public void setInitialTime(int paramInt)
  {
    AppMethodBeat.i(78105);
    Log.i("MicroMsg.FtsWebVideoView", "setInitialTime initialTime=%d", new Object[] { Integer.valueOf(paramInt) });
    this.sVf = paramInt;
    AppMethodBeat.o(78105);
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(78095);
    Log.i("MicroMsg.FtsWebVideoView", "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puB = paramBoolean;
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
    this.iYs = paramBoolean;
    this.PMm.setMute(paramBoolean);
    if (paramBoolean)
    {
      this.PMn.axB();
      AppMethodBeat.o(78099);
      return;
    }
    this.PMn.gRy();
    AppMethodBeat.o(78099);
  }
  
  public void setObjectFit(String paramString)
  {
    AppMethodBeat.i(78098);
    Log.i("MicroMsg.FtsWebVideoView", "setObjectFit objectFit=%s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.PMm.setScaleType(i.e.RcF);
      this.puu.setScaleType(ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(78098);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.PMm.setScaleType(i.e.RcH);
      this.puu.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(78098);
      return;
    }
    this.PMm.setScaleType(i.e.RcG);
    this.puu.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(78098);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(78104);
    Log.i("MicroMsg.FtsWebVideoView", "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puD = paramBoolean;
    AppMethodBeat.o(78104);
  }
  
  public void setUiLifecycleListener(b.a parama)
  {
    this.PMz = parama;
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.puz = paramInt;
  }
  
  public void setVideoSizeByte(int paramInt)
  {
    this.PMA = paramInt;
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(78089);
    Log.i("MicroMsg.FtsWebVideoView", "start");
    gTA();
    if ((paramBoolean) && (!iX(getContext())))
    {
      Log.i("MicroMsg.FtsWebVideoView", "start network is not wifi");
      AppMethodBeat.o(78089);
      return;
    }
    this.PMF = FtsWebVideoView.c.PMM;
    if (this.PMm.isPlaying())
    {
      AppMethodBeat.o(78089);
      return;
    }
    if (this.puB)
    {
      WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.PMn;
      if (localWebSearchWebVideoViewControlBar.puW == null) {
        localWebSearchWebVideoViewControlBar.puW = new MTimerHandler(new WebSearchWebVideoViewControlBar.2(localWebSearchWebVideoViewControlBar), true);
      }
      localWebSearchWebVideoViewControlBar.bWX();
      localWebSearchWebVideoViewControlBar.puW.stopTimer();
      localWebSearchWebVideoViewControlBar.puW.startTimer(500L);
    }
    this.PMm.start();
    if (this.PMC == 0L)
    {
      this.PMC = System.currentTimeMillis();
      AppMethodBeat.o(78089);
      return;
    }
    this.PMC = 9223372036854775807L;
    AppMethodBeat.o(78089);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(78092);
    Log.i("MicroMsg.FtsWebVideoView", "stop");
    if (!this.PMm.isPlaying())
    {
      AppMethodBeat.o(78092);
      return;
    }
    this.PMm.stop();
    WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.PMn;
    if (localWebSearchWebVideoViewControlBar.puW != null) {
      localWebSearchWebVideoViewControlBar.puW.stopTimer();
    }
    AppMethodBeat.o(78092);
  }
  
  public static abstract interface a
  {
    public abstract void CP(boolean paramBoolean);
    
    public abstract boolean QT();
    
    public abstract void bSs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView
 * JD-Core Version:    0.7.0.1
 */