package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;

final class b$4
  implements MenuItem.OnMenuItemClickListener
{
  b$4(b paramb) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(153580);
    this.pDl.pDe.onBackPressed();
    AppMethodBeat.o(153580);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.4
 * JD-Core Version:    0.7.0.1
 */