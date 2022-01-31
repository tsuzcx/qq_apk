package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.protocal.protobuf.do;
import com.tencent.mm.sdk.platformtools.ab;

public final class y
  extends m
  implements k
{
  private f callback;
  private b rr;
  int vLw;
  x vLx;
  
  public y(int paramInt, x paramx)
  {
    AppMethodBeat.i(79366);
    this.vLw = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new dn();
    ((b.a)localObject).fsY = new do();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((b.a)localObject).funcId = 452;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (dn)this.rr.fsV.fta;
    byte[] arrayOfByte = paramx.dli();
    if (arrayOfByte != null) {
      ((dn)localObject).ReqBuf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
    }
    ((dn)localObject).jKs = paramInt;
    this.vLx = paramx;
    AppMethodBeat.o(79366);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(79368);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(79368);
    return i;
  }
  
  public final int getType()
  {
    return 452;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(79367);
    ab.d("MicroMsg.NetSceneAppCenter", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneAppCenter", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(79367);
      return;
    }
    this.vLx.bJ(aa.a(((do)this.rr.fsW.fta).wpD));
    this.vLx.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, this.rr, paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(79367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.y
 * JD-Core Version:    0.7.0.1
 */