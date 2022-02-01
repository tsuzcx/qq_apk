package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.a.a;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  talk ahZE;
  
  public b()
  {
    AppMethodBeat.i(62557);
    this.ahZE = new talk();
    com.tencent.pb.common.c.b.i("simon:TalkRoomContext", new Object[] { "construct engine:", this.ahZE });
    AppMethodBeat.o(62557);
  }
  
  public final int Close()
  {
    AppMethodBeat.i(62559);
    if (!a.ahcq)
    {
      AppMethodBeat.o(62559);
      return 0;
    }
    try
    {
      if (this.ahZE != null)
      {
        i = this.ahZE.close();
        com.tencent.pb.common.c.b.i("simon:TalkRoomContext", new Object[] { "Close ret: ", Integer.valueOf(i) });
        AppMethodBeat.o(62559);
        return i;
      }
    }
    finally
    {
      for (;;)
      {
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "Close ", localObject });
        int i = 0;
      }
    }
  }
  
  public final void OnMembersChanged(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62560);
    if ((!a.ahcq) || (this.ahZE == null))
    {
      AppMethodBeat.o(62560);
      return;
    }
    this.ahZE.OnMembersChanged(paramArrayOfInt);
    AppMethodBeat.o(62560);
  }
  
  public final byte[] kea()
  {
    if ((!a.ahcq) || (this.ahZE == null)) {
      return new byte[0];
    }
    return this.ahZE.field_capInfo;
  }
  
  public final void keb()
  {
    if ((!a.ahcq) || (this.ahZE == null)) {
      return;
    }
    this.ahZE.field_capInfo = null;
  }
  
  public final int kec()
  {
    AppMethodBeat.i(62561);
    try
    {
      if (a.ahcq)
      {
        localObject1 = this.ahZE;
        if (localObject1 != null) {}
      }
      else
      {
        AppMethodBeat.o(62561);
        return 0;
      }
      Object localObject1 = new AtomicInteger();
      AtomicInteger localAtomicInteger = new AtomicInteger();
      this.ahZE.getChannelBytes((AtomicInteger)localObject1, localAtomicInteger);
      int i = localAtomicInteger.get();
      AppMethodBeat.o(62561);
      return i;
    }
    finally
    {
      com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "getTotalWWANBytes: ", localObject2 });
      AppMethodBeat.o(62561);
    }
    return 0;
  }
  
  public final int uninitLive()
  {
    AppMethodBeat.i(62558);
    if (!a.ahcq)
    {
      AppMethodBeat.o(62558);
      return 0;
    }
    try
    {
      if (this.ahZE != null)
      {
        i = this.ahZE.uninit();
        com.tencent.pb.common.c.b.i("simon:TalkRoomContext", new Object[] { "uninitLive ret: ", Integer.valueOf(i) });
        AppMethodBeat.o(62558);
        return i;
      }
    }
    finally
    {
      for (;;)
      {
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "uninitLive ", localObject });
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.b
 * JD-Core Version:    0.7.0.1
 */