package com.tencent.mm.plugin.remittance.model;

import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.gd;
import com.tencent.mm.g.a.gd.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.protocal.protobuf.os;
import com.tencent.mm.protocal.protobuf.ot;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.wallet_core.c.j;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class i
  extends n
  implements k, j
{
  private com.tencent.mm.al.g callback;
  private b iaa;
  public int uxV;
  public ot vAh;
  public String vAi;
  public gd vAj;
  
  public i(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, ahe paramahe, String paramString8, int paramInt6, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, int paramInt7, int paramInt8, String paramString14)
  {
    AppMethodBeat.i(163811);
    this.vAj = null;
    Object localObject2 = new b.a();
    ((b.a)localObject2).gUU = new os();
    ((b.a)localObject2).gUV = new ot();
    ((b.a)localObject2).funcId = 1633;
    ((b.a)localObject2).uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
    ((b.a)localObject2).reqCmdId = 0;
    ((b.a)localObject2).respCmdId = 0;
    Object localObject1 = d.dEQ();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject1).yaF;
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject1).yaG;
    this.vAi = paramString9;
    this.uxV = paramInt2;
    this.iaa = ((b.a)localObject2).atI();
    localObject2 = (os)this.iaa.gUS.gUX;
    ((os)localObject2).vBp = paramString1;
    ((os)localObject2).CMp = URLDecoder.decode(paramString2);
    ((os)localObject2).scene = paramInt1;
    ((os)localObject2).CMq = paramString3;
    ((os)localObject2).vBj = paramString4;
    ((os)localObject2).Cya = paramInt2;
    ((os)localObject2).channel = paramInt3;
    ((os)localObject2).vBk = paramString5;
    ((os)localObject2).vBq = paramString6;
    ((os)localObject2).vBo = paramInt4;
    ((os)localObject2).CMx = paramString13;
    ((os)localObject2).CMz = paramInt8;
    ((os)localObject2).iaw = paramString7;
    ((os)localObject2).Cyg = paramString14;
    if (paramahe != null) {
      ((os)localObject2).CxZ = paramahe;
    }
    ((os)localObject2).CMj = paramString8;
    ((os)localObject2).vzO = paramInt6;
    if (paramInt5 == 1)
    {
      paramString1 = ay.getWifiInfo(aj.getContext());
      if (paramString1 == null) {
        break label470;
      }
      ((os)localObject2).CMr = paramString1.getBSSID();
    }
    for (;;)
    {
      ((os)localObject2).CMs = 0;
      ((os)localObject2).yaF = str;
      ((os)localObject2).yaG = ((String)localObject1);
      ((os)localObject2).CMu = com.tencent.mm.plugin.wallet_core.model.s.ecc().ecJ();
      com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      ((os)localObject2).CMt = false;
      ((os)localObject2).CMv = paramString9;
      ((os)localObject2).vBm = paramString10;
      ((os)localObject2).nickname = paramString11;
      ((os)localObject2).CMy = paramInt7;
      ((os)localObject2).vAM = paramString12;
      ad.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", new Object[] { paramString9 });
      ad.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s amount_remind_sign:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt5), a.a(paramahe), paramString9, paramString13, Integer.valueOf(paramInt8), Integer.valueOf(paramInt7), paramString14 });
      AppMethodBeat.o(163811);
      return;
      label470:
      ad.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
    }
  }
  
  public i(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, ahe paramahe, String paramString8, int paramInt6, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, int paramInt7, int paramInt8, String paramString14, String paramString15, String paramString16)
  {
    AppMethodBeat.i(174416);
    this.vAj = null;
    Object localObject2 = new b.a();
    ((b.a)localObject2).gUU = new os();
    ((b.a)localObject2).gUV = new ot();
    ((b.a)localObject2).funcId = 1633;
    ((b.a)localObject2).uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
    ((b.a)localObject2).reqCmdId = 0;
    ((b.a)localObject2).respCmdId = 0;
    Object localObject1 = d.dEQ();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject1).yaF;
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject1).yaG;
    this.vAi = paramString9;
    this.uxV = paramInt2;
    this.iaa = ((b.a)localObject2).atI();
    localObject2 = (os)this.iaa.gUS.gUX;
    ((os)localObject2).vBp = paramString1;
    ((os)localObject2).CMp = URLDecoder.decode(paramString2);
    ((os)localObject2).scene = paramInt1;
    ((os)localObject2).CMq = paramString3;
    ((os)localObject2).vBj = paramString4;
    ((os)localObject2).Cya = paramInt2;
    ((os)localObject2).channel = paramInt3;
    ((os)localObject2).vBk = paramString5;
    ((os)localObject2).vBq = paramString6;
    ((os)localObject2).vBo = paramInt4;
    ((os)localObject2).CMx = paramString13;
    ((os)localObject2).CMz = paramInt8;
    ((os)localObject2).iaw = paramString7;
    ((os)localObject2).Cyg = paramString14;
    if (paramahe != null) {
      ((os)localObject2).CxZ = paramahe;
    }
    ((os)localObject2).CMj = paramString8;
    ((os)localObject2).vzO = paramInt6;
    if (paramInt5 == 1)
    {
      paramString1 = ay.getWifiInfo(aj.getContext());
      if (paramString1 == null) {
        break label499;
      }
      ((os)localObject2).CMr = paramString1.getBSSID();
    }
    for (;;)
    {
      ((os)localObject2).CMs = 0;
      ((os)localObject2).yaF = str;
      ((os)localObject2).yaG = ((String)localObject1);
      ((os)localObject2).CMu = com.tencent.mm.plugin.wallet_core.model.s.ecc().ecJ();
      com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      ((os)localObject2).CMt = false;
      ((os)localObject2).CMv = paramString9;
      ((os)localObject2).vBm = paramString10;
      ((os)localObject2).nickname = paramString11;
      ((os)localObject2).CMy = paramInt7;
      ((os)localObject2).vAM = paramString12;
      ((os)localObject2).CMA = paramString15;
      ((os)localObject2).CMB = paramString16;
      ad.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", new Object[] { paramString9 });
      ad.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s amount_remind_sign:%s inputRecvName:%s checkRecvNameSign:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt5), a.a(paramahe), paramString9, paramString13, Integer.valueOf(paramInt8), Integer.valueOf(paramInt7), paramString14, paramString15, paramString16 });
      AppMethodBeat.o(174416);
      return;
      label499:
      ad.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
    }
  }
  
  public static JSONObject a(om paramom)
  {
    AppMethodBeat.i(67852);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("flag", paramom.dtM);
      localJSONObject.put("succpage_first_delay_ms", paramom.CMd);
      localJSONObject.put("succpage_max_retry_cnt", paramom.CMe);
      localJSONObject.put("succpage_retry_waiting_ms", paramom.CMf);
      AppMethodBeat.o(67852);
      return localJSONObject;
    }
    catch (Exception paramom)
    {
      for (;;)
      {
        ad.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "getBusiF2FFaultConfigJSONObject() Exception: %s", new Object[] { paramom.getMessage() });
      }
    }
  }
  
  public static om amg(String paramString)
  {
    AppMethodBeat.i(67853);
    om localom = new om();
    try
    {
      paramString = new JSONObject(paramString);
      localom.dtM = paramString.optInt("flag");
      localom.CMd = paramString.optInt("succpage_first_delay_ms");
      localom.CMe = paramString.optInt("succpage_max_retry_cnt");
      localom.CMf = paramString.optInt("succpage_retry_waiting_ms");
      AppMethodBeat.o(67853);
      return localom;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "createBusiF2FFaultConfigFromJSONObject() Exception: %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final void a(gd paramgd)
  {
    int i = 1;
    this.vAj = paramgd;
    os localos = (os)this.iaa.gUS.gUX;
    if (paramgd.djg.dji == 1) {}
    for (;;)
    {
      localos.CMw = i;
      return;
      i = 0;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(67850);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
    AppMethodBeat.o(67850);
    return i;
  }
  
  public final int getType()
  {
    return 1633;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67851);
    ad.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.vAh = ((ot)((b)paramq).gUT.gUX);
    paramq = new StringBuffer();
    paramq.append(String.format("trans_id: %s,", new Object[] { this.vAh.CxX }));
    paramq.append(String.format("zero_pay_flag: %s,", new Object[] { Integer.valueOf(this.vAh.CMH) }));
    paramq.append(String.format("can_use_fingerprint: %s,", new Object[] { Integer.valueOf(this.vAh.CMN) }));
    paramq.append(String.format("payer_need_auth_flag: %s,", new Object[] { Integer.valueOf(this.vAh.CMI) }));
    paramArrayOfByte = new com.tencent.mm.wallet_core.c.e(paramInt2, paramInt3, paramString);
    com.tencent.mm.wallet_core.c.s.getRetModel(paramInt2, paramInt3, paramString, paramArrayOfByte);
    ad.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "ret_code: %s, ret_msg: %s trans_id: %s f2f_id: %s re_getfavor: %s payok_checksign: %s reqKey %s ret:%s", new Object[] { Integer.valueOf(this.vAh.ntx), this.vAh.nty, this.vAh.CxX, this.vAh.CxW, Integer.valueOf(this.vAh.CMG), this.vAh.CxY, this.vAh.dlJ, paramq.toString() });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramArrayOfByte.errType, paramArrayOfByte.errCode, paramArrayOfByte.errMsg, this);
    }
    AppMethodBeat.o(67851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.i
 * JD-Core Version:    0.7.0.1
 */