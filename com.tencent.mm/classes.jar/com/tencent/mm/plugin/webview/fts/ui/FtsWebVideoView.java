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
import com.tencent.mm.plugin.report.service.g;
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
  private ImageView BtT;
  private ImageView DDr;
  public WebSearchWebVideoViewControlBar DLA;
  private View DLB;
  private View DLC;
  private WebSearchDotPercentIndicator DLD;
  private View DLE;
  private Button DLF;
  private TextView DLG;
  private TextView DLH;
  private boolean DLI;
  private a DLJ;
  private a DLK;
  private d DLL;
  private b.a DLM;
  private int DLN;
  private boolean DLO;
  private long DLP;
  private View DLQ;
  private View DLR;
  private FtsWebVideoView.c DLS;
  public BroadcastReceiver DLT;
  private FtsWebVideoView.b DLy;
  public FtsVideoWrapper DLz;
  private boolean csg;
  public boolean fMP;
  private boolean isLoading;
  private TextView lkG;
  private LinearLayout lkM;
  private TextView lkO;
  private ImageView lkP;
  private ImageView lkQ;
  private String lkU;
  private int lkV;
  private boolean lkX;
  private boolean lkZ;
  private boolean lld;
  private boolean lle;
  private String llg;
  private String mAppId;
  private int otW;
  private String url;
  
  public FtsWebVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(78077);
    this.DLy = FtsWebVideoView.b.DLV;
    this.DLS = FtsWebVideoView.c.DLZ;
    this.DLT = new BroadcastReceiver()
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
    this.DLy = FtsWebVideoView.b.DLV;
    this.DLS = FtsWebVideoView.c.DLZ;
    this.DLT = new BroadcastReceiver()
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
    this.DLy = FtsWebVideoView.b.DLV;
    this.DLS = FtsWebVideoView.c.DLZ;
    this.DLT = new BroadcastReceiver()
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
  
  private boolean bhH()
  {
    AppMethodBeat.i(78116);
    ad.i("MicroMsg.FtsWebVideoView", "isLive %b %b", new Object[] { Boolean.valueOf(this.lld), Boolean.valueOf(this.DLz.bhH()) });
    if ((this.lld) || (this.DLz.bhH()))
    {
      AppMethodBeat.o(78116);
      return true;
    }
    AppMethodBeat.o(78116);
    return false;
  }
  
  private void bmK()
  {
    AppMethodBeat.i(78106);
    this.DLJ = new a(getContext(), this, new a.b()
    {
      public final void aC(float paramAnonymousFloat)
      {
        AppMethodBeat.i(78057);
        ad.d("MicroMsg.FtsWebVideoView", "onAdjustVolume:".concat(String.valueOf(paramAnonymousFloat)));
        FtsWebVideoView.j(FtsWebVideoView.this).setPercent(paramAnonymousFloat);
        FtsWebVideoView.k(FtsWebVideoView.this).setText(2131759742);
        FtsWebVideoView.l(FtsWebVideoView.this).setImageResource(2131690275);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(0);
        AppMethodBeat.o(78057);
      }
      
      public final void aD(float paramAnonymousFloat)
      {
        AppMethodBeat.i(78058);
        ad.d("MicroMsg.FtsWebVideoView", "onAdjustBrightness:".concat(String.valueOf(paramAnonymousFloat)));
        FtsWebVideoView.j(FtsWebVideoView.this).setPercent(paramAnonymousFloat);
        FtsWebVideoView.k(FtsWebVideoView.this).setText(2131759739);
        FtsWebVideoView.l(FtsWebVideoView.this).setImageResource(2131690267);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(0);
        AppMethodBeat.o(78058);
      }
      
      public final void bmV()
      {
        AppMethodBeat.i(78050);
        ad.d("MicroMsg.FtsWebVideoView", "onSingleTap");
        if (FtsWebVideoView.e(FtsWebVideoView.this)) {
          FtsWebVideoView.c(FtsWebVideoView.this).uS(FtsWebVideoView.f(FtsWebVideoView.this));
        }
        AppMethodBeat.o(78050);
      }
      
      public final void bmW()
      {
        AppMethodBeat.i(78051);
        ad.d("MicroMsg.FtsWebVideoView", "onDoubleTap");
        AppMethodBeat.o(78051);
      }
      
      public final void bmX()
      {
        AppMethodBeat.i(78052);
        if (FtsWebVideoView.d(FtsWebVideoView.this).bhH())
        {
          ad.i("MicroMsg.FtsWebVideoView", "onStartDragProgress isLive: no seek");
          AppMethodBeat.o(78052);
          return;
        }
        FtsWebVideoView.g(FtsWebVideoView.this).setVisibility(0);
        FtsWebVideoView.c(FtsWebVideoView.this).eqK();
        AppMethodBeat.o(78052);
      }
      
      public final void bmY()
      {
        AppMethodBeat.i(78059);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(8);
        AppMethodBeat.o(78059);
      }
      
      public final void bmZ()
      {
        AppMethodBeat.i(78060);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(8);
        AppMethodBeat.o(78060);
      }
      
      public final boolean epQ()
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
        if (FtsWebVideoView.d(FtsWebVideoView.this).bhH())
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
          String str = c.sm(i * 1000L);
          FtsWebVideoView.g(FtsWebVideoView.this).setText(c.sm(paramAnonymousInt * 1000L) + "/" + str);
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
        FtsWebVideoView.c(FtsWebVideoView.this).eqL();
        FtsWebVideoView.g(FtsWebVideoView.this).setVisibility(8);
        ad.i("MicroMsg.FtsWebVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(FtsWebVideoView.d(FtsWebVideoView.this).getCurrPosSec()), Float.valueOf(paramAnonymousFloat) });
        if (FtsWebVideoView.d(FtsWebVideoView.this).bhH())
        {
          ad.i("MicroMsg.FtsWebVideoView", "onEndDragProgress isLive: no seek");
          AppMethodBeat.o(78054);
          return;
        }
        FtsWebVideoView.this.U(paramAnonymousInt, false);
        FtsWebVideoView.c(FtsWebVideoView.this).eqL();
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null) {
          FtsWebVideoView.h(FtsWebVideoView.this).eOs();
        }
        AppMethodBeat.o(78054);
      }
    });
    AppMethodBeat.o(78106);
  }
  
  private void bmM()
  {
    AppMethodBeat.i(78107);
    this.DLz.setIMMVideoViewCallback(new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(78061);
        ad.i("MicroMsg.FtsWebVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        g.yhR.f(14911, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), FtsWebVideoView.n(FtsWebVideoView.this), ay.iR(FtsWebVideoView.this.getContext()) });
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
          paramAnonymousString1.bz(paramAnonymousString1.a(7, paramAnonymousString2));
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
        if (FtsWebVideoView.s(FtsWebVideoView.this) == FtsWebVideoView.b.DLV)
        {
          paramAnonymousString2 = FtsWebVideoView.this;
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label92;
          }
        }
        label92:
        for (paramAnonymousString1 = FtsWebVideoView.b.DLX;; paramAnonymousString1 = FtsWebVideoView.b.DLW)
        {
          FtsWebVideoView.a(paramAnonymousString2, paramAnonymousString1);
          ad.i("MicroMsg.FtsWebVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { FtsWebVideoView.s(FtsWebVideoView.this) });
          AppMethodBeat.o(78064);
          return;
        }
      }
      
      public final void dq(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78062);
        ad.i("MicroMsg.FtsWebVideoView", "onPrepared");
        paramAnonymousString1 = FtsWebVideoView.o(FtsWebVideoView.this);
        paramAnonymousString1.lsq = -1;
        paramAnonymousString1.lsr = 0;
        paramAnonymousString1.lsp = 0.0F;
        FtsWebVideoView.c(FtsWebVideoView.this).uS(FtsWebVideoView.f(FtsWebVideoView.this));
        AppMethodBeat.o(78062);
      }
      
      public final void dr(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78063);
        ad.i("MicroMsg.FtsWebVideoView", "onVideoEnded");
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          ad.d("MicroMsg.JsApiVideoCallback", "onVideoEnded %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.boj();
        }
        try
        {
          paramAnonymousString1.bz(paramAnonymousString1.a(3, null));
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
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78065);
        ad.i("MicroMsg.FtsWebVideoView", "onVideoPause");
        if ((FtsWebVideoView.h(FtsWebVideoView.this) != null) && (FtsWebVideoView.h(FtsWebVideoView.this) != null))
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          ad.d("MicroMsg.JsApiVideoCallback", "onVideoPause %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.boj();
          try
          {
            paramAnonymousString1.bz(paramAnonymousString1.a(2, null));
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
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78066);
        ad.i("MicroMsg.FtsWebVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(FtsWebVideoView.t(FtsWebVideoView.this)) });
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          ad.d("MicroMsg.JsApiVideoCallback", "onVideoPlay %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.lpO = 0;
          if (paramAnonymousString1.lpN == null) {
            paramAnonymousString1.lpN = new av(new d.1(paramAnonymousString1), true);
          }
          paramAnonymousString1.lpN.az(250L, 250L);
        }
        try
        {
          paramAnonymousString1.bz(paramAnonymousString1.a(1, null));
          if ((FtsWebVideoView.u(FtsWebVideoView.this) > 0L) && (FtsWebVideoView.u(FtsWebVideoView.this) != 9223372036854775807L))
          {
            long l = System.currentTimeMillis() - FtsWebVideoView.u(FtsWebVideoView.this);
            g.yhR.f(14909, new Object[] { Long.valueOf(l), Long.valueOf(System.currentTimeMillis()), Long.valueOf(l), ay.iR(FtsWebVideoView.this.getContext()), FtsWebVideoView.n(FtsWebVideoView.this) });
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
      
      public final void du(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78067);
        ad.i("MicroMsg.FtsWebVideoView", "onVideoWaiting");
        FtsWebVideoView.c(FtsWebVideoView.this).eqK();
        FtsWebVideoView.a(FtsWebVideoView.this, true);
        AppMethodBeat.o(78067);
      }
      
      public final void dv(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78068);
        ad.i("MicroMsg.FtsWebVideoView", "onVideoWaitingEnd");
        FtsWebVideoView.a(FtsWebVideoView.this, false);
        FtsWebVideoView.c(FtsWebVideoView.this).eqL();
        FtsWebVideoView.c(FtsWebVideoView.this).bno();
        AppMethodBeat.o(78068);
      }
      
      public final void eT(String paramAnonymousString1, String paramAnonymousString2) {}
    });
    AppMethodBeat.o(78107);
  }
  
  private void eOk()
  {
    AppMethodBeat.i(78084);
    if (bmN())
    {
      this.DDr.setVisibility(0);
      AppMethodBeat.o(78084);
      return;
    }
    this.DDr.setVisibility(8);
    AppMethodBeat.o(78084);
  }
  
  private void eOl()
  {
    AppMethodBeat.i(78090);
    this.DLB.setVisibility(8);
    AppMethodBeat.o(78090);
  }
  
  private boolean eOm()
  {
    AppMethodBeat.i(78110);
    if ((this.lkX) && (!eOn()))
    {
      AppMethodBeat.o(78110);
      return true;
    }
    AppMethodBeat.o(78110);
    return false;
  }
  
  private boolean eOn()
  {
    AppMethodBeat.i(78111);
    if (this.DLB.getVisibility() == 0)
    {
      AppMethodBeat.o(78111);
      return true;
    }
    AppMethodBeat.o(78111);
    return false;
  }
  
  private void eOo()
  {
    AppMethodBeat.i(78114);
    this.DLA = new WebSearchWebVideoViewControlBar(getContext());
    this.DLA.setVisibility(8);
    this.DLA.setEnterFullScreenBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78069);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (!FtsWebVideoView.this.bmN()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.uU(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78069);
          return;
        }
      }
    });
    this.DLA.setExitFullScreenBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78037);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (!FtsWebVideoView.this.bmN()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.uU(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78037);
          return;
        }
      }
    });
    this.DLA.setMuteBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78038);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        FtsWebVideoView.v(FtsWebVideoView.this);
        FtsWebVideoView.c(FtsWebVideoView.this).bno();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78038);
      }
    });
    this.DLA.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqD()
      {
        AppMethodBeat.i(78039);
        ad.i("MicroMsg.FtsWebVideoView", "onSeekPre");
        FtsWebVideoView.c(FtsWebVideoView.this).bSH();
        AppMethodBeat.o(78039);
      }
      
      public final void nM(int paramAnonymousInt)
      {
        AppMethodBeat.i(78040);
        ad.i("MicroMsg.FtsWebVideoView", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        FtsWebVideoView.this.U(paramAnonymousInt, false);
        FtsWebVideoView.c(FtsWebVideoView.this).bno();
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null) {
          FtsWebVideoView.h(FtsWebVideoView.this).eOs();
        }
        AppMethodBeat.o(78040);
      }
    });
    this.DLA.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78041);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (FtsWebVideoView.d(FtsWebVideoView.this).isPlaying())
        {
          FtsWebVideoView.c(FtsWebVideoView.this).bSH();
          FtsWebVideoView.this.pause();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78041);
          return;
          FtsWebVideoView.c(FtsWebVideoView.this).bno();
          FtsWebVideoView.this.start(true);
        }
      }
    });
    this.DLA.setStatePorter(new WebSearchWebVideoViewControlBar.a()
    {
      public final int bmT()
      {
        AppMethodBeat.i(78042);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getCacheTimeSec();
        AppMethodBeat.o(78042);
        return i;
      }
      
      public final int bmU()
      {
        AppMethodBeat.i(78043);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getVideoDurationSec();
        AppMethodBeat.o(78043);
        return i;
      }
      
      public final int eMH()
      {
        AppMethodBeat.i(78044);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getCurrPosMs();
        AppMethodBeat.o(78044);
        return i;
      }
    });
    this.DLz.setVideoFooterView(this.DLA);
    AppMethodBeat.o(78114);
  }
  
  private boolean gR(final Context paramContext)
  {
    AppMethodBeat.i(78080);
    Object localObject = this.DLS;
    if (ay.isConnected(paramContext))
    {
      if ((!this.DLO) && (!ay.isWifi(paramContext)))
      {
        pause();
        this.DLS = FtsWebVideoView.c.DMa;
        this.DLA.setVisibility(8);
        localObject = getNetUnavailableTip();
        String str = paramContext.getString(2131764669);
        paramContext.getString(2131764666);
        kN((String)localObject, str);
        AppMethodBeat.o(78080);
        return false;
      }
    }
    else
    {
      if (localObject == FtsWebVideoView.c.DMb)
      {
        this.DLQ.setVisibility(0);
        this.DLR.setVisibility(8);
        this.DLB.setVisibility(0);
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
        gS(paramContext);
      }
    }
    AppMethodBeat.o(78080);
    return true;
  }
  
  private void gS(Context paramContext)
  {
    AppMethodBeat.i(78081);
    this.DLS = FtsWebVideoView.c.DMb;
    pause();
    kN(paramContext.getString(2131764685), paramContext.getString(2131764699));
    AppMethodBeat.o(78081);
  }
  
  private String getNetUnavailableTip()
  {
    AppMethodBeat.i(78082);
    Object localObject;
    if (this.DLN == 0)
    {
      localObject = getContext().getString(2131764687);
      AppMethodBeat.o(78082);
      return localObject;
    }
    Context localContext = getContext();
    long l = this.DLN;
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
    this.DLz = ((FtsVideoWrapper)findViewById(2131306410));
    this.lkG = ((TextView)findViewById(2131303515));
    this.DLB = findViewById(2131305866);
    this.DLC = findViewById(2131305891);
    this.lkM = ((LinearLayout)findViewById(2131296505));
    this.DLD = ((WebSearchDotPercentIndicator)findViewById(2131296506));
    this.lkO = ((TextView)findViewById(2131296502));
    this.lkP = ((ImageView)findViewById(2131296504));
    this.lkQ = ((ImageView)findViewById(2131298813));
    this.DLQ = findViewById(2131306352);
    this.DLR = findViewById(2131305892);
    this.DLD.setDotsNum(8);
    this.BtT = ((ImageView)findViewById(2131298815));
    this.DLE = findViewById(2131298829);
    this.DLG = ((TextView)findViewById(2131305867));
    this.DLF = ((Button)findViewById(2131305868));
    this.DLH = ((TextView)findViewById(2131305870));
    this.DDr = ((ImageView)findViewById(2131299599));
    this.DLG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78036);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        FtsWebVideoView.this.pause();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78036);
      }
    });
    this.DDr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78045);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (!FtsWebVideoView.this.bmN()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.uU(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78045);
          return;
        }
      }
    });
    this.DLF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78046);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (FtsWebVideoView.a(FtsWebVideoView.this) == FtsWebVideoView.c.DMa) {
          FtsWebVideoView.b(FtsWebVideoView.this);
        }
        FtsWebVideoView.this.start(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78046);
      }
    });
    this.DLE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78047);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        FtsWebVideoView.this.start(true);
        FtsWebVideoView.c(FtsWebVideoView.this).bno();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78047);
      }
    });
    bmK();
    bmM();
    eOo();
    paramContext.registerReceiver(this.DLT, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    eOl();
    AppMethodBeat.o(78079);
  }
  
  private void kN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78083);
    eOl();
    this.DLQ.setVisibility(8);
    this.DLR.setVisibility(0);
    this.DLA.setVisibility(8);
    this.DLB.setVisibility(0);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.DLH.setText(paramString1);
      this.DLH.setVisibility(0);
      if (TextUtils.isEmpty(paramString2)) {
        break label139;
      }
      this.DLF.setText(paramString2);
      this.DLF.setVisibility(0);
    }
    for (;;)
    {
      this.DLC.setVisibility(0);
      this.DLE.setVisibility(8);
      this.DLG.setVisibility(8);
      eOk();
      AppMethodBeat.o(78083);
      return;
      this.DLH.setVisibility(8);
      break;
      label139:
      this.DLF.setVisibility(8);
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
    if (!bt.isNullOrNil(this.llg))
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
    ad.i("MicroMsg.FtsWebVideoView", "seek to position=%d current=%d isLive=%b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.DLz.getCurrPosSec()), Boolean.valueOf(this.lld) });
    if (bhH())
    {
      AppMethodBeat.o(78094);
      return;
    }
    if (paramBoolean)
    {
      this.DLz.c(paramInt, paramBoolean);
      AppMethodBeat.o(78094);
      return;
    }
    this.DLz.o(paramInt);
    AppMethodBeat.o(78094);
  }
  
  public final boolean bmN()
  {
    AppMethodBeat.i(78113);
    if (this.DLK == null)
    {
      ad.w("MicroMsg.FtsWebVideoView", "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(78113);
      return false;
    }
    boolean bool = this.DLK.isFullScreen();
    AppMethodBeat.o(78113);
    return bool;
  }
  
  public final void cD(String paramString, int paramInt)
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
    this.lld = false;
    this.DLz.c(false, paramString, paramInt);
    if (this.DLA != null) {
      this.DLA.setVideoTotalTime(paramInt);
    }
    if (this.otW > 0) {
      this.DLz.o(this.otW);
    }
    if (this.csg)
    {
      ad.i("MicroMsg.FtsWebVideoView", "setVideoPath autoPlay");
      start(false);
    }
    if (paramString.startsWith("wxfile://")) {
      setCover(paramString);
    }
    AppMethodBeat.o(78093);
  }
  
  public final void gQ(boolean paramBoolean)
  {
    AppMethodBeat.i(78115);
    if (this.DLL == null)
    {
      AppMethodBeat.o(78115);
      return;
    }
    if (this.DLy == FtsWebVideoView.b.DLX) {}
    for (String str = "vertical";; str = "horizontal")
    {
      this.DLL.d(this.lkV, paramBoolean, str);
      eOk();
      AppMethodBeat.o(78115);
      return;
    }
  }
  
  public d getCallback()
  {
    return this.DLL;
  }
  
  public String getCookieData()
  {
    return this.lkU;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(78101);
    int i = this.DLz.getCurrPosMs();
    AppMethodBeat.o(78101);
    return i;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(78100);
    int i = this.DLz.getCurrPosSec();
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
    return this.DLM;
  }
  
  public int getVideoSizeByte()
  {
    return this.DLN;
  }
  
  public int getmVideoPlayerId()
  {
    return this.lkV;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78108);
    if ((this.lkZ) || (bmN()))
    {
      a locala;
      if (this.DLJ != null)
      {
        locala = this.DLJ;
        if (locala.DLr.epQ())
        {
          int i = paramMotionEvent.getActionMasked();
          if (i == 0)
          {
            locala.lsp = paramMotionEvent.getRawX();
            locala.MG = ((AudioManager)locala.mContext.getSystemService("audio")).getStreamVolume(3);
            locala.ljJ = c.dw(locala.mContext);
          }
          GestureDetector localGestureDetector = locala.lsn;
          com.tencent.mm.hellhoundlib.b.a locala1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala1.ahp(), "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala1.mq(0)), "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          if ((i != 1) && (i != 3)) {
            break label258;
          }
          if (locala.DLq != a.a.DLw) {
            break label266;
          }
          locala.DLr.l(locala.lsr, paramMotionEvent.getRawX() - locala.lsp);
          locala.lsq = -1;
          locala.lsr = 0;
          locala.lsp = 0.0F;
        }
      }
      for (;;)
      {
        locala.DLq = a.a.DLt;
        label258:
        AppMethodBeat.o(78108);
        return true;
        label266:
        if (locala.DLq == a.a.DLu)
        {
          ((AudioManager)locala.mContext.getSystemService("audio")).getStreamMaxVolume(3);
          locala.DLr.bmY();
        }
        else if (locala.DLq == a.a.DLv)
        {
          locala.DLr.bmZ();
        }
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (eOm())) {
      this.DLA.uS(this.isLoading);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(78108);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(78091);
    ad.i("MicroMsg.FtsWebVideoView", "pause");
    eOl();
    if (!this.DLz.isPlaying())
    {
      AppMethodBeat.o(78091);
      return;
    }
    this.DLz.pause();
    AppMethodBeat.o(78091);
  }
  
  public void setAllowMobileNetPlay(boolean paramBoolean)
  {
    this.DLO = paramBoolean;
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
    this.csg = paramBoolean;
    AppMethodBeat.o(78086);
  }
  
  public void setCallback(d paramd)
  {
    this.DLL = paramd;
  }
  
  public void setCookieData(String paramString)
  {
    this.lkU = paramString;
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
    this.llg = paramString;
    com.tencent.mm.modelappbrand.a.b.aDV().a(this.lkQ, paramString, null, null);
    AppMethodBeat.o(78096);
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(78103);
    ad.i("MicroMsg.FtsWebVideoView", "setDisableScroll isDisableScroll=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.DLI = paramBoolean;
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
    this.DLK = parama;
  }
  
  public void setFullScreenDirection(String paramString)
  {
    AppMethodBeat.i(78102);
    ad.i("MicroMsg.FtsWebVideoView", "setFullScreenDirection %s", new Object[] { paramString });
    if ("horizontal".equalsIgnoreCase(paramString))
    {
      this.DLy = FtsWebVideoView.b.DLW;
      AppMethodBeat.o(78102);
      return;
    }
    if ("vertical".equalsIgnoreCase(paramString))
    {
      this.DLy = FtsWebVideoView.b.DLX;
      AppMethodBeat.o(78102);
      return;
    }
    this.DLy = FtsWebVideoView.b.DLV;
    AppMethodBeat.o(78102);
  }
  
  public void setInitialTime(int paramInt)
  {
    AppMethodBeat.i(78105);
    ad.i("MicroMsg.FtsWebVideoView", "setInitialTime initialTime=%d", new Object[] { Integer.valueOf(paramInt) });
    this.otW = paramInt;
    AppMethodBeat.o(78105);
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(78095);
    ad.i("MicroMsg.FtsWebVideoView", "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lkX = paramBoolean;
    AppMethodBeat.o(78095);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(78088);
    ad.i("MicroMsg.FtsWebVideoView", "setLoop loop=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lle = paramBoolean;
    AppMethodBeat.o(78088);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(78099);
    ad.i("MicroMsg.FtsWebVideoView", "setMute isMute=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.fMP = paramBoolean;
    this.DLz.setMute(paramBoolean);
    if (paramBoolean)
    {
      this.DLA.acU();
      AppMethodBeat.o(78099);
      return;
    }
    this.DLA.eMG();
    AppMethodBeat.o(78099);
  }
  
  public void setObjectFit(String paramString)
  {
    AppMethodBeat.i(78098);
    ad.i("MicroMsg.FtsWebVideoView", "setObjectFit objectFit=%s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.DLz.setScaleType(i.e.ESN);
      this.lkQ.setScaleType(ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(78098);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.DLz.setScaleType(i.e.ESP);
      this.lkQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(78098);
      return;
    }
    this.DLz.setScaleType(i.e.ESO);
    this.lkQ.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(78098);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(78104);
    ad.i("MicroMsg.FtsWebVideoView", "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lkZ = paramBoolean;
    AppMethodBeat.o(78104);
  }
  
  public void setUiLifecycleListener(b.a parama)
  {
    this.DLM = parama;
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.lkV = paramInt;
  }
  
  public void setVideoSizeByte(int paramInt)
  {
    this.DLN = paramInt;
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(78089);
    ad.i("MicroMsg.FtsWebVideoView", "start");
    eOl();
    if ((paramBoolean) && (!gR(getContext())))
    {
      ad.i("MicroMsg.FtsWebVideoView", "start network is not wifi");
      AppMethodBeat.o(78089);
      return;
    }
    this.DLS = FtsWebVideoView.c.DLZ;
    if (this.DLz.isPlaying())
    {
      AppMethodBeat.o(78089);
      return;
    }
    if (this.lkX)
    {
      WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.DLA;
      if (localWebSearchWebVideoViewControlBar.llt == null) {
        localWebSearchWebVideoViewControlBar.llt = new av(new WebSearchWebVideoViewControlBar.2(localWebSearchWebVideoViewControlBar), true);
      }
      localWebSearchWebVideoViewControlBar.boH();
      localWebSearchWebVideoViewControlBar.llt.stopTimer();
      localWebSearchWebVideoViewControlBar.llt.az(500L, 500L);
    }
    this.DLz.start();
    if (this.DLP == 0L)
    {
      this.DLP = System.currentTimeMillis();
      AppMethodBeat.o(78089);
      return;
    }
    this.DLP = 9223372036854775807L;
    AppMethodBeat.o(78089);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(78092);
    ad.i("MicroMsg.FtsWebVideoView", "stop");
    if (!this.DLz.isPlaying())
    {
      AppMethodBeat.o(78092);
      return;
    }
    this.DLz.stop();
    WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.DLA;
    if (localWebSearchWebVideoViewControlBar.llt != null) {
      localWebSearchWebVideoViewControlBar.llt.stopTimer();
    }
    AppMethodBeat.o(78092);
  }
  
  public final void uU(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(78112);
    ad.i("MicroMsg.FtsWebVideoView", "operateFullScreen toFullScreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.DLK == null)
    {
      ad.w("MicroMsg.FtsWebVideoView", "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(78112);
      return;
    }
    if (paramBoolean == bmN())
    {
      ad.i("MicroMsg.FtsWebVideoView", "operateFullScreen current same");
      AppMethodBeat.o(78112);
      return;
    }
    if (paramBoolean)
    {
      Object localObject = this.DLK;
      paramBoolean = bool;
      if (this.DLy != FtsWebVideoView.b.DLX) {
        paramBoolean = true;
      }
      ((a)localObject).uV(paramBoolean);
      localObject = this.DLA;
      ((WebSearchWebVideoViewControlBar)localObject).lrS = true;
      ((WebSearchWebVideoViewControlBar)localObject).boD();
      gQ(true);
      AppMethodBeat.o(78112);
      return;
    }
    this.DLK.bkF();
    this.DLA.bkF();
    AppMethodBeat.o(78112);
  }
  
  public static abstract interface a
  {
    public abstract void bkF();
    
    public abstract boolean isFullScreen();
    
    public abstract void uV(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView
 * JD-Core Version:    0.7.0.1
 */