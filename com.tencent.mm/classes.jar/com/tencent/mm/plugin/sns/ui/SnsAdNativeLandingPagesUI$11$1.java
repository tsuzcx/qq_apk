package com.tencent.mm.plugin.sns.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class SnsAdNativeLandingPagesUI$11$1
  implements ViewTreeObserver.OnPreDrawListener
{
  SnsAdNativeLandingPagesUI$11$1(SnsAdNativeLandingPagesUI.11 param11, RecyclerView paramRecyclerView) {}
  
  public final boolean onPreDraw()
  {
    y.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPreDraw %d, %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesUI.c(this.oUX.oUU).getHeight()), Integer.valueOf(SnsAdNativeLandingPagesUI.d(this.oUX.oUU)) });
    if (SnsAdNativeLandingPagesUI.e(this.oUX.oUU)) {
      ai.l(new SnsAdNativeLandingPagesUI.11.1.1(this), 50L);
    }
    this.hsd.getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.11.1
 * JD-Core Version:    0.7.0.1
 */