package com.tencent.mm.ui.chatting.a;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements am.a
{
  a$1(a parama) {}
  
  public final boolean tC()
  {
    if ((a.a(this.voh) != null) && (a.a(this.voh).euf))
    {
      y.i("MicroMsg.ChattingDataAdapter", "[onTimerExpired]");
      this.voh.cDo();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.a.1
 * JD-Core Version:    0.7.0.1
 */