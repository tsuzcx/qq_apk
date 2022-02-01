package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dmv;
import com.tencent.mm.protocal.protobuf.dzv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bp;
import java.io.IOException;
import java.util.LinkedList;

final class g$5
  extends bp<Integer>
{
  g$5(g paramg, Integer paramInteger, String[] paramArrayOfString, int[] paramArrayOfInt, b paramb, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    super(3000L, paramInteger, (byte)0);
  }
  
  private Integer aPn()
  {
    AppMethodBeat.i(29403);
    for (;;)
    {
      try
      {
        dzv localdzv = new dzv();
        ae.i("MicroMsg.TalkRoomEngineProxy", "Open Engine svr cnt %d", new Object[] { Integer.valueOf(this.BEn.length) });
        i = 0;
        if (i < this.BEn.length)
        {
          dmv localdmv = new dmv();
          localdmv.HUh = this.BEn[i];
          if (localdmv.HUh == null)
          {
            ae.i("MicroMsg.TalkRoomEngineProxy", "Open Engine ip_str null skip");
          }
          else
          {
            localdmv.port = this.BEo[i];
            localdzv.IeY.add(localdmv);
            ae.i("MicroMsg.TalkRoomEngineProxy", "Open Engine svr:[%s][%d] ", new Object[] { localdmv.HUh, Integer.valueOf(localdmv.port) });
          }
        }
      }
      catch (IOException localIOException)
      {
        ae.printErrStackTrace("MicroMsg.TalkRoomEngineProxy", localIOException, "engine.Open exception", new Object[0]);
        AppMethodBeat.o(29403);
        return Integer.valueOf(-1);
      }
      ae.i("MicroMsg.TalkRoomEngineProxy", "Open Engine valid svr cnt %d", new Object[] { Integer.valueOf(localIOException.IeY.size()) });
      int i = g.a(this.BEl).Open(this.BEp, this.pKl, this.BEq, this.BEr, this.BEs, this.BEt, localIOException.toByteArray(), localIOException.toByteArray().length);
      AppMethodBeat.o(29403);
      return Integer.valueOf(i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.g.5
 * JD-Core Version:    0.7.0.1
 */