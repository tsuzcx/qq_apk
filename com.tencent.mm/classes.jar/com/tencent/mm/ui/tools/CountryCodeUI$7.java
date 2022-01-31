package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.at.b.a;

final class CountryCodeUI$7
  implements AdapterView.OnItemClickListener
{
  CountryCodeUI$7(CountryCodeUI paramCountryCodeUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = new Intent();
    if (paramInt >= CountryCodeUI.b(this.vYt).getHeaderViewsCount())
    {
      paramView = (b.a)CountryCodeUI.c(this.vYt).getItem(paramInt - CountryCodeUI.b(this.vYt).getHeaderViewsCount());
      paramAdapterView.putExtra("country_name", paramView.esg);
      paramAdapterView.putExtra("couttry_code", paramView.esf);
      paramAdapterView.putExtra("iso_code", paramView.ese);
      this.vYt.setResult(100, paramAdapterView);
    }
    this.vYt.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CountryCodeUI.7
 * JD-Core Version:    0.7.0.1
 */