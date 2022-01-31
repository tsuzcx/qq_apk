package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class ChattingSendDataToDeviceUI$9
  implements Runnable
{
  TextView zBd;
  
  ChattingSendDataToDeviceUI$9(ChattingSendDataToDeviceUI paramChattingSendDataToDeviceUI, String paramString1, String paramString2, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(30771);
    for (;;)
    {
      View localView;
      try
      {
        ChattingSendDataToDeviceUI.c localc = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(this.zAW).get(this.vdy);
        localc.csn = this.lai;
        if (this.gQj > localc.progress) {
          localc.progress = this.gQj;
        }
        int i = ((Integer)ChattingSendDataToDeviceUI.k(this.zAW).get(this.vdy)).intValue();
        localView = (View)ChattingSendDataToDeviceUI.c(this.zAW).get(Integer.valueOf(i));
        ap localap = (ap)localView.getTag();
        if (localap == null)
        {
          ab.w("MicroMsg.ChattingSendDataToDeviceUI", "get view holder is null");
          AppMethodBeat.o(30771);
          return;
        }
        this.zBd = localap.zBd;
        this.zBd.setVisibility(0);
        if (this.lai.equals("send_data_failed"))
        {
          ChattingSendDataToDeviceUI.a(this.zAW, 5);
          this.zBd.setText(this.zAW.getString(2131298318));
          ChattingSendDataToDeviceUI.b(this.zAW).remove(this.vdy);
          this.zBd.setTextColor(this.zAW.getResources().getColor(2131690443));
          ChattingSendDataToDeviceUI.a(false, 0, localView);
          ChattingSendDataToDeviceUI.d(this.zAW).put(localc.deviceID, localc);
          AppMethodBeat.o(30771);
          return;
        }
        if (this.lai.equals("send_data_sending"))
        {
          this.zBd.setText(this.zAW.getString(2131298323));
          this.zBd.setTextColor(this.zAW.getResources().getColor(2131690440));
          ChattingSendDataToDeviceUI.a(true, this.gQj, localView);
          continue;
        }
        if (!this.lai.equals("send_data_cancel")) {
          continue;
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: send Data: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(30771);
        return;
      }
      ChattingSendDataToDeviceUI.a(this.zAW, 6);
      this.zBd.setText(this.zAW.getString(2131298314));
      this.zBd.setTextColor(this.zAW.getResources().getColor(2131690438));
      ChattingSendDataToDeviceUI.a(true, 0, localView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.9
 * JD-Core Version:    0.7.0.1
 */