package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.daz;
import com.tencent.mm.protocal.protobuf.dmt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.LinkedList;

final class g$5
  extends bo<Integer>
{
  g$5(g paramg, Integer paramInteger, String[] paramArrayOfString, int[] paramArrayOfInt, b paramb, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    super(3000L, paramInteger, (byte)0);
  }
  
  private Integer aEP()
  {
    AppMethodBeat.i(29403);
    for (;;)
    {
      try
      {
        dmt localdmt = new dmt();
        ad.i("MicroMsg.TalkRoomEngineProxy", "Open Engine svr cnt %d", new Object[] { Integer.valueOf(this.yHW.length) });
        i = 0;
        if (i < this.yHW.length)
        {
          daz localdaz = new daz();
          localdaz.EsN = this.yHW[i];
          if (localdaz.EsN == null)
          {
            ad.i("MicroMsg.TalkRoomEngineProxy", "Open Engine ip_str null skip");
          }
          else
          {
            localdaz.port = this.yHX[i];
            localdmt.ECH.add(localdaz);
            ad.i("MicroMsg.TalkRoomEngineProxy", "Open Engine svr:[%s][%d] ", new Object[] { localdaz.EsN, Integer.valueOf(localdaz.port) });
          }
        }
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("MicroMsg.TalkRoomEngineProxy", localIOException, "engine.Open exception", new Object[0]);
        AppMethodBeat.o(29403);
        return Integer.valueOf(-1);
      }
      ad.i("MicroMsg.TalkRoomEngineProxy", "Open Engine valid svr cnt %d", new Object[] { Integer.valueOf(localIOException.ECH.size()) });
      int i = g.a(this.yHU).Open(this.yHY, this.owx, this.yHZ, this.yIa, this.yIb, this.yIc, localIOException.toByteArray(), localIOException.toByteArray().length);
      AppMethodBeat.o(29403);
      return Integer.valueOf(i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.g.5
 * JD-Core Version:    0.7.0.1
 */