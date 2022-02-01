package com.tencent.mm.plugin.sns.ad.widget.living;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.sdk.platformtools.Log;

public class LivingDescBarLayout
  extends RelativeLayout
{
  private a QgQ;
  private ImageView uPE;
  
  public LivingDescBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LivingDescBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void hcW()
  {
    AppMethodBeat.i(310378);
    if (this.uPE != null) {
      this.uPE.setImageResource(b.i.ad_living_description_icon);
    }
    AppMethodBeat.o(310378);
  }
  
  public final boolean hcX()
  {
    AppMethodBeat.i(310384);
    a locala = this.QgQ;
    if (locala != null)
    {
      boolean bool = locala.hcX();
      AppMethodBeat.o(310384);
      return bool;
    }
    AppMethodBeat.o(310384);
    return false;
  }
  
  public final void hcY()
  {
    AppMethodBeat.i(310397);
    a locala = this.QgQ;
    if (locala != null) {
      locala.hcY();
    }
    AppMethodBeat.o(310397);
  }
  
  public final void hcZ()
  {
    AppMethodBeat.i(310407);
    a locala = this.QgQ;
    if (locala != null) {
      locala.stop();
    }
    AppMethodBeat.o(310407);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(310417);
    super.onAttachedToWindow();
    Log.w("SnsAd.LivingDescBarLayout", "onAttachedToWindow is called!!");
    AppMethodBeat.o(310417);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(310425);
    super.onDetachedFromWindow();
    a locala = this.QgQ;
    if (locala != null) {
      locala.a(null);
    }
    AppMethodBeat.o(310425);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(310361);
    super.onFinishInflate();
    try
    {
      this.uPE = ((ImageView)findViewById(b.f.ad_live_desc_image));
      this.uPE.setImageResource(b.i.ad_living_description_icon);
      this.QgQ = new a((TextView)findViewById(b.f.ad_live_desc_content1), (TextView)findViewById(b.f.ad_live_desc_content2));
      return;
    }
    finally
    {
      AppMethodBeat.o(310361);
    }
  }
  
  public void setIconImage(Drawable paramDrawable)
  {
    AppMethodBeat.i(310372);
    if ((this.uPE != null) && (paramDrawable != null)) {
      this.uPE.setImageDrawable(paramDrawable);
    }
    AppMethodBeat.o(310372);
  }
  
  public void setSlideAdapter(b paramb)
  {
    AppMethodBeat.i(310391);
    a locala = this.QgQ;
    if (locala != null) {
      locala.a(paramb);
    }
    AppMethodBeat.o(310391);
  }
  
  static final class a
    implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, Handler.Callback
  {
    Handler PRJ;
    private TextView QgR;
    private TextView QgS;
    LivingDescBarLayout.b QgT;
    private int QgU;
    float QgV;
    ValueAnimator bXi;
    int mState;
    
    public a(TextView paramTextView1, TextView paramTextView2)
    {
      AppMethodBeat.i(310401);
      this.QgU = 0;
      this.QgV = 0.0F;
      this.mState = 1;
      this.PRJ = new Handler(Looper.getMainLooper(), this);
      this.QgR = paramTextView1;
      this.QgS = paramTextView2;
      AppMethodBeat.o(310401);
    }
    
    private boolean hda()
    {
      return (this.QgS != null) && (this.QgR != null);
    }
    
    private static void jo(View paramView)
    {
      AppMethodBeat.i(310419);
      if (paramView != null)
      {
        paramView.setVisibility(4);
        paramView.setTranslationY(0.0F);
        paramView.setAlpha(1.0F);
      }
      AppMethodBeat.o(310419);
    }
    
    public final void a(LivingDescBarLayout.b paramb)
    {
      AppMethodBeat.i(310461);
      try
      {
        stop();
        if ((paramb != null) && (paramb.getCount() > 0) && (hda()))
        {
          this.QgU = 0;
          String str = paramb.ajB(this.QgU);
          this.QgR.setVisibility(0);
          this.QgR.setText(str);
          if (paramb.getCount() > 1) {
            this.PRJ.sendEmptyMessageDelayed(1, 2000L);
          }
        }
        this.QgT = paramb;
        return;
      }
      finally
      {
        AppMethodBeat.o(310461);
      }
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(310558);
      try
      {
        int i = paramMessage.what;
        if (i != 1) {}
      }
      finally
      {
        label93:
        AppMethodBeat.o(310558);
        return false;
      }
      try
      {
        if (this.bXi == null)
        {
          this.bXi = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
          this.bXi.addUpdateListener(this);
          this.bXi.addListener(this);
        }
        if (hda())
        {
          this.QgV = this.QgR.getHeight();
          this.bXi.start();
          this.mState = 0;
        }
      }
      finally
      {
        break label93;
      }
      AppMethodBeat.o(310558);
      return true;
    }
    
    final boolean hcX()
    {
      AppMethodBeat.i(310444);
      if ((this.QgT == null) || (this.QgT.getCount() <= 0))
      {
        AppMethodBeat.o(310444);
        return true;
      }
      AppMethodBeat.o(310444);
      return false;
    }
    
    public final void hcY()
    {
      AppMethodBeat.i(310480);
      try
      {
        if ((this.QgT != null) && (this.QgT.getCount() > 0) && (hda()))
        {
          Log.i("SlideController", "notifyCurrentDataChange, mCurrentVisibleView pre text is " + this.QgR.getText() + ", mToVisibleView pre text is " + this.QgS.getText());
          String str1 = this.QgT.ajB(this.QgU);
          this.QgR.setText(str1);
          int i = this.QgU;
          int j = this.QgT.getCount();
          String str2 = this.QgT.ajB((i + 1) % j);
          this.QgS.setText(str2);
          Log.i("SlideController", "notifyCurrentDataChange, mCurrentVisibleView: " + str1 + ", mToVisibleView: " + str2);
        }
        AppMethodBeat.o(310480);
        return;
      }
      finally
      {
        Log.e("SlideController", localObject.toString());
        AppMethodBeat.o(310480);
      }
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(310517);
      try
      {
        Log.d("SlideController", "onAnimationCancel is called ");
        jo(this.QgS);
        jo(this.QgR);
        return;
      }
      finally
      {
        AppMethodBeat.o(310517);
      }
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(310509);
      Log.d("SlideController", "onAnimationEnd is called ");
      try
      {
        paramAnimator = this.QgT;
        if ((paramAnimator == null) || (paramAnimator.getCount() <= 0) || (!hda()))
        {
          Log.d("SlideController", "onAnimationEnd return because of count is 0");
          return;
        }
        TextView localTextView = this.QgS;
        this.QgS = this.QgR;
        this.QgR = localTextView;
        jo(this.QgS);
        this.QgU = ((this.QgU + 1) % paramAnimator.getCount());
        this.QgV = 0.0F;
        if (this.mState == 0) {
          this.PRJ.sendEmptyMessageDelayed(1, 2000L);
        }
        this.bXi = null;
        return;
      }
      finally
      {
        AppMethodBeat.o(310509);
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(310497);
      Log.d("SlideController", "onAnimationStart is called ");
      try
      {
        paramAnimator = this.QgT;
        if ((paramAnimator == null) || (paramAnimator.getCount() <= 0) || (!hda()))
        {
          Log.d("SlideController", "onAnimationStart return because of count is 0 ");
          return;
        }
        this.QgS.setTranslationY(this.QgV);
        this.QgS.setAlpha(0.0F);
        this.QgS.setVisibility(0);
        int i = this.QgU;
        int j = paramAnimator.getCount();
        this.QgS.setText(paramAnimator.ajB((i + 1) % j));
        return;
      }
      finally
      {
        AppMethodBeat.o(310497);
      }
    }
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(310542);
      try
      {
        paramValueAnimator = paramValueAnimator.getAnimatedValue();
        if ((paramValueAnimator instanceof Float))
        {
          float f1 = ((Float)paramValueAnimator).floatValue();
          if (hda())
          {
            float f2 = this.QgV * f1;
            this.QgS.setTranslationY(this.QgV - f2);
            this.QgS.setAlpha(f1);
            this.QgR.setTranslationY(-f2);
            this.QgR.setAlpha(1.0F - f1);
          }
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(310542);
      }
    }
    
    public final void stop()
    {
      AppMethodBeat.i(310489);
      try
      {
        this.mState = 1;
        this.PRJ.removeMessages(1);
        if ((this.bXi != null) && (this.bXi.isRunning())) {
          this.bXi.cancel();
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(310489);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract String ajB(int paramInt);
    
    public abstract int getCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.LivingDescBarLayout
 * JD-Core Version:    0.7.0.1
 */