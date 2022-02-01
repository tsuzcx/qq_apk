package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.model.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.List;

public final class x
{
  public List<ElementQuery> DgL = null;
  public SparseArray<String> DrT = null;
  public List<a> DrU;
  
  public final ElementQuery aFJ(String paramString)
  {
    AppMethodBeat.i(70412);
    if ((this.DgL != null) && (this.DgL.size() != 0))
    {
      Iterator localIterator = this.DgL.iterator();
      while (localIterator.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)localIterator.next();
        if ((localElementQuery.dlT != null) && (localElementQuery.dlT.equals(paramString)))
        {
          AppMethodBeat.o(70412);
          return localElementQuery;
        }
      }
      ae.w("MicroMsg.WalletBankElementManager", "hy: not found given banktype: %s", new Object[] { paramString });
      AppMethodBeat.o(70412);
      return null;
    }
    ae.w("MicroMsg.WalletBankElementManager", "hy: no element from given banktype");
    AppMethodBeat.o(70412);
    return null;
  }
  
  public final ElementQuery aFK(String paramString)
  {
    AppMethodBeat.i(70413);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.WalletBankElementManager", "hy: bindSerail given is null");
      AppMethodBeat.o(70413);
      return null;
    }
    if ((this.DgL != null) && (this.DgL.size() != 0))
    {
      Iterator localIterator = this.DgL.iterator();
      while (localIterator.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)localIterator.next();
        if (paramString.equals(localElementQuery.wRt))
        {
          AppMethodBeat.o(70413);
          return localElementQuery;
        }
      }
      ae.w("MicroMsg.WalletBankElementManager", "hy: not found given element query");
      AppMethodBeat.o(70413);
      return null;
    }
    ae.w("MicroMsg.WalletBankElementManager", "hy: element list is null. get element failed");
    AppMethodBeat.o(70413);
    return null;
  }
  
  public final String am(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(70411);
    if (this.DrT != null)
    {
      String str = (String)this.DrT.get(paramInt);
      if (!bu.isNullOrNil(str))
      {
        AppMethodBeat.o(70411);
        return str;
      }
    }
    paramContext = paramContext.getString(2131765105);
    AppMethodBeat.o(70411);
    return paramContext;
  }
  
  public final String gQ(Context paramContext)
  {
    AppMethodBeat.i(70410);
    paramContext = am(paramContext, t.eJf().eJR());
    AppMethodBeat.o(70410);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.x
 * JD-Core Version:    0.7.0.1
 */