package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eqo;
import com.tencent.mm.protocal.protobuf.fen;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SyncTask;
import java.io.IOException;
import java.util.LinkedList;

final class f$5
  extends SyncTask<Integer>
{
  f$5(f paramf, Integer paramInteger, String[] paramArrayOfString, int[] paramArrayOfInt, ILiveConEngineCallback_AIDL paramILiveConEngineCallback_AIDL, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    super(3000L, paramInteger);
  }
  
  private Integer bts()
  {
    AppMethodBeat.i(29403);
    for (;;)
    {
      try
      {
        fen localfen = new fen();
        Log.i("MicroMsg.TalkRoomEngineProxy", "Open Engine svr cnt %d", new Object[] { Integer.valueOf(this.Mjf.length) });
        i = 0;
        if (i < this.Mjf.length)
        {
          eqo localeqo = new eqo();
          localeqo.Utd = this.Mjf[i];
          if (localeqo.Utd == null)
          {
            Log.i("MicroMsg.TalkRoomEngineProxy", "Open Engine ip_str null skip");
          }
          else
          {
            localeqo.port = this.Mjg[i];
            localfen.UEt.add(localeqo);
            Log.i("MicroMsg.TalkRoomEngineProxy", "Open Engine svr:[%s][%d] ", new Object[] { localeqo.Utd, Integer.valueOf(localeqo.port) });
          }
        }
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.TalkRoomEngineProxy", localIOException, "engine.Open exception", new Object[0]);
        AppMethodBeat.o(29403);
        return Integer.valueOf(-1);
      }
      Log.i("MicroMsg.TalkRoomEngineProxy", "Open Engine valid svr cnt %d", new Object[] { Integer.valueOf(localIOException.UEt.size()) });
      int i = f.a(this.Mjd).Open(this.Mjh, this.uDO, this.Mji, this.Mjj, this.Mjk, this.Mjl, localIOException.toByteArray(), localIOException.toByteArray().length);
      AppMethodBeat.o(29403);
      return Integer.valueOf(i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.f.5
 * JD-Core Version:    0.7.0.1
 */