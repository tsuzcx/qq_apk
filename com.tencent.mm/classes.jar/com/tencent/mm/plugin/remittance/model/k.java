package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.gs;
import com.tencent.mm.f.a.gs.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.protocal.protobuf.qu;
import com.tencent.mm.protocal.protobuf.ra;
import com.tencent.mm.protocal.protobuf.rb;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.j;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class k
  extends q
  implements m, j
{
  public int GVj;
  public rb IlD;
  public String IlE;
  public gs IlF;
  private i callback;
  private com.tencent.mm.an.d kwO;
  
  public k(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, aos paramaos, String paramString8, int paramInt6, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, int paramInt7, int paramInt8, String paramString14)
  {
    AppMethodBeat.i(163811);
    this.IlF = null;
    Object localObject1 = new d.a();
    ((d.a)localObject1).lBU = new ra();
    ((d.a)localObject1).lBV = new rb();
    ((d.a)localObject1).funcId = 1633;
    ((d.a)localObject1).uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
    ((d.a)localObject1).lBW = 0;
    ((d.a)localObject1).respCmdId = 0;
    Object localObject2 = com.tencent.mm.plugin.soter.d.d.gai();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject2).Lwz;
    localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).ktM;
    this.IlE = paramString9;
    this.GVj = paramInt2;
    this.kwO = ((d.a)localObject1).bgN();
    localObject1 = (ra)d.b.b(this.kwO.lBR);
    ((ra)localObject1).ImY = paramString1;
    ((ra)localObject1).RZp = URLDecoder.decode(paramString2);
    ((ra)localObject1).scene = paramInt1;
    ((ra)localObject1).RZq = paramString3;
    ((ra)localObject1).ImS = paramString4;
    ((ra)localObject1).RJi = paramInt2;
    ((ra)localObject1).channel = paramInt3;
    ((ra)localObject1).ImT = paramString5;
    ((ra)localObject1).ImZ = paramString6;
    ((ra)localObject1).ImX = paramInt4;
    ((ra)localObject1).RZx = paramString13;
    ((ra)localObject1).RZz = paramInt8;
    ((ra)localObject1).llO = paramString7;
    ((ra)localObject1).RJq = paramString14;
    if (paramaos != null) {
      ((ra)localObject1).RJh = paramaos;
    }
    ((ra)localObject1).RZj = paramString8;
    ((ra)localObject1).Ilb = paramInt6;
    if (paramInt5 == 1)
    {
      ((ra)localObject1).RZr = ConnectivityCompat.Companion.getWiFiBssid();
      ((ra)localObject1).RZs = 0;
    }
    ((ra)localObject1).Lwz = str;
    ((ra)localObject1).ktM = ((String)localObject2);
    ((ra)localObject1).RZu = u.gJo().gJU();
    h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
    ((ra)localObject1).RZt = false;
    ((ra)localObject1).RZv = paramString9;
    ((ra)localObject1).ImV = paramString10;
    ((ra)localObject1).nickname = paramString11;
    ((ra)localObject1).RZy = paramInt7;
    ((ra)localObject1).Imv = paramString12;
    Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", new Object[] { paramString9 });
    Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s amount_remind_sign:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt5), a.a(paramaos), paramString9, paramString13, Integer.valueOf(paramInt8), Integer.valueOf(paramInt7), paramString14 });
    AppMethodBeat.o(163811);
  }
  
  public k(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, aos paramaos, String paramString8, int paramInt6, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, int paramInt7, int paramInt8, String paramString14, String paramString15, String paramString16)
  {
    AppMethodBeat.i(174416);
    this.IlF = null;
    Object localObject1 = new d.a();
    ((d.a)localObject1).lBU = new ra();
    ((d.a)localObject1).lBV = new rb();
    ((d.a)localObject1).funcId = 1633;
    ((d.a)localObject1).uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
    ((d.a)localObject1).lBW = 0;
    ((d.a)localObject1).respCmdId = 0;
    Object localObject2 = com.tencent.mm.plugin.soter.d.d.gai();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject2).Lwz;
    localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).ktM;
    this.IlE = paramString9;
    this.GVj = paramInt2;
    this.kwO = ((d.a)localObject1).bgN();
    localObject1 = (ra)d.b.b(this.kwO.lBR);
    ((ra)localObject1).ImY = paramString1;
    ((ra)localObject1).RZp = URLDecoder.decode(paramString2);
    ((ra)localObject1).scene = paramInt1;
    ((ra)localObject1).RZq = paramString3;
    ((ra)localObject1).ImS = paramString4;
    ((ra)localObject1).RJi = paramInt2;
    ((ra)localObject1).channel = paramInt3;
    ((ra)localObject1).ImT = paramString5;
    ((ra)localObject1).ImZ = paramString6;
    ((ra)localObject1).ImX = paramInt4;
    ((ra)localObject1).RZx = paramString13;
    ((ra)localObject1).RZz = paramInt8;
    ((ra)localObject1).llO = paramString7;
    ((ra)localObject1).RJq = paramString14;
    if (paramaos != null) {
      ((ra)localObject1).RJh = paramaos;
    }
    ((ra)localObject1).RZj = paramString8;
    ((ra)localObject1).Ilb = paramInt6;
    if (paramInt5 == 1)
    {
      ((ra)localObject1).RZr = ConnectivityCompat.Companion.getWiFiBssid();
      ((ra)localObject1).RZs = 0;
    }
    ((ra)localObject1).Lwz = str;
    ((ra)localObject1).ktM = ((String)localObject2);
    ((ra)localObject1).RZu = u.gJo().gJU();
    h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
    ((ra)localObject1).RZt = false;
    ((ra)localObject1).RZv = paramString9;
    ((ra)localObject1).ImV = paramString10;
    ((ra)localObject1).nickname = paramString11;
    ((ra)localObject1).RZy = paramInt7;
    ((ra)localObject1).Imv = paramString12;
    ((ra)localObject1).RZA = paramString15;
    ((ra)localObject1).RZB = paramString16;
    Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", new Object[] { paramString9 });
    Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s amount_remind_sign:%s inputRecvName:%s checkRecvNameSign:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt5), a.a(paramaos), paramString9, paramString13, Integer.valueOf(paramInt8), Integer.valueOf(paramInt7), paramString14, paramString15, paramString16 });
    AppMethodBeat.o(174416);
  }
  
  public static JSONObject a(qu paramqu)
  {
    AppMethodBeat.i(67852);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("flag", paramqu.cUP);
      localJSONObject.put("succpage_first_delay_ms", paramqu.RZd);
      localJSONObject.put("succpage_max_retry_cnt", paramqu.RZe);
      localJSONObject.put("succpage_retry_waiting_ms", paramqu.RZf);
      AppMethodBeat.o(67852);
      return localJSONObject;
    }
    catch (Exception paramqu)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "getBusiF2FFaultConfigJSONObject() Exception: %s", new Object[] { paramqu.getMessage() });
      }
    }
  }
  
  public static qu aWG(String paramString)
  {
    AppMethodBeat.i(67853);
    qu localqu = new qu();
    try
    {
      paramString = new JSONObject(paramString);
      localqu.cUP = paramString.optInt("flag");
      localqu.RZd = paramString.optInt("succpage_first_delay_ms");
      localqu.RZe = paramString.optInt("succpage_max_retry_cnt");
      localqu.RZf = paramString.optInt("succpage_retry_waiting_ms");
      AppMethodBeat.o(67853);
      return localqu;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "createBusiF2FFaultConfigFromJSONObject() Exception: %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final void a(gs paramgs)
  {
    int i = 1;
    AppMethodBeat.i(265928);
    this.IlF = paramgs;
    ra localra = (ra)d.b.b(this.kwO.lBR);
    if (paramgs.fDc.fDe == 1) {}
    for (;;)
    {
      localra.RZw = i;
      AppMethodBeat.o(265928);
      return;
      i = 0;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67850);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(67850);
    return i;
  }
  
  public final int getType()
  {
    return 1633;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67851);
    Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.IlD = ((rb)d.c.b(((com.tencent.mm.an.d)params).lBS));
    params = new StringBuffer();
    params.append(String.format("trans_id: %s,", new Object[] { this.IlD.InV }));
    params.append(String.format("zero_pay_flag: %s,", new Object[] { Integer.valueOf(this.IlD.RZH) }));
    params.append(String.format("can_use_fingerprint: %s,", new Object[] { Integer.valueOf(this.IlD.RZN) }));
    params.append(String.format("payer_need_auth_flag: %s,", new Object[] { Integer.valueOf(this.IlD.RZI) }));
    paramArrayOfByte = new com.tencent.mm.wallet_core.c.e(paramInt2, paramInt3, paramString);
    com.tencent.mm.wallet_core.c.s.getRetModel(paramInt2, paramInt3, paramString, paramArrayOfByte);
    Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "ret_code: %s, ret_msg: %s trans_id: %s f2f_id: %s re_getfavor: %s payok_checksign: %s reqKey %s ret:%s", new Object[] { Integer.valueOf(this.IlD.tqa), this.IlD.tqb, this.IlD.InV, this.IlD.RJf, Integer.valueOf(this.IlD.RZG), this.IlD.RJg, this.IlD.fHb, params.toString() });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramArrayOfByte.errType, paramArrayOfByte.errCode, paramArrayOfByte.errMsg, this);
    }
    AppMethodBeat.o(67851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.k
 * JD-Core Version:    0.7.0.1
 */