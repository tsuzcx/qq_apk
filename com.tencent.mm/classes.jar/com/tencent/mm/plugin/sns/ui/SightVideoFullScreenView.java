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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.vfs.o;

public class SightVideoFullScreenView
  extends RelativeLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener
{
  FrameLayout AjA;
  View AjB;
  View AjC;
  String AjE;
  int AjF;
  int AjG;
  String AjH;
  volatile boolean AjL;
  private long AjM;
  private com.tencent.mm.plugin.sns.ui.d.a AjN;
  OfflineVideoView AnC;
  volatile boolean cBE;
  View contentView;
  private GestureDetector iNw;
  volatile boolean isFirst;
  int ivg;
  private String kKP;
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
  private volatile boolean zXN;
  ImageView zXO;
  View zXP;
  Runnable zXR;
  private int zXS;
  private int zXa;
  View.OnClickListener zXc;
  
  public SightVideoFullScreenView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(219761);
    this.contentView = null;
    this.zWT = false;
    this.zXN = false;
    this.cBE = true;
    this.zWO = true;
    this.zPy = false;
    this.isFirst = true;
    this.AjL = false;
    this.zXc = edC();
    this.rNx = edD();
    this.wyh = 0L;
    this.zWZ = 0;
    this.zXS = 0;
    this.zXa = 0;
    this.zWY = 0;
    this.wyN = 0;
    this.AjM = 0L;
    this.zWL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219759);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(219759);
      }
    };
    this.zXR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219760);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(219760);
      }
    };
    this.mContext = paramContext;
    this.iNw = new GestureDetector(this);
    AppMethodBeat.o(219761);
  }
  
  public SightVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(219762);
    this.contentView = null;
    this.zWT = false;
    this.zXN = false;
    this.cBE = true;
    this.zWO = true;
    this.zPy = false;
    this.isFirst = true;
    this.AjL = false;
    this.zXc = edC();
    this.rNx = edD();
    this.wyh = 0L;
    this.zWZ = 0;
    this.zXS = 0;
    this.zXa = 0;
    this.zWY = 0;
    this.wyN = 0;
    this.AjM = 0L;
    this.zWL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219759);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(219759);
      }
    };
    this.zXR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219760);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(219760);
      }
    };
    this.mContext = paramContext;
    this.iNw = new GestureDetector(this);
    AppMethodBeat.o(219762);
  }
  
  public SightVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(219763);
    this.contentView = null;
    this.zWT = false;
    this.zXN = false;
    this.cBE = true;
    this.zWO = true;
    this.zPy = false;
    this.isFirst = true;
    this.AjL = false;
    this.zXc = edC();
    this.rNx = edD();
    this.wyh = 0L;
    this.zWZ = 0;
    this.zXS = 0;
    this.zXa = 0;
    this.zWY = 0;
    this.wyN = 0;
    this.AjM = 0L;
    this.zWL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219759);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(219759);
      }
    };
    this.zXR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219760);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(219760);
      }
    };
    this.mContext = paramContext;
    this.iNw = new GestureDetector(this);
    AppMethodBeat.o(219763);
  }
  
  private static void ao(Runnable paramRunnable)
  {
    AppMethodBeat.i(219777);
    try
    {
      ar.ay(paramRunnable);
      ar.o(paramRunnable, 4000L);
      AppMethodBeat.o(219777);
      return;
    }
    catch (Throwable paramRunnable)
    {
      ae.e("SightVideoFullScreenView", paramRunnable.toString());
      AppMethodBeat.o(219777);
    }
  }
  
  private View.OnClickListener edC()
  {
    AppMethodBeat.i(219771);
    View.OnClickListener local6 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(219756);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        for (;;)
        {
          try
          {
            SightVideoFullScreenView.c(SightVideoFullScreenView.this, true);
            if (!SightVideoFullScreenView.a(SightVideoFullScreenView.this).isPlaying()) {
              continue;
            }
            SightVideoFullScreenView.p(SightVideoFullScreenView.this);
            if (SightVideoFullScreenView.q(SightVideoFullScreenView.this)) {
              SightVideoFullScreenView.r(SightVideoFullScreenView.this);
            }
          }
          catch (Throwable paramAnonymousView)
          {
            ae.e("SightVideoFullScreenView", paramAnonymousView.toString());
            continue;
            SightVideoFullScreenView.this.dZP();
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219756);
          return;
          if (!SightVideoFullScreenView.l(SightVideoFullScreenView.this)) {
            continue;
          }
          SightVideoFullScreenView.this.dZN();
          SightVideoFullScreenView.this.eeu();
        }
      }
    };
    AppMethodBeat.o(219771);
    return local6;
  }
  
  private com.tencent.mm.plugin.sight.decode.ui.b edD()
  {
    AppMethodBeat.i(219772);
    com.tencent.mm.plugin.sight.decode.ui.b local7 = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqS()
      {
        AppMethodBeat.i(219757);
        try
        {
          if (SightVideoFullScreenView.a(SightVideoFullScreenView.this) != null) {
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).edL();
          }
          SightVideoFullScreenView.c(SightVideoFullScreenView.this, true);
          AppMethodBeat.o(219757);
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(219757);
        }
      }
      
      public final void nP(int paramAnonymousInt)
      {
        AppMethodBeat.i(219758);
        try
        {
          ae.i("SightVideoFullScreenView", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          if (SightVideoFullScreenView.l(SightVideoFullScreenView.this)) {
            SightVideoFullScreenView.this.dZN();
          }
          for (;;)
          {
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).aF(paramAnonymousInt * 1000, true);
            SightVideoFullScreenView.b(SightVideoFullScreenView.this, true);
            ar.ay(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
            SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(219758);
            return;
            SightVideoFullScreenView.this.dZP();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(219758);
        }
      }
    };
    AppMethodBeat.o(219772);
    return local7;
  }
  
  public final void dZN()
  {
    AppMethodBeat.i(219766);
    try
    {
      this.zWH.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131690341));
      this.AnC.setMute(true);
      this.zWP = true;
      AppMethodBeat.o(219766);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(219766);
    }
  }
  
  public final void dZP()
  {
    AppMethodBeat.i(219767);
    try
    {
      this.zWH.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131690342));
      this.AnC.setMute(false);
      this.zWP = false;
      AppMethodBeat.o(219767);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(219767);
    }
  }
  
  final void eam()
  {
    AppMethodBeat.i(219764);
    try
    {
      an.aH((Activity)this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.AjB.getLayoutParams();
      localLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 64);
      localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)this.AjC.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.zXO.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.zWG.getLayoutParams()).width = (this.lya - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 232));
      AppMethodBeat.o(219764);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(219764);
    }
  }
  
  final void ean()
  {
    AppMethodBeat.i(219765);
    try
    {
      an.aH((Activity)this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.AjB.getLayoutParams();
      localLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 0);
      localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)this.AjC.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.zXO.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.zWG.getLayoutParams()).width = (this.lxZ - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 74));
      AppMethodBeat.o(219765);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(219765);
    }
  }
  
  public final void eeu()
  {
    AppMethodBeat.i(219769);
    try
    {
      if (this.zWT)
      {
        ae.e("SightVideoFullScreenView", "last download fail, try again");
        this.AnC.cyW();
        AppMethodBeat.o(219769);
        return;
      }
      if ((!this.zXN) && (!TextUtils.isEmpty(this.kKP)))
      {
        this.AnC.ahQ(this.kKP);
        this.zXN = true;
      }
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219754);
          try
          {
            ae.i("SightVideoFullScreenView", "sightVideoStartPlay");
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).start();
            SightVideoFullScreenView.b(SightVideoFullScreenView.this, true);
            ar.ay(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
            SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(219754);
            return;
          }
          catch (Throwable localThrowable)
          {
            ae.e("SightVideoFullScreenView", localThrowable.toString());
            AppMethodBeat.o(219754);
          }
        }
      });
      this.wyh = System.currentTimeMillis();
      this.wyN += 1;
      AppMethodBeat.o(219769);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(219769);
    }
  }
  
  final void eev()
  {
    AppMethodBeat.i(219770);
    ae.d("SightVideoFullScreenView", "pause play");
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219755);
        try
        {
          ae.i("SightVideoFullScreenView", "sightVideoPausePlay");
          SightVideoFullScreenView.a(SightVideoFullScreenView.this).edL();
          SightVideoFullScreenView.b(SightVideoFullScreenView.this, false);
          SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(0);
          SightVideoFullScreenView.aq(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
          AppMethodBeat.o(219755);
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(219755);
        }
      }
    });
    if (this.wyh != 0L)
    {
      this.AjM += System.currentTimeMillis() - this.wyh;
      this.wyh = 0L;
      ae.i("SightVideoFullScreenView", "playTimeInterval update");
    }
    AppMethodBeat.o(219770);
  }
  
  public final Intent eew()
  {
    AppMethodBeat.i(219773);
    Intent localIntent = new Intent();
    try
    {
      if ((this.AnC.isPlaying()) && (this.wyh != 0L))
      {
        this.AjM += System.currentTimeMillis() - this.wyh;
        this.wyh = 0L;
        ae.i("SightVideoFullScreenView", "playTimeInterval update");
      }
      localIntent.putExtra("KComponentVideoType", this.ivg);
      localIntent.putExtra("KComponentCid", this.AjE);
      localIntent.putExtra("KComponentCurrentTime", this.AnC.getCurrentPositionMs());
      localIntent.putExtra("KComponentVoiceType", this.zWP);
      localIntent.putExtra("KComponentProgressType", this.AnC.isPlaying());
      localIntent.putExtra("KComponentClickPlayControlCount", this.zWZ);
      localIntent.putExtra("KComponentDoubleClickCount", this.zXS);
      localIntent.putExtra("KComponentClickVoiceControlCount", this.zXa);
      localIntent.putExtra("KComponentPlayCompletedCount", this.zWY);
      localIntent.putExtra("KComponentPlayCount", this.wyN);
      localIntent.putExtra("KComponentPlayTimeInterval", this.AjM);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ae.e("SightVideoFullScreenView", localThrowable.toString());
      }
    }
    AppMethodBeat.o(219773);
    return localIntent;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(219774);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219774);
          return;
          dZN();
        }
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        ae.e("SightVideoFullScreenView", paramView.toString());
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
    AppMethodBeat.i(219775);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        ae.i("SightVideoFullScreenView", "ORIENTATION_LANDSCAPE");
        eam();
        AppMethodBeat.o(219775);
        return;
      }
      if (paramConfiguration.orientation == 1)
      {
        ae.i("SightVideoFullScreenView", "ORIENTATION_PORTRAIT");
        ean();
      }
      AppMethodBeat.o(219775);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      ae.e("SightVideoFullScreenView", paramConfiguration.toString());
      AppMethodBeat.o(219775);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219780);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    try
    {
      ae.i("SightVideoFullScreenView", "onDoubleTap");
      this.zXS += 1;
      ao(this.zWL);
      if (this.AnC.isPlaying()) {
        eev();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(219780);
        return false;
        if (!this.zWP) {
          break;
        }
        dZN();
        eeu();
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        ae.e("SightVideoFullScreenView", paramMotionEvent.toString());
        continue;
        dZP();
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
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219782);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(219782);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219779);
    try
    {
      ae.i("SightVideoFullScreenView", "onSingleTapConfirmed");
      if (!this.zWO)
      {
        this.zWO = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(219779);
        return false;
        this.zWO = false;
        setFocus(false);
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        ae.e("SightVideoFullScreenView", paramMotionEvent.toString());
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219781);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(219781);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219778);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    paramView = this.iNw;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.ahE(), "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.mt(0)), "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(219778);
    return bool;
  }
  
  final void rL(boolean paramBoolean)
  {
    AppMethodBeat.i(219768);
    try
    {
      this.zWG.setIsPlay(paramBoolean);
      this.zWG.getPlayBtn().getLayoutParams().width = this.length;
      this.zWG.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        ae.i("SightVideoFullScreenView", "startPlay");
        this.zWG.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131691470));
        AppMethodBeat.o(219768);
        return;
      }
      ae.i("SightVideoFullScreenView", "pausePlay");
      this.zWG.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131691469));
      AppMethodBeat.o(219768);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(219768);
    }
  }
  
  void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(219776);
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
      AppMethodBeat.o(219776);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(219776);
    }
    this.zWO = false;
    this.zWG.setVisibility(4);
    this.zWH.setVisibility(8);
    this.zXO.setVisibility(8);
    ar.ay(this.zWL);
    if (this.AjN != null) {
      this.AjN.sf(false);
    }
    AppMethodBeat.o(219776);
    return;
  }
  
  public void setProgressBarStatusListener(com.tencent.mm.plugin.sns.ui.d.a parama)
  {
    this.AjN = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView
 * JD-Core Version:    0.7.0.1
 */