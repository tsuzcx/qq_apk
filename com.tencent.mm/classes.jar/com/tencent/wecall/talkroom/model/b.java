package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.a.a;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  talk Mlr;
  
  public b()
  {
    AppMethodBeat.i(62557);
    this.Mlr = new talk();
    com.tencent.pb.common.c.b.i("simon:TalkRoomContext", new Object[] { "construct engine:", this.Mlr });
    AppMethodBeat.o(62557);
  }
  
  public final int Close()
  {
    AppMethodBeat.i(62559);
    if (!a.LER)
    {
      AppMethodBeat.o(62559);
      return 0;
    }
    try
    {
      if (this.Mlr != null)
      {
        i = this.Mlr.close();
        com.tencent.pb.common.c.b.i("simon:TalkRoomContext", new Object[] { "Close ret: ", Integer.valueOf(i) });
        AppMethodBeat.o(62559);
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "Close ", localThrowable });
        int i = 0;
      }
    }
  }
  
  public final void OnMembersChanged(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62560);
    if ((!a.LER) || (this.Mlr == null))
    {
      AppMethodBeat.o(62560);
      return;
    }
    this.Mlr.OnMembersChanged(paramArrayOfInt);
    AppMethodBeat.o(62560);
  }
  
  public final byte[] fZs()
  {
    if ((!a.LER) || (this.Mlr == null)) {
      return new byte[0];
    }
    return this.Mlr.field_capInfo;
  }
  
  public final void fZt()
  {
    if ((!a.LER) || (this.Mlr == null)) {
      return;
    }
    this.Mlr.field_capInfo = null;
  }
  
  public final int fZu()
  {
    AppMethodBeat.i(62561);
    try
    {
      if (a.LER)
      {
        localObject = this.Mlr;
        if (localObject != null) {}
      }
      else
      {
        AppMethodBeat.o(62561);
        return 0;
      }
      Object localObject = new AtomicInteger();
      AtomicInteger localAtomicInteger = new AtomicInteger();
      this.Mlr.getChannelBytes((AtomicInteger)localObject, localAtomicInteger);
      int i = localAtomicInteger.get();
      AppMethodBeat.o(62561);
      return i;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "getTotalWWANBytes: ", localThrowable });
      AppMethodBeat.o(62561);
    }
    return 0;
  }
  
  public final int uninitLive()
  {
    AppMethodBeat.i(62558);
    if (!a.LER)
    {
      AppMethodBeat.o(62558);
      return 0;
    }
    try
    {
      if (this.Mlr != null)
      {
        i = this.Mlr.uninit();
        com.tencent.pb.common.c.b.i("simon:TalkRoomContext", new Object[] { "uninitLive ret: ", Integer.valueOf(i) });
        AppMethodBeat.o(62558);
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.pb.common.c.b.w("simon:TalkRoomContext", new Object[] { "uninitLive ", localThrowable });
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.b
 * JD-Core Version:    0.7.0.1
 */