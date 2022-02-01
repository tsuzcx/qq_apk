package com.tencent.mm.plugin.offline.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends m
{
  public static String AJF = "3";
  public String AJA;
  public String AJB;
  public String AJC;
  public String AJD;
  public String AJE;
  public String AJG;
  public int AJH;
  public String AJI;
  public String AJJ;
  public String AJK;
  public int AJL;
  public String token;
  
  public k(Bankcard paramBankcard, String paramString, int paramInt)
  {
    AppMethodBeat.i(66300);
    this.AJA = "";
    this.AJB = "";
    this.token = "";
    this.AJC = "";
    this.AJD = "";
    this.AJE = "";
    this.AJG = "";
    this.AJH = 0;
    this.AJI = "";
    this.AJJ = "";
    this.AJK = "";
    this.AJL = 20000;
    String str = q.aoG();
    Object localObject = (String)l.aol().get(256);
    if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).equals(str))) {
      h.CyF.dN(965, 48);
    }
    Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "old id: %s, new id: %s", new Object[] { localObject, str });
    localObject = new HashMap();
    ((Map)localObject).put("passwd", paramString);
    ((Map)localObject).put("device_id", str);
    ((Map)localObject).put("weixin_ver", "0x" + Integer.toHexString(d.KyO));
    ((Map)localObject).put("bind_serialno", paramBankcard.field_bindSerial);
    ((Map)localObject).put("bank_type", paramBankcard.field_bankcardType);
    ((Map)localObject).put("card_tail", paramBankcard.field_bankcardTail);
    ((Map)localObject).put("open_limitfee", String.valueOf(paramInt));
    this.AJL = paramInt;
    paramBankcard = f.getUsername();
    paramBankcard = MD5Util.getMD5String(MD5Util.getMD5String(paramBankcard) + MD5Util.getMD5String(q.aoG()));
    ((Map)localObject).put("user_id", paramBankcard);
    paramString = com.tencent.mm.wallet_core.c.b.hhj();
    com.tencent.mm.wallet_core.b.hgC();
    if (com.tencent.mm.wallet_core.b.hgE()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramBankcard = paramString.hr(paramBankcard, paramInt);
      com.tencent.mm.wallet_core.b.hgC();
      Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "crt_csr %s %s", new Object[] { paramBankcard, Boolean.valueOf(com.tencent.mm.wallet_core.b.hgE()) });
      ((Map)localObject).put("crt_csr", paramBankcard);
      ((Map)localObject).put("type", AJF);
      ((Map)localObject).put("version_number", AJF);
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
      com.tencent.mm.plugin.offline.k.ezn();
      com.tencent.mm.plugin.offline.k.bN(196630, "0");
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
      h.CyF.b(paramString, true);
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
      this.AJB = paramJSONObject.optString("crt_crt");
      this.AJA = paramJSONObject.optString("cn");
      this.token = paramJSONObject.optString("token");
      this.AJC = paramJSONObject.optString("valid_end");
      this.AJD = paramJSONObject.optString("encrypt_str");
      this.AJE = paramJSONObject.optString("deviceid");
      if (!com.tencent.mm.wallet_core.c.b.hhj().importCert(this.AJA, this.AJB)) {
        break label531;
      }
      Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
      this.AJG = paramJSONObject.optString("token_v2");
      this.AJH = paramJSONObject.optInt("algorithm_type");
      this.AJI = paramJSONObject.optString("card_list");
      this.AJJ = paramJSONObject.optString("key_list");
      this.AJK = paramJSONObject.optString("token_pin");
      String str2 = paramJSONObject.optString("notice_url");
      String str1 = paramJSONObject.optString("auth_codes");
      paramInt = paramJSONObject.optInt("update_interval");
      paramString = paramJSONObject.optString("code_ver");
      int i = paramJSONObject.optInt("cipher_type", 0);
      com.tencent.mm.plugin.offline.k.ezn();
      com.tencent.mm.plugin.offline.k.bN(196617, this.AJA);
      com.tencent.mm.plugin.offline.k.ezn();
      com.tencent.mm.plugin.offline.k.bN(196626, this.AJC);
      com.tencent.mm.plugin.offline.k.ezn();
      com.tencent.mm.plugin.offline.k.bN(196627, this.AJD);
      com.tencent.mm.plugin.offline.k.ezn();
      com.tencent.mm.plugin.offline.k.bN(196628, this.AJE);
      com.tencent.mm.plugin.offline.k.ezn();
      com.tencent.mm.plugin.offline.k.bN(196630, "1");
      com.tencent.mm.plugin.offline.k.ezn();
      com.tencent.mm.plugin.offline.k.bN(196632, System.currentTimeMillis() / 1000L);
      a.w(this.token, this.AJG, this.AJI, this.AJJ);
      a.Uf(this.AJH);
      com.tencent.mm.plugin.offline.k.ezn();
      com.tencent.mm.plugin.offline.k.bN(196647, this.AJK);
      a.aJn(str2);
      com.tencent.mm.plugin.offline.k.ezn();
      paramJSONObject = com.tencent.mm.plugin.offline.k.TX(196617);
      com.tencent.mm.wallet_core.c.b.hhj();
      com.tencent.mm.wallet_core.c.b.clearToken(paramJSONObject);
      com.tencent.mm.wallet_core.c.b.hhj();
      paramJSONObject = this.AJA;
      if (i != 1) {
        break label542;
      }
      bool = true;
      label380:
      bool = com.tencent.mm.wallet_core.c.b.F(paramJSONObject, str1, bool);
      Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", new Object[] { Boolean.valueOf(bool), this.AJA });
      if (bool) {
        break label548;
      }
      Log.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
      paramJSONObject = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      com.tencent.mm.wallet_core.c.b.hhj();
      Log.e("MicroMsg.NetSceneTenpayWxOfflineCreate", com.tencent.mm.wallet_core.c.b.getLastError());
    }
    for (;;)
    {
      com.tencent.mm.plugin.offline.k.ezn();
      com.tencent.mm.plugin.offline.k.bN(196649, String.valueOf(paramInt));
      g.aAi();
      g.aAh().azQ().set(ar.a.NSn, q.dr(true));
      g.aAi();
      g.aAh().azQ().set(ar.a.NSo, paramString);
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
  
  public final void onGYNetEnd2(com.tencent.mm.wallet_core.c.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66303);
    com.tencent.mm.wallet_core.c.b.hhj().hhk();
    AppMethodBeat.o(66303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.k
 * JD-Core Version:    0.7.0.1
 */