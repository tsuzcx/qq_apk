package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.bll;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends n
  implements k
{
  private g callback;
  public String hNI;
  private final com.tencent.mm.al.b rr;
  public String tZO;
  
  public d(float paramFloat1, float paramFloat2, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89769);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new blk();
    ((b.a)localObject).gUV = new bll();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((b.a)localObject).funcId = 376;
    ((b.a)localObject).reqCmdId = 183;
    ((b.a)localObject).respCmdId = 1000000183;
    this.rr = ((b.a)localObject).atI();
    localObject = (blk)this.rr.gUS.gUX;
    ((blk)localObject).OpCode = 1;
    ((blk)localObject).COI = paramFloat1;
    ((blk)localObject).COJ = paramFloat2;
    ((blk)localObject).DfE = paramInt;
    ((blk)localObject).DfF = paramString1;
    ((blk)localObject).DfG = paramString2;
    ((blk)localObject).DfH = 0;
    ad.d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1 lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt + " gpsSource:0 mac" + paramString1 + " cell:" + paramString2);
    AppMethodBeat.o(89769);
  }
  
  public d(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89770);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new blk();
    ((b.a)localObject).gUV = new bll();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/joinlbsroom";
    ((b.a)localObject).funcId = 376;
    ((b.a)localObject).reqCmdId = 183;
    ((b.a)localObject).respCmdId = 1000000183;
    this.rr = ((b.a)localObject).atI();
    localObject = (blk)this.rr.gUS.gUX;
    ((blk)localObject).COI = 0.0F;
    ((blk)localObject).COJ = 0.0F;
    ((blk)localObject).DfE = 0;
    ((blk)localObject).DfH = 0;
    ((blk)localObject).DfF = "";
    ((blk)localObject).DfG = "";
    ((blk)localObject).OpCode = 2;
    ((blk)localObject).hod = paramString;
    ((blk)localObject).DJm = paramInt1;
    ((blk)localObject).DJl = paramInt2;
    AppMethodBeat.o(89770);
  }
  
  public final int JJ()
  {
    return ((blk)this.rr.gUS.gUX).OpCode;
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
    ad.d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " opCode:" + JJ());
    paramArrayOfByte = (bll)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if (paramInt2 != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89772);
      return;
    }
    if (JJ() == 1)
    {
      this.hNI = paramArrayOfByte.hod;
      this.tZO = paramArrayOfByte.DJn;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89772);
      return;
    }
    if (JJ() == 2)
    {
      b.aja(((blk)((com.tencent.mm.al.b)paramq).gUS.gUX).hod);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(89772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.d
 * JD-Core Version:    0.7.0.1
 */