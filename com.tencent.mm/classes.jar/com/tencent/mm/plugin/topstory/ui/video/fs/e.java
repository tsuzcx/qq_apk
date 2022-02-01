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
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.fcl;
import com.tencent.mm.protocal.protobuf.fnz;
import com.tencent.mm.protocal.protobuf.foa;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.protocal.protobuf.foj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.util.HashMap;
import java.util.LinkedList;

public class e
  extends com.tencent.mm.plugin.topstory.ui.video.f
{
  private i.b EAt;
  protected View.OnClickListener PQP;
  protected f TNJ;
  protected k TNK;
  protected View.OnClickListener TNL;
  protected View.OnClickListener TNM;
  protected View.OnClickListener TNN;
  protected View.OnClickListener TNO;
  protected View.OnClickListener TNP;
  private View TNQ;
  private TextView TNR;
  private TextView TNS;
  private ImageView TNT;
  private ImageView TNU;
  private boolean isLoading;
  
  public e(Context paramContext, com.tencent.mm.plugin.topstory.ui.video.b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    AppMethodBeat.i(126286);
    this.EAt = new i.b()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int j = 0;
        AppMethodBeat.i(126257);
        Log.e("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        paramAnonymousString2 = e.B(e.this).hNK().apc(e.A(e.this).hND());
        if ((paramAnonymousString2 != null) && (paramAnonymousString2.abOD != null))
        {
          Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousString2.abOD.size()), paramAnonymousString2.videoUrl, Integer.valueOf(paramAnonymousString2.abOL) });
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
              Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", new Object[] { Integer.valueOf(i), localfoj.url, Integer.valueOf(localfoj.abOL) });
              com.tencent.mm.plugin.websearch.api.a.b.rG(com.tencent.mm.plugin.websearch.api.a.b.Wqz);
              e.this.postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(126256);
                  e.this.bi(true, true);
                  AppMethodBeat.o(126256);
                }
              }, 100L);
              AppMethodBeat.o(126257);
              return;
            }
            i += 1;
          }
        }
        e.E(e.this).hNK().a(e.C(e.this).hNz(), e.D(e.this).hND());
        e.this.nn(e.this.getContext().getString(c.g.video_error_warnning, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), e.this.getContext().getString(c.g.video_retry_play));
        e.this.getFSVideoUIComponent().hNB().onError(paramAnonymousString1);
        com.tencent.mm.plugin.topstory.a.h.aoM(paramAnonymousInt1);
        paramAnonymousString1 = e.this.getFSVideoUIComponent().hNx().TNp;
        paramAnonymousInt2 = j;
        if (paramAnonymousString1 != null)
        {
          paramAnonymousInt2 = j;
          if (paramAnonymousString1.TIB > 0L) {
            paramAnonymousInt2 = (int)(System.currentTimeMillis() - paramAnonymousString1.TIB) / 1000;
          }
        }
        com.tencent.mm.plugin.topstory.a.h.a(paramAnonymousString2, paramAnonymousInt1, paramAnonymousString3, paramAnonymousInt2);
        AppMethodBeat.o(126257);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126260);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(126260);
      }
      
      public final void el(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126258);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onPrepared");
        e.this.TNK.hOw();
        if (!e.F(e.this)) {
          e.this.hNU();
        }
        AppMethodBeat.o(126258);
      }
      
      public final void em(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126259);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoEnded");
        e.this.getFSVideoUIComponent().hNB().beC(paramAnonymousString1);
        e.this.getFSVideoUIComponent().hNx().TNo = 1;
        int i = e.this.getFSVideoUIComponent().hNO();
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "clicfg_topstory_v_video_play  %s", new Object[] { Integer.valueOf(i) });
        if ((i == 1) && (e.this.getFSVideoUIComponent().hNH()) && ((e.G(e.this) instanceof j))) {}
        try
        {
          Thread.sleep(100L);
          ((j)e.H(e.this)).FD(true);
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
              ((com.tencent.mm.plugin.topstory.ui.video.h)e.K(e.this)).FD(true);
              e.a(e.this, false);
              AppMethodBeat.o(126259);
              return;
              boolean bool = e.this.getFSVideoUIComponent().aoT(e.I(e.this).hNv() + 1);
            }
            paramAnonymousString1 = paramAnonymousString1;
          }
          catch (InterruptedException paramAnonymousString1)
          {
            break label166;
          }
        }
      }
      
      public final void en(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void eo(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void ep(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126261);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaiting");
        e.a(e.this, true);
        AppMethodBeat.o(126261);
      }
      
      public final void eq(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126262);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaitingEnd");
        e.a(e.this, false);
        e.this.hNU();
        paramAnonymousString1 = e.this.getFSVideoUIComponent().hNx().TNp;
        if ((paramAnonymousString1 != null) && (paramAnonymousString1.TIM == 0L))
        {
          paramAnonymousString1.TIM = (System.currentTimeMillis() - paramAnonymousString1.TIB);
          Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramAnonymousString1.TIJ), Long.valueOf(paramAnonymousString1.TIM) });
        }
        AppMethodBeat.o(126262);
      }
      
      public final void gE(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void onSeekComplete(ITPPlayer paramAnonymousITPPlayer) {}
    };
    if (this.TLn.hNH()) {
      this.coverIv.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    AppMethodBeat.o(126286);
  }
  
  private boolean cvd()
  {
    AppMethodBeat.i(126298);
    if (this.TLy.getVisibility() == 0)
    {
      AppMethodBeat.o(126298);
      return true;
    }
    AppMethodBeat.o(126298);
    return false;
  }
  
  public i.e c(foh paramfoh)
  {
    return i.e.XYM;
  }
  
  protected void cuW()
  {
    AppMethodBeat.i(126296);
    this.TNK = new k(getContext(), this, new a());
    AppMethodBeat.o(126296);
  }
  
  public f getControlBar()
  {
    return this.TNJ;
  }
  
  public a getFSItemUIComponent()
  {
    return (a)this.TLF;
  }
  
  public com.tencent.mm.plugin.topstory.ui.video.b getFSVideoUIComponent()
  {
    return this.TLn;
  }
  
  public int getLayoutId()
  {
    return c.e.top_story_fs_video_container;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public foh getVideoInfo()
  {
    return this.TIW;
  }
  
  public i.b getVideoViewCallback()
  {
    return this.EAt;
  }
  
  public final void hNS()
  {
    AppMethodBeat.i(126290);
    Log.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollPlayContainerStatus");
    this.TLy.setVisibility(8);
    this.TLx.setVisibility(8);
    this.coverIv.setVisibility(0);
    this.TLp.setVisibility(8);
    this.TLo.setVisibility(8);
    this.TLC.setVisibility(8);
    AppMethodBeat.o(126290);
  }
  
  public final void hNT()
  {
    AppMethodBeat.i(126291);
    Log.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollStopContainerStatus");
    this.TLy.setVisibility(0);
    if ((getFSVideoUIComponent().hNw().hOx()) && (!aj.isFreeSimCard())) {
      this.TLx.setVisibility(0);
    }
    for (;;)
    {
      this.coverIv.setVisibility(0);
      this.TLp.setVisibility(8);
      this.TLo.setVisibility(8);
      this.TLC.setVisibility(8);
      this.TLA.setVisibility(0);
      this.TLz.setVisibility(8);
      this.TLs.setVisibility(0);
      this.TLt.setVisibility(8);
      this.TLw.setVisibility(8);
      AppMethodBeat.o(126291);
      return;
      this.TLx.setVisibility(8);
    }
  }
  
  public final void hNU()
  {
    AppMethodBeat.i(126288);
    super.hNU();
    AppMethodBeat.o(126288);
  }
  
  public final void hNX()
  {
    AppMethodBeat.i(126294);
    if (this.TNJ != null) {
      this.TNJ.setVisibility(8);
    }
    AppMethodBeat.o(126294);
  }
  
  public final void hNY()
  {
    AppMethodBeat.i(126292);
    f localf = this.TNJ;
    if (localf.TOp != null) {
      localf.TOp.stopTimer();
    }
    AppMethodBeat.o(126292);
  }
  
  protected void hOJ()
  {
    AppMethodBeat.i(126289);
    this.TNJ.m(this.TIW);
    AppMethodBeat.o(126289);
  }
  
  public boolean hOK()
  {
    return false;
  }
  
  public final void hOb()
  {
    AppMethodBeat.i(126295);
    if (this.TNJ != null) {
      this.TNJ.show();
    }
    AppMethodBeat.o(126295);
  }
  
  public final void hOd()
  {
    AppMethodBeat.i(126299);
    super.hOd();
    if (hOK())
    {
      AppMethodBeat.o(126299);
      return;
    }
    if ((this.TIW.abOO != null) && (this.TIW.abOO.abNW != null))
    {
      this.TNR.setText(this.TIW.abOO.abNW.title);
      this.TNS.setText(this.TIW.abOO.abNW.desc);
      com.tencent.mm.modelimage.r.bKe().a(this.TIW.abOO.abNW.avatar, this.TNT, TKP);
      this.TNQ.setVisibility(0);
      com.tencent.mm.plugin.topstory.a.h.a(this.TLn.hNz(), this.TIW, 1);
      AppMethodBeat.o(126299);
      return;
    }
    this.TNQ.setVisibility(8);
    AppMethodBeat.o(126299);
  }
  
  public final void hOe()
  {
    AppMethodBeat.i(126300);
    super.hOe();
    if (hOK())
    {
      AppMethodBeat.o(126300);
      return;
    }
    this.TNQ.setVisibility(8);
    AppMethodBeat.o(126300);
  }
  
  public final boolean hOf()
  {
    AppMethodBeat.i(161624);
    if (this.TNQ != null)
    {
      if (this.TNQ.getVisibility() == 0)
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
    if (!hOK())
    {
      this.TNQ = findViewById(c.d.point_video_layout);
      this.TNR = ((TextView)findViewById(c.d.point_video_title));
      this.TNS = ((TextView)findViewById(c.d.point_video_desc));
      this.TNT = ((ImageView)findViewById(c.d.point_video_iv));
      this.TNU = ((ImageView)findViewById(c.d.point_video_close_iv));
    }
    this.PQP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126251);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        e.this.getFSVideoUIComponent().anI();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126251);
      }
    };
    this.TNL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126270);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        e.this.getFSVideoUIComponent().aZ(paramAnonymousView, e.a(e.this).hNv());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126270);
      }
    };
    this.TNM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126271);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        e.this.getFSItemUIComponent().ape(e.b(e.this).hNv());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126271);
      }
    };
    this.TNN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126272);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        e.this.getFSVideoUIComponent().a(e.c(e.this), paramAnonymousView);
        e.this.hOJ();
        if (!e.this.hOK()) {
          e.d(e.this).setVisibility(8);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126272);
      }
    };
    this.TNO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126273);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        localObject = e.this.getFSVideoUIComponent();
        e.e(e.this).hNv();
        ((com.tencent.mm.plugin.topstory.ui.video.b)localObject).a((fcl)paramAnonymousView.getTag());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126273);
      }
    };
    this.TNP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126274);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        n.a(e.f(e.this), e.this.getFSVideoUIComponent().fWt());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126274);
      }
    };
    this.TLu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126275);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (e.g(e.this) == com.tencent.mm.plugin.topstory.ui.video.f.a.TLJ)
        {
          e.this.getFSVideoUIComponent().hNw().TMQ = true;
          e.h(e.this).aoV(2);
        }
        if (e.this.getFSVideoUIComponent().hNw().isConnected())
        {
          e.a(e.this, com.tencent.mm.plugin.topstory.ui.video.f.a.TLI);
          if (e.this.getFSVideoUIComponent().hNB().TNv)
          {
            e.this.getFSVideoUIComponent().hNB().bcl();
            com.tencent.mm.plugin.websearch.api.a.a.rG(19);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126275);
          return;
          e.this.bi(true, false);
          break;
          com.tencent.mm.plugin.websearch.api.a.a.rG(20);
        }
      }
    });
    this.TLs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126276);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        e.this.getFSVideoUIComponent().hNx().TNo = 2;
        boolean bool;
        if ((e.this.getFSItemUIComponent() != null) && (e.this.getFSItemUIComponent().hNv() == e.this.getFSVideoUIComponent().hND()))
        {
          paramAnonymousView = e.this;
          if (!e.this.getFSVideoUIComponent().hNw().TMQ)
          {
            bool = true;
            paramAnonymousView.bi(bool, false);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126276);
          return;
          bool = false;
          break;
          e.this.getFSVideoUIComponent().aoT(e.i(e.this).hNv());
          e.this.getFSVideoUIComponent().hNx().k(e.j(e.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().hNz(), e.k(e.this), e.l(e.this).hNv(), 2, "");
        }
      }
    });
    this.TLt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126277);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        e.this.hOa();
        e.this.TNJ.cvy();
        e.this.getFSVideoUIComponent().hNx().TNo = 2;
        e.this.getFSVideoUIComponent().hNB().a(e.this.getFSVideoUIComponent(), e.m(e.this), e.n(e.this), e.o(e.this).hNv());
        e.this.hNU();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126277);
      }
    });
    this.TLy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126252);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((e.this.getFSItemUIComponent() != null) && (e.this.getFSItemUIComponent().hNv() != e.this.getFSVideoUIComponent().hND()))
        {
          e.this.getFSVideoUIComponent().hNx().TNo = 2;
          e.this.getFSVideoUIComponent().aoT(e.p(e.this).hNv());
          e.this.getFSVideoUIComponent().hNx().k(e.q(e.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().hNz(), e.r(e.this), e.s(e.this).hNv(), 2, "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126252);
      }
    });
    if (!hOK())
    {
      this.TNQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126254);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new g.a(MMApplicationContext.getContext());
          paramAnonymousView.bDE(e.this.getContext().getString(c.g.top_story_open_appbrand, new Object[] { e.t(e.this).abOO.abNW.abNT })).NF(true);
          paramAnonymousView.aEX(c.g.app_accept);
          paramAnonymousView.c(new g.c()
          {
            public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(126253);
              if (paramAnonymous2Boolean)
              {
                com.tencent.mm.plugin.topstory.a.h.a(e.u(e.this).hNz(), e.v(e.this), 2);
                paramAnonymous2String = new com.tencent.mm.plugin.appbrand.api.g();
                paramAnonymous2String.appId = e.w(e.this).abOO.abNW.appId;
                paramAnonymous2String.qAF = e.x(e.this).abOO.abNW.icO;
                paramAnonymous2String.scene = 1152;
                ((t)com.tencent.mm.kernel.h.ax(t.class)).a(e.this.getContext(), paramAnonymous2String);
                e.d(e.this).setVisibility(8);
              }
              AppMethodBeat.o(126253);
            }
          }).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126254);
        }
      });
      this.TNU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126255);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          e.d(e.this).setVisibility(8);
          com.tencent.mm.plugin.topstory.a.h.a(e.y(e.this).hNz(), e.z(e.this), 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126255);
        }
      });
    }
    cuW();
    if (getFSVideoUIComponent().hNH()) {
      this.TNJ = new l(getContext());
    }
    for (;;)
    {
      this.TNJ.setOnlyFS(hOK());
      this.TNJ.setVisibility(8);
      this.TNJ.setShareBtnClickListener(this.TNM);
      this.TNJ.setWowBtnClickListener(this.TNN);
      this.TNJ.setTagBtnClickListener(this.TNO);
      this.TNJ.setSourceItemClickListener(this.TNP);
      if (com.tencent.mm.plugin.topstory.a.g.hMI()) {
        this.TNJ.setTitleClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(126263);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            e.this.getFSVideoUIComponent().hNB().TNx = true;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126263);
          }
        });
      }
      this.TNJ.setOnUpdateProgressLenListener(new f.a()
      {
        public final void b(foh paramAnonymousfoh, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(126264);
          if (paramAnonymousInt2 > 0) {}
          for (int i = e.L(e.this).getWidth() * paramAnonymousInt1 / paramAnonymousInt2;; i = 0)
          {
            Object localObject = e.this.getFSVideoUIComponent().hNx().TNp;
            if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).TIE < e.this.getFSVideoUIComponent().hNB().getCurrPosMs())) {
              ((com.tencent.mm.plugin.topstory.a.b.b)localObject).TIE = e.this.getFSVideoUIComponent().hNB().getCurrPosMs();
            }
            if (e.M(e.this).hNB().fjy())
            {
              int j = e.N(e.this).hNB().getCurrPosMs() / 1000;
              if (((PluginTopStoryUI)com.tencent.mm.kernel.h.az(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(paramAnonymousfoh.Ido)) {
                ((PluginTopStoryUI)com.tencent.mm.kernel.h.az(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(paramAnonymousfoh.Ido, Integer.valueOf(j));
              }
            }
            localObject = (FrameLayout.LayoutParams)e.O(e.this).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject).width = i;
            e.P(e.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
            e.Q(e.this).requestLayout();
            if (!e.this.TNJ.cvt()) {
              e.this.TNJ.setVisibility(8);
            }
            if ((paramAnonymousfoh.abOE & 0x100) <= 0) {
              e.R(e.this).a(paramAnonymousfoh, paramAnonymousInt1, paramAnonymousInt2);
            }
            e.S(e.this).a(paramAnonymousfoh, e.this, paramAnonymousInt1);
            AppMethodBeat.o(126264);
            return;
          }
        }
        
        public final void hOL()
        {
          AppMethodBeat.i(126265);
          e.T(e.this).setVisibility(8);
          AppMethodBeat.o(126265);
        }
        
        public final void hOM()
        {
          AppMethodBeat.i(126266);
          if ((e.this.getFSVideoUIComponent().hNB().TNv) && ((e.this.getFSVideoUIComponent().hNB().fjy()) || (e.this.getFSVideoUIComponent().hNB().TNw)))
          {
            e.U(e.this).setVisibility(0);
            AppMethodBeat.o(126266);
            return;
          }
          e.V(e.this).setVisibility(8);
          AppMethodBeat.o(126266);
        }
      });
      this.TNJ.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
      {
        public final void blc()
        {
          AppMethodBeat.i(126267);
          Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekPre");
          e.this.TNJ.hON();
          AppMethodBeat.o(126267);
        }
        
        public final void tS(int paramAnonymousInt)
        {
          AppMethodBeat.i(126268);
          Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          e.this.seekTo(paramAnonymousInt);
          e.this.TNJ.cvy();
          com.tencent.mm.plugin.websearch.api.a.a.rG(22);
          AppMethodBeat.o(126268);
        }
        
        public final void tT(int paramAnonymousInt) {}
      });
      this.TNJ.setOnPlayButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126269);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (e.this.getFSVideoUIComponent().hNB().TNv)
          {
            if ((!(e.this.TNJ instanceof l)) && (e.this.TNJ.getVideoTotalTime() - e.this.TNJ.getmPosition() < 2))
            {
              Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "cannot change play status in last 2 seconds");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(126269);
              return;
            }
            e.this.getFSVideoUIComponent().hNx().k(e.W(e.this));
            if (e.this.getFSVideoUIComponent().hNB().fjy())
            {
              e.this.getFSVideoUIComponent().hNB().bck();
              e.this.TNJ.hON();
              e.this.hNU();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126269);
            return;
            e.this.getFSVideoUIComponent().hNB().bcl();
            e.this.TNJ.cvy();
            break;
            Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "no video play now");
          }
        }
      });
      AppMethodBeat.o(126287);
      return;
      this.TNJ = new f(getContext());
      if (aw.bx(getContext()))
      {
        f localf = this.TNJ;
        int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
        int j = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
        localf.TOd.setPadding(i, 0, j, 0);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126297);
    if (this.TNK != null) {
      this.TNK.ai(paramMotionEvent);
    }
    AppMethodBeat.o(126297);
    return true;
  }
  
  public void updateView()
  {
    AppMethodBeat.i(126293);
    super.updateView();
    if (this.TNJ != null)
    {
      this.TNJ.setVideoTotalTime(this.TIW.Rfk);
      this.TNJ.n(this.TIW);
    }
    if ((getFSItemUIComponent() != null) && (getFSItemUIComponent().hNv() != getFSVideoUIComponent().hND()))
    {
      if (!getFSVideoUIComponent().hNw().isConnected()) {
        break label130;
      }
      hNV();
    }
    for (;;)
    {
      if (this.titleTv != null)
      {
        this.titleTv.setText(this.TIW.title);
        aw.a(this.titleTv.getPaint(), 0.8F);
      }
      AppMethodBeat.o(126293);
      return;
      label130:
      nn(getNoNetTip(), getContext().getString(c.g.video_retry_play));
    }
  }
  
  public class a
    implements c
  {
    private float TNY;
    
    a()
    {
      AppMethodBeat.i(126278);
      this.TNY = com.tencent.mm.cd.a.mt(e.this.getContext());
      AppMethodBeat.o(126278);
    }
    
    public void aoW(int paramInt)
    {
      AppMethodBeat.i(126283);
      e.this.TNJ.hOP();
      e.aa(e.this).setVisibility(8);
      e.this.seekTo(paramInt);
      AppMethodBeat.o(126283);
    }
    
    public final void cvh()
    {
      AppMethodBeat.i(126279);
      Log.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSingleTap");
      if (e.X(e.this))
      {
        if (e.this.TNJ.cvt())
        {
          e.this.TNJ.setVisibility(8);
          AppMethodBeat.o(126279);
          return;
        }
        e.this.TNJ.show();
        if (e.this.getFSItemUIComponent() != null)
        {
          e.this.getFSItemUIComponent().hNu();
          e.this.getFSItemUIComponent().hNt();
        }
      }
      AppMethodBeat.o(126279);
    }
    
    public final void cvi()
    {
      AppMethodBeat.i(126280);
      Log.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onDoubleTap");
      AppMethodBeat.o(126280);
    }
    
    public void cvj()
    {
      AppMethodBeat.i(126281);
      e.Y(e.this).setVisibility(0);
      e.this.TNJ.hOO();
      AppMethodBeat.o(126281);
    }
    
    public final boolean cvk()
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
    
    public int dz(float paramFloat)
    {
      AppMethodBeat.i(126282);
      paramFloat /= this.TNY;
      int j = e.this.getFSVideoUIComponent().hNB().getVideoDurationSec();
      int i = getCurrentPosition();
      int k = (int)(paramFloat * j) + i;
      if (k < 0) {
        i = 0;
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.websearch.ui.b.iY(j * 1000L);
        e.Z(e.this).setText(com.tencent.mm.plugin.websearch.ui.b.iY(i * 1000L) + "/" + str);
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
      int i = e.this.getFSVideoUIComponent().hNB().getCurrPosSec();
      AppMethodBeat.o(126285);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e
 * JD-Core Version:    0.7.0.1
 */