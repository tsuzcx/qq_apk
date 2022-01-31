package com.tencent.mm.ui.transmit;

import android.app.Activity;

final class MsgRetransmitUI$a$1
  implements Runnable
{
  MsgRetransmitUI$a$1(MsgRetransmitUI.a parama) {}
  
  public final void run()
  {
    if ((this.wgW.wgS) && ((this.wgW.context instanceof Activity))) {
      ((Activity)this.wgW.context).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.a.1
 * JD-Core Version:    0.7.0.1
 */