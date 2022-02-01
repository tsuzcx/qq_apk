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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am;
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
  volatile boolean cAX;
  View contentView;
  private GestureDetector iKD;
  volatile boolean isFirst;
  int ism;
  private String kHA;
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
  private volatile boolean zGF;
  ImageView zGG;
  View zGH;
  Runnable zGJ;
  private int zGK;
  String zSA;
  volatile boolean zSE;
  private long zSF;
  private com.tencent.mm.plugin.sns.ui.d.a zSG;
  FrameLayout zSt;
  View zSu;
  View zSv;
  String zSx;
  int zSy;
  int zSz;
  OfflineVideoView zWt;
  volatile boolean zxZ;
  String zzR;
  
  public SightVideoFullScreenView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(198232);
    this.contentView = null;
    this.zFN = false;
    this.zGF = false;
    this.cAX = true;
    this.zFI = true;
    this.zxZ = false;
    this.isFirst = true;
    this.zSE = false;
    this.zFW = dZW();
    this.rFm = dZX();
    this.wiC = 0L;
    this.zFT = 0;
    this.zGK = 0;
    this.zFU = 0;
    this.zFS = 0;
    this.wji = 0;
    this.zSF = 0L;
    this.zFF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198230);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(198230);
      }
    };
    this.zGJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198231);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(198231);
      }
    };
    this.mContext = paramContext;
    this.iKD = new GestureDetector(this);
    AppMethodBeat.o(198232);
  }
  
  public SightVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(198233);
    this.contentView = null;
    this.zFN = false;
    this.zGF = false;
    this.cAX = true;
    this.zFI = true;
    this.zxZ = false;
    this.isFirst = true;
    this.zSE = false;
    this.zFW = dZW();
    this.rFm = dZX();
    this.wiC = 0L;
    this.zFT = 0;
    this.zGK = 0;
    this.zFU = 0;
    this.zFS = 0;
    this.wji = 0;
    this.zSF = 0L;
    this.zFF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198230);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(198230);
      }
    };
    this.zGJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198231);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(198231);
      }
    };
    this.mContext = paramContext;
    this.iKD = new GestureDetector(this);
    AppMethodBeat.o(198233);
  }
  
  public SightVideoFullScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(198234);
    this.contentView = null;
    this.zFN = false;
    this.zGF = false;
    this.cAX = true;
    this.zFI = true;
    this.zxZ = false;
    this.isFirst = true;
    this.zSE = false;
    this.zFW = dZW();
    this.rFm = dZX();
    this.wiC = 0L;
    this.zFT = 0;
    this.zGK = 0;
    this.zFU = 0;
    this.zFS = 0;
    this.wji = 0;
    this.zSF = 0L;
    this.zFF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198230);
        SightVideoFullScreenView.c(SightVideoFullScreenView.this, false);
        AppMethodBeat.o(198230);
      }
    };
    this.zGJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198231);
        SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
        AppMethodBeat.o(198231);
      }
    };
    this.mContext = paramContext;
    this.iKD = new GestureDetector(this);
    AppMethodBeat.o(198234);
  }
  
  private static void aq(Runnable paramRunnable)
  {
    AppMethodBeat.i(198248);
    try
    {
      aq.aA(paramRunnable);
      aq.o(paramRunnable, 4000L);
      AppMethodBeat.o(198248);
      return;
    }
    catch (Throwable paramRunnable)
    {
      ad.e("SightVideoFullScreenView", paramRunnable.toString());
      AppMethodBeat.o(198248);
    }
  }
  
  private View.OnClickListener dZW()
  {
    AppMethodBeat.i(198242);
    View.OnClickListener local6 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198227);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
            ad.e("SightVideoFullScreenView", paramAnonymousView.toString());
            continue;
            SightVideoFullScreenView.this.dWn();
            continue;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198227);
          return;
          if (!SightVideoFullScreenView.l(SightVideoFullScreenView.this)) {
            continue;
          }
          SightVideoFullScreenView.this.dWl();
          SightVideoFullScreenView.this.eaO();
        }
      }
    };
    AppMethodBeat.o(198242);
    return local6;
  }
  
  private com.tencent.mm.plugin.sight.decode.ui.b dZX()
  {
    AppMethodBeat.i(198243);
    com.tencent.mm.plugin.sight.decode.ui.b local7 = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqD()
      {
        AppMethodBeat.i(198228);
        try
        {
          if (SightVideoFullScreenView.a(SightVideoFullScreenView.this) != null) {
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).eaf();
          }
          SightVideoFullScreenView.c(SightVideoFullScreenView.this, true);
          AppMethodBeat.o(198228);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(198228);
        }
      }
      
      public final void nM(int paramAnonymousInt)
      {
        AppMethodBeat.i(198229);
        try
        {
          ad.i("SightVideoFullScreenView", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
          if (SightVideoFullScreenView.l(SightVideoFullScreenView.this)) {
            SightVideoFullScreenView.this.dWl();
          }
          for (;;)
          {
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).aC(paramAnonymousInt * 1000, true);
            SightVideoFullScreenView.b(SightVideoFullScreenView.this, true);
            aq.aA(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
            SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(198229);
            return;
            SightVideoFullScreenView.this.dWn();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(198229);
        }
      }
    };
    AppMethodBeat.o(198243);
    return local7;
  }
  
  final void dWK()
  {
    AppMethodBeat.i(198235);
    try
    {
      am.aG((Activity)this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.zSu.getLayoutParams();
      localLayoutParams.leftMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 64);
      localLayoutParams.rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 64);
      ((RelativeLayout.LayoutParams)this.zSv.getLayoutParams()).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.zGG.getLayoutParams()).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 20);
      ((RelativeLayout.LayoutParams)this.zFA.getLayoutParams()).width = (this.ltB - com.tencent.mm.cc.a.fromDPToPix(this.mContext, 232));
      AppMethodBeat.o(198235);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(198235);
    }
  }
  
  final void dWL()
  {
    AppMethodBeat.i(198236);
    try
    {
      am.aG((Activity)this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.zSu.getLayoutParams();
      localLayoutParams.leftMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 0);
      localLayoutParams.rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 0);
      ((RelativeLayout.LayoutParams)this.zSv.getLayoutParams()).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.zGG.getLayoutParams()).rightMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 10);
      ((RelativeLayout.LayoutParams)this.zFA.getLayoutParams()).width = (this.ltA - com.tencent.mm.cc.a.fromDPToPix(this.mContext, 74));
      AppMethodBeat.o(198236);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(198236);
    }
  }
  
  public final void dWl()
  {
    AppMethodBeat.i(198237);
    try
    {
      this.zFB.setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131690341));
      this.zWt.setMute(true);
      this.zFJ = true;
      AppMethodBeat.o(198237);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(198237);
    }
  }
  
  public final void dWn()
  {
    AppMethodBeat.i(198238);
    try
    {
      this.zFB.setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131690342));
      this.zWt.setMute(false);
      this.zFJ = false;
      AppMethodBeat.o(198238);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(198238);
    }
  }
  
  public final void eaO()
  {
    AppMethodBeat.i(198240);
    try
    {
      if (this.zFN)
      {
        ad.e("SightVideoFullScreenView", "last download fail, try again");
        this.zWt.cxv();
        AppMethodBeat.o(198240);
        return;
      }
      if ((!this.zGF) && (!TextUtils.isEmpty(this.kHA)))
      {
        this.zWt.agT(this.kHA);
        this.zGF = true;
      }
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198225);
          try
          {
            ad.i("SightVideoFullScreenView", "sightVideoStartPlay");
            SightVideoFullScreenView.a(SightVideoFullScreenView.this).start();
            SightVideoFullScreenView.b(SightVideoFullScreenView.this, true);
            aq.aA(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
            SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(8);
            AppMethodBeat.o(198225);
            return;
          }
          catch (Throwable localThrowable)
          {
            ad.e("SightVideoFullScreenView", localThrowable.toString());
            AppMethodBeat.o(198225);
          }
        }
      });
      this.wiC = System.currentTimeMillis();
      this.wji += 1;
      AppMethodBeat.o(198240);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(198240);
    }
  }
  
  final void eaP()
  {
    AppMethodBeat.i(198241);
    ad.d("SightVideoFullScreenView", "pause play");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198226);
        try
        {
          ad.i("SightVideoFullScreenView", "sightVideoPausePlay");
          SightVideoFullScreenView.a(SightVideoFullScreenView.this).eaf();
          SightVideoFullScreenView.b(SightVideoFullScreenView.this, false);
          SightVideoFullScreenView.o(SightVideoFullScreenView.this).setVisibility(0);
          SightVideoFullScreenView.as(SightVideoFullScreenView.n(SightVideoFullScreenView.this));
          AppMethodBeat.o(198226);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.e("SightVideoFullScreenView", localThrowable.toString());
          AppMethodBeat.o(198226);
        }
      }
    });
    if (this.wiC != 0L)
    {
      this.zSF += System.currentTimeMillis() - this.wiC;
      this.wiC = 0L;
      ad.i("SightVideoFullScreenView", "playTimeInterval update");
    }
    AppMethodBeat.o(198241);
  }
  
  public final Intent eaQ()
  {
    AppMethodBeat.i(198244);
    Intent localIntent = new Intent();
    try
    {
      if ((this.zWt.isPlaying()) && (this.wiC != 0L))
      {
        this.zSF += System.currentTimeMillis() - this.wiC;
        this.wiC = 0L;
        ad.i("SightVideoFullScreenView", "playTimeInterval update");
      }
      localIntent.putExtra("KComponentVideoType", this.ism);
      localIntent.putExtra("KComponentCid", this.zSx);
      localIntent.putExtra("KComponentCurrentTime", this.zWt.getCurrentPositionMs());
      localIntent.putExtra("KComponentVoiceType", this.zFJ);
      localIntent.putExtra("KComponentProgressType", this.zWt.isPlaying());
      localIntent.putExtra("KComponentClickPlayControlCount", this.zFT);
      localIntent.putExtra("KComponentDoubleClickCount", this.zGK);
      localIntent.putExtra("KComponentClickVoiceControlCount", this.zFU);
      localIntent.putExtra("KComponentPlayCompletedCount", this.zFS);
      localIntent.putExtra("KComponentPlayCount", this.wji);
      localIntent.putExtra("KComponentPlayTimeInterval", this.zSF);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.e("SightVideoFullScreenView", localThrowable.toString());
      }
    }
    AppMethodBeat.o(198244);
    return localIntent;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(198245);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198245);
          return;
          dWl();
        }
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        ad.e("SightVideoFullScreenView", paramView.toString());
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
    AppMethodBeat.i(198246);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      if (paramConfiguration.orientation == 2)
      {
        ad.i("SightVideoFullScreenView", "ORIENTATION_LANDSCAPE");
        dWK();
        AppMethodBeat.o(198246);
        return;
      }
      if (paramConfiguration.orientation == 1)
      {
        ad.i("SightVideoFullScreenView", "ORIENTATION_PORTRAIT");
        dWL();
      }
      AppMethodBeat.o(198246);
      return;
    }
    catch (Throwable paramConfiguration)
    {
      ad.e("SightVideoFullScreenView", paramConfiguration.toString());
      AppMethodBeat.o(198246);
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198251);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    try
    {
      ad.i("SightVideoFullScreenView", "onDoubleTap");
      this.zGK += 1;
      aq(this.zFF);
      if (this.zWt.isPlaying()) {
        eaP();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(198251);
        return false;
        if (!this.zFJ) {
          break;
        }
        dWl();
        eaO();
      }
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        ad.e("SightVideoFullScreenView", paramMotionEvent.toString());
        continue;
        dWn();
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
    AppMethodBeat.i(198253);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(198253);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198250);
    try
    {
      ad.i("SightVideoFullScreenView", "onSingleTapConfirmed");
      if (!this.zFI)
      {
        this.zFI = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(198250);
        return false;
        this.zFI = false;
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
    AppMethodBeat.i(198252);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(198252);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198249);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    paramView = this.iKD;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.ahp(), "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.mq(0)), "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(198249);
    return bool;
  }
  
  final void rE(boolean paramBoolean)
  {
    AppMethodBeat.i(198239);
    try
    {
      this.zFA.setIsPlay(paramBoolean);
      this.zFA.getPlayBtn().getLayoutParams().width = this.length;
      this.zFA.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        ad.i("SightVideoFullScreenView", "startPlay");
        this.zFA.getPlayBtn().setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131691470));
        AppMethodBeat.o(198239);
        return;
      }
      ad.i("SightVideoFullScreenView", "pausePlay");
      this.zFA.getPlayBtn().setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131691469));
      AppMethodBeat.o(198239);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(198239);
    }
  }
  
  void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(198247);
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
      AppMethodBeat.o(198247);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("SightVideoFullScreenView", localThrowable.toString());
      AppMethodBeat.o(198247);
    }
    this.zFI = false;
    this.zFA.setVisibility(4);
    this.zFB.setVisibility(8);
    this.zGG.setVisibility(8);
    aq.aA(this.zFF);
    if (this.zSG != null) {
      this.zSG.rY(false);
    }
    AppMethodBeat.o(198247);
    return;
  }
  
  public void setProgressBarStatusListener(com.tencent.mm.plugin.sns.ui.d.a parama)
  {
    this.zSG = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView
 * JD-Core Version:    0.7.0.1
 */