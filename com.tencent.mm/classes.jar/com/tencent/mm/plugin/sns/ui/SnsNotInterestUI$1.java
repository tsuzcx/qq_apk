package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsNotInterestUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SnsNotInterestUI$1(SnsNotInterestUI paramSnsNotInterestUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(39123);
    this.rTQ.finish();
    AppMethodBeat.o(39123);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsNotInterestUI.1
 * JD-Core Version:    0.7.0.1
 */