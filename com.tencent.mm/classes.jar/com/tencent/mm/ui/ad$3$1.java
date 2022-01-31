package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import com.tencent.mm.sdk.platformtools.y;

final class ad$3$1
  implements View.OnApplyWindowInsetsListener
{
  ad$3$1(ad.3 param3) {}
  
  @TargetApi(20)
  public final WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    if (paramWindowInsets == null) {
      return paramWindowInsets;
    }
    y.i("MicroMsg.LauncherUI.NewChattingTabUI", "OnApplyWindowInsetsListener %s", new Object[] { paramWindowInsets });
    paramWindowInsets.consumeSystemWindowInsets();
    paramView = this.uQb.uPW.uPI;
    HomeUI.FitSystemWindowLayoutView localFitSystemWindowLayoutView = this.uQb.uPZ;
    paramWindowInsets.getSystemWindowInsetTop();
    paramView.a(localFitSystemWindowLayoutView, new Rect(paramWindowInsets.getSystemWindowInsetLeft(), paramWindowInsets.getSystemWindowInsetTop(), paramWindowInsets.getSystemWindowInsetRight(), paramWindowInsets.getSystemWindowInsetBottom()), this.uQb.uQa);
    return paramWindowInsets;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.ad.3.1
 * JD-Core Version:    0.7.0.1
 */