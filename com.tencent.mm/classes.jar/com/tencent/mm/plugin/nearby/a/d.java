package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cqn;
import com.tencent.mm.protocal.protobuf.cqo;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  public String GsA;
  private i callback;
  public String mye;
  private final com.tencent.mm.an.d rr;
  
  public d(float paramFloat1, float paramFloat2, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89769);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cqn();
    ((d.a)localObject).lBV = new cqo();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((d.a)localObject).funcId = 376;
    ((d.a)localObject).lBW = 183;
    ((d.a)localObject).respCmdId = 1000000183;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cqn)d.b.b(this.rr.lBR);
    ((cqn)localObject).RLe = 1;
    ((cqn)localObject).ScO = paramFloat1;
    ((cqn)localObject).ScP = paramFloat2;
    ((cqn)localObject).Sxt = paramInt;
    ((cqn)localObject).Sxu = paramString1;
    ((cqn)localObject).Sxv = paramString2;
    ((cqn)localObject).Sxw = 0;
    Log.d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1 lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt + " gpsSource:0 mac" + paramString1 + " cell:" + paramString2);
    AppMethodBeat.o(89769);
  }
  
  public d(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89770);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cqn();
    ((d.a)localObject).lBV = new cqo();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((d.a)localObject).funcId = 376;
    ((d.a)localObject).lBW = 183;
    ((d.a)localObject).respCmdId = 1000000183;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cqn)d.b.b(this.rr.lBR);
    ((cqn)localObject).ScO = 0.0F;
    ((cqn)localObject).ScP = 0.0F;
    ((cqn)localObject).Sxt = 0;
    ((cqn)localObject).Sxw = 0;
    ((cqn)localObject).Sxu = "";
    ((cqn)localObject).Sxv = "";
    ((cqn)localObject).RLe = 2;
    ((cqn)localObject).lWn = paramString;
    ((cqn)localObject).TxX = paramInt1;
    ((cqn)localObject).TxW = paramInt2;
    AppMethodBeat.o(89770);
  }
  
  public final int ZB()
  {
    AppMethodBeat.i(232022);
    int i = ((cqn)d.b.b(this.rr.lBR)).RLe;
    AppMethodBeat.o(232022);
    return i;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(89771);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(89771);
    return i;
  }
  
  public final int getType()
  {
    return 376;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89772);
    Log.d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " opCode:" + ZB());
    paramArrayOfByte = (cqo)d.c.b(((com.tencent.mm.an.d)params).lBS);
    if (paramInt2 != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89772);
      return;
    }
    if (ZB() == 1)
    {
      this.mye = paramArrayOfByte.lWn;
      this.GsA = paramArrayOfByte.TxY;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89772);
      return;
    }
    if (ZB() == 2)
    {
      b.aSN(((cqn)d.b.b(((com.tencent.mm.an.d)params).lBR)).lWn);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(89772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.d
 * JD-Core Version:    0.7.0.1
 */