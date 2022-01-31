package com.tencent.mm.wallet_core.b.a;

import android.content.Context;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.wallet_core.c.u;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class a
  extends u
{
  private f callback;
  private b rr;
  
  public abstract String bhG();
  
  public abstract int bhH();
  
  public boolean bhI()
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
    ab.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + bhH() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString + " " + getType());
    avi localavi = (avi)((b)paramq).fsW.fta;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = localavi.xkM;
      paramq = aa.b(localavi.xkL);
      if ((paramInt1 == 0) && (!bo.isNullOrNil(paramq))) {
        paramInt1 = localavi.cpX;
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
        if (!bo.isNullOrNil(paramArrayOfByte)) {
          break label384;
        }
        paramq = localavi.errorMsg;
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        ab.printErrStackTrace("MiroMsg.NetSceneTenpayH5TransferBase", paramString, "", new Object[0]);
        i = 1000;
        paramInt1 = 2;
      }
      if (bhI())
      {
        onGYNetEnd(i, paramq, localJSONObject);
        if (paramInt2 != 0) {
          ab.e("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + bhH() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
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
          paramString = ah.getContext().getString(2131305032);
          paramInt2 = i;
          paramInt3 = paramInt1;
          break;
          paramInt2 = 1000;
          paramInt3 = 2;
          paramString = localavi.xkN;
          break;
          paramString = br.F(paramString, "e");
          i = paramInt2;
          paramInt1 = paramInt3;
        } while (paramString == null);
        ab.d("MiroMsg.NetSceneTenpayH5TransferBase", "CDN error!");
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
      ((b.a)localObject1).fsX = new avh();
      ((b.a)localObject1).fsY = new avi();
      ((b.a)localObject1).uri = bhG();
      ((b.a)localObject1).funcId = getType();
      ((b.a)localObject1).reqCmdId = 0;
      ((b.a)localObject1).respCmdId = 0;
      this.rr = ((b.a)localObject1).ado();
      this.rr.setIsUserCmd(true);
    }
    Object localObject1 = (avh)this.rr.fsV.fta;
    ((avh)localObject1).xkI = bhH();
    ((avh)localObject1).xkJ = 1;
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
    ab.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + ((avh)localObject1).xkI + ", req = " + localStringBuilder.toString());
    paramMap = localStringBuilder.toString().getBytes();
    ((avh)localObject1).xkK = new SKBuiltinBuffer_t().setBuffer(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.b.a.a
 * JD-Core Version:    0.7.0.1
 */