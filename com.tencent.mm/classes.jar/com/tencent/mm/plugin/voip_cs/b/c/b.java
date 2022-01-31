package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends m
  implements k
{
  private f callback;
  private com.tencent.mm.ai.b rr;
  
  public b(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(135374);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cru();
    ((b.a)localObject).fsY = new crv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipheartbeat";
    ((b.a)localObject).funcId = 795;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cru)this.rr.fsV.fta;
    ((cru)localObject).xSP = paramLong1;
    ((cru)localObject).wQQ = paramLong2;
    ((cru)localObject).xCj = System.currentTimeMillis();
    AppMethodBeat.o(135374);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(135376);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(135376);
    return i;
  }
  
  public final int getType()
  {
    return 795;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(135375);
    ab.i("MicroMsg.NetSceneVoipCSHeartBeat", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(135375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.c.b
 * JD-Core Version:    0.7.0.1
 */