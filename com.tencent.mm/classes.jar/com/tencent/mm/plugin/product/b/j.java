package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.protocal.c.bfk;
import com.tencent.mm.protocal.c.bfl;
import com.tencent.mm.protocal.c.bmq;
import com.tencent.mm.protocal.c.wi;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class j
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  public String mRR;
  public LinkedList<wi> mSc;
  public LinkedList<au> mSd;
  
  public j(LinkedList<bmq> paramLinkedList, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bfk();
    ((b.a)localObject).ecI = new bfl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/presubmitorder";
    ((b.a)localObject).ecG = 554;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bfk)this.dmK.ecE.ecN;
    ((bfk)localObject).sHg = paramLinkedList;
    if (paramLinkedList != null) {
      i = paramLinkedList.size();
    }
    ((bfk)localObject).mPW = i;
    ((bfk)localObject).tAd = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = (bfl)((b)paramq).ecF.ecN;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.sHi == 0))
    {
      y.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + paramArrayOfByte.teu);
      y.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + paramArrayOfByte.sHh);
      this.mSc = paramArrayOfByte.tAe;
      this.mRR = paramArrayOfByte.sHh;
      this.mSd = paramArrayOfByte.tAf;
    }
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
    y.d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.dmL.onSceneEnd(paramInt2, paramInt1, paramq, this);
  }
  
  public final int getType()
  {
    return 554;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.j
 * JD-Core Version:    0.7.0.1
 */