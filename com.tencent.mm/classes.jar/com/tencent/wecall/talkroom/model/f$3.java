package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.a.m;
import java.util.TimerTask;

final class f$3
  extends TimerTask
{
  f$3(f paramf, m paramm) {}
  
  public final void run()
  {
    if (this.xeC == null)
    {
      c.x("TalkRoomService", new Object[] { "doHelloTimeOutTask scene is null" });
      return;
    }
    if (!f.a(this.xeA, this.xeC.kWU, this.xeC.lvU, this.xeC.xdR, false))
    {
      c.x("TalkRoomService", new Object[] { "doHelloTimeOutTask isCurrentRoom is false scene.mGroupId: ", this.xeC.kWU, " scene.mRoomId: ", Integer.valueOf(this.xeC.lvU), " scene.mRoomKey: ", Long.valueOf(this.xeC.xdR) });
      return;
    }
    c.x("TalkRoomService", new Object[] { "doHelloTimeOutTask mGroupId: ", f.b(this.xeA), " mRoomId: ", Integer.valueOf(f.g(this.xeA)), " mRoomKey: ", Long.valueOf(f.h(this.xeA)) });
    this.xeA.xdZ.KE(330);
    h.KA(-1606);
    this.xeA.a(this.xeC.kWU, this.xeC.lvU, this.xeC.xdR, 117, true);
    f.f(this.xeA).i(-600, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f.3
 * JD-Core Version:    0.7.0.1
 */