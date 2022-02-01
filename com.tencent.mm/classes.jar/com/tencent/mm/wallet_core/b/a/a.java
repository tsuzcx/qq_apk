package com.tencent.mm.wallet_core.b.a;

import android.content.Context;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bpg;
import com.tencent.mm.protocal.protobuf.bph;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.wallet_core.c.w;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class a
  extends w
{
  private f callback;
  private b rr;
  
  public abstract String cbJ();
  
  public abstract int cbK();
  
  public boolean cbL()
  {
    return false;
  }
  
  public int doScene(e parame, f paramf)
  {
    this.callback = paramf;
    return dispatch(parame, this.rr, this);
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    ae.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + cbK() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString + " " + getType());
    bph localbph = (bph)((b)paramq).hQE.hQJ;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = localbph.HcR;
      paramq = z.b(localbph.HcQ);
      if ((paramInt1 == 0) && (!bu.isNullOrNil(paramq))) {
        paramInt1 = localbph.doQ;
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
        if (!bu.isNullOrNil(paramArrayOfByte)) {
          break label384;
        }
        paramq = localbph.errorMsg;
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        ae.printErrStackTrace("MiroMsg.NetSceneTenpayH5TransferBase", paramString, "", new Object[0]);
        i = 1000;
        paramInt1 = 2;
      }
      if (cbL())
      {
        onGYNetEnd(i, paramq, localJSONObject);
        if (paramInt2 != 0) {
          ae.e("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + cbK() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
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
          paramString = ak.getContext().getString(2131765224);
          paramInt2 = i;
          paramInt3 = paramInt1;
          break;
          paramInt2 = 1000;
          paramInt3 = 2;
          paramString = localbph.HcS;
          break;
          paramString = bx.M(paramString, "e");
          i = paramInt2;
          paramInt1 = paramInt3;
        } while (paramString == null);
        ae.d("MiroMsg.NetSceneTenpayH5TransferBase", "CDN error!");
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
      ((b.a)localObject1).hQF = new bpg();
      ((b.a)localObject1).hQG = new bph();
      ((b.a)localObject1).uri = cbJ();
      ((b.a)localObject1).funcId = getType();
      ((b.a)localObject1).hQH = 0;
      ((b.a)localObject1).respCmdId = 0;
      this.rr = ((b.a)localObject1).aDS();
      this.rr.setIsUserCmd(true);
    }
    Object localObject1 = (bpg)this.rr.hQD.hQJ;
    ((bpg)localObject1).HcN = cbK();
    ((bpg)localObject1).HcO = 1;
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
      if (!bu.isNullOrNil(str))
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
    ae.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + ((bpg)localObject1).HcN + ", req = " + localStringBuilder.toString());
    paramMap = localStringBuilder.toString().getBytes();
    ((bpg)localObject1).HcP = new SKBuiltinBuffer_t().setBuffer(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.b.a.a
 * JD-Core Version:    0.7.0.1
 */