package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.c.c;

final class f$8
  implements Runnable
{
  f$8(f paramf) {}
  
  public final void run()
  {
    if ((this.xeA.bPW()) && (f.s(this.xeA)))
    {
      c.d("TalkRoomService", new Object[] { "syscall", "finishtalk becos holdtimeout" });
      h.KB(-2003);
      this.xeA.xdZ.KE(401);
      this.xeA.at(f.b(this.xeA), 3, 108);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f.8
 * JD-Core Version:    0.7.0.1
 */