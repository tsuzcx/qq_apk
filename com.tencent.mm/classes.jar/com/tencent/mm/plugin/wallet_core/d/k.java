package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends MAutoStorage<al>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  private List<Object> listeners;
  
  static
  {
    AppMethodBeat.i(70634);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(al.info, "WalletUserInfo") };
    AppMethodBeat.o(70634);
  }
  
  public k(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, al.info, "WalletUserInfo", null);
    AppMethodBeat.i(70627);
    this.listeners = new LinkedList();
    Log.i("MicroMsg.WalletUserInfoStorage", "already call constructor.");
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(70627);
  }
  
  public final boolean b(al paramal)
  {
    AppMethodBeat.i(70629);
    if (super.insert(paramal))
    {
      paramal = this.listeners.iterator();
      while (paramal.hasNext()) {
        paramal.next();
      }
      AppMethodBeat.o(70629);
      return true;
    }
    AppMethodBeat.o(70629);
    return false;
  }
  
  public final boolean bwy()
  {
    AppMethodBeat.i(70630);
    boolean bool = this.db.execSQL("WalletUserInfo", "delete from WalletUserInfo");
    AppMethodBeat.o(70630);
    return bool;
  }
  
  public final al ijK()
  {
    AppMethodBeat.i(70628);
    al localal = new al();
    Cursor localCursor = this.db.rawQuery("select * from WalletUserInfo", null, 2);
    localal.field_is_reg = -1;
    if (localCursor == null)
    {
      AppMethodBeat.o(70628);
      return localal;
    }
    if (localCursor.moveToNext()) {
      localal.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(70628);
    return localal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.k
 * JD-Core Version:    0.7.0.1
 */