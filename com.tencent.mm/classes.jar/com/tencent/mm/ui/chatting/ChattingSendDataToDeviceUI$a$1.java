package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.y;

final class ChattingSendDataToDeviceUI$a$1
  implements Runnable
{
  ChattingSendDataToDeviceUI$a$1(ChattingSendDataToDeviceUI.a parama, int paramInt1, ChattingSendDataToDeviceUI.c paramc, as paramas, int paramInt2) {}
  
  public final void run()
  {
    int i = this.vlB + 1;
    while (this.vlG.vlx.vln)
    {
      int j;
      if (i >= 100)
      {
        j = i;
        try
        {
          if (this.vlA.bKT.equals("send_data_sucess"))
          {
            j = i;
            this.vlG.vlx.runOnUiThread(new ChattingSendDataToDeviceUI.a.1.1(this));
            return;
          }
          j = i;
          if (!this.vlA.bKT.equals("send_data_failed")) {
            continue;
          }
          j = i;
          this.vlG.vlx.runOnUiThread(new ChattingSendDataToDeviceUI.a.1.2(this));
          return;
        }
        catch (Exception localException)
        {
          y.d("MicroMsg.ChattingSendDataToDeviceUI", "setSendingProgress exception %s", new Object[] { localException });
          i = j;
        }
      }
      else
      {
        j = i;
        this.vlz.vnu.setProgress(i);
        j = i;
        this.vlA.progress = i;
        i += 1;
        j = i;
        Thread.sleep(this.vlC);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a.1
 * JD-Core Version:    0.7.0.1
 */