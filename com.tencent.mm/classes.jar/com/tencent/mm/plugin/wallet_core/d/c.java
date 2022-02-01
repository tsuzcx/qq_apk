package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.BankcardScene;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends MAutoStorage<BankcardScene>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  private List<Object> listeners;
  
  static
  {
    AppMethodBeat.i(70599);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(BankcardScene.info, "WalletBankcardScene") };
    AppMethodBeat.o(70599);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, BankcardScene.info, "WalletBankcardScene", BankcardScene.INDEX_CREATE);
    AppMethodBeat.i(70591);
    this.listeners = new LinkedList();
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(70591);
  }
  
  public final boolean a(BankcardScene paramBankcardScene)
  {
    AppMethodBeat.i(70593);
    if (super.insert(paramBankcardScene))
    {
      paramBankcardScene = this.listeners.iterator();
      while (paramBankcardScene.hasNext()) {
        paramBankcardScene.next();
      }
      AppMethodBeat.o(70593);
      return true;
    }
    AppMethodBeat.o(70593);
    return false;
  }
  
  public final ArrayList<BankcardScene> aso(int paramInt)
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(301087);
    Object localObject = "select * from WalletBankcardScene where scene=".concat(String.valueOf(paramInt));
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(301087);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        BankcardScene localBankcardScene = new BankcardScene();
        localBankcardScene.convertFrom((Cursor)localObject);
        localArrayList.add(localBankcardScene);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(301087);
    return localArrayList;
  }
  
  public final boolean asp(int paramInt)
  {
    AppMethodBeat.i(70595);
    String str = "delete from WalletBankcardScene where scene=".concat(String.valueOf(paramInt));
    boolean bool = this.db.execSQL("WalletBankcardScene", str);
    AppMethodBeat.o(70595);
    return bool;
  }
  
  public final boolean lZ(List<BankcardScene> paramList)
  {
    AppMethodBeat.i(70592);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      super.insert((BankcardScene)paramList.next());
    }
    paramList = this.listeners.iterator();
    while (paramList.hasNext()) {
      paramList.next();
    }
    AppMethodBeat.o(70592);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.c
 * JD-Core Version:    0.7.0.1
 */