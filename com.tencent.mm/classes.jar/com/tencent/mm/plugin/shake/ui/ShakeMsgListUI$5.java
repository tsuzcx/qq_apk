package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.j;

final class ShakeMsgListUI$5
  implements AdapterView.OnItemLongClickListener
{
  ShakeMsgListUI$5(ShakeMsgListUI paramShakeMsgListUI, j paramj) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < ShakeMsgListUI.f(this.obT).getHeaderViewsCount())
    {
      y.w("MicroMsg.ShakeMsgListUI", "on header view long click, ignore");
      return true;
    }
    this.hZt.a(paramView, paramInt, paramLong, this.obT.mController.uMN, ShakeMsgListUI.h(this.obT));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.5
 * JD-Core Version:    0.7.0.1
 */