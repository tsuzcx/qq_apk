package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends MAutoStorage<an>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  private List<Object> listeners;
  
  static
  {
    AppMethodBeat.i(70634);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(an.info, "WalletUserInfo") };
    AppMethodBeat.o(70634);
  }
  
  public k(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, an.info, "WalletUserInfo", null);
    AppMethodBeat.i(70627);
    this.listeners = new LinkedList();
    Log.i("MicroMsg.WalletUserInfoStorage", "already call constructor.");
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(70627);
  }
  
  public final boolean b(an paraman)
  {
    AppMethodBeat.i(70629);
    if (super.insert(paraman))
    {
      paraman = this.listeners.iterator();
      while (paraman.hasNext()) {
        paraman.next();
      }
      AppMethodBeat.o(70629);
      return true;
    }
    AppMethodBeat.o(70629);
    return false;
  }
  
  public final boolean byd()
  {
    AppMethodBeat.i(70630);
    boolean bool = this.db.execSQL("WalletUserInfo", "delete from WalletUserInfo");
    AppMethodBeat.o(70630);
    return bool;
  }
  
  public final an gKZ()
  {
    AppMethodBeat.i(70628);
    an localan = new an();
    Cursor localCursor = this.db.rawQuery("select * from WalletUserInfo", null, 2);
    localan.field_is_reg = -1;
    if (localCursor == null)
    {
      AppMethodBeat.o(70628);
      return localan;
    }
    if (localCursor.moveToNext()) {
      localan.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(70628);
    return localan;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.k
 * JD-Core Version:    0.7.0.1
 */