package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dng;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
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
    ae.i("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    dnh localdnh = (dnh)((b)paramq).hQE.hQJ;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (localdnh.HcR == 0)
      {
        paramq = z.b(localdnh.HcQ);
        try
        {
          JSONObject localJSONObject = new JSONObject(paramq);
          paramInt1 = localJSONObject.getInt("retcode");
          paramArrayOfByte = localdnh.Hxe;
          paramq = paramArrayOfByte;
          if (bu.isNullOrNil(paramArrayOfByte)) {
            paramq = localJSONObject.optString("retmsg");
          }
          i = localdnh.Hxd;
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
            ae.printErrStackTrace("MicroMsg.NetSceneTenpayOfflineBase", paramString, "", new Object[0]);
            paramString = ak.getContext().getString(2131765224);
            i = 2;
            paramInt1 = 1000;
          }
        }
        if (paramInt1 != 0) {
          ae.e("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + paramInt1 + ", errCode = " + i + ", errMsg = " + paramString);
        }
        this.callback.onSceneEnd(paramInt1, i, paramString, this);
        ae.d("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + paramInt1 + ", errCode = " + i + ", errMsg = " + paramString);
        return;
        label297:
        ae.i("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode tenpayErrType : ".concat(String.valueOf(i)));
        if (i != 0) {
          break label448;
        }
        i = -1000;
      }
    }
    label448:
    for (;;)
    {
      ae.d("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode errMsg : ".concat(String.valueOf(paramq)));
      paramString = paramq;
      paramInt1 = 1000;
      break;
      paramString = localdnh.HcS;
      i = 2;
      paramInt1 = 1000;
      break;
      paramq = bx.M(paramString, "e");
      paramInt1 = paramInt2;
      i = paramInt3;
      if (paramq == null) {
        break;
      }
      ae.d("MicroMsg.NetSceneTenpayOfflineBase", "CDN error!");
      paramString = (String)paramq.get(".e.Content");
      paramInt1 = paramInt2;
      i = paramInt3;
      break;
    }
  }
  
  public abstract void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public final void setRequestData(Map<String, String> paramMap)
  {
    if (!com.tencent.mm.pluginsdk.wallet.e.fjq()) {
      paramMap.put("jsapi_reqkey", com.tencent.mm.pluginsdk.wallet.e.fjr());
    }
    if (this.rr == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).hQF = new dng();
      ((b.a)localObject1).hQG = new dnh();
      localObject2 = getUri();
      i = getFuncId();
      ((b.a)localObject1).uri = ((String)localObject2);
      ((b.a)localObject1).funcId = i;
      ((b.a)localObject1).hQH = 185;
      ((b.a)localObject1).respCmdId = 1000000185;
      this.rr = ((b.a)localObject1).aDS();
    }
    Object localObject1 = (dng)this.rr.hQD.hQJ;
    ((dng)localObject1).HcN = getTenpayCgicmd();
    ((dng)localObject1).HcO = 1;
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
      if (!bu.isNullOrNil(str1))
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
      if (bu.isNullOrNil(str2)) {
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
        ((dng)localObject1).HcP = new SKBuiltinBuffer_t().setBuffer(paramMap);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.h
 * JD-Core Version:    0.7.0.1
 */