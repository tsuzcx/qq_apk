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
import com.tencent.mm.av.q;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.dos;
import com.tencent.mm.protocal.protobuf.dot;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;
import java.util.LinkedList;

public class e
  extends com.tencent.mm.plugin.topstory.ui.video.f
{
  protected f BNG;
  protected k BNH;
  protected View.OnClickListener BNI;
  protected View.OnClickListener BNJ;
  protected View.OnClickListener BNK;
  protected View.OnClickListener BNL;
  protected View.OnClickListener BNM;
  protected View.OnClickListener BNN;
  private View BNO;
  private TextView BNP;
  private TextView BNQ;
  private ImageView BNR;
  private ImageView BNS;
  private boolean isLoading;
  private i.b sZu;
  
  public e(Context paramContext, com.tencent.mm.plugin.topstory.ui.video.b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    AppMethodBeat.i(126286);
    this.sZu = new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int j = 0;
        AppMethodBeat.i(126257);
        ae.e("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        paramAnonymousString2 = e.D(e.this).ets().TN(e.C(e.this).etl());
        if ((paramAnonymousString2 != null) && (paramAnonymousString2.HWp != null))
        {
          ae.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousString2.HWp.size()), paramAnonymousString2.videoUrl, Integer.valueOf(paramAnonymousString2.HWy) });
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
              ae.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", new Object[] { Integer.valueOf(i), localdpc.url, Integer.valueOf(localdpc.HWy) });
              com.tencent.mm.plugin.websearch.api.a.b.md(com.tencent.mm.plugin.websearch.api.a.b.DVa);
              e.this.postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(126256);
                  e.this.ap(true, true);
                  AppMethodBeat.o(126256);
                }
              }, 100L);
              AppMethodBeat.o(126257);
              return;
            }
            i += 1;
          }
        }
        e.G(e.this).ets().a(e.E(e.this).etg(), e.F(e.this).etl());
        e.this.ko(e.this.getContext().getString(2131764672, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), e.this.getContext().getString(2131764699));
        e.this.getFSVideoUIComponent().eti().onError(paramAnonymousString1);
        i.TA(paramAnonymousInt1);
        paramAnonymousString1 = e.this.getFSVideoUIComponent().ete().BNm;
        paramAnonymousInt2 = j;
        if (paramAnonymousString1 != null)
        {
          paramAnonymousInt2 = j;
          if (paramAnonymousString1.BID > 0L) {
            paramAnonymousInt2 = (int)(System.currentTimeMillis() - paramAnonymousString1.BID) / 1000;
          }
        }
        i.a(paramAnonymousString2, paramAnonymousInt1, paramAnonymousString3, paramAnonymousInt2);
        AppMethodBeat.o(126257);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126260);
        ae.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(126260);
      }
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126258);
        ae.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onPrepared");
        e.this.BNH.bpt();
        if (!e.H(e.this)) {
          e.this.etB();
        }
        AppMethodBeat.o(126258);
      }
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126259);
        ae.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoEnded");
        e.this.getFSVideoUIComponent().eti().aEr(paramAnonymousString1);
        e.this.getFSVideoUIComponent().ete().BNl = 1;
        int i = e.this.getFSVideoUIComponent().etw();
        ae.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "clicfg_topstory_v_video_play  %s", new Object[] { Integer.valueOf(i) });
        if ((i == 1) && (e.this.getFSVideoUIComponent().etp()) && ((e.I(e.this) instanceof j))) {}
        try
        {
          Thread.sleep(100L);
          ((j)e.J(e.this)).sQ(true);
          ae.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "VVideoAutoPlay replay succ");
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
              ((com.tencent.mm.plugin.topstory.ui.video.h)e.M(e.this)).sQ(true);
              e.a(e.this, false);
              AppMethodBeat.o(126259);
              return;
              boolean bool = e.this.getFSVideoUIComponent().TE(e.K(e.this).etc() + 1);
            }
            paramAnonymousString1 = paramAnonymousString1;
          }
          catch (InterruptedException paramAnonymousString1)
          {
            break label166;
          }
        }
      }
      
      public final void du(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dv(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dw(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126261);
        ae.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaiting");
        e.a(e.this, true);
        AppMethodBeat.o(126261);
      }
      
      public final void dx(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126262);
        ae.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaitingEnd");
        e.a(e.this, false);
        e.this.etB();
        paramAnonymousString1 = e.this.getFSVideoUIComponent().ete().BNm;
        if ((paramAnonymousString1 != null) && (paramAnonymousString1.BIO == 0L))
        {
          paramAnonymousString1.BIO = (System.currentTimeMillis() - paramAnonymousString1.BID);
          ae.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramAnonymousString1.BIL), Long.valueOf(paramAnonymousString1.BIO) });
        }
        AppMethodBeat.o(126262);
      }
      
      public final void eX(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    if (this.BLm.etp()) {
      this.oZd.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    AppMethodBeat.o(126286);
  }
  
  private boolean bnB()
  {
    AppMethodBeat.i(126298);
    if (this.BLx.getVisibility() == 0)
    {
      AppMethodBeat.o(126298);
      return true;
    }
    AppMethodBeat.o(126298);
    return false;
  }
  
  public final void bTP()
  {
    AppMethodBeat.i(126295);
    if (this.BNG != null) {
      this.BNG.show();
    }
    AppMethodBeat.o(126295);
  }
  
  protected void bnu()
  {
    AppMethodBeat.i(126296);
    this.BNH = new k(getContext(), this, new a());
    AppMethodBeat.o(126296);
  }
  
  public i.e c(dpa paramdpa)
  {
    return i.e.Flj;
  }
  
  public final void etA()
  {
    AppMethodBeat.i(126291);
    ae.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollStopContainerStatus");
    this.BLx.setVisibility(0);
    if ((getFSVideoUIComponent().etd().eua()) && (!com.tencent.mm.plugin.topstory.a.h.esu())) {
      this.BLw.setVisibility(0);
    }
    for (;;)
    {
      this.oZd.setVisibility(0);
      this.BLo.setVisibility(8);
      this.BLn.setVisibility(8);
      this.BLB.setVisibility(8);
      this.BLz.setVisibility(0);
      this.BLy.setVisibility(8);
      this.BLr.setVisibility(0);
      this.BLs.setVisibility(8);
      this.BLv.setVisibility(8);
      AppMethodBeat.o(126291);
      return;
      this.BLw.setVisibility(8);
    }
  }
  
  public final void etB()
  {
    AppMethodBeat.i(126288);
    super.etB();
    AppMethodBeat.o(126288);
  }
  
  public final void etE()
  {
    AppMethodBeat.i(126294);
    if (this.BNG != null) {
      this.BNG.setVisibility(8);
    }
    AppMethodBeat.o(126294);
  }
  
  public final void etF()
  {
    AppMethodBeat.i(126292);
    f localf = this.BNG;
    if (localf.BOn != null) {
      localf.BOn.stopTimer();
    }
    AppMethodBeat.o(126292);
  }
  
  public final void etJ()
  {
    AppMethodBeat.i(126299);
    super.etJ();
    if (euo())
    {
      AppMethodBeat.o(126299);
      return;
    }
    if ((this.BIY.HWB != null) && (this.BIY.HWB.HVE != null))
    {
      this.BNP.setText(this.BIY.HWB.HVE.title);
      this.BNQ.setText(this.BIY.HWB.HVE.desc);
      q.aJb().a(this.BIY.HWB.HVE.ssR, this.BNR, BKO);
      this.BNO.setVisibility(0);
      i.a(this.BLm.etg(), this.BIY, 1);
      AppMethodBeat.o(126299);
      return;
    }
    this.BNO.setVisibility(8);
    AppMethodBeat.o(126299);
  }
  
  public final void etK()
  {
    AppMethodBeat.i(126300);
    super.etK();
    if (euo())
    {
      AppMethodBeat.o(126300);
      return;
    }
    this.BNO.setVisibility(8);
    AppMethodBeat.o(126300);
  }
  
  public final boolean etL()
  {
    AppMethodBeat.i(161624);
    if (this.BNO != null)
    {
      if (this.BNO.getVisibility() == 0)
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
  
  public final void etz()
  {
    AppMethodBeat.i(126290);
    ae.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollPlayContainerStatus");
    this.BLx.setVisibility(8);
    this.BLw.setVisibility(8);
    this.oZd.setVisibility(0);
    this.BLo.setVisibility(8);
    this.BLn.setVisibility(8);
    this.BLB.setVisibility(8);
    AppMethodBeat.o(126290);
  }
  
  protected void eun()
  {
    AppMethodBeat.i(126289);
    this.BNG.l(this.BIY);
    AppMethodBeat.o(126289);
  }
  
  public boolean euo()
  {
    return false;
  }
  
  public f getControlBar()
  {
    return this.BNG;
  }
  
  public a getFSItemUIComponent()
  {
    return (a)this.BLE;
  }
  
  public com.tencent.mm.plugin.topstory.ui.video.b getFSVideoUIComponent()
  {
    return this.BLm;
  }
  
  public int getLayoutId()
  {
    return 2131495777;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public dpa getVideoInfo()
  {
    return this.BIY;
  }
  
  public i.b getVideoViewCallback()
  {
    return this.sZu;
  }
  
  public void init()
  {
    AppMethodBeat.i(126287);
    super.init();
    if (!euo())
    {
      this.BNO = findViewById(2131303343);
      this.BNP = ((TextView)findViewById(2131303344));
      this.BNQ = ((TextView)findViewById(2131303341));
      this.BNR = ((ImageView)findViewById(2131303342));
      this.BNS = ((ImageView)findViewById(2131303340));
    }
    this.BNI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126251);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        e.this.getFSVideoUIComponent().diF();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126251);
      }
    };
    this.BNJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126270);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        e.this.getFSVideoUIComponent().at(paramAnonymousView, e.a(e.this).etc());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126270);
      }
    };
    this.BNK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126271);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        e.this.getFSItemUIComponent().TP(e.b(e.this).etc());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126271);
      }
    };
    this.BNL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126272);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        e.this.getFSVideoUIComponent().a(e.c(e.this), paramAnonymousView);
        e.this.eun();
        if (!e.this.euo()) {
          e.d(e.this).setVisibility(8);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126272);
      }
    };
    this.BNM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126273);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = e.this.getFSVideoUIComponent();
        e.e(e.this).etc();
        ((com.tencent.mm.plugin.topstory.ui.video.b)localObject).a((dfc)paramAnonymousView.getTag());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126273);
      }
    };
    this.BNN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126274);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((e.f(e.this) != null) && (!bu.isNullOrNil(e.g(e.this).dJL)))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", e.h(e.this).dJL);
          d.b(e.this.getFSVideoUIComponent().dkN().getApplicationContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126274);
      }
    };
    this.BLt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126275);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (e.i(e.this) == com.tencent.mm.plugin.topstory.ui.video.f.a.BLI)
        {
          e.this.getFSVideoUIComponent().etd().BMO = true;
          e.j(e.this).TG(2);
        }
        if (e.this.getFSVideoUIComponent().etd().isConnected())
        {
          e.a(e.this, com.tencent.mm.plugin.topstory.ui.video.f.a.BLH);
          if (e.this.getFSVideoUIComponent().eti().BNs)
          {
            e.this.getFSVideoUIComponent().eti().edW();
            com.tencent.mm.plugin.websearch.api.a.a.md(19);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126275);
          return;
          e.this.ap(true, false);
          break;
          com.tencent.mm.plugin.websearch.api.a.a.md(20);
        }
      }
    });
    this.BLr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126276);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        e.this.getFSVideoUIComponent().ete().BNl = 2;
        boolean bool;
        if ((e.this.getFSItemUIComponent() != null) && (e.this.getFSItemUIComponent().etc() == e.this.getFSVideoUIComponent().etl()))
        {
          paramAnonymousView = e.this;
          if (!e.this.getFSVideoUIComponent().etd().BMO)
          {
            bool = true;
            paramAnonymousView.ap(bool, false);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126276);
          return;
          bool = false;
          break;
          e.this.getFSVideoUIComponent().TE(e.k(e.this).etc());
          e.this.getFSVideoUIComponent().ete().j(e.l(e.this));
          ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().etg(), e.m(e.this), e.n(e.this).etc(), 2, "");
        }
      }
    });
    this.BLs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126277);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        e.this.etH();
        e.this.BNG.bnY();
        e.this.getFSVideoUIComponent().ete().BNl = 2;
        e.this.getFSVideoUIComponent().eti().a(e.this.getFSVideoUIComponent(), e.o(e.this), e.p(e.this), e.q(e.this).etc());
        e.this.etB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126277);
      }
    });
    this.BLx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126252);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((e.this.getFSItemUIComponent() != null) && (e.this.getFSItemUIComponent().etc() != e.this.getFSVideoUIComponent().etl()))
        {
          e.this.getFSVideoUIComponent().ete().BNl = 2;
          e.this.getFSVideoUIComponent().TE(e.r(e.this).etc());
          e.this.getFSVideoUIComponent().ete().j(e.s(e.this));
          ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().etg(), e.t(e.this), e.u(e.this).etc(), 2, "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126252);
      }
    });
    if (!euo())
    {
      this.BNO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126254);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(ak.getContext());
          paramAnonymousView.aZq(e.this.getContext().getString(2131764484, new Object[] { e.v(e.this).HWB.HVE.HVA })).zi(true);
          paramAnonymousView.afY(2131755270);
          paramAnonymousView.c(new f.c()
          {
            public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(126253);
              if (paramAnonymous2Boolean)
              {
                i.a(e.w(e.this).etg(), e.x(e.this), 2);
                paramAnonymous2String = new com.tencent.mm.plugin.appbrand.api.f();
                paramAnonymous2String.appId = e.y(e.this).HWB.HVE.appId;
                paramAnonymous2String.jFL = e.z(e.this).HWB.HVE.dKV;
                paramAnonymous2String.scene = 1152;
                ((p)g.ab(p.class)).a(e.this.getContext(), paramAnonymous2String);
                e.d(e.this).setVisibility(8);
              }
              AppMethodBeat.o(126253);
            }
          }).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126254);
        }
      });
      this.BNS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126255);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          e.d(e.this).setVisibility(8);
          i.a(e.A(e.this).etg(), e.B(e.this), 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126255);
        }
      });
    }
    bnu();
    if (getFSVideoUIComponent().etp()) {
      this.BNG = new l(getContext());
    }
    for (;;)
    {
      this.BNG.setOnlyFS(euo());
      this.BNG.setVisibility(8);
      this.BNG.setShareBtnClickListener(this.BNK);
      this.BNG.setWowBtnClickListener(this.BNL);
      this.BNG.setTagBtnClickListener(this.BNM);
      this.BNG.setSourceItemClickListener(this.BNN);
      if (com.tencent.mm.plugin.topstory.a.h.esr()) {
        this.BNG.setTitleClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(126263);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            e.this.getFSVideoUIComponent().eti().BNu = true;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126263);
          }
        });
      }
      this.BNG.setOnUpdateProgressLenListener(new f.a()
      {
        public final void b(dpa paramAnonymousdpa, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(126264);
          if (paramAnonymousInt2 > 0) {}
          for (int i = e.N(e.this).getWidth() * paramAnonymousInt1 / paramAnonymousInt2;; i = 0)
          {
            Object localObject = e.this.getFSVideoUIComponent().ete().BNm;
            if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).BIG < e.this.getFSVideoUIComponent().eti().getCurrPosMs())) {
              ((com.tencent.mm.plugin.topstory.a.b.b)localObject).BIG = e.this.getFSVideoUIComponent().eti().getCurrPosMs();
            }
            if (e.O(e.this).eti().eul())
            {
              int j = e.P(e.this).eti().getCurrPosMs() / 1000;
              if (((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(paramAnonymousdpa.udb)) {
                ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(paramAnonymousdpa.udb, Integer.valueOf(j));
              }
            }
            localObject = (FrameLayout.LayoutParams)e.Q(e.this).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject).width = i;
            e.R(e.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
            e.S(e.this).requestLayout();
            if (!e.this.BNG.bnS()) {
              e.this.BNG.setVisibility(8);
            }
            if ((paramAnonymousdpa.HWq & 0x100) <= 0) {
              e.T(e.this).a(paramAnonymousdpa, paramAnonymousInt1, paramAnonymousInt2);
            }
            e.U(e.this).a(paramAnonymousdpa, e.this, paramAnonymousInt1);
            AppMethodBeat.o(126264);
            return;
          }
        }
        
        public final void eup()
        {
          AppMethodBeat.i(126265);
          e.V(e.this).setVisibility(8);
          AppMethodBeat.o(126265);
        }
        
        public final void euq()
        {
          AppMethodBeat.i(126266);
          if ((e.this.getFSVideoUIComponent().eti().BNs) && ((e.this.getFSVideoUIComponent().eti().eul()) || (e.this.getFSVideoUIComponent().eti().BNt)))
          {
            e.W(e.this).setVisibility(0);
            AppMethodBeat.o(126266);
            return;
          }
          e.X(e.this).setVisibility(8);
          AppMethodBeat.o(126266);
        }
      });
      this.BNG.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
      {
        public final void aqS()
        {
          AppMethodBeat.i(126267);
          ae.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekPre");
          e.this.BNG.bTU();
          AppMethodBeat.o(126267);
        }
        
        public final void nP(int paramAnonymousInt)
        {
          AppMethodBeat.i(126268);
          ae.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          e.this.seekTo(paramAnonymousInt);
          e.this.BNG.bnY();
          com.tencent.mm.plugin.websearch.api.a.a.md(22);
          AppMethodBeat.o(126268);
        }
      });
      this.BNG.setOnPlayButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126269);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (e.this.getFSVideoUIComponent().eti().BNs)
          {
            if ((!(e.this.BNG instanceof l)) && (e.this.BNG.getVideoTotalTime() - e.this.BNG.getmPosition() < 2))
            {
              ae.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "cannot change play status in last 2 seconds");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(126269);
              return;
            }
            e.this.getFSVideoUIComponent().ete().j(e.Y(e.this));
            if (e.this.getFSVideoUIComponent().eti().eul())
            {
              e.this.getFSVideoUIComponent().eti().cyX();
              e.this.BNG.bTU();
              e.this.etB();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126269);
            return;
            e.this.getFSVideoUIComponent().eti().edW();
            e.this.BNG.bnY();
            break;
            ae.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "no video play now");
          }
        }
      });
      AppMethodBeat.o(126287);
      return;
      this.BNG = new f(getContext());
      if (al.aH(getContext()))
      {
        f localf = this.BNG;
        int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
        int j = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
        localf.BOb.setPadding(i, 0, j, 0);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126297);
    if (this.BNH != null) {
      this.BNH.w(paramMotionEvent);
    }
    AppMethodBeat.o(126297);
    return true;
  }
  
  public void updateView()
  {
    AppMethodBeat.i(126293);
    super.updateView();
    if (this.BNG != null)
    {
      this.BNG.setVideoTotalTime(this.BIY.AjG);
      this.BNG.m(this.BIY);
    }
    if ((getFSItemUIComponent() != null) && (getFSItemUIComponent().etc() != getFSVideoUIComponent().etl()))
    {
      if (!getFSVideoUIComponent().etd().isConnected()) {
        break label130;
      }
      etC();
    }
    for (;;)
    {
      if (this.titleTv != null)
      {
        this.titleTv.setText(this.BIY.title);
        al.a(this.titleTv.getPaint(), 0.8F);
      }
      AppMethodBeat.o(126293);
      return;
      label130:
      ko(getNoNetTip(), getContext().getString(2131764699));
    }
  }
  
  public class a
    implements c
  {
    private float BNW;
    
    a()
    {
      AppMethodBeat.i(126278);
      this.BNW = com.tencent.mm.cb.a.iv(e.this.getContext());
      AppMethodBeat.o(126278);
    }
    
    public void TH(int paramInt)
    {
      AppMethodBeat.i(126283);
      e.this.BNG.eus();
      e.ac(e.this).setVisibility(8);
      e.this.seekTo(paramInt);
      AppMethodBeat.o(126283);
    }
    
    public int bH(float paramFloat)
    {
      AppMethodBeat.i(126282);
      paramFloat /= this.BNW;
      int j = e.this.getFSVideoUIComponent().eti().getVideoDurationSec();
      int i = getCurrentPosition();
      int k = (int)(paramFloat * j) + i;
      if (k < 0) {
        i = 0;
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.websearch.ui.a.sz(j * 1000L);
        e.ab(e.this).setText(com.tencent.mm.plugin.websearch.ui.a.sz(i * 1000L) + "/" + str);
        AppMethodBeat.o(126282);
        return i;
        i = k;
        if (k > j) {
          i = j;
        }
      }
    }
    
    public final void bnF()
    {
      AppMethodBeat.i(126279);
      ae.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSingleTap");
      if (e.Z(e.this))
      {
        if (e.this.BNG.bnS())
        {
          e.this.BNG.setVisibility(8);
          AppMethodBeat.o(126279);
          return;
        }
        e.this.BNG.show();
        if (e.this.getFSItemUIComponent() != null)
        {
          e.this.getFSItemUIComponent().etb();
          e.this.getFSItemUIComponent().eta();
        }
      }
      AppMethodBeat.o(126279);
    }
    
    public final void bnG()
    {
      AppMethodBeat.i(126280);
      ae.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onDoubleTap");
      AppMethodBeat.o(126280);
    }
    
    public void bnH()
    {
      AppMethodBeat.i(126281);
      e.aa(e.this).setVisibility(0);
      e.this.BNG.eur();
      AppMethodBeat.o(126281);
    }
    
    public final boolean etx()
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
      int i = e.this.getFSVideoUIComponent().eti().getCurrPosSec();
      AppMethodBeat.o(126285);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e
 * JD-Core Version:    0.7.0.1
 */