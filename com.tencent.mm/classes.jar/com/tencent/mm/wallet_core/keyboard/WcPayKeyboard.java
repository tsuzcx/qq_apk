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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.LayoutListenerView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;

public class WcPayKeyboard
  extends RelativeLayout
{
  private TextView RrZ;
  private TextView Rsa;
  private TextView Rsb;
  private TextView Rsc;
  private TextView Rsd;
  private TextView Rse;
  private TextView Rsf;
  private TextView Rsg;
  private TextView Rsh;
  private TextView Rsi;
  private TextView Rsj;
  private TextView Rsk;
  private View Rsl;
  private ViewGroup Rsm;
  private LinearLayout Rsn;
  private WcPayKeyboardAnimationActionButton Rso;
  private View Rsp;
  private WcPayKeyboard.b Rsq;
  private a Rsr;
  private boolean Rss;
  private ObjectAnimator Rst;
  private ObjectAnimator Rsu;
  public EditText mInputEditText;
  private TextView nAB;
  
  public WcPayKeyboard(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(72671);
    this.Rsq = WcPayKeyboard.b.RsD;
    this.Rss = false;
    this.Rst = null;
    this.Rsu = null;
    init();
    AppMethodBeat.o(72671);
  }
  
  public WcPayKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72672);
    this.Rsq = WcPayKeyboard.b.RsD;
    this.Rss = false;
    this.Rst = null;
    this.Rsu = null;
    init();
    AppMethodBeat.o(72672);
  }
  
  public WcPayKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72673);
    this.Rsq = WcPayKeyboard.b.RsD;
    this.Rss = false;
    this.Rst = null;
    this.Rsu = null;
    init();
    AppMethodBeat.o(72673);
  }
  
  private void DI(final boolean paramBoolean)
  {
    AppMethodBeat.i(72687);
    if (this.Rss)
    {
      DK(paramBoolean);
      AppMethodBeat.o(72687);
      return;
    }
    final int i = this.Rsn.getHeight();
    if (this.Rsu == null)
    {
      this.Rsu = ObjectAnimator.ofFloat(this.Rsn, "translationY", new float[] { 0.0F, i });
      this.Rsu.setDuration(300L);
      this.Rsu.setInterpolator(new LinearInterpolator());
    }
    this.Rsu.removeAllListeners();
    this.Rsu.addListener(new Animator.AnimatorListener()
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
    this.Rsu.removeAllUpdateListeners();
    this.Rsu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(72666);
        if (WcPayKeyboard.g(WcPayKeyboard.this) != null)
        {
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          float f2 = i - f1;
          Log.v("MicroMsg.WcPayKeyBoard", "hideWcPayKeyboardBase() onAnimationUpdate() baseHeight:%s translationY:%s %s", new Object[] { Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
          WcPayKeyboard.g(WcPayKeyboard.this).bO(f2);
        }
        AppMethodBeat.o(72666);
      }
    });
    this.Rsu.start();
    AppMethodBeat.o(72687);
  }
  
  private void DK(final boolean paramBoolean)
  {
    AppMethodBeat.i(72691);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772162);
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
    this.Rsn.startAnimation(localAnimation);
    setWindowViewBottomMargin(0);
    AppMethodBeat.o(72691);
  }
  
  private void bj(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(72686);
    if (paramBoolean1)
    {
      this.Rso.setVisibility(0);
      if (this.Rso.RsT)
      {
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        this.Rsk.getLocationOnScreen(arrayOfInt1);
        this.Rsm.getLocationOnScreen(arrayOfInt2);
        if (this.nAB.isShown())
        {
          this.nAB.getHeight();
          com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
        }
        this.Rsl.getHeight();
        com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
        int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
        this.Rso.U(this.Rsk.getWidth(), this.Rsk.getHeight(), i, arrayOfInt1[0]);
      }
      for (;;)
      {
        this.Rso.RsQ = this.Rsk.getText();
        this.Rsk.setVisibility(4);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(72663);
            WcPayKeyboardAnimationActionButton localWcPayKeyboardAnimationActionButton = WcPayKeyboard.d(WcPayKeyboard.this);
            if (localWcPayKeyboardAnimationActionButton.CPA != null) {
              localWcPayKeyboardAnimationActionButton.CPA.start();
            }
            WcPayKeyboard.e(WcPayKeyboard.this);
            AppMethodBeat.o(72663);
          }
        });
        AppMethodBeat.o(72686);
        return;
        this.Rso.hgX();
      }
    }
    if (paramBoolean2)
    {
      this.Rso.hhd();
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(72664);
          WcPayKeyboard.f(WcPayKeyboard.this);
          WcPayKeyboardAnimationActionButton localWcPayKeyboardAnimationActionButton = WcPayKeyboard.d(WcPayKeyboard.this);
          if (localWcPayKeyboardAnimationActionButton.Rte != null) {
            localWcPayKeyboardAnimationActionButton.Rte.start();
          }
          AppMethodBeat.o(72664);
        }
      });
      AppMethodBeat.o(72686);
      return;
    }
    this.Rso.hhh();
    this.Rso.setVisibility(8);
    AppMethodBeat.o(72686);
  }
  
  private boolean hgO()
  {
    return this.Rsq == WcPayKeyboard.b.RsC;
  }
  
  private boolean hgT()
  {
    AppMethodBeat.i(72685);
    boolean bool1;
    if (this.Rsu == null)
    {
      bool1 = false;
      if (this.Rst != null) {
        break label51;
      }
    }
    label51:
    for (boolean bool2 = false;; bool2 = this.Rst.isRunning())
    {
      if ((!bool1) && (!bool2)) {
        break label62;
      }
      AppMethodBeat.o(72685);
      return true;
      bool1 = this.Rsu.isRunning();
      break;
    }
    label62:
    AppMethodBeat.o(72685);
    return false;
  }
  
  private void hgU()
  {
    AppMethodBeat.i(72688);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772204);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(72667);
        WcPayKeyboard.d(WcPayKeyboard.this).setVisibility(4);
        if (this.Rsz) {
          WcPayKeyboard.this.setVisibility(8);
        }
        AppMethodBeat.o(72667);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.Rso.startAnimation(localAnimation);
    AppMethodBeat.o(72688);
  }
  
  private void hgV()
  {
    AppMethodBeat.i(72689);
    setVisibility(0);
    this.Rso.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772203);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.Rso.startAnimation(localAnimation);
    AppMethodBeat.o(72689);
  }
  
  private void init()
  {
    AppMethodBeat.i(72674);
    LayoutInflater.from(getContext()).inflate(2131497039, this, true);
    this.Rsn = ((LinearLayout)findViewById(2131302959));
    this.Rsi = ((TextView)findViewById(2131302947));
    this.RrZ = ((TextView)findViewById(2131302948));
    this.Rsa = ((TextView)findViewById(2131302949));
    this.Rsb = ((TextView)findViewById(2131302950));
    this.Rsc = ((TextView)findViewById(2131302951));
    this.Rsd = ((TextView)findViewById(2131302952));
    this.Rse = ((TextView)findViewById(2131302953));
    this.Rsf = ((TextView)findViewById(2131302954));
    this.Rsg = ((TextView)findViewById(2131302955));
    this.Rsh = ((TextView)findViewById(2131302956));
    this.Rsj = ((TextView)findViewById(2131302961));
    this.Rsl = findViewById(2131302960);
    this.Rsk = ((TextView)findViewById(2131302957));
    this.Rso = ((WcPayKeyboardAnimationActionButton)findViewById(2131302958));
    this.nAB = ((TextView)findViewById(2131302963));
    this.Rsm = ((ViewGroup)findViewById(2131302962));
    this.Rsk.setTypeface(Typeface.defaultFromStyle(1));
    this.Rsk.setTextSize(1, 17.0F * com.tencent.mm.cb.a.ez(getContext()));
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72652);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/keyboard/WcPayKeyboard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (WcPayKeyboard.a(WcPayKeyboard.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/keyboard/WcPayKeyboard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72652);
          return;
        }
        int i;
        if (paramAnonymousView.getId() == 2131302947) {
          i = 7;
        }
        for (;;)
        {
          if (!Util.isEqual(i, 0)) {
            paramAnonymousView.performHapticFeedback(0, 2);
          }
          if (paramAnonymousView.getId() != 2131302957) {
            paramAnonymousView.getId();
          }
          WcPayKeyboard.a(WcPayKeyboard.this).dispatchKeyEvent(new KeyEvent(0, i));
          WcPayKeyboard.a(WcPayKeyboard.this).dispatchKeyEvent(new KeyEvent(1, i));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/keyboard/WcPayKeyboard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72652);
          return;
          if (paramAnonymousView.getId() == 2131302948) {
            i = 8;
          } else if (paramAnonymousView.getId() == 2131302949) {
            i = 9;
          } else if (paramAnonymousView.getId() == 2131302950) {
            i = 10;
          } else if (paramAnonymousView.getId() == 2131302951) {
            i = 11;
          } else if (paramAnonymousView.getId() == 2131302952) {
            i = 12;
          } else if (paramAnonymousView.getId() == 2131302953) {
            i = 13;
          } else if (paramAnonymousView.getId() == 2131302954) {
            i = 14;
          } else if (paramAnonymousView.getId() == 2131302955) {
            i = 15;
          } else if (paramAnonymousView.getId() == 2131302956) {
            i = 16;
          } else if (paramAnonymousView.getId() == 2131302960) {
            i = 67;
          } else if (paramAnonymousView.getId() == 2131302961) {
            i = 56;
          } else if ((paramAnonymousView.getId() == 2131302957) || (paramAnonymousView.getId() == 2131302958)) {
            i = 66;
          } else {
            i = 0;
          }
        }
      }
    };
    this.Rsn.setOnClickListener(local1);
    this.Rsi.setOnClickListener(local1);
    this.RrZ.setOnClickListener(local1);
    this.Rsa.setOnClickListener(local1);
    this.Rsb.setOnClickListener(local1);
    this.Rsc.setOnClickListener(local1);
    this.Rsd.setOnClickListener(local1);
    this.Rse.setOnClickListener(local1);
    this.Rsf.setOnClickListener(local1);
    this.Rsg.setOnClickListener(local1);
    this.Rsh.setOnClickListener(local1);
    this.Rsl.setOnClickListener(local1);
    this.Rsj.setOnClickListener(local1);
    this.Rsk.setOnClickListener(local1);
    this.Rso.setOnClickListener(local1);
    AppMethodBeat.o(72674);
  }
  
  private void setWindowViewBottomMargin(int paramInt)
  {
    AppMethodBeat.i(72692);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.Rsp.getLayoutParams();
    localLayoutParams.bottomMargin = paramInt;
    this.Rsp.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(72692);
  }
  
  public final void DH(boolean paramBoolean)
  {
    AppMethodBeat.i(72683);
    this.Rsk.setEnabled(paramBoolean);
    this.Rso.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      if (ao.isDarkMode())
      {
        this.Rsk.setBackgroundResource(2131235694);
        this.Rsk.setTextColor(Color.parseColor("#347051"));
        AppMethodBeat.o(72683);
        return;
      }
      this.Rsk.setBackgroundResource(2131235693);
      this.Rsk.setTextColor(Color.parseColor("#CDF2DF"));
      AppMethodBeat.o(72683);
      return;
    }
    this.Rsk.setBackgroundResource(2131235693);
    this.Rsk.setTextColor(getResources().getColor(2131101430));
    AppMethodBeat.o(72683);
  }
  
  public final void DJ(final boolean paramBoolean)
  {
    AppMethodBeat.i(72690);
    setVisibility(0);
    this.Rsn.setVisibility(4);
    this.Rsn.post(new Runnable()
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
            Log.d("MicroMsg.WcPayKeyBoard", "keyboard anim end");
            if (!WcPayKeyboard.2.this.Rsw)
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
            if (WcPayKeyboard.2.this.Rsw)
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
              Log.v("MicroMsg.WcPayKeyBoard", "showWcPayKeyboardBase() onAnimationUpdate() baseHeight:%s translationY:%s %s", new Object[] { Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
              WcPayKeyboard.g(WcPayKeyboard.this).bO(f2);
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
  
  public final void fEW()
  {
    AppMethodBeat.i(72682);
    this.nAB.setVisibility(8);
    if (this.Rsn.isShown()) {
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
  
  public final void hgN()
  {
    AppMethodBeat.i(72677);
    Log.i("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() %s %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.Rsq, Boolean.valueOf(hgS()), Util.getStack() });
    if (hgS())
    {
      AppMethodBeat.o(72677);
      return;
    }
    if (this.Rsq == WcPayKeyboard.b.RsD)
    {
      AppMethodBeat.o(72677);
      return;
    }
    if ((isShown()) && (hgP())) {
      bj(true, false);
    }
    for (;;)
    {
      this.Rsq = WcPayKeyboard.b.RsC;
      AppMethodBeat.o(72677);
      return;
      if (!isShown()) {
        if (hgP()) {
          Log.e("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() why here??");
        } else if (hgO()) {
          hgV();
        }
      }
    }
  }
  
  public final boolean hgP()
  {
    return this.Rsq == WcPayKeyboard.b.RsB;
  }
  
  public final boolean hgQ()
  {
    return this.Rsq == WcPayKeyboard.b.RsD;
  }
  
  public final boolean hgR()
  {
    AppMethodBeat.i(72679);
    if ((getVisibility() == 8) && (!hgQ()))
    {
      AppMethodBeat.o(72679);
      return true;
    }
    AppMethodBeat.o(72679);
    return false;
  }
  
  public final boolean hgS()
  {
    AppMethodBeat.i(72684);
    if ((hgT()) || (this.Rso.hgY()))
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
    Log.i("MicroMsg.WcPayKeyBoard", "hideWcKb() %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.Rsq, Util.getStack() });
    if (hgS())
    {
      AppMethodBeat.o(72676);
      return;
    }
    if (this.Rsq == WcPayKeyboard.b.RsD)
    {
      AppMethodBeat.o(72676);
      return;
    }
    if (isShown())
    {
      if (hgP()) {
        DI(true);
      }
      if (hgO()) {
        hgU();
      }
    }
    AppMethodBeat.o(72676);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(72675);
    if ((isShown()) && (hgP()))
    {
      hgN();
      AppMethodBeat.o(72675);
      return true;
    }
    AppMethodBeat.o(72675);
    return false;
  }
  
  public final void s(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(214331);
    paramMMActivity = (LayoutListenerView)paramMMActivity.findViewById(2131304715);
    paramMMActivity.setBackgroundColor(-1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 80;
    paramMMActivity.addView(this, localLayoutParams);
    setVisibility(8);
    this.Rsp = paramMMActivity.getChildAt(0);
    this.Rss = true;
    AppMethodBeat.o(214331);
  }
  
  public void setActionText(String paramString)
  {
    AppMethodBeat.i(72680);
    this.Rsk.setText(paramString);
    AppMethodBeat.o(72680);
  }
  
  public void setHeightListener(a parama)
  {
    this.Rsr = parama;
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
    this.nAB.setText(paramString);
    this.nAB.setVisibility(0);
    if (this.Rsn.isShown()) {
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
    Log.i("MicroMsg.WcPayKeyBoard", "showNormalStWcKb() %s %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.Rsq, Boolean.valueOf(hgS()), Util.getStack() });
    if (hgS())
    {
      AppMethodBeat.o(72678);
      return;
    }
    if (isShown()) {
      if (hgO()) {
        bj(false, true);
      }
    }
    for (;;)
    {
      this.Rsq = WcPayKeyboard.b.RsB;
      AppMethodBeat.o(72678);
      return;
      if (hgO()) {
        bj(false, false);
      }
      DJ(true);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bO(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboard
 * JD-Core Version:    0.7.0.1
 */