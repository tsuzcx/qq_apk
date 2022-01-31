package com.tencent.mm.plugin.websearch.widget;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mm.sdk.platformtools.y;

final class a$6
  implements Runnable
{
  a$6(a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView1, View paramView2) {}
  
  public final void run()
  {
    y.i("FTSSearchWidgetMgr", "animating  size beginH %d, endH %d, beginW %d, endW %d", new Object[] { Integer.valueOf(this.qWT), Integer.valueOf(this.qWU), Integer.valueOf(this.qWV), Integer.valueOf(this.qWW) });
    if ((this.qWT == this.qWU) && (this.qWV == this.qWW)) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams1 = this.qWX.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams2 = this.qWY.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.qWT, this.qWU });
    localValueAnimator.setDuration(300L);
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.addUpdateListener(new a.6.1(this, localLayoutParams1, localLayoutParams2));
    localValueAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.6
 * JD-Core Version:    0.7.0.1
 */