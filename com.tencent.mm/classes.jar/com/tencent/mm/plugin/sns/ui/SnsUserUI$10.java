package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsUserUI$10
  implements MenuItem.OnMenuItemClickListener
{
  SnsUserUI$10(SnsUserUI paramSnsUserUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(200622);
    this.yXT.finish();
    AppMethodBeat.o(200622);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.10
 * JD-Core Version:    0.7.0.1
 */