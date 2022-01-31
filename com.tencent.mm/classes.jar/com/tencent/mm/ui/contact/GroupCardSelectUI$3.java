package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class GroupCardSelectUI$3
  implements MenuItem.OnMenuItemClickListener
{
  GroupCardSelectUI$3(GroupCardSelectUI paramGroupCardSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(33730);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("Select_Conv_User", bo.d(GroupCardSelectUI.c(this.AcZ), ","));
    this.AcZ.setResult(-1, paramMenuItem);
    this.AcZ.finish();
    AppMethodBeat.o(33730);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.GroupCardSelectUI.3
 * JD-Core Version:    0.7.0.1
 */