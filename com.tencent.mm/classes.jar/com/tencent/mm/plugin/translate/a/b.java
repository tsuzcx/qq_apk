package com.tencent.mm.plugin.translate.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ale;
import com.tencent.mm.protocal.c.alf;
import com.tencent.mm.protocal.c.byz;
import com.tencent.mm.protocal.c.bza;
import java.util.LinkedList;

public final class b
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL = null;
  public LinkedList<bza> pKC;
  
  public b(LinkedList<byz> paramLinkedList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ale();
    ((b.a)localObject).ecI = new alf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/gettranstext";
    ((b.a)localObject).ecG = 631;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ale)this.dmK.ecE.ecN;
    ((ale)localObject).thk = paramLinkedList;
    ((ale)localObject).hPR = paramLinkedList.size();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = (alf)this.dmK.ecF.ecN;
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.pKC = paramq.thk;
  }
  
  public final int getType()
  {
    return 631;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.b
 * JD-Core Version:    0.7.0.1
 */