package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker.Formatter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Formatter;
import java.util.Locale;

final class i
  implements NumberPicker.Formatter
{
  final Object[] QTB;
  char QTC;
  Formatter QTD;
  final StringBuilder mBuilder;
  
  i()
  {
    AppMethodBeat.i(159590);
    this.mBuilder = new StringBuilder();
    this.QTB = new Object[1];
    d(Locale.getDefault());
    AppMethodBeat.o(159590);
  }
  
  private void d(Locale paramLocale)
  {
    AppMethodBeat.i(159591);
    this.QTD = e(paramLocale);
    this.QTC = '0';
    AppMethodBeat.o(159591);
  }
  
  private Formatter e(Locale paramLocale)
  {
    AppMethodBeat.i(159593);
    paramLocale = new Formatter(this.mBuilder, paramLocale);
    AppMethodBeat.o(159593);
    return paramLocale;
  }
  
  public final String format(int paramInt)
  {
    AppMethodBeat.i(159592);
    Object localObject = Locale.getDefault();
    if (this.QTC != '0') {
      d((Locale)localObject);
    }
    this.QTB[0] = Integer.valueOf(paramInt);
    this.mBuilder.delete(0, this.mBuilder.length());
    this.QTD.format("%02d", this.QTB);
    localObject = this.QTD.toString();
    AppMethodBeat.o(159592);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.i
 * JD-Core Version:    0.7.0.1
 */