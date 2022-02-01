package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.model.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.List;

public final class w
{
  public List<ElementQuery> BoS = null;
  public SparseArray<String> BzV = null;
  public List<a> BzW;
  
  public final String aj(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(70411);
    if (this.BzV != null)
    {
      String str = (String)this.BzV.get(paramInt);
      if (!bs.isNullOrNil(str))
      {
        AppMethodBeat.o(70411);
        return str;
      }
    }
    paramContext = paramContext.getString(2131765105);
    AppMethodBeat.o(70411);
    return paramContext;
  }
  
  public final ElementQuery azh(String paramString)
  {
    AppMethodBeat.i(70412);
    if ((this.BoS != null) && (this.BoS.size() != 0))
    {
      Iterator localIterator = this.BoS.iterator();
      while (localIterator.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)localIterator.next();
        if ((localElementQuery.cZz != null) && (localElementQuery.cZz.equals(paramString)))
        {
          AppMethodBeat.o(70412);
          return localElementQuery;
        }
      }
      ac.w("MicroMsg.WalletBankElementManager", "hy: not found given banktype: %s", new Object[] { paramString });
      AppMethodBeat.o(70412);
      return null;
    }
    ac.w("MicroMsg.WalletBankElementManager", "hy: no element from given banktype");
    AppMethodBeat.o(70412);
    return null;
  }
  
  public final ElementQuery azi(String paramString)
  {
    AppMethodBeat.i(70413);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.WalletBankElementManager", "hy: bindSerail given is null");
      AppMethodBeat.o(70413);
      return null;
    }
    if ((this.BoS != null) && (this.BoS.size() != 0))
    {
      Iterator localIterator = this.BoS.iterator();
      while (localIterator.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)localIterator.next();
        if (paramString.equals(localElementQuery.vwo))
        {
          AppMethodBeat.o(70413);
          return localElementQuery;
        }
      }
      ac.w("MicroMsg.WalletBankElementManager", "hy: not found given element query");
      AppMethodBeat.o(70413);
      return null;
    }
    ac.w("MicroMsg.WalletBankElementManager", "hy: element list is null. get element failed");
    AppMethodBeat.o(70413);
    return null;
  }
  
  public final String gH(Context paramContext)
  {
    AppMethodBeat.i(70410);
    paramContext = aj(paramContext, s.ery().esk());
    AppMethodBeat.o(70410);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.w
 * JD-Core Version:    0.7.0.1
 */