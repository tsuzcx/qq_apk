package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.c.c;

final class f$1$1
  implements Runnable
{
  f$1$1(f.1 param1) {}
  
  public final void run()
  {
    try
    {
      c.w("TalkRoomService", new Object[] { "initMediaComponent" });
      f.e(this.xeB.xeA);
      return;
    }
    catch (Throwable localThrowable)
    {
      c.x("TalkRoomService", new Object[] { "keep_OnOpenSuccess initMediaComponent:  ", localThrowable });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f.1.1
 * JD-Core Version:    0.7.0.1
 */