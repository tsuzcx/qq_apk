package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends i<af>
{
  public static final String[] dXp = { i.a(af.buS, "WalletUserInfo") };
  private List<Object> aLS = new LinkedList();
  public e dXw;
  
  public j(e parame)
  {
    super(parame, af.buS, "WalletUserInfo", null);
    y.i("MicroMsg.WalletUserInfoStorage", "already call constructor.");
    this.dXw = parame;
  }
  
  public final boolean a(af paramaf)
  {
    if (super.b(paramaf))
    {
      paramaf = this.aLS.iterator();
      while (paramaf.hasNext()) {
        paramaf.next();
      }
      return true;
    }
    return false;
  }
  
  public final af bWq()
  {
    af localaf = new af();
    Cursor localCursor = this.dXw.a("select * from WalletUserInfo", null, 2);
    localaf.field_is_reg = -1;
    if (localCursor == null) {
      return localaf;
    }
    if (localCursor.moveToNext()) {
      localaf.d(localCursor);
    }
    localCursor.close();
    return localaf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.j
 * JD-Core Version:    0.7.0.1
 */