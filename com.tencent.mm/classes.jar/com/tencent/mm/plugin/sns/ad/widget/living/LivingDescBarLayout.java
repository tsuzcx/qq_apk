package com.tencent.mm.plugin.sns.ad.widget.living;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class LivingDescBarLayout
  extends RelativeLayout
{
  a DAz;
  
  public LivingDescBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LivingDescBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void eYt()
  {
    AppMethodBeat.i(202419);
    a locala = this.DAz;
    if (locala != null) {
      locala.stop();
    }
    AppMethodBeat.o(202419);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(202420);
    super.onAttachedToWindow();
    Log.w("SnsAd.LivingDescBarLayout", "onAttachedToWindow is called!!");
    AppMethodBeat.o(202420);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(202421);
    super.onDetachedFromWindow();
    a locala = this.DAz;
    if (locala != null) {
      locala.a(null);
    }
    AppMethodBeat.o(202421);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(202417);
    super.onFinishInflate();
    try
    {
      ((ImageView)findViewById(2131296498)).setImageResource(2131689519);
      this.DAz = new a((TextView)findViewById(2131296495), (TextView)findViewById(2131296496));
      AppMethodBeat.o(202417);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202417);
    }
  }
  
  public void setSlideAdapter(b paramb)
  {
    AppMethodBeat.i(202418);
    a locala = this.DAz;
    if (locala != null) {
      locala.a(paramb);
    }
    AppMethodBeat.o(202418);
  }
  
  static final class a
    implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, Handler.Callback
  {
    private TextView DAA;
    private TextView DAB;
    Handler DAC;
    LivingDescBarLayout.b DAD;
    private int DAE;
    float DAF;
    ValueAnimator aAO;
    int mState;
    
    public a(TextView paramTextView1, TextView paramTextView2)
    {
      AppMethodBeat.i(202408);
      this.DAE = 0;
      this.DAF = 0.0F;
      this.mState = 1;
      this.DAC = new Handler(Looper.getMainLooper(), this);
      this.DAA = paramTextView1;
      this.DAB = paramTextView2;
      AppMethodBeat.o(202408);
    }
    
    private boolean eYu()
    {
      return (this.DAB != null) && (this.DAA != null);
    }
    
    private static void fd(View paramView)
    {
      AppMethodBeat.i(202416);
      if (paramView != null)
      {
        paramView.setVisibility(4);
        paramView.setTranslationY(0.0F);
        paramView.setAlpha(1.0F);
      }
      AppMethodBeat.o(202416);
    }
    
    public final void a(LivingDescBarLayout.b paramb)
    {
      AppMethodBeat.i(202409);
      try
      {
        stop();
        if ((paramb != null) && (paramb.getCount() > 0) && (eYu()))
        {
          this.DAE = 0;
          String str = paramb.XW(this.DAE);
          this.DAA.setVisibility(0);
          this.DAA.setText(str);
          if (paramb.getCount() > 1) {
            this.DAC.sendEmptyMessageDelayed(1, 2000L);
          }
        }
        this.DAD = paramb;
        AppMethodBeat.o(202409);
        return;
      }
      catch (Throwable paramb)
      {
        AppMethodBeat.o(202409);
      }
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(202415);
      try
      {
        int i = paramMessage.what;
        if (i != 1) {}
      }
      catch (Throwable paramMessage)
      {
        label93:
        AppMethodBeat.o(202415);
        return false;
      }
      try
      {
        if (this.aAO == null)
        {
          this.aAO = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
          this.aAO.addUpdateListener(this);
          this.aAO.addListener(this);
        }
        if (eYu())
        {
          this.DAF = this.DAA.getHeight();
          this.aAO.start();
          this.mState = 0;
        }
      }
      catch (Throwable paramMessage)
      {
        break label93;
      }
      AppMethodBeat.o(202415);
      return true;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(202413);
      try
      {
        Log.d("SlideController", "onAnimationCancel is called ");
        fd(this.DAB);
        fd(this.DAA);
        AppMethodBeat.o(202413);
        return;
      }
      catch (Throwable paramAnimator)
      {
        AppMethodBeat.o(202413);
      }
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(202412);
      Log.d("SlideController", "onAnimationEnd is called ");
      try
      {
        paramAnimator = this.DAD;
        if ((paramAnimator == null) || (paramAnimator.getCount() <= 0) || (!eYu()))
        {
          Log.d("SlideController", "onAnimationEnd return because of count is 0");
          AppMethodBeat.o(202412);
          return;
        }
        TextView localTextView = this.DAB;
        this.DAB = this.DAA;
        this.DAA = localTextView;
        fd(this.DAB);
        this.DAE = ((this.DAE + 1) % paramAnimator.getCount());
        this.DAF = 0.0F;
        if (this.mState == 0) {
          this.DAC.sendEmptyMessageDelayed(1, 2000L);
        }
        this.aAO = null;
        AppMethodBeat.o(202412);
        return;
      }
      catch (Throwable paramAnimator)
      {
        AppMethodBeat.o(202412);
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(202411);
      Log.d("SlideController", "onAnimationStart is called ");
      try
      {
        paramAnimator = this.DAD;
        if ((paramAnimator == null) || (paramAnimator.getCount() <= 0) || (!eYu()))
        {
          Log.d("SlideController", "onAnimationStart return because of count is 0 ");
          AppMethodBeat.o(202411);
          return;
        }
        this.DAB.setTranslationY(this.DAF);
        this.DAB.setAlpha(0.0F);
        this.DAB.setVisibility(0);
        int i = this.DAE;
        int j = paramAnimator.getCount();
        this.DAB.setText(paramAnimator.XW((i + 1) % j));
        AppMethodBeat.o(202411);
        return;
      }
      catch (Throwable paramAnimator)
      {
        AppMethodBeat.o(202411);
      }
    }
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(202414);
      try
      {
        paramValueAnimator = paramValueAnimator.getAnimatedValue();
        if ((paramValueAnimator instanceof Float))
        {
          float f1 = ((Float)paramValueAnimator).floatValue();
          if (eYu())
          {
            float f2 = this.DAF * f1;
            this.DAB.setTranslationY(this.DAF - f2);
            this.DAB.setAlpha(f1);
            this.DAA.setTranslationY(-f2);
            this.DAA.setAlpha(1.0F - f1);
          }
        }
        AppMethodBeat.o(202414);
        return;
      }
      catch (Throwable paramValueAnimator)
      {
        AppMethodBeat.o(202414);
      }
    }
    
    public final void stop()
    {
      AppMethodBeat.i(202410);
      try
      {
        this.mState = 1;
        this.DAC.removeMessages(1);
        if ((this.aAO != null) && (this.aAO.isRunning())) {
          this.aAO.cancel();
        }
        AppMethodBeat.o(202410);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(202410);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract String XW(int paramInt);
    
    public abstract int getCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.LivingDescBarLayout
 * JD-Core Version:    0.7.0.1
 */