package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;

public final class j
  extends com.tencent.mm.sdk.e.j<ai>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(70626);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(ai.info, "WalletRegionGreyAreaList") };
    AppMethodBeat.o(70626);
  }
  
  public j(e parame)
  {
    super(parame, ai.info, "WalletRegionGreyAreaList", null);
    this.db = parame;
  }
  
  public final ai TL(int paramInt)
  {
    AppMethodBeat.i(70625);
    Object localObject = "select * from WalletRegionGreyAreaList where wallet_region = ".concat(String.valueOf(paramInt));
    Cursor localCursor = this.db.a((String)localObject, null, 2);
    ac.i("MicroMsg.WalletRegionGreyItemStg", "getWalletRegionGreyItem ".concat(String.valueOf(localObject)));
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
    ac.i("MicroMsg.WalletRegionGreyItemStg", "get grey item ");
    localCursor.close();
    AppMethodBeat.o(70625);
    return localObject;
  }
  
  public final void a(int paramInt, cee paramcee)
  {
    AppMethodBeat.i(70624);
    ai localai = new ai();
    localai.field_wallet_region = paramInt;
    try
    {
      localai.field_wallet_grey_item_buf = paramcee.toByteArray();
      super.replace(localai);
      AppMethodBeat.o(70624);
      return;
    }
    catch (Exception paramcee)
    {
      for (;;)
      {
        ac.e("MicroMsg.WalletRegionGreyItemStg", "setWalletRegionGreyItem error " + paramcee.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.j
 * JD-Core Version:    0.7.0.1
 */