package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.a.a;
import com.tencent.pb.common.c.c;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  talk BzZ;
  
  public b()
  {
    AppMethodBeat.i(127789);
    this.BzZ = new talk();
    c.i("simon:TalkRoomContext", new Object[] { "construct engine:", this.BzZ });
    AppMethodBeat.o(127789);
  }
  
  public final int Close()
  {
    AppMethodBeat.i(127791);
    if (!a.BcB)
    {
      AppMethodBeat.o(127791);
      return 0;
    }
    try
    {
      if (this.BzZ != null)
      {
        i = this.BzZ.close();
        c.i("simon:TalkRoomContext", new Object[] { "Close ret: ", Integer.valueOf(i) });
        AppMethodBeat.o(127791);
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        c.w("simon:TalkRoomContext", new Object[] { "Close ", localThrowable });
        int i = 0;
      }
    }
  }
  
  public final void OnMembersChanged(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(127792);
    if ((!a.BcB) || (this.BzZ == null))
    {
      AppMethodBeat.o(127792);
      return;
    }
    this.BzZ.OnMembersChanged(paramArrayOfInt);
    AppMethodBeat.o(127792);
  }
  
  public final byte[] dXs()
  {
    if ((!a.BcB) || (this.BzZ == null)) {
      return new byte[0];
    }
    return this.BzZ.field_capInfo;
  }
  
  public final void dXt()
  {
    if ((!a.BcB) || (this.BzZ == null)) {
      return;
    }
    this.BzZ.field_capInfo = null;
  }
  
  public final int dXu()
  {
    AppMethodBeat.i(127793);
    try
    {
      if (a.BcB)
      {
        localObject = this.BzZ;
        if (localObject != null) {}
      }
      else
      {
        AppMethodBeat.o(127793);
        return 0;
      }
      Object localObject = new AtomicInteger();
      AtomicInteger localAtomicInteger = new AtomicInteger();
      this.BzZ.getChannelBytes((AtomicInteger)localObject, localAtomicInteger);
      int i = localAtomicInteger.get();
      AppMethodBeat.o(127793);
      return i;
    }
    catch (Throwable localThrowable)
    {
      c.w("simon:TalkRoomContext", new Object[] { "getTotalWWANBytes: ", localThrowable });
      AppMethodBeat.o(127793);
    }
    return 0;
  }
  
  public final int uninitLive()
  {
    AppMethodBeat.i(127790);
    if (!a.BcB)
    {
      AppMethodBeat.o(127790);
      return 0;
    }
    try
    {
      if (this.BzZ != null)
      {
        i = this.BzZ.uninit();
        c.i("simon:TalkRoomContext", new Object[] { "uninitLive ret: ", Integer.valueOf(i) });
        AppMethodBeat.o(127790);
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        c.w("simon:TalkRoomContext", new Object[] { "uninitLive ", localThrowable });
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.b
 * JD-Core Version:    0.7.0.1
 */