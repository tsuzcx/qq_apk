package com.tencent.mm.plugin.offline.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends j
{
  public static String mLd = "3";
  public String mKY = "";
  public String mKZ = "";
  public String mLa = "";
  public String mLb = "";
  public String mLc = "";
  public String mLe = "";
  public int mLf = 0;
  public String mLg = "";
  public String mLh = "";
  public String mLi = "";
  public int mLj = 20000;
  public String token = "";
  
  public k(Bankcard paramBankcard, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString);
    localHashMap.put("device_id", com.tencent.mm.compatible.e.q.zg());
    localHashMap.put("weixin_ver", "0x" + Integer.toHexString(d.spa));
    localHashMap.put("bind_serialno", paramBankcard.field_bindSerial);
    localHashMap.put("bank_type", paramBankcard.field_bankcardType);
    localHashMap.put("card_tail", paramBankcard.field_bankcardTail);
    localHashMap.put("open_limitfee", String.valueOf(paramInt));
    this.mLj = paramInt;
    paramBankcard = com.tencent.mm.wallet_core.ui.e.getUsername();
    paramBankcard = ad.bB(ad.bB(paramBankcard) + ad.bB(com.tencent.mm.compatible.e.q.zg()));
    localHashMap.put("user_id", paramBankcard);
    paramString = com.tencent.mm.wallet_core.c.a.cMr();
    b.cMj();
    if (b.cMl()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramBankcard = paramString.dO(paramBankcard, paramInt);
      b.cMj();
      y.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "crt_csr %s %s", new Object[] { paramBankcard, Boolean.valueOf(b.cMl()) });
      localHashMap.put("crt_csr", paramBankcard);
      localHashMap.put("type", mLd);
      localHashMap.put("version_number", mLd);
      D(localHashMap);
      return;
    }
  }
  
  public final int HH()
  {
    return 565;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.offline.k.bpX();
      com.tencent.mm.plugin.offline.k.ax(196630, "0");
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
      h.nFQ.b(paramString, true);
      return;
      paramArrayOfByte.SetKey(10);
    }
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    boolean bool;
    if (paramJSONObject != null)
    {
      this.mKZ = paramJSONObject.optString("crt_crt");
      this.mKY = paramJSONObject.optString("cn");
      this.token = paramJSONObject.optString("token");
      this.mLa = paramJSONObject.optString("valid_end");
      this.mLb = paramJSONObject.optString("encrypt_str");
      this.mLc = paramJSONObject.optString("deviceid");
      if (!com.tencent.mm.wallet_core.c.a.cMr().importCert(this.mKY, this.mKZ)) {
        break label512;
      }
      y.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
      this.mLe = paramJSONObject.optString("token_v2");
      this.mLf = paramJSONObject.optInt("algorithm_type");
      this.mLg = paramJSONObject.optString("card_list");
      this.mLh = paramJSONObject.optString("key_list");
      this.mLi = paramJSONObject.optString("token_pin");
      String str2 = paramJSONObject.optString("notice_url");
      String str1 = paramJSONObject.optString("auth_codes");
      paramInt = paramJSONObject.optInt("update_interval");
      paramString = paramJSONObject.optString("code_ver");
      int i = paramJSONObject.optInt("cipher_type", 0);
      com.tencent.mm.plugin.offline.k.bpX();
      com.tencent.mm.plugin.offline.k.ax(196617, this.mKY);
      com.tencent.mm.plugin.offline.k.bpX();
      com.tencent.mm.plugin.offline.k.ax(196626, this.mLa);
      com.tencent.mm.plugin.offline.k.bpX();
      com.tencent.mm.plugin.offline.k.ax(196627, this.mLb);
      com.tencent.mm.plugin.offline.k.bpX();
      com.tencent.mm.plugin.offline.k.ax(196628, this.mLc);
      com.tencent.mm.plugin.offline.k.bpX();
      com.tencent.mm.plugin.offline.k.ax(196630, "1");
      com.tencent.mm.plugin.offline.k.bpX();
      com.tencent.mm.plugin.offline.k.ax(196632, System.currentTimeMillis() / 1000L);
      com.tencent.mm.plugin.offline.c.a.p(this.token, this.mLe, this.mLg, this.mLh);
      com.tencent.mm.plugin.offline.c.a.vG(this.mLf);
      com.tencent.mm.plugin.offline.k.bpX();
      com.tencent.mm.plugin.offline.k.ax(196647, this.mLi);
      com.tencent.mm.plugin.offline.c.a.Ks(str2);
      com.tencent.mm.plugin.offline.k.bpX();
      paramJSONObject = com.tencent.mm.plugin.offline.k.vA(196617);
      com.tencent.mm.wallet_core.c.a.cMr();
      com.tencent.mm.wallet_core.c.a.clearToken(paramJSONObject);
      com.tencent.mm.wallet_core.c.a.cMr();
      paramJSONObject = this.mKY;
      if (i != 1) {
        break label523;
      }
      bool = true;
      label368:
      bool = com.tencent.mm.wallet_core.c.a.z(paramJSONObject, str1, bool);
      y.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", new Object[] { Boolean.valueOf(bool), this.mKY });
      if (bool) {
        break label529;
      }
      y.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
      paramJSONObject = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      com.tencent.mm.wallet_core.c.a.cMr();
      y.e("MicroMsg.NetSceneTenpayWxOfflineCreate", com.tencent.mm.wallet_core.c.a.getLastError());
    }
    for (;;)
    {
      com.tencent.mm.plugin.offline.k.bpX();
      com.tencent.mm.plugin.offline.k.ax(196649, String.valueOf(paramInt));
      g.DQ();
      g.DP().Dz().c(ac.a.unD, com.tencent.mm.compatible.e.q.zf());
      g.DQ();
      g.DP().Dz().c(ac.a.unE, paramString);
      return;
      label512:
      y.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt fail");
      break;
      label523:
      bool = false;
      break label368;
      label529:
      y.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens success!");
    }
  }
  
  public final void a(c paramc, JSONObject paramJSONObject)
  {
    com.tencent.mm.wallet_core.c.a.cMr().cMs();
  }
  
  public final int aEC()
  {
    return 46;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlinecreate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.k
 * JD-Core Version:    0.7.0.1
 */