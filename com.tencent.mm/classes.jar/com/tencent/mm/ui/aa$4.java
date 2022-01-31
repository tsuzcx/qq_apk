package com.tencent.mm.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

final class aa$4
  implements Runnable
{
  aa$4(aa paramaa) {}
  
  public final void run()
  {
    if (!au.DK()) {
      y.w("MicroMsg.UnreadCountHelper", "getAddrTabUnreadCount, but mmcore not ready");
    }
    for (int i = 0;; i = ah.g((Integer)com.tencent.mm.model.c.Dz().get(143618, null)))
    {
      if (this.uPf.uOZ != null) {
        this.uPf.uOZ.FI(i);
      }
      return;
      au.Hx();
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|setAddressTagUnread";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.aa.4
 * JD-Core Version:    0.7.0.1
 */