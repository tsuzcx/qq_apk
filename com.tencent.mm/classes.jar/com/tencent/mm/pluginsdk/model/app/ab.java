package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.sdk.platformtools.ae;

public final class ab
  extends n
  implements k
{
  int FfF;
  aa FfG;
  private f callback;
  private b rr;
  
  public ab(int paramInt, aa paramaa)
  {
    AppMethodBeat.i(151804);
    this.FfF = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new eg();
    ((b.a)localObject).hQG = new eh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((b.a)localObject).funcId = 452;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (eg)this.rr.hQD.hQJ;
    byte[] arrayOfByte = paramaa.fdr();
    if (arrayOfByte != null) {
      ((eg)localObject).ReqBuf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
    }
    ((eg)localObject).nJA = paramInt;
    this.FfG = paramaa;
    AppMethodBeat.o(151804);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151806);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151806);
    return i;
  }
  
  public final int getType()
  {
    return 452;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151805);
    ae.d("MicroMsg.NetSceneAppCenter", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneAppCenter", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151805);
      return;
    }
    this.FfG.ck(z.a(((eh)this.rr.hQE.hQJ).FOC));
    this.FfG.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, this.rr, paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ab
 * JD-Core Version:    0.7.0.1
 */