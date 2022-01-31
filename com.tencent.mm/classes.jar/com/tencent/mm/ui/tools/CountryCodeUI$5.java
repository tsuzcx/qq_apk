package com.tencent.mm.ui.tools;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.VerticalScrollBar.a;

final class CountryCodeUI$5
  implements VerticalScrollBar.a
{
  CountryCodeUI$5(CountryCodeUI paramCountryCodeUI) {}
  
  public final void lf(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(34804);
    if (this.AqG.getString(2131302955).equals(paramString))
    {
      CountryCodeUI.b(this.AqG).setSelection(0);
      AppMethodBeat.o(34804);
      return;
    }
    int j = Integer.decode(paramString.substring(0, paramString.length() - 1)).intValue();
    paramString = CountryCodeUI.c(this.AqG).nSp;
    if (paramString == null)
    {
      AppMethodBeat.o(34804);
      return;
    }
    do
    {
      i += 1;
      if (i >= paramString.length) {
        break;
      }
    } while (paramString[i] != j);
    CountryCodeUI.b(this.AqG).setSelection(i + CountryCodeUI.b(this.AqG).getHeaderViewsCount());
    AppMethodBeat.o(34804);
    return;
    AppMethodBeat.o(34804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CountryCodeUI.5
 * JD-Core Version:    0.7.0.1
 */