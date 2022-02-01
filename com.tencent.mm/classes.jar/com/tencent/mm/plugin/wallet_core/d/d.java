package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends MAutoStorage<Bankcard>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  private List<Object> listeners;
  
  static
  {
    AppMethodBeat.i(70611);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(Bankcard.info, "WalletBankcard") };
    AppMethodBeat.o(70611);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, Bankcard.info, "WalletBankcard", null);
    AppMethodBeat.i(70600);
    this.listeners = new LinkedList();
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(70600);
  }
  
  public final boolean bwy()
  {
    AppMethodBeat.i(301105);
    boolean bool = this.db.execSQL("WalletBankcard", "delete from WalletBankcard");
    AppMethodBeat.o(301105);
    return bool;
  }
  
  public final boolean i(Bankcard paramBankcard)
  {
    AppMethodBeat.i(70607);
    if (super.insert(paramBankcard))
    {
      paramBankcard = this.listeners.iterator();
      while (paramBankcard.hasNext()) {
        paramBankcard.next();
      }
      AppMethodBeat.o(70607);
      return true;
    }
    AppMethodBeat.o(70607);
    return false;
  }
  
  public final ArrayList<Bankcard> ijB()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(70601);
    Object localObject = "select * from WalletBankcard where cardType <= 7 OR cardType & " + Bankcard.VDh + " != 0";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(70601);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        Bankcard localBankcard = new Bankcard();
        localBankcard.convertFrom((Cursor)localObject);
        localArrayList.add(localBankcard);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(70601);
    return localArrayList;
  }
  
  public final Bankcard ikl()
  {
    Bankcard localBankcard = null;
    AppMethodBeat.i(70602);
    Object localObject = "select * from WalletBankcard where cardType & " + Bankcard.VDd + " != 0 ";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(70602);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localBankcard = new Bankcard();
      localBankcard.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(70602);
    return localBankcard;
  }
  
  public final Bankcard ikm()
  {
    Bankcard localBankcard = null;
    AppMethodBeat.i(70603);
    Object localObject = "select * from WalletBankcard where cardType & " + Bankcard.VDg + " != 0 ";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(70603);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localBankcard = new Bankcard();
      localBankcard.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(70603);
    return localBankcard;
  }
  
  public final ArrayList<Bankcard> ikn()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(70604);
    Object localObject = "select * from WalletBankcard where cardType & " + Bankcard.VDc + " != 0 ";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(70604);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        Bankcard localBankcard = new Bankcard();
        localBankcard.convertFrom((Cursor)localObject);
        localArrayList.add(localBankcard);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(70604);
    return localArrayList;
  }
  
  public final Bankcard iko()
  {
    Bankcard localBankcard = null;
    AppMethodBeat.i(70605);
    Object localObject = "select * from WalletBankcard where cardType & " + Bankcard.VDe + " != 0 ";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(70605);
      return null;
    }
    if (((Cursor)localObject).moveToNext())
    {
      localBankcard = new Bankcard();
      localBankcard.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(70605);
    return localBankcard;
  }
  
  public final boolean lZ(List<Bankcard> paramList)
  {
    AppMethodBeat.i(70606);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      super.insert((Bankcard)paramList.next());
    }
    paramList = this.listeners.iterator();
    while (paramList.hasNext()) {
      paramList.next();
    }
    AppMethodBeat.o(70606);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.d
 * JD-Core Version:    0.7.0.1
 */