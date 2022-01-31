package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

final class b$1
  implements NumberPicker.OnValueChangeListener
{
  b$1(b paramb) {}
  
  public final void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    b.a(this.wow).setOptionsArray(b.a(this.wow, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b.1
 * JD-Core Version:    0.7.0.1
 */