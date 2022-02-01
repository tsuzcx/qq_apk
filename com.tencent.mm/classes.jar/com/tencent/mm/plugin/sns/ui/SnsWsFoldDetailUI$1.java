package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsWsFoldDetailUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SnsWsFoldDetailUI$1(SnsWsFoldDetailUI paramSnsWsFoldDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(308274);
    this.RET.hideVKB();
    this.RET.finish();
    AppMethodBeat.o(308274);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsWsFoldDetailUI.1
 * JD-Core Version:    0.7.0.1
 */