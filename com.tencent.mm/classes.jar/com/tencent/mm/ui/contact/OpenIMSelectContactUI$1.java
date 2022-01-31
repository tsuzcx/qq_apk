package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import java.util.ArrayList;
import java.util.List;

final class OpenIMSelectContactUI$1
  implements MenuItem.OnMenuItemClickListener
{
  OpenIMSelectContactUI$1(OpenIMSelectContactUI paramOpenIMSelectContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(33824);
    paramMenuItem = OpenIMSelectContactUI.a(this.AeG, t.hI(OpenIMSelectContactUI.a(this.AeG), 8192));
    paramMenuItem.remove(r.Zn());
    ArrayList localArrayList = new ArrayList(OpenIMSelectContactUI.b(this.AeG));
    localArrayList.removeAll(paramMenuItem);
    boolean bool = OpenIMSelectContactUI.a(this.AeG, paramMenuItem, localArrayList);
    AppMethodBeat.o(33824);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMSelectContactUI.1
 * JD-Core Version:    0.7.0.1
 */