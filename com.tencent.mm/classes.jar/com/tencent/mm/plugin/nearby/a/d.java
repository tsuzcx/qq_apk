package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bun;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
  extends n
  implements k
{
  private f callback;
  public String iKu;
  private final com.tencent.mm.ak.b rr;
  public String wDQ;
  
  public d(float paramFloat1, float paramFloat2, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89769);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bun();
    ((b.a)localObject).hQG = new buo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((b.a)localObject).funcId = 376;
    ((b.a)localObject).hQH = 183;
    ((b.a)localObject).respCmdId = 1000000183;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bun)this.rr.hQD.hQJ;
    ((bun)localObject).OpCode = 1;
    ((bun)localObject).GgZ = paramFloat1;
    ((bun)localObject).Gha = paramFloat2;
    ((bun)localObject).Gzf = paramInt;
    ((bun)localObject).Gzg = paramString1;
    ((bun)localObject).Gzh = paramString2;
    ((bun)localObject).Gzi = 0;
    ae.d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1 lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt + " gpsSource:0 mac" + paramString1 + " cell:" + paramString2);
    AppMethodBeat.o(89769);
  }
  
  public d(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89770);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bun();
    ((b.a)localObject).hQG = new buo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((b.a)localObject).funcId = 376;
    ((b.a)localObject).hQH = 183;
    ((b.a)localObject).respCmdId = 1000000183;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bun)this.rr.hQD.hQJ;
    ((bun)localObject).GgZ = 0.0F;
    ((bun)localObject).Gha = 0.0F;
    ((bun)localObject).Gzf = 0;
    ((bun)localObject).Gzi = 0;
    ((bun)localObject).Gzg = "";
    ((bun)localObject).Gzh = "";
    ((bun)localObject).OpCode = 2;
    ((bun)localObject).ikN = paramString;
    ((bun)localObject).HhL = paramInt1;
    ((bun)localObject).HhK = paramInt2;
    AppMethodBeat.o(89770);
  }
  
  public final int KZ()
  {
    return ((bun)this.rr.hQD.hQJ).OpCode;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(89771);
    this.callback = paramf;
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
    ae.d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " opCode:" + KZ());
    paramArrayOfByte = (buo)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if (paramInt2 != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89772);
      return;
    }
    if (KZ() == 1)
    {
      this.iKu = paramArrayOfByte.ikN;
      this.wDQ = paramArrayOfByte.HhM;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89772);
      return;
    }
    if (KZ() == 2)
    {
      b.auk(((bun)((com.tencent.mm.ak.b)paramq).hQD.hQJ).ikN);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(89772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.d
 * JD-Core Version:    0.7.0.1
 */