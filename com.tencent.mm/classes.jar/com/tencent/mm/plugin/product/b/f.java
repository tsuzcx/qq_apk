package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmq;
import com.tencent.mm.protocal.c.lm;
import com.tencent.mm.protocal.c.ln;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class f
  extends m
  implements k
{
  private b dmK;
  private com.tencent.mm.ah.f dmL;
  
  public f(LinkedList<bmq> paramLinkedList, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new lm();
    ((b.a)localObject).ecI = new ln();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/cancelpreorder";
    ((b.a)localObject).ecG = 555;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (lm)this.dmK.ecE.ecN;
    ((lm)localObject).sHg = paramLinkedList;
    if (paramLinkedList != null) {
      i = paramLinkedList.size();
    }
    ((lm)localObject).mPW = i;
    ((lm)localObject).sHh = paramString;
    y.d("MicroMsg.NetSceneMallCancelPreOrder", "lockId " + paramString);
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = (ln)((b)paramq).ecF.ecN;
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramArrayOfByte.sHi != 0)
      {
        paramInt1 = paramArrayOfByte.sHi;
        paramq = paramArrayOfByte.sHj;
      }
    }
    y.d("MicroMsg.NetSceneMallCancelPreOrder", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.dmL.onSceneEnd(paramInt2, paramInt1, paramq, this);
  }
  
  public final int getType()
  {
    return 555;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.f
 * JD-Core Version:    0.7.0.1
 */