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
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.dct;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.ddd;
import com.tencent.mm.sdk.platformtools.ad;
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
  private boolean isLoading;
  private k yQH;
  private View.OnClickListener yQI;
  private View yQO;
  private TextView yQP;
  private TextView yQQ;
  private ImageView yQR;
  private ImageView yQS;
  private h.b yQT;
  private g ySa;
  private View ySb;
  private TextView ySc;
  
  public f(Context paramContext, com.tencent.mm.plugin.topstory.ui.video.b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    AppMethodBeat.i(126459);
    this.yQT = new h.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int j = 0;
        AppMethodBeat.i(126445);
        ad.e("MicroMsg.TopStory.TopStoryListVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 != 0)
        {
          paramAnonymousString2 = f.C(f.this).dOT().Pq(f.B(f.this).dOM());
          if ((paramAnonymousString2 != null) && (paramAnonymousString2.EuV != null))
          {
            ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousString2.EuV.size()), paramAnonymousString2.videoUrl, Integer.valueOf(paramAnonymousString2.Eve) });
            int i = 0;
            while (i < paramAnonymousString2.EuV.size())
            {
              ddd localddd = (ddd)paramAnonymousString2.EuV.get(i);
              if (paramAnonymousString2.videoUrl.equals(localddd.url))
              {
                if (i + 1 >= paramAnonymousString2.EuV.size()) {
                  break;
                }
                i += 1;
                localddd = (ddd)paramAnonymousString2.EuV.get(i);
                if ((localddd == null) || (bt.isNullOrNil(localddd.url))) {
                  break;
                }
                paramAnonymousString2.Eve = localddd.Eve;
                paramAnonymousString2.videoUrl = localddd.url;
                ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", new Object[] { Integer.valueOf(i), localddd.url, Integer.valueOf(localddd.Eve) });
                com.tencent.mm.plugin.websearch.api.a.b.lI(com.tencent.mm.plugin.websearch.api.a.b.AHQ);
                f.this.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(126444);
                    f.this.aj(true, true);
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
        f.F(f.this).dOT().a(f.D(f.this).dOH(), f.E(f.this).dOM());
        f.this.jv(f.this.getContext().getString(2131764672, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), f.this.getContext().getString(2131764699));
        f.this.getListVideoUIComponent().dOJ().onError(paramAnonymousString1);
        i.Pd(paramAnonymousInt1);
        paramAnonymousString1 = f.this.getListVideoUIComponent().dOF().yQm;
        paramAnonymousInt2 = j;
        if (paramAnonymousString1 != null)
        {
          paramAnonymousInt2 = j;
          if (paramAnonymousString1.yLz > 0L) {
            paramAnonymousInt2 = (int)(System.currentTimeMillis() - paramAnonymousString1.yLz) / 1000;
          }
        }
        i.a(f.G(f.this), paramAnonymousInt1, paramAnonymousString3, paramAnonymousInt2);
        AppMethodBeat.o(126445);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126448);
        ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(126448);
      }
      
      public final void db(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126446);
        ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onPrepared");
        f.H(f.this).bee();
        if (!f.I(f.this)) {
          f.this.dPc();
        }
        AppMethodBeat.o(126446);
      }
      
      public final void dc(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126447);
        ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoEnded, pos:%s, listpos:%s", new Object[] { Integer.valueOf(f.J(f.this).dOD()), Integer.valueOf(f.K(f.this).dOD()) });
        f.this.getListVideoUIComponent().dOJ().asK(paramAnonymousString1);
        f.this.getListVideoUIComponent().dOF().yQl = 1;
        if ((!f.this.getListVideoUIComponent().Ph(f.L(f.this).dOD() + 1)) && ((f.M(f.this) instanceof h))) {}
        try
        {
          Thread.sleep(100L);
          label134:
          ((h)f.N(f.this)).rf(true);
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
      
      public final void dd(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void de(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dg(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126449);
        ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaiting");
        f.a(f.this, true);
        AppMethodBeat.o(126449);
      }
      
      public final void dh(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126450);
        ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaitingEnd");
        f.a(f.this, false);
        f.g(f.this).setVisibility(8);
        if (f.O(f.this).Evf != null)
        {
          ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "longVideoInfo onVideoWaitingEnd");
          f.P(f.this).setVisibility(0);
        }
        f.this.dPc();
        paramAnonymousString1 = f.this.getListVideoUIComponent().dOF().yQm;
        if ((paramAnonymousString1 != null) && (paramAnonymousString1.yLK == 0L))
        {
          paramAnonymousString1.yLK = (System.currentTimeMillis() - paramAnonymousString1.yLz);
          ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramAnonymousString1.yLH), Long.valueOf(paramAnonymousString1.yLK) });
        }
        AppMethodBeat.o(126450);
      }
      
      public final void jw(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    AppMethodBeat.o(126459);
  }
  
  private boolean bck()
  {
    AppMethodBeat.i(126469);
    if (this.yOx.getVisibility() == 0)
    {
      AppMethodBeat.o(126469);
      return true;
    }
    AppMethodBeat.o(126469);
    return false;
  }
  
  public final boolean aj(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(126464);
    paramBoolean1 = super.aj(paramBoolean1, paramBoolean2);
    getListVideoUIComponent().dOJ().setMute(getListVideoUIComponent().Ny());
    AppMethodBeat.o(126464);
    return paramBoolean1;
  }
  
  public final h.e c(ddb paramddb)
  {
    return h.e.BVs;
  }
  
  public final void cE()
  {
    AppMethodBeat.i(126466);
    super.cE();
    if (this.ySa != null) {
      this.ySa.setVideoTotalTime(this.yLU.xot);
    }
    TextView localTextView;
    long l;
    String str;
    if ((getListItemUIComponent() != null) && (getListItemUIComponent().dOD() != getListVideoUIComponent().dOM()))
    {
      if (getListVideoUIComponent().dOE().isConnected()) {
        dPd();
      }
    }
    else
    {
      if (this.yLU.Evf == null) {
        break label293;
      }
      this.ySb.setVisibility(0);
      localTextView = this.ySc;
      l = this.yLU.Evf.xot;
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
      jv(getNoNetTip(), getContext().getString(2131764699));
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
    this.ySb.setVisibility(8);
    AppMethodBeat.o(126466);
  }
  
  public final void dPa()
  {
    AppMethodBeat.i(126462);
    ad.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollPlayContainerStatus");
    this.yOx.setVisibility(8);
    this.nMg.setVisibility(0);
    this.yOo.setVisibility(8);
    this.yOn.setVisibility(8);
    this.yOB.setVisibility(8);
    AppMethodBeat.o(126462);
  }
  
  public final void dPb()
  {
    AppMethodBeat.i(126463);
    ad.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollStopContainerStatus");
    this.yOx.setVisibility(0);
    this.nMg.setVisibility(0);
    this.yOo.setVisibility(8);
    this.yOn.setVisibility(8);
    this.yOB.setVisibility(8);
    this.yOz.setVisibility(0);
    this.yOy.setVisibility(8);
    this.yOr.setVisibility(0);
    this.yOs.setVisibility(8);
    this.yOv.setVisibility(8);
    AppMethodBeat.o(126463);
  }
  
  public final void dPc()
  {
    AppMethodBeat.i(126461);
    super.dPc();
    AppMethodBeat.o(126461);
  }
  
  public final void dPf()
  {
    AppMethodBeat.i(126467);
    if (this.ySa != null) {
      this.ySa.setVisibility(8);
    }
    AppMethodBeat.o(126467);
  }
  
  public final void dPg()
  {
    AppMethodBeat.i(126465);
    g localg = this.ySa;
    if (localg.yRo != null) {
      localg.yRo.stopTimer();
    }
    AppMethodBeat.o(126465);
  }
  
  public final void dPk()
  {
    AppMethodBeat.i(126470);
    super.dPk();
    if ((this.yLU.Evh != null) && (this.yLU.Evh.Euk != null))
    {
      this.yQP.setText(this.yLU.Evh.Euk.title);
      this.yQQ.setText(this.yLU.Evh.Euk.desc);
      com.tencent.mm.aw.o.ayJ().a(this.yLU.Evh.Euk.qDs, this.yQR, yNO);
      this.yQO.setVisibility(0);
      i.a(this.yOm.dOH(), this.yLU, 1);
      if (getControlBar().bcB())
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.yQO.getLayoutParams();
        localLayoutParams.bottomMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165298);
        this.yQO.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(126470);
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.yQO.getLayoutParams();
      localLayoutParams.bottomMargin = com.tencent.mm.cd.a.ap(getContext(), 2131165303);
      this.yQO.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(126470);
      return;
    }
    this.yQO.setVisibility(8);
    AppMethodBeat.o(126470);
  }
  
  public final void dPl()
  {
    AppMethodBeat.i(126471);
    super.dPl();
    this.yQO.setVisibility(8);
    AppMethodBeat.o(126471);
  }
  
  public final boolean dPm()
  {
    AppMethodBeat.i(161627);
    if (this.yQO.getVisibility() == 0)
    {
      AppMethodBeat.o(161627);
      return true;
    }
    AppMethodBeat.o(161627);
    return false;
  }
  
  public final g getControlBar()
  {
    return this.ySa;
  }
  
  public final int getLayoutId()
  {
    return 2131495790;
  }
  
  public final a getListItemUIComponent()
  {
    return (a)this.yOE;
  }
  
  public final b getListVideoUIComponent()
  {
    return (b)this.yOm;
  }
  
  public final String getSessionId()
  {
    return this.sessionId;
  }
  
  public final ddb getVideoInfo()
  {
    return this.yLU;
  }
  
  public final h.b getVideoViewCallback()
  {
    return this.yQT;
  }
  
  public final void init()
  {
    AppMethodBeat.i(126460);
    super.init();
    this.ySb = findViewById(2131301594);
    this.ySc = ((TextView)findViewById(2131301593));
    this.yQO = findViewById(2131303343);
    this.yQP = ((TextView)findViewById(2131303344));
    this.yQQ = ((TextView)findViewById(2131303341));
    this.yQR = ((ImageView)findViewById(2131303342));
    this.yQS = ((ImageView)findViewById(2131303340));
    this.yQI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126429);
        f.this.getListVideoUIComponent().bcC();
        AppMethodBeat.o(126429);
      }
    };
    this.yOt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126436);
        if (f.a(f.this) == com.tencent.mm.plugin.topstory.ui.video.f.a.yOI)
        {
          f.this.getListVideoUIComponent().dOE().yPO = true;
          f.b(f.this).Pj(2);
        }
        if (f.this.getListVideoUIComponent().dOE().isConnected())
        {
          f.a(f.this, com.tencent.mm.plugin.topstory.ui.video.f.a.yOH);
          if (f.this.getListVideoUIComponent().dOJ().yQs)
          {
            f.this.getListVideoUIComponent().dOJ().dzF();
            f.this.dPc();
          }
          for (;;)
          {
            com.tencent.mm.plugin.websearch.api.a.a.lI(19);
            AppMethodBeat.o(126436);
            return;
            f.this.aj(true, false);
          }
        }
        com.tencent.mm.plugin.websearch.api.a.a.lI(20);
        AppMethodBeat.o(126436);
      }
    });
    this.yOr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126437);
        f.this.getListVideoUIComponent().dOF().yQl = 2;
        if ((f.this.getListItemUIComponent() != null) && (f.this.getListItemUIComponent().dOD() == f.this.getListVideoUIComponent().dOM()))
        {
          paramAnonymousView = f.this;
          if (!f.this.getListVideoUIComponent().dOE().yPO) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.aj(bool, false);
            AppMethodBeat.o(126437);
            return;
          }
        }
        f.this.getListVideoUIComponent().Ph(f.c(f.this).dOD());
        f.this.getListVideoUIComponent().dOF().j(f.d(f.this));
        ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().dOH(), f.e(f.this), f.f(f.this).dOD(), 2, "");
        AppMethodBeat.o(126437);
      }
    });
    this.yOs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126438);
        f.this.dPi();
        f.g(f.this).bcH();
        f.this.getListVideoUIComponent().dOF().yQl = 2;
        f.this.getListVideoUIComponent().dOJ().a(f.this.getListVideoUIComponent(), f.h(f.this), f.i(f.this), f.j(f.this).dOD());
        f.this.dPc();
        AppMethodBeat.o(126438);
      }
    });
    this.yOx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126439);
        if ((f.this.getListItemUIComponent() != null) && (f.this.getListItemUIComponent().dOD() != f.this.getListVideoUIComponent().dOM()))
        {
          f.this.getListVideoUIComponent().dOF().yQl = 2;
          f.this.getListVideoUIComponent().Ph(f.k(f.this).dOD());
          f.this.getListVideoUIComponent().dOF().j(f.l(f.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().dOH(), f.m(f.this), f.n(f.this).dOD(), 2, "");
        }
        AppMethodBeat.o(126439);
      }
    });
    this.ySb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126440);
        paramAnonymousView = new dcy();
        paramAnonymousView.scene = f.this.getListVideoUIComponent().dOH().scene;
        paramAnonymousView.qwV = UUID.randomUUID().toString();
        paramAnonymousView.Euw = f.this.getListVideoUIComponent().dOH().jko;
        paramAnonymousView.Eux = f.this.getListVideoUIComponent().dOH().Eux;
        paramAnonymousView.Euu = f.o(f.this).Evf.rNP;
        paramAnonymousView.Euv = f.this.getListVideoUIComponent().dOH().Euv;
        paramAnonymousView.Euz = f.p(f.this).Evf;
        paramAnonymousView.dcm = "topstory";
        paramAnonymousView.jko = f.this.getListVideoUIComponent().dOH().jko;
        paramAnonymousView.Euy = f.q(f.this).EuN;
        paramAnonymousView.Euz.EuW = f.r(f.this).EuW;
        paramAnonymousView.AFX.addAll(f.s(f.this).Evf.AFX);
        aa.a(f.this.getListVideoUIComponent().cKW(), paramAnonymousView);
        AppMethodBeat.o(126440);
      }
    });
    this.yQO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126442);
        paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(aj.getContext());
        paramAnonymousView.aMo(f.this.getContext().getString(2131764484, new Object[] { f.t(f.this).Evh.Euk.Eug })).wZ(true);
        paramAnonymousView.aaF(2131755270);
        paramAnonymousView.c(new f.c()
        {
          public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(126441);
            if (paramAnonymous2Boolean)
            {
              i.a(f.u(f.this).dOH(), f.v(f.this), 2);
              paramAnonymous2String = new com.tencent.mm.plugin.appbrand.a.f();
              paramAnonymous2String.appId = f.w(f.this).Evh.Euk.appId;
              paramAnonymous2String.iJb = f.x(f.this).Evh.Euk.dzJ;
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
    this.yQS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126443);
        f.y(f.this).setVisibility(8);
        i.a(f.z(f.this).dOH(), f.A(f.this), 3);
        AppMethodBeat.o(126443);
      }
    });
    this.yQH = new k(getContext(), this, new a());
    this.ySa = new g(getContext());
    this.ySa.setVisibility(8);
    this.ySa.setFullScreenBtnClickListener(this.yQI);
    this.ySa.setOnUpdateProgressLenListener(new g.a()
    {
      public final void dPS()
      {
        AppMethodBeat.i(126431);
        f.ac(f.this).setVisibility(8);
        RelativeLayout.LayoutParams localLayoutParams;
        if (f.ad(f.this).Evf != null)
        {
          f.P(f.this).setVisibility(0);
          localLayoutParams = (RelativeLayout.LayoutParams)f.P(f.this).getLayoutParams();
          localLayoutParams.bottomMargin = com.tencent.mm.cd.a.ap(f.this.getContext(), 2131165298);
          f.P(f.this).setLayoutParams(localLayoutParams);
        }
        if (f.y(f.this).getVisibility() == 0)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)f.y(f.this).getLayoutParams();
          localLayoutParams.bottomMargin = com.tencent.mm.cd.a.ap(f.this.getContext(), 2131165298);
          f.y(f.this).setLayoutParams(localLayoutParams);
        }
        AppMethodBeat.o(126431);
      }
      
      public final void dPT()
      {
        AppMethodBeat.i(126432);
        if (f.ae(f.this).Evf != null)
        {
          ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "longVideoInfo onControlBarGone");
          f.P(f.this).setVisibility(8);
        }
        if ((f.this.getListVideoUIComponent().dOJ().yQs) && ((f.this.getListVideoUIComponent().dOJ().dPO()) || (f.this.getListVideoUIComponent().dOJ().yQt))) {
          f.af(f.this).setVisibility(0);
        }
        for (;;)
        {
          if (f.y(f.this).getVisibility() == 0)
          {
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)f.y(f.this).getLayoutParams();
            localLayoutParams.bottomMargin = com.tencent.mm.cd.a.ap(f.this.getContext(), 2131165303);
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
          Object localObject = f.this.getListVideoUIComponent().dOF().yQm;
          if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).yLC < f.this.getListVideoUIComponent().dOJ().getCurrPosMs())) {
            ((com.tencent.mm.plugin.topstory.a.b.b)localObject).yLC = f.this.getListVideoUIComponent().dOJ().getCurrPosMs();
          }
          if (f.this.getListVideoUIComponent().dOJ().dPO())
          {
            int j = f.this.getListVideoUIComponent().dOJ().getCurrPosMs() / 1000;
            if (((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(f.R(f.this).rNP)) {
              ((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(f.S(f.this).rNP, Integer.valueOf(j));
            }
          }
          if (!f.g(f.this).bcB())
          {
            localObject = (FrameLayout.LayoutParams)f.T(f.this).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject).width = i;
            f.U(f.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
            f.V(f.this).requestLayout();
            f.W(f.this).setVisibility(0);
          }
          if ((f.X(f.this).EuW & 0x100) <= 0) {
            f.Z(f.this).a(f.Y(f.this), paramAnonymousInt1, paramAnonymousInt2);
          }
          f.ab(f.this).a(f.aa(f.this), f.this, paramAnonymousInt1);
          AppMethodBeat.o(126430);
          return;
        }
      }
    });
    this.ySa.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void bcv()
      {
        AppMethodBeat.i(126433);
        ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekPre");
        f.g(f.this).bGT();
        AppMethodBeat.o(126433);
      }
      
      public final void rZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(126434);
        ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        f.this.seekTo(paramAnonymousInt);
        f.g(f.this).bcH();
        com.tencent.mm.plugin.websearch.api.a.a.lI(22);
        AppMethodBeat.o(126434);
      }
    });
    this.ySa.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126435);
        if (f.this.getListVideoUIComponent().dOJ().yQs)
        {
          if (f.g(f.this).getVideoTotalTime() - f.g(f.this).getmPosition() < 2)
          {
            ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "cannot change play status in last 2 seconds");
            AppMethodBeat.o(126435);
            return;
          }
          f.this.getListVideoUIComponent().dOF().j(f.ah(f.this));
          if (f.this.getListVideoUIComponent().dOJ().dPO())
          {
            f.this.getListVideoUIComponent().dOJ().ckd();
            f.g(f.this).bGT();
          }
          for (;;)
          {
            f.this.dPc();
            AppMethodBeat.o(126435);
            return;
            f.this.getListVideoUIComponent().dOJ().dzF();
            f.g(f.this).bcH();
          }
        }
        ad.i("MicroMsg.TopStory.TopStoryListVideoContainer", "no video play now");
        AppMethodBeat.o(126435);
      }
    });
    AppMethodBeat.o(126460);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126468);
    if (this.yQH != null) {
      this.yQH.A(paramMotionEvent);
    }
    AppMethodBeat.o(126468);
    return true;
  }
  
  final class a
    implements c
  {
    private float yQX;
    
    a()
    {
      AppMethodBeat.i(126451);
      this.yQX = com.tencent.mm.cd.a.hW(f.this.getContext());
      AppMethodBeat.o(126451);
    }
    
    public final void Pk(int paramInt)
    {
      AppMethodBeat.i(126456);
      f.g(f.this).dPV();
      f.al(f.this).setVisibility(8);
      f.this.seekTo(paramInt);
      AppMethodBeat.o(126456);
    }
    
    public final void bcn()
    {
      AppMethodBeat.i(126452);
      ad.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onSingleTap");
      if (f.ai(f.this))
      {
        if (f.g(f.this).bcB())
        {
          f.g(f.this).setVisibility(8);
          AppMethodBeat.o(126452);
          return;
        }
        f.g(f.this).show();
        if (f.this.getListItemUIComponent() != null)
        {
          f.this.getListItemUIComponent().dOC();
          f.this.getListItemUIComponent().dOB();
        }
      }
      AppMethodBeat.o(126452);
    }
    
    public final void bco()
    {
      AppMethodBeat.i(126453);
      ad.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onDoubleTap");
      AppMethodBeat.o(126453);
    }
    
    public final void bcp()
    {
      AppMethodBeat.i(126454);
      f.aj(f.this).setVisibility(0);
      f.g(f.this).dPU();
      AppMethodBeat.o(126454);
    }
    
    public final int by(float paramFloat)
    {
      AppMethodBeat.i(126455);
      paramFloat /= this.yQX;
      int j = f.this.getListVideoUIComponent().dOJ().getVideoDurationSec();
      int i = getCurrentPosition();
      int k = (int)(paramFloat * j) + i;
      if (k < 0) {
        i = 0;
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.websearch.ui.a.mz(j * 1000L);
        f.ak(f.this).setText(com.tencent.mm.plugin.websearch.ui.a.mz(i * 1000L) + "/" + str);
        AppMethodBeat.o(126455);
        return i;
        i = k;
        if (k > j) {
          i = j;
        }
      }
    }
    
    public final boolean dOY()
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
      int i = f.this.getListVideoUIComponent().dOJ().getCurrPosSec();
      AppMethodBeat.o(126458);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f
 * JD-Core Version:    0.7.0.1
 */