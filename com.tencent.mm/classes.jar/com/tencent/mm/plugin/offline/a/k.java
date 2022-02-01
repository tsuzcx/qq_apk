package com.tencent.mm.plugin.offline.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends m
{
  public static String GCN = "3";
  public String GCH;
  public String GCI;
  public String GCJ;
  public String GCK;
  public String GCL;
  public String GCO;
  public int GCP;
  public String GCQ;
  public String GCR;
  public String GCS;
  public int GCT;
  public String token;
  
  public k(Bankcard paramBankcard, String paramString, int paramInt)
  {
    AppMethodBeat.i(66300);
    this.GCH = "";
    this.GCI = "";
    this.token = "";
    this.GCJ = "";
    this.GCK = "";
    this.GCL = "";
    this.GCO = "";
    this.GCP = 0;
    this.GCQ = "";
    this.GCR = "";
    this.GCS = "";
    this.GCT = 20000;
    String str = q.auM();
    Object localObject = (String)l.auq().get(256);
    if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).equals(str))) {
      com.tencent.mm.plugin.report.service.h.IzE.el(965, 48);
    }
    Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "old id: %s, new id: %s", new Object[] { localObject, str });
    localObject = new HashMap();
    ((Map)localObject).put("passwd", paramString);
    ((Map)localObject).put("device_id", str);
    ((Map)localObject).put("weixin_ver", "0x" + Integer.toHexString(d.RAD));
    ((Map)localObject).put("bind_serialno", paramBankcard.field_bindSerial);
    ((Map)localObject).put("bank_type", paramBankcard.field_bankcardType);
    ((Map)localObject).put("card_tail", paramBankcard.field_bankcardTail);
    ((Map)localObject).put("open_limitfee", String.valueOf(paramInt));
    this.GCT = paramInt;
    paramBankcard = g.getUsername();
    paramBankcard = MD5Util.getMD5String(MD5Util.getMD5String(paramBankcard) + MD5Util.getMD5String(q.auM()));
    ((Map)localObject).put("user_id", paramBankcard);
    paramString = com.tencent.mm.wallet_core.c.b.iiL();
    com.tencent.mm.wallet_core.b.iie();
    if (com.tencent.mm.wallet_core.b.iig()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramBankcard = paramString.ia(paramBankcard, paramInt);
      com.tencent.mm.wallet_core.b.iie();
      Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "crt_csr %s %s", new Object[] { paramBankcard, Boolean.valueOf(com.tencent.mm.wallet_core.b.iig()) });
      ((Map)localObject).put("crt_csr", paramBankcard);
      ((Map)localObject).put("type", GCN);
      ((Map)localObject).put("version_number", GCN);
      setRequestData((Map)localObject);
      AppMethodBeat.o(66300);
      return;
    }
  }
  
  public final int getFuncId()
  {
    return 565;
  }
  
  public final int getTenpayCgicmd()
  {
    return 46;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlinecreate";
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66302);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.bL(196630, "0");
    }
    paramString = new ArrayList();
    params = new IDKey();
    params.SetID(135);
    params.SetValue(1L);
    params.SetKey(11);
    paramArrayOfByte = new IDKey();
    paramArrayOfByte.SetID(135);
    paramArrayOfByte.SetValue(1L);
    if ((paramInt3 == 0) && (paramInt3 == 0)) {
      paramArrayOfByte.SetKey(9);
    }
    for (;;)
    {
      paramString.add(params);
      paramString.add(paramArrayOfByte);
      com.tencent.mm.plugin.report.service.h.IzE.b(paramString, true);
      AppMethodBeat.o(66302);
      return;
      paramArrayOfByte.SetKey(10);
    }
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66301);
    boolean bool;
    if (paramJSONObject != null)
    {
      this.GCI = paramJSONObject.optString("crt_crt");
      this.GCH = paramJSONObject.optString("cn");
      this.token = paramJSONObject.optString("token");
      this.GCJ = paramJSONObject.optString("valid_end");
      this.GCK = paramJSONObject.optString("encrypt_str");
      this.GCL = paramJSONObject.optString("deviceid");
      if (!com.tencent.mm.wallet_core.c.b.iiL().importCert(this.GCH, this.GCI)) {
        break label531;
      }
      Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
      this.GCO = paramJSONObject.optString("token_v2");
      this.GCP = paramJSONObject.optInt("algorithm_type");
      this.GCQ = paramJSONObject.optString("card_list");
      this.GCR = paramJSONObject.optString("key_list");
      this.GCS = paramJSONObject.optString("token_pin");
      String str2 = paramJSONObject.optString("notice_url");
      String str1 = paramJSONObject.optString("auth_codes");
      paramInt = paramJSONObject.optInt("update_interval");
      paramString = paramJSONObject.optString("code_ver");
      int i = paramJSONObject.optInt("cipher_type", 0);
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.bL(196617, this.GCH);
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.bL(196626, this.GCJ);
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.bL(196627, this.GCK);
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.bL(196628, this.GCL);
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.bL(196630, "1");
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.bL(196632, System.currentTimeMillis() / 1000L);
      a.B(this.token, this.GCO, this.GCQ, this.GCR);
      a.aaQ(this.GCP);
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.bL(196647, this.GCS);
      a.aTJ(str2);
      com.tencent.mm.plugin.offline.k.fkT();
      paramJSONObject = com.tencent.mm.plugin.offline.k.aaK(196617);
      com.tencent.mm.wallet_core.c.b.iiL();
      com.tencent.mm.wallet_core.c.b.clearToken(paramJSONObject);
      com.tencent.mm.wallet_core.c.b.iiL();
      paramJSONObject = this.GCH;
      if (i != 1) {
        break label542;
      }
      bool = true;
      label380:
      bool = com.tencent.mm.wallet_core.c.b.I(paramJSONObject, str1, bool);
      Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", new Object[] { Boolean.valueOf(bool), this.GCH });
      if (bool) {
        break label548;
      }
      Log.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
      paramJSONObject = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      com.tencent.mm.wallet_core.c.b.iiL();
      Log.e("MicroMsg.NetSceneTenpayWxOfflineCreate", com.tencent.mm.wallet_core.c.b.getLastError());
    }
    for (;;)
    {
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.bL(196649, String.valueOf(paramInt));
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vgl, q.dR(true));
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vgm, paramString);
      AppMethodBeat.o(66301);
      return;
      label531:
      Log.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt fail");
      break;
      label542:
      bool = false;
      break label380;
      label548:
      Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens success!");
    }
  }
  
  public final void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66303);
    com.tencent.mm.wallet_core.c.b.iiL().iiM();
    AppMethodBeat.o(66303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.k
 * JD-Core Version:    0.7.0.1
 */