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

public final class d
  extends a
{
  protected int JMN;
  protected int JMO;
  
  public d(Context paramContext, FrameLayout paramFrameLayout, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramContext, paramFrameLayout, paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  protected final void c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = 0;
    AppMethodBeat.i(268599);
    if (this.JMN == 0) {
      this.JMN = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 180);
    }
    if (this.JMO == 0) {
      this.JMO = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 220);
    }
    int i = (int)i.an(this.JMN, this.JMO);
    int j = this.mMaxSize * 2 + paramInt2;
    int k = j * 1000 / i;
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 0.0F });
    localObjectAnimator1.setDuration((int)i.an(0.0F, this.alM));
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, -j });
    localObjectAnimator2.setInterpolator(new LinearInterpolator());
    localObjectAnimator2.setDuration(k);
    paramInt2 = paramInt2 - this.JME - paramInt3 / 2;
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
    AppMethodBeat.o(268599);
  }
  
  protected final Rect fMj()
  {
    AppMethodBeat.i(268600);
    Rect localRect = new Rect();
    int i = 0;
    int j = (int)i.an(this.DIY, this.mMaxSize);
    int k = (int)i.an(this.JME / 2, this.JME + this.mMaxSize * 4);
    a(localRect, (int)i.an(j / 2, this.JMD - j / 2), k, j);
    j = 0;
    label82:
    if (j < this.JMI.size()) {
      if (!Rect.intersects((Rect)this.JMI.get(j), localRect)) {}
    }
    for (j = 1;; j = 0)
    {
      if (j == 0)
      {
        AppMethodBeat.o(268600);
        return localRect;
        j += 1;
        break label82;
      }
      i += 1;
      if (i > 20)
      {
        AppMethodBeat.o(268600);
        return localRect;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.a.d
 * JD-Core Version:    0.7.0.1
 */