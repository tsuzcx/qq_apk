package com.tencent.mm.plugin.offline.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends m
{
  public static String uka = "3";
  public String token;
  public String ujV;
  public String ujW;
  public String ujX;
  public String ujY;
  public String ujZ;
  public String ukb;
  public int ukc;
  public String ukd;
  public String uke;
  public String ukf;
  public int ukg;
  
  public k(Bankcard paramBankcard, String paramString, int paramInt)
  {
    AppMethodBeat.i(66300);
    this.ujV = "";
    this.ujW = "";
    this.token = "";
    this.ujX = "";
    this.ujY = "";
    this.ujZ = "";
    this.ukb = "";
    this.ukc = 0;
    this.ukd = "";
    this.uke = "";
    this.ukf = "";
    this.ukg = 20000;
    String str = com.tencent.mm.compatible.deviceinfo.q.Xa();
    Object localObject = (String)l.WE().get(256);
    if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).equals(str))) {
      h.vKh.dB(965, 48);
    }
    ad.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "old id: %s, new id: %s", new Object[] { localObject, str });
    localObject = new HashMap();
    ((Map)localObject).put("passwd", paramString);
    ((Map)localObject).put("device_id", str);
    ((Map)localObject).put("weixin_ver", "0x" + Integer.toHexString(d.CpK));
    ((Map)localObject).put("bind_serialno", paramBankcard.field_bindSerial);
    ((Map)localObject).put("bank_type", paramBankcard.field_bankcardType);
    ((Map)localObject).put("card_tail", paramBankcard.field_bankcardTail);
    ((Map)localObject).put("open_limitfee", String.valueOf(paramInt));
    this.ukg = paramInt;
    paramBankcard = com.tencent.mm.wallet_core.ui.e.getUsername();
    paramBankcard = ai.du(ai.du(paramBankcard) + ai.du(com.tencent.mm.compatible.deviceinfo.q.Xa()));
    ((Map)localObject).put("user_id", paramBankcard);
    paramString = com.tencent.mm.wallet_core.c.b.fjR();
    com.tencent.mm.wallet_core.b.fjk();
    if (com.tencent.mm.wallet_core.b.fjm()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramBankcard = paramString.gm(paramBankcard, paramInt);
      com.tencent.mm.wallet_core.b.fjk();
      ad.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "crt_csr %s %s", new Object[] { paramBankcard, Boolean.valueOf(com.tencent.mm.wallet_core.b.fjm()) });
      ((Map)localObject).put("crt_csr", paramBankcard);
      ((Map)localObject).put("type", uka);
      ((Map)localObject).put("version_number", uka);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66302);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.offline.k.cYr();
      com.tencent.mm.plugin.offline.k.bp(196630, "0");
    }
    paramString = new ArrayList();
    paramq = new IDKey();
    paramq.SetID(135);
    paramq.SetValue(1L);
    paramq.SetKey(11);
    paramArrayOfByte = new IDKey();
    paramArrayOfByte.SetID(135);
    paramArrayOfByte.SetValue(1L);
    if ((paramInt3 == 0) && (paramInt3 == 0)) {
      paramArrayOfByte.SetKey(9);
    }
    for (;;)
    {
      paramString.add(paramq);
      paramString.add(paramArrayOfByte);
      h.vKh.b(paramString, true);
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
      this.ujW = paramJSONObject.optString("crt_crt");
      this.ujV = paramJSONObject.optString("cn");
      this.token = paramJSONObject.optString("token");
      this.ujX = paramJSONObject.optString("valid_end");
      this.ujY = paramJSONObject.optString("encrypt_str");
      this.ujZ = paramJSONObject.optString("deviceid");
      if (!com.tencent.mm.wallet_core.c.b.fjR().importCert(this.ujV, this.ujW)) {
        break label531;
      }
      ad.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
      this.ukb = paramJSONObject.optString("token_v2");
      this.ukc = paramJSONObject.optInt("algorithm_type");
      this.ukd = paramJSONObject.optString("card_list");
      this.uke = paramJSONObject.optString("key_list");
      this.ukf = paramJSONObject.optString("token_pin");
      String str2 = paramJSONObject.optString("notice_url");
      String str1 = paramJSONObject.optString("auth_codes");
      paramInt = paramJSONObject.optInt("update_interval");
      paramString = paramJSONObject.optString("code_ver");
      int i = paramJSONObject.optInt("cipher_type", 0);
      com.tencent.mm.plugin.offline.k.cYr();
      com.tencent.mm.plugin.offline.k.bp(196617, this.ujV);
      com.tencent.mm.plugin.offline.k.cYr();
      com.tencent.mm.plugin.offline.k.bp(196626, this.ujX);
      com.tencent.mm.plugin.offline.k.cYr();
      com.tencent.mm.plugin.offline.k.bp(196627, this.ujY);
      com.tencent.mm.plugin.offline.k.cYr();
      com.tencent.mm.plugin.offline.k.bp(196628, this.ujZ);
      com.tencent.mm.plugin.offline.k.cYr();
      com.tencent.mm.plugin.offline.k.bp(196630, "1");
      com.tencent.mm.plugin.offline.k.cYr();
      com.tencent.mm.plugin.offline.k.bp(196632, System.currentTimeMillis() / 1000L);
      a.q(this.token, this.ukb, this.ukd, this.uke);
      a.IP(this.ukc);
      com.tencent.mm.plugin.offline.k.cYr();
      com.tencent.mm.plugin.offline.k.bp(196647, this.ukf);
      a.ajO(str2);
      com.tencent.mm.plugin.offline.k.cYr();
      paramJSONObject = com.tencent.mm.plugin.offline.k.IH(196617);
      com.tencent.mm.wallet_core.c.b.fjR();
      com.tencent.mm.wallet_core.c.b.clearToken(paramJSONObject);
      com.tencent.mm.wallet_core.c.b.fjR();
      paramJSONObject = this.ujV;
      if (i != 1) {
        break label542;
      }
      bool = true;
      label380:
      bool = com.tencent.mm.wallet_core.c.b.F(paramJSONObject, str1, bool);
      ad.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", new Object[] { Boolean.valueOf(bool), this.ujV });
      if (bool) {
        break label548;
      }
      ad.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
      paramJSONObject = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      com.tencent.mm.wallet_core.c.b.fjR();
      ad.e("MicroMsg.NetSceneTenpayWxOfflineCreate", com.tencent.mm.wallet_core.c.b.getLastError());
    }
    for (;;)
    {
      com.tencent.mm.plugin.offline.k.cYr();
      com.tencent.mm.plugin.offline.k.bp(196649, String.valueOf(paramInt));
      g.afC();
      g.afB().afk().set(ae.a.FfO, com.tencent.mm.compatible.deviceinfo.q.cG(true));
      g.afC();
      g.afB().afk().set(ae.a.FfP, paramString);
      AppMethodBeat.o(66301);
      return;
      label531:
      ad.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt fail");
      break;
      label542:
      bool = false;
      break label380;
      label548:
      ad.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens success!");
    }
  }
  
  public final void onGYNetEnd2(com.tencent.mm.wallet_core.c.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66303);
    com.tencent.mm.wallet_core.c.b.fjR().fjS();
    AppMethodBeat.o(66303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.k
 * JD-Core Version:    0.7.0.1
 */