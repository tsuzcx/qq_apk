package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsAddressUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SnsAddressUI$2(SnsAddressUI paramSnsAddressUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(33924);
    this.Afv.finish();
    if (!this.Afv.getIntent().getBooleanExtra("stay_in_wechat", true)) {
      this.Afv.moveTaskToBack(true);
    }
    AppMethodBeat.o(33924);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsAddressUI.2
 * JD-Core Version:    0.7.0.1
 */