package com.tencent.mm.plugin.shake.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.an.af;
import com.tencent.mm.an.f;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.faw;
import com.tencent.mm.protocal.protobuf.fax;
import com.tencent.mm.protocal.protobuf.fay;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bx;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends p
  implements com.tencent.mm.network.m
{
  List<d> Pzb;
  private int Pzc;
  private h callback;
  private String lym;
  int ret;
  private com.tencent.mm.am.c rr;
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28086);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fax();
    ((c.a)localObject).otF = new fay();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/shakeget";
    ((c.a)localObject).funcId = 162;
    ((c.a)localObject).otG = 57;
    ((c.a)localObject).respCmdId = 1000000057;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fax)c.b.b(this.rr.otB);
    ((fax)localObject).YLa = new gol().df(paramArrayOfByte);
    ((fax)localObject).abAS = 1;
    try
    {
      paramArrayOfByte = new gdd();
      paramArrayOfByte.acaX = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.gtE());
      ((fax)localObject).YKb = new gol().df(paramArrayOfByte.toByteArray());
      return;
    }
    finally
    {
      AppMethodBeat.o(28086);
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(28087);
    Log.d("MicroMsg.NetSceneShakeGet", "doScene");
    this.callback = paramh;
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
    paramArrayOfByte = (fay)c.c.b(this.rr.otC);
    this.Pzb = new LinkedList();
    this.Pzc = paramArrayOfByte.abAU;
    this.ret = paramArrayOfByte.Idd;
    this.lym = paramArrayOfByte.MRj;
    int i = paramArrayOfByte.vgN;
    Log.d("MicroMsg.NetSceneShakeGet", "size:".concat(String.valueOf(i)));
    bh.bCz();
    bx localbx = com.tencent.mm.model.c.bzA();
    e locale;
    if (i > 0)
    {
      locale = m.gXd();
      locale.gWS();
      Log.i("MicroMsg.NewShakeItemStorage", "delOldRecord count:".concat(String.valueOf(i)));
      params = new StringBuilder("DELETE FROM shakeitem1 WHERE shakeItemID NOT IN ( SELECT shakeItemID FROM shakeitem1 ORDER BY shakeItemID DESC LIMIT ");
      if (100 > i)
      {
        paramInt1 = 100 - i;
        params = paramInt1 + " )";
        if (locale.db.execSQL("shakeitem1", params))
        {
          Log.i("MicroMsg.NewShakeItemStorage", "delOldRecord success count:".concat(String.valueOf(i)));
          locale.doNotify();
        }
        paramInt1 = i - 1;
        label232:
        if (paramInt1 < 0) {
          break label781;
        }
        if (!z.bAM().equals(((faw)paramArrayOfByte.abAT.get(paramInt1)).UserName))
        {
          params = af.bHf().Mn(((faw)paramArrayOfByte.abAT.get(paramInt1)).UserName);
          if (params != null) {
            break label802;
          }
          params = new com.tencent.mm.api.c();
        }
      }
    }
    label775:
    label781:
    label802:
    for (;;)
    {
      params.field_username = ((faw)paramArrayOfByte.abAT.get(paramInt1)).UserName;
      params.field_brandList = ((faw)paramArrayOfByte.abAT.get(paramInt1)).pSp;
      Object localObject = ((faw)paramArrayOfByte.abAT.get(paramInt1)).aaMt;
      if (localObject != null)
      {
        params.field_brandFlag = ((ahl)localObject).pSt;
        params.field_brandInfo = ((ahl)localObject).pSv;
        params.field_brandIconURL = ((ahl)localObject).pSw;
        params.field_extInfo = ((ahl)localObject).pSu;
      }
      if (!af.bHf().h(params)) {
        af.bHf().g(params);
      }
      params = new d((faw)paramArrayOfByte.abAT.get(paramInt1));
      localObject = new j();
      ((j)localObject).username = params.field_username;
      boolean bool;
      if (params.field_hasHDImg > 0)
      {
        bool = true;
        label470:
        ((j)localObject).gX(bool);
        ((j)localObject).jZY = params.field_imgstatus;
        ((j)localObject).osN = ((faw)paramArrayOfByte.abAT.get(paramInt1)).ZhO;
        ((j)localObject).osM = ((faw)paramArrayOfByte.abAT.get(paramInt1)).ZhP;
        q.bFE().b((j)localObject);
        ((j)localObject).eQp = -1;
        Log.d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", new Object[] { ((j)localObject).getUsername(), ((j)localObject).bFw(), ((j)localObject).bFx() });
        if (!localbx.bxr(params.field_username)) {
          break label775;
        }
      }
      for (i = 1;; i = 0)
      {
        params.field_reserved2 = i;
        localObject = localbx.JE(params.field_username);
        if ((localObject != null) && ((int)((com.tencent.mm.contact.d)localObject).maN > 0))
        {
          locale.aVK(((az)localObject).field_username);
          locale.aVK(((az)localObject).field_encryptUsername);
        }
        locale.a(params, false);
        bh.bCz();
        com.tencent.mm.model.c.bAc().V(params.field_username, this.Pzc, ((faw)paramArrayOfByte.abAT.get(paramInt1)).aant);
        params.scene = this.Pzc;
        this.Pzb.add(params);
        Log.v("MicroMsg.NetSceneShakeGet", "item info: " + params.field_username + " " + params.field_nickname);
        paramInt1 -= 1;
        break label232;
        paramInt1 = 0;
        break;
        bool = false;
        break label470;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28088);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.model.a
 * JD-Core Version:    0.7.0.1
 */