package com.tencent.mm.plugin.remittance.bankcard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigDecimal;

public final class a
{
  public static double Ct(int paramInt)
  {
    AppMethodBeat.i(44488);
    double d = fV(String.valueOf(paramInt), "100");
    AppMethodBeat.o(44488);
    return d;
  }
  
  public static char Yc(String paramString)
  {
    AppMethodBeat.i(44489);
    paramString = SpellMap.u(paramString.charAt(0));
    ab.d("MicroMsg.BankRemitUtil", "pinyin: %s", new Object[] { paramString });
    if (!bo.isNullOrNil(paramString))
    {
      char c = paramString.toUpperCase().charAt(0);
      AppMethodBeat.o(44489);
      return c;
    }
    AppMethodBeat.o(44489);
    return '#';
  }
  
  public static long fU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44485);
    try
    {
      if (bo.getDouble(paramString1.trim(), 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.trim())
      {
        long l = new BigDecimal(paramString1).divide(new BigDecimal(paramString2.trim()), 0, 4).longValue();
        AppMethodBeat.o(44485);
        return l;
      }
      return 0L;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.BankRemitUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(44485);
    }
  }
  
  public static double fV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44486);
    try
    {
      if (bo.getDouble(paramString1.trim(), 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.trim())
      {
        double d = new BigDecimal(paramString1).divide(new BigDecimal(paramString2.trim()), 2, 4).doubleValue();
        AppMethodBeat.o(44486);
        return d;
      }
      return 0.0D;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.BankRemitUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(44486);
    }
  }
  
  public static double fW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44487);
    try
    {
      double d1 = bo.getDouble(paramString1, 0.0D);
      double d2 = bo.getDouble(paramString2, 0.0D);
      if (d1 == 0.0D) {
        paramString1 = "0";
      }
      paramString1 = new BigDecimal(paramString1);
      if (d2 == 0.0D) {
        paramString2 = "0";
      }
      d1 = paramString1.multiply(new BigDecimal(paramString2)).doubleValue();
      AppMethodBeat.o(44487);
      return d1;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.BankRemitUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(44487);
    }
    return 0.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.a
 * JD-Core Version:    0.7.0.1
 */