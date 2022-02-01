package com.tencent.mm.plugin.remittance.model;

import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.g.a.ge.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.ot;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.pa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.wallet_core.c.j;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class i
  extends n
  implements k, j
{
  private com.tencent.mm.ak.g callback;
  private b gvE;
  public int vGO;
  public pa wKm;
  public String wKn;
  public ge wKo;
  
  public i(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, aid paramaid, String paramString8, int paramInt6, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, int paramInt7, int paramInt8, String paramString14)
  {
    AppMethodBeat.i(163811);
    this.wKo = null;
    Object localObject2 = new b.a();
    ((b.a)localObject2).hvt = new oz();
    ((b.a)localObject2).hvu = new pa();
    ((b.a)localObject2).funcId = 1633;
    ((b.a)localObject2).uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
    ((b.a)localObject2).reqCmdId = 0;
    ((b.a)localObject2).respCmdId = 0;
    Object localObject1 = d.dTq();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject1).znE;
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject1).znF;
    this.wKn = paramString9;
    this.vGO = paramInt2;
    this.gvE = ((b.a)localObject2).aAz();
    localObject2 = (oz)this.gvE.hvr.hvw;
    ((oz)localObject2).wLu = paramString1;
    ((oz)localObject2).EeR = URLDecoder.decode(paramString2);
    ((oz)localObject2).scene = paramInt1;
    ((oz)localObject2).EeS = paramString3;
    ((oz)localObject2).wLo = paramString4;
    ((oz)localObject2).DQw = paramInt2;
    ((oz)localObject2).channel = paramInt3;
    ((oz)localObject2).wLp = paramString5;
    ((oz)localObject2).wLv = paramString6;
    ((oz)localObject2).wLt = paramInt4;
    ((oz)localObject2).EeZ = paramString13;
    ((oz)localObject2).Efb = paramInt8;
    ((oz)localObject2).iAz = paramString7;
    ((oz)localObject2).DQC = paramString14;
    if (paramaid != null) {
      ((oz)localObject2).DQv = paramaid;
    }
    ((oz)localObject2).EeL = paramString8;
    ((oz)localObject2).wJT = paramInt6;
    if (paramInt5 == 1)
    {
      paramString1 = ax.getWifiInfo(ai.getContext());
      if (paramString1 == null) {
        break label470;
      }
      ((oz)localObject2).EeT = paramString1.getBSSID();
    }
    for (;;)
    {
      ((oz)localObject2).EeU = 0;
      ((oz)localObject2).znE = str;
      ((oz)localObject2).znF = ((String)localObject1);
      ((oz)localObject2).EeW = com.tencent.mm.plugin.wallet_core.model.s.ery().ese();
      com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      ((oz)localObject2).EeV = false;
      ((oz)localObject2).EeX = paramString9;
      ((oz)localObject2).wLr = paramString10;
      ((oz)localObject2).nickname = paramString11;
      ((oz)localObject2).Efa = paramInt7;
      ((oz)localObject2).wKR = paramString12;
      ac.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", new Object[] { paramString9 });
      ac.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s amount_remind_sign:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt5), a.a(paramaid), paramString9, paramString13, Integer.valueOf(paramInt8), Integer.valueOf(paramInt7), paramString14 });
      AppMethodBeat.o(163811);
      return;
      label470:
      ac.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
    }
  }
  
  public i(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, aid paramaid, String paramString8, int paramInt6, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, int paramInt7, int paramInt8, String paramString14, String paramString15, String paramString16)
  {
    AppMethodBeat.i(174416);
    this.wKo = null;
    Object localObject2 = new b.a();
    ((b.a)localObject2).hvt = new oz();
    ((b.a)localObject2).hvu = new pa();
    ((b.a)localObject2).funcId = 1633;
    ((b.a)localObject2).uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
    ((b.a)localObject2).reqCmdId = 0;
    ((b.a)localObject2).respCmdId = 0;
    Object localObject1 = d.dTq();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject1).znE;
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject1).znF;
    this.wKn = paramString9;
    this.vGO = paramInt2;
    this.gvE = ((b.a)localObject2).aAz();
    localObject2 = (oz)this.gvE.hvr.hvw;
    ((oz)localObject2).wLu = paramString1;
    ((oz)localObject2).EeR = URLDecoder.decode(paramString2);
    ((oz)localObject2).scene = paramInt1;
    ((oz)localObject2).EeS = paramString3;
    ((oz)localObject2).wLo = paramString4;
    ((oz)localObject2).DQw = paramInt2;
    ((oz)localObject2).channel = paramInt3;
    ((oz)localObject2).wLp = paramString5;
    ((oz)localObject2).wLv = paramString6;
    ((oz)localObject2).wLt = paramInt4;
    ((oz)localObject2).EeZ = paramString13;
    ((oz)localObject2).Efb = paramInt8;
    ((oz)localObject2).iAz = paramString7;
    ((oz)localObject2).DQC = paramString14;
    if (paramaid != null) {
      ((oz)localObject2).DQv = paramaid;
    }
    ((oz)localObject2).EeL = paramString8;
    ((oz)localObject2).wJT = paramInt6;
    if (paramInt5 == 1)
    {
      paramString1 = ax.getWifiInfo(ai.getContext());
      if (paramString1 == null) {
        break label499;
      }
      ((oz)localObject2).EeT = paramString1.getBSSID();
    }
    for (;;)
    {
      ((oz)localObject2).EeU = 0;
      ((oz)localObject2).znE = str;
      ((oz)localObject2).znF = ((String)localObject1);
      ((oz)localObject2).EeW = com.tencent.mm.plugin.wallet_core.model.s.ery().ese();
      com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      ((oz)localObject2).EeV = false;
      ((oz)localObject2).EeX = paramString9;
      ((oz)localObject2).wLr = paramString10;
      ((oz)localObject2).nickname = paramString11;
      ((oz)localObject2).Efa = paramInt7;
      ((oz)localObject2).wKR = paramString12;
      ((oz)localObject2).Efc = paramString15;
      ((oz)localObject2).Efd = paramString16;
      ac.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", new Object[] { paramString9 });
      ac.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s amount_remind_sign:%s inputRecvName:%s checkRecvNameSign:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt5), a.a(paramaid), paramString9, paramString13, Integer.valueOf(paramInt8), Integer.valueOf(paramInt7), paramString14, paramString15, paramString16 });
      AppMethodBeat.o(174416);
      return;
      label499:
      ac.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
    }
  }
  
  public static JSONObject a(ot paramot)
  {
    AppMethodBeat.i(67852);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("flag", paramot.drx);
      localJSONObject.put("succpage_first_delay_ms", paramot.EeF);
      localJSONObject.put("succpage_max_retry_cnt", paramot.EeG);
      localJSONObject.put("succpage_retry_waiting_ms", paramot.EeH);
      AppMethodBeat.o(67852);
      return localJSONObject;
    }
    catch (Exception paramot)
    {
      for (;;)
      {
        ac.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "getBusiF2FFaultConfigJSONObject() Exception: %s", new Object[] { paramot.getMessage() });
      }
    }
  }
  
  public static ot arn(String paramString)
  {
    AppMethodBeat.i(67853);
    ot localot = new ot();
    try
    {
      paramString = new JSONObject(paramString);
      localot.drx = paramString.optInt("flag");
      localot.EeF = paramString.optInt("succpage_first_delay_ms");
      localot.EeG = paramString.optInt("succpage_max_retry_cnt");
      localot.EeH = paramString.optInt("succpage_retry_waiting_ms");
      AppMethodBeat.o(67853);
      return localot;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "createBusiF2FFaultConfigFromJSONObject() Exception: %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final void a(ge paramge)
  {
    int i = 1;
    this.wKo = paramge;
    oz localoz = (oz)this.gvE.hvr.hvw;
    if (paramge.dgB.dgD == 1) {}
    for (;;)
    {
      localoz.EeY = i;
      return;
      i = 0;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(67850);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
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
    ac.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.wKm = ((pa)((b)paramq).hvs.hvw);
    paramq = new StringBuffer();
    paramq.append(String.format("trans_id: %s,", new Object[] { this.wKm.DQt }));
    paramq.append(String.format("zero_pay_flag: %s,", new Object[] { Integer.valueOf(this.wKm.Efj) }));
    paramq.append(String.format("can_use_fingerprint: %s,", new Object[] { Integer.valueOf(this.wKm.Efp) }));
    paramq.append(String.format("payer_need_auth_flag: %s,", new Object[] { Integer.valueOf(this.wKm.Efk) }));
    paramArrayOfByte = new com.tencent.mm.wallet_core.c.e(paramInt2, paramInt3, paramString);
    com.tencent.mm.wallet_core.c.s.getRetModel(paramInt2, paramInt3, paramString, paramArrayOfByte);
    ac.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "ret_code: %s, ret_msg: %s trans_id: %s f2f_id: %s re_getfavor: %s payok_checksign: %s reqKey %s ret:%s", new Object[] { Integer.valueOf(this.wKm.nWx), this.wKm.nWy, this.wKm.DQt, this.wKm.DQs, Integer.valueOf(this.wKm.Efi), this.wKm.DQu, this.wKm.djr, paramq.toString() });
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