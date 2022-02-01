package com.tencent.mm.plugin.sns.ad.widget.a.a;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.i;
import com.tencent.mm.plugin.sns.ad.widget.a.b.a;
import com.tencent.mm.plugin.sns.ad.widget.gllib.GLViewContainer;
import com.tencent.mm.plugin.sns.ad.widget.gllib.b;
import java.util.ArrayList;

public final class d
  extends a
{
  public d(Context paramContext, GLViewContainer paramGLViewContainer, b.a parama)
  {
    super(paramContext, paramGLViewContainer, parama);
  }
  
  protected final void a(b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310144);
    paramInt1 = (int)i.aR(this.Qhh, this.Qhi);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramb, "alpha", new float[] { 1.0F, 1.0F });
    paramInt2 = (int)i.aR(0.0F, this.Qhg.duration);
    localObjectAnimator1.setDuration(paramInt2);
    paramInt2 = this.Qhg.duration - paramInt2;
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramb, "translationX", new float[] { 0.0F, (int)(paramInt1 * paramInt2 / 1000.0F) });
    localObjectAnimator2.setInterpolator(new LinearInterpolator());
    localObjectAnimator2.setDuration(paramInt2 + 100);
    paramb = ObjectAnimator.ofFloat(paramb, "alpha", new float[] { 1.0F, 0.0F });
    paramb.setStartDelay(paramInt2 - 300);
    paramb.setDuration(300L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator2).with(paramb).after(localObjectAnimator1);
    localAnimatorSet.start();
    AppMethodBeat.o(310144);
  }
  
  public final Rect hdf()
  {
    AppMethodBeat.i(310152);
    Rect localRect = new Rect();
    int i = 0;
    int j = (int)i.aR(this.Qhg.oQY, this.Qhg.maxSize);
    int k = (int)i.aR(j / 2, this.Qhg.Qhm - j / 2);
    a(localRect, (int)i.aR(-this.Qhg.maxSize, -this.Qhg.maxSize), k, j);
    j = 0;
    label90:
    if (j < this.Qhj.size()) {
      if (!Rect.intersects((Rect)this.Qhj.get(j), localRect)) {}
    }
    for (j = 1;; j = 0)
    {
      if (j == 0)
      {
        AppMethodBeat.o(310152);
        return localRect;
        j += 1;
        break label90;
      }
      i += 1;
      if (i > 30)
      {
        AppMethodBeat.o(310152);
        return localRect;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.a.a.d
 * JD-Core Version:    0.7.0.1
 */