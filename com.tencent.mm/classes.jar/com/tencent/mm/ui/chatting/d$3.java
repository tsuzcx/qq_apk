package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class d$3
  extends ah
{
  d$3(d paramd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    try
    {
      y.i("MicroMsg.AutoPlay", "startPlayHandler start Play");
      this.vhN.cBZ();
      return;
    }
    catch (Exception paramMessage)
    {
      y.printErrStackTrace("MicroMsg.AutoPlay", paramMessage, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.3
 * JD-Core Version:    0.7.0.1
 */