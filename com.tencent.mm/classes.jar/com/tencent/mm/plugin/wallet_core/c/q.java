package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.d.g;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q
  extends m
{
  public q()
  {
    AppMethodBeat.i(69926);
    setRequestData(new HashMap());
    AppMethodBeat.o(69926);
  }
  
  public final int getFuncId()
  {
    return 1631;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1631;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/queryuserwallet";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69927);
    ad.i("MicroMsg.NetSceneQueryUserWallet", "errCode is : ".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      s.ecf().db.execSQL("WalletKindInfo", "delete from WalletKindInfo");
      if (paramJSONObject != null)
      {
        ad.i("MicroMsg.NetSceneQueryUserWallet", "resp json " + paramJSONObject.toString());
        paramString = paramJSONObject.optJSONArray("UserWalletInfoList");
        if (paramString != null)
        {
          int i = paramString.length();
          paramInt = 0;
          while (paramInt < i)
          {
            paramJSONObject = ac.be(paramString.optJSONObject(paramInt));
            if (paramJSONObject != null) {
              s.ecf().insert(paramJSONObject);
            }
            paramInt += 1;
          }
          AppMethodBeat.o(69927);
          return;
        }
        ad.e("MicroMsg.NetSceneQueryUserWallet", "wallet array is null");
        AppMethodBeat.o(69927);
        return;
      }
      ad.e("MicroMsg.NetSceneQueryUserWallet", "response json is null");
    }
    AppMethodBeat.o(69927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.q
 * JD-Core Version:    0.7.0.1
 */