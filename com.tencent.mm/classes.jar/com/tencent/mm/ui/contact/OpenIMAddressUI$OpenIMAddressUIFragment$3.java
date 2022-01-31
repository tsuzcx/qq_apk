package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.d;

final class OpenIMAddressUI$OpenIMAddressUIFragment$3
  implements n.d
{
  OpenIMAddressUI$OpenIMAddressUIFragment$3(OpenIMAddressUI.OpenIMAddressUIFragment paramOpenIMAddressUIFragment) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(33767);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(33767);
      return;
    case 1: 
    case 2: 
      OpenIMAddressUI.OpenIMAddressUIFragment.a(this.Aes, OpenIMAddressUI.OpenIMAddressUIFragment.j(this.Aes));
      AppMethodBeat.o(33767);
      return;
    }
    OpenIMAddressUI.OpenIMAddressUIFragment.c(this.Aes, OpenIMAddressUI.OpenIMAddressUIFragment.j(this.Aes));
    AppMethodBeat.o(33767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.3
 * JD-Core Version:    0.7.0.1
 */