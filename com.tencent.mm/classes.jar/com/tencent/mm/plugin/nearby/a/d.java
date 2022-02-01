package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.btt;
import com.tencent.mm.protocal.protobuf.btu;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends n
  implements k
{
  private f callback;
  public String iHB;
  private final com.tencent.mm.al.b rr;
  public String woh;
  
  public d(float paramFloat1, float paramFloat2, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89769);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new btt();
    ((b.a)localObject).hNN = new btu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((b.a)localObject).funcId = 376;
    ((b.a)localObject).hNO = 183;
    ((b.a)localObject).respCmdId = 1000000183;
    this.rr = ((b.a)localObject).aDC();
    localObject = (btt)this.rr.hNK.hNQ;
    ((btt)localObject).OpCode = 1;
    ((btt)localObject).FOA = paramFloat1;
    ((btt)localObject).FOB = paramFloat2;
    ((btt)localObject).Ggw = paramInt;
    ((btt)localObject).Ggx = paramString1;
    ((btt)localObject).Ggy = paramString2;
    ((btt)localObject).Ggz = 0;
    ad.d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1 lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt + " gpsSource:0 mac" + paramString1 + " cell:" + paramString2);
    AppMethodBeat.o(89769);
  }
  
  public d(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89770);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new btt();
    ((b.a)localObject).hNN = new btu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((b.a)localObject).funcId = 376;
    ((b.a)localObject).hNO = 183;
    ((b.a)localObject).respCmdId = 1000000183;
    this.rr = ((b.a)localObject).aDC();
    localObject = (btt)this.rr.hNK.hNQ;
    ((btt)localObject).FOA = 0.0F;
    ((btt)localObject).FOB = 0.0F;
    ((btt)localObject).Ggw = 0;
    ((btt)localObject).Ggz = 0;
    ((btt)localObject).Ggx = "";
    ((btt)localObject).Ggy = "";
    ((btt)localObject).OpCode = 2;
    ((btt)localObject).ihU = paramString;
    ((btt)localObject).GOl = paramInt1;
    ((btt)localObject).GOk = paramInt2;
    AppMethodBeat.o(89770);
  }
  
  public final int KR()
  {
    return ((btt)this.rr.hNK.hNQ).OpCode;
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
    ad.d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " opCode:" + KR());
    paramArrayOfByte = (btu)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if (paramInt2 != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89772);
      return;
    }
    if (KR() == 1)
    {
      this.iHB = paramArrayOfByte.ihU;
      this.woh = paramArrayOfByte.GOm;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89772);
      return;
    }
    if (KR() == 2)
    {
      b.asX(((btt)((com.tencent.mm.al.b)paramq).hNK.hNQ).ihU);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(89772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.d
 * JD-Core Version:    0.7.0.1
 */