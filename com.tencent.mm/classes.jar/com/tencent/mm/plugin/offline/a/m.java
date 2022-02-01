package com.tencent.mm.plugin.offline.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.e;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends com.tencent.mm.wallet_core.tenpay.model.m
{
  public static String VERSION_NUMBER = "3";
  public String MyS;
  public String MyT;
  public String MyU;
  public String MyV;
  public String MyW;
  public String MyX;
  public int MyY;
  public String MyZ;
  public String Mza;
  public String Mzb;
  private int Mzc;
  public int Mzd;
  public String token;
  
  public m(Bankcard paramBankcard, String paramString, int paramInt)
  {
    AppMethodBeat.i(66300);
    this.MyS = "";
    this.MyT = "";
    this.token = "";
    this.MyU = "";
    this.MyV = "";
    this.MyW = "";
    this.MyX = "";
    this.MyY = 0;
    this.MyZ = "";
    this.Mza = "";
    this.Mzb = "";
    this.Mzd = 20000;
    String str = q.aPg();
    Object localObject = (String)l.aOI().get(256);
    if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).equals(str))) {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(965, 48);
    }
    Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "old id: %s, new id: %s", new Object[] { localObject, str });
    localObject = new HashMap();
    ((Map)localObject).put("passwd", paramString);
    ((Map)localObject).put("device_id", str);
    ((Map)localObject).put("weixin_ver", "0x" + Integer.toHexString(com.tencent.mm.protocal.d.Yxh));
    ((Map)localObject).put("bind_serialno", paramBankcard.field_bindSerial);
    ((Map)localObject).put("bank_type", paramBankcard.field_bankcardType);
    ((Map)localObject).put("card_tail", paramBankcard.field_bankcardTail);
    ((Map)localObject).put("open_limitfee", String.valueOf(paramInt));
    this.Mzd = paramInt;
    paramBankcard = i.getUsername();
    paramBankcard = MD5Util.getMD5String(MD5Util.getMD5String(paramBankcard) + MD5Util.getMD5String(q.aPg()));
    ((Map)localObject).put("user_id", paramBankcard);
    paramString = com.tencent.mm.wallet_core.model.b.jOG();
    com.tencent.mm.wallet_core.b.jNX();
    if (com.tencent.mm.wallet_core.b.jNZ()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramBankcard = paramString.jm(paramBankcard, paramInt);
      com.tencent.mm.wallet_core.b.jNX();
      Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "crt_csr %s %s", new Object[] { paramBankcard, Boolean.valueOf(com.tencent.mm.wallet_core.b.jNZ()) });
      ((Map)localObject).put("crt_csr", paramBankcard);
      ((Map)localObject).put("type", VERSION_NUMBER);
      ((Map)localObject).put("version_number", VERSION_NUMBER);
      this.Mzc = com.tencent.mm.plugin.offline.c.d.gxe();
      ((Map)localObject).put("is_new_authcodes", this.Mzc);
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
      k.gvj();
      k.ct(196630, "0");
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
      com.tencent.mm.plugin.report.service.h.OAn.b(paramString, true);
      AppMethodBeat.o(66302);
      return;
      paramArrayOfByte.SetKey(10);
    }
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66301);
    int i;
    label333:
    boolean bool;
    if (paramJSONObject != null)
    {
      this.MyT = paramJSONObject.optString("crt_crt");
      this.MyS = paramJSONObject.optString("cn");
      this.token = paramJSONObject.optString("token");
      this.MyU = paramJSONObject.optString("valid_end");
      this.MyV = paramJSONObject.optString("encrypt_str");
      this.MyW = paramJSONObject.optString("deviceid");
      if (!com.tencent.mm.wallet_core.model.b.jOG().importCert(this.MyS, this.MyT)) {
        break label559;
      }
      Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
      this.MyX = paramJSONObject.optString("token_v2");
      this.MyY = paramJSONObject.optInt("algorithm_type");
      this.MyZ = paramJSONObject.optString("card_list");
      this.Mza = paramJSONObject.optString("key_list");
      this.Mzb = paramJSONObject.optString("token_pin");
      String str2 = paramJSONObject.optString("notice_url");
      String str1 = paramJSONObject.optString("auth_codes");
      i = paramJSONObject.optInt("update_interval");
      paramString = paramJSONObject.optString("code_ver");
      int j = paramJSONObject.optInt("cipher_type", 0);
      k.gvj();
      k.ct(196617, this.MyS);
      k.gvj();
      k.ct(196626, this.MyU);
      k.gvj();
      k.ct(196627, this.MyV);
      k.gvj();
      k.ct(196628, this.MyW);
      k.gvj();
      k.ct(196630, "1");
      k.gvj();
      k.ct(196632, System.currentTimeMillis() / 1000L);
      paramJSONObject = this.token;
      String str3 = this.MyX;
      String str4 = this.MyZ;
      String str5 = this.Mza;
      if (this.Mzc != 1) {
        break label570;
      }
      paramInt = 2;
      com.tencent.mm.plugin.offline.c.d.a(paramJSONObject, str3, str4, str5, paramInt);
      com.tencent.mm.plugin.offline.c.d.afi(this.MyY);
      k.gvj();
      k.ct(196647, this.Mzb);
      com.tencent.mm.plugin.offline.c.d.aQO(str2);
      k.gvj();
      paramJSONObject = k.afd(196617);
      com.tencent.mm.wallet_core.model.b.jOG();
      com.tencent.mm.wallet_core.model.b.clearToken(paramJSONObject);
      com.tencent.mm.wallet_core.model.b.jOG();
      paramJSONObject = this.MyS;
      if (j != 1) {
        break label575;
      }
      bool = true;
      label407:
      bool = com.tencent.mm.wallet_core.model.b.P(paramJSONObject, str1, bool);
      Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", new Object[] { Boolean.valueOf(bool), this.MyS });
      if (bool) {
        break label581;
      }
      Log.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
      paramJSONObject = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      com.tencent.mm.wallet_core.model.b.jOG();
      Log.e("MicroMsg.NetSceneTenpayWxOfflineCreate", com.tencent.mm.wallet_core.model.b.getLastError());
    }
    for (;;)
    {
      k.gvj();
      k.ct(196649, String.valueOf(i));
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acHA, q.eD(true));
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acHB, paramString);
      AppMethodBeat.o(66301);
      return;
      label559:
      Log.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt fail");
      break;
      label570:
      paramInt = 1;
      break label333;
      label575:
      bool = false;
      break label407;
      label581:
      Log.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens success!");
    }
  }
  
  public final void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66303);
    com.tencent.mm.wallet_core.model.b.jOG().jOH();
    AppMethodBeat.o(66303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.m
 * JD-Core Version:    0.7.0.1
 */