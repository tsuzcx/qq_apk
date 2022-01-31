package com.tencent.mm.ui.chatting.b;

import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.x;

final class t$2
  implements View.OnClickListener
{
  t$2(t paramt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {}
  
  public final void onClick(View paramView)
  {
    if (!this.vqY.byx.vtz.isScreenEnable()) {
      y.w("MicroMsg.ChattingUI.HeaderComponent", "Actionbar customView onclick screen not enable");
    }
    while (this.irQ == null) {
      return;
    }
    this.irQ.onMenuItemClick(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.t.2
 * JD-Core Version:    0.7.0.1
 */