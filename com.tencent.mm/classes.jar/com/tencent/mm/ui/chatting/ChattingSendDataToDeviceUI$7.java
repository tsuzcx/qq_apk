package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChattingSendDataToDeviceUI$7
  implements Runnable
{
  ChattingSendDataToDeviceUI$7(ChattingSendDataToDeviceUI paramChattingSendDataToDeviceUI, ap paramap, ChattingSendDataToDeviceUI.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(30768);
    this.zAY.zCQ.setVisibility(0);
    this.zAY.zBd.setTextColor(this.zAW.getResources().getColor(2131690440));
    this.zAY.zBd.setText(this.zAW.getText(2131298323));
    this.zAZ.csn = "send_data_sending";
    AppMethodBeat.o(30768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.7
 * JD-Core Version:    0.7.0.1
 */