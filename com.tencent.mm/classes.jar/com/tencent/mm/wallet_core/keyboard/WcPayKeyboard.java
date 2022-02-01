package com.tencent.mm.wallet_core.keyboard;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;

public class WcPayKeyboard
  extends RelativeLayout
{
  public boolean LTA;
  private ObjectAnimator LTB;
  private ObjectAnimator LTC;
  private TextView LTh;
  private TextView LTi;
  private TextView LTj;
  private TextView LTk;
  private TextView LTl;
  private TextView LTm;
  private TextView LTn;
  private TextView LTo;
  private TextView LTp;
  private TextView LTq;
  private TextView LTr;
  private TextView LTs;
  private View LTt;
  private ViewGroup LTu;
  private LinearLayout LTv;
  private WcPayKeyboardAnimationActionButton LTw;
  public View LTx;
  private WcPayKeyboard.b LTy;
  private a LTz;
  public EditText mInputEditText;
  private TextView mpP;
  
  public WcPayKeyboard(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(72671);
    this.LTy = WcPayKeyboard.b.LTM;
    this.LTA = false;
    this.LTB = null;
    this.LTC = null;
    init();
    AppMethodBeat.o(72671);
  }
  
  public WcPayKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72672);
    this.LTy = WcPayKeyboard.b.LTM;
    this.LTA = false;
    this.LTB = null;
    this.LTC = null;
    init();
    AppMethodBeat.o(72672);
  }
  
  public WcPayKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72673);
    this.LTy = WcPayKeyboard.b.LTM;
    this.LTA = false;
    this.LTB = null;
    this.LTC = null;
    init();
    AppMethodBeat.o(72673);
  }
  
  private void aZ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(72686);
    if (paramBoolean1)
    {
      this.LTw.setVisibility(0);
      if (this.LTw.LUd)
      {
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        this.LTs.getLocationOnScreen(arrayOfInt1);
        this.LTu.getLocationOnScreen(arrayOfInt2);
        if (this.mpP.isShown())
        {
          this.mpP.getHeight();
          com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
        }
        this.LTt.getHeight();
        com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
        int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
        this.LTw.V(this.LTs.getWidth(), this.LTs.getHeight(), i, arrayOfInt1[0]);
      }
      for (;;)
      {
        this.LTw.LUa = this.LTs.getText();
        this.LTs.setVisibility(4);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(72663);
            WcPayKeyboardAnimationActionButton localWcPayKeyboardAnimationActionButton = WcPayKeyboard.d(WcPayKeyboard.this);
            if (localWcPayKeyboardAnimationActionButton.yLH != null) {
              localWcPayKeyboardAnimationActionButton.yLH.start();
            }
            WcPayKeyboard.e(WcPayKeyboard.this);
            AppMethodBeat.o(72663);
          }
        });
        AppMethodBeat.o(72686);
        return;
        this.LTw.fVA();
      }
    }
    if (paramBoolean2)
    {
      this.LTw.fVG();
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(72664);
          WcPayKeyboard.f(WcPayKeyboard.this);
          WcPayKeyboardAnimationActionButton localWcPayKeyboardAnimationActionButton = WcPayKeyboard.d(WcPayKeyboard.this);
          if (localWcPayKeyboardAnimationActionButton.LUo != null) {
            localWcPayKeyboardAnimationActionButton.LUo.start();
          }
          AppMethodBeat.o(72664);
        }
      });
      AppMethodBeat.o(72686);
      return;
    }
    this.LTw.fVK();
    this.LTw.setVisibility(8);
    AppMethodBeat.o(72686);
  }
  
  private boolean fVr()
  {
    return this.LTy == WcPayKeyboard.b.LTL;
  }
  
  private boolean fVw()
  {
    AppMethodBeat.i(72685);
    boolean bool1;
    if (this.LTC == null)
    {
      bool1 = false;
      if (this.LTB != null) {
        break label51;
      }
    }
    label51:
    for (boolean bool2 = false;; bool2 = this.LTB.isRunning())
    {
      if ((!bool1) && (!bool2)) {
        break label62;
      }
      AppMethodBeat.o(72685);
      return true;
      bool1 = this.LTC.isRunning();
      break;
    }
    label62:
    AppMethodBeat.o(72685);
    return false;
  }
  
  private void fVx()
  {
    AppMethodBeat.i(72688);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772171);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(72667);
        WcPayKeyboard.d(WcPayKeyboard.this).setVisibility(4);
        if (this.LTI) {
          WcPayKeyboard.this.setVisibility(8);
        }
        AppMethodBeat.o(72667);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.LTw.startAnimation(localAnimation);
    AppMethodBeat.o(72688);
  }
  
  private void fVy()
  {
    AppMethodBeat.i(72689);
    setVisibility(0);
    this.LTw.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772170);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.LTw.startAnimation(localAnimation);
    AppMethodBeat.o(72689);
  }
  
  private void init()
  {
    AppMethodBeat.i(72674);
    LayoutInflater.from(getContext()).inflate(2131496059, this, true);
    this.LTv = ((LinearLayout)findViewById(2131301263));
    this.LTq = ((TextView)findViewById(2131301251));
    this.LTh = ((TextView)findViewById(2131301252));
    this.LTi = ((TextView)findViewById(2131301253));
    this.LTj = ((TextView)findViewById(2131301254));
    this.LTk = ((TextView)findViewById(2131301255));
    this.LTl = ((TextView)findViewById(2131301256));
    this.LTm = ((TextView)findViewById(2131301257));
    this.LTn = ((TextView)findViewById(2131301258));
    this.LTo = ((TextView)findViewById(2131301259));
    this.LTp = ((TextView)findViewById(2131301260));
    this.LTr = ((TextView)findViewById(2131301265));
    this.LTt = findViewById(2131301264);
    this.LTs = ((TextView)findViewById(2131301261));
    this.LTw = ((WcPayKeyboardAnimationActionButton)findViewById(2131301262));
    this.mpP = ((TextView)findViewById(2131301267));
    this.LTu = ((ViewGroup)findViewById(2131301266));
    this.LTs.setTypeface(Typeface.defaultFromStyle(1));
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72652);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/keyboard/WcPayKeyboard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (WcPayKeyboard.a(WcPayKeyboard.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/keyboard/WcPayKeyboard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72652);
          return;
        }
        int i;
        if (paramAnonymousView.getId() == 2131301251) {
          i = 7;
        }
        for (;;)
        {
          if (!bu.jB(i, 0)) {
            paramAnonymousView.performHapticFeedback(0, 2);
          }
          if (paramAnonymousView.getId() != 2131301261) {
            paramAnonymousView.getId();
          }
          WcPayKeyboard.a(WcPayKeyboard.this).dispatchKeyEvent(new KeyEvent(0, i));
          WcPayKeyboard.a(WcPayKeyboard.this).dispatchKeyEvent(new KeyEvent(1, i));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/keyboard/WcPayKeyboard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72652);
          return;
          if (paramAnonymousView.getId() == 2131301252) {
            i = 8;
          } else if (paramAnonymousView.getId() == 2131301253) {
            i = 9;
          } else if (paramAnonymousView.getId() == 2131301254) {
            i = 10;
          } else if (paramAnonymousView.getId() == 2131301255) {
            i = 11;
          } else if (paramAnonymousView.getId() == 2131301256) {
            i = 12;
          } else if (paramAnonymousView.getId() == 2131301257) {
            i = 13;
          } else if (paramAnonymousView.getId() == 2131301258) {
            i = 14;
          } else if (paramAnonymousView.getId() == 2131301259) {
            i = 15;
          } else if (paramAnonymousView.getId() == 2131301260) {
            i = 16;
          } else if (paramAnonymousView.getId() == 2131301264) {
            i = 67;
          } else if (paramAnonymousView.getId() == 2131301265) {
            i = 56;
          } else if ((paramAnonymousView.getId() == 2131301261) || (paramAnonymousView.getId() == 2131301262)) {
            i = 66;
          } else {
            i = 0;
          }
        }
      }
    };
    this.LTv.setOnClickListener(local1);
    this.LTq.setOnClickListener(local1);
    this.LTh.setOnClickListener(local1);
    this.LTi.setOnClickListener(local1);
    this.LTj.setOnClickListener(local1);
    this.LTk.setOnClickListener(local1);
    this.LTl.setOnClickListener(local1);
    this.LTm.setOnClickListener(local1);
    this.LTn.setOnClickListener(local1);
    this.LTo.setOnClickListener(local1);
    this.LTp.setOnClickListener(local1);
    this.LTt.setOnClickListener(local1);
    this.LTr.setOnClickListener(local1);
    this.LTs.setOnClickListener(local1);
    this.LTw.setOnClickListener(local1);
    AppMethodBeat.o(72674);
  }
  
  private void setWindowViewBottomMargin(int paramInt)
  {
    AppMethodBeat.i(72692);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.LTx.getLayoutParams();
    localLayoutParams.bottomMargin = paramInt;
    this.LTx.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(72692);
  }
  
  private void zA(final boolean paramBoolean)
  {
    AppMethodBeat.i(72691);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772138);
    localAnimation.setDuration(330L);
    localAnimation.setInterpolator(new LinearInterpolator());
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(72657);
        WcPayKeyboard.c(WcPayKeyboard.this).setVisibility(4);
        if (paramBoolean) {
          WcPayKeyboard.this.setVisibility(8);
        }
        AppMethodBeat.o(72657);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.LTv.startAnimation(localAnimation);
    setWindowViewBottomMargin(0);
    AppMethodBeat.o(72691);
  }
  
  private void zy(final boolean paramBoolean)
  {
    AppMethodBeat.i(72687);
    if (this.LTA)
    {
      zA(paramBoolean);
      AppMethodBeat.o(72687);
      return;
    }
    final int i = this.LTv.getHeight();
    if (this.LTC == null)
    {
      this.LTC = ObjectAnimator.ofFloat(this.LTv, "translationY", new float[] { 0.0F, i });
      this.LTC.setDuration(300L);
      this.LTC.setInterpolator(new LinearInterpolator());
    }
    this.LTC.removeAllListeners();
    this.LTC.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(72665);
        WcPayKeyboard.c(WcPayKeyboard.this).setVisibility(4);
        WcPayKeyboard.c(WcPayKeyboard.this).setTranslationY(WcPayKeyboard.c(WcPayKeyboard.this).getTranslationY() - i);
        if (paramBoolean) {
          WcPayKeyboard.this.setVisibility(8);
        }
        AppMethodBeat.o(72665);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    this.LTC.removeAllUpdateListeners();
    this.LTC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(72666);
        if (WcPayKeyboard.g(WcPayKeyboard.this) != null)
        {
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          float f2 = i - f1;
          ae.v("MicroMsg.WcPayKeyBoard", "hideWcPayKeyboardBase() onAnimationUpdate() baseHeight:%s translationY:%s %s", new Object[] { Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
          WcPayKeyboard.g(WcPayKeyboard.this).bv(f2);
        }
        AppMethodBeat.o(72666);
      }
    });
    this.LTC.start();
    AppMethodBeat.o(72687);
  }
  
  public final void eyi()
  {
    AppMethodBeat.i(72682);
    this.mpP.setVisibility(8);
    if (this.LTv.isShown()) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(72662);
          if (WcPayKeyboard.b(WcPayKeyboard.this)) {
            WcPayKeyboard.a(WcPayKeyboard.this, WcPayKeyboard.c(WcPayKeyboard.this).getHeight());
          }
          AppMethodBeat.o(72662);
        }
      });
    }
    AppMethodBeat.o(72682);
  }
  
  public final void fVq()
  {
    AppMethodBeat.i(72677);
    ae.i("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() %s %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.LTy, Boolean.valueOf(fVv()), bu.fpN() });
    if (fVv())
    {
      AppMethodBeat.o(72677);
      return;
    }
    if (this.LTy == WcPayKeyboard.b.LTM)
    {
      AppMethodBeat.o(72677);
      return;
    }
    if ((isShown()) && (fVs())) {
      aZ(true, false);
    }
    for (;;)
    {
      this.LTy = WcPayKeyboard.b.LTL;
      AppMethodBeat.o(72677);
      return;
      if (!isShown()) {
        if (fVs()) {
          ae.e("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() why here??");
        } else if (fVr()) {
          fVy();
        }
      }
    }
  }
  
  public final boolean fVs()
  {
    return this.LTy == WcPayKeyboard.b.LTK;
  }
  
  public final boolean fVt()
  {
    return this.LTy == WcPayKeyboard.b.LTM;
  }
  
  public final boolean fVu()
  {
    AppMethodBeat.i(72679);
    if ((getVisibility() == 8) && (!fVt()))
    {
      AppMethodBeat.o(72679);
      return true;
    }
    AppMethodBeat.o(72679);
    return false;
  }
  
  public final boolean fVv()
  {
    AppMethodBeat.i(72684);
    if ((fVw()) || (this.LTw.fVB()))
    {
      AppMethodBeat.o(72684);
      return true;
    }
    AppMethodBeat.o(72684);
    return false;
  }
  
  public final void hideWcKb()
  {
    AppMethodBeat.i(72676);
    ae.i("MicroMsg.WcPayKeyBoard", "hideWcKb() %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.LTy, bu.fpN() });
    if (fVv())
    {
      AppMethodBeat.o(72676);
      return;
    }
    if (this.LTy == WcPayKeyboard.b.LTM)
    {
      AppMethodBeat.o(72676);
      return;
    }
    if (isShown())
    {
      if (fVs()) {
        zy(true);
      }
      if (fVr()) {
        fVx();
      }
    }
    AppMethodBeat.o(72676);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(72675);
    if ((isShown()) && (fVs()))
    {
      fVq();
      AppMethodBeat.o(72675);
      return true;
    }
    AppMethodBeat.o(72675);
    return false;
  }
  
  public void setActionText(String paramString)
  {
    AppMethodBeat.i(72680);
    this.LTs.setText(paramString);
    AppMethodBeat.o(72680);
  }
  
  public void setHeightListener(a parama)
  {
    this.LTz = parama;
  }
  
  public void setInputEditText(EditText paramEditText)
  {
    if (paramEditText != null) {
      this.mInputEditText = paramEditText;
    }
  }
  
  public void setTipText(String paramString)
  {
    AppMethodBeat.i(72681);
    this.mpP.setText(paramString);
    this.mpP.setVisibility(0);
    if (this.LTv.isShown()) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(72661);
          if (WcPayKeyboard.b(WcPayKeyboard.this)) {
            WcPayKeyboard.a(WcPayKeyboard.this, WcPayKeyboard.c(WcPayKeyboard.this).getHeight());
          }
          AppMethodBeat.o(72661);
        }
      });
    }
    AppMethodBeat.o(72681);
  }
  
  public final void showNormalStWcKb()
  {
    AppMethodBeat.i(72678);
    ae.i("MicroMsg.WcPayKeyBoard", "showNormalStWcKb() %s %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.LTy, Boolean.valueOf(fVv()), bu.fpN() });
    if (fVv())
    {
      AppMethodBeat.o(72678);
      return;
    }
    if (isShown()) {
      if (fVr()) {
        aZ(false, true);
      }
    }
    for (;;)
    {
      this.LTy = WcPayKeyboard.b.LTK;
      AppMethodBeat.o(72678);
      return;
      if (fVr()) {
        aZ(false, false);
      }
      zz(true);
    }
  }
  
  public final void zx(boolean paramBoolean)
  {
    AppMethodBeat.i(72683);
    this.LTs.setEnabled(paramBoolean);
    this.LTw.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      if (al.isDarkMode())
      {
        this.LTs.setBackgroundResource(2131231135);
        this.LTs.setTextColor(Color.parseColor("#347051"));
        AppMethodBeat.o(72683);
        return;
      }
      this.LTs.setBackgroundResource(2131234728);
      this.LTs.setTextColor(Color.parseColor("#CDF2DF"));
      AppMethodBeat.o(72683);
      return;
    }
    this.LTs.setBackgroundResource(2131234728);
    this.LTs.setTextColor(getResources().getColor(2131101185));
    AppMethodBeat.o(72683);
  }
  
  public final void zz(final boolean paramBoolean)
  {
    AppMethodBeat.i(72690);
    setVisibility(0);
    this.LTv.setVisibility(4);
    this.LTv.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(72656);
        if (WcPayKeyboard.b(WcPayKeyboard.this))
        {
          WcPayKeyboard.a(WcPayKeyboard.this, paramBoolean);
          AppMethodBeat.o(72656);
          return;
        }
        final int i = WcPayKeyboard.c(WcPayKeyboard.this).getHeight();
        if (WcPayKeyboard.h(WcPayKeyboard.this) == null)
        {
          float f = WcPayKeyboard.c(WcPayKeyboard.this).getTranslationY();
          WcPayKeyboard.a(WcPayKeyboard.this, ObjectAnimator.ofFloat(WcPayKeyboard.c(WcPayKeyboard.this), "translationY", new float[] { i + f, f }));
          WcPayKeyboard.h(WcPayKeyboard.this).setDuration(300L);
          WcPayKeyboard.h(WcPayKeyboard.this).setInterpolator(new LinearInterpolator());
        }
        WcPayKeyboard.h(WcPayKeyboard.this).removeAllListeners();
        WcPayKeyboard.h(WcPayKeyboard.this).addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(72654);
            ae.d("MicroMsg.WcPayKeyBoard", "keyboard anim end");
            if (!WcPayKeyboard.2.this.LTF)
            {
              WcPayKeyboard.i(WcPayKeyboard.this).setVisibility(0);
              WcPayKeyboard.d(WcPayKeyboard.this).setVisibility(4);
            }
            AppMethodBeat.o(72654);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
          
          public final void onAnimationStart(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(72653);
            WcPayKeyboard.c(WcPayKeyboard.this).setVisibility(0);
            if (WcPayKeyboard.2.this.LTF)
            {
              WcPayKeyboard.i(WcPayKeyboard.this).setVisibility(0);
              AppMethodBeat.o(72653);
              return;
            }
            WcPayKeyboard.i(WcPayKeyboard.this).setVisibility(4);
            AppMethodBeat.o(72653);
          }
        });
        WcPayKeyboard.h(WcPayKeyboard.this).removeAllUpdateListeners();
        WcPayKeyboard.h(WcPayKeyboard.this).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            AppMethodBeat.i(72655);
            if (WcPayKeyboard.g(WcPayKeyboard.this) != null)
            {
              float f1 = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
              float f2 = i - f1;
              ae.v("MicroMsg.WcPayKeyBoard", "showWcPayKeyboardBase() onAnimationUpdate() baseHeight:%s translationY:%s %s", new Object[] { Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
              WcPayKeyboard.g(WcPayKeyboard.this).bv(f2);
            }
            AppMethodBeat.o(72655);
          }
        });
        WcPayKeyboard.h(WcPayKeyboard.this).start();
        AppMethodBeat.o(72656);
      }
    });
    AppMethodBeat.o(72690);
  }
  
  public static abstract interface a
  {
    public abstract void bv(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboard
 * JD-Core Version:    0.7.0.1
 */