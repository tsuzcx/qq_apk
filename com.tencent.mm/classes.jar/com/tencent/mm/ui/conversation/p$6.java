package com.tencent.mm.ui.conversation;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.sdk.platformtools.Log;

final class p$6
  implements MessageQueue.IdleHandler
{
  p$6(p paramp) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(38727);
    Log.d("MicroMsg.RefreshHelper", "dkuploadAddrBook idleHandler");
    if ((bg.aAc()) && (l.bnZ() == l.a.keL) && (!l.bnY()))
    {
      ao localao = new ao(l.boi(), l.boh());
      bg.azz().a(localao, 0);
    }
    Looper.myQueue().removeIdleHandler(this.Qhd.pzA);
    AppMethodBeat.o(38727);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.p.6
 * JD-Core Version:    0.7.0.1
 */