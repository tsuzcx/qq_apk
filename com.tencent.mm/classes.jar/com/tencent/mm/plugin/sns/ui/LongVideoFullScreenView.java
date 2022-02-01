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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;

public class LongVideoFullScreenView
  extends RelativeLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, h.b, h.d
{
  View contentView;
  volatile boolean gkP;
  int hYQ;
  private GestureDetector irA;
  volatile boolean isFirst;
  boolean isWaiting;
  int kWB;
  int kWC;
  int length;
  boolean lrL;
  Context mContext;
  b qUY;
  private int vdM;
  private long vdg;
  FrameLayout yBe;
  View yBf;
  View yBg;
  AdLandingVideoWrapper yBh;
  String yBi;
  int yBj;
  int yBk;
  String yBl;
  int yBm;
  private volatile boolean yBn;
  private volatile int yBo;
  volatile boolean yBp;
  private long yBq;
  volatile boolean yhR;
  String yjj;
  VideoPlayerSeekBar yoF;
  ImageView yoG;
  Runnable yoK;
  private volatile boolean yoN;
  boolean yoO;
  private volatile boolean yoS;
  private int yoX;
  private int yoY;
  private int yoZ;
  ImageView ypE;
  View ypF;
  Runnable ypH;
  private int ypI;
  View.OnClickListener ypb;
  int yqi;
  
  public LongVideoFullScreenView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(200344);
    this.contentView = null;
    this.yBn = false;
    this.yBo = 0;
    this.gkP = true;
    this.yoS = false;
    this.yoN = true;
    this.yhR = false;
    this.isFirst = true;
    this.yBp = false;
    this.vdg = 0L;
    this.yoY = 0;
    this.ypI = 0;
    this.yoZ = 0;
    this.yoX = 0;
    this.vdM = 0;
    this.yBq = 0L;
    this.ypb = dNJ();
    this.qUY = dNK();
    this.yoK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200342);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(200342);
      }
    };
    this.ypH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200343);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(200343);
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(200343);
        }
      }
    };
    this.mContext = paramContext;
    this.irA = new GestureDetector(this);
    AppMethodBeat.o(200344);
  }
  
  public LongVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200345);
    this.contentView = null;
    this.yBn = false;
    this.yBo = 0;
    this.gkP = true;
    this.yoS = false;
    this.yoN = true;
    this.yhR = false;
    this.isFirst = true;
    this.yBp = false;
    this.vdg = 0L;
    this.yoY = 0;
    this.ypI = 0;
    this.yoZ = 0;
    this.yoX = 0;
    this.vdM = 0;
    this.yBq = 0L;
    this.ypb = dNJ();
    this.qUY = dNK();
    this.yoK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200342);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(200342);
      }
    };
    this.ypH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200343);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(200343);
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(200343);
        }
      }
    };
    this.mContext = paramContext;
    this.irA = new GestureDetector(this);
    AppMethodBeat.o(200345);
  }
  
  public LongVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200346);
    this.contentView = null;
    this.yBn = false;
    this.yBo = 0;
    this.gkP = true;
    this.yoS = false;
    this.yoN = true;
    this.yhR = false;
    this.isFirst = true;
    this.yBp = false;
    this.vdg = 0L;
    this.yoY = 0;
    this.ypI = 0;
    this.yoZ = 0;
    this.yoX = 0;
    this.vdM = 0;
    this.yBq = 0L;
    this.ypb = dNJ();
    this.qUY = dNK();
    this.yoK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200342);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(200342);
      }
    };
    this.ypH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200343);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(200343);
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(200343);
        }
      }
    };
    this.mContext = paramContext;
    this.irA = new GestureDetector(this);
    AppMethodBeat.o(200346);
  }
  
  private static void ar(Runnable paramRunnable)
  {
    AppMethodBeat.i(200364);
    try
    {
      ap.aB(paramRunnable);
      ap.n(paramRunnable, 4000L);
      AppMethodBeat.o(200364);
      return;
    }
    catch (Throwable paramRunnable)
    {
      ac.e("LongVideoFullScreenView", paramRunnable.toString());
      AppMethodBeat.o(200364);
    }
  }
  
  private View.OnClickListener dNJ()
  {
    AppMethodBeat.i(200360);
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200339);
        for (;;)
        {
          try
          {
            ac.i("LongVideoFullScreenView", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(LongVideoFullScreenView.h(LongVideoFullScreenView.this).isPlaying()) });
            LongVideoFullScreenView.b(LongVideoFullScreenView.this, true);
            if (LongVideoFullScreenView.h(LongVideoFullScreenView.this).isPlaying())
            {
              LongVideoFullScreenView.n(LongVideoFullScreenView.this);
              if (LongVideoFullScreenView.q(LongVideoFullScreenView.this)) {
                LongVideoFullScreenView.r(LongVideoFullScreenView.this);
              }
              AppMethodBeat.o(200339);
              return;
            }
            if (LongVideoFullScreenView.o(LongVideoFullScreenView.this))
            {
              LongVideoFullScreenView.this.dJV();
              LongVideoFullScreenView.p(LongVideoFullScreenView.this);
            }
            else
            {
              LongVideoFullScreenView.this.dKb();
            }
          }
          catch (Throwable paramAnonymousView)
          {
            ac.e("LongVideoFullScreenView", paramAnonymousView.toString());
            AppMethodBeat.o(200339);
            return;
          }
        }
      }
    };
    AppMethodBeat.o(200360);
    return local3;
  }
  
  private b dNK()
  {
    AppMethodBeat.i(200361);
    b local4 = new b()
    {
      public final void anR()
      {
        AppMethodBeat.i(200340);
        try
        {
          LongVideoFullScreenView.b(LongVideoFullScreenView.this, true);
          AppMethodBeat.o(200340);
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(200340);
        }
      }
      
      public final void nn(int paramAnonymousInt)
      {
        AppMethodBeat.i(200341);
        try
        {
          ac.i("LongVideoFullScreenView", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          LongVideoFullScreenView.a(LongVideoFullScreenView.this, paramAnonymousInt);
          if (LongVideoFullScreenView.o(LongVideoFullScreenView.this)) {
            LongVideoFullScreenView.this.dJV();
          }
          for (;;)
          {
            LongVideoFullScreenView.h(LongVideoFullScreenView.this).c(paramAnonymousInt, true);
            ap.aB(LongVideoFullScreenView.m(LongVideoFullScreenView.this));
            LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(200341);
            return;
            LongVideoFullScreenView.this.dKb();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(200341);
        }
      }
    };
    AppMethodBeat.o(200361);
    return local4;
  }
  
  private void ra(boolean paramBoolean)
  {
    AppMethodBeat.i(200355);
    try
    {
      this.yoF.setIsPlay(paramBoolean);
      this.yoF.getPlayBtn().getLayoutParams().width = this.length;
      this.yoF.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        ac.i("LongVideoFullScreenView", "startPlay");
        this.yoF.getPlayBtn().setImageDrawable(a.l(this.mContext, 2131691470));
        AppMethodBeat.o(200355);
        return;
      }
      ac.i("LongVideoFullScreenView", "pausePlay");
      this.yoF.getPlayBtn().setImageDrawable(a.l(this.mContext, 2131691469));
      AppMethodBeat.o(200355);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(200355);
    }
  }
  
  final void bVK()
  {
    AppMethodBeat.i(200356);
    try
    {
      ac.i("LongVideoFullScreenView", "starting play, downFailed=" + this.yoS);
      boolean bool = this.yoS;
      if (bool) {
        try
        {
          ac.e("LongVideoFullScreenView", "last download fail ,try again");
          if ((this.yoF != null) && (this.yoF.getParent() != null)) {
            ((ViewGroup)this.yoF.getParent()).removeView(this.yoF);
          }
          this.yBh.setFullScreen(true);
          this.yBh.c(false, this.yBl, 0);
          if (this.mContext.getResources().getConfiguration().orientation == 2)
          {
            ac.i("LongVideoFullScreenView", "ORIENTATION_LANDSCAPE");
            dNH();
          }
          for (;;)
          {
            this.yBh.c(0.0D, true);
            this.yBh.dLf();
            AppMethodBeat.o(200356);
            return;
            if (this.mContext.getResources().getConfiguration().orientation == 1)
            {
              ac.i("LongVideoFullScreenView", "ORIENTATION_PORTRAIT");
              dNI();
            }
          }
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200337);
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
                    AppMethodBeat.o(200337);
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
                ac.e("LongVideoFullScreenView", localThrowable.toString());
                AppMethodBeat.o(200337);
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
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).dLf();
                AppMethodBeat.o(200337);
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
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).dLf();
                LongVideoFullScreenView.k(LongVideoFullScreenView.this);
                LongVideoFullScreenView.a(LongVideoFullScreenView.this, System.currentTimeMillis());
                AppMethodBeat.o(200337);
                return;
                label405:
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).c(LongVideoFullScreenView.h(LongVideoFullScreenView.this).getCurrPosSec(), true);
              }
            }
          });
        }
        catch (Throwable localThrowable1)
        {
          ac.e("LongVideoFullScreenView", localThrowable1.toString());
        }
      }
      AppMethodBeat.o(200356);
      return;
    }
    catch (Throwable localThrowable2)
    {
      ac.e("LongVideoFullScreenView", localThrowable2.toString());
      AppMethodBeat.o(200356);
    }
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200354);
    ac.e("LongVideoFullScreenView", "online play error, %s", new Object[] { paramString3 });
    this.yoS = true;
    AppMethodBeat.o(200354);
  }
  
  final void crK()
  {
    AppMethodBeat.i(200357);
    try
    {
      ac.d("LongVideoFullScreenView", "pause play");
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200338);
          try
          {
            LongVideoFullScreenView.h(LongVideoFullScreenView.this).pause();
            LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(0);
            LongVideoFullScreenView.as(LongVideoFullScreenView.m(LongVideoFullScreenView.this));
            LongVideoFullScreenView.a(LongVideoFullScreenView.this, false);
            AppMethodBeat.o(200338);
            return;
          }
          catch (Throwable localThrowable)
          {
            ac.e("LongVideoFullScreenView", localThrowable.toString());
            AppMethodBeat.o(200338);
          }
        }
      });
      if (this.vdg != 0L)
      {
        this.yBq += System.currentTimeMillis() - this.vdg;
        this.vdg = 0L;
        ac.i("LongVideoFullScreenView", "playTimeInterval update");
      }
      AppMethodBeat.o(200357);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(200357);
    }
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dJV()
  {
    AppMethodBeat.i(200358);
    try
    {
      this.yoG.setImageDrawable(a.l(this.mContext, 2131690341));
      this.yBh.setMute(true);
      this.yoO = true;
      AppMethodBeat.o(200358);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(200358);
    }
  }
  
  public final void dKb()
  {
    AppMethodBeat.i(200359);
    try
    {
      this.yoG.setImageDrawable(a.l(this.mContext, 2131690342));
      this.yBh.setMute(false);
      this.yoO = false;
      AppMethodBeat.o(200359);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(200359);
    }
  }
  
  public final void dLd()
  {
    AppMethodBeat.i(200352);
    try
    {
      if (this.yBh.getCurrPosSec() >= this.yBk)
      {
        ac.i("LongVideoFullScreenView", "onLoopCompletion");
        this.yoX += 1;
        this.yBh.c(0.0D, true);
      }
      AppMethodBeat.o(200352);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(200352);
    }
  }
  
  final void dNH()
  {
    AppMethodBeat.i(200347);
    try
    {
      Object localObject = this.yoF.getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.yoF);
      }
      al.aG((Activity)this.mContext);
      localObject = (RelativeLayout.LayoutParams)this.yBf.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)this.yBg.getLayoutParams()).rightMargin = a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.ypE.getLayoutParams()).rightMargin = a.fromDPToPix(this.mContext, 20);
      localObject = new RelativeLayout.LayoutParams(this.kWC - a.fromDPToPix(this.mContext, 232), -2);
      ((ViewGroup)this.yBf).addView(this.yoF, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(200347);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(200347);
    }
  }
  
  final void dNI()
  {
    AppMethodBeat.i(200348);
    try
    {
      Object localObject = this.yoF.getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.yoF);
      }
      al.aG((Activity)this.mContext);
      localObject = (RelativeLayout.LayoutParams)this.yBf.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)this.yBg.getLayoutParams()).rightMargin = a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.ypE.getLayoutParams()).rightMargin = a.fromDPToPix(this.mContext, 10);
      localObject = new RelativeLayout.LayoutParams(this.kWB - a.fromDPToPix(this.mContext, 74), -2);
      ((ViewGroup)this.yBf).addView(this.yoF, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(200348);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(200348);
    }
  }
  
  public final Intent dNL()
  {
    AppMethodBeat.i(200362);
    Intent localIntent = new Intent();
    try
    {
      if ((this.yBh.isPlaying()) && (this.vdg != 0L))
      {
        this.yBq += System.currentTimeMillis() - this.vdg;
        this.vdg = 0L;
        ac.i("LongVideoFullScreenView", "playTimeInterval update");
      }
      localIntent.putExtra("KComponentVideoType", this.hYQ);
      localIntent.putExtra("KComponentCid", this.yBi);
      localIntent.putExtra("KComponentCurrentTime", this.yBh.getCurrPosSec());
      localIntent.putExtra("KComponentVoiceType", this.yoO);
      localIntent.putExtra("KComponentProgressType", this.yBh.isPlaying());
      localIntent.putExtra("KComponentClickPlayControlCount", this.yoY);
      localIntent.putExtra("KComponentDoubleClickCount", this.ypI);
      localIntent.putExtra("KComponentClickVoiceControlCount", this.yoZ);
      localIntent.putExtra("KComponentPlayCompletedCount", this.yoX);
      localIntent.putExtra("KComponentPlayCount", this.vdM);
      localIntent.putExtra("KComponentPlayTimeInterval", this.yBq);
      localIntent.putExtra("KComponentIsWaiting", this.yBn);
      localIntent.putExtra("KComponentSeekTimeDueWaiting", this.yBo);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ac.e("LongVideoFullScreenView", localThrowable.toString());
      }
    }
    AppMethodBeat.o(200362);
    return localIntent;
  }
  
  public final void jdMethod_do(String paramString1, String paramString2)
  {
    this.yoS = false;
  }
  
  public final void dp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(200351);
    try
    {
      this.yoX += 1;
      this.yBh.yqI.stopTimer();
      this.yBh.onUIPause();
      AppMethodBeat.o(200351);
      return;
    }
    catch (Throwable paramString1)
    {
      ac.e("LongVideoFullScreenView", paramString1.toString());
      AppMethodBeat.o(200351);
    }
  }
  
  public final void dq(String paramString1, String paramString2) {}
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(200353);
    try
    {
      ap.aB(this.ypH);
      this.ypF.setVisibility(8);
      ra(true);
      AppMethodBeat.o(200353);
      return;
    }
    catch (Throwable paramString1)
    {
      ac.e("LongVideoFullScreenView", paramString1.toString());
      AppMethodBeat.o(200353);
    }
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    this.yBn = true;
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    this.yBn = false;
    this.yBo = 0;
  }
  
  public final void eJ(String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(200349);
    try
    {
      if (paramView.getId() == 2131304921)
      {
        this.yoZ += 1;
        setFocus(true);
        if (this.yoO)
        {
          dKb();
          AppMethodBeat.o(200349);
          return;
        }
        dJV();
        AppMethodBeat.o(200349);
        return;
      }
    }
    catch (Throwable paramView)
    {
      ac.e("LongVideoFullScreenView", paramView.toString());
      AppMethodBeat.o(200349);
      return;
    }
    if (paramView.getId() == 2131307246)
    {
      ap.aB(this.ypH);
      this.ypF.setVisibility(8);
      ((Activity)this.mContext).finish();
    }
    AppMethodBeat.o(200349);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(200350);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        ac.i("LongVideoFullScreenView", "ORIENTATION_LANDSCAPE");
        dNH();
        AppMethodBeat.o(200350);
        return;
      }
      if (paramConfiguration.orientation == 1)
      {
        ac.i("LongVideoFullScreenView", "ORIENTATION_PORTRAIT");
        dNI();
      }
      AppMethodBeat.o(200350);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      ac.e("LongVideoFullScreenView", paramConfiguration.toString());
      AppMethodBeat.o(200350);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200367);
    for (;;)
    {
      try
      {
        ac.i("LongVideoFullScreenView", "onDoubleTap");
        if (!this.yoS) {
          this.ypI += 1;
        }
        ar(this.yoK);
        if (!this.yBh.isPlaying()) {
          continue;
        }
        crK();
      }
      catch (Throwable paramMotionEvent)
      {
        ac.e("LongVideoFullScreenView", paramMotionEvent.toString());
        continue;
        dKb();
        continue;
      }
      AppMethodBeat.o(200367);
      return false;
      if (!this.yoO) {
        continue;
      }
      dJV();
      bVK();
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
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200366);
    try
    {
      ac.i("LongVideoFullScreenView", "onSingleTapConfirmed");
      if (!this.yoN)
      {
        this.yoN = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(200366);
        return false;
        this.yoN = false;
        setFocus(false);
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        ac.e("LongVideoFullScreenView", paramMotionEvent.toString());
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200365);
    boolean bool = this.irA.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(200365);
    return bool;
  }
  
  void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(200363);
    if (paramBoolean) {}
    try
    {
      this.yoF.setVisibility(0);
      this.yoG.setVisibility(0);
      this.ypE.setVisibility(0);
      ar(this.yoK);
      AppMethodBeat.o(200363);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(200363);
    }
    this.yoN = false;
    this.yoF.setVisibility(4);
    this.yoG.setVisibility(8);
    this.ypE.setVisibility(8);
    ap.aB(this.yoK);
    AppMethodBeat.o(200363);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LongVideoFullScreenView
 * JD-Core Version:    0.7.0.1
 */