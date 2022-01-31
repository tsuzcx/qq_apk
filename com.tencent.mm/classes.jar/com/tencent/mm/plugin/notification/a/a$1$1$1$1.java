package com.tencent.mm.plugin.notification.a;

import com.tencent.mm.model.al;
import com.tencent.mm.model.au;

final class a$1$1$1$1
  implements Runnable
{
  a$1$1$1$1(a.1.1.1 param1) {}
  
  public final void run()
  {
    au.getNotification().k(this.mIr.mIo, this.mIr.mIq.mIm);
    if (this.mIr.mIq.mIn.mIl.mIk)
    {
      this.mIr.mIq.mIn.mIl.mIk = false;
      au.getNotification().bd(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.a.a.1.1.1.1
 * JD-Core Version:    0.7.0.1
 */