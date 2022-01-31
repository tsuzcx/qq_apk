package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;

final class YADatePicker$c$1
  implements NumberPicker.OnValueChangeListener
{
  YADatePicker$c$1(YADatePicker.c paramc) {}
  
  public final void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112870);
    YADatePicker.c.a(this.AJH);
    this.AJH.jsh.setTimeInMillis(this.AJH.AJF.getTimeInMillis());
    int i;
    if (paramNumberPicker == this.AJH.AJt)
    {
      i = this.AJH.jsh.getActualMaximum(5);
      if ((paramInt1 == i) && (paramInt2 == 1)) {
        this.AJH.jsh.add(5, 1);
      }
    }
    for (;;)
    {
      this.AJH.aD(this.AJH.jsh.get(1), this.AJH.jsh.get(2), this.AJH.jsh.get(5));
      this.AJH.dPw();
      this.AJH.dPx();
      YADatePicker.c.b(this.AJH);
      AppMethodBeat.o(112870);
      return;
      if ((paramInt1 == 1) && (paramInt2 == i))
      {
        this.AJH.jsh.add(5, -1);
      }
      else
      {
        this.AJH.jsh.add(5, paramInt2 - paramInt1);
        continue;
        if (paramNumberPicker == this.AJH.AJu)
        {
          if ((paramInt1 == 11) && (paramInt2 == 0)) {
            this.AJH.jsh.add(2, 1);
          } else if ((paramInt1 == 0) && (paramInt2 == 11)) {
            this.AJH.jsh.add(2, -1);
          } else {
            this.AJH.jsh.add(2, paramInt2 - paramInt1);
          }
        }
        else
        {
          if (paramNumberPicker != this.AJH.AJv) {
            break;
          }
          this.AJH.jsh.set(1, paramInt2);
        }
      }
    }
    paramNumberPicker = new IllegalArgumentException();
    AppMethodBeat.o(112870);
    throw paramNumberPicker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker.c.1
 * JD-Core Version:    0.7.0.1
 */