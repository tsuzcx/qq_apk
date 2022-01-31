package com.tencent.mm.ui;

import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;

final class NewChattingTabUI$3
  implements Runnable
{
  NewChattingTabUI$3(NewChattingTabUI paramNewChattingTabUI, int[] paramArrayOfInt, HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, ViewGroup paramViewGroup) {}
  
  public final void run()
  {
    AppMethodBeat.i(29795);
    NewChattingTabUI.g(this.zei).getSupportActionBar().getCustomView().getLocationInWindow(this.zek);
    int i = NewChattingTabUI.h(this.zei);
    if (i > 0)
    {
      NewChattingTabUI.e(this.zei).a(this.zel, new Rect(0, i, 0, 0), this.zem);
      AppMethodBeat.o(29795);
      return;
    }
    if (d.fv(20)) {
      this.zel.setOnApplyWindowInsetsListener(new NewChattingTabUI.3.1(this));
    }
    AppMethodBeat.o(29795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI.3
 * JD-Core Version:    0.7.0.1
 */