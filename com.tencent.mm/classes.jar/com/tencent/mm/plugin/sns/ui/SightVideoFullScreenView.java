package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
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
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.u;

public class SightVideoFullScreenView
  extends RelativeLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener
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
  String KFI;
  int KFJ;
  int KFK;
  String KFL;
  volatile boolean KFP;
  private long KFQ;
  private com.tencent.mm.plugin.sns.ui.d.a KFR;
  OfflineVideoView KKe;
  a KKf;
  volatile boolean KkF;
  String Kmm;
  private volatile boolean KtQ;
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
  volatile boolean isInit;
  int length;
  private GestureDetector mBn;
  Context mContext;
  int mfT;
  private String oLQ;
  int pEj;
  int pEk;
  com.tencent.mm.plugin.sight.decode.ui.b wTG;
  private volatile boolean zSl;
  
  public SightVideoFullScreenView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(266431);
    this.contentView = null;
    this.Ktg = false;
    this.zSl = false;
    this.isInit = true;
    this.KtQ = true;
    this.KkF = false;
    this.isFirst = true;
    this.KFP = false;
    this.Ktm = fTR();
    this.wTG = fTS();
    this.FOL = 0L;
    this.JAX = 0;
    this.JAZ = 0;
    this.JAY = 0;
    this.JAW = 0;
    this.FPs = 0;
    this.KFQ = 0L;
    this.JBl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194036);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(194036);
      }
    };
    this.Ktl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201837);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(201837);
      }
    };
    this.mContext = paramContext;
    this.mBn = new GestureDetector(this);
    AppMethodBeat.o(266431);
  }
  
  public SightVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(266432);
    this.contentView = null;
    this.Ktg = false;
    this.zSl = false;
    this.isInit = true;
    this.KtQ = true;
    this.KkF = false;
    this.isFirst = true;
    this.KFP = false;
    this.Ktm = fTR();
    this.wTG = fTS();
    this.FOL = 0L;
    this.JAX = 0;
    this.JAZ = 0;
    this.JAY = 0;
    this.JAW = 0;
    this.FPs = 0;
    this.KFQ = 0L;
    this.JBl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194036);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(194036);
      }
    };
    this.Ktl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201837);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(201837);
      }
    };
    this.mContext = paramContext;
    this.mBn = new GestureDetector(this);
    AppMethodBeat.o(266432);
  }
  
  public SightVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(266433);
    this.contentView = null;
    this.Ktg = false;
    this.zSl = false;
    this.isInit = true;
    this.KtQ = true;
    this.KkF = false;
    this.isFirst = true;
    this.KFP = false;
    this.Ktm = fTR();
    this.wTG = fTS();
    this.FOL = 0L;
    this.JAX = 0;
    this.JAZ = 0;
    this.JAY = 0;
    this.JAW = 0;
    this.FPs = 0;
    this.KFQ = 0L;
    this.JBl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194036);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(194036);
      }
    };
    this.Ktl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201837);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(201837);
      }
    };
    this.mContext = paramContext;
    this.mBn = new GestureDetector(this);
    AppMethodBeat.o(266433);
  }
  
  private static void aE(Runnable paramRunnable)
  {
    AppMethodBeat.i(266450);
    try
    {
      MMHandlerThread.removeRunnable(paramRunnable);
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(266450);
      return;
    }
    catch (Throwable paramRunnable)
    {
      Log.e("SightVideoFullScreenView", paramRunnable.toString());
      AppMethodBeat.o(266450);
    }
  }
  
  private View.OnClickListener fTR()
  {
    AppMethodBeat.i(266442);
    View.OnClickListener local6 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(265758);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
            Log.e("SightVideoFullScreenView", paramAnonymousView.toString());
            continue;
            SightVideoFullScreenView.this.fKs();
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(265758);
          return;
          if (!SightVideoFullScreenView.l(SightVideoFullScreenView.this)) {
            continue;
          }
          SightVideoFullScreenView.this.fKr();
          SightVideoFullScreenView.this.fUS();
        }
      }
    };
    AppMethodBeat.o(266442);
    return local6;
  }
  
  private com.tencent.mm.plugin.sight.decode.ui.b fTS()
  {
    AppMethodBeat.i(266443);
    com.tencent.mm.plugin.sight.decode.ui.b local7 = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aRo()
      {
        AppMethodBeat.i(202686);
        try
        {
          if (SightVideoFullScreenView.a(SightVideoFullScreenView.this) != null) {
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).fUa();
          }
          SightVideoFullScreenView.c(SightVideoFullScreenView.this, true);
          AppMethodBeat.o(202686);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(202686);
        }
      }
      
      public final void tY(int paramAnonymousInt)
      {
        AppMethodBeat.i(202690);
        try
        {
          Log.i("SightVideoFullScreenView", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          if (SightVideoFullScreenView.l(SightVideoFullScreenView.this)) {
            SightVideoFullScreenView.this.fKr();
          }
          for (;;)
          {
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).bd(paramAnonymousInt * 1000, true);
            SightVideoFullScreenView.b(SightVideoFullScreenView.this, true);
            MMHandlerThread.removeRunnable(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
            SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(202690);
            return;
            SightVideoFullScreenView.this.fKs();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(202690);
        }
      }
    };
    AppMethodBeat.o(266443);
    return local7;
  }
  
  public final void fKr()
  {
    AppMethodBeat.i(266436);
    try
    {
      this.Kte.setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, i.i.icon_volume_off));
      this.KKe.setMute(true);
      this.JAS = true;
      AppMethodBeat.o(266436);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(266436);
    }
  }
  
  public final void fKs()
  {
    AppMethodBeat.i(266437);
    try
    {
      this.Kte.setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, i.i.icon_volume_on));
      this.KKe.setMute(false);
      this.JAS = false;
      AppMethodBeat.o(266437);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(266437);
    }
  }
  
  final void fQW()
  {
    AppMethodBeat.i(266434);
    try
    {
      ao.aR((Activity)this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.KFF.getLayoutParams();
      localLayoutParams.leftMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 64);
      localLayoutParams.rightMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)this.KFG.getLayoutParams()).rightMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.Kti.getLayoutParams()).rightMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.Kth.getLayoutParams()).width = (this.pEk - com.tencent.mm.ci.a.fromDPToPix(this.mContext, 232));
      AppMethodBeat.o(266434);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(266434);
    }
  }
  
  final void fQX()
  {
    AppMethodBeat.i(266435);
    try
    {
      ao.aR((Activity)this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.KFF.getLayoutParams();
      localLayoutParams.leftMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 0);
      localLayoutParams.rightMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)this.KFG.getLayoutParams()).rightMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.Kti.getLayoutParams()).rightMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.Kth.getLayoutParams()).width = (this.pEj - com.tencent.mm.ci.a.fromDPToPix(this.mContext, 74));
      AppMethodBeat.o(266435);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(266435);
    }
  }
  
  public final void fUS()
  {
    AppMethodBeat.i(266440);
    try
    {
      if (this.Ktg)
      {
        Log.e("SightVideoFullScreenView", "last download fail, try again");
        this.KKe.dmh();
        AppMethodBeat.o(266440);
        return;
      }
      if ((!this.zSl) && (!TextUtils.isEmpty(this.oLQ)))
      {
        this.KKe.aAB(this.oLQ);
        this.zSl = true;
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(202571);
          try
          {
            Log.i("SightVideoFullScreenView", "sightVideoStartPlay");
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).start();
            SightVideoFullScreenView.b(SightVideoFullScreenView.this, true);
            MMHandlerThread.removeRunnable(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
            SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
            SightVideoFullScreenView.this.requestAudioFocus();
            AppMethodBeat.o(202571);
            return;
          }
          catch (Throwable localThrowable)
          {
            Log.e("SightVideoFullScreenView", localThrowable.toString());
            AppMethodBeat.o(202571);
          }
        }
      });
      this.FOL = System.currentTimeMillis();
      this.FPs += 1;
      AppMethodBeat.o(266440);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(266440);
    }
  }
  
  final void fUT()
  {
    AppMethodBeat.i(266441);
    Log.d("SightVideoFullScreenView", "pause play");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(265766);
        try
        {
          Log.i("SightVideoFullScreenView", "sightVideoPausePlay");
          SightVideoFullScreenView.a(SightVideoFullScreenView.this).fUa();
          SightVideoFullScreenView.b(SightVideoFullScreenView.this, false);
          SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(0);
          SightVideoFullScreenView.aG(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
          AppMethodBeat.o(265766);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(265766);
        }
      }
    });
    if (this.FOL != 0L)
    {
      this.KFQ += System.currentTimeMillis() - this.FOL;
      this.FOL = 0L;
      Log.i("SightVideoFullScreenView", "playTimeInterval update");
    }
    AppMethodBeat.o(266441);
  }
  
  public final Intent fUU()
  {
    AppMethodBeat.i(266445);
    Intent localIntent = new Intent();
    try
    {
      if ((this.KKe.isPlaying()) && (this.FOL != 0L))
      {
        this.KFQ += System.currentTimeMillis() - this.FOL;
        this.FOL = 0L;
        Log.i("SightVideoFullScreenView", "playTimeInterval update");
      }
      localIntent.putExtra("KComponentVideoType", this.mfT);
      localIntent.putExtra("KComponentCid", this.KFI);
      localIntent.putExtra("KComponentCurrentTime", this.KKe.getCurrentPositionMs());
      localIntent.putExtra("KComponentVoiceType", this.JAS);
      localIntent.putExtra("KComponentProgressType", this.KKe.isPlaying());
      localIntent.putExtra("KComponentClickPlayControlCount", this.JAX);
      localIntent.putExtra("KComponentDoubleClickCount", this.JAZ);
      localIntent.putExtra("KComponentClickVoiceControlCount", this.JAY);
      localIntent.putExtra("KComponentPlayCompletedCount", this.JAW);
      localIntent.putExtra("KComponentPlayCount", this.FPs);
      localIntent.putExtra("KComponentPlayTimeInterval", this.KFQ);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("SightVideoFullScreenView", localThrowable.toString());
      }
    }
    AppMethodBeat.o(266445);
    return localIntent;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(266447);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(266447);
          return;
          fKr();
        }
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        Log.e("SightVideoFullScreenView", paramView.toString());
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
    AppMethodBeat.i(266448);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        Log.i("SightVideoFullScreenView", "ORIENTATION_LANDSCAPE");
        fQW();
        AppMethodBeat.o(266448);
        return;
      }
      if (paramConfiguration.orientation == 1)
      {
        Log.i("SightVideoFullScreenView", "ORIENTATION_PORTRAIT");
        fQX();
      }
      AppMethodBeat.o(266448);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      Log.e("SightVideoFullScreenView", paramConfiguration.toString());
      AppMethodBeat.o(266448);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(266453);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    try
    {
      Log.i("SightVideoFullScreenView", "onDoubleTap");
      this.JAZ += 1;
      aE(this.JBl);
      if (this.KKe.isPlaying()) {
        fUT();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(266453);
        return false;
        if (!this.JAS) {
          break;
        }
        fKr();
        fUS();
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        Log.e("SightVideoFullScreenView", paramMotionEvent.toString());
        continue;
        fKs();
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
    AppMethodBeat.i(266456);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(266456);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(266452);
    try
    {
      Log.i("SightVideoFullScreenView", "onSingleTapConfirmed");
      if (!this.KtQ)
      {
        this.KtQ = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(266452);
        return false;
        this.KtQ = false;
        setFocus(false);
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        Log.e("SightVideoFullScreenView", paramMotionEvent.toString());
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(266454);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(266454);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(266451);
    paramView = this.mBn;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, paramMotionEvent.aFh(), "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(266451);
    return bool;
  }
  
  public final void requestAudioFocus()
  {
    AppMethodBeat.i(266458);
    int i;
    try
    {
      if (this.mContext == null)
      {
        Log.e("SightVideoFullScreenView", "context is null");
        AppMethodBeat.o(266458);
        return;
      }
      if (this.KKf != null) {
        break label127;
      }
      this.KKf = new a();
      AudioManager localAudioManager = (AudioManager)this.mContext.getSystemService("audio");
      if (localAudioManager == null) {
        break label127;
      }
      i = localAudioManager.requestAudioFocus(this.KKf, 3, 2);
      if (i == 1)
      {
        Log.i("SightVideoFullScreenView", "requestAudioFocus successfully!");
        AppMethodBeat.o(266458);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("SightVideoFullScreenView", "requestAudioFocus has something wrong!");
      AppMethodBeat.o(266458);
      return;
    }
    Log.i("SightVideoFullScreenView", "requestAudioFocus is not granted. value = ".concat(String.valueOf(i)));
    label127:
    AppMethodBeat.o(266458);
  }
  
  void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(266449);
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
      AppMethodBeat.o(266449);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(266449);
    }
    this.KtQ = false;
    this.Kth.setVisibility(4);
    this.Kte.setVisibility(8);
    this.Kti.setVisibility(8);
    MMHandlerThread.removeRunnable(this.JBl);
    if (this.KFR != null) {
      this.KFR.zf(false);
    }
    AppMethodBeat.o(266449);
    return;
  }
  
  public void setProgressBarStatusListener(com.tencent.mm.plugin.sns.ui.d.a parama)
  {
    this.KFR = parama;
  }
  
  final void yM(boolean paramBoolean)
  {
    AppMethodBeat.i(266438);
    try
    {
      this.Kth.setIsPlay(paramBoolean);
      this.Kth.getPlayBtn().getLayoutParams().width = this.length;
      this.Kth.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        Log.i("SightVideoFullScreenView", "startPlay");
        this.Kth.getPlayBtn().setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, i.i.media_player_btn_cur_status_on));
        AppMethodBeat.o(266438);
        return;
      }
      Log.i("SightVideoFullScreenView", "pausePlay");
      this.Kth.getPlayBtn().setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, i.i.media_player_btn_cur_status_off));
      AppMethodBeat.o(266438);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(266438);
    }
  }
  
  final class a
    implements AudioManager.OnAudioFocusChangeListener
  {
    a() {}
    
    public final void onAudioFocusChange(int paramInt)
    {
      AppMethodBeat.i(266883);
      SightVideoFullScreenView.agY(paramInt);
      AppMethodBeat.o(266883);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView
 * JD-Core Version:    0.7.0.1
 */