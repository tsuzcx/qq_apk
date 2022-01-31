package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.bab;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends m
  implements k
{
  private f callback;
  public String gfM;
  public String pcq;
  private final com.tencent.mm.ai.b rr;
  
  public d(float paramFloat1, float paramFloat2, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(55367);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new baa();
    ((b.a)localObject).fsY = new bab();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((b.a)localObject).funcId = 376;
    ((b.a)localObject).reqCmdId = 183;
    ((b.a)localObject).respCmdId = 1000000183;
    this.rr = ((b.a)localObject).ado();
    localObject = (baa)this.rr.fsV.fta;
    ((baa)localObject).OpCode = 1;
    ((baa)localObject).wDh = paramFloat1;
    ((baa)localObject).wDi = paramFloat2;
    ((baa)localObject).wSk = paramInt;
    ((baa)localObject).wSl = paramString1;
    ((baa)localObject).wSm = paramString2;
    ((baa)localObject).wSn = 0;
    ab.d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1 lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt + " gpsSource:0 mac" + paramString1 + " cell:" + paramString2);
    AppMethodBeat.o(55367);
  }
  
  public d(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55368);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new baa();
    ((b.a)localObject).fsY = new bab();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((b.a)localObject).funcId = 376;
    ((b.a)localObject).reqCmdId = 183;
    ((b.a)localObject).respCmdId = 1000000183;
    this.rr = ((b.a)localObject).ado();
    localObject = (baa)this.rr.fsV.fta;
    ((baa)localObject).wDh = 0.0F;
    ((baa)localObject).wDi = 0.0F;
    ((baa)localObject).wSk = 0;
    ((baa)localObject).wSn = 0;
    ((baa)localObject).wSl = "";
    ((baa)localObject).wSm = "";
    ((baa)localObject).OpCode = 2;
    ((baa)localObject).fLr = paramString;
    ((baa)localObject).xpv = paramInt1;
    ((baa)localObject).xpu = paramInt2;
    AppMethodBeat.o(55368);
  }
  
  public final int Ac()
  {
    return ((baa)this.rr.fsV.fta).OpCode;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(55369);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(55369);
    return i;
  }
  
  public final int getType()
  {
    return 376;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55370);
    ab.d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " opCode:" + Ac());
    paramArrayOfByte = (bab)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if (paramInt2 != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(55370);
      return;
    }
    if (Ac() == 1)
    {
      this.gfM = paramArrayOfByte.fLr;
      this.pcq = paramArrayOfByte.xpw;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(55370);
      return;
    }
    if (Ac() == 2)
    {
      b.VN(((baa)((com.tencent.mm.ai.b)paramq).fsV.fta).fLr);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(55370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.d
 * JD-Core Version:    0.7.0.1
 */