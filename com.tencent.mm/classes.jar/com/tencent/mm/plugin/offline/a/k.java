package com.tencent.mm.plugin.offline.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends m
{
  public static String plu = "3";
  public int plA;
  public String plp;
  public String plq;
  public String plr;
  public String pls;
  public String plt;
  public String plv;
  public int plw;
  public String plx;
  public String ply;
  public String plz;
  public String token;
  
  public k(Bankcard paramBankcard, String paramString, int paramInt)
  {
    AppMethodBeat.i(43401);
    this.plp = "";
    this.plq = "";
    this.token = "";
    this.plr = "";
    this.pls = "";
    this.plt = "";
    this.plv = "";
    this.plw = 0;
    this.plx = "";
    this.ply = "";
    this.plz = "";
    this.plA = 20000;
    String str = com.tencent.mm.compatible.e.q.LK();
    Object localObject = (String)l.Lm().get(256);
    if ((!bo.isNullOrNil((String)localObject)) && (((String)localObject).equals(str))) {
      h.qsU.cT(965, 48);
    }
    ab.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "old id: %s, new id: %s", new Object[] { localObject, str });
    localObject = new HashMap();
    ((Map)localObject).put("passwd", paramString);
    ((Map)localObject).put("device_id", str);
    ((Map)localObject).put("weixin_ver", "0x" + Integer.toHexString(com.tencent.mm.protocal.d.whH));
    ((Map)localObject).put("bind_serialno", paramBankcard.field_bindSerial);
    ((Map)localObject).put("bank_type", paramBankcard.field_bankcardType);
    ((Map)localObject).put("card_tail", paramBankcard.field_bankcardTail);
    ((Map)localObject).put("open_limitfee", String.valueOf(paramInt));
    this.plA = paramInt;
    paramBankcard = com.tencent.mm.wallet_core.ui.e.getUsername();
    paramBankcard = ag.cE(ag.cE(paramBankcard) + ag.cE(com.tencent.mm.compatible.e.q.LK()));
    ((Map)localObject).put("user_id", paramBankcard);
    paramString = com.tencent.mm.wallet_core.c.b.dSi();
    com.tencent.mm.wallet_core.b.dRI();
    if (com.tencent.mm.wallet_core.b.dRK()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramBankcard = paramString.eY(paramBankcard, paramInt);
      com.tencent.mm.wallet_core.b.dRI();
      ab.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "crt_csr %s %s", new Object[] { paramBankcard, Boolean.valueOf(com.tencent.mm.wallet_core.b.dRK()) });
      ((Map)localObject).put("crt_csr", paramBankcard);
      ((Map)localObject).put("type", plu);
      ((Map)localObject).put("version_number", plu);
      setRequestData((Map)localObject);
      AppMethodBeat.o(43401);
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
    AppMethodBeat.i(43403);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.offline.k.bYF();
      com.tencent.mm.plugin.offline.k.aT(196630, "0");
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
      h.qsU.b(paramString, true);
      AppMethodBeat.o(43403);
      return;
      paramArrayOfByte.SetKey(10);
    }
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(43402);
    boolean bool;
    if (paramJSONObject != null)
    {
      this.plq = paramJSONObject.optString("crt_crt");
      this.plp = paramJSONObject.optString("cn");
      this.token = paramJSONObject.optString("token");
      this.plr = paramJSONObject.optString("valid_end");
      this.pls = paramJSONObject.optString("encrypt_str");
      this.plt = paramJSONObject.optString("deviceid");
      if (!com.tencent.mm.wallet_core.c.b.dSi().importCert(this.plp, this.plq)) {
        break label531;
      }
      ab.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
      this.plv = paramJSONObject.optString("token_v2");
      this.plw = paramJSONObject.optInt("algorithm_type");
      this.plx = paramJSONObject.optString("card_list");
      this.ply = paramJSONObject.optString("key_list");
      this.plz = paramJSONObject.optString("token_pin");
      String str2 = paramJSONObject.optString("notice_url");
      String str1 = paramJSONObject.optString("auth_codes");
      paramInt = paramJSONObject.optInt("update_interval");
      paramString = paramJSONObject.optString("code_ver");
      int i = paramJSONObject.optInt("cipher_type", 0);
      com.tencent.mm.plugin.offline.k.bYF();
      com.tencent.mm.plugin.offline.k.aT(196617, this.plp);
      com.tencent.mm.plugin.offline.k.bYF();
      com.tencent.mm.plugin.offline.k.aT(196626, this.plr);
      com.tencent.mm.plugin.offline.k.bYF();
      com.tencent.mm.plugin.offline.k.aT(196627, this.pls);
      com.tencent.mm.plugin.offline.k.bYF();
      com.tencent.mm.plugin.offline.k.aT(196628, this.plt);
      com.tencent.mm.plugin.offline.k.bYF();
      com.tencent.mm.plugin.offline.k.aT(196630, "1");
      com.tencent.mm.plugin.offline.k.bYF();
      com.tencent.mm.plugin.offline.k.aT(196632, System.currentTimeMillis() / 1000L);
      a.r(this.token, this.plv, this.plx, this.ply);
      a.Be(this.plw);
      com.tencent.mm.plugin.offline.k.bYF();
      com.tencent.mm.plugin.offline.k.aT(196647, this.plz);
      a.Wu(str2);
      com.tencent.mm.plugin.offline.k.bYF();
      paramJSONObject = com.tencent.mm.plugin.offline.k.AY(196617);
      com.tencent.mm.wallet_core.c.b.dSi();
      com.tencent.mm.wallet_core.c.b.clearToken(paramJSONObject);
      com.tencent.mm.wallet_core.c.b.dSi();
      paramJSONObject = this.plp;
      if (i != 1) {
        break label542;
      }
      bool = true;
      label380:
      bool = com.tencent.mm.wallet_core.c.b.F(paramJSONObject, str1, bool);
      ab.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", new Object[] { Boolean.valueOf(bool), this.plp });
      if (bool) {
        break label548;
      }
      ab.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
      paramJSONObject = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      com.tencent.mm.wallet_core.c.b.dSi();
      ab.e("MicroMsg.NetSceneTenpayWxOfflineCreate", com.tencent.mm.wallet_core.c.b.getLastError());
    }
    for (;;)
    {
      com.tencent.mm.plugin.offline.k.bYF();
      com.tencent.mm.plugin.offline.k.aT(196649, String.valueOf(paramInt));
      g.RM();
      g.RL().Ru().set(ac.a.yxu, com.tencent.mm.compatible.e.q.bP(true));
      g.RM();
      g.RL().Ru().set(ac.a.yxv, paramString);
      AppMethodBeat.o(43402);
      return;
      label531:
      ab.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt fail");
      break;
      label542:
      bool = false;
      break label380;
      label548:
      ab.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens success!");
    }
  }
  
  public final void onGYNetEnd2(com.tencent.mm.wallet_core.c.d paramd, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(43404);
    com.tencent.mm.wallet_core.c.b.dSi().dSj();
    AppMethodBeat.o(43404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.k
 * JD-Core Version:    0.7.0.1
 */