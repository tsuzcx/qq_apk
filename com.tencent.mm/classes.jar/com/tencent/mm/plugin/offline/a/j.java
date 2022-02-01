package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.fmj;
import com.tencent.mm.protocal.protobuf.fmk;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class j
  extends com.tencent.mm.wallet_core.model.w
{
  private h callback;
  private c rr;
  
  protected void aQz(String paramString) {}
  
  public int doScene(g paramg, h paramh)
  {
    this.callback = paramh;
    return dispatch(paramg, this.rr, this);
  }
  
  public int getFuncId()
  {
    return 385;
  }
  
  public abstract int getTenpayCgicmd();
  
  public int getType()
  {
    return 385;
  }
  
  public String getUri()
  {
    return "/cgi-bin/micromsg-bin/tenpay";
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    Log.i("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    fmk localfmk = (fmk)c.c.b(((c)params).otC);
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (localfmk.aaFT == 0)
      {
        String str = com.tencent.mm.platformtools.w.b(localfmk.aaFS);
        try
        {
          JSONObject localJSONObject = new JSONObject(str);
          paramInt1 = localJSONObject.getInt("retcode");
          paramArrayOfByte = localfmk.abiq;
          params = paramArrayOfByte;
          if (Util.isNullOrNil(paramArrayOfByte)) {
            params = localJSONObject.optString("retmsg");
          }
          i = localfmk.abip;
          if ((paramInt1 != 0) || (i != 0)) {
            break label299;
          }
          onGYNetEnd(paramInt1, params, localJSONObject);
          paramInt1 = paramInt3;
          aQz(str);
          paramInt3 = paramInt1;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            label176:
            Log.printErrStackTrace("MicroMsg.NetSceneTenpayOfflineBase", paramString, "", new Object[0]);
            paramInt2 = 1000;
            paramInt3 = 2;
            paramString = MMApplicationContext.getContext().getString(a.i.wallet_data_err);
          }
        }
        if (paramInt2 != 0) {
          Log.e("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        Log.d("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
        return;
        label299:
        Log.i("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode tenpayErrType : ".concat(String.valueOf(i)));
        paramInt3 = 1000;
        if (i != 0) {
          break label445;
        }
        paramInt2 = paramInt1;
        break label448;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode errMsg : ".concat(String.valueOf(params)));
      paramString = params;
      paramInt2 = paramInt3;
      break;
      paramInt2 = 1000;
      paramInt3 = 2;
      paramString = localfmk.aaFU;
      break label176;
      params = XmlParser.parseXml(paramString, "e", null);
      if (params != null)
      {
        Log.d("MicroMsg.NetSceneTenpayOfflineBase", "CDN error!");
        paramString = (String)params.get(".e.Content");
        break label176;
      }
      break label176;
      label445:
      paramInt2 = i;
      label448:
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = -1000;
      }
    }
  }
  
  public abstract void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public final void setRequestData(Map<String, String> paramMap)
  {
    if (!e.iOV()) {
      paramMap.put("jsapi_reqkey", e.iOW());
    }
    if (this.rr == null)
    {
      localObject1 = new c.a();
      ((c.a)localObject1).otE = new fmj();
      ((c.a)localObject1).otF = new fmk();
      localObject2 = getUri();
      i = getFuncId();
      ((c.a)localObject1).uri = ((String)localObject2);
      ((c.a)localObject1).funcId = i;
      ((c.a)localObject1).otG = 185;
      ((c.a)localObject1).respCmdId = 1000000185;
      this.rr = ((c.a)localObject1).bEF();
    }
    Object localObject1 = (fmj)c.b.b(this.rr.otB);
    ((fmj)localObject1).aaFP = getTenpayCgicmd();
    ((fmj)localObject1).aaFQ = 1;
    Object localObject2 = paramMap.keySet().toArray();
    Arrays.sort((Object[])localObject2);
    Object localObject3 = new StringBuilder();
    int i = 0;
    String str1;
    int k;
    for (int j = 0; i < localObject2.length; j = k)
    {
      localObject4 = localObject2[i];
      str1 = (String)paramMap.get(localObject4);
      k = j;
      if (!Util.isNullOrNil(str1))
      {
        if (j != 0) {
          ((StringBuilder)localObject3).append("&");
        }
        ((StringBuilder)localObject3).append(localObject4);
        ((StringBuilder)localObject3).append("=");
        ((StringBuilder)localObject3).append(str1);
        k = 1;
      }
      i += 1;
    }
    localObject3 = TenpayUtil.signWith3Des(((StringBuilder)localObject3).toString());
    Object localObject4 = new StringBuilder();
    i = 0;
    j = 0;
    if (j < localObject2.length)
    {
      str1 = localObject2[j];
      String str2 = (String)paramMap.get(str1);
      if (Util.isNullOrNil(str2)) {
        break label435;
      }
      if (i != 0) {
        ((StringBuilder)localObject4).append("&");
      }
      ((StringBuilder)localObject4).append(str1);
      ((StringBuilder)localObject4).append("=");
      ((StringBuilder)localObject4).append(r.cg(str2));
      i = 1;
    }
    label435:
    for (;;)
    {
      j += 1;
      break;
      if (i != 0) {}
      for (paramMap = "&";; paramMap = "")
      {
        ((StringBuilder)localObject4).append(paramMap);
        ((StringBuilder)localObject4).append("WCPaySign");
        ((StringBuilder)localObject4).append("=");
        ((StringBuilder)localObject4).append((String)localObject3);
        paramMap = ((StringBuilder)localObject4).toString().getBytes();
        ((fmj)localObject1).aaFR = new gol().df(paramMap);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.j
 * JD-Core Version:    0.7.0.1
 */