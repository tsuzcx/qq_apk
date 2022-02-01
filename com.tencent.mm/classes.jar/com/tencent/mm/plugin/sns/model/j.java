package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cdy;
import com.tencent.mm.protocal.protobuf.cdz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class j
  extends n
  implements k
{
  public f callback;
  private final int hDS;
  private b rr;
  
  public j()
  {
    AppMethodBeat.i(95561);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cdy();
    ((b.a)localObject).hQG = new cdz();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_checkgrant";
    ((b.a)localObject).funcId = 2842;
    this.hDS = -1216949095;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cdy)this.rr.hQD.hQJ;
    g.ajS();
    g.ajP();
    ((cdy)localObject).HqS = a.getUin();
    ((cdy)localObject).HqE = -1216949095;
    ae.i("MicroMsg.NetSceneOauthCheckGrant", "init useruin:%d, bizuin:%d", new Object[] { Integer.valueOf(((cdy)localObject).HqS), Integer.valueOf(((cdy)localObject).HqE) });
    AppMethodBeat.o(95561);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(95562);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    am.a locala;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cdz)((b)paramq).hQE.hQJ;
      ae.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd bizUin:%d, status:%d", new Object[] { Integer.valueOf(this.hDS), Integer.valueOf(paramq.status) });
      if (this.hDS == -1216949095)
      {
        g.ajS();
        paramArrayOfByte = g.ajR().ajA();
        locala = am.a.IMW;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.model.j
 * JD-Core Version:    0.7.0.1
 */