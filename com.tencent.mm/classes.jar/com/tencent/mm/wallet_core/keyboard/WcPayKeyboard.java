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
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.gridlayout.widget.GridLayout;
import androidx.gridlayout.widget.GridLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.type.ViewType;
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
import com.tencent.mm.ui.aw;
import com.tencent.mm.wallet_core.c;

public class WcPayKeyboard
  extends RelativeLayout
{
  public ObjectAnimator Jvf;
  private TextView agRD;
  private TextView agRE;
  private View agRF;
  private ViewGroup agRG;
  private LinearLayout agRH;
  private WcPayKeyboardAnimationActionButton agRI;
  private View agRJ;
  private WcPayKeyboard.b agRK;
  private a agRL;
  private boolean agRM;
  public ObjectAnimator agRN;
  public EditText mInputEditText;
  private TextView mKey0;
  private TextView mKey1;
  private TextView mKey2;
  private TextView mKey3;
  private TextView mKey4;
  private TextView mKey5;
  private TextView mKey6;
  private TextView mKey7;
  private TextView mKey8;
  private TextView mKey9;
  private TextView tHK;
  
  public WcPayKeyboard(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(72671);
    this.agRK = WcPayKeyboard.b.agRW;
    this.agRM = false;
    this.agRN = null;
    this.Jvf = null;
    init();
    AppMethodBeat.o(72671);
  }
  
  public WcPayKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72672);
    this.agRK = WcPayKeyboard.b.agRW;
    this.agRM = false;
    this.agRN = null;
    this.Jvf = null;
    init();
    AppMethodBeat.o(72672);
  }
  
  public WcPayKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72673);
    this.agRK = WcPayKeyboard.b.agRW;
    this.agRM = false;
    this.agRN = null;
    this.Jvf = null;
    init();
    AppMethodBeat.o(72673);
  }
  
  private void Oj(final boolean paramBoolean)
  {
    AppMethodBeat.i(72687);
    if (this.agRM)
    {
      Ol(paramBoolean);
      AppMethodBeat.o(72687);
      return;
    }
    final int i = this.agRH.getHeight();
    if (this.Jvf == null)
    {
      this.Jvf = ObjectAnimator.ofFloat(this.agRH, "translationY", new float[] { 0.0F, i });
      this.Jvf.setDuration(300L);
      this.Jvf.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    this.Jvf.removeAllListeners();
    this.Jvf.addListener(new Animator.AnimatorListener()
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
    this.Jvf.removeAllUpdateListeners();
    this.Jvf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(72666);
        if (WcPayKeyboard.g(WcPayKeyboard.this) != null)
        {
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          float f2 = i - f1;
          Log.v("MicroMsg.WcPayKeyBoard", "hideWcPayKeyboardBase() onAnimationUpdate() baseHeight:%s translationY:%s %s", new Object[] { Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
          WcPayKeyboard.g(WcPayKeyboard.this).cY(f2);
        }
        AppMethodBeat.o(72666);
      }
    });
    this.Jvf.start();
    AppMethodBeat.o(72687);
  }
  
  private void Ol(final boolean paramBoolean)
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
    this.agRH.startAnimation(localAnimation);
    setWindowViewBottomMargin(0);
    AppMethodBeat.o(72691);
  }
  
  private void bU(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(72686);
    if (paramBoolean1)
    {
      this.agRI.setVisibility(0);
      if (this.agRI.agSl)
      {
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        this.agRE.getLocationOnScreen(arrayOfInt1);
        this.agRG.getLocationOnScreen(arrayOfInt2);
        if (this.tHK.isShown())
        {
          this.tHK.getHeight();
          com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
        }
        this.agRF.getHeight();
        com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
        int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
        this.agRI.aj(this.agRE.getWidth(), this.agRE.getHeight(), i, arrayOfInt1[0]);
      }
      for (;;)
      {
        this.agRI.agSi = this.agRE.getText();
        this.agRE.setVisibility(4);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(72663);
            WcPayKeyboardAnimationActionButton localWcPayKeyboardAnimationActionButton = WcPayKeyboard.d(WcPayKeyboard.this);
            if (localWcPayKeyboardAnimationActionButton.Div != null) {
              localWcPayKeyboardAnimationActionButton.Div.start();
            }
            WcPayKeyboard.e(WcPayKeyboard.this);
            AppMethodBeat.o(72663);
          }
        });
        AppMethodBeat.o(72686);
        return;
        this.agRI.jOu();
      }
    }
    if (paramBoolean2)
    {
      this.agRI.jOA();
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(72664);
          WcPayKeyboard.f(WcPayKeyboard.this);
          WcPayKeyboardAnimationActionButton localWcPayKeyboardAnimationActionButton = WcPayKeyboard.d(WcPayKeyboard.this);
          if (localWcPayKeyboardAnimationActionButton.agSx != null) {
            localWcPayKeyboardAnimationActionButton.agSx.start();
          }
          AppMethodBeat.o(72664);
        }
      });
      AppMethodBeat.o(72686);
      return;
    }
    this.agRI.jOE();
    this.agRI.setVisibility(8);
    AppMethodBeat.o(72686);
  }
  
  private void init()
  {
    AppMethodBeat.i(72674);
    LayoutInflater.from(getContext()).inflate(a.g.wc_pay_keyboard, this, true);
    this.agRH = ((LinearLayout)findViewById(a.f.keyboard_base));
    this.mKey0 = ((TextView)findViewById(a.f.keyboard_0));
    this.mKey1 = ((TextView)findViewById(a.f.keyboard_1));
    this.mKey2 = ((TextView)findViewById(a.f.keyboard_2));
    this.mKey3 = ((TextView)findViewById(a.f.keyboard_3));
    this.mKey4 = ((TextView)findViewById(a.f.keyboard_4));
    this.mKey5 = ((TextView)findViewById(a.f.keyboard_5));
    this.mKey6 = ((TextView)findViewById(a.f.keyboard_6));
    this.mKey7 = ((TextView)findViewById(a.f.keyboard_7));
    this.mKey8 = ((TextView)findViewById(a.f.keyboard_8));
    this.mKey9 = ((TextView)findViewById(a.f.keyboard_9));
    this.agRD = ((TextView)findViewById(a.f.keyboard_dot));
    this.agRF = findViewById(a.f.keyboard_del);
    this.agRE = ((TextView)findViewById(a.f.keyboard_action));
    this.agRI = ((WcPayKeyboardAnimationActionButton)findViewById(a.f.keyboard_animation_action));
    this.tHK = ((TextView)findViewById(a.f.keyboard_tip_tv));
    this.agRG = ((ViewGroup)findViewById(a.f.keyboard_gl));
    this.agRE.setTypeface(Typeface.defaultFromStyle(1));
    this.agRE.setTextSize(1, 17.0F * com.tencent.mm.cd.a.getScaleSize(getContext()));
    Object localObject = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72652);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/wallet_core/keyboard/WcPayKeyboard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    this.agRH.setOnClickListener((View.OnClickListener)localObject);
    this.mKey0.setOnClickListener((View.OnClickListener)localObject);
    this.mKey1.setOnClickListener((View.OnClickListener)localObject);
    this.mKey2.setOnClickListener((View.OnClickListener)localObject);
    this.mKey3.setOnClickListener((View.OnClickListener)localObject);
    this.mKey4.setOnClickListener((View.OnClickListener)localObject);
    this.mKey5.setOnClickListener((View.OnClickListener)localObject);
    this.mKey6.setOnClickListener((View.OnClickListener)localObject);
    this.mKey7.setOnClickListener((View.OnClickListener)localObject);
    this.mKey8.setOnClickListener((View.OnClickListener)localObject);
    this.mKey9.setOnClickListener((View.OnClickListener)localObject);
    this.agRF.setOnClickListener((View.OnClickListener)localObject);
    this.agRD.setOnClickListener((View.OnClickListener)localObject);
    this.agRE.setOnClickListener((View.OnClickListener)localObject);
    this.agRI.setOnClickListener((View.OnClickListener)localObject);
    localObject = new c();
    ((c)localObject).setViewType(ViewType.Button);
    this.agRE.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    this.agRF.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    AppMethodBeat.o(72674);
  }
  
  private boolean jOq()
  {
    AppMethodBeat.i(72685);
    boolean bool1;
    if (this.Jvf == null)
    {
      bool1 = false;
      if (this.agRN != null) {
        break label51;
      }
    }
    label51:
    for (boolean bool2 = false;; bool2 = this.agRN.isRunning())
    {
      if ((!bool1) && (!bool2)) {
        break label62;
      }
      AppMethodBeat.o(72685);
      return true;
      bool1 = this.Jvf.isRunning();
      break;
    }
    label62:
    AppMethodBeat.o(72685);
    return false;
  }
  
  private void jOr()
  {
    AppMethodBeat.i(72688);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.wc_keyboard_push_down_out);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(72667);
        WcPayKeyboard.d(WcPayKeyboard.this).setVisibility(4);
        if (this.agRS) {
          WcPayKeyboard.this.setVisibility(8);
        }
        AppMethodBeat.o(72667);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.agRI.startAnimation(localAnimation);
    AppMethodBeat.o(72688);
  }
  
  private void jOs()
  {
    AppMethodBeat.i(72689);
    setVisibility(0);
    this.agRI.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.wc_keyboard_push_down_in);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.agRI.startAnimation(localAnimation);
    AppMethodBeat.o(72689);
  }
  
  private void setWindowViewBottomMargin(int paramInt)
  {
    AppMethodBeat.i(72692);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.agRJ.getLayoutParams();
    localLayoutParams.bottomMargin = paramInt;
    this.agRJ.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(72692);
  }
  
  public final void Oi(boolean paramBoolean)
  {
    AppMethodBeat.i(72683);
    this.agRE.setEnabled(paramBoolean);
    this.agRI.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      if (aw.isDarkMode())
      {
        this.agRE.setBackgroundResource(a.e.wc_pay_kb_action_btn_bg_disable_dm);
        this.agRE.setTextColor(Color.parseColor("#347051"));
        AppMethodBeat.o(72683);
        return;
      }
      this.agRE.setBackgroundResource(a.e.wc_pay_kb_action_btn_bg);
      this.agRE.setTextColor(Color.parseColor("#CDF2DF"));
      AppMethodBeat.o(72683);
      return;
    }
    this.agRE.setBackgroundResource(a.e.wc_pay_kb_action_btn_bg);
    this.agRE.setTextColor(getResources().getColor(a.c.white_text_color_selector));
    AppMethodBeat.o(72683);
  }
  
  public final void Ok(final boolean paramBoolean)
  {
    AppMethodBeat.i(72690);
    setVisibility(0);
    this.agRH.setVisibility(4);
    this.agRH.post(new Runnable()
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
          WcPayKeyboard.h(WcPayKeyboard.this).setInterpolator(new AccelerateDecelerateInterpolator());
        }
        WcPayKeyboard.h(WcPayKeyboard.this).removeAllListeners();
        WcPayKeyboard.h(WcPayKeyboard.this).addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
          
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(72654);
            Log.d("MicroMsg.WcPayKeyBoard", "keyboard anim end");
            if (!WcPayKeyboard.2.this.agRP)
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
            if (WcPayKeyboard.2.this.agRP)
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
              WcPayKeyboard.g(WcPayKeyboard.this).cY(f2);
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
  
  public final void hVf()
  {
    AppMethodBeat.i(72682);
    this.tHK.setVisibility(8);
    if (this.agRH.isShown()) {
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
    Log.i("MicroMsg.WcPayKeyBoard", "hideWcKb() %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.agRK, Util.getStack() });
    if (jOp())
    {
      AppMethodBeat.o(72676);
      return;
    }
    if (this.agRK == WcPayKeyboard.b.agRW)
    {
      AppMethodBeat.o(72676);
      return;
    }
    if (isShown())
    {
      if (jOm()) {
        Oj(true);
      }
      if (jOl()) {
        jOr();
      }
    }
    AppMethodBeat.o(72676);
  }
  
  public final void jOk()
  {
    AppMethodBeat.i(72677);
    Log.i("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() %s %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.agRK, Boolean.valueOf(jOp()), Util.getStack() });
    if (jOp())
    {
      AppMethodBeat.o(72677);
      return;
    }
    if (this.agRK == WcPayKeyboard.b.agRW)
    {
      AppMethodBeat.o(72677);
      return;
    }
    if ((isShown()) && (jOm())) {
      bU(true, false);
    }
    for (;;)
    {
      this.agRK = WcPayKeyboard.b.agRV;
      AppMethodBeat.o(72677);
      return;
      if (!isShown()) {
        if (jOm()) {
          Log.e("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() why here??");
        } else if (jOl()) {
          jOs();
        }
      }
    }
  }
  
  public final boolean jOl()
  {
    return this.agRK == WcPayKeyboard.b.agRV;
  }
  
  public final boolean jOm()
  {
    return this.agRK == WcPayKeyboard.b.agRU;
  }
  
  public final boolean jOn()
  {
    return this.agRK == WcPayKeyboard.b.agRW;
  }
  
  public final boolean jOo()
  {
    AppMethodBeat.i(72679);
    if ((getVisibility() == 8) && (!jOn()))
    {
      AppMethodBeat.o(72679);
      return true;
    }
    AppMethodBeat.o(72679);
    return false;
  }
  
  public final boolean jOp()
  {
    AppMethodBeat.i(72684);
    if ((jOq()) || (this.agRI.jOv()))
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
    if ((isShown()) && (jOm()))
    {
      jOk();
      AppMethodBeat.o(72675);
      return true;
    }
    AppMethodBeat.o(72675);
    return false;
  }
  
  public void setActionBtnColor(int paramInt)
  {
    AppMethodBeat.i(242139);
    this.agRE.setBackgroundResource(paramInt);
    this.agRI.setBackgroundResource(paramInt);
    AppMethodBeat.o(242139);
  }
  
  public void setActionText(String paramString)
  {
    AppMethodBeat.i(72680);
    this.agRE.setText(paramString);
    AppMethodBeat.o(72680);
  }
  
  public void setHeightListener(a parama)
  {
    this.agRL = parama;
  }
  
  public void setInputEditText(EditText paramEditText)
  {
    if (paramEditText != null) {
      this.mInputEditText = paramEditText;
    }
  }
  
  public void setIsOnlySupportInteger(boolean paramBoolean)
  {
    AppMethodBeat.i(242138);
    if (paramBoolean)
    {
      this.agRD.setVisibility(8);
      localLayoutParams = (GridLayout.LayoutParams)this.mKey0.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bGG = GridLayout.a(-2147483648, 3, GridLayout.bFB, 1.0F);
        this.mKey0.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(242138);
      return;
    }
    this.agRD.setVisibility(0);
    GridLayout.LayoutParams localLayoutParams = (GridLayout.LayoutParams)this.mKey0.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.bGG = GridLayout.a(-2147483648, 2, GridLayout.bFB, 1.0F);
      this.mKey0.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(242138);
  }
  
  public void setTipText(String paramString)
  {
    AppMethodBeat.i(72681);
    this.tHK.setText(paramString);
    this.tHK.setVisibility(0);
    if (this.agRH.isShown()) {
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
    Log.i("MicroMsg.WcPayKeyBoard", "showNormalStWcKb() %s %s %s [%s]", new Object[] { Boolean.valueOf(isShown()), this.agRK, Boolean.valueOf(jOp()), Util.getStack() });
    if (jOp())
    {
      AppMethodBeat.o(72678);
      return;
    }
    if (isShown()) {
      if (jOl()) {
        bU(false, true);
      }
    }
    for (;;)
    {
      this.agRK = WcPayKeyboard.b.agRU;
      AppMethodBeat.o(72678);
      return;
      if (jOl()) {
        bU(false, false);
      }
      Ok(true);
    }
  }
  
  public final void y(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(242140);
    paramMMActivity = (LayoutListenerView)paramMMActivity.findViewById(a.f.mm_content_fl);
    paramMMActivity.setBackgroundColor(-1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 80;
    paramMMActivity.addView(this, localLayoutParams);
    setVisibility(8);
    this.agRJ = paramMMActivity.getChildAt(0);
    this.agRM = true;
    AppMethodBeat.o(242140);
  }
  
  public static abstract interface a
  {
    public abstract void cY(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboard
 * JD-Core Version:    0.7.0.1
 */