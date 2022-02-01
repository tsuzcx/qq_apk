package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.protocal.protobuf.ecd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class j
  extends MAutoStorage<ai>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(70626);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ai.info, "WalletRegionGreyAreaList") };
    AppMethodBeat.o(70626);
  }
  
  public j(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ai.info, "WalletRegionGreyAreaList", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final void a(int paramInt, ecd paramecd)
  {
    AppMethodBeat.i(70624);
    ai localai = new ai();
    localai.field_wallet_region = paramInt;
    try
    {
      localai.field_wallet_grey_item_buf = paramecd.toByteArray();
      super.replace(localai);
      AppMethodBeat.o(70624);
      return;
    }
    catch (Exception paramecd)
    {
      for (;;)
      {
        Log.e("MicroMsg.WalletRegionGreyItemStg", "setWalletRegionGreyItem error " + paramecd.getMessage());
      }
    }
  }
  
  public final ai asq(int paramInt)
  {
    AppMethodBeat.i(70625);
    Object localObject = "select * from WalletRegionGreyAreaList where wallet_region = ".concat(String.valueOf(paramInt));
    Cursor localCursor = this.db.rawQuery((String)localObject, null, 2);
    Log.i("MicroMsg.WalletRegionGreyItemStg", "getWalletRegionGreyItem ".concat(String.valueOf(localObject)));
    if (localCursor == null)
    {
      localObject = new ai();
      AppMethodBeat.o(70625);
      return localObject;
    }
    localObject = new ai();
    if (localCursor.moveToNext())
    {
      localObject = new ai();
      ((ai)localObject).convertFrom(localCursor);
    }
    Log.i("MicroMsg.WalletRegionGreyItemStg", "get grey item ");
    localCursor.close();
    AppMethodBeat.o(70625);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.j
 * JD-Core Version:    0.7.0.1
 */