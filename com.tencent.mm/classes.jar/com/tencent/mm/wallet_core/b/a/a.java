package com.tencent.mm.wallet_core.b.a;

import android.content.Context;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bgm;
import com.tencent.mm.protocal.protobuf.bgn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.wallet_core.c.w;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class a
  extends w
{
  private g callback;
  private b rr;
  
  public abstract String bOB();
  
  public abstract int bOC();
  
  public boolean bOD()
  {
    return false;
  }
  
  public int doScene(e parame, g paramg)
  {
    this.callback = paramg;
    return dispatch(parame, this.rr, this);
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    ad.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + bOC() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString + " " + getType());
    bgn localbgn = (bgn)((b)paramq).gUT.gUX;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = localbgn.DEw;
      paramq = z.b(localbgn.DEv);
      if ((paramInt1 == 0) && (!bt.isNullOrNil(paramq))) {
        paramInt1 = localbgn.deV;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localJSONObject = new JSONObject(paramq);
        i = localJSONObject.getInt("retcode");
        paramArrayOfByte = localJSONObject.optString("retmsg");
        paramq = paramArrayOfByte;
        if (!bt.isNullOrNil(paramArrayOfByte)) {
          break label384;
        }
        paramq = localbgn.errorMsg;
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        ad.printErrStackTrace("MiroMsg.NetSceneTenpayH5TransferBase", paramString, "", new Object[0]);
        i = 1000;
        paramInt1 = 2;
      }
      if (bOD())
      {
        onGYNetEnd(i, paramq, localJSONObject);
        if (paramInt2 != 0) {
          ad.e("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + bOC() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      paramInt2 = 1000;
      if (paramInt1 == 0)
      {
        paramInt1 = -1000;
        paramString = paramq;
        paramInt3 = paramInt1;
        continue;
        do
        {
          paramString = aj.getContext().getString(2131765224);
          paramInt2 = i;
          paramInt3 = paramInt1;
          break;
          paramInt2 = 1000;
          paramInt3 = 2;
          paramString = localbgn.DEx;
          break;
          paramString = bw.K(paramString, "e");
          i = paramInt2;
          paramInt1 = paramInt3;
        } while (paramString == null);
        ad.d("MiroMsg.NetSceneTenpayH5TransferBase", "CDN error!");
        paramString = (String)paramString.get(".e.Content");
      }
      else
      {
        continue;
        label384:
        if (i == 0) {
          if (paramInt1 == 0) {}
        }
      }
    }
  }
  
  public abstract void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public final void setRequestData(Map<String, String> paramMap)
  {
    if (this.rr == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).gUU = new bgm();
      ((b.a)localObject1).gUV = new bgn();
      ((b.a)localObject1).uri = bOB();
      ((b.a)localObject1).funcId = getType();
      ((b.a)localObject1).reqCmdId = 0;
      ((b.a)localObject1).respCmdId = 0;
      this.rr = ((b.a)localObject1).atI();
      this.rr.setIsUserCmd(true);
    }
    Object localObject1 = (bgm)this.rr.gUS.gUX;
    ((bgm)localObject1).DEs = bOC();
    ((bgm)localObject1).DEt = 1;
    Object[] arrayOfObject = paramMap.keySet().toArray();
    Arrays.sort(arrayOfObject);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int k;
    for (int j = 0; i < arrayOfObject.length; j = k)
    {
      Object localObject2 = arrayOfObject[i];
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
    ad.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + ((bgm)localObject1).DEs + ", req = " + localStringBuilder.toString());
    paramMap = localStringBuilder.toString().getBytes();
    ((bgm)localObject1).DEu = new SKBuiltinBuffer_t().setBuffer(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.b.a.a
 * JD-Core Version:    0.7.0.1
 */