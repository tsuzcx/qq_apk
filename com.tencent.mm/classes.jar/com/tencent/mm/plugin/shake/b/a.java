package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.am.af;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.csb;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bg;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private String nvv;
  int ret;
  private com.tencent.mm.al.b rr;
  List<d> wlB;
  private int wlC;
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28086);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new csc();
    ((b.a)localObject).gUV = new csd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakeget";
    ((b.a)localObject).funcId = 162;
    ((b.a)localObject).reqCmdId = 57;
    ((b.a)localObject).respCmdId = 1000000057;
    this.rr = ((b.a)localObject).atI();
    localObject = (csc)this.rr.gUS.gUX;
    ((csc)localObject).CCV = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((csc)localObject).Ekb = 1;
    try
    {
      paramArrayOfByte = new dow();
      paramArrayOfByte.EFc = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.cWU());
      ((csc)localObject).CBU = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte.toByteArray());
      AppMethodBeat.o(28086);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      AppMethodBeat.o(28086);
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(28087);
    ad.d("MicroMsg.NetSceneShakeGet", "doScene");
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
    ad.d("MicroMsg.NetSceneShakeGet", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (csd)this.rr.gUT.gUX;
    this.wlB = new LinkedList();
    this.wlC = paramq.Ekd;
    this.ret = paramq.Ret;
    this.nvv = paramq.uwt;
    int i = paramq.mAK;
    ad.d("MicroMsg.NetSceneShakeGet", "size:".concat(String.valueOf(i)));
    az.arV();
    paramArrayOfByte = com.tencent.mm.model.c.apM();
    if (i > 0)
    {
      e locale = m.dpb();
      locale.doR();
      ad.i("MicroMsg.NewShakeItemStorage", "delOldRecord count:".concat(String.valueOf(i)));
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
          ad.i("MicroMsg.NewShakeItemStorage", "delOldRecord success count:".concat(String.valueOf(i)));
          locale.doNotify();
        }
        paramInt1 = i - 1;
        if (paramInt1 < 0) {
          break label767;
        }
        if (!u.aqG().equals(((csb)paramq.Ekc.get(paramInt1)).mAQ))
        {
          localObject1 = af.awe().wy(((csb)paramq.Ekc.get(paramInt1)).mAQ);
          ((com.tencent.mm.api.c)localObject1).field_username = ((csb)paramq.Ekc.get(paramInt1)).mAQ;
          ((com.tencent.mm.api.c)localObject1).field_brandList = ((csb)paramq.Ekc.get(paramInt1)).ijW;
          localObject2 = ((csb)paramq.Ekc.get(paramInt1)).DJc;
          if (localObject2 != null)
          {
            ((com.tencent.mm.api.c)localObject1).field_brandFlag = ((zh)localObject2).ika;
            ((com.tencent.mm.api.c)localObject1).field_brandInfo = ((zh)localObject2).ikc;
            ((com.tencent.mm.api.c)localObject1).field_brandIconURL = ((zh)localObject2).ikd;
            ((com.tencent.mm.api.c)localObject1).field_extInfo = ((zh)localObject2).ikb;
          }
          if (!af.awe().g((com.tencent.mm.api.c)localObject1)) {
            af.awe().f((com.tencent.mm.api.c)localObject1);
          }
        }
        localObject1 = new d((csb)paramq.Ekc.get(paramInt1));
        localObject2 = new i();
        ((i)localObject2).username = ((d)localObject1).field_username;
        if (((d)localObject1).field_hasHDImg <= 0) {
          break label755;
        }
        bool = true;
        label456:
        ((i)localObject2).ee(bool);
        ((i)localObject2).evo = ((d)localObject1).field_imgstatus;
        ((i)localObject2).gUg = ((csb)paramq.Ekc.get(paramInt1)).CVv;
        ((i)localObject2).gUf = ((csb)paramq.Ekc.get(paramInt1)).CVw;
        p.auF().b((i)localObject2);
        ((i)localObject2).dtM = -1;
        ad.d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", new Object[] { ((i)localObject2).getUsername(), ((i)localObject2).aux(), ((i)localObject2).auy() });
        if (!paramArrayOfByte.aHT(((d)localObject1).field_username)) {
          break label761;
        }
      }
      label755:
      label761:
      for (i = 1;; i = 0)
      {
        ((d)localObject1).field_reserved2 = i;
        localObject2 = paramArrayOfByte.aHY(((d)localObject1).field_username);
        if ((localObject2 != null) && ((int)((com.tencent.mm.n.b)localObject2).fId > 0))
        {
          locale.ana(((au)localObject2).field_username);
          locale.ana(((au)localObject2).field_encryptUsername);
        }
        locale.a((d)localObject1, false);
        az.arV();
        com.tencent.mm.model.c.aqn().D(((d)localObject1).field_username, this.wlC, ((csb)paramq.Ekc.get(paramInt1)).Dqd);
        ((d)localObject1).scene = this.wlC;
        this.wlB.add(localObject1);
        ad.v("MicroMsg.NetSceneShakeGet", "item info: " + ((d)localObject1).field_username + " " + ((d)localObject1).field_nickname);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.a
 * JD-Core Version:    0.7.0.1
 */