package com.tencent.mm.plugin.offline.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends m
{
  public static String vsW = "3";
  public String token;
  public String vsR;
  public String vsS;
  public String vsT;
  public String vsU;
  public String vsV;
  public String vsX;
  public int vsY;
  public String vsZ;
  public String vta;
  public String vtb;
  public int vtc;
  
  public k(Bankcard paramBankcard, String paramString, int paramInt)
  {
    AppMethodBeat.i(66300);
    this.vsR = "";
    this.vsS = "";
    this.token = "";
    this.vsT = "";
    this.vsU = "";
    this.vsV = "";
    this.vsX = "";
    this.vsY = 0;
    this.vsZ = "";
    this.vta = "";
    this.vtb = "";
    this.vtc = 20000;
    String str = com.tencent.mm.compatible.deviceinfo.q.XX();
    Object localObject = (String)l.XC().get(256);
    if ((!bs.isNullOrNil((String)localObject)) && (((String)localObject).equals(str))) {
      h.wUl.dB(965, 48);
    }
    ac.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "old id: %s, new id: %s", new Object[] { localObject, str });
    localObject = new HashMap();
    ((Map)localObject).put("passwd", paramString);
    ((Map)localObject).put("device_id", str);
    ((Map)localObject).put("weixin_ver", "0x" + Integer.toHexString(d.DIc));
    ((Map)localObject).put("bind_serialno", paramBankcard.field_bindSerial);
    ((Map)localObject).put("bank_type", paramBankcard.field_bankcardType);
    ((Map)localObject).put("card_tail", paramBankcard.field_bankcardTail);
    ((Map)localObject).put("open_limitfee", String.valueOf(paramInt));
    this.vtc = paramInt;
    paramBankcard = com.tencent.mm.wallet_core.ui.e.getUsername();
    paramBankcard = ah.dg(ah.dg(paramBankcard) + ah.dg(com.tencent.mm.compatible.deviceinfo.q.XX()));
    ((Map)localObject).put("user_id", paramBankcard);
    paramString = com.tencent.mm.wallet_core.c.b.fAg();
    com.tencent.mm.wallet_core.b.fzz();
    if (com.tencent.mm.wallet_core.b.fzB()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramBankcard = paramString.gq(paramBankcard, paramInt);
      com.tencent.mm.wallet_core.b.fzz();
      ac.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "crt_csr %s %s", new Object[] { paramBankcard, Boolean.valueOf(com.tencent.mm.wallet_core.b.fzB()) });
      ((Map)localObject).put("crt_csr", paramBankcard);
      ((Map)localObject).put("type", vsW);
      ((Map)localObject).put("version_number", vsW);
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
      com.tencent.mm.plugin.offline.k.dlZ();
      com.tencent.mm.plugin.offline.k.bu(196630, "0");
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
      h.wUl.b(paramString, true);
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
      this.vsS = paramJSONObject.optString("crt_crt");
      this.vsR = paramJSONObject.optString("cn");
      this.token = paramJSONObject.optString("token");
      this.vsT = paramJSONObject.optString("valid_end");
      this.vsU = paramJSONObject.optString("encrypt_str");
      this.vsV = paramJSONObject.optString("deviceid");
      if (!com.tencent.mm.wallet_core.c.b.fAg().importCert(this.vsR, this.vsS)) {
        break label531;
      }
      ac.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
      this.vsX = paramJSONObject.optString("token_v2");
      this.vsY = paramJSONObject.optInt("algorithm_type");
      this.vsZ = paramJSONObject.optString("card_list");
      this.vta = paramJSONObject.optString("key_list");
      this.vtb = paramJSONObject.optString("token_pin");
      String str2 = paramJSONObject.optString("notice_url");
      String str1 = paramJSONObject.optString("auth_codes");
      paramInt = paramJSONObject.optInt("update_interval");
      paramString = paramJSONObject.optString("code_ver");
      int i = paramJSONObject.optInt("cipher_type", 0);
      com.tencent.mm.plugin.offline.k.dlZ();
      com.tencent.mm.plugin.offline.k.bu(196617, this.vsR);
      com.tencent.mm.plugin.offline.k.dlZ();
      com.tencent.mm.plugin.offline.k.bu(196626, this.vsT);
      com.tencent.mm.plugin.offline.k.dlZ();
      com.tencent.mm.plugin.offline.k.bu(196627, this.vsU);
      com.tencent.mm.plugin.offline.k.dlZ();
      com.tencent.mm.plugin.offline.k.bu(196628, this.vsV);
      com.tencent.mm.plugin.offline.k.dlZ();
      com.tencent.mm.plugin.offline.k.bu(196630, "1");
      com.tencent.mm.plugin.offline.k.dlZ();
      com.tencent.mm.plugin.offline.k.bu(196632, System.currentTimeMillis() / 1000L);
      a.s(this.token, this.vsX, this.vsZ, this.vta);
      a.KO(this.vsY);
      com.tencent.mm.plugin.offline.k.dlZ();
      com.tencent.mm.plugin.offline.k.bu(196647, this.vtb);
      a.aoM(str2);
      com.tencent.mm.plugin.offline.k.dlZ();
      paramJSONObject = com.tencent.mm.plugin.offline.k.KG(196617);
      com.tencent.mm.wallet_core.c.b.fAg();
      com.tencent.mm.wallet_core.c.b.clearToken(paramJSONObject);
      com.tencent.mm.wallet_core.c.b.fAg();
      paramJSONObject = this.vsR;
      if (i != 1) {
        break label542;
      }
      bool = true;
      label380:
      bool = com.tencent.mm.wallet_core.c.b.F(paramJSONObject, str1, bool);
      ac.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", new Object[] { Boolean.valueOf(bool), this.vsR });
      if (bool) {
        break label548;
      }
      ac.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
      paramJSONObject = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      com.tencent.mm.wallet_core.c.b.fAg();
      ac.e("MicroMsg.NetSceneTenpayWxOfflineCreate", com.tencent.mm.wallet_core.c.b.getLastError());
    }
    for (;;)
    {
      com.tencent.mm.plugin.offline.k.dlZ();
      com.tencent.mm.plugin.offline.k.bu(196649, String.valueOf(paramInt));
      g.agS();
      g.agR().agA().set(ah.a.GDC, com.tencent.mm.compatible.deviceinfo.q.cF(true));
      g.agS();
      g.agR().agA().set(ah.a.GDD, paramString);
      AppMethodBeat.o(66301);
      return;
      label531:
      ac.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt fail");
      break;
      label542:
      bool = false;
      break label380;
      label548:
      ac.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens success!");
    }
  }
  
  public final void onGYNetEnd2(com.tencent.mm.wallet_core.c.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66303);
    com.tencent.mm.wallet_core.c.b.fAg().fAh();
    AppMethodBeat.o(66303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.k
 * JD-Core Version:    0.7.0.1
 */