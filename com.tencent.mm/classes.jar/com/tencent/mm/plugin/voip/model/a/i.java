package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dnd;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnj;

public final class i
  extends n<dnd, dne>
{
  String TAG;
  
  public i(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(115244);
    this.TAG = "MicroMsg.NetSceneVoipShutDown";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dnd();
    ((b.a)localObject).gUV = new dne();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipshutdown";
    ((b.a)localObject).funcId = 173;
    ((b.a)localObject).reqCmdId = 66;
    ((b.a)localObject).respCmdId = 1000000066;
    this.rr = ((b.a)localObject).atI();
    localObject = (dnd)this.rr.gUS.gUX;
    ((dnd)localObject).DdZ = paramInt;
    ((dnd)localObject).Dea = paramLong;
    dnj localdnj = new dnj();
    cmf localcmf = new cmf();
    localcmf.aEE(paramString);
    localdnj.EsS = localcmf;
    ((dnd)localObject).EBT = localdnj;
    ((dnd)localObject).EAY = System.currentTimeMillis();
    AppMethodBeat.o(115244);
  }
  
  public final g dVg()
  {
    AppMethodBeat.i(115245);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115243);
        c.Logd(i.this.TAG, "onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        AppMethodBeat.o(115243);
      }
    };
    AppMethodBeat.o(115245);
    return local1;
  }
  
  public final int getType()
  {
    return 173;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.i
 * JD-Core Version:    0.7.0.1
 */