package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class ShakeMsgListUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ShakeMsgListUI$2(ShakeMsgListUI paramShakeMsgListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24753);
    h.a(this.qQa.getContext(), true, this.qQa.getString(2131303608), "", this.qQa.getString(2131302874), this.qQa.getString(2131296888), new ShakeMsgListUI.2.1(this), new ShakeMsgListUI.2.2(this));
    AppMethodBeat.o(24753);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.2
 * JD-Core Version:    0.7.0.1
 */