package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  extends com.tencent.mm.sdk.e.j<aj>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(70626);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(aj.info, "WalletRegionGreyAreaList") };
    AppMethodBeat.o(70626);
  }
  
  public j(e parame)
  {
    super(parame, aj.info, "WalletRegionGreyAreaList", null);
    this.db = parame;
  }
  
  public final aj VD(int paramInt)
  {
    AppMethodBeat.i(70625);
    Object localObject = "select * from WalletRegionGreyAreaList where wallet_region = ".concat(String.valueOf(paramInt));
    Cursor localCursor = this.db.a((String)localObject, null, 2);
    ad.i("MicroMsg.WalletRegionGreyItemStg", "getWalletRegionGreyItem ".concat(String.valueOf(localObject)));
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
    ad.i("MicroMsg.WalletRegionGreyItemStg", "get grey item ");
    localCursor.close();
    AppMethodBeat.o(70625);
    return localObject;
  }
  
  public final void a(int paramInt, cjd paramcjd)
  {
    AppMethodBeat.i(70624);
    aj localaj = new aj();
    localaj.field_wallet_region = paramInt;
    try
    {
      localaj.field_wallet_grey_item_buf = paramcjd.toByteArray();
      super.replace(localaj);
      AppMethodBeat.o(70624);
      return;
    }
    catch (Exception paramcjd)
    {
      for (;;)
      {
        ad.e("MicroMsg.WalletRegionGreyItemStg", "setWalletRegionGreyItem error " + paramcjd.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.j
 * JD-Core Version:    0.7.0.1
 */