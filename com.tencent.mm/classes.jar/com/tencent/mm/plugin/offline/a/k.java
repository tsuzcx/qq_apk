package com.tencent.mm.plugin.offline.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends m
{
  public static String wyo = "3";
  public String token;
  public String wyj;
  public String wyk;
  public String wyl;
  public String wym;
  public String wyn;
  public String wyp;
  public int wyq;
  public String wyr;
  public String wys;
  public String wyt;
  public int wyu;
  
  public k(Bankcard paramBankcard, String paramString, int paramInt)
  {
    AppMethodBeat.i(66300);
    this.wyj = "";
    this.wyk = "";
    this.token = "";
    this.wyl = "";
    this.wym = "";
    this.wyn = "";
    this.wyp = "";
    this.wyq = 0;
    this.wyr = "";
    this.wys = "";
    this.wyt = "";
    this.wyu = 20000;
    String str = com.tencent.mm.compatible.deviceinfo.q.aay();
    Object localObject = (String)l.aad().get(256);
    if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).equals(str))) {
      com.tencent.mm.plugin.report.service.g.yhR.dD(965, 48);
    }
    ad.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "old id: %s, new id: %s", new Object[] { localObject, str });
    localObject = new HashMap();
    ((Map)localObject).put("passwd", paramString);
    ((Map)localObject).put("device_id", str);
    ((Map)localObject).put("weixin_ver", "0x" + Integer.toHexString(d.Fnj));
    ((Map)localObject).put("bind_serialno", paramBankcard.field_bindSerial);
    ((Map)localObject).put("bank_type", paramBankcard.field_bankcardType);
    ((Map)localObject).put("card_tail", paramBankcard.field_bankcardTail);
    ((Map)localObject).put("open_limitfee", String.valueOf(paramInt));
    this.wyu = paramInt;
    paramBankcard = com.tencent.mm.wallet_core.ui.e.getUsername();
    paramBankcard = com.tencent.mm.sdk.platformtools.ai.ee(com.tencent.mm.sdk.platformtools.ai.ee(paramBankcard) + com.tencent.mm.sdk.platformtools.ai.ee(com.tencent.mm.compatible.deviceinfo.q.aay()));
    ((Map)localObject).put("user_id", paramBankcard);
    paramString = com.tencent.mm.wallet_core.c.b.fRq();
    com.tencent.mm.wallet_core.b.fQJ();
    if (com.tencent.mm.wallet_core.b.fQL()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramBankcard = paramString.gN(paramBankcard, paramInt);
      com.tencent.mm.wallet_core.b.fQJ();
      ad.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "crt_csr %s %s", new Object[] { paramBankcard, Boolean.valueOf(com.tencent.mm.wallet_core.b.fQL()) });
      ((Map)localObject).put("crt_csr", paramBankcard);
      ((Map)localObject).put("type", wyo);
      ((Map)localObject).put("version_number", wyo);
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
      com.tencent.mm.plugin.offline.k.dwq();
      com.tencent.mm.plugin.offline.k.bz(196630, "0");
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
      com.tencent.mm.plugin.report.service.g.yhR.b(paramString, true);
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
      this.wyk = paramJSONObject.optString("crt_crt");
      this.wyj = paramJSONObject.optString("cn");
      this.token = paramJSONObject.optString("token");
      this.wyl = paramJSONObject.optString("valid_end");
      this.wym = paramJSONObject.optString("encrypt_str");
      this.wyn = paramJSONObject.optString("deviceid");
      if (!com.tencent.mm.wallet_core.c.b.fRq().importCert(this.wyj, this.wyk)) {
        break label531;
      }
      ad.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
      this.wyp = paramJSONObject.optString("token_v2");
      this.wyq = paramJSONObject.optInt("algorithm_type");
      this.wyr = paramJSONObject.optString("card_list");
      this.wys = paramJSONObject.optString("key_list");
      this.wyt = paramJSONObject.optString("token_pin");
      String str2 = paramJSONObject.optString("notice_url");
      String str1 = paramJSONObject.optString("auth_codes");
      paramInt = paramJSONObject.optInt("update_interval");
      paramString = paramJSONObject.optString("code_ver");
      int i = paramJSONObject.optInt("cipher_type", 0);
      com.tencent.mm.plugin.offline.k.dwq();
      com.tencent.mm.plugin.offline.k.bz(196617, this.wyj);
      com.tencent.mm.plugin.offline.k.dwq();
      com.tencent.mm.plugin.offline.k.bz(196626, this.wyl);
      com.tencent.mm.plugin.offline.k.dwq();
      com.tencent.mm.plugin.offline.k.bz(196627, this.wym);
      com.tencent.mm.plugin.offline.k.dwq();
      com.tencent.mm.plugin.offline.k.bz(196628, this.wyn);
      com.tencent.mm.plugin.offline.k.dwq();
      com.tencent.mm.plugin.offline.k.bz(196630, "1");
      com.tencent.mm.plugin.offline.k.dwq();
      com.tencent.mm.plugin.offline.k.bz(196632, System.currentTimeMillis() / 1000L);
      a.s(this.token, this.wyp, this.wyr, this.wys);
      a.Mq(this.wyq);
      com.tencent.mm.plugin.offline.k.dwq();
      com.tencent.mm.plugin.offline.k.bz(196647, this.wyt);
      a.atM(str2);
      com.tencent.mm.plugin.offline.k.dwq();
      paramJSONObject = com.tencent.mm.plugin.offline.k.Mi(196617);
      com.tencent.mm.wallet_core.c.b.fRq();
      com.tencent.mm.wallet_core.c.b.clearToken(paramJSONObject);
      com.tencent.mm.wallet_core.c.b.fRq();
      paramJSONObject = this.wyj;
      if (i != 1) {
        break label542;
      }
      bool = true;
      label380:
      bool = com.tencent.mm.wallet_core.c.b.F(paramJSONObject, str1, bool);
      ad.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", new Object[] { Boolean.valueOf(bool), this.wyj });
      if (bool) {
        break label548;
      }
      ad.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
      paramJSONObject = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      com.tencent.mm.wallet_core.c.b.fRq();
      ad.e("MicroMsg.NetSceneTenpayWxOfflineCreate", com.tencent.mm.wallet_core.c.b.getLastError());
    }
    for (;;)
    {
      com.tencent.mm.plugin.offline.k.dwq();
      com.tencent.mm.plugin.offline.k.bz(196649, String.valueOf(paramInt));
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IpV, com.tencent.mm.compatible.deviceinfo.q.cH(true));
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IpW, paramString);
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
    com.tencent.mm.wallet_core.c.b.fRq().fRr();
    AppMethodBeat.o(66303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.k
 * JD-Core Version:    0.7.0.1
 */