package com.tencent.mm.ui.chatting.view;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.picker.OptionPicker;
import java.util.Calendar;

final class b$2
  implements NumberPicker.OnValueChangeListener
{
  b$2(b paramb) {}
  
  public final void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32777);
    ab.d("MicroMsg.MMRemindDatePicker", "[onValueChange] oldVal:%s newVal:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.zRe.zQZ.setOptionsArray(this.zRe.Qq(paramInt2));
    paramInt1 = Calendar.getInstance().get(11);
    if (paramInt2 == 0)
    {
      this.zRe.zQZ.setValue(0);
      AppMethodBeat.o(32777);
      return;
    }
    this.zRe.zQZ.setValue(paramInt1);
    AppMethodBeat.o(32777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.b.2
 * JD-Core Version:    0.7.0.1
 */