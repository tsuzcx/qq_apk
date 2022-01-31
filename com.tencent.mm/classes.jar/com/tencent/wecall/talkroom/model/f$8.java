package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.c;

final class f$8
  implements Runnable
{
  f$8(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(127877);
    if ((this.BBh.cMa()) && (f.s(this.BBh)))
    {
      c.d("TalkRoomService", new Object[] { "syscall", "finishtalk becos holdtimeout" });
      h.Tu(-2003);
      this.BBh.BAG.Tx(401);
      this.BBh.aK(f.b(this.BBh), 3, 108);
    }
    AppMethodBeat.o(127877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f.8
 * JD-Core Version:    0.7.0.1
 */