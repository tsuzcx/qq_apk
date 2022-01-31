package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ala;
import com.tencent.mm.protocal.c.alb;
import com.tencent.mm.protocal.c.bxc;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends f
{
  private final b dmK;
  private com.tencent.mm.ah.f dmL;
  private final String lGF;
  public LinkedList<bxc> pBF;
  public int pBj;
  private int sceneType = 0;
  
  public c(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    this.sceneType = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ala();
    ((b.a)localObject).ecI = new alb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/gettalkroommember";
    ((b.a)localObject).ecG = 336;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ala)this.dmK.ecE.ecN;
    ((ala)localObject).sST = paramInt1;
    ((ala)localObject).sSU = paramLong;
    this.lGF = paramString;
    ((ala)localObject).pyo = paramInt2;
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
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    y.d("MicroMsg.NetSceneGetTalkRoomMember", "doScene");
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetTalkRoomMember", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = (alb)this.dmK.ecF.ecN;
    y.i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", new Object[] { paramq.toString() });
    this.pBj = paramq.sSV;
    this.pBF = an(paramq.svo);
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
    return 336;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.c
 * JD-Core Version:    0.7.0.1
 */