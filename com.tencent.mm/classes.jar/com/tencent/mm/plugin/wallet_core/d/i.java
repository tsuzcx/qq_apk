package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  extends com.tencent.mm.sdk.e.i<ac>
{
  public static final String[] dXp = { com.tencent.mm.sdk.e.i.a(ac.buS, "WalletRegionGreyAreaList") };
  private e dXw;
  
  public i(e parame)
  {
    super(parame, ac.buS, "WalletRegionGreyAreaList", null);
    this.dXw = parame;
  }
  
  public final ac AR(int paramInt)
  {
    Object localObject = "select * from WalletRegionGreyAreaList where wallet_region = " + paramInt;
    Cursor localCursor = this.dXw.a((String)localObject, null, 2);
    y.i("MicroMsg.WalletRegionGreyItemStg", "getWalletRegionGreyItem " + (String)localObject);
    if (localCursor == null) {
      return new ac();
    }
    localObject = new ac();
    if (localCursor.moveToNext())
    {
      localObject = new ac();
      ((ac)localObject).d(localCursor);
    }
    y.i("MicroMsg.WalletRegionGreyItemStg", "get grey item ");
    localCursor.close();
    return localObject;
  }
  
  public final void a(int paramInt, bdo parambdo)
  {
    ac localac = new ac();
    localac.field_wallet_region = paramInt;
    try
    {
      localac.field_wallet_grey_item_buf = parambdo.toByteArray();
      super.a(localac);
      return;
    }
    catch (Exception parambdo)
    {
      for (;;)
      {
        y.e("MicroMsg.WalletRegionGreyItemStg", "setWalletRegionGreyItem error " + parambdo.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.i
 * JD-Core Version:    0.7.0.1
 */