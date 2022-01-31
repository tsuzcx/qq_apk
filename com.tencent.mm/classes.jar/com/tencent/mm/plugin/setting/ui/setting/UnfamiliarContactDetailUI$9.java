package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;

final class UnfamiliarContactDetailUI$9
  implements View.OnClickListener
{
  UnfamiliarContactDetailUI$9(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127646);
    paramView = (CheckBox)UnfamiliarContactDetailUI.i(this.qLi).findViewById(2131820950);
    if (!paramView.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      if (!paramView.isChecked()) {
        break;
      }
      int i = 0;
      while (i < UnfamiliarContactDetailUI.f(this.qLi).size())
      {
        UnfamiliarContactDetailUI.b(this.qLi).add(Integer.valueOf(i));
        i += 1;
      }
    }
    UnfamiliarContactDetailUI.b(this.qLi).clear();
    if (UnfamiliarContactDetailUI.b(this.qLi).size() > 0)
    {
      UnfamiliarContactDetailUI.d(this.qLi).setEnabled(true);
      UnfamiliarContactDetailUI.c(this.qLi).setEnabled(true);
    }
    for (;;)
    {
      UnfamiliarContactDetailUI.j(this.qLi).post(new UnfamiliarContactDetailUI.9.1(this));
      AppMethodBeat.o(127646);
      return;
      UnfamiliarContactDetailUI.d(this.qLi).setEnabled(false);
      UnfamiliarContactDetailUI.c(this.qLi).setEnabled(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.9
 * JD-Core Version:    0.7.0.1
 */