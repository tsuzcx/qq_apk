package com.tencent.mm.plugin.sns.ad.widget.a;

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
import com.tencent.mm.plugin.sns.ad.i.h;
import java.util.ArrayList;

public final class e
  extends a
{
  protected int DBc;
  protected int DBd;
  
  public e(Context paramContext, FrameLayout paramFrameLayout, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramContext, paramFrameLayout, paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  protected final void c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(202454);
    if (this.DBc == 0) {
      this.DBc = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 180);
    }
    if (this.DBd == 0) {
      this.DBd = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 220);
    }
    paramInt2 = (int)h.al(this.DBc, this.DBd);
    paramInt1 = this.DAR + this.mMaxSize - paramInt1;
    paramInt2 = paramInt1 * 1000 / paramInt2;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 1.0F });
    localObjectAnimator.setDuration((int)h.al(0.0F, this.atU));
    paramView = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { 0.0F, paramInt1 });
    paramView.setInterpolator(new LinearInterpolator());
    paramView.setDuration(paramInt2);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(paramView).after(localObjectAnimator);
    localAnimatorSet.start();
    AppMethodBeat.o(202454);
  }
  
  protected final Rect eYz()
  {
    AppMethodBeat.i(202455);
    Rect localRect = new Rect();
    int i = 0;
    int j = (int)h.al(this.DAQ, this.mMaxSize);
    int k = (int)h.al(j / 2, this.DAS - j / 2);
    a(localRect, (int)h.al(-this.mMaxSize, -this.mMaxSize), k, j);
    j = 0;
    label75:
    if (j < this.DAW.size()) {
      if (!Rect.intersects((Rect)this.DAW.get(j), localRect)) {}
    }
    for (j = 1;; j = 0)
    {
      if (j == 0)
      {
        AppMethodBeat.o(202455);
        return localRect;
        j += 1;
        break label75;
      }
      i += 1;
      if (i > 20)
      {
        AppMethodBeat.o(202455);
        return localRect;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.a.e
 * JD-Core Version:    0.7.0.1
 */