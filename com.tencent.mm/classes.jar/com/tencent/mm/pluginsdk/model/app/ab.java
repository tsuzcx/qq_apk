package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.pd;
import com.tencent.mm.protocal.c.pe;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class ab
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  private ab.a rUC;
  
  public ab(String paramString1, String paramString2, String paramString3, int paramInt, ab.a parama)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new pd();
    ((b.a)localObject).ecI = new pe();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkmd5";
    ((b.a)localObject).ecG = 939;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (pd)this.dmK.ecE.ecN;
    ((pd)localObject).fileid = paramString1;
    ((pd)localObject).bIW = paramString2;
    ((pd)localObject).sMP = paramString3;
    ((pd)localObject).sMQ = paramInt;
    this.rUC = parama;
    y.i("MicroMsg.NetSceneCheckMd5", "summersafecdn NetSceneCheckMd5 fileid[%s], md5[%s], newmd5[%s], crc[%d], stack[%s]", new Object[] { ((pd)localObject).fileid, ((pd)localObject).bIW, ((pd)localObject).sMP, Integer.valueOf(((pd)localObject).sMQ), bk.csb() });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneCheckMd5", "summersafecdn onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.rUC != null)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label89;
      }
      paramString = this.rUC;
    }
    for (;;)
    {
      paramArrayOfByte = "";
      paramq = paramString;
      for (paramString = paramArrayOfByte;; paramString = paramArrayOfByte)
      {
        paramq.aa(paramString, paramInt2, paramInt3);
        return;
        label89:
        paramq = (pe)((b)paramq).ecF.ecN;
        paramString = this.rUC;
        if (paramq == null) {
          break;
        }
        paramArrayOfByte = paramq.aeskey;
        paramq = paramString;
      }
    }
  }
  
  public final int getType()
  {
    return 939;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ab
 * JD-Core Version:    0.7.0.1
 */