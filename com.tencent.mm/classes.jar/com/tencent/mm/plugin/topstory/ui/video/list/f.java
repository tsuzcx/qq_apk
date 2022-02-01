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
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.h;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.protocal.protobuf.eip;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.eiy;
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
  private k Goo;
  private View.OnClickListener Gop;
  private View Gov;
  private TextView Gow;
  private TextView Gox;
  private ImageView Goy;
  private ImageView Goz;
  private g GpG;
  private View GpH;
  private TextView GpI;
  private boolean isLoading;
  private i.b wcv;
  
  public f(Context paramContext, com.tencent.mm.plugin.topstory.ui.video.b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    AppMethodBeat.i(126459);
    this.wcv = new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int j = 0;
        AppMethodBeat.i(126445);
        Log.e("MicroMsg.TopStory.TopStoryListVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 != 0)
        {
          paramAnonymousString2 = f.F(f.this).fyO().acd(f.E(f.this).fyH());
          if ((paramAnonymousString2 != null) && (paramAnonymousString2.Niw != null))
          {
            Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousString2.Niw.size()), paramAnonymousString2.videoUrl, Integer.valueOf(paramAnonymousString2.NiF) });
            int i = 0;
            while (i < paramAnonymousString2.Niw.size())
            {
              eiy localeiy = (eiy)paramAnonymousString2.Niw.get(i);
              if (paramAnonymousString2.videoUrl.equals(localeiy.url))
              {
                if (i + 1 >= paramAnonymousString2.Niw.size()) {
                  break;
                }
                i += 1;
                localeiy = (eiy)paramAnonymousString2.Niw.get(i);
                if ((localeiy == null) || (Util.isNullOrNil(localeiy.url))) {
                  break;
                }
                paramAnonymousString2.NiF = localeiy.NiF;
                paramAnonymousString2.videoUrl = localeiy.url;
                Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", new Object[] { Integer.valueOf(i), localeiy.url, Integer.valueOf(localeiy.NiF) });
                com.tencent.mm.plugin.websearch.api.a.b.pl(com.tencent.mm.plugin.websearch.api.a.b.IFT);
                f.this.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(126444);
                    f.this.ay(true, true);
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
        f.I(f.this).fyO().a(f.G(f.this).fyD(), f.H(f.this).fyH());
        f.this.lg(f.this.getContext().getString(2131767065, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), f.this.getContext().getString(2131767108));
        f.this.getListVideoUIComponent().fyF().onError(paramAnonymousString1);
        i.abQ(paramAnonymousInt1);
        paramAnonymousString1 = f.this.getListVideoUIComponent().fyB().GnT;
        paramAnonymousInt2 = j;
        if (paramAnonymousString1 != null)
        {
          paramAnonymousInt2 = j;
          if (paramAnonymousString1.Gjm > 0L) {
            paramAnonymousInt2 = (int)(System.currentTimeMillis() - paramAnonymousString1.Gjm) / 1000;
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
      
      public final void dH(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126446);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onPrepared");
        f.K(f.this).bKZ();
        if (!f.L(f.this)) {
          f.this.fyX();
        }
        AppMethodBeat.o(126446);
      }
      
      public final void dI(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126447);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoEnded, pos:%s, listpos:%s", new Object[] { Integer.valueOf(f.M(f.this).fyz()), Integer.valueOf(f.N(f.this).fyz()) });
        f.this.getListVideoUIComponent().fyF().aTH(paramAnonymousString1);
        f.this.getListVideoUIComponent().fyB().GnS = 1;
        if ((!f.this.getListVideoUIComponent().abU(f.O(f.this).fyz() + 1)) && ((f.P(f.this) instanceof h))) {}
        try
        {
          Thread.sleep(100L);
          label134:
          ((h)f.Q(f.this)).wu(true);
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
      
      public final void dJ(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dK(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dL(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126449);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaiting");
        f.a(f.this, true);
        AppMethodBeat.o(126449);
      }
      
      public final void dM(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126450);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaitingEnd");
        f.a(f.this, false);
        f.g(f.this).setVisibility(8);
        if (f.R(f.this).NiG != null)
        {
          Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "longVideoInfo onVideoWaitingEnd");
          f.S(f.this).setVisibility(0);
        }
        f.this.fyX();
        paramAnonymousString1 = f.this.getListVideoUIComponent().fyB().GnT;
        if ((paramAnonymousString1 != null) && (paramAnonymousString1.Gjx == 0L))
        {
          paramAnonymousString1.Gjx = (System.currentTimeMillis() - paramAnonymousString1.Gjm);
          Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramAnonymousString1.Gju), Long.valueOf(paramAnonymousString1.Gjx) });
        }
        AppMethodBeat.o(126450);
      }
      
      public final void fo(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    AppMethodBeat.o(126459);
  }
  
  private boolean bJf()
  {
    AppMethodBeat.i(126469);
    if (this.Gmd.getVisibility() == 0)
    {
      AppMethodBeat.o(126469);
      return true;
    }
    AppMethodBeat.o(126469);
    return false;
  }
  
  public final boolean ay(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(126464);
    paramBoolean1 = super.ay(paramBoolean1, paramBoolean2);
    getListVideoUIComponent().fyF().setMute(getListVideoUIComponent().Zx());
    AppMethodBeat.o(126464);
    return paramBoolean1;
  }
  
  public final i.e c(eiw parameiw)
  {
    return i.e.Kcb;
  }
  
  public final void fyV()
  {
    AppMethodBeat.i(126462);
    Log.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollPlayContainerStatus");
    this.Gmd.setVisibility(8);
    this.puw.setVisibility(0);
    this.GlU.setVisibility(8);
    this.GlT.setVisibility(8);
    this.Gmh.setVisibility(8);
    AppMethodBeat.o(126462);
  }
  
  public final void fyW()
  {
    AppMethodBeat.i(126463);
    Log.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollStopContainerStatus");
    this.Gmd.setVisibility(0);
    this.puw.setVisibility(0);
    this.GlU.setVisibility(8);
    this.GlT.setVisibility(8);
    this.Gmh.setVisibility(8);
    this.Gmf.setVisibility(0);
    this.Gme.setVisibility(8);
    this.GlX.setVisibility(0);
    this.GlY.setVisibility(8);
    this.Gmb.setVisibility(8);
    AppMethodBeat.o(126463);
  }
  
  public final void fyX()
  {
    AppMethodBeat.i(126461);
    super.fyX();
    AppMethodBeat.o(126461);
  }
  
  public final void fza()
  {
    AppMethodBeat.i(126467);
    if (this.GpG != null) {
      this.GpG.setVisibility(8);
    }
    AppMethodBeat.o(126467);
  }
  
  public final void fzb()
  {
    AppMethodBeat.i(126465);
    g localg = this.GpG;
    if (localg.GoU != null) {
      localg.GoU.stopTimer();
    }
    AppMethodBeat.o(126465);
  }
  
  public final void fzf()
  {
    AppMethodBeat.i(126470);
    super.fzf();
    if ((this.GjH.NiI != null) && (this.GjH.NiI.NhN != null))
    {
      this.Gow.setText(this.GjH.NiI.NhN.title);
      this.Gox.setText(this.GjH.NiI.NhN.desc);
      q.bcV().a(this.GjH.NiI.NhN.uNR, this.Goy, Glu);
      this.Gov.setVisibility(0);
      i.a(this.GlS.fyD(), this.GjH, 1);
      if (getControlBar().bJw())
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.Gov.getLayoutParams();
        localLayoutParams.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165308);
        this.Gov.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(126470);
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Gov.getLayoutParams();
      localLayoutParams.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165314);
      this.Gov.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(126470);
      return;
    }
    this.Gov.setVisibility(8);
    AppMethodBeat.o(126470);
  }
  
  public final void fzg()
  {
    AppMethodBeat.i(126471);
    super.fzg();
    this.Gov.setVisibility(8);
    AppMethodBeat.o(126471);
  }
  
  public final boolean fzh()
  {
    AppMethodBeat.i(161627);
    if (this.Gov.getVisibility() == 0)
    {
      AppMethodBeat.o(161627);
      return true;
    }
    AppMethodBeat.o(161627);
    return false;
  }
  
  public final g getControlBar()
  {
    return this.GpG;
  }
  
  public final int getLayoutId()
  {
    return 2131496748;
  }
  
  public final a getListItemUIComponent()
  {
    return (a)this.Gmk;
  }
  
  public final b getListVideoUIComponent()
  {
    return (b)this.GlS;
  }
  
  public final String getSessionId()
  {
    return this.sessionId;
  }
  
  public final eiw getVideoInfo()
  {
    return this.GjH;
  }
  
  public final i.b getVideoViewCallback()
  {
    return this.wcv;
  }
  
  public final void init()
  {
    AppMethodBeat.i(126460);
    super.init();
    this.GpH = findViewById(2131303833);
    this.GpI = ((TextView)findViewById(2131303832));
    this.Gov = findViewById(2131306029);
    this.Gow = ((TextView)findViewById(2131306030));
    this.Gox = ((TextView)findViewById(2131306027));
    this.Goy = ((ImageView)findViewById(2131306028));
    this.Goz = ((ImageView)findViewById(2131306026));
    this.Gop = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126429);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        f.this.getListVideoUIComponent().KD();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126429);
      }
    };
    this.GlZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126436);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (f.a(f.this) == com.tencent.mm.plugin.topstory.ui.video.f.a.Gmo)
        {
          f.this.getListVideoUIComponent().fyA().Gnu = true;
          f.b(f.this).abW(2);
        }
        if (f.this.getListVideoUIComponent().fyA().isConnected())
        {
          f.a(f.this, com.tencent.mm.plugin.topstory.ui.video.f.a.Gmn);
          if (f.this.getListVideoUIComponent().fyF().GnZ)
          {
            f.this.getListVideoUIComponent().fyF().eYd();
            f.this.fyX();
            com.tencent.mm.plugin.websearch.api.a.a.pl(19);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126436);
          return;
          f.this.ay(true, false);
          break;
          com.tencent.mm.plugin.websearch.api.a.a.pl(20);
        }
      }
    });
    this.GlX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126437);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        f.this.getListVideoUIComponent().fyB().GnS = 2;
        boolean bool;
        if ((f.this.getListItemUIComponent() != null) && (f.this.getListItemUIComponent().fyz() == f.this.getListVideoUIComponent().fyH()))
        {
          paramAnonymousView = f.this;
          if (!f.this.getListVideoUIComponent().fyA().Gnu)
          {
            bool = true;
            paramAnonymousView.ay(bool, false);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126437);
          return;
          bool = false;
          break;
          f.this.getListVideoUIComponent().abU(f.c(f.this).fyz());
          f.this.getListVideoUIComponent().fyB().k(f.d(f.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().fyD(), f.e(f.this), f.f(f.this).fyz(), 2, "");
        }
      }
    });
    this.GlY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126438);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        f.this.fzd();
        f.g(f.this).bJB();
        f.this.getListVideoUIComponent().fyB().GnS = 2;
        f.this.getListVideoUIComponent().fyF().a(f.this.getListVideoUIComponent(), f.h(f.this), f.i(f.this), f.j(f.this).fyz());
        f.this.fyX();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126438);
      }
    });
    this.Gmd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126439);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((f.this.getListItemUIComponent() != null) && (f.this.getListItemUIComponent().fyz() != f.this.getListVideoUIComponent().fyH()))
        {
          f.this.getListVideoUIComponent().fyB().GnS = 2;
          f.this.getListVideoUIComponent().abU(f.k(f.this).fyz());
          f.this.getListVideoUIComponent().fyB().k(f.l(f.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().fyD(), f.m(f.this), f.n(f.this).fyz(), 2, "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126439);
      }
    });
    this.GpH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126440);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new eit();
        paramAnonymousView.scene = f.this.getListVideoUIComponent().fyD().scene;
        paramAnonymousView.sGQ = UUID.randomUUID().toString();
        paramAnonymousView.NhZ = f.this.getListVideoUIComponent().fyD().hes;
        paramAnonymousView.Nia = f.this.getListVideoUIComponent().fyD().Nia;
        paramAnonymousView.NhX = f.o(f.this).NiG.psI;
        paramAnonymousView.NhY = f.this.getListVideoUIComponent().fyD().NhY;
        paramAnonymousView.Nic = f.p(f.this).NiG;
        paramAnonymousView.dDv = "topstory";
        paramAnonymousView.hes = f.this.getListVideoUIComponent().fyD().hes;
        paramAnonymousView.Nib = f.q(f.this).Nip;
        paramAnonymousView.Nic.Nix = f.r(f.this).Nix;
        paramAnonymousView.IDO.addAll(f.s(f.this).NiG.IDO);
        ai.a(f.this.getListVideoUIComponent().eeF(), paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126440);
      }
    });
    if (this.Gov != null) {
      this.Gov.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126442);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(MMApplicationContext.getContext());
          paramAnonymousView.bow(f.this.getContext().getString(2131766828, new Object[] { f.t(f.this).NiI.NhN.NhK })).Dq(true);
          paramAnonymousView.apa(2131755305);
          paramAnonymousView.c(new f.c()
          {
            public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(126441);
              if ((paramAnonymous2Boolean) && (f.u(f.this) != null) && (f.v(f.this).NiI != null) && (f.w(f.this).NiI.NhN != null))
              {
                i.a(f.x(f.this).fyD(), f.y(f.this), 2);
                paramAnonymous2String = new com.tencent.mm.plugin.appbrand.api.g();
                paramAnonymous2String.appId = f.z(f.this).NiI.NhN.appId;
                paramAnonymous2String.kHw = f.A(f.this).NiI.NhN.ecK;
                paramAnonymous2String.scene = 1152;
                ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(f.this.getContext(), paramAnonymous2String);
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
    if (this.Goz != null) {
      this.Goz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126443);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          f.B(f.this).setVisibility(8);
          i.a(f.C(f.this).fyD(), f.D(f.this), 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126443);
        }
      });
    }
    this.Goo = new k(getContext(), this, new a());
    this.GpG = new g(getContext());
    this.GpG.setVisibility(8);
    this.GpG.setFullScreenBtnClickListener(this.Gop);
    this.GpG.setOnUpdateProgressLenListener(new g.a()
    {
      public final void fzK()
      {
        AppMethodBeat.i(126431);
        f.af(f.this).setVisibility(8);
        RelativeLayout.LayoutParams localLayoutParams;
        if (f.ag(f.this).NiG != null)
        {
          f.S(f.this).setVisibility(0);
          localLayoutParams = (RelativeLayout.LayoutParams)f.S(f.this).getLayoutParams();
          localLayoutParams.bottomMargin = com.tencent.mm.cb.a.aH(f.this.getContext(), 2131165308);
          f.S(f.this).setLayoutParams(localLayoutParams);
        }
        if (f.B(f.this).getVisibility() == 0)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)f.B(f.this).getLayoutParams();
          localLayoutParams.bottomMargin = com.tencent.mm.cb.a.aH(f.this.getContext(), 2131165308);
          f.B(f.this).setLayoutParams(localLayoutParams);
        }
        AppMethodBeat.o(126431);
      }
      
      public final void fzL()
      {
        AppMethodBeat.i(126432);
        if (f.ah(f.this).NiG != null)
        {
          Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "longVideoInfo onControlBarGone");
          f.S(f.this).setVisibility(8);
        }
        if ((f.this.getListVideoUIComponent().fyF().GnZ) && ((f.this.getListVideoUIComponent().fyF().dFG()) || (f.this.getListVideoUIComponent().fyF().Goa))) {
          f.ai(f.this).setVisibility(0);
        }
        for (;;)
        {
          if (f.B(f.this).getVisibility() == 0)
          {
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)f.B(f.this).getLayoutParams();
            localLayoutParams.bottomMargin = com.tencent.mm.cb.a.aH(f.this.getContext(), 2131165314);
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
          Object localObject = f.this.getListVideoUIComponent().fyB().GnT;
          if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).Gjp < f.this.getListVideoUIComponent().fyF().getCurrPosMs())) {
            ((com.tencent.mm.plugin.topstory.a.b.b)localObject).Gjp = f.this.getListVideoUIComponent().fyF().getCurrPosMs();
          }
          if (f.this.getListVideoUIComponent().fyF().dFG())
          {
            int j = f.this.getListVideoUIComponent().fyF().getCurrPosMs() / 1000;
            if (((PluginTopStoryUI)com.tencent.mm.kernel.g.ah(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(f.U(f.this).psI)) {
              ((PluginTopStoryUI)com.tencent.mm.kernel.g.ah(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(f.V(f.this).psI, Integer.valueOf(j));
            }
          }
          if (!f.g(f.this).bJw())
          {
            localObject = (FrameLayout.LayoutParams)f.W(f.this).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject).width = i;
            f.X(f.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
            f.Y(f.this).requestLayout();
            f.Z(f.this).setVisibility(0);
          }
          if ((f.aa(f.this).Nix & 0x100) <= 0) {
            f.ac(f.this).a(f.ab(f.this), paramAnonymousInt1, paramAnonymousInt2);
          }
          f.ae(f.this).a(f.ad(f.this), f.this, paramAnonymousInt1);
          AppMethodBeat.o(126430);
          return;
        }
      }
    });
    this.GpG.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aJq()
      {
        AppMethodBeat.i(126433);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekPre");
        f.g(f.this).crH();
        AppMethodBeat.o(126433);
      }
      
      public final void rk(int paramAnonymousInt)
      {
        AppMethodBeat.i(126434);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        f.this.seekTo(paramAnonymousInt);
        f.g(f.this).bJB();
        com.tencent.mm.plugin.websearch.api.a.a.pl(22);
        AppMethodBeat.o(126434);
      }
    });
    this.GpG.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126435);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (f.this.getListVideoUIComponent().fyF().GnZ)
        {
          if (f.g(f.this).getVideoTotalTime() - f.g(f.this).getmPosition() < 2)
          {
            Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "cannot change play status in last 2 seconds");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126435);
            return;
          }
          f.this.getListVideoUIComponent().fyB().k(f.ak(f.this));
          if (f.this.getListVideoUIComponent().fyF().dFG())
          {
            f.this.getListVideoUIComponent().fyF().cXa();
            f.g(f.this).crH();
            f.this.fyX();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126435);
          return;
          f.this.getListVideoUIComponent().fyF().eYd();
          f.g(f.this).bJB();
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
    if (this.Goo != null) {
      this.Goo.A(paramMotionEvent);
    }
    AppMethodBeat.o(126468);
    return true;
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(126466);
    super.updateView();
    if (this.GpG != null) {
      this.GpG.setVideoTotalTime(this.GjH.Eso);
    }
    TextView localTextView;
    long l;
    String str;
    if ((getListItemUIComponent() != null) && (getListItemUIComponent().fyz() != getListVideoUIComponent().fyH()))
    {
      if (getListVideoUIComponent().fyA().isConnected()) {
        fyY();
      }
    }
    else
    {
      if (this.GjH.NiG == null) {
        break label295;
      }
      this.GpH.setVisibility(0);
      localTextView = this.GpI;
      l = this.GjH.NiG.Eso;
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
      lg(getNoNetTip(), getContext().getString(2131767108));
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
    this.GpH.setVisibility(8);
    AppMethodBeat.o(126466);
  }
  
  final class a
    implements c
  {
    private float GoD;
    
    a()
    {
      AppMethodBeat.i(126451);
      this.GoD = com.tencent.mm.cb.a.jo(f.this.getContext());
      AppMethodBeat.o(126451);
    }
    
    public final void abX(int paramInt)
    {
      AppMethodBeat.i(126456);
      f.g(f.this).fzN();
      f.ao(f.this).setVisibility(8);
      f.this.seekTo(paramInt);
      AppMethodBeat.o(126456);
    }
    
    public final void bJj()
    {
      AppMethodBeat.i(126452);
      Log.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onSingleTap");
      if (f.al(f.this))
      {
        if (f.g(f.this).bJw())
        {
          f.g(f.this).setVisibility(8);
          AppMethodBeat.o(126452);
          return;
        }
        f.g(f.this).show();
        if (f.this.getListItemUIComponent() != null)
        {
          f.this.getListItemUIComponent().fyy();
          f.this.getListItemUIComponent().fyx();
        }
      }
      AppMethodBeat.o(126452);
    }
    
    public final void bJk()
    {
      AppMethodBeat.i(126453);
      Log.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onDoubleTap");
      AppMethodBeat.o(126453);
    }
    
    public final void bJl()
    {
      AppMethodBeat.i(126454);
      f.am(f.this).setVisibility(0);
      f.g(f.this).fzM();
      AppMethodBeat.o(126454);
    }
    
    public final int ce(float paramFloat)
    {
      AppMethodBeat.i(126455);
      paramFloat /= this.GoD;
      int j = f.this.getListVideoUIComponent().fyF().getVideoDurationSec();
      int i = getCurrentPosition();
      int k = (int)(paramFloat * j) + i;
      if (k < 0) {
        i = 0;
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.websearch.ui.a.AF(j * 1000L);
        f.an(f.this).setText(com.tencent.mm.plugin.websearch.ui.a.AF(i * 1000L) + "/" + str);
        AppMethodBeat.o(126455);
        return i;
        i = k;
        if (k > j) {
          i = j;
        }
      }
    }
    
    public final boolean fyT()
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
      int i = f.this.getListVideoUIComponent().fyF().getCurrPosSec();
      AppMethodBeat.o(126458);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f
 * JD-Core Version:    0.7.0.1
 */