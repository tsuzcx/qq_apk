package com.tencent.mm.wallet_core.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mm.al.g;
import com.tencent.mm.g.b.a.p;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class s
  extends w
{
  protected static final int ERR_RETCODE_JSON_RESOLVE_ERROR = -10089;
  private static final int ERR_RETCODE_NO_JSON = -10088;
  private static final String PAY_END = "1";
  private static final String TAG = "MicroMsg.NetScenePayBase";
  protected int SVR_ERR_CODE = 0;
  protected int SVR_ERR_TYPE = 0;
  private Map<String, String> _request = new HashMap();
  protected g callback;
  public String crt_token = "";
  public String crt_wording = "";
  protected String error_detail_url;
  private boolean hasProcessWalletError = false;
  public boolean hasRevServerRep = false;
  protected boolean isChildConsume = false;
  public int is_gen_cert = 0;
  public int is_hint_cert = 0;
  public int is_ignore_cert = 0;
  private m jumpRemind;
  private String payAppUrl = "";
  private String payFlag = "";
  protected com.tencent.mm.al.b rr;
  private String wappay_jumped_url = "";
  
  public static e getRetModel(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4, String paramString3, int paramInt5, String paramString4)
  {
    e locale = new e(paramInt1, paramInt2, paramString1);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramInt3 != 0)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: plat ret is error");
        locale.f(1000, paramInt3, paramString2, 1);
        return locale;
      }
      if (paramInt4 != 0)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: errType is error");
        locale.f(1000, paramInt4, paramString3, 2);
        return locale;
      }
      if (paramInt5 != 0)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: retCode is error");
        if ((paramInt5 != -10089) && (paramInt5 != -10088))
        {
          locale.f(1000, paramInt5, paramString4, 2);
          return locale;
        }
        locale.f(1000, 2, paramString4, 2);
        return locale;
      }
      if (!bt.isNullOrNil(paramString3))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetScenePayBase", "finModel.errMsg = biz_errMsg");
        locale.errMsg = paramString3;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetScenePayBase", "hy: all's OK");
      return locale;
    }
    getRetModel(paramInt1, paramInt2, paramString1, locale);
    return locale;
  }
  
  public static void getRetModel(int paramInt1, int paramInt2, String paramString, e parame)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
      paramString = bw.K(paramString, "e");
      if (paramString != null)
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
        parame.errMsg = ((String)paramString.get(".e.Content"));
      }
    }
    else
    {
      return;
    }
    if ((paramInt2 == -1) || (paramInt2 == -500))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetScenePayBase", "hy: network error");
      parame.errMsg = aj.getContext().getString(2131765520);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetScenePayBase", "hy: unknown system error");
    parame.errMsg = aj.getContext().getString(2131765224);
  }
  
  public void addRequestData(Map<String, String> paramMap)
  {
    Object localObject1 = paramMap;
    if (paramMap == null) {
      localObject1 = new HashMap();
    }
    if (localObject1 != null) {
      ((Map)localObject1).remove("uin");
    }
    if (this._request == null) {
      this._request = new HashMap();
    }
    if (this._request != null) {
      this._request.remove("uin");
    }
    paramMap = ((Map)localObject1).keySet().toArray();
    int i = 0;
    while (i < paramMap.length)
    {
      Object localObject2 = paramMap[i];
      String str = (String)((Map)localObject1).get(localObject2);
      if (this._request.containsKey(localObject2)) {
        this._request.remove(localObject2);
      }
      this._request.put((String)localObject2, str);
      i += 1;
    }
    setRequestData(this._request);
  }
  
  public boolean callbackUIWhenWalletError()
  {
    return false;
  }
  
  public void certSignConfig() {}
  
  public boolean checkRecSrvResp()
  {
    return this.hasRevServerRep;
  }
  
  public abstract void configRequest(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract int doSceneSimulately(com.tencent.mm.al.b paramb, com.tencent.mm.network.e parame, g paramg);
  
  public int getCgicmdForKV()
  {
    return getPayCgicmd();
  }
  
  public com.tencent.mm.al.b getCommReqResp()
  {
    return this.rr;
  }
  
  public abstract String getEncryptUrl(String paramString);
  
  public String getErrDetailUrl()
  {
    return this.error_detail_url;
  }
  
  public m getJumpRemind()
  {
    return this.jumpRemind;
  }
  
  public abstract int getPayCgicmd();
  
  public abstract x getRetModel(com.tencent.mm.al.b paramb);
  
  public String getReturnUrl()
  {
    return this.payAppUrl;
  }
  
  public String getToken()
  {
    return null;
  }
  
  public String getWappayJumpUrl()
  {
    return this.wappay_jumped_url;
  }
  
  public boolean hasProcessWalletError()
  {
    return this.hasProcessWalletError;
  }
  
  public boolean isBlock()
  {
    return true;
  }
  
  public boolean isJumpRemind()
  {
    return this.jumpRemind != null;
  }
  
  public boolean isPayEnd()
  {
    if (this.payFlag == null) {
      return false;
    }
    return "1".equals(this.payFlag.trim());
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    this.SVR_ERR_TYPE = paramInt2;
    this.SVR_ERR_CODE = paramInt3;
    if ((ab.hWz) && (1686 == getPayCgicmd()))
    {
      paramInt3 = -1;
      paramInt2 = 3;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetScenePayBase", "cgi: %d, rrType %d, rrCgi %s, PayCgicmd %s, errType %d, errCode %d, errMsg %s, this: %s ", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramq.getType()), paramq.getUri(), Integer.valueOf(getPayCgicmd()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, toString() });
      Object localObject1 = getRetModel((com.tencent.mm.al.b)paramq);
      int i = ((x)localObject1).DEw;
      String str2 = ((x)localObject1).DEx;
      int j = ((x)localObject1).IdR;
      String str1 = ((x)localObject1).oXw;
      paramInt1 = -10088;
      paramq = aj.getContext().getString(2131765224);
      paramArrayOfByte = null;
      localObject1 = z.b(((x)localObject1).DEv);
      if (!bt.isNullOrNil((String)localObject1)) {}
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          paramArrayOfByte = paramq;
          try
          {
            this.error_detail_url = ((JSONObject)localObject1).optString("error_detail_url");
            paramArrayOfByte = paramq;
            paramInt1 = ((JSONObject)localObject1).getInt("retcode");
            paramArrayOfByte = paramq;
            paramq = ((JSONObject)localObject1).optString("retmsg");
            paramArrayOfByte = paramq;
            this.payFlag = ((JSONObject)localObject1).optString("pay_flag");
            paramArrayOfByte = paramq;
            this.payAppUrl = ((JSONObject)localObject1).optString("return_url");
            paramArrayOfByte = paramq;
            this.wappay_jumped_url = ((JSONObject)localObject1).optString("wappay_jumped_url");
            paramArrayOfByte = paramq;
            this.is_gen_cert = ((JSONObject)localObject1).optInt("is_gen_cert");
            paramArrayOfByte = paramq;
            this.crt_token = ((JSONObject)localObject1).optString("crt_token");
            paramArrayOfByte = paramq;
            this.is_hint_cert = ((JSONObject)localObject1).optInt("is_hint_crt");
            paramArrayOfByte = paramq;
            Object localObject2 = ((JSONObject)localObject1).optJSONObject("crt_wording");
            if (localObject2 != null)
            {
              paramArrayOfByte = paramq;
              this.crt_wording = ((JSONObject)localObject2).toString();
              paramArrayOfByte = paramq;
              this.is_ignore_cert = ((JSONObject)localObject1).optInt("is_ignore_crt");
              paramArrayOfByte = paramq;
              if (((JSONObject)localObject1).optInt("del_cert", 0) != 0)
              {
                paramArrayOfByte = paramq;
                ad.fkc();
                paramArrayOfByte = paramq;
                localObject2 = ad.getCrtNo();
                paramArrayOfByte = paramq;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetScenePayBase", "clean token %s", new Object[] { localObject2 });
                paramArrayOfByte = paramq;
                ad.fkc().aNb((String)localObject2);
              }
              paramArrayOfByte = paramq;
              this.jumpRemind = m.bz((JSONObject)localObject1);
              paramArrayOfByte = paramq;
              this.hasRevServerRep = true;
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = str1;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetScenePayBase", "tenpayResp: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[] { Integer.valueOf(getType()), Integer.valueOf(getPayCgicmd()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(i), str2, Integer.valueOf(j), localObject1, Integer.valueOf(paramInt1), paramq, paramArrayOfByte, toString() });
              paramString = getRetModel(paramInt2, paramInt3, paramString, i, str2, j, (String)localObject1, paramInt1, paramq);
              reportCellInfo(paramInt2, paramInt3);
              if (paramArrayOfByte == null) {
                continue;
              }
              if (((paramString.errType != 0) || (paramString.errCode != 0)) && (!shouldResolveJsonWhenError())) {
                continue;
              }
              onRawGYNetEnd(paramString, paramArrayOfByte);
              onRawGYNetEndFuck2(paramString, paramArrayOfByte);
              if (!this.isChildConsume) {
                continue;
              }
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
              return;
            }
            paramArrayOfByte = paramq;
            this.crt_wording = "";
            continue;
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetScenePayBase", "hy: json resolve error: error when resolving error code : " + localException1.toString());
          }
          catch (Exception localException1)
          {
            paramq = paramArrayOfByte;
            paramArrayOfByte = (byte[])localObject1;
          }
        }
        catch (Exception localException2)
        {
          paramArrayOfByte = null;
          continue;
        }
        paramInt1 = -10089;
        localObject1 = aj.getContext().getString(2131765337);
        continue;
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetScenePayBase", "hy: respString is null");
        localObject1 = localException1;
        continue;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
        continue;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
        continue;
        this.callback.onSceneEnd(paramString.errType, paramString.errCode, paramString.errMsg, this);
        return;
      }
    }
  }
  
  public abstract void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public void onGYNetEnd2(e parame, JSONObject paramJSONObject) {}
  
  public void onRawGYNetEnd(e parame, JSONObject paramJSONObject)
  {
    onGYNetEnd(parame.errCode, parame.errMsg, paramJSONObject);
  }
  
  public void onRawGYNetEndFuck2(e parame, JSONObject paramJSONObject)
  {
    onGYNetEnd2(parame, paramJSONObject);
  }
  
  public abstract void putToReqText(com.tencent.mm.al.b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t);
  
  public void putToRequest(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(paramString);
  }
  
  public abstract void putToWXReqText(com.tencent.mm.al.b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t);
  
  public void reportCellInfo(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {}
    try
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetScenePayBase", "errType is OK, reportCellInfo do nothing");
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetScenePayBase", "reportCellInfo error. %s", new Object[] { localException.getMessage() });
      return;
    }
    if (!k.shouldReportCellInfo())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetScenePayBase", "shouldReportCellInfo is false, reportCellInfo do nothing");
      return;
    }
    Object localObject1 = k.ebS();
    if ((localObject1 != null) && (!bt.isNullOrNil(((az)localObject1).Cvi)) && (!bt.isNullOrNil(((az)localObject1).Cvj)))
    {
      int i = getPayCgicmd();
      String str7 = ((az)localObject1).Cvi;
      String str8 = ((az)localObject1).Cvh;
      String str9 = ((az)localObject1).Cvj;
      if (!bt.isNullOrNil(str9))
      {
        int j = str9.length();
        localObject1 = "";
        String str6 = "";
        String str5 = "";
        String str4 = "";
        Object localObject3 = "";
        String str1;
        String str2;
        String str3;
        Object localObject2;
        if (j > 5000)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetScenePayBase", "reportCellInfo. cell info is too long to report");
          str1 = str6;
          str2 = str5;
          str3 = str4;
          localObject2 = localObject3;
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetScenePayBase", "reportCellInfo do report");
          localObject3 = new p();
          ((p)localObject3).dHR = i;
          ((p)localObject3).dHS = paramInt1;
          ((p)localObject3).dHT = paramInt2;
          ((p)localObject3).dHU = ((p)localObject3).t("EncryptKey", str7, true);
          ((p)localObject3).dHV = ((p)localObject3).t("EncryptUserinfo", str8, true);
          ((p)localObject3).dHW = ((p)localObject3).t("EncryptCellinfoLength", String.valueOf(j), true);
          ((p)localObject3).dHX = ((p)localObject3).t("EncryptCellinfo_01", (String)localObject1, true);
          ((p)localObject3).dHY = ((p)localObject3).t("EncryptCellinfo_02", str1, true);
          ((p)localObject3).dHZ = ((p)localObject3).t("EncryptCellinfo_03", str2, true);
          ((p)localObject3).dIa = ((p)localObject3).t("EncryptCellinfo_04", str3, true);
          ((p)localObject3).dIb = ((p)localObject3).t("EncryptCellinfo_05", (String)localObject2, true);
          ((p)localObject3).aBj();
          return;
          if (j > 4000)
          {
            localObject1 = str9.substring(0, 1000);
            str1 = str9.substring(1000, 2000);
            str2 = str9.substring(2000, 3000);
            str3 = str9.substring(3000, 4000);
            localObject2 = str9.substring(4000, j);
          }
          else if (j > 3000)
          {
            localObject1 = str9.substring(0, 1000);
            str1 = str9.substring(1000, 2000);
            str2 = str9.substring(2000, 3000);
            str3 = str9.substring(3000, j);
            localObject2 = localObject3;
          }
          else if (j > 2000)
          {
            localObject1 = str9.substring(0, 1000);
            str1 = str9.substring(1000, 2000);
            str2 = str9.substring(2000, j);
            localObject2 = localObject3;
            str3 = str4;
          }
          else if (j > 1000)
          {
            localObject1 = str9.substring(0, 1000);
            str1 = str9.substring(1000, j);
            localObject2 = localObject3;
            str3 = str4;
            str2 = str5;
          }
          else
          {
            localObject2 = localObject3;
            str3 = str4;
            str2 = str5;
            str1 = str6;
            if (j > 0)
            {
              localObject1 = str9.substring(0, j);
              localObject2 = localObject3;
              str3 = str4;
              str2 = str5;
              str1 = str6;
            }
          }
        }
      }
    }
  }
  
  public boolean resend()
  {
    reset();
    return false;
  }
  
  public void setCommReqResp(com.tencent.mm.al.b paramb)
  {
    this.rr = paramb;
  }
  
  public void setHasProcessWalletError(boolean paramBoolean)
  {
    this.hasProcessWalletError = paramBoolean;
  }
  
  public void setPayInfo(PayInfo paramPayInfo, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    setPayInfo(paramPayInfo, paramMap1, paramMap2, false);
  }
  
  public void setPayInfo(PayInfo paramPayInfo, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    Object localObject = paramMap2;
    if (paramMap2 == null) {
      localObject = new HashMap();
    }
    if (paramPayInfo == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetScenePayBase", "Cmd : " + getPayCgicmd() + ", payInfo is null");
      ((Map)localObject).put("devicename", Build.MODEL);
      setWXRequestData((Map)localObject);
      return;
    }
    paramMap1.put("req_key", paramPayInfo.dcE);
    paramMap1.put("partner_id", paramPayInfo.partnerId);
    paramMap1.put("pay_sign", paramPayInfo.dCx);
    if (paramPayInfo.Cov >= 0) {
      paramMap1.put("auto_deduct_flag", paramPayInfo.Cov);
    }
    if (paramPayInfo.dtb > 0) {
      paramMap1.put("pay_scene", paramPayInfo.dtb);
    }
    if (paramPayInfo.dtc >= 0) {
      paramMap1.put("bindbankscene", paramPayInfo.dtc);
    }
    if (!bt.isNullOrNil(paramPayInfo.Cow)) {
      paramMap1.put("deduct_bank_type", paramPayInfo.Cow);
    }
    if (!bt.isNullOrNil(paramPayInfo.Cox)) {
      paramMap1.put("deduct_bind_serial", paramPayInfo.Cox);
    }
    if (paramBoolean) {
      paramMap1.put("use_touch", "0");
    }
    for (;;)
    {
      paramMap1.put("fp_identify_num", paramPayInfo.ApX);
      if (!TextUtils.isEmpty(paramPayInfo.dlK)) {
        paramMap1.put("encrypted_pay_info", URLEncoder.encode(paramPayInfo.dlK));
      }
      if (!TextUtils.isEmpty(paramPayInfo.dlL)) {
        paramMap1.put("encrypted_rsa_sign", URLEncoder.encode(paramPayInfo.dlL));
      }
      ((Map)localObject).put("uuid", paramPayInfo.uuid);
      ((Map)localObject).put("appid", paramPayInfo.appId);
      ((Map)localObject).put("appsource", paramPayInfo.Axg);
      ((Map)localObject).put("channel", paramPayInfo.channel);
      ((Map)localObject).put("devicename", Build.MODEL);
      ((Map)localObject).put("soter_req", paramPayInfo.dsE);
      return;
      paramMap1.put("use_touch", paramPayInfo.ApW);
    }
  }
  
  public void setRequestData(Map<String, String> paramMap)
  {
    Object localObject1 = paramMap;
    if (paramMap == null) {
      localObject1 = new HashMap();
    }
    if (localObject1 != null) {
      ((Map)localObject1).remove("uin");
    }
    if (!com.tencent.mm.pluginsdk.wallet.e.eBc()) {
      ((Map)localObject1).put("jsapi_reqkey", com.tencent.mm.pluginsdk.wallet.e.eBd());
    }
    this._request = ((Map)localObject1);
    configRequest(true, true);
    paramMap = (String)((Map)localObject1).get("req_key");
    getCommReqResp().getReqObj().setRouteInfo(com.tencent.mm.wallet_core.ui.e.aNn(paramMap));
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      paramMap = ((Map)localObject1).keySet().toArray();
      Arrays.sort(paramMap);
      localStringBuilder = new StringBuilder();
      int i = 0;
      int k;
      for (int j = 0; i < paramMap.length; j = k)
      {
        Object localObject2 = paramMap[i];
        String str = (String)((Map)localObject1).get(localObject2);
        k = j;
        if (!bt.isNullOrNil(str))
        {
          if (j != 0) {
            localStringBuilder.append("&");
          }
          localStringBuilder.append(localObject2);
          localStringBuilder.append("=");
          putToRequest(localStringBuilder, str);
          k = 1;
        }
        i += 1;
      }
      if (!com.tencent.mm.sdk.a.b.eEQ()) {
        break label418;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetScenePayBase", "RQ: Cmd : " + getPayCgicmd() + ", req = " + localStringBuilder.toString() + " " + toString() + " " + bt.eGN().toString());
      localObject1 = getEncryptUrl(localStringBuilder.toString());
      if (j == 0) {
        break label473;
      }
    }
    label418:
    label473:
    for (paramMap = "&";; paramMap = "")
    {
      localStringBuilder.append(paramMap);
      localStringBuilder.append("WCPaySign");
      localStringBuilder.append("=");
      localStringBuilder.append((String)localObject1);
      paramMap = localStringBuilder.toString().getBytes();
      paramMap = new SKBuiltinBuffer_t().setBuffer(paramMap);
      putToReqText(this.rr, paramMap);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetScenePayBase", "setRequestData getPayCgicmd: %s type: %s this: %s cgi %s ", new Object[] { Integer.valueOf(getPayCgicmd()), Integer.valueOf(getType()), toString(), this.rr.getUri() });
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetScenePayBase", "RQ: Cmd : " + getPayCgicmd() + ", req = " + localStringBuilder.toString() + " " + toString());
      break;
    }
  }
  
  public void setWXRequestData(Map<String, String> paramMap)
  {
    configRequest(false, false);
    if (paramMap != null)
    {
      Object localObject1 = k.ebS();
      if (localObject1 != null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetScenePayBase", "location found");
        paramMap.put("province", ((az)localObject1).evz);
        if (!paramMap.containsKey("city")) {
          paramMap.put("city", ((az)localObject1).evA);
        }
        paramMap.put("location_timestamp", ((az)localObject1).Cve);
        paramMap.put("encrypt_key", ((az)localObject1).Cvi);
        paramMap.put("encrypt_userinfo", ((az)localObject1).Cvh);
        if (k.shouldReportCellInfo()) {
          paramMap.put("encrypt_cellinfo", ((az)localObject1).Cvj);
        }
      }
      localObject1 = paramMap.keySet().toArray();
      Arrays.sort((Object[])localObject1);
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      int k;
      for (int j = 0; i < localObject1.length; j = k)
      {
        Object localObject2 = localObject1[i];
        String str = (String)paramMap.get(localObject2);
        k = j;
        if (!bt.isNullOrNil(str))
        {
          if (j != 0) {
            localStringBuilder.append("&");
          }
          localStringBuilder.append(localObject2);
          localStringBuilder.append("=");
          localStringBuilder.append(str);
          k = 1;
        }
        i += 1;
      }
      if (com.tencent.mm.sdk.a.b.eEQ()) {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetScenePayBase", "Cmd : " + getPayCgicmd() + ", wxreq = " + localStringBuilder.toString());
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetScenePayBase", "wxreq: " + localStringBuilder.toString());
      paramMap = localStringBuilder.toString().getBytes();
      paramMap = new SKBuiltinBuffer_t().setBuffer(paramMap);
      putToWXReqText(this.rr, paramMap);
    }
  }
  
  public boolean shouldResolveJsonWhenError()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.s
 * JD-Core Version:    0.7.0.1
 */