package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class MMProcessBar
  extends View
{
  private Animation FN;
  private float QDe;
  
  public MMProcessBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(205404);
    this.QDe = 0.0F;
    this.FN = new RotateAnimation(0.0F, 360.0F);
    AppMethodBeat.o(205404);
  }
  
  public MMProcessBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164211);
    this.QDe = 0.0F;
    this.FN = new RotateAnimation(0.0F, 360.0F);
    AppMethodBeat.o(164211);
  }
  
  public MMProcessBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164212);
    this.QDe = 0.0F;
    this.FN = new RotateAnimation(0.0F, 360.0F);
    AppMethodBeat.o(164212);
  }
  
  public final void gYO()
  {
    AppMethodBeat.i(164217);
    if (this.FN != null) {
      this.FN.cancel();
    }
    clearAnimation();
    AppMethodBeat.o(164217);
  }
  
  public final void gYP()
  {
    AppMethodBeat.i(164218);
    if (getVisibility() == 0)
    {
      startAnimation(this.FN);
      AppMethodBeat.o(164218);
      return;
    }
    Log.w("MicroMsg.MMProcessBar", "[startRotate] startRotate fail. this view Visibility=%s", new Object[] { Integer.valueOf(getVisibility()) });
    AppMethodBeat.o(164218);
  }
  
  public final boolean gYQ()
  {
    AppMethodBeat.i(205406);
    if ((this.FN != null) && (!this.FN.hasEnded()) && (this.FN.hasStarted()))
    {
      AppMethodBeat.o(205406);
      return true;
    }
    AppMethodBeat.o(205406);
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(164215);
    super.onAttachedToWindow();
    gYP();
    AppMethodBeat.o(164215);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(164214);
    super.onDetachedFromWindow();
    gYO();
    AppMethodBeat.o(164214);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164216);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      float f1 = getWidth() / 2.0F;
      float f2 = getHeight() / 2.0F;
      gYO();
      this.FN = new RotateAnimation(0.0F, 72000.0F, f1, f2);
      this.FN.setRepeatMode(-1);
      this.FN.setRepeatCount(-1);
      this.FN.setDuration(70000L);
      this.FN.setInterpolator(new LinearInterpolator());
      if (getVisibility() == 0) {
        gYP();
      }
    }
    AppMethodBeat.o(164216);
  }
  
  public final void rotate(float paramFloat)
  {
    AppMethodBeat.i(164219);
    if ((this.FN != null) && (!this.FN.hasEnded())) {
      this.FN.cancel();
    }
    this.QDe += paramFloat;
    setRotation(this.QDe * 360.0F);
    AppMethodBeat.o(164219);
  }
  
  public final void setBackground$255f295(int paramInt)
  {
    AppMethodBeat.i(205405);
    try
    {
      Drawable localDrawable = getResources().getDrawable(2131690268);
      localDrawable.setColorFilter(MMApplicationContext.getContext().getResources().getColor(2131099685), PorterDuff.Mode.SRC_ATOP);
      if (paramInt != 0) {
        a.a(localDrawable, ColorStateList.valueOf(paramInt));
      }
      setBackground(localDrawable);
      AppMethodBeat.o(205405);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(205405);
    }
  }
  
  public void setDuration(long paramLong)
  {
    AppMethodBeat.i(164220);
    this.FN.setDuration(paramLong);
    AppMethodBeat.o(164220);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    AppMethodBeat.i(164221);
    this.FN.setInterpolator(paramInterpolator);
    AppMethodBeat.o(164221);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(164213);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      gYP();
      AppMethodBeat.o(164213);
      return;
    }
    gYO();
    AppMethodBeat.o(164213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMProcessBar
 * JD-Core Version:    0.7.0.1
 */