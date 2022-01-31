package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class a$8
  implements am.a
{
  a$8(a parama, long paramLong) {}
  
  public final boolean tC()
  {
    if ((!this.mIE.mIx.contains(Long.valueOf(this.byn))) && (!this.mIE.mIy.contains(Long.valueOf(this.byn))) && (this.mIE.mIu.contains(this.byn)))
    {
      y.i("MicroMsg.AbstractSendMsgFailNotification", "msg:%d send timeout, move this message to fail list, continue send next message", new Object[] { Long.valueOf(this.byn) });
      this.mIE.mIy.add(Long.valueOf(this.byn));
      this.mIE.mIz.add(Long.valueOf(this.byn));
      if (this.mIE.mIx.size() + this.mIE.mIy.size() >= this.mIE.mIu.mIG.size()) {
        a.d(this.mIE);
      }
    }
    else
    {
      return true;
    }
    long l = this.mIE.mIu.bpB();
    this.mIE.fn(l);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.a.8
 * JD-Core Version:    0.7.0.1
 */