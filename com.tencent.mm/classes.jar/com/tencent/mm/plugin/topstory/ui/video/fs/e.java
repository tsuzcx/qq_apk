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
import com.tencent.mm.aw.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.protocal.protobuf.dnw;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;
import java.util.LinkedList;

public class e
  extends com.tencent.mm.plugin.topstory.ui.video.f
{
  protected f Bwi;
  protected k Bwj;
  protected View.OnClickListener Bwk;
  protected View.OnClickListener Bwl;
  protected View.OnClickListener Bwm;
  protected View.OnClickListener Bwn;
  protected View.OnClickListener Bwo;
  protected View.OnClickListener Bwp;
  private View Bwq;
  private TextView Bwr;
  private TextView Bws;
  private ImageView Bwt;
  private ImageView Bwu;
  private boolean isLoading;
  private i.b sOj;
  
  public e(Context paramContext, com.tencent.mm.plugin.topstory.ui.video.b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    AppMethodBeat.i(126286);
    this.sOj = new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int j = 0;
        AppMethodBeat.i(126257);
        ad.e("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        paramAnonymousString2 = e.D(e.this).epL().Tg(e.C(e.this).epE());
        if ((paramAnonymousString2 != null) && (paramAnonymousString2.HCC != null))
        {
          ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousString2.HCC.size()), paramAnonymousString2.videoUrl, Integer.valueOf(paramAnonymousString2.HCL) });
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
              ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", new Object[] { Integer.valueOf(i), localdof.url, Integer.valueOf(localdof.HCL) });
              com.tencent.mm.plugin.websearch.api.a.b.ma(com.tencent.mm.plugin.websearch.api.a.b.DDc);
              e.this.postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(126256);
                  e.this.aq(true, true);
                  AppMethodBeat.o(126256);
                }
              }, 100L);
              AppMethodBeat.o(126257);
              return;
            }
            i += 1;
          }
        }
        e.G(e.this).epL().a(e.E(e.this).epz(), e.F(e.this).epE());
        e.this.ki(e.this.getContext().getString(2131764672, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), e.this.getContext().getString(2131764699));
        e.this.getFSVideoUIComponent().epB().onError(paramAnonymousString1);
        i.ST(paramAnonymousInt1);
        paramAnonymousString1 = e.this.getFSVideoUIComponent().epx().BvO;
        paramAnonymousInt2 = j;
        if (paramAnonymousString1 != null)
        {
          paramAnonymousInt2 = j;
          if (paramAnonymousString1.Bre > 0L) {
            paramAnonymousInt2 = (int)(System.currentTimeMillis() - paramAnonymousString1.Bre) / 1000;
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
      
      public final void dq(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126258);
        ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onPrepared");
        e.this.Bwj.boJ();
        if (!e.H(e.this)) {
          e.this.epU();
        }
        AppMethodBeat.o(126258);
      }
      
      public final void dr(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126259);
        ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoEnded");
        e.this.getFSVideoUIComponent().epB().aCY(paramAnonymousString1);
        e.this.getFSVideoUIComponent().epx().BvN = 1;
        int i = e.this.getFSVideoUIComponent().epP();
        ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "clicfg_topstory_v_video_play  %s", new Object[] { Integer.valueOf(i) });
        if ((i == 1) && (e.this.getFSVideoUIComponent().epI()) && ((e.I(e.this) instanceof j))) {}
        try
        {
          Thread.sleep(100L);
          ((j)e.J(e.this)).sJ(true);
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
              ((com.tencent.mm.plugin.topstory.ui.video.h)e.M(e.this)).sJ(true);
              e.a(e.this, false);
              AppMethodBeat.o(126259);
              return;
              boolean bool = e.this.getFSVideoUIComponent().SX(e.K(e.this).epv() + 1);
            }
            paramAnonymousString1 = paramAnonymousString1;
          }
          catch (InterruptedException paramAnonymousString1)
          {
            break label166;
          }
        }
      }
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void du(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126261);
        ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaiting");
        e.a(e.this, true);
        AppMethodBeat.o(126261);
      }
      
      public final void dv(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126262);
        ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaitingEnd");
        e.a(e.this, false);
        e.this.epU();
        paramAnonymousString1 = e.this.getFSVideoUIComponent().epx().BvO;
        if ((paramAnonymousString1 != null) && (paramAnonymousString1.Brp == 0L))
        {
          paramAnonymousString1.Brp = (System.currentTimeMillis() - paramAnonymousString1.Bre);
          ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramAnonymousString1.Brm), Long.valueOf(paramAnonymousString1.Brp) });
        }
        AppMethodBeat.o(126262);
      }
      
      public final void eT(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    if (this.BtO.epI()) {
      this.oSB.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    AppMethodBeat.o(126286);
  }
  
  private boolean bmR()
  {
    AppMethodBeat.i(126298);
    if (this.BtZ.getVisibility() == 0)
    {
      AppMethodBeat.o(126298);
      return true;
    }
    AppMethodBeat.o(126298);
    return false;
  }
  
  public final void bSC()
  {
    AppMethodBeat.i(126295);
    if (this.Bwi != null) {
      this.Bwi.show();
    }
    AppMethodBeat.o(126295);
  }
  
  protected void bmK()
  {
    AppMethodBeat.i(126296);
    this.Bwj = new k(getContext(), this, new a());
    AppMethodBeat.o(126296);
  }
  
  public i.e c(dod paramdod)
  {
    return i.e.ESO;
  }
  
  public final void epS()
  {
    AppMethodBeat.i(126290);
    ad.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollPlayContainerStatus");
    this.BtZ.setVisibility(8);
    this.BtY.setVisibility(8);
    this.oSB.setVisibility(0);
    this.BtQ.setVisibility(8);
    this.BtP.setVisibility(8);
    this.Bud.setVisibility(8);
    AppMethodBeat.o(126290);
  }
  
  public final void epT()
  {
    AppMethodBeat.i(126291);
    ad.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollStopContainerStatus");
    this.BtZ.setVisibility(0);
    if ((getFSVideoUIComponent().epw().eqt()) && (!com.tencent.mm.plugin.topstory.a.h.eoN())) {
      this.BtY.setVisibility(0);
    }
    for (;;)
    {
      this.oSB.setVisibility(0);
      this.BtQ.setVisibility(8);
      this.BtP.setVisibility(8);
      this.Bud.setVisibility(8);
      this.Bub.setVisibility(0);
      this.Bua.setVisibility(8);
      this.BtT.setVisibility(0);
      this.BtU.setVisibility(8);
      this.BtX.setVisibility(8);
      AppMethodBeat.o(126291);
      return;
      this.BtY.setVisibility(8);
    }
  }
  
  public final void epU()
  {
    AppMethodBeat.i(126288);
    super.epU();
    AppMethodBeat.o(126288);
  }
  
  public final void epX()
  {
    AppMethodBeat.i(126294);
    if (this.Bwi != null) {
      this.Bwi.setVisibility(8);
    }
    AppMethodBeat.o(126294);
  }
  
  public final void epY()
  {
    AppMethodBeat.i(126292);
    f localf = this.Bwi;
    if (localf.BwP != null) {
      localf.BwP.stopTimer();
    }
    AppMethodBeat.o(126292);
  }
  
  protected void eqG()
  {
    AppMethodBeat.i(126289);
    this.Bwi.l(this.Brz);
    AppMethodBeat.o(126289);
  }
  
  public boolean eqH()
  {
    return false;
  }
  
  public final void eqc()
  {
    AppMethodBeat.i(126299);
    super.eqc();
    if (eqH())
    {
      AppMethodBeat.o(126299);
      return;
    }
    if ((this.Brz.HCO != null) && (this.Brz.HCO.HBR != null))
    {
      this.Bwr.setText(this.Brz.HCO.HBR.title);
      this.Bws.setText(this.Brz.HCO.HBR.desc);
      q.aIJ().a(this.Brz.HCO.HBR.sjU, this.Bwt, Btq);
      this.Bwq.setVisibility(0);
      i.a(this.BtO.epz(), this.Brz, 1);
      AppMethodBeat.o(126299);
      return;
    }
    this.Bwq.setVisibility(8);
    AppMethodBeat.o(126299);
  }
  
  public final void eqd()
  {
    AppMethodBeat.i(126300);
    super.eqd();
    if (eqH())
    {
      AppMethodBeat.o(126300);
      return;
    }
    this.Bwq.setVisibility(8);
    AppMethodBeat.o(126300);
  }
  
  public final boolean eqe()
  {
    AppMethodBeat.i(161624);
    if (this.Bwq != null)
    {
      if (this.Bwq.getVisibility() == 0)
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
    return this.Bwi;
  }
  
  public a getFSItemUIComponent()
  {
    return (a)this.Bug;
  }
  
  public com.tencent.mm.plugin.topstory.ui.video.b getFSVideoUIComponent()
  {
    return this.BtO;
  }
  
  public int getLayoutId()
  {
    return 2131495777;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public dod getVideoInfo()
  {
    return this.Brz;
  }
  
  public i.b getVideoViewCallback()
  {
    return this.sOj;
  }
  
  public void init()
  {
    AppMethodBeat.i(126287);
    super.init();
    if (!eqH())
    {
      this.Bwq = findViewById(2131303343);
      this.Bwr = ((TextView)findViewById(2131303344));
      this.Bws = ((TextView)findViewById(2131303341));
      this.Bwt = ((ImageView)findViewById(2131303342));
      this.Bwu = ((ImageView)findViewById(2131303340));
    }
    this.Bwk = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126251);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        e.this.getFSVideoUIComponent().dfI();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126251);
      }
    };
    this.Bwl = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126270);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        e.this.getFSVideoUIComponent().at(paramAnonymousView, e.a(e.this).epv());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126270);
      }
    };
    this.Bwm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126271);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        e.this.getFSItemUIComponent().Ti(e.b(e.this).epv());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126271);
      }
    };
    this.Bwn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126272);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        e.this.getFSVideoUIComponent().a(e.c(e.this), paramAnonymousView);
        e.this.eqG();
        if (!e.this.eqH()) {
          e.d(e.this).setVisibility(8);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126272);
      }
    };
    this.Bwo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126273);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = e.this.getFSVideoUIComponent();
        e.e(e.this).epv();
        ((com.tencent.mm.plugin.topstory.ui.video.b)localObject).a((dei)paramAnonymousView.getTag());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126273);
      }
    };
    this.Bwp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126274);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((e.f(e.this) != null) && (!bt.isNullOrNil(e.g(e.this).lox)))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", e.h(e.this).lox);
          d.b(e.this.getFSVideoUIComponent().dhO().getApplicationContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126274);
      }
    };
    this.BtV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126275);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (e.i(e.this) == com.tencent.mm.plugin.topstory.ui.video.f.a.Buk)
        {
          e.this.getFSVideoUIComponent().epw().Bvq = true;
          e.j(e.this).SZ(2);
        }
        if (e.this.getFSVideoUIComponent().epw().isConnected())
        {
          e.a(e.this, com.tencent.mm.plugin.topstory.ui.video.f.a.Buj);
          if (e.this.getFSVideoUIComponent().epB().BvU)
          {
            e.this.getFSVideoUIComponent().epB().eaq();
            com.tencent.mm.plugin.websearch.api.a.a.ma(19);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126275);
          return;
          e.this.aq(true, false);
          break;
          com.tencent.mm.plugin.websearch.api.a.a.ma(20);
        }
      }
    });
    this.BtT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126276);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        e.this.getFSVideoUIComponent().epx().BvN = 2;
        boolean bool;
        if ((e.this.getFSItemUIComponent() != null) && (e.this.getFSItemUIComponent().epv() == e.this.getFSVideoUIComponent().epE()))
        {
          paramAnonymousView = e.this;
          if (!e.this.getFSVideoUIComponent().epw().Bvq)
          {
            bool = true;
            paramAnonymousView.aq(bool, false);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126276);
          return;
          bool = false;
          break;
          e.this.getFSVideoUIComponent().SX(e.k(e.this).epv());
          e.this.getFSVideoUIComponent().epx().j(e.l(e.this));
          ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().epz(), e.m(e.this), e.n(e.this).epv(), 2, "");
        }
      }
    });
    this.BtU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126277);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        e.this.eqa();
        e.this.Bwi.bno();
        e.this.getFSVideoUIComponent().epx().BvN = 2;
        e.this.getFSVideoUIComponent().epB().a(e.this.getFSVideoUIComponent(), e.o(e.this), e.p(e.this), e.q(e.this).epv());
        e.this.epU();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126277);
      }
    });
    this.BtZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126252);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((e.this.getFSItemUIComponent() != null) && (e.this.getFSItemUIComponent().epv() != e.this.getFSVideoUIComponent().epE()))
        {
          e.this.getFSVideoUIComponent().epx().BvN = 2;
          e.this.getFSVideoUIComponent().SX(e.r(e.this).epv());
          e.this.getFSVideoUIComponent().epx().j(e.s(e.this));
          ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().epz(), e.t(e.this), e.u(e.this).epv(), 2, "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126252);
      }
    });
    if (!eqH())
    {
      this.Bwq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126254);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(aj.getContext());
          paramAnonymousView.aXO(e.this.getContext().getString(2131764484, new Object[] { e.v(e.this).HCO.HBR.HBN })).yU(true);
          paramAnonymousView.afp(2131755270);
          paramAnonymousView.c(new f.c()
          {
            public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(126253);
              if (paramAnonymous2Boolean)
              {
                i.a(e.w(e.this).epz(), e.x(e.this), 2);
                paramAnonymous2String = new com.tencent.mm.plugin.appbrand.api.f();
                paramAnonymous2String.appId = e.y(e.this).HCO.HBR.appId;
                paramAnonymous2String.jCN = e.z(e.this).HCO.HBR.dJH;
                paramAnonymous2String.scene = 1152;
                ((com.tencent.mm.plugin.appbrand.service.o)g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).a(e.this.getContext(), paramAnonymous2String);
                e.d(e.this).setVisibility(8);
              }
              AppMethodBeat.o(126253);
            }
          }).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126254);
        }
      });
      this.Bwu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126255);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          e.d(e.this).setVisibility(8);
          i.a(e.A(e.this).epz(), e.B(e.this), 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126255);
        }
      });
    }
    bmK();
    if (getFSVideoUIComponent().epI()) {
      this.Bwi = new l(getContext());
    }
    for (;;)
    {
      this.Bwi.setOnlyFS(eqH());
      this.Bwi.setVisibility(8);
      this.Bwi.setShareBtnClickListener(this.Bwm);
      this.Bwi.setWowBtnClickListener(this.Bwn);
      this.Bwi.setTagBtnClickListener(this.Bwo);
      this.Bwi.setSourceItemClickListener(this.Bwp);
      if (com.tencent.mm.plugin.topstory.a.h.eoK()) {
        this.Bwi.setTitleClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(126263);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            e.this.getFSVideoUIComponent().epB().BvW = true;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126263);
          }
        });
      }
      this.Bwi.setOnUpdateProgressLenListener(new f.a()
      {
        public final void b(dod paramAnonymousdod, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(126264);
          if (paramAnonymousInt2 > 0) {}
          for (int i = e.N(e.this).getWidth() * paramAnonymousInt1 / paramAnonymousInt2;; i = 0)
          {
            Object localObject = e.this.getFSVideoUIComponent().epx().BvO;
            if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).Brh < e.this.getFSVideoUIComponent().epB().getCurrPosMs())) {
              ((com.tencent.mm.plugin.topstory.a.b.b)localObject).Brh = e.this.getFSVideoUIComponent().epB().getCurrPosMs();
            }
            if (e.O(e.this).epB().eqE())
            {
              int j = e.P(e.this).epB().getCurrPosMs() / 1000;
              if (((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(paramAnonymousdod.tSk)) {
                ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(paramAnonymousdod.tSk, Integer.valueOf(j));
              }
            }
            localObject = (FrameLayout.LayoutParams)e.Q(e.this).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject).width = i;
            e.R(e.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
            e.S(e.this).requestLayout();
            if (!e.this.Bwi.bni()) {
              e.this.Bwi.setVisibility(8);
            }
            if ((paramAnonymousdod.HCD & 0x100) <= 0) {
              e.T(e.this).a(paramAnonymousdod, paramAnonymousInt1, paramAnonymousInt2);
            }
            e.U(e.this).a(paramAnonymousdod, e.this, paramAnonymousInt1);
            AppMethodBeat.o(126264);
            return;
          }
        }
        
        public final void eqI()
        {
          AppMethodBeat.i(126265);
          e.V(e.this).setVisibility(8);
          AppMethodBeat.o(126265);
        }
        
        public final void eqJ()
        {
          AppMethodBeat.i(126266);
          if ((e.this.getFSVideoUIComponent().epB().BvU) && ((e.this.getFSVideoUIComponent().epB().eqE()) || (e.this.getFSVideoUIComponent().epB().BvV)))
          {
            e.W(e.this).setVisibility(0);
            AppMethodBeat.o(126266);
            return;
          }
          e.X(e.this).setVisibility(8);
          AppMethodBeat.o(126266);
        }
      });
      this.Bwi.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
      {
        public final void aqD()
        {
          AppMethodBeat.i(126267);
          ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekPre");
          e.this.Bwi.bSH();
          AppMethodBeat.o(126267);
        }
        
        public final void nM(int paramAnonymousInt)
        {
          AppMethodBeat.i(126268);
          ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          e.this.seekTo(paramAnonymousInt);
          e.this.Bwi.bno();
          com.tencent.mm.plugin.websearch.api.a.a.ma(22);
          AppMethodBeat.o(126268);
        }
      });
      this.Bwi.setOnPlayButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126269);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (e.this.getFSVideoUIComponent().epB().BvU)
          {
            if ((!(e.this.Bwi instanceof l)) && (e.this.Bwi.getVideoTotalTime() - e.this.Bwi.getmPosition() < 2))
            {
              ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "cannot change play status in last 2 seconds");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(126269);
              return;
            }
            e.this.getFSVideoUIComponent().epx().j(e.Y(e.this));
            if (e.this.getFSVideoUIComponent().epB().eqE())
            {
              e.this.getFSVideoUIComponent().epB().cxw();
              e.this.Bwi.bSH();
              e.this.epU();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126269);
            return;
            e.this.getFSVideoUIComponent().epB().eaq();
            e.this.Bwi.bno();
            break;
            ad.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "no video play now");
          }
        }
      });
      AppMethodBeat.o(126287);
      return;
      this.Bwi = new f(getContext());
      if (al.aG(getContext()))
      {
        f localf = this.Bwi;
        int i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 24);
        int j = com.tencent.mm.cc.a.fromDPToPix(getContext(), 24);
        localf.BwD.setPadding(i, 0, j, 0);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126297);
    if (this.Bwj != null) {
      this.Bwj.w(paramMotionEvent);
    }
    AppMethodBeat.o(126297);
    return true;
  }
  
  public void updateView()
  {
    AppMethodBeat.i(126293);
    super.updateView();
    if (this.Bwi != null)
    {
      this.Bwi.setVideoTotalTime(this.Brz.zSz);
      this.Bwi.m(this.Brz);
    }
    if ((getFSItemUIComponent() != null) && (getFSItemUIComponent().epv() != getFSVideoUIComponent().epE()))
    {
      if (!getFSVideoUIComponent().epw().isConnected()) {
        break label130;
      }
      epV();
    }
    for (;;)
    {
      if (this.titleTv != null)
      {
        this.titleTv.setText(this.Brz.title);
        al.a(this.titleTv.getPaint(), 0.8F);
      }
      AppMethodBeat.o(126293);
      return;
      label130:
      ki(getNoNetTip(), getContext().getString(2131764699));
    }
  }
  
  public class a
    implements c
  {
    private float Bwy;
    
    a()
    {
      AppMethodBeat.i(126278);
      this.Bwy = com.tencent.mm.cc.a.iq(e.this.getContext());
      AppMethodBeat.o(126278);
    }
    
    public void Ta(int paramInt)
    {
      AppMethodBeat.i(126283);
      e.this.Bwi.eqL();
      e.ac(e.this).setVisibility(8);
      e.this.seekTo(paramInt);
      AppMethodBeat.o(126283);
    }
    
    public int bJ(float paramFloat)
    {
      AppMethodBeat.i(126282);
      paramFloat /= this.Bwy;
      int j = e.this.getFSVideoUIComponent().epB().getVideoDurationSec();
      int i = getCurrentPosition();
      int k = (int)(paramFloat * j) + i;
      if (k < 0) {
        i = 0;
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.websearch.ui.a.sm(j * 1000L);
        e.ab(e.this).setText(com.tencent.mm.plugin.websearch.ui.a.sm(i * 1000L) + "/" + str);
        AppMethodBeat.o(126282);
        return i;
        i = k;
        if (k > j) {
          i = j;
        }
      }
    }
    
    public final void bmV()
    {
      AppMethodBeat.i(126279);
      ad.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSingleTap");
      if (e.Z(e.this))
      {
        if (e.this.Bwi.bni())
        {
          e.this.Bwi.setVisibility(8);
          AppMethodBeat.o(126279);
          return;
        }
        e.this.Bwi.show();
        if (e.this.getFSItemUIComponent() != null)
        {
          e.this.getFSItemUIComponent().epu();
          e.this.getFSItemUIComponent().ept();
        }
      }
      AppMethodBeat.o(126279);
    }
    
    public final void bmW()
    {
      AppMethodBeat.i(126280);
      ad.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onDoubleTap");
      AppMethodBeat.o(126280);
    }
    
    public void bmX()
    {
      AppMethodBeat.i(126281);
      e.aa(e.this).setVisibility(0);
      e.this.Bwi.eqK();
      AppMethodBeat.o(126281);
    }
    
    public final boolean epQ()
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
      int i = e.this.getFSVideoUIComponent().epB().getCurrPosSec();
      AppMethodBeat.o(126285);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e
 * JD-Core Version:    0.7.0.1
 */