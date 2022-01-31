package com.tencent.mm.ui;

import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.y;

final class h$16
  implements Runnable
{
  h$16(h paramh) {}
  
  public final void run()
  {
    h.a(this.uJi, q.Gn());
    h.b(this.uJi, q.Gu());
    h.a(this.uJi, q.Go());
    long l = System.currentTimeMillis();
    h.s(this.uJi);
    y.i("MicroMsg.FindMoreFriendsUI", "[updateStatus] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.h.16
 * JD-Core Version:    0.7.0.1
 */