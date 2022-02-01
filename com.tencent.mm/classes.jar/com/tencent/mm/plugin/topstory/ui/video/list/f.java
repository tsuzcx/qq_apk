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
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.c.b;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.esq;
import com.tencent.mm.protocal.protobuf.esr;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.protocal.protobuf.eta;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.UUID;

public final class f
  extends com.tencent.mm.plugin.topstory.ui.video.f
{
  private View.OnClickListener JBh;
  private k Nbb;
  private View Nbh;
  private TextView Nbi;
  private TextView Nbj;
  private ImageView Nbk;
  private ImageView Nbl;
  private g Ncs;
  private View Nct;
  private TextView Ncu;
  private boolean isLoading;
  private i.b zxu;
  
  public f(Context paramContext, com.tencent.mm.plugin.topstory.ui.video.b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    AppMethodBeat.i(126459);
    this.zxu = new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int j = 0;
        AppMethodBeat.i(126445);
        Log.e("MicroMsg.TopStory.TopStoryListVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 != 0)
        {
          paramAnonymousString2 = f.F(f.this).gqL().ajJ(f.E(f.this).gqE());
          if ((paramAnonymousString2 != null) && (paramAnonymousString2.Uvc != null))
          {
            Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousString2.Uvc.size()), paramAnonymousString2.videoUrl, Integer.valueOf(paramAnonymousString2.Uvk) });
            int i = 0;
            while (i < paramAnonymousString2.Uvc.size())
            {
              eta localeta = (eta)paramAnonymousString2.Uvc.get(i);
              if (paramAnonymousString2.videoUrl.equals(localeta.url))
              {
                if (i + 1 >= paramAnonymousString2.Uvc.size()) {
                  break;
                }
                i += 1;
                localeta = (eta)paramAnonymousString2.Uvc.get(i);
                if ((localeta == null) || (Util.isNullOrNil(localeta.url))) {
                  break;
                }
                paramAnonymousString2.Uvk = localeta.Uvk;
                paramAnonymousString2.videoUrl = localeta.url;
                Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", new Object[] { Integer.valueOf(i), localeta.url, Integer.valueOf(localeta.Uvk) });
                com.tencent.mm.plugin.websearch.api.a.b.rE(com.tencent.mm.plugin.websearch.api.a.b.PAk);
                f.this.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(126444);
                    f.this.aL(true, true);
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
        f.I(f.this).gqL().a(f.G(f.this).gqA(), f.H(f.this).gqE());
        f.this.lF(f.this.getContext().getString(c.g.video_error_warnning, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), f.this.getContext().getString(c.g.video_retry_play));
        f.this.getListVideoUIComponent().gqC().onError(paramAnonymousString1);
        i.ajv(paramAnonymousInt1);
        paramAnonymousString1 = f.this.getListVideoUIComponent().gqy().NaG;
        paramAnonymousInt2 = j;
        if (paramAnonymousString1 != null)
        {
          paramAnonymousInt2 = j;
          if (paramAnonymousString1.MVX > 0L) {
            paramAnonymousInt2 = (int)(System.currentTimeMillis() - paramAnonymousString1.MVX) / 1000;
          }
        }
        i.a(f.J(f.this), paramAnonymousInt1, paramAnonymousString3, paramAnonymousInt2);
        AppMethodBeat.o(126445);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126448);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(126448);
      }
      
      public final void dS(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126446);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onPrepared");
        f.K(f.this).bWZ();
        if (!f.L(f.this)) {
          f.this.gqW();
        }
        AppMethodBeat.o(126446);
      }
      
      public final void dT(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126447);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoEnded, pos:%s, listpos:%s", new Object[] { Integer.valueOf(f.M(f.this).gqw()), Integer.valueOf(f.N(f.this).gqw()) });
        f.this.getListVideoUIComponent().gqC().bff(paramAnonymousString1);
        f.this.getListVideoUIComponent().gqy().NaF = 1;
        if ((!f.this.getListVideoUIComponent().ajA(f.O(f.this).gqw() + 1)) && ((f.P(f.this) instanceof com.tencent.mm.plugin.topstory.ui.video.h))) {}
        try
        {
          Thread.sleep(100L);
          label134:
          ((com.tencent.mm.plugin.topstory.ui.video.h)f.Q(f.this)).Ah(true);
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
      
      public final void dU(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dV(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dW(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126449);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaiting");
        f.a(f.this, true);
        AppMethodBeat.o(126449);
      }
      
      public final void dX(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126450);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaitingEnd");
        f.a(f.this, false);
        f.g(f.this).setVisibility(8);
        if (f.R(f.this).Uvl != null)
        {
          Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "longVideoInfo onVideoWaitingEnd");
          f.S(f.this).setVisibility(0);
        }
        f.this.gqW();
        paramAnonymousString1 = f.this.getListVideoUIComponent().gqy().NaG;
        if ((paramAnonymousString1 != null) && (paramAnonymousString1.MWi == 0L))
        {
          paramAnonymousString1.MWi = (System.currentTimeMillis() - paramAnonymousString1.MVX);
          Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramAnonymousString1.MWf), Long.valueOf(paramAnonymousString1.MWi) });
        }
        AppMethodBeat.o(126450);
      }
      
      public final void fC(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    AppMethodBeat.o(126459);
  }
  
  private boolean bUO()
  {
    AppMethodBeat.i(126469);
    if (this.MYP.getVisibility() == 0)
    {
      AppMethodBeat.o(126469);
      return true;
    }
    AppMethodBeat.o(126469);
    return false;
  }
  
  public final boolean aL(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(126464);
    paramBoolean1 = super.aL(paramBoolean1, paramBoolean2);
    getListVideoUIComponent().gqC().setMute(getListVideoUIComponent().aeg());
    AppMethodBeat.o(126464);
    return paramBoolean1;
  }
  
  public final i.e c(esy paramesy)
  {
    return i.e.RcG;
  }
  
  public final g getControlBar()
  {
    return this.Ncs;
  }
  
  public final int getLayoutId()
  {
    return c.e.top_story_list_video_container;
  }
  
  public final a getListItemUIComponent()
  {
    return (a)this.MYW;
  }
  
  public final b getListVideoUIComponent()
  {
    return (b)this.MYE;
  }
  
  public final String getSessionId()
  {
    return this.sessionId;
  }
  
  public final esy getVideoInfo()
  {
    return this.MWs;
  }
  
  public final i.b getVideoViewCallback()
  {
    return this.zxu;
  }
  
  public final void gqU()
  {
    AppMethodBeat.i(126462);
    Log.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollPlayContainerStatus");
    this.MYP.setVisibility(8);
    this.sDJ.setVisibility(0);
    this.MYG.setVisibility(8);
    this.MYF.setVisibility(8);
    this.MYT.setVisibility(8);
    AppMethodBeat.o(126462);
  }
  
  public final void gqV()
  {
    AppMethodBeat.i(126463);
    Log.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollStopContainerStatus");
    this.MYP.setVisibility(0);
    this.sDJ.setVisibility(0);
    this.MYG.setVisibility(8);
    this.MYF.setVisibility(8);
    this.MYT.setVisibility(8);
    this.MYR.setVisibility(0);
    this.MYQ.setVisibility(8);
    this.MYJ.setVisibility(0);
    this.MYK.setVisibility(8);
    this.MYN.setVisibility(8);
    AppMethodBeat.o(126463);
  }
  
  public final void gqW()
  {
    AppMethodBeat.i(126461);
    super.gqW();
    AppMethodBeat.o(126461);
  }
  
  public final void gqZ()
  {
    AppMethodBeat.i(126467);
    if (this.Ncs != null) {
      this.Ncs.setVisibility(8);
    }
    AppMethodBeat.o(126467);
  }
  
  public final void gra()
  {
    AppMethodBeat.i(126465);
    g localg = this.Ncs;
    if (localg.NbG != null) {
      localg.NbG.stopTimer();
    }
    AppMethodBeat.o(126465);
  }
  
  public final void gre()
  {
    AppMethodBeat.i(126470);
    super.gre();
    if ((this.MWs.Uvn != null) && (this.MWs.Uvn.Uut != null))
    {
      this.Nbi.setText(this.MWs.Uvn.Uut.title);
      this.Nbj.setText(this.MWs.Uvn.Uut.desc);
      q.bml().a(this.MWs.Uvn.Uut.avatar, this.Nbk, MYh);
      this.Nbh.setVisibility(0);
      i.a(this.MYE.gqA(), this.MWs, 1);
      if (getControlBar().bVd())
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.Nbh.getLayoutParams();
        localLayoutParams.bottomMargin = com.tencent.mm.ci.a.aZ(getContext(), c.b.Edge_6A);
        this.Nbh.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(126470);
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Nbh.getLayoutParams();
      localLayoutParams.bottomMargin = com.tencent.mm.ci.a.aZ(getContext(), c.b.Edge_A);
      this.Nbh.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(126470);
      return;
    }
    this.Nbh.setVisibility(8);
    AppMethodBeat.o(126470);
  }
  
  public final void grf()
  {
    AppMethodBeat.i(126471);
    super.grf();
    this.Nbh.setVisibility(8);
    AppMethodBeat.o(126471);
  }
  
  public final boolean grg()
  {
    AppMethodBeat.i(161627);
    if (this.Nbh.getVisibility() == 0)
    {
      AppMethodBeat.o(161627);
      return true;
    }
    AppMethodBeat.o(161627);
    return false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(126460);
    super.init();
    this.Nct = findViewById(c.d.long_video_layout);
    this.Ncu = ((TextView)findViewById(c.d.long_video_desc));
    this.Nbh = findViewById(c.d.point_video_layout);
    this.Nbi = ((TextView)findViewById(c.d.point_video_title));
    this.Nbj = ((TextView)findViewById(c.d.point_video_desc));
    this.Nbk = ((ImageView)findViewById(c.d.point_video_iv));
    this.Nbl = ((ImageView)findViewById(c.d.point_video_close_iv));
    this.JBh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126429);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        f.this.getListVideoUIComponent().Nq();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126429);
      }
    };
    this.MYL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126436);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (f.a(f.this) == com.tencent.mm.plugin.topstory.ui.video.f.a.MZa)
        {
          f.this.getListVideoUIComponent().gqx().Nah = true;
          f.b(f.this).ajC(2);
        }
        if (f.this.getListVideoUIComponent().gqx().isConnected())
        {
          f.a(f.this, com.tencent.mm.plugin.topstory.ui.video.f.a.MYZ);
          if (f.this.getListVideoUIComponent().gqC().NaM)
          {
            f.this.getListVideoUIComponent().gqC().fLJ();
            f.this.gqW();
            com.tencent.mm.plugin.websearch.api.a.a.rE(19);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126436);
          return;
          f.this.aL(true, false);
          break;
          com.tencent.mm.plugin.websearch.api.a.a.rE(20);
        }
      }
    });
    this.MYJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126437);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        f.this.getListVideoUIComponent().gqy().NaF = 2;
        boolean bool;
        if ((f.this.getListItemUIComponent() != null) && (f.this.getListItemUIComponent().gqw() == f.this.getListVideoUIComponent().gqE()))
        {
          paramAnonymousView = f.this;
          if (!f.this.getListVideoUIComponent().gqx().Nah)
          {
            bool = true;
            paramAnonymousView.aL(bool, false);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126437);
          return;
          bool = false;
          break;
          f.this.getListVideoUIComponent().ajA(f.c(f.this).gqw());
          f.this.getListVideoUIComponent().gqy().k(f.d(f.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().gqA(), f.e(f.this), f.f(f.this).gqw(), 2, "");
        }
      }
    });
    this.MYK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126438);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        f.this.grc();
        f.g(f.this).bVi();
        f.this.getListVideoUIComponent().gqy().NaF = 2;
        f.this.getListVideoUIComponent().gqC().a(f.this.getListVideoUIComponent(), f.h(f.this), f.i(f.this), f.j(f.this).gqw());
        f.this.gqW();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126438);
      }
    });
    this.MYP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126439);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((f.this.getListItemUIComponent() != null) && (f.this.getListItemUIComponent().gqw() != f.this.getListVideoUIComponent().gqE()))
        {
          f.this.getListVideoUIComponent().gqy().NaF = 2;
          f.this.getListVideoUIComponent().ajA(f.k(f.this).gqw());
          f.this.getListVideoUIComponent().gqy().k(f.l(f.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().gqA(), f.m(f.this), f.n(f.this).gqw(), 2, "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126439);
      }
    });
    this.Nct.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126440);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new esv();
        paramAnonymousView.scene = f.this.getListVideoUIComponent().gqA().scene;
        paramAnonymousView.wmL = UUID.randomUUID().toString();
        paramAnonymousView.UuF = f.this.getListVideoUIComponent().gqA().jQi;
        paramAnonymousView.UuG = f.this.getListVideoUIComponent().gqA().UuG;
        paramAnonymousView.UuD = f.o(f.this).Uvl.Crh;
        paramAnonymousView.UuE = f.this.getListVideoUIComponent().gqA().UuE;
        paramAnonymousView.UuI = f.p(f.this).Uvl;
        paramAnonymousView.fwe = "topstory";
        paramAnonymousView.jQi = f.this.getListVideoUIComponent().gqA().jQi;
        paramAnonymousView.UuH = f.q(f.this).UuV;
        paramAnonymousView.UuI.Uvd = f.r(f.this).Uvd;
        paramAnonymousView.Pye.addAll(f.s(f.this).Uvl.Pye);
        ai.a(f.this.getListVideoUIComponent().eOa(), paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126440);
      }
    });
    if (this.Nbh != null) {
      this.Nbh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126442);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(MMApplicationContext.getContext());
          paramAnonymousView.bBl(f.this.getContext().getString(c.g.top_story_open_appbrand, new Object[] { f.t(f.this).Uvn.Uut.Uuq })).HL(true);
          paramAnonymousView.ayp(c.g.app_accept);
          paramAnonymousView.c(new f.c()
          {
            public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(126441);
              if ((paramAnonymous2Boolean) && (f.u(f.this) != null) && (f.v(f.this).Uvn != null) && (f.w(f.this).Uvn.Uut != null))
              {
                i.a(f.x(f.this).gqA(), f.y(f.this), 2);
                paramAnonymous2String = new com.tencent.mm.plugin.appbrand.api.g();
                paramAnonymous2String.appId = f.z(f.this).Uvn.Uut.appId;
                paramAnonymous2String.nBq = f.A(f.this).Uvn.Uut.fWP;
                paramAnonymous2String.scene = 1152;
                ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.r.class)).a(f.this.getContext(), paramAnonymous2String);
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
    if (this.Nbl != null) {
      this.Nbl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126443);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          f.B(f.this).setVisibility(8);
          i.a(f.C(f.this).gqA(), f.D(f.this), 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126443);
        }
      });
    }
    this.Nbb = new k(getContext(), this, new a());
    this.Ncs = new g(getContext());
    this.Ncs.setVisibility(8);
    this.Ncs.setFullScreenBtnClickListener(this.JBh);
    this.Ncs.setOnUpdateProgressLenListener(new g.a()
    {
      public final void grL()
      {
        AppMethodBeat.i(126431);
        f.af(f.this).setVisibility(8);
        RelativeLayout.LayoutParams localLayoutParams;
        if (f.ag(f.this).Uvl != null)
        {
          f.S(f.this).setVisibility(0);
          localLayoutParams = (RelativeLayout.LayoutParams)f.S(f.this).getLayoutParams();
          localLayoutParams.bottomMargin = com.tencent.mm.ci.a.aZ(f.this.getContext(), c.b.Edge_6A);
          f.S(f.this).setLayoutParams(localLayoutParams);
        }
        if (f.B(f.this).getVisibility() == 0)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)f.B(f.this).getLayoutParams();
          localLayoutParams.bottomMargin = com.tencent.mm.ci.a.aZ(f.this.getContext(), c.b.Edge_6A);
          f.B(f.this).setLayoutParams(localLayoutParams);
        }
        AppMethodBeat.o(126431);
      }
      
      public final void grM()
      {
        AppMethodBeat.i(126432);
        if (f.ah(f.this).Uvl != null)
        {
          Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "longVideoInfo onControlBarGone");
          f.S(f.this).setVisibility(8);
        }
        if ((f.this.getListVideoUIComponent().gqC().NaM) && ((f.this.getListVideoUIComponent().gqC().ehu()) || (f.this.getListVideoUIComponent().gqC().NaN))) {
          f.ai(f.this).setVisibility(0);
        }
        for (;;)
        {
          if (f.B(f.this).getVisibility() == 0)
          {
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)f.B(f.this).getLayoutParams();
            localLayoutParams.bottomMargin = com.tencent.mm.ci.a.aZ(f.this.getContext(), c.b.Edge_A);
            f.B(f.this).setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(126432);
          return;
          f.aj(f.this).setVisibility(8);
        }
      }
      
      public final void kC(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126430);
        if (paramAnonymousInt2 > 0) {}
        for (int i = f.T(f.this).getWidth() * paramAnonymousInt1 / paramAnonymousInt2;; i = 0)
        {
          Object localObject = f.this.getListVideoUIComponent().gqy().NaG;
          if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).MWa < f.this.getListVideoUIComponent().gqC().getCurrPosMs())) {
            ((com.tencent.mm.plugin.topstory.a.b.b)localObject).MWa = f.this.getListVideoUIComponent().gqC().getCurrPosMs();
          }
          if (f.this.getListVideoUIComponent().gqC().ehu())
          {
            int j = f.this.getListVideoUIComponent().gqC().getCurrPosMs() / 1000;
            if (((PluginTopStoryUI)com.tencent.mm.kernel.h.ag(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(f.U(f.this).Crh)) {
              ((PluginTopStoryUI)com.tencent.mm.kernel.h.ag(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(f.V(f.this).Crh, Integer.valueOf(j));
            }
          }
          if (!f.g(f.this).bVd())
          {
            localObject = (FrameLayout.LayoutParams)f.W(f.this).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject).width = i;
            f.X(f.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
            f.Y(f.this).requestLayout();
            f.Z(f.this).setVisibility(0);
          }
          if ((f.aa(f.this).Uvd & 0x100) <= 0) {
            f.ac(f.this).a(f.ab(f.this), paramAnonymousInt1, paramAnonymousInt2);
          }
          f.ae(f.this).a(f.ad(f.this), f.this, paramAnonymousInt1);
          AppMethodBeat.o(126430);
          return;
        }
      }
    });
    this.Ncs.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aRo()
      {
        AppMethodBeat.i(126433);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekPre");
        f.g(f.this).cEO();
        AppMethodBeat.o(126433);
      }
      
      public final void tY(int paramAnonymousInt)
      {
        AppMethodBeat.i(126434);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        f.this.seekTo(paramAnonymousInt);
        f.g(f.this).bVi();
        com.tencent.mm.plugin.websearch.api.a.a.rE(22);
        AppMethodBeat.o(126434);
      }
    });
    this.Ncs.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126435);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (f.this.getListVideoUIComponent().gqC().NaM)
        {
          if (f.g(f.this).getVideoTotalTime() - f.g(f.this).getmPosition() < 2)
          {
            Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "cannot change play status in last 2 seconds");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126435);
            return;
          }
          f.this.getListVideoUIComponent().gqy().k(f.ak(f.this));
          if (f.this.getListVideoUIComponent().gqC().ehu())
          {
            f.this.getListVideoUIComponent().gqC().dmi();
            f.g(f.this).cEO();
            f.this.gqW();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126435);
          return;
          f.this.getListVideoUIComponent().gqC().fLJ();
          f.g(f.this).bVi();
          break;
          Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "no video play now");
        }
      }
    });
    AppMethodBeat.o(126460);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126468);
    if (this.Nbb != null) {
      this.Nbb.C(paramMotionEvent);
    }
    AppMethodBeat.o(126468);
    return true;
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(126466);
    super.updateView();
    if (this.Ncs != null) {
      this.Ncs.setVideoTotalTime(this.MWs.KFK);
    }
    TextView localTextView;
    long l;
    String str;
    if ((getListItemUIComponent() != null) && (getListItemUIComponent().gqw() != getListVideoUIComponent().gqE()))
    {
      if (getListVideoUIComponent().gqx().isConnected()) {
        gqX();
      }
    }
    else
    {
      if (this.MWs.Uvl == null) {
        break label295;
      }
      this.Nct.setVisibility(0);
      localTextView = this.Ncu;
      l = this.MWs.Uvl.KFK;
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
      lF(getNoNetTip(), getContext().getString(c.g.video_retry_play));
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
    this.Nct.setVisibility(8);
    AppMethodBeat.o(126466);
  }
  
  final class a
    implements c
  {
    private float Nbp;
    
    a()
    {
      AppMethodBeat.i(126451);
      this.Nbp = com.tencent.mm.ci.a.ks(f.this.getContext());
      AppMethodBeat.o(126451);
    }
    
    public final void ajD(int paramInt)
    {
      AppMethodBeat.i(126456);
      f.g(f.this).grO();
      f.ao(f.this).setVisibility(8);
      f.this.seekTo(paramInt);
      AppMethodBeat.o(126456);
    }
    
    public final void bUS()
    {
      AppMethodBeat.i(126452);
      Log.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onSingleTap");
      if (f.al(f.this))
      {
        if (f.g(f.this).bVd())
        {
          f.g(f.this).setVisibility(8);
          AppMethodBeat.o(126452);
          return;
        }
        f.g(f.this).show();
        if (f.this.getListItemUIComponent() != null)
        {
          f.this.getListItemUIComponent().gqv();
          f.this.getListItemUIComponent().gqu();
        }
      }
      AppMethodBeat.o(126452);
    }
    
    public final void bUT()
    {
      AppMethodBeat.i(126453);
      Log.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onDoubleTap");
      AppMethodBeat.o(126453);
    }
    
    public final void bUU()
    {
      AppMethodBeat.i(126454);
      f.am(f.this).setVisibility(0);
      f.g(f.this).grN();
      AppMethodBeat.o(126454);
    }
    
    public final int cn(float paramFloat)
    {
      AppMethodBeat.i(126455);
      paramFloat /= this.Nbp;
      int j = f.this.getListVideoUIComponent().gqC().getVideoDurationSec();
      int i = getCurrentPosition();
      int k = (int)(paramFloat * j) + i;
      if (k < 0) {
        i = 0;
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.websearch.ui.b.GN(j * 1000L);
        f.an(f.this).setText(com.tencent.mm.plugin.websearch.ui.b.GN(i * 1000L) + "/" + str);
        AppMethodBeat.o(126455);
        return i;
        i = k;
        if (k > j) {
          i = j;
        }
      }
    }
    
    public final int getCurrentPosition()
    {
      AppMethodBeat.i(126458);
      int i = f.this.getListVideoUIComponent().gqC().getCurrPosSec();
      AppMethodBeat.o(126458);
      return i;
    }
    
    public final boolean gqQ()
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f
 * JD-Core Version:    0.7.0.1
 */