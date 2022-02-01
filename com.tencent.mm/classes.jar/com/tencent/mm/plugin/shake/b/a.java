package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.am.ag;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.dcx;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.dcz;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.g;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private String oBP;
  int ret;
  private com.tencent.mm.al.b rr;
  List<d> yLC;
  private int yLD;
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28086);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dcy();
    ((b.a)localObject).hNN = new dcz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakeget";
    ((b.a)localObject).funcId = 162;
    ((b.a)localObject).hNO = 57;
    ((b.a)localObject).respCmdId = 1000000057;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dcy)this.rr.hNK.hNQ;
    ((dcy)localObject).FAN = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((dcy)localObject).HrH = 1;
    try
    {
      paramArrayOfByte = new eah();
      paramArrayOfByte.HNl = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.duO());
      ((dcy)localObject).FzL = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte.toByteArray());
      AppMethodBeat.o(28086);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      AppMethodBeat.o(28086);
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(28087);
    ad.d("MicroMsg.NetSceneShakeGet", "doScene");
    this.callback = paramf;
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
    paramq = (dcz)this.rr.hNL.hNQ;
    this.yLC = new LinkedList();
    this.yLD = paramq.HrJ;
    this.ret = paramq.Ret;
    this.oBP = paramq.wMs;
    int i = paramq.nDi;
    ad.d("MicroMsg.NetSceneShakeGet", "size:".concat(String.valueOf(i)));
    ba.aBQ();
    paramArrayOfByte = com.tencent.mm.model.c.azp();
    if (i > 0)
    {
      e locale = m.dOO();
      locale.dOE();
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
        if (!u.aAm().equals(((dcx)paramq.HrI.get(paramInt1)).nDo))
        {
          localObject1 = ag.aFZ().DD(((dcx)paramq.HrI.get(paramInt1)).nDo);
          ((com.tencent.mm.api.c)localObject1).field_username = ((dcx)paramq.HrI.get(paramInt1)).nDo;
          ((com.tencent.mm.api.c)localObject1).field_brandList = ((dcx)paramq.HrI.get(paramInt1)).jdm;
          localObject2 = ((dcx)paramq.HrI.get(paramInt1)).GOb;
          if (localObject2 != null)
          {
            ((com.tencent.mm.api.c)localObject1).field_brandFlag = ((acf)localObject2).jdq;
            ((com.tencent.mm.api.c)localObject1).field_brandInfo = ((acf)localObject2).jds;
            ((com.tencent.mm.api.c)localObject1).field_brandIconURL = ((acf)localObject2).jdt;
            ((com.tencent.mm.api.c)localObject1).field_extInfo = ((acf)localObject2).jdr;
          }
          if (!ag.aFZ().g((com.tencent.mm.api.c)localObject1)) {
            ag.aFZ().f((com.tencent.mm.api.c)localObject1);
          }
        }
        localObject1 = new d((dcx)paramq.HrI.get(paramInt1));
        localObject2 = new i();
        ((i)localObject2).username = ((d)localObject1).field_username;
        if (((d)localObject1).field_hasHDImg <= 0) {
          break label755;
        }
        bool = true;
        label456:
        ((i)localObject2).eB(bool);
        ((i)localObject2).ePj = ((d)localObject1).field_imgstatus;
        ((i)localObject2).hMX = ((dcx)paramq.HrI.get(paramInt1)).FVo;
        ((i)localObject2).hMW = ((dcx)paramq.HrI.get(paramInt1)).FVp;
        p.aEx().b((i)localObject2);
        ((i)localObject2).dDp = -1;
        ad.d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", new Object[] { ((i)localObject2).getUsername(), ((i)localObject2).aEq(), ((i)localObject2).aEr() });
        if (!paramArrayOfByte.aTg(((d)localObject1).field_username)) {
          break label761;
        }
      }
      label755:
      label761:
      for (i = 1;; i = 0)
      {
        ((d)localObject1).field_reserved2 = i;
        localObject2 = paramArrayOfByte.Bf(((d)localObject1).field_username);
        if ((localObject2 != null) && ((int)((com.tencent.mm.o.b)localObject2).gfj > 0))
        {
          locale.axj(((aw)localObject2).field_username);
          locale.axj(((aw)localObject2).field_encryptUsername);
        }
        locale.a((d)localObject1, false);
        ba.aBQ();
        com.tencent.mm.model.c.azR().D(((d)localObject1).field_username, this.yLD, ((dcx)paramq.HrI.get(paramInt1)).Guj);
        ((d)localObject1).scene = this.yLD;
        this.yLC.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.a
 * JD-Core Version:    0.7.0.1
 */