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

public final class c
  extends j<Bankcard>
{
  public static final String[] SQL_CREATE;
  private List<Object> aTm;
  public e db;
  
  static
  {
    AppMethodBeat.i(47071);
    SQL_CREATE = new String[] { j.getCreateSQLs(Bankcard.info, "WalletBankcard") };
    AppMethodBeat.o(47071);
  }
  
  public c(e parame)
  {
    super(parame, Bankcard.info, "WalletBankcard", null);
    AppMethodBeat.i(47059);
    this.aTm = new LinkedList();
    this.db = parame;
    AppMethodBeat.o(47059);
  }
  
  public final boolean aql()
  {
    AppMethodBeat.i(47067);
    boolean bool = this.db.execSQL("WalletBankcard", "delete from WalletBankcard");
    AppMethodBeat.o(47067);
    return bool;
  }
  
  public final ArrayList<Bankcard> cUF()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(47060);
    Object localObject = "select * from WalletBankcard where cardType <= 7 OR cardType & " + Bankcard.ufF + " != 0";
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(47060);
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
    AppMethodBeat.o(47060);
    return localArrayList;
  }
  
  public final Bankcard cVg()
  {
    Bankcard localBankcard = null;
    AppMethodBeat.i(47061);
    Object localObject = "select * from WalletBankcard where cardType & " + Bankcard.ufB + " != 0 ";
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(47061);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localBankcard = new Bankcard();
      localBankcard.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(47061);
    return localBankcard;
  }
  
  public final Bankcard cVh()
  {
    Bankcard localBankcard = null;
    AppMethodBeat.i(47062);
    Object localObject = "select * from WalletBankcard where cardType & " + Bankcard.ufE + " != 0 ";
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(47062);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localBankcard = new Bankcard();
      localBankcard.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(47062);
    return localBankcard;
  }
  
  public final ArrayList<Bankcard> cVi()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(47063);
    Object localObject = "select * from WalletBankcard where cardType & " + Bankcard.ufA + " != 0 ";
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(47063);
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
    AppMethodBeat.o(47063);
    return localArrayList;
  }
  
  public final Bankcard cVj()
  {
    Bankcard localBankcard = null;
    AppMethodBeat.i(47064);
    Object localObject = "select * from WalletBankcard where cardType & " + Bankcard.ufC + " != 0 ";
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(47064);
      return null;
    }
    if (((Cursor)localObject).moveToNext())
    {
      localBankcard = new Bankcard();
      localBankcard.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(47064);
    return localBankcard;
  }
  
  public final boolean dY(List<Bankcard> paramList)
  {
    AppMethodBeat.i(47065);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      super.insert((Bankcard)paramList.next());
    }
    paramList = this.aTm.iterator();
    while (paramList.hasNext()) {
      paramList.next();
    }
    AppMethodBeat.o(47065);
    return true;
  }
  
  public final boolean f(Bankcard paramBankcard)
  {
    AppMethodBeat.i(47066);
    if (super.insert(paramBankcard))
    {
      paramBankcard = this.aTm.iterator();
      while (paramBankcard.hasNext()) {
        paramBankcard.next();
      }
      AppMethodBeat.o(47066);
      return true;
    }
    AppMethodBeat.o(47066);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.c
 * JD-Core Version:    0.7.0.1
 */