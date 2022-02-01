package com.tencent.mm.plugin.nearby.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dhe;
import com.tencent.mm.protocal.protobuf.dhf;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends p
  implements m
{
  private h callback;
  final c rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(89773);
    c.a locala = new c.a();
    locala.otE = new dhf();
    locala.otF = new dhg();
    locala.uri = "/cgi-bin/micromsg-bin/getroommember";
    locala.funcId = 377;
    locala.otG = 184;
    locala.respCmdId = 1000000184;
    this.rr = locala.bEF();
    ((dhf)c.b.b(this.rr.otB)).oPp = paramString;
    Log.d("MicroMsg.NetSceneLbsRoomGetMember", "Req: roomName:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(89773);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(89774);
    this.callback = paramh;
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
    params = (dhg)c.c.b(this.rr.otC);
    if (paramInt2 != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89775);
      return;
    }
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < params.YFm.size())
    {
      j localj = new j();
      localj.username = ((dhe)params.YFm.get(paramInt1)).UserName;
      localj.osN = ((dhe)params.YFm.get(paramInt1)).ZhO;
      localj.osM = ((dhe)params.YFm.get(paramInt1)).ZhP;
      localj.gX(true);
      paramArrayOfByte.add(localj);
      paramInt1 += 1;
    }
    q.bFE().bY(paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(89775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.model.e
 * JD-Core Version:    0.7.0.1
 */