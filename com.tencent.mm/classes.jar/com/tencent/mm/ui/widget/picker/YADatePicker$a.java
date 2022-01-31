package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import java.util.Locale;

abstract class YADatePicker$a
  implements YADatePicker.b
{
  protected Context mContext;
  protected YADatePicker woP;
  protected Locale woQ;
  protected YADatePicker.d woR;
  protected YADatePicker.e woS;
  
  protected YADatePicker$a(YADatePicker paramYADatePicker, Context paramContext)
  {
    this.woP = paramYADatePicker;
    this.mContext = paramContext;
    e(Locale.getDefault());
  }
  
  protected void e(Locale paramLocale)
  {
    if (!paramLocale.equals(this.woQ)) {
      this.woQ = paramLocale;
    }
  }
  
  public void setValidationCallback(YADatePicker.e parame)
  {
    this.woS = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker.a
 * JD-Core Version:    0.7.0.1
 */