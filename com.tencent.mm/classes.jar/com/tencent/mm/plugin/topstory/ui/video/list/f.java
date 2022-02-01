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
import com.tencent.mm.aw.q;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.h;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.protocal.protobuf.dnw;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.UUID;

public final class f
  extends com.tencent.mm.plugin.topstory.ui.video.f
{
  private k Bwj;
  private View.OnClickListener Bwk;
  private View Bwq;
  private TextView Bwr;
  private TextView Bws;
  private ImageView Bwt;
  private ImageView Bwu;
  private g BxB;
  private View BxC;
  private TextView BxD;
  private boolean isLoading;
  private i.b sOj;
  
  public f(Context paramContext, com.tencent.mm.plugin.topstory.ui.video.b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    AppMethodBeat.i(126459);
    this.sOj = new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int j = 0;
        AppMethodBeat.i(126445);
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TopStory.TopStoryListVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 != 0)
        {
          paramAnonymousString2 = f.F(f.this).epL().Tg(f.E(f.this).epE());
          if ((paramAnonymousString2 != null) && (paramAnonymousString2.HCC != null))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousString2.HCC.size()), paramAnonymousString2.videoUrl, Integer.valueOf(paramAnonymousString2.HCL) });
            int i = 0;
            while (i < paramAnonymousString2.HCC.size())
            {
              dof localdof = (dof)paramAnonymousString2.HCC.get(i);
              if (paramAnonymousString2.videoUrl.equals(localdof.url))
              {
                if (i + 1 >= paramAnonymousString2.HCC.size()) {
                  break;
                }
                i += 1;
                localdof = (dof)paramAnonymousString2.HCC.get(i);
                if ((localdof == null) || (bt.isNullOrNil(localdof.url))) {
                  break;
                }
                paramAnonymousString2.HCL = localdof.HCL;
                paramAnonymousString2.videoUrl = localdof.url;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", new Object[] { Integer.valueOf(i), localdof.url, Integer.valueOf(localdof.HCL) });
                com.tencent.mm.plugin.websearch.api.a.b.ma(com.tencent.mm.plugin.websearch.api.a.b.DDc);
                f.this.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(126444);
                    f.this.aq(true, true);
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
        f.I(f.this).epL().a(f.G(f.this).epz(), f.H(f.this).epE());
        f.this.ki(f.this.getContext().getString(2131764672, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), f.this.getContext().getString(2131764699));
        f.this.getListVideoUIComponent().epB().onError(paramAnonymousString1);
        i.ST(paramAnonymousInt1);
        paramAnonymousString1 = f.this.getListVideoUIComponent().epx().BvO;
        paramAnonymousInt2 = j;
        if (paramAnonymousString1 != null)
        {
          paramAnonymousInt2 = j;
          if (paramAnonymousString1.Bre > 0L) {
            paramAnonymousInt2 = (int)(System.currentTimeMillis() - paramAnonymousString1.Bre) / 1000;
          }
        }
        i.a(f.J(f.this), paramAnonymousInt1, paramAnonymousString3, paramAnonymousInt2);
        AppMethodBeat.o(126445);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126448);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(126448);
      }
      
      public final void dq(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126446);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onPrepared");
        f.K(f.this).boJ();
        if (!f.L(f.this)) {
          f.this.epU();
        }
        AppMethodBeat.o(126446);
      }
      
      public final void dr(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126447);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoEnded, pos:%s, listpos:%s", new Object[] { Integer.valueOf(f.M(f.this).epv()), Integer.valueOf(f.N(f.this).epv()) });
        f.this.getListVideoUIComponent().epB().aCY(paramAnonymousString1);
        f.this.getListVideoUIComponent().epx().BvN = 1;
        if ((!f.this.getListVideoUIComponent().SX(f.O(f.this).epv() + 1)) && ((f.P(f.this) instanceof h))) {}
        try
        {
          Thread.sleep(100L);
          label134:
          ((h)f.Q(f.this)).sJ(true);
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
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void du(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126449);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaiting");
        f.a(f.this, true);
        AppMethodBeat.o(126449);
      }
      
      public final void dv(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126450);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaitingEnd");
        f.a(f.this, false);
        f.g(f.this).setVisibility(8);
        if (f.R(f.this).HCM != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "longVideoInfo onVideoWaitingEnd");
          f.S(f.this).setVisibility(0);
        }
        f.this.epU();
        paramAnonymousString1 = f.this.getListVideoUIComponent().epx().BvO;
        if ((paramAnonymousString1 != null) && (paramAnonymousString1.Brp == 0L))
        {
          paramAnonymousString1.Brp = (System.currentTimeMillis() - paramAnonymousString1.Bre);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramAnonymousString1.Brm), Long.valueOf(paramAnonymousString1.Brp) });
        }
        AppMethodBeat.o(126450);
      }
      
      public final void eT(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    AppMethodBeat.o(126459);
  }
  
  private boolean bmR()
  {
    AppMethodBeat.i(126469);
    if (this.BtZ.getVisibility() == 0)
    {
      AppMethodBeat.o(126469);
      return true;
    }
    AppMethodBeat.o(126469);
    return false;
  }
  
  public final boolean aq(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(126464);
    paramBoolean1 = super.aq(paramBoolean1, paramBoolean2);
    getListVideoUIComponent().epB().setMute(getListVideoUIComponent().Pf());
    AppMethodBeat.o(126464);
    return paramBoolean1;
  }
  
  public final i.e c(dod paramdod)
  {
    return i.e.ESO;
  }
  
  public final void epS()
  {
    AppMethodBeat.i(126462);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollPlayContainerStatus");
    this.BtZ.setVisibility(8);
    this.oSB.setVisibility(0);
    this.BtQ.setVisibility(8);
    this.BtP.setVisibility(8);
    this.Bud.setVisibility(8);
    AppMethodBeat.o(126462);
  }
  
  public final void epT()
  {
    AppMethodBeat.i(126463);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollStopContainerStatus");
    this.BtZ.setVisibility(0);
    this.oSB.setVisibility(0);
    this.BtQ.setVisibility(8);
    this.BtP.setVisibility(8);
    this.Bud.setVisibility(8);
    this.Bub.setVisibility(0);
    this.Bua.setVisibility(8);
    this.BtT.setVisibility(0);
    this.BtU.setVisibility(8);
    this.BtX.setVisibility(8);
    AppMethodBeat.o(126463);
  }
  
  public final void epU()
  {
    AppMethodBeat.i(126461);
    super.epU();
    AppMethodBeat.o(126461);
  }
  
  public final void epX()
  {
    AppMethodBeat.i(126467);
    if (this.BxB != null) {
      this.BxB.setVisibility(8);
    }
    AppMethodBeat.o(126467);
  }
  
  public final void epY()
  {
    AppMethodBeat.i(126465);
    g localg = this.BxB;
    if (localg.BwP != null) {
      localg.BwP.stopTimer();
    }
    AppMethodBeat.o(126465);
  }
  
  public final void eqc()
  {
    AppMethodBeat.i(126470);
    super.eqc();
    if ((this.Brz.HCO != null) && (this.Brz.HCO.HBR != null))
    {
      this.Bwr.setText(this.Brz.HCO.HBR.title);
      this.Bws.setText(this.Brz.HCO.HBR.desc);
      q.aIJ().a(this.Brz.HCO.HBR.sjU, this.Bwt, Btq);
      this.Bwq.setVisibility(0);
      i.a(this.BtO.epz(), this.Brz, 1);
      if (getControlBar().bni())
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.Bwq.getLayoutParams();
        localLayoutParams.bottomMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165298);
        this.Bwq.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(126470);
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Bwq.getLayoutParams();
      localLayoutParams.bottomMargin = com.tencent.mm.cc.a.ay(getContext(), 2131165303);
      this.Bwq.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(126470);
      return;
    }
    this.Bwq.setVisibility(8);
    AppMethodBeat.o(126470);
  }
  
  public final void eqd()
  {
    AppMethodBeat.i(126471);
    super.eqd();
    this.Bwq.setVisibility(8);
    AppMethodBeat.o(126471);
  }
  
  public final boolean eqe()
  {
    AppMethodBeat.i(161627);
    if (this.Bwq.getVisibility() == 0)
    {
      AppMethodBeat.o(161627);
      return true;
    }
    AppMethodBeat.o(161627);
    return false;
  }
  
  public final g getControlBar()
  {
    return this.BxB;
  }
  
  public final int getLayoutId()
  {
    return 2131495790;
  }
  
  public final a getListItemUIComponent()
  {
    return (a)this.Bug;
  }
  
  public final b getListVideoUIComponent()
  {
    return (b)this.BtO;
  }
  
  public final String getSessionId()
  {
    return this.sessionId;
  }
  
  public final dod getVideoInfo()
  {
    return this.Brz;
  }
  
  public final i.b getVideoViewCallback()
  {
    return this.sOj;
  }
  
  public final void init()
  {
    AppMethodBeat.i(126460);
    super.init();
    this.BxC = findViewById(2131301594);
    this.BxD = ((TextView)findViewById(2131301593));
    this.Bwq = findViewById(2131303343);
    this.Bwr = ((TextView)findViewById(2131303344));
    this.Bws = ((TextView)findViewById(2131303341));
    this.Bwt = ((ImageView)findViewById(2131303342));
    this.Bwu = ((ImageView)findViewById(2131303340));
    this.Bwk = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126429);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        f.this.getListVideoUIComponent().bnj();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126429);
      }
    };
    this.BtV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126436);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (f.a(f.this) == com.tencent.mm.plugin.topstory.ui.video.f.a.Buk)
        {
          f.this.getListVideoUIComponent().epw().Bvq = true;
          f.b(f.this).SZ(2);
        }
        if (f.this.getListVideoUIComponent().epw().isConnected())
        {
          f.a(f.this, com.tencent.mm.plugin.topstory.ui.video.f.a.Buj);
          if (f.this.getListVideoUIComponent().epB().BvU)
          {
            f.this.getListVideoUIComponent().epB().eaq();
            f.this.epU();
            com.tencent.mm.plugin.websearch.api.a.a.ma(19);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126436);
          return;
          f.this.aq(true, false);
          break;
          com.tencent.mm.plugin.websearch.api.a.a.ma(20);
        }
      }
    });
    this.BtT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126437);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        f.this.getListVideoUIComponent().epx().BvN = 2;
        boolean bool;
        if ((f.this.getListItemUIComponent() != null) && (f.this.getListItemUIComponent().epv() == f.this.getListVideoUIComponent().epE()))
        {
          paramAnonymousView = f.this;
          if (!f.this.getListVideoUIComponent().epw().Bvq)
          {
            bool = true;
            paramAnonymousView.aq(bool, false);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126437);
          return;
          bool = false;
          break;
          f.this.getListVideoUIComponent().SX(f.c(f.this).epv());
          f.this.getListVideoUIComponent().epx().j(f.d(f.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().epz(), f.e(f.this), f.f(f.this).epv(), 2, "");
        }
      }
    });
    this.BtU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126438);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        f.this.eqa();
        f.g(f.this).bno();
        f.this.getListVideoUIComponent().epx().BvN = 2;
        f.this.getListVideoUIComponent().epB().a(f.this.getListVideoUIComponent(), f.h(f.this), f.i(f.this), f.j(f.this).epv());
        f.this.epU();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126438);
      }
    });
    this.BtZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126439);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((f.this.getListItemUIComponent() != null) && (f.this.getListItemUIComponent().epv() != f.this.getListVideoUIComponent().epE()))
        {
          f.this.getListVideoUIComponent().epx().BvN = 2;
          f.this.getListVideoUIComponent().SX(f.k(f.this).epv());
          f.this.getListVideoUIComponent().epx().j(f.l(f.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().epz(), f.m(f.this), f.n(f.this).epv(), 2, "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126439);
      }
    });
    this.BxC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126440);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new doa();
        paramAnonymousView.scene = f.this.getListVideoUIComponent().epz().scene;
        paramAnonymousView.qXu = UUID.randomUUID().toString();
        paramAnonymousView.HCd = f.this.getListVideoUIComponent().epz().keN;
        paramAnonymousView.HCe = f.this.getListVideoUIComponent().epz().HCe;
        paramAnonymousView.HCb = f.o(f.this).HCM.tSk;
        paramAnonymousView.HCc = f.this.getListVideoUIComponent().epz().HCc;
        paramAnonymousView.HCg = f.p(f.this).HCM;
        paramAnonymousView.dld = "topstory";
        paramAnonymousView.keN = f.this.getListVideoUIComponent().epz().keN;
        paramAnonymousView.HCf = f.q(f.this).HCu;
        paramAnonymousView.HCg.HCD = f.r(f.this).HCD;
        paramAnonymousView.DBj.addAll(f.s(f.this).HCM.DBj);
        com.tencent.mm.plugin.websearch.api.ad.a(f.this.getListVideoUIComponent().dhO(), paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126440);
      }
    });
    if (this.Bwq != null) {
      this.Bwq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126442);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(aj.getContext());
          paramAnonymousView.aXO(f.this.getContext().getString(2131764484, new Object[] { f.t(f.this).HCO.HBR.HBN })).yU(true);
          paramAnonymousView.afp(2131755270);
          paramAnonymousView.c(new f.c()
          {
            public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(126441);
              if ((paramAnonymous2Boolean) && (f.u(f.this) != null) && (f.v(f.this).HCO != null) && (f.w(f.this).HCO.HBR != null))
              {
                i.a(f.x(f.this).epz(), f.y(f.this), 2);
                paramAnonymous2String = new com.tencent.mm.plugin.appbrand.api.f();
                paramAnonymous2String.appId = f.z(f.this).HCO.HBR.appId;
                paramAnonymous2String.jCN = f.A(f.this).HCO.HBR.dJH;
                paramAnonymous2String.scene = 1152;
                ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).a(f.this.getContext(), paramAnonymous2String);
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
    if (this.Bwu != null) {
      this.Bwu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126443);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          f.B(f.this).setVisibility(8);
          i.a(f.C(f.this).epz(), f.D(f.this), 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126443);
        }
      });
    }
    this.Bwj = new k(getContext(), this, new a());
    this.BxB = new g(getContext());
    this.BxB.setVisibility(8);
    this.BxB.setFullScreenBtnClickListener(this.Bwk);
    this.BxB.setOnUpdateProgressLenListener(new g.a()
    {
      public final void eqI()
      {
        AppMethodBeat.i(126431);
        f.af(f.this).setVisibility(8);
        RelativeLayout.LayoutParams localLayoutParams;
        if (f.ag(f.this).HCM != null)
        {
          f.S(f.this).setVisibility(0);
          localLayoutParams = (RelativeLayout.LayoutParams)f.S(f.this).getLayoutParams();
          localLayoutParams.bottomMargin = com.tencent.mm.cc.a.ay(f.this.getContext(), 2131165298);
          f.S(f.this).setLayoutParams(localLayoutParams);
        }
        if (f.B(f.this).getVisibility() == 0)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)f.B(f.this).getLayoutParams();
          localLayoutParams.bottomMargin = com.tencent.mm.cc.a.ay(f.this.getContext(), 2131165298);
          f.B(f.this).setLayoutParams(localLayoutParams);
        }
        AppMethodBeat.o(126431);
      }
      
      public final void eqJ()
      {
        AppMethodBeat.i(126432);
        if (f.ah(f.this).HCM != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "longVideoInfo onControlBarGone");
          f.S(f.this).setVisibility(8);
        }
        if ((f.this.getListVideoUIComponent().epB().BvU) && ((f.this.getListVideoUIComponent().epB().eqE()) || (f.this.getListVideoUIComponent().epB().BvV))) {
          f.ai(f.this).setVisibility(0);
        }
        for (;;)
        {
          if (f.B(f.this).getVisibility() == 0)
          {
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)f.B(f.this).getLayoutParams();
            localLayoutParams.bottomMargin = com.tencent.mm.cc.a.ay(f.this.getContext(), 2131165303);
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
          Object localObject = f.this.getListVideoUIComponent().epx().BvO;
          if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).Brh < f.this.getListVideoUIComponent().epB().getCurrPosMs())) {
            ((com.tencent.mm.plugin.topstory.a.b.b)localObject).Brh = f.this.getListVideoUIComponent().epB().getCurrPosMs();
          }
          if (f.this.getListVideoUIComponent().epB().eqE())
          {
            int j = f.this.getListVideoUIComponent().epB().getCurrPosMs() / 1000;
            if (((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(f.U(f.this).tSk)) {
              ((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(f.V(f.this).tSk, Integer.valueOf(j));
            }
          }
          if (!f.g(f.this).bni())
          {
            localObject = (FrameLayout.LayoutParams)f.W(f.this).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject).width = i;
            f.X(f.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
            f.Y(f.this).requestLayout();
            f.Z(f.this).setVisibility(0);
          }
          if ((f.aa(f.this).HCD & 0x100) <= 0) {
            f.ac(f.this).a(f.ab(f.this), paramAnonymousInt1, paramAnonymousInt2);
          }
          f.ae(f.this).a(f.ad(f.this), f.this, paramAnonymousInt1);
          AppMethodBeat.o(126430);
          return;
        }
      }
    });
    this.BxB.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqD()
      {
        AppMethodBeat.i(126433);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekPre");
        f.g(f.this).bSH();
        AppMethodBeat.o(126433);
      }
      
      public final void nM(int paramAnonymousInt)
      {
        AppMethodBeat.i(126434);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        f.this.seekTo(paramAnonymousInt);
        f.g(f.this).bno();
        com.tencent.mm.plugin.websearch.api.a.a.ma(22);
        AppMethodBeat.o(126434);
      }
    });
    this.BxB.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126435);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (f.this.getListVideoUIComponent().epB().BvU)
        {
          if (f.g(f.this).getVideoTotalTime() - f.g(f.this).getmPosition() < 2)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "cannot change play status in last 2 seconds");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126435);
            return;
          }
          f.this.getListVideoUIComponent().epx().j(f.ak(f.this));
          if (f.this.getListVideoUIComponent().epB().eqE())
          {
            f.this.getListVideoUIComponent().epB().cxw();
            f.g(f.this).bSH();
            f.this.epU();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126435);
          return;
          f.this.getListVideoUIComponent().epB().eaq();
          f.g(f.this).bno();
          break;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "no video play now");
        }
      }
    });
    AppMethodBeat.o(126460);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126468);
    if (this.Bwj != null) {
      this.Bwj.w(paramMotionEvent);
    }
    AppMethodBeat.o(126468);
    return true;
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(126466);
    super.updateView();
    if (this.BxB != null) {
      this.BxB.setVideoTotalTime(this.Brz.zSz);
    }
    TextView localTextView;
    long l;
    String str;
    if ((getListItemUIComponent() != null) && (getListItemUIComponent().epv() != getListVideoUIComponent().epE()))
    {
      if (getListVideoUIComponent().epw().isConnected()) {
        epV();
      }
    }
    else
    {
      if (this.Brz.HCM == null) {
        break label295;
      }
      this.BxC.setVisibility(0);
      localTextView = this.BxD;
      l = this.Brz.HCM.zSz;
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
      ki(getNoNetTip(), getContext().getString(2131764699));
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
    this.BxC.setVisibility(8);
    AppMethodBeat.o(126466);
  }
  
  final class a
    implements c
  {
    private float Bwy;
    
    a()
    {
      AppMethodBeat.i(126451);
      this.Bwy = com.tencent.mm.cc.a.iq(f.this.getContext());
      AppMethodBeat.o(126451);
    }
    
    public final void Ta(int paramInt)
    {
      AppMethodBeat.i(126456);
      f.g(f.this).eqL();
      f.ao(f.this).setVisibility(8);
      f.this.seekTo(paramInt);
      AppMethodBeat.o(126456);
    }
    
    public final int bJ(float paramFloat)
    {
      AppMethodBeat.i(126455);
      paramFloat /= this.Bwy;
      int j = f.this.getListVideoUIComponent().epB().getVideoDurationSec();
      int i = getCurrentPosition();
      int k = (int)(paramFloat * j) + i;
      if (k < 0) {
        i = 0;
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.websearch.ui.a.sm(j * 1000L);
        f.an(f.this).setText(com.tencent.mm.plugin.websearch.ui.a.sm(i * 1000L) + "/" + str);
        AppMethodBeat.o(126455);
        return i;
        i = k;
        if (k > j) {
          i = j;
        }
      }
    }
    
    public final void bmV()
    {
      AppMethodBeat.i(126452);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onSingleTap");
      if (f.al(f.this))
      {
        if (f.g(f.this).bni())
        {
          f.g(f.this).setVisibility(8);
          AppMethodBeat.o(126452);
          return;
        }
        f.g(f.this).show();
        if (f.this.getListItemUIComponent() != null)
        {
          f.this.getListItemUIComponent().epu();
          f.this.getListItemUIComponent().ept();
        }
      }
      AppMethodBeat.o(126452);
    }
    
    public final void bmW()
    {
      AppMethodBeat.i(126453);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onDoubleTap");
      AppMethodBeat.o(126453);
    }
    
    public final void bmX()
    {
      AppMethodBeat.i(126454);
      f.am(f.this).setVisibility(0);
      f.g(f.this).eqK();
      AppMethodBeat.o(126454);
    }
    
    public final boolean epQ()
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
      int i = f.this.getListVideoUIComponent().epB().getCurrPosSec();
      AppMethodBeat.o(126458);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f
 * JD-Core Version:    0.7.0.1
 */