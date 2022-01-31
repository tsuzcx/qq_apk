package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class ChattingSendDataToDeviceUI$a$1$2
  implements Runnable
{
  ChattingSendDataToDeviceUI$a$1$2(ChattingSendDataToDeviceUI.a.1 param1) {}
  
  public final void run()
  {
    this.vlH.vlz.vnu.setProgress(0);
    this.vlH.vlz.vnu.setVisibility(4);
    this.vlH.vlz.vlE.setText(this.vlH.vlG.vlx.getText(R.l.chatting_send_failed));
    this.vlH.vlz.vlE.setTextColor(this.vlH.vlG.vlx.getResources().getColor(R.e.send_state_text_failed));
    this.vlH.vlA.bKT = "send_data_failed";
    this.vlH.vlA.progress = 0;
    ChattingSendDataToDeviceUI.d(this.vlH.vlG.vlx).put(this.vlH.vlA.deviceID, this.vlH.vlA);
    y.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_FAILED!", new Object[] { this.vlH.vlA.deviceID });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a.1.2
 * JD-Core Version:    0.7.0.1
 */