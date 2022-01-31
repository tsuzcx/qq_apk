package com.tencent.mm.ui.tools;

import android.app.TimePickerDialog.OnTimeSetListener;
import android.widget.TextView;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;

final class HardCoderSettingUI$5
  implements TimePickerDialog.OnTimeSetListener
{
  HardCoderSettingUI$5(HardCoderSettingUI paramHardCoderSettingUI) {}
  
  public final void onTimeSet(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34874);
    if (HardCoderSettingUI.s(this.AuJ))
    {
      WXHardCoderJNI.hcBeginTimeHour = paramInt1;
      WXHardCoderJNI.hcBeginTimeMin = paramInt2;
      HardCoderSettingUI.t(this.AuJ).setText(HardCoderSettingUI.i(this.AuJ, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
      AppMethodBeat.o(34874);
      return;
    }
    WXHardCoderJNI.hcEndTimeHour = paramInt1;
    WXHardCoderJNI.hcEndTimeMin = paramInt2;
    HardCoderSettingUI.u(this.AuJ).setText(HardCoderSettingUI.i(this.AuJ, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
    AppMethodBeat.o(34874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.HardCoderSettingUI.5
 * JD-Core Version:    0.7.0.1
 */