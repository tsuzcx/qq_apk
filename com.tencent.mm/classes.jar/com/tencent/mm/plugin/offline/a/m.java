package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.xweb.util.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends h
{
  String bRP = c.o(System.currentTimeMillis().getBytes());
  public String mLa = "";
  public String mLb = "";
  public String mLc = "";
  public String mLe = "";
  public int mLf = 0;
  public String mLg = "";
  public String mLh = "";
  public String mLi = "";
  private String mLk;
  private int mLl;
  public String mLm;
  public int mLn = 0;
  int mLo = 0;
  public String token = "";
  
  public m(String paramString, int paramInt)
  {
    this(paramString, paramInt, paramInt);
  }
  
  public m(String paramString, int paramInt1, int paramInt2)
  {
    y.v("MicroMsg.NetSceneTenpayWxOfflineGetToken", "scene %s stack %s ", new Object[] { Integer.valueOf(paramInt1), bk.csb().toString() });
    Object localObject2 = com.tencent.mm.plugin.offline.c.a.getToken();
    com.tencent.mm.plugin.offline.k.bpX();
    String str = com.tencent.mm.plugin.offline.k.vA(196628);
    Object localObject1 = str;
    if (TextUtils.isEmpty(str)) {
      localObject1 = q.zg();
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramString = (String)localObject1 + "&" + paramString + "&" + ((int)(Math.random() * 1000000.0D) + 1000000);
      localObject1 = new HashMap();
      ((Map)localObject1).put("token_src", paramString);
      com.tencent.mm.plugin.offline.k.bpX();
      str = com.tencent.mm.plugin.offline.k.vA(196617);
      switch (paramInt2)
      {
      default: 
        paramInt2 = 12;
        label299:
        com.tencent.mm.plugin.report.service.h.nFQ.a(135L, paramInt2, 1L, true);
        localObject2 = new com.tencent.mm.h.b.a.a();
        ((com.tencent.mm.h.b.a.a)localObject2).cfA = this.bRP;
        ((com.tencent.mm.h.b.a.a)localObject2).cfv = 1L;
        com.tencent.mm.wallet_core.c.a.cMr();
        if (com.tencent.mm.wallet_core.c.a.isCertExist(str))
        {
          ((com.tencent.mm.h.b.a.a)localObject2).cfw = 1;
          com.tencent.mm.wallet_core.c.a.cMr();
          ((com.tencent.mm.h.b.a.a)localObject2).cfx = com.tencent.mm.wallet_core.c.a.getLastError();
          ((com.tencent.mm.h.b.a.a)localObject2).QX();
          localObject2 = new com.tencent.mm.h.b.a.a();
          ((com.tencent.mm.h.b.a.a)localObject2).cfA = this.bRP;
          ((com.tencent.mm.h.b.a.a)localObject2).cfv = 3L;
          com.tencent.mm.wallet_core.c.a.cMr();
          paramString = com.tencent.mm.wallet_core.c.a.genUserSig(str, paramString);
          if (bk.bl(paramString))
          {
            ((com.tencent.mm.h.b.a.a)localObject2).cfw = 0;
            com.tencent.mm.wallet_core.c.a.cMr();
            ((com.tencent.mm.h.b.a.a)localObject2).cfx = com.tencent.mm.wallet_core.c.a.getLastError();
            ((com.tencent.mm.h.b.a.a)localObject2).QX();
            label442:
            y.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
            if (!TextUtils.isEmpty(paramString)) {
              break label1004;
            }
            y.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 4L, 1L, true);
            label477:
            ((Map)localObject1).put("sign", paramString);
            ((Map)localObject1).put("cert_no", str);
            ((Map)localObject1).put("type", k.mLd);
            ((Map)localObject1).put("version_number", k.mLd);
            if (com.tencent.mm.plugin.offline.c.a.bqU() != 2) {
              break label1015;
            }
            ((Map)localObject1).put("last_token", com.tencent.mm.plugin.offline.c.a.bqV());
            label546:
            y.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "inOfflineUI: %B", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.k.mKz) });
            if (paramInt1 != 65281) {
              break label1031;
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
      D((Map)localObject1);
      return;
      paramString = (String)localObject1 + "&" + paramString + "&" + ((int)(Math.random() * 1000000.0D) + 1000000) + "&" + (String)localObject2;
      break;
      paramInt2 = 12;
      break label299;
      paramInt2 = 13;
      break label299;
      paramInt2 = 14;
      break label299;
      paramInt2 = 15;
      break label299;
      paramInt2 = 16;
      break label299;
      paramInt2 = 17;
      break label299;
      paramInt2 = 18;
      break label299;
      paramInt2 = 19;
      break label299;
      paramInt2 = 20;
      break label299;
      paramInt2 = 24;
      break label299;
      paramInt2 = 72;
      break label299;
      ((com.tencent.mm.h.b.a.a)localObject2).cfw = 1;
      com.tencent.mm.wallet_core.c.a.cMr();
      ((com.tencent.mm.h.b.a.a)localObject2).cfx = com.tencent.mm.wallet_core.c.a.getLastError();
      ((com.tencent.mm.h.b.a.a)localObject2).QX();
      break label442;
      paramString = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
      com.tencent.mm.wallet_core.c.a.cMr();
      y.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", com.tencent.mm.wallet_core.c.a.getLastError());
      ((com.tencent.mm.h.b.a.a)localObject2).cfw = 0;
      com.tencent.mm.wallet_core.c.a.cMr();
      ((com.tencent.mm.h.b.a.a)localObject2).cfx = com.tencent.mm.wallet_core.c.a.getLastError();
      ((com.tencent.mm.h.b.a.a)localObject2).QX();
      com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 6L, 1L, true);
      paramString = new com.tencent.mm.h.b.a.a();
      paramString.cfA = this.bRP;
      paramString.cfv = 2L;
      g.DQ();
      localObject2 = (String)g.DP().Dz().get(ac.a.unD, "");
      if ((localObject2 != null) && (((String)localObject2).equals(q.zf())))
      {
        y.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
        paramString.cfw = 1;
        com.tencent.mm.wallet_core.c.a.cMr();
        paramString.cfx = com.tencent.mm.wallet_core.c.a.getLastError();
      }
      for (;;)
      {
        paramString.QX();
        y.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: " + str);
        paramString = "";
        break;
        paramString.cfw = 0;
        com.tencent.mm.wallet_core.c.a.cMr();
        paramString.cfx = com.tencent.mm.wallet_core.c.a.getLastError();
        y.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
        com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 5L, 1L, true);
      }
      label1004:
      y.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
      break label477;
      label1015:
      ((Map)localObject1).put("last_token", com.tencent.mm.plugin.offline.c.a.getToken());
      break label546;
      label1031:
      if (com.tencent.mm.plugin.offline.k.mKz) {
        ((Map)localObject1).put("fetch_tag", "1");
      } else {
        ((Map)localObject1).put("fetch_tag", "0");
      }
    }
  }
  
  public final int HH()
  {
    if (com.tencent.mm.plugin.offline.k.mKz) {
      return 571;
    }
    return 1725;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      this.token = paramJSONObject.optString("token");
      this.mLa = paramJSONObject.optString("valid_end");
      this.mLb = paramJSONObject.optString("encrypt_str");
      this.mLc = paramJSONObject.optString("deviceid");
      this.mLe = paramJSONObject.optString("token_v2");
      this.mLf = paramJSONObject.optInt("algorithm_type");
      this.mLg = paramJSONObject.optString("card_list");
      this.mLh = paramJSONObject.optString("key_list");
      this.mLi = paramJSONObject.optString("token_pin");
      this.mLk = paramJSONObject.optString("auth_codes");
      this.mLl = paramJSONObject.optInt("update_interval");
      this.mLm = paramJSONObject.optString("code_ver");
      this.mLn = paramJSONObject.optInt("reget_token_num", 0);
      this.mLo = paramJSONObject.optInt("cipher_type", 0);
      if (this.mLn <= 0) {
        break label217;
      }
    }
    label217:
    for (com.tencent.mm.plugin.offline.k.mKA = this.mLn;; com.tencent.mm.plugin.offline.k.mKA = 10)
    {
      y.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "json: %s", new Object[] { paramJSONObject.toString() });
      return;
    }
  }
  
  public final int aEC()
  {
    if (com.tencent.mm.plugin.offline.k.mKz) {
      return 52;
    }
    return 1725;
  }
  
  public final boolean bqe()
  {
    y.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
    com.tencent.mm.plugin.offline.k.bpX();
    com.tencent.mm.plugin.offline.k.ax(196626, this.mLa);
    com.tencent.mm.plugin.offline.k.bpX();
    com.tencent.mm.plugin.offline.k.ax(196627, this.mLb);
    com.tencent.mm.plugin.offline.k.bpX();
    com.tencent.mm.plugin.offline.k.ax(196628, this.mLc);
    com.tencent.mm.plugin.offline.k.bpX();
    com.tencent.mm.plugin.offline.k.ax(196632, System.currentTimeMillis() / 1000L);
    com.tencent.mm.plugin.offline.c.a.p(this.token, this.mLe, this.mLg, this.mLh);
    com.tencent.mm.plugin.offline.c.a.vG(this.mLf);
    com.tencent.mm.plugin.offline.k.bpX();
    com.tencent.mm.plugin.offline.k.ax(196647, this.mLi);
    com.tencent.mm.plugin.offline.k.bpX();
    Object localObject1 = com.tencent.mm.plugin.offline.k.vA(196617);
    com.tencent.mm.wallet_core.c.a.cMr();
    com.tencent.mm.wallet_core.c.a.clearToken((String)localObject1);
    com.tencent.mm.wallet_core.c.a.cMr();
    Object localObject2 = this.mLk;
    boolean bool;
    if (this.mLo == 1)
    {
      bool = true;
      bool = com.tencent.mm.wallet_core.c.a.z((String)localObject1, (String)localObject2, bool);
      localObject1 = new com.tencent.mm.h.b.a.a();
      ((com.tencent.mm.h.b.a.a)localObject1).cfA = this.bRP;
      ((com.tencent.mm.h.b.a.a)localObject1).cfv = 3L;
      if (bool) {
        break label304;
      }
      ((com.tencent.mm.h.b.a.a)localObject1).cfw = 0;
      com.tencent.mm.wallet_core.c.a.cMr();
      ((com.tencent.mm.h.b.a.a)localObject1).cfx = com.tencent.mm.wallet_core.c.a.getLastError();
      y.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
      localObject2 = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      com.tencent.mm.wallet_core.c.a.cMr();
      y.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", com.tencent.mm.wallet_core.c.a.getLastError());
    }
    for (;;)
    {
      ((com.tencent.mm.h.b.a.a)localObject1).QX();
      com.tencent.mm.plugin.offline.k.bpX();
      com.tencent.mm.plugin.offline.k.ax(196649, this.mLl);
      g.DQ();
      g.DP().Dz().c(ac.a.unE, this.mLm);
      return bool;
      bool = false;
      break;
      label304:
      ((com.tencent.mm.h.b.a.a)localObject1).cfw = 1;
      com.tencent.mm.wallet_core.c.a.cMr();
      ((com.tencent.mm.h.b.a.a)localObject1).cfx = com.tencent.mm.wallet_core.c.a.getLastError();
      y.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
    }
  }
  
  public final String getUri()
  {
    if (com.tencent.mm.plugin.offline.k.mKz) {
      return "/cgi-bin/mmpay-bin/tenpay/offlinegettoken";
    }
    return "/cgi-bin/mmpay-bin/tenpay/offlinegettokenbackground";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.m
 * JD-Core Version:    0.7.0.1
 */