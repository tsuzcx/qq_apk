package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.a.m;
import java.util.TimerTask;

final class f$3
  extends TimerTask
{
  f$3(f paramf, m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(127872);
    if (this.BBj == null)
    {
      c.w("TalkRoomService", new Object[] { "doHelloTimeOutTask scene is null" });
      AppMethodBeat.o(127872);
      return;
    }
    if (!f.a(this.BBh, this.BBj.nuW, this.BBj.nTj, this.BBj.tFh, false))
    {
      c.w("TalkRoomService", new Object[] { "doHelloTimeOutTask isCurrentRoom is false scene.mGroupId: ", this.BBj.nuW, " scene.mRoomId: ", Integer.valueOf(this.BBj.nTj), " scene.mRoomKey: ", Long.valueOf(this.BBj.tFh) });
      AppMethodBeat.o(127872);
      return;
    }
    c.w("TalkRoomService", new Object[] { "doHelloTimeOutTask mGroupId: ", f.b(this.BBh), " mRoomId: ", Integer.valueOf(f.g(this.BBh)), " mRoomKey: ", Long.valueOf(f.h(this.BBh)) });
    this.BBh.BAG.Tx(330);
    h.Tt(-1606);
    this.BBh.a(this.BBj.nuW, this.BBj.nTj, this.BBj.tFh, 117, true);
    f.f(this.BBh).l(-600, null);
    AppMethodBeat.o(127872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f.3
 * JD-Core Version:    0.7.0.1
 */