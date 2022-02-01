package com.tencent.mm.plugin.sns.ad.f.a;

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
import com.tencent.mm.plugin.sns.ad.e.f;
import java.util.ArrayList;

public final class e
  extends a
{
  protected int zbO;
  protected int zbP;
  
  public e(Context paramContext, FrameLayout paramFrameLayout, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramContext, paramFrameLayout, paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  protected final void c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(197728);
    if (this.zbO == 0) {
      this.zbO = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 180);
    }
    if (this.zbP == 0) {
      this.zbP = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 220);
    }
    paramInt2 = (int)f.ae(this.zbO, this.zbP);
    paramInt1 = this.zbF + this.zbE - paramInt1;
    paramInt2 = paramInt1 * 1000 / paramInt2;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 1.0F });
    localObjectAnimator.setDuration((int)f.ae(0.0F, this.atW));
    paramView = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { 0.0F, paramInt1 });
    paramView.setInterpolator(new LinearInterpolator());
    paramView.setDuration(paramInt2);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(paramView).after(localObjectAnimator);
    localAnimatorSet.start();
    AppMethodBeat.o(197728);
  }
  
  protected final Rect dSl()
  {
    AppMethodBeat.i(197729);
    Rect localRect = new Rect();
    int i = 0;
    int j = (int)f.ae(this.zbD, this.zbE);
    int k = (int)f.ae(j / 2, this.zbG - j / 2);
    a(localRect, (int)f.ae(-this.zbE, -this.zbE), k, j);
    j = 0;
    label75:
    if (j < this.zbJ.size()) {
      if (!Rect.intersects((Rect)this.zbJ.get(j), localRect)) {}
    }
    for (j = 1;; j = 0)
    {
      if (j == 0)
      {
        AppMethodBeat.o(197729);
        return localRect;
        j += 1;
        break label75;
      }
      i += 1;
      if (i > 20)
      {
        AppMethodBeat.o(197729);
        return localRect;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.a.e
 * JD-Core Version:    0.7.0.1
 */