package com.tencent.mm.ui.widget;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class MMSwitchBtn$b
  extends Animation
{
  int direction = 0;
  float wkc = 0.0F;
  long wkd = 0L;
  
  private MMSwitchBtn$b(MMSwitchBtn paramMMSwitchBtn)
  {
    setInterpolator(new AccelerateDecelerateInterpolator());
    setAnimationListener(new MMSwitchBtn.b.1(this, paramMMSwitchBtn));
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.direction == 0) {}
    for (MMSwitchBtn.d(this.wke).left = (this.wkc - (float)this.wkd * paramFloat);; MMSwitchBtn.d(this.wke).left = (this.wkc + (float)this.wkd * paramFloat))
    {
      MMSwitchBtn.e(this.wke);
      this.wke.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMSwitchBtn.b
 * JD-Core Version:    0.7.0.1
 */