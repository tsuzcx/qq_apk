package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
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
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.protocal.protobuf.esq;
import com.tencent.mm.protocal.protobuf.esr;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.protocal.protobuf.eta;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;
import java.util.LinkedList;

public class e
  extends com.tencent.mm.plugin.topstory.ui.video.f
{
  protected View.OnClickListener JBh;
  protected f Nba;
  protected k Nbb;
  protected View.OnClickListener Nbc;
  protected View.OnClickListener Nbd;
  protected View.OnClickListener Nbe;
  protected View.OnClickListener Nbf;
  protected View.OnClickListener Nbg;
  private View Nbh;
  private TextView Nbi;
  private TextView Nbj;
  private ImageView Nbk;
  private ImageView Nbl;
  private boolean isLoading;
  private i.b zxu;
  
  public e(Context paramContext, com.tencent.mm.plugin.topstory.ui.video.b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    AppMethodBeat.i(126286);
    this.zxu = new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int j = 0;
        AppMethodBeat.i(126257);
        Log.e("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        paramAnonymousString2 = e.B(e.this).gqL().ajJ(e.A(e.this).gqE());
        if ((paramAnonymousString2 != null) && (paramAnonymousString2.Uvc != null))
        {
          Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousString2.Uvc.size()), paramAnonymousString2.videoUrl, Integer.valueOf(paramAnonymousString2.Uvk) });
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
              Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", new Object[] { Integer.valueOf(i), localeta.url, Integer.valueOf(localeta.Uvk) });
              com.tencent.mm.plugin.websearch.api.a.b.rE(com.tencent.mm.plugin.websearch.api.a.b.PAk);
              e.this.postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(126256);
                  e.this.aL(true, true);
                  AppMethodBeat.o(126256);
                }
              }, 100L);
              AppMethodBeat.o(126257);
              return;
            }
            i += 1;
          }
        }
        e.E(e.this).gqL().a(e.C(e.this).gqA(), e.D(e.this).gqE());
        e.this.lF(e.this.getContext().getString(c.g.video_error_warnning, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), e.this.getContext().getString(c.g.video_retry_play));
        e.this.getFSVideoUIComponent().gqC().onError(paramAnonymousString1);
        i.ajv(paramAnonymousInt1);
        paramAnonymousString1 = e.this.getFSVideoUIComponent().gqy().NaG;
        paramAnonymousInt2 = j;
        if (paramAnonymousString1 != null)
        {
          paramAnonymousInt2 = j;
          if (paramAnonymousString1.MVX > 0L) {
            paramAnonymousInt2 = (int)(System.currentTimeMillis() - paramAnonymousString1.MVX) / 1000;
          }
        }
        i.a(paramAnonymousString2, paramAnonymousInt1, paramAnonymousString3, paramAnonymousInt2);
        AppMethodBeat.o(126257);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126260);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(126260);
      }
      
      public final void dS(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126258);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onPrepared");
        e.this.Nbb.bWZ();
        if (!e.F(e.this)) {
          e.this.gqW();
        }
        AppMethodBeat.o(126258);
      }
      
      public final void dT(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126259);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoEnded");
        e.this.getFSVideoUIComponent().gqC().bff(paramAnonymousString1);
        e.this.getFSVideoUIComponent().gqy().NaF = 1;
        int i = e.this.getFSVideoUIComponent().gqP();
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "clicfg_topstory_v_video_play  %s", new Object[] { Integer.valueOf(i) });
        if ((i == 1) && (e.this.getFSVideoUIComponent().gqI()) && ((e.G(e.this) instanceof j))) {}
        try
        {
          Thread.sleep(100L);
          ((j)e.H(e.this)).Ah(true);
          Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "VVideoAutoPlay replay succ");
          bool = true;
          if ((bool) || (!(e.J(e.this) instanceof com.tencent.mm.plugin.topstory.ui.video.h))) {}
        }
        catch (InterruptedException paramAnonymousString1)
        {
          try
          {
            for (;;)
            {
              Thread.sleep(100L);
              label166:
              ((com.tencent.mm.plugin.topstory.ui.video.h)e.K(e.this)).Ah(true);
              e.a(e.this, false);
              AppMethodBeat.o(126259);
              return;
              boolean bool = e.this.getFSVideoUIComponent().ajA(e.I(e.this).gqw() + 1);
            }
            paramAnonymousString1 = paramAnonymousString1;
          }
          catch (InterruptedException paramAnonymousString1)
          {
            break label166;
          }
        }
      }
      
      public final void dU(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dV(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dW(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126261);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaiting");
        e.a(e.this, true);
        AppMethodBeat.o(126261);
      }
      
      public final void dX(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126262);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaitingEnd");
        e.a(e.this, false);
        e.this.gqW();
        paramAnonymousString1 = e.this.getFSVideoUIComponent().gqy().NaG;
        if ((paramAnonymousString1 != null) && (paramAnonymousString1.MWi == 0L))
        {
          paramAnonymousString1.MWi = (System.currentTimeMillis() - paramAnonymousString1.MVX);
          Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramAnonymousString1.MWf), Long.valueOf(paramAnonymousString1.MWi) });
        }
        AppMethodBeat.o(126262);
      }
      
      public final void fC(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    if (this.MYE.gqI()) {
      this.sDJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    AppMethodBeat.o(126286);
  }
  
  private boolean bUO()
  {
    AppMethodBeat.i(126298);
    if (this.MYP.getVisibility() == 0)
    {
      AppMethodBeat.o(126298);
      return true;
    }
    AppMethodBeat.o(126298);
    return false;
  }
  
  protected void bUH()
  {
    AppMethodBeat.i(126296);
    this.Nbb = new k(getContext(), this, new a());
    AppMethodBeat.o(126296);
  }
  
  public i.e c(esy paramesy)
  {
    return i.e.RcG;
  }
  
  public final void cEI()
  {
    AppMethodBeat.i(126295);
    if (this.Nba != null) {
      this.Nba.show();
    }
    AppMethodBeat.o(126295);
  }
  
  public f getControlBar()
  {
    return this.Nba;
  }
  
  public a getFSItemUIComponent()
  {
    return (a)this.MYW;
  }
  
  public com.tencent.mm.plugin.topstory.ui.video.b getFSVideoUIComponent()
  {
    return this.MYE;
  }
  
  public int getLayoutId()
  {
    return c.e.top_story_fs_video_container;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public esy getVideoInfo()
  {
    return this.MWs;
  }
  
  public i.b getVideoViewCallback()
  {
    return this.zxu;
  }
  
  public final void gqU()
  {
    AppMethodBeat.i(126290);
    Log.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollPlayContainerStatus");
    this.MYP.setVisibility(8);
    this.MYO.setVisibility(8);
    this.sDJ.setVisibility(0);
    this.MYG.setVisibility(8);
    this.MYF.setVisibility(8);
    this.MYT.setVisibility(8);
    AppMethodBeat.o(126290);
  }
  
  public final void gqV()
  {
    AppMethodBeat.i(126291);
    Log.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollStopContainerStatus");
    this.MYP.setVisibility(0);
    if ((getFSVideoUIComponent().gqx().grx()) && (!ai.isFreeSimCard())) {
      this.MYO.setVisibility(0);
    }
    for (;;)
    {
      this.sDJ.setVisibility(0);
      this.MYG.setVisibility(8);
      this.MYF.setVisibility(8);
      this.MYT.setVisibility(8);
      this.MYR.setVisibility(0);
      this.MYQ.setVisibility(8);
      this.MYJ.setVisibility(0);
      this.MYK.setVisibility(8);
      this.MYN.setVisibility(8);
      AppMethodBeat.o(126291);
      return;
      this.MYO.setVisibility(8);
    }
  }
  
  public final void gqW()
  {
    AppMethodBeat.i(126288);
    super.gqW();
    AppMethodBeat.o(126288);
  }
  
  public final void gqZ()
  {
    AppMethodBeat.i(126294);
    if (this.Nba != null) {
      this.Nba.setVisibility(8);
    }
    AppMethodBeat.o(126294);
  }
  
  protected void grJ()
  {
    AppMethodBeat.i(126289);
    this.Nba.m(this.MWs);
    AppMethodBeat.o(126289);
  }
  
  public boolean grK()
  {
    return false;
  }
  
  public final void gra()
  {
    AppMethodBeat.i(126292);
    f localf = this.Nba;
    if (localf.NbG != null) {
      localf.NbG.stopTimer();
    }
    AppMethodBeat.o(126292);
  }
  
  public final void gre()
  {
    AppMethodBeat.i(126299);
    super.gre();
    if (grK())
    {
      AppMethodBeat.o(126299);
      return;
    }
    if ((this.MWs.Uvn != null) && (this.MWs.Uvn.Uut != null))
    {
      this.Nbi.setText(this.MWs.Uvn.Uut.title);
      this.Nbj.setText(this.MWs.Uvn.Uut.desc);
      q.bml().a(this.MWs.Uvn.Uut.avatar, this.Nbk, MYh);
      this.Nbh.setVisibility(0);
      i.a(this.MYE.gqA(), this.MWs, 1);
      AppMethodBeat.o(126299);
      return;
    }
    this.Nbh.setVisibility(8);
    AppMethodBeat.o(126299);
  }
  
  public final void grf()
  {
    AppMethodBeat.i(126300);
    super.grf();
    if (grK())
    {
      AppMethodBeat.o(126300);
      return;
    }
    this.Nbh.setVisibility(8);
    AppMethodBeat.o(126300);
  }
  
  public final boolean grg()
  {
    AppMethodBeat.i(161624);
    if (this.Nbh != null)
    {
      if (this.Nbh.getVisibility() == 0)
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
  
  public void init()
  {
    AppMethodBeat.i(126287);
    super.init();
    if (!grK())
    {
      this.Nbh = findViewById(c.d.point_video_layout);
      this.Nbi = ((TextView)findViewById(c.d.point_video_title));
      this.Nbj = ((TextView)findViewById(c.d.point_video_desc));
      this.Nbk = ((ImageView)findViewById(c.d.point_video_iv));
      this.Nbl = ((ImageView)findViewById(c.d.point_video_close_iv));
    }
    this.JBh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126251);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        e.this.getFSVideoUIComponent().Np();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126251);
      }
    };
    this.Nbc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126270);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        e.this.getFSVideoUIComponent().aD(paramAnonymousView, e.a(e.this).gqw());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126270);
      }
    };
    this.Nbd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126271);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        e.this.getFSItemUIComponent().ajL(e.b(e.this).gqw());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126271);
      }
    };
    this.Nbe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126272);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        e.this.getFSVideoUIComponent().a(e.c(e.this), paramAnonymousView);
        e.this.grJ();
        if (!e.this.grK()) {
          e.d(e.this).setVisibility(8);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126272);
      }
    };
    this.Nbf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126273);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = e.this.getFSVideoUIComponent();
        e.e(e.this).gqw();
        ((com.tencent.mm.plugin.topstory.ui.video.b)localObject).a((eij)paramAnonymousView.getTag());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126273);
      }
    };
    this.Nbg = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126274);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        n.a(e.f(e.this), e.this.getFSVideoUIComponent().eOa());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126274);
      }
    };
    this.MYL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126275);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (e.g(e.this) == com.tencent.mm.plugin.topstory.ui.video.f.a.MZa)
        {
          e.this.getFSVideoUIComponent().gqx().Nah = true;
          e.h(e.this).ajC(2);
        }
        if (e.this.getFSVideoUIComponent().gqx().isConnected())
        {
          e.a(e.this, com.tencent.mm.plugin.topstory.ui.video.f.a.MYZ);
          if (e.this.getFSVideoUIComponent().gqC().NaM)
          {
            e.this.getFSVideoUIComponent().gqC().fLJ();
            com.tencent.mm.plugin.websearch.api.a.a.rE(19);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126275);
          return;
          e.this.aL(true, false);
          break;
          com.tencent.mm.plugin.websearch.api.a.a.rE(20);
        }
      }
    });
    this.MYJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126276);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        e.this.getFSVideoUIComponent().gqy().NaF = 2;
        boolean bool;
        if ((e.this.getFSItemUIComponent() != null) && (e.this.getFSItemUIComponent().gqw() == e.this.getFSVideoUIComponent().gqE()))
        {
          paramAnonymousView = e.this;
          if (!e.this.getFSVideoUIComponent().gqx().Nah)
          {
            bool = true;
            paramAnonymousView.aL(bool, false);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126276);
          return;
          bool = false;
          break;
          e.this.getFSVideoUIComponent().ajA(e.i(e.this).gqw());
          e.this.getFSVideoUIComponent().gqy().k(e.j(e.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().gqA(), e.k(e.this), e.l(e.this).gqw(), 2, "");
        }
      }
    });
    this.MYK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126277);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        e.this.grc();
        e.this.Nba.bVi();
        e.this.getFSVideoUIComponent().gqy().NaF = 2;
        e.this.getFSVideoUIComponent().gqC().a(e.this.getFSVideoUIComponent(), e.m(e.this), e.n(e.this), e.o(e.this).gqw());
        e.this.gqW();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126277);
      }
    });
    this.MYP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126252);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((e.this.getFSItemUIComponent() != null) && (e.this.getFSItemUIComponent().gqw() != e.this.getFSVideoUIComponent().gqE()))
        {
          e.this.getFSVideoUIComponent().gqy().NaF = 2;
          e.this.getFSVideoUIComponent().ajA(e.p(e.this).gqw());
          e.this.getFSVideoUIComponent().gqy().k(e.q(e.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().gqA(), e.r(e.this), e.s(e.this).gqw(), 2, "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126252);
      }
    });
    if (!grK())
    {
      this.Nbh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126254);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(MMApplicationContext.getContext());
          paramAnonymousView.bBl(e.this.getContext().getString(c.g.top_story_open_appbrand, new Object[] { e.t(e.this).Uvn.Uut.Uuq })).HL(true);
          paramAnonymousView.ayp(c.g.app_accept);
          paramAnonymousView.c(new f.c()
          {
            public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(126253);
              if (paramAnonymous2Boolean)
              {
                i.a(e.u(e.this).gqA(), e.v(e.this), 2);
                paramAnonymous2String = new g();
                paramAnonymous2String.appId = e.w(e.this).Uvn.Uut.appId;
                paramAnonymous2String.nBq = e.x(e.this).Uvn.Uut.fWP;
                paramAnonymous2String.scene = 1152;
                ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.r.class)).a(e.this.getContext(), paramAnonymous2String);
                e.d(e.this).setVisibility(8);
              }
              AppMethodBeat.o(126253);
            }
          }).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126254);
        }
      });
      this.Nbl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126255);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          e.d(e.this).setVisibility(8);
          i.a(e.y(e.this).gqA(), e.z(e.this), 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126255);
        }
      });
    }
    bUH();
    if (getFSVideoUIComponent().gqI()) {
      this.Nba = new l(getContext());
    }
    for (;;)
    {
      this.Nba.setOnlyFS(grK());
      this.Nba.setVisibility(8);
      this.Nba.setShareBtnClickListener(this.Nbd);
      this.Nba.setWowBtnClickListener(this.Nbe);
      this.Nba.setTagBtnClickListener(this.Nbf);
      this.Nba.setSourceItemClickListener(this.Nbg);
      if (com.tencent.mm.plugin.topstory.a.h.gpM()) {
        this.Nba.setTitleClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(126263);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            e.this.getFSVideoUIComponent().gqC().NaO = true;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126263);
          }
        });
      }
      this.Nba.setOnUpdateProgressLenListener(new f.a()
      {
        public final void b(esy paramAnonymousesy, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(126264);
          if (paramAnonymousInt2 > 0) {}
          for (int i = e.L(e.this).getWidth() * paramAnonymousInt1 / paramAnonymousInt2;; i = 0)
          {
            Object localObject = e.this.getFSVideoUIComponent().gqy().NaG;
            if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).MWa < e.this.getFSVideoUIComponent().gqC().getCurrPosMs())) {
              ((com.tencent.mm.plugin.topstory.a.b.b)localObject).MWa = e.this.getFSVideoUIComponent().gqC().getCurrPosMs();
            }
            if (e.M(e.this).gqC().ehu())
            {
              int j = e.N(e.this).gqC().getCurrPosMs() / 1000;
              if (((PluginTopStoryUI)com.tencent.mm.kernel.h.ag(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(paramAnonymousesy.Crh)) {
                ((PluginTopStoryUI)com.tencent.mm.kernel.h.ag(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(paramAnonymousesy.Crh, Integer.valueOf(j));
              }
            }
            localObject = (FrameLayout.LayoutParams)e.O(e.this).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject).width = i;
            e.P(e.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
            e.Q(e.this).requestLayout();
            if (!e.this.Nba.bVd()) {
              e.this.Nba.setVisibility(8);
            }
            if ((paramAnonymousesy.Uvd & 0x100) <= 0) {
              e.R(e.this).a(paramAnonymousesy, paramAnonymousInt1, paramAnonymousInt2);
            }
            e.S(e.this).a(paramAnonymousesy, e.this, paramAnonymousInt1);
            AppMethodBeat.o(126264);
            return;
          }
        }
        
        public final void grL()
        {
          AppMethodBeat.i(126265);
          e.T(e.this).setVisibility(8);
          AppMethodBeat.o(126265);
        }
        
        public final void grM()
        {
          AppMethodBeat.i(126266);
          if ((e.this.getFSVideoUIComponent().gqC().NaM) && ((e.this.getFSVideoUIComponent().gqC().ehu()) || (e.this.getFSVideoUIComponent().gqC().NaN)))
          {
            e.U(e.this).setVisibility(0);
            AppMethodBeat.o(126266);
            return;
          }
          e.V(e.this).setVisibility(8);
          AppMethodBeat.o(126266);
        }
      });
      this.Nba.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
      {
        public final void aRo()
        {
          AppMethodBeat.i(126267);
          Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekPre");
          e.this.Nba.cEO();
          AppMethodBeat.o(126267);
        }
        
        public final void tY(int paramAnonymousInt)
        {
          AppMethodBeat.i(126268);
          Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          e.this.seekTo(paramAnonymousInt);
          e.this.Nba.bVi();
          com.tencent.mm.plugin.websearch.api.a.a.rE(22);
          AppMethodBeat.o(126268);
        }
      });
      this.Nba.setOnPlayButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126269);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (e.this.getFSVideoUIComponent().gqC().NaM)
          {
            if ((!(e.this.Nba instanceof l)) && (e.this.Nba.getVideoTotalTime() - e.this.Nba.getmPosition() < 2))
            {
              Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "cannot change play status in last 2 seconds");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(126269);
              return;
            }
            e.this.getFSVideoUIComponent().gqy().k(e.W(e.this));
            if (e.this.getFSVideoUIComponent().gqC().ehu())
            {
              e.this.getFSVideoUIComponent().gqC().dmi();
              e.this.Nba.cEO();
              e.this.gqW();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126269);
            return;
            e.this.getFSVideoUIComponent().gqC().fLJ();
            e.this.Nba.bVi();
            break;
            Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "no video play now");
          }
        }
      });
      AppMethodBeat.o(126287);
      return;
      this.Nba = new f(getContext());
      if (ar.aN(getContext()))
      {
        f localf = this.Nba;
        int i = com.tencent.mm.ci.a.fromDPToPix(getContext(), 24);
        int j = com.tencent.mm.ci.a.fromDPToPix(getContext(), 24);
        localf.Nbu.setPadding(i, 0, j, 0);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126297);
    if (this.Nbb != null) {
      this.Nbb.C(paramMotionEvent);
    }
    AppMethodBeat.o(126297);
    return true;
  }
  
  public void updateView()
  {
    AppMethodBeat.i(126293);
    super.updateView();
    if (this.Nba != null)
    {
      this.Nba.setVideoTotalTime(this.MWs.KFK);
      this.Nba.n(this.MWs);
    }
    if ((getFSItemUIComponent() != null) && (getFSItemUIComponent().gqw() != getFSVideoUIComponent().gqE()))
    {
      if (!getFSVideoUIComponent().gqx().isConnected()) {
        break label130;
      }
      gqX();
    }
    for (;;)
    {
      if (this.titleTv != null)
      {
        this.titleTv.setText(this.MWs.title);
        ar.a(this.titleTv.getPaint(), 0.8F);
      }
      AppMethodBeat.o(126293);
      return;
      label130:
      lF(getNoNetTip(), getContext().getString(c.g.video_retry_play));
    }
  }
  
  public class a
    implements c
  {
    private float Nbp;
    
    a()
    {
      AppMethodBeat.i(126278);
      this.Nbp = com.tencent.mm.ci.a.ks(e.this.getContext());
      AppMethodBeat.o(126278);
    }
    
    public void ajD(int paramInt)
    {
      AppMethodBeat.i(126283);
      e.this.Nba.grO();
      e.aa(e.this).setVisibility(8);
      e.this.seekTo(paramInt);
      AppMethodBeat.o(126283);
    }
    
    public final void bUS()
    {
      AppMethodBeat.i(126279);
      Log.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSingleTap");
      if (e.X(e.this))
      {
        if (e.this.Nba.bVd())
        {
          e.this.Nba.setVisibility(8);
          AppMethodBeat.o(126279);
          return;
        }
        e.this.Nba.show();
        if (e.this.getFSItemUIComponent() != null)
        {
          e.this.getFSItemUIComponent().gqv();
          e.this.getFSItemUIComponent().gqu();
        }
      }
      AppMethodBeat.o(126279);
    }
    
    public final void bUT()
    {
      AppMethodBeat.i(126280);
      Log.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onDoubleTap");
      AppMethodBeat.o(126280);
    }
    
    public void bUU()
    {
      AppMethodBeat.i(126281);
      e.Y(e.this).setVisibility(0);
      e.this.Nba.grN();
      AppMethodBeat.o(126281);
    }
    
    public int cn(float paramFloat)
    {
      AppMethodBeat.i(126282);
      paramFloat /= this.Nbp;
      int j = e.this.getFSVideoUIComponent().gqC().getVideoDurationSec();
      int i = getCurrentPosition();
      int k = (int)(paramFloat * j) + i;
      if (k < 0) {
        i = 0;
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.websearch.ui.b.GN(j * 1000L);
        e.Z(e.this).setText(com.tencent.mm.plugin.websearch.ui.b.GN(i * 1000L) + "/" + str);
        AppMethodBeat.o(126282);
        return i;
        i = k;
        if (k > j) {
          i = j;
        }
      }
    }
    
    public final int getCurrentPosition()
    {
      AppMethodBeat.i(126285);
      int i = e.this.getFSVideoUIComponent().gqC().getCurrPosSec();
      AppMethodBeat.o(126285);
      return i;
    }
    
    public final boolean gqQ()
    {
      AppMethodBeat.i(126284);
      if (e.ab(e.this))
      {
        AppMethodBeat.o(126284);
        return false;
      }
      AppMethodBeat.o(126284);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e
 * JD-Core Version:    0.7.0.1
 */