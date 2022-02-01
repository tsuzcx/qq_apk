package com.tencent.mm.ui.conversation;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.sdk.platformtools.Log;

final class q$6
  implements MessageQueue.IdleHandler
{
  q$6(q paramq) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(38727);
    Log.d("MicroMsg.RefreshHelper", "dkuploadAddrBook idleHandler");
    if ((bh.aHB()) && (l.byi() == l.a.mWk) && (!l.byh()))
    {
      ao localao = new ao(l.byr(), l.byq());
      bh.aGY().a(localao, 0);
    }
    Looper.myQueue().removeIdleHandler(this.XEn.sJE);
    AppMethodBeat.o(38727);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.q.6
 * JD-Core Version:    0.7.0.1
 */