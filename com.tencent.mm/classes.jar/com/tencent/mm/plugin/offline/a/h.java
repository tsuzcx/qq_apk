package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eha;
import com.tencent.mm.protocal.protobuf.ehb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class h
  extends com.tencent.mm.ak.q
  implements m
{
  private i callback;
  private d rr;
  
  public int doScene(g paramg, i parami)
  {
    this.callback = parami;
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
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    Log.i("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    ehb localehb = (ehb)((d)params).iLL.iLR;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (localehb.MhU == 0)
      {
        params = z.b(localehb.MhT);
        try
        {
          JSONObject localJSONObject = new JSONObject(params);
          paramInt1 = localJSONObject.getInt("retcode");
          paramArrayOfByte = localehb.MGe;
          params = paramArrayOfByte;
          if (Util.isNullOrNil(paramArrayOfByte)) {
            params = localJSONObject.optString("retmsg");
          }
          i = localehb.MGd;
          if ((paramInt1 != 0) || (i != 0)) {
            break label297;
          }
          onGYNetEnd(paramInt1, params, localJSONObject);
          i = paramInt3;
          paramInt1 = paramInt2;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.NetSceneTenpayOfflineBase", paramString, "", new Object[0]);
            paramString = MMApplicationContext.getContext().getString(2131767667);
            i = 2;
            paramInt1 = 1000;
          }
        }
        if (paramInt1 != 0) {
          Log.e("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + paramInt1 + ", errCode = " + i + ", errMsg = " + paramString);
        }
        this.callback.onSceneEnd(paramInt1, i, paramString, this);
        Log.d("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + paramInt1 + ", errCode = " + i + ", errMsg = " + paramString);
        return;
        label297:
        Log.i("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode tenpayErrType : ".concat(String.valueOf(i)));
        if (i != 0) {
          break label449;
        }
        i = -1000;
      }
    }
    label449:
    for (;;)
    {
      Log.d("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode errMsg : ".concat(String.valueOf(params)));
      paramString = params;
      paramInt1 = 1000;
      break;
      paramString = localehb.MhV;
      i = 2;
      paramInt1 = 1000;
      break;
      params = XmlParser.parseXml(paramString, "e", null);
      paramInt1 = paramInt2;
      i = paramInt3;
      if (params == null) {
        break;
      }
      Log.d("MicroMsg.NetSceneTenpayOfflineBase", "CDN error!");
      paramString = (String)params.get(".e.Content");
      paramInt1 = paramInt2;
      i = paramInt3;
      break;
    }
  }
  
  public abstract void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public final void setRequestData(Map<String, String> paramMap)
  {
    if (!e.gsQ()) {
      paramMap.put("jsapi_reqkey", e.gsR());
    }
    if (this.rr == null)
    {
      localObject1 = new d.a();
      ((d.a)localObject1).iLN = new eha();
      ((d.a)localObject1).iLO = new ehb();
      localObject2 = getUri();
      i = getFuncId();
      ((d.a)localObject1).uri = ((String)localObject2);
      ((d.a)localObject1).funcId = i;
      ((d.a)localObject1).iLP = 185;
      ((d.a)localObject1).respCmdId = 1000000185;
      this.rr = ((d.a)localObject1).aXF();
    }
    Object localObject1 = (eha)this.rr.iLK.iLR;
    ((eha)localObject1).MhQ = getTenpayCgicmd();
    ((eha)localObject1).MhR = 1;
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
        break label438;
      }
      if (i != 0) {
        ((StringBuilder)localObject4).append("&");
      }
      ((StringBuilder)localObject4).append(str1);
      ((StringBuilder)localObject4).append("=");
      ((StringBuilder)localObject4).append(com.tencent.mm.compatible.util.q.encode(str2));
      i = 1;
    }
    label438:
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
        ((eha)localObject1).MhS = new SKBuiltinBuffer_t().setBuffer(paramMap);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.h
 * JD-Core Version:    0.7.0.1
 */