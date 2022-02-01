package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.dwv;
import com.tencent.mm.protocal.protobuf.dww;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends q
  implements com.tencent.mm.network.m
{
  List<d> DgE;
  private int DgF;
  private com.tencent.mm.ak.i callback;
  private String pWf;
  int ret;
  private com.tencent.mm.ak.d rr;
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28086);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dww();
    ((d.a)localObject).iLO = new dwx();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/shakeget";
    ((d.a)localObject).funcId = 162;
    ((d.a)localObject).iLP = 57;
    ((d.a)localObject).respCmdId = 1000000057;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dww)this.rr.iLK.iLR;
    ((dww)localObject).KMS = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((dww)localObject).MWS = 1;
    try
    {
      paramArrayOfByte = new ewf();
      paramArrayOfByte.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.exJ());
      ((dww)localObject).KLQ = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte.toByteArray());
      AppMethodBeat.o(28086);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      AppMethodBeat.o(28086);
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
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
    params = (dwx)this.rr.iLL.iLR;
    this.DgE = new LinkedList();
    this.DgF = params.MWU;
    this.ret = params.Ret;
    this.pWf = params.AZI;
    int i = params.oTz;
    Log.d("MicroMsg.NetSceneShakeGet", "size:".concat(String.valueOf(i)));
    bg.aVF();
    paramArrayOfByte = com.tencent.mm.model.c.aSN();
    if (i > 0)
    {
      e locale = m.eUm();
      locale.eUc();
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
        if (!z.aTY().equals(((dwv)params.MWT.get(paramInt1)).UserName))
        {
          localObject1 = ag.bah().MT(((dwv)params.MWT.get(paramInt1)).UserName);
          ((com.tencent.mm.api.c)localObject1).field_username = ((dwv)params.MWT.get(paramInt1)).UserName;
          ((com.tencent.mm.api.c)localObject1).field_brandList = ((dwv)params.MWT.get(paramInt1)).kei;
          localObject2 = ((dwv)params.MWT.get(paramInt1)).MmR;
          if (localObject2 != null)
          {
            ((com.tencent.mm.api.c)localObject1).field_brandFlag = ((aeq)localObject2).kem;
            ((com.tencent.mm.api.c)localObject1).field_brandInfo = ((aeq)localObject2).keo;
            ((com.tencent.mm.api.c)localObject1).field_brandIconURL = ((aeq)localObject2).kep;
            ((com.tencent.mm.api.c)localObject1).field_extInfo = ((aeq)localObject2).ken;
          }
          if (!ag.bah().h((com.tencent.mm.api.c)localObject1)) {
            ag.bah().g((com.tencent.mm.api.c)localObject1);
          }
        }
        localObject1 = new d((dwv)params.MWT.get(paramInt1));
        localObject2 = new com.tencent.mm.aj.i();
        ((com.tencent.mm.aj.i)localObject2).username = ((d)localObject1).field_username;
        if (((d)localObject1).field_hasHDImg <= 0) {
          break label755;
        }
        bool = true;
        label456:
        ((com.tencent.mm.aj.i)localObject2).fv(bool);
        ((com.tencent.mm.aj.i)localObject2).fuz = ((d)localObject1).field_imgstatus;
        ((com.tencent.mm.aj.i)localObject2).iKX = ((dwv)params.MWT.get(paramInt1)).Lir;
        ((com.tencent.mm.aj.i)localObject2).iKW = ((dwv)params.MWT.get(paramInt1)).Lis;
        p.aYB().b((com.tencent.mm.aj.i)localObject2);
        ((com.tencent.mm.aj.i)localObject2).cSx = -1;
        Log.d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", new Object[] { ((com.tencent.mm.aj.i)localObject2).getUsername(), ((com.tencent.mm.aj.i)localObject2).aYt(), ((com.tencent.mm.aj.i)localObject2).aYu() });
        if (!paramArrayOfByte.bjG(((d)localObject1).field_username)) {
          break label761;
        }
      }
      label755:
      label761:
      for (i = 1;; i = 0)
      {
        ((d)localObject1).field_reserved2 = i;
        localObject2 = paramArrayOfByte.Kn(((d)localObject1).field_username);
        if ((localObject2 != null) && ((int)((com.tencent.mm.contact.c)localObject2).gMZ > 0))
        {
          locale.aNj(((ax)localObject2).field_username);
          locale.aNj(((ax)localObject2).field_encryptUsername);
        }
        locale.a((d)localObject1, false);
        bg.aVF();
        com.tencent.mm.model.c.aTp().O(((d)localObject1).field_username, this.DgF, ((dwv)params.MWT.get(paramInt1)).LRO);
        ((d)localObject1).scene = this.DgF;
        this.DgE.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.a
 * JD-Core Version:    0.7.0.1
 */