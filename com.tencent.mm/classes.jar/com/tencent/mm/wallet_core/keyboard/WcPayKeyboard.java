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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;

public class WcPayKeyboard
  extends RelativeLayout
{
  private View JDA;
  private ViewGroup JDB;
  private LinearLayout JDC;
  private WcPayKeyboardAnimationActionButton JDD;
  public View JDE;
  private WcPayKeyboard.b JDF;
  private a JDG;
  public boolean JDH;
  private ObjectAnimator JDI;
  private ObjectAnimator JDJ;
  private TextView JDo;
  private TextView JDp;
  private TextView JDq;
  private TextView JDr;
  private TextView JDs;
  private TextView JDt;
  private TextView JDu;
  private TextView JDv;
  private TextView JDw;
  private TextView JDx;
  private TextView JDy;
  private TextView JDz;
  private TextView lLe;
  public EditText mInputEditText;
  
  public WcPayKeyboard(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(72671);
    this.JDF = WcPayKeyboard.b.JDS;
    this.JDH = false;
    this.JDI = null;
    this.JDJ = null;
    init();
    AppMethodBeat.o(72671);
  }
  
  public WcPayKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72672);
    this.JDF = WcPayKeyboard.b.JDS;
    this.JDH = false;
    this.JDI = null;
    this.JDJ = null;
    init();
    AppMethodBeat.o(72672);
  }
  
  public WcPayKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72673);
    this.JDF = WcPayKeyboard.b.JDS;
    this.JDH = false;
    this.JDI = null;
    this.JDJ = null;
    init();
    AppMethodBeat.o(72673);
  }
  
  private void aS(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(72686);
    if (paramBoolean1)
    {
      this.JDD.setVisibility(0);
      if (this.JDD.JEk)
      {
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        this.JDz.getLocationOnScreen(arrayOfInt1);
        this.JDB.getLocationOnScreen(arrayOfInt2);
        if (this.lLe.isShown())
        {
          this.lLe.getHeight();
          a.fromDPToPix(getContext(), 24);
        }
        this.JDA.getHeight();
        a.fromDPToPix(getContext(), 16);
        int i = a.fromDPToPix(getContext(), 8);
        this.JDD.V(this.JDz.getWidth(), this.JDz.getHeight(), i, arrayOfInt1[0]);
      }
      for (;;)
      {
        this.JDD.JEh = this.JDz.getText();
        this.JDz.setVisibility(4);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(72663);
            WcPayKeyboardAnimationActionButton localWcPayKeyboardAnimationActionButton = WcPayKeyboard.d(WcPayKeyboard.this);
            if (localWcPayKeyboardAnimationActionButton.xhG != null) {
              localWcPayKeyboardAnimationActionButton.xhG.start();
            }
            WcPayKeyboard.e(WcPayKeyboard.this);
            AppMethodBeat.o(72663);
          }
        });
        AppMethodBeat.o(72686);
        return;
        this.JDD.fzU();
      }
    }
    if (paramBoolean2)
    {
      this.JDD.fAa();
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(72664);
          WcPayKeyboard.f(WcPayKeyboard.this);
          WcPayKeyboardAnimationActionButton localWcPayKeyboardAnimationActionButton = WcPayKeyboard.d(WcPayKeyboard.this);
          if (localWcPayKeyboardAnimationActionButton.JEv != null) {
            localWcPayKeyboardAnimationActionButton.JEv.start();
          }
          AppMethodBeat.o(72664);
        }
      });
      AppMethodBeat.o(72686);
      return;
    }
    this.JDD.fAe();
    this.JDD.setVisibility(8);
    AppMethodBeat.o(72686);
  }
  
  private boolean fzL()
  {
    return this.JDF == WcPayKeyboard.b.JDR;
  }
  
  private boolean fzQ()
  {
    AppMethodBeat.i(72685);
    boolean bool1;
    if (this.JDJ == null)
    {
      bool1 = false;
      if (this.JDI != null) {
        break label51;
      }
    }
    label51:
    for (boolean bool2 = false;; bool2 = this.JDI.isRunning())
    {
      if ((!bool1) && (!bool2)) {
        break label62;
      }
      AppMethodBeat.o(72685);
      return true;
      bool1 = this.JDJ.isRunning();
      break;
    }
    label62:
    AppMethodBeat.o(72685);
    return false;
  }
  
  private void fzR()
  {
    AppMethodBeat.i(72688);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772171);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(72667);
        WcPayKeyboard.d(WcPayKeyboard.this).setVisibility(4);
        if (this.JDO) {
          WcPayKeyboard.this.setVisibility(8);
        }
        AppMethodBeat.o(72667);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.JDD.startAnimation(localAnimation);
    AppMethodBeat.o(72688);
  }
  
  private void fzS()
  {
    AppMethodBeat.i(72689);
    setVisibility(0);
    this.JDD.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772170);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.JDD.startAnimation(localAnimation);
    AppMethodBeat.o(72689);
  }
  
  private void init()
  {
    AppMethodBeat.i(72674);
    LayoutInflater.from(getContext()).inflate(2131496059, this, true);
    this.JDC = ((LinearLayout)findViewById(2131301263));
    this.JDx = ((TextView)findViewById(2131301251));
    this.JDo = ((TextView)findViewById(2131301252));
    this.JDp = ((TextView)findViewById(2131301253));
    this.JDq = ((TextView)findViewById(2131301254));
    this.JDr = ((TextView)findViewById(2131301255));
    this.JDs = ((TextView)findViewById(2131301256));
    this.JDt = ((TextView)findViewById(2131301257));
    this.JDu = ((TextView)findViewById(2131301258));
    this.JDv = ((TextView)findViewById(2131301259));
    this.JDw = ((TextView)findViewById(2131301260));
    this.JDy = ((TextView)findViewById(2131301265));
    this.JDA = findViewById(2131301264);
    this.JDz = ((TextView)findViewById(2131301261));
    this.JDD = ((WcPayKeyboardAnimationActionButton)findViewById(2131301262));
    this.lLe = ((TextView)findViewById(2131301267));
    this.JDB = ((ViewGroup)findViewById(2131301266));
    this.JDz.setTypeface(Typeface.defaultFromStyle(1));
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72652);
        if (WcPayKeyboard.a(WcPayKeyboard.this) == null)
        {
          AppMethodBeat.o(72652);
          return;
        }
        int i;
        if (paramAnonymousView.getId() == 2131301251) {
          i = 7;
        }
        for (;;)
        {
          if (!bs.jl(i, 0)) {
            paramAnonymousView.performHapticFeedback(0, 2);
          }
          if (paramAnonymousView.getId() != 2131301261) {
            paramAnonymousView.getId();
          }
          WcPayKeyboard.a(WcPayKeyboard.this).dispatchKeyEvent(new KeyEvent(0, i));
          WcPayKeyboard.a(WcPayKeyboard.this).dispatchKeyEvent(new KeyEvent(1, i));
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
    this.JDC.setOnClickListener(local1);
    this.JDx.setOnClickListener(local1);
    this.JDo.setOnClickListener(local1);
    this.JDp.setOnClickListener(local1);
    this.JDq.setOnClickListener(local1);
    this.JDr.setOnClickListener(local1);
    this.JDs.setOnClickListener(local1);
    this.JDt.setOnClickListener(local1);
    this.JDu.setOnClickListener(local1);
    this.JDv.setOnClickListener(local1);
    this.JDw.setOnClickListener(local1);
    this.JDA.setOnClickListener(local1);
    this.JDy.setOnClickListener(local1);
    this.JDz.setOnClickListener(local1);
    this.JDD.setOnClickListener(local1);
    AppMethodBeat.o(72674);
  }
  
  private void setWindowViewBottomMargin(int paramInt)
  {
    AppMethodBeat.i(72692);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.JDE.getLayoutParams();
    localLayoutParams.bottomMargin = paramInt;
    this.JDE.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(72692);
  }
  
  private void yx(final boolean paramBoolean)
  {
    AppMethodBeat.i(72687);
    if (this.JDH)
    {
      yz(paramBoolean);
      AppMethodBeat.o(72687);
      return;
    }
    final int i = this.JDC.getHeight();
    if (this.JDJ == null)
    {
      this.JDJ = ObjectAnimator.ofFloat(this.JDC, "translationY", new float[] { 0.0F, i });
      this.JDJ.setDuration(300L);
      this.JDJ.setInterpolator(new LinearInterpolator());
    }
    this.JDJ.removeAllListeners();
    this.JDJ.addListener(new Animator.AnimatorListener()
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
    this.JDJ.removeAllUpdateListeners();
    this.JDJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(72666);
        if (WcPayKeyboard.g(WcPayKeyboard.this) != null)
        {
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          float f2 = i - f1;
          ac.v("MicroMsg.WcPayKeyBoard", "hideWcPayKeyboardBase() onAnimationUpdate() baseHeight:%s translationY:%s %s", new Object[] { Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
          WcPayKeyboard.g(WcPayKeyboard.this).bs(f2);
        }
        AppMethodBeat.o(72666);
      }
    });
    this.JDJ.start();
    AppMethodBeat.o(72687);
  }
  
  private void yz(final boolean paramBoolean)
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
    this.JDC.startAnimation(localAnimation);
    setWindowViewBottomMargin(0);
    AppMethodBeat.o(72691);
  }
  
  public final void egR()
  {
    AppMethodBeat.i(72682);
    this.lLe.setVisibility(8);
    if (this.JDC.isShown()) {
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
  
  public final void fzK()
  {
    AppMethodBeat.i(72677);
    ac.i("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() %s %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.JDF, Boolean.valueOf(fzP()), bs.eWi() });
    if (fzP())
    {
      AppMethodBeat.o(72677);
      return;
    }
    if (this.JDF == WcPayKeyboard.b.JDS)
    {
      AppMethodBeat.o(72677);
      return;
    }
    if ((isShown()) && (fzM())) {
      aS(true, false);
    }
    for (;;)
    {
      this.JDF = WcPayKeyboard.b.JDR;
      AppMethodBeat.o(72677);
      return;
      if (!isShown()) {
        if (fzM()) {
          ac.e("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() why here??");
        } else if (fzL()) {
          fzS();
        }
      }
    }
  }
  
  public final boolean fzM()
  {
    return this.JDF == WcPayKeyboard.b.JDQ;
  }
  
  public final boolean fzN()
  {
    return this.JDF == WcPayKeyboard.b.JDS;
  }
  
  public final boolean fzO()
  {
    AppMethodBeat.i(72679);
    if ((getVisibility() == 8) && (!fzN()))
    {
      AppMethodBeat.o(72679);
      return true;
    }
    AppMethodBeat.o(72679);
    return false;
  }
  
  public final boolean fzP()
  {
    AppMethodBeat.i(72684);
    if ((fzQ()) || (this.JDD.fzV()))
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
    ac.i("MicroMsg.WcPayKeyBoard", "hideWcKb() %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.JDF, bs.eWi() });
    if (fzP())
    {
      AppMethodBeat.o(72676);
      return;
    }
    if (this.JDF == WcPayKeyboard.b.JDS)
    {
      AppMethodBeat.o(72676);
      return;
    }
    if (isShown())
    {
      if (fzM()) {
        yx(true);
      }
      if (fzL()) {
        fzR();
      }
    }
    AppMethodBeat.o(72676);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(72675);
    if ((isShown()) && (fzM()))
    {
      fzK();
      AppMethodBeat.o(72675);
      return true;
    }
    AppMethodBeat.o(72675);
    return false;
  }
  
  public void setActionText(String paramString)
  {
    AppMethodBeat.i(72680);
    this.JDz.setText(paramString);
    AppMethodBeat.o(72680);
  }
  
  public void setHeightListener(a parama)
  {
    this.JDG = parama;
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
    this.lLe.setText(paramString);
    this.lLe.setVisibility(0);
    if (this.JDC.isShown()) {
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
    ac.i("MicroMsg.WcPayKeyBoard", "showNormalStWcKb() %s %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.JDF, Boolean.valueOf(fzP()), bs.eWi() });
    if (fzP())
    {
      AppMethodBeat.o(72678);
      return;
    }
    if (isShown()) {
      if (fzL()) {
        aS(false, true);
      }
    }
    for (;;)
    {
      this.JDF = WcPayKeyboard.b.JDQ;
      AppMethodBeat.o(72678);
      return;
      if (fzL()) {
        aS(false, false);
      }
      yy(true);
    }
  }
  
  public final void yw(boolean paramBoolean)
  {
    AppMethodBeat.i(72683);
    this.JDz.setEnabled(paramBoolean);
    this.JDD.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      if (aj.DT())
      {
        this.JDz.setBackgroundResource(2131231135);
        this.JDz.setTextColor(Color.parseColor("#347051"));
        AppMethodBeat.o(72683);
        return;
      }
      this.JDz.setBackgroundResource(2131234728);
      this.JDz.setTextColor(Color.parseColor("#CDF2DF"));
      AppMethodBeat.o(72683);
      return;
    }
    this.JDz.setBackgroundResource(2131234728);
    this.JDz.setTextColor(getResources().getColor(2131101185));
    AppMethodBeat.o(72683);
  }
  
  public final void yy(final boolean paramBoolean)
  {
    AppMethodBeat.i(72690);
    setVisibility(0);
    this.JDC.setVisibility(4);
    this.JDC.post(new Runnable()
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
            ac.d("MicroMsg.WcPayKeyBoard", "keyboard anim end");
            if (!WcPayKeyboard.2.this.JDL)
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
            if (WcPayKeyboard.2.this.JDL)
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
              ac.v("MicroMsg.WcPayKeyBoard", "showWcPayKeyboardBase() onAnimationUpdate() baseHeight:%s translationY:%s %s", new Object[] { Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
              WcPayKeyboard.g(WcPayKeyboard.this).bs(f2);
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
    public abstract void bs(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboard
 * JD-Core Version:    0.7.0.1
 */