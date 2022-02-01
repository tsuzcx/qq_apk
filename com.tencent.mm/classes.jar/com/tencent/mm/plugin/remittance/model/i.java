package com.tencent.mm.plugin.remittance.model;

import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.gh.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.qe;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.s;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class i
  extends n
  implements k, j
{
  private f callback;
  private b gPp;
  public int wNV;
  public qf xXT;
  public String xXU;
  public gh xXV;
  
  public i(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, akt paramakt, String paramString8, int paramInt6, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, int paramInt7, int paramInt8, String paramString14)
  {
    AppMethodBeat.i(163811);
    this.xXV = null;
    Object localObject2 = new b.a();
    ((b.a)localObject2).hNM = new qe();
    ((b.a)localObject2).hNN = new qf();
    ((b.a)localObject2).funcId = 1633;
    ((b.a)localObject2).uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
    ((b.a)localObject2).hNO = 0;
    ((b.a)localObject2).respCmdId = 0;
    Object localObject1 = d.efE();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject1).AFy;
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject1).AFz;
    this.xXU = paramString9;
    this.wNV = paramInt2;
    this.gPp = ((b.a)localObject2).aDC();
    localObject2 = (qe)this.gPp.hNK.hNQ;
    ((qe)localObject2).xZb = paramString1;
    ((qe)localObject2).FLq = URLDecoder.decode(paramString2);
    ((qe)localObject2).scene = paramInt1;
    ((qe)localObject2).FLr = paramString3;
    ((qe)localObject2).xYV = paramString4;
    ((qe)localObject2).FvL = paramInt2;
    ((qe)localObject2).channel = paramInt3;
    ((qe)localObject2).xYW = paramString5;
    ((qe)localObject2).xZc = paramString6;
    ((qe)localObject2).xZa = paramInt4;
    ((qe)localObject2).FLy = paramString13;
    ((qe)localObject2).FLA = paramInt8;
    ((qe)localObject2).iTJ = paramString7;
    ((qe)localObject2).FvR = paramString14;
    if (paramakt != null) {
      ((qe)localObject2).FvK = paramakt;
    }
    ((qe)localObject2).FLk = paramString8;
    ((qe)localObject2).xXA = paramInt6;
    if (paramInt5 == 1)
    {
      paramString1 = ay.getWifiInfo(aj.getContext());
      if (paramString1 == null) {
        break label470;
      }
      ((qe)localObject2).FLs = paramString1.getBSSID();
    }
    for (;;)
    {
      ((qe)localObject2).FLt = 0;
      ((qe)localObject2).AFy = str;
      ((qe)localObject2).AFz = ((String)localObject1);
      ((qe)localObject2).FLv = t.eFy().eGe();
      g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      ((qe)localObject2).FLu = false;
      ((qe)localObject2).FLw = paramString9;
      ((qe)localObject2).xYY = paramString10;
      ((qe)localObject2).nickname = paramString11;
      ((qe)localObject2).FLz = paramInt7;
      ((qe)localObject2).xYy = paramString12;
      ad.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", new Object[] { paramString9 });
      ad.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s amount_remind_sign:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt5), a.a(paramakt), paramString9, paramString13, Integer.valueOf(paramInt8), Integer.valueOf(paramInt7), paramString14 });
      AppMethodBeat.o(163811);
      return;
      label470:
      ad.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
    }
  }
  
  public i(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, akt paramakt, String paramString8, int paramInt6, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, int paramInt7, int paramInt8, String paramString14, String paramString15, String paramString16)
  {
    AppMethodBeat.i(174416);
    this.xXV = null;
    Object localObject2 = new b.a();
    ((b.a)localObject2).hNM = new qe();
    ((b.a)localObject2).hNN = new qf();
    ((b.a)localObject2).funcId = 1633;
    ((b.a)localObject2).uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
    ((b.a)localObject2).hNO = 0;
    ((b.a)localObject2).respCmdId = 0;
    Object localObject1 = d.efE();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject1).AFy;
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject1).AFz;
    this.xXU = paramString9;
    this.wNV = paramInt2;
    this.gPp = ((b.a)localObject2).aDC();
    localObject2 = (qe)this.gPp.hNK.hNQ;
    ((qe)localObject2).xZb = paramString1;
    ((qe)localObject2).FLq = URLDecoder.decode(paramString2);
    ((qe)localObject2).scene = paramInt1;
    ((qe)localObject2).FLr = paramString3;
    ((qe)localObject2).xYV = paramString4;
    ((qe)localObject2).FvL = paramInt2;
    ((qe)localObject2).channel = paramInt3;
    ((qe)localObject2).xYW = paramString5;
    ((qe)localObject2).xZc = paramString6;
    ((qe)localObject2).xZa = paramInt4;
    ((qe)localObject2).FLy = paramString13;
    ((qe)localObject2).FLA = paramInt8;
    ((qe)localObject2).iTJ = paramString7;
    ((qe)localObject2).FvR = paramString14;
    if (paramakt != null) {
      ((qe)localObject2).FvK = paramakt;
    }
    ((qe)localObject2).FLk = paramString8;
    ((qe)localObject2).xXA = paramInt6;
    if (paramInt5 == 1)
    {
      paramString1 = ay.getWifiInfo(aj.getContext());
      if (paramString1 == null) {
        break label499;
      }
      ((qe)localObject2).FLs = paramString1.getBSSID();
    }
    for (;;)
    {
      ((qe)localObject2).FLt = 0;
      ((qe)localObject2).AFy = str;
      ((qe)localObject2).AFz = ((String)localObject1);
      ((qe)localObject2).FLv = t.eFy().eGe();
      g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      ((qe)localObject2).FLu = false;
      ((qe)localObject2).FLw = paramString9;
      ((qe)localObject2).xYY = paramString10;
      ((qe)localObject2).nickname = paramString11;
      ((qe)localObject2).FLz = paramInt7;
      ((qe)localObject2).xYy = paramString12;
      ((qe)localObject2).FLB = paramString15;
      ((qe)localObject2).FLC = paramString16;
      ad.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", new Object[] { paramString9 });
      ad.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s amount_remind_sign:%s inputRecvName:%s checkRecvNameSign:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt5), a.a(paramakt), paramString9, paramString13, Integer.valueOf(paramInt8), Integer.valueOf(paramInt7), paramString14, paramString15, paramString16 });
      AppMethodBeat.o(174416);
      return;
      label499:
      ad.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
    }
  }
  
  public static JSONObject a(py parampy)
  {
    AppMethodBeat.i(67852);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("flag", parampy.dDp);
      localJSONObject.put("succpage_first_delay_ms", parampy.FLe);
      localJSONObject.put("succpage_max_retry_cnt", parampy.FLf);
      localJSONObject.put("succpage_retry_waiting_ms", parampy.FLg);
      AppMethodBeat.o(67852);
      return localJSONObject;
    }
    catch (Exception parampy)
    {
      for (;;)
      {
        ad.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "getBusiF2FFaultConfigJSONObject() Exception: %s", new Object[] { parampy.getMessage() });
      }
    }
  }
  
  public static py awn(String paramString)
  {
    AppMethodBeat.i(67853);
    py localpy = new py();
    try
    {
      paramString = new JSONObject(paramString);
      localpy.dDp = paramString.optInt("flag");
      localpy.FLe = paramString.optInt("succpage_first_delay_ms");
      localpy.FLf = paramString.optInt("succpage_max_retry_cnt");
      localpy.FLg = paramString.optInt("succpage_retry_waiting_ms");
      AppMethodBeat.o(67853);
      return localpy;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "createBusiF2FFaultConfigFromJSONObject() Exception: %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final void a(gh paramgh)
  {
    int i = 1;
    this.xXV = paramgh;
    qe localqe = (qe)this.gPp.hNK.hNQ;
    if (paramgh.drX.drZ == 1) {}
    for (;;)
    {
      localqe.FLx = i;
      return;
      i = 0;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(67850);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
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
    this.xXT = ((qf)((b)paramq).hNL.hNQ);
    paramq = new StringBuffer();
    paramq.append(String.format("trans_id: %s,", new Object[] { this.xXT.FvI }));
    paramq.append(String.format("zero_pay_flag: %s,", new Object[] { Integer.valueOf(this.xXT.FLI) }));
    paramq.append(String.format("can_use_fingerprint: %s,", new Object[] { Integer.valueOf(this.xXT.FLO) }));
    paramq.append(String.format("payer_need_auth_flag: %s,", new Object[] { Integer.valueOf(this.xXT.FLJ) }));
    paramArrayOfByte = new com.tencent.mm.wallet_core.c.e(paramInt2, paramInt3, paramString);
    s.getRetModel(paramInt2, paramInt3, paramString, paramArrayOfByte);
    ad.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "ret_code: %s, ret_msg: %s trans_id: %s f2f_id: %s re_getfavor: %s payok_checksign: %s reqKey %s ret:%s", new Object[] { Integer.valueOf(this.xXT.ozR), this.xXT.ozS, this.xXT.FvI, this.xXT.FvH, Integer.valueOf(this.xXT.FLH), this.xXT.FvJ, this.xXT.dve, paramq.toString() });
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