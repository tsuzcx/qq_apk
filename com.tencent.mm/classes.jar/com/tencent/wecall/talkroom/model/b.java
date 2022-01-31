package com.tencent.wecall.talkroom.model;

import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.a.a;
import com.tencent.pb.common.c.c;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  talk xdr = new talk();
  
  public b()
  {
    c.d("simon:TalkRoomContext", new Object[] { "construct" });
  }
  
  public final int Close()
  {
    if (!a.wFa) {
      return 0;
    }
    try
    {
      i = this.xdr.close();
      c.d("simon:TalkRoomContext", new Object[] { "Close ret: ", Integer.valueOf(i) });
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        c.x("simon:TalkRoomContext", new Object[] { "Close ", localThrowable });
        int i = 0;
      }
    }
  }
  
  public final void OnMembersChanged(int[] paramArrayOfInt)
  {
    if (!a.wFa) {
      return;
    }
    this.xdr.OnMembersChanged(paramArrayOfInt);
  }
  
  public final byte[] cRA()
  {
    if (!a.wFa) {
      return new byte[0];
    }
    return this.xdr.field_capInfo;
  }
  
  public final int cRB()
  {
    try
    {
      if (!a.wFa) {
        return 0;
      }
      AtomicInteger localAtomicInteger1 = new AtomicInteger();
      AtomicInteger localAtomicInteger2 = new AtomicInteger();
      this.xdr.getChannelBytes(localAtomicInteger1, localAtomicInteger2);
      int i = localAtomicInteger2.get();
      return i;
    }
    catch (Throwable localThrowable)
    {
      c.x("simon:TalkRoomContext", new Object[] { "getTotalWWANBytes: ", localThrowable });
    }
    return 0;
  }
  
  public final int uninitLive()
  {
    if (!a.wFa) {
      return 0;
    }
    try
    {
      i = this.xdr.uninit();
      c.d("simon:TalkRoomContext", new Object[] { "uninitLive ret: ", Integer.valueOf(i) });
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        c.x("simon:TalkRoomContext", new Object[] { "uninitLive ", localThrowable });
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.b
 * JD-Core Version:    0.7.0.1
 */