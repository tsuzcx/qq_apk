package com.tencent.wecall.talkroom.model;

import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.a.a;

final class f$5
  implements com.tencent.pb.talkroom.sdk.c
{
  f$5(f paramf) {}
  
  public final void W(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      if (!f.l(this.xeA)) {
        return;
      }
      if (f.m(this.xeA))
      {
        int i = 0;
        while (i < paramArrayOfByte.length)
        {
          paramArrayOfByte[i] = 0;
          i += 1;
        }
      }
      if (f.l(this.xeA))
      {
        b localb = f.c(this.xeA);
        short s = (short)paramInt;
        if (a.wFa) {
          localb.xdr.SendAudio(paramArrayOfByte, s, 0);
        }
        if (this.xeA.xeo)
        {
          this.xeA.xeo = false;
          com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "onRecPcmDataCallBack len: ", Integer.valueOf(paramInt) });
          return;
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "initMediaComponent record", paramArrayOfByte });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f.5
 * JD-Core Version:    0.7.0.1
 */