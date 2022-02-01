package com.tencent.mm.wallet_core.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;

public final class ah
{
  public static int ija()
  {
    AppMethodBeat.i(72821);
    if (z.bdq())
    {
      i = a.i.wallet_power_by_payu;
      AppMethodBeat.o(72821);
      return i;
    }
    int i = a.i.wallet_power_by_tenpay;
    AppMethodBeat.o(72821);
    return i;
  }
  
  public static String ijb()
  {
    AppMethodBeat.i(72822);
    if (z.bdq())
    {
      AppMethodBeat.o(72822);
      return "R";
    }
    if (z.bdr())
    {
      AppMethodBeat.o(72822);
      return "HK$";
    }
    AppMethodBeat.o(72822);
    return "¥";
  }
  
  public static String ijc()
  {
    return "¥";
  }
  
  public static int ijd()
  {
    AppMethodBeat.i(72823);
    if (z.bdq())
    {
      i = a.g.wallet_payu_date_illustration_dialog;
      AppMethodBeat.o(72823);
      return i;
    }
    int i = a.g.wallet_date_illustration_dialog;
    AppMethodBeat.o(72823);
    return i;
  }
  
  public static int ije()
  {
    AppMethodBeat.i(72824);
    if (z.bdq())
    {
      i = a.i.wallet_card_date_illustraction_payu;
      AppMethodBeat.o(72824);
      return i;
    }
    int i = a.i.wallet_card_date_illustraction;
    AppMethodBeat.o(72824);
    return i;
  }
  
  public static int ijf()
  {
    AppMethodBeat.i(72825);
    if (z.bdq())
    {
      i = a.g.cvv_payu_dialog;
      AppMethodBeat.o(72825);
      return i;
    }
    int i = a.g.cvv_dialog;
    AppMethodBeat.o(72825);
    return i;
  }
  
  public static int ijg()
  {
    AppMethodBeat.i(72827);
    if (z.bdq())
    {
      i = a.i.wallet_change_bankcard_balance_left_payu;
      AppMethodBeat.o(72827);
      return i;
    }
    int i = a.i.wallet_change_bankcard_balance_left;
    AppMethodBeat.o(72827);
    return i;
  }
  
  public static String lM(Context paramContext)
  {
    AppMethodBeat.i(72826);
    if (z.bdq())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.ah
 * JD-Core Version:    0.7.0.1
 */