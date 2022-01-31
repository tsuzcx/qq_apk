package com.tencent.mm.wallet_core.c;

import android.content.Context;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;

public final class ab
{
  public static int cMK()
  {
    if (q.Gw()) {
      return a.i.wallet_power_by_payu;
    }
    return a.i.wallet_power_by_tenpay;
  }
  
  public static String cML()
  {
    if (q.Gw()) {
      return "R";
    }
    if (q.Gx()) {
      return "HK$";
    }
    return "¥";
  }
  
  public static int cMM()
  {
    if (q.Gw()) {
      return a.g.wallet_payu_date_illustration_dialog;
    }
    return a.g.wallet_date_illustration_dialog;
  }
  
  public static int cMN()
  {
    if (q.Gw()) {
      return a.i.wallet_card_date_illustraction_payu;
    }
    return a.i.wallet_card_date_illustraction;
  }
  
  public static int cMO()
  {
    if (q.Gw()) {
      return a.g.cvv_payu_dialog;
    }
    return a.g.cvv_dialog;
  }
  
  public static String hm(Context paramContext)
  {
    if (q.Gw()) {
      return paramContext.getString(a.i.wallet_pwd_dialog_titile_payu);
    }
    return paramContext.getString(a.i.wallet_pwd_dialog_titile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.ab
 * JD-Core Version:    0.7.0.1
 */