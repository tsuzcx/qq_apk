package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.protocal.protobuf.bgu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class j
  extends m
  implements k
{
  public f callback;
  private final int fhN;
  private b rr;
  
  public j()
  {
    AppMethodBeat.i(36236);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bgt();
    ((b.a)localObject).fsY = new bgu();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_checkgrant";
    ((b.a)localObject).funcId = 2842;
    this.fhN = -1216949095;
    this.rr = ((b.a)localObject).ado();
    localObject = (bgt)this.rr.fsV.fta;
    g.RM();
    g.RJ();
    ((bgt)localObject).xvY = a.getUin();
    ((bgt)localObject).xvZ = -1216949095;
    ab.i("MicroMsg.NetSceneOauthCheckGrant", "init useruin:%d, bizuin:%d", new Object[] { Integer.valueOf(((bgt)localObject).xvY), Integer.valueOf(((bgt)localObject).xvZ) });
    AppMethodBeat.o(36236);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(36237);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(36237);
    return i;
  }
  
  public final int getType()
  {
    return 2842;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36238);
    ab.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    ac.a locala;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bgu)((b)paramq).fsW.fta;
      ab.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd bizUin:%d, status:%d", new Object[] { Integer.valueOf(this.fhN), Integer.valueOf(paramq.status) });
      if (this.fhN == -1216949095)
      {
        g.RM();
        paramArrayOfByte = g.RL().Ru();
        locala = ac.a.yzX;
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
      AppMethodBeat.o(36238);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.j
 * JD-Core Version:    0.7.0.1
 */