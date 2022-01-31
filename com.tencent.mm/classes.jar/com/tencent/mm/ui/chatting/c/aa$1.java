package com.tencent.mm.ui.chatting.c;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.d;
import com.tencent.mm.sdk.platformtools.ab;

final class aa$1
  implements MessageQueue.IdleHandler
{
  aa$1(aa paramaa) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(153839);
    Looper.myQueue().removeIdleHandler(this);
    if (this.zHb.caz == null)
    {
      AppMethodBeat.o(153839);
      return false;
    }
    ab.i("MicroMsg.ChattingUI.MessBoxComponent", "now try to activity the tools process");
    d.aNX();
    AppMethodBeat.o(153839);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.aa.1
 * JD-Core Version:    0.7.0.1
 */