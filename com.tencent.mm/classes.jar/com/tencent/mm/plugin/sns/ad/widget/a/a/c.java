package com.tencent.mm.plugin.sns.ad.widget.a.a;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.i;
import com.tencent.mm.plugin.sns.ad.widget.a.b.a;
import com.tencent.mm.plugin.sns.ad.widget.gllib.GLViewContainer;
import com.tencent.mm.plugin.sns.ad.widget.gllib.b;
import java.util.ArrayList;

public final class c
  extends a
{
  public c(Context paramContext, GLViewContainer paramGLViewContainer, b.a parama)
  {
    super(paramContext, paramGLViewContainer, parama);
  }
  
  protected final void a(b paramb, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(310151);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramb, "alpha", new float[] { 0.0F, 0.0F });
    int k = (int)i.aR(0.0F, 2000.0F);
    localObjectAnimator1.setDuration(k);
    int j = (int)i.aR(this.Qhh, this.Qhi);
    k = this.Qhg.duration - k;
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramb, "translationY", new float[] { 0.0F, -(int)(j * k / 1000.0F) });
    localObjectAnimator2.setInterpolator(new LinearInterpolator());
    localObjectAnimator2.setDuration(k + 100);
    paramInt2 = paramInt1 - this.Qhg.Qhm - paramInt2 / 2;
    paramInt1 = i;
    if (paramInt2 > 0) {
      paramInt1 = paramInt2 * 1000 / j;
    }
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramb, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator3.setInterpolator(new AccelerateInterpolator());
    if (paramInt1 > 0) {
      localObjectAnimator3.setStartDelay(paramInt1);
    }
    localObjectAnimator3.setDuration(400L);
    paramb = ObjectAnimator.ofFloat(paramb, "alpha", new float[] { 1.0F, 0.0F });
    paramb.setStartDelay(k - 300);
    paramb.setDuration(300L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator2).with(localObjectAnimator3).with(paramb).after(localObjectAnimator1);
    localAnimatorSet.start();
    AppMethodBeat.o(310151);
  }
  
  public final Rect hdf()
  {
    AppMethodBeat.i(310161);
    Rect localRect = new Rect();
    int i = 0;
    int j = (int)i.aR(this.Qhg.oQY, this.Qhg.maxSize);
    int k = (int)i.aR(this.Qhg.Qhm / 2, this.Qhg.Qhm + this.Qhg.maxSize * 4);
    a(localRect, (int)i.aR(j / 2, this.Qhg.Qhl - j / 2), k, j);
    j = 0;
    label100:
    if (j < this.Qhj.size()) {
      if (!Rect.intersects((Rect)this.Qhj.get(j), localRect)) {}
    }
    for (j = 1;; j = 0)
    {
      if (j == 0)
      {
        AppMethodBeat.o(310161);
        return localRect;
        j += 1;
        break label100;
      }
      i += 1;
      if (i > 30)
      {
        AppMethodBeat.o(310161);
        return localRect;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.a.a.c
 * JD-Core Version:    0.7.0.1
 */