package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.f.b.a.l;
import com.tencent.mm.kernel.f;
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
  public String GCJ;
  public String GCK;
  public String GCL;
  public String GCO;
  public int GCP;
  public String GCQ;
  public String GCR;
  public String GCS;
  private String GCU;
  private int GCV;
  public String GCW;
  public int GCX;
  int GCY;
  String fLj;
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
    this.GCJ = "";
    this.GCK = "";
    this.GCL = "";
    this.GCO = "";
    this.GCP = 0;
    this.GCQ = "";
    this.GCR = "";
    this.GCS = "";
    this.GCX = 0;
    this.GCY = 0;
    this.fLj = d.getMessageDigest(System.currentTimeMillis().getBytes());
    Log.v("MicroMsg.NetSceneTenpayWxOfflineGetToken", "scene %s stack %s ", new Object[] { Integer.valueOf(paramInt1), Util.getStack().toString() });
    Object localObject2 = a.getToken();
    com.tencent.mm.plugin.offline.k.fkT();
    String str = com.tencent.mm.plugin.offline.k.aaK(196628);
    Object localObject1 = str;
    if (TextUtils.isEmpty(str)) {
      localObject1 = q.auM();
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramString = (String)localObject1 + "&" + paramString + "&" + ((int)(Math.random() * 1000000.0D) + 1000000);
      localObject1 = new HashMap();
      ((Map)localObject1).put("token_src", paramString);
      com.tencent.mm.plugin.offline.k.fkT();
      str = com.tencent.mm.plugin.offline.k.aaK(196617);
      switch (paramInt2)
      {
      default: 
        paramInt2 = 12;
        label303:
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, paramInt2, 1L, true);
        localObject2 = new l();
        ((l)localObject2).iE(this.fLj);
        ((l)localObject2).geB = 1L;
        b.iiL();
        if (b.isCertExist(str))
        {
          ((l)localObject2).geC = 1;
          b.iiL();
          ((l)localObject2).geD = b.getLastError();
          ((l)localObject2).bpa();
          localObject2 = new l();
          ((l)localObject2).iE(this.fLj);
          ((l)localObject2).geB = 3L;
          b.iiL();
          paramString = b.genUserSig(str, paramString);
          if (Util.isNullOrNil(paramString))
          {
            ((l)localObject2).geC = 0;
            b.iiL();
            ((l)localObject2).geD = b.getLastError();
            ((l)localObject2).bpa();
            label448:
            Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
            if (!TextUtils.isEmpty(paramString)) {
              break label1012;
            }
            Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 4L, 1L, true);
            label483:
            ((Map)localObject1).put("sign", paramString);
            ((Map)localObject1).put("cert_no", str);
            ((Map)localObject1).put("type", k.GCN);
            ((Map)localObject1).put("version_number", k.GCN);
            if (a.fmc() != 2) {
              break label1023;
            }
            ((Map)localObject1).put("last_token", a.fmd());
            label554:
            Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "inOfflineUI: %B", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.k.GCg) });
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
      ((l)localObject2).geC = 1;
      b.iiL();
      ((l)localObject2).geD = b.getLastError();
      ((l)localObject2).bpa();
      break label448;
      paramString = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
      b.iiL();
      Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", b.getLastError());
      ((l)localObject2).geC = 0;
      b.iiL();
      ((l)localObject2).geD = b.getLastError();
      ((l)localObject2).bpa();
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 6L, 1L, true);
      paramString = new l();
      paramString.iE(this.fLj);
      paramString.geB = 2L;
      com.tencent.mm.kernel.h.aHH();
      localObject2 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vgl, "");
      if ((localObject2 != null) && (((String)localObject2).equals(q.dR(true))))
      {
        Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
        paramString.geC = 1;
        b.iiL();
        paramString.geD = b.getLastError();
      }
      for (;;)
      {
        paramString.bpa();
        Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: ".concat(String.valueOf(str)));
        paramString = "";
        break;
        paramString.geC = 0;
        b.iiL();
        paramString.geD = b.getLastError();
        Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 5L, 1L, true);
      }
      label1012:
      Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
      break label483;
      label1023:
      ((Map)localObject1).put("last_token", a.getToken());
      break label554;
      label1040:
      if (com.tencent.mm.plugin.offline.k.GCg) {
        ((Map)localObject1).put("fetch_tag", "1");
      } else {
        ((Map)localObject1).put("fetch_tag", "0");
      }
    }
  }
  
  public final boolean fkY()
  {
    AppMethodBeat.i(66309);
    Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
    com.tencent.mm.plugin.offline.k.fkT();
    com.tencent.mm.plugin.offline.k.bL(196626, this.GCJ);
    com.tencent.mm.plugin.offline.k.fkT();
    com.tencent.mm.plugin.offline.k.bL(196627, this.GCK);
    com.tencent.mm.plugin.offline.k.fkT();
    com.tencent.mm.plugin.offline.k.bL(196628, this.GCL);
    com.tencent.mm.plugin.offline.k.fkT();
    com.tencent.mm.plugin.offline.k.bL(196632, System.currentTimeMillis() / 1000L);
    a.B(this.token, this.GCO, this.GCQ, this.GCR);
    a.aaQ(this.GCP);
    com.tencent.mm.plugin.offline.k.fkT();
    com.tencent.mm.plugin.offline.k.bL(196647, this.GCS);
    com.tencent.mm.plugin.offline.k.fkT();
    Object localObject1 = com.tencent.mm.plugin.offline.k.aaK(196617);
    b.iiL();
    b.clearToken((String)localObject1);
    b.iiL();
    Object localObject2 = this.GCU;
    boolean bool;
    if (this.GCY == 1)
    {
      bool = true;
      bool = b.I((String)localObject1, (String)localObject2, bool);
      localObject1 = new l();
      ((l)localObject1).iE(this.fLj);
      ((l)localObject1).geB = 3L;
      if (bool) {
        break label317;
      }
      ((l)localObject1).geC = 0;
      b.iiL();
      ((l)localObject1).geD = b.getLastError();
      Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
      localObject2 = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      b.iiL();
      Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", b.getLastError());
    }
    for (;;)
    {
      ((l)localObject1).bpa();
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.bL(196649, this.GCV);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vgm, this.GCW);
      AppMethodBeat.o(66309);
      return bool;
      bool = false;
      break;
      label317:
      ((l)localObject1).geC = 1;
      b.iiL();
      ((l)localObject1).geD = b.getLastError();
      Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
    }
  }
  
  public final int getFuncId()
  {
    if (com.tencent.mm.plugin.offline.k.GCg) {
      return 571;
    }
    return 1725;
  }
  
  public final int getTenpayCgicmd()
  {
    if (com.tencent.mm.plugin.offline.k.GCg) {
      return 52;
    }
    return 1725;
  }
  
  public final String getUri()
  {
    if (com.tencent.mm.plugin.offline.k.GCg) {
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
      this.GCJ = paramJSONObject.optString("valid_end");
      this.GCK = paramJSONObject.optString("encrypt_str");
      this.GCL = paramJSONObject.optString("deviceid");
      this.GCO = paramJSONObject.optString("token_v2");
      this.GCP = paramJSONObject.optInt("algorithm_type");
      this.GCQ = paramJSONObject.optString("card_list");
      this.GCR = paramJSONObject.optString("key_list");
      this.GCS = paramJSONObject.optString("token_pin");
      this.GCU = paramJSONObject.optString("auth_codes");
      this.GCV = paramJSONObject.optInt("update_interval");
      this.GCW = paramJSONObject.optString("code_ver");
      this.GCX = paramJSONObject.optInt("reget_token_num", 0);
      this.GCY = paramJSONObject.optInt("cipher_type", 0);
      a.aaS(this.GCX);
      Log.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "json: %s", new Object[] { paramJSONObject.toString() });
    }
    AppMethodBeat.o(66308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.m
 * JD-Core Version:    0.7.0.1
 */