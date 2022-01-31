package com.tencent.mm.ui.conversation;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.sdk.platformtools.ab;

final class m$6
  implements MessageQueue.IdleHandler
{
  m$6(m paramm) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(34600);
    ab.d("MicroMsg.RefreshHelper", "dkuploadAddrBook idleHandler");
    if ((aw.RG()) && (l.aqq() == l.a.gxB) && (!l.aqp()))
    {
      al localal = new al(l.aqz(), l.aqy());
      aw.Rc().a(localal, 0);
    }
    Looper.myQueue().removeIdleHandler(this.AlR.jZm);
    AppMethodBeat.o(34600);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m.6
 * JD-Core Version:    0.7.0.1
 */