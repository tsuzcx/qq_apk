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
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.y;

public class SightVideoFullScreenView
  extends RelativeLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener
{
  com.tencent.mm.plugin.sight.decode.ui.b Aqj;
  private volatile boolean Fey;
  private long LJG;
  private int LKo;
  boolean PQB;
  private int PQE;
  private int PQF;
  private int PQG;
  private int PQH;
  Runnable PQR;
  volatile boolean QIM;
  String QKq;
  ImageView QRE;
  private volatile boolean QRG;
  VideoPlayerSeekBar QRH;
  ImageView QRI;
  View QRJ;
  Runnable QRL;
  View.OnClickListener QRM;
  private volatile boolean QSq;
  FrameLayout Rfe;
  View Rff;
  View Rfg;
  String Rfi;
  int Rfj;
  int Rfk;
  String Rfl;
  volatile boolean Rfp;
  private long Rfq;
  private com.tencent.mm.plugin.sns.ui.listener.a Rfr;
  OfflineVideoView RjG;
  a RjH;
  View contentView;
  boolean hLy;
  volatile boolean isFirst;
  volatile boolean isInit;
  int length;
  Context mContext;
  private GestureDetector nwZ;
  int oYP;
  int pvg;
  private String rPL;
  int sJv;
  
  public SightVideoFullScreenView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(307794);
    this.contentView = null;
    this.QRG = false;
    this.Fey = false;
    this.isInit = true;
    this.QSq = true;
    this.QIM = false;
    this.isFirst = true;
    this.Rfp = false;
    this.QRM = hmk();
    this.Aqj = hml();
    this.LJG = 0L;
    this.PQF = 0;
    this.PQH = 0;
    this.PQG = 0;
    this.PQE = 0;
    this.LKo = 0;
    this.Rfq = 0L;
    this.PQR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307608);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(307608);
      }
    };
    this.QRL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307612);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(307612);
      }
    };
    this.mContext = paramContext;
    this.nwZ = new GestureDetector(this);
    AppMethodBeat.o(307794);
  }
  
  public SightVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(307798);
    this.contentView = null;
    this.QRG = false;
    this.Fey = false;
    this.isInit = true;
    this.QSq = true;
    this.QIM = false;
    this.isFirst = true;
    this.Rfp = false;
    this.QRM = hmk();
    this.Aqj = hml();
    this.LJG = 0L;
    this.PQF = 0;
    this.PQH = 0;
    this.PQG = 0;
    this.PQE = 0;
    this.LKo = 0;
    this.Rfq = 0L;
    this.PQR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307608);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(307608);
      }
    };
    this.QRL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307612);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(307612);
      }
    };
    this.mContext = paramContext;
    this.nwZ = new GestureDetector(this);
    AppMethodBeat.o(307798);
  }
  
  public SightVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(307801);
    this.contentView = null;
    this.QRG = false;
    this.Fey = false;
    this.isInit = true;
    this.QSq = true;
    this.QIM = false;
    this.isFirst = true;
    this.Rfp = false;
    this.QRM = hmk();
    this.Aqj = hml();
    this.LJG = 0L;
    this.PQF = 0;
    this.PQH = 0;
    this.PQG = 0;
    this.PQE = 0;
    this.LKo = 0;
    this.Rfq = 0L;
    this.PQR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307608);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(307608);
      }
    };
    this.QRL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307612);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(307612);
      }
    };
    this.mContext = paramContext;
    this.nwZ = new GestureDetector(this);
    AppMethodBeat.o(307801);
  }
  
  private static void aN(Runnable paramRunnable)
  {
    AppMethodBeat.i(307811);
    try
    {
      MMHandlerThread.removeRunnable(paramRunnable);
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(307811);
      return;
    }
    finally
    {
      Log.e("SightVideoFullScreenView", paramRunnable.toString());
      AppMethodBeat.o(307811);
    }
  }
  
  private View.OnClickListener hmk()
  {
    AppMethodBeat.i(307802);
    View.OnClickListener local6 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(307616);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
          finally
          {
            Log.e("SightVideoFullScreenView", paramAnonymousView.toString());
            continue;
            SightVideoFullScreenView.this.hax();
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(307616);
          return;
          if (!SightVideoFullScreenView.l(SightVideoFullScreenView.this)) {
            continue;
          }
          SightVideoFullScreenView.this.haw();
          SightVideoFullScreenView.this.hni();
        }
      }
    };
    AppMethodBeat.o(307802);
    return local6;
  }
  
  private com.tencent.mm.plugin.sight.decode.ui.b hml()
  {
    AppMethodBeat.i(307805);
    com.tencent.mm.plugin.sight.decode.ui.b local7 = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void blc()
      {
        AppMethodBeat.i(307619);
        try
        {
          if (SightVideoFullScreenView.a(SightVideoFullScreenView.this) != null) {
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).hmu();
          }
          SightVideoFullScreenView.c(SightVideoFullScreenView.this, true);
          AppMethodBeat.o(307619);
          return;
        }
        finally
        {
          Log.e("SightVideoFullScreenView", localObject.toString());
          AppMethodBeat.o(307619);
        }
      }
      
      public final void tS(int paramAnonymousInt)
      {
        AppMethodBeat.i(307622);
        try
        {
          Log.i("SightVideoFullScreenView", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          if (SightVideoFullScreenView.l(SightVideoFullScreenView.this)) {
            SightVideoFullScreenView.this.haw();
          }
          for (;;)
          {
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).bK(paramAnonymousInt * 1000, true);
            SightVideoFullScreenView.b(SightVideoFullScreenView.this, true);
            MMHandlerThread.removeRunnable(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
            SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(307622);
            return;
            SightVideoFullScreenView.this.hax();
          }
          return;
        }
        finally
        {
          Log.e("SightVideoFullScreenView", localObject.toString());
          AppMethodBeat.o(307622);
        }
      }
      
      public final void tT(int paramAnonymousInt) {}
    };
    AppMethodBeat.o(307805);
    return local7;
  }
  
  final void DV(boolean paramBoolean)
  {
    AppMethodBeat.i(307873);
    try
    {
      this.QRH.setIsPlay(paramBoolean);
      this.QRH.getPlayBtn().getLayoutParams().width = this.length;
      this.QRH.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        Log.i("SightVideoFullScreenView", "startPlay");
        this.QRH.getPlayBtn().setImageDrawable(com.tencent.mm.cd.a.m(this.mContext, b.i.media_player_btn_cur_status_on));
        AppMethodBeat.o(307873);
        return;
      }
      Log.i("SightVideoFullScreenView", "pausePlay");
      this.QRH.getPlayBtn().setImageDrawable(com.tencent.mm.cd.a.m(this.mContext, b.i.media_player_btn_cur_status_off));
      AppMethodBeat.o(307873);
      return;
    }
    finally
    {
      Log.e("SightVideoFullScreenView", localObject.toString());
      AppMethodBeat.o(307873);
    }
  }
  
  public final void bUf()
  {
    AppMethodBeat.i(307915);
    int i;
    try
    {
      if (this.mContext == null)
      {
        Log.e("SightVideoFullScreenView", "context is null");
        AppMethodBeat.o(307915);
        return;
      }
      if (this.RjH != null) {
        break label127;
      }
      this.RjH = new a();
      AudioManager localAudioManager = (AudioManager)this.mContext.getSystemService("audio");
      if (localAudioManager == null) {
        break label127;
      }
      i = localAudioManager.requestAudioFocus(this.RjH, 3, 2);
      if (i != 1) {}
    }
    finally
    {
      Log.e("SightVideoFullScreenView", "requestAudioFocus has something wrong!");
      AppMethodBeat.o(307915);
      return;
    }
    Log.i("SightVideoFullScreenView", "requestAudioFocus is not granted. value = ".concat(String.valueOf(i)));
    label127:
    AppMethodBeat.o(307915);
  }
  
  public final void haw()
  {
    AppMethodBeat.i(307869);
    try
    {
      this.QRE.setImageDrawable(com.tencent.mm.cd.a.m(this.mContext, b.i.icon_volume_off));
      this.RjG.setMute(true);
      this.PQB = true;
      AppMethodBeat.o(307869);
      return;
    }
    finally
    {
      Log.e("SightVideoFullScreenView", localObject.toString());
      AppMethodBeat.o(307869);
    }
  }
  
  public final void hax()
  {
    AppMethodBeat.i(307871);
    try
    {
      this.QRE.setImageDrawable(com.tencent.mm.cd.a.m(this.mContext, b.i.icon_volume_on));
      this.RjG.setMute(false);
      this.PQB = false;
      AppMethodBeat.o(307871);
      return;
    }
    finally
    {
      Log.e("SightVideoFullScreenView", localObject.toString());
      AppMethodBeat.o(307871);
    }
  }
  
  final void hiU()
  {
    AppMethodBeat.i(307861);
    try
    {
      ar.bt((Activity)this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Rff.getLayoutParams();
      localLayoutParams.leftMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 64);
      localLayoutParams.rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)this.Rfg.getLayoutParams()).rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.QRI.getLayoutParams()).rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.QRH.getLayoutParams()).width = (this.pvg - com.tencent.mm.cd.a.fromDPToPix(this.mContext, 232));
      AppMethodBeat.o(307861);
      return;
    }
    finally
    {
      Log.e("SightVideoFullScreenView", localObject.toString());
      AppMethodBeat.o(307861);
    }
  }
  
  final void hiV()
  {
    AppMethodBeat.i(307864);
    try
    {
      ar.bt((Activity)this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Rff.getLayoutParams();
      localLayoutParams.leftMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 0);
      localLayoutParams.rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)this.Rfg.getLayoutParams()).rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.QRI.getLayoutParams()).rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.QRH.getLayoutParams()).width = (this.sJv - com.tencent.mm.cd.a.fromDPToPix(this.mContext, 74));
      AppMethodBeat.o(307864);
      return;
    }
    finally
    {
      Log.e("SightVideoFullScreenView", localObject.toString());
      AppMethodBeat.o(307864);
    }
  }
  
  public final void hni()
  {
    AppMethodBeat.i(307877);
    try
    {
      if (this.QRG)
      {
        Log.e("SightVideoFullScreenView", "last download fail, try again");
        this.RjG.dSY();
        AppMethodBeat.o(307877);
        return;
      }
      if ((!this.Fey) && (!TextUtils.isEmpty(this.rPL)))
      {
        this.RjG.auJ(this.rPL);
        this.Fey = true;
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(307624);
          try
          {
            Log.i("SightVideoFullScreenView", "sightVideoStartPlay");
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).start();
            SightVideoFullScreenView.b(SightVideoFullScreenView.this, true);
            MMHandlerThread.removeRunnable(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
            SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
            SightVideoFullScreenView.this.bUf();
            AppMethodBeat.o(307624);
            return;
          }
          finally
          {
            Log.e("SightVideoFullScreenView", localObject.toString());
            AppMethodBeat.o(307624);
          }
        }
      });
      this.LJG = System.currentTimeMillis();
      this.LKo += 1;
      AppMethodBeat.o(307877);
      return;
    }
    finally
    {
      Log.e("SightVideoFullScreenView", localObject.toString());
      AppMethodBeat.o(307877);
    }
  }
  
  final void hnj()
  {
    AppMethodBeat.i(307879);
    Log.d("SightVideoFullScreenView", "pause play");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307629);
        try
        {
          Log.i("SightVideoFullScreenView", "sightVideoPausePlay");
          SightVideoFullScreenView.a(SightVideoFullScreenView.this).hmu();
          SightVideoFullScreenView.b(SightVideoFullScreenView.this, false);
          SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(0);
          SightVideoFullScreenView.aP(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
          AppMethodBeat.o(307629);
          return;
        }
        finally
        {
          Log.e("SightVideoFullScreenView", localObject.toString());
          AppMethodBeat.o(307629);
        }
      }
    });
    if (this.LJG != 0L)
    {
      this.Rfq += System.currentTimeMillis() - this.LJG;
      this.LJG = 0L;
      Log.i("SightVideoFullScreenView", "playTimeInterval update");
    }
    AppMethodBeat.o(307879);
  }
  
  public final Intent hnk()
  {
    AppMethodBeat.i(307882);
    Intent localIntent = new Intent();
    try
    {
      if ((this.RjG.isPlaying()) && (this.LJG != 0L))
      {
        this.Rfq += System.currentTimeMillis() - this.LJG;
        this.LJG = 0L;
        Log.i("SightVideoFullScreenView", "playTimeInterval update");
      }
      localIntent.putExtra("KComponentVideoType", this.oYP);
      localIntent.putExtra("KComponentCid", this.Rfi);
      localIntent.putExtra("KComponentCurrentTime", this.RjG.getCurrentPositionMs());
      localIntent.putExtra("KComponentVoiceType", this.PQB);
      localIntent.putExtra("KComponentProgressType", this.RjG.isPlaying());
      localIntent.putExtra("KComponentClickPlayControlCount", this.PQF);
      localIntent.putExtra("KComponentDoubleClickCount", this.PQH);
      localIntent.putExtra("KComponentClickVoiceControlCount", this.PQG);
      localIntent.putExtra("KComponentPlayCompletedCount", this.PQE);
      localIntent.putExtra("KComponentPlayCount", this.LKo);
      localIntent.putExtra("KComponentPlayTimeInterval", this.Rfq);
    }
    finally
    {
      for (;;)
      {
        Log.e("SightVideoFullScreenView", localObject.toString());
      }
    }
    AppMethodBeat.o(307882);
    return localIntent;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(307885);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    try
    {
      if (paramView.getId() == b.f.sns_ad_native_landing_pages_sight_voice_btn)
      {
        this.PQG += 1;
        setFocus(true);
        if (this.PQB) {
          hax();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(307885);
          return;
          haw();
        }
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("SightVideoFullScreenView", paramView.toString());
        continue;
        if (paramView.getId() == b.f.sns_ad_native_landing_pages_sight_video_full_screen_btn)
        {
          MMHandlerThread.removeRunnable(this.QRL);
          this.QRJ.setVisibility(8);
          ((Activity)this.mContext).finish();
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(307886);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        Log.i("SightVideoFullScreenView", "ORIENTATION_LANDSCAPE");
        hiU();
        AppMethodBeat.o(307886);
        return;
      }
      if (paramConfiguration.orientation == 1)
      {
        Log.i("SightVideoFullScreenView", "ORIENTATION_PORTRAIT");
        hiV();
      }
      AppMethodBeat.o(307886);
      return;
    }
    finally
    {
      Log.e("SightVideoFullScreenView", paramConfiguration.toString());
      AppMethodBeat.o(307886);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307901);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    try
    {
      Log.i("SightVideoFullScreenView", "onDoubleTap");
      this.PQH += 1;
      aN(this.PQR);
      if (this.RjG.isPlaying()) {
        hnj();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(307901);
        return false;
        if (!this.PQB) {
          break;
        }
        haw();
        hni();
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("SightVideoFullScreenView", paramMotionEvent.toString());
        continue;
        hax();
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
    AppMethodBeat.i(307909);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(307909);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307896);
    try
    {
      Log.i("SightVideoFullScreenView", "onSingleTapConfirmed");
      if (!this.QSq)
      {
        this.QSq = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(307896);
        return false;
        this.QSq = false;
        setFocus(false);
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("SightVideoFullScreenView", paramMotionEvent.toString());
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307905);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(307905);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307891);
    paramView = this.nwZ;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, paramMotionEvent.aYi(), "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(307891);
    return bool;
  }
  
  void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(307889);
    if (paramBoolean) {}
    try
    {
      if (this.Rfr != null) {
        this.Rfr.Es(true);
      }
      this.QRH.setVisibility(0);
      this.QRE.setVisibility(0);
      this.QRI.setVisibility(0);
      aN(this.PQR);
      AppMethodBeat.o(307889);
      return;
    }
    finally
    {
      Log.e("SightVideoFullScreenView", localObject.toString());
      AppMethodBeat.o(307889);
    }
    this.QSq = false;
    this.QRH.setVisibility(4);
    this.QRE.setVisibility(8);
    this.QRI.setVisibility(8);
    MMHandlerThread.removeRunnable(this.PQR);
    if (this.Rfr != null) {
      this.Rfr.Es(false);
    }
    AppMethodBeat.o(307889);
    return;
  }
  
  public void setProgressBarStatusListener(com.tencent.mm.plugin.sns.ui.listener.a parama)
  {
    this.Rfr = parama;
  }
  
  final class a
    implements AudioManager.OnAudioFocusChangeListener
  {
    a() {}
    
    public final void onAudioFocusChange(int paramInt)
    {
      AppMethodBeat.i(307645);
      SightVideoFullScreenView.alR(paramInt);
      AppMethodBeat.o(307645);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView
 * JD-Core Version:    0.7.0.1
 */