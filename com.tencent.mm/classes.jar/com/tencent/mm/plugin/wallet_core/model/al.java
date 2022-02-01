package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gl;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class al
  extends gl
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(70492);
    c.a locala = new c.a();
    locala.EYt = new Field[32];
    locala.columns = new String[33];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "uin";
    locala.EYv.put("uin", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" uin TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "uin";
    locala.columns[1] = "is_reg";
    locala.EYv.put("is_reg", "INTEGER");
    localStringBuilder.append(" is_reg INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "true_name";
    locala.EYv.put("true_name", "TEXT");
    localStringBuilder.append(" true_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "card_num";
    locala.EYv.put("card_num", "INTEGER");
    localStringBuilder.append(" card_num INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "isDomesticUser";
    locala.EYv.put("isDomesticUser", "INTEGER");
    localStringBuilder.append(" isDomesticUser INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "cre_type";
    locala.EYv.put("cre_type", "INTEGER");
    localStringBuilder.append(" cre_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "main_card_bind_serialno";
    locala.EYv.put("main_card_bind_serialno", "TEXT");
    localStringBuilder.append(" main_card_bind_serialno TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "ftf_pay_url";
    locala.EYv.put("ftf_pay_url", "TEXT");
    localStringBuilder.append(" ftf_pay_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "switchConfig";
    locala.EYv.put("switchConfig", "INTEGER");
    localStringBuilder.append(" switchConfig INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "reset_passwd_flag";
    locala.EYv.put("reset_passwd_flag", "TEXT");
    localStringBuilder.append(" reset_passwd_flag TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "find_passwd_url";
    locala.EYv.put("find_passwd_url", "TEXT");
    localStringBuilder.append(" find_passwd_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "is_open_touch";
    locala.EYv.put("is_open_touch", "INTEGER");
    localStringBuilder.append(" is_open_touch INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "lct_wording";
    locala.EYv.put("lct_wording", "TEXT");
    localStringBuilder.append(" lct_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "lct_url";
    locala.EYv.put("lct_url", "TEXT");
    localStringBuilder.append(" lct_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "cre_name";
    locala.EYv.put("cre_name", "TEXT");
    localStringBuilder.append(" cre_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "lqt_state";
    locala.EYv.put("lqt_state", "INTEGER");
    localStringBuilder.append(" lqt_state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "paymenu_use_new";
    locala.EYv.put("paymenu_use_new", "INTEGER");
    localStringBuilder.append(" paymenu_use_new INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "is_show_lqb";
    locala.EYv.put("is_show_lqb", "INTEGER");
    localStringBuilder.append(" is_show_lqb INTEGER");
    localStringBuilder.append(", ");
    locala.columns[18] = "is_open_lqb";
    locala.EYv.put("is_open_lqb", "INTEGER");
    localStringBuilder.append(" is_open_lqb INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "lqb_open_url";
    locala.EYv.put("lqb_open_url", "TEXT");
    localStringBuilder.append(" lqb_open_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "lqt_cell_is_show";
    locala.EYv.put("lqt_cell_is_show", "INTEGER");
    localStringBuilder.append(" lqt_cell_is_show INTEGER");
    localStringBuilder.append(", ");
    locala.columns[21] = "lqt_cell_icon";
    locala.EYv.put("lqt_cell_icon", "TEXT");
    localStringBuilder.append(" lqt_cell_icon TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "lqt_cell_is_open_lqt";
    locala.EYv.put("lqt_cell_is_open_lqt", "INTEGER");
    localStringBuilder.append(" lqt_cell_is_open_lqt INTEGER");
    localStringBuilder.append(", ");
    locala.columns[23] = "lqt_cell_lqt_open_url";
    locala.EYv.put("lqt_cell_lqt_open_url", "TEXT");
    localStringBuilder.append(" lqt_cell_lqt_open_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "lqt_cell_lqt_title";
    locala.EYv.put("lqt_cell_lqt_title", "TEXT");
    localStringBuilder.append(" lqt_cell_lqt_title TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "lqt_cell_lqt_wording";
    locala.EYv.put("lqt_cell_lqt_wording", "TEXT");
    localStringBuilder.append(" lqt_cell_lqt_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[26] = "forget_passwd_url";
    locala.EYv.put("forget_passwd_url", "TEXT");
    localStringBuilder.append(" forget_passwd_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[27] = "unipay_order_state";
    locala.EYv.put("unipay_order_state", "INTEGER");
    localStringBuilder.append(" unipay_order_state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[28] = "bank_priority";
    locala.EYv.put("bank_priority", "TEXT");
    localStringBuilder.append(" bank_priority TEXT");
    localStringBuilder.append(", ");
    locala.columns[29] = "wallet_balance";
    locala.EYv.put("wallet_balance", "LONG");
    localStringBuilder.append(" wallet_balance LONG");
    localStringBuilder.append(", ");
    locala.columns[30] = "wallet_entrance_balance_switch_state";
    locala.EYv.put("wallet_entrance_balance_switch_state", "INTEGER");
    localStringBuilder.append(" wallet_entrance_balance_switch_state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[31] = "soter_pay_open_type";
    locala.EYv.put("soter_pay_open_type", "INTEGER");
    localStringBuilder.append(" soter_pay_open_type INTEGER");
    locala.columns[32] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(70492);
  }
  
  public final boolean ecF()
  {
    return this.field_is_reg == 1;
  }
  
  public final boolean ecG()
  {
    return this.field_is_reg == 2;
  }
  
  public final boolean ecH()
  {
    return this.field_is_reg == 0;
  }
  
  public final boolean ecI()
  {
    return this.field_is_reg == -1;
  }
  
  public final boolean ecJ()
  {
    return this.field_is_open_touch == 1;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.al
 * JD-Core Version:    0.7.0.1
 */