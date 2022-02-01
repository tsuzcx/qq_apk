package com.tencent.mm.plugin.remittance.model;

import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.protocal.protobuf.qg;
import com.tencent.mm.protocal.protobuf.qh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.s;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class i
  extends n
  implements k, j
{
  private f callback;
  private b gRX;
  public int xdJ;
  public qh ynL;
  public String ynM;
  public gi ynN;
  
  public i(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, ald paramald, String paramString8, int paramInt6, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, int paramInt7, int paramInt8, String paramString14)
  {
    AppMethodBeat.i(163811);
    this.ynN = null;
    Object localObject2 = new b.a();
    ((b.a)localObject2).hQF = new qg();
    ((b.a)localObject2).hQG = new qh();
    ((b.a)localObject2).funcId = 1633;
    ((b.a)localObject2).uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
    ((b.a)localObject2).hQH = 0;
    ((b.a)localObject2).respCmdId = 0;
    Object localObject1 = d.ejm();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject1).AXb;
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject1).AXc;
    this.ynM = paramString9;
    this.xdJ = paramInt2;
    this.gRX = ((b.a)localObject2).aDS();
    localObject2 = (qg)this.gRX.hQD.hQJ;
    ((qg)localObject2).yoT = paramString1;
    ((qg)localObject2).GdP = URLDecoder.decode(paramString2);
    ((qg)localObject2).scene = paramInt1;
    ((qg)localObject2).GdQ = paramString3;
    ((qg)localObject2).yoN = paramString4;
    ((qg)localObject2).FOj = paramInt2;
    ((qg)localObject2).channel = paramInt3;
    ((qg)localObject2).yoO = paramString5;
    ((qg)localObject2).yoU = paramString6;
    ((qg)localObject2).yoS = paramInt4;
    ((qg)localObject2).GdX = paramString13;
    ((qg)localObject2).GdZ = paramInt8;
    ((qg)localObject2).iWC = paramString7;
    ((qg)localObject2).FOp = paramString14;
    if (paramald != null) {
      ((qg)localObject2).FOi = paramald;
    }
    ((qg)localObject2).GdJ = paramString8;
    ((qg)localObject2).yns = paramInt6;
    if (paramInt5 == 1)
    {
      paramString1 = az.getWifiInfo(ak.getContext());
      if (paramString1 == null) {
        break label470;
      }
      ((qg)localObject2).GdR = paramString1.getBSSID();
    }
    for (;;)
    {
      ((qg)localObject2).GdS = 0;
      ((qg)localObject2).AXb = str;
      ((qg)localObject2).AXc = ((String)localObject1);
      ((qg)localObject2).GdU = t.eJf().eJL();
      g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      ((qg)localObject2).GdT = false;
      ((qg)localObject2).GdV = paramString9;
      ((qg)localObject2).yoQ = paramString10;
      ((qg)localObject2).nickname = paramString11;
      ((qg)localObject2).GdY = paramInt7;
      ((qg)localObject2).yoq = paramString12;
      ae.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", new Object[] { paramString9 });
      ae.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s amount_remind_sign:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt5), a.a(paramald), paramString9, paramString13, Integer.valueOf(paramInt8), Integer.valueOf(paramInt7), paramString14 });
      AppMethodBeat.o(163811);
      return;
      label470:
      ae.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
    }
  }
  
  public i(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, ald paramald, String paramString8, int paramInt6, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, int paramInt7, int paramInt8, String paramString14, String paramString15, String paramString16)
  {
    AppMethodBeat.i(174416);
    this.ynN = null;
    Object localObject2 = new b.a();
    ((b.a)localObject2).hQF = new qg();
    ((b.a)localObject2).hQG = new qh();
    ((b.a)localObject2).funcId = 1633;
    ((b.a)localObject2).uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
    ((b.a)localObject2).hQH = 0;
    ((b.a)localObject2).respCmdId = 0;
    Object localObject1 = d.ejm();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject1).AXb;
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject1).AXc;
    this.ynM = paramString9;
    this.xdJ = paramInt2;
    this.gRX = ((b.a)localObject2).aDS();
    localObject2 = (qg)this.gRX.hQD.hQJ;
    ((qg)localObject2).yoT = paramString1;
    ((qg)localObject2).GdP = URLDecoder.decode(paramString2);
    ((qg)localObject2).scene = paramInt1;
    ((qg)localObject2).GdQ = paramString3;
    ((qg)localObject2).yoN = paramString4;
    ((qg)localObject2).FOj = paramInt2;
    ((qg)localObject2).channel = paramInt3;
    ((qg)localObject2).yoO = paramString5;
    ((qg)localObject2).yoU = paramString6;
    ((qg)localObject2).yoS = paramInt4;
    ((qg)localObject2).GdX = paramString13;
    ((qg)localObject2).GdZ = paramInt8;
    ((qg)localObject2).iWC = paramString7;
    ((qg)localObject2).FOp = paramString14;
    if (paramald != null) {
      ((qg)localObject2).FOi = paramald;
    }
    ((qg)localObject2).GdJ = paramString8;
    ((qg)localObject2).yns = paramInt6;
    if (paramInt5 == 1)
    {
      paramString1 = az.getWifiInfo(ak.getContext());
      if (paramString1 == null) {
        break label499;
      }
      ((qg)localObject2).GdR = paramString1.getBSSID();
    }
    for (;;)
    {
      ((qg)localObject2).GdS = 0;
      ((qg)localObject2).AXb = str;
      ((qg)localObject2).AXc = ((String)localObject1);
      ((qg)localObject2).GdU = t.eJf().eJL();
      g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      ((qg)localObject2).GdT = false;
      ((qg)localObject2).GdV = paramString9;
      ((qg)localObject2).yoQ = paramString10;
      ((qg)localObject2).nickname = paramString11;
      ((qg)localObject2).GdY = paramInt7;
      ((qg)localObject2).yoq = paramString12;
      ((qg)localObject2).Gea = paramString15;
      ((qg)localObject2).Geb = paramString16;
      ae.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", new Object[] { paramString9 });
      ae.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s amount_remind_sign:%s inputRecvName:%s checkRecvNameSign:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt5), a.a(paramald), paramString9, paramString13, Integer.valueOf(paramInt8), Integer.valueOf(paramInt7), paramString14, paramString15, paramString16 });
      AppMethodBeat.o(174416);
      return;
      label499:
      ae.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
    }
  }
  
  public static JSONObject a(qa paramqa)
  {
    AppMethodBeat.i(67852);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("flag", paramqa.dEu);
      localJSONObject.put("succpage_first_delay_ms", paramqa.GdD);
      localJSONObject.put("succpage_max_retry_cnt", paramqa.GdE);
      localJSONObject.put("succpage_retry_waiting_ms", paramqa.GdF);
      AppMethodBeat.o(67852);
      return localJSONObject;
    }
    catch (Exception paramqa)
    {
      for (;;)
      {
        ae.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "getBusiF2FFaultConfigJSONObject() Exception: %s", new Object[] { paramqa.getMessage() });
      }
    }
  }
  
  public static qa axC(String paramString)
  {
    AppMethodBeat.i(67853);
    qa localqa = new qa();
    try
    {
      paramString = new JSONObject(paramString);
      localqa.dEu = paramString.optInt("flag");
      localqa.GdD = paramString.optInt("succpage_first_delay_ms");
      localqa.GdE = paramString.optInt("succpage_max_retry_cnt");
      localqa.GdF = paramString.optInt("succpage_retry_waiting_ms");
      AppMethodBeat.o(67853);
      return localqa;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "createBusiF2FFaultConfigFromJSONObject() Exception: %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final void a(gi paramgi)
  {
    int i = 1;
    this.ynN = paramgi;
    qg localqg = (qg)this.gRX.hQD.hQJ;
    if (paramgi.dtd.dtf == 1) {}
    for (;;)
    {
      localqg.GdW = i;
      return;
      i = 0;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(67850);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
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
    ae.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.ynL = ((qh)((b)paramq).hQE.hQJ);
    paramq = new StringBuffer();
    paramq.append(String.format("trans_id: %s,", new Object[] { this.ynL.FOg }));
    paramq.append(String.format("zero_pay_flag: %s,", new Object[] { Integer.valueOf(this.ynL.Geh) }));
    paramq.append(String.format("can_use_fingerprint: %s,", new Object[] { Integer.valueOf(this.ynL.Gen) }));
    paramq.append(String.format("payer_need_auth_flag: %s,", new Object[] { Integer.valueOf(this.ynL.Gei) }));
    paramArrayOfByte = new com.tencent.mm.wallet_core.c.e(paramInt2, paramInt3, paramString);
    s.getRetModel(paramInt2, paramInt3, paramString, paramArrayOfByte);
    ae.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "ret_code: %s, ret_msg: %s trans_id: %s f2f_id: %s re_getfavor: %s payok_checksign: %s reqKey %s ret:%s", new Object[] { Integer.valueOf(this.ynL.oGt), this.ynL.oGu, this.ynL.FOg, this.ynL.FOf, Integer.valueOf(this.ynL.Geg), this.ynL.FOh, this.ynL.dwj, paramq.toString() });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramArrayOfByte.errType, paramArrayOfByte.errCode, paramArrayOfByte.errMsg, this);
    }
    AppMethodBeat.o(67851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.i
 * JD-Core Version:    0.7.0.1
 */