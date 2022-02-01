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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.s;

public class SightVideoFullScreenView
  extends RelativeLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener
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
  ImageView Egd;
  View Ege;
  Runnable Egg;
  private int Egh;
  FrameLayout Esi;
  View Esj;
  View Esk;
  String Esm;
  int Esn;
  int Eso;
  String Esp;
  volatile boolean Est;
  private long Esu;
  private com.tencent.mm.plugin.sns.ui.d.a Esv;
  OfflineVideoView Ewn;
  View contentView;
  boolean gVd;
  volatile boolean isFirst;
  volatile boolean isInit;
  private GestureDetector jKk;
  int jqs;
  private String lPw;
  int length;
  Context mContext;
  int mEX;
  int mEY;
  com.tencent.mm.plugin.sight.decode.ui.b tni;
  private volatile boolean vbV;
  
  public SightVideoFullScreenView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(203373);
    this.contentView = null;
    this.Efc = false;
    this.vbV = false;
    this.isInit = true;
    this.EeX = true;
    this.DXw = false;
    this.isFirst = true;
    this.Est = false;
    this.Efl = ffU();
    this.tni = ffV();
    this.AhP = 0L;
    this.Efi = 0;
    this.Egh = 0;
    this.Efj = 0;
    this.Efh = 0;
    this.Aiv = 0;
    this.Esu = 0L;
    this.EeU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203371);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(203371);
      }
    };
    this.Egg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203372);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(203372);
      }
    };
    this.mContext = paramContext;
    this.jKk = new GestureDetector(this);
    AppMethodBeat.o(203373);
  }
  
  public SightVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(203374);
    this.contentView = null;
    this.Efc = false;
    this.vbV = false;
    this.isInit = true;
    this.EeX = true;
    this.DXw = false;
    this.isFirst = true;
    this.Est = false;
    this.Efl = ffU();
    this.tni = ffV();
    this.AhP = 0L;
    this.Efi = 0;
    this.Egh = 0;
    this.Efj = 0;
    this.Efh = 0;
    this.Aiv = 0;
    this.Esu = 0L;
    this.EeU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203371);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(203371);
      }
    };
    this.Egg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203372);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(203372);
      }
    };
    this.mContext = paramContext;
    this.jKk = new GestureDetector(this);
    AppMethodBeat.o(203374);
  }
  
  public SightVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203375);
    this.contentView = null;
    this.Efc = false;
    this.vbV = false;
    this.isInit = true;
    this.EeX = true;
    this.DXw = false;
    this.isFirst = true;
    this.Est = false;
    this.Efl = ffU();
    this.tni = ffV();
    this.AhP = 0L;
    this.Efi = 0;
    this.Egh = 0;
    this.Efj = 0;
    this.Efh = 0;
    this.Aiv = 0;
    this.Esu = 0L;
    this.EeU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203371);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(203371);
      }
    };
    this.Egg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203372);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(203372);
      }
    };
    this.mContext = paramContext;
    this.jKk = new GestureDetector(this);
    AppMethodBeat.o(203375);
  }
  
  private static void ay(Runnable paramRunnable)
  {
    AppMethodBeat.i(203389);
    try
    {
      MMHandlerThread.removeRunnable(paramRunnable);
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(203389);
      return;
    }
    catch (Throwable paramRunnable)
    {
      Log.e("SightVideoFullScreenView", paramRunnable.toString());
      AppMethodBeat.o(203389);
    }
  }
  
  private View.OnClickListener ffU()
  {
    AppMethodBeat.i(203383);
    View.OnClickListener local6 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203368);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
            SightVideoFullScreenView.this.fcK();
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203368);
          return;
          if (!SightVideoFullScreenView.l(SightVideoFullScreenView.this)) {
            continue;
          }
          SightVideoFullScreenView.this.fcJ();
          SightVideoFullScreenView.this.fgL();
        }
      }
    };
    AppMethodBeat.o(203383);
    return local6;
  }
  
  private com.tencent.mm.plugin.sight.decode.ui.b ffV()
  {
    AppMethodBeat.i(203384);
    com.tencent.mm.plugin.sight.decode.ui.b local7 = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aJq()
      {
        AppMethodBeat.i(203369);
        try
        {
          if (SightVideoFullScreenView.a(SightVideoFullScreenView.this) != null) {
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).fgd();
          }
          SightVideoFullScreenView.c(SightVideoFullScreenView.this, true);
          AppMethodBeat.o(203369);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(203369);
        }
      }
      
      public final void rk(int paramAnonymousInt)
      {
        AppMethodBeat.i(203370);
        try
        {
          Log.i("SightVideoFullScreenView", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          if (SightVideoFullScreenView.l(SightVideoFullScreenView.this)) {
            SightVideoFullScreenView.this.fcJ();
          }
          for (;;)
          {
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).aU(paramAnonymousInt * 1000, true);
            SightVideoFullScreenView.b(SightVideoFullScreenView.this, true);
            MMHandlerThread.removeRunnable(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
            SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(203370);
            return;
            SightVideoFullScreenView.this.fcK();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(203370);
        }
      }
    };
    AppMethodBeat.o(203384);
    return local7;
  }
  
  public final void fcJ()
  {
    AppMethodBeat.i(203378);
    try
    {
      this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131690469));
      this.Ewn.setMute(true);
      this.EeY = true;
      AppMethodBeat.o(203378);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(203378);
    }
  }
  
  public final void fcK()
  {
    AppMethodBeat.i(203379);
    try
    {
      this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131690470));
      this.Ewn.setMute(false);
      this.EeY = false;
      AppMethodBeat.o(203379);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(203379);
    }
  }
  
  final void fda()
  {
    AppMethodBeat.i(203376);
    try
    {
      ap.aL((Activity)this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Esj.getLayoutParams();
      localLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 64);
      localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)this.Esk.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.Egd.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.EeP.getLayoutParams()).width = (this.mEY - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 232));
      AppMethodBeat.o(203376);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(203376);
    }
  }
  
  final void fdb()
  {
    AppMethodBeat.i(203377);
    try
    {
      ap.aL((Activity)this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Esj.getLayoutParams();
      localLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 0);
      localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)this.Esk.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.Egd.getLayoutParams()).rightMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.EeP.getLayoutParams()).width = (this.mEX - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 74));
      AppMethodBeat.o(203377);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(203377);
    }
  }
  
  public final void fgL()
  {
    AppMethodBeat.i(203381);
    try
    {
      if (this.Efc)
      {
        Log.e("SightVideoFullScreenView", "last download fail, try again");
        this.Ewn.cWZ();
        AppMethodBeat.o(203381);
        return;
      }
      if ((!this.vbV) && (!TextUtils.isEmpty(this.lPw)))
      {
        this.Ewn.asy(this.lPw);
        this.vbV = true;
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203366);
          try
          {
            Log.i("SightVideoFullScreenView", "sightVideoStartPlay");
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).start();
            SightVideoFullScreenView.b(SightVideoFullScreenView.this, true);
            MMHandlerThread.removeRunnable(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
            SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(203366);
            return;
          }
          catch (Throwable localThrowable)
          {
            Log.e("SightVideoFullScreenView", localThrowable.toString());
            AppMethodBeat.o(203366);
          }
        }
      });
      this.AhP = System.currentTimeMillis();
      this.Aiv += 1;
      AppMethodBeat.o(203381);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(203381);
    }
  }
  
  final void fgM()
  {
    AppMethodBeat.i(203382);
    Log.d("SightVideoFullScreenView", "pause play");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203367);
        try
        {
          Log.i("SightVideoFullScreenView", "sightVideoPausePlay");
          SightVideoFullScreenView.a(SightVideoFullScreenView.this).fgd();
          SightVideoFullScreenView.b(SightVideoFullScreenView.this, false);
          SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(0);
          SightVideoFullScreenView.aA(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
          AppMethodBeat.o(203367);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(203367);
        }
      }
    });
    if (this.AhP != 0L)
    {
      this.Esu += System.currentTimeMillis() - this.AhP;
      this.AhP = 0L;
      Log.i("SightVideoFullScreenView", "playTimeInterval update");
    }
    AppMethodBeat.o(203382);
  }
  
  public final Intent fgN()
  {
    AppMethodBeat.i(203385);
    Intent localIntent = new Intent();
    try
    {
      if ((this.Ewn.isPlaying()) && (this.AhP != 0L))
      {
        this.Esu += System.currentTimeMillis() - this.AhP;
        this.AhP = 0L;
        Log.i("SightVideoFullScreenView", "playTimeInterval update");
      }
      localIntent.putExtra("KComponentVideoType", this.jqs);
      localIntent.putExtra("KComponentCid", this.Esm);
      localIntent.putExtra("KComponentCurrentTime", this.Ewn.getCurrentPositionMs());
      localIntent.putExtra("KComponentVoiceType", this.EeY);
      localIntent.putExtra("KComponentProgressType", this.Ewn.isPlaying());
      localIntent.putExtra("KComponentClickPlayControlCount", this.Efi);
      localIntent.putExtra("KComponentDoubleClickCount", this.Egh);
      localIntent.putExtra("KComponentClickVoiceControlCount", this.Efj);
      localIntent.putExtra("KComponentPlayCompletedCount", this.Efh);
      localIntent.putExtra("KComponentPlayCount", this.Aiv);
      localIntent.putExtra("KComponentPlayTimeInterval", this.Esu);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("SightVideoFullScreenView", localThrowable.toString());
      }
    }
    AppMethodBeat.o(203385);
    return localIntent;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(203386);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203386);
          return;
          fcJ();
        }
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        Log.e("SightVideoFullScreenView", paramView.toString());
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
    AppMethodBeat.i(203387);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        Log.i("SightVideoFullScreenView", "ORIENTATION_LANDSCAPE");
        fda();
        AppMethodBeat.o(203387);
        return;
      }
      if (paramConfiguration.orientation == 1)
      {
        Log.i("SightVideoFullScreenView", "ORIENTATION_PORTRAIT");
        fdb();
      }
      AppMethodBeat.o(203387);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      Log.e("SightVideoFullScreenView", paramConfiguration.toString());
      AppMethodBeat.o(203387);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(203392);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    try
    {
      Log.i("SightVideoFullScreenView", "onDoubleTap");
      this.Egh += 1;
      ay(this.EeU);
      if (this.Ewn.isPlaying()) {
        fgM();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(203392);
        return false;
        if (!this.EeY) {
          break;
        }
        fcJ();
        fgL();
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        Log.e("SightVideoFullScreenView", paramMotionEvent.toString());
        continue;
        fcK();
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
    AppMethodBeat.i(203394);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(203394);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(203391);
    try
    {
      Log.i("SightVideoFullScreenView", "onSingleTapConfirmed");
      if (!this.EeX)
      {
        this.EeX = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(203391);
        return false;
        this.EeX = false;
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
    AppMethodBeat.i(203393);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(203393);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(203390);
    paramView = this.jKk;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.axQ(), "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(203390);
    return bool;
  }
  
  void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(203388);
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
      AppMethodBeat.o(203388);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(203388);
    }
    this.EeX = false;
    this.EeP.setVisibility(4);
    this.EeQ.setVisibility(8);
    this.Egd.setVisibility(8);
    MMHandlerThread.removeRunnable(this.EeU);
    if (this.Esv != null) {
      this.Esv.vB(false);
    }
    AppMethodBeat.o(203388);
    return;
  }
  
  public void setProgressBarStatusListener(com.tencent.mm.plugin.sns.ui.d.a parama)
  {
    this.Esv = parama;
  }
  
  final void vh(boolean paramBoolean)
  {
    AppMethodBeat.i(203380);
    try
    {
      this.EeP.setIsPlay(paramBoolean);
      this.EeP.getPlayBtn().getLayoutParams().width = this.length;
      this.EeP.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        Log.i("SightVideoFullScreenView", "startPlay");
        this.EeP.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131691079));
        AppMethodBeat.o(203380);
        return;
      }
      Log.i("SightVideoFullScreenView", "pausePlay");
      this.EeP.getPlayBtn().setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131691078));
      AppMethodBeat.o(203380);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(203380);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView
 * JD-Core Version:    0.7.0.1
 */