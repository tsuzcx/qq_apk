package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.h.c.r;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.z.a;
import com.tencent.mm.protocal.c.abg;
import com.tencent.mm.protocal.c.abh;
import com.tencent.mm.protocal.c.baq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class ad
  extends com.tencent.mm.ah.m
  implements k
{
  private static final String[] rUL = { "wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b" };
  final String appId;
  private com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL;
  private final int ezA;
  
  public ad(String paramString)
  {
    this.appId = paramString;
    this.ezA = 3;
    paramString = new b.a();
    paramString.ecH = new abg();
    paramString.ecI = new abh();
    paramString.uri = "/cgi-bin/micromsg-bin/getappinfo";
    paramString.ecG = 231;
    paramString.ecJ = 0;
    paramString.ecK = 0;
    this.dmK = paramString.Kt();
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    if ((this.appId == null) || (this.appId.length() == 0))
    {
      y.e("MicroMsg.NetSceneGetAppInfo", "doScene fail, appId is null");
      return -1;
    }
    paramf = (abg)this.dmK.ecE.ecN;
    paramf.kRX = this.appId;
    paramf.sTo = this.ezA;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetAppInfo", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 4) && (paramInt3 == -1011))
    {
      y.e("MicroMsg.NetSceneGetAppInfo", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", appinfo does not exist");
      a.brn();
      paramq = i.ckU();
      paramq.field_appId = this.appId;
      a.brn().a(paramq);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneGetAppInfo", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    Object localObject1 = (abh)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    paramArrayOfByte = ((abh)localObject1).taJ.sux;
    Object localObject2 = ((abh)localObject1).taJ;
    if (localObject2 == null)
    {
      y.e("MicroMsg.NetSceneGetAppInfo", "convertToAppInfo : openAppInfo is null");
      paramq = null;
    }
    while (paramq == null)
    {
      y.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info is null");
      this.dmL.onSceneEnd(3, -1, paramString, this);
      return;
      paramq = new f();
      paramq.field_appId = ((baq)localObject2).kRX;
      paramq.field_appName = ((baq)localObject2).kVn;
      paramq.field_appDiscription = ((baq)localObject2).twx;
      paramq.field_appIconUrl = ((baq)localObject2).suv;
      paramq.field_appStoreUrl = ((baq)localObject2).kSq;
      paramq.field_appVersion = ((baq)localObject2).sCy;
      paramq.field_appWatermarkUrl = ((baq)localObject2).twy;
      paramq.field_packageName = ((baq)localObject2).sux;
      paramq.field_signature = p.VY(((baq)localObject2).sCv);
      paramq.field_appName_en = ((baq)localObject2).twz;
      paramq.field_appName_tw = ((baq)localObject2).twB;
      paramq.field_appDiscription_en = ((baq)localObject2).twA;
      paramq.field_appDiscription_tw = ((baq)localObject2).twC;
      paramq.field_appInfoFlag = ((baq)localObject2).kSe;
      y.d("MicroMsg.NetSceneGetAppInfo", "appid = %s, appInfoFlag = %s", new Object[] { paramq.field_appId, Integer.valueOf(paramq.field_appInfoFlag) });
    }
    paramq.field_appType = ((abh)localObject1).sCw;
    localObject2 = ((abh)localObject1).taJ;
    localObject1 = ((baq)localObject2).sux;
    localObject2 = ((baq)localObject2).sCv;
    if ((localObject1 == null) || (((String)localObject1).length() == 0) || (localObject2 == null) || (((String)localObject2).length() == 0)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 != 0) || (paramq.ZH()))
      {
        y.e("MicroMsg.NetSceneGetAppInfo", "no android app, packageName = " + paramArrayOfByte);
        com.tencent.mm.pluginsdk.ui.tools.b.WU(this.appId);
      }
      if (paramq.field_appId != null) {
        break;
      }
      y.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info.appId is null");
      this.dmL.onSceneEnd(3, -1, paramString, this);
      return;
    }
    if (!paramq.field_appId.equals(this.appId))
    {
      y.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : appId is different");
      this.dmL.onSceneEnd(3, -1, paramString, this);
      return;
    }
    paramArrayOfByte = a.brn();
    localObject1 = paramArrayOfByte.VU(this.appId);
    if ((localObject1 == null) || (((f)localObject1).field_appId == null) || (((f)localObject1).field_appId.length() == 0))
    {
      if (paramInt1 != 0)
      {
        paramInt1 = 3;
        paramq.field_status = paramInt1;
        paramq.field_modifyTime = System.currentTimeMillis();
        if (paramq.field_appId != null) {
          paramInt1 = 0;
        }
      }
      for (;;)
      {
        if (paramInt1 < rUL.length)
        {
          if (paramq.field_appId.equals(rUL[paramInt1])) {
            paramq.field_status = -1;
          }
        }
        else
        {
          if (paramArrayOfByte.l(paramq)) {
            break label754;
          }
          y.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : insert fail");
          this.dmL.onSceneEnd(3, -1, paramString, this);
          return;
          paramInt1 = 4;
          break;
        }
        paramInt1 += 1;
      }
      label754:
      a.brl().dg(this.appId, 1);
      a.brl().dg(this.appId, 2);
      a.brl().dg(this.appId, 3);
      a.brl().dg(this.appId, 4);
      a.brl().dg(this.appId, 5);
    }
    label1448:
    for (;;)
    {
      if (bk.bl(paramq.field_openId))
      {
        y.d("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd, openId is null, trigger getAppSetting, appId = " + paramq.field_appId);
        a.brp().qh(paramq.field_appId);
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      if (paramInt1 != 0)
      {
        paramInt1 = 3;
        paramq.field_status = paramInt1;
        if (paramq.field_appId != null)
        {
          paramInt1 = 0;
          label894:
          if (paramInt1 < rUL.length)
          {
            if (!paramq.field_appId.equals(rUL[paramInt1])) {
              break label983;
            }
            paramq.field_status = -1;
          }
        }
        if (localObject1 != null) {
          break label990;
        }
        y.e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appinfo is null");
      }
      for (;;)
      {
        if (paramArrayOfByte.a(paramq, new String[0])) {
          break label1216;
        }
        y.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : update fail");
        this.dmL.onSceneEnd(3, -1, paramString, this);
        return;
        paramInt1 = ((f)localObject1).field_status;
        break;
        label983:
        paramInt1 += 1;
        break label894;
        label990:
        if (((f)localObject1).ckN())
        {
          if (!bk.bl(((f)localObject1).field_appIconUrl)) {
            paramq.field_appIconUrl = ((f)localObject1).field_appIconUrl;
          }
          if (!bk.bl(((f)localObject1).field_appName)) {
            paramq.field_appName = ((f)localObject1).field_appName;
          }
          if (!bk.bl(((f)localObject1).field_appName_en)) {
            paramq.field_appName_en = ((f)localObject1).field_appName_en;
          }
          if (!bk.bl(((f)localObject1).field_appName_tw)) {
            paramq.field_appName_tw = ((f)localObject1).field_appName_tw;
          }
          if (!bk.bl(((f)localObject1).field_appName_hk)) {
            paramq.field_appName_hk = ((f)localObject1).field_appName_hk;
          }
        }
        if ((bk.bl(paramq.field_appId)) || (bk.bl(((f)localObject1).field_appId)))
        {
          y.e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appid is null");
        }
        else if (!paramq.field_appId.equalsIgnoreCase(((f)localObject1).field_appId))
        {
          y.e("MicroMsg.NetSceneGetAppInfo", "merge failed, appis is different");
        }
        else
        {
          paramq.field_openId = ((f)localObject1).field_openId;
          paramq.field_authFlag = ((f)localObject1).field_authFlag;
          paramq.cL(((r)localObject1).cvw);
          paramq.cM(((r)localObject1).cvx);
          paramq.cN(((r)localObject1).cvy);
        }
      }
      label1216:
      if ((localObject1 == null) || (((f)localObject1).field_appIconUrl == null) || (((f)localObject1).field_appIconUrl.length() == 0)) {
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 == 0) {
          break label1448;
        }
        a.brl().dg(this.appId, 1);
        a.brl().dg(this.appId, 2);
        a.brl().dg(this.appId, 3);
        a.brl().dg(this.appId, 4);
        a.brl().dg(this.appId, 5);
        break;
        if (!bk.bl(paramq.cvQ))
        {
          if (bk.bl(((r)localObject1).cvQ))
          {
            paramInt1 = 1;
            continue;
          }
          if (!((r)localObject1).cvQ.equals(((r)localObject1).cvQ))
          {
            paramInt1 = 1;
            continue;
          }
        }
        if (!bk.bl(paramq.cvR))
        {
          if (bk.bl(((r)localObject1).cvR))
          {
            paramInt1 = 1;
            continue;
          }
          if (!((r)localObject1).cvR.equals(((r)localObject1).cvR))
          {
            paramInt1 = 1;
            continue;
          }
        }
        if ((paramq.field_appIconUrl == null) || (paramq.field_appIconUrl.length() == 0)) {
          paramInt1 = 0;
        } else if (!((f)localObject1).field_appIconUrl.equals(paramq.field_appIconUrl)) {
          paramInt1 = 1;
        } else {
          paramInt1 = 0;
        }
      }
    }
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 231;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ad
 * JD-Core Version:    0.7.0.1
 */