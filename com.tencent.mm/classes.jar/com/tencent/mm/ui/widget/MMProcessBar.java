package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class MMProcessBar
  extends View
{
  private Animation CN;
  private boolean HzO;
  private float HzP;
  
  public MMProcessBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164211);
    this.HzO = true;
    this.HzP = 0.0F;
    this.CN = new RotateAnimation(0.0F, 360.0F);
    AppMethodBeat.o(164211);
  }
  
  public MMProcessBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164212);
    this.HzO = true;
    this.HzP = 0.0F;
    this.CN = new RotateAnimation(0.0F, 360.0F);
    AppMethodBeat.o(164212);
  }
  
  private void feK()
  {
    AppMethodBeat.i(164217);
    if (this.CN != null) {
      this.CN.cancel();
    }
    clearAnimation();
    AppMethodBeat.o(164217);
  }
  
  public final void feL()
  {
    AppMethodBeat.i(164218);
    if (getVisibility() == 0)
    {
      startAnimation(this.CN);
      AppMethodBeat.o(164218);
      return;
    }
    ad.w("MicroMsg.MMProcessBar", "[startRotate] startRotate fail. this view Visibility=%s", new Object[] { Integer.valueOf(getVisibility()) });
    AppMethodBeat.o(164218);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(164215);
    super.onAttachedToWindow();
    feL();
    AppMethodBeat.o(164215);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(164214);
    super.onDetachedFromWindow();
    feK();
    AppMethodBeat.o(164214);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164216);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      float f1 = getWidth() / 2;
      float f2 = getHeight() / 2;
      feK();
      this.CN = new RotateAnimation(0.0F, 36000.0F, f1, f2);
      this.CN.setRepeatMode(-1);
      this.CN.setRepeatCount(-1);
      this.CN.setDuration(75000L);
      this.CN.setInterpolator(new LinearInterpolator());
      if ((getVisibility() == 0) && (this.HzO)) {
        feL();
      }
    }
    AppMethodBeat.o(164216);
  }
  
  public final void rotate(float paramFloat)
  {
    AppMethodBeat.i(164219);
    if ((this.CN != null) && (!this.CN.hasEnded())) {
      this.CN.cancel();
    }
    this.HzP += paramFloat;
    setRotation(this.HzP * 360.0F);
    AppMethodBeat.o(164219);
  }
  
  public void setDuration(long paramLong)
  {
    AppMethodBeat.i(164220);
    this.CN.setDuration(paramLong);
    AppMethodBeat.o(164220);
  }
  
  public void setIfVisibleRotate(boolean paramBoolean)
  {
    this.HzO = paramBoolean;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    AppMethodBeat.i(164221);
    this.CN.setInterpolator(paramInterpolator);
    AppMethodBeat.o(164221);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(164213);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (this.HzO)
      {
        feL();
        AppMethodBeat.o(164213);
      }
    }
    else {
      feK();
    }
    AppMethodBeat.o(164213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMProcessBar
 * JD-Core Version:    0.7.0.1
 */