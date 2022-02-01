package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class MMProcessBar
  extends View
{
  private Animation FD;
  private boolean LnU;
  private float LnV;
  
  public MMProcessBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164211);
    this.LnU = true;
    this.LnV = 0.0F;
    this.FD = new RotateAnimation(0.0F, 360.0F);
    AppMethodBeat.o(164211);
  }
  
  public MMProcessBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164212);
    this.LnU = true;
    this.LnV = 0.0F;
    this.FD = new RotateAnimation(0.0F, 360.0F);
    AppMethodBeat.o(164212);
  }
  
  private void fPM()
  {
    AppMethodBeat.i(164217);
    if (this.FD != null) {
      this.FD.cancel();
    }
    clearAnimation();
    AppMethodBeat.o(164217);
  }
  
  public final void fPN()
  {
    AppMethodBeat.i(164218);
    if (getVisibility() == 0)
    {
      startAnimation(this.FD);
      AppMethodBeat.o(164218);
      return;
    }
    ae.w("MicroMsg.MMProcessBar", "[startRotate] startRotate fail. this view Visibility=%s", new Object[] { Integer.valueOf(getVisibility()) });
    AppMethodBeat.o(164218);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(164215);
    super.onAttachedToWindow();
    fPN();
    AppMethodBeat.o(164215);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(164214);
    super.onDetachedFromWindow();
    fPM();
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
      fPM();
      this.FD = new RotateAnimation(0.0F, 72000.0F, f1, f2);
      this.FD.setRepeatMode(-1);
      this.FD.setRepeatCount(-1);
      this.FD.setDuration(75000L);
      this.FD.setInterpolator(new LinearInterpolator());
      if ((getVisibility() == 0) && (this.LnU)) {
        fPN();
      }
    }
    AppMethodBeat.o(164216);
  }
  
  public final void rotate(float paramFloat)
  {
    AppMethodBeat.i(164219);
    if ((this.FD != null) && (!this.FD.hasEnded())) {
      this.FD.cancel();
    }
    this.LnV += paramFloat;
    setRotation(this.LnV * 360.0F);
    AppMethodBeat.o(164219);
  }
  
  public void setDuration(long paramLong)
  {
    AppMethodBeat.i(164220);
    this.FD.setDuration(paramLong);
    AppMethodBeat.o(164220);
  }
  
  public void setIfVisibleRotate(boolean paramBoolean)
  {
    this.LnU = paramBoolean;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    AppMethodBeat.i(164221);
    this.FD.setInterpolator(paramInterpolator);
    AppMethodBeat.o(164221);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(164213);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (this.LnU)
      {
        fPN();
        AppMethodBeat.o(164213);
      }
    }
    else {
      fPM();
    }
    AppMethodBeat.o(164213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMProcessBar
 * JD-Core Version:    0.7.0.1
 */