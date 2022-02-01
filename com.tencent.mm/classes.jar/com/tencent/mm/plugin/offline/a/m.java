package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.b.a.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.xweb.util.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends h
{
  public String AJC;
  public String AJD;
  public String AJE;
  public String AJG;
  public int AJH;
  public String AJI;
  public String AJJ;
  public String AJK;
  private String AJM;
  private int AJN;
  public String AJO;
  public int AJP;
  int AJQ;
  String dRM;
  public String token;
  
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
    this.AJC = "";
    this.AJD = "";
    this.AJE = "";
    this.AJG = "";
    this.AJH = 0;
    this.AJI = "";
    this.AJJ = "";
    this.AJK = "";
    this.AJP = 0;
    this.AJQ = 0;
    this.dRM = d.getMessageDigest(System.currentTimeMillis().getBytes());
    Log.v("MicroMsg.NetSceneTenpayWxOfflineGetToken", "scene %s stack %s ", new Object[] { Integer.valueOf(paramInt1), Util.getStack().toString() });
    Object localObject2 = a.getToken();
    com.tencent.mm.plugin.offline.k.ezn();
    String str = com.tencent.mm.plugin.offline.k.TX(196628);
    Object localObject1 = str;
    if (TextUtils.isEmpty(str)) {
      localObject1 = q.aoG();
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramString = (String)localObject1 + "&" + paramString + "&" + ((int)(Math.random() * 1000000.0D) + 1000000);
      localObject1 = new HashMap();
      ((Map)localObject1).put("token_src", paramString);
      com.tencent.mm.plugin.offline.k.ezn();
      str = com.tencent.mm.plugin.offline.k.TX(196617);
      switch (paramInt2)
      {
      default: 
        paramInt2 = 12;
        label303:
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, paramInt2, 1L, true);
        localObject2 = new i();
        ((i)localObject2).hM(this.dRM);
        ((i)localObject2).ejW = 1L;
        b.hhj();
        if (b.isCertExist(str))
        {
          ((i)localObject2).ejX = 1;
          b.hhj();
          ((i)localObject2).ejY = b.getLastError();
          ((i)localObject2).bfK();
          localObject2 = new i();
          ((i)localObject2).hM(this.dRM);
          ((i)localObject2).ejW = 3L;
          b.hhj();
          paramString = b.genUserSig(str, paramString);
          if (Util.isNullOrNil(paramString))
          {
            ((i)localObject2).ejX = 0;
            b.hhj();
            ((i)localObject2).ejY = b.getLastError();
            ((i)localObject2).bfK();
            label448:
            Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
            if (!TextUtils.isEmpty(paramString)) {
              break label1012;
            }
            Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 4L, 1L, true);
            label483:
            ((Map)localObject1).put("sign", paramString);
            ((Map)localObject1).put("cert_no", str);
            ((Map)localObject1).put("type", k.AJF);
            ((Map)localObject1).put("version_number", k.AJF);
            if (a.eAy() != 2) {
              break label1023;
            }
            ((Map)localObject1).put("last_token", a.eAz());
            label554:
            Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "inOfflineUI: %B", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.k.AIX) });
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
      ((i)localObject2).ejX = 1;
      b.hhj();
      ((i)localObject2).ejY = b.getLastError();
      ((i)localObject2).bfK();
      break label448;
      paramString = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
      b.hhj();
      Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", b.getLastError());
      ((i)localObject2).ejX = 0;
      b.hhj();
      ((i)localObject2).ejY = b.getLastError();
      ((i)localObject2).bfK();
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 6L, 1L, true);
      paramString = new i();
      paramString.hM(this.dRM);
      paramString.ejW = 2L;
      g.aAi();
      localObject2 = (String)g.aAh().azQ().get(ar.a.NSn, "");
      if ((localObject2 != null) && (((String)localObject2).equals(q.dr(true))))
      {
        Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
        paramString.ejX = 1;
        b.hhj();
        paramString.ejY = b.getLastError();
      }
      for (;;)
      {
        paramString.bfK();
        Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: ".concat(String.valueOf(str)));
        paramString = "";
        break;
        paramString.ejX = 0;
        b.hhj();
        paramString.ejY = b.getLastError();
        Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 5L, 1L, true);
      }
      label1012:
      Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
      break label483;
      label1023:
      ((Map)localObject1).put("last_token", a.getToken());
      break label554;
      label1040:
      if (com.tencent.mm.plugin.offline.k.AIX) {
        ((Map)localObject1).put("fetch_tag", "1");
      } else {
        ((Map)localObject1).put("fetch_tag", "0");
      }
    }
  }
  
  public final boolean ezs()
  {
    AppMethodBeat.i(66309);
    Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
    com.tencent.mm.plugin.offline.k.ezn();
    com.tencent.mm.plugin.offline.k.bN(196626, this.AJC);
    com.tencent.mm.plugin.offline.k.ezn();
    com.tencent.mm.plugin.offline.k.bN(196627, this.AJD);
    com.tencent.mm.plugin.offline.k.ezn();
    com.tencent.mm.plugin.offline.k.bN(196628, this.AJE);
    com.tencent.mm.plugin.offline.k.ezn();
    com.tencent.mm.plugin.offline.k.bN(196632, System.currentTimeMillis() / 1000L);
    a.w(this.token, this.AJG, this.AJI, this.AJJ);
    a.Uf(this.AJH);
    com.tencent.mm.plugin.offline.k.ezn();
    com.tencent.mm.plugin.offline.k.bN(196647, this.AJK);
    com.tencent.mm.plugin.offline.k.ezn();
    Object localObject1 = com.tencent.mm.plugin.offline.k.TX(196617);
    b.hhj();
    b.clearToken((String)localObject1);
    b.hhj();
    Object localObject2 = this.AJM;
    boolean bool;
    if (this.AJQ == 1)
    {
      bool = true;
      bool = b.F((String)localObject1, (String)localObject2, bool);
      localObject1 = new i();
      ((i)localObject1).hM(this.dRM);
      ((i)localObject1).ejW = 3L;
      if (bool) {
        break label317;
      }
      ((i)localObject1).ejX = 0;
      b.hhj();
      ((i)localObject1).ejY = b.getLastError();
      Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
      localObject2 = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      b.hhj();
      Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", b.getLastError());
    }
    for (;;)
    {
      ((i)localObject1).bfK();
      com.tencent.mm.plugin.offline.k.ezn();
      com.tencent.mm.plugin.offline.k.bN(196649, this.AJN);
      g.aAi();
      g.aAh().azQ().set(ar.a.NSo, this.AJO);
      AppMethodBeat.o(66309);
      return bool;
      bool = false;
      break;
      label317:
      ((i)localObject1).ejX = 1;
      b.hhj();
      ((i)localObject1).ejY = b.getLastError();
      Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
    }
  }
  
  public final int getFuncId()
  {
    if (com.tencent.mm.plugin.offline.k.AIX) {
      return 571;
    }
    return 1725;
  }
  
  public final int getTenpayCgicmd()
  {
    if (com.tencent.mm.plugin.offline.k.AIX) {
      return 52;
    }
    return 1725;
  }
  
  public final String getUri()
  {
    if (com.tencent.mm.plugin.offline.k.AIX) {
      return "/cgi-bin/mmpay-bin/tenpay/offlinegettoken";
    }
    return "/cgi-bin/mmpay-bin/tenpay/offlinegettokenbackground";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66308);
    Log.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      this.token = paramJSONObject.optString("token");
      this.AJC = paramJSONObject.optString("valid_end");
      this.AJD = paramJSONObject.optString("encrypt_str");
      this.AJE = paramJSONObject.optString("deviceid");
      this.AJG = paramJSONObject.optString("token_v2");
      this.AJH = paramJSONObject.optInt("algorithm_type");
      this.AJI = paramJSONObject.optString("card_list");
      this.AJJ = paramJSONObject.optString("key_list");
      this.AJK = paramJSONObject.optString("token_pin");
      this.AJM = paramJSONObject.optString("auth_codes");
      this.AJN = paramJSONObject.optInt("update_interval");
      this.AJO = paramJSONObject.optString("code_ver");
      this.AJP = paramJSONObject.optInt("reget_token_num", 0);
      this.AJQ = paramJSONObject.optInt("cipher_type", 0);
      a.Uh(this.AJP);
      Log.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "json: %s", new Object[] { paramJSONObject.toString() });
    }
    AppMethodBeat.o(66308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.m
 * JD-Core Version:    0.7.0.1
 */