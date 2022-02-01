package com.tencent.mm.plugin.offline.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends m
{
  public static String wNZ = "3";
  public String token;
  public String wNU;
  public String wNV;
  public String wNW;
  public String wNX;
  public String wNY;
  public String wOa;
  public int wOb;
  public String wOc;
  public String wOd;
  public String wOe;
  public int wOf;
  
  public k(Bankcard paramBankcard, String paramString, int paramInt)
  {
    AppMethodBeat.i(66300);
    this.wNU = "";
    this.wNV = "";
    this.token = "";
    this.wNW = "";
    this.wNX = "";
    this.wNY = "";
    this.wOa = "";
    this.wOb = 0;
    this.wOc = "";
    this.wOd = "";
    this.wOe = "";
    this.wOf = 20000;
    String str = com.tencent.mm.compatible.deviceinfo.q.aaH();
    Object localObject = (String)l.aam().get(256);
    if ((!bu.isNullOrNil((String)localObject)) && (((String)localObject).equals(str))) {
      com.tencent.mm.plugin.report.service.g.yxI.dD(965, 48);
    }
    ae.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "old id: %s, new id: %s", new Object[] { localObject, str });
    localObject = new HashMap();
    ((Map)localObject).put("passwd", paramString);
    ((Map)localObject).put("device_id", str);
    ((Map)localObject).put("weixin_ver", "0x" + Integer.toHexString(d.FFH));
    ((Map)localObject).put("bind_serialno", paramBankcard.field_bindSerial);
    ((Map)localObject).put("bank_type", paramBankcard.field_bankcardType);
    ((Map)localObject).put("card_tail", paramBankcard.field_bankcardTail);
    ((Map)localObject).put("open_limitfee", String.valueOf(paramInt));
    this.wOf = paramInt;
    paramBankcard = f.getUsername();
    paramBankcard = com.tencent.mm.sdk.platformtools.aj.ej(com.tencent.mm.sdk.platformtools.aj.ej(paramBankcard) + com.tencent.mm.sdk.platformtools.aj.ej(com.tencent.mm.compatible.deviceinfo.q.aaH()));
    ((Map)localObject).put("user_id", paramBankcard);
    paramString = com.tencent.mm.wallet_core.c.b.fVM();
    com.tencent.mm.wallet_core.b.fVf();
    if (com.tencent.mm.wallet_core.b.fVh()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramBankcard = paramString.gW(paramBankcard, paramInt);
      com.tencent.mm.wallet_core.b.fVf();
      ae.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "crt_csr %s %s", new Object[] { paramBankcard, Boolean.valueOf(com.tencent.mm.wallet_core.b.fVh()) });
      ((Map)localObject).put("crt_csr", paramBankcard);
      ((Map)localObject).put("type", wNZ);
      ((Map)localObject).put("version_number", wNZ);
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
      com.tencent.mm.plugin.offline.k.dzG();
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
      com.tencent.mm.plugin.report.service.g.yxI.b(paramString, true);
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
      this.wNV = paramJSONObject.optString("crt_crt");
      this.wNU = paramJSONObject.optString("cn");
      this.token = paramJSONObject.optString("token");
      this.wNW = paramJSONObject.optString("valid_end");
      this.wNX = paramJSONObject.optString("encrypt_str");
      this.wNY = paramJSONObject.optString("deviceid");
      if (!com.tencent.mm.wallet_core.c.b.fVM().importCert(this.wNU, this.wNV)) {
        break label531;
      }
      ae.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
      this.wOa = paramJSONObject.optString("token_v2");
      this.wOb = paramJSONObject.optInt("algorithm_type");
      this.wOc = paramJSONObject.optString("card_list");
      this.wOd = paramJSONObject.optString("key_list");
      this.wOe = paramJSONObject.optString("token_pin");
      String str2 = paramJSONObject.optString("notice_url");
      String str1 = paramJSONObject.optString("auth_codes");
      paramInt = paramJSONObject.optInt("update_interval");
      paramString = paramJSONObject.optString("code_ver");
      int i = paramJSONObject.optInt("cipher_type", 0);
      com.tencent.mm.plugin.offline.k.dzG();
      com.tencent.mm.plugin.offline.k.bz(196617, this.wNU);
      com.tencent.mm.plugin.offline.k.dzG();
      com.tencent.mm.plugin.offline.k.bz(196626, this.wNW);
      com.tencent.mm.plugin.offline.k.dzG();
      com.tencent.mm.plugin.offline.k.bz(196627, this.wNX);
      com.tencent.mm.plugin.offline.k.dzG();
      com.tencent.mm.plugin.offline.k.bz(196628, this.wNY);
      com.tencent.mm.plugin.offline.k.dzG();
      com.tencent.mm.plugin.offline.k.bz(196630, "1");
      com.tencent.mm.plugin.offline.k.dzG();
      com.tencent.mm.plugin.offline.k.bz(196632, System.currentTimeMillis() / 1000L);
      a.s(this.token, this.wOa, this.wOc, this.wOd);
      a.MV(this.wOb);
      com.tencent.mm.plugin.offline.k.dzG();
      com.tencent.mm.plugin.offline.k.bz(196647, this.wOe);
      a.avb(str2);
      com.tencent.mm.plugin.offline.k.dzG();
      paramJSONObject = com.tencent.mm.plugin.offline.k.MN(196617);
      com.tencent.mm.wallet_core.c.b.fVM();
      com.tencent.mm.wallet_core.c.b.clearToken(paramJSONObject);
      com.tencent.mm.wallet_core.c.b.fVM();
      paramJSONObject = this.wNU;
      if (i != 1) {
        break label542;
      }
      bool = true;
      label380:
      bool = com.tencent.mm.wallet_core.c.b.F(paramJSONObject, str1, bool);
      ae.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", new Object[] { Boolean.valueOf(bool), this.wNU });
      if (bool) {
        break label548;
      }
      ae.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
      paramJSONObject = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      com.tencent.mm.wallet_core.c.b.fVM();
      ae.e("MicroMsg.NetSceneTenpayWxOfflineCreate", com.tencent.mm.wallet_core.c.b.getLastError());
    }
    for (;;)
    {
      com.tencent.mm.plugin.offline.k.dzG();
      com.tencent.mm.plugin.offline.k.bz(196649, String.valueOf(paramInt));
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKp, com.tencent.mm.compatible.deviceinfo.q.cH(true));
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKq, paramString);
      AppMethodBeat.o(66301);
      return;
      label531:
      ae.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt fail");
      break;
      label542:
      bool = false;
      break label380;
      label548:
      ae.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens success!");
    }
  }
  
  public final void onGYNetEnd2(com.tencent.mm.wallet_core.c.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66303);
    com.tencent.mm.wallet_core.c.b.fVM().fVN();
    AppMethodBeat.o(66303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.k
 * JD-Core Version:    0.7.0.1
 */