package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class ComposeUI$10
  implements MenuItem.OnMenuItemClickListener
{
  ComposeUI$10(ComposeUI paramComposeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(68179);
    if (((ComposeUI.a(this.pLX, false)) && (ComposeUI.a(this.pLX) == 5)) || (ComposeUI.a(this.pLX) == 6)) {
      h.d(this.pLX.getContext(), this.pLX.getString(2131302130), "", this.pLX.getString(2131302132), this.pLX.getString(2131296888), new ComposeUI.10.1(this), null);
    }
    for (;;)
    {
      AppMethodBeat.o(68179);
      return true;
      this.pLX.setResult(0);
      this.pLX.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.10
 * JD-Core Version:    0.7.0.1
 */