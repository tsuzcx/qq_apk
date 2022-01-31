package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import java.util.HashMap;

final class ChattingSendDataToDeviceUI$8$1
  implements Runnable
{
  ChattingSendDataToDeviceUI$8$1(ChattingSendDataToDeviceUI.8 param8) {}
  
  public final void run()
  {
    this.vlD.vlz.vnu.setProgress(0);
    ChattingSendDataToDeviceUI.b(this.vlD.vlx).remove(this.vlD.rpN);
    this.vlD.vlz.vnu.setVisibility(4);
    this.vlD.vlz.vlE.setText(this.vlD.vlx.getText(R.l.chatting_send_success));
    this.vlD.vlz.vlE.setTextColor(this.vlD.vlx.getResources().getColor(R.e.send_data_sending));
    this.vlD.vlA.bKT = "send_data_sucess";
    this.vlD.vlA.progress = 0;
    ChattingSendDataToDeviceUI.a(this.vlD.vlx, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.8.1
 * JD-Core Version:    0.7.0.1
 */