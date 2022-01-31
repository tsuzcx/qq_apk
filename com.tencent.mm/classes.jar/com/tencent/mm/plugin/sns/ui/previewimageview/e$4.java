package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.os.Build.VERSION;
import android.view.View;

final class e$4
  implements DynamicGridView.f
{
  e$4(e parame, DynamicGridView paramDynamicGridView, View paramView) {}
  
  public final void bKq()
  {
    DynamicGridView localDynamicGridView = this.ppU;
    localDynamicGridView.jDC = false;
    localDynamicGridView.requestDisallowInterceptTouchEvent(false);
    if ((DynamicGridView.bKv()) && (localDynamicGridView.pqr)) {
      localDynamicGridView.jB(true);
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.ppU.setElevation(this.ppV.ppN);
      return;
    }
    this.ppW.bringToFront();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e.4
 * JD-Core Version:    0.7.0.1
 */