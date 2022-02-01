package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fls;
import com.tencent.mm.protocal.protobuf.gaz;
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
  
  private Integer bRc()
  {
    AppMethodBeat.i(29403);
    for (;;)
    {
      try
      {
        gaz localgaz = new gaz();
        Log.i("MicroMsg.TalkRoomEngineProxy", "Open Engine svr cnt %d", new Object[] { Integer.valueOf(this.SMB.length) });
        i = 0;
        if (i < this.SMB.length)
        {
          fls localfls = new fls();
          localfls.abMk = this.SMB[i];
          if (localfls.abMk == null)
          {
            Log.i("MicroMsg.TalkRoomEngineProxy", "Open Engine ip_str null skip");
          }
          else
          {
            localfls.port = this.SMC[i];
            localgaz.abYE.add(localfls);
            Log.i("MicroMsg.TalkRoomEngineProxy", "Open Engine svr:[%s][%d] ", new Object[] { localfls.abMk, Integer.valueOf(localfls.port) });
          }
        }
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.TalkRoomEngineProxy", localIOException, "engine.Open exception", new Object[0]);
        AppMethodBeat.o(29403);
        return Integer.valueOf(-1);
      }
      Log.i("MicroMsg.TalkRoomEngineProxy", "Open Engine valid svr cnt %d", new Object[] { Integer.valueOf(localIOException.abYE.size()) });
      int i = f.a(this.SMz).Open(this.SMD, this.xMg, this.SME, this.SMF, this.SMG, this.SMH, localIOException.toByteArray(), localIOException.toByteArray().length);
      AppMethodBeat.o(29403);
      return Integer.valueOf(i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.f.5
 * JD-Core Version:    0.7.0.1
 */