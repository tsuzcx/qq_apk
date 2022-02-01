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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;

public class LongVideoFullScreenView
  extends RelativeLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, h.b, h.d
{
  View contentView;
  volatile boolean ggj;
  private GestureDetector hRv;
  int hyp;
  volatile boolean isFirst;
  boolean isWaiting;
  boolean kQm;
  int kvn;
  int kvo;
  int length;
  Context mContext;
  b qmw;
  private long tUy;
  private int tVe;
  volatile boolean wVd;
  String wWv;
  VideoPlayerSeekBar xbQ;
  ImageView xbR;
  Runnable xbV;
  private volatile boolean xbY;
  boolean xbZ;
  ImageView xcQ;
  View xcR;
  Runnable xcT;
  private int xcU;
  private volatile boolean xce;
  private int xcj;
  private int xck;
  private int xcl;
  View.OnClickListener xcn;
  int xdt;
  FrameLayout xon;
  View xoo;
  View xop;
  AdLandingVideoWrapper xoq;
  String xor;
  int xos;
  int xot;
  String xou;
  int xov;
  private volatile boolean xow;
  private volatile int xox;
  volatile boolean xoy;
  private long xoz;
  
  public LongVideoFullScreenView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(187538);
    this.contentView = null;
    this.xow = false;
    this.xox = 0;
    this.ggj = true;
    this.xce = false;
    this.xbY = true;
    this.wVd = false;
    this.isFirst = true;
    this.xoy = false;
    this.tUy = 0L;
    this.xck = 0;
    this.xcU = 0;
    this.xcl = 0;
    this.xcj = 0;
    this.tVe = 0;
    this.xoz = 0L;
    this.xcn = dzm();
    this.qmw = dzn();
    this.xbV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187536);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(187536);
      }
    };
    this.xcT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187537);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(187537);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(187537);
        }
      }
    };
    this.mContext = paramContext;
    this.hRv = new GestureDetector(this);
    AppMethodBeat.o(187538);
  }
  
  public LongVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(187539);
    this.contentView = null;
    this.xow = false;
    this.xox = 0;
    this.ggj = true;
    this.xce = false;
    this.xbY = true;
    this.wVd = false;
    this.isFirst = true;
    this.xoy = false;
    this.tUy = 0L;
    this.xck = 0;
    this.xcU = 0;
    this.xcl = 0;
    this.xcj = 0;
    this.tVe = 0;
    this.xoz = 0L;
    this.xcn = dzm();
    this.qmw = dzn();
    this.xbV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187536);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(187536);
      }
    };
    this.xcT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187537);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(187537);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(187537);
        }
      }
    };
    this.mContext = paramContext;
    this.hRv = new GestureDetector(this);
    AppMethodBeat.o(187539);
  }
  
  public LongVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(187540);
    this.contentView = null;
    this.xow = false;
    this.xox = 0;
    this.ggj = true;
    this.xce = false;
    this.xbY = true;
    this.wVd = false;
    this.isFirst = true;
    this.xoy = false;
    this.tUy = 0L;
    this.xck = 0;
    this.xcU = 0;
    this.xcl = 0;
    this.xcj = 0;
    this.tVe = 0;
    this.xoz = 0L;
    this.xcn = dzm();
    this.qmw = dzn();
    this.xbV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187536);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(187536);
      }
    };
    this.xcT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187537);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(187537);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(187537);
        }
      }
    };
    this.mContext = paramContext;
    this.hRv = new GestureDetector(this);
    AppMethodBeat.o(187540);
  }
  
  private static void ap(Runnable paramRunnable)
  {
    AppMethodBeat.i(187558);
    try
    {
      aq.az(paramRunnable);
      aq.n(paramRunnable, 4000L);
      AppMethodBeat.o(187558);
      return;
    }
    catch (Throwable paramRunnable)
    {
      ad.e("LongVideoFullScreenView", paramRunnable.toString());
      AppMethodBeat.o(187558);
    }
  }
  
  private View.OnClickListener dzm()
  {
    AppMethodBeat.i(187554);
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187533);
        for (;;)
        {
          try
          {
            ad.i("LongVideoFullScreenView", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(LongVideoFullScreenView.h(LongVideoFullScreenView.this).isPlaying()) });
            LongVideoFullScreenView.b(LongVideoFullScreenView.this, true);
            if (LongVideoFullScreenView.h(LongVideoFullScreenView.this).isPlaying())
            {
              LongVideoFullScreenView.n(LongVideoFullScreenView.this);
              if (LongVideoFullScreenView.q(LongVideoFullScreenView.this)) {
                LongVideoFullScreenView.r(LongVideoFullScreenView.this);
              }
              AppMethodBeat.o(187533);
              return;
            }
            if (LongVideoFullScreenView.o(LongVideoFullScreenView.this))
            {
              LongVideoFullScreenView.this.dvw();
              LongVideoFullScreenView.p(LongVideoFullScreenView.this);
            }
            else
            {
              LongVideoFullScreenView.this.dvC();
            }
          }
          catch (Throwable paramAnonymousView)
          {
            ad.e("LongVideoFullScreenView", paramAnonymousView.toString());
            AppMethodBeat.o(187533);
            return;
          }
        }
      }
    };
    AppMethodBeat.o(187554);
    return local3;
  }
  
  private b dzn()
  {
    AppMethodBeat.i(187555);
    b local4 = new b()
    {
      public final void bcv()
      {
        AppMethodBeat.i(187534);
        try
        {
          LongVideoFullScreenView.b(LongVideoFullScreenView.this, true);
          AppMethodBeat.o(187534);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(187534);
        }
      }
      
      public final void rZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(187535);
        try
        {
          ad.i("LongVideoFullScreenView", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          LongVideoFullScreenView.a(LongVideoFullScreenView.this, paramAnonymousInt);
          if (LongVideoFullScreenView.o(LongVideoFullScreenView.this)) {
            LongVideoFullScreenView.this.dvw();
          }
          for (;;)
          {
            LongVideoFullScreenView.h(LongVideoFullScreenView.this).c(paramAnonymousInt, true);
            aq.az(LongVideoFullScreenView.m(LongVideoFullScreenView.this));
            LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(187535);
            return;
            LongVideoFullScreenView.this.dvC();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("LongVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(187535);
        }
      }
    };
    AppMethodBeat.o(187555);
    return local4;
  }
  
  private void qb(boolean paramBoolean)
  {
    AppMethodBeat.i(187549);
    try
    {
      this.xbQ.setIsPlay(paramBoolean);
      this.xbQ.getPlayBtn().getLayoutParams().width = this.length;
      this.xbQ.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        ad.i("LongVideoFullScreenView", "startPlay");
        this.xbQ.getPlayBtn().setImageDrawable(a.l(this.mContext, 2131691470));
        AppMethodBeat.o(187549);
        return;
      }
      ad.i("LongVideoFullScreenView", "pausePlay");
      this.xbQ.getPlayBtn().setImageDrawable(a.l(this.mContext, 2131691469));
      AppMethodBeat.o(187549);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(187549);
    }
  }
  
  final void bOu()
  {
    AppMethodBeat.i(187550);
    try
    {
      ad.i("LongVideoFullScreenView", "starting play, downFailed=" + this.xce);
      boolean bool = this.xce;
      if (bool) {
        try
        {
          ad.e("LongVideoFullScreenView", "last download fail ,try again");
          if ((this.xbQ != null) && (this.xbQ.getParent() != null)) {
            ((ViewGroup)this.xbQ.getParent()).removeView(this.xbQ);
          }
          this.xoq.setFullScreen(true);
          this.xoq.c(false, this.xou, 0);
          if (this.mContext.getResources().getConfiguration().orientation == 2)
          {
            ad.i("LongVideoFullScreenView", "ORIENTATION_LANDSCAPE");
            dzk();
          }
          for (;;)
          {
            this.xoq.c(0.0D, true);
            this.xoq.dwG();
            AppMethodBeat.o(187550);
            return;
            if (this.mContext.getResources().getConfiguration().orientation == 1)
            {
              ad.i("LongVideoFullScreenView", "ORIENTATION_PORTRAIT");
              dzl();
            }
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187531);
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
                    AppMethodBeat.o(187531);
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
                AppMethodBeat.o(187531);
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
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).dwG();
                AppMethodBeat.o(187531);
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
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).dwG();
                LongVideoFullScreenView.k(LongVideoFullScreenView.this);
                LongVideoFullScreenView.a(LongVideoFullScreenView.this, System.currentTimeMillis());
                AppMethodBeat.o(187531);
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
      AppMethodBeat.o(187550);
      return;
    }
    catch (Throwable localThrowable2)
    {
      ad.e("LongVideoFullScreenView", localThrowable2.toString());
      AppMethodBeat.o(187550);
    }
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187548);
    ad.e("LongVideoFullScreenView", "online play error, %s", new Object[] { paramString3 });
    this.xce = true;
    AppMethodBeat.o(187548);
  }
  
  final void ckd()
  {
    AppMethodBeat.i(187551);
    try
    {
      ad.d("LongVideoFullScreenView", "pause play");
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187532);
          try
          {
            LongVideoFullScreenView.h(LongVideoFullScreenView.this).pause();
            LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(0);
            LongVideoFullScreenView.aq(LongVideoFullScreenView.m(LongVideoFullScreenView.this));
            LongVideoFullScreenView.a(LongVideoFullScreenView.this, false);
            AppMethodBeat.o(187532);
            return;
          }
          catch (Throwable localThrowable)
          {
            ad.e("LongVideoFullScreenView", localThrowable.toString());
            AppMethodBeat.o(187532);
          }
        }
      });
      if (this.tUy != 0L)
      {
        this.xoz += System.currentTimeMillis() - this.tUy;
        this.tUy = 0L;
        ad.i("LongVideoFullScreenView", "playTimeInterval update");
      }
      AppMethodBeat.o(187551);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(187551);
    }
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void db(String paramString1, String paramString2)
  {
    this.xce = false;
  }
  
  public final void dc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187545);
    try
    {
      this.xcj += 1;
      this.xoq.xdT.stopTimer();
      this.xoq.onUIPause();
      AppMethodBeat.o(187545);
      return;
    }
    catch (Throwable paramString1)
    {
      ad.e("LongVideoFullScreenView", paramString1.toString());
      AppMethodBeat.o(187545);
    }
  }
  
  public final void dd(String paramString1, String paramString2) {}
  
  public final void de(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187547);
    try
    {
      aq.az(this.xcT);
      this.xcR.setVisibility(8);
      qb(true);
      AppMethodBeat.o(187547);
      return;
    }
    catch (Throwable paramString1)
    {
      ad.e("LongVideoFullScreenView", paramString1.toString());
      AppMethodBeat.o(187547);
    }
  }
  
  public final void dg(String paramString1, String paramString2)
  {
    this.xow = true;
  }
  
  public final void dh(String paramString1, String paramString2)
  {
    this.xow = false;
    this.xox = 0;
  }
  
  public final void dvC()
  {
    AppMethodBeat.i(187553);
    try
    {
      this.xbR.setImageDrawable(a.l(this.mContext, 2131690342));
      this.xoq.setMute(false);
      this.xbZ = false;
      AppMethodBeat.o(187553);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(187553);
    }
  }
  
  public final void dvw()
  {
    AppMethodBeat.i(187552);
    try
    {
      this.xbR.setImageDrawable(a.l(this.mContext, 2131690341));
      this.xoq.setMute(true);
      this.xbZ = true;
      AppMethodBeat.o(187552);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(187552);
    }
  }
  
  public final void dwE()
  {
    AppMethodBeat.i(187546);
    try
    {
      if (this.xoq.getCurrPosSec() >= this.xot)
      {
        ad.i("LongVideoFullScreenView", "onLoopCompletion");
        this.xcj += 1;
        this.xoq.c(0.0D, true);
      }
      AppMethodBeat.o(187546);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(187546);
    }
  }
  
  final void dzk()
  {
    AppMethodBeat.i(187541);
    try
    {
      Object localObject = this.xbQ.getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.xbQ);
      }
      al.aC((Activity)this.mContext);
      localObject = (RelativeLayout.LayoutParams)this.xoo.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)this.xop.getLayoutParams()).rightMargin = a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.xcQ.getLayoutParams()).rightMargin = a.fromDPToPix(this.mContext, 20);
      localObject = new RelativeLayout.LayoutParams(this.kvo - a.fromDPToPix(this.mContext, 232), -2);
      ((ViewGroup)this.xoo).addView(this.xbQ, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(187541);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(187541);
    }
  }
  
  final void dzl()
  {
    AppMethodBeat.i(187542);
    try
    {
      Object localObject = this.xbQ.getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.xbQ);
      }
      al.aC((Activity)this.mContext);
      localObject = (RelativeLayout.LayoutParams)this.xoo.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)this.xop.getLayoutParams()).rightMargin = a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.xcQ.getLayoutParams()).rightMargin = a.fromDPToPix(this.mContext, 10);
      localObject = new RelativeLayout.LayoutParams(this.kvn - a.fromDPToPix(this.mContext, 74), -2);
      ((ViewGroup)this.xoo).addView(this.xbQ, (ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(187542);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(187542);
    }
  }
  
  public final Intent dzo()
  {
    AppMethodBeat.i(187556);
    Intent localIntent = new Intent();
    try
    {
      if ((this.xoq.isPlaying()) && (this.tUy != 0L))
      {
        this.xoz += System.currentTimeMillis() - this.tUy;
        this.tUy = 0L;
        ad.i("LongVideoFullScreenView", "playTimeInterval update");
      }
      localIntent.putExtra("KComponentVideoType", this.hyp);
      localIntent.putExtra("KComponentCid", this.xor);
      localIntent.putExtra("KComponentCurrentTime", this.xoq.getCurrPosSec());
      localIntent.putExtra("KComponentVoiceType", this.xbZ);
      localIntent.putExtra("KComponentProgressType", this.xoq.isPlaying());
      localIntent.putExtra("KComponentClickPlayControlCount", this.xck);
      localIntent.putExtra("KComponentDoubleClickCount", this.xcU);
      localIntent.putExtra("KComponentClickVoiceControlCount", this.xcl);
      localIntent.putExtra("KComponentPlayCompletedCount", this.xcj);
      localIntent.putExtra("KComponentPlayCount", this.tVe);
      localIntent.putExtra("KComponentPlayTimeInterval", this.xoz);
      localIntent.putExtra("KComponentIsWaiting", this.xow);
      localIntent.putExtra("KComponentSeekTimeDueWaiting", this.xox);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.e("LongVideoFullScreenView", localThrowable.toString());
      }
    }
    AppMethodBeat.o(187556);
    return localIntent;
  }
  
  public final void jw(String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(187543);
    try
    {
      if (paramView.getId() == 2131304921)
      {
        this.xcl += 1;
        setFocus(true);
        if (this.xbZ)
        {
          dvC();
          AppMethodBeat.o(187543);
          return;
        }
        dvw();
        AppMethodBeat.o(187543);
        return;
      }
    }
    catch (Throwable paramView)
    {
      ad.e("LongVideoFullScreenView", paramView.toString());
      AppMethodBeat.o(187543);
      return;
    }
    if (paramView.getId() == 2131307246)
    {
      aq.az(this.xcT);
      this.xcR.setVisibility(8);
      ((Activity)this.mContext).finish();
    }
    AppMethodBeat.o(187543);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(187544);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        ad.i("LongVideoFullScreenView", "ORIENTATION_LANDSCAPE");
        dzk();
        AppMethodBeat.o(187544);
        return;
      }
      if (paramConfiguration.orientation == 1)
      {
        ad.i("LongVideoFullScreenView", "ORIENTATION_PORTRAIT");
        dzl();
      }
      AppMethodBeat.o(187544);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      ad.e("LongVideoFullScreenView", paramConfiguration.toString());
      AppMethodBeat.o(187544);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187561);
    for (;;)
    {
      try
      {
        ad.i("LongVideoFullScreenView", "onDoubleTap");
        if (!this.xce) {
          this.xcU += 1;
        }
        ap(this.xbV);
        if (!this.xoq.isPlaying()) {
          continue;
        }
        ckd();
      }
      catch (Throwable paramMotionEvent)
      {
        ad.e("LongVideoFullScreenView", paramMotionEvent.toString());
        continue;
        dvC();
        continue;
      }
      AppMethodBeat.o(187561);
      return false;
      if (!this.xbZ) {
        continue;
      }
      dvw();
      bOu();
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
    AppMethodBeat.i(187560);
    try
    {
      ad.i("LongVideoFullScreenView", "onSingleTapConfirmed");
      if (!this.xbY)
      {
        this.xbY = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(187560);
        return false;
        this.xbY = false;
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
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187559);
    boolean bool = this.hRv.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(187559);
    return bool;
  }
  
  void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(187557);
    if (paramBoolean) {}
    try
    {
      this.xbQ.setVisibility(0);
      this.xbR.setVisibility(0);
      this.xcQ.setVisibility(0);
      ap(this.xbV);
      AppMethodBeat.o(187557);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("LongVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(187557);
    }
    this.xbY = false;
    this.xbQ.setVisibility(4);
    this.xbR.setVisibility(8);
    this.xcQ.setVisibility(8);
    aq.az(this.xbV);
    AppMethodBeat.o(187557);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LongVideoFullScreenView
 * JD-Core Version:    0.7.0.1
 */