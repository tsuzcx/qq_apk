package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class ChattingSendDataToDeviceUI$a$1$2
  implements Runnable
{
  ChattingSendDataToDeviceUI$a$1$2(ChattingSendDataToDeviceUI.a.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(30775);
    this.zBg.zAY.zCQ.Px(0);
    this.zBg.zAY.zCQ.setVisibility(4);
    this.zBg.zAY.zBd.setText(this.zBg.zBf.zAW.getText(2131298318));
    this.zBg.zAY.zBd.setTextColor(this.zBg.zBf.zAW.getResources().getColor(2131690443));
    this.zBg.zAZ.csn = "send_data_failed";
    this.zBg.zAZ.progress = 0;
    ChattingSendDataToDeviceUI.d(this.zBg.zBf.zAW).put(this.zBg.zAZ.deviceID, this.zBg.zAZ);
    ab.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_FAILED!", new Object[] { this.zBg.zAZ.deviceID });
    AppMethodBeat.o(30775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a.1.2
 * JD-Core Version:    0.7.0.1
 */