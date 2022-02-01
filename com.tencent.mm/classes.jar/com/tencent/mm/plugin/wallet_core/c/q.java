package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.d.g;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
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
    Log.i("MicroMsg.NetSceneQueryUserWallet", "errCode is : ".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      t.fQL().db.execSQL("WalletKindInfo", "delete from WalletKindInfo");
      if (paramJSONObject != null)
      {
        Log.i("MicroMsg.NetSceneQueryUserWallet", "resp json " + paramJSONObject.toString());
        paramString = paramJSONObject.optJSONArray("UserWalletInfoList");
        if (paramString != null)
        {
          int i = paramString.length();
          paramInt = 0;
          while (paramInt < i)
          {
            paramJSONObject = ad.bO(paramString.optJSONObject(paramInt));
            if (paramJSONObject != null) {
              t.fQL().insert(paramJSONObject);
            }
            paramInt += 1;
          }
          AppMethodBeat.o(69927);
          return;
        }
        Log.e("MicroMsg.NetSceneQueryUserWallet", "wallet array is null");
        AppMethodBeat.o(69927);
        return;
      }
      Log.e("MicroMsg.NetSceneQueryUserWallet", "response json is null");
    }
    AppMethodBeat.o(69927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.q
 * JD-Core Version:    0.7.0.1
 */