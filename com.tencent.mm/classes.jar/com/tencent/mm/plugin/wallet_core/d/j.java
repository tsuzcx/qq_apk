package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.protocal.protobuf.daf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class j
  extends MAutoStorage<aj>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(70626);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(aj.info, "WalletRegionGreyAreaList") };
    AppMethodBeat.o(70626);
  }
  
  public j(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, aj.info, "WalletRegionGreyAreaList", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final void a(int paramInt, daf paramdaf)
  {
    AppMethodBeat.i(70624);
    aj localaj = new aj();
    localaj.field_wallet_region = paramInt;
    try
    {
      localaj.field_wallet_grey_item_buf = paramdaf.toByteArray();
      super.replace(localaj);
      AppMethodBeat.o(70624);
      return;
    }
    catch (Exception paramdaf)
    {
      for (;;)
      {
        Log.e("MicroMsg.WalletRegionGreyItemStg", "setWalletRegionGreyItem error " + paramdaf.getMessage());
      }
    }
  }
  
  public final aj aeO(int paramInt)
  {
    AppMethodBeat.i(70625);
    Object localObject = "select * from WalletRegionGreyAreaList where wallet_region = ".concat(String.valueOf(paramInt));
    Cursor localCursor = this.db.rawQuery((String)localObject, null, 2);
    Log.i("MicroMsg.WalletRegionGreyItemStg", "getWalletRegionGreyItem ".concat(String.valueOf(localObject)));
    if (localCursor == null)
    {
      localObject = new aj();
      AppMethodBeat.o(70625);
      return localObject;
    }
    localObject = new aj();
    if (localCursor.moveToNext())
    {
      localObject = new aj();
      ((aj)localObject).convertFrom(localCursor);
    }
    Log.i("MicroMsg.WalletRegionGreyItemStg", "get grey item ");
    localCursor.close();
    AppMethodBeat.o(70625);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.j
 * JD-Core Version:    0.7.0.1
 */