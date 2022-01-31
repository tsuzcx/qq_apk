package com.tencent.mm.wallet_core.b.a;

import android.content.Context;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.api;
import com.tencent.mm.protocal.c.apj;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class a
  extends s
{
  private b dmK;
  private f dmL;
  
  public final void D(Map<String, String> paramMap)
  {
    if (this.dmK == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).ecH = new api();
      ((b.a)localObject1).ecI = new apj();
      ((b.a)localObject1).uri = aEz();
      ((b.a)localObject1).ecG = getType();
      ((b.a)localObject1).ecJ = 0;
      ((b.a)localObject1).ecK = 0;
      this.dmK = ((b.a)localObject1).Kt();
      this.dmK.ecZ = true;
    }
    Object localObject1 = (api)this.dmK.ecE.ecN;
    ((api)localObject1).tlp = aEA();
    ((api)localObject1).tlq = 1;
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
      if (!bk.bl(str))
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
    y.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + ((api)localObject1).tlp + ", req = " + localStringBuilder.toString());
    paramMap = localStringBuilder.toString().getBytes();
    ((api)localObject1).tlr = new bmk().bs(paramMap);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public abstract void a(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public abstract int aEA();
  
  public boolean aEB()
  {
    return false;
  }
  
  public abstract String aEz();
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + aEA() + ", errType = " + paramInt1 + ", errCode = " + paramInt2 + ", errMsg = " + paramString + " " + getType());
    apj localapj = (apj)((b)paramq).ecF.ecN;
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      i = localapj.tlt;
      paramq = aa.b(localapj.tls);
      if ((i == 0) && (!bk.bl(paramq))) {
        i = localapj.bIC;
      }
    }
    for (;;)
    {
      int j;
      try
      {
        localJSONObject = new JSONObject(paramq);
        j = localJSONObject.getInt("retcode");
        String str = localJSONObject.optString("retmsg");
        paramq = str;
        if (!bk.bl(str)) {
          break label385;
        }
        paramq = localapj.errorMsg;
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        y.printErrStackTrace("MiroMsg.NetSceneTenpayH5TransferBase", paramString, "", new Object[0]);
        i = 2;
        j = 1000;
      }
      if (aEB())
      {
        a(j, paramq, localJSONObject);
        if (paramInt1 != 0) {
          y.e("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + aEA() + ", errType = " + paramInt1 + ", errCode = " + paramInt2 + ", errMsg = " + paramString);
        }
        this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
        return;
      }
      if (i == 0)
      {
        paramInt1 = -1000;
        paramString = paramq;
        paramInt2 = paramInt1;
        paramInt1 = 1000;
        continue;
        do
        {
          paramString = ae.getContext().getString(a.i.wallet_data_err);
          paramInt1 = j;
          paramInt2 = i;
          break;
          paramString = localapj.tlu;
          paramInt2 = 2;
          paramInt1 = 1000;
          break;
          paramString = bn.s(paramString, "e");
          j = paramInt1;
          i = paramInt2;
        } while (paramString == null);
        y.d("MiroMsg.NetSceneTenpayH5TransferBase", "CDN error!");
        paramString = (String)paramString.get(".e.Content");
      }
      else
      {
        paramInt1 = i;
        continue;
        label385:
        if (j == 0) {
          if (i == 0) {}
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.b.a.a
 * JD-Core Version:    0.7.0.1
 */