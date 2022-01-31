package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends i<Bankcard>
{
  public static final String[] dXp = { i.a(Bankcard.buS, "WalletBankcard") };
  private List<Object> aLS = new LinkedList();
  public e dXw;
  
  public c(e parame)
  {
    super(parame, Bankcard.buS, "WalletBankcard", null);
    this.dXw = parame;
  }
  
  public final ArrayList<Bankcard> bVZ()
  {
    ArrayList localArrayList = null;
    Cursor localCursor = this.dXw.a("select * from WalletBankcard where cardType <= 7", null, 2);
    if (localCursor == null) {
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        Bankcard localBankcard = new Bankcard();
        localBankcard.d(localCursor);
        localArrayList.add(localBankcard);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    return localArrayList;
  }
  
  public final ArrayList<Bankcard> bWo()
  {
    ArrayList localArrayList = null;
    Object localObject = "select * from WalletBankcard where cardType & " + Bankcard.qtn + " != 0 ";
    localObject = this.dXw.a((String)localObject, null, 2);
    if (localObject == null) {
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        Bankcard localBankcard = new Bankcard();
        localBankcard.d((Cursor)localObject);
        localArrayList.add(localBankcard);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    return localArrayList;
  }
  
  public final boolean cV(List<Bankcard> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      super.b((Bankcard)paramList.next());
    }
    paramList = this.aLS.iterator();
    while (paramList.hasNext()) {
      paramList.next();
    }
    return true;
  }
  
  public final boolean e(Bankcard paramBankcard)
  {
    if (super.b(paramBankcard))
    {
      paramBankcard = this.aLS.iterator();
      while (paramBankcard.hasNext()) {
        paramBankcard.next();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.c
 * JD-Core Version:    0.7.0.1
 */