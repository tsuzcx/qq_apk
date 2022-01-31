package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import java.util.HashSet;

final class UnfamiliarContactDetailUI$c$1
  implements View.OnClickListener
{
  UnfamiliarContactDetailUI$c$1(UnfamiliarContactDetailUI.c paramc, UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = this.nXl.khV;
    boolean bool;
    if (!this.nXl.khV.isChecked())
    {
      bool = true;
      paramView.setChecked(bool);
      if (!this.nXl.khV.isChecked()) {
        break label120;
      }
      UnfamiliarContactDetailUI.b(this.nXl.nWX).add(Integer.valueOf(i));
    }
    for (;;)
    {
      if (UnfamiliarContactDetailUI.b(this.nXl.nWX).size() != 0) {
        break label141;
      }
      UnfamiliarContactDetailUI.d(this.nXl.nWX).setEnabled(false);
      UnfamiliarContactDetailUI.c(this.nXl.nWX).setEnabled(false);
      return;
      bool = false;
      break;
      label120:
      UnfamiliarContactDetailUI.b(this.nXl.nWX).remove(Integer.valueOf(i));
    }
    label141:
    UnfamiliarContactDetailUI.d(this.nXl.nWX).setEnabled(true);
    UnfamiliarContactDetailUI.c(this.nXl.nWX).setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.c.1
 * JD-Core Version:    0.7.0.1
 */