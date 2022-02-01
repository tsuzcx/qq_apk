package com.tencent.mm.wallet_core.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mm.ak.g;
import com.tencent.mm.g.b.a.p;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
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
  protected com.tencent.mm.ak.b rr;
  private String wappay_jumped_url = "";
  
  public static e getRetModel(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4, String paramString3, int paramInt5, String paramString4)
  {
    e locale = new e(paramInt1, paramInt2, paramString1);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramInt3 != 0)
      {
        ac.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: plat ret is error");
        locale.e(1000, paramInt3, paramString2, 1);
        return locale;
      }
      if (paramInt4 != 0)
      {
        ac.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: errType is error");
        locale.e(1000, paramInt4, paramString3, 2);
        return locale;
      }
      if (paramInt5 != 0)
      {
        ac.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: retCode is error");
        if ((paramInt5 != -10089) && (paramInt5 != -10088))
        {
          locale.e(1000, paramInt5, paramString4, 2);
          return locale;
        }
        locale.e(1000, 2, paramString4, 2);
        return locale;
      }
      if (!bs.isNullOrNil(paramString3))
      {
        ac.i("MicroMsg.NetScenePayBase", "finModel.errMsg = biz_errMsg");
        locale.errMsg = paramString3;
      }
      ac.i("MicroMsg.NetScenePayBase", "hy: all's OK");
      return locale;
    }
    getRetModel(paramInt1, paramInt2, paramString1, locale);
    return locale;
  }
  
  public static void getRetModel(int paramInt1, int paramInt2, String paramString, e parame)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
      paramString = bv.L(paramString, "e");
      if (paramString != null)
      {
        ac.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
        parame.errMsg = ((String)paramString.get(".e.Content"));
      }
    }
    else
    {
      return;
    }
    if ((paramInt2 == -1) || (paramInt2 == -500))
    {
      ac.w("MicroMsg.NetScenePayBase", "hy: network error");
      parame.errMsg = ai.getContext().getString(2131765520);
      return;
    }
    ac.w("MicroMsg.NetScenePayBase", "hy: unknown system error");
    parame.errMsg = ai.getContext().getString(2131765224);
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
  
  public abstract int doSceneSimulately(com.tencent.mm.ak.b paramb, com.tencent.mm.network.e parame, g paramg);
  
  public int getCgicmdForKV()
  {
    return getPayCgicmd();
  }
  
  public com.tencent.mm.ak.b getCommReqResp()
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
  
  public abstract x getRetModel(com.tencent.mm.ak.b paramb);
  
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
    if ((ab.iwD) && (1686 == getPayCgicmd()))
    {
      paramInt3 = -1;
      paramInt2 = 3;
    }
    for (;;)
    {
      ac.i("MicroMsg.NetScenePayBase", "cgi: %d, rrType %d, rrCgi %s, PayCgicmd %s, errType %d, errCode %d, errMsg %s, this: %s ", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramq.getType()), paramq.getUri(), Integer.valueOf(getPayCgicmd()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, toString() });
      Object localObject1 = getRetModel((com.tencent.mm.ak.b)paramq);
      int i = ((x)localObject1).EZR;
      String str2 = ((x)localObject1).EZS;
      int j = ((x)localObject1).JFt;
      String str1 = ((x)localObject1).pAH;
      paramInt1 = -10088;
      paramq = ai.getContext().getString(2131765224);
      paramArrayOfByte = null;
      localObject1 = z.b(((x)localObject1).EZQ);
      if (!bs.isNullOrNil((String)localObject1)) {}
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
                ad.fAs();
                paramArrayOfByte = paramq;
                localObject2 = ad.getCrtNo();
                paramArrayOfByte = paramq;
                ac.i("MicroMsg.NetScenePayBase", "clean token %s", new Object[] { localObject2 });
                paramArrayOfByte = paramq;
                ad.fAs().aSE((String)localObject2);
              }
              paramArrayOfByte = paramq;
              this.jumpRemind = m.bA((JSONObject)localObject1);
              paramArrayOfByte = paramq;
              this.hasRevServerRep = true;
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = str1;
              ac.i("MicroMsg.NetScenePayBase", "tenpayResp: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[] { Integer.valueOf(getType()), Integer.valueOf(getPayCgicmd()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(i), str2, Integer.valueOf(j), localObject1, Integer.valueOf(paramInt1), paramq, paramArrayOfByte, toString() });
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
              ac.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
              return;
            }
            paramArrayOfByte = paramq;
            this.crt_wording = "";
            continue;
            ac.w("MicroMsg.NetScenePayBase", "hy: json resolve error: error when resolving error code : " + localException1.toString());
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
        localObject1 = ai.getContext().getString(2131765337);
        continue;
        ac.w("MicroMsg.NetScenePayBase", "hy: respString is null");
        localObject1 = localException1;
        continue;
        ac.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
        continue;
        ac.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
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
  
  public abstract void putToReqText(com.tencent.mm.ak.b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t);
  
  public void putToRequest(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(paramString);
  }
  
  public abstract void putToWXReqText(com.tencent.mm.ak.b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t);
  
  public void reportCellInfo(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {}
    try
    {
      ac.e("MicroMsg.NetScenePayBase", "errType is OK, reportCellInfo do nothing");
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.NetScenePayBase", "reportCellInfo error. %s", new Object[] { localException.getMessage() });
      return;
    }
    if (!k.shouldReportCellInfo())
    {
      ac.e("MicroMsg.NetScenePayBase", "shouldReportCellInfo is false, reportCellInfo do nothing");
      return;
    }
    Object localObject1 = k.ero();
    if ((localObject1 != null) && (!bs.isNullOrNil(((bb)localObject1).DND)) && (!bs.isNullOrNil(((bb)localObject1).DNE)))
    {
      int i = getPayCgicmd();
      String str7 = ((bb)localObject1).DND;
      String str8 = ((bb)localObject1).DNC;
      String str9 = ((bb)localObject1).DNE;
      if (!bs.isNullOrNil(str9))
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
          ac.e("MicroMsg.NetScenePayBase", "reportCellInfo. cell info is too long to report");
          str1 = str6;
          str2 = str5;
          str3 = str4;
          localObject2 = localObject3;
        }
        for (;;)
        {
          ac.e("MicroMsg.NetScenePayBase", "reportCellInfo do report");
          localObject3 = new p();
          ((p)localObject3).dFE = i;
          ((p)localObject3).dFF = paramInt1;
          ((p)localObject3).dFG = paramInt2;
          ((p)localObject3).dFH = ((p)localObject3).t("EncryptKey", str7, true);
          ((p)localObject3).dFI = ((p)localObject3).t("EncryptUserinfo", str8, true);
          ((p)localObject3).dFJ = ((p)localObject3).t("EncryptCellinfoLength", String.valueOf(j), true);
          ((p)localObject3).dFK = ((p)localObject3).t("EncryptCellinfo_01", (String)localObject1, true);
          ((p)localObject3).dFL = ((p)localObject3).t("EncryptCellinfo_02", str1, true);
          ((p)localObject3).dFM = ((p)localObject3).t("EncryptCellinfo_03", str2, true);
          ((p)localObject3).dFN = ((p)localObject3).t("EncryptCellinfo_04", str3, true);
          ((p)localObject3).dFO = ((p)localObject3).t("EncryptCellinfo_05", (String)localObject2, true);
          ((p)localObject3).aHZ();
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
  
  public void setCommReqResp(com.tencent.mm.ak.b paramb)
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
      ac.e("MicroMsg.NetScenePayBase", "Cmd : " + getPayCgicmd() + ", payInfo is null");
      ((Map)localObject).put("devicename", Build.MODEL);
      setWXRequestData((Map)localObject);
      return;
    }
    paramMap1.put("req_key", paramPayInfo.dac);
    paramMap1.put("partner_id", paramPayInfo.partnerId);
    paramMap1.put("pay_sign", paramPayInfo.dAj);
    if (paramPayInfo.DGN >= 0) {
      paramMap1.put("auto_deduct_flag", paramPayInfo.DGN);
    }
    if (paramPayInfo.dqL > 0) {
      paramMap1.put("pay_scene", paramPayInfo.dqL);
    }
    if (paramPayInfo.dqM >= 0) {
      paramMap1.put("bindbankscene", paramPayInfo.dqM);
    }
    if (!bs.isNullOrNil(paramPayInfo.DGO)) {
      paramMap1.put("deduct_bank_type", paramPayInfo.DGO);
    }
    if (!bs.isNullOrNil(paramPayInfo.DGP)) {
      paramMap1.put("deduct_bind_serial", paramPayInfo.DGP);
    }
    if (paramBoolean) {
      paramMap1.put("use_touch", "0");
    }
    for (;;)
    {
      paramMap1.put("fp_identify_num", paramPayInfo.BIr);
      if (!TextUtils.isEmpty(paramPayInfo.djs)) {
        paramMap1.put("encrypted_pay_info", URLEncoder.encode(paramPayInfo.djs));
      }
      if (!TextUtils.isEmpty(paramPayInfo.djt)) {
        paramMap1.put("encrypted_rsa_sign", URLEncoder.encode(paramPayInfo.djt));
      }
      ((Map)localObject).put("uuid", paramPayInfo.uuid);
      ((Map)localObject).put("appid", paramPayInfo.appId);
      ((Map)localObject).put("appsource", paramPayInfo.BPA);
      ((Map)localObject).put("channel", paramPayInfo.channel);
      ((Map)localObject).put("devicename", Build.MODEL);
      ((Map)localObject).put("soter_req", paramPayInfo.dqo);
      return;
      paramMap1.put("use_touch", paramPayInfo.BIq);
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
    if (!com.tencent.mm.pluginsdk.wallet.e.eQw()) {
      ((Map)localObject1).put("jsapi_reqkey", com.tencent.mm.pluginsdk.wallet.e.eQx());
    }
    this._request = ((Map)localObject1);
    configRequest(true, true);
    paramMap = (String)((Map)localObject1).get("req_key");
    getCommReqResp().getReqObj().setRouteInfo(com.tencent.mm.wallet_core.ui.e.aSQ(paramMap));
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
        if (!bs.isNullOrNil(str))
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
      if (!com.tencent.mm.sdk.a.b.eUk()) {
        break label418;
      }
      ac.i("MicroMsg.NetScenePayBase", "RQ: Cmd : " + getPayCgicmd() + ", req = " + localStringBuilder.toString() + " " + toString() + " " + bs.eWi().toString());
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
      ac.i("MicroMsg.NetScenePayBase", "setRequestData getPayCgicmd: %s type: %s this: %s cgi %s ", new Object[] { Integer.valueOf(getPayCgicmd()), Integer.valueOf(getType()), toString(), this.rr.getUri() });
      return;
      ac.i("MicroMsg.NetScenePayBase", "RQ: Cmd : " + getPayCgicmd() + ", req = " + localStringBuilder.toString() + " " + toString());
      break;
    }
  }
  
  public void setWXRequestData(Map<String, String> paramMap)
  {
    configRequest(false, false);
    if (paramMap != null)
    {
      Object localObject1 = k.ero();
      if (localObject1 != null)
      {
        ac.i("MicroMsg.NetScenePayBase", "location found");
        paramMap.put("province", ((bb)localObject1).exV);
        if (!paramMap.containsKey("city")) {
          paramMap.put("city", ((bb)localObject1).exW);
        }
        paramMap.put("location_timestamp", ((bb)localObject1).DNz);
        paramMap.put("encrypt_key", ((bb)localObject1).DND);
        paramMap.put("encrypt_userinfo", ((bb)localObject1).DNC);
        if (k.shouldReportCellInfo()) {
          paramMap.put("encrypt_cellinfo", ((bb)localObject1).DNE);
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
        if (!bs.isNullOrNil(str))
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
      if (com.tencent.mm.sdk.a.b.eUk()) {
        ac.d("MicroMsg.NetScenePayBase", "Cmd : " + getPayCgicmd() + ", wxreq = " + localStringBuilder.toString());
      }
      ac.d("MicroMsg.NetScenePayBase", "wxreq: " + localStringBuilder.toString());
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