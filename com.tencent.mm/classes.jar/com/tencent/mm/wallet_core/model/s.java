package com.tencent.mm.wallet_core.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.am.c;
import com.tencent.mm.am.h;
import com.tencent.mm.autogen.mmdata.rpt.aw;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.network.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.wallet_core.ui.i;
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
  protected h callback;
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
  protected c rr;
  private String wappay_jumped_url = "";
  
  public static e getRetModel(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4, String paramString3, int paramInt5, String paramString4)
  {
    e locale = new e(paramInt1, paramInt2, paramString1);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramInt3 != 0)
      {
        Log.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: plat ret is error");
        locale.g(1000, paramInt3, paramString2, 1);
        return locale;
      }
      if (paramInt4 != 0)
      {
        Log.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: errType is error");
        locale.g(1000, paramInt4, paramString3, 2);
        return locale;
      }
      if (paramInt5 != 0)
      {
        Log.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: retCode is error");
        if ((paramInt5 != -10089) && (paramInt5 != -10088))
        {
          locale.g(1000, paramInt5, paramString4, 2);
          return locale;
        }
        locale.g(1000, 2, paramString4, 2);
        return locale;
      }
      if (!Util.isNullOrNil(paramString3))
      {
        Log.i("MicroMsg.NetScenePayBase", "finModel.errMsg = biz_errMsg");
        locale.errMsg = paramString3;
      }
      Log.i("MicroMsg.NetScenePayBase", "hy: all's OK");
      return locale;
    }
    getRetModel(paramInt1, paramInt2, paramString1, locale);
    return locale;
  }
  
  public static void getRetModel(int paramInt1, int paramInt2, String paramString, e parame)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
      paramString = XmlParser.parseXml(paramString, "e", null);
      if (paramString != null)
      {
        Log.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
        parame.errMsg = ((String)paramString.get(".e.Content"));
      }
    }
    else
    {
      return;
    }
    if ((paramInt2 == -1) || (paramInt2 == -500))
    {
      Log.w("MicroMsg.NetScenePayBase", "hy: network error");
      parame.errMsg = MMApplicationContext.getContext().getString(a.i.wallet_net_err);
      return;
    }
    Log.w("MicroMsg.NetScenePayBase", "hy: unknown system error");
    parame.errMsg = MMApplicationContext.getContext().getString(a.i.wallet_data_err);
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
  
  public abstract int doSceneSimulately(c paramc, g paramg, h paramh);
  
  public int getCgicmdForKV()
  {
    return getPayCgicmd();
  }
  
  public c getCommReqResp()
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
  
  public abstract x getRetModel(c paramc);
  
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
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte, long paramLong)
  {
    this.SVR_ERR_TYPE = paramInt2;
    this.SVR_ERR_CODE = paramInt3;
    if ((z.pDj) && (1686 == getPayCgicmd()))
    {
      paramInt3 = -1;
      paramInt2 = 3;
    }
    for (;;)
    {
      Log.i("MicroMsg.NetScenePayBase", "cgi: %d, rrType %d, rrCgi %s, PayCgicmd %s, errType %d, errCode %d, errMsg %s, this: %s ", new Object[] { Integer.valueOf(getType()), Integer.valueOf(params.getType()), params.getUri(), Integer.valueOf(getPayCgicmd()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, toString() });
      Object localObject1 = getRetModel((c)params);
      int i = ((x)localObject1).aaFT;
      String str2 = ((x)localObject1).aaFU;
      int j = ((x)localObject1).agTv;
      String str1 = ((x)localObject1).ytw;
      paramInt1 = -10088;
      params = MMApplicationContext.getContext().getString(a.i.wallet_data_err);
      paramArrayOfByte = null;
      localObject1 = com.tencent.mm.platformtools.w.b(((x)localObject1).aaFS);
      if (!Util.isNullOrNil((String)localObject1)) {}
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          paramArrayOfByte = params;
          try
          {
            this.error_detail_url = ((JSONObject)localObject1).optString("error_detail_url");
            paramArrayOfByte = params;
            paramInt1 = ((JSONObject)localObject1).getInt("retcode");
            paramArrayOfByte = params;
            params = ((JSONObject)localObject1).optString("retmsg");
            paramArrayOfByte = params;
            this.payFlag = ((JSONObject)localObject1).optString("pay_flag");
            paramArrayOfByte = params;
            this.payAppUrl = ((JSONObject)localObject1).optString("return_url");
            paramArrayOfByte = params;
            this.wappay_jumped_url = ((JSONObject)localObject1).optString("wappay_jumped_url");
            paramArrayOfByte = params;
            this.is_gen_cert = ((JSONObject)localObject1).optInt("is_gen_cert");
            paramArrayOfByte = params;
            this.crt_token = ((JSONObject)localObject1).optString("crt_token");
            paramArrayOfByte = params;
            this.is_hint_cert = ((JSONObject)localObject1).optInt("is_hint_crt");
            paramArrayOfByte = params;
            Object localObject2 = ((JSONObject)localObject1).optJSONObject("crt_wording");
            if (localObject2 != null)
            {
              paramArrayOfByte = params;
              this.crt_wording = ((JSONObject)localObject2).toString();
              paramArrayOfByte = params;
              this.is_ignore_cert = ((JSONObject)localObject1).optInt("is_ignore_crt");
              paramArrayOfByte = params;
              if (((JSONObject)localObject1).optInt("del_cert", 0) != 0)
              {
                paramArrayOfByte = params;
                ae.jOT();
                paramArrayOfByte = params;
                localObject2 = ae.getCrtNo();
                paramArrayOfByte = params;
                Log.i("MicroMsg.NetScenePayBase", "clean token %s", new Object[] { localObject2 });
                paramArrayOfByte = params;
                ae.jOT().bEG((String)localObject2);
              }
              paramArrayOfByte = params;
              this.jumpRemind = m.cP((JSONObject)localObject1);
              paramArrayOfByte = params;
              this.hasRevServerRep = true;
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = str1;
              Log.i("MicroMsg.NetScenePayBase", "tenpayResp: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[] { Integer.valueOf(getType()), Integer.valueOf(getPayCgicmd()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(i), str2, Integer.valueOf(j), localObject1, Integer.valueOf(paramInt1), params, paramArrayOfByte, toString() });
              paramString = getRetModel(paramInt2, paramInt3, paramString, i, str2, j, (String)localObject1, paramInt1, params);
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
              Log.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
              return;
            }
            paramArrayOfByte = params;
            this.crt_wording = "";
            continue;
            Log.w("MicroMsg.NetScenePayBase", "hy: json resolve error: error when resolving error code : " + localException1.toString());
          }
          catch (Exception localException1)
          {
            params = paramArrayOfByte;
            paramArrayOfByte = (byte[])localObject1;
          }
        }
        catch (Exception localException2)
        {
          paramArrayOfByte = null;
          continue;
        }
        paramInt1 = -10089;
        localObject1 = MMApplicationContext.getContext().getString(a.i.wallet_json_err);
        continue;
        Log.w("MicroMsg.NetScenePayBase", "hy: respString is null");
        localObject1 = localException1;
        continue;
        Log.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
        continue;
        Log.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
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
  
  public abstract void putToReqText(c paramc, gol paramgol);
  
  public void putToRequest(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(paramString);
  }
  
  public abstract void putToWXReqText(c paramc, gol paramgol);
  
  public void reportCellInfo(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {}
    try
    {
      Log.e("MicroMsg.NetScenePayBase", "errType is OK, reportCellInfo do nothing");
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NetScenePayBase", "reportCellInfo error. %s", new Object[] { localException.getMessage() });
      return;
    }
    if (!k.shouldReportCellInfo())
    {
      Log.e("MicroMsg.NetScenePayBase", "shouldReportCellInfo is false, reportCellInfo do nothing");
      return;
    }
    Object localObject1 = k.iis();
    if ((localObject1 != null) && (!Util.isNullOrNil(((bi)localObject1).YCM)) && (!Util.isNullOrNil(((bi)localObject1).YCN)))
    {
      int i = getPayCgicmd();
      String str7 = ((bi)localObject1).YCM;
      String str8 = ((bi)localObject1).YCL;
      String str9 = ((bi)localObject1).YCN;
      if (!Util.isNullOrNil(str9))
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
          Log.e("MicroMsg.NetScenePayBase", "reportCellInfo. cell info is too long to report");
          str1 = str6;
          str2 = str5;
          str3 = str4;
          localObject2 = localObject3;
        }
        for (;;)
        {
          Log.e("MicroMsg.NetScenePayBase", "reportCellInfo do report");
          localObject3 = new aw();
          ((aw)localObject3).ipI = i;
          ((aw)localObject3).ipJ = paramInt1;
          ((aw)localObject3).ipK = paramInt2;
          ((aw)localObject3).ipL = ((aw)localObject3).F("EncryptKey", str7, true);
          ((aw)localObject3).ipM = ((aw)localObject3).F("EncryptUserinfo", str8, true);
          ((aw)localObject3).ipN = ((aw)localObject3).F("EncryptCellinfoLength", String.valueOf(j), true);
          ((aw)localObject3).ipO = ((aw)localObject3).F("EncryptCellinfo_01", (String)localObject1, true);
          ((aw)localObject3).ipP = ((aw)localObject3).F("EncryptCellinfo_02", str1, true);
          ((aw)localObject3).ipQ = ((aw)localObject3).F("EncryptCellinfo_03", str2, true);
          ((aw)localObject3).ipR = ((aw)localObject3).F("EncryptCellinfo_04", str3, true);
          ((aw)localObject3).ipS = ((aw)localObject3).F("EncryptCellinfo_05", (String)localObject2, true);
          ((aw)localObject3).bMH();
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
  
  public void setCommReqResp(c paramc)
  {
    this.rr = paramc;
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
      Log.e("MicroMsg.NetScenePayBase", "Cmd : " + getPayCgicmd() + ", payInfo is null");
      ((Map)localObject).put("devicename", q.aPo());
      setWXRequestData((Map)localObject);
      return;
    }
    paramMap1.put("req_key", paramPayInfo.hAT);
    paramMap1.put("partner_id", paramPayInfo.partnerId);
    paramMap1.put("pay_sign", paramPayInfo.hPe);
    if (paramPayInfo.YvI >= 0) {
      paramMap1.put("auto_deduct_flag", paramPayInfo.YvI);
    }
    if (paramPayInfo.hUR > 0) {
      paramMap1.put("pay_scene", paramPayInfo.hUR);
    }
    if (paramPayInfo.hUS >= 0) {
      paramMap1.put("bindbankscene", paramPayInfo.hUS);
    }
    if (!Util.isNullOrNil(paramPayInfo.YvJ)) {
      paramMap1.put("deduct_bank_type", paramPayInfo.YvJ);
    }
    if (!Util.isNullOrNil(paramPayInfo.YvK)) {
      paramMap1.put("deduct_bind_serial", paramPayInfo.YvK);
    }
    if (paramBoolean) {
      paramMap1.put("use_touch", "0");
    }
    for (;;)
    {
      paramMap1.put("fp_identify_num", paramPayInfo.VSw);
      if (!TextUtils.isEmpty(paramPayInfo.hMz)) {
        paramMap1.put("encrypted_pay_info", URLEncoder.encode(paramPayInfo.hMz));
      }
      if (!TextUtils.isEmpty(paramPayInfo.hMA)) {
        paramMap1.put("encrypted_rsa_sign", URLEncoder.encode(paramPayInfo.hMA));
      }
      ((Map)localObject).put("uuid", paramPayInfo.uuid);
      ((Map)localObject).put("appid", paramPayInfo.appId);
      ((Map)localObject).put("appsource", paramPayInfo.Wan);
      ((Map)localObject).put("channel", paramPayInfo.channel);
      ((Map)localObject).put("devicename", q.aPo());
      ((Map)localObject).put("soter_req", paramPayInfo.hUq);
      return;
      paramMap1.put("use_touch", paramPayInfo.VSv);
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
    if (!com.tencent.mm.pluginsdk.wallet.e.iOV()) {
      ((Map)localObject1).put("jsapi_reqkey", com.tencent.mm.pluginsdk.wallet.e.iOW());
    }
    this._request = ((Map)localObject1);
    configRequest(true, true);
    paramMap = (String)((Map)localObject1).get("req_key");
    getCommReqResp().getReqObj().setRouteInfo(i.bEV(paramMap));
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
        if (!Util.isNullOrNil(str))
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
      if (!CrashReportFactory.hasDebuger()) {
        break label418;
      }
      Log.i("MicroMsg.NetScenePayBase", "RQ: Cmd : " + getPayCgicmd() + ", req = " + localStringBuilder.toString() + " " + toString() + " " + Util.getStack().toString());
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
      paramMap = new gol().df(paramMap);
      putToReqText(this.rr, paramMap);
      Log.i("MicroMsg.NetScenePayBase", "setRequestData getPayCgicmd: %s type: %s this: %s cgi %s ", new Object[] { Integer.valueOf(getPayCgicmd()), Integer.valueOf(getType()), toString(), this.rr.getUri() });
      return;
      Log.i("MicroMsg.NetScenePayBase", "RQ: Cmd : " + getPayCgicmd() + ", req = " + localStringBuilder.toString() + " " + toString());
      break;
    }
  }
  
  public void setWXRequestData(Map<String, String> paramMap)
  {
    configRequest(false, false);
    if (paramMap != null)
    {
      Object localObject1 = k.iis();
      if (localObject1 != null)
      {
        Log.i("MicroMsg.NetScenePayBase", "location found");
        paramMap.put("province", ((bi)localObject1).province);
        if (!paramMap.containsKey("city")) {
          paramMap.put("city", ((bi)localObject1).city);
        }
        paramMap.put("location_timestamp", ((bi)localObject1).YCI);
        paramMap.put("encrypt_key", ((bi)localObject1).YCM);
        paramMap.put("encrypt_userinfo", ((bi)localObject1).YCL);
        if (k.shouldReportCellInfo()) {
          paramMap.put("encrypt_cellinfo", ((bi)localObject1).YCN);
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
        if (!Util.isNullOrNil(str))
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
      if (CrashReportFactory.hasDebuger()) {
        Log.d("MicroMsg.NetScenePayBase", "Cmd : " + getPayCgicmd() + ", wxreq = " + localStringBuilder.toString());
      }
      Log.d("MicroMsg.NetScenePayBase", "wxreq: " + localStringBuilder.toString());
      paramMap = localStringBuilder.toString().getBytes();
      paramMap = new gol().df(paramMap);
      putToWXReqText(this.rr, paramMap);
    }
  }
  
  public boolean shouldResolveJsonWhenError()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.s
 * JD-Core Version:    0.7.0.1
 */