package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;

final class ChattingSendDataToDeviceUI$7
  implements Runnable
{
  ChattingSendDataToDeviceUI$7(ChattingSendDataToDeviceUI paramChattingSendDataToDeviceUI, as paramas, ChattingSendDataToDeviceUI.c paramc) {}
  
  public final void run()
  {
    this.vlz.vnu.setVisibility(0);
    this.vlz.vlE.setTextColor(this.vlx.getResources().getColor(R.e.send_data_sending));
    this.vlz.vlE.setText(this.vlx.getText(R.l.chatting_sending));
    this.vlA.bKT = "send_data_sending";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.7
 * JD-Core Version:    0.7.0.1
 */