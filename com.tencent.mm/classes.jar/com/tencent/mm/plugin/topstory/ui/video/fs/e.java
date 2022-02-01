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
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.dig;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;
import java.util.LinkedList;

public class e
  extends com.tencent.mm.plugin.topstory.ui.video.f
{
  protected View.OnClickListener AeA;
  protected View.OnClickListener AeB;
  protected View.OnClickListener AeC;
  protected View.OnClickListener AeD;
  private View AeE;
  private TextView AeF;
  private TextView AeG;
  private ImageView AeH;
  private ImageView AeI;
  protected f Aew;
  protected k Aex;
  protected View.OnClickListener Aey;
  protected View.OnClickListener Aez;
  private boolean isLoading;
  private h.b rRH;
  
  public e(Context paramContext, com.tencent.mm.plugin.topstory.ui.video.b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    AppMethodBeat.i(126286);
    this.rRH = new h.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int j = 0;
        AppMethodBeat.i(126257);
        ac.e("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        paramAnonymousString2 = e.D(e.this).edt().Rw(e.C(e.this).edm());
        if ((paramAnonymousString2 != null) && (paramAnonymousString2.FRW != null))
        {
          ac.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousString2.FRW.size()), paramAnonymousString2.videoUrl, Integer.valueOf(paramAnonymousString2.FSf) });
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
              ac.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", new Object[] { Integer.valueOf(i), localdiq.url, Integer.valueOf(localdiq.FSf) });
              com.tencent.mm.plugin.websearch.api.a.b.lA(com.tencent.mm.plugin.websearch.api.a.b.Cah);
              e.this.postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(126256);
                  e.this.am(true, true);
                  AppMethodBeat.o(126256);
                }
              }, 100L);
              AppMethodBeat.o(126257);
              return;
            }
            i += 1;
          }
        }
        e.G(e.this).edt().a(e.E(e.this).edh(), e.F(e.this).edm());
        e.this.jT(e.this.getContext().getString(2131764672, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), e.this.getContext().getString(2131764699));
        e.this.getFSVideoUIComponent().edj().onError(paramAnonymousString1);
        i.Rj(paramAnonymousInt1);
        paramAnonymousString1 = e.this.getFSVideoUIComponent().edf().Aec;
        paramAnonymousInt2 = j;
        if (paramAnonymousString1 != null)
        {
          paramAnonymousInt2 = j;
          if (paramAnonymousString1.zZs > 0L) {
            paramAnonymousInt2 = (int)(System.currentTimeMillis() - paramAnonymousString1.zZs) / 1000;
          }
        }
        i.a(paramAnonymousString2, paramAnonymousInt1, paramAnonymousString3, paramAnonymousInt2);
        AppMethodBeat.o(126257);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126260);
        ac.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(126260);
      }
      
      public final void jdMethod_do(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126258);
        ac.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onPrepared");
        e.this.Aex.bkY();
        if (!e.H(e.this)) {
          e.this.edC();
        }
        AppMethodBeat.o(126258);
      }
      
      public final void dp(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126259);
        ac.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoEnded");
        e.this.getFSVideoUIComponent().edj().axT(paramAnonymousString1);
        e.this.getFSVideoUIComponent().edf().Aeb = 1;
        int i = e.this.getFSVideoUIComponent().edx();
        ac.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "clicfg_topstory_v_video_play  %s", new Object[] { Integer.valueOf(i) });
        if ((i == 1) && (e.this.getFSVideoUIComponent().edq()) && ((e.I(e.this) instanceof j))) {}
        try
        {
          Thread.sleep(100L);
          ((j)e.J(e.this)).sd(true);
          ac.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "VVideoAutoPlay replay succ");
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
              ((com.tencent.mm.plugin.topstory.ui.video.h)e.M(e.this)).sd(true);
              e.a(e.this, false);
              AppMethodBeat.o(126259);
              return;
              boolean bool = e.this.getFSVideoUIComponent().Rn(e.K(e.this).edd() + 1);
            }
            paramAnonymousString1 = paramAnonymousString1;
          }
          catch (InterruptedException paramAnonymousString1)
          {
            break label166;
          }
        }
      }
      
      public final void dq(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dr(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126261);
        ac.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaiting");
        e.a(e.this, true);
        AppMethodBeat.o(126261);
      }
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126262);
        ac.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaitingEnd");
        e.a(e.this, false);
        e.this.edC();
        paramAnonymousString1 = e.this.getFSVideoUIComponent().edf().Aec;
        if ((paramAnonymousString1 != null) && (paramAnonymousString1.zZD == 0L))
        {
          paramAnonymousString1.zZD = (System.currentTimeMillis() - paramAnonymousString1.zZs);
          ac.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramAnonymousString1.zZA), Long.valueOf(paramAnonymousString1.zZD) });
        }
        AppMethodBeat.o(126262);
      }
      
      public final void eJ(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    if (this.Acd.edq()) {
      this.opg.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    AppMethodBeat.o(126286);
  }
  
  private boolean bjf()
  {
    AppMethodBeat.i(126298);
    if (this.Aco.getVisibility() == 0)
    {
      AppMethodBeat.o(126298);
      return true;
    }
    AppMethodBeat.o(126298);
    return false;
  }
  
  public final void bOb()
  {
    AppMethodBeat.i(126295);
    if (this.Aew != null) {
      this.Aew.show();
    }
    AppMethodBeat.o(126295);
  }
  
  protected void biY()
  {
    AppMethodBeat.i(126296);
    this.Aex = new k(getContext(), this, new a());
    AppMethodBeat.o(126296);
  }
  
  public h.e c(dio paramdio)
  {
    return h.e.DnJ;
  }
  
  public void cL()
  {
    AppMethodBeat.i(126293);
    super.cL();
    if (this.Aew != null)
    {
      this.Aew.setVideoTotalTime(this.zZN.yBk);
      this.Aew.m(this.zZN);
    }
    if ((getFSItemUIComponent() != null) && (getFSItemUIComponent().edd() != getFSVideoUIComponent().edm()))
    {
      if (!getFSVideoUIComponent().ede().isConnected()) {
        break label130;
      }
      edD();
    }
    for (;;)
    {
      if (this.titleTv != null)
      {
        this.titleTv.setText(this.zZN.title);
        aj.a(this.titleTv.getPaint(), 0.8F);
      }
      AppMethodBeat.o(126293);
      return;
      label130:
      jT(getNoNetTip(), getContext().getString(2131764699));
    }
  }
  
  public final void edA()
  {
    AppMethodBeat.i(126290);
    ac.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollPlayContainerStatus");
    this.Aco.setVisibility(8);
    this.Acn.setVisibility(8);
    this.opg.setVisibility(0);
    this.Acf.setVisibility(8);
    this.Ace.setVisibility(8);
    this.Acs.setVisibility(8);
    AppMethodBeat.o(126290);
  }
  
  public final void edB()
  {
    AppMethodBeat.i(126291);
    ac.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollStopContainerStatus");
    this.Aco.setVisibility(0);
    if ((getFSVideoUIComponent().ede().eeb()) && (!com.tencent.mm.plugin.topstory.a.h.ecw())) {
      this.Acn.setVisibility(0);
    }
    for (;;)
    {
      this.opg.setVisibility(0);
      this.Acf.setVisibility(8);
      this.Ace.setVisibility(8);
      this.Acs.setVisibility(8);
      this.Acq.setVisibility(0);
      this.Acp.setVisibility(8);
      this.Aci.setVisibility(0);
      this.Acj.setVisibility(8);
      this.Acm.setVisibility(8);
      AppMethodBeat.o(126291);
      return;
      this.Acn.setVisibility(8);
    }
  }
  
  public final void edC()
  {
    AppMethodBeat.i(126288);
    super.edC();
    AppMethodBeat.o(126288);
  }
  
  public final void edF()
  {
    AppMethodBeat.i(126294);
    if (this.Aew != null) {
      this.Aew.setVisibility(8);
    }
    AppMethodBeat.o(126294);
  }
  
  public final void edG()
  {
    AppMethodBeat.i(126292);
    f localf = this.Aew;
    if (localf.Afd != null) {
      localf.Afd.stopTimer();
    }
    AppMethodBeat.o(126292);
  }
  
  public final void edK()
  {
    AppMethodBeat.i(126299);
    super.edK();
    if (eeq())
    {
      AppMethodBeat.o(126299);
      return;
    }
    if ((this.zZN.FSi != null) && (this.zZN.FSi.FRl != null))
    {
      this.AeF.setText(this.zZN.FSi.FRl.title);
      this.AeG.setText(this.zZN.FSi.FRl.desc);
      com.tencent.mm.av.o.aFB().a(this.zZN.FSi.FRl.ruB, this.AeH, AbF);
      this.AeE.setVisibility(0);
      i.a(this.Acd.edh(), this.zZN, 1);
      AppMethodBeat.o(126299);
      return;
    }
    this.AeE.setVisibility(8);
    AppMethodBeat.o(126299);
  }
  
  public final void edL()
  {
    AppMethodBeat.i(126300);
    super.edL();
    if (eeq())
    {
      AppMethodBeat.o(126300);
      return;
    }
    this.AeE.setVisibility(8);
    AppMethodBeat.o(126300);
  }
  
  public final boolean edM()
  {
    AppMethodBeat.i(161624);
    if (this.AeE != null)
    {
      if (this.AeE.getVisibility() == 0)
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
  
  protected void eep()
  {
    AppMethodBeat.i(126289);
    this.Aew.l(this.zZN);
    AppMethodBeat.o(126289);
  }
  
  public boolean eeq()
  {
    return false;
  }
  
  public f getControlBar()
  {
    return this.Aew;
  }
  
  public a getFSItemUIComponent()
  {
    return (a)this.Acv;
  }
  
  public com.tencent.mm.plugin.topstory.ui.video.b getFSVideoUIComponent()
  {
    return this.Acd;
  }
  
  public int getLayoutId()
  {
    return 2131495777;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public dio getVideoInfo()
  {
    return this.zZN;
  }
  
  public h.b getVideoViewCallback()
  {
    return this.rRH;
  }
  
  public void init()
  {
    AppMethodBeat.i(126287);
    super.init();
    if (!eeq())
    {
      this.AeE = findViewById(2131303343);
      this.AeF = ((TextView)findViewById(2131303344));
      this.AeG = ((TextView)findViewById(2131303341));
      this.AeH = ((ImageView)findViewById(2131303342));
      this.AeI = ((ImageView)findViewById(2131303340));
    }
    this.Aey = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126251);
        e.this.getFSVideoUIComponent().cWw();
        AppMethodBeat.o(126251);
      }
    };
    this.Aez = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126270);
        e.this.getFSVideoUIComponent().as(paramAnonymousView, e.a(e.this).edd());
        AppMethodBeat.o(126270);
      }
    };
    this.AeA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126271);
        e.this.getFSItemUIComponent().Ry(e.b(e.this).edd());
        AppMethodBeat.o(126271);
      }
    };
    this.AeB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126272);
        e.this.getFSVideoUIComponent().a(e.c(e.this), paramAnonymousView);
        e.this.eep();
        if (!e.this.eeq()) {
          e.d(e.this).setVisibility(8);
        }
        AppMethodBeat.o(126272);
      }
    };
    this.AeC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126273);
        com.tencent.mm.plugin.topstory.ui.video.b localb = e.this.getFSVideoUIComponent();
        e.e(e.this).edd();
        localb.a((cyv)paramAnonymousView.getTag());
        AppMethodBeat.o(126273);
      }
    };
    this.AeD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126274);
        if ((e.f(e.this) != null) && (!bs.isNullOrNil(e.g(e.this).kRU)))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", e.h(e.this).kRU);
          d.b(e.this.getFSVideoUIComponent().cYC().getApplicationContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        }
        AppMethodBeat.o(126274);
      }
    };
    this.Ack.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126275);
        if (e.i(e.this) == com.tencent.mm.plugin.topstory.ui.video.f.a.Acz)
        {
          e.this.getFSVideoUIComponent().ede().AdF = true;
          e.j(e.this).Rp(2);
        }
        if (e.this.getFSVideoUIComponent().ede().isConnected())
        {
          e.a(e.this, com.tencent.mm.plugin.topstory.ui.video.f.a.Acy);
          if (e.this.getFSVideoUIComponent().edj().Aei) {
            e.this.getFSVideoUIComponent().edj().dOc();
          }
          for (;;)
          {
            com.tencent.mm.plugin.websearch.api.a.a.lA(19);
            AppMethodBeat.o(126275);
            return;
            e.this.am(true, false);
          }
        }
        com.tencent.mm.plugin.websearch.api.a.a.lA(20);
        AppMethodBeat.o(126275);
      }
    });
    this.Aci.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126276);
        e.this.getFSVideoUIComponent().edf().Aeb = 2;
        if ((e.this.getFSItemUIComponent() != null) && (e.this.getFSItemUIComponent().edd() == e.this.getFSVideoUIComponent().edm()))
        {
          paramAnonymousView = e.this;
          if (!e.this.getFSVideoUIComponent().ede().AdF) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.am(bool, false);
            AppMethodBeat.o(126276);
            return;
          }
        }
        e.this.getFSVideoUIComponent().Rn(e.k(e.this).edd());
        e.this.getFSVideoUIComponent().edf().j(e.l(e.this));
        ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().edh(), e.m(e.this), e.n(e.this).edd(), 2, "");
        AppMethodBeat.o(126276);
      }
    });
    this.Acj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126277);
        e.this.edI();
        e.this.Aew.bjC();
        e.this.getFSVideoUIComponent().edf().Aeb = 2;
        e.this.getFSVideoUIComponent().edj().a(e.this.getFSVideoUIComponent(), e.o(e.this), e.p(e.this), e.q(e.this).edd());
        e.this.edC();
        AppMethodBeat.o(126277);
      }
    });
    this.Aco.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126252);
        if ((e.this.getFSItemUIComponent() != null) && (e.this.getFSItemUIComponent().edd() != e.this.getFSVideoUIComponent().edm()))
        {
          e.this.getFSVideoUIComponent().edf().Aeb = 2;
          e.this.getFSVideoUIComponent().Rn(e.r(e.this).edd());
          e.this.getFSVideoUIComponent().edf().j(e.s(e.this));
          ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().edh(), e.t(e.this), e.u(e.this).edd(), 2, "");
        }
        AppMethodBeat.o(126252);
      }
    });
    if (!eeq())
    {
      this.AeE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126254);
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(ai.getContext());
          paramAnonymousView.aRQ(e.this.getContext().getString(2131764484, new Object[] { e.v(e.this).FSi.FRl.FRh })).yi(true);
          paramAnonymousView.acQ(2131755270);
          paramAnonymousView.c(new f.c()
          {
            public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(126253);
              if (paramAnonymous2Boolean)
              {
                i.a(e.w(e.this).edh(), e.x(e.this), 2);
                paramAnonymous2String = new com.tencent.mm.plugin.appbrand.a.f();
                paramAnonymous2String.appId = e.y(e.this).FSi.FRl.appId;
                paramAnonymous2String.jjf = e.z(e.this).FSi.FRl.dxv;
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
      this.AeI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126255);
          e.d(e.this).setVisibility(8);
          i.a(e.A(e.this).edh(), e.B(e.this), 3);
          AppMethodBeat.o(126255);
        }
      });
    }
    biY();
    if (getFSVideoUIComponent().edq()) {
      this.Aew = new l(getContext());
    }
    for (;;)
    {
      this.Aew.setOnlyFS(eeq());
      this.Aew.setVisibility(8);
      this.Aew.setShareBtnClickListener(this.AeA);
      this.Aew.setWowBtnClickListener(this.AeB);
      this.Aew.setTagBtnClickListener(this.AeC);
      this.Aew.setSourceItemClickListener(this.AeD);
      if (com.tencent.mm.plugin.topstory.a.h.ect()) {
        this.Aew.setTitleClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(126263);
            e.this.getFSVideoUIComponent().edj().Aek = true;
            AppMethodBeat.o(126263);
          }
        });
      }
      this.Aew.setOnUpdateProgressLenListener(new f.a()
      {
        public final void b(dio paramAnonymousdio, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(126264);
          if (paramAnonymousInt2 > 0) {}
          for (int i = e.N(e.this).getWidth() * paramAnonymousInt1 / paramAnonymousInt2;; i = 0)
          {
            Object localObject = e.this.getFSVideoUIComponent().edf().Aec;
            if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).zZv < e.this.getFSVideoUIComponent().edj().getCurrPosMs())) {
              ((com.tencent.mm.plugin.topstory.a.b.b)localObject).zZv = e.this.getFSVideoUIComponent().edj().getCurrPosMs();
            }
            if (e.O(e.this).edj().een())
            {
              int j = e.P(e.this).edj().getCurrPosMs() / 1000;
              if (((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(paramAnonymousdio.sVF)) {
                ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(paramAnonymousdio.sVF, Integer.valueOf(j));
              }
            }
            localObject = (FrameLayout.LayoutParams)e.Q(e.this).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject).width = i;
            e.R(e.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
            e.S(e.this).requestLayout();
            if (!e.this.Aew.bjw()) {
              e.this.Aew.setVisibility(8);
            }
            if ((paramAnonymousdio.FRX & 0x100) <= 0) {
              e.T(e.this).a(paramAnonymousdio, paramAnonymousInt1, paramAnonymousInt2);
            }
            e.U(e.this).a(paramAnonymousdio, e.this, paramAnonymousInt1);
            AppMethodBeat.o(126264);
            return;
          }
        }
        
        public final void eer()
        {
          AppMethodBeat.i(126265);
          e.V(e.this).setVisibility(8);
          AppMethodBeat.o(126265);
        }
        
        public final void ees()
        {
          AppMethodBeat.i(126266);
          if ((e.this.getFSVideoUIComponent().edj().Aei) && ((e.this.getFSVideoUIComponent().edj().een()) || (e.this.getFSVideoUIComponent().edj().Aej)))
          {
            e.W(e.this).setVisibility(0);
            AppMethodBeat.o(126266);
            return;
          }
          e.X(e.this).setVisibility(8);
          AppMethodBeat.o(126266);
        }
      });
      this.Aew.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
      {
        public final void anR()
        {
          AppMethodBeat.i(126267);
          ac.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekPre");
          e.this.Aew.bOg();
          AppMethodBeat.o(126267);
        }
        
        public final void nn(int paramAnonymousInt)
        {
          AppMethodBeat.i(126268);
          ac.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          e.this.seekTo(paramAnonymousInt);
          e.this.Aew.bjC();
          com.tencent.mm.plugin.websearch.api.a.a.lA(22);
          AppMethodBeat.o(126268);
        }
      });
      this.Aew.setOnPlayButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126269);
          if (e.this.getFSVideoUIComponent().edj().Aei)
          {
            if ((!(e.this.Aew instanceof l)) && (e.this.Aew.getVideoTotalTime() - e.this.Aew.getmPosition() < 2))
            {
              ac.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "cannot change play status in last 2 seconds");
              AppMethodBeat.o(126269);
              return;
            }
            e.this.getFSVideoUIComponent().edf().j(e.Y(e.this));
            if (e.this.getFSVideoUIComponent().edj().een())
            {
              e.this.getFSVideoUIComponent().edj().crK();
              e.this.Aew.bOg();
            }
            for (;;)
            {
              e.this.edC();
              AppMethodBeat.o(126269);
              return;
              e.this.getFSVideoUIComponent().edj().dOc();
              e.this.Aew.bjC();
            }
          }
          ac.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "no video play now");
          AppMethodBeat.o(126269);
        }
      });
      AppMethodBeat.o(126287);
      return;
      this.Aew = new f(getContext());
      if (aj.aG(getContext()))
      {
        f localf = this.Aew;
        int i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 24);
        int j = com.tencent.mm.cc.a.fromDPToPix(getContext(), 24);
        localf.AeR.setPadding(i, 0, j, 0);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126297);
    if (this.Aex != null) {
      this.Aex.y(paramMotionEvent);
    }
    AppMethodBeat.o(126297);
    return true;
  }
  
  public class a
    implements c
  {
    private float AeM;
    
    a()
    {
      AppMethodBeat.i(126278);
      this.AeM = com.tencent.mm.cc.a.ih(e.this.getContext());
      AppMethodBeat.o(126278);
    }
    
    public void Rq(int paramInt)
    {
      AppMethodBeat.i(126283);
      e.this.Aew.eeu();
      e.ac(e.this).setVisibility(8);
      e.this.seekTo(paramInt);
      AppMethodBeat.o(126283);
    }
    
    public int bG(float paramFloat)
    {
      AppMethodBeat.i(126282);
      paramFloat /= this.AeM;
      int j = e.this.getFSVideoUIComponent().edj().getVideoDurationSec();
      int i = getCurrentPosition();
      int k = (int)(paramFloat * j) + i;
      if (k < 0) {
        i = 0;
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.websearch.ui.a.qn(j * 1000L);
        e.ab(e.this).setText(com.tencent.mm.plugin.websearch.ui.a.qn(i * 1000L) + "/" + str);
        AppMethodBeat.o(126282);
        return i;
        i = k;
        if (k > j) {
          i = j;
        }
      }
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(126279);
      ac.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSingleTap");
      if (e.Z(e.this))
      {
        if (e.this.Aew.bjw())
        {
          e.this.Aew.setVisibility(8);
          AppMethodBeat.o(126279);
          return;
        }
        e.this.Aew.show();
        if (e.this.getFSItemUIComponent() != null)
        {
          e.this.getFSItemUIComponent().edc();
          e.this.getFSItemUIComponent().edb();
        }
      }
      AppMethodBeat.o(126279);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(126280);
      ac.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onDoubleTap");
      AppMethodBeat.o(126280);
    }
    
    public void bjl()
    {
      AppMethodBeat.i(126281);
      e.aa(e.this).setVisibility(0);
      e.this.Aew.eet();
      AppMethodBeat.o(126281);
    }
    
    public final boolean edy()
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
      int i = e.this.getFSVideoUIComponent().edj().getCurrPosSec();
      AppMethodBeat.o(126285);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e
 * JD-Core Version:    0.7.0.1
 */