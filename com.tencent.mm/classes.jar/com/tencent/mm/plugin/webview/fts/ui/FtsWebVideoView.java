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
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public class FtsWebVideoView
  extends RelativeLayout
{
  private ImageView GlX;
  private ImageView IGW;
  private FtsWebVideoView.b IPW;
  public FtsVideoWrapper IPX;
  public WebSearchWebVideoViewControlBar IPY;
  private View IPZ;
  private View IQa;
  private WebSearchDotPercentIndicator IQb;
  private View IQc;
  private Button IQd;
  private TextView IQe;
  private TextView IQf;
  private boolean IQg;
  private a IQh;
  private a IQi;
  private d IQj;
  private b.a IQk;
  private int IQl;
  private boolean IQm;
  private long IQn;
  private View IQo;
  private View IQp;
  private FtsWebVideoView.c IQq;
  public BroadcastReceiver IQr;
  private boolean cEZ;
  public boolean guh;
  private boolean isLoading;
  private String mAppId;
  private boolean mLoop;
  private TextView mvK;
  private LinearLayout mvQ;
  private TextView mvS;
  private ImageView mvT;
  private ImageView mvU;
  private String mvY;
  private int mvZ;
  private boolean mwb;
  private boolean mwd;
  private boolean mwh;
  private String mwj;
  private int pOi;
  private String url;
  
  public FtsWebVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(78077);
    this.IPW = FtsWebVideoView.b.IQt;
    this.IQq = FtsWebVideoView.c.IQx;
    this.IQr = new BroadcastReceiver()
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
    this.IPW = FtsWebVideoView.b.IQt;
    this.IQq = FtsWebVideoView.c.IQx;
    this.IQr = new BroadcastReceiver()
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
    this.IPW = FtsWebVideoView.b.IQt;
    this.IQq = FtsWebVideoView.c.IQx;
    this.IQr = new BroadcastReceiver()
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
  
  private void bIY()
  {
    AppMethodBeat.i(78106);
    this.IQh = new a(getContext(), this, new a.b()
    {
      public final void aM(float paramAnonymousFloat)
      {
        AppMethodBeat.i(78057);
        Log.d("MicroMsg.FtsWebVideoView", "onAdjustVolume:".concat(String.valueOf(paramAnonymousFloat)));
        FtsWebVideoView.j(FtsWebVideoView.this).setPercent(paramAnonymousFloat);
        FtsWebVideoView.k(FtsWebVideoView.this).setText(2131761063);
        FtsWebVideoView.l(FtsWebVideoView.this).setImageResource(2131690371);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(0);
        AppMethodBeat.o(78057);
      }
      
      public final void aN(float paramAnonymousFloat)
      {
        AppMethodBeat.i(78058);
        Log.d("MicroMsg.FtsWebVideoView", "onAdjustBrightness:".concat(String.valueOf(paramAnonymousFloat)));
        FtsWebVideoView.j(FtsWebVideoView.this).setPercent(paramAnonymousFloat);
        FtsWebVideoView.k(FtsWebVideoView.this).setText(2131761060);
        FtsWebVideoView.l(FtsWebVideoView.this).setImageResource(2131690363);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(0);
        AppMethodBeat.o(78058);
      }
      
      public final void bJj()
      {
        AppMethodBeat.i(78050);
        Log.d("MicroMsg.FtsWebVideoView", "onSingleTap");
        if (FtsWebVideoView.e(FtsWebVideoView.this)) {
          FtsWebVideoView.c(FtsWebVideoView.this).yQ(FtsWebVideoView.f(FtsWebVideoView.this));
        }
        AppMethodBeat.o(78050);
      }
      
      public final void bJk()
      {
        AppMethodBeat.i(78051);
        Log.d("MicroMsg.FtsWebVideoView", "onDoubleTap");
        AppMethodBeat.o(78051);
      }
      
      public final void bJl()
      {
        AppMethodBeat.i(78052);
        if (FtsWebVideoView.d(FtsWebVideoView.this).isLive())
        {
          Log.i("MicroMsg.FtsWebVideoView", "onStartDragProgress isLive: no seek");
          AppMethodBeat.o(78052);
          return;
        }
        FtsWebVideoView.g(FtsWebVideoView.this).setVisibility(0);
        FtsWebVideoView.c(FtsWebVideoView.this).fzM();
        AppMethodBeat.o(78052);
      }
      
      public final void bJm()
      {
        AppMethodBeat.i(78059);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(8);
        AppMethodBeat.o(78059);
      }
      
      public final void bJn()
      {
        AppMethodBeat.i(78060);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(8);
        AppMethodBeat.o(78060);
      }
      
      public final boolean fyT()
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
      
      public final int k(int paramAnonymousInt, float paramAnonymousFloat)
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
          String str = c.AF(i * 1000L);
          FtsWebVideoView.g(FtsWebVideoView.this).setText(c.AF(paramAnonymousInt * 1000L) + "/" + str);
          AppMethodBeat.o(78053);
          return paramAnonymousInt;
          if (paramAnonymousInt > i) {
            paramAnonymousInt = i;
          }
        }
      }
      
      public final void l(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(78054);
        FtsWebVideoView.c(FtsWebVideoView.this).fzN();
        FtsWebVideoView.g(FtsWebVideoView.this).setVisibility(8);
        Log.i("MicroMsg.FtsWebVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(FtsWebVideoView.d(FtsWebVideoView.this).getCurrPosSec()), Float.valueOf(paramAnonymousFloat) });
        if (FtsWebVideoView.d(FtsWebVideoView.this).isLive())
        {
          Log.i("MicroMsg.FtsWebVideoView", "onEndDragProgress isLive: no seek");
          AppMethodBeat.o(78054);
          return;
        }
        FtsWebVideoView.this.ac(paramAnonymousInt, false);
        FtsWebVideoView.c(FtsWebVideoView.this).fzN();
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null) {
          FtsWebVideoView.h(FtsWebVideoView.this).gaP();
        }
        AppMethodBeat.o(78054);
      }
    });
    AppMethodBeat.o(78106);
  }
  
  private void bJa()
  {
    AppMethodBeat.i(78107);
    this.IPX.setIMMVideoViewCallback(new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(78061);
        Log.i("MicroMsg.FtsWebVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        h.CyF.a(14911, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), FtsWebVideoView.n(FtsWebVideoView.this), NetStatusUtil.getFormatedNetType(FtsWebVideoView.this.getContext()) });
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          Log.e("MicroMsg.JsApiVideoCallback", "onError what %d, extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          paramAnonymousString1.clean();
        }
        try
        {
          paramAnonymousString2 = new JSONObject();
          paramAnonymousString2.put("errCode", paramAnonymousInt1);
          paramAnonymousString2.put("errMsg", String.valueOf(paramAnonymousInt2));
          paramAnonymousString1.bY(paramAnonymousString1.b(7, paramAnonymousString2));
          FtsWebVideoView.this.pause();
          FtsWebVideoView.a(FtsWebVideoView.this, FtsWebVideoView.this.getContext().getString(2131767065, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), FtsWebVideoView.this.getContext().getString(2131767108));
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
        if (FtsWebVideoView.s(FtsWebVideoView.this) == FtsWebVideoView.b.IQt)
        {
          paramAnonymousString2 = FtsWebVideoView.this;
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label92;
          }
        }
        label92:
        for (paramAnonymousString1 = FtsWebVideoView.b.IQv;; paramAnonymousString1 = FtsWebVideoView.b.IQu)
        {
          FtsWebVideoView.a(paramAnonymousString2, paramAnonymousString1);
          Log.i("MicroMsg.FtsWebVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { FtsWebVideoView.s(FtsWebVideoView.this) });
          AppMethodBeat.o(78064);
          return;
        }
      }
      
      public final void dH(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78062);
        Log.i("MicroMsg.FtsWebVideoView", "onPrepared");
        paramAnonymousString1 = FtsWebVideoView.o(FtsWebVideoView.this);
        paramAnonymousString1.mDM = -1;
        paramAnonymousString1.mDN = 0;
        paramAnonymousString1.mDL = 0.0F;
        FtsWebVideoView.c(FtsWebVideoView.this).yQ(FtsWebVideoView.f(FtsWebVideoView.this));
        AppMethodBeat.o(78062);
      }
      
      public final void dI(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78063);
        Log.i("MicroMsg.FtsWebVideoView", "onVideoEnded");
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          Log.d("MicroMsg.JsApiVideoCallback", "onVideoEnded %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.bKw();
        }
        try
        {
          paramAnonymousString1.bY(paramAnonymousString1.b(3, null));
          if (FtsWebVideoView.p(FtsWebVideoView.this))
          {
            FtsWebVideoView.this.ac(0, true);
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
          FtsWebVideoView.this.ac(0, false);
          FtsWebVideoView.this.pause();
          FtsWebVideoView.q(FtsWebVideoView.this);
          FtsWebVideoView.r(FtsWebVideoView.this).setImageResource(2131232852);
          FtsWebVideoView.c(FtsWebVideoView.this).setVisibility(8);
          AppMethodBeat.o(78063);
        }
      }
      
      public final void dJ(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78065);
        Log.i("MicroMsg.FtsWebVideoView", "onVideoPause");
        if ((FtsWebVideoView.h(FtsWebVideoView.this) != null) && (FtsWebVideoView.h(FtsWebVideoView.this) != null))
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          Log.d("MicroMsg.JsApiVideoCallback", "onVideoPause %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.bKw();
          try
          {
            paramAnonymousString1.bY(paramAnonymousString1.b(2, null));
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
      
      public final void dK(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78066);
        Log.i("MicroMsg.FtsWebVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(FtsWebVideoView.t(FtsWebVideoView.this)) });
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          Log.d("MicroMsg.JsApiVideoCallback", "onVideoPlay %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.mAN = 0;
          if (paramAnonymousString1.mAM == null) {
            paramAnonymousString1.mAM = new MTimerHandler(new d.1(paramAnonymousString1), true);
          }
          paramAnonymousString1.mAM.startTimer(250L);
        }
        try
        {
          paramAnonymousString1.bY(paramAnonymousString1.b(1, null));
          if ((FtsWebVideoView.u(FtsWebVideoView.this) > 0L) && (FtsWebVideoView.u(FtsWebVideoView.this) != 9223372036854775807L))
          {
            long l = System.currentTimeMillis() - FtsWebVideoView.u(FtsWebVideoView.this);
            h.CyF.a(14909, new Object[] { Long.valueOf(l), Long.valueOf(System.currentTimeMillis()), Long.valueOf(l), NetStatusUtil.getFormatedNetType(FtsWebVideoView.this.getContext()), FtsWebVideoView.n(FtsWebVideoView.this) });
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
      
      public final void dL(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78067);
        Log.i("MicroMsg.FtsWebVideoView", "onVideoWaiting");
        FtsWebVideoView.c(FtsWebVideoView.this).fzM();
        FtsWebVideoView.a(FtsWebVideoView.this, true);
        AppMethodBeat.o(78067);
      }
      
      public final void dM(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78068);
        Log.i("MicroMsg.FtsWebVideoView", "onVideoWaitingEnd");
        FtsWebVideoView.a(FtsWebVideoView.this, false);
        FtsWebVideoView.c(FtsWebVideoView.this).fzN();
        FtsWebVideoView.c(FtsWebVideoView.this).bJB();
        AppMethodBeat.o(78068);
      }
      
      public final void fo(String paramAnonymousString1, String paramAnonymousString2) {}
    });
    AppMethodBeat.o(78107);
  }
  
  private void gaH()
  {
    AppMethodBeat.i(78084);
    if (bJb())
    {
      this.IGW.setVisibility(0);
      AppMethodBeat.o(78084);
      return;
    }
    this.IGW.setVisibility(8);
    AppMethodBeat.o(78084);
  }
  
  private void gaI()
  {
    AppMethodBeat.i(78090);
    this.IPZ.setVisibility(8);
    AppMethodBeat.o(78090);
  }
  
  private boolean gaJ()
  {
    AppMethodBeat.i(78110);
    if ((this.mwb) && (!gaK()))
    {
      AppMethodBeat.o(78110);
      return true;
    }
    AppMethodBeat.o(78110);
    return false;
  }
  
  private boolean gaK()
  {
    AppMethodBeat.i(78111);
    if (this.IPZ.getVisibility() == 0)
    {
      AppMethodBeat.o(78111);
      return true;
    }
    AppMethodBeat.o(78111);
    return false;
  }
  
  private void gaL()
  {
    AppMethodBeat.i(78114);
    this.IPY = new WebSearchWebVideoViewControlBar(getContext());
    this.IPY.setVisibility(8);
    this.IPY.setEnterFullScreenBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78069);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!FtsWebVideoView.this.bJb()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.yT(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78069);
          return;
        }
      }
    });
    this.IPY.setExitFullScreenBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78037);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!FtsWebVideoView.this.bJb()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.yT(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78037);
          return;
        }
      }
    });
    this.IPY.setMuteBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78038);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        FtsWebVideoView.v(FtsWebVideoView.this);
        FtsWebVideoView.c(FtsWebVideoView.this).bJB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78038);
      }
    });
    this.IPY.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aJq()
      {
        AppMethodBeat.i(78039);
        Log.i("MicroMsg.FtsWebVideoView", "onSeekPre");
        FtsWebVideoView.c(FtsWebVideoView.this).crH();
        AppMethodBeat.o(78039);
      }
      
      public final void rk(int paramAnonymousInt)
      {
        AppMethodBeat.i(78040);
        Log.i("MicroMsg.FtsWebVideoView", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        FtsWebVideoView.this.ac(paramAnonymousInt, false);
        FtsWebVideoView.c(FtsWebVideoView.this).bJB();
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null) {
          FtsWebVideoView.h(FtsWebVideoView.this).gaP();
        }
        AppMethodBeat.o(78040);
      }
    });
    this.IPY.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78041);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (FtsWebVideoView.d(FtsWebVideoView.this).isPlaying())
        {
          FtsWebVideoView.c(FtsWebVideoView.this).crH();
          FtsWebVideoView.this.pause();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78041);
          return;
          FtsWebVideoView.c(FtsWebVideoView.this).bJB();
          FtsWebVideoView.this.start(true);
        }
      }
    });
    this.IPY.setStatePorter(new WebSearchWebVideoViewControlBar.a()
    {
      public final int bJh()
      {
        AppMethodBeat.i(78042);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getCacheTimeSec();
        AppMethodBeat.o(78042);
        return i;
      }
      
      public final int bJi()
      {
        AppMethodBeat.i(78043);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getVideoDurationSec();
        AppMethodBeat.o(78043);
        return i;
      }
      
      public final int fYO()
      {
        AppMethodBeat.i(78044);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getCurrPosMs();
        AppMethodBeat.o(78044);
        return i;
      }
    });
    this.IPX.setVideoFooterView(this.IPY);
    AppMethodBeat.o(78114);
  }
  
  private String getNetUnavailableTip()
  {
    AppMethodBeat.i(78082);
    Object localObject;
    if (this.IQl == 0)
    {
      localObject = getContext().getString(2131767094);
      AppMethodBeat.o(78082);
      return localObject;
    }
    Context localContext = getContext();
    long l = this.IQl;
    if (l < 0L) {
      localObject = "";
    }
    for (;;)
    {
      localObject = localContext.getString(2131767093, new Object[] { localObject });
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
  
  private boolean hS(final Context paramContext)
  {
    AppMethodBeat.i(78080);
    Object localObject = this.IQq;
    if (NetStatusUtil.isConnected(paramContext))
    {
      if ((!this.IQm) && (!NetStatusUtil.isWifi(paramContext)))
      {
        pause();
        this.IQq = FtsWebVideoView.c.IQy;
        this.IPY.setVisibility(8);
        localObject = getNetUnavailableTip();
        String str = paramContext.getString(2131767051);
        paramContext.getString(2131767039);
        lS((String)localObject, str);
        AppMethodBeat.o(78080);
        return false;
      }
    }
    else
    {
      if (localObject == FtsWebVideoView.c.IQz)
      {
        this.IQo.setVisibility(0);
        this.IQp.setVisibility(8);
        this.IPZ.setVisibility(0);
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
        hT(paramContext);
      }
    }
    AppMethodBeat.o(78080);
    return true;
  }
  
  private void hT(Context paramContext)
  {
    AppMethodBeat.i(78081);
    this.IQq = FtsWebVideoView.c.IQz;
    pause();
    lS(paramContext.getString(2131767092), paramContext.getString(2131767108));
    AppMethodBeat.o(78081);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(78079);
    LayoutInflater.from(paramContext).inflate(2131494782, this);
    this.IPX = ((FtsVideoWrapper)findViewById(2131309841));
    this.mvK = ((TextView)findViewById(2131306281));
    this.IPZ = findViewById(2131309148);
    this.IQa = findViewById(2131309175);
    this.mvQ = ((LinearLayout)findViewById(2131296579));
    this.IQb = ((WebSearchDotPercentIndicator)findViewById(2131296580));
    this.mvS = ((TextView)findViewById(2131296576));
    this.mvT = ((ImageView)findViewById(2131296578));
    this.mvU = ((ImageView)findViewById(2131299277));
    this.IQo = findViewById(2131309778);
    this.IQp = findViewById(2131309176);
    this.IQb.setDotsNum(8);
    this.GlX = ((ImageView)findViewById(2131299280));
    this.IQc = findViewById(2131299294);
    this.IQe = ((TextView)findViewById(2131309149));
    this.IQd = ((Button)findViewById(2131309150));
    this.IQf = ((TextView)findViewById(2131309152));
    this.IGW = ((ImageView)findViewById(2131300227));
    this.IQe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78036);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        FtsWebVideoView.this.pause();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78036);
      }
    });
    this.IGW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78045);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!FtsWebVideoView.this.bJb()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.yT(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78045);
          return;
        }
      }
    });
    this.IQd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78046);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (FtsWebVideoView.a(FtsWebVideoView.this) == FtsWebVideoView.c.IQy) {
          FtsWebVideoView.b(FtsWebVideoView.this);
        }
        FtsWebVideoView.this.start(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78046);
      }
    });
    this.IQc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78047);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        FtsWebVideoView.this.start(true);
        FtsWebVideoView.c(FtsWebVideoView.this).bJB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78047);
      }
    });
    bIY();
    bJa();
    gaL();
    paramContext.registerReceiver(this.IQr, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    gaI();
    AppMethodBeat.o(78079);
  }
  
  private boolean isLive()
  {
    AppMethodBeat.i(78116);
    Log.i("MicroMsg.FtsWebVideoView", "isLive %b %b", new Object[] { Boolean.valueOf(this.mwh), Boolean.valueOf(this.IPX.isLive()) });
    if ((this.mwh) || (this.IPX.isLive()))
    {
      AppMethodBeat.o(78116);
      return true;
    }
    AppMethodBeat.o(78116);
    return false;
  }
  
  private void lS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78083);
    gaI();
    this.IQo.setVisibility(8);
    this.IQp.setVisibility(0);
    this.IPY.setVisibility(8);
    this.IPZ.setVisibility(0);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.IQf.setText(paramString1);
      this.IQf.setVisibility(0);
      if (TextUtils.isEmpty(paramString2)) {
        break label139;
      }
      this.IQd.setText(paramString2);
      this.IQd.setVisibility(0);
    }
    for (;;)
    {
      this.IQa.setVisibility(0);
      this.IQc.setVisibility(8);
      this.IQe.setVisibility(8);
      gaH();
      AppMethodBeat.o(78083);
      return;
      this.IQf.setVisibility(8);
      break;
      label139:
      this.IQd.setVisibility(8);
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
    if (!Util.isNullOrNil(this.mwj))
    {
      Log.i("MicroMsg.FtsWebVideoView", "setCover mCoverUrl not null");
      AppMethodBeat.o(78097);
      return;
    }
    AppMethodBeat.o(78097);
  }
  
  public final void ac(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(78094);
    Log.i("MicroMsg.FtsWebVideoView", "seek to position=%d current=%d isLive=%b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.IPX.getCurrPosSec()), Boolean.valueOf(this.mwh) });
    if (isLive())
    {
      AppMethodBeat.o(78094);
      return;
    }
    if (paramBoolean)
    {
      this.IPX.c(paramInt, paramBoolean);
      AppMethodBeat.o(78094);
      return;
    }
    this.IPX.p(paramInt);
    AppMethodBeat.o(78094);
  }
  
  public final boolean bJb()
  {
    AppMethodBeat.i(78113);
    if (this.IQi == null)
    {
      Log.w("MicroMsg.FtsWebVideoView", "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(78113);
      return false;
    }
    boolean bool = this.IQi.isFullScreen();
    AppMethodBeat.o(78113);
    return bool;
  }
  
  public final void cN(String paramString, int paramInt)
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
    this.mwh = false;
    this.IPX.c(false, paramString, paramInt);
    if (this.IPY != null) {
      this.IPY.setVideoTotalTime(paramInt);
    }
    if (this.pOi > 0) {
      this.IPX.p(this.pOi);
    }
    if (this.cEZ)
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
    return this.IQj;
  }
  
  public String getCookieData()
  {
    return this.mvY;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(78101);
    int i = this.IPX.getCurrPosMs();
    AppMethodBeat.o(78101);
    return i;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(78100);
    int i = this.IPX.getCurrPosSec();
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
    return this.IQk;
  }
  
  public int getVideoSizeByte()
  {
    return this.IQl;
  }
  
  public int getmVideoPlayerId()
  {
    return this.mvZ;
  }
  
  public final void hN(boolean paramBoolean)
  {
    AppMethodBeat.i(78115);
    if (this.IQj == null)
    {
      AppMethodBeat.o(78115);
      return;
    }
    if (this.IPW == FtsWebVideoView.b.IQv) {}
    for (String str = "vertical";; str = "horizontal")
    {
      this.IQj.d(this.mvZ, paramBoolean, str);
      gaH();
      AppMethodBeat.o(78115);
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78108);
    if ((this.mwd) || (bJb()))
    {
      a locala;
      if (this.IQh != null)
      {
        locala = this.IQh;
        if (locala.IPP.fyT())
        {
          int i = paramMotionEvent.getActionMasked();
          if (i == 0)
          {
            locala.mDL = paramMotionEvent.getRawX();
            locala.MQ = ((AudioManager)locala.mContext.getSystemService("audio")).getStreamVolume(3);
            locala.mue = c.dV(locala.mContext);
          }
          GestureDetector localGestureDetector = locala.mDJ;
          com.tencent.mm.hellhoundlib.b.a locala1 = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala1.axQ(), "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala1.pG(0)), "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          if ((i != 1) && (i != 3)) {
            break label258;
          }
          if (locala.IPO != a.a.IPU) {
            break label266;
          }
          locala.IPP.l(locala.mDN, paramMotionEvent.getRawX() - locala.mDL);
          locala.mDM = -1;
          locala.mDN = 0;
          locala.mDL = 0.0F;
        }
      }
      for (;;)
      {
        locala.IPO = a.a.IPR;
        label258:
        AppMethodBeat.o(78108);
        return true;
        label266:
        if (locala.IPO == a.a.IPS)
        {
          ((AudioManager)locala.mContext.getSystemService("audio")).getStreamMaxVolume(3);
          locala.IPP.bJm();
        }
        else if (locala.IPO == a.a.IPT)
        {
          locala.IPP.bJn();
        }
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (gaJ())) {
      this.IPY.yQ(this.isLoading);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(78108);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(78091);
    Log.i("MicroMsg.FtsWebVideoView", "pause");
    gaI();
    if (!this.IPX.isPlaying())
    {
      AppMethodBeat.o(78091);
      return;
    }
    this.IPX.pause();
    AppMethodBeat.o(78091);
  }
  
  public void setAllowMobileNetPlay(boolean paramBoolean)
  {
    this.IQm = paramBoolean;
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
    this.cEZ = paramBoolean;
    AppMethodBeat.o(78086);
  }
  
  public void setCallback(d paramd)
  {
    this.IQj = paramd;
  }
  
  public void setCookieData(String paramString)
  {
    this.mvY = paramString;
  }
  
  public final void setCover$16da05f7(String paramString)
  {
    AppMethodBeat.i(78096);
    Log.i("MicroMsg.FtsWebVideoView", "setCover coverUrl=%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78096);
      return;
    }
    this.mwj = paramString;
    com.tencent.mm.modelappbrand.a.b.aXY().a(this.mvU, paramString, null, null);
    AppMethodBeat.o(78096);
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(78103);
    Log.i("MicroMsg.FtsWebVideoView", "setDisableScroll isDisableScroll=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.IQg = paramBoolean;
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
    this.IQi = parama;
  }
  
  public void setFullScreenDirection(String paramString)
  {
    AppMethodBeat.i(78102);
    Log.i("MicroMsg.FtsWebVideoView", "setFullScreenDirection %s", new Object[] { paramString });
    if ("horizontal".equalsIgnoreCase(paramString))
    {
      this.IPW = FtsWebVideoView.b.IQu;
      AppMethodBeat.o(78102);
      return;
    }
    if ("vertical".equalsIgnoreCase(paramString))
    {
      this.IPW = FtsWebVideoView.b.IQv;
      AppMethodBeat.o(78102);
      return;
    }
    this.IPW = FtsWebVideoView.b.IQt;
    AppMethodBeat.o(78102);
  }
  
  public void setInitialTime(int paramInt)
  {
    AppMethodBeat.i(78105);
    Log.i("MicroMsg.FtsWebVideoView", "setInitialTime initialTime=%d", new Object[] { Integer.valueOf(paramInt) });
    this.pOi = paramInt;
    AppMethodBeat.o(78105);
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(78095);
    Log.i("MicroMsg.FtsWebVideoView", "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mwb = paramBoolean;
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
    this.guh = paramBoolean;
    this.IPX.setMute(paramBoolean);
    if (paramBoolean)
    {
      this.IPY.ard();
      AppMethodBeat.o(78099);
      return;
    }
    this.IPY.fYN();
    AppMethodBeat.o(78099);
  }
  
  public void setObjectFit(String paramString)
  {
    AppMethodBeat.i(78098);
    Log.i("MicroMsg.FtsWebVideoView", "setObjectFit objectFit=%s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.IPX.setScaleType(i.e.Kca);
      this.mvU.setScaleType(ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(78098);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.IPX.setScaleType(i.e.Kcc);
      this.mvU.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(78098);
      return;
    }
    this.IPX.setScaleType(i.e.Kcb);
    this.mvU.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(78098);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(78104);
    Log.i("MicroMsg.FtsWebVideoView", "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mwd = paramBoolean;
    AppMethodBeat.o(78104);
  }
  
  public void setUiLifecycleListener(b.a parama)
  {
    this.IQk = parama;
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.mvZ = paramInt;
  }
  
  public void setVideoSizeByte(int paramInt)
  {
    this.IQl = paramInt;
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(78089);
    Log.i("MicroMsg.FtsWebVideoView", "start");
    gaI();
    if ((paramBoolean) && (!hS(getContext())))
    {
      Log.i("MicroMsg.FtsWebVideoView", "start network is not wifi");
      AppMethodBeat.o(78089);
      return;
    }
    this.IQq = FtsWebVideoView.c.IQx;
    if (this.IPX.isPlaying())
    {
      AppMethodBeat.o(78089);
      return;
    }
    if (this.mwb)
    {
      WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.IPY;
      if (localWebSearchWebVideoViewControlBar.mww == null) {
        localWebSearchWebVideoViewControlBar.mww = new MTimerHandler(new WebSearchWebVideoViewControlBar.2(localWebSearchWebVideoViewControlBar), true);
      }
      localWebSearchWebVideoViewControlBar.bKX();
      localWebSearchWebVideoViewControlBar.mww.stopTimer();
      localWebSearchWebVideoViewControlBar.mww.startTimer(500L);
    }
    this.IPX.start();
    if (this.IQn == 0L)
    {
      this.IQn = System.currentTimeMillis();
      AppMethodBeat.o(78089);
      return;
    }
    this.IQn = 9223372036854775807L;
    AppMethodBeat.o(78089);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(78092);
    Log.i("MicroMsg.FtsWebVideoView", "stop");
    if (!this.IPX.isPlaying())
    {
      AppMethodBeat.o(78092);
      return;
    }
    this.IPX.stop();
    WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.IPY;
    if (localWebSearchWebVideoViewControlBar.mww != null) {
      localWebSearchWebVideoViewControlBar.mww.stopTimer();
    }
    AppMethodBeat.o(78092);
  }
  
  public final void yT(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(78112);
    Log.i("MicroMsg.FtsWebVideoView", "operateFullScreen toFullScreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.IQi == null)
    {
      Log.w("MicroMsg.FtsWebVideoView", "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(78112);
      return;
    }
    if (paramBoolean == bJb())
    {
      Log.i("MicroMsg.FtsWebVideoView", "operateFullScreen current same");
      AppMethodBeat.o(78112);
      return;
    }
    if (paramBoolean)
    {
      Object localObject = this.IQi;
      paramBoolean = bool;
      if (this.IPW != FtsWebVideoView.b.IQv) {
        paramBoolean = true;
      }
      ((a)localObject).yU(paramBoolean);
      localObject = this.IPY;
      ((WebSearchWebVideoViewControlBar)localObject).mDo = true;
      ((WebSearchWebVideoViewControlBar)localObject).bKT();
      hN(true);
      AppMethodBeat.o(78112);
      return;
    }
    this.IQi.bGL();
    this.IPY.bGL();
    AppMethodBeat.o(78112);
  }
  
  public static abstract interface a
  {
    public abstract void bGL();
    
    public abstract boolean isFullScreen();
    
    public abstract void yU(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView
 * JD-Core Version:    0.7.0.1
 */