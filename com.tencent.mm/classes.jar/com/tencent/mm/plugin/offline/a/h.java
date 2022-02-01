package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dmj;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class h
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    this.callback = paramf;
    return dispatch(parame, this.rr, this);
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
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    ad.i("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    dmk localdmk = (dmk)((b)paramq).hNL.hNQ;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (localdmk.GJq == 0)
      {
        paramq = z.b(localdmk.GJp);
        try
        {
          JSONObject localJSONObject = new JSONObject(paramq);
          paramInt1 = localJSONObject.getInt("retcode");
          paramArrayOfByte = localdmk.HdE;
          paramq = paramArrayOfByte;
          if (bt.isNullOrNil(paramArrayOfByte)) {
            paramq = localJSONObject.optString("retmsg");
          }
          i = localdmk.HdD;
          if ((paramInt1 != 0) || (i != 0)) {
            break label297;
          }
          onGYNetEnd(paramInt1, paramq, localJSONObject);
          i = paramInt3;
          paramInt1 = paramInt2;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.NetSceneTenpayOfflineBase", paramString, "", new Object[0]);
            paramString = aj.getContext().getString(2131765224);
            i = 2;
            paramInt1 = 1000;
          }
        }
        if (paramInt1 != 0) {
          ad.e("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + paramInt1 + ", errCode = " + i + ", errMsg = " + paramString);
        }
        this.callback.onSceneEnd(paramInt1, i, paramString, this);
        ad.d("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + paramInt1 + ", errCode = " + i + ", errMsg = " + paramString);
        return;
        label297:
        ad.i("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode tenpayErrType : ".concat(String.valueOf(i)));
        if (i != 0) {
          break label448;
        }
        i = -1000;
      }
    }
    label448:
    for (;;)
    {
      ad.d("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode errMsg : ".concat(String.valueOf(paramq)));
      paramString = paramq;
      paramInt1 = 1000;
      break;
      paramString = localdmk.GJr;
      i = 2;
      paramInt1 = 1000;
      break;
      paramq = bw.M(paramString, "e");
      paramInt1 = paramInt2;
      i = paramInt3;
      if (paramq == null) {
        break;
      }
      ad.d("MicroMsg.NetSceneTenpayOfflineBase", "CDN error!");
      paramString = (String)paramq.get(".e.Content");
      paramInt1 = paramInt2;
      i = paramInt3;
      break;
    }
  }
  
  public abstract void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public final void setRequestData(Map<String, String> paramMap)
  {
    if (!com.tencent.mm.pluginsdk.wallet.e.ffA()) {
      paramMap.put("jsapi_reqkey", com.tencent.mm.pluginsdk.wallet.e.ffB());
    }
    if (this.rr == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).hNM = new dmj();
      ((b.a)localObject1).hNN = new dmk();
      localObject2 = getUri();
      i = getFuncId();
      ((b.a)localObject1).uri = ((String)localObject2);
      ((b.a)localObject1).funcId = i;
      ((b.a)localObject1).hNO = 185;
      ((b.a)localObject1).respCmdId = 1000000185;
      this.rr = ((b.a)localObject1).aDC();
    }
    Object localObject1 = (dmj)this.rr.hNK.hNQ;
    ((dmj)localObject1).GJm = getTenpayCgicmd();
    ((dmj)localObject1).GJn = 1;
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
      if (!bt.isNullOrNil(str1))
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
      if (bt.isNullOrNil(str2)) {
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
        ((dmj)localObject1).GJo = new SKBuiltinBuffer_t().setBuffer(paramMap);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.h
 * JD-Core Version:    0.7.0.1
 */