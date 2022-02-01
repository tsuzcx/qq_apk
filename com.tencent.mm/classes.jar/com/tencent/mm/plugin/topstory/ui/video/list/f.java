package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.h;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.dos;
import com.tencent.mm.protocal.protobuf.dot;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.UUID;

public final class f
  extends com.tencent.mm.plugin.topstory.ui.video.f
{
  private k BNH;
  private View.OnClickListener BNI;
  private View BNO;
  private TextView BNP;
  private TextView BNQ;
  private ImageView BNR;
  private ImageView BNS;
  private g BOZ;
  private View BPa;
  private TextView BPb;
  private boolean isLoading;
  private i.b sZu;
  
  public f(Context paramContext, com.tencent.mm.plugin.topstory.ui.video.b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    AppMethodBeat.i(126459);
    this.sZu = new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int j = 0;
        AppMethodBeat.i(126445);
        ae.e("MicroMsg.TopStory.TopStoryListVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 != 0)
        {
          paramAnonymousString2 = f.F(f.this).ets().TN(f.E(f.this).etl());
          if ((paramAnonymousString2 != null) && (paramAnonymousString2.HWp != null))
          {
            ae.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousString2.HWp.size()), paramAnonymousString2.videoUrl, Integer.valueOf(paramAnonymousString2.HWy) });
            int i = 0;
            while (i < paramAnonymousString2.HWp.size())
            {
              dpc localdpc = (dpc)paramAnonymousString2.HWp.get(i);
              if (paramAnonymousString2.videoUrl.equals(localdpc.url))
              {
                if (i + 1 >= paramAnonymousString2.HWp.size()) {
                  break;
                }
                i += 1;
                localdpc = (dpc)paramAnonymousString2.HWp.get(i);
                if ((localdpc == null) || (bu.isNullOrNil(localdpc.url))) {
                  break;
                }
                paramAnonymousString2.HWy = localdpc.HWy;
                paramAnonymousString2.videoUrl = localdpc.url;
                ae.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", new Object[] { Integer.valueOf(i), localdpc.url, Integer.valueOf(localdpc.HWy) });
                com.tencent.mm.plugin.websearch.api.a.b.md(com.tencent.mm.plugin.websearch.api.a.b.DVa);
                f.this.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(126444);
                    f.this.ap(true, true);
                    AppMethodBeat.o(126444);
                  }
                }, 100L);
                AppMethodBeat.o(126445);
                return;
              }
              i += 1;
            }
          }
        }
        f.I(f.this).ets().a(f.G(f.this).etg(), f.H(f.this).etl());
        f.this.ko(f.this.getContext().getString(2131764672, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), f.this.getContext().getString(2131764699));
        f.this.getListVideoUIComponent().eti().onError(paramAnonymousString1);
        i.TA(paramAnonymousInt1);
        paramAnonymousString1 = f.this.getListVideoUIComponent().ete().BNm;
        paramAnonymousInt2 = j;
        if (paramAnonymousString1 != null)
        {
          paramAnonymousInt2 = j;
          if (paramAnonymousString1.BID > 0L) {
            paramAnonymousInt2 = (int)(System.currentTimeMillis() - paramAnonymousString1.BID) / 1000;
          }
        }
        i.a(f.J(f.this), paramAnonymousInt1, paramAnonymousString3, paramAnonymousInt2);
        AppMethodBeat.o(126445);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126448);
        ae.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(126448);
      }
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126446);
        ae.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onPrepared");
        f.K(f.this).bpt();
        if (!f.L(f.this)) {
          f.this.etB();
        }
        AppMethodBeat.o(126446);
      }
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126447);
        ae.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoEnded, pos:%s, listpos:%s", new Object[] { Integer.valueOf(f.M(f.this).etc()), Integer.valueOf(f.N(f.this).etc()) });
        f.this.getListVideoUIComponent().eti().aEr(paramAnonymousString1);
        f.this.getListVideoUIComponent().ete().BNl = 1;
        if ((!f.this.getListVideoUIComponent().TE(f.O(f.this).etc() + 1)) && ((f.P(f.this) instanceof h))) {}
        try
        {
          Thread.sleep(100L);
          label134:
          ((h)f.Q(f.this)).sQ(true);
          f.g(f.this).setVisibility(8);
          f.a(f.this, false);
          AppMethodBeat.o(126447);
          return;
        }
        catch (InterruptedException paramAnonymousString1)
        {
          break label134;
        }
      }
      
      public final void du(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dv(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dw(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126449);
        ae.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaiting");
        f.a(f.this, true);
        AppMethodBeat.o(126449);
      }
      
      public final void dx(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126450);
        ae.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaitingEnd");
        f.a(f.this, false);
        f.g(f.this).setVisibility(8);
        if (f.R(f.this).HWz != null)
        {
          ae.i("MicroMsg.TopStory.TopStoryListVideoContainer", "longVideoInfo onVideoWaitingEnd");
          f.S(f.this).setVisibility(0);
        }
        f.this.etB();
        paramAnonymousString1 = f.this.getListVideoUIComponent().ete().BNm;
        if ((paramAnonymousString1 != null) && (paramAnonymousString1.BIO == 0L))
        {
          paramAnonymousString1.BIO = (System.currentTimeMillis() - paramAnonymousString1.BID);
          ae.i("MicroMsg.TopStory.TopStoryListVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramAnonymousString1.BIL), Long.valueOf(paramAnonymousString1.BIO) });
        }
        AppMethodBeat.o(126450);
      }
      
      public final void eX(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    AppMethodBeat.o(126459);
  }
  
  private boolean bnB()
  {
    AppMethodBeat.i(126469);
    if (this.BLx.getVisibility() == 0)
    {
      AppMethodBeat.o(126469);
      return true;
    }
    AppMethodBeat.o(126469);
    return false;
  }
  
  public final boolean ap(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(126464);
    paramBoolean1 = super.ap(paramBoolean1, paramBoolean2);
    getListVideoUIComponent().eti().setMute(getListVideoUIComponent().Pd());
    AppMethodBeat.o(126464);
    return paramBoolean1;
  }
  
  public final i.e c(dpa paramdpa)
  {
    return i.e.Flj;
  }
  
  public final void etA()
  {
    AppMethodBeat.i(126463);
    ae.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollStopContainerStatus");
    this.BLx.setVisibility(0);
    this.oZd.setVisibility(0);
    this.BLo.setVisibility(8);
    this.BLn.setVisibility(8);
    this.BLB.setVisibility(8);
    this.BLz.setVisibility(0);
    this.BLy.setVisibility(8);
    this.BLr.setVisibility(0);
    this.BLs.setVisibility(8);
    this.BLv.setVisibility(8);
    AppMethodBeat.o(126463);
  }
  
  public final void etB()
  {
    AppMethodBeat.i(126461);
    super.etB();
    AppMethodBeat.o(126461);
  }
  
  public final void etE()
  {
    AppMethodBeat.i(126467);
    if (this.BOZ != null) {
      this.BOZ.setVisibility(8);
    }
    AppMethodBeat.o(126467);
  }
  
  public final void etF()
  {
    AppMethodBeat.i(126465);
    g localg = this.BOZ;
    if (localg.BOn != null) {
      localg.BOn.stopTimer();
    }
    AppMethodBeat.o(126465);
  }
  
  public final void etJ()
  {
    AppMethodBeat.i(126470);
    super.etJ();
    if ((this.BIY.HWB != null) && (this.BIY.HWB.HVE != null))
    {
      this.BNP.setText(this.BIY.HWB.HVE.title);
      this.BNQ.setText(this.BIY.HWB.HVE.desc);
      q.aJb().a(this.BIY.HWB.HVE.ssR, this.BNR, BKO);
      this.BNO.setVisibility(0);
      i.a(this.BLm.etg(), this.BIY, 1);
      if (getControlBar().bnS())
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.BNO.getLayoutParams();
        localLayoutParams.bottomMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165298);
        this.BNO.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(126470);
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.BNO.getLayoutParams();
      localLayoutParams.bottomMargin = com.tencent.mm.cb.a.ay(getContext(), 2131165303);
      this.BNO.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(126470);
      return;
    }
    this.BNO.setVisibility(8);
    AppMethodBeat.o(126470);
  }
  
  public final void etK()
  {
    AppMethodBeat.i(126471);
    super.etK();
    this.BNO.setVisibility(8);
    AppMethodBeat.o(126471);
  }
  
  public final boolean etL()
  {
    AppMethodBeat.i(161627);
    if (this.BNO.getVisibility() == 0)
    {
      AppMethodBeat.o(161627);
      return true;
    }
    AppMethodBeat.o(161627);
    return false;
  }
  
  public final void etz()
  {
    AppMethodBeat.i(126462);
    ae.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollPlayContainerStatus");
    this.BLx.setVisibility(8);
    this.oZd.setVisibility(0);
    this.BLo.setVisibility(8);
    this.BLn.setVisibility(8);
    this.BLB.setVisibility(8);
    AppMethodBeat.o(126462);
  }
  
  public final g getControlBar()
  {
    return this.BOZ;
  }
  
  public final int getLayoutId()
  {
    return 2131495790;
  }
  
  public final a getListItemUIComponent()
  {
    return (a)this.BLE;
  }
  
  public final b getListVideoUIComponent()
  {
    return (b)this.BLm;
  }
  
  public final String getSessionId()
  {
    return this.sessionId;
  }
  
  public final dpa getVideoInfo()
  {
    return this.BIY;
  }
  
  public final i.b getVideoViewCallback()
  {
    return this.sZu;
  }
  
  public final void init()
  {
    AppMethodBeat.i(126460);
    super.init();
    this.BPa = findViewById(2131301594);
    this.BPb = ((TextView)findViewById(2131301593));
    this.BNO = findViewById(2131303343);
    this.BNP = ((TextView)findViewById(2131303344));
    this.BNQ = ((TextView)findViewById(2131303341));
    this.BNR = ((ImageView)findViewById(2131303342));
    this.BNS = ((ImageView)findViewById(2131303340));
    this.BNI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126429);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        f.this.getListVideoUIComponent().bnT();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126429);
      }
    };
    this.BLt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126436);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (f.a(f.this) == com.tencent.mm.plugin.topstory.ui.video.f.a.BLI)
        {
          f.this.getListVideoUIComponent().etd().BMO = true;
          f.b(f.this).TG(2);
        }
        if (f.this.getListVideoUIComponent().etd().isConnected())
        {
          f.a(f.this, com.tencent.mm.plugin.topstory.ui.video.f.a.BLH);
          if (f.this.getListVideoUIComponent().eti().BNs)
          {
            f.this.getListVideoUIComponent().eti().edW();
            f.this.etB();
            com.tencent.mm.plugin.websearch.api.a.a.md(19);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126436);
          return;
          f.this.ap(true, false);
          break;
          com.tencent.mm.plugin.websearch.api.a.a.md(20);
        }
      }
    });
    this.BLr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126437);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        f.this.getListVideoUIComponent().ete().BNl = 2;
        boolean bool;
        if ((f.this.getListItemUIComponent() != null) && (f.this.getListItemUIComponent().etc() == f.this.getListVideoUIComponent().etl()))
        {
          paramAnonymousView = f.this;
          if (!f.this.getListVideoUIComponent().etd().BMO)
          {
            bool = true;
            paramAnonymousView.ap(bool, false);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126437);
          return;
          bool = false;
          break;
          f.this.getListVideoUIComponent().TE(f.c(f.this).etc());
          f.this.getListVideoUIComponent().ete().j(f.d(f.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().etg(), f.e(f.this), f.f(f.this).etc(), 2, "");
        }
      }
    });
    this.BLs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126438);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        f.this.etH();
        f.g(f.this).bnY();
        f.this.getListVideoUIComponent().ete().BNl = 2;
        f.this.getListVideoUIComponent().eti().a(f.this.getListVideoUIComponent(), f.h(f.this), f.i(f.this), f.j(f.this).etc());
        f.this.etB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126438);
      }
    });
    this.BLx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126439);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((f.this.getListItemUIComponent() != null) && (f.this.getListItemUIComponent().etc() != f.this.getListVideoUIComponent().etl()))
        {
          f.this.getListVideoUIComponent().ete().BNl = 2;
          f.this.getListVideoUIComponent().TE(f.k(f.this).etc());
          f.this.getListVideoUIComponent().ete().j(f.l(f.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().etg(), f.m(f.this), f.n(f.this).etc(), 2, "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126439);
      }
    });
    this.BPa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126440);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new dox();
        paramAnonymousView.scene = f.this.getListVideoUIComponent().etg().scene;
        paramAnonymousView.rfA = UUID.randomUUID().toString();
        paramAnonymousView.HVQ = f.this.getListVideoUIComponent().etg().kid;
        paramAnonymousView.HVR = f.this.getListVideoUIComponent().etg().HVR;
        paramAnonymousView.HVO = f.o(f.this).HWz.udb;
        paramAnonymousView.HVP = f.this.getListVideoUIComponent().etg().HVP;
        paramAnonymousView.HVT = f.p(f.this).HWz;
        paramAnonymousView.dmf = "topstory";
        paramAnonymousView.kid = f.this.getListVideoUIComponent().etg().kid;
        paramAnonymousView.HVS = f.q(f.this).HWh;
        paramAnonymousView.HVT.HWq = f.r(f.this).HWq;
        paramAnonymousView.DTg.addAll(f.s(f.this).HWz.DTg);
        ad.a(f.this.getListVideoUIComponent().dkN(), paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126440);
      }
    });
    if (this.BNO != null) {
      this.BNO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126442);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(ak.getContext());
          paramAnonymousView.aZq(f.this.getContext().getString(2131764484, new Object[] { f.t(f.this).HWB.HVE.HVA })).zi(true);
          paramAnonymousView.afY(2131755270);
          paramAnonymousView.c(new f.c()
          {
            public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(126441);
              if ((paramAnonymous2Boolean) && (f.u(f.this) != null) && (f.v(f.this).HWB != null) && (f.w(f.this).HWB.HVE != null))
              {
                i.a(f.x(f.this).etg(), f.y(f.this), 2);
                paramAnonymous2String = new com.tencent.mm.plugin.appbrand.api.f();
                paramAnonymous2String.appId = f.z(f.this).HWB.HVE.appId;
                paramAnonymous2String.jFL = f.A(f.this).HWB.HVE.dKV;
                paramAnonymous2String.scene = 1152;
                ((p)com.tencent.mm.kernel.g.ab(p.class)).a(f.this.getContext(), paramAnonymous2String);
                f.B(f.this).setVisibility(8);
              }
              AppMethodBeat.o(126441);
            }
          }).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126442);
        }
      });
    }
    if (this.BNS != null) {
      this.BNS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126443);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          f.B(f.this).setVisibility(8);
          i.a(f.C(f.this).etg(), f.D(f.this), 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126443);
        }
      });
    }
    this.BNH = new k(getContext(), this, new a());
    this.BOZ = new g(getContext());
    this.BOZ.setVisibility(8);
    this.BOZ.setFullScreenBtnClickListener(this.BNI);
    this.BOZ.setOnUpdateProgressLenListener(new g.a()
    {
      public final void eup()
      {
        AppMethodBeat.i(126431);
        f.af(f.this).setVisibility(8);
        RelativeLayout.LayoutParams localLayoutParams;
        if (f.ag(f.this).HWz != null)
        {
          f.S(f.this).setVisibility(0);
          localLayoutParams = (RelativeLayout.LayoutParams)f.S(f.this).getLayoutParams();
          localLayoutParams.bottomMargin = com.tencent.mm.cb.a.ay(f.this.getContext(), 2131165298);
          f.S(f.this).setLayoutParams(localLayoutParams);
        }
        if (f.B(f.this).getVisibility() == 0)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)f.B(f.this).getLayoutParams();
          localLayoutParams.bottomMargin = com.tencent.mm.cb.a.ay(f.this.getContext(), 2131165298);
          f.B(f.this).setLayoutParams(localLayoutParams);
        }
        AppMethodBeat.o(126431);
      }
      
      public final void euq()
      {
        AppMethodBeat.i(126432);
        if (f.ah(f.this).HWz != null)
        {
          ae.i("MicroMsg.TopStory.TopStoryListVideoContainer", "longVideoInfo onControlBarGone");
          f.S(f.this).setVisibility(8);
        }
        if ((f.this.getListVideoUIComponent().eti().BNs) && ((f.this.getListVideoUIComponent().eti().eul()) || (f.this.getListVideoUIComponent().eti().BNt))) {
          f.ai(f.this).setVisibility(0);
        }
        for (;;)
        {
          if (f.B(f.this).getVisibility() == 0)
          {
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)f.B(f.this).getLayoutParams();
            localLayoutParams.bottomMargin = com.tencent.mm.cb.a.ay(f.this.getContext(), 2131165303);
            f.B(f.this).setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(126432);
          return;
          f.aj(f.this).setVisibility(8);
        }
      }
      
      public final void update(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126430);
        if (paramAnonymousInt2 > 0) {}
        for (int i = f.T(f.this).getWidth() * paramAnonymousInt1 / paramAnonymousInt2;; i = 0)
        {
          Object localObject = f.this.getListVideoUIComponent().ete().BNm;
          if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).BIG < f.this.getListVideoUIComponent().eti().getCurrPosMs())) {
            ((com.tencent.mm.plugin.topstory.a.b.b)localObject).BIG = f.this.getListVideoUIComponent().eti().getCurrPosMs();
          }
          if (f.this.getListVideoUIComponent().eti().eul())
          {
            int j = f.this.getListVideoUIComponent().eti().getCurrPosMs() / 1000;
            if (((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(f.U(f.this).udb)) {
              ((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(f.V(f.this).udb, Integer.valueOf(j));
            }
          }
          if (!f.g(f.this).bnS())
          {
            localObject = (FrameLayout.LayoutParams)f.W(f.this).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject).width = i;
            f.X(f.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
            f.Y(f.this).requestLayout();
            f.Z(f.this).setVisibility(0);
          }
          if ((f.aa(f.this).HWq & 0x100) <= 0) {
            f.ac(f.this).a(f.ab(f.this), paramAnonymousInt1, paramAnonymousInt2);
          }
          f.ae(f.this).a(f.ad(f.this), f.this, paramAnonymousInt1);
          AppMethodBeat.o(126430);
          return;
        }
      }
    });
    this.BOZ.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqS()
      {
        AppMethodBeat.i(126433);
        ae.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekPre");
        f.g(f.this).bTU();
        AppMethodBeat.o(126433);
      }
      
      public final void nP(int paramAnonymousInt)
      {
        AppMethodBeat.i(126434);
        ae.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        f.this.seekTo(paramAnonymousInt);
        f.g(f.this).bnY();
        com.tencent.mm.plugin.websearch.api.a.a.md(22);
        AppMethodBeat.o(126434);
      }
    });
    this.BOZ.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126435);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (f.this.getListVideoUIComponent().eti().BNs)
        {
          if (f.g(f.this).getVideoTotalTime() - f.g(f.this).getmPosition() < 2)
          {
            ae.i("MicroMsg.TopStory.TopStoryListVideoContainer", "cannot change play status in last 2 seconds");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126435);
            return;
          }
          f.this.getListVideoUIComponent().ete().j(f.ak(f.this));
          if (f.this.getListVideoUIComponent().eti().eul())
          {
            f.this.getListVideoUIComponent().eti().cyX();
            f.g(f.this).bTU();
            f.this.etB();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126435);
          return;
          f.this.getListVideoUIComponent().eti().edW();
          f.g(f.this).bnY();
          break;
          ae.i("MicroMsg.TopStory.TopStoryListVideoContainer", "no video play now");
        }
      }
    });
    AppMethodBeat.o(126460);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126468);
    if (this.BNH != null) {
      this.BNH.w(paramMotionEvent);
    }
    AppMethodBeat.o(126468);
    return true;
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(126466);
    super.updateView();
    if (this.BOZ != null) {
      this.BOZ.setVideoTotalTime(this.BIY.AjG);
    }
    TextView localTextView;
    long l;
    String str;
    if ((getListItemUIComponent() != null) && (getListItemUIComponent().etc() != getListVideoUIComponent().etl()))
    {
      if (getListVideoUIComponent().etd().isConnected()) {
        etC();
      }
    }
    else
    {
      if (this.BIY.HWz == null) {
        break label295;
      }
      this.BPa.setVisibility(0);
      localTextView = this.BPb;
      l = this.BIY.HWz.AjG;
      if (l > 0L) {
        break label158;
      }
      str = "00:00";
    }
    for (;;)
    {
      localTextView.setText(str);
      AppMethodBeat.o(126466);
      return;
      ko(getNoNetTip(), getContext().getString(2131764699));
      break;
      label158:
      if (l < 60L) {
        str = String.format(Locale.getDefault(), "00:%02d", new Object[] { Long.valueOf(l % 60L) });
      } else if (l < 3600L) {
        str = String.format(Locale.getDefault(), "%02d:%02d", new Object[] { Long.valueOf(l / 60L), Long.valueOf(l % 60L) });
      } else {
        str = String.format(Locale.getDefault(), "%02d:%02d:%02d", new Object[] { Long.valueOf(l / 3600L), Long.valueOf(l % 3600L / 60L), Long.valueOf(l % 60L) });
      }
    }
    label295:
    this.BPa.setVisibility(8);
    AppMethodBeat.o(126466);
  }
  
  final class a
    implements c
  {
    private float BNW;
    
    a()
    {
      AppMethodBeat.i(126451);
      this.BNW = com.tencent.mm.cb.a.iv(f.this.getContext());
      AppMethodBeat.o(126451);
    }
    
    public final void TH(int paramInt)
    {
      AppMethodBeat.i(126456);
      f.g(f.this).eus();
      f.ao(f.this).setVisibility(8);
      f.this.seekTo(paramInt);
      AppMethodBeat.o(126456);
    }
    
    public final int bH(float paramFloat)
    {
      AppMethodBeat.i(126455);
      paramFloat /= this.BNW;
      int j = f.this.getListVideoUIComponent().eti().getVideoDurationSec();
      int i = getCurrentPosition();
      int k = (int)(paramFloat * j) + i;
      if (k < 0) {
        i = 0;
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.websearch.ui.a.sz(j * 1000L);
        f.an(f.this).setText(com.tencent.mm.plugin.websearch.ui.a.sz(i * 1000L) + "/" + str);
        AppMethodBeat.o(126455);
        return i;
        i = k;
        if (k > j) {
          i = j;
        }
      }
    }
    
    public final void bnF()
    {
      AppMethodBeat.i(126452);
      ae.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onSingleTap");
      if (f.al(f.this))
      {
        if (f.g(f.this).bnS())
        {
          f.g(f.this).setVisibility(8);
          AppMethodBeat.o(126452);
          return;
        }
        f.g(f.this).show();
        if (f.this.getListItemUIComponent() != null)
        {
          f.this.getListItemUIComponent().etb();
          f.this.getListItemUIComponent().eta();
        }
      }
      AppMethodBeat.o(126452);
    }
    
    public final void bnG()
    {
      AppMethodBeat.i(126453);
      ae.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onDoubleTap");
      AppMethodBeat.o(126453);
    }
    
    public final void bnH()
    {
      AppMethodBeat.i(126454);
      f.am(f.this).setVisibility(0);
      f.g(f.this).eur();
      AppMethodBeat.o(126454);
    }
    
    public final boolean etx()
    {
      AppMethodBeat.i(126457);
      if (f.ap(f.this))
      {
        AppMethodBeat.o(126457);
        return false;
      }
      AppMethodBeat.o(126457);
      return true;
    }
    
    public final int getCurrentPosition()
    {
      AppMethodBeat.i(126458);
      int i = f.this.getListVideoUIComponent().eti().getCurrPosSec();
      AppMethodBeat.o(126458);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f
 * JD-Core Version:    0.7.0.1
 */