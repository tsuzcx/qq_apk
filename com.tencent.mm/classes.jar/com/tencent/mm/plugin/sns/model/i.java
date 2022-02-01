package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class i
  extends n
  implements k
{
  public com.tencent.mm.ak.g callback;
  private final int hiV;
  private b rr;
  
  public i()
  {
    AppMethodBeat.i(95561);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new byn();
    ((b.a)localObject).hvu = new byo();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_checkgrant";
    ((b.a)localObject).funcId = 2842;
    this.hiV = -1216949095;
    this.rr = ((b.a)localObject).aAz();
    localObject = (byn)this.rr.hvr.hvw;
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP();
    ((byn)localObject).FnJ = a.getUin();
    ((byn)localObject).Fnv = -1216949095;
    ac.i("MicroMsg.NetSceneOauthCheckGrant", "init useruin:%d, bizuin:%d", new Object[] { Integer.valueOf(((byn)localObject).FnJ), Integer.valueOf(((byn)localObject).Fnv) });
    AppMethodBeat.o(95561);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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
    ac.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    ah.a locala;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (byo)((b)paramq).hvs.hvw;
      ac.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd bizUin:%d, status:%d", new Object[] { Integer.valueOf(this.hiV), Integer.valueOf(paramq.status) });
      if (this.hiV == -1216949095)
      {
        com.tencent.mm.kernel.g.agS();
        paramArrayOfByte = com.tencent.mm.kernel.g.agR().agA();
        locala = ah.a.GGi;
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