package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.protocal.protobuf.bli;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  extends j<ai>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(47086);
    SQL_CREATE = new String[] { j.getCreateSQLs(ai.info, "WalletRegionGreyAreaList") };
    AppMethodBeat.o(47086);
  }
  
  public i(e parame)
  {
    super(parame, ai.info, "WalletRegionGreyAreaList", null);
    this.db = parame;
  }
  
  public final ai IC(int paramInt)
  {
    AppMethodBeat.i(47085);
    Object localObject = "select * from WalletRegionGreyAreaList where wallet_region = ".concat(String.valueOf(paramInt));
    Cursor localCursor = this.db.a((String)localObject, null, 2);
    ab.i("MicroMsg.WalletRegionGreyItemStg", "getWalletRegionGreyItem ".concat(String.valueOf(localObject)));
    if (localCursor == null)
    {
      localObject = new ai();
      AppMethodBeat.o(47085);
      return localObject;
    }
    localObject = new ai();
    if (localCursor.moveToNext())
    {
      localObject = new ai();
      ((ai)localObject).convertFrom(localCursor);
    }
    ab.i("MicroMsg.WalletRegionGreyItemStg", "get grey item ");
    localCursor.close();
    AppMethodBeat.o(47085);
    return localObject;
  }
  
  public final void a(int paramInt, bli parambli)
  {
    AppMethodBeat.i(47084);
    ai localai = new ai();
    localai.field_wallet_region = paramInt;
    try
    {
      localai.field_wallet_grey_item_buf = parambli.toByteArray();
      super.replace(localai);
      AppMethodBeat.o(47084);
      return;
    }
    catch (Exception parambli)
    {
      for (;;)
      {
        ab.e("MicroMsg.WalletRegionGreyItemStg", "setWalletRegionGreyItem error " + parambli.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.i
 * JD-Core Version:    0.7.0.1
 */