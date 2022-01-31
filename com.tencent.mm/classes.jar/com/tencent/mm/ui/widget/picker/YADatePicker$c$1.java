package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import java.util.Calendar;

final class YADatePicker$c$1
  implements NumberPicker.OnValueChangeListener
{
  YADatePicker$c$1(YADatePicker.c paramc) {}
  
  public final void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    YADatePicker.c.a(this.wph);
    this.wph.hzR.setTimeInMillis(this.wph.wpf.getTimeInMillis());
    int i;
    if (paramNumberPicker == this.wph.woT)
    {
      i = this.wph.hzR.getActualMaximum(5);
      if ((paramInt1 == i) && (paramInt2 == 1)) {
        this.wph.hzR.add(5, 1);
      }
    }
    for (;;)
    {
      this.wph.ar(this.wph.hzR.get(1), this.wph.hzR.get(2), this.wph.hzR.get(5));
      this.wph.cKr();
      this.wph.cKs();
      YADatePicker.c.b(this.wph);
      return;
      if ((paramInt1 == 1) && (paramInt2 == i))
      {
        this.wph.hzR.add(5, -1);
      }
      else
      {
        this.wph.hzR.add(5, paramInt2 - paramInt1);
        continue;
        if (paramNumberPicker == this.wph.woU)
        {
          if ((paramInt1 == 11) && (paramInt2 == 0)) {
            this.wph.hzR.add(2, 1);
          } else if ((paramInt1 == 0) && (paramInt2 == 11)) {
            this.wph.hzR.add(2, -1);
          } else {
            this.wph.hzR.add(2, paramInt2 - paramInt1);
          }
        }
        else
        {
          if (paramNumberPicker != this.wph.woV) {
            break;
          }
          this.wph.hzR.set(1, paramInt2);
        }
      }
    }
    throw new IllegalArgumentException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker.c.1
 * JD-Core Version:    0.7.0.1
 */