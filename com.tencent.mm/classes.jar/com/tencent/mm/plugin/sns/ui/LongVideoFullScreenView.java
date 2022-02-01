package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;

public class LongVideoFullScreenView
  extends RelativeLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, i.b, i.d
{
  FrameLayout AjA;
  View AjB;
  View AjC;
  AdLandingVideoWrapper AjD;
  String AjE;
  int AjF;
  int AjG;
  String AjH;
  int AjI;
  private volatile boolean AjJ;
  private volatile int AjK;
  volatile boolean AjL;
  private long AjM;
  private com.tencent.mm.plugin.sns.ui.d.a AjN;
  View contentView;
  volatile boolean gHg;
  private GestureDetector iNw;
  volatile boolean isFirst;
  boolean isWaiting;
  int ivg;
  boolean lVw;
  int length;
  int lxZ;
  int lya;
  Context mContext;
  com.tencent.mm.plugin.sight.decode.ui.b rNx;
  private int wyN;
  private long wyh;
  volatile boolean zPy;
  String zQQ;
  VideoPlayerSeekBar zWG;
  ImageView zWH;
  Runnable zWL;
  private volatile boolean zWO;
  boolean zWP;
  private volatile boolean zWT;
  private int zWY;
  private int zWZ;
  ImageView zXO;
  View zXP;
  Runnable zXR;
  private int zXS;
  private int zXa;
  View.OnClickListener zXc;
  int zYx;
  
  public LongVideoFullScreenView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(219670);
    this.contentView = null;
    this.AjJ = false;
    this.AjK = 0;
    this.gHg = true;
    this.zWT = false;
    this.zWO = true;
    this.zPy = false;
    this.isFirst = true;
    this.AjL = false;
    this.wyh = 0L;
    this.zWZ = 0;
    this.zXS = 0;
    this.zXa = 0;
    this.zWY = 0;
    this.wyN = 0;
    this.AjM = 0L;
    this.zXc = edC();
    this.rNx = edD();
    this.zWL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219668);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(219668);
      }
    };
    this.zXR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219669);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(219669);
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(219669);
        }
      }
    };
    this.mContext = paramContext;
    this.iNw = new GestureDetector(this);
    AppMethodBeat.o(219670);
  }
  
  public LongVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(219671);
    this.contentView = null;
    this.AjJ = false;
    this.AjK = 0;
    this.gHg = true;
    this.zWT = false;
    this.zWO = true;
    this.zPy = false;
    this.isFirst = true;
    this.AjL = false;
    this.wyh = 0L;
    this.zWZ = 0;
    this.zXS = 0;
    this.zXa = 0;
    this.zWY = 0;
    this.wyN = 0;
    this.AjM = 0L;
    this.zXc = edC();
    this.rNx = edD();
    this.zWL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219668);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(219668);
      }
    };
    this.zXR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219669);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(219669);
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(219669);
        }
      }
    };
    this.mContext = paramContext;
    this.iNw = new GestureDetector(this);
    AppMethodBeat.o(219671);
  }
  
  public LongVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(219672);
    this.contentView = null;
    this.AjJ = false;
    this.AjK = 0;
    this.gHg = true;
    this.zWT = false;
    this.zWO = true;
    this.zPy = false;
    this.isFirst = true;
    this.AjL = false;
    this.wyh = 0L;
    this.zWZ = 0;
    this.zXS = 0;
    this.zXa = 0;
    this.zWY = 0;
    this.wyN = 0;
    this.AjM = 0L;
    this.zXc = edC();
    this.rNx = edD();
    this.zWL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219668);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(219668);
      }
    };
    this.zXR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219669);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(219669);
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(219669);
        }
      }
    };
    this.mContext = paramContext;
    this.iNw = new GestureDetector(this);
    AppMethodBeat.o(219672);
  }
  
  private static void ao(Runnable paramRunnable)
  {
    AppMethodBeat.i(219690);
    try
    {
      ar.ay(paramRunnable);
      ar.o(paramRunnable, 4000L);
      AppMethodBeat.o(219690);
      return;
    }
    catch (Throwable paramRunnable)
    {
      ae.e("LongVideoFullScreenView", paramRunnable.toString());
      AppMethodBeat.o(219690);
    }
  }
  
  private View.OnClickListener edC()
  {
    AppMethodBeat.i(219686);
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(219665);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        for (;;)
        {
          try
          {
            ae.i("LongVideoFullScreenView", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(LongVideoFullScreenView.h(LongVideoFullScreenView.this).isPlaying()) });
            LongVideoFullScreenView.b(LongVideoFullScreenView.this, true);
            if (!LongVideoFullScreenView.h(LongVideoFullScreenView.this).isPlaying()) {
              continue;
            }
            LongVideoFullScreenView.n(LongVideoFullScreenView.this);
            if (LongVideoFullScreenView.q(LongVideoFullScreenView.this)) {
              LongVideoFullScreenView.r(LongVideoFullScreenView.this);
            }
          }
          catch (Throwable paramAnonymousView)
          {
            ae.e("LongVideoFullScreenView", paramAnonymousView.toString());
            continue;
            LongVideoFullScreenView.this.dZP();
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219665);
          return;
          if (!LongVideoFullScreenView.o(LongVideoFullScreenView.this)) {
            continue;
          }
          LongVideoFullScreenView.this.dZN();
          LongVideoFullScreenView.p(LongVideoFullScreenView.this);
        }
      }
    };
    AppMethodBeat.o(219686);
    return local3;
  }
  
  private com.tencent.mm.plugin.sight.decode.ui.b edD()
  {
    AppMethodBeat.i(219687);
    com.tencent.mm.plugin.sight.decode.ui.b local4 = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqS()
      {
        AppMethodBeat.i(219666);
        try
        {
          LongVideoFullScreenView.b(LongVideoFullScreenView.this, true);
          AppMethodBeat.o(219666);
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(219666);
        }
      }
      
      public final void nP(int paramAnonymousInt)
      {
        AppMethodBeat.i(219667);
        try
        {
          ae.i("LongVideoFullScreenView", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          LongVideoFullScreenView.a(LongVideoFullScreenView.this, paramAnonymousInt);
          if (LongVideoFullScreenView.o(LongVideoFullScreenView.this)) {
            LongVideoFullScreenView.this.dZN();
          }
          for (;;)
          {
            LongVideoFullScreenView.h(LongVideoFullScreenView.this).c(paramAnonymousInt, true);
            ar.ay(LongVideoFullScreenView.m(LongVideoFullScreenView.this));
            LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(219667);
            return;
            LongVideoFullScreenView.this.dZP();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(219667);
        }
      }
    };
    AppMethodBeat.o(219687);
    return local4;
  }
  
  private void rL(boolean paramBoolean)
  {
    AppMethodBeat.i(219681);
    try
    {
      this.zWG.setIsPlay(paramBoolean);
      this.zWG.getPlayBtn().getLayoutParams().width = this.length;
      this.zWG.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        ae.i("LongVideoFullScreenView", "startPlay");
        this.zWG.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131691470));
        AppMethodBeat.o(219681);
        return;
      }
      ae.i("LongVideoFullScreenView", "pausePlay");
      this.zWG.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131691469));
      AppMethodBeat.o(219681);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(219681);
    }
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(219680);
    ae.e("LongVideoFullScreenView", "online play error, %s", new Object[] { paramString3 });
    this.zWT = true;
    AppMethodBeat.o(219680);
  }
  
  final void cbC()
  {
    AppMethodBeat.i(219682);
    try
    {
      ae.i("LongVideoFullScreenView", "starting play, downFailed=" + this.zWT);
      boolean bool = this.zWT;
      if (bool) {
        try
        {
          ae.e("LongVideoFullScreenView", "last download fail ,try again");
          if ((this.zWG != null) && (this.zWG.getParent() != null)) {
            ((ViewGroup)this.zWG.getParent()).removeView(this.zWG);
          }
          this.AjD.setFullScreen(true);
          this.AjD.c(false, this.AjH, 0);
          if (this.mContext.getResources().getConfiguration().orientation == 2)
          {
            ae.i("LongVideoFullScreenView", "ORIENTATION_LANDSCAPE");
            eam();
          }
          for (;;)
          {
            this.AjD.c(0.0D, true);
            this.AjD.eaZ();
            AppMethodBeat.o(219682);
            return;
            if (this.mContext.getResources().getConfiguration().orientation == 1)
            {
              ae.i("LongVideoFullScreenView", "ORIENTATION_PORTRAIT");
              ean();
            }
          }
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219663);
              try
              {
                if (!LongVideoFullScreenView.a(LongVideoFullScreenView.this)) {
                  break label313;
                }
                LongVideoFullScreenView.b(LongVideoFullScreenView.this);
                if (LongVideoFullScreenView.c(LongVideoFullScreenView.this))
                {
                  if ((LongVideoFullScreenView.d(LongVideoFullScreenView.this) > 0) && (LongVideoFullScreenView.d(LongVideoFullScreenView.this) <= LongVideoFullScreenView.e(LongVideoFullScreenView.this)))
                  {
                    LongVideoFullScreenView.g(LongVideoFullScreenView.this).seek(LongVideoFullScreenView.f(LongVideoFullScreenView.this));
                    LongVideoFullScreenView.h(LongVideoFullScreenView.this).c(LongVideoFullScreenView.f(LongVideoFullScreenView.this), true);
                  }
                  for (;;)
                  {
                    LongVideoFullScreenView.a(LongVideoFullScreenView.this, System.currentTimeMillis());
                    LongVideoFullScreenView.a(LongVideoFullScreenView.this, true);
                    AppMethodBeat.o(219663);
                    return;
                    LongVideoFullScreenView.g(LongVideoFullScreenView.this).seek(0);
                    LongVideoFullScreenView.h(LongVideoFullScreenView.this).c(0.0D, true);
                  }
                }
                if (LongVideoFullScreenView.i(LongVideoFullScreenView.this) >= LongVideoFullScreenView.e(LongVideoFullScreenView.this)) {
                  break label192;
                }
              }
              catch (Throwable localThrowable)
              {
                ae.e("LongVideoFullScreenView", localThrowable.toString());
                AppMethodBeat.o(219663);
                return;
              }
              if (LongVideoFullScreenView.i(LongVideoFullScreenView.this) < 0)
              {
                label192:
                LongVideoFullScreenView.g(LongVideoFullScreenView.this).seek(0);
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).c(0.0D, LongVideoFullScreenView.j(LongVideoFullScreenView.this));
              }
              for (;;)
              {
                LongVideoFullScreenView.a(LongVideoFullScreenView.this, System.currentTimeMillis());
                LongVideoFullScreenView.a(LongVideoFullScreenView.this, LongVideoFullScreenView.j(LongVideoFullScreenView.this));
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).eaZ();
                AppMethodBeat.o(219663);
                return;
                LongVideoFullScreenView.g(LongVideoFullScreenView.this).seek(LongVideoFullScreenView.i(LongVideoFullScreenView.this) / 1000);
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).c(LongVideoFullScreenView.i(LongVideoFullScreenView.this), LongVideoFullScreenView.j(LongVideoFullScreenView.this));
              }
              label313:
              if (!LongVideoFullScreenView.h(LongVideoFullScreenView.this).isPlaying())
              {
                if (LongVideoFullScreenView.h(LongVideoFullScreenView.this).getCurrPosSec() != LongVideoFullScreenView.h(LongVideoFullScreenView.this).getVideoDurationSec()) {
                  break label405;
                }
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).c(0.0D, true);
              }
              for (;;)
              {
                LongVideoFullScreenView.a(LongVideoFullScreenView.this, true);
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).eaZ();
                LongVideoFullScreenView.k(LongVideoFullScreenView.this);
                LongVideoFullScreenView.a(LongVideoFullScreenView.this, System.currentTimeMillis());
                AppMethodBeat.o(219663);
                return;
                label405:
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).c(LongVideoFullScreenView.h(LongVideoFullScreenView.this).getCurrPosSec(), true);
              }
            }
          });
        }
        catch (Throwable localThrowable1)
        {
          ae.e("LongVideoFullScreenView", localThrowable1.toString());
        }
      }
      AppMethodBeat.o(219682);
      return;
    }
    catch (Throwable localThrowable2)
    {
      ae.e("LongVideoFullScreenView", localThrowable2.toString());
      AppMethodBeat.o(219682);
    }
  }
  
  final void cyX()
  {
    AppMethodBeat.i(219683);
    try
    {
      ae.d("LongVideoFullScreenView", "pause play");
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219664);
          try
          {
            LongVideoFullScreenView.h(LongVideoFullScreenView.this).pause();
            LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(0);
            LongVideoFullScreenView.ap(LongVideoFullScreenView.m(LongVideoFullScreenView.this));
            LongVideoFullScreenView.a(LongVideoFullScreenView.this, false);
            AppMethodBeat.o(219664);
            return;
          }
          catch (Throwable localThrowable)
          {
            ae.e("LongVideoFullScreenView", localThrowable.toString());
            AppMethodBeat.o(219664);
          }
        }
      });
      if (this.wyh != 0L)
      {
        this.AjM += System.currentTimeMillis() - this.wyh;
        this.wyh = 0L;
        ae.i("LongVideoFullScreenView", "playTimeInterval update");
      }
      AppMethodBeat.o(219683);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(219683);
    }
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dZN()
  {
    AppMethodBeat.i(219684);
    try
    {
      this.zWH.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131690341));
      this.AjD.setMute(true);
      this.zWP = true;
      AppMethodBeat.o(219684);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(219684);
    }
  }
  
  public final void dZP()
  {
    AppMethodBeat.i(219685);
    try
    {
      this.zWH.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131690342));
      this.AjD.setMute(false);
      this.zWP = false;
      AppMethodBeat.o(219685);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(219685);
    }
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    this.zWT = false;
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219677);
    try
    {
      this.zWY += 1;
      this.AjD.zYZ.stopTimer();
      this.AjD.onUIPause();
      AppMethodBeat.o(219677);
      return;
    }
    catch (Throwable paramString1)
    {
      ae.e("LongVideoFullScreenView", paramString1.toString());
      AppMethodBeat.o(219677);
    }
  }
  
  public final void du(String paramString1, String paramString2) {}
  
  public final void dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219679);
    try
    {
      ar.ay(this.zXR);
      this.zXP.setVisibility(8);
      rL(true);
      AppMethodBeat.o(219679);
      return;
    }
    catch (Throwable paramString1)
    {
      ae.e("LongVideoFullScreenView", paramString1.toString());
      AppMethodBeat.o(219679);
    }
  }
  
  public final void dw(String paramString1, String paramString2)
  {
    this.AjJ = true;
  }
  
  public final void dx(String paramString1, String paramString2)
  {
    this.AjJ = false;
    this.AjK = 0;
  }
  
  public final void eX(String paramString1, String paramString2) {}
  
  public final void eaX()
  {
    AppMethodBeat.i(219678);
    try
    {
      if (this.AjD.getCurrPosSec() >= this.AjG)
      {
        ae.i("LongVideoFullScreenView", "onLoopCompletion");
        this.zWY += 1;
        this.AjD.c(0.0D, true);
      }
      AppMethodBeat.o(219678);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(219678);
    }
  }
  
  final void eam()
  {
    AppMethodBeat.i(219673);
    try
    {
      Object localObject = this.zWG.getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.zWG);
      }
      an.aH((Activity)this.mContext);
      localObject = (RelativeLayout.LayoutParams)this.AjB.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)this.AjC.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.zXO.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
      localObject = new RelativeLayout.LayoutParams(this.lya - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 232), -2);
      ((ViewGroup)this.AjB).addView(this.zWG, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(219673);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(219673);
    }
  }
  
  final void ean()
  {
    AppMethodBeat.i(219674);
    try
    {
      Object localObject = this.zWG.getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.zWG);
      }
      an.aH((Activity)this.mContext);
      localObject = (RelativeLayout.LayoutParams)this.AjB.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)this.AjC.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.zXO.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 10);
      localObject = new RelativeLayout.LayoutParams(this.lxZ - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 74), -2);
      ((ViewGroup)this.AjB).addView(this.zWG, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(219674);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(219674);
    }
  }
  
  public final Intent edE()
  {
    AppMethodBeat.i(219688);
    Intent localIntent = new Intent();
    try
    {
      if ((this.AjD.isPlaying()) && (this.wyh != 0L))
      {
        this.AjM += System.currentTimeMillis() - this.wyh;
        this.wyh = 0L;
        ae.i("LongVideoFullScreenView", "playTimeInterval update");
      }
      localIntent.putExtra("KComponentVideoType", this.ivg);
      localIntent.putExtra("KComponentCid", this.AjE);
      localIntent.putExtra("KComponentCurrentTime", this.AjD.getCurrPosSec());
      localIntent.putExtra("KComponentVoiceType", this.zWP);
      localIntent.putExtra("KComponentProgressType", this.AjD.isPlaying());
      localIntent.putExtra("KComponentClickPlayControlCount", this.zWZ);
      localIntent.putExtra("KComponentDoubleClickCount", this.zXS);
      localIntent.putExtra("KComponentClickVoiceControlCount", this.zXa);
      localIntent.putExtra("KComponentPlayCompletedCount", this.zWY);
      localIntent.putExtra("KComponentPlayCount", this.wyN);
      localIntent.putExtra("KComponentPlayTimeInterval", this.AjM);
      localIntent.putExtra("KComponentIsWaiting", this.AjJ);
      localIntent.putExtra("KComponentSeekTimeDueWaiting", this.AjK);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ae.e("LongVideoFullScreenView", localThrowable.toString());
      }
    }
    AppMethodBeat.o(219688);
    return localIntent;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(219675);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    try
    {
      if (paramView.getId() == 2131304921)
      {
        this.zXa += 1;
        setFocus(true);
        if (this.zWP) {
          dZP();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219675);
          return;
          dZN();
        }
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        ae.e("LongVideoFullScreenView", paramView.toString());
        continue;
        if (paramView.getId() == 2131307246)
        {
          ar.ay(this.zXR);
          this.zXP.setVisibility(8);
          ((Activity)this.mContext).finish();
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(219676);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        ae.i("LongVideoFullScreenView", "ORIENTATION_LANDSCAPE");
        eam();
        AppMethodBeat.o(219676);
        return;
      }
      if (paramConfiguration.orientation == 1)
      {
        ae.i("LongVideoFullScreenView", "ORIENTATION_PORTRAIT");
        ean();
      }
      AppMethodBeat.o(219676);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      ae.e("LongVideoFullScreenView", paramConfiguration.toString());
      AppMethodBeat.o(219676);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219693);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    for (;;)
    {
      try
      {
        ae.i("LongVideoFullScreenView", "onDoubleTap");
        if (!this.zWT) {
          this.zXS += 1;
        }
        ao(this.zWL);
        if (!this.AjD.isPlaying()) {
          continue;
        }
        cyX();
      }
      catch (Throwable paramMotionEvent)
      {
        ae.e("LongVideoFullScreenView", paramMotionEvent.toString());
        continue;
        dZP();
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(219693);
      return false;
      if (!this.zWP) {
        continue;
      }
      dZN();
      cbC();
    }
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219695);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(219695);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219692);
    try
    {
      ae.i("LongVideoFullScreenView", "onSingleTapConfirmed");
      if (!this.zWO)
      {
        this.zWO = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(219692);
        return false;
        this.zWO = false;
        setFocus(false);
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        ae.e("LongVideoFullScreenView", paramMotionEvent.toString());
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219694);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(219694);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219691);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    paramView = this.iNw;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.ahE(), "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.mt(0)), "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(219691);
    return bool;
  }
  
  void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(219689);
    if (paramBoolean) {}
    try
    {
      if (this.AjN != null) {
        this.AjN.sf(true);
      }
      this.zWG.setVisibility(0);
      this.zWH.setVisibility(0);
      this.zXO.setVisibility(0);
      ao(this.zWL);
      AppMethodBeat.o(219689);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(219689);
    }
    this.zWO = false;
    this.zWG.setVisibility(4);
    this.zWH.setVisibility(8);
    this.zXO.setVisibility(8);
    ar.ay(this.zWL);
    if (this.AjN != null) {
      this.AjN.sf(false);
    }
    AppMethodBeat.o(219689);
    return;
  }
  
  public void setProgressBarStatusListener(com.tencent.mm.plugin.sns.ui.d.a parama)
  {
    this.AjN = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LongVideoFullScreenView
 * JD-Core Version:    0.7.0.1
 */