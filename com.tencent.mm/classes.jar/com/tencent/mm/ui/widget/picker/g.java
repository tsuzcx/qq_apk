package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker.Formatter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Formatter;
import java.util.Locale;

final class g
  implements NumberPicker.Formatter
{
  Formatter agkA;
  final Object[] agky;
  char agkz;
  final StringBuilder mBuilder;
  
  g()
  {
    AppMethodBeat.i(159590);
    this.mBuilder = new StringBuilder();
    this.agky = new Object[1];
    e(Locale.getDefault());
    AppMethodBeat.o(159590);
  }
  
  private void e(Locale paramLocale)
  {
    AppMethodBeat.i(159591);
    this.agkA = f(paramLocale);
    this.agkz = '0';
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
    if (this.agkz != '0') {
      e((Locale)localObject);
    }
    this.agky[0] = Integer.valueOf(paramInt);
    this.mBuilder.delete(0, this.mBuilder.length());
    this.agkA.format("%02d", this.agky);
    localObject = this.agkA.toString();
    AppMethodBeat.o(159592);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.g
 * JD-Core Version:    0.7.0.1
 */