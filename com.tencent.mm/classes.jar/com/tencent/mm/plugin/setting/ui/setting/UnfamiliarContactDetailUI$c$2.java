package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class UnfamiliarContactDetailUI$c$2
  implements View.OnClickListener
{
  UnfamiliarContactDetailUI$c$2(UnfamiliarContactDetailUI.c paramc, UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = UnfamiliarContactDetailUI.e(this.nXl.nWX).xi(i);
    y.i("MicroMsg.UnfamiliarContactUI", "position:%s", new Object[] { Integer.valueOf(i), paramView.dtK });
    UnfamiliarContactDetailUI.c.a(this.nXl, paramView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.c.2
 * JD-Core Version:    0.7.0.1
 */