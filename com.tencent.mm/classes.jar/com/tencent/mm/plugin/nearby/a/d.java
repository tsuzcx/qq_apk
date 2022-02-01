package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bpg;
import com.tencent.mm.protocal.protobuf.bph;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  extends n
  implements k
{
  private g callback;
  public String ioe;
  private final com.tencent.mm.ak.b rr;
  public String viO;
  
  public d(float paramFloat1, float paramFloat2, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89769);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bpg();
    ((b.a)localObject).hvu = new bph();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((b.a)localObject).funcId = 376;
    ((b.a)localObject).reqCmdId = 183;
    ((b.a)localObject).respCmdId = 1000000183;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bpg)this.rr.hvr.hvw;
    ((bpg)localObject).OpCode = 1;
    ((bpg)localObject).Eht = paramFloat1;
    ((bpg)localObject).Ehu = paramFloat2;
    ((bpg)localObject).EyK = paramInt;
    ((bpg)localObject).EyL = paramString1;
    ((bpg)localObject).EyM = paramString2;
    ((bpg)localObject).EyN = 0;
    ac.d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1 lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt + " gpsSource:0 mac" + paramString1 + " cell:" + paramString2);
    AppMethodBeat.o(89769);
  }
  
  public d(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89770);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bpg();
    ((b.a)localObject).hvu = new bph();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((b.a)localObject).funcId = 376;
    ((b.a)localObject).reqCmdId = 183;
    ((b.a)localObject).respCmdId = 1000000183;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bpg)this.rr.hvr.hvw;
    ((bpg)localObject).Eht = 0.0F;
    ((bpg)localObject).Ehu = 0.0F;
    ((bpg)localObject).EyK = 0;
    ((bpg)localObject).EyN = 0;
    ((bpg)localObject).EyL = "";
    ((bpg)localObject).EyM = "";
    ((bpg)localObject).OpCode = 2;
    ((bpg)localObject).hOG = paramString;
    ((bpg)localObject).FeH = paramInt1;
    ((bpg)localObject).FeG = paramInt2;
    AppMethodBeat.o(89770);
  }
  
  public final int Js()
  {
    return ((bpg)this.rr.hvr.hvw).OpCode;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(89771);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(89771);
    return i;
  }
  
  public final int getType()
  {
    return 376;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89772);
    ac.d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " opCode:" + Js());
    paramArrayOfByte = (bph)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if (paramInt2 != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89772);
      return;
    }
    if (Js() == 1)
    {
      this.ioe = paramArrayOfByte.hOG;
      this.viO = paramArrayOfByte.FeI;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89772);
      return;
    }
    if (Js() == 2)
    {
      b.anY(((bpg)((com.tencent.mm.ak.b)paramq).hvr.hvw).hOG);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(89772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.d
 * JD-Core Version:    0.7.0.1
 */