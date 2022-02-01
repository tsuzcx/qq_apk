package com.tencent.mm.plugin.sns.ad.widget.a;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.i;
import java.util.ArrayList;

public final class f
  extends a
{
  public f(Context paramContext, FrameLayout paramFrameLayout, b.a parama)
  {
    super(paramContext, paramFrameLayout, parama);
  }
  
  protected final void A(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310162);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 0.0F });
    paramInt1 = (int)i.aR(0.0F, 2000.0F);
    localObjectAnimator1.setInterpolator(new AccelerateInterpolator());
    localObjectAnimator1.setDuration(paramInt1);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "rotation", new float[] { 0.0F, 360.0F });
    localObjectAnimator2.setInterpolator(new LinearInterpolator());
    localObjectAnimator2.setDuration(3000L);
    localObjectAnimator2.start();
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.0F, 1.0F });
    localObjectAnimator3.setDuration(500L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.0F, 1.0F });
    localObjectAnimator4.setDuration(500L);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator5.setInterpolator(new LinearInterpolator());
    localObjectAnimator5.setDuration(500L);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 1.0F, 0.0F });
    localObjectAnimator6.setDuration(500L);
    localObjectAnimator6.setStartDelay(2600L);
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 1.0F, 0.0F });
    localObjectAnimator7.setStartDelay(2600L);
    localObjectAnimator7.setDuration(500L);
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F });
    paramView.setInterpolator(new LinearInterpolator());
    paramView.setDuration(500L);
    if (this.Qhg.duration - 3000 - paramInt1 > 0) {
      paramView.setStartDelay(2500L);
    }
    for (;;)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(localObjectAnimator3).with(localObjectAnimator4).with(localObjectAnimator5).with(localObjectAnimator2).with(localObjectAnimator6).with(localObjectAnimator7).with(paramView).after(localObjectAnimator1);
      localAnimatorSet.start();
      AppMethodBeat.o(310162);
      return;
      paramInt2 = this.Qhg.duration - paramInt1 - 500;
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = 0;
      }
      paramView.setStartDelay(paramInt1);
    }
  }
  
  protected final Rect hdf()
  {
    AppMethodBeat.i(310171);
    Rect localRect = new Rect();
    int i = 0;
    int j = (int)i.aR(this.Qhg.oQY, this.Qhg.maxSize);
    a(localRect, (int)i.aR(j / 2, this.Qhg.Qhl - j / 2), (int)i.aR(j / 2, this.Qhg.Qhm - j / 2), j);
    j = 0;
    label84:
    if (j < this.Qhj.size()) {
      if (!Rect.intersects((Rect)this.Qhj.get(j), localRect)) {}
    }
    for (j = 1;; j = 0)
    {
      if (j == 0)
      {
        AppMethodBeat.o(310171);
        return localRect;
        j += 1;
        break label84;
      }
      i += 1;
      if (i > 30)
      {
        AppMethodBeat.o(310171);
        return localRect;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.a.f
 * JD-Core Version:    0.7.0.1
 */