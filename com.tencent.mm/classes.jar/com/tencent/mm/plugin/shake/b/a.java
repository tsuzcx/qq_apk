package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bqy;
import com.tencent.mm.protocal.c.bqz;
import com.tencent.mm.protocal.c.bra;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.g;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.ah.m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  private String ioU;
  List<d> nYE;
  private int nYF;
  int ret;
  
  public a(byte[] paramArrayOfByte)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bqz();
    ((b.a)localObject).ecI = new bra();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakeget";
    ((b.a)localObject).ecG = 162;
    ((b.a)localObject).ecJ = 57;
    ((b.a)localObject).ecK = 1000000057;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bqz)this.dmK.ecE.ecN;
    ((bqz)localObject).szp = new bmk().bs(paramArrayOfByte);
    ((bqz)localObject).tHL = 1;
    ((bqz)localObject).tpt = new bmk().bs(com.tencent.mm.plugin.normsg.a.b.mGK.boP());
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    y.d("MicroMsg.NetSceneShakeGet", "doScene");
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneShakeGet", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (bra)this.dmK.ecF.ecN;
    this.nYE = new LinkedList();
    this.nYF = paramq.tHN;
    this.ret = paramq.sze;
    this.ioU = paramq.mSC;
    int i = paramq.hPS;
    y.d("MicroMsg.NetSceneShakeGet", "size:" + i);
    au.Hx();
    paramArrayOfByte = c.Fw();
    if (i > 0)
    {
      e locale = m.bzU();
      locale.bzM();
      y.i("MicroMsg.NewShakeItemStorage", "delOldRecord count:" + i);
      Object localObject1 = new StringBuilder("DELETE FROM shakeitem1 WHERE shakeItemID NOT IN ( SELECT shakeItemID FROM shakeitem1 ORDER BY shakeItemID DESC LIMIT ");
      label247:
      Object localObject2;
      boolean bool;
      if (100 > i)
      {
        paramInt1 = 100 - i;
        localObject1 = paramInt1 + " )";
        if (locale.dXw.gk("shakeitem1", (String)localObject1))
        {
          y.i("MicroMsg.NewShakeItemStorage", "delOldRecord success count:" + i);
          locale.doNotify();
        }
        paramInt1 = i - 1;
        if (paramInt1 < 0) {
          break label782;
        }
        if (!com.tencent.mm.model.q.Gj().equals(((bqy)paramq.tHM.get(paramInt1)).hPY))
        {
          localObject1 = z.My().kQ(((bqy)paramq.tHM.get(paramInt1)).hPY);
          ((com.tencent.mm.ai.d)localObject1).field_username = ((bqy)paramq.tHM.get(paramInt1)).hPY;
          ((com.tencent.mm.ai.d)localObject1).field_brandList = ((bqy)paramq.tHM.get(paramInt1)).ffr;
          localObject2 = ((bqy)paramq.tHM.get(paramInt1)).tpn;
          if (localObject2 != null)
          {
            ((com.tencent.mm.ai.d)localObject1).field_brandFlag = ((sg)localObject2).ffv;
            ((com.tencent.mm.ai.d)localObject1).field_brandInfo = ((sg)localObject2).ffx;
            ((com.tencent.mm.ai.d)localObject1).field_brandIconURL = ((sg)localObject2).ffy;
            ((com.tencent.mm.ai.d)localObject1).field_extInfo = ((sg)localObject2).ffw;
          }
          if (!z.My().e((com.tencent.mm.ai.d)localObject1)) {
            z.My().d((com.tencent.mm.ai.d)localObject1);
          }
        }
        localObject1 = new d((bqy)paramq.tHM.get(paramInt1));
        localObject2 = new h();
        ((h)localObject2).username = ((d)localObject1).field_username;
        if (((d)localObject1).field_hasHDImg <= 0) {
          break label770;
        }
        bool = true;
        label471:
        ((h)localObject2).bK(bool);
        ((h)localObject2).cCq = ((d)localObject1).field_imgstatus;
        ((h)localObject2).ebT = ((bqy)paramq.tHM.get(paramInt1)).sLD;
        ((h)localObject2).ebS = ((bqy)paramq.tHM.get(paramInt1)).sLE;
        o.Kh().a((h)localObject2);
        ((h)localObject2).bcw = -1;
        y.d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", new Object[] { ((h)localObject2).getUsername(), ((h)localObject2).JX(), ((h)localObject2).JY() });
        if (!paramArrayOfByte.abg(((d)localObject1).field_username)) {
          break label776;
        }
      }
      label770:
      label776:
      for (i = 1;; i = 0)
      {
        ((d)localObject1).field_reserved2 = i;
        localObject2 = paramArrayOfByte.abl(((d)localObject1).field_username);
        if ((localObject2 != null) && ((int)((com.tencent.mm.n.a)localObject2).dBe > 0))
        {
          locale.Mu(((ao)localObject2).field_username);
          locale.Mu(((ao)localObject2).field_encryptUsername);
        }
        locale.a((d)localObject1, false);
        au.Hx();
        c.Ga().z(((d)localObject1).field_username, this.nYF, ((bqy)paramq.tHM.get(paramInt1)).tac);
        ((d)localObject1).scene = this.nYF;
        this.nYE.add(localObject1);
        y.v("MicroMsg.NetSceneShakeGet", "item info: " + ((d)localObject1).field_username + " " + ((d)localObject1).field_nickname);
        paramInt1 -= 1;
        break label247;
        paramInt1 = 0;
        break;
        bool = false;
        break label471;
      }
    }
    label782:
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 162;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.a
 * JD-Core Version:    0.7.0.1
 */