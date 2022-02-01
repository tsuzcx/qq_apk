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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;

public class LongVideoFullScreenView
  extends RelativeLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, i.b, i.d
{
  View contentView;
  volatile boolean gEz;
  private GestureDetector iKD;
  volatile boolean isFirst;
  boolean isWaiting;
  int ism;
  boolean lQV;
  int length;
  int ltA;
  int ltB;
  Context mContext;
  com.tencent.mm.plugin.sight.decode.ui.b rFm;
  private long wiC;
  private int wji;
  VideoPlayerSeekBar zFA;
  ImageView zFB;
  Runnable zFF;
  private volatile boolean zFI;
  boolean zFJ;
  private volatile boolean zFN;
  private int zFS;
  private int zFT;
  private int zFU;
  View.OnClickListener zFW;
  ImageView zGG;
  View zGH;
  Runnable zGJ;
  private int zGK;
  int zHq;
  String zSA;
  int zSB;
  private volatile boolean zSC;
  private volatile int zSD;
  volatile boolean zSE;
  private long zSF;
  private com.tencent.mm.plugin.sns.ui.d.a zSG;
  FrameLayout zSt;
  View zSu;
  View zSv;
  AdLandingVideoWrapper zSw;
  String zSx;
  int zSy;
  int zSz;
  volatile boolean zxZ;
  String zzR;
  
  public LongVideoFullScreenView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(198148);
    this.contentView = null;
    this.zSC = false;
    this.zSD = 0;
    this.gEz = true;
    this.zFN = false;
    this.zFI = true;
    this.zxZ = false;
    this.isFirst = true;
    this.zSE = false;
    this.wiC = 0L;
    this.zFT = 0;
    this.zGK = 0;
    this.zFU = 0;
    this.zFS = 0;
    this.wji = 0;
    this.zSF = 0L;
    this.zFW = dZW();
    this.rFm = dZX();
    this.zFF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198146);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(198146);
      }
    };
    this.zGJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198147);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(198147);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(198147);
        }
      }
    };
    this.mContext = paramContext;
    this.iKD = new GestureDetector(this);
    AppMethodBeat.o(198148);
  }
  
  public LongVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(198149);
    this.contentView = null;
    this.zSC = false;
    this.zSD = 0;
    this.gEz = true;
    this.zFN = false;
    this.zFI = true;
    this.zxZ = false;
    this.isFirst = true;
    this.zSE = false;
    this.wiC = 0L;
    this.zFT = 0;
    this.zGK = 0;
    this.zFU = 0;
    this.zFS = 0;
    this.wji = 0;
    this.zSF = 0L;
    this.zFW = dZW();
    this.rFm = dZX();
    this.zFF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198146);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(198146);
      }
    };
    this.zGJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198147);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(198147);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(198147);
        }
      }
    };
    this.mContext = paramContext;
    this.iKD = new GestureDetector(this);
    AppMethodBeat.o(198149);
  }
  
  public LongVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(198150);
    this.contentView = null;
    this.zSC = false;
    this.zSD = 0;
    this.gEz = true;
    this.zFN = false;
    this.zFI = true;
    this.zxZ = false;
    this.isFirst = true;
    this.zSE = false;
    this.wiC = 0L;
    this.zFT = 0;
    this.zGK = 0;
    this.zFU = 0;
    this.zFS = 0;
    this.wji = 0;
    this.zSF = 0L;
    this.zFW = dZW();
    this.rFm = dZX();
    this.zFF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198146);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(198146);
      }
    };
    this.zGJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198147);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(198147);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(198147);
        }
      }
    };
    this.mContext = paramContext;
    this.iKD = new GestureDetector(this);
    AppMethodBeat.o(198150);
  }
  
  private static void aq(Runnable paramRunnable)
  {
    AppMethodBeat.i(198168);
    try
    {
      aq.aA(paramRunnable);
      aq.o(paramRunnable, 4000L);
      AppMethodBeat.o(198168);
      return;
    }
    catch (Throwable paramRunnable)
    {
      ad.e("LongVideoFullScreenView", paramRunnable.toString());
      AppMethodBeat.o(198168);
    }
  }
  
  private View.OnClickListener dZW()
  {
    AppMethodBeat.i(198164);
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198143);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        for (;;)
        {
          try
          {
            ad.i("LongVideoFullScreenView", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(LongVideoFullScreenView.h(LongVideoFullScreenView.this).isPlaying()) });
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
            ad.e("LongVideoFullScreenView", paramAnonymousView.toString());
            continue;
            LongVideoFullScreenView.this.dWn();
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198143);
          return;
          if (!LongVideoFullScreenView.o(LongVideoFullScreenView.this)) {
            continue;
          }
          LongVideoFullScreenView.this.dWl();
          LongVideoFullScreenView.p(LongVideoFullScreenView.this);
        }
      }
    };
    AppMethodBeat.o(198164);
    return local3;
  }
  
  private com.tencent.mm.plugin.sight.decode.ui.b dZX()
  {
    AppMethodBeat.i(198165);
    com.tencent.mm.plugin.sight.decode.ui.b local4 = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqD()
      {
        AppMethodBeat.i(198144);
        try
        {
          LongVideoFullScreenView.b(LongVideoFullScreenView.this, true);
          AppMethodBeat.o(198144);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(198144);
        }
      }
      
      public final void nM(int paramAnonymousInt)
      {
        AppMethodBeat.i(198145);
        try
        {
          ad.i("LongVideoFullScreenView", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          LongVideoFullScreenView.a(LongVideoFullScreenView.this, paramAnonymousInt);
          if (LongVideoFullScreenView.o(LongVideoFullScreenView.this)) {
            LongVideoFullScreenView.this.dWl();
          }
          for (;;)
          {
            LongVideoFullScreenView.h(LongVideoFullScreenView.this).c(paramAnonymousInt, true);
            aq.aA(LongVideoFullScreenView.m(LongVideoFullScreenView.this));
            LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(198145);
            return;
            LongVideoFullScreenView.this.dWn();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(198145);
        }
      }
    };
    AppMethodBeat.o(198165);
    return local4;
  }
  
  private void rE(boolean paramBoolean)
  {
    AppMethodBeat.i(198159);
    try
    {
      this.zFA.setIsPlay(paramBoolean);
      this.zFA.getPlayBtn().getLayoutParams().width = this.length;
      this.zFA.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        ad.i("LongVideoFullScreenView", "startPlay");
        this.zFA.getPlayBtn().setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131691470));
        AppMethodBeat.o(198159);
        return;
      }
      ad.i("LongVideoFullScreenView", "pausePlay");
      this.zFA.getPlayBtn().setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131691469));
      AppMethodBeat.o(198159);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(198159);
    }
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198158);
    ad.e("LongVideoFullScreenView", "online play error, %s", new Object[] { paramString3 });
    this.zFN = true;
    AppMethodBeat.o(198158);
  }
  
  final void can()
  {
    AppMethodBeat.i(198160);
    try
    {
      ad.i("LongVideoFullScreenView", "starting play, downFailed=" + this.zFN);
      boolean bool = this.zFN;
      if (bool) {
        try
        {
          ad.e("LongVideoFullScreenView", "last download fail ,try again");
          if ((this.zFA != null) && (this.zFA.getParent() != null)) {
            ((ViewGroup)this.zFA.getParent()).removeView(this.zFA);
          }
          this.zSw.setFullScreen(true);
          this.zSw.c(false, this.zSA, 0);
          if (this.mContext.getResources().getConfiguration().orientation == 2)
          {
            ad.i("LongVideoFullScreenView", "ORIENTATION_LANDSCAPE");
            dWK();
          }
          for (;;)
          {
            this.zSw.c(0.0D, true);
            this.zSw.dXw();
            AppMethodBeat.o(198160);
            return;
            if (this.mContext.getResources().getConfiguration().orientation == 1)
            {
              ad.i("LongVideoFullScreenView", "ORIENTATION_PORTRAIT");
              dWL();
            }
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198141);
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
                    AppMethodBeat.o(198141);
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
                ad.e("LongVideoFullScreenView", localThrowable.toString());
                AppMethodBeat.o(198141);
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
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).dXw();
                AppMethodBeat.o(198141);
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
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).dXw();
                LongVideoFullScreenView.k(LongVideoFullScreenView.this);
                LongVideoFullScreenView.a(LongVideoFullScreenView.this, System.currentTimeMillis());
                AppMethodBeat.o(198141);
                return;
                label405:
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).c(LongVideoFullScreenView.h(LongVideoFullScreenView.this).getCurrPosSec(), true);
              }
            }
          });
        }
        catch (Throwable localThrowable1)
        {
          ad.e("LongVideoFullScreenView", localThrowable1.toString());
        }
      }
      AppMethodBeat.o(198160);
      return;
    }
    catch (Throwable localThrowable2)
    {
      ad.e("LongVideoFullScreenView", localThrowable2.toString());
      AppMethodBeat.o(198160);
    }
  }
  
  final void cxw()
  {
    AppMethodBeat.i(198161);
    try
    {
      ad.d("LongVideoFullScreenView", "pause play");
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198142);
          try
          {
            LongVideoFullScreenView.h(LongVideoFullScreenView.this).pause();
            LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(0);
            LongVideoFullScreenView.ar(LongVideoFullScreenView.m(LongVideoFullScreenView.this));
            LongVideoFullScreenView.a(LongVideoFullScreenView.this, false);
            AppMethodBeat.o(198142);
            return;
          }
          catch (Throwable localThrowable)
          {
            ad.e("LongVideoFullScreenView", localThrowable.toString());
            AppMethodBeat.o(198142);
          }
        }
      });
      if (this.wiC != 0L)
      {
        this.zSF += System.currentTimeMillis() - this.wiC;
        this.wiC = 0L;
        ad.i("LongVideoFullScreenView", "playTimeInterval update");
      }
      AppMethodBeat.o(198161);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(198161);
    }
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  final void dWK()
  {
    AppMethodBeat.i(198151);
    try
    {
      Object localObject = this.zFA.getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.zFA);
      }
      am.aG((Activity)this.mContext);
      localObject = (RelativeLayout.LayoutParams)this.zSu.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)this.zSv.getLayoutParams()).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.zGG.getLayoutParams()).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 20);
      localObject = new RelativeLayout.LayoutParams(this.ltB - com.tencent.mm.cc.a.fromDPToPix(this.mContext, 232), -2);
      ((ViewGroup)this.zSu).addView(this.zFA, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(198151);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(198151);
    }
  }
  
  final void dWL()
  {
    AppMethodBeat.i(198152);
    try
    {
      Object localObject = this.zFA.getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.zFA);
      }
      am.aG((Activity)this.mContext);
      localObject = (RelativeLayout.LayoutParams)this.zSu.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)this.zSv.getLayoutParams()).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.zGG.getLayoutParams()).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 10);
      localObject = new RelativeLayout.LayoutParams(this.ltA - com.tencent.mm.cc.a.fromDPToPix(this.mContext, 74), -2);
      ((ViewGroup)this.zSu).addView(this.zFA, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(198152);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(198152);
    }
  }
  
  public final void dWl()
  {
    AppMethodBeat.i(198162);
    try
    {
      this.zFB.setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131690341));
      this.zSw.setMute(true);
      this.zFJ = true;
      AppMethodBeat.o(198162);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(198162);
    }
  }
  
  public final void dWn()
  {
    AppMethodBeat.i(198163);
    try
    {
      this.zFB.setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131690342));
      this.zSw.setMute(false);
      this.zFJ = false;
      AppMethodBeat.o(198163);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(198163);
    }
  }
  
  public final void dXu()
  {
    AppMethodBeat.i(198156);
    try
    {
      if (this.zSw.getCurrPosSec() >= this.zSz)
      {
        ad.i("LongVideoFullScreenView", "onLoopCompletion");
        this.zFS += 1;
        this.zSw.c(0.0D, true);
      }
      AppMethodBeat.o(198156);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(198156);
    }
  }
  
  public final Intent dZY()
  {
    AppMethodBeat.i(198166);
    Intent localIntent = new Intent();
    try
    {
      if ((this.zSw.isPlaying()) && (this.wiC != 0L))
      {
        this.zSF += System.currentTimeMillis() - this.wiC;
        this.wiC = 0L;
        ad.i("LongVideoFullScreenView", "playTimeInterval update");
      }
      localIntent.putExtra("KComponentVideoType", this.ism);
      localIntent.putExtra("KComponentCid", this.zSx);
      localIntent.putExtra("KComponentCurrentTime", this.zSw.getCurrPosSec());
      localIntent.putExtra("KComponentVoiceType", this.zFJ);
      localIntent.putExtra("KComponentProgressType", this.zSw.isPlaying());
      localIntent.putExtra("KComponentClickPlayControlCount", this.zFT);
      localIntent.putExtra("KComponentDoubleClickCount", this.zGK);
      localIntent.putExtra("KComponentClickVoiceControlCount", this.zFU);
      localIntent.putExtra("KComponentPlayCompletedCount", this.zFS);
      localIntent.putExtra("KComponentPlayCount", this.wji);
      localIntent.putExtra("KComponentPlayTimeInterval", this.zSF);
      localIntent.putExtra("KComponentIsWaiting", this.zSC);
      localIntent.putExtra("KComponentSeekTimeDueWaiting", this.zSD);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.e("LongVideoFullScreenView", localThrowable.toString());
      }
    }
    AppMethodBeat.o(198166);
    return localIntent;
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    this.zFN = false;
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198155);
    try
    {
      this.zFS += 1;
      this.zSw.zHS.stopTimer();
      this.zSw.onUIPause();
      AppMethodBeat.o(198155);
      return;
    }
    catch (Throwable paramString1)
    {
      ad.e("LongVideoFullScreenView", paramString1.toString());
      AppMethodBeat.o(198155);
    }
  }
  
  public final void ds(String paramString1, String paramString2) {}
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198157);
    try
    {
      aq.aA(this.zGJ);
      this.zGH.setVisibility(8);
      rE(true);
      AppMethodBeat.o(198157);
      return;
    }
    catch (Throwable paramString1)
    {
      ad.e("LongVideoFullScreenView", paramString1.toString());
      AppMethodBeat.o(198157);
    }
  }
  
  public final void du(String paramString1, String paramString2)
  {
    this.zSC = true;
  }
  
  public final void dv(String paramString1, String paramString2)
  {
    this.zSC = false;
    this.zSD = 0;
  }
  
  public final void eT(String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(198153);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    try
    {
      if (paramView.getId() == 2131304921)
      {
        this.zFU += 1;
        setFocus(true);
        if (this.zFJ) {
          dWn();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198153);
          return;
          dWl();
        }
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        ad.e("LongVideoFullScreenView", paramView.toString());
        continue;
        if (paramView.getId() == 2131307246)
        {
          aq.aA(this.zGJ);
          this.zGH.setVisibility(8);
          ((Activity)this.mContext).finish();
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(198154);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        ad.i("LongVideoFullScreenView", "ORIENTATION_LANDSCAPE");
        dWK();
        AppMethodBeat.o(198154);
        return;
      }
      if (paramConfiguration.orientation == 1)
      {
        ad.i("LongVideoFullScreenView", "ORIENTATION_PORTRAIT");
        dWL();
      }
      AppMethodBeat.o(198154);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      ad.e("LongVideoFullScreenView", paramConfiguration.toString());
      AppMethodBeat.o(198154);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198171);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    for (;;)
    {
      try
      {
        ad.i("LongVideoFullScreenView", "onDoubleTap");
        if (!this.zFN) {
          this.zGK += 1;
        }
        aq(this.zFF);
        if (!this.zSw.isPlaying()) {
          continue;
        }
        cxw();
      }
      catch (Throwable paramMotionEvent)
      {
        ad.e("LongVideoFullScreenView", paramMotionEvent.toString());
        continue;
        dWn();
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(198171);
      return false;
      if (!this.zFJ) {
        continue;
      }
      dWl();
      can();
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
    AppMethodBeat.i(198173);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(198173);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198170);
    try
    {
      ad.i("LongVideoFullScreenView", "onSingleTapConfirmed");
      if (!this.zFI)
      {
        this.zFI = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(198170);
        return false;
        this.zFI = false;
        setFocus(false);
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        ad.e("LongVideoFullScreenView", paramMotionEvent.toString());
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198172);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(198172);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198169);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    paramView = this.iKD;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.ahp(), "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.mq(0)), "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(198169);
    return bool;
  }
  
  void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(198167);
    if (paramBoolean) {}
    try
    {
      if (this.zSG != null) {
        this.zSG.rY(true);
      }
      this.zFA.setVisibility(0);
      this.zFB.setVisibility(0);
      this.zGG.setVisibility(0);
      aq(this.zFF);
      AppMethodBeat.o(198167);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(198167);
    }
    this.zFI = false;
    this.zFA.setVisibility(4);
    this.zFB.setVisibility(8);
    this.zGG.setVisibility(8);
    aq.aA(this.zFF);
    if (this.zSG != null) {
      this.zSG.rY(false);
    }
    AppMethodBeat.o(198167);
    return;
  }
  
  public void setProgressBarStatusListener(com.tencent.mm.plugin.sns.ui.d.a parama)
  {
    this.zSG = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LongVideoFullScreenView
 * JD-Core Version:    0.7.0.1
 */