package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ea;
import com.tencent.mm.protocal.protobuf.eb;
import com.tencent.mm.sdk.platformtools.ad;

public final class ab
  extends n
  implements k
{
  int BQg;
  aa BQh;
  private g callback;
  private b rr;
  
  public ab(int paramInt, aa paramaa)
  {
    AppMethodBeat.i(151804);
    this.BQg = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ea();
    ((b.a)localObject).gUV = new eb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((b.a)localObject).funcId = 452;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (ea)this.rr.gUS.gUX;
    byte[] arrayOfByte = paramaa.evp();
    if (arrayOfByte != null) {
      ((ea)localObject).ReqBuf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
    }
    ((ea)localObject).mBH = paramInt;
    this.BQh = paramaa;
    AppMethodBeat.o(151804);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(151806);
    this.callback = paramg;
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
    ad.d("MicroMsg.NetSceneAppCenter", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneAppCenter", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151805);
      return;
    }
    this.BQh.cb(z.a(((eb)this.rr.gUT.gUX).Cyq));
    this.BQh.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, this.rr, paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ab
 * JD-Core Version:    0.7.0.1
 */