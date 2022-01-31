package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.a.a;

final class f$5
  implements com.tencent.pb.talkroom.sdk.c
{
  f$5(f paramf) {}
  
  public final void X(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(127874);
    try
    {
      boolean bool = f.l(this.BBh);
      if (!bool)
      {
        AppMethodBeat.o(127874);
        return;
      }
      if (f.m(this.BBh))
      {
        int i = 0;
        while (i < paramArrayOfByte.length)
        {
          paramArrayOfByte[i] = 0;
          i += 1;
        }
      }
      b localb;
      short s;
      if (f.l(this.BBh))
      {
        localb = f.c(this.BBh);
        s = (short)paramInt;
        if ((a.BcB) && (localb.BzZ != null)) {
          break label140;
        }
      }
      for (;;)
      {
        if (this.BBh.BAV)
        {
          this.BBh.BAV = false;
          com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "onRecPcmDataCallBack len: ", Integer.valueOf(paramInt) });
        }
        AppMethodBeat.o(127874);
        return;
        label140:
        localb.BzZ.SendAudio(paramArrayOfByte, s, 0);
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "initMediaComponent record", paramArrayOfByte });
      AppMethodBeat.o(127874);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f.5
 * JD-Core Version:    0.7.0.1
 */