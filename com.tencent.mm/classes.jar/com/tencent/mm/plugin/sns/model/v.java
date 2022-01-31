package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bui;
import com.tencent.mm.protocal.c.buj;
import com.tencent.mm.protocal.c.buk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class v
  extends com.tencent.mm.ah.m
  implements k
{
  private String bIW;
  private int bMC;
  private b dmK;
  public f dmL;
  public LinkedList<bui> oqE = null;
  public int oqF;
  
  public v(int paramInt)
  {
    this.bMC = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new buj();
    ((b.a)localObject).ecI = new buk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
    ((b.a)localObject).ecG = 292;
    ((b.a)localObject).ecJ = 116;
    ((b.a)localObject).ecK = 1000000116;
    this.dmK = ((b.a)localObject).Kt();
    localObject = af.bDJ().OF("@__weixintsnstag").field_md5;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      this.bIW = ((String)localObject);
      buj localbuj = (buj)this.dmK.ecE.ecN;
      localbuj.ssq = paramInt;
      localbuj.tLc = ((String)localObject);
      return;
    }
  }
  
  public static t a(t paramt, bui parambui)
  {
    paramt.field_tagId = parambui.tLb;
    paramt.field_tagName = bk.aM(parambui.kVl, "");
    paramt.field_count = parambui.hPS;
    paramt.cD(parambui.hPT);
    y.d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + parambui.toString());
    return paramt;
  }
  
  private static boolean a(List<Long> paramList, Long paramLong)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((Long)paramList.next()).longValue() == paramLong.longValue()) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean b(t paramt, bui parambui)
  {
    boolean bool2 = false;
    paramt = paramt.field_memberList.split(",");
    parambui = parambui.hPT.iterator();
    label73:
    label80:
    label83:
    for (;;)
    {
      boolean bool1 = bool2;
      if (parambui.hasNext())
      {
        bml localbml = (bml)parambui.next();
        i = 0;
        if (i >= paramt.length) {
          break label80;
        }
        if (!paramt[i].equals(localbml)) {
          break label73;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label83;
        }
        bool1 = true;
        return bool1;
        i += 1;
        break;
      }
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneSnsTagList", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    Object localObject1 = (buk)((b)paramq).ecF.ecN;
    y.d("MicroMsg.NetSceneSnsTagList", "[onGYNetEnd]State：%s", new Object[] { Integer.valueOf(this.oqF) });
    this.oqF = ((buk)localObject1).oqF;
    this.oqE = ((buk)localObject1).hPT;
    paramq = ((buk)localObject1).tLc;
    if (this.bIW.equals(paramq))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramArrayOfByte = af.bDL().bHe();
    Object localObject2;
    if (this.bMC != 3) {
      localObject2 = paramArrayOfByte.iterator();
    }
    label483:
    for (;;)
    {
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Long)((Iterator)localObject2).next();
        Iterator localIterator = ((buk)localObject1).hPT.iterator();
        bui localbui;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localbui = (bui)localIterator.next();
        } while (((Long)localObject3).longValue() != localbui.tLb);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label483;
        }
        ((Iterator)localObject2).remove();
        af.bDL().gw(((Long)localObject3).longValue());
        break;
        localObject1 = ((buk)localObject1).hPT.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bui)((Iterator)localObject1).next();
          if (!a(paramArrayOfByte, Long.valueOf(((bui)localObject2).tLb)))
          {
            localObject3 = new t();
            a((t)localObject3, (bui)localObject2);
            af.bDL().a((t)localObject3);
          }
          else
          {
            localObject3 = af.bDL().gv(((bui)localObject2).tLb);
            if (((((t)localObject3).field_tagName != null) && (!((t)localObject3).field_tagName.equals(((bui)localObject2).kVl))) || (((t)localObject3).field_count != ((bui)localObject2).hPS) || (b((t)localObject3, (bui)localObject2)))
            {
              a((t)localObject3, (bui)localObject2);
              af.bDL().a((t)localObject3);
            }
          }
        }
        paramArrayOfByte = af.bDJ().OF("@__weixintsnstag");
        paramArrayOfByte.field_md5 = paramq;
        af.bDJ().a(paramArrayOfByte);
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
    }
  }
  
  public final List<String> gb(long paramLong)
  {
    LinkedList localLinkedList = new LinkedList();
    if (this.oqE == null) {
      return localLinkedList;
    }
    Iterator localIterator = this.oqE.iterator();
    while (localIterator.hasNext())
    {
      bui localbui = (bui)localIterator.next();
      if (localbui.tLb == paramLong)
      {
        localIterator = localbui.hPT.iterator();
        while (localIterator.hasNext()) {
          localLinkedList.add(((bml)localIterator.next()).tFO);
        }
        return localLinkedList;
      }
    }
    return localLinkedList;
  }
  
  public final int getType()
  {
    return 292;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.v
 * JD-Core Version:    0.7.0.1
 */