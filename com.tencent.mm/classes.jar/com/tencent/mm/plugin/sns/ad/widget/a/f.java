package com.tencent.mm.plugin.sns.ad.widget.a;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.i;
import java.util.ArrayList;

public final class f
  extends a
{
  public f(Context paramContext, FrameLayout paramFrameLayout, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramContext, paramFrameLayout, paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  protected final void c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(259692);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 0.0F });
    paramInt1 = (int)i.an(0.0F, 0.8F * this.alM);
    localObjectAnimator1.setInterpolator(new AccelerateInterpolator());
    localObjectAnimator1.setDuration(paramInt1);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "rotation", new float[] { 0.0F, this.alM / 1000.0F * 180.0F });
    localObjectAnimator2.setInterpolator(new LinearInterpolator());
    localObjectAnimator2.setDuration(this.alM);
    localObjectAnimator2.setRepeatCount(10);
    localObjectAnimator2.start();
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.0F, 1.0F });
    localObjectAnimator3.setDuration(400L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.0F, 1.0F });
    localObjectAnimator4.setDuration(400L);
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    paramView.setInterpolator(new LinearInterpolator());
    paramView.setDuration(400L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator3).with(localObjectAnimator4).with(paramView).with(localObjectAnimator2).after(localObjectAnimator1);
    localAnimatorSet.start();
    AppMethodBeat.o(259692);
  }
  
  protected final Rect fMj()
  {
    AppMethodBeat.i(259694);
    Rect localRect = new Rect();
    int i = 0;
    int j = (int)i.an(this.DIY, this.mMaxSize);
    a(localRect, (int)i.an(j / 2, this.JMD - j / 2), (int)i.an(j / 2, this.JME - j / 2), j);
    j = 0;
    label72:
    if (j < this.JMI.size()) {
      if (!Rect.intersects((Rect)this.JMI.get(j), localRect)) {}
    }
    for (j = 1;; j = 0)
    {
      if (j == 0)
      {
        AppMethodBeat.o(259694);
        return localRect;
        j += 1;
        break label72;
      }
      i += 1;
      if (i > 20)
      {
        AppMethodBeat.o(259694);
        return localRect;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.a.f
 * JD-Core Version:    0.7.0.1
 */