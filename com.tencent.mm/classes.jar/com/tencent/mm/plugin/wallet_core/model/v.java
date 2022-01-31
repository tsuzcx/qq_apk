package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

public final class v
{
  public List<ElementQuery> ubS = null;
  public SparseArray<String> ulh = null;
  
  public final String ab(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(46888);
    if (this.ulh != null)
    {
      String str = (String)this.ulh.get(paramInt);
      if (!bo.isNullOrNil(str))
      {
        AppMethodBeat.o(46888);
        return str;
      }
    }
    paramContext = paramContext.getString(2131304913);
    AppMethodBeat.o(46888);
    return paramContext;
  }
  
  public final ElementQuery afh(String paramString)
  {
    AppMethodBeat.i(46889);
    if ((this.ubS != null) && (this.ubS.size() != 0))
    {
      Iterator localIterator = this.ubS.iterator();
      while (localIterator.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)localIterator.next();
        if ((localElementQuery.poq != null) && (localElementQuery.poq.equals(paramString)))
        {
          AppMethodBeat.o(46889);
          return localElementQuery;
        }
      }
      ab.w("MicroMsg.WalletBankElementManager", "hy: not found given banktype: %s", new Object[] { paramString });
      AppMethodBeat.o(46889);
      return null;
    }
    ab.w("MicroMsg.WalletBankElementManager", "hy: no element from given banktype");
    AppMethodBeat.o(46889);
    return null;
  }
  
  public final ElementQuery afi(String paramString)
  {
    AppMethodBeat.i(46890);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.WalletBankElementManager", "hy: bindSerail given is null");
      AppMethodBeat.o(46890);
      return null;
    }
    if ((this.ubS != null) && (this.ubS.size() != 0))
    {
      Iterator localIterator = this.ubS.iterator();
      while (localIterator.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)localIterator.next();
        if (paramString.equals(localElementQuery.por))
        {
          AppMethodBeat.o(46890);
          return localElementQuery;
        }
      }
      ab.w("MicroMsg.WalletBankElementManager", "hy: not found given element query");
      AppMethodBeat.o(46890);
      return null;
    }
    ab.w("MicroMsg.WalletBankElementManager", "hy: element list is null. get element failed");
    AppMethodBeat.o(46890);
    return null;
  }
  
  public final String fq(Context paramContext)
  {
    AppMethodBeat.i(46887);
    paramContext = ab(paramContext, t.cTN().cUv());
    AppMethodBeat.o(46887);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.v
 * JD-Core Version:    0.7.0.1
 */