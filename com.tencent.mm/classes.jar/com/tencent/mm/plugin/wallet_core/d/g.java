package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.HashMap;
import java.util.Map;

public final class g
  extends i<y>
{
  public static final String[] dXp = { i.a(y.buS, "WalletLuckyMoney") };
  public static Map<String, y> eWF = new HashMap();
  private e dXw;
  
  public g(e parame)
  {
    super(parame, y.buS, "WalletLuckyMoney", null);
    this.dXw = parame;
  }
  
  public final y QC(String paramString)
  {
    paramString = this.dXw.rawQuery("select * from WalletLuckyMoney where mNativeUrl=?", new String[] { paramString });
    if (paramString == null) {
      return null;
    }
    if (paramString.getCount() == 0)
    {
      paramString.close();
      return null;
    }
    paramString.moveToFirst();
    y localy = new y();
    localy.d(paramString);
    paramString.close();
    return localy;
  }
  
  public final boolean a(y paramy)
  {
    if ((paramy != null) && (eWF.containsKey(paramy.field_mNativeUrl))) {
      eWF.put(paramy.field_mNativeUrl, paramy);
    }
    return super.a(paramy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.g
 * JD-Core Version:    0.7.0.1
 */