package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public final class q
{
  public List<ElementQuery> qqW = null;
  public SparseArray<String> qyy = null;
  
  public final String O(Context paramContext, int paramInt)
  {
    if (this.qyy != null)
    {
      String str = (String)this.qyy.get(paramInt);
      if (!bk.bl(str)) {
        return str;
      }
    }
    return paramContext.getString(a.i.wallet_card_cre_type_default);
  }
  
  public final ElementQuery Qp(String paramString)
  {
    if ((this.qqW != null) && (this.qqW.size() != 0))
    {
      Iterator localIterator = this.qqW.iterator();
      while (localIterator.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)localIterator.next();
        if ((localElementQuery.mOb != null) && (localElementQuery.mOb.equals(paramString))) {
          return localElementQuery;
        }
      }
      y.w("MicroMsg.WalletBankElementManager", "hy: not found given banktype: %s", new Object[] { paramString });
      return null;
    }
    y.w("MicroMsg.WalletBankElementManager", "hy: no element from given banktype");
    return null;
  }
  
  public final ElementQuery Qq(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.WalletBankElementManager", "hy: bindSerail given is null");
      return null;
    }
    if ((this.qqW != null) && (this.qqW.size() != 0))
    {
      Iterator localIterator = this.qqW.iterator();
      while (localIterator.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)localIterator.next();
        if (paramString.equals(localElementQuery.mOc)) {
          return localElementQuery;
        }
      }
      y.w("MicroMsg.WalletBankElementManager", "hy: not found given element query");
      return null;
    }
    y.w("MicroMsg.WalletBankElementManager", "hy: element list is null. get element failed");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.q
 * JD-Core Version:    0.7.0.1
 */