package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.protocal.protobuf.blr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class r
  extends u
{
  private f callback;
  private com.tencent.mm.ai.b rr;
  
  public r(String paramString)
  {
    this(paramString, null, null, -1, -1, -1);
  }
  
  public r(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(49074);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new blq();
    ((b.a)localObject).fsY = new blr();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/paysubscribe";
    ((b.a)localObject).funcId = 421;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.e.awk(paramString2);
    this.rr = ((b.a)localObject).ado();
    localObject = (blq)this.rr.fsV.fta;
    ((blq)localObject).xAn = paramString1;
    ((blq)localObject).wDH = m.cTC();
    ((blq)localObject).xAo = paramString3;
    if (!bo.isNullOrNil(paramString2)) {
      ((blq)localObject).xAp = new com.tencent.mm.bv.b(paramString2.getBytes());
    }
    if (paramInt1 >= 0) {
      ((blq)localObject).wDC = paramInt1;
    }
    if (paramInt2 >= 0) {
      ((blq)localObject).wkX = paramInt2;
    }
    if (paramInt3 >= 0) {
      ((blq)localObject).xAq = paramInt3;
    }
    AppMethodBeat.o(49074);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(49075);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(49075);
    return i;
  }
  
  public final int getType()
  {
    return 421;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142656);
    ab.d("MicroMsg.NetScenePaySubscribe", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(142656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.r
 * JD-Core Version:    0.7.0.1
 */