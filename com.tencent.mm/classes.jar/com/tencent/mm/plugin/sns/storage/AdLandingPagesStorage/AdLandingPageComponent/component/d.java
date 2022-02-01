package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import org.json.JSONObject;

public final class d
  extends m
{
  protected ae Kpi;
  protected ImageView Kpj;
  protected TextView Kpk;
  protected TextView Kpl;
  protected FrameLayout Kpm;
  protected RoundedCornerFrameLayout Kpn;
  protected ViewGroup Kpo;
  protected p Kpp;
  protected boolean Kpq;
  public boolean Kpr;
  int clickCount;
  public boolean isFinishing;
  protected View mContentView;
  protected Context mContext;
  protected Handler mHandler;
  
  public d(Context paramContext, ae paramae, ViewGroup paramViewGroup)
  {
    super(paramContext, paramae, paramViewGroup);
    AppMethodBeat.i(96425);
    this.Kpq = false;
    this.clickCount = 0;
    this.mHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(96424);
        if (paramAnonymousMessage.what == 1)
        {
          d.this.B(((Boolean)paramAnonymousMessage.obj).booleanValue());
          AppMethodBeat.o(96424);
          return;
        }
        if (paramAnonymousMessage.what == 2) {
          d.this.C(((Boolean)paramAnonymousMessage.obj).booleanValue());
        }
        AppMethodBeat.o(96424);
      }
    };
    this.mContext = paramContext;
    this.Kpo = paramViewGroup;
    this.Kpi = paramae;
    if (this.Kpi.type == 141) {
      bool = true;
    }
    this.Kpr = bool;
    fKp();
    fKe();
    Log.i("AdLandingFloatBarCompWrapper", "refreshView, cid=" + paramae.KmB + ", hash=" + hashCode());
    AppMethodBeat.o(96425);
  }
  
  private void a(final p paramp, final View paramView, final Button paramButton, final r paramr, float paramFloat, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(243384);
    AnimatorSet localAnimatorSet1 = new AnimatorSet();
    localAnimatorSet1.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat, 0.0F });
    localObjectAnimator1.setDuration(300L);
    localObjectAnimator1.setStartDelay(1000L);
    localObjectAnimator1.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(269012);
        if ((d.this.mContext instanceof SnsAdNativeLandingPagesUI))
        {
          boolean bool = ((SnsAdNativeLandingPagesUI)d.this.mContext).KMa;
          if ((!d.this.isFinishing) && (!bool))
          {
            if ((paramp instanceof s)) {
              ((s)paramp).Krl = false;
            }
            paramButton.setVisibility(0);
            if (!((SnsAdNativeLandingPagesUI)d.this.mContext).KLV) {
              d.this.Kpp.fKk();
            }
          }
        }
        AppMethodBeat.o(269012);
      }
    });
    localObjectAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(215244);
        if (!Util.isNullOrNil(paramr.Kmb))
        {
          paramAnonymousValueAnimator = paramButton.getCompoundDrawables()[0];
          if (paramAnonymousValueAnimator != null) {
            paramAnonymousValueAnimator.setColorFilter(com.tencent.mm.ci.a.w(d.this.context, i.c.white), PorterDuff.Mode.SRC_ATOP);
          }
        }
        AppMethodBeat.o(215244);
      }
    });
    paramp = ObjectAnimator.ofInt((GradientDrawable)paramButton.getBackground(), "color", new int[] { com.tencent.mm.ci.a.w(this.context, i.c.BW_0_Alpha_0_2), Color.parseColor(paramr.KlQ) });
    paramp.setEvaluator(new ArgbEvaluator());
    paramp.setDuration(500L);
    paramp.setStartDelay(1000L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofInt(paramButton, "textColor", new int[] { com.tencent.mm.ci.a.w(this.context, i.c.white), Color.parseColor(paramr.KlM) });
    localObjectAnimator2.setEvaluator(new ArgbEvaluator());
    localObjectAnimator2.setDuration(500L);
    localObjectAnimator2.setStartDelay(1000L);
    localObjectAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(197460);
        if (!Util.isNullOrNil(paramr.Kmb))
        {
          paramAnonymousValueAnimator = (Integer)paramAnonymousValueAnimator.getAnimatedValue();
          Drawable localDrawable = paramButton.getCompoundDrawables()[0];
          if (localDrawable != null) {
            localDrawable.setColorFilter(paramAnonymousValueAnimator.intValue(), PorterDuff.Mode.SRC_ATOP);
          }
        }
        AppMethodBeat.o(197460);
      }
    });
    AnimatorSet localAnimatorSet2 = new AnimatorSet();
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.mContentView, "alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { 0.0F, (this.pEj - paramInt1) / 2 - com.tencent.mm.ci.a.fromDPToPix(this.context, 28) });
    ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { com.tencent.mm.ci.a.fromDPToPix(this.context, 190), paramInt1 });
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { com.tencent.mm.ci.a.fromDPToPix(this.context, 40), paramInt2 });
    localValueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(219006);
        Button localButton;
        int i;
        try
        {
          paramAnonymousValueAnimator = (Integer)paramAnonymousValueAnimator.getAnimatedValue();
          Object localObject = paramView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).width = paramAnonymousValueAnimator.intValue();
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if (Util.isNullOrNil(paramr.Kmb)) {
            break label245;
          }
          localObject = d.this.context;
          localButton = paramButton;
          float f3 = paramAnonymousValueAnimator.intValue();
          paramAnonymousValueAnimator = paramr;
          if ((localButton == null) || (paramAnonymousValueAnimator == null))
          {
            Log.e("BtnIconUpdateHelper", "adjustFloatBarIconBtn, but btn or btnInfo is null");
            AppMethodBeat.o(219006);
            return;
          }
          float f2 = paramAnonymousValueAnimator.Kmc;
          float f1 = f2;
          if (f2 <= 0.0F) {
            f1 = com.tencent.mm.ci.a.fromDPToPix((Context)localObject, 20);
          }
          i = com.tencent.mm.ci.a.fromDPToPix((Context)localObject, 4);
          f2 = localButton.getPaint().measureText(localButton.getText().toString());
          float f4 = i;
          Log.i("BtnIconUpdateHelper", "btn width = ".concat(String.valueOf(f3)));
          i = (int)(f3 - (f1 + f4 + f2)) / 2;
          if (i < 0)
          {
            Log.d("BtnIconUpdateHelper", "updateBtnIcon but horizontalPadding < 0");
            AppMethodBeat.o(219006);
            return;
          }
        }
        catch (Throwable paramAnonymousValueAnimator)
        {
          Log.e("AdLandingFloatBarCompWrapper", paramAnonymousValueAnimator.toString());
          AppMethodBeat.o(219006);
          return;
        }
        Log.i("BtnIconUpdateHelper", "horizontalPadding = ".concat(String.valueOf(i)));
        localButton.setPadding(i, 0, i, 0);
        label245:
        AppMethodBeat.o(219006);
      }
    });
    localValueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(249638);
        paramAnonymousValueAnimator = (Integer)paramAnonymousValueAnimator.getAnimatedValue();
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        localLayoutParams.height = paramAnonymousValueAnimator.intValue();
        paramView.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(249638);
      }
    });
    localAnimatorSet2.play(localObjectAnimator3).with(localObjectAnimator4).with(localValueAnimator1).with(localValueAnimator2);
    localAnimatorSet2.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet2.setDuration(1000L);
    localAnimatorSet2.setStartDelay(1500L);
    localAnimatorSet2.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(256264);
        if (!d.this.isFinishing)
        {
          d.this.Kpo.removeView(paramView);
          paramView.setTranslationX(0.0F);
          paramAnonymousAnimator = new FrameLayout.LayoutParams(-1, -1);
          d.this.Kpm.addView(paramView, paramAnonymousAnimator);
          paramAnonymousAnimator = (LinearLayout.LayoutParams)d.this.Kpm.getLayoutParams();
          paramAnonymousAnimator.width = paramInt1;
          paramAnonymousAnimator.height = paramInt2;
          d.this.Kpm.setLayoutParams(paramAnonymousAnimator);
        }
        AppMethodBeat.o(256264);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(256263);
        if ((d.this.mContext instanceof SnsAdNativeLandingPagesUI))
        {
          boolean bool = ((SnsAdNativeLandingPagesUI)d.this.mContext).KMa;
          if ((!d.this.isFinishing) && (!bool))
          {
            d.this.mContentView.setVisibility(0);
            if (!((SnsAdNativeLandingPagesUI)d.this.mContext).KLV) {
              d.this.fKk();
            }
          }
        }
        AppMethodBeat.o(256263);
      }
    });
    localAnimatorSet1.play(paramp).with(localObjectAnimator2).after(localObjectAnimator1).before(localAnimatorSet2);
    localAnimatorSet1.start();
    AppMethodBeat.o(243384);
  }
  
  private void fQS()
  {
    AppMethodBeat.i(243383);
    if (!this.Kpr)
    {
      Log.i("AdLandingFloatBarCompWrapper", "this is an old floatBarViewWrapper, isAnimationFloatBar: " + this.Kpr);
      AppMethodBeat.o(243383);
      return;
    }
    Object localObject1 = null;
    if ((this.Kpp instanceof q)) {
      localObject1 = ((q)this.Kpp).KqS;
    }
    while (localObject1 == null)
    {
      Log.e("AdLandingFloatBarCompWrapper", "button is null");
      AppMethodBeat.o(243383);
      return;
      if ((this.Kpp instanceof s))
      {
        localObject1 = (s)this.Kpp;
        ((s)localObject1).Krl = true;
        localObject1 = ((s)localObject1).Kre;
      }
    }
    View localView = this.Kpp.getView();
    if (localView == null)
    {
      Log.e("AdLandingFloatBarCompWrapper", "btnView is null");
      AppMethodBeat.o(243383);
      return;
    }
    if (!(this.Kpi.Knc instanceof r))
    {
      Log.e("AdLandingFloatBarCompWrapper", "btnInfo is not instanceof AdLandingPageCompentBtnInfo");
      AppMethodBeat.o(243383);
      return;
    }
    r localr = (r)this.Kpi.Knc;
    if (localr == null)
    {
      Log.e("AdLandingFloatBarCompWrapper", "info is null");
      AppMethodBeat.o(243383);
      return;
    }
    try
    {
      int j = (int)localr.KmD;
      if ((int)localr.height == 0) {}
      float f;
      for (int i = (int)localr.KmE;; i = (int)f)
      {
        this.Kpm.removeView(localView);
        this.mContentView.setAlpha(0.0F);
        this.mContentView.setVisibility(8);
        Object localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setColor(com.tencent.mm.ci.a.w(this.context, i.c.BW_0_Alpha_0_2));
        if (localr.bDI > 0.0F) {
          ((GradientDrawable)localObject2).setCornerRadius(localr.bDI);
        }
        ((Button)localObject1).setBackground((Drawable)localObject2);
        ((Button)localObject1).setTextColor(com.tencent.mm.ci.a.w(this.context, i.c.white));
        localObject2 = new FrameLayout.LayoutParams(com.tencent.mm.ci.a.fromDPToPix(this.context, 190), com.tencent.mm.ci.a.fromDPToPix(this.context, 40));
        ((FrameLayout.LayoutParams)localObject2).gravity = 81;
        ((FrameLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 58);
        this.Kpo.addView(localView, (ViewGroup.LayoutParams)localObject2);
        ((Button)localObject1).setVisibility(8);
        ((Button)localObject1).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        a(this.Kpp, localView, (Button)localObject1, localr, ((FrameLayout.LayoutParams)localObject2).bottomMargin, j, i);
        AppMethodBeat.o(243383);
        return;
        f = localr.height;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdLandingFloatBarCompWrapper", localThrowable.toString());
      AppMethodBeat.o(243383);
    }
  }
  
  protected final void B(boolean paramBoolean)
  {
    AppMethodBeat.i(96429);
    if (this.mContentView.getVisibility() != 0)
    {
      this.mContentView.setVisibility(0);
      fKk();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.5F, 1, 0.0F);
        localTranslateAnimation.setInterpolator(new OvershootInterpolator(1.0F));
        localTranslateAnimation.setDuration(700L);
        this.mContentView.startAnimation(localTranslateAnimation);
      }
    }
    AppMethodBeat.o(96429);
  }
  
  protected final void C(boolean paramBoolean)
  {
    AppMethodBeat.i(96431);
    if (this.mContentView.getVisibility() == 0)
    {
      this.mContentView.setVisibility(8);
      fKl();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.5F);
        localTranslateAnimation.setDuration(400L);
        this.mContentView.startAnimation(localTranslateAnimation);
      }
    }
    AppMethodBeat.o(96431);
  }
  
  public final void QT(long paramLong)
  {
    AppMethodBeat.i(96428);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(1, Boolean.TRUE);
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
    AppMethodBeat.o(96428);
  }
  
  public final boolean by(JSONObject paramJSONObject)
  {
    boolean bool = true;
    AppMethodBeat.i(96436);
    if (this.Kpi == null)
    {
      paramJSONObject = new StringBuilder("kvReport, mFloatBarInfo==null?");
      if (this.Kpi == null) {}
      for (;;)
      {
        Log.e("AdLandingFloatBarCompWrapper", bool);
        AppMethodBeat.o(96436);
        return false;
        bool = false;
      }
    }
    if (!super.by(paramJSONObject))
    {
      AppMethodBeat.o(96436);
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      Log.i("AdLandingFloatBarCompWrapper", "kv=" + paramJSONObject.toString());
      AppMethodBeat.o(96436);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      Log.printErrStackTrace("AdLandingFloatBarCompWrapper", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96436);
    }
    return false;
  }
  
  /* Error */
  protected final void fKe()
  {
    // Byte code:
    //   0: ldc_w 499
    //   3: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   10: getfield 502	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:iconUrl	Ljava/lang/String;
    //   13: invokestatic 508	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifne +289 -> 305
    //   19: aload_0
    //   20: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   23: getfield 502	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:iconUrl	Ljava/lang/String;
    //   26: astore_1
    //   27: ldc_w 510
    //   30: aload_1
    //   31: new 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$1
    //   34: dup
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 513	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$1:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;Ljava/lang/String;)V
    //   40: invokestatic 518	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/h:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f$a;)V
    //   43: aload_0
    //   44: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   47: getfield 521	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:title	Ljava/lang/String;
    //   50: invokestatic 508	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifne +264 -> 317
    //   56: aload_0
    //   57: getfield 523	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpk	Landroid/widget/TextView;
    //   60: aload_0
    //   61: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   64: getfield 521	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:title	Ljava/lang/String;
    //   67: invokevirtual 529	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   70: aload_0
    //   71: getfield 523	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpk	Landroid/widget/TextView;
    //   74: iconst_0
    //   75: invokevirtual 530	android/widget/TextView:setVisibility	(I)V
    //   78: aload_0
    //   79: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   82: getfield 533	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:desc	Ljava/lang/String;
    //   85: invokestatic 508	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +241 -> 329
    //   91: aload_0
    //   92: getfield 535	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpl	Landroid/widget/TextView;
    //   95: aload_0
    //   96: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   99: getfield 533	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:desc	Ljava/lang/String;
    //   102: invokevirtual 529	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   105: aload_0
    //   106: getfield 535	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpl	Landroid/widget/TextView;
    //   109: iconst_0
    //   110: invokevirtual 530	android/widget/TextView:setVisibility	(I)V
    //   113: aload_0
    //   114: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   117: getfield 538	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:nWx	Ljava/lang/String;
    //   120: invokestatic 508	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne +263 -> 386
    //   126: aload_0
    //   127: getfield 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContentView	Landroid/view/View;
    //   130: aload_0
    //   131: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   134: getfield 538	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:nWx	Ljava/lang/String;
    //   137: invokestatic 222	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   140: invokevirtual 541	android/view/View:setBackgroundColor	(I)V
    //   143: aload_0
    //   144: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   147: getfield 544	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:lnt	Ljava/lang/String;
    //   150: invokestatic 508	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   153: ifne +20 -> 173
    //   156: aload_0
    //   157: getfield 523	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpk	Landroid/widget/TextView;
    //   160: aload_0
    //   161: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   164: getfield 544	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:lnt	Ljava/lang/String;
    //   167: invokestatic 222	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   170: invokevirtual 545	android/widget/TextView:setTextColor	(I)V
    //   173: aload_0
    //   174: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   177: getfield 548	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:KmX	Ljava/lang/String;
    //   180: invokestatic 508	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   183: ifne +20 -> 203
    //   186: aload_0
    //   187: getfield 535	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpl	Landroid/widget/TextView;
    //   190: aload_0
    //   191: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   194: getfield 548	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:KmX	Ljava/lang/String;
    //   197: invokestatic 222	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   200: invokevirtual 545	android/widget/TextView:setTextColor	(I)V
    //   203: aload_0
    //   204: getfield 354	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpm	Landroid/widget/FrameLayout;
    //   207: invokevirtual 551	android/widget/FrameLayout:removeAllViews	()V
    //   210: aload_0
    //   211: getfield 80	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContext	Landroid/content/Context;
    //   214: aload_0
    //   215: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   218: getfield 338	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:Knc	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   221: aload_0
    //   222: getfield 354	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpm	Landroid/widget/FrameLayout;
    //   225: iconst_0
    //   226: invokestatic 556	com/tencent/mm/plugin/sns/ui/ba:a	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;Landroid/view/ViewGroup;I)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/m;
    //   229: astore_1
    //   230: aload_1
    //   231: instanceof 328
    //   234: ifeq +279 -> 513
    //   237: aload_0
    //   238: aload_1
    //   239: checkcast 328	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/p
    //   242: putfield 307	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpp	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/p;
    //   245: aload_0
    //   246: getfield 307	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpp	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/p;
    //   249: ifnull +19 -> 268
    //   252: aload_0
    //   253: getfield 307	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpp	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/p;
    //   256: invokevirtual 332	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/p:getView	()Landroid/view/View;
    //   259: astore_1
    //   260: aload_0
    //   261: getfield 354	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpm	Landroid/widget/FrameLayout;
    //   264: aload_1
    //   265: invokevirtual 558	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   268: aload_0
    //   269: aload_0
    //   270: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   273: getfield 561	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:KmY	Z
    //   276: putfield 65	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpq	Z
    //   279: aload_0
    //   280: getfield 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:mContentView	Landroid/view/View;
    //   283: new 14	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$4
    //   286: dup
    //   287: aload_0
    //   288: invokespecial 564	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$4:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;)V
    //   291: invokevirtual 568	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   294: aload_0
    //   295: invokespecial 570	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:fQS	()V
    //   298: ldc_w 499
    //   301: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: return
    //   305: aload_0
    //   306: getfield 572	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpn	Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;
    //   309: bipush 8
    //   311: invokevirtual 575	com/tencent/mm/ui/widget/RoundedCornerFrameLayout:setVisibility	(I)V
    //   314: goto -271 -> 43
    //   317: aload_0
    //   318: getfield 523	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpk	Landroid/widget/TextView;
    //   321: bipush 8
    //   323: invokevirtual 530	android/widget/TextView:setVisibility	(I)V
    //   326: goto -248 -> 78
    //   329: aload_0
    //   330: getfield 535	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpl	Landroid/widget/TextView;
    //   333: bipush 8
    //   335: invokevirtual 530	android/widget/TextView:setVisibility	(I)V
    //   338: goto -225 -> 113
    //   341: astore_1
    //   342: ldc 100
    //   344: new 102	java/lang/StringBuilder
    //   347: dup
    //   348: ldc_w 577
    //   351: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: aload_1
    //   355: invokevirtual 578	java/lang/Exception:toString	()Ljava/lang/String;
    //   358: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc_w 580
    //   364: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_0
    //   368: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   371: getfield 538	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:nWx	Ljava/lang/String;
    //   374: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: goto -240 -> 143
    //   386: aload_0
    //   387: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   390: getfield 583	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:KmW	Ljava/lang/String;
    //   393: invokestatic 508	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   396: ifne -253 -> 143
    //   399: ldc_w 510
    //   402: aload_0
    //   403: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   406: getfield 583	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:KmW	Ljava/lang/String;
    //   409: new 12	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$3
    //   412: dup
    //   413: aload_0
    //   414: invokespecial 584	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d$3:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d;)V
    //   417: invokestatic 518	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/h:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f$a;)V
    //   420: goto -277 -> 143
    //   423: astore_1
    //   424: ldc 100
    //   426: new 102	java/lang/StringBuilder
    //   429: dup
    //   430: ldc_w 586
    //   433: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   436: aload_1
    //   437: invokevirtual 578	java/lang/Exception:toString	()Ljava/lang/String;
    //   440: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: ldc_w 580
    //   446: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_0
    //   450: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   453: getfield 544	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:lnt	Ljava/lang/String;
    //   456: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: goto -292 -> 173
    //   468: astore_1
    //   469: ldc 100
    //   471: new 102	java/lang/StringBuilder
    //   474: dup
    //   475: ldc_w 588
    //   478: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   481: aload_1
    //   482: invokevirtual 578	java/lang/Exception:toString	()Ljava/lang/String;
    //   485: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: ldc_w 580
    //   491: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_0
    //   495: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/d:Kpi	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
    //   498: getfield 548	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae:KmX	Ljava/lang/String;
    //   501: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: goto -307 -> 203
    //   513: ldc 100
    //   515: ldc_w 590
    //   518: aload_1
    //   519: invokestatic 596	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   522: invokevirtual 600	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   525: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: goto -283 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	this	d
    //   26	239	1	localObject	Object
    //   341	14	1	localException1	Exception
    //   423	14	1	localException2	Exception
    //   468	51	1	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   126	143	341	java/lang/Exception
    //   156	173	423	java/lang/Exception
    //   186	203	468	java/lang/Exception
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(96433);
    super.fKk();
    if (this.Kpp != null) {
      this.Kpp.fKk();
    }
    Log.i("AdLandingFloatBarCompWrapper", "viewWillAppear");
    if (((this.Kpp instanceof u)) && (!((u)this.Kpp).KqS.isEnabled())) {
      this.Kpq = false;
    }
    AppMethodBeat.o(96433);
  }
  
  public final void fKl()
  {
    AppMethodBeat.i(96434);
    super.fKl();
    if (this.Kpp != null) {
      this.Kpp.fKl();
    }
    Log.i("AdLandingFloatBarCompWrapper", "viewWillDisappear, exposureCount=" + fRl() + ", stayTime=" + fRk());
    AppMethodBeat.o(96434);
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(96435);
    super.fKo();
    if (this.Kpp != null) {
      this.Kpp.fKo();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(96435);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(96426);
    Object localObject = LayoutInflater.from(this.mContext).inflate(i.g.sns_ad_native_landing_pages_item_floatbar, this.Kpo, false);
    this.mContentView = ((View)localObject);
    this.Kpj = ((ImageView)((View)localObject).findViewById(i.f.float_icon));
    this.Kpk = ((TextView)((View)localObject).findViewById(i.f.float_title_txt));
    this.Kpl = ((TextView)((View)localObject).findViewById(i.f.float_desc_txt));
    this.Kpm = ((FrameLayout)((View)localObject).findViewById(i.f.float_btn_container));
    ((RoundedCornerFrameLayout)((View)localObject).findViewById(i.f.float_bar_corner_container)).setRadius(com.tencent.mm.ci.a.fromDPToPix(this.mContext, 8));
    this.Kpn = ((RoundedCornerFrameLayout)((View)localObject).findViewById(i.f.float_bar_icon_container));
    this.Kpn.setRadius(com.tencent.mm.ci.a.fromDPToPix(this.mContext, 4));
    this.Kpo.addView(this.mContentView);
    if (this.Kpr)
    {
      localObject = this.mContentView.getLayoutParams();
      if ((localObject instanceof FrameLayout.LayoutParams))
      {
        localObject = (FrameLayout.LayoutParams)localObject;
        ((FrameLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 42);
        this.mContentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    this.mContentView.setVisibility(8);
    AppMethodBeat.o(96426);
  }
  
  public final void fQN()
  {
    AppMethodBeat.i(243378);
    Button localButton;
    if (this.Kpr)
    {
      this.isFinishing = true;
      localButton = null;
      if (!(this.Kpp instanceof q)) {
        break label126;
      }
      localButton = ((q)this.Kpp).KqS;
    }
    for (;;)
    {
      if ((localButton != null) && (this.Kpp.getView() != null))
      {
        localButton.clearAnimation();
        this.Kpp.getView().clearAnimation();
        if (localButton.getVisibility() == 0)
        {
          localButton.setVisibility(8);
          this.Kpp.fKl();
        }
      }
      if (this.mContentView.getVisibility() == 0)
      {
        this.mContentView.clearAnimation();
        this.mContentView.setVisibility(8);
        fKl();
      }
      AppMethodBeat.o(243378);
      return;
      label126:
      if ((this.Kpp instanceof s)) {
        localButton = ((s)this.Kpp).Kre;
      }
    }
  }
  
  public final void fQO()
  {
    AppMethodBeat.i(243379);
    Button localButton = null;
    try
    {
      if ((this.Kpp instanceof q)) {
        localButton = ((q)this.Kpp).KqS;
      }
      for (;;)
      {
        if (localButton != null) {
          localButton.setVisibility(8);
        }
        if (this.mContentView != null) {
          this.mContentView.setVisibility(8);
        }
        fKl();
        AppMethodBeat.o(243379);
        return;
        if ((this.Kpp instanceof s)) {
          localButton = ((s)this.Kpp).Kre;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdLandingFloatBarCompWrapper", localThrowable.toString());
      AppMethodBeat.o(243379);
    }
  }
  
  public final void fQP()
  {
    AppMethodBeat.i(243380);
    Button localButton = null;
    try
    {
      if ((this.Kpp instanceof q)) {
        localButton = ((q)this.Kpp).KqS;
      }
      for (;;)
      {
        if (localButton != null) {
          localButton.setVisibility(0);
        }
        if (this.mContentView != null) {
          this.mContentView.setVisibility(0);
        }
        if (!((SnsAdNativeLandingPagesUI)this.mContext).KLV) {
          fKk();
        }
        AppMethodBeat.o(243380);
        return;
        if ((this.Kpp instanceof s)) {
          localButton = ((s)this.Kpp).Kre;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdLandingFloatBarCompWrapper", localThrowable.toString());
      AppMethodBeat.o(243380);
    }
  }
  
  public final void fQQ()
  {
    AppMethodBeat.i(96437);
    if (this.Kpp != null)
    {
      this.Kpp.clickCount -= this.clickCount;
      Log.i("AdLandingFloatBarCompWrapper", "btn kv, clickCount=" + this.Kpp.clickCount + ", stayTime=" + this.Kpp.fRk());
    }
    AppMethodBeat.o(96437);
  }
  
  public final p fQR()
  {
    return this.Kpp;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(96432);
    if (this.Kpr)
    {
      Button localButton = null;
      if ((this.Kpp instanceof q)) {
        localButton = ((q)this.Kpp).KqS;
      }
      while (((localButton != null) && (localButton.getVisibility() == 0)) || (this.mContentView.getVisibility() == 0))
      {
        AppMethodBeat.o(96432);
        return true;
        if ((this.Kpp instanceof s)) {
          localButton = ((s)this.Kpp).Kre;
        }
      }
      AppMethodBeat.o(96432);
      return false;
    }
    if (this.mContentView.getVisibility() == 0)
    {
      AppMethodBeat.o(96432);
      return true;
    }
    AppMethodBeat.o(96432);
    return false;
  }
  
  public final void m(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(96430);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(2, Boolean.valueOf(paramBoolean));
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
    AppMethodBeat.o(96430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d
 * JD-Core Version:    0.7.0.1
 */