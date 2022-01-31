package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

final class ShakeMsgListUI$3
  implements View.OnClickListener
{
  ShakeMsgListUI$3(ShakeMsgListUI paramShakeMsgListUI, View paramView) {}
  
  public final void onClick(View paramView)
  {
    ShakeMsgListUI.a(this.obT, ShakeMsgListUI.d(this.obT) + 8);
    ShakeMsgListUI.b(this.obT).xp(ShakeMsgListUI.d(this.obT));
    if (ShakeMsgListUI.e(this.obT) <= ShakeMsgListUI.d(this.obT)) {
      ShakeMsgListUI.f(this.obT).removeFooterView(this.mDO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.3
 * JD-Core Version:    0.7.0.1
 */