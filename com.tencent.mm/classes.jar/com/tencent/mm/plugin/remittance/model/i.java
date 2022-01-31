package com.tencent.mm.plugin.remittance.model;

import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.protocal.protobuf.mj;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class i
  extends m
  implements k, com.tencent.mm.wallet_core.c.i
{
  private f callback;
  public b goo;
  public mq qji;
  public String qjj;
  public fx qjk;
  
  public i(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, adg paramadg, String paramString8, int paramInt6, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(44738);
    this.qjk = null;
    Object localObject2 = new b.a();
    ((b.a)localObject2).fsX = new mp();
    ((b.a)localObject2).fsY = new mq();
    ((b.a)localObject2).funcId = 1633;
    ((b.a)localObject2).uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
    ((b.a)localObject2).reqCmdId = 0;
    ((b.a)localObject2).respCmdId = 0;
    Object localObject1 = com.tencent.mm.plugin.soter.d.d.cyc();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject1).son;
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject1).kbP;
    this.qjj = paramString9;
    this.goo = ((b.a)localObject2).ado();
    localObject2 = (mp)this.goo.fsV.fta;
    ((mp)localObject2).qkn = paramString1;
    ((mp)localObject2).wBb = URLDecoder.decode(paramString2);
    ((mp)localObject2).scene = paramInt1;
    ((mp)localObject2).wBc = paramString3;
    ((mp)localObject2).qkh = paramString4;
    ((mp)localObject2).wpu = paramInt2;
    ((mp)localObject2).cCy = paramInt3;
    ((mp)localObject2).qki = paramString5;
    ((mp)localObject2).qko = paramString6;
    ((mp)localObject2).qkm = paramInt4;
    ((mp)localObject2).wBj = paramString13;
    ((mp)localObject2).wBl = paramInt8;
    ((mp)localObject2).wpt = paramString7;
    if (paramadg != null) {
      ((mp)localObject2).wps = paramadg;
    }
    ((mp)localObject2).wAV = paramString8;
    ((mp)localObject2).qiP = paramInt6;
    if (paramInt5 == 1)
    {
      paramString1 = at.getWifiInfo(ah.getContext());
      if (paramString1 == null) {
        break label451;
      }
      ((mp)localObject2).wBd = paramString1.getBSSID();
    }
    for (;;)
    {
      ((mp)localObject2).wBe = 0;
      ((mp)localObject2).son = str;
      ((mp)localObject2).kbP = ((String)localObject1);
      ((mp)localObject2).wBg = t.cTN().cUp();
      g.E(l.class);
      ((mp)localObject2).wBf = false;
      ((mp)localObject2).wBh = paramString9;
      ((mp)localObject2).qkk = paramString10;
      ((mp)localObject2).nickname = paramString11;
      ((mp)localObject2).wBk = paramInt7;
      ((mp)localObject2).qjK = paramString12;
      ab.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", new Object[] { paramString9 });
      ab.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt5), a.a(paramadg), paramString9, paramString13, Integer.valueOf(paramInt8), Integer.valueOf(paramInt7) });
      AppMethodBeat.o(44738);
      return;
      label451:
      ab.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
    }
  }
  
  public static mj Yf(String paramString)
  {
    AppMethodBeat.i(142130);
    mj localmj = new mj();
    try
    {
      paramString = new JSONObject(paramString);
      localmj.bsY = paramString.optInt("flag");
      localmj.wAP = paramString.optInt("succpage_first_delay_ms");
      localmj.wAQ = paramString.optInt("succpage_max_retry_cnt");
      localmj.wAR = paramString.optInt("succpage_retry_waiting_ms");
      AppMethodBeat.o(142130);
      return localmj;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "createBusiF2FFaultConfigFromJSONObject() Exception: %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public static JSONObject a(mj parammj)
  {
    AppMethodBeat.i(142129);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("flag", parammj.bsY);
      localJSONObject.put("succpage_first_delay_ms", parammj.wAP);
      localJSONObject.put("succpage_max_retry_cnt", parammj.wAQ);
      localJSONObject.put("succpage_retry_waiting_ms", parammj.wAR);
      AppMethodBeat.o(142129);
      return localJSONObject;
    }
    catch (Exception parammj)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "getBusiF2FFaultConfigJSONObject() Exception: %s", new Object[] { parammj.getMessage() });
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(44739);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(44739);
    return i;
  }
  
  public final int getType()
  {
    return 1633;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(44740);
    ab.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.qji = ((mq)((b)paramq).fsW.fta);
    paramq = new StringBuffer();
    paramq.append(String.format("trans_id: %s,", new Object[] { this.qji.wpq }));
    paramq.append(String.format("zero_pay_flag: %s,", new Object[] { Integer.valueOf(this.qji.wBr) }));
    paramq.append(String.format("can_use_fingerprint: %s,", new Object[] { Integer.valueOf(this.qji.wBx) }));
    paramq.append(String.format("payer_need_auth_flag: %s,", new Object[] { Integer.valueOf(this.qji.wBs) }));
    paramArrayOfByte = new com.tencent.mm.wallet_core.c.d(paramInt2, paramInt3, paramString);
    com.tencent.mm.wallet_core.c.q.getRetModel(paramInt2, paramInt3, paramString, paramArrayOfByte);
    ab.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "ret_code: %s, ret_msg: %s trans_id: %s f2f_id: %s re_getfavor: %s payok_checksign: %s reqKey %s ret:%s", new Object[] { Integer.valueOf(this.qji.koj), this.qji.kok, this.qji.wpq, this.qji.wpp, Integer.valueOf(this.qji.wBq), this.qji.wpr, this.qji.cwk, paramq.toString() });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramArrayOfByte.errType, paramArrayOfByte.errCode, paramArrayOfByte.errMsg, this);
    }
    AppMethodBeat.o(44740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.i
 * JD-Core Version:    0.7.0.1
 */