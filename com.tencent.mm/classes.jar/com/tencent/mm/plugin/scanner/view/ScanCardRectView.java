package com.tencent.mm.plugin.scanner.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.uj;
import com.tencent.mm.f.a.uk;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.aj.a.e;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.b.a.a.a;
import com.tencent.mm.plugin.scanner.b.a.b.b;
import com.tencent.mm.plugin.scanner.b.a.c;
import com.tencent.mm.plugin.scanner.b.a.c.a;
import com.tencent.mm.plugin.scanner.b.a.c.b;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.qbar.WxQbarNative;
import com.tencent.scanlib.a.b.b.a;
import com.tencent.scanlib.a.b.d.a;
import com.tencent.scanlib.a.f;
import com.tencent.scanlib.ui.ScanView;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class ScanCardRectView
  extends ScanView
{
  private long IIw;
  private ScannerFlashSwitcher IOH;
  private IListener IPv;
  private ScanRectDecorView ISL;
  private IListener<uk> ITm;
  private CardHighLightEdgeView JaC;
  private a JaD;
  private View JaE;
  private a.a JaF;
  private com.tencent.mm.plugin.scanner.b.a.b.a JaG;
  private c.b JaH;
  private int mode;
  
  public ScanCardRectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(118389);
    this.JaF = new a.a() {};
    this.JaG = new com.tencent.mm.plugin.scanner.b.a.b.a()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118383);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          Log.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(118383);
      }
      
      public final void as(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(118382);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.PW(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.JaH = new c.b()
    {
      private LinkedList<Integer> JaL;
      private Integer JaM;
      Integer JaN;
      private Integer JaO;
      
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177502);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          Log.i("MicroMsg.ScanCardRectView", "license decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(177502);
      }
      
      public final void as(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(177501);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.PW(paramAnonymousLong2);
        }
        AppMethodBeat.o(177501);
      }
      
      public final void b(long paramAnonymousLong, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177503);
        if ((paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this)) && (paramAnonymousBundle.containsKey("param_card_edge")))
        {
          paramAnonymousBundle = paramAnonymousBundle.getBooleanArray("param_card_edge");
          ScanCardRectView.d(ScanCardRectView.this).setHighLightEdges(paramAnonymousBundle);
          if ((ScanCardRectView.e(ScanCardRectView.this) != 9) && (ScanCardRectView.e(ScanCardRectView.this) != 11))
          {
            AppMethodBeat.o(177503);
            return;
          }
          if (!ScanCardRectView.fFk())
          {
            AppMethodBeat.o(177503);
            return;
          }
          this.JaO = Integer.valueOf(this.JaO.intValue() + 1);
          if ((paramAnonymousBundle[0] == 0) || (paramAnonymousBundle[1] == 0) || (paramAnonymousBundle[2] == 0) || (paramAnonymousBundle[3] == 0))
          {
            this.JaM = Integer.valueOf(this.JaM.intValue() + 1);
            this.JaL.add(Integer.valueOf(1));
          }
          for (;;)
          {
            if ((this.JaL.size() > 60) && (((Integer)this.JaL.pollFirst()).intValue() == 1)) {
              this.JaM = Integer.valueOf(this.JaM.intValue() - 1);
            }
            if (this.JaO.intValue() < 0) {
              this.JaO = Integer.valueOf(0);
            }
            if (this.JaO.intValue() >= 70) {
              break;
            }
            AppMethodBeat.o(177503);
            return;
            this.JaL.add(Integer.valueOf(0));
          }
          final View localView;
          if (this.JaM.intValue() >= 53)
          {
            paramAnonymousBundle = (TextView)ScanCardRectView.f(ScanCardRectView.this).findViewById(a.d.bottom_tip_view);
            localView = ScanCardRectView.f(ScanCardRectView.this).findViewById(a.d.bottom_tip_icon);
            paramAnonymousBundle.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(243215);
                if (ScanCardRectView.7.this.JaN.intValue() == 1)
                {
                  AppMethodBeat.o(243215);
                  return;
                }
                ScanCardRectView.7.this.JaN = Integer.valueOf(1);
                ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.JaP, "alpha", new float[] { 1.0F, 0.0F });
                ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.JaP, "alpha", new float[] { 0.0F, 1.0F });
                AnimatorSet localAnimatorSet = new AnimatorSet();
                localAnimatorSet.setDuration(333L);
                localAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
                localObjectAnimator2.addListener(new Animator.AnimatorListener()
                {
                  public final void onAnimationCancel(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationEnd(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationRepeat(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationStart(Animator paramAnonymous3Animator)
                  {
                    AppMethodBeat.i(243232);
                    ScanCardRectView.7.1.this.JaQ.setText(ScanCardRectView.this.getContext().getResources().getString(a.g.scan_id_card_align_tips));
                    ScanCardRectView.7.1.this.JaR.setVisibility(0);
                    AppMethodBeat.o(243232);
                  }
                });
                localAnimatorSet.start();
                AppMethodBeat.o(243215);
              }
            });
            AppMethodBeat.o(177503);
            return;
          }
          if (this.JaM.intValue() >= 40)
          {
            if (this.JaN.intValue() == 2)
            {
              AppMethodBeat.o(177503);
              return;
            }
            this.JaN = Integer.valueOf(2);
            paramAnonymousBundle = (TextView)ScanCardRectView.f(ScanCardRectView.this).findViewById(a.d.bottom_tip_view);
            localView = ScanCardRectView.f(ScanCardRectView.this).findViewById(a.d.bottom_tip_icon);
            paramAnonymousBundle.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(243208);
                ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.JaP, "alpha", new float[] { 1.0F, 0.0F });
                ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.JaP, "alpha", new float[] { 0.0F, 1.0F });
                AnimatorSet localAnimatorSet = new AnimatorSet();
                localAnimatorSet.setDuration(333L);
                localAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
                localObjectAnimator2.addListener(new Animator.AnimatorListener()
                {
                  public final void onAnimationCancel(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationEnd(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationRepeat(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationStart(Animator paramAnonymous3Animator)
                  {
                    AppMethodBeat.i(243181);
                    ScanCardRectView.7.2.this.JaQ.setText(ScanCardRectView.this.getContext().getResources().getString(a.g.scan_id_card_region_tips));
                    ScanCardRectView.7.2.this.JaR.setVisibility(0);
                    AppMethodBeat.o(243181);
                  }
                });
                localAnimatorSet.start();
                AppMethodBeat.o(243208);
              }
            });
          }
        }
        AppMethodBeat.o(177503);
      }
    };
    this.IPv = new IListener() {};
    this.ITm = new IListener() {};
    AppMethodBeat.o(118389);
  }
  
  public ScanCardRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(118390);
    this.JaF = new a.a() {};
    this.JaG = new com.tencent.mm.plugin.scanner.b.a.b.a()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118383);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          Log.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(118383);
      }
      
      public final void as(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(118382);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.PW(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.JaH = new c.b()
    {
      private LinkedList<Integer> JaL;
      private Integer JaM;
      Integer JaN;
      private Integer JaO;
      
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177502);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          Log.i("MicroMsg.ScanCardRectView", "license decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(177502);
      }
      
      public final void as(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(177501);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.PW(paramAnonymousLong2);
        }
        AppMethodBeat.o(177501);
      }
      
      public final void b(long paramAnonymousLong, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177503);
        if ((paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this)) && (paramAnonymousBundle.containsKey("param_card_edge")))
        {
          paramAnonymousBundle = paramAnonymousBundle.getBooleanArray("param_card_edge");
          ScanCardRectView.d(ScanCardRectView.this).setHighLightEdges(paramAnonymousBundle);
          if ((ScanCardRectView.e(ScanCardRectView.this) != 9) && (ScanCardRectView.e(ScanCardRectView.this) != 11))
          {
            AppMethodBeat.o(177503);
            return;
          }
          if (!ScanCardRectView.fFk())
          {
            AppMethodBeat.o(177503);
            return;
          }
          this.JaO = Integer.valueOf(this.JaO.intValue() + 1);
          if ((paramAnonymousBundle[0] == 0) || (paramAnonymousBundle[1] == 0) || (paramAnonymousBundle[2] == 0) || (paramAnonymousBundle[3] == 0))
          {
            this.JaM = Integer.valueOf(this.JaM.intValue() + 1);
            this.JaL.add(Integer.valueOf(1));
          }
          for (;;)
          {
            if ((this.JaL.size() > 60) && (((Integer)this.JaL.pollFirst()).intValue() == 1)) {
              this.JaM = Integer.valueOf(this.JaM.intValue() - 1);
            }
            if (this.JaO.intValue() < 0) {
              this.JaO = Integer.valueOf(0);
            }
            if (this.JaO.intValue() >= 70) {
              break;
            }
            AppMethodBeat.o(177503);
            return;
            this.JaL.add(Integer.valueOf(0));
          }
          final View localView;
          if (this.JaM.intValue() >= 53)
          {
            paramAnonymousBundle = (TextView)ScanCardRectView.f(ScanCardRectView.this).findViewById(a.d.bottom_tip_view);
            localView = ScanCardRectView.f(ScanCardRectView.this).findViewById(a.d.bottom_tip_icon);
            paramAnonymousBundle.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(243215);
                if (ScanCardRectView.7.this.JaN.intValue() == 1)
                {
                  AppMethodBeat.o(243215);
                  return;
                }
                ScanCardRectView.7.this.JaN = Integer.valueOf(1);
                ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.JaP, "alpha", new float[] { 1.0F, 0.0F });
                ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.JaP, "alpha", new float[] { 0.0F, 1.0F });
                AnimatorSet localAnimatorSet = new AnimatorSet();
                localAnimatorSet.setDuration(333L);
                localAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
                localObjectAnimator2.addListener(new Animator.AnimatorListener()
                {
                  public final void onAnimationCancel(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationEnd(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationRepeat(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationStart(Animator paramAnonymous3Animator)
                  {
                    AppMethodBeat.i(243232);
                    ScanCardRectView.7.1.this.JaQ.setText(ScanCardRectView.this.getContext().getResources().getString(a.g.scan_id_card_align_tips));
                    ScanCardRectView.7.1.this.JaR.setVisibility(0);
                    AppMethodBeat.o(243232);
                  }
                });
                localAnimatorSet.start();
                AppMethodBeat.o(243215);
              }
            });
            AppMethodBeat.o(177503);
            return;
          }
          if (this.JaM.intValue() >= 40)
          {
            if (this.JaN.intValue() == 2)
            {
              AppMethodBeat.o(177503);
              return;
            }
            this.JaN = Integer.valueOf(2);
            paramAnonymousBundle = (TextView)ScanCardRectView.f(ScanCardRectView.this).findViewById(a.d.bottom_tip_view);
            localView = ScanCardRectView.f(ScanCardRectView.this).findViewById(a.d.bottom_tip_icon);
            paramAnonymousBundle.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(243208);
                ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.JaP, "alpha", new float[] { 1.0F, 0.0F });
                ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.JaP, "alpha", new float[] { 0.0F, 1.0F });
                AnimatorSet localAnimatorSet = new AnimatorSet();
                localAnimatorSet.setDuration(333L);
                localAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
                localObjectAnimator2.addListener(new Animator.AnimatorListener()
                {
                  public final void onAnimationCancel(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationEnd(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationRepeat(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationStart(Animator paramAnonymous3Animator)
                  {
                    AppMethodBeat.i(243181);
                    ScanCardRectView.7.2.this.JaQ.setText(ScanCardRectView.this.getContext().getResources().getString(a.g.scan_id_card_region_tips));
                    ScanCardRectView.7.2.this.JaR.setVisibility(0);
                    AppMethodBeat.o(243181);
                  }
                });
                localAnimatorSet.start();
                AppMethodBeat.o(243208);
              }
            });
          }
        }
        AppMethodBeat.o(177503);
      }
    };
    this.IPv = new IListener() {};
    this.ITm = new IListener() {};
    AppMethodBeat.o(118390);
  }
  
  public ScanCardRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(118391);
    this.JaF = new a.a() {};
    this.JaG = new com.tencent.mm.plugin.scanner.b.a.b.a()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118383);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          Log.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(118383);
      }
      
      public final void as(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(118382);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.PW(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.JaH = new c.b()
    {
      private LinkedList<Integer> JaL;
      private Integer JaM;
      Integer JaN;
      private Integer JaO;
      
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177502);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          Log.i("MicroMsg.ScanCardRectView", "license decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(177502);
      }
      
      public final void as(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(177501);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.PW(paramAnonymousLong2);
        }
        AppMethodBeat.o(177501);
      }
      
      public final void b(long paramAnonymousLong, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177503);
        if ((paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this)) && (paramAnonymousBundle.containsKey("param_card_edge")))
        {
          paramAnonymousBundle = paramAnonymousBundle.getBooleanArray("param_card_edge");
          ScanCardRectView.d(ScanCardRectView.this).setHighLightEdges(paramAnonymousBundle);
          if ((ScanCardRectView.e(ScanCardRectView.this) != 9) && (ScanCardRectView.e(ScanCardRectView.this) != 11))
          {
            AppMethodBeat.o(177503);
            return;
          }
          if (!ScanCardRectView.fFk())
          {
            AppMethodBeat.o(177503);
            return;
          }
          this.JaO = Integer.valueOf(this.JaO.intValue() + 1);
          if ((paramAnonymousBundle[0] == 0) || (paramAnonymousBundle[1] == 0) || (paramAnonymousBundle[2] == 0) || (paramAnonymousBundle[3] == 0))
          {
            this.JaM = Integer.valueOf(this.JaM.intValue() + 1);
            this.JaL.add(Integer.valueOf(1));
          }
          for (;;)
          {
            if ((this.JaL.size() > 60) && (((Integer)this.JaL.pollFirst()).intValue() == 1)) {
              this.JaM = Integer.valueOf(this.JaM.intValue() - 1);
            }
            if (this.JaO.intValue() < 0) {
              this.JaO = Integer.valueOf(0);
            }
            if (this.JaO.intValue() >= 70) {
              break;
            }
            AppMethodBeat.o(177503);
            return;
            this.JaL.add(Integer.valueOf(0));
          }
          final View localView;
          if (this.JaM.intValue() >= 53)
          {
            paramAnonymousBundle = (TextView)ScanCardRectView.f(ScanCardRectView.this).findViewById(a.d.bottom_tip_view);
            localView = ScanCardRectView.f(ScanCardRectView.this).findViewById(a.d.bottom_tip_icon);
            paramAnonymousBundle.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(243215);
                if (ScanCardRectView.7.this.JaN.intValue() == 1)
                {
                  AppMethodBeat.o(243215);
                  return;
                }
                ScanCardRectView.7.this.JaN = Integer.valueOf(1);
                ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.JaP, "alpha", new float[] { 1.0F, 0.0F });
                ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.JaP, "alpha", new float[] { 0.0F, 1.0F });
                AnimatorSet localAnimatorSet = new AnimatorSet();
                localAnimatorSet.setDuration(333L);
                localAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
                localObjectAnimator2.addListener(new Animator.AnimatorListener()
                {
                  public final void onAnimationCancel(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationEnd(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationRepeat(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationStart(Animator paramAnonymous3Animator)
                  {
                    AppMethodBeat.i(243232);
                    ScanCardRectView.7.1.this.JaQ.setText(ScanCardRectView.this.getContext().getResources().getString(a.g.scan_id_card_align_tips));
                    ScanCardRectView.7.1.this.JaR.setVisibility(0);
                    AppMethodBeat.o(243232);
                  }
                });
                localAnimatorSet.start();
                AppMethodBeat.o(243215);
              }
            });
            AppMethodBeat.o(177503);
            return;
          }
          if (this.JaM.intValue() >= 40)
          {
            if (this.JaN.intValue() == 2)
            {
              AppMethodBeat.o(177503);
              return;
            }
            this.JaN = Integer.valueOf(2);
            paramAnonymousBundle = (TextView)ScanCardRectView.f(ScanCardRectView.this).findViewById(a.d.bottom_tip_view);
            localView = ScanCardRectView.f(ScanCardRectView.this).findViewById(a.d.bottom_tip_icon);
            paramAnonymousBundle.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(243208);
                ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.JaP, "alpha", new float[] { 1.0F, 0.0F });
                ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.JaP, "alpha", new float[] { 0.0F, 1.0F });
                AnimatorSet localAnimatorSet = new AnimatorSet();
                localAnimatorSet.setDuration(333L);
                localAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
                localObjectAnimator2.addListener(new Animator.AnimatorListener()
                {
                  public final void onAnimationCancel(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationEnd(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationRepeat(Animator paramAnonymous3Animator) {}
                  
                  public final void onAnimationStart(Animator paramAnonymous3Animator)
                  {
                    AppMethodBeat.i(243181);
                    ScanCardRectView.7.2.this.JaQ.setText(ScanCardRectView.this.getContext().getResources().getString(a.g.scan_id_card_region_tips));
                    ScanCardRectView.7.2.this.JaR.setVisibility(0);
                    AppMethodBeat.o(243181);
                  }
                });
                localAnimatorSet.start();
                AppMethodBeat.o(243208);
              }
            });
          }
        }
        AppMethodBeat.o(177503);
      }
    };
    this.IPv = new IListener() {};
    this.ITm = new IListener() {};
    AppMethodBeat.o(118391);
  }
  
  private static boolean fCw()
  {
    AppMethodBeat.i(243264);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vCF, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ScanCardRectView", "id_card_scan_v2: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(243264);
      return bool;
    }
  }
  
  private void fDz()
  {
    AppMethodBeat.i(118404);
    this.IOH = ((ScannerFlashSwitcher)this.JaE.findViewById(a.d.scanner_card_flash_switcher));
    if (this.IOH != null) {
      this.IOH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(177504);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/view/ScanCardRectView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!ScanCardRectView.g(ScanCardRectView.this).gZ)
          {
            paramAnonymousView = new uk();
            paramAnonymousView.fTJ.fvK = 1;
            EventCenter.instance.publish(paramAnonymousView);
            ScanCardRectView.g(ScanCardRectView.this).fEm();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/view/ScanCardRectView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(177504);
            return;
            paramAnonymousView = new uk();
            paramAnonymousView.fTJ.fvK = 2;
            EventCenter.instance.publish(paramAnonymousView);
            ScanCardRectView.g(ScanCardRectView.this).fEn();
          }
        }
      });
    }
    EventCenter.instance.addListener(this.IPv);
    EventCenter.instance.addListener(this.ITm);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177505);
        ScanCameraLightDetector.IYP.start(((com.tencent.mm.plugin.scanner.a.a)ScanCardRectView.h(ScanCardRectView.this)).iow());
        AppMethodBeat.o(177505);
      }
    }, 300L);
    AppMethodBeat.o(118404);
  }
  
  private void fEa()
  {
    AppMethodBeat.i(118398);
    com.tencent.mm.plugin.scanner.b.a.b.fCu().release();
    c localc = c.fCv();
    long l = this.IIw;
    synchronized (localc.Brg)
    {
      if (localc.IIw == l)
      {
        localc.IIw = 0L;
        localc.IIz = 0;
        localc.IIE = null;
        localc.IIq.clear();
      }
      this.IIw = 0L;
      AppMethodBeat.o(118398);
      return;
    }
  }
  
  public final void fDY()
  {
    AppMethodBeat.i(118393);
    this.ZrD = new com.tencent.mm.plugin.scanner.a.a();
    AppMethodBeat.o(118393);
  }
  
  public Rect getDecorRect()
  {
    AppMethodBeat.i(118394);
    Rect localRect = this.ISL.getDecorRect();
    AppMethodBeat.o(118394);
    return localRect;
  }
  
  public final void init()
  {
    AppMethodBeat.i(118392);
    super.init();
    this.JaC = new CardHighLightEdgeView(getContext());
    addView(this.JaC, new FrameLayout.LayoutParams(-1, -1));
    this.ISL = new ScanRectDecorView(getContext());
    addView(this.ISL, new FrameLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(118392);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(118396);
    super.onAttachedToWindow();
    Object localObject1 = new Point();
    getDisplay().getSize((Point)localObject1);
    Log.i("MicroMsg.ScanCardRectView", "screenSize %s", new Object[] { localObject1 });
    if (this.JaE != null) {
      removeView(this.JaE);
    }
    switch (this.mode)
    {
    case 8: 
    default: 
      Log.e("MicroMsg.ScanCardRectView", "unknown mode!");
      AppMethodBeat.o(118396);
      return;
    case 7: 
      this.JaE = View.inflate(getContext(), a.e.scan_bankcard_body, null);
      localObject2 = Util.nullAs(((Activity)getContext()).getIntent().getStringExtra("bank_card_owner"), "");
      String str = String.format(getContext().getResources().getString(a.g.scan_bank_owner), new Object[] { localObject2 });
      View localView = this.JaE.findViewById(a.d.top_container);
      if (Util.isNullOrNil((String)localObject2)) {
        localView.setVisibility(4);
      }
      for (;;)
      {
        addView(this.JaE, new FrameLayout.LayoutParams(-1, -1));
        localObject2 = new Rect();
        ((Rect)localObject2).left = com.tencent.mm.ci.a.fromDPToPix(getContext(), 40);
        ((Rect)localObject2).right = (((Point)localObject1).x - com.tencent.mm.ci.a.fromDPToPix(getContext(), 40));
        ((Rect)localObject2).top = ((((Point)localObject1).y - (int)(((Rect)localObject2).width() / 1.586F)) / 2);
        ((Rect)localObject2).bottom = (((Rect)localObject2).top + (int)(((Rect)localObject2).width() / 1.586F));
        Log.i("MicroMsg.ScanCardRectView", "scan bank card rect %s", new Object[] { localObject2 });
        this.ISL.jp(((Rect)localObject2).width(), ((Rect)localObject2).height());
        this.JaC.setCardRect((Rect)localObject2);
        fDz();
        AppMethodBeat.o(118396);
        return;
        ((TextView)this.JaE.findViewById(a.d.bank_card_owner)).setText(str);
        this.JaE.findViewById(a.d.bank_card_declare).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(118378);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/view/ScanCardRectView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            paramAnonymousView = View.inflate(ScanCardRectView.this.getContext(), a.e.scan_bank_card_declare, null);
            com.tencent.mm.ui.base.h.a(ScanCardRectView.this.getContext(), ScanCardRectView.this.getContext().getString(a.g.scan_bank_card_declare_title), ScanCardRectView.this.getContext().getString(a.g.scan_bank_card_declare_ok), paramAnonymousView, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(118377);
                paramAnonymous2DialogInterface.dismiss();
                AppMethodBeat.o(118377);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/view/ScanCardRectView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(118378);
          }
        });
        localView.setVisibility(0);
      }
    case 9: 
    case 11: 
      localObject2 = new Rect();
      ((Rect)localObject2).left = com.tencent.mm.ci.a.fromDPToPix(getContext(), 40);
      ((Rect)localObject2).right = (((Point)localObject1).x - com.tencent.mm.ci.a.fromDPToPix(getContext(), 40));
      ((Rect)localObject2).top = ((((Point)localObject1).y - (int)(((Rect)localObject2).width() / 1.586F)) / 2);
      ((Rect)localObject2).bottom = (((Rect)localObject2).top + (int)(((Rect)localObject2).width() / 1.586F));
      Log.i("MicroMsg.ScanCardRectView", "scan id card rect %s", new Object[] { localObject2 });
      this.ISL.jp(((Rect)localObject2).width(), ((Rect)localObject2).height());
      this.JaC.setCardRect((Rect)localObject2);
      this.JaE = View.inflate(getContext(), a.e.scan_idcard_body, null);
      addView(this.JaE, new FrameLayout.LayoutParams(-1, -1));
      localObject1 = (TextView)this.JaE.findViewById(a.d.bottom_tip_view);
      ((TextView)localObject1).setShadowLayer(3.0F, 0.0F, 0.0F, -16777216);
      ((TextView)localObject1).setText(getContext().getResources().getString(a.g.scan_id_card_default_tips));
      ar.a(((TextView)localObject1).getPaint(), 0.8F);
      fDz();
      AppMethodBeat.o(118396);
      return;
    }
    Object localObject2 = new Rect();
    ((Rect)localObject2).left = com.tencent.mm.ci.a.fromDPToPix(getContext(), 40);
    ((Rect)localObject2).right = (((Point)localObject1).x - com.tencent.mm.ci.a.fromDPToPix(getContext(), 40));
    ((Rect)localObject2).top = ((((Point)localObject1).y - (int)(((Rect)localObject2).width() / 1.467F)) / 2);
    ((Rect)localObject2).bottom = (((Rect)localObject2).top + (int)(((Rect)localObject2).width() / 1.467F));
    Log.i("MicroMsg.ScanCardRectView", "scan driver card rect %s", new Object[] { localObject2 });
    this.ISL.jp(((Rect)localObject2).width(), ((Rect)localObject2).height());
    this.JaC.setCardRect((Rect)localObject2);
    this.JaE = View.inflate(getContext(), a.e.scan_idcard_body, null);
    addView(this.JaE, new FrameLayout.LayoutParams(-1, -1));
    ((TextView)this.JaE.findViewById(a.d.bottom_tip_view)).setText("");
    fDz();
    AppMethodBeat.o(118396);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(118403);
    Log.i("MicroMsg.ScanCardRectView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      PW(0L);
    }
    WO(ZrG);
    AppMethodBeat.o(118403);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(118401);
    super.onDestroy();
    com.tencent.mm.plugin.scanner.b.a.b.fCu().release();
    c.fCv().release();
    AppMethodBeat.o(118401);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(118399);
    super.onPause();
    fEa();
    AppMethodBeat.o(118399);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(118402);
    super.onPreviewFrame(paramArrayOfByte, paramCamera);
    paramCamera = new StringBuilder("onPreviewFrame null data:");
    boolean bool;
    if (paramArrayOfByte == null) {
      bool = true;
    }
    Point localPoint;
    int i;
    int j;
    int k;
    for (;;)
    {
      Log.i("MicroMsg.ScanCardRectView", bool);
      if ((this.ZrD.egx()) && (((com.tencent.mm.plugin.scanner.a.a)this.ZrD).fCr())) {
        ScanCameraLightDetector.IYP.P(paramArrayOfByte, ((com.tencent.mm.plugin.scanner.a.a)this.ZrD).ios().x, ((com.tencent.mm.plugin.scanner.a.a)this.ZrD).ios().y);
      }
      if (this.mode == 7)
      {
        ??? = ((com.tencent.scanlib.a.a)this.ZrD).G(getDecorRect());
        paramCamera = com.tencent.mm.plugin.scanner.b.a.b.fCu();
        localPoint = this.ZrD.ios();
        i = this.ZrD.getCameraRotation();
        synchronized (paramCamera.Brg)
        {
          if ((((Rect)???).width() != paramCamera.IIt.width()) || (((Rect)???).height() != paramCamera.IIt.height())) {}
          synchronized (paramCamera.IIr)
          {
            if (paramCamera.jvb) {
              WxQbarNative.focusedEngineRelease();
            }
            paramCamera.jvb = false;
            Log.i("MicroMsg.BankCardDetectQueue", "resolution %s, rotation %d, rect %s", new Object[] { localPoint, Integer.valueOf(i), ??? });
            if (!paramCamera.jvb) {}
            synchronized (paramCamera.IIr)
            {
              Log.i("MicroMsg.BankCardDetectQueue", "rect %s", new Object[] { ??? });
              paramCamera.IIt = ((Rect)???);
              j = (int)(((Rect)???).width() * com.tencent.mm.plugin.scanner.b.a.b.IIp);
              k = (int)(((Rect)???).height() * com.tencent.mm.plugin.scanner.b.a.b.IIp);
              paramCamera.kXj.left = (((Rect)???).left - (j - ((Rect)???).width()) / 2);
              paramCamera.kXj.top = (((Rect)???).top - (k - ((Rect)???).height()) / 2);
              paramCamera.kXj.right = (paramCamera.kXj.left + j);
              paramCamera.kXj.bottom = (paramCamera.kXj.top + k);
              Log.i("MicroMsg.BankCardDetectQueue", "cropRect %s", new Object[] { paramCamera.kXj });
              if (WxQbarNative.focusedEngineForBankcardInit(j, k, 8, false) == 0)
              {
                bool = true;
                label436:
                paramCamera.jvb = bool;
                if (!paramCamera.jvb) {}
              }
            }
          }
        }
        synchronized (paramCamera.Brg)
        {
          paramCamera.IIq.clear();
          paramCamera.IIq.put("param_preview_data", paramArrayOfByte);
          paramCamera.IIq.put("param_camera_resolution", localPoint);
          paramCamera.IIq.put("param_camera_rotation", Integer.valueOf(i));
          if ((!paramCamera.IIy) && (paramCamera.IIw != 0L))
          {
            Log.i("MicroMsg.BankCardDetectQueue", "%d submit decode bankcard", new Object[] { Long.valueOf(paramCamera.IIw) });
            paramCamera.IIv.execute(new b.b(paramCamera, paramCamera.IIw));
          }
          if ((!((com.tencent.scanlib.a.a)this.ZrD).fDZ()) && (com.tencent.mm.plugin.scanner.b.a.b.fCu().IIz > 10))
          {
            Log.i("MicroMsg.ScanCardRectView", "change to FOCUS_MODE_AUTO");
            this.ZrD.bCY("auto");
            WO(100L);
          }
          AppMethodBeat.o(118402);
          return;
          bool = false;
          continue;
          paramArrayOfByte = finally;
          AppMethodBeat.o(118402);
          throw paramArrayOfByte;
          paramArrayOfByte = finally;
          AppMethodBeat.o(118402);
          throw paramArrayOfByte;
          bool = false;
          break label436;
          paramArrayOfByte = finally;
          AppMethodBeat.o(118402);
          throw paramArrayOfByte;
        }
      }
    }
    if (this.mode == 11)
    {
      paramCamera = getDecorRect();
      double d1 = 0.0D;
      if (fCw()) {
        d1 = 30.0D;
      }
      double d3 = (paramCamera.bottom - paramCamera.top) / (paramCamera.right - paramCamera.left);
      double d4 = paramCamera.right - paramCamera.left;
      double d5 = paramCamera.bottom - paramCamera.top;
      double d2 = d1 * 0.5D;
      d1 = (d3 * (d4 + d1) - d5) * 0.5D;
      i = paramCamera.left;
      j = (int)d2;
      k = paramCamera.top;
      int m = (int)d1;
      int n = paramCamera.right;
      paramCamera = new Rect(i - j, k - m, (int)d2 + n, paramCamera.bottom + (int)d1);
      ??? = ((com.tencent.scanlib.a.a)this.ZrD).G(paramCamera);
      paramCamera = c.fCv();
      localPoint = this.ZrD.ios();
      j = this.ZrD.getCameraRotation();
    }
    for (;;)
    {
      synchronized (paramCamera.Brg)
      {
        if ((((Rect)???).width() != paramCamera.IIt.width()) || (((Rect)???).height() != paramCamera.IIt.height()))
        {
          paramCamera.release();
          paramCamera.jvb = false;
        }
        if (!paramCamera.jvb) {}
        synchronized (paramCamera.IIr)
        {
          paramCamera.IIt = ((Rect)???);
          i = (int)(((Rect)???).width() * 1.05D) / 4 * 4;
          k = (int)(((Rect)???).height() * 1.05D) / 4 * 4;
          paramCamera.kXj.left = (((Rect)???).left - (i - ((Rect)???).width()) / 2);
          paramCamera.kXj.top = (((Rect)???).top - (k - ((Rect)???).height()) / 2);
          paramCamera.kXj.right = (i + paramCamera.kXj.left);
          paramCamera.kXj.bottom = (k + paramCamera.kXj.top);
          if (j % 180 != 0)
          {
            k = (localPoint.y - paramCamera.kXj.height()) / 2;
            i = (localPoint.x - paramCamera.kXj.width()) / 2;
            if (c.fCw()) {
              i = ((Rect)???).left;
            }
            paramCamera.kXj = new Rect(k, i, paramCamera.kXj.height() + k, paramCamera.kXj.width() + i);
          }
          Log.i("MicroMsg.LicenseCardDecodeQueue", "init cropRect %s", new Object[] { paramCamera.kXj });
          i = LibCardRecog.recognizeCardInit(paramCamera.kXj.width(), paramCamera.kXj.height(), paramCamera.lnm);
          Log.d("MicroMsg.LicenseCardDecodeQueue", "initRet %d, cropWidth %d, cropHeight %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramCamera.kXj.width()), Integer.valueOf(paramCamera.kXj.height()) });
          if (i == 0)
          {
            bool = true;
            paramCamera.jvb = bool;
            if (!paramCamera.jvb) {}
          }
        }
      }
      synchronized (paramCamera.Brg)
      {
        paramCamera.IIq.clear();
        paramCamera.IIq.put("param_preview_data", paramArrayOfByte);
        paramCamera.IIq.put("param_camera_resolution", localPoint);
        paramCamera.IIq.put("param_camera_rotation", Integer.valueOf(j));
        if ((!paramCamera.IIy) && (paramCamera.IIw != 0L))
        {
          Log.i("MicroMsg.LicenseCardDecodeQueue", "%d submit decode license card", new Object[] { Long.valueOf(paramCamera.IIw) });
          paramCamera.IIs.execute(new c.a(paramCamera, paramCamera.IIw));
        }
        if ((!((com.tencent.scanlib.a.a)this.ZrD).fDZ()) && (c.fCv().IIz > 10))
        {
          Log.i("MicroMsg.ScanCardRectView", "change to FOCUS_MODE_AUTO");
          this.ZrD.bCY("auto");
          WO(100L);
        }
        AppMethodBeat.o(118402);
        return;
        paramArrayOfByte = finally;
        AppMethodBeat.o(118402);
        throw paramArrayOfByte;
        bool = false;
        continue;
        paramArrayOfByte = finally;
        AppMethodBeat.o(118402);
        throw paramArrayOfByte;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(118397);
    super.onResume();
    com.tencent.mm.plugin.scanner.b.a.b localb;
    long l;
    com.tencent.mm.plugin.scanner.b.a.b.a locala;
    if (!this.ZrD.isOpen())
    {
      a(new b.b.a()
      {
        public final void fEl()
        {
          AppMethodBeat.i(118379);
          ScanCardRectView.this.a(new b.d.a()
          {
            public final void fEk()
            {
              AppMethodBeat.i(177499);
              ScanCardRectView.this.PW(0L);
              AppMethodBeat.o(177499);
            }
          });
          AppMethodBeat.o(118379);
        }
      });
      this.IIw = System.currentTimeMillis();
      if (this.mode != 7) {
        break label157;
      }
      localb = com.tencent.mm.plugin.scanner.b.a.b.fCu();
      l = this.IIw;
      locala = this.JaG;
    }
    for (;;)
    {
      label157:
      synchronized (localb.Brg)
      {
        localb.IIw = l;
        localb.IIz = 0;
        localb.IIx = locala;
        this.ISL.dlp();
        AppMethodBeat.o(118397);
        return;
        if (!this.ZrD.egx())
        {
          a(new b.d.a()
          {
            public final void fEk()
            {
              AppMethodBeat.i(177500);
              ScanCardRectView.this.PW(0L);
              AppMethodBeat.o(177500);
            }
          });
          break;
        }
        PW(0L);
      }
      if (this.mode == 10) {
        if ((this.mode == 9) || (this.mode == 11)) {
          c.fCv().a(1, this.IIw, this.JaH);
        } else if (this.mode == 10) {
          c.fCv().a(2, this.IIw, this.JaH);
        }
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(118400);
    super.onStop();
    aYA();
    if (this.IOH != null) {
      this.IOH.fEn();
    }
    ScanCameraLightDetector.IYP.stop();
    EventCenter.instance.removeListener(this.ITm);
    EventCenter.instance.removeListener(this.IPv);
    AppMethodBeat.o(118400);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(118395);
    this.ISL.setDecorRect(paramRect);
    this.JaC.setCardRect(paramRect);
    AppMethodBeat.o(118395);
  }
  
  public void setMode(int paramInt)
  {
    this.mode = paramInt;
    this.IIw = 0L;
  }
  
  public void setScanCallback(a parama)
  {
    this.JaD = parama;
  }
  
  public static abstract interface a
  {
    public abstract void e(long paramLong, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanCardRectView
 * JD-Core Version:    0.7.0.1
 */