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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public class FtsWebVideoView
  extends RelativeLayout
{
  private ImageView BLr;
  private ImageView DVp;
  private View EdA;
  private WebSearchDotPercentIndicator EdB;
  private View EdC;
  private Button EdD;
  private TextView EdE;
  private TextView EdF;
  private boolean EdG;
  private a EdH;
  private a EdI;
  private d EdJ;
  private b.a EdK;
  private int EdL;
  private boolean EdM;
  private long EdN;
  private View EdO;
  private View EdP;
  private FtsWebVideoView.c EdQ;
  public BroadcastReceiver EdR;
  private FtsWebVideoView.b Edw;
  public FtsVideoWrapper Edx;
  public WebSearchWebVideoViewControlBar Edy;
  private View Edz;
  private boolean csJ;
  public boolean fOX;
  private boolean isLoading;
  private boolean lpB;
  private boolean lpC;
  private String lpE;
  private TextView lpe;
  private LinearLayout lpk;
  private TextView lpm;
  private ImageView lpn;
  private ImageView lpo;
  private String lps;
  private int lpt;
  private boolean lpv;
  private boolean lpx;
  private String mAppId;
  private int oAx;
  private String url;
  
  public FtsWebVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(78077);
    this.Edw = FtsWebVideoView.b.EdT;
    this.EdQ = FtsWebVideoView.c.EdX;
    this.EdR = new BroadcastReceiver()
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
    this.Edw = FtsWebVideoView.b.EdT;
    this.EdQ = FtsWebVideoView.c.EdX;
    this.EdR = new BroadcastReceiver()
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
    this.Edw = FtsWebVideoView.b.EdT;
    this.EdQ = FtsWebVideoView.c.EdX;
    this.EdR = new BroadcastReceiver()
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
  
  private boolean bip()
  {
    AppMethodBeat.i(78116);
    ae.i("MicroMsg.FtsWebVideoView", "isLive %b %b", new Object[] { Boolean.valueOf(this.lpB), Boolean.valueOf(this.Edx.bip()) });
    if ((this.lpB) || (this.Edx.bip()))
    {
      AppMethodBeat.o(78116);
      return true;
    }
    AppMethodBeat.o(78116);
    return false;
  }
  
  private void bnu()
  {
    AppMethodBeat.i(78106);
    this.EdH = new a(getContext(), this, new a.b()
    {
      public final void aC(float paramAnonymousFloat)
      {
        AppMethodBeat.i(78057);
        ae.d("MicroMsg.FtsWebVideoView", "onAdjustVolume:".concat(String.valueOf(paramAnonymousFloat)));
        FtsWebVideoView.j(FtsWebVideoView.this).setPercent(paramAnonymousFloat);
        FtsWebVideoView.k(FtsWebVideoView.this).setText(2131759742);
        FtsWebVideoView.l(FtsWebVideoView.this).setImageResource(2131690275);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(0);
        AppMethodBeat.o(78057);
      }
      
      public final void aD(float paramAnonymousFloat)
      {
        AppMethodBeat.i(78058);
        ae.d("MicroMsg.FtsWebVideoView", "onAdjustBrightness:".concat(String.valueOf(paramAnonymousFloat)));
        FtsWebVideoView.j(FtsWebVideoView.this).setPercent(paramAnonymousFloat);
        FtsWebVideoView.k(FtsWebVideoView.this).setText(2131759739);
        FtsWebVideoView.l(FtsWebVideoView.this).setImageResource(2131690267);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(0);
        AppMethodBeat.o(78058);
      }
      
      public final void bnF()
      {
        AppMethodBeat.i(78050);
        ae.d("MicroMsg.FtsWebVideoView", "onSingleTap");
        if (FtsWebVideoView.e(FtsWebVideoView.this)) {
          FtsWebVideoView.c(FtsWebVideoView.this).va(FtsWebVideoView.f(FtsWebVideoView.this));
        }
        AppMethodBeat.o(78050);
      }
      
      public final void bnG()
      {
        AppMethodBeat.i(78051);
        ae.d("MicroMsg.FtsWebVideoView", "onDoubleTap");
        AppMethodBeat.o(78051);
      }
      
      public final void bnH()
      {
        AppMethodBeat.i(78052);
        if (FtsWebVideoView.d(FtsWebVideoView.this).bip())
        {
          ae.i("MicroMsg.FtsWebVideoView", "onStartDragProgress isLive: no seek");
          AppMethodBeat.o(78052);
          return;
        }
        FtsWebVideoView.g(FtsWebVideoView.this).setVisibility(0);
        FtsWebVideoView.c(FtsWebVideoView.this).eur();
        AppMethodBeat.o(78052);
      }
      
      public final void bnI()
      {
        AppMethodBeat.i(78059);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(8);
        AppMethodBeat.o(78059);
      }
      
      public final void bnJ()
      {
        AppMethodBeat.i(78060);
        FtsWebVideoView.m(FtsWebVideoView.this).setVisibility(8);
        AppMethodBeat.o(78060);
      }
      
      public final boolean etx()
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
        if (FtsWebVideoView.d(FtsWebVideoView.this).bip())
        {
          ae.i("MicroMsg.FtsWebVideoView", "onDragProgress isLive: no seek");
          AppMethodBeat.o(78053);
          return 0;
        }
        ae.i("MicroMsg.FtsWebVideoView", "onDragProgress:" + paramAnonymousInt + "/" + paramAnonymousFloat);
        paramAnonymousFloat /= FtsWebVideoView.this.getMeasuredWidth();
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getVideoDurationSec();
        paramAnonymousInt = getCurrentPosition();
        paramAnonymousInt = (int)(paramAnonymousFloat * i) + paramAnonymousInt;
        if (paramAnonymousInt < 0) {
          paramAnonymousInt = j;
        }
        for (;;)
        {
          String str = c.sz(i * 1000L);
          FtsWebVideoView.g(FtsWebVideoView.this).setText(c.sz(paramAnonymousInt * 1000L) + "/" + str);
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
        FtsWebVideoView.c(FtsWebVideoView.this).eus();
        FtsWebVideoView.g(FtsWebVideoView.this).setVisibility(8);
        ae.i("MicroMsg.FtsWebVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(FtsWebVideoView.d(FtsWebVideoView.this).getCurrPosSec()), Float.valueOf(paramAnonymousFloat) });
        if (FtsWebVideoView.d(FtsWebVideoView.this).bip())
        {
          ae.i("MicroMsg.FtsWebVideoView", "onEndDragProgress isLive: no seek");
          AppMethodBeat.o(78054);
          return;
        }
        FtsWebVideoView.this.W(paramAnonymousInt, false);
        FtsWebVideoView.c(FtsWebVideoView.this).eus();
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null) {
          FtsWebVideoView.h(FtsWebVideoView.this).eSd();
        }
        AppMethodBeat.o(78054);
      }
    });
    AppMethodBeat.o(78106);
  }
  
  private void bnw()
  {
    AppMethodBeat.i(78107);
    this.Edx.setIMMVideoViewCallback(new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(78061);
        ae.i("MicroMsg.FtsWebVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        g.yxI.f(14911, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), FtsWebVideoView.n(FtsWebVideoView.this), az.iW(FtsWebVideoView.this.getContext()) });
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          ae.e("MicroMsg.JsApiVideoCallback", "onError what %d, extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
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
            ae.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
        }
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(78064);
        ae.i("MicroMsg.FtsWebVideoView", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (FtsWebVideoView.s(FtsWebVideoView.this) == FtsWebVideoView.b.EdT)
        {
          paramAnonymousString2 = FtsWebVideoView.this;
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label92;
          }
        }
        label92:
        for (paramAnonymousString1 = FtsWebVideoView.b.EdV;; paramAnonymousString1 = FtsWebVideoView.b.EdU)
        {
          FtsWebVideoView.a(paramAnonymousString2, paramAnonymousString1);
          ae.i("MicroMsg.FtsWebVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { FtsWebVideoView.s(FtsWebVideoView.this) });
          AppMethodBeat.o(78064);
          return;
        }
      }
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78062);
        ae.i("MicroMsg.FtsWebVideoView", "onPrepared");
        paramAnonymousString1 = FtsWebVideoView.o(FtsWebVideoView.this);
        paramAnonymousString1.lwP = -1;
        paramAnonymousString1.lwQ = 0;
        paramAnonymousString1.lwO = 0.0F;
        FtsWebVideoView.c(FtsWebVideoView.this).va(FtsWebVideoView.f(FtsWebVideoView.this));
        AppMethodBeat.o(78062);
      }
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78063);
        ae.i("MicroMsg.FtsWebVideoView", "onVideoEnded");
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          ae.d("MicroMsg.JsApiVideoCallback", "onVideoEnded %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.boT();
        }
        try
        {
          paramAnonymousString1.bz(paramAnonymousString1.a(3, null));
          if (FtsWebVideoView.p(FtsWebVideoView.this))
          {
            FtsWebVideoView.this.W(0, true);
            AppMethodBeat.o(78063);
            return;
          }
        }
        catch (JSONException paramAnonymousString1)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
          FtsWebVideoView.this.W(0, false);
          FtsWebVideoView.this.pause();
          FtsWebVideoView.q(FtsWebVideoView.this);
          FtsWebVideoView.r(FtsWebVideoView.this).setImageResource(2131232470);
          FtsWebVideoView.c(FtsWebVideoView.this).setVisibility(8);
          AppMethodBeat.o(78063);
        }
      }
      
      public final void du(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78065);
        ae.i("MicroMsg.FtsWebVideoView", "onVideoPause");
        if ((FtsWebVideoView.h(FtsWebVideoView.this) != null) && (FtsWebVideoView.h(FtsWebVideoView.this) != null))
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          ae.d("MicroMsg.JsApiVideoCallback", "onVideoPause %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.boT();
          try
          {
            paramAnonymousString1.bz(paramAnonymousString1.a(2, null));
            AppMethodBeat.o(78065);
            return;
          }
          catch (JSONException paramAnonymousString1)
          {
            ae.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
        }
        AppMethodBeat.o(78065);
      }
      
      public final void dv(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78066);
        ae.i("MicroMsg.FtsWebVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(FtsWebVideoView.t(FtsWebVideoView.this)) });
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null)
        {
          paramAnonymousString1 = FtsWebVideoView.h(FtsWebVideoView.this);
          ae.d("MicroMsg.JsApiVideoCallback", "onVideoPlay %s", new Object[] { paramAnonymousString1.toString() });
          paramAnonymousString1.lul = 0;
          if (paramAnonymousString1.luk == null) {
            paramAnonymousString1.luk = new aw(new d.1(paramAnonymousString1), true);
          }
          paramAnonymousString1.luk.ay(250L, 250L);
        }
        try
        {
          paramAnonymousString1.bz(paramAnonymousString1.a(1, null));
          if ((FtsWebVideoView.u(FtsWebVideoView.this) > 0L) && (FtsWebVideoView.u(FtsWebVideoView.this) != 9223372036854775807L))
          {
            long l = System.currentTimeMillis() - FtsWebVideoView.u(FtsWebVideoView.this);
            g.yxI.f(14909, new Object[] { Long.valueOf(l), Long.valueOf(System.currentTimeMillis()), Long.valueOf(l), az.iW(FtsWebVideoView.this.getContext()), FtsWebVideoView.n(FtsWebVideoView.this) });
          }
          AppMethodBeat.o(78066);
          return;
        }
        catch (JSONException paramAnonymousString1)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramAnonymousString1, null, new Object[0]);
          }
        }
      }
      
      public final void dw(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78067);
        ae.i("MicroMsg.FtsWebVideoView", "onVideoWaiting");
        FtsWebVideoView.c(FtsWebVideoView.this).eur();
        FtsWebVideoView.a(FtsWebVideoView.this, true);
        AppMethodBeat.o(78067);
      }
      
      public final void dx(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(78068);
        ae.i("MicroMsg.FtsWebVideoView", "onVideoWaitingEnd");
        FtsWebVideoView.a(FtsWebVideoView.this, false);
        FtsWebVideoView.c(FtsWebVideoView.this).eus();
        FtsWebVideoView.c(FtsWebVideoView.this).bnY();
        AppMethodBeat.o(78068);
      }
      
      public final void eX(String paramAnonymousString1, String paramAnonymousString2) {}
    });
    AppMethodBeat.o(78107);
  }
  
  private void eRV()
  {
    AppMethodBeat.i(78084);
    if (bnx())
    {
      this.DVp.setVisibility(0);
      AppMethodBeat.o(78084);
      return;
    }
    this.DVp.setVisibility(8);
    AppMethodBeat.o(78084);
  }
  
  private void eRW()
  {
    AppMethodBeat.i(78090);
    this.Edz.setVisibility(8);
    AppMethodBeat.o(78090);
  }
  
  private boolean eRX()
  {
    AppMethodBeat.i(78110);
    if ((this.lpv) && (!eRY()))
    {
      AppMethodBeat.o(78110);
      return true;
    }
    AppMethodBeat.o(78110);
    return false;
  }
  
  private boolean eRY()
  {
    AppMethodBeat.i(78111);
    if (this.Edz.getVisibility() == 0)
    {
      AppMethodBeat.o(78111);
      return true;
    }
    AppMethodBeat.o(78111);
    return false;
  }
  
  private void eRZ()
  {
    AppMethodBeat.i(78114);
    this.Edy = new WebSearchWebVideoViewControlBar(getContext());
    this.Edy.setVisibility(8);
    this.Edy.setEnterFullScreenBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78069);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!FtsWebVideoView.this.bnx()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.vc(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78069);
          return;
        }
      }
    });
    this.Edy.setExitFullScreenBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78037);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!FtsWebVideoView.this.bnx()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.vc(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78037);
          return;
        }
      }
    });
    this.Edy.setMuteBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78038);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        FtsWebVideoView.v(FtsWebVideoView.this);
        FtsWebVideoView.c(FtsWebVideoView.this).bnY();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78038);
      }
    });
    this.Edy.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqS()
      {
        AppMethodBeat.i(78039);
        ae.i("MicroMsg.FtsWebVideoView", "onSeekPre");
        FtsWebVideoView.c(FtsWebVideoView.this).bTU();
        AppMethodBeat.o(78039);
      }
      
      public final void nP(int paramAnonymousInt)
      {
        AppMethodBeat.i(78040);
        ae.i("MicroMsg.FtsWebVideoView", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        FtsWebVideoView.this.W(paramAnonymousInt, false);
        FtsWebVideoView.c(FtsWebVideoView.this).bnY();
        if (FtsWebVideoView.h(FtsWebVideoView.this) != null) {
          FtsWebVideoView.h(FtsWebVideoView.this).eSd();
        }
        AppMethodBeat.o(78040);
      }
    });
    this.Edy.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78041);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (FtsWebVideoView.d(FtsWebVideoView.this).isPlaying())
        {
          FtsWebVideoView.c(FtsWebVideoView.this).bTU();
          FtsWebVideoView.this.pause();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78041);
          return;
          FtsWebVideoView.c(FtsWebVideoView.this).bnY();
          FtsWebVideoView.this.start(true);
        }
      }
    });
    this.Edy.setStatePorter(new WebSearchWebVideoViewControlBar.a()
    {
      public final int bnD()
      {
        AppMethodBeat.i(78042);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getCacheTimeSec();
        AppMethodBeat.o(78042);
        return i;
      }
      
      public final int bnE()
      {
        AppMethodBeat.i(78043);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getVideoDurationSec();
        AppMethodBeat.o(78043);
        return i;
      }
      
      public final int eQs()
      {
        AppMethodBeat.i(78044);
        int i = FtsWebVideoView.d(FtsWebVideoView.this).getCurrPosMs();
        AppMethodBeat.o(78044);
        return i;
      }
    });
    this.Edx.setVideoFooterView(this.Edy);
    AppMethodBeat.o(78114);
  }
  
  private boolean gW(final Context paramContext)
  {
    AppMethodBeat.i(78080);
    Object localObject = this.EdQ;
    if (az.isConnected(paramContext))
    {
      if ((!this.EdM) && (!az.isWifi(paramContext)))
      {
        pause();
        this.EdQ = FtsWebVideoView.c.EdY;
        this.Edy.setVisibility(8);
        localObject = getNetUnavailableTip();
        String str = paramContext.getString(2131764669);
        paramContext.getString(2131764666);
        kU((String)localObject, str);
        AppMethodBeat.o(78080);
        return false;
      }
    }
    else
    {
      if (localObject == FtsWebVideoView.c.EdZ)
      {
        this.EdO.setVisibility(0);
        this.EdP.setVisibility(8);
        this.Edz.setVisibility(0);
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
        gX(paramContext);
      }
    }
    AppMethodBeat.o(78080);
    return true;
  }
  
  private void gX(Context paramContext)
  {
    AppMethodBeat.i(78081);
    this.EdQ = FtsWebVideoView.c.EdZ;
    pause();
    kU(paramContext.getString(2131764685), paramContext.getString(2131764699));
    AppMethodBeat.o(78081);
  }
  
  private String getNetUnavailableTip()
  {
    AppMethodBeat.i(78082);
    Object localObject;
    if (this.EdL == 0)
    {
      localObject = getContext().getString(2131764687);
      AppMethodBeat.o(78082);
      return localObject;
    }
    Context localContext = getContext();
    long l = this.EdL;
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
    this.Edx = ((FtsVideoWrapper)findViewById(2131306410));
    this.lpe = ((TextView)findViewById(2131303515));
    this.Edz = findViewById(2131305866);
    this.EdA = findViewById(2131305891);
    this.lpk = ((LinearLayout)findViewById(2131296505));
    this.EdB = ((WebSearchDotPercentIndicator)findViewById(2131296506));
    this.lpm = ((TextView)findViewById(2131296502));
    this.lpn = ((ImageView)findViewById(2131296504));
    this.lpo = ((ImageView)findViewById(2131298813));
    this.EdO = findViewById(2131306352);
    this.EdP = findViewById(2131305892);
    this.EdB.setDotsNum(8);
    this.BLr = ((ImageView)findViewById(2131298815));
    this.EdC = findViewById(2131298829);
    this.EdE = ((TextView)findViewById(2131305867));
    this.EdD = ((Button)findViewById(2131305868));
    this.EdF = ((TextView)findViewById(2131305870));
    this.DVp = ((ImageView)findViewById(2131299599));
    this.EdE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78036);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        FtsWebVideoView.this.pause();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78036);
      }
    });
    this.DVp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78045);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!FtsWebVideoView.this.bnx()) {}
        for (boolean bool = true;; bool = false)
        {
          FtsWebVideoView.this.vc(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78045);
          return;
        }
      }
    });
    this.EdD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78046);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (FtsWebVideoView.a(FtsWebVideoView.this) == FtsWebVideoView.c.EdY) {
          FtsWebVideoView.b(FtsWebVideoView.this);
        }
        FtsWebVideoView.this.start(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78046);
      }
    });
    this.EdC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78047);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        FtsWebVideoView.this.start(true);
        FtsWebVideoView.c(FtsWebVideoView.this).bnY();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78047);
      }
    });
    bnu();
    bnw();
    eRZ();
    paramContext.registerReceiver(this.EdR, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    eRW();
    AppMethodBeat.o(78079);
  }
  
  private void kU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78083);
    eRW();
    this.EdO.setVisibility(8);
    this.EdP.setVisibility(0);
    this.Edy.setVisibility(8);
    this.Edz.setVisibility(0);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.EdF.setText(paramString1);
      this.EdF.setVisibility(0);
      if (TextUtils.isEmpty(paramString2)) {
        break label139;
      }
      this.EdD.setText(paramString2);
      this.EdD.setVisibility(0);
    }
    for (;;)
    {
      this.EdA.setVisibility(0);
      this.EdC.setVisibility(8);
      this.EdE.setVisibility(8);
      eRV();
      AppMethodBeat.o(78083);
      return;
      this.EdF.setVisibility(8);
      break;
      label139:
      this.EdD.setVisibility(8);
    }
  }
  
  private void setCover(String paramString)
  {
    AppMethodBeat.i(78097);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78097);
      return;
    }
    if (!bu.isNullOrNil(this.lpE))
    {
      ae.i("MicroMsg.FtsWebVideoView", "setCover mCoverUrl not null");
      AppMethodBeat.o(78097);
      return;
    }
    AppMethodBeat.o(78097);
  }
  
  public final void W(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(78094);
    ae.i("MicroMsg.FtsWebVideoView", "seek to position=%d current=%d isLive=%b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Edx.getCurrPosSec()), Boolean.valueOf(this.lpB) });
    if (bip())
    {
      AppMethodBeat.o(78094);
      return;
    }
    if (paramBoolean)
    {
      this.Edx.c(paramInt, paramBoolean);
      AppMethodBeat.o(78094);
      return;
    }
    this.Edx.o(paramInt);
    AppMethodBeat.o(78094);
  }
  
  public final boolean bnx()
  {
    AppMethodBeat.i(78113);
    if (this.EdI == null)
    {
      ae.w("MicroMsg.FtsWebVideoView", "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(78113);
      return false;
    }
    boolean bool = this.EdI.isFullScreen();
    AppMethodBeat.o(78113);
    return bool;
  }
  
  public final void cH(String paramString, int paramInt)
  {
    AppMethodBeat.i(78093);
    ae.i("MicroMsg.FtsWebVideoView", "setVideoPath path=%s isLive=%s", new Object[] { paramString, Boolean.FALSE });
    this.url = paramString;
    if (bu.isNullOrNil(paramString))
    {
      ae.v("MicroMsg.FtsWebVideoView", "setVideoPath videoPath empty");
      AppMethodBeat.o(78093);
      return;
    }
    stop();
    this.lpB = false;
    this.Edx.c(false, paramString, paramInt);
    if (this.Edy != null) {
      this.Edy.setVideoTotalTime(paramInt);
    }
    if (this.oAx > 0) {
      this.Edx.o(this.oAx);
    }
    if (this.csJ)
    {
      ae.i("MicroMsg.FtsWebVideoView", "setVideoPath autoPlay");
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
    if (this.EdJ == null)
    {
      AppMethodBeat.o(78115);
      return;
    }
    if (this.Edw == FtsWebVideoView.b.EdV) {}
    for (String str = "vertical";; str = "horizontal")
    {
      this.EdJ.d(this.lpt, paramBoolean, str);
      eRV();
      AppMethodBeat.o(78115);
      return;
    }
  }
  
  public d getCallback()
  {
    return this.EdJ;
  }
  
  public String getCookieData()
  {
    return this.lps;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(78101);
    int i = this.Edx.getCurrPosMs();
    AppMethodBeat.o(78101);
    return i;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(78100);
    int i = this.Edx.getCurrPosSec();
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
    return this.EdK;
  }
  
  public int getVideoSizeByte()
  {
    return this.EdL;
  }
  
  public int getmVideoPlayerId()
  {
    return this.lpt;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(78108);
    if ((this.lpx) || (bnx()))
    {
      a locala;
      if (this.EdH != null)
      {
        locala = this.EdH;
        if (locala.Edp.etx())
        {
          int i = paramMotionEvent.getActionMasked();
          if (i == 0)
          {
            locala.lwO = paramMotionEvent.getRawX();
            locala.MG = ((AudioManager)locala.mContext.getSystemService("audio")).getStreamVolume(3);
            locala.lnw = c.dA(locala.mContext);
          }
          GestureDetector localGestureDetector = locala.lwM;
          com.tencent.mm.hellhoundlib.b.a locala1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala1.ahE(), "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala1.mt(0)), "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          if ((i != 1) && (i != 3)) {
            break label258;
          }
          if (locala.Edo != a.a.Edu) {
            break label266;
          }
          locala.Edp.l(locala.lwQ, paramMotionEvent.getRawX() - locala.lwO);
          locala.lwP = -1;
          locala.lwQ = 0;
          locala.lwO = 0.0F;
        }
      }
      for (;;)
      {
        locala.Edo = a.a.Edr;
        label258:
        AppMethodBeat.o(78108);
        return true;
        label266:
        if (locala.Edo == a.a.Eds)
        {
          ((AudioManager)locala.mContext.getSystemService("audio")).getStreamMaxVolume(3);
          locala.Edp.bnI();
        }
        else if (locala.Edo == a.a.Edt)
        {
          locala.Edp.bnJ();
        }
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (eRX())) {
      this.Edy.va(this.isLoading);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(78108);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(78091);
    ae.i("MicroMsg.FtsWebVideoView", "pause");
    eRW();
    if (!this.Edx.isPlaying())
    {
      AppMethodBeat.o(78091);
      return;
    }
    this.Edx.pause();
    AppMethodBeat.o(78091);
  }
  
  public void setAllowMobileNetPlay(boolean paramBoolean)
  {
    this.EdM = paramBoolean;
  }
  
  public void setAppId(String paramString)
  {
    AppMethodBeat.i(78085);
    ae.i("MicroMsg.FtsWebVideoView", "setAppId appid=%s", new Object[] { paramString });
    this.mAppId = paramString;
    AppMethodBeat.o(78085);
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(78086);
    ae.i("MicroMsg.FtsWebVideoView", "setAutoPlay =%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.csJ = paramBoolean;
    AppMethodBeat.o(78086);
  }
  
  public void setCallback(d paramd)
  {
    this.EdJ = paramd;
  }
  
  public void setCookieData(String paramString)
  {
    this.lps = paramString;
  }
  
  public final void setCover$16da05f7(String paramString)
  {
    AppMethodBeat.i(78096);
    ae.i("MicroMsg.FtsWebVideoView", "setCover coverUrl=%s", new Object[] { paramString });
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78096);
      return;
    }
    this.lpE = paramString;
    com.tencent.mm.modelappbrand.a.b.aEl().a(this.lpo, paramString, null, null);
    AppMethodBeat.o(78096);
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(78103);
    ae.i("MicroMsg.FtsWebVideoView", "setDisableScroll isDisableScroll=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.EdG = paramBoolean;
    AppMethodBeat.o(78103);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(78087);
    if (paramInt <= 0)
    {
      ae.i("MicroMsg.FtsWebVideoView", "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(78087);
      return;
    }
    AppMethodBeat.o(78087);
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.EdI = parama;
  }
  
  public void setFullScreenDirection(String paramString)
  {
    AppMethodBeat.i(78102);
    ae.i("MicroMsg.FtsWebVideoView", "setFullScreenDirection %s", new Object[] { paramString });
    if ("horizontal".equalsIgnoreCase(paramString))
    {
      this.Edw = FtsWebVideoView.b.EdU;
      AppMethodBeat.o(78102);
      return;
    }
    if ("vertical".equalsIgnoreCase(paramString))
    {
      this.Edw = FtsWebVideoView.b.EdV;
      AppMethodBeat.o(78102);
      return;
    }
    this.Edw = FtsWebVideoView.b.EdT;
    AppMethodBeat.o(78102);
  }
  
  public void setInitialTime(int paramInt)
  {
    AppMethodBeat.i(78105);
    ae.i("MicroMsg.FtsWebVideoView", "setInitialTime initialTime=%d", new Object[] { Integer.valueOf(paramInt) });
    this.oAx = paramInt;
    AppMethodBeat.o(78105);
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(78095);
    ae.i("MicroMsg.FtsWebVideoView", "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpv = paramBoolean;
    AppMethodBeat.o(78095);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(78088);
    ae.i("MicroMsg.FtsWebVideoView", "setLoop loop=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpC = paramBoolean;
    AppMethodBeat.o(78088);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(78099);
    ae.i("MicroMsg.FtsWebVideoView", "setMute isMute=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.fOX = paramBoolean;
    this.Edx.setMute(paramBoolean);
    if (paramBoolean)
    {
      this.Edy.adg();
      AppMethodBeat.o(78099);
      return;
    }
    this.Edy.eQr();
    AppMethodBeat.o(78099);
  }
  
  public void setObjectFit(String paramString)
  {
    AppMethodBeat.i(78098);
    ae.i("MicroMsg.FtsWebVideoView", "setObjectFit objectFit=%s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.Edx.setScaleType(i.e.Fli);
      this.lpo.setScaleType(ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(78098);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.Edx.setScaleType(i.e.Flk);
      this.lpo.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(78098);
      return;
    }
    this.Edx.setScaleType(i.e.Flj);
    this.lpo.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(78098);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(78104);
    ae.i("MicroMsg.FtsWebVideoView", "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpx = paramBoolean;
    AppMethodBeat.o(78104);
  }
  
  public void setUiLifecycleListener(b.a parama)
  {
    this.EdK = parama;
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.lpt = paramInt;
  }
  
  public void setVideoSizeByte(int paramInt)
  {
    this.EdL = paramInt;
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(78089);
    ae.i("MicroMsg.FtsWebVideoView", "start");
    eRW();
    if ((paramBoolean) && (!gW(getContext())))
    {
      ae.i("MicroMsg.FtsWebVideoView", "start network is not wifi");
      AppMethodBeat.o(78089);
      return;
    }
    this.EdQ = FtsWebVideoView.c.EdX;
    if (this.Edx.isPlaying())
    {
      AppMethodBeat.o(78089);
      return;
    }
    if (this.lpv)
    {
      WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.Edy;
      if (localWebSearchWebVideoViewControlBar.lpR == null) {
        localWebSearchWebVideoViewControlBar.lpR = new aw(new WebSearchWebVideoViewControlBar.2(localWebSearchWebVideoViewControlBar), true);
      }
      localWebSearchWebVideoViewControlBar.bpr();
      localWebSearchWebVideoViewControlBar.lpR.stopTimer();
      localWebSearchWebVideoViewControlBar.lpR.ay(500L, 500L);
    }
    this.Edx.start();
    if (this.EdN == 0L)
    {
      this.EdN = System.currentTimeMillis();
      AppMethodBeat.o(78089);
      return;
    }
    this.EdN = 9223372036854775807L;
    AppMethodBeat.o(78089);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(78092);
    ae.i("MicroMsg.FtsWebVideoView", "stop");
    if (!this.Edx.isPlaying())
    {
      AppMethodBeat.o(78092);
      return;
    }
    this.Edx.stop();
    WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = this.Edy;
    if (localWebSearchWebVideoViewControlBar.lpR != null) {
      localWebSearchWebVideoViewControlBar.lpR.stopTimer();
    }
    AppMethodBeat.o(78092);
  }
  
  public final void vc(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(78112);
    ae.i("MicroMsg.FtsWebVideoView", "operateFullScreen toFullScreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.EdI == null)
    {
      ae.w("MicroMsg.FtsWebVideoView", "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(78112);
      return;
    }
    if (paramBoolean == bnx())
    {
      ae.i("MicroMsg.FtsWebVideoView", "operateFullScreen current same");
      AppMethodBeat.o(78112);
      return;
    }
    if (paramBoolean)
    {
      Object localObject = this.EdI;
      paramBoolean = bool;
      if (this.Edw != FtsWebVideoView.b.EdV) {
        paramBoolean = true;
      }
      ((a)localObject).vd(paramBoolean);
      localObject = this.Edy;
      ((WebSearchWebVideoViewControlBar)localObject).lws = true;
      ((WebSearchWebVideoViewControlBar)localObject).bpn();
      gQ(true);
      AppMethodBeat.o(78112);
      return;
    }
    this.EdI.blp();
    this.Edy.blp();
    AppMethodBeat.o(78112);
  }
  
  public static abstract interface a
  {
    public abstract void blp();
    
    public abstract boolean isFullScreen();
    
    public abstract void vd(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView
 * JD-Core Version:    0.7.0.1
 */