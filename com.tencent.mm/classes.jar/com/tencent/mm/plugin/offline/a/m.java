package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.b.a.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.xweb.util.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends h
{
  String dyV;
  public String token;
  public String wyl;
  public String wym;
  public String wyn;
  public String wyp;
  public int wyq;
  public String wyr;
  public String wys;
  public String wyt;
  private String wyv;
  private int wyw;
  public String wyx;
  public int wyy;
  int wyz;
  
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
    this.wyl = "";
    this.wym = "";
    this.wyn = "";
    this.wyp = "";
    this.wyq = 0;
    this.wyr = "";
    this.wys = "";
    this.wyt = "";
    this.wyy = 0;
    this.wyz = 0;
    this.dyV = d.getMessageDigest(System.currentTimeMillis().getBytes());
    ad.v("MicroMsg.NetSceneTenpayWxOfflineGetToken", "scene %s stack %s ", new Object[] { Integer.valueOf(paramInt1), bt.flS().toString() });
    Object localObject2 = a.getToken();
    com.tencent.mm.plugin.offline.k.dwq();
    String str = com.tencent.mm.plugin.offline.k.Mi(196628);
    Object localObject1 = str;
    if (TextUtils.isEmpty(str)) {
      localObject1 = q.aay();
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramString = (String)localObject1 + "&" + paramString + "&" + ((int)(Math.random() * 1000000.0D) + 1000000);
      localObject1 = new HashMap();
      ((Map)localObject1).put("token_src", paramString);
      com.tencent.mm.plugin.offline.k.dwq();
      str = com.tencent.mm.plugin.offline.k.Mi(196617);
      switch (paramInt2)
      {
      default: 
        paramInt2 = 12;
        label303:
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, paramInt2, 1L, true);
        localObject2 = new c();
        ((c)localObject2).gD(this.dyV);
        ((c)localObject2).dPH = 1L;
        b.fRq();
        if (b.isCertExist(str))
        {
          ((c)localObject2).dPI = 1;
          b.fRq();
          ((c)localObject2).dPJ = b.getLastError();
          ((c)localObject2).aLk();
          localObject2 = new c();
          ((c)localObject2).gD(this.dyV);
          ((c)localObject2).dPH = 3L;
          b.fRq();
          paramString = b.genUserSig(str, paramString);
          if (bt.isNullOrNil(paramString))
          {
            ((c)localObject2).dPI = 0;
            b.fRq();
            ((c)localObject2).dPJ = b.getLastError();
            ((c)localObject2).aLk();
            label448:
            ad.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
            if (!TextUtils.isEmpty(paramString)) {
              break label1012;
            }
            ad.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 4L, 1L, true);
            label483:
            ((Map)localObject1).put("sign", paramString);
            ((Map)localObject1).put("cert_no", str);
            ((Map)localObject1).put("type", k.wyo);
            ((Map)localObject1).put("version_number", k.wyo);
            if (a.dxw() != 2) {
              break label1023;
            }
            ((Map)localObject1).put("last_token", a.dxx());
            label554:
            ad.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "inOfflineUI: %B", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.k.wxG) });
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
      ((c)localObject2).dPI = 1;
      b.fRq();
      ((c)localObject2).dPJ = b.getLastError();
      ((c)localObject2).aLk();
      break label448;
      paramString = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
      b.fRq();
      ad.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", b.getLastError());
      ((c)localObject2).dPI = 0;
      b.fRq();
      ((c)localObject2).dPJ = b.getLastError();
      ((c)localObject2).aLk();
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 6L, 1L, true);
      paramString = new c();
      paramString.gD(this.dyV);
      paramString.dPH = 2L;
      com.tencent.mm.kernel.g.ajD();
      localObject2 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IpV, "");
      if ((localObject2 != null) && (((String)localObject2).equals(q.cH(true))))
      {
        ad.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
        paramString.dPI = 1;
        b.fRq();
        paramString.dPJ = b.getLastError();
      }
      for (;;)
      {
        paramString.aLk();
        ad.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: ".concat(String.valueOf(str)));
        paramString = "";
        break;
        paramString.dPI = 0;
        b.fRq();
        paramString.dPJ = b.getLastError();
        ad.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 5L, 1L, true);
      }
      label1012:
      ad.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
      break label483;
      label1023:
      ((Map)localObject1).put("last_token", a.getToken());
      break label554;
      label1040:
      if (com.tencent.mm.plugin.offline.k.wxG) {
        ((Map)localObject1).put("fetch_tag", "1");
      } else {
        ((Map)localObject1).put("fetch_tag", "0");
      }
    }
  }
  
  public final boolean dwv()
  {
    AppMethodBeat.i(66309);
    ad.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
    com.tencent.mm.plugin.offline.k.dwq();
    com.tencent.mm.plugin.offline.k.bz(196626, this.wyl);
    com.tencent.mm.plugin.offline.k.dwq();
    com.tencent.mm.plugin.offline.k.bz(196627, this.wym);
    com.tencent.mm.plugin.offline.k.dwq();
    com.tencent.mm.plugin.offline.k.bz(196628, this.wyn);
    com.tencent.mm.plugin.offline.k.dwq();
    com.tencent.mm.plugin.offline.k.bz(196632, System.currentTimeMillis() / 1000L);
    a.s(this.token, this.wyp, this.wyr, this.wys);
    a.Mq(this.wyq);
    com.tencent.mm.plugin.offline.k.dwq();
    com.tencent.mm.plugin.offline.k.bz(196647, this.wyt);
    com.tencent.mm.plugin.offline.k.dwq();
    Object localObject1 = com.tencent.mm.plugin.offline.k.Mi(196617);
    b.fRq();
    b.clearToken((String)localObject1);
    b.fRq();
    Object localObject2 = this.wyv;
    boolean bool;
    if (this.wyz == 1)
    {
      bool = true;
      bool = b.F((String)localObject1, (String)localObject2, bool);
      localObject1 = new c();
      ((c)localObject1).gD(this.dyV);
      ((c)localObject1).dPH = 3L;
      if (bool) {
        break label317;
      }
      ((c)localObject1).dPI = 0;
      b.fRq();
      ((c)localObject1).dPJ = b.getLastError();
      ad.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
      localObject2 = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
      b.fRq();
      ad.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", b.getLastError());
    }
    for (;;)
    {
      ((c)localObject1).aLk();
      com.tencent.mm.plugin.offline.k.dwq();
      com.tencent.mm.plugin.offline.k.bz(196649, this.wyw);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IpW, this.wyx);
      AppMethodBeat.o(66309);
      return bool;
      bool = false;
      break;
      label317:
      ((c)localObject1).dPI = 1;
      b.fRq();
      ((c)localObject1).dPJ = b.getLastError();
      ad.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
    }
  }
  
  public final int getFuncId()
  {
    if (com.tencent.mm.plugin.offline.k.wxG) {
      return 571;
    }
    return 1725;
  }
  
  public final int getTenpayCgicmd()
  {
    if (com.tencent.mm.plugin.offline.k.wxG) {
      return 52;
    }
    return 1725;
  }
  
  public final String getUri()
  {
    if (com.tencent.mm.plugin.offline.k.wxG) {
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
      this.wyl = paramJSONObject.optString("valid_end");
      this.wym = paramJSONObject.optString("encrypt_str");
      this.wyn = paramJSONObject.optString("deviceid");
      this.wyp = paramJSONObject.optString("token_v2");
      this.wyq = paramJSONObject.optInt("algorithm_type");
      this.wyr = paramJSONObject.optString("card_list");
      this.wys = paramJSONObject.optString("key_list");
      this.wyt = paramJSONObject.optString("token_pin");
      this.wyv = paramJSONObject.optString("auth_codes");
      this.wyw = paramJSONObject.optInt("update_interval");
      this.wyx = paramJSONObject.optString("code_ver");
      this.wyy = paramJSONObject.optInt("reget_token_num", 0);
      this.wyz = paramJSONObject.optInt("cipher_type", 0);
      a.Ms(this.wyy);
      ad.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "json: %s", new Object[] { paramJSONObject.toString() });
    }
    AppMethodBeat.o(66308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.m
 * JD-Core Version:    0.7.0.1
 */