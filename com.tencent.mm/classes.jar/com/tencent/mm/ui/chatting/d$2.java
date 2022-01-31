package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.aq;

final class d$2
  extends ah
{
  d$2(d paramd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    super.handleMessage(paramMessage);
    try
    {
      y.i("MicroMsg.AutoPlay", "reset speaker");
      this.vhN.setScreenEnable(true);
      paramMessage = this.vhN;
      if (!this.vhN.vhB.ian) {}
      for (;;)
      {
        paramMessage.iak = bool;
        return;
        bool = false;
      }
      return;
    }
    catch (Exception paramMessage)
    {
      y.printErrStackTrace("MicroMsg.AutoPlay", paramMessage, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.2
 * JD-Core Version:    0.7.0.1
 */