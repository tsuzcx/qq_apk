package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.azq;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class j
  extends m
  implements k
{
  private final int dRO;
  private b dmK;
  public f dmL;
  
  public j()
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new azq();
    ((b.a)localObject).ecI = new azr();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_checkgrant";
    ((b.a)localObject).ecG = 2842;
    this.dRO = -1216949095;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (azq)this.dmK.ecE.ecN;
    g.DQ();
    g.DN();
    ((azq)localObject).tvN = a.CK();
    ((azq)localObject).tvO = -1216949095;
    y.i("MicroMsg.NetSceneOauthCheckGrant", "init useruin:%d, bizuin:%d", new Object[] { Integer.valueOf(((azq)localObject).tvN), Integer.valueOf(((azq)localObject).tvO) });
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    ac.a locala;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (azr)((b)paramq).ecF.ecN;
      y.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd bizUin:%d, status:%d", new Object[] { Integer.valueOf(this.dRO), Integer.valueOf(paramq.status) });
      if (this.dRO == -1216949095)
      {
        g.DQ();
        paramArrayOfByte = g.DP().Dz();
        locala = ac.a.upX;
        if (paramq.status != 1) {
          break label170;
        }
      }
    }
    label170:
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfByte.c(locala, Boolean.valueOf(bool));
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
  }
  
  public final int getType()
  {
    return 2842;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.j
 * JD-Core Version:    0.7.0.1
 */