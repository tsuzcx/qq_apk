package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blh;
import com.tencent.mm.protocal.protobuf.bli;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.sdk.platformtools.ad;
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
    locala.gUU = new bli();
    locala.gUV = new blj();
    locala.uri = "/cgi-bin/micromsg-bin/getroommember";
    locala.funcId = 377;
    locala.reqCmdId = 184;
    locala.respCmdId = 1000000184;
    this.rr = locala.atI();
    ((bli)this.rr.gUS.gUX).hod = paramString;
    ad.d("MicroMsg.NetSceneLbsRoomGetMember", "Req: roomName:".concat(String.valueOf(paramString)));
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
    ad.d("MicroMsg.NetSceneLbsRoomGetMember", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (blj)this.rr.gUT.gUX;
    if (paramInt2 != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89775);
      return;
    }
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < paramq.Cxd.size())
    {
      i locali = new i();
      locali.username = ((blh)paramq.Cxd.get(paramInt1)).mAQ;
      locali.gUg = ((blh)paramq.Cxd.get(paramInt1)).CVv;
      locali.gUf = ((blh)paramq.Cxd.get(paramInt1)).CVw;
      locali.ee(true);
      paramArrayOfByte.add(locali);
      paramInt1 += 1;
    }
    p.auF().ao(paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(89775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.e
 * JD-Core Version:    0.7.0.1
 */