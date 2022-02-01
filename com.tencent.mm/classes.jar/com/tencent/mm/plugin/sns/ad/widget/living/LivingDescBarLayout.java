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
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.sdk.platformtools.Log;

public class LivingDescBarLayout
  extends RelativeLayout
{
  a JMm;
  
  public LivingDescBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LivingDescBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void fMd()
  {
    AppMethodBeat.i(201103);
    a locala = this.JMm;
    if (locala != null) {
      locala.stop();
    }
    AppMethodBeat.o(201103);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(201104);
    super.onAttachedToWindow();
    Log.w("SnsAd.LivingDescBarLayout", "onAttachedToWindow is called!!");
    AppMethodBeat.o(201104);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(201107);
    super.onDetachedFromWindow();
    a locala = this.JMm;
    if (locala != null) {
      locala.a(null);
    }
    AppMethodBeat.o(201107);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(201097);
    super.onFinishInflate();
    try
    {
      ((ImageView)findViewById(i.f.ad_live_desc_image)).setImageResource(i.i.ad_living_description_icon);
      this.JMm = new a((TextView)findViewById(i.f.ad_live_desc_content1), (TextView)findViewById(i.f.ad_live_desc_content2));
      AppMethodBeat.o(201097);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(201097);
    }
  }
  
  public void setSlideAdapter(b paramb)
  {
    AppMethodBeat.i(201100);
    a locala = this.JMm;
    if (locala != null) {
      locala.a(paramb);
    }
    AppMethodBeat.o(201100);
  }
  
  static final class a
    implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, Handler.Callback
  {
    private TextView JMn;
    private TextView JMo;
    Handler JMp;
    LivingDescBarLayout.b JMq;
    private int JMr;
    float JMs;
    ValueAnimator aiD;
    int mState;
    
    public a(TextView paramTextView1, TextView paramTextView2)
    {
      AppMethodBeat.i(265149);
      this.JMr = 0;
      this.JMs = 0.0F;
      this.mState = 1;
      this.JMp = new Handler(Looper.getMainLooper(), this);
      this.JMn = paramTextView1;
      this.JMo = paramTextView2;
      AppMethodBeat.o(265149);
    }
    
    private boolean fMe()
    {
      return (this.JMo != null) && (this.JMn != null);
    }
    
    private static void gk(View paramView)
    {
      AppMethodBeat.i(265165);
      if (paramView != null)
      {
        paramView.setVisibility(4);
        paramView.setTranslationY(0.0F);
        paramView.setAlpha(1.0F);
      }
      AppMethodBeat.o(265165);
    }
    
    public final void a(LivingDescBarLayout.b paramb)
    {
      AppMethodBeat.i(265152);
      try
      {
        stop();
        if ((paramb != null) && (paramb.getCount() > 0) && (fMe()))
        {
          this.JMr = 0;
          String str = paramb.afk(this.JMr);
          this.JMn.setVisibility(0);
          this.JMn.setText(str);
          if (paramb.getCount() > 1) {
            this.JMp.sendEmptyMessageDelayed(1, 2000L);
          }
        }
        this.JMq = paramb;
        AppMethodBeat.o(265152);
        return;
      }
      catch (Throwable paramb)
      {
        AppMethodBeat.o(265152);
      }
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(265164);
      try
      {
        int i = paramMessage.what;
        if (i != 1) {}
      }
      catch (Throwable paramMessage)
      {
        label93:
        AppMethodBeat.o(265164);
        return false;
      }
      try
      {
        if (this.aiD == null)
        {
          this.aiD = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
          this.aiD.addUpdateListener(this);
          this.aiD.addListener(this);
        }
        if (fMe())
        {
          this.JMs = this.JMn.getHeight();
          this.aiD.start();
          this.mState = 0;
        }
      }
      catch (Throwable paramMessage)
      {
        break label93;
      }
      AppMethodBeat.o(265164);
      return true;
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(265162);
      try
      {
        Log.d("SlideController", "onAnimationCancel is called ");
        gk(this.JMo);
        gk(this.JMn);
        AppMethodBeat.o(265162);
        return;
      }
      catch (Throwable paramAnimator)
      {
        AppMethodBeat.o(265162);
      }
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(265160);
      Log.d("SlideController", "onAnimationEnd is called ");
      try
      {
        paramAnimator = this.JMq;
        if ((paramAnimator == null) || (paramAnimator.getCount() <= 0) || (!fMe()))
        {
          Log.d("SlideController", "onAnimationEnd return because of count is 0");
          AppMethodBeat.o(265160);
          return;
        }
        TextView localTextView = this.JMo;
        this.JMo = this.JMn;
        this.JMn = localTextView;
        gk(this.JMo);
        this.JMr = ((this.JMr + 1) % paramAnimator.getCount());
        this.JMs = 0.0F;
        if (this.mState == 0) {
          this.JMp.sendEmptyMessageDelayed(1, 2000L);
        }
        this.aiD = null;
        AppMethodBeat.o(265160);
        return;
      }
      catch (Throwable paramAnimator)
      {
        AppMethodBeat.o(265160);
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(265157);
      Log.d("SlideController", "onAnimationStart is called ");
      try
      {
        paramAnimator = this.JMq;
        if ((paramAnimator == null) || (paramAnimator.getCount() <= 0) || (!fMe()))
        {
          Log.d("SlideController", "onAnimationStart return because of count is 0 ");
          AppMethodBeat.o(265157);
          return;
        }
        this.JMo.setTranslationY(this.JMs);
        this.JMo.setAlpha(0.0F);
        this.JMo.setVisibility(0);
        int i = this.JMr;
        int j = paramAnimator.getCount();
        this.JMo.setText(paramAnimator.afk((i + 1) % j));
        AppMethodBeat.o(265157);
        return;
      }
      catch (Throwable paramAnimator)
      {
        AppMethodBeat.o(265157);
      }
    }
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(265163);
      try
      {
        paramValueAnimator = paramValueAnimator.getAnimatedValue();
        if ((paramValueAnimator instanceof Float))
        {
          float f1 = ((Float)paramValueAnimator).floatValue();
          if (fMe())
          {
            float f2 = this.JMs * f1;
            this.JMo.setTranslationY(this.JMs - f2);
            this.JMo.setAlpha(f1);
            this.JMn.setTranslationY(-f2);
            this.JMn.setAlpha(1.0F - f1);
          }
        }
        AppMethodBeat.o(265163);
        return;
      }
      catch (Throwable paramValueAnimator)
      {
        AppMethodBeat.o(265163);
      }
    }
    
    public final void stop()
    {
      AppMethodBeat.i(265154);
      try
      {
        this.mState = 1;
        this.JMp.removeMessages(1);
        if ((this.aiD != null) && (this.aiD.isRunning())) {
          this.aiD.cancel();
        }
        AppMethodBeat.o(265154);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(265154);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract String afk(int paramInt);
    
    public abstract int getCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.LivingDescBarLayout
 * JD-Core Version:    0.7.0.1
 */