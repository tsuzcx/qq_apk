package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class i
  extends n
  implements k
{
  public com.tencent.mm.al.g callback;
  private final int gIu;
  private b rr;
  
  public i()
  {
    AppMethodBeat.i(95561);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new btw();
    ((b.a)localObject).gUV = new btx();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_checkgrant";
    ((b.a)localObject).funcId = 2842;
    this.gIu = -1216949095;
    this.rr = ((b.a)localObject).atI();
    localObject = (btw)this.rr.gUS.gUX;
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz();
    ((btw)localObject).DRr = a.getUin();
    ((btw)localObject).DRd = -1216949095;
    ad.i("MicroMsg.NetSceneOauthCheckGrant", "init useruin:%d, bizuin:%d", new Object[] { Integer.valueOf(((btw)localObject).DRr), Integer.valueOf(((btw)localObject).DRd) });
    AppMethodBeat.o(95561);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(95562);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95562);
    return i;
  }
  
  public final int getType()
  {
    return 2842;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95563);
    ad.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    ae.a locala;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (btx)((b)paramq).gUT.gUX;
      ad.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd bizUin:%d, status:%d", new Object[] { Integer.valueOf(this.gIu), Integer.valueOf(paramq.status) });
      if (this.gIu == -1216949095)
      {
        com.tencent.mm.kernel.g.afC();
        paramArrayOfByte = com.tencent.mm.kernel.g.afB().afk();
        locala = ae.a.Fit;
        if (paramq.status != 1) {
          break label180;
        }
      }
    }
    label180:
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfByte.set(locala, Boolean.valueOf(bool));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95563);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.i
 * JD-Core Version:    0.7.0.1
 */