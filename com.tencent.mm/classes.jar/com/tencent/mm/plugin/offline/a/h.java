package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.protocal.protobuf.cjt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class h
  extends m
  implements k
{
  private f callback;
  private b rr;
  
  public int doScene(e parame, f paramf)
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
    ab.i("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    cjt localcjt = (cjt)((b)paramq).fsW.fta;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (localcjt.xkM == 0)
      {
        paramq = aa.b(localcjt.xkL);
        try
        {
          JSONObject localJSONObject = new JSONObject(paramq);
          paramInt1 = localJSONObject.getInt("retcode");
          paramArrayOfByte = localcjt.xAx;
          paramq = paramArrayOfByte;
          if (bo.isNullOrNil(paramArrayOfByte)) {
            paramq = localJSONObject.optString("retmsg");
          }
          i = localcjt.xAw;
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
            ab.printErrStackTrace("MicroMsg.NetSceneTenpayOfflineBase", paramString, "", new Object[0]);
            paramString = ah.getContext().getString(2131305032);
            i = 2;
            paramInt1 = 1000;
          }
        }
        if (paramInt1 != 0) {
          ab.e("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + paramInt1 + ", errCode = " + i + ", errMsg = " + paramString);
        }
        this.callback.onSceneEnd(paramInt1, i, paramString, this);
        ab.d("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + paramInt1 + ", errCode = " + i + ", errMsg = " + paramString);
        return;
        label297:
        ab.i("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode tenpayErrType : ".concat(String.valueOf(i)));
        if (i != 0) {
          break label448;
        }
        i = -1000;
      }
    }
    label448:
    for (;;)
    {
      ab.d("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode errMsg : ".concat(String.valueOf(paramq)));
      paramString = paramq;
      paramInt1 = 1000;
      break;
      paramString = localcjt.xkN;
      i = 2;
      paramInt1 = 1000;
      break;
      paramq = br.F(paramString, "e");
      paramInt1 = paramInt2;
      i = paramInt3;
      if (paramq == null) {
        break;
      }
      ab.d("MicroMsg.NetSceneTenpayOfflineBase", "CDN error!");
      paramString = (String)paramq.get(".e.Content");
      paramInt1 = paramInt2;
      i = paramInt3;
      break;
    }
  }
  
  public abstract void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public final void setRequestData(Map<String, String> paramMap)
  {
    if (!g.dpN()) {
      paramMap.put("jsapi_reqkey", g.dpO());
    }
    if (this.rr == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).fsX = new cjs();
      ((b.a)localObject1).fsY = new cjt();
      localObject2 = getUri();
      i = getFuncId();
      ((b.a)localObject1).uri = ((String)localObject2);
      ((b.a)localObject1).funcId = i;
      ((b.a)localObject1).reqCmdId = 185;
      ((b.a)localObject1).respCmdId = 1000000185;
      this.rr = ((b.a)localObject1).ado();
    }
    Object localObject1 = (cjs)this.rr.fsV.fta;
    ((cjs)localObject1).xkI = getTenpayCgicmd();
    ((cjs)localObject1).xkJ = 1;
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
      if (!bo.isNullOrNil(str1))
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
      if (bo.isNullOrNil(str2)) {
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
        ((cjs)localObject1).xkK = new SKBuiltinBuffer_t().setBuffer(paramMap);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.h
 * JD-Core Version:    0.7.0.1
 */