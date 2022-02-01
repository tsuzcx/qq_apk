package com.tencent.mm.plugin.sns.ad.g.a;

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
import com.tencent.mm.plugin.sns.ad.f.f;
import java.util.ArrayList;

public final class c
  extends a
{
  protected int zsr;
  protected int zss;
  
  public c(Context paramContext, FrameLayout paramFrameLayout, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramContext, paramFrameLayout, paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  protected final void c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = 0;
    AppMethodBeat.i(219196);
    if (this.zsr == 0) {
      this.zsr = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 180);
    }
    if (this.zss == 0) {
      this.zss = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 220);
    }
    int i = (int)f.ae(this.zsr, this.zss);
    int j = this.zsj + this.zsh * 2 - paramInt2;
    int k = j * 1000 / i;
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 0.0F });
    localObjectAnimator1.setDuration((int)f.ae(0.0F, this.atW));
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, j });
    localObjectAnimator2.setInterpolator(new LinearInterpolator());
    localObjectAnimator2.setDuration(k);
    if (paramInt2 < 0) {
      paramInt1 = Math.abs(paramInt3 / 2 + paramInt2) * 1000 / i;
    }
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    paramView.setInterpolator(new AccelerateInterpolator());
    paramView.setDuration(400L);
    if (paramInt1 > 0) {
      paramView.setStartDelay(paramInt1);
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator2).with(paramView).after(localObjectAnimator1);
    localAnimatorSet.start();
    AppMethodBeat.o(219196);
  }
  
  protected final Rect dVJ()
  {
    AppMethodBeat.i(219197);
    Rect localRect = new Rect();
    int i = 0;
    int j = (int)f.ae(this.zsg, this.zsh);
    int k = (int)f.ae(this.zsj / 2, -this.zsh * 4);
    a(localRect, (int)f.ae(j / 2, this.zsi - j / 2), k, j);
    j = 0;
    label78:
    if (j < this.zsm.size()) {
      if (!Rect.intersects((Rect)this.zsm.get(j), localRect)) {}
    }
    for (j = 1;; j = 0)
    {
      if (j == 0)
      {
        AppMethodBeat.o(219197);
        return localRect;
        j += 1;
        break label78;
      }
      i += 1;
      if (i > 20)
      {
        AppMethodBeat.o(219197);
        return localRect;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.a.c
 * JD-Core Version:    0.7.0.1
 */