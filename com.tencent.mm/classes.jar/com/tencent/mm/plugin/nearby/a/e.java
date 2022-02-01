package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.protocal.protobuf.chp;
import com.tencent.mm.protocal.protobuf.chq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  final d rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(89773);
    d.a locala = new d.a();
    locala.iLN = new chp();
    locala.iLO = new chq();
    locala.uri = "/cgi-bin/micromsg-bin/getroommember";
    locala.funcId = 377;
    locala.iLP = 184;
    locala.respCmdId = 1000000184;
    this.rr = locala.aXF();
    ((chp)this.rr.iLK.iLR).jfM = paramString;
    Log.d("MicroMsg.NetSceneLbsRoomGetMember", "Req: roomName:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(89773);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(89774);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(89774);
    return i;
  }
  
  public final int getType()
  {
    return 377;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89775);
    Log.d("MicroMsg.NetSceneLbsRoomGetMember", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    params = (chq)this.rr.iLL.iLR;
    if (paramInt2 != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89775);
      return;
    }
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < params.KGQ.size())
    {
      com.tencent.mm.aj.i locali = new com.tencent.mm.aj.i();
      locali.username = ((cho)params.KGQ.get(paramInt1)).UserName;
      locali.iKX = ((cho)params.KGQ.get(paramInt1)).Lir;
      locali.iKW = ((cho)params.KGQ.get(paramInt1)).Lis;
      locali.fv(true);
      paramArrayOfByte.add(locali);
      paramInt1 += 1;
    }
    p.aYB().av(paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(89775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.e
 * JD-Core Version:    0.7.0.1
 */