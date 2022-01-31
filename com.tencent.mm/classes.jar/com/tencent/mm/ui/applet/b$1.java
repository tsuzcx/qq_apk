package com.tencent.mm.ui.applet;

import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class b$1
  implements MessageQueue.IdleHandler
{
  b$1(b paramb) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(106223);
    while (this.zgD.zgB.size() > 0)
    {
      String str = (String)this.zgD.zgB.removeFirst();
      this.zgD.zgC.xh(str);
    }
    AppMethodBeat.o(106223);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.applet.b.1
 * JD-Core Version:    0.7.0.1
 */