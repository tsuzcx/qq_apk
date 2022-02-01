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
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao;
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
  private long FOL;
  private int FPs;
  boolean JAS;
  private int JAW;
  private int JAX;
  private int JAY;
  private int JAZ;
  Runnable JBl;
  FrameLayout KFE;
  View KFF;
  View KFG;
  AdLandingVideoWrapper KFH;
  String KFI;
  int KFJ;
  int KFK;
  String KFL;
  int KFM;
  private volatile boolean KFN;
  private volatile int KFO;
  volatile boolean KFP;
  private long KFQ;
  private com.tencent.mm.plugin.sns.ui.d.a KFR;
  volatile boolean KkF;
  String Kmm;
  private volatile boolean KtQ;
  int KtV;
  ImageView Kte;
  private volatile boolean Ktg;
  VideoPlayerSeekBar Kth;
  ImageView Kti;
  View Ktj;
  Runnable Ktl;
  View.OnClickListener Ktm;
  View contentView;
  boolean fGh;
  volatile boolean isFirst;
  boolean isWaiting;
  volatile boolean kfR;
  int length;
  private GestureDetector mBn;
  Context mContext;
  int mfT;
  int pEj;
  int pEk;
  com.tencent.mm.plugin.sight.decode.ui.b wTG;
  
  public LongVideoFullScreenView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(264118);
    this.contentView = null;
    this.KFN = false;
    this.KFO = 0;
    this.kfR = true;
    this.Ktg = false;
    this.KtQ = true;
    this.KkF = false;
    this.isFirst = true;
    this.KFP = false;
    this.FOL = 0L;
    this.JAX = 0;
    this.JAZ = 0;
    this.JAY = 0;
    this.JAW = 0;
    this.FPs = 0;
    this.KFQ = 0L;
    this.Ktm = fTR();
    this.wTG = fTS();
    this.JBl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(240185);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(240185);
      }
    };
    this.Ktl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264724);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(264724);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(264724);
        }
      }
    };
    this.mContext = paramContext;
    this.mBn = new GestureDetector(this);
    AppMethodBeat.o(264118);
  }
  
  public LongVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(264120);
    this.contentView = null;
    this.KFN = false;
    this.KFO = 0;
    this.kfR = true;
    this.Ktg = false;
    this.KtQ = true;
    this.KkF = false;
    this.isFirst = true;
    this.KFP = false;
    this.FOL = 0L;
    this.JAX = 0;
    this.JAZ = 0;
    this.JAY = 0;
    this.JAW = 0;
    this.FPs = 0;
    this.KFQ = 0L;
    this.Ktm = fTR();
    this.wTG = fTS();
    this.JBl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(240185);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(240185);
      }
    };
    this.Ktl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264724);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(264724);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(264724);
        }
      }
    };
    this.mContext = paramContext;
    this.mBn = new GestureDetector(this);
    AppMethodBeat.o(264120);
  }
  
  public LongVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(264122);
    this.contentView = null;
    this.KFN = false;
    this.KFO = 0;
    this.kfR = true;
    this.Ktg = false;
    this.KtQ = true;
    this.KkF = false;
    this.isFirst = true;
    this.KFP = false;
    this.FOL = 0L;
    this.JAX = 0;
    this.JAZ = 0;
    this.JAY = 0;
    this.JAW = 0;
    this.FPs = 0;
    this.KFQ = 0L;
    this.Ktm = fTR();
    this.wTG = fTS();
    this.JBl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(240185);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(240185);
      }
    };
    this.Ktl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264724);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(264724);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(264724);
        }
      }
    };
    this.mContext = paramContext;
    this.mBn = new GestureDetector(this);
    AppMethodBeat.o(264122);
  }
  
  private static void aE(Runnable paramRunnable)
  {
    AppMethodBeat.i(264143);
    try
    {
      MMHandlerThread.removeRunnable(paramRunnable);
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(264143);
      return;
    }
    catch (Throwable paramRunnable)
    {
      Log.e("LongVideoFullScreenView", paramRunnable.toString());
      AppMethodBeat.o(264143);
    }
  }
  
  private View.OnClickListener fTR()
  {
    AppMethodBeat.i(264139);
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203909);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
            LongVideoFullScreenView.this.fKs();
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203909);
          return;
          if (!LongVideoFullScreenView.o(LongVideoFullScreenView.this)) {
            continue;
          }
          LongVideoFullScreenView.this.fKr();
          LongVideoFullScreenView.p(LongVideoFullScreenView.this);
        }
      }
    };
    AppMethodBeat.o(264139);
    return local3;
  }
  
  private com.tencent.mm.plugin.sight.decode.ui.b fTS()
  {
    AppMethodBeat.i(264140);
    com.tencent.mm.plugin.sight.decode.ui.b local4 = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aRo()
      {
        AppMethodBeat.i(265849);
        try
        {
          LongVideoFullScreenView.b(LongVideoFullScreenView.this, true);
          AppMethodBeat.o(265849);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(265849);
        }
      }
      
      public final void tY(int paramAnonymousInt)
      {
        AppMethodBeat.i(265850);
        try
        {
          Log.i("LongVideoFullScreenView", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          int i = paramAnonymousInt;
          if (paramAnonymousInt >= LongVideoFullScreenView.e(LongVideoFullScreenView.this))
          {
            i = 0;
            LongVideoFullScreenView.s(LongVideoFullScreenView.this);
            Log.i("LongVideoFullScreenView", "onLoopCompletion, onSeekTo time is 0");
          }
          LongVideoFullScreenView.a(LongVideoFullScreenView.this, i);
          if (LongVideoFullScreenView.o(LongVideoFullScreenView.this)) {
            LongVideoFullScreenView.this.fKr();
          }
          for (;;)
          {
            LongVideoFullScreenView.h(LongVideoFullScreenView.this).a(i, true);
            MMHandlerThread.removeRunnable(LongVideoFullScreenView.m(LongVideoFullScreenView.this));
            LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(265850);
            return;
            LongVideoFullScreenView.this.fKs();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(265850);
        }
      }
    };
    AppMethodBeat.o(264140);
    return local4;
  }
  
  private void yM(boolean paramBoolean)
  {
    AppMethodBeat.i(264134);
    try
    {
      this.Kth.setIsPlay(paramBoolean);
      this.Kth.getPlayBtn().getLayoutParams().width = this.length;
      this.Kth.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        Log.i("LongVideoFullScreenView", "startPlay");
        this.Kth.getPlayBtn().setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, i.i.media_player_btn_cur_status_on));
        AppMethodBeat.o(264134);
        return;
      }
      Log.i("LongVideoFullScreenView", "pausePlay");
      this.Kth.getPlayBtn().setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, i.i.media_player_btn_cur_status_off));
      AppMethodBeat.o(264134);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(264134);
    }
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(264133);
    Log.e("LongVideoFullScreenView", "online play error, %s", new Object[] { paramString3 });
    this.Ktg = true;
    AppMethodBeat.o(264133);
  }
  
  final void cNW()
  {
    AppMethodBeat.i(264135);
    try
    {
      Log.i("LongVideoFullScreenView", "starting play, downFailed=" + this.Ktg);
      boolean bool = this.Ktg;
      if (bool) {
        try
        {
          Log.e("LongVideoFullScreenView", "last download fail ,try again");
          if ((this.Kth != null) && (this.Kth.getParent() != null)) {
            ((ViewGroup)this.Kth.getParent()).removeView(this.Kth);
          }
          this.KFH.setFullScreen(true);
          this.KFH.c(false, this.KFL, 0);
          if (this.mContext.getResources().getConfiguration().orientation == 2)
          {
            Log.i("LongVideoFullScreenView", "ORIENTATION_LANDSCAPE");
            fQW();
          }
          for (;;)
          {
            this.KFH.a(0.0D, true);
            this.KFH.fRI();
            AppMethodBeat.o(264135);
            return;
            if (this.mContext.getResources().getConfiguration().orientation == 1)
            {
              Log.i("LongVideoFullScreenView", "ORIENTATION_PORTRAIT");
              fQX();
            }
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(266224);
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
                    LongVideoFullScreenView.h(LongVideoFullScreenView.this).a(LongVideoFullScreenView.f(LongVideoFullScreenView.this), true);
                  }
                  for (;;)
                  {
                    LongVideoFullScreenView.a(LongVideoFullScreenView.this, System.currentTimeMillis());
                    LongVideoFullScreenView.a(LongVideoFullScreenView.this, true);
                    AppMethodBeat.o(266224);
                    return;
                    LongVideoFullScreenView.g(LongVideoFullScreenView.this).seek(0);
                    LongVideoFullScreenView.h(LongVideoFullScreenView.this).a(0.0D, true);
                  }
                }
                if (LongVideoFullScreenView.i(LongVideoFullScreenView.this) >= LongVideoFullScreenView.e(LongVideoFullScreenView.this)) {
                  break label192;
                }
              }
              catch (Throwable localThrowable)
              {
                Log.e("LongVideoFullScreenView", localThrowable.toString());
                AppMethodBeat.o(266224);
                return;
              }
              if (LongVideoFullScreenView.i(LongVideoFullScreenView.this) < 0)
              {
                label192:
                LongVideoFullScreenView.g(LongVideoFullScreenView.this).seek(0);
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).a(0.0D, LongVideoFullScreenView.j(LongVideoFullScreenView.this));
              }
              for (;;)
              {
                LongVideoFullScreenView.a(LongVideoFullScreenView.this, System.currentTimeMillis());
                LongVideoFullScreenView.a(LongVideoFullScreenView.this, LongVideoFullScreenView.j(LongVideoFullScreenView.this));
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).fRI();
                AppMethodBeat.o(266224);
                return;
                LongVideoFullScreenView.g(LongVideoFullScreenView.this).seek(LongVideoFullScreenView.i(LongVideoFullScreenView.this) / 1000);
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).a(LongVideoFullScreenView.i(LongVideoFullScreenView.this), LongVideoFullScreenView.j(LongVideoFullScreenView.this));
              }
              label313:
              if (!LongVideoFullScreenView.h(LongVideoFullScreenView.this).isPlaying())
              {
                if (LongVideoFullScreenView.h(LongVideoFullScreenView.this).getCurrPosSec() != LongVideoFullScreenView.h(LongVideoFullScreenView.this).getVideoDurationSec()) {
                  break label405;
                }
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).a(0.0D, true);
              }
              for (;;)
              {
                LongVideoFullScreenView.a(LongVideoFullScreenView.this, true);
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).fRI();
                LongVideoFullScreenView.k(LongVideoFullScreenView.this);
                LongVideoFullScreenView.a(LongVideoFullScreenView.this, System.currentTimeMillis());
                AppMethodBeat.o(266224);
                return;
                label405:
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).a(LongVideoFullScreenView.h(LongVideoFullScreenView.this).getCurrPosSec(), true);
              }
            }
          });
        }
        catch (Throwable localThrowable1)
        {
          Log.e("LongVideoFullScreenView", localThrowable1.toString());
        }
      }
      AppMethodBeat.o(264135);
      return;
    }
    catch (Throwable localThrowable2)
    {
      Log.e("LongVideoFullScreenView", localThrowable2.toString());
      AppMethodBeat.o(264135);
    }
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dS(String paramString1, String paramString2)
  {
    this.Ktg = false;
  }
  
  public final void dT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(264130);
    try
    {
      this.JAW += 1;
      this.KFH.Kux.stopTimer();
      this.KFH.onUIPause();
      AppMethodBeat.o(264130);
      return;
    }
    catch (Throwable paramString1)
    {
      Log.e("LongVideoFullScreenView", paramString1.toString());
      AppMethodBeat.o(264130);
    }
  }
  
  public final void dU(String paramString1, String paramString2) {}
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(264132);
    try
    {
      MMHandlerThread.removeRunnable(this.Ktl);
      this.Ktj.setVisibility(8);
      yM(true);
      AppMethodBeat.o(264132);
      return;
    }
    catch (Throwable paramString1)
    {
      Log.e("LongVideoFullScreenView", paramString1.toString());
      AppMethodBeat.o(264132);
    }
  }
  
  public final void dW(String paramString1, String paramString2)
  {
    this.KFN = true;
  }
  
  public final void dX(String paramString1, String paramString2)
  {
    this.KFN = false;
    this.KFO = 0;
  }
  
  final void dmi()
  {
    AppMethodBeat.i(264136);
    try
    {
      Log.d("LongVideoFullScreenView", "pause play");
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(204608);
          try
          {
            LongVideoFullScreenView.h(LongVideoFullScreenView.this).pause();
            LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(0);
            LongVideoFullScreenView.aF(LongVideoFullScreenView.m(LongVideoFullScreenView.this));
            LongVideoFullScreenView.a(LongVideoFullScreenView.this, false);
            AppMethodBeat.o(204608);
            return;
          }
          catch (Throwable localThrowable)
          {
            Log.e("LongVideoFullScreenView", localThrowable.toString());
            AppMethodBeat.o(204608);
          }
        }
      });
      if (this.FOL != 0L)
      {
        this.KFQ += System.currentTimeMillis() - this.FOL;
        this.FOL = 0L;
        Log.i("LongVideoFullScreenView", "playTimeInterval update");
      }
      AppMethodBeat.o(264136);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(264136);
    }
  }
  
  public final void fC(String paramString1, String paramString2) {}
  
  public final void fKr()
  {
    AppMethodBeat.i(264137);
    try
    {
      this.Kte.setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, i.i.icon_volume_off));
      this.KFH.setMute(true);
      this.JAS = true;
      AppMethodBeat.o(264137);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(264137);
    }
  }
  
  public final void fKs()
  {
    AppMethodBeat.i(264138);
    try
    {
      this.Kte.setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, i.i.icon_volume_on));
      this.KFH.setMute(false);
      this.JAS = false;
      AppMethodBeat.o(264138);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(264138);
    }
  }
  
  public final void fKt()
  {
    AppMethodBeat.i(264131);
    try
    {
      int i = this.KFH.getCurrPosSec();
      if (i >= this.KFK)
      {
        Log.i("LongVideoFullScreenView", "onLoopCompletion, currPosSec is ".concat(String.valueOf(i)));
        this.JAW += 1;
        this.KFH.a(0.0D, true);
      }
      AppMethodBeat.o(264131);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(264131);
    }
  }
  
  final void fQW()
  {
    AppMethodBeat.i(264124);
    try
    {
      Object localObject = this.Kth.getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.Kth);
      }
      ao.aR((Activity)this.mContext);
      localObject = (RelativeLayout.LayoutParams)this.KFF.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)this.KFG.getLayoutParams()).rightMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.Kti.getLayoutParams()).rightMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 20);
      localObject = new RelativeLayout.LayoutParams(this.pEk - com.tencent.mm.ci.a.fromDPToPix(this.mContext, 232), -2);
      ((ViewGroup)this.KFF).addView(this.Kth, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(264124);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(264124);
    }
  }
  
  final void fQX()
  {
    AppMethodBeat.i(264126);
    try
    {
      Object localObject = this.Kth.getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.Kth);
      }
      ao.aR((Activity)this.mContext);
      localObject = (RelativeLayout.LayoutParams)this.KFF.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)this.KFG.getLayoutParams()).rightMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.Kti.getLayoutParams()).rightMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 10);
      localObject = new RelativeLayout.LayoutParams(this.pEj - com.tencent.mm.ci.a.fromDPToPix(this.mContext, 74), -2);
      ((ViewGroup)this.KFF).addView(this.Kth, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(264126);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(264126);
    }
  }
  
  public final Intent fTT()
  {
    AppMethodBeat.i(264141);
    Intent localIntent = new Intent();
    try
    {
      if ((this.KFH.isPlaying()) && (this.FOL != 0L))
      {
        this.KFQ += System.currentTimeMillis() - this.FOL;
        this.FOL = 0L;
        Log.i("LongVideoFullScreenView", "playTimeInterval update");
      }
      localIntent.putExtra("KComponentVideoType", this.mfT);
      localIntent.putExtra("KComponentCid", this.KFI);
      localIntent.putExtra("KComponentCurrentTime", this.KFH.getCurrPosSec());
      localIntent.putExtra("KComponentVoiceType", this.JAS);
      localIntent.putExtra("KComponentProgressType", this.KFH.isPlaying());
      localIntent.putExtra("KComponentClickPlayControlCount", this.JAX);
      localIntent.putExtra("KComponentDoubleClickCount", this.JAZ);
      localIntent.putExtra("KComponentClickVoiceControlCount", this.JAY);
      localIntent.putExtra("KComponentPlayCompletedCount", this.JAW);
      localIntent.putExtra("KComponentPlayCount", this.FPs);
      localIntent.putExtra("KComponentPlayTimeInterval", this.KFQ);
      localIntent.putExtra("KComponentIsWaiting", this.KFN);
      localIntent.putExtra("KComponentSeekTimeDueWaiting", this.KFO);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("LongVideoFullScreenView", localThrowable.toString());
      }
    }
    AppMethodBeat.o(264141);
    return localIntent;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(264128);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    try
    {
      if (paramView.getId() == i.f.sns_ad_native_landing_pages_sight_voice_btn)
      {
        this.JAY += 1;
        setFocus(true);
        if (this.JAS) {
          fKs();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(264128);
          return;
          fKr();
        }
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        Log.e("LongVideoFullScreenView", paramView.toString());
        continue;
        if (paramView.getId() == i.f.sns_ad_native_landing_pages_sight_video_full_screen_btn)
        {
          MMHandlerThread.removeRunnable(this.Ktl);
          this.Ktj.setVisibility(8);
          ((Activity)this.mContext).finish();
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(264129);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        Log.i("LongVideoFullScreenView", "ORIENTATION_LANDSCAPE");
        fQW();
        AppMethodBeat.o(264129);
        return;
      }
      if (paramConfiguration.orientation == 1)
      {
        Log.i("LongVideoFullScreenView", "ORIENTATION_PORTRAIT");
        fQX();
      }
      AppMethodBeat.o(264129);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      Log.e("LongVideoFullScreenView", paramConfiguration.toString());
      AppMethodBeat.o(264129);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(264146);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    for (;;)
    {
      try
      {
        Log.i("LongVideoFullScreenView", "onDoubleTap");
        if (!this.Ktg) {
          this.JAZ += 1;
        }
        aE(this.JBl);
        if (!this.KFH.isPlaying()) {
          continue;
        }
        dmi();
      }
      catch (Throwable paramMotionEvent)
      {
        Log.e("LongVideoFullScreenView", paramMotionEvent.toString());
        continue;
        fKs();
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(264146);
      return false;
      if (!this.JAS) {
        continue;
      }
      fKr();
      cNW();
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
    AppMethodBeat.i(264148);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(264148);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(264145);
    try
    {
      Log.i("LongVideoFullScreenView", "onSingleTapConfirmed");
      if (!this.KtQ)
      {
        this.KtQ = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(264145);
        return false;
        this.KtQ = false;
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
    AppMethodBeat.i(264147);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(264147);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(264144);
    paramView = this.mBn;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, paramMotionEvent.aFh(), "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(264144);
    return bool;
  }
  
  void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(264142);
    if (paramBoolean) {}
    try
    {
      if (this.KFR != null) {
        this.KFR.zf(true);
      }
      this.Kth.setVisibility(0);
      this.Kte.setVisibility(0);
      this.Kti.setVisibility(0);
      aE(this.JBl);
      AppMethodBeat.o(264142);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(264142);
    }
    this.KtQ = false;
    this.Kth.setVisibility(4);
    this.Kte.setVisibility(8);
    this.Kti.setVisibility(8);
    MMHandlerThread.removeRunnable(this.JBl);
    if (this.KFR != null) {
      this.KFR.zf(false);
    }
    AppMethodBeat.o(264142);
    return;
  }
  
  public void setProgressBarStatusListener(com.tencent.mm.plugin.sns.ui.d.a parama)
  {
    this.KFR = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LongVideoFullScreenView
 * JD-Core Version:    0.7.0.1
 */