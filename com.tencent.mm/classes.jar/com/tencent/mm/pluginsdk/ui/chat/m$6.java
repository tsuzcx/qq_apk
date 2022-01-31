package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public final class m$6
  implements Runnable
{
  public m$6(m paramm, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(62459);
    if (this.vZl.jdMethod_do(this.fOX))
    {
      this.vZl.mHandler.sendEmptyMessage(20003);
      AppMethodBeat.o(62459);
      return;
    }
    this.vZl.mHandler.removeMessages(20003);
    this.vZl.mHandler.sendEmptyMessage(20001);
    AppMethodBeat.o(62459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.m.6
 * JD-Core Version:    0.7.0.1
 */