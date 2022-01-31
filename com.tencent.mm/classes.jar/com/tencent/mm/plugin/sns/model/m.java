package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bkk;
import com.tencent.mm.protocal.c.bss;
import com.tencent.mm.protocal.c.bst;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends com.tencent.mm.ah.m
  implements com.tencent.mm.network.k
{
  public static List<Long> opN = Collections.synchronizedList(new LinkedList());
  public static List<Long> opO = Collections.synchronizedList(new LinkedList());
  private b dmK;
  public com.tencent.mm.ah.f dmL;
  private long eAA;
  private String eFp;
  
  public m(long paramLong, int paramInt, String paramString)
  {
    this.eAA = paramLong;
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new bst();
    ((b.a)localObject1).ecI = new bsu();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
    ((b.a)localObject1).ecG = 683;
    Object localObject2 = new StringBuilder();
    g.DQ();
    this.eFp = (g.DP().cachePath + "ad_detail_session");
    int i;
    if (aq.isWifi(ae.getContext())) {
      i = 1;
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.vfs.e.c(this.eFp, 0, -1);
      this.dmK = ((b.a)localObject1).Kt();
      ((bst)this.dmK.ecE.ecN).sGd = paramLong;
      ((bst)this.dmK.ecE.ecN).tJk = aa.I((byte[])localObject2);
      ((bst)this.dmK.ecE.ecN).pyo = paramInt;
      ((bst)this.dmK.ecE.ecN).tJm = i;
      if ((paramString != null) && (paramString.length() > 0)) {
        ((bst)this.dmK.ecE.ecN).tJl = aa.pk(paramString);
      }
      localObject1 = new StringBuilder("req snsId ").append(paramLong).append(" ").append(com.tencent.mm.plugin.sns.data.i.fN(paramLong)).append(" scene ").append(paramInt).append(" buf is null? ");
      if (localObject2 == null) {}
      for (boolean bool = true;; bool = false)
      {
        y.d("MicroMsg.NetSceneSnsAdObjectDetial", bool);
        y.i("MicroMsg.NetSceneSnsAdObjectDetial", "do adObjectDetail snsId[%d] scene[%d] syncBuffer[%s]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString });
        return;
        if (aq.is3G(ae.getContext()))
        {
          i = 3;
          break;
        }
        if (aq.is4G(ae.getContext()))
        {
          i = 4;
          break;
        }
        if (!aq.is2G(ae.getContext())) {
          break label378;
        }
        i = 2;
        break;
      }
      label378:
      i = 0;
    }
  }
  
  public m(long paramLong, bkk parambkk)
  {
    this(paramLong, 2, "");
    ((bst)this.dmK.ecE.ecN).swb = parambkk;
  }
  
  public static boolean fS(long paramLong)
  {
    if (opN.contains(Long.valueOf(paramLong))) {
      return false;
    }
    opN.add(Long.valueOf(paramLong));
    return true;
  }
  
  public static boolean fT(long paramLong)
  {
    if (opO.contains(Long.valueOf(paramLong))) {
      return false;
    }
    opO.add(Long.valueOf(paramLong));
    return true;
  }
  
  private static boolean fU(long paramLong)
  {
    opO.remove(Long.valueOf(paramLong));
    return true;
  }
  
  private static boolean fV(long paramLong)
  {
    opN.remove(Long.valueOf(paramLong));
    return true;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneSnsAdObjectDetial", "errType " + paramInt2 + " errCode " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        fV(this.eAA);
        fU(this.eAA);
        return;
        if ((paramInt2 == 4) && (paramInt3 == 1))
        {
          paramq = aa.a(((bsu)this.dmK.ecF.ecN).tJk);
          if (paramq != null)
          {
            com.tencent.mm.vfs.e.deleteFile(this.eFp);
            com.tencent.mm.vfs.e.b(this.eFp, paramq, paramq.length);
          }
          paramInt1 = 0;
        }
      }
      else
      {
        paramq = aa.a(((bsu)this.dmK.ecF.ecN).tJk);
        com.tencent.mm.vfs.e.deleteFile(this.eFp);
        com.tencent.mm.vfs.e.b(this.eFp, paramq, paramq.length);
        paramq = ((bsu)this.dmK.ecF.ecN).tJn;
        paramArrayOfByte = ((bsu)this.dmK.ecF.ecN).tJo;
        paramInt1 = ((bst)this.dmK.ecE.ecN).pyo;
        if (paramq != null)
        {
          y.i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail xml " + aa.b(paramq.tJi.tJU));
          y.i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml " + paramq.tJj);
        }
        if ((paramq != null) && (paramq.tJi != null) && (paramq.tJi.ttD > 0))
        {
          y.i("MicroMsg.NetSceneSnsAdObjectDetial", paramq.tJi.sGd + " will remove by get detail ");
          fV(this.eAA);
          fU(this.eAA);
          af.bDI().delete(paramq.tJi.sGd);
          af.bDK().go(paramq.tJi.sGd);
          com.tencent.mm.plugin.sns.storage.i.gn(paramq.tJi.sGd);
          this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
          return;
        }
        if ((paramq != null) && (paramq.tJi != null)) {
          y.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment:" + paramq.tJi.tKb.size() + " like: " + paramq.tJi.tJY.size());
        }
        if (paramInt1 == 2)
        {
          y.i("MicroMsg.NetSceneSnsAdObjectDetial", "get atDetail %s", new Object[] { Long.valueOf(this.eAA) });
          paramq = ((bsu)this.dmK.ecF.ecN).tJp;
          if (paramq != null) {
            a.a(paramq);
          }
        }
        for (;;)
        {
          this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
          fV(this.eAA);
          fU(this.eAA);
          return;
          a.a(paramq, paramArrayOfByte);
        }
      }
      paramInt1 = 0;
    }
  }
  
  public final int getType()
  {
    return 683;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.m
 * JD-Core Version:    0.7.0.1
 */