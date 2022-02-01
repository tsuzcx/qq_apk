package com.tencent.mm.plugin.product.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
{
  public static String D(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(66854);
    if (paramInt1 == paramInt2)
    {
      paramString = c(paramInt1, paramString);
      AppMethodBeat.o(66854);
      return paramString;
    }
    paramString = String.format("%s~%s", new Object[] { c(paramInt2, paramString), c(paramInt1, paramString) });
    AppMethodBeat.o(66854);
    return paramString;
  }
  
  public static String a(Context paramContext, aec paramaec)
  {
    AppMethodBeat.i(66856);
    if (paramaec.CNG > 0)
    {
      paramContext = paramaec.Name + " " + c(paramaec.CNG, paramaec.PriceType);
      AppMethodBeat.o(66856);
      return paramContext;
    }
    paramContext = paramContext.getString(2131761147);
    AppMethodBeat.o(66856);
    return paramContext;
  }
  
  public static String c(double paramDouble, String paramString)
  {
    AppMethodBeat.i(66855);
    if (("CNY".equals(paramString)) || ("1".equals(paramString)) || (bt.isNullOrNil(paramString)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.b
 * JD-Core Version:    0.7.0.1
 */