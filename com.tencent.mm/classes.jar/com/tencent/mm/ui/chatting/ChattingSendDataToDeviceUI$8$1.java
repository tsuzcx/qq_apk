package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

final class ChattingSendDataToDeviceUI$8$1
  implements Runnable
{
  ChattingSendDataToDeviceUI$8$1(ChattingSendDataToDeviceUI.8 param8) {}
  
  public final void run()
  {
    AppMethodBeat.i(30769);
    this.zBc.zAY.zCQ.Px(0);
    ChattingSendDataToDeviceUI.b(this.zBc.zAW).remove(this.zBc.vdy);
    this.zBc.zAY.zCQ.setVisibility(4);
    this.zBc.zAY.zBd.setText(this.zBc.zAW.getText(2131298321));
    this.zBc.zAY.zBd.setTextColor(this.zBc.zAW.getResources().getColor(2131690440));
    this.zBc.zAZ.csn = "send_data_sucess";
    this.zBc.zAZ.progress = 0;
    ChattingSendDataToDeviceUI.a(this.zBc.zAW, 4);
    AppMethodBeat.o(30769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.8.1
 * JD-Core Version:    0.7.0.1
 */