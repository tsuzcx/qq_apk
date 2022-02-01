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

public final class d
  extends a
{
  public d(Context paramContext, FrameLayout paramFrameLayout, b.a parama)
  {
    super(paramContext, paramFrameLayout, parama);
  }
  
  protected final void A(View paramView, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(310180);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 0.0F });
    int k = (int)i.aR(0.0F, 2000.0F);
    localObjectAnimator1.setDuration(k);
    int j = (int)i.aR(this.Qhh, this.Qhi);
    k = this.Qhg.duration - k;
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, -(int)(j * k / 1000.0F) });
    localObjectAnimator2.setInterpolator(new LinearInterpolator());
    localObjectAnimator2.setDuration(k + 100);
    paramInt2 = paramInt1 - this.Qhg.Qhm - paramInt2 / 2;
    paramInt1 = i;
    if (paramInt2 > 0) {
      paramInt1 = paramInt2 * 1000 / j;
    }
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator3.setInterpolator(new AccelerateInterpolator());
    if (paramInt1 > 0) {
      localObjectAnimator3.setStartDelay(paramInt1);
    }
    localObjectAnimator3.setDuration(400L);
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F });
    paramView.setStartDelay(k - 300);
    paramView.setDuration(300L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator2).with(localObjectAnimator3).with(paramView).after(localObjectAnimator1);
    localAnimatorSet.start();
    AppMethodBeat.o(310180);
  }
  
  protected final Rect hdf()
  {
    AppMethodBeat.i(310193);
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
        AppMethodBeat.o(310193);
        return localRect;
        j += 1;
        break label100;
      }
      i += 1;
      if (i > 30)
      {
        AppMethodBeat.o(310193);
        return localRect;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.a.d
 * JD-Core Version:    0.7.0.1
 */