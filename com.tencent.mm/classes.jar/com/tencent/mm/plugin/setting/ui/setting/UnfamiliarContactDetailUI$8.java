package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.a.d;

final class UnfamiliarContactDetailUI$8
  implements View.OnClickListener
{
  UnfamiliarContactDetailUI$8(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new d(this.nWX, 1, false);
    paramView.phH = new UnfamiliarContactDetailUI.8.1(this);
    paramView.phI = new UnfamiliarContactDetailUI.8.2(this);
    paramView.cfU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.8
 * JD-Core Version:    0.7.0.1
 */