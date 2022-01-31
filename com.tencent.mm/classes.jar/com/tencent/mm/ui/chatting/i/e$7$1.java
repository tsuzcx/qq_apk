package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.e.a.b;

final class e$7$1
  implements Runnable
{
  e$7$1(e.7 param7, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(32565);
    this.zPw.zPs.zPp.kFv = false;
    if (e.c(this.zPw.zPs) != null) {
      e.c(this.zPw.zPs).s(this.zPw.kFC, this.kFN);
    }
    AppMethodBeat.o(32565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.e.7.1
 * JD-Core Version:    0.7.0.1
 */