package com.tencent.mm.ui.tools;

import android.app.TimePickerDialog.OnTimeSetListener;
import android.widget.TextView;
import android.widget.TimePicker;
import com.tencent.mm.hardcoder.WXHardCoderJNI;

final class HardCoderSettingUI$5
  implements TimePickerDialog.OnTimeSetListener
{
  HardCoderSettingUI$5(HardCoderSettingUI paramHardCoderSettingUI) {}
  
  public final void onTimeSet(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    if (HardCoderSettingUI.s(this.wcp))
    {
      WXHardCoderJNI.hcBeginTimeHour = paramInt1;
      WXHardCoderJNI.hcBeginTimeMin = paramInt2;
      HardCoderSettingUI.t(this.wcp).setText(HardCoderSettingUI.i(this.wcp, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
      return;
    }
    WXHardCoderJNI.hcEndTimeHour = paramInt1;
    WXHardCoderJNI.hcEndTimeMin = paramInt2;
    HardCoderSettingUI.u(this.wcp).setText(HardCoderSettingUI.i(this.wcp, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.HardCoderSettingUI.5
 * JD-Core Version:    0.7.0.1
 */