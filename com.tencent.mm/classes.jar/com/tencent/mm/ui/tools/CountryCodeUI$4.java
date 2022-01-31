package com.tencent.mm.ui.tools;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.VerticalScrollBar.a;

final class CountryCodeUI$4
  implements VerticalScrollBar.a
{
  CountryCodeUI$4(CountryCodeUI paramCountryCodeUI) {}
  
  public final void lf(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(34803);
    int j = paramString.charAt(0);
    if (this.AqG.getString(2131302955).equals(paramString))
    {
      CountryCodeUI.b(this.AqG).setSelection(0);
      AppMethodBeat.o(34803);
      return;
    }
    paramString = CountryCodeUI.c(this.AqG).nSp;
    if (paramString == null)
    {
      AppMethodBeat.o(34803);
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
    AppMethodBeat.o(34803);
    return;
    AppMethodBeat.o(34803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CountryCodeUI.4
 * JD-Core Version:    0.7.0.1
 */