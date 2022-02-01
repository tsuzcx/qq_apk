package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.ab;
import org.json.JSONObject;

public final class ah
  extends ae
{
  public am Vde;
  
  public ah()
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
      ((a)h.az(a.class)).getWalletCacheStg().set(at.a.acVq, paramString.toString());
      this.Vde = am.cd(paramString);
      AppMethodBeat.o(69959);
      return;
    }
    ((a)h.az(a.class)).getWalletCacheStg().set(at.a.acVq, "");
    this.Vde = null;
    AppMethodBeat.o(69959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ah
 * JD-Core Version:    0.7.0.1
 */