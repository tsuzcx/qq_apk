package com.tencent.mm.plugin.product.b;

import android.content.Context;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.wi;
import com.tencent.mm.sdk.platformtools.bk;

public final class b
{
  public static String a(Context paramContext, wi paramwi)
  {
    if (paramwi.sFS > 0) {
      return paramwi.kRZ + " " + c(paramwi.sFS, paramwi.sSo);
    }
    return paramContext.getString(a.i.mall_product_submit_price_express_free);
  }
  
  public static String c(double paramDouble, String paramString)
  {
    if (("CNY".equals(paramString)) || ("1".equals(paramString)) || (bk.bl(paramString))) {
      return String.format("¥%.2f", new Object[] { Double.valueOf(paramDouble / 100.0D) });
    }
    return String.format("%s%.2f", new Object[] { paramString, Double.valueOf(paramDouble / 100.0D) });
  }
  
  public static String p(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == paramInt2) {
      return c(paramInt1, paramString);
    }
    return String.format("%s~%s", new Object[] { c(paramInt2, paramString), c(paramInt1, paramString) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.b
 * JD-Core Version:    0.7.0.1
 */