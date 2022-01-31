package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o
  extends m
{
  public o()
  {
    AppMethodBeat.i(46521);
    setRequestData(new HashMap());
    AppMethodBeat.o(46521);
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
    AppMethodBeat.i(46522);
    ab.i("MicroMsg.NetSceneQueryUserWallet", "errCode is : ".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      t.cTQ().db.execSQL("WalletKindInfo", "delete from WalletKindInfo");
      if (paramJSONObject != null)
      {
        ab.i("MicroMsg.NetSceneQueryUserWallet", "resp json " + paramJSONObject.toString());
        paramString = paramJSONObject.optJSONArray("UserWalletInfoList");
        if (paramString != null)
        {
          int i = paramString.length();
          paramInt = 0;
          while (paramInt < i)
          {
            paramJSONObject = ac.aI(paramString.optJSONObject(paramInt));
            if (paramJSONObject != null) {
              t.cTQ().insert(paramJSONObject);
            }
            paramInt += 1;
          }
          AppMethodBeat.o(46522);
          return;
        }
        ab.e("MicroMsg.NetSceneQueryUserWallet", "wallet array is null");
        AppMethodBeat.o(46522);
        return;
      }
      ab.e("MicroMsg.NetSceneQueryUserWallet", "response json is null");
    }
    AppMethodBeat.o(46522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.o
 * JD-Core Version:    0.7.0.1
 */