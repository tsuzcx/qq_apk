package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.b.a.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.xweb.util.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends h
{
  String dAa;
  public String token;
  public String wNW;
  public String wNX;
  public String wNY;
  public String wOa;
  public int wOb;
  public String wOc;
  public String wOd;
  public String wOe;
  private String wOg;
  private int wOh;
  public String wOi;
  public int wOj;
  int wOk;
  
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
    this.wNW = "";
    this.wNX = "";
    this.wNY = "";
    this.wOa = "";
    this.wOb = 0;
    this.wOc = "";
    this.wOd = "";
    this.wOe = "";
    this.wOj = 0;
    this.wOk = 0;
    this.dAa = d.getMessageDigest(System.currentTimeMillis().getBytes());
    ae.v("MicroMsg.NetSceneTenpayWxOfflineGetToken", "scene %s stack %s ", new Object[] { Integer.valueOf(paramInt1), bu.fpN().toString() });
    Object localObject2 = a.getToken();
    com.tencent.mm.plugin.offline.k.dzG();
    String str = com.tencent.mm.plugin.offline.k.MN(196628);
    Object localObject1 = str;
    if (TextUtils.isEmpty(str)) {
      localObject1 = q.aaH();
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramString = (String)localObject1 + "&" + paramString + "&" + ((int)(Math.random() * 1000000.0D) + 1000000);
      localObject1 = new HashMap();
      ((Map)localObject1).put("token_src", paramString);
      com.tencent.mm.plugin.offline.k.dzG();
      str = com.tencent.mm.plugin.offline.k.MN(196617);
      switch (paramInt2)
      {
      default: 
        paramInt2 = 12;
        label303:
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, paramInt2, 1L, true);
        localObject2 = new c();
        ((c)localObject2).gJ(this.dAa);
        ((c)localObject2).dQX = 1L;
        b.fVM();
        if (b.isCertExist(str))
        {
          ((c)localObject2).dQY = 1;
          b.fVM();
          ((c)localObject2).dQZ = b.getLastError();
          ((c)localObject2).aLH();
          localObject2 = new c();
          ((c)localObject2).gJ(this.dAa);
          ((c)localObject2).dQX = 3L;
          b.fVM();
          paramString = b.genUserSig(str, paramString);
          if (bu.isNullOrNil(paramString))
          {
            ((c)localObject2).dQY = 0;
            b.fVM();
            ((c)localObject2).dQZ = b.getLastError();
            ((c)localObject2).aLH();
            label448:
            ae.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
            if (!TextUtils.isEmpty(paramString)) {
              break label1012;
            }
            ae.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 4L, 1L, true);
            label483:
            ((Map)localObject1).put("sign", paramString);
            ((Map)localObject1).put("cert_no", str);
            ((Map)localObject1).put("type", k.wNZ);
            ((Map)localObject1).put("version_number", k.wNZ);
            if (a.dAM() != 2) {
              break label1023;
            }
            ((Map)localObject1).put("last_token", a.dAN());
            label554:
            ae.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "inOfflineUI: %B", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.k.wNr) });
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
      ((c)localObject2).dQY = 1;
      b.fVM();
      ((c)localObject2).dQZ = b.getLastError();
      ((c)localObject2).aLH();
      break label448;
      paramString = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
      b.fVM();
      ae.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", b.getLastError());
      ((c)localObject2).dQY = 0;
      b.fVM();
      ((c)localObject2).dQZ = b.getLastError();
      ((c)localObject2).aLH();
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 6L, 1L, true);
      paramString = new c();
      paramString.gJ(this.dAa);
      paramString.dQX = 2L;
      com.tencent.mm.kernel.g.ajS();
      localObject2 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IKp, "");
      if ((localObject2 != null) && (((String)localObject2).equals(q.cH(true))))
      {
        ae.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
        paramString.dQY = 1;
        b.fVM();
        paramString.dQZ = b.getLastError();
      }
      for (;;)
      {
        paramString.aLH();
        ae.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: ".concat(String.valueOf(str)));
        paramString = "";
        break;
        paramString.dQY = 0;
        b.fVM();
        paramString.dQZ = b.getLastError();
        ae.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 5L, 1L, true);
      }
      label1012:
      ae.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
      break label483;
      label1023:
      ((Map)localObject1).put("last_token", a.getToken());
      break label554;
      label1040:
      if (com.tencent.mm.plugin.offline.k.wNr) {
        ((Map)localObject1).put("fetch_tag", "1");
      } else {
        ((Map)localObject1).put("fetch_tag", "0");
      }
    }
  }
  
  public final boolean dzL()
  {
    AppMethodBeat.i(66309);
    ae.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
    com.tencent.mm.plugin.offline.k.dzG();
    com.tencent.mm.plugin.offline.k.bz(196626, this.wNW);
    com.tencent.mm.plugin.offline.k.dzG();
    com.tencent.mm.plugin.offline.k.bz(196627, this.wNX);
    com.tencent.mm.plugin.offline.k.dzG();
    com.tencent.mm.plugin.offline.k.bz(196628, this.wNY);
    com.tencent.mm.plugin.offline.k.dzG();
    com.tencent.mm.plugin.offline.k.bz(196632, System.currentTimeMillis() / 1000L);
    a.s(this.token, this.wOa, this.wOc, this.wOd);
    a.MV(this.wOb);
    com.tencent.mm.plugin.offline.k.dzG();
    com.tencent.mm.plugin.offline.k.bz(196647, this.wOe);
    com.tencent.mm.plugin.offline.k.dzG();
    Object localObject1 = com.tencent.mm.plugin.offline.k.MN(196617);
    b.fVM();
    b.clearToken((String)localObject1);
    b.fVM();
    Object localObject2 = this.wOg;
    boolean bool;
    if (this.wOk == 1)
    {
      bool = true;
      bool = b.F((String)localObject1, (String)localObject2, bool);
      localObject1 = new c();
      ((c)localObject1).gJ(this.dAa);
      ((c)localObject1).dQX = 3L;
      if (bool) {
        break label317;
      }
      ((c)localObject1).dQY = 0;
      b.fVM();
      ((c)localObject1).dQZ = b.getLastError();
      ae.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
      localObject2 = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      b.fVM();
      ae.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", b.getLastError());
    }
    for (;;)
    {
      ((c)localObject1).aLH();
      com.tencent.mm.plugin.offline.k.dzG();
      com.tencent.mm.plugin.offline.k.bz(196649, this.wOh);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKq, this.wOi);
      AppMethodBeat.o(66309);
      return bool;
      bool = false;
      break;
      label317:
      ((c)localObject1).dQY = 1;
      b.fVM();
      ((c)localObject1).dQZ = b.getLastError();
      ae.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
    }
  }
  
  public final int getFuncId()
  {
    if (com.tencent.mm.plugin.offline.k.wNr) {
      return 571;
    }
    return 1725;
  }
  
  public final int getTenpayCgicmd()
  {
    if (com.tencent.mm.plugin.offline.k.wNr) {
      return 52;
    }
    return 1725;
  }
  
  public final String getUri()
  {
    if (com.tencent.mm.plugin.offline.k.wNr) {
      return "/cgi-bin/mmpay-bin/tenpay/offlinegettoken";
    }
    return "/cgi-bin/mmpay-bin/tenpay/offlinegettokenbackground";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66308);
    ae.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      this.token = paramJSONObject.optString("token");
      this.wNW = paramJSONObject.optString("valid_end");
      this.wNX = paramJSONObject.optString("encrypt_str");
      this.wNY = paramJSONObject.optString("deviceid");
      this.wOa = paramJSONObject.optString("token_v2");
      this.wOb = paramJSONObject.optInt("algorithm_type");
      this.wOc = paramJSONObject.optString("card_list");
      this.wOd = paramJSONObject.optString("key_list");
      this.wOe = paramJSONObject.optString("token_pin");
      this.wOg = paramJSONObject.optString("auth_codes");
      this.wOh = paramJSONObject.optInt("update_interval");
      this.wOi = paramJSONObject.optString("code_ver");
      this.wOj = paramJSONObject.optInt("reget_token_num", 0);
      this.wOk = paramJSONObject.optInt("cipher_type", 0);
      a.MX(this.wOj);
      ae.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "json: %s", new Object[] { paramJSONObject.toString() });
    }
    AppMethodBeat.o(66308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.m
 * JD-Core Version:    0.7.0.1
 */