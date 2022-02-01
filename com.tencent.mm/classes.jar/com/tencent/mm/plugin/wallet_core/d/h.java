package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.HashMap;
import java.util.Map;

public final class h
  extends j<ad>
{
  public static final String[] SQL_CREATE;
  public static Map<String, ad> iaG;
  private e db;
  
  static
  {
    AppMethodBeat.i(70620);
    SQL_CREATE = new String[] { j.getCreateSQLs(ad.info, "WalletLuckyMoney") };
    iaG = new HashMap();
    AppMethodBeat.o(70620);
  }
  
  public h(e parame)
  {
    super(parame, ad.info, "WalletLuckyMoney", null);
    this.db = parame;
  }
  
  public final boolean a(ad paramad)
  {
    AppMethodBeat.i(70618);
    if ((paramad != null) && (iaG.containsKey(paramad.field_mNativeUrl))) {
      iaG.put(paramad.field_mNativeUrl, paramad);
    }
    boolean bool = super.replace(paramad);
    AppMethodBeat.o(70618);
    return bool;
  }
  
  public final ad auf(String paramString)
  {
    AppMethodBeat.i(70617);
    paramString = this.db.rawQuery("select * from WalletLuckyMoney where mNativeUrl=?", new String[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(70617);
      return null;
    }
    if (paramString.getCount() == 0)
    {
      paramString.close();
      AppMethodBeat.o(70617);
      return null;
    }
    paramString.moveToFirst();
    ad localad = new ad();
    localad.convertFrom(paramString);
    paramString.close();
    AppMethodBeat.o(70617);
    return localad;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.h
 * JD-Core Version:    0.7.0.1
 */