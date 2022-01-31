package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.cl.b;
import com.tencent.mm.sdk.platformtools.y;

final class z$1
  implements Runnable
{
  z$1(z paramz) {}
  
  public final void run()
  {
    if (this.vrw.byx == null) {
      return;
    }
    y.i("MicroMsg.ChattingUI.MessBoxComponent", "now try to activity the tools process");
    b.afs("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.z.1
 * JD-Core Version:    0.7.0.1
 */