package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.protocal.protobuf.bku;
import com.tencent.mm.protocal.protobuf.bkv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.u;

public final class g
  extends u
{
  private f callback;
  private b rr;
  
  public g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43778);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bku();
    ((b.a)localObject).fsY = new bkv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/paydeluserroll";
    ((b.a)localObject).funcId = 389;
    ((b.a)localObject).reqCmdId = 187;
    ((b.a)localObject).respCmdId = 1000000187;
    this.rr = ((b.a)localObject).ado();
    localObject = (bku)this.rr.fsV.fta;
    ((bku)localObject).xzv = 1;
    if (!bo.isNullOrNil(paramString1)) {
      ((bku)localObject).ppY = paramString1;
    }
    if (!bo.isNullOrNil(paramString2)) {
      ((bku)localObject).pqq = paramString2;
    }
    ((bku)localObject).wDH = m.cTC();
    AppMethodBeat.o(43778);
  }
  
  public final int cat()
  {
    return ((bku)this.rr.fsV.fta).xzv;
  }
  
  public final String cau()
  {
    return ((bku)this.rr.fsV.fta).ppY;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(43780);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(43780);
    return i;
  }
  
  public final int getType()
  {
    return 389;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142119);
    ab.d("MicroMsg.NetScenePayDelUserRoll", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(142119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.g
 * JD-Core Version:    0.7.0.1
 */