package com.tencent.mm.plugin.recharge.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public static MallRechargeProduct cI(List<MallRechargeProduct> paramList)
  {
    AppMethodBeat.i(44246);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MallRechargeProduct localMallRechargeProduct = (MallRechargeProduct)localIterator.next();
      if ((localMallRechargeProduct.isDefault) && (localMallRechargeProduct.isValid()))
      {
        ab.d("MicroMsg.MallRechargeLogic", "find the defaultProduct");
        AppMethodBeat.o(44246);
        return localMallRechargeProduct;
      }
    }
    ab.d("MicroMsg.MallRechargeLogic", "products.get(0)");
    paramList = (MallRechargeProduct)paramList.get(0);
    AppMethodBeat.o(44246);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.a
 * JD-Core Version:    0.7.0.1
 */