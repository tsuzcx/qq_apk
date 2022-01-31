package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bd;
import com.tencent.mm.protocal.c.be;
import com.tencent.mm.protocal.c.bj;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class l
  extends m
  implements k
{
  private b dmK;
  public f dmL;
  private LinkedList<bj> opM;
  
  public l(LinkedList<bj> paramLinkedList)
  {
    b.a locala = new b.a();
    locala.ecH = new bd();
    locala.ecI = new be();
    locala.uri = "/cgi-bin/mmoc-bin/ad/addatareport";
    locala.ecG = 1295;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((bd)this.dmK.ecE.ecN).suL = paramLinkedList;
    this.opM = paramLinkedList;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneSnsAdDataReport", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1295;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.l
 * JD-Core Version:    0.7.0.1
 */