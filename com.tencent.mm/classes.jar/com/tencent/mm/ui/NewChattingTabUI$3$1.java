package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class NewChattingTabUI$3$1
  implements View.OnApplyWindowInsetsListener
{
  NewChattingTabUI$3$1(NewChattingTabUI.3 param3) {}
  
  @TargetApi(20)
  public final WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(29794);
    if (paramWindowInsets == null)
    {
      AppMethodBeat.o(29794);
      return paramWindowInsets;
    }
    ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "OnApplyWindowInsetsListener %s", new Object[] { paramWindowInsets });
    paramWindowInsets.consumeSystemWindowInsets();
    paramView = NewChattingTabUI.e(this.zen.zei);
    HomeUI.FitSystemWindowLayoutView localFitSystemWindowLayoutView = this.zen.zel;
    paramWindowInsets.getSystemWindowInsetTop();
    paramView.a(localFitSystemWindowLayoutView, new Rect(paramWindowInsets.getSystemWindowInsetLeft(), paramWindowInsets.getSystemWindowInsetTop(), paramWindowInsets.getSystemWindowInsetRight(), paramWindowInsets.getSystemWindowInsetBottom()), this.zen.zem);
    AppMethodBeat.o(29794);
    return paramWindowInsets;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI.3.1
 * JD-Core Version:    0.7.0.1
 */