package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.btq;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.ad;
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
    locala.hNM = new btr();
    locala.hNN = new bts();
    locala.uri = "/cgi-bin/micromsg-bin/getroommember";
    locala.funcId = 377;
    locala.hNO = 184;
    locala.respCmdId = 1000000184;
    this.rr = locala.aDC();
    ((btr)this.rr.hNK.hNQ).ihU = paramString;
    ad.d("MicroMsg.NetSceneLbsRoomGetMember", "Req: roomName:".concat(String.valueOf(paramString)));
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
    ad.d("MicroMsg.NetSceneLbsRoomGetMember", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (bts)this.rr.hNL.hNQ;
    if (paramInt2 != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89775);
      return;
    }
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < paramq.FuN.size())
    {
      i locali = new i();
      locali.username = ((btq)paramq.FuN.get(paramInt1)).nDo;
      locali.hMX = ((btq)paramq.FuN.get(paramInt1)).FVo;
      locali.hMW = ((btq)paramq.FuN.get(paramInt1)).FVp;
      locali.eB(true);
      paramArrayOfByte.add(locali);
      paramInt1 += 1;
    }
    p.aEx().am(paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(89775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.e
 * JD-Core Version:    0.7.0.1
 */