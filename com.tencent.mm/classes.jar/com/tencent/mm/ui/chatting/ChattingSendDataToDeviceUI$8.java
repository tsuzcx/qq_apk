package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ChattingSendDataToDeviceUI$8
  implements Runnable
{
  ChattingSendDataToDeviceUI$8(ChattingSendDataToDeviceUI paramChattingSendDataToDeviceUI, int paramInt1, ap paramap, String paramString, ChattingSendDataToDeviceUI.c paramc, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(30770);
    int i = this.zBa + 1;
    int j;
    for (;;)
    {
      if (i >= 100) {
        j = i;
      }
      try
      {
        this.zAW.runOnUiThread(new ChattingSendDataToDeviceUI.8.1(this));
        AppMethodBeat.o(30770);
        return;
      }
      catch (Exception localException)
      {
        ab.d("MicroMsg.ChattingSendDataToDeviceUI", "setProgress on progress view exception %s", new Object[] { localException });
        i = j;
      }
      j = i;
      this.zAY.zCQ.Px(i);
      i += 1;
      j = i;
      Thread.sleep(this.zBb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.8
 * JD-Core Version:    0.7.0.1
 */