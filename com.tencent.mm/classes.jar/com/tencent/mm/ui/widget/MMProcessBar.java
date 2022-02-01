package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import androidx.core.graphics.drawable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class MMProcessBar
  extends View
{
  private float afTA;
  public Animation bCz;
  
  public MMProcessBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(251671);
    this.afTA = 0.0F;
    this.bCz = new RotateAnimation(0.0F, 360.0F);
    AppMethodBeat.o(251671);
  }
  
  public MMProcessBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164211);
    this.afTA = 0.0F;
    this.bCz = new RotateAnimation(0.0F, 360.0F);
    AppMethodBeat.o(164211);
  }
  
  public MMProcessBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164212);
    this.afTA = 0.0F;
    this.bCz = new RotateAnimation(0.0F, 360.0F);
    AppMethodBeat.o(164212);
  }
  
  public final void ed(float paramFloat)
  {
    AppMethodBeat.i(164219);
    if ((this.bCz != null) && (!this.bCz.hasEnded())) {
      this.bCz.cancel();
    }
    this.afTA += paramFloat;
    setRotation(this.afTA * 360.0F);
    AppMethodBeat.o(164219);
  }
  
  public final void jEO()
  {
    AppMethodBeat.i(164217);
    if (this.bCz != null) {
      this.bCz.cancel();
    }
    clearAnimation();
    AppMethodBeat.o(164217);
  }
  
  public final void jEP()
  {
    AppMethodBeat.i(164218);
    if (getVisibility() == 0)
    {
      startAnimation(this.bCz);
      AppMethodBeat.o(164218);
      return;
    }
    Log.w("MicroMsg.MMProcessBar", "[startRotate] startRotate fail. this view Visibility=%s", new Object[] { Integer.valueOf(getVisibility()) });
    AppMethodBeat.o(164218);
  }
  
  public final void oH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251702);
    try
    {
      Drawable localDrawable = getResources().getDrawable(paramInt1);
      localDrawable.setColorFilter(MMApplicationContext.getContext().getResources().getColor(a.d.BW_70), PorterDuff.Mode.SRC_ATOP);
      if (paramInt2 != 0) {
        a.a(localDrawable, ColorStateList.valueOf(paramInt2));
      }
      setBackground(localDrawable);
      AppMethodBeat.o(251702);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(251702);
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(164215);
    super.onAttachedToWindow();
    jEP();
    AppMethodBeat.o(164215);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(164214);
    super.onDetachedFromWindow();
    jEO();
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
      jEO();
      this.bCz = new RotateAnimation(0.0F, 72000.0F, f1, f2);
      this.bCz.setRepeatMode(-1);
      this.bCz.setRepeatCount(-1);
      this.bCz.setDuration(70000L);
      this.bCz.setInterpolator(new LinearInterpolator());
      if (getVisibility() == 0) {
        jEP();
      }
    }
    AppMethodBeat.o(164216);
  }
  
  public void setDuration(long paramLong)
  {
    AppMethodBeat.i(164220);
    this.bCz.setDuration(paramLong);
    AppMethodBeat.o(164220);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    AppMethodBeat.i(164221);
    this.bCz.setInterpolator(paramInterpolator);
    AppMethodBeat.o(164221);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(164213);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      jEP();
      AppMethodBeat.o(164213);
      return;
    }
    jEO();
    AppMethodBeat.o(164213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMProcessBar
 * JD-Core Version:    0.7.0.1
 */