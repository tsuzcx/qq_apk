package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsCommentUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SnsCommentUI$3(SnsCommentUI paramSnsCommentUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(38918);
    this.rQs.hideVKB();
    this.rQs.finish();
    AppMethodBeat.o(38918);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentUI.3
 * JD-Core Version:    0.7.0.1
 */