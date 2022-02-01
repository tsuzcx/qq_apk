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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;

public class WcPayKeyboard
  extends RelativeLayout
{
  private TextView IbM;
  private TextView IbN;
  private TextView IbO;
  private TextView IbP;
  private TextView IbQ;
  private TextView IbR;
  private TextView IbS;
  private TextView IbT;
  private TextView IbU;
  private TextView IbV;
  private TextView IbW;
  private TextView IbX;
  private View IbY;
  private ViewGroup IbZ;
  private LinearLayout Ica;
  private WcPayKeyboardAnimationActionButton Icb;
  public View Icc;
  private WcPayKeyboard.b Icd;
  private a Ice;
  public boolean Icf;
  private ObjectAnimator Icg;
  private ObjectAnimator Ich;
  private TextView lln;
  public EditText mInputEditText;
  
  public WcPayKeyboard(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(72671);
    this.Icd = WcPayKeyboard.b.Icq;
    this.Icf = false;
    this.Icg = null;
    this.Ich = null;
    init();
    AppMethodBeat.o(72671);
  }
  
  public WcPayKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72672);
    this.Icd = WcPayKeyboard.b.Icq;
    this.Icf = false;
    this.Icg = null;
    this.Ich = null;
    init();
    AppMethodBeat.o(72672);
  }
  
  public WcPayKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72673);
    this.Icd = WcPayKeyboard.b.Icq;
    this.Icf = false;
    this.Icg = null;
    this.Ich = null;
    init();
    AppMethodBeat.o(72673);
  }
  
  private void aN(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(72686);
    if (paramBoolean1)
    {
      this.Icb.setVisibility(0);
      if (this.Icb.IcI)
      {
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        this.IbX.getLocationOnScreen(arrayOfInt1);
        this.IbZ.getLocationOnScreen(arrayOfInt2);
        if (this.lln.isShown())
        {
          this.lln.getHeight();
          a.fromDPToPix(getContext(), 24);
        }
        this.IbY.getHeight();
        a.fromDPToPix(getContext(), 16);
        int i = a.fromDPToPix(getContext(), 8);
        this.Icb.T(this.IbX.getWidth(), this.IbX.getHeight(), i, arrayOfInt1[0]);
      }
      for (;;)
      {
        this.Icb.IcF = this.IbX.getText();
        this.IbX.setVisibility(4);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(72663);
            WcPayKeyboardAnimationActionButton localWcPayKeyboardAnimationActionButton = WcPayKeyboard.d(WcPayKeyboard.this);
            if (localWcPayKeyboardAnimationActionButton.vWT != null) {
              localWcPayKeyboardAnimationActionButton.vWT.start();
            }
            WcPayKeyboard.e(WcPayKeyboard.this);
            AppMethodBeat.o(72663);
          }
        });
        AppMethodBeat.o(72686);
        return;
        this.Icb.fjF();
      }
    }
    if (paramBoolean2)
    {
      this.Icb.fjL();
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(72664);
          WcPayKeyboard.f(WcPayKeyboard.this);
          WcPayKeyboardAnimationActionButton localWcPayKeyboardAnimationActionButton = WcPayKeyboard.d(WcPayKeyboard.this);
          if (localWcPayKeyboardAnimationActionButton.IcT != null) {
            localWcPayKeyboardAnimationActionButton.IcT.start();
          }
          AppMethodBeat.o(72664);
        }
      });
      AppMethodBeat.o(72686);
      return;
    }
    this.Icb.fjP();
    this.Icb.setVisibility(8);
    AppMethodBeat.o(72686);
  }
  
  private boolean fjB()
  {
    AppMethodBeat.i(72685);
    boolean bool1;
    if (this.Ich == null)
    {
      bool1 = false;
      if (this.Icg != null) {
        break label51;
      }
    }
    label51:
    for (boolean bool2 = false;; bool2 = this.Icg.isRunning())
    {
      if ((!bool1) && (!bool2)) {
        break label62;
      }
      AppMethodBeat.o(72685);
      return true;
      bool1 = this.Ich.isRunning();
      break;
    }
    label62:
    AppMethodBeat.o(72685);
    return false;
  }
  
  private void fjC()
  {
    AppMethodBeat.i(72688);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772171);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(72667);
        WcPayKeyboard.d(WcPayKeyboard.this).setVisibility(4);
        if (this.Icm) {
          WcPayKeyboard.this.setVisibility(8);
        }
        AppMethodBeat.o(72667);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.Icb.startAnimation(localAnimation);
    AppMethodBeat.o(72688);
  }
  
  private void fjD()
  {
    AppMethodBeat.i(72689);
    setVisibility(0);
    this.Icb.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772170);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.Icb.startAnimation(localAnimation);
    AppMethodBeat.o(72689);
  }
  
  private boolean fjw()
  {
    return this.Icd == WcPayKeyboard.b.Icp;
  }
  
  private void init()
  {
    AppMethodBeat.i(72674);
    LayoutInflater.from(getContext()).inflate(2131496059, this, true);
    this.Ica = ((LinearLayout)findViewById(2131301263));
    this.IbV = ((TextView)findViewById(2131301251));
    this.IbM = ((TextView)findViewById(2131301252));
    this.IbN = ((TextView)findViewById(2131301253));
    this.IbO = ((TextView)findViewById(2131301254));
    this.IbP = ((TextView)findViewById(2131301255));
    this.IbQ = ((TextView)findViewById(2131301256));
    this.IbR = ((TextView)findViewById(2131301257));
    this.IbS = ((TextView)findViewById(2131301258));
    this.IbT = ((TextView)findViewById(2131301259));
    this.IbU = ((TextView)findViewById(2131301260));
    this.IbW = ((TextView)findViewById(2131301265));
    this.IbY = findViewById(2131301264);
    this.IbX = ((TextView)findViewById(2131301261));
    this.Icb = ((WcPayKeyboardAnimationActionButton)findViewById(2131301262));
    this.lln = ((TextView)findViewById(2131301267));
    this.IbZ = ((ViewGroup)findViewById(2131301266));
    this.IbX.setTypeface(Typeface.defaultFromStyle(1));
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
          if (!bt.iY(i, 0)) {
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
    this.Ica.setOnClickListener(local1);
    this.IbV.setOnClickListener(local1);
    this.IbM.setOnClickListener(local1);
    this.IbN.setOnClickListener(local1);
    this.IbO.setOnClickListener(local1);
    this.IbP.setOnClickListener(local1);
    this.IbQ.setOnClickListener(local1);
    this.IbR.setOnClickListener(local1);
    this.IbS.setOnClickListener(local1);
    this.IbT.setOnClickListener(local1);
    this.IbU.setOnClickListener(local1);
    this.IbY.setOnClickListener(local1);
    this.IbW.setOnClickListener(local1);
    this.IbX.setOnClickListener(local1);
    this.Icb.setOnClickListener(local1);
    AppMethodBeat.o(72674);
  }
  
  private void setWindowViewBottomMargin(int paramInt)
  {
    AppMethodBeat.i(72692);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.Icc.getLayoutParams();
    localLayoutParams.bottomMargin = paramInt;
    this.Icc.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(72692);
  }
  
  private void xn(final boolean paramBoolean)
  {
    AppMethodBeat.i(72687);
    if (this.Icf)
    {
      xp(paramBoolean);
      AppMethodBeat.o(72687);
      return;
    }
    final int i = this.Ica.getHeight();
    if (this.Ich == null)
    {
      this.Ich = ObjectAnimator.ofFloat(this.Ica, "translationY", new float[] { 0.0F, i });
      this.Ich.setDuration(300L);
      this.Ich.setInterpolator(new LinearInterpolator());
    }
    this.Ich.removeAllListeners();
    this.Ich.addListener(new Animator.AnimatorListener()
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
    this.Ich.removeAllUpdateListeners();
    this.Ich.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(72666);
        if (WcPayKeyboard.g(WcPayKeyboard.this) != null)
        {
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          float f2 = i - f1;
          ad.v("MicroMsg.WcPayKeyBoard", "hideWcPayKeyboardBase() onAnimationUpdate() baseHeight:%s translationY:%s %s", new Object[] { Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
          WcPayKeyboard.g(WcPayKeyboard.this).bk(f2);
        }
        AppMethodBeat.o(72666);
      }
    });
    this.Ich.start();
    AppMethodBeat.o(72687);
  }
  
  private void xp(final boolean paramBoolean)
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
    this.Ica.startAnimation(localAnimation);
    setWindowViewBottomMargin(0);
    AppMethodBeat.o(72691);
  }
  
  public final void dRG()
  {
    AppMethodBeat.i(72682);
    this.lln.setVisibility(8);
    if (this.Ica.isShown()) {
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
  
  public final boolean fjA()
  {
    AppMethodBeat.i(72684);
    if ((fjB()) || (this.Icb.fjG()))
    {
      AppMethodBeat.o(72684);
      return true;
    }
    AppMethodBeat.o(72684);
    return false;
  }
  
  public final void fjv()
  {
    AppMethodBeat.i(72677);
    ad.i("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() %s %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.Icd, Boolean.valueOf(fjA()), bt.eGN() });
    if (fjA())
    {
      AppMethodBeat.o(72677);
      return;
    }
    if (this.Icd == WcPayKeyboard.b.Icq)
    {
      AppMethodBeat.o(72677);
      return;
    }
    if ((isShown()) && (fjx())) {
      aN(true, false);
    }
    for (;;)
    {
      this.Icd = WcPayKeyboard.b.Icp;
      AppMethodBeat.o(72677);
      return;
      if (!isShown()) {
        if (fjx()) {
          ad.e("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() why here??");
        } else if (fjw()) {
          fjD();
        }
      }
    }
  }
  
  public final boolean fjx()
  {
    return this.Icd == WcPayKeyboard.b.Ico;
  }
  
  public final boolean fjy()
  {
    return this.Icd == WcPayKeyboard.b.Icq;
  }
  
  public final boolean fjz()
  {
    AppMethodBeat.i(72679);
    if ((getVisibility() == 8) && (!fjy()))
    {
      AppMethodBeat.o(72679);
      return true;
    }
    AppMethodBeat.o(72679);
    return false;
  }
  
  public final void hideWcKb()
  {
    AppMethodBeat.i(72676);
    ad.i("MicroMsg.WcPayKeyBoard", "hideWcKb() %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.Icd, bt.eGN() });
    if (fjA())
    {
      AppMethodBeat.o(72676);
      return;
    }
    if (this.Icd == WcPayKeyboard.b.Icq)
    {
      AppMethodBeat.o(72676);
      return;
    }
    if (isShown())
    {
      if (fjx()) {
        xn(true);
      }
      if (fjw()) {
        fjC();
      }
    }
    AppMethodBeat.o(72676);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(72675);
    if ((isShown()) && (fjx()))
    {
      fjv();
      AppMethodBeat.o(72675);
      return true;
    }
    AppMethodBeat.o(72675);
    return false;
  }
  
  public void setActionText(String paramString)
  {
    AppMethodBeat.i(72680);
    this.IbX.setText(paramString);
    AppMethodBeat.o(72680);
  }
  
  public void setHeightListener(a parama)
  {
    this.Ice = parama;
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
    this.lln.setText(paramString);
    this.lln.setVisibility(0);
    if (this.Ica.isShown()) {
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
    ad.i("MicroMsg.WcPayKeyBoard", "showNormalStWcKb() %s %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.Icd, Boolean.valueOf(fjA()), bt.eGN() });
    if (fjA())
    {
      AppMethodBeat.o(72678);
      return;
    }
    if (isShown()) {
      if (fjw()) {
        aN(false, true);
      }
    }
    for (;;)
    {
      this.Icd = WcPayKeyboard.b.Ico;
      AppMethodBeat.o(72678);
      return;
      if (fjw()) {
        aN(false, false);
      }
      xo(true);
    }
  }
  
  public final void xm(boolean paramBoolean)
  {
    AppMethodBeat.i(72683);
    this.IbX.setEnabled(paramBoolean);
    this.Icb.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      if (ai.Eq())
      {
        this.IbX.setBackgroundResource(2131231135);
        this.IbX.setTextColor(Color.parseColor("#347051"));
        AppMethodBeat.o(72683);
        return;
      }
      this.IbX.setBackgroundResource(2131234728);
      this.IbX.setTextColor(Color.parseColor("#CDF2DF"));
      AppMethodBeat.o(72683);
      return;
    }
    this.IbX.setBackgroundResource(2131234728);
    this.IbX.setTextColor(getResources().getColor(2131101185));
    AppMethodBeat.o(72683);
  }
  
  public final void xo(final boolean paramBoolean)
  {
    AppMethodBeat.i(72690);
    setVisibility(0);
    this.Ica.setVisibility(4);
    this.Ica.post(new Runnable()
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
            if (!WcPayKeyboard.2.this.Icj)
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
            if (WcPayKeyboard.2.this.Icj)
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
              WcPayKeyboard.g(WcPayKeyboard.this).bk(f2);
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
    public abstract void bk(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboard
 * JD-Core Version:    0.7.0.1
 */