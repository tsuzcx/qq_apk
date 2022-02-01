package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dex;
import com.tencent.mm.protocal.protobuf.dko;
import com.tencent.mm.protocal.protobuf.dkp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.w;

public final class l
  extends w
  implements k
{
  private f callback;
  private b rr;
  public String wMg;
  
  public l(dex paramdex, String paramString)
  {
    AppMethodBeat.i(66906);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dko();
    ((b.a)localObject).hNN = new dkp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/submitmallorder";
    ((b.a)localObject).funcId = 556;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dko)this.rr.hNK.hNQ;
    ((dko)localObject).Hzc = paramdex;
    ((dko)localObject).Hze = paramString;
    AppMethodBeat.o(66906);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(66907);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(66907);
    return i;
  }
  
  public final int getType()
  {
    return 556;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66908);
    paramq = (dkp)((b)paramq).hNL.hNQ;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ad.d("MicroMsg.NetSceneMallSubmitMallOrder", "resp.ReqKey " + paramq.Hzd);
      this.wMg = paramq.Hzd;
    }
    ad.d("MicroMsg.NetSceneMallSubmitMallOrder", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(66908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.l
 * JD-Core Version:    0.7.0.1
 */