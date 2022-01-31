package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.ArrayList;

public final class f
  extends i<x>
{
  public static final String[] dXp = { i.a(x.buS, "WalletKindInfo") };
  public e dXw;
  
  public f(e parame)
  {
    super(parame, x.buS, "WalletKindInfo", null);
    this.dXw = parame;
  }
  
  public final ArrayList<x> bWp()
  {
    ArrayList localArrayList = null;
    Cursor localCursor = this.dXw.a("select * from WalletKindInfo", null, 2);
    if (localCursor == null) {
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        x localx = new x();
        localx.d(localCursor);
        localArrayList.add(localx);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.f
 * JD-Core Version:    0.7.0.1
 */