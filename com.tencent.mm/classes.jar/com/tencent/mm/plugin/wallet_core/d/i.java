package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;

public final class i
  extends j<af>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(70623);
    SQL_CREATE = new String[] { j.getCreateSQLs(af.info, "WalletPrefInfo") };
    AppMethodBeat.o(70623);
  }
  
  public i(e parame)
  {
    super(parame, af.info, "WalletPrefInfo", null);
    this.db = parame;
  }
  
  public final af aug(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(70621);
    if (!bt.isNullOrNil(paramString))
    {
      Cursor localCursor = this.db.a("select * from WalletPrefInfo where pref_key=?", new String[] { paramString }, 2);
      if (localCursor == null)
      {
        AppMethodBeat.o(70621);
        return null;
      }
      paramString = localObject;
      if (localCursor.moveToFirst())
      {
        paramString = new af();
        paramString.convertFrom(localCursor);
      }
      localCursor.close();
      AppMethodBeat.o(70621);
      return paramString;
    }
    AppMethodBeat.o(70621);
    return null;
  }
  
  public final boolean auh(String paramString)
  {
    AppMethodBeat.i(70622);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = "delete from WalletPrefInfo where pref_key='" + paramString + "'";
      boolean bool = this.db.execSQL("WalletPrefInfo", paramString);
      AppMethodBeat.o(70622);
      return bool;
    }
    AppMethodBeat.o(70622);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.i
 * JD-Core Version:    0.7.0.1
 */