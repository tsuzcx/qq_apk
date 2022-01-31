package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.y;

final class FixToolsUplogUI$1
  implements DatePickerDialog.OnDateSetListener
{
  FixToolsUplogUI$1(FixToolsUplogUI paramFixToolsUplogUI, int paramInt, long paramLong) {}
  
  public final void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    switch (this.val$id)
    {
    default: 
      return;
    }
    paramDatePicker = new StringBuffer().append(String.format("%02d", new Object[] { Integer.valueOf(paramInt1) })).append(".").append(String.format("%02d", new Object[] { Integer.valueOf(paramInt2 + 1) })).append(".").append(String.format("%02d", new Object[] { Integer.valueOf(paramInt3) }));
    FixToolsUplogUI.a(this.nRv).setText(paramDatePicker);
    FixToolsUplogUI.Mo(String.format("%02d", new Object[] { Integer.valueOf(paramInt1) }) + String.format("%02d", new Object[] { Integer.valueOf(paramInt2 + 1) }) + String.format("%02d", new Object[] { Integer.valueOf(paramInt3) }));
    y.i("MicroMsg.FixToolsUplogUI", "uplog choose time maxTime[%d], date[%s]", new Object[] { Long.valueOf(this.nRu), FixToolsUplogUI.access$100() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI.1
 * JD-Core Version:    0.7.0.1
 */