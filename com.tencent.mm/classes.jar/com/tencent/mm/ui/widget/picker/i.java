package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker.Formatter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Formatter;
import java.util.Locale;

final class i
  implements NumberPicker.Formatter
{
  final Object[] LxM;
  char LxN;
  Formatter LxO;
  final StringBuilder mBuilder;
  
  i()
  {
    AppMethodBeat.i(159590);
    this.mBuilder = new StringBuilder();
    this.LxM = new Object[1];
    e(Locale.getDefault());
    AppMethodBeat.o(159590);
  }
  
  private void e(Locale paramLocale)
  {
    AppMethodBeat.i(159591);
    this.LxO = f(paramLocale);
    this.LxN = '0';
    AppMethodBeat.o(159591);
  }
  
  private Formatter f(Locale paramLocale)
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
    if (this.LxN != '0') {
      e((Locale)localObject);
    }
    this.LxM[0] = Integer.valueOf(paramInt);
    this.mBuilder.delete(0, this.mBuilder.length());
    this.LxO.format("%02d", this.LxM);
    localObject = this.LxO.toString();
    AppMethodBeat.o(159592);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.i
 * JD-Core Version:    0.7.0.1
 */