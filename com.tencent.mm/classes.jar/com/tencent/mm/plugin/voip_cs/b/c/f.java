package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.sdk.platformtools.ab;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  public b rr;
  
  public f(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(135386);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cse();
    ((b.a)localObject).fsY = new csf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipsync";
    ((b.a)localObject).funcId = 818;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cse)this.rr.fsV.fta;
    ((cse)localObject).xSP = paramLong1;
    ((cse)localObject).wQQ = paramLong2;
    ((cse)localObject).yaP = paramInt;
    ((cse)localObject).xCj = System.currentTimeMillis();
    AppMethodBeat.o(135386);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(135388);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(135388);
    return i;
  }
  
  public final int getType()
  {
    return 818;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(135387);
    ab.i("MicroMsg.NetSceneVoipCSSync", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(135387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.c.f
 * JD-Core Version:    0.7.0.1
 */