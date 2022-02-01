package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vfs.i;

public class SightVideoFullScreenView
  extends RelativeLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener
{
  View contentView;
  volatile boolean csX;
  private GestureDetector hRv;
  int hyp;
  volatile boolean isFirst;
  private String jLZ;
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
  private volatile boolean xcP;
  ImageView xcQ;
  View xcR;
  Runnable xcT;
  private int xcU;
  private volatile boolean xce;
  private int xcj;
  private int xck;
  private int xcl;
  View.OnClickListener xcn;
  FrameLayout xon;
  View xoo;
  View xop;
  String xor;
  int xos;
  int xot;
  String xou;
  volatile boolean xoy;
  private long xoz;
  OfflineVideoView xsi;
  
  public SightVideoFullScreenView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(187607);
    this.contentView = null;
    this.xce = false;
    this.xcP = false;
    this.csX = true;
    this.xbY = true;
    this.wVd = false;
    this.isFirst = true;
    this.xoy = false;
    this.xcn = dzm();
    this.qmw = dzn();
    this.tUy = 0L;
    this.xck = 0;
    this.xcU = 0;
    this.xcl = 0;
    this.xcj = 0;
    this.tVe = 0;
    this.xoz = 0L;
    this.xbV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187605);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(187605);
      }
    };
    this.xcT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187606);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(187606);
      }
    };
    this.mContext = paramContext;
    this.hRv = new GestureDetector(this);
    AppMethodBeat.o(187607);
  }
  
  public SightVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(187608);
    this.contentView = null;
    this.xce = false;
    this.xcP = false;
    this.csX = true;
    this.xbY = true;
    this.wVd = false;
    this.isFirst = true;
    this.xoy = false;
    this.xcn = dzm();
    this.qmw = dzn();
    this.tUy = 0L;
    this.xck = 0;
    this.xcU = 0;
    this.xcl = 0;
    this.xcj = 0;
    this.tVe = 0;
    this.xoz = 0L;
    this.xbV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187605);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(187605);
      }
    };
    this.xcT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187606);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(187606);
      }
    };
    this.mContext = paramContext;
    this.hRv = new GestureDetector(this);
    AppMethodBeat.o(187608);
  }
  
  public SightVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(187609);
    this.contentView = null;
    this.xce = false;
    this.xcP = false;
    this.csX = true;
    this.xbY = true;
    this.wVd = false;
    this.isFirst = true;
    this.xoy = false;
    this.xcn = dzm();
    this.qmw = dzn();
    this.tUy = 0L;
    this.xck = 0;
    this.xcU = 0;
    this.xcl = 0;
    this.xcj = 0;
    this.tVe = 0;
    this.xoz = 0L;
    this.xbV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187605);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(187605);
      }
    };
    this.xcT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187606);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(187606);
      }
    };
    this.mContext = paramContext;
    this.hRv = new GestureDetector(this);
    AppMethodBeat.o(187609);
  }
  
  private static void ap(Runnable paramRunnable)
  {
    AppMethodBeat.i(187623);
    try
    {
      aq.az(paramRunnable);
      aq.n(paramRunnable, 4000L);
      AppMethodBeat.o(187623);
      return;
    }
    catch (Throwable paramRunnable)
    {
      ad.e("SightVideoFullScreenView", paramRunnable.toString());
      AppMethodBeat.o(187623);
    }
  }
  
  private View.OnClickListener dzm()
  {
    AppMethodBeat.i(187617);
    View.OnClickListener local6 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187602);
        for (;;)
        {
          try
          {
            SightVideoFullScreenView.c(SightVideoFullScreenView.this, true);
            if (SightVideoFullScreenView.a(SightVideoFullScreenView.this).isPlaying())
            {
              SightVideoFullScreenView.p(SightVideoFullScreenView.this);
              if (SightVideoFullScreenView.q(SightVideoFullScreenView.this)) {
                SightVideoFullScreenView.r(SightVideoFullScreenView.this);
              }
              AppMethodBeat.o(187602);
              return;
            }
            if (SightVideoFullScreenView.l(SightVideoFullScreenView.this))
            {
              SightVideoFullScreenView.this.dvw();
              SightVideoFullScreenView.this.dAd();
            }
            else
            {
              SightVideoFullScreenView.this.dvC();
            }
          }
          catch (Throwable paramAnonymousView)
          {
            ad.e("SightVideoFullScreenView", paramAnonymousView.toString());
            AppMethodBeat.o(187602);
            return;
          }
        }
      }
    };
    AppMethodBeat.o(187617);
    return local6;
  }
  
  private b dzn()
  {
    AppMethodBeat.i(187618);
    b local7 = new b()
    {
      public final void bcv()
      {
        AppMethodBeat.i(187603);
        try
        {
          if (SightVideoFullScreenView.a(SightVideoFullScreenView.this) != null) {
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).dzv();
          }
          SightVideoFullScreenView.c(SightVideoFullScreenView.this, true);
          AppMethodBeat.o(187603);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(187603);
        }
      }
      
      public final void rZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(187604);
        try
        {
          ad.i("SightVideoFullScreenView", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          if (SightVideoFullScreenView.l(SightVideoFullScreenView.this)) {
            SightVideoFullScreenView.this.dvw();
          }
          for (;;)
          {
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).au(paramAnonymousInt * 1000, true);
            SightVideoFullScreenView.b(SightVideoFullScreenView.this, true);
            aq.az(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
            SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(187604);
            return;
            SightVideoFullScreenView.this.dvC();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(187604);
        }
      }
    };
    AppMethodBeat.o(187618);
    return local7;
  }
  
  public final void dAd()
  {
    AppMethodBeat.i(187615);
    try
    {
      if (this.xce)
      {
        ad.e("SightVideoFullScreenView", "last download fail, try again");
        this.xsi.ckc();
        AppMethodBeat.o(187615);
        return;
      }
      if ((!this.xcP) && (!TextUtils.isEmpty(this.jLZ)))
      {
        this.xsi.YI(this.jLZ);
        this.xcP = true;
      }
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187600);
          try
          {
            ad.i("SightVideoFullScreenView", "sightVideoStartPlay");
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).start();
            SightVideoFullScreenView.b(SightVideoFullScreenView.this, true);
            aq.az(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
            SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(187600);
            return;
          }
          catch (Throwable localThrowable)
          {
            ad.e("SightVideoFullScreenView", localThrowable.toString());
            AppMethodBeat.o(187600);
          }
        }
      });
      this.tUy = System.currentTimeMillis();
      this.tVe += 1;
      AppMethodBeat.o(187615);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(187615);
    }
  }
  
  final void dAe()
  {
    AppMethodBeat.i(187616);
    ad.d("SightVideoFullScreenView", "pause play");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187601);
        try
        {
          ad.i("SightVideoFullScreenView", "sightVideoPausePlay");
          SightVideoFullScreenView.a(SightVideoFullScreenView.this).dzv();
          SightVideoFullScreenView.b(SightVideoFullScreenView.this, false);
          SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(0);
          SightVideoFullScreenView.ar(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
          AppMethodBeat.o(187601);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(187601);
        }
      }
    });
    if (this.tUy != 0L)
    {
      this.xoz += System.currentTimeMillis() - this.tUy;
      this.tUy = 0L;
      ad.i("SightVideoFullScreenView", "playTimeInterval update");
    }
    AppMethodBeat.o(187616);
  }
  
  public final Intent dAf()
  {
    AppMethodBeat.i(187619);
    Intent localIntent = new Intent();
    try
    {
      if ((this.xsi.isPlaying()) && (this.tUy != 0L))
      {
        this.xoz += System.currentTimeMillis() - this.tUy;
        this.tUy = 0L;
        ad.i("SightVideoFullScreenView", "playTimeInterval update");
      }
      localIntent.putExtra("KComponentVideoType", this.hyp);
      localIntent.putExtra("KComponentCid", this.xor);
      localIntent.putExtra("KComponentCurrentTime", this.xsi.getCurrentPositionMs());
      localIntent.putExtra("KComponentVoiceType", this.xbZ);
      localIntent.putExtra("KComponentProgressType", this.xsi.isPlaying());
      localIntent.putExtra("KComponentClickPlayControlCount", this.xck);
      localIntent.putExtra("KComponentDoubleClickCount", this.xcU);
      localIntent.putExtra("KComponentClickVoiceControlCount", this.xcl);
      localIntent.putExtra("KComponentPlayCompletedCount", this.xcj);
      localIntent.putExtra("KComponentPlayCount", this.tVe);
      localIntent.putExtra("KComponentPlayTimeInterval", this.xoz);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.e("SightVideoFullScreenView", localThrowable.toString());
      }
    }
    AppMethodBeat.o(187619);
    return localIntent;
  }
  
  public final void dvC()
  {
    AppMethodBeat.i(187613);
    try
    {
      this.xbR.setImageDrawable(a.l(this.mContext, 2131690342));
      this.xsi.setMute(false);
      this.xbZ = false;
      AppMethodBeat.o(187613);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(187613);
    }
  }
  
  public final void dvw()
  {
    AppMethodBeat.i(187612);
    try
    {
      this.xbR.setImageDrawable(a.l(this.mContext, 2131690341));
      this.xsi.setMute(true);
      this.xbZ = true;
      AppMethodBeat.o(187612);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(187612);
    }
  }
  
  final void dzk()
  {
    AppMethodBeat.i(187610);
    try
    {
      al.aC((Activity)this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.xoo.getLayoutParams();
      localLayoutParams.leftMargin = a.fromDPToPix(this.mContext, 64);
      localLayoutParams.rightMargin = a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)this.xop.getLayoutParams()).rightMargin = a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.xcQ.getLayoutParams()).rightMargin = a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.xbQ.getLayoutParams()).width = (this.kvo - a.fromDPToPix(this.mContext, 232));
      AppMethodBeat.o(187610);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(187610);
    }
  }
  
  final void dzl()
  {
    AppMethodBeat.i(187611);
    try
    {
      al.aC((Activity)this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.xoo.getLayoutParams();
      localLayoutParams.leftMargin = a.fromDPToPix(this.mContext, 0);
      localLayoutParams.rightMargin = a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)this.xop.getLayoutParams()).rightMargin = a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.xcQ.getLayoutParams()).rightMargin = a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.xbQ.getLayoutParams()).width = (this.kvn - a.fromDPToPix(this.mContext, 74));
      AppMethodBeat.o(187611);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(187611);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(187620);
    try
    {
      if (paramView.getId() == 2131304921)
      {
        this.xcl += 1;
        setFocus(true);
        if (this.xbZ)
        {
          dvC();
          AppMethodBeat.o(187620);
          return;
        }
        dvw();
        AppMethodBeat.o(187620);
        return;
      }
    }
    catch (Throwable paramView)
    {
      ad.e("SightVideoFullScreenView", paramView.toString());
      AppMethodBeat.o(187620);
      return;
    }
    if (paramView.getId() == 2131307246)
    {
      aq.az(this.xcT);
      this.xcR.setVisibility(8);
      ((Activity)this.mContext).finish();
    }
    AppMethodBeat.o(187620);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(187621);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        ad.i("SightVideoFullScreenView", "ORIENTATION_LANDSCAPE");
        dzk();
        AppMethodBeat.o(187621);
        return;
      }
      if (paramConfiguration.orientation == 1)
      {
        ad.i("SightVideoFullScreenView", "ORIENTATION_PORTRAIT");
        dzl();
      }
      AppMethodBeat.o(187621);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      ad.e("SightVideoFullScreenView", paramConfiguration.toString());
      AppMethodBeat.o(187621);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187626);
    try
    {
      ad.i("SightVideoFullScreenView", "onDoubleTap");
      this.xcU += 1;
      ap(this.xbV);
      if (this.xsi.isPlaying()) {
        dAe();
      }
      for (;;)
      {
        AppMethodBeat.o(187626);
        return false;
        if (!this.xbZ) {
          break;
        }
        dvw();
        dAd();
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        ad.e("SightVideoFullScreenView", paramMotionEvent.toString());
        continue;
        dvC();
      }
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
    AppMethodBeat.i(187625);
    try
    {
      ad.i("SightVideoFullScreenView", "onSingleTapConfirmed");
      if (!this.xbY)
      {
        this.xbY = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(187625);
        return false;
        this.xbY = false;
        setFocus(false);
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        ad.e("SightVideoFullScreenView", paramMotionEvent.toString());
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187624);
    boolean bool = this.hRv.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(187624);
    return bool;
  }
  
  final void qb(boolean paramBoolean)
  {
    AppMethodBeat.i(187614);
    try
    {
      this.xbQ.setIsPlay(paramBoolean);
      this.xbQ.getPlayBtn().getLayoutParams().width = this.length;
      this.xbQ.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        ad.i("SightVideoFullScreenView", "startPlay");
        this.xbQ.getPlayBtn().setImageDrawable(a.l(this.mContext, 2131691470));
        AppMethodBeat.o(187614);
        return;
      }
      ad.i("SightVideoFullScreenView", "pausePlay");
      this.xbQ.getPlayBtn().setImageDrawable(a.l(this.mContext, 2131691469));
      AppMethodBeat.o(187614);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(187614);
    }
  }
  
  void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(187622);
    if (paramBoolean) {}
    try
    {
      this.xbQ.setVisibility(0);
      this.xbR.setVisibility(0);
      this.xcQ.setVisibility(0);
      ap(this.xbV);
      AppMethodBeat.o(187622);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(187622);
    }
    this.xbY = false;
    this.xbQ.setVisibility(4);
    this.xbR.setVisibility(8);
    this.xcQ.setVisibility(8);
    aq.az(this.xbV);
    AppMethodBeat.o(187622);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView
 * JD-Core Version:    0.7.0.1
 */