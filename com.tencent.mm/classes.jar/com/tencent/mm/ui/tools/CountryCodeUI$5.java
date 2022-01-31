package com.tencent.mm.ui.tools;

import android.widget.ListView;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.VerticalScrollBar.a;

final class CountryCodeUI$5
  implements VerticalScrollBar.a
{
  CountryCodeUI$5(CountryCodeUI paramCountryCodeUI) {}
  
  public final void eU(String paramString)
  {
    int i = 0;
    if (this.vYt.getString(R.l.scroll_bar_search).equals(paramString)) {
      CountryCodeUI.b(this.vYt).setSelection(0);
    }
    for (;;)
    {
      return;
      int j = Integer.decode(paramString.substring(0, paramString.length() - 1)).intValue();
      paramString = CountryCodeUI.c(this.vYt).luY;
      if (paramString != null) {
        while (i < paramString.length)
        {
          if (paramString[i] == j)
          {
            CountryCodeUI.b(this.vYt).setSelection(i + CountryCodeUI.b(this.vYt).getHeaderViewsCount());
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CountryCodeUI.5
 * JD-Core Version:    0.7.0.1
 */