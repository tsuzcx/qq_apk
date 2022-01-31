package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ai.d;
import com.tencent.mm.h.a.os;
import com.tencent.mm.sdk.b.a;

final class c$11
  implements Runnable
{
  c$11(c paramc) {}
  
  public final void run()
  {
    os localos = new os();
    if (c.c(this.voK) != null)
    {
      localos.bYm.userName = c.c(this.voK).field_username;
      a.udP.m(localos);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.c.11
 * JD-Core Version:    0.7.0.1
 */