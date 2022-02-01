package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.protocal.protobuf.cql;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  final d rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(89773);
    d.a locala = new d.a();
    locala.lBU = new cql();
    locala.lBV = new cqm();
    locala.uri = "/cgi-bin/micromsg-bin/getroommember";
    locala.funcId = 377;
    locala.lBW = 184;
    locala.respCmdId = 1000000184;
    this.rr = locala.bgN();
    ((cql)d.b.b(this.rr.lBR)).lWn = paramString;
    Log.d("MicroMsg.NetSceneLbsRoomGetMember", "Req: roomName:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(89773);
  }
  
  public final int doScene(g paramg, i parami)
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
    params = (cqm)d.c.b(this.rr.lBS);
    if (paramInt2 != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89775);
      return;
    }
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < params.RIk.size())
    {
      j localj = new j();
      localj.username = ((cqk)params.RIk.get(paramInt1)).UserName;
      localj.lBe = ((cqk)params.RIk.get(paramInt1)).SjI;
      localj.lBd = ((cqk)params.RIk.get(paramInt1)).SjJ;
      localj.gg(true);
      paramArrayOfByte.add(localj);
      paramInt1 += 1;
    }
    com.tencent.mm.am.q.bhP().at(paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(89775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.e
 * JD-Core Version:    0.7.0.1
 */