package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.d;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.Map;
import org.json.JSONObject;

public final class q
  extends j
{
  public n mLu;
  public com.tencent.mm.plugin.wallet_core.c.y mLv;
  public com.tencent.mm.wallet_core.c.c mLw;
  public com.tencent.mm.wallet_core.c.c mLx;
  
  public q(int paramInt)
  {
    this.mLu = new n(System.currentTimeMillis(), paramInt);
    D(this.mLu.mLt);
    this.mLv = new com.tencent.mm.plugin.wallet_core.c.y(null, 8);
    aB(this.mLv.mLt);
    aC(this.mLv.qma);
  }
  
  private static com.tencent.mm.wallet_core.c.c Y(JSONObject paramJSONObject)
  {
    com.tencent.mm.wallet_core.c.c localc = new com.tencent.mm.wallet_core.c.c();
    localc.aox = ae.getContext().getString(a.i.wallet_data_err);
    String str = ae.getContext().getString(a.i.wallet_data_err);
    try
    {
      i = paramJSONObject.getInt("retcode");
      paramJSONObject = paramJSONObject.optString("retmsg");
      if (i != 0)
      {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: resolve busi error: retCode is error");
        if (i != -10089)
        {
          localc.f(1000, i, paramJSONObject, 2);
          return localc;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: json resolve error: error when resolving error code : " + paramJSONObject.toString());
        paramJSONObject = str;
        int i = -10089;
      }
      localc.f(1000, 2, paramJSONObject, 2);
      return localc;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: all's OK");
    return localc;
  }
  
  public static boolean isEnabled()
  {
    boolean bool2 = false;
    Object localObject = com.tencent.mm.model.c.c.IX().fJ("100337");
    boolean bool1 = bool2;
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).ctr();
      bool1 = bool2;
      if (((Map)localObject).containsKey("enabled"))
      {
        bool1 = bool2;
        if ("1".equals(((Map)localObject).get("enabled"))) {
          bool1 = true;
        }
      }
    }
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "isUserBindQueryEnabled: " + bool1);
    return bool1;
  }
  
  public final int HH()
  {
    return 1742;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramInt != 0) {}
    do
    {
      return;
      paramString = paramJSONObject.optJSONObject("queryuser_resp");
      this.mLw = Y(paramString);
      this.mLu.a(this.mLw.errCode, this.mLw.aox, paramString);
      paramJSONObject = paramJSONObject.optJSONObject("bindquerynew_resp");
      this.mLx = Y(paramJSONObject);
      this.mLv.a(this.mLx.errCode, this.mLx.aox, paramJSONObject);
      paramString = paramString.optString("card_list");
    } while (paramString == null);
    a.Kq(paramString);
  }
  
  public final int aEC()
  {
    return 1742;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlineuserbindquery";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.q
 * JD-Core Version:    0.7.0.1
 */