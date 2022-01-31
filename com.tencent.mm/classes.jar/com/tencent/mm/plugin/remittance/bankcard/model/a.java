package com.tencent.mm.plugin.remittance.bankcard.model;

import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.math.BigDecimal;

public final class a
{
  public static char LK(String paramString)
  {
    paramString = SpellMap.e(paramString.charAt(0));
    y.d("MicroMsg.BankRemitUtil", "pinyin: %s", new Object[] { paramString });
    if (!bk.bl(paramString)) {
      return paramString.toUpperCase().charAt(0);
    }
    return '#';
  }
  
  public static long eu(String paramString1, String paramString2)
  {
    try
    {
      if (bk.getDouble(paramString1.trim(), 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.trim()) {
        return new BigDecimal(paramString1).divide(new BigDecimal(paramString2.trim()), 0, 4).longValue();
      }
      return 0L;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.BankRemitUtil", paramString1, "", new Object[0]);
    }
  }
  
  public static double ev(String paramString1, String paramString2)
  {
    try
    {
      if (bk.getDouble(paramString1.trim(), 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.trim()) {
        return new BigDecimal(paramString1).divide(new BigDecimal(paramString2.trim()), 2, 4).doubleValue();
      }
      return 0.0D;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.BankRemitUtil", paramString1, "", new Object[0]);
    }
  }
  
  public static double ew(String paramString1, String paramString2)
  {
    try
    {
      double d1 = bk.getDouble(paramString1, 0.0D);
      double d2 = bk.getDouble(paramString2, 0.0D);
      if (d1 == 0.0D) {
        paramString1 = "0";
      }
      paramString1 = new BigDecimal(paramString1);
      if (d2 == 0.0D) {
        paramString2 = "0";
      }
      d1 = paramString1.multiply(new BigDecimal(paramString2)).doubleValue();
      return d1;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.BankRemitUtil", paramString1, "", new Object[0]);
    }
    return 0.0D;
  }
  
  public static double wD(int paramInt)
  {
    return ev(String.valueOf(paramInt), "100");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.a
 * JD-Core Version:    0.7.0.1
 */