package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ChattingSendDataToDeviceUI$a$1
  implements Runnable
{
  ChattingSendDataToDeviceUI$a$1(ChattingSendDataToDeviceUI.a parama, int paramInt1, ChattingSendDataToDeviceUI.c paramc, ap paramap, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(30776);
    int i = this.zBa + 1;
    int j;
    while (this.zBf.zAW.zAN)
    {
      if (i >= 100) {
        j = i;
      }
      try
      {
        if (this.zAZ.csn.equals("send_data_sucess"))
        {
          j = i;
          this.zBf.zAW.runOnUiThread(new ChattingSendDataToDeviceUI.a.1.1(this));
          AppMethodBeat.o(30776);
          return;
        }
        j = i;
        if (!this.zAZ.csn.equals("send_data_failed")) {
          continue;
        }
        j = i;
        this.zBf.zAW.runOnUiThread(new ChattingSendDataToDeviceUI.a.1.2(this));
        AppMethodBeat.o(30776);
        return;
      }
      catch (Exception localException)
      {
        ab.d("MicroMsg.ChattingSendDataToDeviceUI", "setSendingProgress exception %s", new Object[] { localException });
        i = j;
      }
      j = i;
      this.zAY.zCQ.Px(i);
      j = i;
      this.zAZ.progress = i;
      i += 1;
      j = i;
      Thread.sleep(this.zBb);
    }
    AppMethodBeat.o(30776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a.1
 * JD-Core Version:    0.7.0.1
 */