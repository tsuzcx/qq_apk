package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

final class UnfamiliarContactDetailUI$c$1
  implements View.OnClickListener
{
  UnfamiliarContactDetailUI$c$1(UnfamiliarContactDetailUI.c paramc, UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127658);
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = this.qLv.mCC;
    boolean bool;
    if (!this.qLv.mCC.isChecked())
    {
      bool = true;
      paramView.setChecked(bool);
      if (!this.qLv.mCC.isChecked()) {
        break label130;
      }
      UnfamiliarContactDetailUI.b(this.qLv.qLi).add(Integer.valueOf(i));
    }
    for (;;)
    {
      if (UnfamiliarContactDetailUI.b(this.qLv.qLi).size() != 0) {
        break label151;
      }
      UnfamiliarContactDetailUI.d(this.qLv.qLi).setEnabled(false);
      UnfamiliarContactDetailUI.c(this.qLv.qLi).setEnabled(false);
      AppMethodBeat.o(127658);
      return;
      bool = false;
      break;
      label130:
      UnfamiliarContactDetailUI.b(this.qLv.qLi).remove(Integer.valueOf(i));
    }
    label151:
    UnfamiliarContactDetailUI.d(this.qLv.qLi).setEnabled(true);
    UnfamiliarContactDetailUI.c(this.qLv.qLi).setEnabled(true);
    AppMethodBeat.o(127658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.c.1
 * JD-Core Version:    0.7.0.1
 */