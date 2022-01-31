package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.xweb.util.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends h
{
  String czq;
  private String plB;
  private int plC;
  public String plD;
  public int plE;
  int plF;
  public String plr;
  public String pls;
  public String plt;
  public String plv;
  public int plw;
  public String plx;
  public String ply;
  public String plz;
  public String token;
  
  public m(String paramString, int paramInt)
  {
    this(paramString, paramInt, paramInt);
    AppMethodBeat.i(43407);
    AppMethodBeat.o(43407);
  }
  
  public m(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43408);
    this.token = "";
    this.plr = "";
    this.pls = "";
    this.plt = "";
    this.plv = "";
    this.plw = 0;
    this.plx = "";
    this.ply = "";
    this.plz = "";
    this.plE = 0;
    this.plF = 0;
    this.czq = d.w(System.currentTimeMillis().getBytes());
    ab.v("MicroMsg.NetSceneTenpayWxOfflineGetToken", "scene %s stack %s ", new Object[] { Integer.valueOf(paramInt1), bo.dtY().toString() });
    Object localObject2 = com.tencent.mm.plugin.offline.c.a.getToken();
    com.tencent.mm.plugin.offline.k.bYF();
    String str = com.tencent.mm.plugin.offline.k.AY(196628);
    Object localObject1 = str;
    if (TextUtils.isEmpty(str)) {
      localObject1 = q.LK();
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramString = (String)localObject1 + "&" + paramString + "&" + ((int)(Math.random() * 1000000.0D) + 1000000);
      localObject1 = new HashMap();
      ((Map)localObject1).put("token_src", paramString);
      com.tencent.mm.plugin.offline.k.bYF();
      str = com.tencent.mm.plugin.offline.k.AY(196617);
      switch (paramInt2)
      {
      default: 
        paramInt2 = 12;
        label303:
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, paramInt2, 1L, true);
        localObject2 = new com.tencent.mm.g.b.a.a();
        ((com.tencent.mm.g.b.a.a)localObject2).eO(this.czq);
        ((com.tencent.mm.g.b.a.a)localObject2).cOc = 1L;
        b.dSi();
        if (b.isCertExist(str))
        {
          ((com.tencent.mm.g.b.a.a)localObject2).cOd = 1;
          b.dSi();
          ((com.tencent.mm.g.b.a.a)localObject2).cOe = b.getLastError();
          ((com.tencent.mm.g.b.a.a)localObject2).ake();
          localObject2 = new com.tencent.mm.g.b.a.a();
          ((com.tencent.mm.g.b.a.a)localObject2).eO(this.czq);
          ((com.tencent.mm.g.b.a.a)localObject2).cOc = 3L;
          b.dSi();
          paramString = b.genUserSig(str, paramString);
          if (bo.isNullOrNil(paramString))
          {
            ((com.tencent.mm.g.b.a.a)localObject2).cOd = 0;
            b.dSi();
            ((com.tencent.mm.g.b.a.a)localObject2).cOe = b.getLastError();
            ((com.tencent.mm.g.b.a.a)localObject2).ake();
            label448:
            ab.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
            if (!TextUtils.isEmpty(paramString)) {
              break label1012;
            }
            ab.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 4L, 1L, true);
            label483:
            ((Map)localObject1).put("sign", paramString);
            ((Map)localObject1).put("cert_no", str);
            ((Map)localObject1).put("type", k.plu);
            ((Map)localObject1).put("version_number", k.plu);
            if (com.tencent.mm.plugin.offline.c.a.bZJ() != 2) {
              break label1023;
            }
            ((Map)localObject1).put("last_token", com.tencent.mm.plugin.offline.c.a.bZK());
            label554:
            ab.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "inOfflineUI: %B", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.k.pkO) });
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
      AppMethodBeat.o(43408);
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
      ((com.tencent.mm.g.b.a.a)localObject2).cOd = 1;
      b.dSi();
      ((com.tencent.mm.g.b.a.a)localObject2).cOe = b.getLastError();
      ((com.tencent.mm.g.b.a.a)localObject2).ake();
      break label448;
      paramString = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
      b.dSi();
      ab.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", b.getLastError());
      ((com.tencent.mm.g.b.a.a)localObject2).cOd = 0;
      b.dSi();
      ((com.tencent.mm.g.b.a.a)localObject2).cOe = b.getLastError();
      ((com.tencent.mm.g.b.a.a)localObject2).ake();
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 6L, 1L, true);
      paramString = new com.tencent.mm.g.b.a.a();
      paramString.eO(this.czq);
      paramString.cOc = 2L;
      g.RM();
      localObject2 = (String)g.RL().Ru().get(ac.a.yxu, "");
      if ((localObject2 != null) && (((String)localObject2).equals(q.bP(true))))
      {
        ab.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
        paramString.cOd = 1;
        b.dSi();
        paramString.cOe = b.getLastError();
      }
      for (;;)
      {
        paramString.ake();
        ab.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: ".concat(String.valueOf(str)));
        paramString = "";
        break;
        paramString.cOd = 0;
        b.dSi();
        paramString.cOe = b.getLastError();
        ab.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 5L, 1L, true);
      }
      label1012:
      ab.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
      break label483;
      label1023:
      ((Map)localObject1).put("last_token", com.tencent.mm.plugin.offline.c.a.getToken());
      break label554;
      label1040:
      if (com.tencent.mm.plugin.offline.k.pkO) {
        ((Map)localObject1).put("fetch_tag", "1");
      } else {
        ((Map)localObject1).put("fetch_tag", "0");
      }
    }
  }
  
  public final boolean bYK()
  {
    AppMethodBeat.i(43410);
    ab.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
    com.tencent.mm.plugin.offline.k.bYF();
    com.tencent.mm.plugin.offline.k.aT(196626, this.plr);
    com.tencent.mm.plugin.offline.k.bYF();
    com.tencent.mm.plugin.offline.k.aT(196627, this.pls);
    com.tencent.mm.plugin.offline.k.bYF();
    com.tencent.mm.plugin.offline.k.aT(196628, this.plt);
    com.tencent.mm.plugin.offline.k.bYF();
    com.tencent.mm.plugin.offline.k.aT(196632, System.currentTimeMillis() / 1000L);
    com.tencent.mm.plugin.offline.c.a.r(this.token, this.plv, this.plx, this.ply);
    com.tencent.mm.plugin.offline.c.a.Be(this.plw);
    com.tencent.mm.plugin.offline.k.bYF();
    com.tencent.mm.plugin.offline.k.aT(196647, this.plz);
    com.tencent.mm.plugin.offline.k.bYF();
    Object localObject1 = com.tencent.mm.plugin.offline.k.AY(196617);
    b.dSi();
    b.clearToken((String)localObject1);
    b.dSi();
    Object localObject2 = this.plB;
    boolean bool;
    if (this.plF == 1)
    {
      bool = true;
      bool = b.F((String)localObject1, (String)localObject2, bool);
      localObject1 = new com.tencent.mm.g.b.a.a();
      ((com.tencent.mm.g.b.a.a)localObject1).eO(this.czq);
      ((com.tencent.mm.g.b.a.a)localObject1).cOc = 3L;
      if (bool) {
        break label317;
      }
      ((com.tencent.mm.g.b.a.a)localObject1).cOd = 0;
      b.dSi();
      ((com.tencent.mm.g.b.a.a)localObject1).cOe = b.getLastError();
      ab.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
      localObject2 = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      b.dSi();
      ab.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", b.getLastError());
    }
    for (;;)
    {
      ((com.tencent.mm.g.b.a.a)localObject1).ake();
      com.tencent.mm.plugin.offline.k.bYF();
      com.tencent.mm.plugin.offline.k.aT(196649, this.plC);
      g.RM();
      g.RL().Ru().set(ac.a.yxv, this.plD);
      AppMethodBeat.o(43410);
      return bool;
      bool = false;
      break;
      label317:
      ((com.tencent.mm.g.b.a.a)localObject1).cOd = 1;
      b.dSi();
      ((com.tencent.mm.g.b.a.a)localObject1).cOe = b.getLastError();
      ab.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
    }
  }
  
  public final int getFuncId()
  {
    if (com.tencent.mm.plugin.offline.k.pkO) {
      return 571;
    }
    return 1725;
  }
  
  public final int getTenpayCgicmd()
  {
    if (com.tencent.mm.plugin.offline.k.pkO) {
      return 52;
    }
    return 1725;
  }
  
  public final String getUri()
  {
    if (com.tencent.mm.plugin.offline.k.pkO) {
      return "/cgi-bin/mmpay-bin/tenpay/offlinegettoken";
    }
    return "/cgi-bin/mmpay-bin/tenpay/offlinegettokenbackground";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(43409);
    ab.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      this.token = paramJSONObject.optString("token");
      this.plr = paramJSONObject.optString("valid_end");
      this.pls = paramJSONObject.optString("encrypt_str");
      this.plt = paramJSONObject.optString("deviceid");
      this.plv = paramJSONObject.optString("token_v2");
      this.plw = paramJSONObject.optInt("algorithm_type");
      this.plx = paramJSONObject.optString("card_list");
      this.ply = paramJSONObject.optString("key_list");
      this.plz = paramJSONObject.optString("token_pin");
      this.plB = paramJSONObject.optString("auth_codes");
      this.plC = paramJSONObject.optInt("update_interval");
      this.plD = paramJSONObject.optString("code_ver");
      this.plE = paramJSONObject.optInt("reget_token_num", 0);
      this.plF = paramJSONObject.optInt("cipher_type", 0);
      if (this.plE <= 0) {
        break label229;
      }
    }
    label229:
    for (com.tencent.mm.plugin.offline.k.pkP = this.plE;; com.tencent.mm.plugin.offline.k.pkP = 10)
    {
      ab.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "json: %s", new Object[] { paramJSONObject.toString() });
      AppMethodBeat.o(43409);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.m
 * JD-Core Version:    0.7.0.1
 */