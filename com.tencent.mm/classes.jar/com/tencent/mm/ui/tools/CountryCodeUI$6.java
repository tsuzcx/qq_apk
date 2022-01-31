package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CountryCodeUI$6
  implements MenuItem.OnMenuItemClickListener
{
  CountryCodeUI$6(CountryCodeUI paramCountryCodeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(34805);
    this.AqG.hideVKB();
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("country_name", CountryCodeUI.d(this.AqG));
    paramMenuItem.putExtra("couttry_code", CountryCodeUI.e(this.AqG));
    paramMenuItem.putExtra("iso_code", CountryCodeUI.f(this.AqG));
    this.AqG.setResult(100, paramMenuItem);
    this.AqG.finish();
    AppMethodBeat.o(34805);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CountryCodeUI.6
 * JD-Core Version:    0.7.0.1
 */