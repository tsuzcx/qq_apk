package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.ctk;
import com.tencent.mm.protocal.protobuf.dct;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.ddd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;
import java.util.LinkedList;

public class e
  extends com.tencent.mm.plugin.topstory.ui.video.f
{
  private boolean isLoading;
  protected f yQG;
  protected k yQH;
  protected View.OnClickListener yQI;
  protected View.OnClickListener yQJ;
  protected View.OnClickListener yQK;
  protected View.OnClickListener yQL;
  protected View.OnClickListener yQM;
  protected View.OnClickListener yQN;
  private View yQO;
  private TextView yQP;
  private TextView yQQ;
  private ImageView yQR;
  private ImageView yQS;
  private h.b yQT;
  
  public e(Context paramContext, com.tencent.mm.plugin.topstory.ui.video.b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    AppMethodBeat.i(126286);
    this.yQT = new h.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int j = 0;
        AppMethodBeat.i(126257);
        ad.e("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        paramAnonymousString2 = e.D(e.this).dOT().Pq(e.C(e.this).dOM());
        if ((paramAnonymousString2 != null) && (paramAnonymousString2.EuV != null))
        {
          ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousString2.EuV.size()), paramAnonymousString2.videoUrl, Integer.valueOf(paramAnonymousString2.Eve) });
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
              ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", new Object[] { Integer.valueOf(i), localddd.url, Integer.valueOf(localddd.Eve) });
              com.tencent.mm.plugin.websearch.api.a.b.lI(com.tencent.mm.plugin.websearch.api.a.b.AHQ);
              e.this.postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(126256);
                  e.this.aj(true, true);
                  AppMethodBeat.o(126256);
                }
              }, 100L);
              AppMethodBeat.o(126257);
              return;
            }
            i += 1;
          }
        }
        e.G(e.this).dOT().a(e.E(e.this).dOH(), e.F(e.this).dOM());
        e.this.jv(e.this.getContext().getString(2131764672, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), e.this.getContext().getString(2131764699));
        e.this.getFSVideoUIComponent().dOJ().onError(paramAnonymousString1);
        i.Pd(paramAnonymousInt1);
        paramAnonymousString1 = e.this.getFSVideoUIComponent().dOF().yQm;
        paramAnonymousInt2 = j;
        if (paramAnonymousString1 != null)
        {
          paramAnonymousInt2 = j;
          if (paramAnonymousString1.yLz > 0L) {
            paramAnonymousInt2 = (int)(System.currentTimeMillis() - paramAnonymousString1.yLz) / 1000;
          }
        }
        i.a(paramAnonymousString2, paramAnonymousInt1, paramAnonymousString3, paramAnonymousInt2);
        AppMethodBeat.o(126257);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126260);
        ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(126260);
      }
      
      public final void db(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126258);
        ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onPrepared");
        e.this.yQH.bee();
        if (!e.H(e.this)) {
          e.this.dPc();
        }
        AppMethodBeat.o(126258);
      }
      
      public final void dc(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126259);
        ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoEnded");
        e.this.getFSVideoUIComponent().dOJ().asK(paramAnonymousString1);
        e.this.getFSVideoUIComponent().dOF().yQl = 1;
        int i = e.this.getFSVideoUIComponent().dOX();
        ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "clicfg_topstory_v_video_play  %s", new Object[] { Integer.valueOf(i) });
        if ((i == 1) && (e.this.getFSVideoUIComponent().dOQ()) && ((e.I(e.this) instanceof j))) {}
        try
        {
          Thread.sleep(100L);
          ((j)e.J(e.this)).rf(true);
          ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "VVideoAutoPlay replay succ");
          bool = true;
          if ((bool) || (!(e.L(e.this) instanceof com.tencent.mm.plugin.topstory.ui.video.h))) {}
        }
        catch (InterruptedException paramAnonymousString1)
        {
          try
          {
            for (;;)
            {
              Thread.sleep(100L);
              label166:
              ((com.tencent.mm.plugin.topstory.ui.video.h)e.M(e.this)).rf(true);
              e.a(e.this, false);
              AppMethodBeat.o(126259);
              return;
              boolean bool = e.this.getFSVideoUIComponent().Ph(e.K(e.this).dOD() + 1);
            }
            paramAnonymousString1 = paramAnonymousString1;
          }
          catch (InterruptedException paramAnonymousString1)
          {
            break label166;
          }
        }
      }
      
      public final void dd(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void de(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dg(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126261);
        ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaiting");
        e.a(e.this, true);
        AppMethodBeat.o(126261);
      }
      
      public final void dh(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126262);
        ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaitingEnd");
        e.a(e.this, false);
        e.this.dPc();
        paramAnonymousString1 = e.this.getFSVideoUIComponent().dOF().yQm;
        if ((paramAnonymousString1 != null) && (paramAnonymousString1.yLK == 0L))
        {
          paramAnonymousString1.yLK = (System.currentTimeMillis() - paramAnonymousString1.yLz);
          ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramAnonymousString1.yLH), Long.valueOf(paramAnonymousString1.yLK) });
        }
        AppMethodBeat.o(126262);
      }
      
      public final void jw(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    if (this.yOm.dOQ()) {
      this.nMg.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    AppMethodBeat.o(126286);
  }
  
  private boolean bck()
  {
    AppMethodBeat.i(126298);
    if (this.yOx.getVisibility() == 0)
    {
      AppMethodBeat.o(126298);
      return true;
    }
    AppMethodBeat.o(126298);
    return false;
  }
  
  public final void bGO()
  {
    AppMethodBeat.i(126295);
    if (this.yQG != null) {
      this.yQG.show();
    }
    AppMethodBeat.o(126295);
  }
  
  protected void bcd()
  {
    AppMethodBeat.i(126296);
    this.yQH = new k(getContext(), this, new a());
    AppMethodBeat.o(126296);
  }
  
  public h.e c(ddb paramddb)
  {
    return h.e.BVs;
  }
  
  public void cE()
  {
    AppMethodBeat.i(126293);
    super.cE();
    if (this.yQG != null)
    {
      this.yQG.setVideoTotalTime(this.yLU.xot);
      this.yQG.m(this.yLU);
    }
    if ((getFSItemUIComponent() != null) && (getFSItemUIComponent().dOD() != getFSVideoUIComponent().dOM()))
    {
      if (!getFSVideoUIComponent().dOE().isConnected()) {
        break label130;
      }
      dPd();
    }
    for (;;)
    {
      if (this.titleTv != null)
      {
        this.titleTv.setText(this.yLU.title);
        ai.a(this.titleTv.getPaint(), 0.8F);
      }
      AppMethodBeat.o(126293);
      return;
      label130:
      jv(getNoNetTip(), getContext().getString(2131764699));
    }
  }
  
  protected void dPQ()
  {
    AppMethodBeat.i(126289);
    this.yQG.l(this.yLU);
    AppMethodBeat.o(126289);
  }
  
  public boolean dPR()
  {
    return false;
  }
  
  public final void dPa()
  {
    AppMethodBeat.i(126290);
    ad.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollPlayContainerStatus");
    this.yOx.setVisibility(8);
    this.yOw.setVisibility(8);
    this.nMg.setVisibility(0);
    this.yOo.setVisibility(8);
    this.yOn.setVisibility(8);
    this.yOB.setVisibility(8);
    AppMethodBeat.o(126290);
  }
  
  public final void dPb()
  {
    AppMethodBeat.i(126291);
    ad.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollStopContainerStatus");
    this.yOx.setVisibility(0);
    if ((getFSVideoUIComponent().dOE().dPC()) && (!com.tencent.mm.plugin.topstory.a.h.dNW())) {
      this.yOw.setVisibility(0);
    }
    for (;;)
    {
      this.nMg.setVisibility(0);
      this.yOo.setVisibility(8);
      this.yOn.setVisibility(8);
      this.yOB.setVisibility(8);
      this.yOz.setVisibility(0);
      this.yOy.setVisibility(8);
      this.yOr.setVisibility(0);
      this.yOs.setVisibility(8);
      this.yOv.setVisibility(8);
      AppMethodBeat.o(126291);
      return;
      this.yOw.setVisibility(8);
    }
  }
  
  public final void dPc()
  {
    AppMethodBeat.i(126288);
    super.dPc();
    AppMethodBeat.o(126288);
  }
  
  public final void dPf()
  {
    AppMethodBeat.i(126294);
    if (this.yQG != null) {
      this.yQG.setVisibility(8);
    }
    AppMethodBeat.o(126294);
  }
  
  public final void dPg()
  {
    AppMethodBeat.i(126292);
    f localf = this.yQG;
    if (localf.yRo != null) {
      localf.yRo.stopTimer();
    }
    AppMethodBeat.o(126292);
  }
  
  public final void dPk()
  {
    AppMethodBeat.i(126299);
    super.dPk();
    if (dPR())
    {
      AppMethodBeat.o(126299);
      return;
    }
    if ((this.yLU.Evh != null) && (this.yLU.Evh.Euk != null))
    {
      this.yQP.setText(this.yLU.Evh.Euk.title);
      this.yQQ.setText(this.yLU.Evh.Euk.desc);
      com.tencent.mm.aw.o.ayJ().a(this.yLU.Evh.Euk.qDs, this.yQR, yNO);
      this.yQO.setVisibility(0);
      i.a(this.yOm.dOH(), this.yLU, 1);
      AppMethodBeat.o(126299);
      return;
    }
    this.yQO.setVisibility(8);
    AppMethodBeat.o(126299);
  }
  
  public final void dPl()
  {
    AppMethodBeat.i(126300);
    super.dPl();
    if (dPR())
    {
      AppMethodBeat.o(126300);
      return;
    }
    this.yQO.setVisibility(8);
    AppMethodBeat.o(126300);
  }
  
  public final boolean dPm()
  {
    AppMethodBeat.i(161624);
    if (this.yQO != null)
    {
      if (this.yQO.getVisibility() == 0)
      {
        AppMethodBeat.o(161624);
        return true;
      }
      AppMethodBeat.o(161624);
      return false;
    }
    AppMethodBeat.o(161624);
    return false;
  }
  
  public f getControlBar()
  {
    return this.yQG;
  }
  
  public a getFSItemUIComponent()
  {
    return (a)this.yOE;
  }
  
  public com.tencent.mm.plugin.topstory.ui.video.b getFSVideoUIComponent()
  {
    return this.yOm;
  }
  
  public int getLayoutId()
  {
    return 2131495777;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public ddb getVideoInfo()
  {
    return this.yLU;
  }
  
  public h.b getVideoViewCallback()
  {
    return this.yQT;
  }
  
  public void init()
  {
    AppMethodBeat.i(126287);
    super.init();
    if (!dPR())
    {
      this.yQO = findViewById(2131303343);
      this.yQP = ((TextView)findViewById(2131303344));
      this.yQQ = ((TextView)findViewById(2131303341));
      this.yQR = ((ImageView)findViewById(2131303342));
      this.yQS = ((ImageView)findViewById(2131303340));
    }
    this.yQI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126251);
        e.this.getFSVideoUIComponent().cMY();
        AppMethodBeat.o(126251);
      }
    };
    this.yQJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126270);
        e.this.getFSVideoUIComponent().aq(paramAnonymousView, e.a(e.this).dOD());
        AppMethodBeat.o(126270);
      }
    };
    this.yQK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126271);
        e.this.getFSItemUIComponent().Ps(e.b(e.this).dOD());
        AppMethodBeat.o(126271);
      }
    };
    this.yQL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126272);
        e.this.getFSVideoUIComponent().a(e.c(e.this), paramAnonymousView);
        e.this.dPQ();
        if (!e.this.dPR()) {
          e.d(e.this).setVisibility(8);
        }
        AppMethodBeat.o(126272);
      }
    };
    this.yQM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126273);
        com.tencent.mm.plugin.topstory.ui.video.b localb = e.this.getFSVideoUIComponent();
        e.e(e.this).dOD();
        localb.a((ctk)paramAnonymousView.getTag());
        AppMethodBeat.o(126273);
      }
    };
    this.yQN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126274);
        if ((e.f(e.this) != null) && (!bt.isNullOrNil(e.g(e.this).kqB)))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", e.h(e.this).kqB);
          d.b(e.this.getFSVideoUIComponent().cKW().getApplicationContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        }
        AppMethodBeat.o(126274);
      }
    };
    this.yOt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126275);
        if (e.i(e.this) == com.tencent.mm.plugin.topstory.ui.video.f.a.yOI)
        {
          e.this.getFSVideoUIComponent().dOE().yPO = true;
          e.j(e.this).Pj(2);
        }
        if (e.this.getFSVideoUIComponent().dOE().isConnected())
        {
          e.a(e.this, com.tencent.mm.plugin.topstory.ui.video.f.a.yOH);
          if (e.this.getFSVideoUIComponent().dOJ().yQs) {
            e.this.getFSVideoUIComponent().dOJ().dzF();
          }
          for (;;)
          {
            com.tencent.mm.plugin.websearch.api.a.a.lI(19);
            AppMethodBeat.o(126275);
            return;
            e.this.aj(true, false);
          }
        }
        com.tencent.mm.plugin.websearch.api.a.a.lI(20);
        AppMethodBeat.o(126275);
      }
    });
    this.yOr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126276);
        e.this.getFSVideoUIComponent().dOF().yQl = 2;
        if ((e.this.getFSItemUIComponent() != null) && (e.this.getFSItemUIComponent().dOD() == e.this.getFSVideoUIComponent().dOM()))
        {
          paramAnonymousView = e.this;
          if (!e.this.getFSVideoUIComponent().dOE().yPO) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.aj(bool, false);
            AppMethodBeat.o(126276);
            return;
          }
        }
        e.this.getFSVideoUIComponent().Ph(e.k(e.this).dOD());
        e.this.getFSVideoUIComponent().dOF().j(e.l(e.this));
        ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().dOH(), e.m(e.this), e.n(e.this).dOD(), 2, "");
        AppMethodBeat.o(126276);
      }
    });
    this.yOs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126277);
        e.this.dPi();
        e.this.yQG.bcH();
        e.this.getFSVideoUIComponent().dOF().yQl = 2;
        e.this.getFSVideoUIComponent().dOJ().a(e.this.getFSVideoUIComponent(), e.o(e.this), e.p(e.this), e.q(e.this).dOD());
        e.this.dPc();
        AppMethodBeat.o(126277);
      }
    });
    this.yOx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126252);
        if ((e.this.getFSItemUIComponent() != null) && (e.this.getFSItemUIComponent().dOD() != e.this.getFSVideoUIComponent().dOM()))
        {
          e.this.getFSVideoUIComponent().dOF().yQl = 2;
          e.this.getFSVideoUIComponent().Ph(e.r(e.this).dOD());
          e.this.getFSVideoUIComponent().dOF().j(e.s(e.this));
          ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().dOH(), e.t(e.this), e.u(e.this).dOD(), 2, "");
        }
        AppMethodBeat.o(126252);
      }
    });
    if (!dPR())
    {
      this.yQO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126254);
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(aj.getContext());
          paramAnonymousView.aMo(e.this.getContext().getString(2131764484, new Object[] { e.v(e.this).Evh.Euk.Eug })).wZ(true);
          paramAnonymousView.aaF(2131755270);
          paramAnonymousView.c(new f.c()
          {
            public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(126253);
              if (paramAnonymous2Boolean)
              {
                i.a(e.w(e.this).dOH(), e.x(e.this), 2);
                paramAnonymous2String = new com.tencent.mm.plugin.appbrand.a.f();
                paramAnonymous2String.appId = e.y(e.this).Evh.Euk.appId;
                paramAnonymous2String.iJb = e.z(e.this).Evh.Euk.dzJ;
                paramAnonymous2String.scene = 1152;
                ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(e.this.getContext(), paramAnonymous2String);
                e.d(e.this).setVisibility(8);
              }
              AppMethodBeat.o(126253);
            }
          }).show();
          AppMethodBeat.o(126254);
        }
      });
      this.yQS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126255);
          e.d(e.this).setVisibility(8);
          i.a(e.A(e.this).dOH(), e.B(e.this), 3);
          AppMethodBeat.o(126255);
        }
      });
    }
    bcd();
    if (getFSVideoUIComponent().dOQ()) {
      this.yQG = new l(getContext());
    }
    for (;;)
    {
      this.yQG.setOnlyFS(dPR());
      this.yQG.setVisibility(8);
      this.yQG.setShareBtnClickListener(this.yQK);
      this.yQG.setWowBtnClickListener(this.yQL);
      this.yQG.setTagBtnClickListener(this.yQM);
      this.yQG.setSourceItemClickListener(this.yQN);
      if (com.tencent.mm.plugin.topstory.a.h.dNT()) {
        this.yQG.setTitleClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(126263);
            e.this.getFSVideoUIComponent().dOJ().yQu = true;
            AppMethodBeat.o(126263);
          }
        });
      }
      this.yQG.setOnUpdateProgressLenListener(new f.a()
      {
        public final void b(ddb paramAnonymousddb, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(126264);
          if (paramAnonymousInt2 > 0) {}
          for (int i = e.N(e.this).getWidth() * paramAnonymousInt1 / paramAnonymousInt2;; i = 0)
          {
            Object localObject = e.this.getFSVideoUIComponent().dOF().yQm;
            if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).yLC < e.this.getFSVideoUIComponent().dOJ().getCurrPosMs())) {
              ((com.tencent.mm.plugin.topstory.a.b.b)localObject).yLC = e.this.getFSVideoUIComponent().dOJ().getCurrPosMs();
            }
            if (e.O(e.this).dOJ().dPO())
            {
              int j = e.P(e.this).dOJ().getCurrPosMs() / 1000;
              if (((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(paramAnonymousddb.rNP)) {
                ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(paramAnonymousddb.rNP, Integer.valueOf(j));
              }
            }
            localObject = (FrameLayout.LayoutParams)e.Q(e.this).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject).width = i;
            e.R(e.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
            e.S(e.this).requestLayout();
            if (!e.this.yQG.bcB()) {
              e.this.yQG.setVisibility(8);
            }
            if ((paramAnonymousddb.EuW & 0x100) <= 0) {
              e.T(e.this).a(paramAnonymousddb, paramAnonymousInt1, paramAnonymousInt2);
            }
            e.U(e.this).a(paramAnonymousddb, e.this, paramAnonymousInt1);
            AppMethodBeat.o(126264);
            return;
          }
        }
        
        public final void dPS()
        {
          AppMethodBeat.i(126265);
          e.V(e.this).setVisibility(8);
          AppMethodBeat.o(126265);
        }
        
        public final void dPT()
        {
          AppMethodBeat.i(126266);
          if ((e.this.getFSVideoUIComponent().dOJ().yQs) && ((e.this.getFSVideoUIComponent().dOJ().dPO()) || (e.this.getFSVideoUIComponent().dOJ().yQt)))
          {
            e.W(e.this).setVisibility(0);
            AppMethodBeat.o(126266);
            return;
          }
          e.X(e.this).setVisibility(8);
          AppMethodBeat.o(126266);
        }
      });
      this.yQG.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
      {
        public final void bcv()
        {
          AppMethodBeat.i(126267);
          ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekPre");
          e.this.yQG.bGT();
          AppMethodBeat.o(126267);
        }
        
        public final void rZ(int paramAnonymousInt)
        {
          AppMethodBeat.i(126268);
          ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          e.this.seekTo(paramAnonymousInt);
          e.this.yQG.bcH();
          com.tencent.mm.plugin.websearch.api.a.a.lI(22);
          AppMethodBeat.o(126268);
        }
      });
      this.yQG.setOnPlayButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126269);
          if (e.this.getFSVideoUIComponent().dOJ().yQs)
          {
            if ((!(e.this.yQG instanceof l)) && (e.this.yQG.getVideoTotalTime() - e.this.yQG.getmPosition() < 2))
            {
              ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "cannot change play status in last 2 seconds");
              AppMethodBeat.o(126269);
              return;
            }
            e.this.getFSVideoUIComponent().dOF().j(e.Y(e.this));
            if (e.this.getFSVideoUIComponent().dOJ().dPO())
            {
              e.this.getFSVideoUIComponent().dOJ().ckd();
              e.this.yQG.bGT();
            }
            for (;;)
            {
              e.this.dPc();
              AppMethodBeat.o(126269);
              return;
              e.this.getFSVideoUIComponent().dOJ().dzF();
              e.this.yQG.bcH();
            }
          }
          ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "no video play now");
          AppMethodBeat.o(126269);
        }
      });
      AppMethodBeat.o(126287);
      return;
      this.yQG = new f(getContext());
      if (ai.aF(getContext()))
      {
        f localf = this.yQG;
        int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
        int j = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
        localf.yRc.setPadding(i, 0, j, 0);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126297);
    if (this.yQH != null) {
      this.yQH.A(paramMotionEvent);
    }
    AppMethodBeat.o(126297);
    return true;
  }
  
  public class a
    implements c
  {
    private float yQX;
    
    a()
    {
      AppMethodBeat.i(126278);
      this.yQX = com.tencent.mm.cd.a.hW(e.this.getContext());
      AppMethodBeat.o(126278);
    }
    
    public void Pk(int paramInt)
    {
      AppMethodBeat.i(126283);
      e.this.yQG.dPV();
      e.ac(e.this).setVisibility(8);
      e.this.seekTo(paramInt);
      AppMethodBeat.o(126283);
    }
    
    public final void bcn()
    {
      AppMethodBeat.i(126279);
      ad.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSingleTap");
      if (e.Z(e.this))
      {
        if (e.this.yQG.bcB())
        {
          e.this.yQG.setVisibility(8);
          AppMethodBeat.o(126279);
          return;
        }
        e.this.yQG.show();
        if (e.this.getFSItemUIComponent() != null)
        {
          e.this.getFSItemUIComponent().dOC();
          e.this.getFSItemUIComponent().dOB();
        }
      }
      AppMethodBeat.o(126279);
    }
    
    public final void bco()
    {
      AppMethodBeat.i(126280);
      ad.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onDoubleTap");
      AppMethodBeat.o(126280);
    }
    
    public void bcp()
    {
      AppMethodBeat.i(126281);
      e.aa(e.this).setVisibility(0);
      e.this.yQG.dPU();
      AppMethodBeat.o(126281);
    }
    
    public int by(float paramFloat)
    {
      AppMethodBeat.i(126282);
      paramFloat /= this.yQX;
      int j = e.this.getFSVideoUIComponent().dOJ().getVideoDurationSec();
      int i = getCurrentPosition();
      int k = (int)(paramFloat * j) + i;
      if (k < 0) {
        i = 0;
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.websearch.ui.a.mz(j * 1000L);
        e.ab(e.this).setText(com.tencent.mm.plugin.websearch.ui.a.mz(i * 1000L) + "/" + str);
        AppMethodBeat.o(126282);
        return i;
        i = k;
        if (k > j) {
          i = j;
        }
      }
    }
    
    public final boolean dOY()
    {
      AppMethodBeat.i(126284);
      if (e.ad(e.this))
      {
        AppMethodBeat.o(126284);
        return false;
      }
      AppMethodBeat.o(126284);
      return true;
    }
    
    public final int getCurrentPosition()
    {
      AppMethodBeat.i(126285);
      int i = e.this.getFSVideoUIComponent().dOJ().getCurrPosSec();
      AppMethodBeat.o(126285);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e
 * JD-Core Version:    0.7.0.1
 */