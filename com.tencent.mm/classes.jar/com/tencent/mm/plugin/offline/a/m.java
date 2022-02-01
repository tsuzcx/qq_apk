package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.xweb.util.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends h
{
  String dpw;
  public String token;
  public String ujX;
  public String ujY;
  public String ujZ;
  public String ukb;
  public int ukc;
  public String ukd;
  public String uke;
  public String ukf;
  private String ukh;
  private int uki;
  public String ukj;
  public int ukk;
  int ukl;
  
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
    this.ujX = "";
    this.ujY = "";
    this.ujZ = "";
    this.ukb = "";
    this.ukc = 0;
    this.ukd = "";
    this.uke = "";
    this.ukf = "";
    this.ukk = 0;
    this.ukl = 0;
    this.dpw = d.getMessageDigest(System.currentTimeMillis().getBytes());
    ad.v("MicroMsg.NetSceneTenpayWxOfflineGetToken", "scene %s stack %s ", new Object[] { Integer.valueOf(paramInt1), bt.eGN().toString() });
    Object localObject2 = a.getToken();
    com.tencent.mm.plugin.offline.k.cYr();
    String str = com.tencent.mm.plugin.offline.k.IH(196628);
    Object localObject1 = str;
    if (TextUtils.isEmpty(str)) {
      localObject1 = q.Xa();
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramString = (String)localObject1 + "&" + paramString + "&" + ((int)(Math.random() * 1000000.0D) + 1000000);
      localObject1 = new HashMap();
      ((Map)localObject1).put("token_src", paramString);
      com.tencent.mm.plugin.offline.k.cYr();
      str = com.tencent.mm.plugin.offline.k.IH(196617);
      switch (paramInt2)
      {
      default: 
        paramInt2 = 12;
        label303:
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, paramInt2, 1L, true);
        localObject2 = new com.tencent.mm.g.b.a.b();
        ((com.tencent.mm.g.b.a.b)localObject2).fS(this.dpw);
        ((com.tencent.mm.g.b.a.b)localObject2).dFf = 1L;
        com.tencent.mm.wallet_core.c.b.fjR();
        if (com.tencent.mm.wallet_core.c.b.isCertExist(str))
        {
          ((com.tencent.mm.g.b.a.b)localObject2).dFg = 1;
          com.tencent.mm.wallet_core.c.b.fjR();
          ((com.tencent.mm.g.b.a.b)localObject2).dFh = com.tencent.mm.wallet_core.c.b.getLastError();
          ((com.tencent.mm.g.b.a.b)localObject2).aBj();
          localObject2 = new com.tencent.mm.g.b.a.b();
          ((com.tencent.mm.g.b.a.b)localObject2).fS(this.dpw);
          ((com.tencent.mm.g.b.a.b)localObject2).dFf = 3L;
          com.tencent.mm.wallet_core.c.b.fjR();
          paramString = com.tencent.mm.wallet_core.c.b.genUserSig(str, paramString);
          if (bt.isNullOrNil(paramString))
          {
            ((com.tencent.mm.g.b.a.b)localObject2).dFg = 0;
            com.tencent.mm.wallet_core.c.b.fjR();
            ((com.tencent.mm.g.b.a.b)localObject2).dFh = com.tencent.mm.wallet_core.c.b.getLastError();
            ((com.tencent.mm.g.b.a.b)localObject2).aBj();
            label448:
            ad.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
            if (!TextUtils.isEmpty(paramString)) {
              break label1012;
            }
            ad.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 4L, 1L, true);
            label483:
            ((Map)localObject1).put("sign", paramString);
            ((Map)localObject1).put("cert_no", str);
            ((Map)localObject1).put("type", k.uka);
            ((Map)localObject1).put("version_number", k.uka);
            if (a.cZw() != 2) {
              break label1023;
            }
            ((Map)localObject1).put("last_token", a.cZx());
            label554:
            ad.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "inOfflineUI: %B", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.k.ujs) });
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
      ((com.tencent.mm.g.b.a.b)localObject2).dFg = 1;
      com.tencent.mm.wallet_core.c.b.fjR();
      ((com.tencent.mm.g.b.a.b)localObject2).dFh = com.tencent.mm.wallet_core.c.b.getLastError();
      ((com.tencent.mm.g.b.a.b)localObject2).aBj();
      break label448;
      paramString = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
      com.tencent.mm.wallet_core.c.b.fjR();
      ad.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", com.tencent.mm.wallet_core.c.b.getLastError());
      ((com.tencent.mm.g.b.a.b)localObject2).dFg = 0;
      com.tencent.mm.wallet_core.c.b.fjR();
      ((com.tencent.mm.g.b.a.b)localObject2).dFh = com.tencent.mm.wallet_core.c.b.getLastError();
      ((com.tencent.mm.g.b.a.b)localObject2).aBj();
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 6L, 1L, true);
      paramString = new com.tencent.mm.g.b.a.b();
      paramString.fS(this.dpw);
      paramString.dFf = 2L;
      g.afC();
      localObject2 = (String)g.afB().afk().get(ae.a.FfO, "");
      if ((localObject2 != null) && (((String)localObject2).equals(q.cG(true))))
      {
        ad.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
        paramString.dFg = 1;
        com.tencent.mm.wallet_core.c.b.fjR();
        paramString.dFh = com.tencent.mm.wallet_core.c.b.getLastError();
      }
      for (;;)
      {
        paramString.aBj();
        ad.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: ".concat(String.valueOf(str)));
        paramString = "";
        break;
        paramString.dFg = 0;
        com.tencent.mm.wallet_core.c.b.fjR();
        paramString.dFh = com.tencent.mm.wallet_core.c.b.getLastError();
        ad.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 5L, 1L, true);
      }
      label1012:
      ad.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
      break label483;
      label1023:
      ((Map)localObject1).put("last_token", a.getToken());
      break label554;
      label1040:
      if (com.tencent.mm.plugin.offline.k.ujs) {
        ((Map)localObject1).put("fetch_tag", "1");
      } else {
        ((Map)localObject1).put("fetch_tag", "0");
      }
    }
  }
  
  public final boolean cYw()
  {
    AppMethodBeat.i(66309);
    ad.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
    com.tencent.mm.plugin.offline.k.cYr();
    com.tencent.mm.plugin.offline.k.bp(196626, this.ujX);
    com.tencent.mm.plugin.offline.k.cYr();
    com.tencent.mm.plugin.offline.k.bp(196627, this.ujY);
    com.tencent.mm.plugin.offline.k.cYr();
    com.tencent.mm.plugin.offline.k.bp(196628, this.ujZ);
    com.tencent.mm.plugin.offline.k.cYr();
    com.tencent.mm.plugin.offline.k.bp(196632, System.currentTimeMillis() / 1000L);
    a.q(this.token, this.ukb, this.ukd, this.uke);
    a.IP(this.ukc);
    com.tencent.mm.plugin.offline.k.cYr();
    com.tencent.mm.plugin.offline.k.bp(196647, this.ukf);
    com.tencent.mm.plugin.offline.k.cYr();
    Object localObject1 = com.tencent.mm.plugin.offline.k.IH(196617);
    com.tencent.mm.wallet_core.c.b.fjR();
    com.tencent.mm.wallet_core.c.b.clearToken((String)localObject1);
    com.tencent.mm.wallet_core.c.b.fjR();
    Object localObject2 = this.ukh;
    boolean bool;
    if (this.ukl == 1)
    {
      bool = true;
      bool = com.tencent.mm.wallet_core.c.b.F((String)localObject1, (String)localObject2, bool);
      localObject1 = new com.tencent.mm.g.b.a.b();
      ((com.tencent.mm.g.b.a.b)localObject1).fS(this.dpw);
      ((com.tencent.mm.g.b.a.b)localObject1).dFf = 3L;
      if (bool) {
        break label317;
      }
      ((com.tencent.mm.g.b.a.b)localObject1).dFg = 0;
      com.tencent.mm.wallet_core.c.b.fjR();
      ((com.tencent.mm.g.b.a.b)localObject1).dFh = com.tencent.mm.wallet_core.c.b.getLastError();
      ad.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
      localObject2 = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      com.tencent.mm.wallet_core.c.b.fjR();
      ad.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", com.tencent.mm.wallet_core.c.b.getLastError());
    }
    for (;;)
    {
      ((com.tencent.mm.g.b.a.b)localObject1).aBj();
      com.tencent.mm.plugin.offline.k.cYr();
      com.tencent.mm.plugin.offline.k.bp(196649, this.uki);
      g.afC();
      g.afB().afk().set(ae.a.FfP, this.ukj);
      AppMethodBeat.o(66309);
      return bool;
      bool = false;
      break;
      label317:
      ((com.tencent.mm.g.b.a.b)localObject1).dFg = 1;
      com.tencent.mm.wallet_core.c.b.fjR();
      ((com.tencent.mm.g.b.a.b)localObject1).dFh = com.tencent.mm.wallet_core.c.b.getLastError();
      ad.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
    }
  }
  
  public final int getFuncId()
  {
    if (com.tencent.mm.plugin.offline.k.ujs) {
      return 571;
    }
    return 1725;
  }
  
  public final int getTenpayCgicmd()
  {
    if (com.tencent.mm.plugin.offline.k.ujs) {
      return 52;
    }
    return 1725;
  }
  
  public final String getUri()
  {
    if (com.tencent.mm.plugin.offline.k.ujs) {
      return "/cgi-bin/mmpay-bin/tenpay/offlinegettoken";
    }
    return "/cgi-bin/mmpay-bin/tenpay/offlinegettokenbackground";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66308);
    ad.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      this.token = paramJSONObject.optString("token");
      this.ujX = paramJSONObject.optString("valid_end");
      this.ujY = paramJSONObject.optString("encrypt_str");
      this.ujZ = paramJSONObject.optString("deviceid");
      this.ukb = paramJSONObject.optString("token_v2");
      this.ukc = paramJSONObject.optInt("algorithm_type");
      this.ukd = paramJSONObject.optString("card_list");
      this.uke = paramJSONObject.optString("key_list");
      this.ukf = paramJSONObject.optString("token_pin");
      this.ukh = paramJSONObject.optString("auth_codes");
      this.uki = paramJSONObject.optInt("update_interval");
      this.ukj = paramJSONObject.optString("code_ver");
      this.ukk = paramJSONObject.optInt("reget_token_num", 0);
      this.ukl = paramJSONObject.optInt("cipher_type", 0);
      a.IR(this.ukk);
      ad.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "json: %s", new Object[] { paramJSONObject.toString() });
    }
    AppMethodBeat.o(66308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.m
 * JD-Core Version:    0.7.0.1
 */