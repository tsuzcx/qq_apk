package com.tencent.mm.plugin.nearlife.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ato;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.se;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class b
  extends m
  implements k
{
  private com.tencent.mm.ah.b ecz;
  private f mEe;
  public String mEf;
  
  public b(String paramString1, String paramString2, String paramString3, ato paramato, int paramInt, LinkedList<bml> paramLinkedList, String paramString4)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new se();
    ((b.a)localObject).ecI = new sf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/createpoi";
    ((b.a)localObject).ecG = 650;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.ecz = ((b.a)localObject).Kt();
    paramString4 = bk.aM(paramString4, "");
    localObject = bk.aM(null, "");
    se localse = (se)this.ecz.ecE.ecN;
    localse.kRZ = paramString1;
    localse.sQh = paramString2;
    localse.sQj = paramato;
    localse.hPS = paramInt;
    if (paramLinkedList != null) {
      localse.sQk = paramLinkedList;
    }
    localse.sQl = paramString4;
    localse.sQm = ((String)localObject);
    localse.sQi = paramString3;
    y.d("MicroMsg.NetSceneCreatePoi", "[req] name:%s, district:%s, Street: %s lat:%f, long:%f, count:%d, tel:%s, url:%s", new Object[] { paramString1, paramString2, paramString3, Float.valueOf(paramato.sGK), Float.valueOf(paramato.sGJ), Integer.valueOf(paramInt), paramString4, localObject });
  }
  
  public final int a(e parame, f paramf)
  {
    this.mEe = paramf;
    return a(parame, this.ecz, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneCreatePoi", "netId:%d, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (sf)this.ecz.ecF.ecN;
    if (this.ecz.ecF.spN != 0)
    {
      this.mEe.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.mEf = paramq.sQn;
    y.d("MicroMsg.NetSceneCreatePoi", "poi:" + this.mEf);
    this.mEe.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 650;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.b
 * JD-Core Version:    0.7.0.1
 */