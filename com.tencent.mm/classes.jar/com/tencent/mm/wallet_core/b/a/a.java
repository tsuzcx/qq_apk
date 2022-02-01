package com.tencent.mm.wallet_core.b.a;

import android.content.Context;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.dai;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class a
  extends com.tencent.mm.wallet_core.model.w
{
  private h callback;
  private c rr;
  
  public int doScene(g paramg, h paramh)
  {
    this.callback = paramh;
    return dispatch(paramg, this.rr, this);
  }
  
  public abstract String drI();
  
  public abstract int drJ();
  
  public boolean drK()
  {
    return false;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    Log.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + drJ() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString + " " + getType());
    daj localdaj = (daj)c.c.b(((c)params).otC);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = localdaj.aaFT;
      params = com.tencent.mm.platformtools.w.b(localdaj.aaFS);
      if ((paramInt1 == 0) && (!Util.isNullOrNil(params))) {
        paramInt1 = localdaj.hDx;
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
          break label386;
        }
        params = localdaj.errorMsg;
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        Log.printErrStackTrace("MiroMsg.NetSceneTenpayH5TransferBase", paramString, "", new Object[0]);
        i = 1000;
        paramInt1 = 2;
      }
      if (drK())
      {
        onGYNetEnd(i, params, localJSONObject);
        if (paramInt2 != 0) {
          Log.e("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + drJ() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
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
          paramString = MMApplicationContext.getContext().getString(a.i.wallet_data_err);
          paramInt2 = i;
          paramInt3 = paramInt1;
          break;
          paramInt2 = 1000;
          paramInt3 = 2;
          paramString = localdaj.aaFU;
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
        label386:
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
      localObject1 = new c.a();
      ((c.a)localObject1).otE = new dai();
      ((c.a)localObject1).otF = new daj();
      ((c.a)localObject1).uri = drI();
      ((c.a)localObject1).funcId = getType();
      ((c.a)localObject1).otG = 0;
      ((c.a)localObject1).respCmdId = 0;
      this.rr = ((c.a)localObject1).bEF();
      this.rr.setIsUserCmd(true);
    }
    Object localObject1 = (dai)c.b.b(this.rr.otB);
    ((dai)localObject1).aaFP = drJ();
    ((dai)localObject1).aaFQ = 1;
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
    Log.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + ((dai)localObject1).aaFP + ", req = " + localStringBuilder.toString());
    paramMap = localStringBuilder.toString().getBytes();
    ((dai)localObject1).aaFR = new gol().df(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.b.a.a
 * JD-Core Version:    0.7.0.1
 */