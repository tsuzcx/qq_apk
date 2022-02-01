package com.tencent.mm.wallet_core.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;

public final class ai
{
  public static int jOW()
  {
    AppMethodBeat.i(72821);
    if (z.bBi())
    {
      i = a.i.wallet_power_by_payu;
      AppMethodBeat.o(72821);
      return i;
    }
    int i = a.i.wallet_power_by_tenpay;
    AppMethodBeat.o(72821);
    return i;
  }
  
  public static String jOX()
  {
    AppMethodBeat.i(72822);
    if (z.bBi())
    {
      AppMethodBeat.o(72822);
      return "R";
    }
    if (z.bBj())
    {
      AppMethodBeat.o(72822);
      return "HK$";
    }
    AppMethodBeat.o(72822);
    return "¥";
  }
  
  public static int jOY()
  {
    AppMethodBeat.i(72823);
    if (z.bBi())
    {
      i = a.g.wallet_payu_date_illustration_dialog;
      AppMethodBeat.o(72823);
      return i;
    }
    int i = a.g.wallet_date_illustration_dialog;
    AppMethodBeat.o(72823);
    return i;
  }
  
  public static int jOZ()
  {
    AppMethodBeat.i(72824);
    if (z.bBi())
    {
      i = a.i.wallet_card_date_illustraction_payu;
      AppMethodBeat.o(72824);
      return i;
    }
    int i = a.i.wallet_card_date_illustraction;
    AppMethodBeat.o(72824);
    return i;
  }
  
  public static int jPa()
  {
    AppMethodBeat.i(72825);
    if (z.bBi())
    {
      i = a.g.cvv_payu_dialog;
      AppMethodBeat.o(72825);
      return i;
    }
    int i = a.g.cvv_dialog;
    AppMethodBeat.o(72825);
    return i;
  }
  
  public static int jPb()
  {
    AppMethodBeat.i(72827);
    if (z.bBi())
    {
      i = a.i.wallet_change_bankcard_balance_left_payu;
      AppMethodBeat.o(72827);
      return i;
    }
    int i = a.i.wallet_change_bankcard_balance_left;
    AppMethodBeat.o(72827);
    return i;
  }
  
  public static String nR(Context paramContext)
  {
    AppMethodBeat.i(72826);
    if (z.bBi())
    {
      paramContext = paramContext.getString(a.i.wallet_pwd_dialog_titile_payu);
      AppMethodBeat.o(72826);
      return paramContext;
    }
    paramContext = paramContext.getString(a.i.wallet_pwd_dialog_titile);
    AppMethodBeat.o(72826);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.ai
 * JD-Core Version:    0.7.0.1
 */