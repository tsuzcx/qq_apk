package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.plugin.setting.a.f;
import java.util.ArrayList;
import java.util.HashSet;

final class UnfamiliarContactDetailUI$9
  implements View.OnClickListener
{
  UnfamiliarContactDetailUI$9(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = (CheckBox)UnfamiliarContactDetailUI.i(this.nWX).findViewById(a.f.checkbox);
    if (!paramView.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      if (!paramView.isChecked()) {
        break;
      }
      int i = 0;
      while (i < UnfamiliarContactDetailUI.f(this.nWX).size())
      {
        UnfamiliarContactDetailUI.b(this.nWX).add(Integer.valueOf(i));
        i += 1;
      }
    }
    UnfamiliarContactDetailUI.b(this.nWX).clear();
    if (UnfamiliarContactDetailUI.b(this.nWX).size() > 0)
    {
      UnfamiliarContactDetailUI.d(this.nWX).setEnabled(true);
      UnfamiliarContactDetailUI.c(this.nWX).setEnabled(true);
    }
    for (;;)
    {
      UnfamiliarContactDetailUI.j(this.nWX).post(new Runnable()
      {
        public final void run()
        {
          UnfamiliarContactDetailUI.e(UnfamiliarContactDetailUI.9.this.nWX).agL.notifyChanged();
        }
      });
      return;
      UnfamiliarContactDetailUI.d(this.nWX).setEnabled(false);
      UnfamiliarContactDetailUI.c(this.nWX).setEnabled(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.9
 * JD-Core Version:    0.7.0.1
 */