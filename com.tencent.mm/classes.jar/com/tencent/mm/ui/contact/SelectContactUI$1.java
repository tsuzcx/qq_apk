package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class SelectContactUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SelectContactUI$1(SelectContactUI paramSelectContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(33850);
    this.Afg.hideVKB();
    this.Afg.finish();
    if (!this.Afg.getIntent().getBooleanExtra("stay_in_wechat", true)) {
      al.p(SelectContactUI.a(this.Afg), 80L);
    }
    AppMethodBeat.o(33850);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.1
 * JD-Core Version:    0.7.0.1
 */