package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;

final class ShakeSayHiListUI$1
  implements View.OnClickListener
{
  ShakeSayHiListUI$1(ShakeSayHiListUI paramShakeSayHiListUI, View paramView) {}
  
  public final void onClick(View paramView)
  {
    ShakeSayHiListUI.a(this.odv, ShakeSayHiListUI.a(this.odv) + 8);
    y.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + ShakeSayHiListUI.a(this.odv));
    ShakeSayHiListUI.b(this.odv).xp(ShakeSayHiListUI.a(this.odv));
    if (ShakeSayHiListUI.c(this.odv) <= ShakeSayHiListUI.a(this.odv))
    {
      ShakeSayHiListUI.d(this.odv).removeFooterView(this.mDO);
      y.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + ShakeSayHiListUI.a(this.odv));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.1
 * JD-Core Version:    0.7.0.1
 */