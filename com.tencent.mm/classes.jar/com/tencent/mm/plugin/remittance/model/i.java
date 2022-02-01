package com.tencent.mm.plugin.remittance.model;

import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.gl.a;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.rb;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.ri;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.wallet_core.c.j;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class i
  extends q
  implements m, j
{
  public int Bbl;
  public ri CoB;
  public String CoC;
  public gl CoD;
  private com.tencent.mm.ak.i callback;
  private com.tencent.mm.ak.d hJu;
  
  public i(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, anr paramanr, String paramString8, int paramInt6, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, int paramInt7, int paramInt8, String paramString14)
  {
    AppMethodBeat.i(163811);
    this.CoD = null;
    Object localObject2 = new d.a();
    ((d.a)localObject2).iLN = new rh();
    ((d.a)localObject2).iLO = new ri();
    ((d.a)localObject2).funcId = 1633;
    ((d.a)localObject2).uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
    ((d.a)localObject2).iLP = 0;
    ((d.a)localObject2).respCmdId = 0;
    Object localObject1 = com.tencent.mm.plugin.soter.d.d.flM();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject1).FhU;
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject1).hFF;
    this.CoC = paramString9;
    this.Bbl = paramInt2;
    this.hJu = ((d.a)localObject2).aXF();
    localObject2 = (rh)this.hJu.iLK.iLR;
    ((rh)localObject2).CpJ = paramString1;
    ((rh)localObject2).KYg = URLDecoder.decode(paramString2);
    ((rh)localObject2).scene = paramInt1;
    ((rh)localObject2).KYh = paramString3;
    ((rh)localObject2).CpD = paramString4;
    ((rh)localObject2).KHQ = paramInt2;
    ((rh)localObject2).channel = paramInt3;
    ((rh)localObject2).CpE = paramString5;
    ((rh)localObject2).CpK = paramString6;
    ((rh)localObject2).CpI = paramInt4;
    ((rh)localObject2).KYo = paramString13;
    ((rh)localObject2).KYq = paramInt8;
    ((rh)localObject2).jTz = paramString7;
    ((rh)localObject2).KHW = paramString14;
    if (paramanr != null) {
      ((rh)localObject2).KHP = paramanr;
    }
    ((rh)localObject2).KYa = paramString8;
    ((rh)localObject2).Coi = paramInt6;
    if (paramInt5 == 1)
    {
      paramString1 = NetStatusUtil.getWifiInfo(MMApplicationContext.getContext());
      if (paramString1 == null) {
        break label470;
      }
      ((rh)localObject2).KYi = paramString1.getBSSID();
    }
    for (;;)
    {
      ((rh)localObject2).KYj = 0;
      ((rh)localObject2).FhU = str;
      ((rh)localObject2).hFF = ((String)localObject1);
      ((rh)localObject2).KYl = t.fQI().fRo();
      com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
      ((rh)localObject2).KYk = false;
      ((rh)localObject2).KYm = paramString9;
      ((rh)localObject2).CpG = paramString10;
      ((rh)localObject2).nickname = paramString11;
      ((rh)localObject2).KYp = paramInt7;
      ((rh)localObject2).Cpg = paramString12;
      Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", new Object[] { paramString9 });
      Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s amount_remind_sign:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt5), a.a(paramanr), paramString9, paramString13, Integer.valueOf(paramInt8), Integer.valueOf(paramInt7), paramString14 });
      AppMethodBeat.o(163811);
      return;
      label470:
      Log.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
    }
  }
  
  public i(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, anr paramanr, String paramString8, int paramInt6, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, int paramInt7, int paramInt8, String paramString14, String paramString15, String paramString16)
  {
    AppMethodBeat.i(174416);
    this.CoD = null;
    Object localObject2 = new d.a();
    ((d.a)localObject2).iLN = new rh();
    ((d.a)localObject2).iLO = new ri();
    ((d.a)localObject2).funcId = 1633;
    ((d.a)localObject2).uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
    ((d.a)localObject2).iLP = 0;
    ((d.a)localObject2).respCmdId = 0;
    Object localObject1 = com.tencent.mm.plugin.soter.d.d.flM();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject1).FhU;
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject1).hFF;
    this.CoC = paramString9;
    this.Bbl = paramInt2;
    this.hJu = ((d.a)localObject2).aXF();
    localObject2 = (rh)this.hJu.iLK.iLR;
    ((rh)localObject2).CpJ = paramString1;
    ((rh)localObject2).KYg = URLDecoder.decode(paramString2);
    ((rh)localObject2).scene = paramInt1;
    ((rh)localObject2).KYh = paramString3;
    ((rh)localObject2).CpD = paramString4;
    ((rh)localObject2).KHQ = paramInt2;
    ((rh)localObject2).channel = paramInt3;
    ((rh)localObject2).CpE = paramString5;
    ((rh)localObject2).CpK = paramString6;
    ((rh)localObject2).CpI = paramInt4;
    ((rh)localObject2).KYo = paramString13;
    ((rh)localObject2).KYq = paramInt8;
    ((rh)localObject2).jTz = paramString7;
    ((rh)localObject2).KHW = paramString14;
    if (paramanr != null) {
      ((rh)localObject2).KHP = paramanr;
    }
    ((rh)localObject2).KYa = paramString8;
    ((rh)localObject2).Coi = paramInt6;
    if (paramInt5 == 1)
    {
      paramString1 = NetStatusUtil.getWifiInfo(MMApplicationContext.getContext());
      if (paramString1 == null) {
        break label499;
      }
      ((rh)localObject2).KYi = paramString1.getBSSID();
    }
    for (;;)
    {
      ((rh)localObject2).KYj = 0;
      ((rh)localObject2).FhU = str;
      ((rh)localObject2).hFF = ((String)localObject1);
      ((rh)localObject2).KYl = t.fQI().fRo();
      com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
      ((rh)localObject2).KYk = false;
      ((rh)localObject2).KYm = paramString9;
      ((rh)localObject2).CpG = paramString10;
      ((rh)localObject2).nickname = paramString11;
      ((rh)localObject2).KYp = paramInt7;
      ((rh)localObject2).Cpg = paramString12;
      ((rh)localObject2).KYr = paramString15;
      ((rh)localObject2).KYs = paramString16;
      Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", new Object[] { paramString9 });
      Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s amount_remind_sign:%s inputRecvName:%s checkRecvNameSign:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt5), a.a(paramanr), paramString9, paramString13, Integer.valueOf(paramInt8), Integer.valueOf(paramInt7), paramString14, paramString15, paramString16 });
      AppMethodBeat.o(174416);
      return;
      label499:
      Log.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
    }
  }
  
  public static JSONObject a(rb paramrb)
  {
    AppMethodBeat.i(67852);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("flag", paramrb.cSx);
      localJSONObject.put("succpage_first_delay_ms", paramrb.KXU);
      localJSONObject.put("succpage_max_retry_cnt", paramrb.KXV);
      localJSONObject.put("succpage_retry_waiting_ms", paramrb.KXW);
      AppMethodBeat.o(67852);
      return localJSONObject;
    }
    catch (Exception paramrb)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "getBusiF2FFaultConfigJSONObject() Exception: %s", new Object[] { paramrb.getMessage() });
      }
    }
  }
  
  public static rb aMc(String paramString)
  {
    AppMethodBeat.i(67853);
    rb localrb = new rb();
    try
    {
      paramString = new JSONObject(paramString);
      localrb.cSx = paramString.optInt("flag");
      localrb.KXU = paramString.optInt("succpage_first_delay_ms");
      localrb.KXV = paramString.optInt("succpage_max_retry_cnt");
      localrb.KXW = paramString.optInt("succpage_retry_waiting_ms");
      AppMethodBeat.o(67853);
      return localrb;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "createBusiF2FFaultConfigFromJSONObject() Exception: %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final void a(gl paramgl)
  {
    int i = 1;
    this.CoD = paramgl;
    rh localrh = (rh)this.hJu.iLK.iLR;
    if (paramgl.dKn.dKp == 1) {}
    for (;;)
    {
      localrh.KYn = i;
      return;
      i = 0;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(67850);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
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
    this.CoB = ((ri)((com.tencent.mm.ak.d)params).iLL.iLR);
    params = new StringBuffer();
    params.append(String.format("trans_id: %s,", new Object[] { this.CoB.KHN }));
    params.append(String.format("zero_pay_flag: %s,", new Object[] { Integer.valueOf(this.CoB.KYy) }));
    params.append(String.format("can_use_fingerprint: %s,", new Object[] { Integer.valueOf(this.CoB.KYE) }));
    params.append(String.format("payer_need_auth_flag: %s,", new Object[] { Integer.valueOf(this.CoB.KYz) }));
    paramArrayOfByte = new com.tencent.mm.wallet_core.c.e(paramInt2, paramInt3, paramString);
    com.tencent.mm.wallet_core.c.s.getRetModel(paramInt2, paramInt3, paramString, paramArrayOfByte);
    Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "ret_code: %s, ret_msg: %s trans_id: %s f2f_id: %s re_getfavor: %s payok_checksign: %s reqKey %s ret:%s", new Object[] { Integer.valueOf(this.CoB.pTZ), this.CoB.pUa, this.CoB.KHN, this.CoB.KHM, Integer.valueOf(this.CoB.KYx), this.CoB.KHO, this.CoB.dNQ, params.toString() });
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