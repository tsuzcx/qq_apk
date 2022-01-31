package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bxg;
import com.tencent.mm.protocal.c.bxh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class h
  extends m
  implements k
{
  private b dmK;
  private com.tencent.mm.ah.f dmL;
  
  public final void D(Map<String, String> paramMap)
  {
    if (!com.tencent.mm.pluginsdk.wallet.f.cow()) {
      paramMap.put("jsapi_reqkey", com.tencent.mm.pluginsdk.wallet.f.cox());
    }
    if (this.dmK == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).ecH = new bxg();
      ((b.a)localObject1).ecI = new bxh();
      localObject2 = getUri();
      i = HH();
      ((b.a)localObject1).uri = ((String)localObject2);
      ((b.a)localObject1).ecG = i;
      ((b.a)localObject1).ecJ = 185;
      ((b.a)localObject1).ecK = 1000000185;
      this.dmK = ((b.a)localObject1).Kt();
    }
    Object localObject1 = (bxg)this.dmK.ecE.ecN;
    ((bxg)localObject1).tlp = aEC();
    ((bxg)localObject1).tlq = 1;
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
      if (!bk.bl(str1))
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
      if (bk.bl(str2)) {
        break label431;
      }
      if (i != 0) {
        ((StringBuilder)localObject4).append("&");
      }
      ((StringBuilder)localObject4).append(str1);
      ((StringBuilder)localObject4).append("=");
      ((StringBuilder)localObject4).append(com.tencent.mm.compatible.util.q.encode(str2));
      i = 1;
    }
    label431:
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
        ((bxg)localObject1).tlr = new bmk().bs(paramMap);
        return;
      }
    }
  }
  
  public int HH()
  {
    return 385;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + aEC() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    bxh localbxh = (bxh)((b)paramq).ecF.ecN;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (localbxh.tlt == 0)
      {
        paramq = aa.b(localbxh.tls);
        try
        {
          JSONObject localJSONObject = new JSONObject(paramq);
          paramInt1 = localJSONObject.getInt("retcode");
          paramArrayOfByte = localbxh.tzp;
          paramq = paramArrayOfByte;
          if (bk.bl(paramArrayOfByte)) {
            paramq = localJSONObject.optString("retmsg");
          }
          i = localbxh.tzo;
          if ((paramInt1 != 0) || (i != 0)) {
            break label297;
          }
          a(paramInt1, paramq, localJSONObject);
          i = paramInt3;
          paramInt1 = paramInt2;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.NetSceneTenpayOfflineBase", paramString, "", new Object[0]);
            paramString = ae.getContext().getString(a.i.wallet_data_err);
            i = 2;
            paramInt1 = 1000;
          }
        }
        if (paramInt1 != 0) {
          y.e("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + aEC() + ", errType = " + paramInt1 + ", errCode = " + i + ", errMsg = " + paramString);
        }
        this.dmL.onSceneEnd(paramInt1, i, paramString, this);
        y.d("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + aEC() + ", errType = " + paramInt1 + ", errCode = " + i + ", errMsg = " + paramString);
        return;
        label297:
        y.i("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode tenpayErrType : " + i);
        if (i != 0) {
          break label468;
        }
        i = -1000;
      }
    }
    label468:
    for (;;)
    {
      y.d("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode errMsg : " + paramq);
      paramString = paramq;
      paramInt1 = 1000;
      break;
      paramString = localbxh.tlu;
      i = 2;
      paramInt1 = 1000;
      break;
      paramq = bn.s(paramString, "e");
      paramInt1 = paramInt2;
      i = paramInt3;
      if (paramq == null) {
        break;
      }
      y.d("MicroMsg.NetSceneTenpayOfflineBase", "CDN error!");
      paramString = (String)paramq.get(".e.Content");
      paramInt1 = paramInt2;
      i = paramInt3;
      break;
    }
  }
  
  public abstract void a(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public abstract int aEC();
  
  public final int getType()
  {
    return 385;
  }
  
  public String getUri()
  {
    return "/cgi-bin/micromsg-bin/tenpay";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.h
 * JD-Core Version:    0.7.0.1
 */