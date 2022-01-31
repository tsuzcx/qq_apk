package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class ChattingSendDataToDeviceUI$9
  implements Runnable
{
  TextView vlE;
  
  ChattingSendDataToDeviceUI$9(ChattingSendDataToDeviceUI paramChattingSendDataToDeviceUI, String paramString1, String paramString2, int paramInt) {}
  
  public final void run()
  {
    for (;;)
    {
      View localView;
      try
      {
        ChattingSendDataToDeviceUI.c localc = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(this.vlx).get(this.rpN);
        localc.bKT = this.iRA;
        if (this.fyT > localc.progress) {
          localc.progress = this.fyT;
        }
        int i = ((Integer)ChattingSendDataToDeviceUI.k(this.vlx).get(this.rpN)).intValue();
        localView = (View)ChattingSendDataToDeviceUI.c(this.vlx).get(Integer.valueOf(i));
        as localas = (as)localView.getTag();
        if (localas == null)
        {
          y.w("MicroMsg.ChattingSendDataToDeviceUI", "get view holder is null");
          return;
        }
        this.vlE = localas.vlE;
        this.vlE.setVisibility(0);
        if (this.iRA.equals("send_data_failed"))
        {
          ChattingSendDataToDeviceUI.a(this.vlx, 5);
          this.vlE.setText(this.vlx.getString(R.l.chatting_send_failed));
          ChattingSendDataToDeviceUI.b(this.vlx).remove(this.rpN);
          this.vlE.setTextColor(this.vlx.getResources().getColor(R.e.send_state_text_failed));
          ChattingSendDataToDeviceUI.a(false, 0, localView);
          ChattingSendDataToDeviceUI.d(this.vlx).put(localc.deviceID, localc);
          return;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: send Data: %s", new Object[] { localException.getMessage() });
        return;
      }
      if (this.iRA.equals("send_data_sending"))
      {
        this.vlE.setText(this.vlx.getString(R.l.chatting_sending));
        this.vlE.setTextColor(this.vlx.getResources().getColor(R.e.send_data_sending));
        ChattingSendDataToDeviceUI.a(true, this.fyT, localView);
      }
      else if (this.iRA.equals("send_data_cancel"))
      {
        ChattingSendDataToDeviceUI.a(this.vlx, 6);
        this.vlE.setText(this.vlx.getString(R.l.chatting_send_cancel));
        this.vlE.setTextColor(this.vlx.getResources().getColor(R.e.send_data_cancel));
        ChattingSendDataToDeviceUI.a(true, 0, localView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.9
 * JD-Core Version:    0.7.0.1
 */