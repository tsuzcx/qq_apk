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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vfs.i;

public class SightVideoFullScreenView
  extends RelativeLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener
{
  View contentView;
  volatile boolean cqf;
  int hYQ;
  private GestureDetector irA;
  volatile boolean isFirst;
  int kWB;
  int kWC;
  private String kmA;
  int length;
  boolean lrL;
  Context mContext;
  b qUY;
  private int vdM;
  private long vdg;
  FrameLayout yBe;
  View yBf;
  View yBg;
  String yBi;
  int yBj;
  int yBk;
  String yBl;
  volatile boolean yBp;
  private long yBq;
  OfflineVideoView yEY;
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
  private volatile boolean ypD;
  ImageView ypE;
  View ypF;
  Runnable ypH;
  private int ypI;
  View.OnClickListener ypb;
  
  public SightVideoFullScreenView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(200413);
    this.contentView = null;
    this.yoS = false;
    this.ypD = false;
    this.cqf = true;
    this.yoN = true;
    this.yhR = false;
    this.isFirst = true;
    this.yBp = false;
    this.ypb = dNJ();
    this.qUY = dNK();
    this.vdg = 0L;
    this.yoY = 0;
    this.ypI = 0;
    this.yoZ = 0;
    this.yoX = 0;
    this.vdM = 0;
    this.yBq = 0L;
    this.yoK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200411);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(200411);
      }
    };
    this.ypH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200412);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(200412);
      }
    };
    this.mContext = paramContext;
    this.irA = new GestureDetector(this);
    AppMethodBeat.o(200413);
  }
  
  public SightVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200414);
    this.contentView = null;
    this.yoS = false;
    this.ypD = false;
    this.cqf = true;
    this.yoN = true;
    this.yhR = false;
    this.isFirst = true;
    this.yBp = false;
    this.ypb = dNJ();
    this.qUY = dNK();
    this.vdg = 0L;
    this.yoY = 0;
    this.ypI = 0;
    this.yoZ = 0;
    this.yoX = 0;
    this.vdM = 0;
    this.yBq = 0L;
    this.yoK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200411);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(200411);
      }
    };
    this.ypH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200412);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(200412);
      }
    };
    this.mContext = paramContext;
    this.irA = new GestureDetector(this);
    AppMethodBeat.o(200414);
  }
  
  public SightVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200415);
    this.contentView = null;
    this.yoS = false;
    this.ypD = false;
    this.cqf = true;
    this.yoN = true;
    this.yhR = false;
    this.isFirst = true;
    this.yBp = false;
    this.ypb = dNJ();
    this.qUY = dNK();
    this.vdg = 0L;
    this.yoY = 0;
    this.ypI = 0;
    this.yoZ = 0;
    this.yoX = 0;
    this.vdM = 0;
    this.yBq = 0L;
    this.yoK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200411);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(200411);
      }
    };
    this.ypH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200412);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(200412);
      }
    };
    this.mContext = paramContext;
    this.irA = new GestureDetector(this);
    AppMethodBeat.o(200415);
  }
  
  private static void ar(Runnable paramRunnable)
  {
    AppMethodBeat.i(200429);
    try
    {
      ap.aB(paramRunnable);
      ap.n(paramRunnable, 4000L);
      AppMethodBeat.o(200429);
      return;
    }
    catch (Throwable paramRunnable)
    {
      ac.e("SightVideoFullScreenView", paramRunnable.toString());
      AppMethodBeat.o(200429);
    }
  }
  
  private View.OnClickListener dNJ()
  {
    AppMethodBeat.i(200423);
    View.OnClickListener local6 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200408);
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
              AppMethodBeat.o(200408);
              return;
            }
            if (SightVideoFullScreenView.l(SightVideoFullScreenView.this))
            {
              SightVideoFullScreenView.this.dJV();
              SightVideoFullScreenView.this.dOA();
            }
            else
            {
              SightVideoFullScreenView.this.dKb();
            }
          }
          catch (Throwable paramAnonymousView)
          {
            ac.e("SightVideoFullScreenView", paramAnonymousView.toString());
            AppMethodBeat.o(200408);
            return;
          }
        }
      }
    };
    AppMethodBeat.o(200423);
    return local6;
  }
  
  private b dNK()
  {
    AppMethodBeat.i(200424);
    b local7 = new b()
    {
      public final void anR()
      {
        AppMethodBeat.i(200409);
        try
        {
          if (SightVideoFullScreenView.a(SightVideoFullScreenView.this) != null) {
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).dNS();
          }
          SightVideoFullScreenView.c(SightVideoFullScreenView.this, true);
          AppMethodBeat.o(200409);
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(200409);
        }
      }
      
      public final void nn(int paramAnonymousInt)
      {
        AppMethodBeat.i(200410);
        try
        {
          ac.i("SightVideoFullScreenView", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          if (SightVideoFullScreenView.l(SightVideoFullScreenView.this)) {
            SightVideoFullScreenView.this.dJV();
          }
          for (;;)
          {
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).ax(paramAnonymousInt * 1000, true);
            SightVideoFullScreenView.b(SightVideoFullScreenView.this, true);
            ap.aB(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
            SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(200410);
            return;
            SightVideoFullScreenView.this.dKb();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(200410);
        }
      }
    };
    AppMethodBeat.o(200424);
    return local7;
  }
  
  public final void dJV()
  {
    AppMethodBeat.i(200418);
    try
    {
      this.yoG.setImageDrawable(a.l(this.mContext, 2131690341));
      this.yEY.setMute(true);
      this.yoO = true;
      AppMethodBeat.o(200418);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(200418);
    }
  }
  
  public final void dKb()
  {
    AppMethodBeat.i(200419);
    try
    {
      this.yoG.setImageDrawable(a.l(this.mContext, 2131690342));
      this.yEY.setMute(false);
      this.yoO = false;
      AppMethodBeat.o(200419);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(200419);
    }
  }
  
  final void dNH()
  {
    AppMethodBeat.i(200416);
    try
    {
      al.aG((Activity)this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.yBf.getLayoutParams();
      localLayoutParams.leftMargin = a.fromDPToPix(this.mContext, 64);
      localLayoutParams.rightMargin = a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)this.yBg.getLayoutParams()).rightMargin = a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.ypE.getLayoutParams()).rightMargin = a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.yoF.getLayoutParams()).width = (this.kWC - a.fromDPToPix(this.mContext, 232));
      AppMethodBeat.o(200416);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(200416);
    }
  }
  
  final void dNI()
  {
    AppMethodBeat.i(200417);
    try
    {
      al.aG((Activity)this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.yBf.getLayoutParams();
      localLayoutParams.leftMargin = a.fromDPToPix(this.mContext, 0);
      localLayoutParams.rightMargin = a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)this.yBg.getLayoutParams()).rightMargin = a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.ypE.getLayoutParams()).rightMargin = a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.yoF.getLayoutParams()).width = (this.kWB - a.fromDPToPix(this.mContext, 74));
      AppMethodBeat.o(200417);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(200417);
    }
  }
  
  public final void dOA()
  {
    AppMethodBeat.i(200421);
    try
    {
      if (this.yoS)
      {
        ac.e("SightVideoFullScreenView", "last download fail, try again");
        this.yEY.crJ();
        AppMethodBeat.o(200421);
        return;
      }
      if ((!this.ypD) && (!TextUtils.isEmpty(this.kmA)))
      {
        this.yEY.ade(this.kmA);
        this.ypD = true;
      }
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200406);
          try
          {
            ac.i("SightVideoFullScreenView", "sightVideoStartPlay");
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).start();
            SightVideoFullScreenView.b(SightVideoFullScreenView.this, true);
            ap.aB(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
            SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(200406);
            return;
          }
          catch (Throwable localThrowable)
          {
            ac.e("SightVideoFullScreenView", localThrowable.toString());
            AppMethodBeat.o(200406);
          }
        }
      });
      this.vdg = System.currentTimeMillis();
      this.vdM += 1;
      AppMethodBeat.o(200421);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(200421);
    }
  }
  
  final void dOB()
  {
    AppMethodBeat.i(200422);
    ac.d("SightVideoFullScreenView", "pause play");
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200407);
        try
        {
          ac.i("SightVideoFullScreenView", "sightVideoPausePlay");
          SightVideoFullScreenView.a(SightVideoFullScreenView.this).dNS();
          SightVideoFullScreenView.b(SightVideoFullScreenView.this, false);
          SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(0);
          SightVideoFullScreenView.at(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
          AppMethodBeat.o(200407);
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(200407);
        }
      }
    });
    if (this.vdg != 0L)
    {
      this.yBq += System.currentTimeMillis() - this.vdg;
      this.vdg = 0L;
      ac.i("SightVideoFullScreenView", "playTimeInterval update");
    }
    AppMethodBeat.o(200422);
  }
  
  public final Intent dOC()
  {
    AppMethodBeat.i(200425);
    Intent localIntent = new Intent();
    try
    {
      if ((this.yEY.isPlaying()) && (this.vdg != 0L))
      {
        this.yBq += System.currentTimeMillis() - this.vdg;
        this.vdg = 0L;
        ac.i("SightVideoFullScreenView", "playTimeInterval update");
      }
      localIntent.putExtra("KComponentVideoType", this.hYQ);
      localIntent.putExtra("KComponentCid", this.yBi);
      localIntent.putExtra("KComponentCurrentTime", this.yEY.getCurrentPositionMs());
      localIntent.putExtra("KComponentVoiceType", this.yoO);
      localIntent.putExtra("KComponentProgressType", this.yEY.isPlaying());
      localIntent.putExtra("KComponentClickPlayControlCount", this.yoY);
      localIntent.putExtra("KComponentDoubleClickCount", this.ypI);
      localIntent.putExtra("KComponentClickVoiceControlCount", this.yoZ);
      localIntent.putExtra("KComponentPlayCompletedCount", this.yoX);
      localIntent.putExtra("KComponentPlayCount", this.vdM);
      localIntent.putExtra("KComponentPlayTimeInterval", this.yBq);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ac.e("SightVideoFullScreenView", localThrowable.toString());
      }
    }
    AppMethodBeat.o(200425);
    return localIntent;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(200426);
    try
    {
      if (paramView.getId() == 2131304921)
      {
        this.yoZ += 1;
        setFocus(true);
        if (this.yoO)
        {
          dKb();
          AppMethodBeat.o(200426);
          return;
        }
        dJV();
        AppMethodBeat.o(200426);
        return;
      }
    }
    catch (Throwable paramView)
    {
      ac.e("SightVideoFullScreenView", paramView.toString());
      AppMethodBeat.o(200426);
      return;
    }
    if (paramView.getId() == 2131307246)
    {
      ap.aB(this.ypH);
      this.ypF.setVisibility(8);
      ((Activity)this.mContext).finish();
    }
    AppMethodBeat.o(200426);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(200427);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        ac.i("SightVideoFullScreenView", "ORIENTATION_LANDSCAPE");
        dNH();
        AppMethodBeat.o(200427);
        return;
      }
      if (paramConfiguration.orientation == 1)
      {
        ac.i("SightVideoFullScreenView", "ORIENTATION_PORTRAIT");
        dNI();
      }
      AppMethodBeat.o(200427);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      ac.e("SightVideoFullScreenView", paramConfiguration.toString());
      AppMethodBeat.o(200427);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200432);
    try
    {
      ac.i("SightVideoFullScreenView", "onDoubleTap");
      this.ypI += 1;
      ar(this.yoK);
      if (this.yEY.isPlaying()) {
        dOB();
      }
      for (;;)
      {
        AppMethodBeat.o(200432);
        return false;
        if (!this.yoO) {
          break;
        }
        dJV();
        dOA();
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        ac.e("SightVideoFullScreenView", paramMotionEvent.toString());
        continue;
        dKb();
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
    AppMethodBeat.i(200431);
    try
    {
      ac.i("SightVideoFullScreenView", "onSingleTapConfirmed");
      if (!this.yoN)
      {
        this.yoN = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(200431);
        return false;
        this.yoN = false;
        setFocus(false);
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        ac.e("SightVideoFullScreenView", paramMotionEvent.toString());
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200430);
    boolean bool = this.irA.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(200430);
    return bool;
  }
  
  final void ra(boolean paramBoolean)
  {
    AppMethodBeat.i(200420);
    try
    {
      this.yoF.setIsPlay(paramBoolean);
      this.yoF.getPlayBtn().getLayoutParams().width = this.length;
      this.yoF.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        ac.i("SightVideoFullScreenView", "startPlay");
        this.yoF.getPlayBtn().setImageDrawable(a.l(this.mContext, 2131691470));
        AppMethodBeat.o(200420);
        return;
      }
      ac.i("SightVideoFullScreenView", "pausePlay");
      this.yoF.getPlayBtn().setImageDrawable(a.l(this.mContext, 2131691469));
      AppMethodBeat.o(200420);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(200420);
    }
  }
  
  void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(200428);
    if (paramBoolean) {}
    try
    {
      this.yoF.setVisibility(0);
      this.yoG.setVisibility(0);
      this.ypE.setVisibility(0);
      ar(this.yoK);
      AppMethodBeat.o(200428);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(200428);
    }
    this.yoN = false;
    this.yoF.setVisibility(4);
    this.yoG.setVisibility(8);
    this.ypE.setVisibility(8);
    ap.aB(this.yoK);
    AppMethodBeat.o(200428);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView
 * JD-Core Version:    0.7.0.1
 */