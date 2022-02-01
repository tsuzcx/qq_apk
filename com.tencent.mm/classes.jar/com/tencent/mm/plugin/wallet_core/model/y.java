package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.model.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class y
{
  public List<ElementQuery> OIn = null;
  public SparseArray<String> OTq = null;
  public List<a> OTr;
  
  public final String aN(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(70411);
    if (this.OTq != null)
    {
      String str = (String)this.OTq.get(paramInt);
      if (!Util.isNullOrNil(str))
      {
        AppMethodBeat.o(70411);
        return str;
      }
    }
    paramContext = paramContext.getString(a.i.wallet_card_cre_type_default);
    AppMethodBeat.o(70411);
    return paramContext;
  }
  
  public final ElementQuery bgR(String paramString)
  {
    AppMethodBeat.i(70412);
    if ((this.OIn != null) && (this.OIn.size() != 0))
    {
      Iterator localIterator = this.OIn.iterator();
      while (localIterator.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)localIterator.next();
        if ((localElementQuery.fvP != null) && (localElementQuery.fvP.equals(paramString)))
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
  
  public final ElementQuery bgS(String paramString)
  {
    AppMethodBeat.i(70413);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.WalletBankElementManager", "hy: bindSerail given is null");
      AppMethodBeat.o(70413);
      return null;
    }
    if ((this.OIn != null) && (this.OIn.size() != 0))
    {
      Iterator localIterator = this.OIn.iterator();
      while (localIterator.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)localIterator.next();
        if (paramString.equals(localElementQuery.GGC))
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
  
  public final String iR(Context paramContext)
  {
    AppMethodBeat.i(70410);
    paramContext = aN(paramContext, u.gJo().gKa());
    AppMethodBeat.o(70410);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.y
 * JD-Core Version:    0.7.0.1
 */