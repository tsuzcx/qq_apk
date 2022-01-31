package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class SnsMsgUI$11
  implements MenuItem.OnMenuItemClickListener
{
  SnsMsgUI$11(SnsMsgUI paramSnsMsgUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(39077);
    h.a(this.rSU.getContext(), this.rSU.getString(2131303901), "", new SnsMsgUI.11.1(this), null);
    AppMethodBeat.o(39077);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.11
 * JD-Core Version:    0.7.0.1
 */