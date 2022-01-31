package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bao;
import com.tencent.mm.protocal.c.bap;
import com.tencent.mm.protocal.c.cdu;
import java.util.LinkedList;

public final class a
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  
  public a(LinkedList<cdu> paramLinkedList, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bao();
    ((b.a)localObject).ecI = new bap();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/opvoicereminder";
    ((b.a)localObject).ecG = 331;
    ((b.a)localObject).ecJ = 150;
    ((b.a)localObject).ecK = 1000000150;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bao)this.dmK.ecE.ecN;
    ((bao)localObject).ssq = 1;
    ((bao)localObject).tww = paramLinkedList;
    ((bao)localObject).twv = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 331;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.a
 * JD-Core Version:    0.7.0.1
 */