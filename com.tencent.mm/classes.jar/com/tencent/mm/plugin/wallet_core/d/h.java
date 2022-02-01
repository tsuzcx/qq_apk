package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.HashMap;
import java.util.Map;

public final class h
  extends j<ae>
{
  public static final String[] SQL_CREATE;
  public static Map<String, ae> iTT;
  private e db;
  
  static
  {
    AppMethodBeat.i(70620);
    SQL_CREATE = new String[] { j.getCreateSQLs(ae.info, "WalletLuckyMoney") };
    iTT = new HashMap();
    AppMethodBeat.o(70620);
  }
  
  public h(e parame)
  {
    super(parame, ae.info, "WalletLuckyMoney", null);
    this.db = parame;
  }
  
  public final boolean a(ae paramae)
  {
    AppMethodBeat.i(70618);
    if ((paramae != null) && (iTT.containsKey(paramae.field_mNativeUrl))) {
      iTT.put(paramae.field_mNativeUrl, paramae);
    }
    boolean bool = super.replace(paramae);
    AppMethodBeat.o(70618);
    return bool;
  }
  
  public final ae aEH(String paramString)
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
    ae localae = new ae();
    localae.convertFrom(paramString);
    paramString.close();
    AppMethodBeat.o(70617);
    return localae;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.h
 * JD-Core Version:    0.7.0.1
 */