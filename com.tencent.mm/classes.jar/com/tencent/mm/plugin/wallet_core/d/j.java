package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends com.tencent.mm.sdk.e.j<al>
{
  public static final String[] SQL_CREATE;
  private List<Object> aTm;
  private e db;
  
  static
  {
    AppMethodBeat.i(47094);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(al.info, "WalletUserInfo") };
    AppMethodBeat.o(47094);
  }
  
  public j(e parame)
  {
    super(parame, al.info, "WalletUserInfo", null);
    AppMethodBeat.i(47087);
    this.aTm = new LinkedList();
    ab.i("MicroMsg.WalletUserInfoStorage", "already call constructor.");
    this.db = parame;
    AppMethodBeat.o(47087);
  }
  
  public final boolean aql()
  {
    AppMethodBeat.i(47090);
    boolean bool = this.db.execSQL("WalletUserInfo", "delete from WalletUserInfo");
    AppMethodBeat.o(47090);
    return bool;
  }
  
  public final boolean b(al paramal)
  {
    AppMethodBeat.i(47089);
    if (super.insert(paramal))
    {
      paramal = this.aTm.iterator();
      while (paramal.hasNext()) {
        paramal.next();
      }
      AppMethodBeat.o(47089);
      return true;
    }
    AppMethodBeat.o(47089);
    return false;
  }
  
  public final al cVl()
  {
    AppMethodBeat.i(47088);
    al localal = new al();
    Cursor localCursor = this.db.a("select * from WalletUserInfo", null, 2);
    localal.field_is_reg = -1;
    if (localCursor == null)
    {
      AppMethodBeat.o(47088);
      return localal;
    }
    if (localCursor.moveToNext()) {
      localal.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(47088);
    return localal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.j
 * JD-Core Version:    0.7.0.1
 */