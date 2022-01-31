package com.tencent.mm.plugin.product.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
{
  public static String a(Context paramContext, aan paramaan)
  {
    AppMethodBeat.i(43950);
    if (paramaan.wCm > 0)
    {
      paramContext = paramaan.Name + " " + d(paramaan.wCm, paramaan.PriceType);
      AppMethodBeat.o(43950);
      return paramContext;
    }
    paramContext = paramContext.getString(2131301500);
    AppMethodBeat.o(43950);
    return paramContext;
  }
  
  public static String d(double paramDouble, String paramString)
  {
    AppMethodBeat.i(43949);
    if (("CNY".equals(paramString)) || ("1".equals(paramString)) || (bo.isNullOrNil(paramString)))
    {
      paramString = String.format("¥%.2f", new Object[] { Double.valueOf(paramDouble / 100.0D) });
      AppMethodBeat.o(43949);
      return paramString;
    }
    paramString = String.format("%s%.2f", new Object[] { paramString, Double.valueOf(paramDouble / 100.0D) });
    AppMethodBeat.o(43949);
    return paramString;
  }
  
  public static String v(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(43948);
    if (paramInt1 == paramInt2)
    {
      paramString = d(paramInt1, paramString);
      AppMethodBeat.o(43948);
      return paramString;
    }
    paramString = String.format("%s~%s", new Object[] { d(paramInt2, paramString), d(paramInt1, paramString) });
    AppMethodBeat.o(43948);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.b
 * JD-Core Version:    0.7.0.1
 */