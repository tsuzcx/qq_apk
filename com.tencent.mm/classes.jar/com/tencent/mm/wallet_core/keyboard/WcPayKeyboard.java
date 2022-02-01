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
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.LayoutListenerView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;

public class WcPayKeyboard
  extends RelativeLayout
{
  private ObjectAnimator DCf;
  private TextView YTA;
  private TextView YTB;
  private TextView YTC;
  private TextView YTD;
  private TextView YTE;
  private TextView YTF;
  private TextView YTG;
  private TextView YTH;
  private TextView YTI;
  private TextView YTJ;
  private TextView YTK;
  private View YTL;
  private ViewGroup YTM;
  private LinearLayout YTN;
  private WcPayKeyboardAnimationActionButton YTO;
  private View YTP;
  private WcPayKeyboard.b YTQ;
  private a YTR;
  private boolean YTS;
  private ObjectAnimator YTT;
  private TextView YTz;
  public EditText mInputEditText;
  private TextView qCM;
  
  public WcPayKeyboard(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(72671);
    this.YTQ = WcPayKeyboard.b.YUc;
    this.YTS = false;
    this.YTT = null;
    this.DCf = null;
    init();
    AppMethodBeat.o(72671);
  }
  
  public WcPayKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72672);
    this.YTQ = WcPayKeyboard.b.YUc;
    this.YTS = false;
    this.YTT = null;
    this.DCf = null;
    init();
    AppMethodBeat.o(72672);
  }
  
  public WcPayKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72673);
    this.YTQ = WcPayKeyboard.b.YUc;
    this.YTS = false;
    this.YTT = null;
    this.DCf = null;
    init();
    AppMethodBeat.o(72673);
  }
  
  private void Ii(final boolean paramBoolean)
  {
    AppMethodBeat.i(72687);
    if (this.YTS)
    {
      Ik(paramBoolean);
      AppMethodBeat.o(72687);
      return;
    }
    final int i = this.YTN.getHeight();
    if (this.DCf == null)
    {
      this.DCf = ObjectAnimator.ofFloat(this.YTN, "translationY", new float[] { 0.0F, i });
      this.DCf.setDuration(300L);
      this.DCf.setInterpolator(new LinearInterpolator());
    }
    this.DCf.removeAllListeners();
    this.DCf.addListener(new Animator.AnimatorListener()
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
    this.DCf.removeAllUpdateListeners();
    this.DCf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(72666);
        if (WcPayKeyboard.g(WcPayKeyboard.this) != null)
        {
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          float f2 = i - f1;
          Log.v("MicroMsg.WcPayKeyBoard", "hideWcPayKeyboardBase() onAnimationUpdate() baseHeight:%s translationY:%s %s", new Object[] { Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
          WcPayKeyboard.g(WcPayKeyboard.this).bU(f2);
        }
        AppMethodBeat.o(72666);
      }
    });
    this.DCf.start();
    AppMethodBeat.o(72687);
  }
  
  private void Ik(final boolean paramBoolean)
  {
    AppMethodBeat.i(72691);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.sight_slide_bottom_out);
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
    this.YTN.startAnimation(localAnimation);
    setWindowViewBottomMargin(0);
    AppMethodBeat.o(72691);
  }
  
  private void bt(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(72686);
    if (paramBoolean1)
    {
      this.YTO.setVisibility(0);
      if (this.YTO.YUr)
      {
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        this.YTK.getLocationOnScreen(arrayOfInt1);
        this.YTM.getLocationOnScreen(arrayOfInt2);
        if (this.qCM.isShown())
        {
          this.qCM.getHeight();
          com.tencent.mm.ci.a.fromDPToPix(getContext(), 24);
        }
        this.YTL.getHeight();
        com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
        int i = com.tencent.mm.ci.a.fromDPToPix(getContext(), 8);
        this.YTO.Z(this.YTK.getWidth(), this.YTK.getHeight(), i, arrayOfInt1[0]);
      }
      for (;;)
      {
        this.YTO.YUo = this.YTK.getText();
        this.YTK.setVisibility(4);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(72663);
            WcPayKeyboardAnimationActionButton localWcPayKeyboardAnimationActionButton = WcPayKeyboard.d(WcPayKeyboard.this);
            if (localWcPayKeyboardAnimationActionButton.IVc != null) {
              localWcPayKeyboardAnimationActionButton.IVc.start();
            }
            WcPayKeyboard.e(WcPayKeyboard.this);
            AppMethodBeat.o(72663);
          }
        });
        AppMethodBeat.o(72686);
        return;
        this.YTO.iiz();
      }
    }
    if (paramBoolean2)
    {
      this.YTO.iiF();
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(72664);
          WcPayKeyboard.f(WcPayKeyboard.this);
          WcPayKeyboardAnimationActionButton localWcPayKeyboardAnimationActionButton = WcPayKeyboard.d(WcPayKeyboard.this);
          if (localWcPayKeyboardAnimationActionButton.YUC != null) {
            localWcPayKeyboardAnimationActionButton.YUC.start();
          }
          AppMethodBeat.o(72664);
        }
      });
      AppMethodBeat.o(72686);
      return;
    }
    this.YTO.iiJ();
    this.YTO.setVisibility(8);
    AppMethodBeat.o(72686);
  }
  
  private boolean iiq()
  {
    return this.YTQ == WcPayKeyboard.b.YUb;
  }
  
  private boolean iiv()
  {
    AppMethodBeat.i(72685);
    boolean bool1;
    if (this.DCf == null)
    {
      bool1 = false;
      if (this.YTT != null) {
        break label51;
      }
    }
    label51:
    for (boolean bool2 = false;; bool2 = this.YTT.isRunning())
    {
      if ((!bool1) && (!bool2)) {
        break label62;
      }
      AppMethodBeat.o(72685);
      return true;
      bool1 = this.DCf.isRunning();
      break;
    }
    label62:
    AppMethodBeat.o(72685);
    return false;
  }
  
  private void iiw()
  {
    AppMethodBeat.i(72688);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.wc_keyboard_push_down_out);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(72667);
        WcPayKeyboard.d(WcPayKeyboard.this).setVisibility(4);
        if (this.YTY) {
          WcPayKeyboard.this.setVisibility(8);
        }
        AppMethodBeat.o(72667);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.YTO.startAnimation(localAnimation);
    AppMethodBeat.o(72688);
  }
  
  private void iix()
  {
    AppMethodBeat.i(72689);
    setVisibility(0);
    this.YTO.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.wc_keyboard_push_down_in);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.YTO.startAnimation(localAnimation);
    AppMethodBeat.o(72689);
  }
  
  private void init()
  {
    AppMethodBeat.i(72674);
    LayoutInflater.from(getContext()).inflate(a.g.wc_pay_keyboard, this, true);
    this.YTN = ((LinearLayout)findViewById(a.f.keyboard_base));
    this.YTI = ((TextView)findViewById(a.f.keyboard_0));
    this.YTz = ((TextView)findViewById(a.f.keyboard_1));
    this.YTA = ((TextView)findViewById(a.f.keyboard_2));
    this.YTB = ((TextView)findViewById(a.f.keyboard_3));
    this.YTC = ((TextView)findViewById(a.f.keyboard_4));
    this.YTD = ((TextView)findViewById(a.f.keyboard_5));
    this.YTE = ((TextView)findViewById(a.f.keyboard_6));
    this.YTF = ((TextView)findViewById(a.f.keyboard_7));
    this.YTG = ((TextView)findViewById(a.f.keyboard_8));
    this.YTH = ((TextView)findViewById(a.f.keyboard_9));
    this.YTJ = ((TextView)findViewById(a.f.keyboard_dot));
    this.YTL = findViewById(a.f.keyboard_del);
    this.YTK = ((TextView)findViewById(a.f.keyboard_action));
    this.YTO = ((WcPayKeyboardAnimationActionButton)findViewById(a.f.keyboard_animation_action));
    this.qCM = ((TextView)findViewById(a.f.keyboard_tip_tv));
    this.YTM = ((ViewGroup)findViewById(a.f.keyboard_gl));
    this.YTK.setTypeface(Typeface.defaultFromStyle(1));
    this.YTK.setTextSize(1, 17.0F * com.tencent.mm.ci.a.ez(getContext()));
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72652);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/wallet_core/keyboard/WcPayKeyboard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (WcPayKeyboard.a(WcPayKeyboard.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/keyboard/WcPayKeyboard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72652);
          return;
        }
        int i;
        if (paramAnonymousView.getId() == a.f.keyboard_0) {
          i = 7;
        }
        for (;;)
        {
          if (!Util.isEqual(i, 0)) {
            paramAnonymousView.performHapticFeedback(0, 2);
          }
          if (paramAnonymousView.getId() != a.f.keyboard_action) {
            paramAnonymousView.getId();
          }
          WcPayKeyboard.a(WcPayKeyboard.this).dispatchKeyEvent(new KeyEvent(0, i));
          WcPayKeyboard.a(WcPayKeyboard.this).dispatchKeyEvent(new KeyEvent(1, i));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/keyboard/WcPayKeyboard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72652);
          return;
          if (paramAnonymousView.getId() == a.f.keyboard_1) {
            i = 8;
          } else if (paramAnonymousView.getId() == a.f.keyboard_2) {
            i = 9;
          } else if (paramAnonymousView.getId() == a.f.keyboard_3) {
            i = 10;
          } else if (paramAnonymousView.getId() == a.f.keyboard_4) {
            i = 11;
          } else if (paramAnonymousView.getId() == a.f.keyboard_5) {
            i = 12;
          } else if (paramAnonymousView.getId() == a.f.keyboard_6) {
            i = 13;
          } else if (paramAnonymousView.getId() == a.f.keyboard_7) {
            i = 14;
          } else if (paramAnonymousView.getId() == a.f.keyboard_8) {
            i = 15;
          } else if (paramAnonymousView.getId() == a.f.keyboard_9) {
            i = 16;
          } else if (paramAnonymousView.getId() == a.f.keyboard_del) {
            i = 67;
          } else if (paramAnonymousView.getId() == a.f.keyboard_dot) {
            i = 56;
          } else if ((paramAnonymousView.getId() == a.f.keyboard_action) || (paramAnonymousView.getId() == a.f.keyboard_animation_action)) {
            i = 66;
          } else {
            i = 0;
          }
        }
      }
    };
    this.YTN.setOnClickListener(local1);
    this.YTI.setOnClickListener(local1);
    this.YTz.setOnClickListener(local1);
    this.YTA.setOnClickListener(local1);
    this.YTB.setOnClickListener(local1);
    this.YTC.setOnClickListener(local1);
    this.YTD.setOnClickListener(local1);
    this.YTE.setOnClickListener(local1);
    this.YTF.setOnClickListener(local1);
    this.YTG.setOnClickListener(local1);
    this.YTH.setOnClickListener(local1);
    this.YTL.setOnClickListener(local1);
    this.YTJ.setOnClickListener(local1);
    this.YTK.setOnClickListener(local1);
    this.YTO.setOnClickListener(local1);
    AppMethodBeat.o(72674);
  }
  
  private void setWindowViewBottomMargin(int paramInt)
  {
    AppMethodBeat.i(72692);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.YTP.getLayoutParams();
    localLayoutParams.bottomMargin = paramInt;
    this.YTP.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(72692);
  }
  
  public final void Ih(boolean paramBoolean)
  {
    AppMethodBeat.i(72683);
    this.YTK.setEnabled(paramBoolean);
    this.YTO.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      if (ar.isDarkMode())
      {
        this.YTK.setBackgroundResource(a.e.wc_pay_kb_action_btn_bg_disable_dm);
        this.YTK.setTextColor(Color.parseColor("#347051"));
        AppMethodBeat.o(72683);
        return;
      }
      this.YTK.setBackgroundResource(a.e.wc_pay_kb_action_btn_bg);
      this.YTK.setTextColor(Color.parseColor("#CDF2DF"));
      AppMethodBeat.o(72683);
      return;
    }
    this.YTK.setBackgroundResource(a.e.wc_pay_kb_action_btn_bg);
    this.YTK.setTextColor(getResources().getColor(a.c.white_text_color_selector));
    AppMethodBeat.o(72683);
  }
  
  public final void Ij(final boolean paramBoolean)
  {
    AppMethodBeat.i(72690);
    setVisibility(0);
    this.YTN.setVisibility(4);
    this.YTN.post(new Runnable()
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
            if (!WcPayKeyboard.2.this.YTV)
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
            if (WcPayKeyboard.2.this.YTV)
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
              WcPayKeyboard.g(WcPayKeyboard.this).bU(f2);
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
  
  public final void gxi()
  {
    AppMethodBeat.i(72682);
    this.qCM.setVisibility(8);
    if (this.YTN.isShown()) {
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
  
  public final void hideWcKb()
  {
    AppMethodBeat.i(72676);
    Log.i("MicroMsg.WcPayKeyBoard", "hideWcKb() %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.YTQ, Util.getStack() });
    if (iiu())
    {
      AppMethodBeat.o(72676);
      return;
    }
    if (this.YTQ == WcPayKeyboard.b.YUc)
    {
      AppMethodBeat.o(72676);
      return;
    }
    if (isShown())
    {
      if (iir()) {
        Ii(true);
      }
      if (iiq()) {
        iiw();
      }
    }
    AppMethodBeat.o(72676);
  }
  
  public final void iip()
  {
    AppMethodBeat.i(72677);
    Log.i("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() %s %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.YTQ, Boolean.valueOf(iiu()), Util.getStack() });
    if (iiu())
    {
      AppMethodBeat.o(72677);
      return;
    }
    if (this.YTQ == WcPayKeyboard.b.YUc)
    {
      AppMethodBeat.o(72677);
      return;
    }
    if ((isShown()) && (iir())) {
      bt(true, false);
    }
    for (;;)
    {
      this.YTQ = WcPayKeyboard.b.YUb;
      AppMethodBeat.o(72677);
      return;
      if (!isShown()) {
        if (iir()) {
          Log.e("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() why here??");
        } else if (iiq()) {
          iix();
        }
      }
    }
  }
  
  public final boolean iir()
  {
    return this.YTQ == WcPayKeyboard.b.YUa;
  }
  
  public final boolean iis()
  {
    return this.YTQ == WcPayKeyboard.b.YUc;
  }
  
  public final boolean iit()
  {
    AppMethodBeat.i(72679);
    if ((getVisibility() == 8) && (!iis()))
    {
      AppMethodBeat.o(72679);
      return true;
    }
    AppMethodBeat.o(72679);
    return false;
  }
  
  public final boolean iiu()
  {
    AppMethodBeat.i(72684);
    if ((iiv()) || (this.YTO.iiA()))
    {
      AppMethodBeat.o(72684);
      return true;
    }
    AppMethodBeat.o(72684);
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(72675);
    if ((isShown()) && (iir()))
    {
      iip();
      AppMethodBeat.o(72675);
      return true;
    }
    AppMethodBeat.o(72675);
    return false;
  }
  
  public void setActionText(String paramString)
  {
    AppMethodBeat.i(72680);
    this.YTK.setText(paramString);
    AppMethodBeat.o(72680);
  }
  
  public void setHeightListener(a parama)
  {
    this.YTR = parama;
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
    this.qCM.setText(paramString);
    this.qCM.setVisibility(0);
    if (this.YTN.isShown()) {
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
    Log.i("MicroMsg.WcPayKeyBoard", "showNormalStWcKb() %s %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.YTQ, Boolean.valueOf(iiu()), Util.getStack() });
    if (iiu())
    {
      AppMethodBeat.o(72678);
      return;
    }
    if (isShown()) {
      if (iiq()) {
        bt(false, true);
      }
    }
    for (;;)
    {
      this.YTQ = WcPayKeyboard.b.YUa;
      AppMethodBeat.o(72678);
      return;
      if (iiq()) {
        bt(false, false);
      }
      Ij(true);
    }
  }
  
  public final void t(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(277507);
    paramMMActivity = (LayoutListenerView)paramMMActivity.findViewById(a.f.mm_content_fl);
    paramMMActivity.setBackgroundColor(-1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 80;
    paramMMActivity.addView(this, localLayoutParams);
    setVisibility(8);
    this.YTP = paramMMActivity.getChildAt(0);
    this.YTS = true;
    AppMethodBeat.o(277507);
  }
  
  public static abstract interface a
  {
    public abstract void bU(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboard
 * JD-Core Version:    0.7.0.1
 */