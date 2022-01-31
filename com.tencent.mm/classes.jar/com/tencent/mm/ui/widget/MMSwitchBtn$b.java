package com.tencent.mm.ui.widget;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMSwitchBtn$b
  extends Animation
{
  long ADL;
  int direction;
  float startX;
  
  private MMSwitchBtn$b(MMSwitchBtn paramMMSwitchBtn)
  {
    AppMethodBeat.i(112576);
    this.direction = 0;
    this.startX = 0.0F;
    this.ADL = 0L;
    setInterpolator(new AccelerateDecelerateInterpolator());
    setAnimationListener(new MMSwitchBtn.b.1(this, paramMMSwitchBtn));
    AppMethodBeat.o(112576);
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    AppMethodBeat.i(112577);
    if (this.direction == 0) {}
    for (MMSwitchBtn.d(this.ADM).left = (this.startX - (float)this.ADL * paramFloat);; MMSwitchBtn.d(this.ADM).left = (this.startX + (float)this.ADL * paramFloat))
    {
      MMSwitchBtn.e(this.ADM);
      this.ADM.invalidate();
      AppMethodBeat.o(112577);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMSwitchBtn.b
 * JD-Core Version:    0.7.0.1
 */