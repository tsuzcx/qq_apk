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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;

public class WcPayKeyboard
  extends RelativeLayout
{
  private TextView LwA;
  private TextView LwB;
  private TextView LwC;
  private TextView LwD;
  private TextView LwE;
  private TextView LwF;
  private View LwG;
  private ViewGroup LwH;
  private LinearLayout LwI;
  private WcPayKeyboardAnimationActionButton LwJ;
  public View LwK;
  private WcPayKeyboard.b LwL;
  private a LwM;
  public boolean LwN;
  private ObjectAnimator LwO;
  private ObjectAnimator LwP;
  private TextView Lwu;
  private TextView Lwv;
  private TextView Lww;
  private TextView Lwx;
  private TextView Lwy;
  private TextView Lwz;
  public EditText mInputEditText;
  private TextView mkS;
  
  public WcPayKeyboard(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(72671);
    this.LwL = WcPayKeyboard.b.LwY;
    this.LwN = false;
    this.LwO = null;
    this.LwP = null;
    init();
    AppMethodBeat.o(72671);
  }
  
  public WcPayKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72672);
    this.LwL = WcPayKeyboard.b.LwY;
    this.LwN = false;
    this.LwO = null;
    this.LwP = null;
    init();
    AppMethodBeat.o(72672);
  }
  
  public WcPayKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72673);
    this.LwL = WcPayKeyboard.b.LwY;
    this.LwN = false;
    this.LwO = null;
    this.LwP = null;
    init();
    AppMethodBeat.o(72673);
  }
  
  private void ba(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(72686);
    if (paramBoolean1)
    {
      this.LwJ.setVisibility(0);
      if (this.LwJ.Lxo)
      {
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        this.LwF.getLocationOnScreen(arrayOfInt1);
        this.LwH.getLocationOnScreen(arrayOfInt2);
        if (this.mkS.isShown())
        {
          this.mkS.getHeight();
          com.tencent.mm.cc.a.fromDPToPix(getContext(), 24);
        }
        this.LwG.getHeight();
        com.tencent.mm.cc.a.fromDPToPix(getContext(), 16);
        int i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 8);
        this.LwJ.V(this.LwF.getWidth(), this.LwF.getHeight(), i, arrayOfInt1[0]);
      }
      for (;;)
      {
        this.LwJ.Lxl = this.LwF.getText();
        this.LwF.setVisibility(4);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(72663);
            WcPayKeyboardAnimationActionButton localWcPayKeyboardAnimationActionButton = WcPayKeyboard.d(WcPayKeyboard.this);
            if (localWcPayKeyboardAnimationActionButton.yvH != null) {
              localWcPayKeyboardAnimationActionButton.yvH.start();
            }
            WcPayKeyboard.e(WcPayKeyboard.this);
            AppMethodBeat.o(72663);
          }
        });
        AppMethodBeat.o(72686);
        return;
        this.LwJ.fRe();
      }
    }
    if (paramBoolean2)
    {
      this.LwJ.fRk();
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(72664);
          WcPayKeyboard.f(WcPayKeyboard.this);
          WcPayKeyboardAnimationActionButton localWcPayKeyboardAnimationActionButton = WcPayKeyboard.d(WcPayKeyboard.this);
          if (localWcPayKeyboardAnimationActionButton.Lxz != null) {
            localWcPayKeyboardAnimationActionButton.Lxz.start();
          }
          AppMethodBeat.o(72664);
        }
      });
      AppMethodBeat.o(72686);
      return;
    }
    this.LwJ.fRo();
    this.LwJ.setVisibility(8);
    AppMethodBeat.o(72686);
  }
  
  private boolean fQV()
  {
    return this.LwL == WcPayKeyboard.b.LwX;
  }
  
  private boolean fRa()
  {
    AppMethodBeat.i(72685);
    boolean bool1;
    if (this.LwP == null)
    {
      bool1 = false;
      if (this.LwO != null) {
        break label51;
      }
    }
    label51:
    for (boolean bool2 = false;; bool2 = this.LwO.isRunning())
    {
      if ((!bool1) && (!bool2)) {
        break label62;
      }
      AppMethodBeat.o(72685);
      return true;
      bool1 = this.LwP.isRunning();
      break;
    }
    label62:
    AppMethodBeat.o(72685);
    return false;
  }
  
  private void fRb()
  {
    AppMethodBeat.i(72688);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772171);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(72667);
        WcPayKeyboard.d(WcPayKeyboard.this).setVisibility(4);
        if (this.LwU) {
          WcPayKeyboard.this.setVisibility(8);
        }
        AppMethodBeat.o(72667);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.LwJ.startAnimation(localAnimation);
    AppMethodBeat.o(72688);
  }
  
  private void fRc()
  {
    AppMethodBeat.i(72689);
    setVisibility(0);
    this.LwJ.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772170);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.LwJ.startAnimation(localAnimation);
    AppMethodBeat.o(72689);
  }
  
  private void init()
  {
    AppMethodBeat.i(72674);
    LayoutInflater.from(getContext()).inflate(2131496059, this, true);
    this.LwI = ((LinearLayout)findViewById(2131301263));
    this.LwD = ((TextView)findViewById(2131301251));
    this.Lwu = ((TextView)findViewById(2131301252));
    this.Lwv = ((TextView)findViewById(2131301253));
    this.Lww = ((TextView)findViewById(2131301254));
    this.Lwx = ((TextView)findViewById(2131301255));
    this.Lwy = ((TextView)findViewById(2131301256));
    this.Lwz = ((TextView)findViewById(2131301257));
    this.LwA = ((TextView)findViewById(2131301258));
    this.LwB = ((TextView)findViewById(2131301259));
    this.LwC = ((TextView)findViewById(2131301260));
    this.LwE = ((TextView)findViewById(2131301265));
    this.LwG = findViewById(2131301264);
    this.LwF = ((TextView)findViewById(2131301261));
    this.LwJ = ((WcPayKeyboardAnimationActionButton)findViewById(2131301262));
    this.mkS = ((TextView)findViewById(2131301267));
    this.LwH = ((ViewGroup)findViewById(2131301266));
    this.LwF.setTypeface(Typeface.defaultFromStyle(1));
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72652);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/keyboard/WcPayKeyboard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
          if (!bt.jx(i, 0)) {
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
    this.LwI.setOnClickListener(local1);
    this.LwD.setOnClickListener(local1);
    this.Lwu.setOnClickListener(local1);
    this.Lwv.setOnClickListener(local1);
    this.Lww.setOnClickListener(local1);
    this.Lwx.setOnClickListener(local1);
    this.Lwy.setOnClickListener(local1);
    this.Lwz.setOnClickListener(local1);
    this.LwA.setOnClickListener(local1);
    this.LwB.setOnClickListener(local1);
    this.LwC.setOnClickListener(local1);
    this.LwG.setOnClickListener(local1);
    this.LwE.setOnClickListener(local1);
    this.LwF.setOnClickListener(local1);
    this.LwJ.setOnClickListener(local1);
    AppMethodBeat.o(72674);
  }
  
  private void setWindowViewBottomMargin(int paramInt)
  {
    AppMethodBeat.i(72692);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.LwK.getLayoutParams();
    localLayoutParams.bottomMargin = paramInt;
    this.LwK.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(72692);
  }
  
  private void zk(final boolean paramBoolean)
  {
    AppMethodBeat.i(72687);
    if (this.LwN)
    {
      zm(paramBoolean);
      AppMethodBeat.o(72687);
      return;
    }
    final int i = this.LwI.getHeight();
    if (this.LwP == null)
    {
      this.LwP = ObjectAnimator.ofFloat(this.LwI, "translationY", new float[] { 0.0F, i });
      this.LwP.setDuration(300L);
      this.LwP.setInterpolator(new LinearInterpolator());
    }
    this.LwP.removeAllListeners();
    this.LwP.addListener(new Animator.AnimatorListener()
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
    this.LwP.removeAllUpdateListeners();
    this.LwP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(72666);
        if (WcPayKeyboard.g(WcPayKeyboard.this) != null)
        {
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          float f2 = i - f1;
          ad.v("MicroMsg.WcPayKeyBoard", "hideWcPayKeyboardBase() onAnimationUpdate() baseHeight:%s translationY:%s %s", new Object[] { Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
          WcPayKeyboard.g(WcPayKeyboard.this).bv(f2);
        }
        AppMethodBeat.o(72666);
      }
    });
    this.LwP.start();
    AppMethodBeat.o(72687);
  }
  
  private void zm(final boolean paramBoolean)
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
    this.LwI.startAnimation(localAnimation);
    setWindowViewBottomMargin(0);
    AppMethodBeat.o(72691);
  }
  
  public final void euC()
  {
    AppMethodBeat.i(72682);
    this.mkS.setVisibility(8);
    if (this.LwI.isShown()) {
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
  
  public final void fQU()
  {
    AppMethodBeat.i(72677);
    ad.i("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() %s %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.LwL, Boolean.valueOf(fQZ()), bt.flS() });
    if (fQZ())
    {
      AppMethodBeat.o(72677);
      return;
    }
    if (this.LwL == WcPayKeyboard.b.LwY)
    {
      AppMethodBeat.o(72677);
      return;
    }
    if ((isShown()) && (fQW())) {
      ba(true, false);
    }
    for (;;)
    {
      this.LwL = WcPayKeyboard.b.LwX;
      AppMethodBeat.o(72677);
      return;
      if (!isShown()) {
        if (fQW()) {
          ad.e("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() why here??");
        } else if (fQV()) {
          fRc();
        }
      }
    }
  }
  
  public final boolean fQW()
  {
    return this.LwL == WcPayKeyboard.b.LwW;
  }
  
  public final boolean fQX()
  {
    return this.LwL == WcPayKeyboard.b.LwY;
  }
  
  public final boolean fQY()
  {
    AppMethodBeat.i(72679);
    if ((getVisibility() == 8) && (!fQX()))
    {
      AppMethodBeat.o(72679);
      return true;
    }
    AppMethodBeat.o(72679);
    return false;
  }
  
  public final boolean fQZ()
  {
    AppMethodBeat.i(72684);
    if ((fRa()) || (this.LwJ.fRf()))
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
    ad.i("MicroMsg.WcPayKeyBoard", "hideWcKb() %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.LwL, bt.flS() });
    if (fQZ())
    {
      AppMethodBeat.o(72676);
      return;
    }
    if (this.LwL == WcPayKeyboard.b.LwY)
    {
      AppMethodBeat.o(72676);
      return;
    }
    if (isShown())
    {
      if (fQW()) {
        zk(true);
      }
      if (fQV()) {
        fRb();
      }
    }
    AppMethodBeat.o(72676);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(72675);
    if ((isShown()) && (fQW()))
    {
      fQU();
      AppMethodBeat.o(72675);
      return true;
    }
    AppMethodBeat.o(72675);
    return false;
  }
  
  public void setActionText(String paramString)
  {
    AppMethodBeat.i(72680);
    this.LwF.setText(paramString);
    AppMethodBeat.o(72680);
  }
  
  public void setHeightListener(a parama)
  {
    this.LwM = parama;
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
    this.mkS.setText(paramString);
    this.mkS.setVisibility(0);
    if (this.LwI.isShown()) {
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
    ad.i("MicroMsg.WcPayKeyBoard", "showNormalStWcKb() %s %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.LwL, Boolean.valueOf(fQZ()), bt.flS() });
    if (fQZ())
    {
      AppMethodBeat.o(72678);
      return;
    }
    if (isShown()) {
      if (fQV()) {
        ba(false, true);
      }
    }
    for (;;)
    {
      this.LwL = WcPayKeyboard.b.LwW;
      AppMethodBeat.o(72678);
      return;
      if (fQV()) {
        ba(false, false);
      }
      zl(true);
    }
  }
  
  public final void zj(boolean paramBoolean)
  {
    AppMethodBeat.i(72683);
    this.LwF.setEnabled(paramBoolean);
    this.LwJ.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      if (al.isDarkMode())
      {
        this.LwF.setBackgroundResource(2131231135);
        this.LwF.setTextColor(Color.parseColor("#347051"));
        AppMethodBeat.o(72683);
        return;
      }
      this.LwF.setBackgroundResource(2131234728);
      this.LwF.setTextColor(Color.parseColor("#CDF2DF"));
      AppMethodBeat.o(72683);
      return;
    }
    this.LwF.setBackgroundResource(2131234728);
    this.LwF.setTextColor(getResources().getColor(2131101185));
    AppMethodBeat.o(72683);
  }
  
  public final void zl(final boolean paramBoolean)
  {
    AppMethodBeat.i(72690);
    setVisibility(0);
    this.LwI.setVisibility(4);
    this.LwI.post(new Runnable()
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
            ad.d("MicroMsg.WcPayKeyBoard", "keyboard anim end");
            if (!WcPayKeyboard.2.this.LwR)
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
            if (WcPayKeyboard.2.this.LwR)
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
              ad.v("MicroMsg.WcPayKeyBoard", "showWcPayKeyboardBase() onAnimationUpdate() baseHeight:%s translationY:%s %s", new Object[] { Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboard
 * JD-Core Version:    0.7.0.1
 */