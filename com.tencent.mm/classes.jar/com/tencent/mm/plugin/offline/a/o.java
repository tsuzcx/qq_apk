package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.n;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.offline.c.d;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class o
  extends j
{
  public String MyU;
  public String MyV;
  public String MyW;
  public String MyX;
  public int MyY;
  public String MyZ;
  public String Mza;
  public String Mzb;
  private int Mzc;
  private String Mze;
  private int Mzf;
  public String Mzg;
  public int Mzh;
  int Mzi;
  public anq Mzj;
  String hQR;
  public String token;
  
  public o(String paramString, int paramInt)
  {
    this(paramString, paramInt, paramInt);
    AppMethodBeat.i(66306);
    AppMethodBeat.o(66306);
  }
  
  public o(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66307);
    this.token = "";
    this.MyU = "";
    this.MyV = "";
    this.MyW = "";
    this.MyX = "";
    this.MyY = 0;
    this.MyZ = "";
    this.Mza = "";
    this.Mzb = "";
    this.Mzh = 0;
    this.Mzi = 0;
    this.hQR = g.getMessageDigest(System.currentTimeMillis().getBytes());
    Log.v("MicroMsg.NetSceneTenpayWxOfflineGetToken", "scene %s stack %s ", new Object[] { Integer.valueOf(paramInt1), Util.getStack().toString() });
    Object localObject2 = d.getToken();
    k.gvj();
    String str = k.afd(196628);
    Object localObject1 = str;
    if (TextUtils.isEmpty(str)) {
      localObject1 = q.aPg();
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramString = (String)localObject1 + "&" + paramString + "&" + ((int)(Math.random() * 1000000.0D) + 1000000);
      localObject1 = new HashMap();
      ((Map)localObject1).put("token_src", paramString);
      k.gvj();
      str = k.afd(196617);
      switch (paramInt2)
      {
      default: 
        paramInt2 = 12;
        label303:
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, paramInt2, 1L, true);
        localObject2 = new n();
        ((n)localObject2).kf(this.hQR);
        ((n)localObject2).ila = 1L;
        b.jOG();
        if (b.isCertExist(str))
        {
          ((n)localObject2).ilb = 1;
          b.jOG();
          ((n)localObject2).ilc = b.getLastError();
          ((n)localObject2).bMH();
          localObject2 = new n();
          ((n)localObject2).kf(this.hQR);
          ((n)localObject2).ila = 3L;
          b.jOG();
          paramString = b.genUserSig(str, paramString);
          if (Util.isNullOrNil(paramString))
          {
            ((n)localObject2).ilb = 0;
            b.jOG();
            ((n)localObject2).ilc = b.getLastError();
            ((n)localObject2).bMH();
            label448:
            Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
            if (!TextUtils.isEmpty(paramString)) {
              break label1086;
            }
            Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 4L, 1L, true);
            label483:
            ((Map)localObject1).put("sign", paramString);
            ((Map)localObject1).put("cert_no", str);
            ((Map)localObject1).put("type", m.VERSION_NUMBER);
            ((Map)localObject1).put("version_number", m.VERSION_NUMBER);
            if (d.gwO() != 2) {
              break label1097;
            }
            ((Map)localObject1).put("last_token", d.gwP());
            label555:
            Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "inOfflineUI: %B", new Object[] { Boolean.valueOf(k.Myo) });
            if (paramInt1 != 65281) {
              break label1114;
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
      this.Mzc = d.gxe();
      ((Map)localObject1).put("is_new_authcodes", this.Mzc);
      ((Map)localObject1).put("code_ver", com.tencent.mm.kernel.h.baE().ban().get(at.a.acHB, ""));
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
      ((n)localObject2).ilb = 1;
      b.jOG();
      ((n)localObject2).ilc = b.getLastError();
      ((n)localObject2).bMH();
      break label448;
      paramString = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
      b.jOG();
      Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", b.getLastError());
      ((n)localObject2).ilb = 0;
      b.jOG();
      ((n)localObject2).ilc = b.getLastError();
      ((n)localObject2).bMH();
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 6L, 1L, true);
      paramString = new n();
      paramString.kf(this.hQR);
      paramString.ila = 2L;
      com.tencent.mm.kernel.h.baF();
      localObject2 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acHA, "");
      if ((localObject2 != null) && (((String)localObject2).equals(q.eD(true))))
      {
        Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
        paramString.ilb = 1;
        b.jOG();
        paramString.ilc = b.getLastError();
      }
      for (;;)
      {
        paramString.bMH();
        Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: ".concat(String.valueOf(str)));
        paramString = "";
        break;
        paramString.ilb = 0;
        b.jOG();
        paramString.ilc = b.getLastError();
        Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 5L, 1L, true);
      }
      label1086:
      Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
      break label483;
      label1097:
      ((Map)localObject1).put("last_token", d.getToken());
      break label555;
      label1114:
      if (k.Myo) {
        ((Map)localObject1).put("fetch_tag", "1");
      } else {
        ((Map)localObject1).put("fetch_tag", "0");
      }
    }
  }
  
  public static anq bB(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(269123);
    if (paramJSONObject != null)
    {
      anq localanq = new anq();
      localanq.Zvn = paramJSONObject.optInt("is_need_show", 0);
      localanq.text = paramJSONObject.optString("text");
      localanq.Zvo = paramJSONObject.optString("button");
      localanq.icon = paramJSONObject.optString("icon");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acVL, paramJSONObject.toString());
      AppMethodBeat.o(269123);
      return localanq;
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acVL, "");
    AppMethodBeat.o(269123);
    return null;
  }
  
  protected final void aQz(String paramString)
  {
    AppMethodBeat.i(269125);
    Log.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "onGYNetEnd2: %s", new Object[] { paramString });
    try
    {
      this.Mzj = bB(new JSONObject(paramString).optJSONObject("enable_code_page"));
      AppMethodBeat.o(269125);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneTenpayWxOfflineGetToken", paramString, "", new Object[0]);
      AppMethodBeat.o(269125);
    }
  }
  
  public final int getFuncId()
  {
    if (k.Myo) {
      return 571;
    }
    return 1725;
  }
  
  public final int getTenpayCgicmd()
  {
    if (k.Myo) {
      return 52;
    }
    return 1725;
  }
  
  public final String getUri()
  {
    if (k.Myo) {
      return "/cgi-bin/mmpay-bin/tenpay/offlinegettoken";
    }
    return "/cgi-bin/mmpay-bin/tenpay/offlinegettokenbackground";
  }
  
  public final boolean gvp()
  {
    AppMethodBeat.i(66309);
    Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
    k.gvj();
    k.ct(196626, this.MyU);
    k.gvj();
    k.ct(196627, this.MyV);
    k.gvj();
    k.ct(196628, this.MyW);
    k.gvj();
    k.ct(196632, System.currentTimeMillis() / 1000L);
    Object localObject1 = this.token;
    Object localObject2 = this.MyX;
    String str1 = this.MyZ;
    String str2 = this.Mza;
    int i;
    boolean bool;
    if (this.Mzc == 1)
    {
      i = 2;
      d.a((String)localObject1, (String)localObject2, str1, str2, i);
      d.afi(this.MyY);
      k.gvj();
      k.ct(196647, this.Mzb);
      k.gvj();
      localObject1 = k.afd(196617);
      b.jOG();
      b.clearToken((String)localObject1);
      b.jOG();
      localObject2 = this.Mze;
      if (this.Mzi != 1) {
        break label346;
      }
      bool = true;
      label188:
      bool = b.P((String)localObject1, (String)localObject2, bool);
      localObject1 = new n();
      ((n)localObject1).kf(this.hQR);
      ((n)localObject1).ila = 3L;
      if (bool) {
        break label351;
      }
      ((n)localObject1).ilb = 0;
      b.jOG();
      ((n)localObject1).ilc = b.getLastError();
      Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
      localObject2 = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      b.jOG();
      Log.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", b.getLastError());
    }
    for (;;)
    {
      ((n)localObject1).bMH();
      k.gvj();
      k.ct(196649, this.Mzf);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acHB, this.Mzg);
      AppMethodBeat.o(66309);
      return bool;
      i = 1;
      break;
      label346:
      bool = false;
      break label188;
      label351:
      ((n)localObject1).ilb = 1;
      b.jOG();
      ((n)localObject1).ilc = b.getLastError();
      Log.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
    }
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66308);
    Log.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      this.token = paramJSONObject.optString("token");
      this.MyU = paramJSONObject.optString("valid_end");
      this.MyV = paramJSONObject.optString("encrypt_str");
      this.MyW = paramJSONObject.optString("deviceid");
      this.MyX = paramJSONObject.optString("token_v2");
      this.MyY = paramJSONObject.optInt("algorithm_type");
      this.MyZ = paramJSONObject.optString("card_list");
      this.Mza = paramJSONObject.optString("key_list");
      this.Mzb = paramJSONObject.optString("token_pin");
      this.Mze = paramJSONObject.optString("auth_codes");
      this.Mzf = paramJSONObject.optInt("update_interval");
      this.Mzg = paramJSONObject.optString("code_ver");
      this.Mzh = paramJSONObject.optInt("reget_token_num", 0);
      this.Mzi = paramJSONObject.optInt("cipher_type", 0);
      d.afk(this.Mzh);
      Log.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "json: %s", new Object[] { paramJSONObject.toString() });
    }
    AppMethodBeat.o(66308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.o
 * JD-Core Version:    0.7.0.1
 */