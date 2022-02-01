package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.c.aa;
import org.json.JSONObject;

public final class ag
  extends ad
{
  public al CRF;
  
  public ag()
  {
    super(null, 3);
  }
  
  public final int getFuncId()
  {
    return 2750;
  }
  
  public final int getTenpayCgicmd()
  {
    return 2750;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/savebindquery";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69959);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    paramString = paramJSONObject.optJSONObject("save_to_lqt_entry");
    if (paramString != null)
    {
      ((a)g.ad(a.class)).getWalletCacheStg().set(am.a.IXg, paramString.toString());
      this.CRF = al.aX(paramString);
    }
    AppMethodBeat.o(69959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ag
 * JD-Core Version:    0.7.0.1
 */