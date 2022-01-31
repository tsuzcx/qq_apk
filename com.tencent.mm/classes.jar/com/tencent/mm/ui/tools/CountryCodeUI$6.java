package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class CountryCodeUI$6
  implements MenuItem.OnMenuItemClickListener
{
  CountryCodeUI$6(CountryCodeUI paramCountryCodeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.vYt.XM();
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("country_name", CountryCodeUI.d(this.vYt));
    paramMenuItem.putExtra("couttry_code", CountryCodeUI.e(this.vYt));
    paramMenuItem.putExtra("iso_code", CountryCodeUI.f(this.vYt));
    this.vYt.setResult(100, paramMenuItem);
    this.vYt.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CountryCodeUI.6
 * JD-Core Version:    0.7.0.1
 */