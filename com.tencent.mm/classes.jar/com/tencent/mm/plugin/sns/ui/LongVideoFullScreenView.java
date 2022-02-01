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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public class LongVideoFullScreenView
  extends RelativeLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, i.b, i.d
{
  private long AhP;
  private int Aiv;
  volatile boolean DXw;
  String DYR;
  VideoPlayerSeekBar EeP;
  ImageView EeQ;
  Runnable EeU;
  private volatile boolean EeX;
  boolean EeY;
  private volatile boolean Efc;
  private int Efh;
  private int Efi;
  private int Efj;
  View.OnClickListener Efl;
  int EgO;
  ImageView Egd;
  View Ege;
  Runnable Egg;
  private int Egh;
  FrameLayout Esi;
  View Esj;
  View Esk;
  AdLandingVideoWrapper Esl;
  String Esm;
  int Esn;
  int Eso;
  String Esp;
  int Esq;
  private volatile boolean Esr;
  private volatile int Ess;
  volatile boolean Est;
  private long Esu;
  private com.tencent.mm.plugin.sns.ui.d.a Esv;
  View contentView;
  boolean gVd;
  volatile boolean htU;
  volatile boolean isFirst;
  boolean isWaiting;
  private GestureDetector jKk;
  int jqs;
  int length;
  Context mContext;
  int mEX;
  int mEY;
  com.tencent.mm.plugin.sight.decode.ui.b tni;
  
  public LongVideoFullScreenView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(203269);
    this.contentView = null;
    this.Esr = false;
    this.Ess = 0;
    this.htU = true;
    this.Efc = false;
    this.EeX = true;
    this.DXw = false;
    this.isFirst = true;
    this.Est = false;
    this.AhP = 0L;
    this.Efi = 0;
    this.Egh = 0;
    this.Efj = 0;
    this.Efh = 0;
    this.Aiv = 0;
    this.Esu = 0L;
    this.Efl = ffU();
    this.tni = ffV();
    this.EeU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203267);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(203267);
      }
    };
    this.Egg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203268);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(203268);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(203268);
        }
      }
    };
    this.mContext = paramContext;
    this.jKk = new GestureDetector(this);
    AppMethodBeat.o(203269);
  }
  
  public LongVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(203270);
    this.contentView = null;
    this.Esr = false;
    this.Ess = 0;
    this.htU = true;
    this.Efc = false;
    this.EeX = true;
    this.DXw = false;
    this.isFirst = true;
    this.Est = false;
    this.AhP = 0L;
    this.Efi = 0;
    this.Egh = 0;
    this.Efj = 0;
    this.Efh = 0;
    this.Aiv = 0;
    this.Esu = 0L;
    this.Efl = ffU();
    this.tni = ffV();
    this.EeU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203267);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(203267);
      }
    };
    this.Egg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203268);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(203268);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(203268);
        }
      }
    };
    this.mContext = paramContext;
    this.jKk = new GestureDetector(this);
    AppMethodBeat.o(203270);
  }
  
  public LongVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203271);
    this.contentView = null;
    this.Esr = false;
    this.Ess = 0;
    this.htU = true;
    this.Efc = false;
    this.EeX = true;
    this.DXw = false;
    this.isFirst = true;
    this.Est = false;
    this.AhP = 0L;
    this.Efi = 0;
    this.Egh = 0;
    this.Efj = 0;
    this.Efh = 0;
    this.Aiv = 0;
    this.Esu = 0L;
    this.Efl = ffU();
    this.tni = ffV();
    this.EeU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203267);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(203267);
      }
    };
    this.Egg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203268);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(203268);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(203268);
        }
      }
    };
    this.mContext = paramContext;
    this.jKk = new GestureDetector(this);
    AppMethodBeat.o(203271);
  }
  
  private static void ay(Runnable paramRunnable)
  {
    AppMethodBeat.i(203289);
    try
    {
      MMHandlerThread.removeRunnable(paramRunnable);
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(203289);
      return;
    }
    catch (Throwable paramRunnable)
    {
      Log.e("LongVideoFullScreenView", paramRunnable.toString());
      AppMethodBeat.o(203289);
    }
  }
  
  private View.OnClickListener ffU()
  {
    AppMethodBeat.i(203285);
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203264);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        for (;;)
        {
          try
          {
            Log.i("LongVideoFullScreenView", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(LongVideoFullScreenView.h(LongVideoFullScreenView.this).isPlaying()) });
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
            Log.e("LongVideoFullScreenView", paramAnonymousView.toString());
            continue;
            LongVideoFullScreenView.this.fcK();
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203264);
          return;
          if (!LongVideoFullScreenView.o(LongVideoFullScreenView.this)) {
            continue;
          }
          LongVideoFullScreenView.this.fcJ();
          LongVideoFullScreenView.p(LongVideoFullScreenView.this);
        }
      }
    };
    AppMethodBeat.o(203285);
    return local3;
  }
  
  private com.tencent.mm.plugin.sight.decode.ui.b ffV()
  {
    AppMethodBeat.i(203286);
    com.tencent.mm.plugin.sight.decode.ui.b local4 = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aJq()
      {
        AppMethodBeat.i(203265);
        try
        {
          LongVideoFullScreenView.b(LongVideoFullScreenView.this, true);
          AppMethodBeat.o(203265);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(203265);
        }
      }
      
      public final void rk(int paramAnonymousInt)
      {
        AppMethodBeat.i(203266);
        try
        {
          Log.i("LongVideoFullScreenView", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          LongVideoFullScreenView.a(LongVideoFullScreenView.this, paramAnonymousInt);
          if (LongVideoFullScreenView.o(LongVideoFullScreenView.this)) {
            LongVideoFullScreenView.this.fcJ();
          }
          for (;;)
          {
            LongVideoFullScreenView.h(LongVideoFullScreenView.this).c(paramAnonymousInt, true);
            MMHandlerThread.removeRunnable(LongVideoFullScreenView.m(LongVideoFullScreenView.this));
            LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(203266);
            return;
            LongVideoFullScreenView.this.fcK();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(203266);
        }
      }
    };
    AppMethodBeat.o(203286);
    return local4;
  }
  
  private void vh(boolean paramBoolean)
  {
    AppMethodBeat.i(203280);
    try
    {
      this.EeP.setIsPlay(paramBoolean);
      this.EeP.getPlayBtn().getLayoutParams().width = this.length;
      this.EeP.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        Log.i("LongVideoFullScreenView", "startPlay");
        this.EeP.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131691079));
        AppMethodBeat.o(203280);
        return;
      }
      Log.i("LongVideoFullScreenView", "pausePlay");
      this.EeP.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131691078));
      AppMethodBeat.o(203280);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(203280);
    }
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203279);
    Log.e("LongVideoFullScreenView", "online play error, %s", new Object[] { paramString3 });
    this.Efc = true;
    AppMethodBeat.o(203279);
  }
  
  final void cXa()
  {
    AppMethodBeat.i(203282);
    try
    {
      Log.d("LongVideoFullScreenView", "pause play");
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203263);
          try
          {
            LongVideoFullScreenView.h(LongVideoFullScreenView.this).pause();
            LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(0);
            LongVideoFullScreenView.az(LongVideoFullScreenView.m(LongVideoFullScreenView.this));
            LongVideoFullScreenView.a(LongVideoFullScreenView.this, false);
            AppMethodBeat.o(203263);
            return;
          }
          catch (Throwable localThrowable)
          {
            Log.e("LongVideoFullScreenView", localThrowable.toString());
            AppMethodBeat.o(203263);
          }
        }
      });
      if (this.AhP != 0L)
      {
        this.Esu += System.currentTimeMillis() - this.AhP;
        this.AhP = 0L;
        Log.i("LongVideoFullScreenView", "playTimeInterval update");
      }
      AppMethodBeat.o(203282);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(203282);
    }
  }
  
  final void czw()
  {
    AppMethodBeat.i(203281);
    try
    {
      Log.i("LongVideoFullScreenView", "starting play, downFailed=" + this.Efc);
      boolean bool = this.Efc;
      if (bool) {
        try
        {
          Log.e("LongVideoFullScreenView", "last download fail ,try again");
          if ((this.EeP != null) && (this.EeP.getParent() != null)) {
            ((ViewGroup)this.EeP.getParent()).removeView(this.EeP);
          }
          this.Esl.setFullScreen(true);
          this.Esl.c(false, this.Esp, 0);
          if (this.mContext.getResources().getConfiguration().orientation == 2)
          {
            Log.i("LongVideoFullScreenView", "ORIENTATION_LANDSCAPE");
            fda();
          }
          for (;;)
          {
            this.Esl.c(0.0D, true);
            this.Esl.fdQ();
            AppMethodBeat.o(203281);
            return;
            if (this.mContext.getResources().getConfiguration().orientation == 1)
            {
              Log.i("LongVideoFullScreenView", "ORIENTATION_PORTRAIT");
              fdb();
            }
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(203262);
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
                    AppMethodBeat.o(203262);
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
                Log.e("LongVideoFullScreenView", localThrowable.toString());
                AppMethodBeat.o(203262);
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
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).fdQ();
                AppMethodBeat.o(203262);
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
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).fdQ();
                LongVideoFullScreenView.k(LongVideoFullScreenView.this);
                LongVideoFullScreenView.a(LongVideoFullScreenView.this, System.currentTimeMillis());
                AppMethodBeat.o(203262);
                return;
                label405:
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).c(LongVideoFullScreenView.h(LongVideoFullScreenView.this).getCurrPosSec(), true);
              }
            }
          });
        }
        catch (Throwable localThrowable1)
        {
          Log.e("LongVideoFullScreenView", localThrowable1.toString());
        }
      }
      AppMethodBeat.o(203281);
      return;
    }
    catch (Throwable localThrowable2)
    {
      Log.e("LongVideoFullScreenView", localThrowable2.toString());
      AppMethodBeat.o(203281);
    }
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dH(String paramString1, String paramString2)
  {
    this.Efc = false;
  }
  
  public final void dI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(203276);
    try
    {
      this.Efh += 1;
      this.Esl.Ehq.stopTimer();
      this.Esl.onUIPause();
      AppMethodBeat.o(203276);
      return;
    }
    catch (Throwable paramString1)
    {
      Log.e("LongVideoFullScreenView", paramString1.toString());
      AppMethodBeat.o(203276);
    }
  }
  
  public final void dJ(String paramString1, String paramString2) {}
  
  public final void dK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(203278);
    try
    {
      MMHandlerThread.removeRunnable(this.Egg);
      this.Ege.setVisibility(8);
      vh(true);
      AppMethodBeat.o(203278);
      return;
    }
    catch (Throwable paramString1)
    {
      Log.e("LongVideoFullScreenView", paramString1.toString());
      AppMethodBeat.o(203278);
    }
  }
  
  public final void dL(String paramString1, String paramString2)
  {
    this.Esr = true;
  }
  
  public final void dM(String paramString1, String paramString2)
  {
    this.Esr = false;
    this.Ess = 0;
  }
  
  public final void fcJ()
  {
    AppMethodBeat.i(203283);
    try
    {
      this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131690469));
      this.Esl.setMute(true);
      this.EeY = true;
      AppMethodBeat.o(203283);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(203283);
    }
  }
  
  public final void fcK()
  {
    AppMethodBeat.i(203284);
    try
    {
      this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131690470));
      this.Esl.setMute(false);
      this.EeY = false;
      AppMethodBeat.o(203284);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(203284);
    }
  }
  
  public final void fdO()
  {
    AppMethodBeat.i(203277);
    try
    {
      if (this.Esl.getCurrPosSec() >= this.Eso)
      {
        Log.i("LongVideoFullScreenView", "onLoopCompletion");
        this.Efh += 1;
        this.Esl.c(0.0D, true);
      }
      AppMethodBeat.o(203277);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(203277);
    }
  }
  
  final void fda()
  {
    AppMethodBeat.i(203272);
    try
    {
      Object localObject = this.EeP.getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.EeP);
      }
      ap.aL((Activity)this.mContext);
      localObject = (RelativeLayout.LayoutParams)this.Esj.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)this.Esk.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.Egd.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
      localObject = new RelativeLayout.LayoutParams(this.mEY - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 232), -2);
      ((ViewGroup)this.Esj).addView(this.EeP, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(203272);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(203272);
    }
  }
  
  final void fdb()
  {
    AppMethodBeat.i(203273);
    try
    {
      Object localObject = this.EeP.getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.EeP);
      }
      ap.aL((Activity)this.mContext);
      localObject = (RelativeLayout.LayoutParams)this.Esj.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)this.Esk.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.Egd.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 10);
      localObject = new RelativeLayout.LayoutParams(this.mEX - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 74), -2);
      ((ViewGroup)this.Esj).addView(this.EeP, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(203273);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(203273);
    }
  }
  
  public final Intent ffW()
  {
    AppMethodBeat.i(203287);
    Intent localIntent = new Intent();
    try
    {
      if ((this.Esl.isPlaying()) && (this.AhP != 0L))
      {
        this.Esu += System.currentTimeMillis() - this.AhP;
        this.AhP = 0L;
        Log.i("LongVideoFullScreenView", "playTimeInterval update");
      }
      localIntent.putExtra("KComponentVideoType", this.jqs);
      localIntent.putExtra("KComponentCid", this.Esm);
      localIntent.putExtra("KComponentCurrentTime", this.Esl.getCurrPosSec());
      localIntent.putExtra("KComponentVoiceType", this.EeY);
      localIntent.putExtra("KComponentProgressType", this.Esl.isPlaying());
      localIntent.putExtra("KComponentClickPlayControlCount", this.Efi);
      localIntent.putExtra("KComponentDoubleClickCount", this.Egh);
      localIntent.putExtra("KComponentClickVoiceControlCount", this.Efj);
      localIntent.putExtra("KComponentPlayCompletedCount", this.Efh);
      localIntent.putExtra("KComponentPlayCount", this.Aiv);
      localIntent.putExtra("KComponentPlayTimeInterval", this.Esu);
      localIntent.putExtra("KComponentIsWaiting", this.Esr);
      localIntent.putExtra("KComponentSeekTimeDueWaiting", this.Ess);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("LongVideoFullScreenView", localThrowable.toString());
      }
    }
    AppMethodBeat.o(203287);
    return localIntent;
  }
  
  public final void fo(String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(203274);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    try
    {
      if (paramView.getId() == 2131308058)
      {
        this.Efj += 1;
        setFocus(true);
        if (this.EeY) {
          fcK();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203274);
          return;
          fcJ();
        }
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        Log.e("LongVideoFullScreenView", paramView.toString());
        continue;
        if (paramView.getId() == 2131308057)
        {
          MMHandlerThread.removeRunnable(this.Egg);
          this.Ege.setVisibility(8);
          ((Activity)this.mContext).finish();
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(203275);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        Log.i("LongVideoFullScreenView", "ORIENTATION_LANDSCAPE");
        fda();
        AppMethodBeat.o(203275);
        return;
      }
      if (paramConfiguration.orientation == 1)
      {
        Log.i("LongVideoFullScreenView", "ORIENTATION_PORTRAIT");
        fdb();
      }
      AppMethodBeat.o(203275);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      Log.e("LongVideoFullScreenView", paramConfiguration.toString());
      AppMethodBeat.o(203275);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(203292);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    for (;;)
    {
      try
      {
        Log.i("LongVideoFullScreenView", "onDoubleTap");
        if (!this.Efc) {
          this.Egh += 1;
        }
        ay(this.EeU);
        if (!this.Esl.isPlaying()) {
          continue;
        }
        cXa();
      }
      catch (Throwable paramMotionEvent)
      {
        Log.e("LongVideoFullScreenView", paramMotionEvent.toString());
        continue;
        fcK();
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(203292);
      return false;
      if (!this.EeY) {
        continue;
      }
      fcJ();
      czw();
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
    AppMethodBeat.i(203294);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(203294);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(203291);
    try
    {
      Log.i("LongVideoFullScreenView", "onSingleTapConfirmed");
      if (!this.EeX)
      {
        this.EeX = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(203291);
        return false;
        this.EeX = false;
        setFocus(false);
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        Log.e("LongVideoFullScreenView", paramMotionEvent.toString());
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(203293);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(203293);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(203290);
    paramView = this.jKk;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.axQ(), "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(203290);
    return bool;
  }
  
  void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(203288);
    if (paramBoolean) {}
    try
    {
      if (this.Esv != null) {
        this.Esv.vB(true);
      }
      this.EeP.setVisibility(0);
      this.EeQ.setVisibility(0);
      this.Egd.setVisibility(0);
      ay(this.EeU);
      AppMethodBeat.o(203288);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(203288);
    }
    this.EeX = false;
    this.EeP.setVisibility(4);
    this.EeQ.setVisibility(8);
    this.Egd.setVisibility(8);
    MMHandlerThread.removeRunnable(this.EeU);
    if (this.Esv != null) {
      this.Esv.vB(false);
    }
    AppMethodBeat.o(203288);
    return;
  }
  
  public void setProgressBarStatusListener(com.tencent.mm.plugin.sns.ui.d.a parama)
  {
    this.Esv = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LongVideoFullScreenView
 * JD-Core Version:    0.7.0.1
 */