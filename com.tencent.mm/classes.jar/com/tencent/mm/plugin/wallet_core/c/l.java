package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
  extends j
{
  public l()
  {
    D(new HashMap());
  }
  
  public final int HH()
  {
    return 1631;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneQueryUserWallet", "errCode is : " + paramInt);
    if (paramInt == 0)
    {
      o.bVv().dXw.gk("WalletKindInfo", "delete from WalletKindInfo");
      if (paramJSONObject != null)
      {
        y.i("MicroMsg.NetSceneQueryUserWallet", "resp json " + paramJSONObject.toString());
        paramString = paramJSONObject.optJSONArray("UserWalletInfoList");
        if (paramString != null)
        {
          int i = paramString.length();
          paramInt = 0;
          while (paramInt < i)
          {
            paramJSONObject = x.au(paramString.optJSONObject(paramInt));
            if (paramJSONObject != null) {
              o.bVv().b(paramJSONObject);
            }
            paramInt += 1;
          }
        }
        y.e("MicroMsg.NetSceneQueryUserWallet", "wallet array is null");
      }
    }
    else
    {
      return;
    }
    y.e("MicroMsg.NetSceneQueryUserWallet", "response json is null");
  }
  
  public final int aEC()
  {
    return 1631;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/queryuserwallet";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.l
 * JD-Core Version:    0.7.0.1
 */