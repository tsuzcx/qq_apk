package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.a.a;
import com.tencent.pb.common.c.c;
import java.util.concurrent.atomic.AtomicInteger;

final class f$6
  implements com.tencent.pb.talkroom.sdk.b
{
  f$6(f paramf, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2) {}
  
  public final int W(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(127875);
    if (!f.l(this.BBh))
    {
      AppMethodBeat.o(127875);
      return 0;
    }
    label169:
    for (;;)
    {
      try
      {
        b localb = f.c(this.BBh);
        int i = (short)paramInt;
        AtomicInteger localAtomicInteger1 = this.BBt;
        AtomicInteger localAtomicInteger2 = this.BBu;
        if (a.BcB) {
          if (localb.BzZ == null)
          {
            break label169;
            if ((this.BBh.BAW) && (i >= 0))
            {
              this.BBh.BAW = false;
              c.w("TalkRoomService", new Object[] { "onPlayPcmDataCallBack len: ", Integer.valueOf(paramInt), " ret: ", Integer.valueOf(i) });
            }
            AppMethodBeat.o(127875);
            return i;
          }
          else
          {
            i = localb.BzZ.GetAudioData(paramArrayOfByte, i, localAtomicInteger1, localAtomicInteger2);
            continue;
          }
        }
        i = 1;
      }
      catch (Exception paramArrayOfByte)
      {
        c.w("TalkRoomService", new Object[] { "initMediaComponent play", paramArrayOfByte });
        AppMethodBeat.o(127875);
        return -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f.6
 * JD-Core Version:    0.7.0.1
 */