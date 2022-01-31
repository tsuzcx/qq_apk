package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b.a;

final class CountryCodeUI$7
  implements AdapterView.OnItemClickListener
{
  CountryCodeUI$7(CountryCodeUI paramCountryCodeUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(34806);
    paramAdapterView = new Intent();
    if (paramInt >= CountryCodeUI.b(this.AqG).getHeaderViewsCount())
    {
      paramView = (b.a)CountryCodeUI.c(this.AqG).getItem(paramInt - CountryCodeUI.b(this.AqG).getHeaderViewsCount());
      paramAdapterView.putExtra("country_name", paramView.fHT);
      paramAdapterView.putExtra("couttry_code", paramView.fHS);
      paramAdapterView.putExtra("iso_code", paramView.fHR);
      this.AqG.setResult(100, paramAdapterView);
    }
    this.AqG.finish();
    AppMethodBeat.o(34806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CountryCodeUI.7
 * JD-Core Version:    0.7.0.1
 */