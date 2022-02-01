package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.ddr;
import com.tencent.mm.protocal.protobuf.dds;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.g;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private String oIr;
  int ret;
  private com.tencent.mm.ak.b rr;
  List<d> zbM;
  private int zbN;
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28086);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dds();
    ((b.a)localObject).hQG = new ddt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/shakeget";
    ((b.a)localObject).funcId = 162;
    ((b.a)localObject).hQH = 57;
    ((b.a)localObject).respCmdId = 1000000057;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dds)this.rr.hQD.hQJ;
    ((dds)localObject).FTj = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((dds)localObject).HLj = 1;
    try
    {
      paramArrayOfByte = new eby();
      paramArrayOfByte.Ihs = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.dye());
      ((dds)localObject).FSj = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte.toByteArray());
      AppMethodBeat.o(28086);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      AppMethodBeat.o(28086);
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(28087);
    ae.d("MicroMsg.NetSceneShakeGet", "doScene");
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
    ae.d("MicroMsg.NetSceneShakeGet", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (ddt)this.rr.hQE.hQJ;
    this.zbM = new LinkedList();
    this.zbN = paramq.HLl;
    this.ret = paramq.Ret;
    this.oIr = paramq.xcg;
    int i = paramq.nID;
    ae.d("MicroMsg.NetSceneShakeGet", "size:".concat(String.valueOf(i)));
    bc.aCg();
    paramArrayOfByte = com.tencent.mm.model.c.azF();
    if (i > 0)
    {
      e locale = m.dSl();
      locale.dSb();
      ae.i("MicroMsg.NewShakeItemStorage", "delOldRecord count:".concat(String.valueOf(i)));
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
          ae.i("MicroMsg.NewShakeItemStorage", "delOldRecord success count:".concat(String.valueOf(i)));
          locale.doNotify();
        }
        paramInt1 = i - 1;
        if (paramInt1 < 0) {
          break label767;
        }
        if (!v.aAC().equals(((ddr)paramq.HLk.get(paramInt1)).nIJ))
        {
          localObject1 = ag.aGp().Ef(((ddr)paramq.HLk.get(paramInt1)).nIJ);
          ((com.tencent.mm.api.c)localObject1).field_username = ((ddr)paramq.HLk.get(paramInt1)).nIJ;
          ((com.tencent.mm.api.c)localObject1).field_brandList = ((ddr)paramq.HLk.get(paramInt1)).jgf;
          localObject2 = ((ddr)paramq.HLk.get(paramInt1)).HhB;
          if (localObject2 != null)
          {
            ((com.tencent.mm.api.c)localObject1).field_brandFlag = ((aco)localObject2).jgj;
            ((com.tencent.mm.api.c)localObject1).field_brandInfo = ((aco)localObject2).jgl;
            ((com.tencent.mm.api.c)localObject1).field_brandIconURL = ((aco)localObject2).jgm;
            ((com.tencent.mm.api.c)localObject1).field_extInfo = ((aco)localObject2).jgk;
          }
          if (!ag.aGp().g((com.tencent.mm.api.c)localObject1)) {
            ag.aGp().f((com.tencent.mm.api.c)localObject1);
          }
        }
        localObject1 = new d((ddr)paramq.HLk.get(paramInt1));
        localObject2 = new i();
        ((i)localObject2).username = ((d)localObject1).field_username;
        if (((d)localObject1).field_hasHDImg <= 0) {
          break label755;
        }
        bool = true;
        label456:
        ((i)localObject2).eD(bool);
        ((i)localObject2).eQU = ((d)localObject1).field_imgstatus;
        ((i)localObject2).hPQ = ((ddr)paramq.HLk.get(paramInt1)).GnN;
        ((i)localObject2).hPP = ((ddr)paramq.HLk.get(paramInt1)).GnO;
        p.aEN().b((i)localObject2);
        ((i)localObject2).dEu = -1;
        ae.d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", new Object[] { ((i)localObject2).getUsername(), ((i)localObject2).aEG(), ((i)localObject2).aEH() });
        if (!paramArrayOfByte.aUH(((d)localObject1).field_username)) {
          break label761;
        }
      }
      label755:
      label761:
      for (i = 1;; i = 0)
      {
        ((d)localObject1).field_reserved2 = i;
        localObject2 = paramArrayOfByte.BH(((d)localObject1).field_username);
        if ((localObject2 != null) && ((int)((com.tencent.mm.contact.c)localObject2).ght > 0))
        {
          locale.ayz(((aw)localObject2).field_username);
          locale.ayz(((aw)localObject2).field_encryptUsername);
        }
        locale.a((d)localObject1, false);
        bc.aCg();
        com.tencent.mm.model.c.aAh().F(((d)localObject1).field_username, this.zbN, ((ddr)paramq.HLk.get(paramInt1)).GNI);
        ((d)localObject1).scene = this.zbN;
        this.zbM.add(localObject1);
        ae.v("MicroMsg.NetSceneShakeGet", "item info: " + ((d)localObject1).field_username + " " + ((d)localObject1).field_nickname);
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