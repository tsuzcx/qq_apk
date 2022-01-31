package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker.Formatter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Formatter;
import java.util.Locale;

final class g
  implements NumberPicker.Formatter
{
  final Object[] AJl;
  char AJm;
  Formatter AJn;
  final StringBuilder mBuilder;
  
  g()
  {
    AppMethodBeat.i(112866);
    this.mBuilder = new StringBuilder();
    this.AJl = new Object[1];
    d(Locale.getDefault());
    AppMethodBeat.o(112866);
  }
  
  private void d(Locale paramLocale)
  {
    AppMethodBeat.i(112867);
    this.AJn = e(paramLocale);
    this.AJm = '0';
    AppMethodBeat.o(112867);
  }
  
  private Formatter e(Locale paramLocale)
  {
    AppMethodBeat.i(112869);
    paramLocale = new Formatter(this.mBuilder, paramLocale);
    AppMethodBeat.o(112869);
    return paramLocale;
  }
  
  public final String format(int paramInt)
  {
    AppMethodBeat.i(112868);
    Object localObject = Locale.getDefault();
    if (this.AJm != '0') {
      d((Locale)localObject);
    }
    this.AJl[0] = Integer.valueOf(paramInt);
    this.mBuilder.delete(0, this.mBuilder.length());
    this.AJn.format("%02d", this.AJl);
    localObject = this.AJn.toString();
    AppMethodBeat.o(112868);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.g
 * JD-Core Version:    0.7.0.1
 */