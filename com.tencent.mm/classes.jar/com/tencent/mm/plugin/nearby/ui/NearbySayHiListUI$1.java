package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;

final class NearbySayHiListUI$1
  implements View.OnClickListener
{
  NearbySayHiListUI$1(NearbySayHiListUI paramNearbySayHiListUI, View paramView) {}
  
  public final void onClick(View paramView)
  {
    NearbySayHiListUI.a(this.mDP, NearbySayHiListUI.a(this.mDP) + 8);
    y.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + NearbySayHiListUI.a(this.mDP));
    paramView = NearbySayHiListUI.b(this.mDP);
    int i = NearbySayHiListUI.a(this.mDP);
    paramView.bcS();
    paramView.limit = i;
    paramView.yc();
    if (NearbySayHiListUI.c(this.mDP) <= NearbySayHiListUI.a(this.mDP))
    {
      NearbySayHiListUI.d(this.mDP).removeFooterView(this.mDO);
      y.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + NearbySayHiListUI.a(this.mDP));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.1
 * JD-Core Version:    0.7.0.1
 */