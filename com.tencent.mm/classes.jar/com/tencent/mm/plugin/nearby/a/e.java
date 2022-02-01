package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.buk;
import com.tencent.mm.protocal.protobuf.bul;
import com.tencent.mm.protocal.protobuf.bum;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends n
  implements k
{
  private f callback;
  final b rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(89773);
    b.a locala = new b.a();
    locala.hQF = new bul();
    locala.hQG = new bum();
    locala.uri = "/cgi-bin/micromsg-bin/getroommember";
    locala.funcId = 377;
    locala.hQH = 184;
    locala.respCmdId = 1000000184;
    this.rr = locala.aDS();
    ((bul)this.rr.hQD.hQJ).ikN = paramString;
    ae.d("MicroMsg.NetSceneLbsRoomGetMember", "Req: roomName:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(89773);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(89774);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(89774);
    return i;
  }
  
  public final int getType()
  {
    return 377;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89775);
    ae.d("MicroMsg.NetSceneLbsRoomGetMember", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (bum)this.rr.hQE.hQJ;
    if (paramInt2 != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89775);
      return;
    }
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < paramq.FNl.size())
    {
      i locali = new i();
      locali.username = ((buk)paramq.FNl.get(paramInt1)).nIJ;
      locali.hPQ = ((buk)paramq.FNl.get(paramInt1)).GnN;
      locali.hPP = ((buk)paramq.FNl.get(paramInt1)).GnO;
      locali.eD(true);
      paramArrayOfByte.add(locali);
      paramInt1 += 1;
    }
    p.aEN().am(paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(89775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.e
 * JD-Core Version:    0.7.0.1
 */