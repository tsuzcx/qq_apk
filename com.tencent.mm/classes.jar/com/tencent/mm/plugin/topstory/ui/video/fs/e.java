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
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.protocal.protobuf.eip;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.eiy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;
import java.util.LinkedList;

public class e
  extends com.tencent.mm.plugin.topstory.ui.video.f
{
  protected f Gon;
  protected k Goo;
  protected View.OnClickListener Gop;
  protected View.OnClickListener Goq;
  protected View.OnClickListener Gor;
  protected View.OnClickListener Gos;
  protected View.OnClickListener Got;
  protected View.OnClickListener Gou;
  private View Gov;
  private TextView Gow;
  private TextView Gox;
  private ImageView Goy;
  private ImageView Goz;
  private boolean isLoading;
  private i.b wcv;
  
  public e(Context paramContext, com.tencent.mm.plugin.topstory.ui.video.b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    AppMethodBeat.i(126286);
    this.wcv = new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int j = 0;
        AppMethodBeat.i(126257);
        Log.e("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        paramAnonymousString2 = e.B(e.this).fyO().acd(e.A(e.this).fyH());
        if ((paramAnonymousString2 != null) && (paramAnonymousString2.Niw != null))
        {
          Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousString2.Niw.size()), paramAnonymousString2.videoUrl, Integer.valueOf(paramAnonymousString2.NiF) });
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
              Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", new Object[] { Integer.valueOf(i), localeiy.url, Integer.valueOf(localeiy.NiF) });
              com.tencent.mm.plugin.websearch.api.a.b.pl(com.tencent.mm.plugin.websearch.api.a.b.IFT);
              e.this.postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(126256);
                  e.this.ay(true, true);
                  AppMethodBeat.o(126256);
                }
              }, 100L);
              AppMethodBeat.o(126257);
              return;
            }
            i += 1;
          }
        }
        e.E(e.this).fyO().a(e.C(e.this).fyD(), e.D(e.this).fyH());
        e.this.lg(e.this.getContext().getString(2131767065, new Object[] { paramAnonymousInt1 + ":" + paramAnonymousInt2 }), e.this.getContext().getString(2131767108));
        e.this.getFSVideoUIComponent().fyF().onError(paramAnonymousString1);
        i.abQ(paramAnonymousInt1);
        paramAnonymousString1 = e.this.getFSVideoUIComponent().fyB().GnT;
        paramAnonymousInt2 = j;
        if (paramAnonymousString1 != null)
        {
          paramAnonymousInt2 = j;
          if (paramAnonymousString1.Gjm > 0L) {
            paramAnonymousInt2 = (int)(System.currentTimeMillis() - paramAnonymousString1.Gjm) / 1000;
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
      
      public final void dH(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126258);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onPrepared");
        e.this.Goo.bKZ();
        if (!e.F(e.this)) {
          e.this.fyX();
        }
        AppMethodBeat.o(126258);
      }
      
      public final void dI(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126259);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoEnded");
        e.this.getFSVideoUIComponent().fyF().aTH(paramAnonymousString1);
        e.this.getFSVideoUIComponent().fyB().GnS = 1;
        int i = e.this.getFSVideoUIComponent().fyS();
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "clicfg_topstory_v_video_play  %s", new Object[] { Integer.valueOf(i) });
        if ((i == 1) && (e.this.getFSVideoUIComponent().fyL()) && ((e.G(e.this) instanceof j))) {}
        try
        {
          Thread.sleep(100L);
          ((j)e.H(e.this)).wu(true);
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
              ((com.tencent.mm.plugin.topstory.ui.video.h)e.K(e.this)).wu(true);
              e.a(e.this, false);
              AppMethodBeat.o(126259);
              return;
              boolean bool = e.this.getFSVideoUIComponent().abU(e.I(e.this).fyz() + 1);
            }
            paramAnonymousString1 = paramAnonymousString1;
          }
          catch (InterruptedException paramAnonymousString1)
          {
            break label166;
          }
        }
      }
      
      public final void dJ(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dK(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dL(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126261);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaiting");
        e.a(e.this, true);
        AppMethodBeat.o(126261);
      }
      
      public final void dM(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(126262);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaitingEnd");
        e.a(e.this, false);
        e.this.fyX();
        paramAnonymousString1 = e.this.getFSVideoUIComponent().fyB().GnT;
        if ((paramAnonymousString1 != null) && (paramAnonymousString1.Gjx == 0L))
        {
          paramAnonymousString1.Gjx = (System.currentTimeMillis() - paramAnonymousString1.Gjm);
          Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "FirstLoadTime %d %d", new Object[] { Long.valueOf(paramAnonymousString1.Gju), Long.valueOf(paramAnonymousString1.Gjx) });
        }
        AppMethodBeat.o(126262);
      }
      
      public final void fo(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    if (this.GlS.fyL()) {
      this.puw.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    AppMethodBeat.o(126286);
  }
  
  private boolean bJf()
  {
    AppMethodBeat.i(126298);
    if (this.Gmd.getVisibility() == 0)
    {
      AppMethodBeat.o(126298);
      return true;
    }
    AppMethodBeat.o(126298);
    return false;
  }
  
  protected void bIY()
  {
    AppMethodBeat.i(126296);
    this.Goo = new k(getContext(), this, new a());
    AppMethodBeat.o(126296);
  }
  
  public i.e c(eiw parameiw)
  {
    return i.e.Kcb;
  }
  
  public final void crC()
  {
    AppMethodBeat.i(126295);
    if (this.Gon != null) {
      this.Gon.show();
    }
    AppMethodBeat.o(126295);
  }
  
  public final void fyV()
  {
    AppMethodBeat.i(126290);
    Log.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollPlayContainerStatus");
    this.Gmd.setVisibility(8);
    this.Gmc.setVisibility(8);
    this.puw.setVisibility(0);
    this.GlU.setVisibility(8);
    this.GlT.setVisibility(8);
    this.Gmh.setVisibility(8);
    AppMethodBeat.o(126290);
  }
  
  public final void fyW()
  {
    AppMethodBeat.i(126291);
    Log.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollStopContainerStatus");
    this.Gmd.setVisibility(0);
    if ((getFSVideoUIComponent().fyA().fzw()) && (!ai.isFreeSimCard())) {
      this.Gmc.setVisibility(0);
    }
    for (;;)
    {
      this.puw.setVisibility(0);
      this.GlU.setVisibility(8);
      this.GlT.setVisibility(8);
      this.Gmh.setVisibility(8);
      this.Gmf.setVisibility(0);
      this.Gme.setVisibility(8);
      this.GlX.setVisibility(0);
      this.GlY.setVisibility(8);
      this.Gmb.setVisibility(8);
      AppMethodBeat.o(126291);
      return;
      this.Gmc.setVisibility(8);
    }
  }
  
  public final void fyX()
  {
    AppMethodBeat.i(126288);
    super.fyX();
    AppMethodBeat.o(126288);
  }
  
  protected void fzI()
  {
    AppMethodBeat.i(126289);
    this.Gon.m(this.GjH);
    AppMethodBeat.o(126289);
  }
  
  public boolean fzJ()
  {
    return false;
  }
  
  public final void fza()
  {
    AppMethodBeat.i(126294);
    if (this.Gon != null) {
      this.Gon.setVisibility(8);
    }
    AppMethodBeat.o(126294);
  }
  
  public final void fzb()
  {
    AppMethodBeat.i(126292);
    f localf = this.Gon;
    if (localf.GoU != null) {
      localf.GoU.stopTimer();
    }
    AppMethodBeat.o(126292);
  }
  
  public final void fzf()
  {
    AppMethodBeat.i(126299);
    super.fzf();
    if (fzJ())
    {
      AppMethodBeat.o(126299);
      return;
    }
    if ((this.GjH.NiI != null) && (this.GjH.NiI.NhN != null))
    {
      this.Gow.setText(this.GjH.NiI.NhN.title);
      this.Gox.setText(this.GjH.NiI.NhN.desc);
      q.bcV().a(this.GjH.NiI.NhN.uNR, this.Goy, Glu);
      this.Gov.setVisibility(0);
      i.a(this.GlS.fyD(), this.GjH, 1);
      AppMethodBeat.o(126299);
      return;
    }
    this.Gov.setVisibility(8);
    AppMethodBeat.o(126299);
  }
  
  public final void fzg()
  {
    AppMethodBeat.i(126300);
    super.fzg();
    if (fzJ())
    {
      AppMethodBeat.o(126300);
      return;
    }
    this.Gov.setVisibility(8);
    AppMethodBeat.o(126300);
  }
  
  public final boolean fzh()
  {
    AppMethodBeat.i(161624);
    if (this.Gov != null)
    {
      if (this.Gov.getVisibility() == 0)
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
    return this.Gon;
  }
  
  public a getFSItemUIComponent()
  {
    return (a)this.Gmk;
  }
  
  public com.tencent.mm.plugin.topstory.ui.video.b getFSVideoUIComponent()
  {
    return this.GlS;
  }
  
  public int getLayoutId()
  {
    return 2131496735;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public eiw getVideoInfo()
  {
    return this.GjH;
  }
  
  public i.b getVideoViewCallback()
  {
    return this.wcv;
  }
  
  public void init()
  {
    AppMethodBeat.i(126287);
    super.init();
    if (!fzJ())
    {
      this.Gov = findViewById(2131306029);
      this.Gow = ((TextView)findViewById(2131306030));
      this.Gox = ((TextView)findViewById(2131306027));
      this.Goy = ((ImageView)findViewById(2131306028));
      this.Goz = ((ImageView)findViewById(2131306026));
    }
    this.Gop = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126251);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        e.this.getFSVideoUIComponent().KC();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126251);
      }
    };
    this.Goq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126270);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        e.this.getFSVideoUIComponent().ay(paramAnonymousView, e.a(e.this).fyz());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126270);
      }
    };
    this.Gor = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126271);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        e.this.getFSItemUIComponent().acf(e.b(e.this).fyz());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126271);
      }
    };
    this.Gos = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126272);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        e.this.getFSVideoUIComponent().a(e.c(e.this), paramAnonymousView);
        e.this.fzI();
        if (!e.this.fzJ()) {
          e.d(e.this).setVisibility(8);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126272);
      }
    };
    this.Got = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126273);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = e.this.getFSVideoUIComponent();
        e.e(e.this).fyz();
        ((com.tencent.mm.plugin.topstory.ui.video.b)localObject).a((dyi)paramAnonymousView.getTag());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126273);
      }
    };
    this.Gou = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126274);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        n.a(e.f(e.this), e.this.getFSVideoUIComponent().eeF());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126274);
      }
    };
    this.GlZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126275);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (e.g(e.this) == com.tencent.mm.plugin.topstory.ui.video.f.a.Gmo)
        {
          e.this.getFSVideoUIComponent().fyA().Gnu = true;
          e.h(e.this).abW(2);
        }
        if (e.this.getFSVideoUIComponent().fyA().isConnected())
        {
          e.a(e.this, com.tencent.mm.plugin.topstory.ui.video.f.a.Gmn);
          if (e.this.getFSVideoUIComponent().fyF().GnZ)
          {
            e.this.getFSVideoUIComponent().fyF().eYd();
            com.tencent.mm.plugin.websearch.api.a.a.pl(19);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126275);
          return;
          e.this.ay(true, false);
          break;
          com.tencent.mm.plugin.websearch.api.a.a.pl(20);
        }
      }
    });
    this.GlX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126276);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        e.this.getFSVideoUIComponent().fyB().GnS = 2;
        boolean bool;
        if ((e.this.getFSItemUIComponent() != null) && (e.this.getFSItemUIComponent().fyz() == e.this.getFSVideoUIComponent().fyH()))
        {
          paramAnonymousView = e.this;
          if (!e.this.getFSVideoUIComponent().fyA().Gnu)
          {
            bool = true;
            paramAnonymousView.ay(bool, false);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126276);
          return;
          bool = false;
          break;
          e.this.getFSVideoUIComponent().abU(e.i(e.this).fyz());
          e.this.getFSVideoUIComponent().fyB().k(e.j(e.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().fyD(), e.k(e.this), e.l(e.this).fyz(), 2, "");
        }
      }
    });
    this.GlY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126277);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        e.this.fzd();
        e.this.Gon.bJB();
        e.this.getFSVideoUIComponent().fyB().GnS = 2;
        e.this.getFSVideoUIComponent().fyF().a(e.this.getFSVideoUIComponent(), e.m(e.this), e.n(e.this), e.o(e.this).fyz());
        e.this.fyX();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126277);
      }
    });
    this.Gmd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126252);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((e.this.getFSItemUIComponent() != null) && (e.this.getFSItemUIComponent().fyz() != e.this.getFSVideoUIComponent().fyH()))
        {
          e.this.getFSVideoUIComponent().fyB().GnS = 2;
          e.this.getFSVideoUIComponent().abU(e.p(e.this).fyz());
          e.this.getFSVideoUIComponent().fyB().k(e.q(e.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().fyD(), e.r(e.this), e.s(e.this).fyz(), 2, "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126252);
      }
    });
    if (!fzJ())
    {
      this.Gov.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126254);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f.a(MMApplicationContext.getContext());
          paramAnonymousView.bow(e.this.getContext().getString(2131766828, new Object[] { e.t(e.this).NiI.NhN.NhK })).Dq(true);
          paramAnonymousView.apa(2131755305);
          paramAnonymousView.c(new f.c()
          {
            public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(126253);
              if (paramAnonymous2Boolean)
              {
                i.a(e.u(e.this).fyD(), e.v(e.this), 2);
                paramAnonymous2String = new com.tencent.mm.plugin.appbrand.api.g();
                paramAnonymous2String.appId = e.w(e.this).NiI.NhN.appId;
                paramAnonymous2String.kHw = e.x(e.this).NiI.NhN.ecK;
                paramAnonymous2String.scene = 1152;
                ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(e.this.getContext(), paramAnonymous2String);
                e.d(e.this).setVisibility(8);
              }
              AppMethodBeat.o(126253);
            }
          }).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126254);
        }
      });
      this.Goz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126255);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          e.d(e.this).setVisibility(8);
          i.a(e.y(e.this).fyD(), e.z(e.this), 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126255);
        }
      });
    }
    bIY();
    if (getFSVideoUIComponent().fyL()) {
      this.Gon = new l(getContext());
    }
    for (;;)
    {
      this.Gon.setOnlyFS(fzJ());
      this.Gon.setVisibility(8);
      this.Gon.setShareBtnClickListener(this.Gor);
      this.Gon.setWowBtnClickListener(this.Gos);
      this.Gon.setTagBtnClickListener(this.Got);
      this.Gon.setSourceItemClickListener(this.Gou);
      if (com.tencent.mm.plugin.topstory.a.h.fxR()) {
        this.Gon.setTitleClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(126263);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            e.this.getFSVideoUIComponent().fyF().Gob = true;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126263);
          }
        });
      }
      this.Gon.setOnUpdateProgressLenListener(new f.a()
      {
        public final void b(eiw paramAnonymouseiw, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(126264);
          if (paramAnonymousInt2 > 0) {}
          for (int i = e.L(e.this).getWidth() * paramAnonymousInt1 / paramAnonymousInt2;; i = 0)
          {
            Object localObject = e.this.getFSVideoUIComponent().fyB().GnT;
            if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.b)localObject).Gjp < e.this.getFSVideoUIComponent().fyF().getCurrPosMs())) {
              ((com.tencent.mm.plugin.topstory.a.b.b)localObject).Gjp = e.this.getFSVideoUIComponent().fyF().getCurrPosMs();
            }
            if (e.M(e.this).fyF().dFG())
            {
              int j = e.N(e.this).fyF().getCurrPosMs() / 1000;
              if (((PluginTopStoryUI)com.tencent.mm.kernel.g.ah(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(paramAnonymouseiw.psI)) {
                ((PluginTopStoryUI)com.tencent.mm.kernel.g.ah(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(paramAnonymouseiw.psI, Integer.valueOf(j));
              }
            }
            localObject = (FrameLayout.LayoutParams)e.O(e.this).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject).width = i;
            e.P(e.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
            e.Q(e.this).requestLayout();
            if (!e.this.Gon.bJw()) {
              e.this.Gon.setVisibility(8);
            }
            if ((paramAnonymouseiw.Nix & 0x100) <= 0) {
              e.R(e.this).a(paramAnonymouseiw, paramAnonymousInt1, paramAnonymousInt2);
            }
            e.S(e.this).a(paramAnonymouseiw, e.this, paramAnonymousInt1);
            AppMethodBeat.o(126264);
            return;
          }
        }
        
        public final void fzK()
        {
          AppMethodBeat.i(126265);
          e.T(e.this).setVisibility(8);
          AppMethodBeat.o(126265);
        }
        
        public final void fzL()
        {
          AppMethodBeat.i(126266);
          if ((e.this.getFSVideoUIComponent().fyF().GnZ) && ((e.this.getFSVideoUIComponent().fyF().dFG()) || (e.this.getFSVideoUIComponent().fyF().Goa)))
          {
            e.U(e.this).setVisibility(0);
            AppMethodBeat.o(126266);
            return;
          }
          e.V(e.this).setVisibility(8);
          AppMethodBeat.o(126266);
        }
      });
      this.Gon.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
      {
        public final void aJq()
        {
          AppMethodBeat.i(126267);
          Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekPre");
          e.this.Gon.crH();
          AppMethodBeat.o(126267);
        }
        
        public final void rk(int paramAnonymousInt)
        {
          AppMethodBeat.i(126268);
          Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          e.this.seekTo(paramAnonymousInt);
          e.this.Gon.bJB();
          com.tencent.mm.plugin.websearch.api.a.a.pl(22);
          AppMethodBeat.o(126268);
        }
      });
      this.Gon.setOnPlayButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126269);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (e.this.getFSVideoUIComponent().fyF().GnZ)
          {
            if ((!(e.this.Gon instanceof l)) && (e.this.Gon.getVideoTotalTime() - e.this.Gon.getmPosition() < 2))
            {
              Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "cannot change play status in last 2 seconds");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(126269);
              return;
            }
            e.this.getFSVideoUIComponent().fyB().k(e.W(e.this));
            if (e.this.getFSVideoUIComponent().fyF().dFG())
            {
              e.this.getFSVideoUIComponent().fyF().cXa();
              e.this.Gon.crH();
              e.this.fyX();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoContainer$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126269);
            return;
            e.this.getFSVideoUIComponent().fyF().eYd();
            e.this.Gon.bJB();
            break;
            Log.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "no video play now");
          }
        }
      });
      AppMethodBeat.o(126287);
      return;
      this.Gon = new f(getContext());
      if (ao.aQ(getContext()))
      {
        f localf = this.Gon;
        int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
        int j = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
        localf.GoI.setPadding(i, 0, j, 0);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126297);
    if (this.Goo != null) {
      this.Goo.A(paramMotionEvent);
    }
    AppMethodBeat.o(126297);
    return true;
  }
  
  public void updateView()
  {
    AppMethodBeat.i(126293);
    super.updateView();
    if (this.Gon != null)
    {
      this.Gon.setVideoTotalTime(this.GjH.Eso);
      this.Gon.n(this.GjH);
    }
    if ((getFSItemUIComponent() != null) && (getFSItemUIComponent().fyz() != getFSVideoUIComponent().fyH()))
    {
      if (!getFSVideoUIComponent().fyA().isConnected()) {
        break label130;
      }
      fyY();
    }
    for (;;)
    {
      if (this.titleTv != null)
      {
        this.titleTv.setText(this.GjH.title);
        ao.a(this.titleTv.getPaint(), 0.8F);
      }
      AppMethodBeat.o(126293);
      return;
      label130:
      lg(getNoNetTip(), getContext().getString(2131767108));
    }
  }
  
  public class a
    implements c
  {
    private float GoD;
    
    a()
    {
      AppMethodBeat.i(126278);
      this.GoD = com.tencent.mm.cb.a.jo(e.this.getContext());
      AppMethodBeat.o(126278);
    }
    
    public void abX(int paramInt)
    {
      AppMethodBeat.i(126283);
      e.this.Gon.fzN();
      e.aa(e.this).setVisibility(8);
      e.this.seekTo(paramInt);
      AppMethodBeat.o(126283);
    }
    
    public final void bJj()
    {
      AppMethodBeat.i(126279);
      Log.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSingleTap");
      if (e.X(e.this))
      {
        if (e.this.Gon.bJw())
        {
          e.this.Gon.setVisibility(8);
          AppMethodBeat.o(126279);
          return;
        }
        e.this.Gon.show();
        if (e.this.getFSItemUIComponent() != null)
        {
          e.this.getFSItemUIComponent().fyy();
          e.this.getFSItemUIComponent().fyx();
        }
      }
      AppMethodBeat.o(126279);
    }
    
    public final void bJk()
    {
      AppMethodBeat.i(126280);
      Log.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onDoubleTap");
      AppMethodBeat.o(126280);
    }
    
    public void bJl()
    {
      AppMethodBeat.i(126281);
      e.Y(e.this).setVisibility(0);
      e.this.Gon.fzM();
      AppMethodBeat.o(126281);
    }
    
    public int ce(float paramFloat)
    {
      AppMethodBeat.i(126282);
      paramFloat /= this.GoD;
      int j = e.this.getFSVideoUIComponent().fyF().getVideoDurationSec();
      int i = getCurrentPosition();
      int k = (int)(paramFloat * j) + i;
      if (k < 0) {
        i = 0;
      }
      for (;;)
      {
        String str = com.tencent.mm.plugin.websearch.ui.a.AF(j * 1000L);
        e.Z(e.this).setText(com.tencent.mm.plugin.websearch.ui.a.AF(i * 1000L) + "/" + str);
        AppMethodBeat.o(126282);
        return i;
        i = k;
        if (k > j) {
          i = j;
        }
      }
    }
    
    public final boolean fyT()
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
    
    public final int getCurrentPosition()
    {
      AppMethodBeat.i(126285);
      int i = e.this.getFSVideoUIComponent().fyF().getCurrPosSec();
      AppMethodBeat.o(126285);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e
 * JD-Core Version:    0.7.0.1
 */