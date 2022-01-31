package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class c$a$1
  implements Runnable
{
  c$a$1(c.a parama, long paramLong, Boolean paramBoolean, c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(31964);
    c.a.a(this.zKm, this.zKj);
    if (this.zKk.booleanValue()) {
      this.zKm.handler.postDelayed(new c.a.1.1(this), 0L);
    }
    AppMethodBeat.o(31964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c.a.1
 * JD-Core Version:    0.7.0.1
 */