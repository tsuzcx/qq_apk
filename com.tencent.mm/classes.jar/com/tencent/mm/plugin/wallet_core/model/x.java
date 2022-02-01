package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.model.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class x
{
  public List<ElementQuery> HQe = null;
  public SparseArray<String> Ibf = null;
  public List<a> Ibg;
  
  public final ElementQuery aVi(String paramString)
  {
    AppMethodBeat.i(70412);
    if ((this.HQe != null) && (this.HQe.size() != 0))
    {
      Iterator localIterator = this.HQe.iterator();
      while (localIterator.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)localIterator.next();
        if ((localElementQuery.dDj != null) && (localElementQuery.dDj.equals(paramString)))
        {
          AppMethodBeat.o(70412);
          return localElementQuery;
        }
      }
      Log.w("MicroMsg.WalletBankElementManager", "hy: not found given banktype: %s", new Object[] { paramString });
      AppMethodBeat.o(70412);
      return null;
    }
    Log.w("MicroMsg.WalletBankElementManager", "hy: no element from given banktype");
    AppMethodBeat.o(70412);
    return null;
  }
  
  public final ElementQuery aVj(String paramString)
  {
    AppMethodBeat.i(70413);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.WalletBankElementManager", "hy: bindSerail given is null");
      AppMethodBeat.o(70413);
      return null;
    }
    if ((this.HQe != null) && (this.HQe.size() != 0))
    {
      Iterator localIterator = this.HQe.iterator();
      while (localIterator.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)localIterator.next();
        if (paramString.equals(localElementQuery.ANo))
        {
          AppMethodBeat.o(70413);
          return localElementQuery;
        }
      }
      Log.w("MicroMsg.WalletBankElementManager", "hy: not found given element query");
      AppMethodBeat.o(70413);
      return null;
    }
    Log.w("MicroMsg.WalletBankElementManager", "hy: element list is null. get element failed");
    AppMethodBeat.o(70413);
    return null;
  }
  
  public final String av(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(70411);
    if (this.Ibf != null)
    {
      String str = (String)this.Ibf.get(paramInt);
      if (!Util.isNullOrNil(str))
      {
        AppMethodBeat.o(70411);
        return str;
      }
    }
    paramContext = paramContext.getString(2131767548);
    AppMethodBeat.o(70411);
    return paramContext;
  }
  
  public final String hM(Context paramContext)
  {
    AppMethodBeat.i(70410);
    paramContext = av(paramContext, t.fQI().fRu());
    AppMethodBeat.o(70410);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.x
 * JD-Core Version:    0.7.0.1
 */