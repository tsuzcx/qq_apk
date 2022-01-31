package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.HashMap;
import java.util.Map;

public final class g
  extends j<ad>
{
  public static final String[] SQL_CREATE;
  public static Map<String, ad> goD;
  private e db;
  
  static
  {
    AppMethodBeat.i(47080);
    SQL_CREATE = new String[] { j.getCreateSQLs(ad.info, "WalletLuckyMoney") };
    goD = new HashMap();
    AppMethodBeat.o(47080);
  }
  
  public g(e parame)
  {
    super(parame, ad.info, "WalletLuckyMoney", null);
    this.db = parame;
  }
  
  public final boolean a(ad paramad)
  {
    AppMethodBeat.i(47078);
    if ((paramad != null) && (goD.containsKey(paramad.field_mNativeUrl))) {
      goD.put(paramad.field_mNativeUrl, paramad);
    }
    boolean bool = super.replace(paramad);
    AppMethodBeat.o(47078);
    return bool;
  }
  
  public final ad afw(String paramString)
  {
    AppMethodBeat.i(47077);
    paramString = this.db.rawQuery("select * from WalletLuckyMoney where mNativeUrl=?", new String[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(47077);
      return null;
    }
    if (paramString.getCount() == 0)
    {
      paramString.close();
      AppMethodBeat.o(47077);
      return null;
    }
    paramString.moveToFirst();
    ad localad = new ad();
    localad.convertFrom(paramString);
    paramString.close();
    AppMethodBeat.o(47077);
    return localad;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.g
 * JD-Core Version:    0.7.0.1
 */