package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.protocal.protobuf.ddi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class j
  extends q
  implements m
{
  public i callback;
  private final int lnn;
  private d rr;
  
  public j()
  {
    AppMethodBeat.i(95561);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ddh();
    ((d.a)localObject).lBV = new ddi();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_checkgrant";
    ((d.a)localObject).funcId = 2842;
    this.lnn = -1216949095;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ddh)d.b.b(this.rr.lBR);
    h.aHH();
    h.aHE();
    ((ddh)localObject).TLf = b.getUin();
    ((ddh)localObject).SnQ = -1216949095;
    Log.i("MicroMsg.NetSceneOauthCheckGrant", "init useruin:%d, bizuin:%d", new Object[] { Integer.valueOf(((ddh)localObject).TLf), Integer.valueOf(((ddh)localObject).SnQ) });
    AppMethodBeat.o(95561);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(95562);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95562);
    return i;
  }
  
  public final int getType()
  {
    return 2842;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95563);
    Log.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    ar.a locala;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (ddi)d.c.b(((d)params).lBS);
      Log.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd bizUin:%d, status:%d", new Object[] { Integer.valueOf(this.lnn), Integer.valueOf(params.status) });
      if (this.lnn == -1216949095)
      {
        h.aHH();
        paramArrayOfByte = h.aHG().aHp();
        locala = ar.a.ViY;
        if (params.status != 1) {
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