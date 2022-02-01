package com.tencent.mm.plugin.sns.ad.g.a;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.f.f;
import java.util.ArrayList;

public final class e
  extends a
{
  protected int zsr;
  protected int zss;
  
  public e(Context paramContext, FrameLayout paramFrameLayout, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramContext, paramFrameLayout, paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  protected final void c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(219200);
    if (this.zsr == 0) {
      this.zsr = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 180);
    }
    if (this.zss == 0) {
      this.zss = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 220);
    }
    paramInt2 = (int)f.ae(this.zsr, this.zss);
    paramInt1 = this.zsi + this.zsh - paramInt1;
    paramInt2 = paramInt1 * 1000 / paramInt2;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 1.0F });
    localObjectAnimator.setDuration((int)f.ae(0.0F, this.atW));
    paramView = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { 0.0F, paramInt1 });
    paramView.setInterpolator(new LinearInterpolator());
    paramView.setDuration(paramInt2);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(paramView).after(localObjectAnimator);
    localAnimatorSet.start();
    AppMethodBeat.o(219200);
  }
  
  protected final Rect dVJ()
  {
    AppMethodBeat.i(219201);
    Rect localRect = new Rect();
    int i = 0;
    int j = (int)f.ae(this.zsg, this.zsh);
    int k = (int)f.ae(j / 2, this.zsj - j / 2);
    a(localRect, (int)f.ae(-this.zsh, -this.zsh), k, j);
    j = 0;
    label75:
    if (j < this.zsm.size()) {
      if (!Rect.intersects((Rect)this.zsm.get(j), localRect)) {}
    }
    for (j = 1;; j = 0)
    {
      if (j == 0)
      {
        AppMethodBeat.o(219201);
        return localRect;
        j += 1;
        break label75;
      }
      i += 1;
      if (i > 20)
      {
        AppMethodBeat.o(219201);
        return localRect;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.a.e
 * JD-Core Version:    0.7.0.1
 */