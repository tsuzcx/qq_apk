package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.crz;
import com.tencent.mm.protocal.protobuf.csa;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends m
  implements k
{
  private f callback;
  public b rr;
  
  public d(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(135380);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new crz();
    ((b.a)localObject).fsY = new csa();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipredirect";
    ((b.a)localObject).funcId = 285;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (crz)this.rr.fsV.fta;
    ((crz)localObject).xSP = paramLong1;
    ((crz)localObject).wQQ = paramLong2;
    ((crz)localObject).xCj = System.currentTimeMillis();
    AppMethodBeat.o(135380);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(135382);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(135382);
    return i;
  }
  
  public final int getType()
  {
    return 285;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(135381);
    ab.i("MicroMsg.NetSceneVoipCSRedirect", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(135381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.c.d
 * JD-Core Version:    0.7.0.1
 */