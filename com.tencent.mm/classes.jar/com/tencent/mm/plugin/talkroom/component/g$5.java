package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dgl;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bn;
import java.io.IOException;
import java.util.LinkedList;

final class g$5
  extends bn<Integer>
{
  g$5(g paramg, Integer paramInteger, String[] paramArrayOfString, int[] paramArrayOfInt, b paramb, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    super(3000L, paramInteger, (byte)0);
  }
  
  private Integer aLG()
  {
    AppMethodBeat.i(29403);
    for (;;)
    {
      try
      {
        dsk localdsk = new dsk();
        ac.i("MicroMsg.TalkRoomEngineProxy", "Open Engine svr cnt %d", new Object[] { Integer.valueOf(this.zVk.length) });
        i = 0;
        if (i < this.zVk.length)
        {
          dgl localdgl = new dgl();
          localdgl.FPP = this.zVk[i];
          if (localdgl.FPP == null)
          {
            ac.i("MicroMsg.TalkRoomEngineProxy", "Open Engine ip_str null skip");
          }
          else
          {
            localdgl.port = this.zVl[i];
            localdsk.FZU.add(localdgl);
            ac.i("MicroMsg.TalkRoomEngineProxy", "Open Engine svr:[%s][%d] ", new Object[] { localdgl.FPP, Integer.valueOf(localdgl.port) });
          }
        }
      }
      catch (IOException localIOException)
      {
        ac.printErrStackTrace("MicroMsg.TalkRoomEngineProxy", localIOException, "engine.Open exception", new Object[0]);
        AppMethodBeat.o(29403);
        return Integer.valueOf(-1);
      }
      ac.i("MicroMsg.TalkRoomEngineProxy", "Open Engine valid svr cnt %d", new Object[] { Integer.valueOf(localIOException.FZU.size()) });
      int i = g.a(this.zVi).Open(this.zVm, this.oZX, this.zVn, this.zVo, this.zVp, this.zVq, localIOException.toByteArray(), localIOException.toByteArray().length);
      AppMethodBeat.o(29403);
      return Integer.valueOf(i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.g.5
 * JD-Core Version:    0.7.0.1
 */