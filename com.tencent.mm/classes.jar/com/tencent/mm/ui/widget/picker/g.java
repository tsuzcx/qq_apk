package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker.Formatter;
import java.util.Formatter;
import java.util.Locale;

final class g
  implements NumberPicker.Formatter
{
  final StringBuilder mBuilder = new StringBuilder();
  final Object[] woL = new Object[1];
  char woM;
  Formatter woN;
  
  g()
  {
    d(Locale.getDefault());
  }
  
  private void d(Locale paramLocale)
  {
    this.woN = new Formatter(this.mBuilder, paramLocale);
    this.woM = '0';
  }
  
  public final String format(int paramInt)
  {
    Locale localLocale = Locale.getDefault();
    if (this.woM != '0') {
      d(localLocale);
    }
    this.woL[0] = Integer.valueOf(paramInt);
    this.mBuilder.delete(0, this.mBuilder.length());
    this.woN.format("%02d", this.woL);
    return this.woN.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.g
 * JD-Core Version:    0.7.0.1
 */