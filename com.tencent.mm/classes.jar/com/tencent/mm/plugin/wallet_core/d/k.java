package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends j<am>
{
  public static final String[] SQL_CREATE;
  private e db;
  private List<Object> listeners;
  
  static
  {
    AppMethodBeat.i(70634);
    SQL_CREATE = new String[] { j.getCreateSQLs(am.info, "WalletUserInfo") };
    AppMethodBeat.o(70634);
  }
  
  public k(e parame)
  {
    super(parame, am.info, "WalletUserInfo", null);
    AppMethodBeat.i(70627);
    this.listeners = new LinkedList();
    ad.i("MicroMsg.WalletUserInfoStorage", "already call constructor.");
    this.db = parame;
    AppMethodBeat.o(70627);
  }
  
  public final boolean aSJ()
  {
    AppMethodBeat.i(70630);
    boolean bool = this.db.execSQL("WalletUserInfo", "delete from WalletUserInfo");
    AppMethodBeat.o(70630);
    return bool;
  }
  
  public final boolean b(am paramam)
  {
    AppMethodBeat.i(70629);
    if (super.insert(paramam))
    {
      paramam = this.listeners.iterator();
      while (paramam.hasNext()) {
        paramam.next();
      }
      AppMethodBeat.o(70629);
      return true;
    }
    AppMethodBeat.o(70629);
    return false;
  }
  
  public final am eHg()
  {
    AppMethodBeat.i(70628);
    am localam = new am();
    Cursor localCursor = this.db.a("select * from WalletUserInfo", null, 2);
    localam.field_is_reg = -1;
    if (localCursor == null)
    {
      AppMethodBeat.o(70628);
      return localam;
    }
    if (localCursor.moveToNext()) {
      localam.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(70628);
    return localam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.k
 * JD-Core Version:    0.7.0.1
 */