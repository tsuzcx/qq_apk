package com.tencent.mm.ui.conversation;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.sdk.platformtools.y;

final class n$6
  implements MessageQueue.IdleHandler
{
  n$6(n paramn) {}
  
  public final boolean queueIdle()
  {
    y.d("MicroMsg.RefreshHelper", "dkuploadAddrBook idleHandler");
    if ((au.DK()) && (l.WP() == l.a.ffT) && (!l.WO()))
    {
      al localal = new al(l.WW(), l.WV());
      au.Dk().a(localal, 0);
    }
    Looper.myQueue().removeIdleHandler(this.vTV.uKq);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.n.6
 * JD-Core Version:    0.7.0.1
 */