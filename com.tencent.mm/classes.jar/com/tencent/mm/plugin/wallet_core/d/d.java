package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends j<Bankcard>
{
  public static final String[] SQL_CREATE;
  public e db;
  private List<Object> listeners;
  
  static
  {
    AppMethodBeat.i(70611);
    SQL_CREATE = new String[] { j.getCreateSQLs(Bankcard.info, "WalletBankcard") };
    AppMethodBeat.o(70611);
  }
  
  public d(e parame)
  {
    super(parame, Bankcard.info, "WalletBankcard", null);
    AppMethodBeat.i(70600);
    this.listeners = new LinkedList();
    this.db = parame;
    AppMethodBeat.o(70600);
  }
  
  public final ArrayList<Bankcard> ecZ()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(70601);
    Object localObject = "select * from WalletBankcard where cardType <= 7 OR cardType & " + Bankcard.AbN + " != 0";
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final Bankcard edA()
  {
    Bankcard localBankcard = null;
    AppMethodBeat.i(70602);
    Object localObject = "select * from WalletBankcard where cardType & " + Bankcard.AbJ + " != 0 ";
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final Bankcard edB()
  {
    Bankcard localBankcard = null;
    AppMethodBeat.i(70603);
    Object localObject = "select * from WalletBankcard where cardType & " + Bankcard.AbM + " != 0 ";
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final ArrayList<Bankcard> edC()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(70604);
    Object localObject = "select * from WalletBankcard where cardType & " + Bankcard.AbI + " != 0 ";
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final Bankcard edD()
  {
    Bankcard localBankcard = null;
    AppMethodBeat.i(70605);
    Object localObject = "select * from WalletBankcard where cardType & " + Bankcard.AbK + " != 0 ";
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final boolean f(Bankcard paramBankcard)
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
  
  public final boolean go(List<Bankcard> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.d
 * JD-Core Version:    0.7.0.1
 */