package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.egm;
import com.tencent.mm.protocal.protobuf.euc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SyncTask;
import java.io.IOException;
import java.util.LinkedList;

final class g$5
  extends SyncTask<Integer>
{
  g$5(g paramg, Integer paramInteger, String[] paramArrayOfString, int[] paramArrayOfInt, b paramb, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    super(3000L, paramInteger);
  }
  
  private Integer bjO()
  {
    AppMethodBeat.i(29403);
    for (;;)
    {
      try
      {
        euc localeuc = new euc();
        Log.i("MicroMsg.TalkRoomEngineProxy", "Open Engine svr cnt %d", new Object[] { Integer.valueOf(this.FPe.length) });
        i = 0;
        if (i < this.FPe.length)
        {
          egm localegm = new egm();
          localegm.Ngz = this.FPe[i];
          if (localegm.Ngz == null)
          {
            Log.i("MicroMsg.TalkRoomEngineProxy", "Open Engine ip_str null skip");
          }
          else
          {
            localegm.port = this.FPf[i];
            localeuc.Nrw.add(localegm);
            Log.i("MicroMsg.TalkRoomEngineProxy", "Open Engine svr:[%s][%d] ", new Object[] { localegm.Ngz, Integer.valueOf(localegm.port) });
          }
        }
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.TalkRoomEngineProxy", localIOException, "engine.Open exception", new Object[0]);
        AppMethodBeat.o(29403);
        return Integer.valueOf(-1);
      }
      Log.i("MicroMsg.TalkRoomEngineProxy", "Open Engine valid svr cnt %d", new Object[] { Integer.valueOf(localIOException.Nrw.size()) });
      int i = g.a(this.FPc).Open(this.FPg, this.raO, this.FPh, this.FPi, this.FPj, this.FPk, localIOException.toByteArray(), localIOException.toByteArray().length);
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