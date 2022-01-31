package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class a$5
  implements am.a
{
  a$5(a parama) {}
  
  public final boolean tC()
  {
    if (this.mIE.mIw)
    {
      y.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(this.mIE.mIu.mIG.size()), Integer.valueOf(this.mIE.mIx.size()), Integer.valueOf(this.mIE.mIy.size()) });
      this.mIE.bpp();
      y.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(this.mIE.mIu.mIG.size()), Integer.valueOf(this.mIE.mIx.size()), Integer.valueOf(this.mIE.mIy.size()) });
      if (this.mIE.mIu.mIG.size() > 0)
      {
        a.c(this.mIE);
        return true;
      }
      a.d(this.mIE);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.a.5
 * JD-Core Version:    0.7.0.1
 */