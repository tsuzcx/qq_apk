package com.tencent.mm.wallet_core.b.a;

import android.content.Context;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cby;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.wallet_core.c.w;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class a
  extends w
{
  private i callback;
  private d rr;
  
  public abstract String czD();
  
  public abstract int czE();
  
  public boolean czF()
  {
    return false;
  }
  
  public int doScene(g paramg, i parami)
  {
    this.callback = parami;
    return dispatch(paramg, this.rr, this);
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    Log.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + czE() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString + " " + getType());
    cbz localcbz = (cbz)((d)params).iLL.iLR;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = localcbz.MhU;
      params = z.b(localcbz.MhT);
      if ((paramInt1 == 0) && (!Util.isNullOrNil(params))) {
        paramInt1 = localcbz.dGe;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localJSONObject = new JSONObject(params);
        i = localJSONObject.getInt("retcode");
        paramArrayOfByte = localJSONObject.optString("retmsg");
        params = paramArrayOfByte;
        if (!Util.isNullOrNil(paramArrayOfByte)) {
          break label385;
        }
        params = localcbz.errorMsg;
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        Log.printErrStackTrace("MiroMsg.NetSceneTenpayH5TransferBase", paramString, "", new Object[0]);
        i = 1000;
        paramInt1 = 2;
      }
      if (czF())
      {
        onGYNetEnd(i, params, localJSONObject);
        if (paramInt2 != 0) {
          Log.e("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + czE() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      paramInt2 = 1000;
      if (paramInt1 == 0)
      {
        paramInt1 = -1000;
        paramString = params;
        paramInt3 = paramInt1;
        continue;
        do
        {
          paramString = MMApplicationContext.getContext().getString(2131767667);
          paramInt2 = i;
          paramInt3 = paramInt1;
          break;
          paramInt2 = 1000;
          paramInt3 = 2;
          paramString = localcbz.MhV;
          break;
          paramString = XmlParser.parseXml(paramString, "e", null);
          i = paramInt2;
          paramInt1 = paramInt3;
        } while (paramString == null);
        Log.d("MiroMsg.NetSceneTenpayH5TransferBase", "CDN error!");
        paramString = (String)paramString.get(".e.Content");
      }
      else
      {
        continue;
        label385:
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
      localObject1 = new d.a();
      ((d.a)localObject1).iLN = new cby();
      ((d.a)localObject1).iLO = new cbz();
      ((d.a)localObject1).uri = czD();
      ((d.a)localObject1).funcId = getType();
      ((d.a)localObject1).iLP = 0;
      ((d.a)localObject1).respCmdId = 0;
      this.rr = ((d.a)localObject1).aXF();
      this.rr.setIsUserCmd(true);
    }
    Object localObject1 = (cby)this.rr.iLK.iLR;
    ((cby)localObject1).MhQ = czE();
    ((cby)localObject1).MhR = 1;
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
      if (!Util.isNullOrNil(str))
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
    Log.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + ((cby)localObject1).MhQ + ", req = " + localStringBuilder.toString());
    paramMap = localStringBuilder.toString().getBytes();
    ((cby)localObject1).MhS = new SKBuiltinBuffer_t().setBuffer(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.b.a.a
 * JD-Core Version:    0.7.0.1
 */