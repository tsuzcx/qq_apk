package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class SelectContactUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SelectContactUI$2(SelectContactUI paramSelectContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(33851);
    paramMenuItem = SelectContactUI.c(this.Afg, t.hI(SelectContactUI.b(this.Afg), 8192));
    paramMenuItem.remove(r.Zn());
    if ((t.hI(SelectContactUI.b(this.Afg), 4096)) && (paramMenuItem.size() > 1)) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (!SelectContactUI.e(this.Afg))
      {
        SelectContactUI.d(this.Afg, true);
        SelectContactUI.f(this.Afg);
      }
      ab.i("MicroMsg.SelectContactUI", "Create the chatroom");
      AppMethodBeat.o(33851);
      return true;
    }
    boolean bool = SelectContactUI.b(this.Afg, SelectContactUI.a(this.Afg, t.hI(SelectContactUI.b(this.Afg), 8192)));
    AppMethodBeat.o(33851);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.2
 * JD-Core Version:    0.7.0.1
 */