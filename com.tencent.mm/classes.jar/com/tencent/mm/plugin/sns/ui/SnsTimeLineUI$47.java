package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsTimeLineUI$47
  implements MenuItem.OnMenuItemClickListener
{
  SnsTimeLineUI$47(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(155757);
    this.rYv.hideVKB();
    this.rYv.finish();
    AppMethodBeat.o(155757);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.47
 * JD-Core Version:    0.7.0.1
 */