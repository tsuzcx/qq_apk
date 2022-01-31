package com.tencent.mm.ui;

import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.compatible.util.d;

final class ad$3
  implements Runnable
{
  ad$3(ad paramad, int[] paramArrayOfInt, HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, ViewGroup paramViewGroup) {}
  
  public final void run()
  {
    this.uPW.ohK.getSupportActionBar().getCustomView().getLocationInWindow(this.uPY);
    int i = this.uPY[1];
    if (i > 0) {
      this.uPW.uPI.a(this.uPZ, new Rect(0, i, 0, 0), this.uQa);
    }
    while (!d.gF(20)) {
      return;
    }
    this.uPZ.setOnApplyWindowInsetsListener(new ad.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.ad.3
 * JD-Core Version:    0.7.0.1
 */