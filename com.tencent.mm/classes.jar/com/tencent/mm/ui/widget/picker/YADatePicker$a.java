package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import java.util.Locale;

abstract class YADatePicker$a
  implements YADatePicker.b
{
  protected YADatePicker AJp;
  protected Locale AJq;
  protected YADatePicker.d AJr;
  protected YADatePicker.e AJs;
  protected Context mContext;
  
  protected YADatePicker$a(YADatePicker paramYADatePicker, Context paramContext)
  {
    this.AJp = paramYADatePicker;
    this.mContext = paramContext;
    f(Locale.getDefault());
  }
  
  protected void f(Locale paramLocale)
  {
    if (!paramLocale.equals(this.AJq)) {
      this.AJq = paramLocale;
    }
  }
  
  public void setValidationCallback(YADatePicker.e parame)
  {
    this.AJs = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker.a
 * JD-Core Version:    0.7.0.1
 */