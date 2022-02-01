package com.tencent.mm.ui.widget.picker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.widget.picker.d.g;
import java.util.Date;

final class CustomDatePickerNew$2
  implements g
{
  CustomDatePickerNew$2(CustomDatePickerNew paramCustomDatePickerNew) {}
  
  public final void a(Date paramDate)
  {
    AppMethodBeat.i(199724);
    CustomDatePickerNew.a(this.Jjf, paramDate);
    an.i("pvTime", "onTimeSelect", new Object[0]);
    AppMethodBeat.o(199724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePickerNew.2
 * JD-Core Version:    0.7.0.1
 */