package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cbj;
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.g;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  private String kqb;
  List<d> qMO;
  private int qMP;
  int ret;
  private com.tencent.mm.ai.b rr;
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24411);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cbk();
    ((b.a)localObject).fsY = new cbl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakeget";
    ((b.a)localObject).funcId = 162;
    ((b.a)localObject).reqCmdId = 57;
    ((b.a)localObject).respCmdId = 1000000057;
    this.rr = ((b.a)localObject).ado();
    localObject = (cbk)this.rr.fsV.fta;
    ((cbk)localObject).wtq = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((cbk)localObject).xMd = 1;
    try
    {
      paramArrayOfByte = new cuv();
      paramArrayOfByte.ydy = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.pgQ.bXq());
      ((cbk)localObject).wss = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte.toByteArray());
      AppMethodBeat.o(24411);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      AppMethodBeat.o(24411);
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(24412);
    ab.d("MicroMsg.NetSceneShakeGet", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(24412);
    return i;
  }
  
  public final int getType()
  {
    return 162;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24413);
    ab.d("MicroMsg.NetSceneShakeGet", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (cbl)this.rr.fsW.fta;
    this.qMO = new LinkedList();
    this.qMP = paramq.xMf;
    this.ret = paramq.Ret;
    this.kqb = paramq.puI;
    int i = paramq.jJu;
    ab.d("MicroMsg.NetSceneShakeGet", "size:".concat(String.valueOf(i)));
    aw.aaz();
    paramArrayOfByte = c.YA();
    if (i > 0)
    {
      e locale = m.cln();
      locale.cld();
      ab.i("MicroMsg.NewShakeItemStorage", "delOldRecord count:".concat(String.valueOf(i)));
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
          ab.i("MicroMsg.NewShakeItemStorage", "delOldRecord success count:".concat(String.valueOf(i)));
          locale.doNotify();
        }
        paramInt1 = i - 1;
        if (paramInt1 < 0) {
          break label767;
        }
        if (!r.Zn().equals(((cbj)paramq.xMe.get(paramInt1)).jJA))
        {
          localObject1 = z.afi().rK(((cbj)paramq.xMe.get(paramInt1)).jJA);
          ((com.tencent.mm.aj.d)localObject1).field_username = ((cbj)paramq.xMe.get(paramInt1)).jJA;
          ((com.tencent.mm.aj.d)localObject1).field_brandList = ((cbj)paramq.xMe.get(paramInt1)).gwZ;
          localObject2 = ((cbj)paramq.xMe.get(paramInt1)).xpl;
          if (localObject2 != null)
          {
            ((com.tencent.mm.aj.d)localObject1).field_brandFlag = ((wc)localObject2).gxd;
            ((com.tencent.mm.aj.d)localObject1).field_brandInfo = ((wc)localObject2).gxf;
            ((com.tencent.mm.aj.d)localObject1).field_brandIconURL = ((wc)localObject2).gxg;
            ((com.tencent.mm.aj.d)localObject1).field_extInfo = ((wc)localObject2).gxe;
          }
          if (!z.afi().e((com.tencent.mm.aj.d)localObject1)) {
            z.afi().d((com.tencent.mm.aj.d)localObject1);
          }
        }
        localObject1 = new d((cbj)paramq.xMe.get(paramInt1));
        localObject2 = new h();
        ((h)localObject2).username = ((d)localObject1).field_username;
        if (((d)localObject1).field_hasHDImg <= 0) {
          break label755;
        }
        bool = true;
        label456:
        ((h)localObject2).cM(bool);
        ((h)localObject2).dqB = ((d)localObject1).field_imgstatus;
        ((h)localObject2).fsl = ((cbj)paramq.xMe.get(paramInt1)).wJq;
        ((h)localObject2).fsk = ((cbj)paramq.xMe.get(paramInt1)).wJr;
        o.adg().b((h)localObject2);
        ((h)localObject2).bsY = -1;
        ab.d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", new Object[] { ((h)localObject2).getUsername(), ((h)localObject2).acX(), ((h)localObject2).acY() });
        if (!paramArrayOfByte.arr(((d)localObject1).field_username)) {
          break label761;
        }
      }
      label755:
      label761:
      for (i = 1;; i = 0)
      {
        ((d)localObject1).field_reserved2 = i;
        localObject2 = paramArrayOfByte.arw(((d)localObject1).field_username);
        if ((localObject2 != null) && ((int)((com.tencent.mm.n.a)localObject2).euF > 0))
        {
          locale.Za(((aq)localObject2).field_username);
          locale.Za(((aq)localObject2).field_encryptUsername);
        }
        locale.a((d)localObject1, false);
        aw.aaz();
        c.Zb().x(((d)localObject1).field_username, this.qMP, ((cbj)paramq.xMe.get(paramInt1)).wYu);
        ((d)localObject1).scene = this.qMP;
        this.qMO.add(localObject1);
        ab.v("MicroMsg.NetSceneShakeGet", "item info: " + ((d)localObject1).field_username + " " + ((d)localObject1).field_nickname);
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
    AppMethodBeat.o(24413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.a
 * JD-Core Version:    0.7.0.1
 */