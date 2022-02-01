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
import com.tencent.mm.plugin.sns.ad.i.i;
import java.util.ArrayList;

public final class e
  extends a
{
  protected int JMN;
  protected int JMO;
  
  public e(Context paramContext, FrameLayout paramFrameLayout, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramContext, paramFrameLayout, paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  protected final void c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(270311);
    if (this.JMN == 0) {
      this.JMN = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 180);
    }
    if (this.JMO == 0) {
      this.JMO = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 220);
    }
    paramInt2 = (int)i.an(this.JMN, this.JMO);
    paramInt1 = this.JMD + this.mMaxSize - paramInt1;
    paramInt2 = paramInt1 * 1000 / paramInt2;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 1.0F });
    localObjectAnimator.setDuration((int)i.an(0.0F, this.alM));
    paramView = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { 0.0F, paramInt1 });
    paramView.setInterpolator(new LinearInterpolator());
    paramView.setDuration(paramInt2);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(paramView).after(localObjectAnimator);
    localAnimatorSet.start();
    AppMethodBeat.o(270311);
  }
  
  protected final Rect fMj()
  {
    AppMethodBeat.i(270313);
    Rect localRect = new Rect();
    int i = 0;
    int j = (int)i.an(this.DIY, this.mMaxSize);
    int k = (int)i.an(j / 2, this.JME - j / 2);
    a(localRect, (int)i.an(-this.mMaxSize, -this.mMaxSize), k, j);
    j = 0;
    label75:
    if (j < this.JMI.size()) {
      if (!Rect.intersects((Rect)this.JMI.get(j), localRect)) {}
    }
    for (j = 1;; j = 0)
    {
      if (j == 0)
      {
        AppMethodBeat.o(270313);
        return localRect;
        j += 1;
        break label75;
      }
      i += 1;
      if (i > 20)
      {
        AppMethodBeat.o(270313);
        return localRect;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.a.e
 * JD-Core Version:    0.7.0.1
 */