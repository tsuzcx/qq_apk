package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.model.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;

public final class x
{
  public List<ElementQuery> CPh = null;
  public SparseArray<String> Dao = null;
  public List<a> Dap;
  
  public final ElementQuery aEp(String paramString)
  {
    AppMethodBeat.i(70412);
    if ((this.CPh != null) && (this.CPh.size() != 0))
    {
      Iterator localIterator = this.CPh.iterator();
      while (localIterator.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)localIterator.next();
        if ((localElementQuery.dkR != null) && (localElementQuery.dkR.equals(paramString)))
        {
          AppMethodBeat.o(70412);
          return localElementQuery;
        }
      }
      ad.w("MicroMsg.WalletBankElementManager", "hy: not found given banktype: %s", new Object[] { paramString });
      AppMethodBeat.o(70412);
      return null;
    }
    ad.w("MicroMsg.WalletBankElementManager", "hy: no element from given banktype");
    AppMethodBeat.o(70412);
    return null;
  }
  
  public final ElementQuery aEq(String paramString)
  {
    AppMethodBeat.i(70413);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.WalletBankElementManager", "hy: bindSerail given is null");
      AppMethodBeat.o(70413);
      return null;
    }
    if ((this.CPh != null) && (this.CPh.size() != 0))
    {
      Iterator localIterator = this.CPh.iterator();
      while (localIterator.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)localIterator.next();
        if (paramString.equals(localElementQuery.wBI))
        {
          AppMethodBeat.o(70413);
          return localElementQuery;
        }
      }
      ad.w("MicroMsg.WalletBankElementManager", "hy: not found given element query");
      AppMethodBeat.o(70413);
      return null;
    }
    ad.w("MicroMsg.WalletBankElementManager", "hy: element list is null. get element failed");
    AppMethodBeat.o(70413);
    return null;
  }
  
  public final String am(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(70411);
    if (this.Dao != null)
    {
      String str = (String)this.Dao.get(paramInt);
      if (!bt.isNullOrNil(str))
      {
        AppMethodBeat.o(70411);
        return str;
      }
    }
    paramContext = paramContext.getString(2131765105);
    AppMethodBeat.o(70411);
    return paramContext;
  }
  
  public final String gL(Context paramContext)
  {
    AppMethodBeat.i(70410);
    paramContext = am(paramContext, t.eFy().eGk());
    AppMethodBeat.o(70410);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.x
 * JD-Core Version:    0.7.0.1
 */