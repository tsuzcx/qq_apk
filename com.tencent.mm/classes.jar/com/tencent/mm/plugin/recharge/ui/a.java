package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public static MallRechargeProduct cf(List<MallRechargeProduct> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MallRechargeProduct localMallRechargeProduct = (MallRechargeProduct)localIterator.next();
      if ((localMallRechargeProduct.isDefault) && (localMallRechargeProduct.isValid()))
      {
        y.d("MicroMsg.MallRechargeLogic", "find the defaultProduct");
        return localMallRechargeProduct;
      }
    }
    y.d("MicroMsg.MallRechargeLogic", "products.get(0)");
    return (MallRechargeProduct)paramList.get(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.a
 * JD-Core Version:    0.7.0.1
 */