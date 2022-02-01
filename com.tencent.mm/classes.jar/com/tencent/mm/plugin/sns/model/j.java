package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.protocal.protobuf.dvd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class j
  extends p
  implements m
{
  public com.tencent.mm.am.h callback;
  private final int nSr;
  private c rr;
  
  public j()
  {
    AppMethodBeat.i(95561);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dvc();
    ((c.a)localObject).otF = new dvd();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_checkgrant";
    ((c.a)localObject).funcId = 2842;
    this.nSr = -1216949095;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dvc)c.b.b(this.rr.otB);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC();
    ((dvc)localObject).abbb = b.getUin();
    ((dvc)localObject).Zms = -1216949095;
    Log.i("MicroMsg.NetSceneOauthCheckGrant", "init useruin:%d, bizuin:%d", new Object[] { Integer.valueOf(((dvc)localObject).abbb), Integer.valueOf(((dvc)localObject).Zms) });
    AppMethodBeat.o(95561);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(95562);
    this.callback = paramh;
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
    at.a locala;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (dvd)c.c.b(((c)params).otC);
      Log.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd bizUin:%d, status:%d", new Object[] { Integer.valueOf(this.nSr), Integer.valueOf(params.status) });
      if (this.nSr == -1216949095)
      {
        com.tencent.mm.kernel.h.baF();
        paramArrayOfByte = com.tencent.mm.kernel.h.baE().ban();
        locala = at.a.acKs;
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