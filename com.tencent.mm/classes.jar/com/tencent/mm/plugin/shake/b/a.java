package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.egw;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.protocal.protobuf.egy;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.an.q
  implements com.tencent.mm.network.m
{
  List<d> Jmk;
  private int Jml;
  private i callback;
  int ret;
  private com.tencent.mm.an.d rr;
  private String tsf;
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28086);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new egx();
    ((d.a)localObject).lBV = new egy();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/shakeget";
    ((d.a)localObject).funcId = 162;
    ((d.a)localObject).lBW = 57;
    ((d.a)localObject).respCmdId = 1000000057;
    this.rr = ((d.a)localObject).bgN();
    localObject = (egx)d.b.b(this.rr.lBR);
    ((egx)localObject).RNM = new eae().dc(paramArrayOfByte);
    ((egx)localObject).Ujn = 1;
    try
    {
      paramArrayOfByte = new fgr();
      paramArrayOfByte.UGO = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjn());
      ((egx)localObject).RMN = new eae().dc(paramArrayOfByte.toByteArray());
      AppMethodBeat.o(28086);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      AppMethodBeat.o(28086);
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(28087);
    Log.d("MicroMsg.NetSceneShakeGet", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(28087);
    return i;
  }
  
  public final int getType()
  {
    return 162;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28088);
    Log.d("MicroMsg.NetSceneShakeGet", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    params = (egy)d.c.b(this.rr.lBS);
    this.Jmk = new LinkedList();
    this.Jml = params.Ujp;
    this.ret = params.CqV;
    this.tsf = params.GTG;
    int i = params.rVx;
    Log.d("MicroMsg.NetSceneShakeGet", "size:".concat(String.valueOf(i)));
    bh.beI();
    paramArrayOfByte = com.tencent.mm.model.c.bbL();
    if (i > 0)
    {
      e locale = m.fHo();
      locale.fHe();
      Log.i("MicroMsg.NewShakeItemStorage", "delOldRecord count:".concat(String.valueOf(i)));
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
          Log.i("MicroMsg.NewShakeItemStorage", "delOldRecord success count:".concat(String.valueOf(i)));
          locale.doNotify();
        }
        paramInt1 = i - 1;
        if (paramInt1 < 0) {
          break label767;
        }
        if (!z.bcZ().equals(((egw)params.Ujo.get(paramInt1)).UserName))
        {
          localObject1 = af.bjv().Uo(((egw)params.Ujo.get(paramInt1)).UserName);
          ((com.tencent.mm.api.c)localObject1).field_username = ((egw)params.Ujo.get(paramInt1)).UserName;
          ((com.tencent.mm.api.c)localObject1).field_brandList = ((egw)params.Ujo.get(paramInt1)).mVI;
          localObject2 = ((egw)params.Ujo.get(paramInt1)).TxM;
          if (localObject2 != null)
          {
            ((com.tencent.mm.api.c)localObject1).field_brandFlag = ((aez)localObject2).mVM;
            ((com.tencent.mm.api.c)localObject1).field_brandInfo = ((aez)localObject2).mVO;
            ((com.tencent.mm.api.c)localObject1).field_brandIconURL = ((aez)localObject2).mVP;
            ((com.tencent.mm.api.c)localObject1).field_extInfo = ((aez)localObject2).mVN;
          }
          if (!af.bjv().h((com.tencent.mm.api.c)localObject1)) {
            af.bjv().g((com.tencent.mm.api.c)localObject1);
          }
        }
        localObject1 = new d((egw)params.Ujo.get(paramInt1));
        localObject2 = new j();
        ((j)localObject2).username = ((d)localObject1).field_username;
        if (((d)localObject1).field_hasHDImg <= 0) {
          break label755;
        }
        bool = true;
        label456:
        ((j)localObject2).gg(bool);
        ((j)localObject2).hDc = ((d)localObject1).field_imgstatus;
        ((j)localObject2).lBe = ((egw)params.Ujo.get(paramInt1)).SjI;
        ((j)localObject2).lBd = ((egw)params.Ujo.get(paramInt1)).SjJ;
        com.tencent.mm.am.q.bhP().b((j)localObject2);
        ((j)localObject2).cUP = -1;
        Log.d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", new Object[] { ((j)localObject2).getUsername(), ((j)localObject2).bhH(), ((j)localObject2).bhI() });
        if (!paramArrayOfByte.bwd(((d)localObject1).field_username)) {
          break label761;
        }
      }
      label755:
      label761:
      for (i = 1;; i = 0)
      {
        ((d)localObject1).field_reserved2 = i;
        localObject2 = paramArrayOfByte.RG(((d)localObject1).field_username);
        if ((localObject2 != null) && ((int)((com.tencent.mm.contact.d)localObject2).jxt > 0))
        {
          locale.aXS(((ax)localObject2).field_username);
          locale.aXS(((ax)localObject2).field_encryptUsername);
        }
        locale.a((d)localObject1, false);
        bh.beI();
        com.tencent.mm.model.c.bcn().T(((d)localObject1).field_username, this.Jml, ((egw)params.Ujo.get(paramInt1)).Tav);
        ((d)localObject1).scene = this.Jml;
        this.Jmk.add(localObject1);
        Log.v("MicroMsg.NetSceneShakeGet", "item info: " + ((d)localObject1).field_username + " " + ((d)localObject1).field_nickname);
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