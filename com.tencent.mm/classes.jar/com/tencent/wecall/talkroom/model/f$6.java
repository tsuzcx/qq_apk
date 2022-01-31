package com.tencent.wecall.talkroom.model;

import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.a.a;
import com.tencent.pb.common.c.c;
import java.util.concurrent.atomic.AtomicInteger;

final class f$6
  implements com.tencent.pb.talkroom.sdk.b
{
  f$6(f paramf, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2) {}
  
  public final int V(byte[] paramArrayOfByte, int paramInt)
  {
    if (!f.l(this.xeA)) {
      return 0;
    }
    try
    {
      b localb = f.c(this.xeA);
      int i = (short)paramInt;
      AtomicInteger localAtomicInteger1 = this.xeM;
      AtomicInteger localAtomicInteger2 = this.xeN;
      if (!a.wFa) {}
      for (i = 1; (this.xeA.xep) && (i >= 0); i = localb.xdr.GetAudioData(paramArrayOfByte, i, localAtomicInteger1, localAtomicInteger2))
      {
        this.xeA.xep = false;
        c.x("TalkRoomService", new Object[] { "onPlayPcmDataCallBack len: ", Integer.valueOf(paramInt), " ret: ", Integer.valueOf(i) });
        break;
      }
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      c.x("TalkRoomService", new Object[] { "initMediaComponent play", paramArrayOfByte });
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f.6
 * JD-Core Version:    0.7.0.1
 */