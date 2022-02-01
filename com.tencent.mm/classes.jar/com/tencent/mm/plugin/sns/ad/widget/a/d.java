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
import com.tencent.mm.plugin.sns.ad.i.h;
import java.util.ArrayList;

public final class d
  extends a
{
  protected int DBc;
  protected int DBd;
  
  public d(Context paramContext, FrameLayout paramFrameLayout, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramContext, paramFrameLayout, paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  protected final void c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = 0;
    AppMethodBeat.i(202452);
    if (this.DBc == 0) {
      this.DBc = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 180);
    }
    if (this.DBd == 0) {
      this.DBd = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 220);
    }
    int i = (int)h.al(this.DBc, this.DBd);
    int j = this.mMaxSize * 2 + paramInt2;
    int k = j * 1000 / i;
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 0.0F });
    localObjectAnimator1.setDuration((int)h.al(0.0F, this.atU));
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, -j });
    localObjectAnimator2.setInterpolator(new LinearInterpolator());
    localObjectAnimator2.setDuration(k);
    paramInt2 = paramInt2 - this.DAS - paramInt3 / 2;
    if (paramInt2 > 0) {
      paramInt1 = paramInt2 * 1000 / i;
    }
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    paramView.setInterpolator(new AccelerateInterpolator());
    if (paramInt1 > 0) {
      paramView.setStartDelay(paramInt1);
    }
    paramView.setDuration(400L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator2).with(paramView).after(localObjectAnimator1);
    localAnimatorSet.start();
    AppMethodBeat.o(202452);
  }
  
  protected final Rect eYz()
  {
    AppMethodBeat.i(202453);
    Rect localRect = new Rect();
    int i = 0;
    int j = (int)h.al(this.DAQ, this.mMaxSize);
    int k = (int)h.al(this.DAS / 2, this.DAS + this.mMaxSize * 4);
    a(localRect, (int)h.al(j / 2, this.DAR - j / 2), k, j);
    j = 0;
    label82:
    if (j < this.DAW.size()) {
      if (!Rect.intersects((Rect)this.DAW.get(j), localRect)) {}
    }
    for (j = 1;; j = 0)
    {
      if (j == 0)
      {
        AppMethodBeat.o(202453);
        return localRect;
        j += 1;
        break label82;
      }
      i += 1;
      if (i > 20)
      {
        AppMethodBeat.o(202453);
        return localRect;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.a.d
 * JD-Core Version:    0.7.0.1
 */