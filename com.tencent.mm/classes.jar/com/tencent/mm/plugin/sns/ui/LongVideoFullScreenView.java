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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.thumbplayer.api.ITPPlayer;

public class LongVideoFullScreenView
  extends RelativeLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, i.b, i.d
{
  private long AXD;
  com.tencent.mm.plugin.sight.decode.ui.b Aqj;
  private long LJG;
  private int LKo;
  boolean PQB;
  private int PQE;
  private int PQF;
  private int PQG;
  private int PQH;
  Runnable PQR;
  int PSX;
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
  int QSv;
  FrameLayout Rfe;
  View Rff;
  View Rfg;
  AdLandingVideoWrapper Rfh;
  String Rfi;
  int Rfj;
  int Rfk;
  String Rfl;
  int Rfm;
  private volatile boolean Rfn;
  private volatile int Rfo;
  volatile boolean Rfp;
  private long Rfq;
  private com.tencent.mm.plugin.sns.ui.listener.a Rfr;
  View contentView;
  boolean hLy;
  volatile boolean isFirst;
  boolean isWaiting;
  int length;
  Context mContext;
  volatile boolean mGp;
  private GestureDetector nwZ;
  int oYP;
  int pvg;
  int sJv;
  
  public LongVideoFullScreenView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(307649);
    this.contentView = null;
    this.Rfn = false;
    this.Rfo = 0;
    this.mGp = true;
    this.QRG = false;
    this.QSq = true;
    this.QIM = false;
    this.isFirst = true;
    this.Rfp = false;
    this.LJG = 0L;
    this.PQF = 0;
    this.PQH = 0;
    this.PQG = 0;
    this.PQE = 0;
    this.LKo = 0;
    this.Rfq = 0L;
    this.QRM = hmk();
    this.Aqj = hml();
    this.PQR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307852);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(307852);
      }
    };
    this.QRL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307857);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(307857);
          return;
        }
        finally
        {
          Log.e("LongVideoFullScreenView", localObject.toString());
          AppMethodBeat.o(307857);
        }
      }
    };
    this.mContext = paramContext;
    this.nwZ = new GestureDetector(this);
    AppMethodBeat.o(307649);
  }
  
  public LongVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(307654);
    this.contentView = null;
    this.Rfn = false;
    this.Rfo = 0;
    this.mGp = true;
    this.QRG = false;
    this.QSq = true;
    this.QIM = false;
    this.isFirst = true;
    this.Rfp = false;
    this.LJG = 0L;
    this.PQF = 0;
    this.PQH = 0;
    this.PQG = 0;
    this.PQE = 0;
    this.LKo = 0;
    this.Rfq = 0L;
    this.QRM = hmk();
    this.Aqj = hml();
    this.PQR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307852);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(307852);
      }
    };
    this.QRL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307857);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(307857);
          return;
        }
        finally
        {
          Log.e("LongVideoFullScreenView", localObject.toString());
          AppMethodBeat.o(307857);
        }
      }
    };
    this.mContext = paramContext;
    this.nwZ = new GestureDetector(this);
    AppMethodBeat.o(307654);
  }
  
  public LongVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(307655);
    this.contentView = null;
    this.Rfn = false;
    this.Rfo = 0;
    this.mGp = true;
    this.QRG = false;
    this.QSq = true;
    this.QIM = false;
    this.isFirst = true;
    this.Rfp = false;
    this.LJG = 0L;
    this.PQF = 0;
    this.PQH = 0;
    this.PQG = 0;
    this.PQE = 0;
    this.LKo = 0;
    this.Rfq = 0L;
    this.QRM = hmk();
    this.Aqj = hml();
    this.PQR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307852);
        LongVideoFullScreenView.b(LongVideoFullScreenView.this, false);
        AppMethodBeat.o(307852);
      }
    };
    this.QRL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307857);
        try
        {
          LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
          AppMethodBeat.o(307857);
          return;
        }
        finally
        {
          Log.e("LongVideoFullScreenView", localObject.toString());
          AppMethodBeat.o(307857);
        }
      }
    };
    this.mContext = paramContext;
    this.nwZ = new GestureDetector(this);
    AppMethodBeat.o(307655);
  }
  
  private void DV(boolean paramBoolean)
  {
    AppMethodBeat.i(307657);
    try
    {
      this.QRH.setIsPlay(paramBoolean);
      this.QRH.getPlayBtn().getLayoutParams().width = this.length;
      this.QRH.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        Log.i("LongVideoFullScreenView", "startPlay");
        this.QRH.getPlayBtn().setImageDrawable(com.tencent.mm.cd.a.m(this.mContext, b.i.media_player_btn_cur_status_on));
        AppMethodBeat.o(307657);
        return;
      }
      Log.i("LongVideoFullScreenView", "pausePlay");
      this.QRH.getPlayBtn().setImageDrawable(com.tencent.mm.cd.a.m(this.mContext, b.i.media_player_btn_cur_status_off));
      AppMethodBeat.o(307657);
      return;
    }
    finally
    {
      Log.e("LongVideoFullScreenView", localObject.toString());
      AppMethodBeat.o(307657);
    }
  }
  
  private static void aN(Runnable paramRunnable)
  {
    AppMethodBeat.i(307664);
    try
    {
      MMHandlerThread.removeRunnable(paramRunnable);
      MMHandlerThread.postToMainThreadDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(307664);
      return;
    }
    finally
    {
      Log.e("LongVideoFullScreenView", paramRunnable.toString());
      AppMethodBeat.o(307664);
    }
  }
  
  private View.OnClickListener hmk()
  {
    AppMethodBeat.i(307660);
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(307868);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
          finally
          {
            Log.e("LongVideoFullScreenView", paramAnonymousView.toString());
            continue;
            LongVideoFullScreenView.this.hax();
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(307868);
          return;
          if (!LongVideoFullScreenView.o(LongVideoFullScreenView.this)) {
            continue;
          }
          LongVideoFullScreenView.this.haw();
          LongVideoFullScreenView.p(LongVideoFullScreenView.this);
        }
      }
    };
    AppMethodBeat.o(307660);
    return local3;
  }
  
  private com.tencent.mm.plugin.sight.decode.ui.b hml()
  {
    AppMethodBeat.i(307661);
    com.tencent.mm.plugin.sight.decode.ui.b local4 = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void blc()
      {
        AppMethodBeat.i(307872);
        try
        {
          LongVideoFullScreenView.b(LongVideoFullScreenView.this, true);
          AppMethodBeat.o(307872);
          return;
        }
        finally
        {
          Log.e("LongVideoFullScreenView", localObject.toString());
          AppMethodBeat.o(307872);
        }
      }
      
      public final void tS(int paramAnonymousInt)
      {
        AppMethodBeat.i(307874);
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
            LongVideoFullScreenView.this.haw();
          }
          for (;;)
          {
            LongVideoFullScreenView.h(LongVideoFullScreenView.this).b(i, true);
            MMHandlerThread.removeRunnable(LongVideoFullScreenView.m(LongVideoFullScreenView.this));
            LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(307874);
            return;
            LongVideoFullScreenView.this.hax();
          }
          return;
        }
        finally
        {
          Log.e("LongVideoFullScreenView", localObject.toString());
          AppMethodBeat.o(307874);
        }
      }
      
      public final void tT(int paramAnonymousInt) {}
    };
    AppMethodBeat.o(307661);
    return local4;
  }
  
  final void bck()
  {
    AppMethodBeat.i(307731);
    try
    {
      Log.d("LongVideoFullScreenView", "pause play");
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(307878);
          try
          {
            LongVideoFullScreenView.h(LongVideoFullScreenView.this).pause();
            LongVideoFullScreenView.l(LongVideoFullScreenView.this).setVisibility(0);
            LongVideoFullScreenView.aO(LongVideoFullScreenView.m(LongVideoFullScreenView.this));
            LongVideoFullScreenView.a(LongVideoFullScreenView.this, false);
            AppMethodBeat.o(307878);
            return;
          }
          finally
          {
            Log.e("LongVideoFullScreenView", localObject.toString());
            AppMethodBeat.o(307878);
          }
        }
      });
      if (this.LJG != 0L)
      {
        this.Rfq += System.currentTimeMillis() - this.LJG;
        this.LJG = 0L;
        Log.i("LongVideoFullScreenView", "playTimeInterval update");
      }
      AppMethodBeat.o(307731);
      return;
    }
    finally
    {
      Log.e("LongVideoFullScreenView", localObject.toString());
      AppMethodBeat.o(307731);
    }
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(307717);
    Log.e("LongVideoFullScreenView", "online play error, %s", new Object[] { paramString3 });
    this.QRG = true;
    h.OAn.kJ(1579, 18);
    AppMethodBeat.o(307717);
  }
  
  final void drB()
  {
    AppMethodBeat.i(307727);
    try
    {
      Log.i("LongVideoFullScreenView", "starting play, downFailed=" + this.QRG);
      boolean bool = this.QRG;
      if (bool) {
        try
        {
          Log.e("LongVideoFullScreenView", "last download fail ,try again");
          if ((this.QRH != null) && (this.QRH.getParent() != null)) {
            ((ViewGroup)this.QRH.getParent()).removeView(this.QRH);
          }
          this.Rfh.setFullScreen(true);
          this.Rfh.b(false, this.Rfl, 0);
          if (this.mContext.getResources().getConfiguration().orientation == 2)
          {
            Log.i("LongVideoFullScreenView", "ORIENTATION_LANDSCAPE");
            hiU();
          }
          for (;;)
          {
            this.Rfh.b(0.0D, true);
            this.Rfh.hjN();
            AppMethodBeat.o(307727);
            return;
            if (this.mContext.getResources().getConfiguration().orientation == 1)
            {
              Log.i("LongVideoFullScreenView", "ORIENTATION_PORTRAIT");
              hiV();
            }
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(307876);
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
                    LongVideoFullScreenView.h(LongVideoFullScreenView.this).b(LongVideoFullScreenView.f(LongVideoFullScreenView.this), true);
                  }
                  for (;;)
                  {
                    LongVideoFullScreenView.a(LongVideoFullScreenView.this, System.currentTimeMillis());
                    LongVideoFullScreenView.a(LongVideoFullScreenView.this, true);
                    AppMethodBeat.o(307876);
                    return;
                    LongVideoFullScreenView.g(LongVideoFullScreenView.this).seek(0);
                    LongVideoFullScreenView.h(LongVideoFullScreenView.this).b(0.0D, true);
                  }
                }
                if (LongVideoFullScreenView.i(LongVideoFullScreenView.this) >= LongVideoFullScreenView.e(LongVideoFullScreenView.this)) {
                  break label192;
                }
              }
              finally
              {
                Log.e("LongVideoFullScreenView", localObject.toString());
                AppMethodBeat.o(307876);
                return;
              }
              if (LongVideoFullScreenView.i(LongVideoFullScreenView.this) < 0)
              {
                label192:
                LongVideoFullScreenView.g(LongVideoFullScreenView.this).seek(0);
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).b(0.0D, LongVideoFullScreenView.j(LongVideoFullScreenView.this));
              }
              for (;;)
              {
                LongVideoFullScreenView.a(LongVideoFullScreenView.this, System.currentTimeMillis());
                LongVideoFullScreenView.a(LongVideoFullScreenView.this, LongVideoFullScreenView.j(LongVideoFullScreenView.this));
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).hjN();
                AppMethodBeat.o(307876);
                return;
                LongVideoFullScreenView.g(LongVideoFullScreenView.this).seek(LongVideoFullScreenView.i(LongVideoFullScreenView.this) / 1000);
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).b(LongVideoFullScreenView.i(LongVideoFullScreenView.this), LongVideoFullScreenView.j(LongVideoFullScreenView.this));
              }
              label313:
              if (!LongVideoFullScreenView.h(LongVideoFullScreenView.this).isPlaying())
              {
                if (LongVideoFullScreenView.h(LongVideoFullScreenView.this).getCurrPosSec() != LongVideoFullScreenView.h(LongVideoFullScreenView.this).getVideoDurationSec()) {
                  break label405;
                }
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).b(0.0D, true);
              }
              for (;;)
              {
                LongVideoFullScreenView.a(LongVideoFullScreenView.this, true);
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).hjN();
                LongVideoFullScreenView.k(LongVideoFullScreenView.this);
                LongVideoFullScreenView.a(LongVideoFullScreenView.this, System.currentTimeMillis());
                AppMethodBeat.o(307876);
                return;
                label405:
                LongVideoFullScreenView.h(LongVideoFullScreenView.this).b(LongVideoFullScreenView.h(LongVideoFullScreenView.this).getCurrPosSec(), true);
              }
            }
          });
        }
        finally
        {
          Log.e("LongVideoFullScreenView", localObject1.toString());
        }
      }
      AppMethodBeat.o(307727);
      return;
    }
    finally
    {
      Log.e("LongVideoFullScreenView", localObject2.toString());
      AppMethodBeat.o(307727);
    }
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void el(String paramString1, String paramString2)
  {
    AppMethodBeat.i(307701);
    this.QRG = false;
    if ((this.Rfk <= 0) && (this.Rfh != null)) {
      this.Rfk = this.Rfh.getVideoDurationSec();
    }
    AppMethodBeat.o(307701);
  }
  
  public final void em(String paramString1, String paramString2)
  {
    AppMethodBeat.i(307704);
    try
    {
      this.PQE += 1;
      this.Rfh.QTh.stopTimer();
      this.Rfh.onUIPause();
      AppMethodBeat.o(307704);
      return;
    }
    finally
    {
      Log.e("LongVideoFullScreenView", paramString1.toString());
      AppMethodBeat.o(307704);
    }
  }
  
  public final void en(String paramString1, String paramString2) {}
  
  public final void eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(307713);
    try
    {
      MMHandlerThread.removeRunnable(this.QRL);
      this.QRJ.setVisibility(8);
      DV(true);
      AppMethodBeat.o(307713);
      return;
    }
    finally
    {
      Log.e("LongVideoFullScreenView", paramString1.toString());
      AppMethodBeat.o(307713);
    }
  }
  
  public final void ep(String paramString1, String paramString2)
  {
    AppMethodBeat.i(307720);
    this.Rfn = true;
    this.AXD = System.currentTimeMillis();
    Log.i("LongVideoFullScreenView", "mediaId = " + paramString2 + ", start loading");
    AppMethodBeat.o(307720);
  }
  
  public final void eq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(307722);
    this.Rfn = false;
    this.Rfo = 0;
    haH();
    Log.i("LongVideoFullScreenView", "mediaId = " + paramString2 + ", end loading");
    AppMethodBeat.o(307722);
  }
  
  public final void gE(String paramString1, String paramString2) {}
  
  final void haH()
  {
    AppMethodBeat.i(307748);
    if (this.AXD != 0L)
    {
      this.PSX = ((int)(this.PSX + (System.currentTimeMillis() - this.AXD)));
      this.AXD = 0L;
    }
    AppMethodBeat.o(307748);
  }
  
  public final void haw()
  {
    AppMethodBeat.i(307735);
    try
    {
      this.QRE.setImageDrawable(com.tencent.mm.cd.a.m(this.mContext, b.i.icon_volume_off));
      this.Rfh.setMute(true);
      this.PQB = true;
      AppMethodBeat.o(307735);
      return;
    }
    finally
    {
      Log.e("LongVideoFullScreenView", localObject.toString());
      AppMethodBeat.o(307735);
    }
  }
  
  public final void hax()
  {
    AppMethodBeat.i(307737);
    try
    {
      this.QRE.setImageDrawable(com.tencent.mm.cd.a.m(this.mContext, b.i.icon_volume_on));
      this.Rfh.setMute(false);
      this.PQB = false;
      AppMethodBeat.o(307737);
      return;
    }
    finally
    {
      Log.e("LongVideoFullScreenView", localObject.toString());
      AppMethodBeat.o(307737);
    }
  }
  
  public final void hay()
  {
    AppMethodBeat.i(307708);
    try
    {
      int i = this.Rfh.getCurrPosSec();
      if (i >= this.Rfk)
      {
        Log.i("LongVideoFullScreenView", "onLoopCompletion, currPosSec is ".concat(String.valueOf(i)));
        this.PQE += 1;
        this.Rfh.b(0.0D, true);
      }
      AppMethodBeat.o(307708);
      return;
    }
    finally
    {
      Log.e("LongVideoFullScreenView", localObject.toString());
      AppMethodBeat.o(307708);
    }
  }
  
  final void hiU()
  {
    AppMethodBeat.i(307692);
    try
    {
      Object localObject1 = this.QRH.getParent();
      if ((localObject1 instanceof ViewGroup)) {
        ((ViewGroup)localObject1).removeView(this.QRH);
      }
      ar.bt((Activity)this.mContext);
      localObject1 = (RelativeLayout.LayoutParams)this.Rff.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)this.Rfg.getLayoutParams()).rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.QRI.getLayoutParams()).rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 20);
      localObject1 = new RelativeLayout.LayoutParams(this.pvg - com.tencent.mm.cd.a.fromDPToPix(this.mContext, 232), -2);
      ((ViewGroup)this.Rff).addView(this.QRH, (ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(307692);
      return;
    }
    finally
    {
      Log.e("LongVideoFullScreenView", localObject2.toString());
      AppMethodBeat.o(307692);
    }
  }
  
  final void hiV()
  {
    AppMethodBeat.i(307694);
    try
    {
      Object localObject1 = this.QRH.getParent();
      if ((localObject1 instanceof ViewGroup)) {
        ((ViewGroup)localObject1).removeView(this.QRH);
      }
      ar.bt((Activity)this.mContext);
      localObject1 = (RelativeLayout.LayoutParams)this.Rff.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)this.Rfg.getLayoutParams()).rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.QRI.getLayoutParams()).rightMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 10);
      localObject1 = new RelativeLayout.LayoutParams(this.sJv - com.tencent.mm.cd.a.fromDPToPix(this.mContext, 74), -2);
      ((ViewGroup)this.Rff).addView(this.QRH, (ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(307694);
      return;
    }
    finally
    {
      Log.e("LongVideoFullScreenView", localObject2.toString());
      AppMethodBeat.o(307694);
    }
  }
  
  public final Intent hmm()
  {
    AppMethodBeat.i(307742);
    Intent localIntent = new Intent();
    try
    {
      if ((this.Rfh.isPlaying()) && (this.LJG != 0L))
      {
        this.Rfq += System.currentTimeMillis() - this.LJG;
        this.LJG = 0L;
        Log.i("LongVideoFullScreenView", "playTimeInterval update");
      }
      localIntent.putExtra("KComponentVideoType", this.oYP);
      localIntent.putExtra("KComponentCid", this.Rfi);
      localIntent.putExtra("KComponentCurrentTime", this.Rfh.getCurrPosSec());
      localIntent.putExtra("KComponentVoiceType", this.PQB);
      localIntent.putExtra("KComponentProgressType", this.Rfh.isPlaying());
      localIntent.putExtra("KComponentClickPlayControlCount", this.PQF);
      localIntent.putExtra("KComponentDoubleClickCount", this.PQH);
      localIntent.putExtra("KComponentClickVoiceControlCount", this.PQG);
      localIntent.putExtra("KComponentPlayCompletedCount", this.PQE);
      localIntent.putExtra("KComponentPlayCount", this.LKo);
      localIntent.putExtra("KComponentPlayTimeInterval", this.Rfq);
      localIntent.putExtra("KComponentIsWaiting", this.Rfn);
      localIntent.putExtra("KComponentSeekTimeDueWaiting", this.Rfo);
    }
    finally
    {
      for (;;)
      {
        Log.e("LongVideoFullScreenView", localObject.toString());
      }
    }
    AppMethodBeat.o(307742);
    return localIntent;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(307696);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(307696);
          return;
          haw();
        }
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("LongVideoFullScreenView", paramView.toString());
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
    AppMethodBeat.i(307698);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        Log.i("LongVideoFullScreenView", "ORIENTATION_LANDSCAPE");
        hiU();
        AppMethodBeat.o(307698);
        return;
      }
      if (paramConfiguration.orientation == 1)
      {
        Log.i("LongVideoFullScreenView", "ORIENTATION_PORTRAIT");
        hiV();
      }
      AppMethodBeat.o(307698);
      return;
    }
    finally
    {
      Log.e("LongVideoFullScreenView", paramConfiguration.toString());
      AppMethodBeat.o(307698);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307762);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    for (;;)
    {
      try
      {
        Log.i("LongVideoFullScreenView", "onDoubleTap");
        if (!this.QRG) {
          this.PQH += 1;
        }
        aN(this.PQR);
        if (!this.Rfh.isPlaying()) {
          continue;
        }
        bck();
      }
      finally
      {
        Log.e("LongVideoFullScreenView", paramMotionEvent.toString());
        continue;
        hax();
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(307762);
      return false;
      if (!this.PQB) {
        continue;
      }
      haw();
      drB();
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
    AppMethodBeat.i(307782);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(307782);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onSeekComplete(ITPPlayer paramITPPlayer) {}
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307758);
    try
    {
      Log.i("LongVideoFullScreenView", "onSingleTapConfirmed");
      if (!this.QSq)
      {
        this.QSq = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(307758);
        return false;
        this.QSq = false;
        setFocus(false);
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("LongVideoFullScreenView", paramMotionEvent.toString());
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307775);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(307775);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307755);
    paramView = this.nwZ;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, paramMotionEvent.aYi(), "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(307755);
    return bool;
  }
  
  void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(307745);
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
      AppMethodBeat.o(307745);
      return;
    }
    finally
    {
      Log.e("LongVideoFullScreenView", localObject.toString());
      AppMethodBeat.o(307745);
    }
    this.QSq = false;
    this.QRH.setVisibility(4);
    this.QRE.setVisibility(8);
    this.QRI.setVisibility(8);
    MMHandlerThread.removeRunnable(this.PQR);
    if (this.Rfr != null) {
      this.Rfr.Es(false);
    }
    AppMethodBeat.o(307745);
    return;
  }
  
  public void setProgressBarStatusListener(com.tencent.mm.plugin.sns.ui.listener.a parama)
  {
    this.Rfr = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LongVideoFullScreenView
 * JD-Core Version:    0.7.0.1
 */