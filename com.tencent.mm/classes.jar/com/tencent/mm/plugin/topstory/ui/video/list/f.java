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
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.h;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.dig;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.UUID;

public final class f
  extends com.tencent.mm.plugin.topstory.ui.video.f
{
  private View AeE;
  private TextView AeF;
  private TextView AeG;
  private ImageView AeH;
  private ImageView AeI;
  private k Aex;
  private View.OnClickListener Aey;
  private g AfP;
  private View AfQ;
  private TextView AfR;
  private boolean isLoading;
  private h.b rRH;
  
  public f(Context paramContext, com.tencent.mm.plugin.topstory.ui.video.b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    AppMethodBeat.i(126459);
    this.rRH = new h.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int j = 0;
        AppMethodBeat.i(126445);
        ac.e("MicroMsg.TopStory.TopStoryListVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 != 0)
        {
          paramAnonymousString2 = f.C(f.this).edt().Rw(f.B(f.this).edm());
          if ((paramAnonymousString2 != null) && (paramAnonymousString2.FRW != null))
          {
            ac.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousString2.FRW.size()), paramAnonymousString2.videoUrl, Integer.valueOf(paramAnonymousString2.FSf) });
            int i = 0;
            while (i < paramAnonymousString2.FRW.size())
            {
              diq localdiq = (diq)paramAnonymousString2.FRW.get(i);
              if (paramAnonymousString2.videoUrl.equals(localdiq.url))
              {
                if (i + 1 >= paramAnonymousString2.FRW.size()) {
                  break;
                }
                i += 1;
                localdiq = (diq)paramAnonymousString2.FRW.get(i);
                if ((localdiq == null) || (bs.isNullOrNil(localdiq.url))) {
                  break;
                }
                paramAnonymousString2.FSf = localdiq.FSf;
                paramAnonymousString2.videoUrl = localdiq.url;
                ac.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", new Object[] { Integer.valueOf(i), localdiq.url, Integer.valueOf(localdiq.FSf) });
                com.tencent.mm.plugin.websearch.api.a.b.lA(com.tencent.mm.plugin.websearch.api.a.b.Cah);
                f.this.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(126444);
                    f.this.am(true, true);
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
        f.F(f.this).edt().a(f.D(f.this).edh(), f.E(f.this).edm());
        f.this.jT(f.this.getContext().getString(2131764672, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), f.this.getContext().getString(2131764699));
        f.this.getListVideoUIComponent().edj().onError(paramAnonymousString1);
        i.Rj(paramAnonymousInt1);
        paramAnonymousString1 = f.this.getListVideoUIComponent().edf().Aec;
        paramAnonymousInt2 = j;
        if (paramAnonymousString1 != null)
        {
          paramAnonymousInt2 = j;
          if (paramAnonymousString1.zZs > 0L) {
            paramAnonymousInt2 = (int)(System.currentTimeMillis() - paramAnonymousString1.zZs) / 1000;
          }
        }
        i.a(f.G(f.this), paramAnonymousInt1, paramAnonymousString3, paramAnonymousInt2);
        AppMethodBeat.o(126445);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126448);
        ac.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(126448);
      }
      
      public final void jdMethod_do(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126446);
        ac.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onPrepared");
        f.H(f.this).bkY();
        if (!f.I(f.this)) {
          f.this.edC();
        }
        AppMethodBeat.o(126446);
      }
      
      public final void dp(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126447);
        ac.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoEnded, pos:%s, listpos:%s", new Object[] { Integer.valueOf(f.J(f.this).edd()), Integer.valueOf(f.K(f.this).edd()) });
        f.this.getListVideoUIComponent().edj().axT(paramAnonymousString1);
        f.this.getListVideoUIComponent().edf().Aeb = 1;
        if ((!f.this.getListVideoUIComponent().Rn(f.L(f.this).edd() + 1)) && ((f.M(f.this) instanceof h))) {}
        try
        {
          Thread.sleep(100L);
          label134:
          ((h)f.N(f.this)).sd(true);
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
      
      public final void dq(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dr(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126449);
        ac.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaiting");
        f.a(f.this, true);
        AppMethodBeat.o(126449);
      }
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126450);
        ac.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaitingEnd");
        f.a(f.this, false);
        f.g(f.this).setVisibility(8);
        if (f.O(f.this).FSg != null)
        {
          ac.i("MicroMsg.TopStory.TopStoryListVideoContainer", "longVideoInfo onVideoWaitingEnd");
          f.P(f.this).setVisibility(0);
        }
        f.this.edC();
        paramAnonymousString1 = f.this.getListVideoUIComponent().edf().Aec;
        if ((paramAnonymousString1 != null) && (paramAnonymousString1.zZD == 0L))
        {
          paramAnonymousString1.zZD = (System.currentTimeMillis() - paramAnonymousString1.zZs);
          ac.i("MicroMsg.TopStory.TopStoryListVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramAnonymousString1.zZA), Long.valueOf(paramAnonymousString1.zZD) });
        }
        AppMethodBeat.o(126450);
      }
      
      public final void eJ(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    AppMethodBeat.o(126459);
  }
  
  private boolean bjf()
  {
    AppMethodBeat.i(126469);
    if (this.Aco.getVisibility() == 0)
    {
      AppMethodBeat.o(126469);
      return true;
    }
    AppMethodBeat.o(126469);
    return false;
  }
  
  public final boolean am(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(126464);
    paramBoolean1 = super.am(paramBoolean1, paramBoolean2);
    getListVideoUIComponent().edj().setMute(getListVideoUIComponent().Nw());
    AppMethodBeat.o(126464);
    return paramBoolean1;
  }
  
  public final h.e c(dio paramdio)
  {
    return h.e.DnJ;
  }
  
  public final void cL()
  {
    AppMethodBeat.i(126466);
    super.cL();
    if (this.AfP != null) {
      this.AfP.setVideoTotalTime(this.zZN.yBk);
    }
    TextView localTextView;
    long l;
    String str;
    if ((getListItemUIComponent() != null) && (getListItemUIComponent().edd() != getListVideoUIComponent().edm()))
    {
      if (getListVideoUIComponent().ede().isConnected()) {
        edD();
      }
    }
    else
    {
      if (this.zZN.FSg == null) {
        break label293;
      }
      this.AfQ.setVisibility(0);
      localTextView = this.AfR;
      l = this.zZN.FSg.yBk;
      if (l > 0L) {
        break label156;
      }
      str = "00:00";
    }
    for (;;)
    {
      localTextView.setText(str);
      AppMethodBeat.o(126466);
      return;
      jT(getNoNetTip(), getContext().getString(2131764699));
      break;
      label156:
      if (l < 60L) {
        str = String.format(Locale.getDefault(), "00:%02d", new Object[] { Long.valueOf(l % 60L) });
      } else if (l < 3600L) {
        str = String.format(Locale.getDefault(), "%02d:%02d", new Object[] { Long.valueOf(l / 60L), Long.valueOf(l % 60L) });
      } else {
        str = String.format(Locale.getDefault(), "%02d:%02d:%02d", new Object[] { Long.valueOf(l / 3600L), Long.valueOf(l % 3600L / 60L), Long.valueOf(l % 60L) });
      }
    }
    label293:
    this.AfQ.setVisibility(8);
    AppMethodBeat.o(126466);
  }
  
  public final void edA()
  {
    AppMethodBeat.i(126462);
    ac.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollPlayContainerStatus");
    this.Aco.setVisibility(8);
    this.opg.setVisibility(0);
    this.Acf.setVisibility(8);
    this.Ace.setVisibility(8);
    this.Acs.setVisibility(8);
    AppMethodBeat.o(126462);
  }
  
  public final void edB()
  {
    AppMethodBeat.i(126463);
    ac.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollStopContainerStatus");
    this.Aco.setVisibility(0);
    this.opg.setVisibility(0);
    this.Acf.setVisibility(8);
    this.Ace.setVisibility(8);
    this.Acs.setVisibility(8);
    this.Acq.setVisibility(0);
    this.Acp.setVisibility(8);
    this.Aci.setVisibility(0);
    this.Acj.setVisibility(8);
    this.Acm.setVisibility(8);
    AppMethodBeat.o(126463);
  }
  
  public final void edC()
  {
    AppMethodBeat.i(126461);
    super.edC();
    AppMethodBeat.o(126461);
  }
  
  public final void edF()
  {
    AppMethodBeat.i(126467);
    if (this.AfP != null) {
      this.AfP.setVisibility(8);
    }
    AppMethodBeat.o(126467);
  }
  
  public final void edG()
  {
    AppMethodBeat.i(126465);
    g localg = this.AfP;
    if (localg.Afd != null) {
      localg.Afd.stopTimer();
    }
    AppMethodBeat.o(126465);
  }
  
  public final void edK()
  {
    AppMethodBeat.i(126470);
    super.edK();
    if ((this.zZN.FSi != null) && (this.zZN.FSi.FRl != null))
    {
      this.AeF.setText(this.zZN.FSi.FRl.title);
      this.AeG.setText(this.zZN.FSi.FRl.desc);
      com.tencent.mm.av.o.aFB().a(this.zZN.FSi.FRl.ruB, this.AeH, AbF);
      this.AeE.setVisibility(0);
      i.a(this.Acd.edh(), this.zZN, 1);
      if (getControlBar().bjw())
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.AeE.getLayoutParams();
        localLayoutParams.bottomMargin = com.tencent.mm.cc.a.av(getContext(), 2131165298);
        this.AeE.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(126470);
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.AeE.getLayoutParams();
      localLayoutParams.bottomMargin = com.tencent.mm.cc.a.av(getContext(), 2131165303);
      this.AeE.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(126470);
      return;
    }
    this.AeE.setVisibility(8);
    AppMethodBeat.o(126470);
  }
  
  public final void edL()
  {
    AppMethodBeat.i(126471);
    super.edL();
    this.AeE.setVisibility(8);
    AppMethodBeat.o(126471);
  }
  
  public final boolean edM()
  {
    AppMethodBeat.i(161627);
    if (this.AeE.getVisibility() == 0)
    {
      AppMethodBeat.o(161627);
      return true;
    }
    AppMethodBeat.o(161627);
    return false;
  }
  
  public final g getControlBar()
  {
    return this.AfP;
  }
  
  public final int getLayoutId()
  {
    return 2131495790;
  }
  
  public final a getListItemUIComponent()
  {
    return (a)this.Acv;
  }
  
  public final b getListVideoUIComponent()
  {
    return (b)this.Acd;
  }
  
  public final String getSessionId()
  {
    return this.sessionId;
  }
  
  public final dio getVideoInfo()
  {
    return this.zZN;
  }
  
  public final h.b getVideoViewCallback()
  {
    return this.rRH;
  }
  
  public final void init()
  {
    AppMethodBeat.i(126460);
    super.init();
    this.AfQ = findViewById(2131301594);
    this.AfR = ((TextView)findViewById(2131301593));
    this.AeE = findViewById(2131303343);
    this.AeF = ((TextView)findViewById(2131303344));
    this.AeG = ((TextView)findViewById(2131303341));
    this.AeH = ((ImageView)findViewById(2131303342));
    this.AeI = ((ImageView)findViewById(2131303340));
    this.Aey = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126429);
        f.this.getListVideoUIComponent().bjx();
        AppMethodBeat.o(126429);
      }
    };
    this.Ack.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126436);
        if (f.a(f.this) == com.tencent.mm.plugin.topstory.ui.video.f.a.Acz)
        {
          f.this.getListVideoUIComponent().ede().AdF = true;
          f.b(f.this).Rp(2);
        }
        if (f.this.getListVideoUIComponent().ede().isConnected())
        {
          f.a(f.this, com.tencent.mm.plugin.topstory.ui.video.f.a.Acy);
          if (f.this.getListVideoUIComponent().edj().Aei)
          {
            f.this.getListVideoUIComponent().edj().dOc();
            f.this.edC();
          }
          for (;;)
          {
            com.tencent.mm.plugin.websearch.api.a.a.lA(19);
            AppMethodBeat.o(126436);
            return;
            f.this.am(true, false);
          }
        }
        com.tencent.mm.plugin.websearch.api.a.a.lA(20);
        AppMethodBeat.o(126436);
      }
    });
    this.Aci.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126437);
        f.this.getListVideoUIComponent().edf().Aeb = 2;
        if ((f.this.getListItemUIComponent() != null) && (f.this.getListItemUIComponent().edd() == f.this.getListVideoUIComponent().edm()))
        {
          paramAnonymousView = f.this;
          if (!f.this.getListVideoUIComponent().ede().AdF) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.am(bool, false);
            AppMethodBeat.o(126437);
            return;
          }
        }
        f.this.getListVideoUIComponent().Rn(f.c(f.this).edd());
        f.this.getListVideoUIComponent().edf().j(f.d(f.this));
        ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().edh(), f.e(f.this), f.f(f.this).edd(), 2, "");
        AppMethodBeat.o(126437);
      }
    });
    this.Acj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126438);
        f.this.edI();
        f.g(f.this).bjC();
        f.this.getListVideoUIComponent().edf().Aeb = 2;
        f.this.getListVideoUIComponent().edj().a(f.this.getListVideoUIComponent(), f.h(f.this), f.i(f.this), f.j(f.this).edd());
        f.this.edC();
        AppMethodBeat.o(126438);
      }
    });
    this.Aco.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126439);
        if ((f.this.getListItemUIComponent() != null) && (f.this.getListItemUIComponent().edd() != f.this.getListVideoUIComponent().edm()))
        {
          f.this.getListVideoUIComponent().edf().Aeb = 2;
          f.this.getListVideoUIComponent().Rn(f.k(f.this).edd());
          f.this.getListVideoUIComponent().edf().j(f.l(f.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().edh(), f.m(f.this), f.n(f.this).edd(), 2, "");
        }
        AppMethodBeat.o(126439);
      }
    });
    this.AfQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126440);
        paramAnonymousView = new dil();
        paramAnonymousView.scene = f.this.getListVideoUIComponent().edh().scene;
        paramAnonymousView.qox = UUID.randomUUID().toString();
        paramAnonymousView.FRx = f.this.getListVideoUIComponent().edh().jKB;
        paramAnonymousView.FRy = f.this.getListVideoUIComponent().edh().FRy;
        paramAnonymousView.FRv = f.o(f.this).FSg.sVF;
        paramAnonymousView.FRw = f.this.getListVideoUIComponent().edh().FRw;
        paramAnonymousView.FRA = f.p(f.this).FSg;
        paramAnonymousView.cZL = "topstory";
        paramAnonymousView.jKB = f.this.getListVideoUIComponent().edh().jKB;
        paramAnonymousView.FRz = f.q(f.this).FRO;
        paramAnonymousView.FRA.FRX = f.r(f.this).FRX;
        paramAnonymousView.BYq.addAll(f.s(f.this).FSg.BYq);
        z.a(f.this.getListVideoUIComponent().cYC(), paramAnonymousView);
        AppMethodBeat.o(126440);
      }
    });
    this.AeE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126442);
        paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(ai.getContext());
        paramAnonymousView.aRQ(f.this.getContext().getString(2131764484, new Object[] { f.t(f.this).FSi.FRl.FRh })).yi(true);
        paramAnonymousView.acQ(2131755270);
        paramAnonymousView.c(new f.c()
        {
          public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(126441);
            if (paramAnonymous2Boolean)
            {
              i.a(f.u(f.this).edh(), f.v(f.this), 2);
              paramAnonymous2String = new com.tencent.mm.plugin.appbrand.a.f();
              paramAnonymous2String.appId = f.w(f.this).FSi.FRl.appId;
              paramAnonymous2String.jjf = f.x(f.this).FSi.FRl.dxv;
              paramAnonymous2String.scene = 1152;
              ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(f.this.getContext(), paramAnonymous2String);
              f.y(f.this).setVisibility(8);
            }
            AppMethodBeat.o(126441);
          }
        }).show();
        AppMethodBeat.o(126442);
      }
    });
    this.AeI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126443);
        f.y(f.this).setVisibility(8);
        i.a(f.z(f.this).edh(), f.A(f.this), 3);
        AppMethodBeat.o(126443);
      }
    });
    this.Aex = new k(getContext(), this, new a());
    this.AfP = new g(getContext());
    this.AfP.setVisibility(8);
    this.AfP.setFullScreenBtnClickListener(this.Aey);
    this.AfP.setOnUpdateProgressLenListener(new g.a()
    {
      public final void eer()
      {
        AppMethodBeat.i(126431);
        f.ac(f.this).setVisibility(8);
        RelativeLayout.LayoutParams localLayoutParams;
        if (f.ad(f.this).FSg != null)
        {
          f.P(f.this).setVisibility(0);
          localLayoutParams = (RelativeLayout.LayoutParams)f.P(f.this).getLayoutParams();
          localLayoutParams.bottomMargin = com.tencent.mm.cc.a.av(f.this.getContext(), 2131165298);
          f.P(f.this).setLayoutParams(localLayoutParams);
        }
        if (f.y(f.this).getVisibility() == 0)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)f.y(f.this).getLayoutParams();
          localLayoutParams.bottomMargin = com.tencent.mm.cc.a.av(f.this.getContext(), 2131165298);
          f.y(f.this).setLayoutParams(localLayoutParams);
        }
        AppMethodBeat.o(126431);
      }
      
      public final void ees()
      {
        AppMethodBeat.i(126432);
        if (f.ae(f.this).FSg != null)
        {
          ac.i("MicroMsg.TopStory.TopStoryListVideoContainer", "longVideoInfo onControlBarGone");
          f.P(f.this).setVisibility(8);
        }
        if ((f.this.getListVideoUIComponent().edj().Aei) && ((f.this.getListVideoUIComponent().edj().een()) || (f.this.getListVideoUIComponent().edj().Aej))) {
          f.af(f.this).setVisibility(0);
        }
        for (;;)
        {
          if (f.y(f.this).getVisibility() == 0)
          {
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)f.y(f.this).getLayoutParams();
            localLayoutParams.bottomMargin = com.tencent.mm.cc.a.av(f.this.getContext(), 2131165303);
            f.y(f.this).setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(126432);
          return;
          f.ag(f.this).setVisibility(8);
        }
      }
      
      public final void update(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126430);
        if (paramAnonymousInt2 > 0) {}
        for (int i = f.Q(f.this).getWidth() * paramAnonymousInt1 / paramAnonymousInt2;; i = 0)
        {
          Object localObject = f.this.getListVideoUIComponent().edf().Aec;
          if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).zZv < f.this.getListVideoUIComponent().edj().getCurrPosMs())) {
            ((com.tencent.mm.plugin.topstory.a.b.b)localObject).zZv = f.this.getListVideoUIComponent().edj().getCurrPosMs();
          }
          if (f.this.getListVideoUIComponent().edj().een())
          {
            int j = f.this.getListVideoUIComponent().edj().getCurrPosMs() / 1000;
            if (((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(f.R(f.this).sVF)) {
              ((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(f.S(f.this).sVF, Integer.valueOf(j));
            }
          }
          if (!f.g(f.this).bjw())
          {
            localObject = (FrameLayout.LayoutParams)f.T(f.this).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject).width = i;
            f.U(f.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
            f.V(f.this).requestLayout();
            f.W(f.this).setVisibility(0);
          }
          if ((f.X(f.this).FRX & 0x100) <= 0) {
            f.Z(f.this).a(f.Y(f.this), paramAnonymousInt1, paramAnonymousInt2);
          }
          f.ab(f.this).a(f.aa(f.this), f.this, paramAnonymousInt1);
          AppMethodBeat.o(126430);
          return;
        }
      }
    });
    this.AfP.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void anR()
      {
        AppMethodBeat.i(126433);
        ac.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekPre");
        f.g(f.this).bOg();
        AppMethodBeat.o(126433);
      }
      
      public final void nn(int paramAnonymousInt)
      {
        AppMethodBeat.i(126434);
        ac.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        f.this.seekTo(paramAnonymousInt);
        f.g(f.this).bjC();
        com.tencent.mm.plugin.websearch.api.a.a.lA(22);
        AppMethodBeat.o(126434);
      }
    });
    this.AfP.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126435);
        if (f.this.getListVideoUIComponent().edj().Aei)
        {
          if (f.g(f.this).getVideoTotalTime() - f.g(f.this).getmPosition() < 2)
          {
            ac.i("MicroMsg.TopStory.TopStoryListVideoContainer", "cannot change play status in last 2 seconds");
            AppMethodBeat.o(126435);
            return;
          }
          f.this.getListVideoUIComponent().edf().j(f.ah(f.this));
          if (f.this.getListVideoUIComponent().edj().een())
          {
            f.this.getListVideoUIComponent().edj().crK();
            f.g(f.this).bOg();
          }
          for (;;)
          {
            f.this.edC();
            AppMethodBeat.o(126435);
            return;
            f.this.getListVideoUIComponent().edj().dOc();
            f.g(f.this).bjC();
          }
        }
        ac.i("MicroMsg.TopStory.TopStoryListVideoContainer", "no video play now");
        AppMethodBeat.o(126435);
      }
    });
    AppMethodBeat.o(126460);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126468);
    if (this.Aex != null) {
      this.Aex.y(paramMotionEvent);
    }
    AppMethodBeat.o(126468);
    return true;
  }
  
  final class a
    implements c
  {
    private float AeM;
    
    a()
    {
      AppMethodBeat.i(126451);
      this.AeM = com.tencent.mm.cc.a.ih(f.this.getContext());
      AppMethodBeat.o(126451);
    }
    
    public final void Rq(int paramInt)
    {
      AppMethodBeat.i(126456);
      f.g(f.this).eeu();
      f.al(f.this).setVisibility(8);
      f.this.seekTo(paramInt);
      AppMethodBeat.o(126456);
    }
    
    public final int bG(float paramFloat)
    {
      AppMethodBeat.i(126455);
      paramFloat /= this.AeM;
      int j = f.this.getListVideoUIComponent().edj().getVideoDurationSec();
      int i = getCurrentPosition();
      int k = (int)(paramFloat * j) + i;
      if (k < 0) {
        i = 0;
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.websearch.ui.a.qn(j * 1000L);
        f.ak(f.this).setText(com.tencent.mm.plugin.websearch.ui.a.qn(i * 1000L) + "/" + str);
        AppMethodBeat.o(126455);
        return i;
        i = k;
        if (k > j) {
          i = j;
        }
      }
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(126452);
      ac.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onSingleTap");
      if (f.ai(f.this))
      {
        if (f.g(f.this).bjw())
        {
          f.g(f.this).setVisibility(8);
          AppMethodBeat.o(126452);
          return;
        }
        f.g(f.this).show();
        if (f.this.getListItemUIComponent() != null)
        {
          f.this.getListItemUIComponent().edc();
          f.this.getListItemUIComponent().edb();
        }
      }
      AppMethodBeat.o(126452);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(126453);
      ac.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onDoubleTap");
      AppMethodBeat.o(126453);
    }
    
    public final void bjl()
    {
      AppMethodBeat.i(126454);
      f.aj(f.this).setVisibility(0);
      f.g(f.this).eet();
      AppMethodBeat.o(126454);
    }
    
    public final boolean edy()
    {
      AppMethodBeat.i(126457);
      if (f.am(f.this))
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
      int i = f.this.getListVideoUIComponent().edj().getCurrPosSec();
      AppMethodBeat.o(126458);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f
 * JD-Core Version:    0.7.0.1
 */