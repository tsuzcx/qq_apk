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
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.topstory.a.e;
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
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.fnz;
import com.tencent.mm.protocal.protobuf.foa;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.protocal.protobuf.foj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;

public final class f
  extends com.tencent.mm.plugin.topstory.ui.video.f
{
  private i.b EAt;
  private View.OnClickListener PQP;
  private k TNK;
  private View TNQ;
  private TextView TNR;
  private TextView TNS;
  private ImageView TNT;
  private ImageView TNU;
  private g TPc;
  private View TPd;
  private TextView TPe;
  private boolean isLoading;
  
  public f(Context paramContext, com.tencent.mm.plugin.topstory.ui.video.b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    AppMethodBeat.i(126459);
    this.EAt = new i.b()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int j = 0;
        AppMethodBeat.i(126445);
        Log.e("MicroMsg.TopStory.TopStoryListVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 != 0)
        {
          paramAnonymousString2 = f.F(f.this).hNK().apc(f.E(f.this).hND());
          if ((paramAnonymousString2 != null) && (paramAnonymousString2.abOD != null))
          {
            Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousString2.abOD.size()), paramAnonymousString2.videoUrl, Integer.valueOf(paramAnonymousString2.abOL) });
            int i = 0;
            while (i < paramAnonymousString2.abOD.size())
            {
              foj localfoj = (foj)paramAnonymousString2.abOD.get(i);
              if (paramAnonymousString2.videoUrl.equals(localfoj.url))
              {
                if (i + 1 >= paramAnonymousString2.abOD.size()) {
                  break;
                }
                i += 1;
                localfoj = (foj)paramAnonymousString2.abOD.get(i);
                if ((localfoj == null) || (Util.isNullOrNil(localfoj.url))) {
                  break;
                }
                paramAnonymousString2.abOL = localfoj.abOL;
                paramAnonymousString2.videoUrl = localfoj.url;
                Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", new Object[] { Integer.valueOf(i), localfoj.url, Integer.valueOf(localfoj.abOL) });
                com.tencent.mm.plugin.websearch.api.a.b.rG(com.tencent.mm.plugin.websearch.api.a.b.Wqz);
                f.this.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(126444);
                    f.this.bi(true, true);
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
        f.I(f.this).hNK().a(f.G(f.this).hNz(), f.H(f.this).hND());
        f.this.nn(f.this.getContext().getString(c.g.video_error_warnning, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), f.this.getContext().getString(c.g.video_retry_play));
        f.this.getListVideoUIComponent().hNB().onError(paramAnonymousString1);
        com.tencent.mm.plugin.topstory.a.h.aoM(paramAnonymousInt1);
        paramAnonymousString1 = f.this.getListVideoUIComponent().hNx().TNp;
        paramAnonymousInt2 = j;
        if (paramAnonymousString1 != null)
        {
          paramAnonymousInt2 = j;
          if (paramAnonymousString1.TIB > 0L) {
            paramAnonymousInt2 = (int)(System.currentTimeMillis() - paramAnonymousString1.TIB) / 1000;
          }
        }
        com.tencent.mm.plugin.topstory.a.h.a(f.J(f.this), paramAnonymousInt1, paramAnonymousString3, paramAnonymousInt2);
        AppMethodBeat.o(126445);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126448);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(126448);
      }
      
      public final void el(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126446);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onPrepared");
        f.K(f.this).hOw();
        if (!f.L(f.this)) {
          f.this.hNU();
        }
        AppMethodBeat.o(126446);
      }
      
      public final void em(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126447);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoEnded, pos:%s, listpos:%s", new Object[] { Integer.valueOf(f.M(f.this).hNv()), Integer.valueOf(f.N(f.this).hNv()) });
        f.this.getListVideoUIComponent().hNB().beC(paramAnonymousString1);
        f.this.getListVideoUIComponent().hNx().TNo = 1;
        if ((!f.this.getListVideoUIComponent().aoT(f.O(f.this).hNv() + 1)) && ((f.P(f.this) instanceof com.tencent.mm.plugin.topstory.ui.video.h))) {}
        try
        {
          Thread.sleep(100L);
          label134:
          ((com.tencent.mm.plugin.topstory.ui.video.h)f.Q(f.this)).FD(true);
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
      
      public final void en(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void eo(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void ep(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126449);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaiting");
        f.a(f.this, true);
        AppMethodBeat.o(126449);
      }
      
      public final void eq(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126450);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaitingEnd");
        f.a(f.this, false);
        f.g(f.this).setVisibility(8);
        if (f.R(f.this).abOM != null)
        {
          Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "longVideoInfo onVideoWaitingEnd");
          f.S(f.this).setVisibility(0);
        }
        f.this.hNU();
        paramAnonymousString1 = f.this.getListVideoUIComponent().hNx().TNp;
        if ((paramAnonymousString1 != null) && (paramAnonymousString1.TIM == 0L))
        {
          paramAnonymousString1.TIM = (System.currentTimeMillis() - paramAnonymousString1.TIB);
          Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramAnonymousString1.TIJ), Long.valueOf(paramAnonymousString1.TIM) });
        }
        AppMethodBeat.o(126450);
      }
      
      public final void gE(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void onSeekComplete(ITPPlayer paramAnonymousITPPlayer) {}
    };
    AppMethodBeat.o(126459);
  }
  
  private boolean cvd()
  {
    AppMethodBeat.i(126469);
    if (this.TLy.getVisibility() == 0)
    {
      AppMethodBeat.o(126469);
      return true;
    }
    AppMethodBeat.o(126469);
    return false;
  }
  
  public final boolean bi(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(126464);
    paramBoolean1 = super.bi(paramBoolean1, paramBoolean2);
    getListVideoUIComponent().hNB().setMute(getListVideoUIComponent().aGe());
    AppMethodBeat.o(126464);
    return paramBoolean1;
  }
  
  public final i.e c(foh paramfoh)
  {
    return i.e.XYM;
  }
  
  public final g getControlBar()
  {
    return this.TPc;
  }
  
  public final int getLayoutId()
  {
    return c.e.top_story_list_video_container;
  }
  
  public final a getListItemUIComponent()
  {
    return (a)this.TLF;
  }
  
  public final b getListVideoUIComponent()
  {
    return (b)this.TLn;
  }
  
  public final String getSessionId()
  {
    return this.sessionId;
  }
  
  public final foh getVideoInfo()
  {
    return this.TIW;
  }
  
  public final i.b getVideoViewCallback()
  {
    return this.EAt;
  }
  
  public final void hNS()
  {
    AppMethodBeat.i(126462);
    Log.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollPlayContainerStatus");
    this.TLy.setVisibility(8);
    this.coverIv.setVisibility(0);
    this.TLp.setVisibility(8);
    this.TLo.setVisibility(8);
    this.TLC.setVisibility(8);
    AppMethodBeat.o(126462);
  }
  
  public final void hNT()
  {
    AppMethodBeat.i(126463);
    Log.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollStopContainerStatus");
    this.TLy.setVisibility(0);
    this.coverIv.setVisibility(0);
    this.TLp.setVisibility(8);
    this.TLo.setVisibility(8);
    this.TLC.setVisibility(8);
    this.TLA.setVisibility(0);
    this.TLz.setVisibility(8);
    this.TLs.setVisibility(0);
    this.TLt.setVisibility(8);
    this.TLw.setVisibility(8);
    AppMethodBeat.o(126463);
  }
  
  public final void hNU()
  {
    AppMethodBeat.i(126461);
    super.hNU();
    AppMethodBeat.o(126461);
  }
  
  public final void hNX()
  {
    AppMethodBeat.i(126467);
    if (this.TPc != null) {
      this.TPc.setVisibility(8);
    }
    AppMethodBeat.o(126467);
  }
  
  public final void hNY()
  {
    AppMethodBeat.i(126465);
    g localg = this.TPc;
    if (localg.TOp != null) {
      localg.TOp.stopTimer();
    }
    AppMethodBeat.o(126465);
  }
  
  public final void hOd()
  {
    AppMethodBeat.i(126470);
    super.hOd();
    if ((this.TIW.abOO != null) && (this.TIW.abOO.abNW != null))
    {
      this.TNR.setText(this.TIW.abOO.abNW.title);
      this.TNS.setText(this.TIW.abOO.abNW.desc);
      com.tencent.mm.modelimage.r.bKe().a(this.TIW.abOO.abNW.avatar, this.TNT, TKP);
      this.TNQ.setVisibility(0);
      com.tencent.mm.plugin.topstory.a.h.a(this.TLn.hNz(), this.TIW, 1);
      if (getControlBar().cvt())
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.TNQ.getLayoutParams();
        localLayoutParams.bottomMargin = com.tencent.mm.cd.a.bs(getContext(), c.b.Edge_6A);
        this.TNQ.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(126470);
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.TNQ.getLayoutParams();
      localLayoutParams.bottomMargin = com.tencent.mm.cd.a.bs(getContext(), c.b.Edge_A);
      this.TNQ.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(126470);
      return;
    }
    this.TNQ.setVisibility(8);
    AppMethodBeat.o(126470);
  }
  
  public final void hOe()
  {
    AppMethodBeat.i(126471);
    super.hOe();
    this.TNQ.setVisibility(8);
    AppMethodBeat.o(126471);
  }
  
  public final boolean hOf()
  {
    AppMethodBeat.i(161627);
    if (this.TNQ.getVisibility() == 0)
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
    this.TPd = findViewById(c.d.long_video_layout);
    this.TPe = ((TextView)findViewById(c.d.long_video_desc));
    this.TNQ = findViewById(c.d.point_video_layout);
    this.TNR = ((TextView)findViewById(c.d.point_video_title));
    this.TNS = ((TextView)findViewById(c.d.point_video_desc));
    this.TNT = ((ImageView)findViewById(c.d.point_video_iv));
    this.TNU = ((ImageView)findViewById(c.d.point_video_close_iv));
    this.PQP = new f.1(this);
    this.TLu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126436);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (f.a(f.this) == com.tencent.mm.plugin.topstory.ui.video.f.a.TLJ)
        {
          f.this.getListVideoUIComponent().hNw().TMQ = true;
          f.b(f.this).aoV(2);
        }
        if (f.this.getListVideoUIComponent().hNw().isConnected())
        {
          f.a(f.this, com.tencent.mm.plugin.topstory.ui.video.f.a.TLI);
          if (f.this.getListVideoUIComponent().hNB().TNv)
          {
            f.this.getListVideoUIComponent().hNB().bcl();
            f.this.hNU();
            com.tencent.mm.plugin.websearch.api.a.a.rG(19);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126436);
          return;
          f.this.bi(true, false);
          break;
          com.tencent.mm.plugin.websearch.api.a.a.rG(20);
        }
      }
    });
    this.TLs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126437);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        f.this.getListVideoUIComponent().hNx().TNo = 2;
        boolean bool;
        if ((f.this.getListItemUIComponent() != null) && (f.this.getListItemUIComponent().hNv() == f.this.getListVideoUIComponent().hND()))
        {
          paramAnonymousView = f.this;
          if (!f.this.getListVideoUIComponent().hNw().TMQ)
          {
            bool = true;
            paramAnonymousView.bi(bool, false);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126437);
          return;
          bool = false;
          break;
          f.this.getListVideoUIComponent().aoT(f.c(f.this).hNv());
          f.this.getListVideoUIComponent().hNx().k(f.d(f.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().hNz(), f.e(f.this), f.f(f.this).hNv(), 2, "");
        }
      }
    });
    this.TLt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126438);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        f.this.hOa();
        f.g(f.this).cvy();
        f.this.getListVideoUIComponent().hNx().TNo = 2;
        f.this.getListVideoUIComponent().hNB().a(f.this.getListVideoUIComponent(), f.h(f.this), f.i(f.this), f.j(f.this).hNv());
        f.this.hNU();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126438);
      }
    });
    this.TLy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126439);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((f.this.getListItemUIComponent() != null) && (f.this.getListItemUIComponent().hNv() != f.this.getListVideoUIComponent().hND()))
        {
          f.this.getListVideoUIComponent().hNx().TNo = 2;
          f.this.getListVideoUIComponent().aoT(f.k(f.this).hNv());
          f.this.getListVideoUIComponent().hNx().k(f.l(f.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().hNz(), f.m(f.this), f.n(f.this).hNv(), 2, "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126439);
      }
    });
    this.TPd.setOnClickListener(new f.9(this));
    if (this.TNQ != null) {
      this.TNQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126442);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new com.tencent.mm.ui.widget.a.g.a(MMApplicationContext.getContext());
          paramAnonymousView.bDE(f.this.getContext().getString(c.g.top_story_open_appbrand, new Object[] { f.t(f.this).abOO.abNW.abNT })).NF(true);
          paramAnonymousView.aEX(c.g.app_accept);
          paramAnonymousView.c(new g.c()
          {
            public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(126441);
              if ((paramAnonymous2Boolean) && (f.u(f.this) != null) && (f.v(f.this).abOO != null) && (f.w(f.this).abOO.abNW != null))
              {
                com.tencent.mm.plugin.topstory.a.h.a(f.x(f.this).hNz(), f.y(f.this), 2);
                paramAnonymous2String = new com.tencent.mm.plugin.appbrand.api.g();
                paramAnonymous2String.appId = f.z(f.this).abOO.abNW.appId;
                paramAnonymous2String.qAF = f.A(f.this).abOO.abNW.icO;
                paramAnonymous2String.scene = 1152;
                ((t)com.tencent.mm.kernel.h.ax(t.class)).a(f.this.getContext(), paramAnonymous2String);
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
    if (this.TNU != null) {
      this.TNU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126443);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          f.B(f.this).setVisibility(8);
          com.tencent.mm.plugin.topstory.a.h.a(f.C(f.this).hNz(), f.D(f.this), 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126443);
        }
      });
    }
    this.TNK = new k(getContext(), this, new a());
    this.TPc = new g(getContext());
    this.TPc.setVisibility(8);
    this.TPc.setFullScreenBtnClickListener(this.PQP);
    this.TPc.setOnUpdateProgressLenListener(new g.a()
    {
      public final void hOL()
      {
        AppMethodBeat.i(126431);
        f.af(f.this).setVisibility(8);
        RelativeLayout.LayoutParams localLayoutParams;
        if (f.ag(f.this).abOM != null)
        {
          f.S(f.this).setVisibility(0);
          localLayoutParams = (RelativeLayout.LayoutParams)f.S(f.this).getLayoutParams();
          localLayoutParams.bottomMargin = com.tencent.mm.cd.a.bs(f.this.getContext(), c.b.Edge_6A);
          f.S(f.this).setLayoutParams(localLayoutParams);
        }
        if (f.B(f.this).getVisibility() == 0)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)f.B(f.this).getLayoutParams();
          localLayoutParams.bottomMargin = com.tencent.mm.cd.a.bs(f.this.getContext(), c.b.Edge_6A);
          f.B(f.this).setLayoutParams(localLayoutParams);
        }
        AppMethodBeat.o(126431);
      }
      
      public final void hOM()
      {
        AppMethodBeat.i(126432);
        if (f.ah(f.this).abOM != null)
        {
          Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "longVideoInfo onControlBarGone");
          f.S(f.this).setVisibility(8);
        }
        if ((f.this.getListVideoUIComponent().hNB().TNv) && ((f.this.getListVideoUIComponent().hNB().fjy()) || (f.this.getListVideoUIComponent().hNB().TNw))) {
          f.ai(f.this).setVisibility(0);
        }
        for (;;)
        {
          if (f.B(f.this).getVisibility() == 0)
          {
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)f.B(f.this).getLayoutParams();
            localLayoutParams.bottomMargin = com.tencent.mm.cd.a.bs(f.this.getContext(), c.b.Edge_A);
            f.B(f.this).setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(126432);
          return;
          f.aj(f.this).setVisibility(8);
        }
      }
      
      public final void mq(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126430);
        if (paramAnonymousInt2 > 0) {}
        for (int i = f.T(f.this).getWidth() * paramAnonymousInt1 / paramAnonymousInt2;; i = 0)
        {
          Object localObject = f.this.getListVideoUIComponent().hNx().TNp;
          if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).TIE < f.this.getListVideoUIComponent().hNB().getCurrPosMs())) {
            ((com.tencent.mm.plugin.topstory.a.b.b)localObject).TIE = f.this.getListVideoUIComponent().hNB().getCurrPosMs();
          }
          if (f.this.getListVideoUIComponent().hNB().fjy())
          {
            int j = f.this.getListVideoUIComponent().hNB().getCurrPosMs() / 1000;
            if (((PluginTopStoryUI)com.tencent.mm.kernel.h.az(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(f.U(f.this).Ido)) {
              ((PluginTopStoryUI)com.tencent.mm.kernel.h.az(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(f.V(f.this).Ido, Integer.valueOf(j));
            }
          }
          if (!f.g(f.this).cvt())
          {
            localObject = (FrameLayout.LayoutParams)f.W(f.this).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject).width = i;
            f.X(f.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
            f.Y(f.this).requestLayout();
            f.Z(f.this).setVisibility(0);
          }
          if ((f.aa(f.this).abOE & 0x100) <= 0) {
            f.ac(f.this).a(f.ab(f.this), paramAnonymousInt1, paramAnonymousInt2);
          }
          f.ae(f.this).a(f.ad(f.this), f.this, paramAnonymousInt1);
          AppMethodBeat.o(126430);
          return;
        }
      }
    });
    this.TPc.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void blc()
      {
        AppMethodBeat.i(126433);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekPre");
        f.g(f.this).hON();
        AppMethodBeat.o(126433);
      }
      
      public final void tS(int paramAnonymousInt)
      {
        AppMethodBeat.i(126434);
        Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        f.this.seekTo(paramAnonymousInt);
        f.g(f.this).cvy();
        com.tencent.mm.plugin.websearch.api.a.a.rG(22);
        AppMethodBeat.o(126434);
      }
      
      public final void tT(int paramAnonymousInt) {}
    });
    this.TPc.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126435);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (f.this.getListVideoUIComponent().hNB().TNv)
        {
          if (f.g(f.this).getVideoTotalTime() - f.g(f.this).getmPosition() < 2)
          {
            Log.i("MicroMsg.TopStory.TopStoryListVideoContainer", "cannot change play status in last 2 seconds");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126435);
            return;
          }
          f.this.getListVideoUIComponent().hNx().k(f.ak(f.this));
          if (f.this.getListVideoUIComponent().hNB().fjy())
          {
            f.this.getListVideoUIComponent().hNB().bck();
            f.g(f.this).hON();
            f.this.hNU();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126435);
          return;
          f.this.getListVideoUIComponent().hNB().bcl();
          f.g(f.this).cvy();
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
    if (this.TNK != null) {
      this.TNK.ai(paramMotionEvent);
    }
    AppMethodBeat.o(126468);
    return true;
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(126466);
    super.updateView();
    if (this.TPc != null) {
      this.TPc.setVideoTotalTime(this.TIW.Rfk);
    }
    TextView localTextView;
    long l;
    String str;
    if ((getListItemUIComponent() != null) && (getListItemUIComponent().hNv() != getListVideoUIComponent().hND()))
    {
      if (getListVideoUIComponent().hNw().isConnected()) {
        hNV();
      }
    }
    else
    {
      if (this.TIW.abOM == null) {
        break label295;
      }
      this.TPd.setVisibility(0);
      localTextView = this.TPe;
      l = this.TIW.abOM.Rfk;
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
      nn(getNoNetTip(), getContext().getString(c.g.video_retry_play));
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
    this.TPd.setVisibility(8);
    AppMethodBeat.o(126466);
  }
  
  final class a
    implements c
  {
    private float TNY;
    
    a()
    {
      AppMethodBeat.i(126451);
      this.TNY = com.tencent.mm.cd.a.mt(f.this.getContext());
      AppMethodBeat.o(126451);
    }
    
    public final void aoW(int paramInt)
    {
      AppMethodBeat.i(126456);
      f.g(f.this).hOP();
      f.ao(f.this).setVisibility(8);
      f.this.seekTo(paramInt);
      AppMethodBeat.o(126456);
    }
    
    public final void cvh()
    {
      AppMethodBeat.i(126452);
      Log.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onSingleTap");
      if (f.al(f.this))
      {
        if (f.g(f.this).cvt())
        {
          f.g(f.this).setVisibility(8);
          AppMethodBeat.o(126452);
          return;
        }
        f.g(f.this).show();
        if (f.this.getListItemUIComponent() != null)
        {
          f.this.getListItemUIComponent().hNu();
          f.this.getListItemUIComponent().hNt();
        }
      }
      AppMethodBeat.o(126452);
    }
    
    public final void cvi()
    {
      AppMethodBeat.i(126453);
      Log.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onDoubleTap");
      AppMethodBeat.o(126453);
    }
    
    public final void cvj()
    {
      AppMethodBeat.i(126454);
      f.am(f.this).setVisibility(0);
      f.g(f.this).hOO();
      AppMethodBeat.o(126454);
    }
    
    public final boolean cvk()
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
    
    public final int dz(float paramFloat)
    {
      AppMethodBeat.i(126455);
      paramFloat /= this.TNY;
      int j = f.this.getListVideoUIComponent().hNB().getVideoDurationSec();
      int i = getCurrentPosition();
      int k = (int)(paramFloat * j) + i;
      if (k < 0) {
        i = 0;
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.websearch.ui.b.iY(j * 1000L);
        f.an(f.this).setText(com.tencent.mm.plugin.websearch.ui.b.iY(i * 1000L) + "/" + str);
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
      int i = f.this.getListVideoUIComponent().hNB().getCurrPosSec();
      AppMethodBeat.o(126458);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f
 * JD-Core Version:    0.7.0.1
 */