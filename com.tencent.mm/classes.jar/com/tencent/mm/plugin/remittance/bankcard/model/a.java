package com.tencent.mm.plugin.remittance.bankcard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigDecimal;

public final class a
{
  public static double VX(int paramInt)
  {
    AppMethodBeat.i(67397);
    double d = jJ(String.valueOf(paramInt), "100");
    AppMethodBeat.o(67397);
    return d;
  }
  
  public static char aLU(String paramString)
  {
    AppMethodBeat.i(67398);
    paramString = SpellMap.x(paramString.charAt(0));
    Log.d("MicroMsg.BankRemitUtil", "pinyin: %s", new Object[] { paramString });
    if (!Util.isNullOrNil(paramString))
    {
      char c = paramString.toUpperCase().charAt(0);
      AppMethodBeat.o(67398);
      return c;
    }
    AppMethodBeat.o(67398);
    return '#';
  }
  
  public static long jI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67394);
    try
    {
      if (Util.getDouble(paramString1.trim(), 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.trim())
      {
        long l = new BigDecimal(paramString1).divide(new BigDecimal(paramString2.trim()), 0, 4).longValue();
        AppMethodBeat.o(67394);
        return l;
      }
      return 0L;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.BankRemitUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(67394);
    }
  }
  
  public static double jJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67395);
    try
    {
      if (Util.getDouble(paramString1.trim(), 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.trim())
      {
        double d = new BigDecimal(paramString1).divide(new BigDecimal(paramString2.trim()), 2, 4).doubleValue();
        AppMethodBeat.o(67395);
        return d;
      }
      return 0.0D;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.BankRemitUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(67395);
    }
  }
  
  public static double jK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67396);
    try
    {
      double d1 = Util.getDouble(paramString1, 0.0D);
      double d2 = Util.getDouble(paramString2, 0.0D);
      if (d1 == 0.0D) {
        paramString1 = "0";
      }
      paramString1 = new BigDecimal(paramString1);
      if (d2 == 0.0D) {
        paramString2 = "0";
      }
      d1 = paramString1.multiply(new BigDecimal(paramString2)).doubleValue();
      AppMethodBeat.o(67396);
      return d1;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.BankRemitUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(67396);
    }
    return 0.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.a
 * JD-Core Version:    0.7.0.1
 */