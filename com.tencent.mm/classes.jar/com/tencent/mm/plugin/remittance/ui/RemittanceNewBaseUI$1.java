package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.ac;

final class RemittanceNewBaseUI$1
  implements MenuItem.OnMenuItemClickListener
{
  RemittanceNewBaseUI$1(RemittanceNewBaseUI paramRemittanceNewBaseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(142226);
    if ((this.qqR.mScene == 1) || (this.qqR.mScene == 6))
    {
      this.qqR.chf();
      this.qqR.finish();
    }
    for (;;)
    {
      AppMethodBeat.o(142226);
      return true;
      if ((this.qqR.mScene == 2) || (this.qqR.mScene == 5))
      {
        this.qqR.finish();
      }
      else
      {
        paramMenuItem = this.qqR;
        Intent localIntent = new Intent();
        localIntent.putExtra("recent_remittance_contact_list", ac.cgX());
        localIntent.setClass(paramMenuItem.getContext(), SelectRemittanceContactUI.class);
        paramMenuItem.startActivityForResult(localIntent, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.1
 * JD-Core Version:    0.7.0.1
 */