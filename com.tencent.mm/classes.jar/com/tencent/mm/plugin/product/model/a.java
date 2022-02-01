package com.tencent.mm.plugin.product.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.aou;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public static String I(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(66854);
    if (paramInt1 == paramInt2)
    {
      paramString = d(paramInt1, paramString);
      AppMethodBeat.o(66854);
      return paramString;
    }
    paramString = String.format("%s~%s", new Object[] { d(paramInt2, paramString), d(paramInt1, paramString) });
    AppMethodBeat.o(66854);
    return paramString;
  }
  
  public static String a(Context paramContext, aou paramaou)
  {
    AppMethodBeat.i(66856);
    if (paramaou.YYF > 0)
    {
      paramContext = paramaou.IGU + " " + d(paramaou.YYF, paramaou.Zuw);
      AppMethodBeat.o(66856);
      return paramContext;
    }
    paramContext = paramContext.getString(a.i.mall_product_submit_price_express_free);
    AppMethodBeat.o(66856);
    return paramContext;
  }
  
  public static String d(double paramDouble, String paramString)
  {
    AppMethodBeat.i(66855);
    if (("CNY".equals(paramString)) || ("1".equals(paramString)) || (Util.isNullOrNil(paramString)))
    {
      paramString = String.format("¥%.2f", new Object[] { Double.valueOf(paramDouble / 100.0D) });
      AppMethodBeat.o(66855);
      return paramString;
    }
    paramString = String.format("%s%.2f", new Object[] { paramString, Double.valueOf(paramDouble / 100.0D) });
    AppMethodBeat.o(66855);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.model.a
 * JD-Core Version:    0.7.0.1
 */