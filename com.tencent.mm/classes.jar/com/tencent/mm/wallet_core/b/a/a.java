package com.tencent.mm.wallet_core.b.a;

import android.content.Context;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
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
  
  public abstract String bVR();
  
  public abstract int bVS();
  
  public boolean bVT()
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
    ac.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + bVS() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString + " " + getType());
    bkf localbkf = (bkf)((b)paramq).hvs.hvw;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = localbkf.EZR;
      paramq = z.b(localbkf.EZQ);
      if ((paramInt1 == 0) && (!bs.isNullOrNil(paramq))) {
        paramInt1 = localbkf.dcp;
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
        if (!bs.isNullOrNil(paramArrayOfByte)) {
          break label384;
        }
        paramq = localbkf.errorMsg;
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        ac.printErrStackTrace("MiroMsg.NetSceneTenpayH5TransferBase", paramString, "", new Object[0]);
        i = 1000;
        paramInt1 = 2;
      }
      if (bVT())
      {
        onGYNetEnd(i, paramq, localJSONObject);
        if (paramInt2 != 0) {
          ac.e("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + bVS() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
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
          paramString = ai.getContext().getString(2131765224);
          paramInt2 = i;
          paramInt3 = paramInt1;
          break;
          paramInt2 = 1000;
          paramInt3 = 2;
          paramString = localbkf.EZS;
          break;
          paramString = bv.L(paramString, "e");
          i = paramInt2;
          paramInt1 = paramInt3;
        } while (paramString == null);
        ac.d("MiroMsg.NetSceneTenpayH5TransferBase", "CDN error!");
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
      ((b.a)localObject1).hvt = new bke();
      ((b.a)localObject1).hvu = new bkf();
      ((b.a)localObject1).uri = bVR();
      ((b.a)localObject1).funcId = getType();
      ((b.a)localObject1).reqCmdId = 0;
      ((b.a)localObject1).respCmdId = 0;
      this.rr = ((b.a)localObject1).aAz();
      this.rr.setIsUserCmd(true);
    }
    Object localObject1 = (bke)this.rr.hvr.hvw;
    ((bke)localObject1).EZN = bVS();
    ((bke)localObject1).EZO = 1;
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
    ac.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + ((bke)localObject1).EZN + ", req = " + localStringBuilder.toString());
    paramMap = localStringBuilder.toString().getBytes();
    ((bke)localObject1).EZP = new SKBuiltinBuffer_t().setBuffer(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.b.a.a
 * JD-Core Version:    0.7.0.1
 */