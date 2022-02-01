package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.xweb.util.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends h
{
  String dnh;
  public String token;
  public String vsT;
  public String vsU;
  public String vsV;
  public String vsX;
  public int vsY;
  public String vsZ;
  public String vta;
  public String vtb;
  private String vtd;
  private int vte;
  public String vtf;
  public int vtg;
  int vth;
  
  public m(String paramString, int paramInt)
  {
    this(paramString, paramInt, paramInt);
    AppMethodBeat.i(66306);
    AppMethodBeat.o(66306);
  }
  
  public m(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66307);
    this.token = "";
    this.vsT = "";
    this.vsU = "";
    this.vsV = "";
    this.vsX = "";
    this.vsY = 0;
    this.vsZ = "";
    this.vta = "";
    this.vtb = "";
    this.vtg = 0;
    this.vth = 0;
    this.dnh = d.getMessageDigest(System.currentTimeMillis().getBytes());
    ac.v("MicroMsg.NetSceneTenpayWxOfflineGetToken", "scene %s stack %s ", new Object[] { Integer.valueOf(paramInt1), bs.eWi().toString() });
    Object localObject2 = a.getToken();
    com.tencent.mm.plugin.offline.k.dlZ();
    String str = com.tencent.mm.plugin.offline.k.KG(196628);
    Object localObject1 = str;
    if (TextUtils.isEmpty(str)) {
      localObject1 = q.XX();
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramString = (String)localObject1 + "&" + paramString + "&" + ((int)(Math.random() * 1000000.0D) + 1000000);
      localObject1 = new HashMap();
      ((Map)localObject1).put("token_src", paramString);
      com.tencent.mm.plugin.offline.k.dlZ();
      str = com.tencent.mm.plugin.offline.k.KG(196617);
      switch (paramInt2)
      {
      default: 
        paramInt2 = 12;
        label303:
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, paramInt2, 1L, true);
        localObject2 = new com.tencent.mm.g.b.a.b();
        ((com.tencent.mm.g.b.a.b)localObject2).fI(this.dnh);
        ((com.tencent.mm.g.b.a.b)localObject2).dCS = 1L;
        com.tencent.mm.wallet_core.c.b.fAg();
        if (com.tencent.mm.wallet_core.c.b.isCertExist(str))
        {
          ((com.tencent.mm.g.b.a.b)localObject2).dCT = 1;
          com.tencent.mm.wallet_core.c.b.fAg();
          ((com.tencent.mm.g.b.a.b)localObject2).dCU = com.tencent.mm.wallet_core.c.b.getLastError();
          ((com.tencent.mm.g.b.a.b)localObject2).aHZ();
          localObject2 = new com.tencent.mm.g.b.a.b();
          ((com.tencent.mm.g.b.a.b)localObject2).fI(this.dnh);
          ((com.tencent.mm.g.b.a.b)localObject2).dCS = 3L;
          com.tencent.mm.wallet_core.c.b.fAg();
          paramString = com.tencent.mm.wallet_core.c.b.genUserSig(str, paramString);
          if (bs.isNullOrNil(paramString))
          {
            ((com.tencent.mm.g.b.a.b)localObject2).dCT = 0;
            com.tencent.mm.wallet_core.c.b.fAg();
            ((com.tencent.mm.g.b.a.b)localObject2).dCU = com.tencent.mm.wallet_core.c.b.getLastError();
            ((com.tencent.mm.g.b.a.b)localObject2).aHZ();
            label448:
            ac.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
            if (!TextUtils.isEmpty(paramString)) {
              break label1012;
            }
            ac.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 4L, 1L, true);
            label483:
            ((Map)localObject1).put("sign", paramString);
            ((Map)localObject1).put("cert_no", str);
            ((Map)localObject1).put("type", k.vsW);
            ((Map)localObject1).put("version_number", k.vsW);
            if (a.dne() != 2) {
              break label1023;
            }
            ((Map)localObject1).put("last_token", a.dnf());
            label554:
            ac.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "inOfflineUI: %B", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.k.vso) });
            if (paramInt1 != 65281) {
              break label1040;
            }
            ((Map)localObject1).put("fetch_tag", "2");
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramInt2 = paramInt1;
      if (paramInt1 == 65281) {
        paramInt2 = 3;
      }
      ((Map)localObject1).put("scene", String.valueOf(paramInt2));
      setRequestData((Map)localObject1);
      AppMethodBeat.o(66307);
      return;
      paramString = (String)localObject1 + "&" + paramString + "&" + ((int)(Math.random() * 1000000.0D) + 1000000) + "&" + (String)localObject2;
      break;
      paramInt2 = 12;
      break label303;
      paramInt2 = 13;
      break label303;
      paramInt2 = 14;
      break label303;
      paramInt2 = 15;
      break label303;
      paramInt2 = 16;
      break label303;
      paramInt2 = 17;
      break label303;
      paramInt2 = 18;
      break label303;
      paramInt2 = 19;
      break label303;
      paramInt2 = 20;
      break label303;
      paramInt2 = 24;
      break label303;
      paramInt2 = 72;
      break label303;
      ((com.tencent.mm.g.b.a.b)localObject2).dCT = 1;
      com.tencent.mm.wallet_core.c.b.fAg();
      ((com.tencent.mm.g.b.a.b)localObject2).dCU = com.tencent.mm.wallet_core.c.b.getLastError();
      ((com.tencent.mm.g.b.a.b)localObject2).aHZ();
      break label448;
      paramString = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
      com.tencent.mm.wallet_core.c.b.fAg();
      ac.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", com.tencent.mm.wallet_core.c.b.getLastError());
      ((com.tencent.mm.g.b.a.b)localObject2).dCT = 0;
      com.tencent.mm.wallet_core.c.b.fAg();
      ((com.tencent.mm.g.b.a.b)localObject2).dCU = com.tencent.mm.wallet_core.c.b.getLastError();
      ((com.tencent.mm.g.b.a.b)localObject2).aHZ();
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 6L, 1L, true);
      paramString = new com.tencent.mm.g.b.a.b();
      paramString.fI(this.dnh);
      paramString.dCS = 2L;
      g.agS();
      localObject2 = (String)g.agR().agA().get(ah.a.GDC, "");
      if ((localObject2 != null) && (((String)localObject2).equals(q.cF(true))))
      {
        ac.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
        paramString.dCT = 1;
        com.tencent.mm.wallet_core.c.b.fAg();
        paramString.dCU = com.tencent.mm.wallet_core.c.b.getLastError();
      }
      for (;;)
      {
        paramString.aHZ();
        ac.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: ".concat(String.valueOf(str)));
        paramString = "";
        break;
        paramString.dCT = 0;
        com.tencent.mm.wallet_core.c.b.fAg();
        paramString.dCU = com.tencent.mm.wallet_core.c.b.getLastError();
        ac.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 5L, 1L, true);
      }
      label1012:
      ac.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
      break label483;
      label1023:
      ((Map)localObject1).put("last_token", a.getToken());
      break label554;
      label1040:
      if (com.tencent.mm.plugin.offline.k.vso) {
        ((Map)localObject1).put("fetch_tag", "1");
      } else {
        ((Map)localObject1).put("fetch_tag", "0");
      }
    }
  }
  
  public final boolean dme()
  {
    AppMethodBeat.i(66309);
    ac.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
    com.tencent.mm.plugin.offline.k.dlZ();
    com.tencent.mm.plugin.offline.k.bu(196626, this.vsT);
    com.tencent.mm.plugin.offline.k.dlZ();
    com.tencent.mm.plugin.offline.k.bu(196627, this.vsU);
    com.tencent.mm.plugin.offline.k.dlZ();
    com.tencent.mm.plugin.offline.k.bu(196628, this.vsV);
    com.tencent.mm.plugin.offline.k.dlZ();
    com.tencent.mm.plugin.offline.k.bu(196632, System.currentTimeMillis() / 1000L);
    a.s(this.token, this.vsX, this.vsZ, this.vta);
    a.KO(this.vsY);
    com.tencent.mm.plugin.offline.k.dlZ();
    com.tencent.mm.plugin.offline.k.bu(196647, this.vtb);
    com.tencent.mm.plugin.offline.k.dlZ();
    Object localObject1 = com.tencent.mm.plugin.offline.k.KG(196617);
    com.tencent.mm.wallet_core.c.b.fAg();
    com.tencent.mm.wallet_core.c.b.clearToken((String)localObject1);
    com.tencent.mm.wallet_core.c.b.fAg();
    Object localObject2 = this.vtd;
    boolean bool;
    if (this.vth == 1)
    {
      bool = true;
      bool = com.tencent.mm.wallet_core.c.b.F((String)localObject1, (String)localObject2, bool);
      localObject1 = new com.tencent.mm.g.b.a.b();
      ((com.tencent.mm.g.b.a.b)localObject1).fI(this.dnh);
      ((com.tencent.mm.g.b.a.b)localObject1).dCS = 3L;
      if (bool) {
        break label317;
      }
      ((com.tencent.mm.g.b.a.b)localObject1).dCT = 0;
      com.tencent.mm.wallet_core.c.b.fAg();
      ((com.tencent.mm.g.b.a.b)localObject1).dCU = com.tencent.mm.wallet_core.c.b.getLastError();
      ac.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
      localObject2 = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      com.tencent.mm.wallet_core.c.b.fAg();
      ac.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", com.tencent.mm.wallet_core.c.b.getLastError());
    }
    for (;;)
    {
      ((com.tencent.mm.g.b.a.b)localObject1).aHZ();
      com.tencent.mm.plugin.offline.k.dlZ();
      com.tencent.mm.plugin.offline.k.bu(196649, this.vte);
      g.agS();
      g.agR().agA().set(ah.a.GDD, this.vtf);
      AppMethodBeat.o(66309);
      return bool;
      bool = false;
      break;
      label317:
      ((com.tencent.mm.g.b.a.b)localObject1).dCT = 1;
      com.tencent.mm.wallet_core.c.b.fAg();
      ((com.tencent.mm.g.b.a.b)localObject1).dCU = com.tencent.mm.wallet_core.c.b.getLastError();
      ac.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
    }
  }
  
  public final int getFuncId()
  {
    if (com.tencent.mm.plugin.offline.k.vso) {
      return 571;
    }
    return 1725;
  }
  
  public final int getTenpayCgicmd()
  {
    if (com.tencent.mm.plugin.offline.k.vso) {
      return 52;
    }
    return 1725;
  }
  
  public final String getUri()
  {
    if (com.tencent.mm.plugin.offline.k.vso) {
      return "/cgi-bin/mmpay-bin/tenpay/offlinegettoken";
    }
    return "/cgi-bin/mmpay-bin/tenpay/offlinegettokenbackground";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66308);
    ac.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      this.token = paramJSONObject.optString("token");
      this.vsT = paramJSONObject.optString("valid_end");
      this.vsU = paramJSONObject.optString("encrypt_str");
      this.vsV = paramJSONObject.optString("deviceid");
      this.vsX = paramJSONObject.optString("token_v2");
      this.vsY = paramJSONObject.optInt("algorithm_type");
      this.vsZ = paramJSONObject.optString("card_list");
      this.vta = paramJSONObject.optString("key_list");
      this.vtb = paramJSONObject.optString("token_pin");
      this.vtd = paramJSONObject.optString("auth_codes");
      this.vte = paramJSONObject.optInt("update_interval");
      this.vtf = paramJSONObject.optString("code_ver");
      this.vtg = paramJSONObject.optInt("reget_token_num", 0);
      this.vth = paramJSONObject.optInt("cipher_type", 0);
      a.KQ(this.vtg);
      ac.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "json: %s", new Object[] { paramJSONObject.toString() });
    }
    AppMethodBeat.o(66308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.m
 * JD-Core Version:    0.7.0.1
 */