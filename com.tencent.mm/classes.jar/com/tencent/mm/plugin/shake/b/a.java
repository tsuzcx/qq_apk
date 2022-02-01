package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.af;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bj;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private String nYv;
  int ret;
  private com.tencent.mm.ak.b rr;
  List<d> xwR;
  private int xwS;
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28086);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cxl();
    ((b.a)localObject).hvu = new cxm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakeget";
    ((b.a)localObject).funcId = 162;
    ((b.a)localObject).reqCmdId = 57;
    ((b.a)localObject).respCmdId = 1000000057;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cxl)this.rr.hvr.hvw;
    ((cxl)localObject).DVs = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((cxl)localObject).FGZ = 1;
    try
    {
      paramArrayOfByte = new dun();
      paramArrayOfByte.Gco = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.dkC());
      ((cxl)localObject).DUr = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte.toByteArray());
      AppMethodBeat.o(28086);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      AppMethodBeat.o(28086);
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(28087);
    ac.d("MicroMsg.NetSceneShakeGet", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(28087);
    return i;
  }
  
  public final int getType()
  {
    return 162;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28088);
    ac.d("MicroMsg.NetSceneShakeGet", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (cxm)this.rr.hvs.hvw;
    this.xwR = new LinkedList();
    this.xwS = paramq.FHb;
    this.ret = paramq.Ret;
    this.nYv = paramq.vFm;
    int i = paramq.ncL;
    ac.d("MicroMsg.NetSceneShakeGet", "size:".concat(String.valueOf(i)));
    az.ayM();
    paramArrayOfByte = com.tencent.mm.model.c.awB();
    if (i > 0)
    {
      e locale = m.dDl();
      locale.dDb();
      ac.i("MicroMsg.NewShakeItemStorage", "delOldRecord count:".concat(String.valueOf(i)));
      Object localObject1 = new StringBuilder("DELETE FROM shakeitem1 WHERE shakeItemID NOT IN ( SELECT shakeItemID FROM shakeitem1 ORDER BY shakeItemID DESC LIMIT ");
      label232:
      Object localObject2;
      boolean bool;
      if (100 > i)
      {
        paramInt1 = 100 - i;
        localObject1 = paramInt1 + " )";
        if (locale.db.execSQL("shakeitem1", (String)localObject1))
        {
          ac.i("MicroMsg.NewShakeItemStorage", "delOldRecord success count:".concat(String.valueOf(i)));
          locale.doNotify();
        }
        paramInt1 = i - 1;
        if (paramInt1 < 0) {
          break label767;
        }
        if (!u.axw().equals(((cxk)paramq.FHa.get(paramInt1)).ncR))
        {
          localObject1 = af.aCW().AE(((cxk)paramq.FHa.get(paramInt1)).ncR);
          ((com.tencent.mm.api.c)localObject1).field_username = ((cxk)paramq.FHa.get(paramInt1)).ncR;
          ((com.tencent.mm.api.c)localObject1).field_brandList = ((cxk)paramq.FHa.get(paramInt1)).iKd;
          localObject2 = ((cxk)paramq.FHa.get(paramInt1)).Fex;
          if (localObject2 != null)
          {
            ((com.tencent.mm.api.c)localObject1).field_brandFlag = ((aaf)localObject2).iKh;
            ((com.tencent.mm.api.c)localObject1).field_brandInfo = ((aaf)localObject2).iKj;
            ((com.tencent.mm.api.c)localObject1).field_brandIconURL = ((aaf)localObject2).iKk;
            ((com.tencent.mm.api.c)localObject1).field_extInfo = ((aaf)localObject2).iKi;
          }
          if (!af.aCW().g((com.tencent.mm.api.c)localObject1)) {
            af.aCW().f((com.tencent.mm.api.c)localObject1);
          }
        }
        localObject1 = new d((cxk)paramq.FHa.get(paramInt1));
        localObject2 = new i();
        ((i)localObject2).username = ((d)localObject1).field_username;
        if (((d)localObject1).field_hasHDImg <= 0) {
          break label755;
        }
        bool = true;
        label456:
        ((i)localObject2).ez(bool);
        ((i)localObject2).exK = ((d)localObject1).field_imgstatus;
        ((i)localObject2).huF = ((cxk)paramq.FHa.get(paramInt1)).Eof;
        ((i)localObject2).huE = ((cxk)paramq.FHa.get(paramInt1)).Eog;
        p.aBw().b((i)localObject2);
        ((i)localObject2).drx = -1;
        ac.d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", new Object[] { ((i)localObject2).getUsername(), ((i)localObject2).aBo(), ((i)localObject2).aBp() });
        if (!paramArrayOfByte.aNo(((d)localObject1).field_username)) {
          break label761;
        }
      }
      label755:
      label761:
      for (i = 1;; i = 0)
      {
        ((d)localObject1).field_reserved2 = i;
        localObject2 = paramArrayOfByte.aNt(((d)localObject1).field_username);
        if ((localObject2 != null) && ((int)((com.tencent.mm.n.b)localObject2).fLJ > 0))
        {
          locale.asj(((av)localObject2).field_username);
          locale.asj(((av)localObject2).field_encryptUsername);
        }
        locale.a((d)localObject1, false);
        az.ayM();
        com.tencent.mm.model.c.axc().C(((d)localObject1).field_username, this.xwS, ((cxk)paramq.FHa.get(paramInt1)).ELg);
        ((d)localObject1).scene = this.xwS;
        this.xwR.add(localObject1);
        ac.v("MicroMsg.NetSceneShakeGet", "item info: " + ((d)localObject1).field_username + " " + ((d)localObject1).field_nickname);
        paramInt1 -= 1;
        break label232;
        paramInt1 = 0;
        break;
        bool = false;
        break label456;
      }
    }
    label767:
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.a
 * JD-Core Version:    0.7.0.1
 */