package com.tencent.mm.plugin.remittance.model;

import android.net.wifi.WifiInfo;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.fu;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.protocal.c.kd;
import com.tencent.mm.protocal.c.ke;
import com.tencent.mm.protocal.c.yz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URLDecoder;

public final class i
  extends m
  implements com.tencent.mm.network.k, com.tencent.mm.wallet_core.c.g
{
  private f dmL;
  public b eWr;
  public ke nyh;
  public String nyi;
  public fu nyj = null;
  
  public i(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, yz paramyz, String paramString8, int paramInt6, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    Object localObject2 = new b.a();
    ((b.a)localObject2).ecH = new kd();
    ((b.a)localObject2).ecI = new ke();
    ((b.a)localObject2).ecG = 1633;
    ((b.a)localObject2).uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
    ((b.a)localObject2).ecJ = 0;
    ((b.a)localObject2).ecK = 0;
    Object localObject1 = d.bKR();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject1).psl;
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject1).psm;
    this.nyi = paramString9;
    this.eWr = ((b.a)localObject2).Kt();
    localObject2 = (kd)this.eWr.ecE.ecN;
    ((kd)localObject2).nzl = paramString1;
    ((kd)localObject2).sES = URLDecoder.decode(paramString2);
    ((kd)localObject2).scene = paramInt1;
    ((kd)localObject2).sET = paramString3;
    ((kd)localObject2).nzf = paramString4;
    ((kd)localObject2).swh = paramInt2;
    ((kd)localObject2).bUR = paramInt3;
    ((kd)localObject2).nzg = paramString5;
    ((kd)localObject2).nzm = paramString6;
    ((kd)localObject2).nzk = paramInt4;
    ((kd)localObject2).swg = paramString7;
    if (paramyz != null) {
      ((kd)localObject2).swf = paramyz;
    }
    ((kd)localObject2).sEM = paramString8;
    ((kd)localObject2).nxO = paramInt6;
    if (paramInt5 == 1)
    {
      paramString1 = aq.getWifiInfo(ae.getContext());
      if (paramString1 == null) {
        break label396;
      }
      ((kd)localObject2).sEU = paramString1.getBSSID();
    }
    for (;;)
    {
      ((kd)localObject2).sEV = 0;
      ((kd)localObject2).psl = str;
      ((kd)localObject2).psm = ((String)localObject1);
      ((kd)localObject2).sEX = o.bVs().bVP();
      com.tencent.mm.kernel.g.r(com.tencent.mm.pluginsdk.k.class);
      ((kd)localObject2).sEW = false;
      ((kd)localObject2).sEY = paramString9;
      ((kd)localObject2).nzi = paramString10;
      ((kd)localObject2).nickname = paramString11;
      ((kd)localObject2).nyK = paramString12;
      y.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", new Object[] { paramString9 });
      y.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt5), a.a(paramyz), paramString9 });
      return;
      label396:
      y.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.nyh = ((ke)((b)paramq).ecF.ecN);
    paramq = new StringBuffer();
    paramq.append(String.format("trans_id: %s,", new Object[] { this.nyh.swd }));
    paramq.append(String.format("zero_pay_flag: %s,", new Object[] { Integer.valueOf(this.nyh.sFf) }));
    paramq.append(String.format("can_use_fingerprint: %s,", new Object[] { Integer.valueOf(this.nyh.sFl) }));
    paramq.append(String.format("payer_need_auth_flag: %s,", new Object[] { Integer.valueOf(this.nyh.sFg) }));
    y.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "ret_code: %s, ret_msg: %s trans_id: %s f2f_id: %s re_getfavor: %s payok_checksign: %s reqKey %s ret:%s", new Object[] { Integer.valueOf(this.nyh.ino), this.nyh.inp, this.nyh.swd, this.nyh.swc, Integer.valueOf(this.nyh.sFe), this.nyh.swe, this.nyh.bOT, paramq.toString() });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1633;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.i
 * JD-Core Version:    0.7.0.1
 */