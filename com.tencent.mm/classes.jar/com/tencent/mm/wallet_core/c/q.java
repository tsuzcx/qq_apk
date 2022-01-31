package com.tencent.mm.wallet_core.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class q
  extends u
{
  protected static final int ERR_RETCODE_JSON_RESOLVE_ERROR = -10089;
  private static final int ERR_RETCODE_NO_JSON = -10088;
  private static final String PAY_END = "1";
  private static final String TAG = "MicroMsg.NetScenePayBase";
  protected int SVR_ERR_CODE = 0;
  protected int SVR_ERR_TYPE = 0;
  private Map<String, String> _request = new HashMap();
  protected f callback;
  public String crt_token = "";
  public String crt_wording = "";
  protected String error_detail_url;
  private boolean hasProcessWalletError = false;
  public boolean hasRevServerRep = false;
  protected boolean isChildConsume = false;
  public int is_gen_cert = 0;
  public int is_hint_cert = 0;
  public int is_ignore_cert = 0;
  private k jumpRemind;
  private String payAppUrl = "";
  private String payFlag = "";
  protected com.tencent.mm.ai.b rr;
  private String wappay_jumped_url = "";
  
  public static d getRetModel(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4, String paramString3, int paramInt5, String paramString4)
  {
    d locald = new d(paramInt1, paramInt2, paramString1);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramInt3 != 0)
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: plat ret is error");
        locald.e(1000, paramInt3, paramString2, 1);
        return locald;
      }
      if (paramInt4 != 0)
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: errType is error");
        locald.e(1000, paramInt4, paramString3, 2);
        return locald;
      }
      if (paramInt5 != 0)
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: retCode is error");
        if ((paramInt5 != -10089) && (paramInt5 != -10088))
        {
          locald.e(1000, paramInt5, paramString4, 2);
          return locald;
        }
        locald.e(1000, 2, paramString4, 2);
        return locald;
      }
      if (!bo.isNullOrNil(paramString3))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetScenePayBase", "finModel.errMsg = biz_errMsg");
        locald.errMsg = paramString3;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetScenePayBase", "hy: all's OK");
      return locald;
    }
    getRetModel(paramInt1, paramInt2, paramString1, locald);
    return locald;
  }
  
  public static void getRetModel(int paramInt1, int paramInt2, String paramString, d paramd)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
      paramString = br.F(paramString, "e");
      if (paramString != null)
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
        paramd.errMsg = ((String)paramString.get(".e.Content"));
      }
    }
    else
    {
      return;
    }
    if ((paramInt2 == -1) || (paramInt2 == -500))
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetScenePayBase", "hy: network error");
      paramd.errMsg = ah.getContext().getString(2131305306);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetScenePayBase", "hy: unknown system error");
    paramd.errMsg = ah.getContext().getString(2131305032);
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
  
  public abstract int doSceneSimulately(com.tencent.mm.ai.b paramb, com.tencent.mm.network.e parame, f paramf);
  
  public int getCgicmdForKV()
  {
    return getPayCgicmd();
  }
  
  public com.tencent.mm.ai.b getCommReqResp()
  {
    return this.rr;
  }
  
  public abstract String getEncryptUrl(String paramString);
  
  public String getErrDetailUrl()
  {
    return this.error_detail_url;
  }
  
  public k getJumpRemind()
  {
    return this.jumpRemind;
  }
  
  public abstract int getPayCgicmd();
  
  public abstract v getRetModel(com.tencent.mm.ai.b paramb);
  
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
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    this.SVR_ERR_TYPE = paramInt2;
    this.SVR_ERR_CODE = paramInt3;
    if ((ae.glC) && (1686 == getPayCgicmd()))
    {
      paramInt3 = -1;
      paramInt2 = 3;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetScenePayBase", "cgi: %d, rrType %d, rrCgi %s, PayCgicmd %s, errType %d, errCode %d, errMsg %s, this: %s ", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramq.getType()), paramq.getUri(), Integer.valueOf(getPayCgicmd()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, toString() });
      Object localObject1 = getRetModel((com.tencent.mm.ai.b)paramq);
      int i = ((v)localObject1).xkM;
      String str2 = ((v)localObject1).xkN;
      int j = ((v)localObject1).AXe;
      String str1 = ((v)localObject1).lGL;
      paramInt1 = -10088;
      paramq = ah.getContext().getString(2131305032);
      paramArrayOfByte = null;
      localObject1 = aa.b(((v)localObject1).xkL);
      if (!bo.isNullOrNil((String)localObject1)) {}
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
                ab.dSv();
                paramArrayOfByte = paramq;
                localObject2 = ab.getCrtNo();
                paramArrayOfByte = paramq;
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetScenePayBase", "clean token %s", new Object[] { localObject2 });
                paramArrayOfByte = paramq;
                ab.dSv().avY((String)localObject2);
              }
              paramArrayOfByte = paramq;
              this.jumpRemind = k.aX((JSONObject)localObject1);
              paramArrayOfByte = paramq;
              this.hasRevServerRep = true;
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = str1;
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetScenePayBase", "tenpayResp: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[] { Integer.valueOf(getType()), Integer.valueOf(getPayCgicmd()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(i), str2, Integer.valueOf(j), localObject1, Integer.valueOf(paramInt1), paramq, paramArrayOfByte, toString() });
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
              com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
              return;
            }
            paramArrayOfByte = paramq;
            this.crt_wording = "";
            continue;
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetScenePayBase", "hy: json resolve error: error when resolving error code : " + localException1.toString());
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
        localObject1 = ah.getContext().getString(2131305145);
        continue;
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetScenePayBase", "hy: respString is null");
        localObject1 = localException1;
        continue;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
        continue;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
        continue;
        this.callback.onSceneEnd(paramString.errType, paramString.errCode, paramString.errMsg, this);
        return;
      }
    }
  }
  
  public abstract void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public void onGYNetEnd2(d paramd, JSONObject paramJSONObject) {}
  
  public void onRawGYNetEnd(d paramd, JSONObject paramJSONObject)
  {
    onGYNetEnd(paramd.errCode, paramd.errMsg, paramJSONObject);
  }
  
  public void onRawGYNetEndFuck2(d paramd, JSONObject paramJSONObject)
  {
    onGYNetEnd2(paramd, paramJSONObject);
  }
  
  public abstract void putToReqText(com.tencent.mm.ai.b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t);
  
  public void putToRequest(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(paramString);
  }
  
  public abstract void putToWXReqText(com.tencent.mm.ai.b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t);
  
  public void reportCellInfo(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {}
    try
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetScenePayBase", "errType is OK, reportCellInfo do nothing");
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetScenePayBase", "reportCellInfo error. %s", new Object[] { localException.getMessage() });
      return;
    }
    if (!m.cTF())
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetScenePayBase", "shouldReportCellInfo is false, reportCellInfo do nothing");
      return;
    }
    Object localObject1 = m.cTC();
    if ((localObject1 != null) && (!bo.isNullOrNil(((aw)localObject1).wmT)) && (!bo.isNullOrNil(((aw)localObject1).wmU)))
    {
      int i = getPayCgicmd();
      String str7 = ((aw)localObject1).wmT;
      String str8 = ((aw)localObject1).wmS;
      String str9 = ((aw)localObject1).wmU;
      if (!bo.isNullOrNil(str9))
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
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetScenePayBase", "reportCellInfo. cell info is too long to report");
          str1 = str6;
          str2 = str5;
          str3 = str4;
          localObject2 = localObject3;
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetScenePayBase", "reportCellInfo do report");
          localObject3 = new j();
          ((j)localObject3).cQm = i;
          ((j)localObject3).cQn = paramInt1;
          ((j)localObject3).cQo = paramInt2;
          ((j)localObject3).eX(str7).eY(str8).eZ(String.valueOf(j)).fa((String)localObject1).fb(str1).fc(str2).fd(str3).fe((String)localObject2).ake();
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
  
  public void setCommReqResp(com.tencent.mm.ai.b paramb)
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
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetScenePayBase", "Cmd : " + getPayCgicmd() + ", payInfo is null");
      ((Map)localObject).put("devicename", Build.MODEL);
      setWXRequestData((Map)localObject);
      return;
    }
    paramMap1.put("req_key", paramPayInfo.cnI);
    paramMap1.put("partner_id", paramPayInfo.partnerId);
    paramMap1.put("pay_sign", paramPayInfo.cLA);
    if (paramPayInfo.wgy >= 0) {
      paramMap1.put("auto_deduct_flag", paramPayInfo.wgy);
    }
    if (paramPayInfo.cCD > 0) {
      paramMap1.put("pay_scene", paramPayInfo.cCD);
    }
    if (paramPayInfo.cCE >= 0) {
      paramMap1.put("bindbankscene", paramPayInfo.cCE);
    }
    if (!bo.isNullOrNil(paramPayInfo.wgz)) {
      paramMap1.put("deduct_bank_type", paramPayInfo.wgz);
    }
    if (!bo.isNullOrNil(paramPayInfo.wgA)) {
      paramMap1.put("deduct_bind_serial", paramPayInfo.wgA);
    }
    if (paramBoolean) {
      paramMap1.put("use_touch", "0");
    }
    for (;;)
    {
      paramMap1.put("fp_identify_num", paramPayInfo.utd);
      if (!TextUtils.isEmpty(paramPayInfo.cwl)) {
        paramMap1.put("encrypted_pay_info", URLEncoder.encode(paramPayInfo.cwl));
      }
      if (!TextUtils.isEmpty(paramPayInfo.cwm)) {
        paramMap1.put("encrypted_rsa_sign", URLEncoder.encode(paramPayInfo.cwm));
      }
      ((Map)localObject).put("uuid", paramPayInfo.eAx);
      ((Map)localObject).put("appid", paramPayInfo.appId);
      ((Map)localObject).put("appsource", paramPayInfo.uAe);
      ((Map)localObject).put("channel", paramPayInfo.cCy);
      ((Map)localObject).put("devicename", Build.MODEL);
      ((Map)localObject).put("soter_req", paramPayInfo.cCf);
      return;
      paramMap1.put("use_touch", paramPayInfo.utc);
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
    if (!g.dpN()) {
      ((Map)localObject1).put("jsapi_reqkey", g.dpO());
    }
    this._request = ((Map)localObject1);
    configRequest(true, true);
    paramMap = (String)((Map)localObject1).get("req_key");
    getCommReqResp().getReqObj().setRouteInfo(com.tencent.mm.wallet_core.ui.e.awk(paramMap));
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
        if (!bo.isNullOrNil(str))
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
      if (!com.tencent.mm.sdk.a.b.dsf()) {
        break label418;
      }
      com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.NetScenePayBase", "RQ: Cmd : " + getPayCgicmd() + ", req = " + localStringBuilder.toString() + " " + toString() + " " + bo.dtY().toString());
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
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetScenePayBase", "setRequestData getPayCgicmd: %s type: %s this: %s cgi %s ", new Object[] { Integer.valueOf(getPayCgicmd()), Integer.valueOf(getType()), toString(), this.rr.getUri() });
      return;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetScenePayBase", "RQ: Cmd : " + getPayCgicmd() + ", req = " + localStringBuilder.toString() + " " + toString());
      break;
    }
  }
  
  public void setWXRequestData(Map<String, String> paramMap)
  {
    configRequest(false, false);
    if (paramMap != null)
    {
      Object localObject1 = m.cTC();
      if (localObject1 != null)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetScenePayBase", "location found");
        paramMap.put("province", ((aw)localObject1).province);
        if (!paramMap.containsKey("city")) {
          paramMap.put("city", ((aw)localObject1).city);
        }
        paramMap.put("location_timestamp", ((aw)localObject1).wmP);
        paramMap.put("encrypt_key", ((aw)localObject1).wmT);
        paramMap.put("encrypt_userinfo", ((aw)localObject1).wmS);
        if (m.cTF()) {
          paramMap.put("encrypt_cellinfo", ((aw)localObject1).wmU);
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
        if (!bo.isNullOrNil(str))
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
      if (com.tencent.mm.sdk.a.b.dsf()) {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetScenePayBase", "Cmd : " + getPayCgicmd() + ", wxreq = " + localStringBuilder.toString());
      }
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetScenePayBase", "wxreq: " + localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.q
 * JD-Core Version:    0.7.0.1
 */