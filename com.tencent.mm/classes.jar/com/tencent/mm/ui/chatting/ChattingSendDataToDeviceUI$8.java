package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.y;

final class ChattingSendDataToDeviceUI$8
  implements Runnable
{
  ChattingSendDataToDeviceUI$8(ChattingSendDataToDeviceUI paramChattingSendDataToDeviceUI, int paramInt1, as paramas, String paramString, ChattingSendDataToDeviceUI.c paramc, int paramInt2) {}
  
  public final void run()
  {
    int i = this.vlB + 1;
    int j;
    for (;;)
    {
      if (i >= 100) {
        j = i;
      }
      try
      {
        this.vlx.runOnUiThread(new ChattingSendDataToDeviceUI.8.1(this));
        return;
      }
      catch (Exception localException)
      {
        y.d("MicroMsg.ChattingSendDataToDeviceUI", "setProgress on progress view exception %s", new Object[] { localException });
        i = j;
      }
      j = i;
      this.vlz.vnu.setProgress(i);
      i += 1;
      j = i;
      Thread.sleep(this.vlC);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.8
 * JD-Core Version:    0.7.0.1
 */