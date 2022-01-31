package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.db;
import com.tencent.mm.h.a.eh;
import com.tencent.mm.h.a.eh.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class ChattingSendDataToDeviceUI$1
  implements AdapterView.OnItemClickListener
{
  ChattingSendDataToDeviceUI$1(ChattingSendDataToDeviceUI paramChattingSendDataToDeviceUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.vlx.vlm = true;
    ChattingSendDataToDeviceUI.c localc = ChattingSendDataToDeviceUI.a(this.vlx).GS(paramInt);
    String str1 = localc.bJp;
    paramAdapterView = localc.deviceID;
    String str2 = localc.bKO;
    for (;;)
    {
      try
      {
        if (ChattingSendDataToDeviceUI.b(this.vlx).get(paramAdapterView) != null)
        {
          y.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: some file is sending");
          paramView = new db();
          paramView.bJl.bwK = paramAdapterView;
          a.udP.m(paramView);
          ChattingSendDataToDeviceUI.a(this.vlx, "send_data_cancel", paramAdapterView, 0);
          localc.bKT = "send_data_cancel";
          ChattingSendDataToDeviceUI.b(this.vlx).remove(paramAdapterView);
          paramAdapterView = (as)((View)ChattingSendDataToDeviceUI.c(this.vlx).get(Integer.valueOf(paramInt))).getTag();
          paramAdapterView.vlE.setText(this.vlx.getText(R.l.chatting_send_cancel));
          paramAdapterView.vlE.setTextColor(this.vlx.getResources().getColor(R.e.send_data_cancel));
          paramAdapterView.vnu.setVisibility(8);
          paramAdapterView.vnu.setProgress(0);
          return;
        }
        localc.bKT = "send_data_sending";
        ChattingSendDataToDeviceUI.d(this.vlx).put(localc.deviceID, localc);
        ChattingSendDataToDeviceUI.b(this.vlx).put(paramAdapterView, paramView);
        ChattingSendDataToDeviceUI.a(this.vlx, "send_data_sending", paramAdapterView, 1);
        ChattingSendDataToDeviceUI.a(this.vlx, 3);
        paramView = new eh();
        paramView.bKM.bwK = paramAdapterView;
        paramView.bKM.bJp = str1;
        paramView.bKM.data = ChattingSendDataToDeviceUI.e(this.vlx);
        paramView.bKM.bKO = str2;
        if (this.vlx.bKP)
        {
          paramView.bKM.bJQ = ChattingSendDataToDeviceUI.f(this.vlx);
          paramView.bKM.bKP = this.vlx.bKP;
          a.udP.m(paramView);
          if (paramView.bKN.bKQ) {
            break;
          }
          ChattingSendDataToDeviceUI.adn("send_data_failed");
          y.e("MicroMsg.ChattingSendDataToDeviceUI", " e.result.isSuccess is false, send fail!");
          return;
        }
      }
      catch (Exception paramAdapterView)
      {
        ChattingSendDataToDeviceUI.adn("send_data_failed");
        y.e("MicroMsg.ChattingSendDataToDeviceUI", "send to device item click exception %s", new Object[] { paramAdapterView });
        return;
      }
      paramView.bKM.bIt = ChattingSendDataToDeviceUI.g(this.vlx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.1
 * JD-Core Version:    0.7.0.1
 */