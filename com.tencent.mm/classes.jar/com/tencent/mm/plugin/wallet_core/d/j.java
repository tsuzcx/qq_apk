package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.protocal.protobuf.djt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class j
  extends MAutoStorage<ak>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(70626);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ak.info, "WalletRegionGreyAreaList") };
    AppMethodBeat.o(70626);
  }
  
  public j(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ak.info, "WalletRegionGreyAreaList", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final void a(int paramInt, djt paramdjt)
  {
    AppMethodBeat.i(70624);
    ak localak = new ak();
    localak.field_wallet_region = paramInt;
    try
    {
      localak.field_wallet_grey_item_buf = paramdjt.toByteArray();
      super.replace(localak);
      AppMethodBeat.o(70624);
      return;
    }
    catch (Exception paramdjt)
    {
      for (;;)
      {
        Log.e("MicroMsg.WalletRegionGreyItemStg", "setWalletRegionGreyItem error " + paramdjt.getMessage());
      }
    }
  }
  
  public final ak amB(int paramInt)
  {
    AppMethodBeat.i(70625);
    Object localObject = "select * from WalletRegionGreyAreaList where wallet_region = ".concat(String.valueOf(paramInt));
    Cursor localCursor = this.db.rawQuery((String)localObject, null, 2);
    Log.i("MicroMsg.WalletRegionGreyItemStg", "getWalletRegionGreyItem ".concat(String.valueOf(localObject)));
    if (localCursor == null)
    {
      localObject = new ak();
      AppMethodBeat.o(70625);
      return localObject;
    }
    localObject = new ak();
    if (localCursor.moveToNext())
    {
      localObject = new ak();
      ((ak)localObject).convertFrom(localCursor);
    }
    Log.i("MicroMsg.WalletRegionGreyItemStg", "get grey item ");
    localCursor.close();
    AppMethodBeat.o(70625);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.j
 * JD-Core Version:    0.7.0.1
 */