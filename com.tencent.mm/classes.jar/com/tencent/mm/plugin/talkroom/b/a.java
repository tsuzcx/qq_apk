package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bxb;
import com.tencent.mm.protocal.c.bxc;
import com.tencent.mm.protocal.c.vr;
import com.tencent.mm.protocal.c.vs;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends f
{
  private final b dmK;
  private com.tencent.mm.ah.f dmL;
  private final String lGF;
  public int lpD;
  public long lpE;
  public LinkedList<bxc> pBF;
  public int pBj;
  public int pBk;
  public LinkedList<bxb> pBm;
  private int sceneType = 0;
  
  public a(String paramString, int paramInt)
  {
    b.a locala = new b.a();
    this.sceneType = paramInt;
    locala.ecH = new vr();
    locala.ecI = new vs();
    locala.uri = "/cgi-bin/micromsg-bin/entertalkroom";
    locala.ecG = 332;
    locala.ecJ = 147;
    locala.ecK = 1000000147;
    this.dmK = locala.Kt();
    ((vr)this.dmK.ecE.ecN).sSS = paramString;
    ((vr)this.dmK.ecE.ecN).pyo = paramInt;
    this.lGF = paramString;
  }
  
  private static LinkedList<bxc> an(LinkedList<bxc> paramLinkedList)
  {
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      bxc localbxc = (bxc)paramLinkedList.next();
      if (!bk.bl(localbxc.hPY)) {
        localLinkedList.add(localbxc);
      }
    }
    return localLinkedList;
  }
  
  private static LinkedList<bxb> ao(LinkedList<bxb> paramLinkedList)
  {
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add((bxb)paramLinkedList.next());
    }
    return localLinkedList;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    y.d("MicroMsg.NetSceneEnterTalkRoom", "doScene %d", new Object[] { Integer.valueOf(this.sceneType) });
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = (vs)this.dmK.ecF.ecN;
    y.i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", new Object[] { paramq.toString() });
    this.lpD = paramq.sST;
    this.lpE = paramq.sSU;
    this.pBj = paramq.sSV;
    this.pBk = paramq.sSX;
    this.pBF = an(paramq.svo);
    this.pBm = ao(paramq.syZ);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final String bMK()
  {
    return this.lGF;
  }
  
  public final int bML()
  {
    return this.sceneType;
  }
  
  public final int getType()
  {
    return 332;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.a
 * JD-Core Version:    0.7.0.1
 */