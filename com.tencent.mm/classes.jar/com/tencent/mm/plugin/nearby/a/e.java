package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bpd;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.protocal.protobuf.bpf;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends n
  implements k
{
  private g callback;
  final b rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(89773);
    b.a locala = new b.a();
    locala.hvt = new bpe();
    locala.hvu = new bpf();
    locala.uri = "/cgi-bin/micromsg-bin/getroommember";
    locala.funcId = 377;
    locala.reqCmdId = 184;
    locala.respCmdId = 1000000184;
    this.rr = locala.aAz();
    ((bpe)this.rr.hvr.hvw).hOG = paramString;
    ac.d("MicroMsg.NetSceneLbsRoomGetMember", "Req: roomName:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(89773);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(89774);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneLbsRoomGetMember", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (bpf)this.rr.hvs.hvw;
    if (paramInt2 != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89775);
      return;
    }
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < paramq.DPz.size())
    {
      i locali = new i();
      locali.username = ((bpd)paramq.DPz.get(paramInt1)).ncR;
      locali.huF = ((bpd)paramq.DPz.get(paramInt1)).Eof;
      locali.huE = ((bpd)paramq.DPz.get(paramInt1)).Eog;
      locali.ez(true);
      paramArrayOfByte.add(locali);
      paramInt1 += 1;
    }
    p.aBw().al(paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(89775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.e
 * JD-Core Version:    0.7.0.1
 */