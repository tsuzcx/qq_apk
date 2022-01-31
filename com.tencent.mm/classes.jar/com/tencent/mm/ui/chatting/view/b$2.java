package com.tencent.mm.ui.chatting.view;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.picker.OptionPicker;
import java.util.Calendar;

final class b$2
  implements NumberPicker.OnValueChangeListener
{
  b$2(b paramb) {}
  
  public final void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.MMRemindDatePicker", "[onValueChange] oldVal:%s newVal:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.vAF.vAA.setOptionsArray(this.vAF.HI(paramInt2));
    paramInt1 = Calendar.getInstance().get(11);
    if (paramInt2 == 0)
    {
      this.vAF.vAA.setValue(0);
      return;
    }
    this.vAF.vAA.setValue(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.b.2
 * JD-Core Version:    0.7.0.1
 */