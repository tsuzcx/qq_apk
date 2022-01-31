package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fn;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class al
  extends fn
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(46962);
    c.a locala = new c.a();
    locala.yrK = new Field[32];
    locala.columns = new String[33];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "uin";
    locala.yrM.put("uin", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" uin TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "uin";
    locala.columns[1] = "is_reg";
    locala.yrM.put("is_reg", "INTEGER");
    localStringBuilder.append(" is_reg INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "true_name";
    locala.yrM.put("true_name", "TEXT");
    localStringBuilder.append(" true_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "card_num";
    locala.yrM.put("card_num", "INTEGER");
    localStringBuilder.append(" card_num INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "isDomesticUser";
    locala.yrM.put("isDomesticUser", "INTEGER");
    localStringBuilder.append(" isDomesticUser INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "cre_type";
    locala.yrM.put("cre_type", "INTEGER");
    localStringBuilder.append(" cre_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "main_card_bind_serialno";
    locala.yrM.put("main_card_bind_serialno", "TEXT");
    localStringBuilder.append(" main_card_bind_serialno TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "ftf_pay_url";
    locala.yrM.put("ftf_pay_url", "TEXT");
    localStringBuilder.append(" ftf_pay_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "switchConfig";
    locala.yrM.put("switchConfig", "INTEGER");
    localStringBuilder.append(" switchConfig INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "reset_passwd_flag";
    locala.yrM.put("reset_passwd_flag", "TEXT");
    localStringBuilder.append(" reset_passwd_flag TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "find_passwd_url";
    locala.yrM.put("find_passwd_url", "TEXT");
    localStringBuilder.append(" find_passwd_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "is_open_touch";
    locala.yrM.put("is_open_touch", "INTEGER");
    localStringBuilder.append(" is_open_touch INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "lct_wording";
    locala.yrM.put("lct_wording", "TEXT");
    localStringBuilder.append(" lct_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "lct_url";
    locala.yrM.put("lct_url", "TEXT");
    localStringBuilder.append(" lct_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "cre_name";
    locala.yrM.put("cre_name", "TEXT");
    localStringBuilder.append(" cre_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "lqt_state";
    locala.yrM.put("lqt_state", "INTEGER");
    localStringBuilder.append(" lqt_state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "paymenu_use_new";
    locala.yrM.put("paymenu_use_new", "INTEGER");
    localStringBuilder.append(" paymenu_use_new INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "is_show_lqb";
    locala.yrM.put("is_show_lqb", "INTEGER");
    localStringBuilder.append(" is_show_lqb INTEGER");
    localStringBuilder.append(", ");
    locala.columns[18] = "is_open_lqb";
    locala.yrM.put("is_open_lqb", "INTEGER");
    localStringBuilder.append(" is_open_lqb INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "lqb_open_url";
    locala.yrM.put("lqb_open_url", "TEXT");
    localStringBuilder.append(" lqb_open_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "lqt_cell_is_show";
    locala.yrM.put("lqt_cell_is_show", "INTEGER");
    localStringBuilder.append(" lqt_cell_is_show INTEGER");
    localStringBuilder.append(", ");
    locala.columns[21] = "lqt_cell_icon";
    locala.yrM.put("lqt_cell_icon", "TEXT");
    localStringBuilder.append(" lqt_cell_icon TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "lqt_cell_is_open_lqt";
    locala.yrM.put("lqt_cell_is_open_lqt", "INTEGER");
    localStringBuilder.append(" lqt_cell_is_open_lqt INTEGER");
    localStringBuilder.append(", ");
    locala.columns[23] = "lqt_cell_lqt_open_url";
    locala.yrM.put("lqt_cell_lqt_open_url", "TEXT");
    localStringBuilder.append(" lqt_cell_lqt_open_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "lqt_cell_lqt_title";
    locala.yrM.put("lqt_cell_lqt_title", "TEXT");
    localStringBuilder.append(" lqt_cell_lqt_title TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "lqt_cell_lqt_wording";
    locala.yrM.put("lqt_cell_lqt_wording", "TEXT");
    localStringBuilder.append(" lqt_cell_lqt_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[26] = "forget_passwd_url";
    locala.yrM.put("forget_passwd_url", "TEXT");
    localStringBuilder.append(" forget_passwd_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[27] = "unipay_order_state";
    locala.yrM.put("unipay_order_state", "INTEGER");
    localStringBuilder.append(" unipay_order_state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[28] = "bank_priority";
    locala.yrM.put("bank_priority", "TEXT");
    localStringBuilder.append(" bank_priority TEXT");
    localStringBuilder.append(", ");
    locala.columns[29] = "wallet_balance";
    locala.yrM.put("wallet_balance", "LONG");
    localStringBuilder.append(" wallet_balance LONG");
    localStringBuilder.append(", ");
    locala.columns[30] = "wallet_entrance_balance_switch_state";
    locala.yrM.put("wallet_entrance_balance_switch_state", "INTEGER");
    localStringBuilder.append(" wallet_entrance_balance_switch_state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[31] = "soter_pay_open_type";
    locala.yrM.put("soter_pay_open_type", "INTEGER");
    localStringBuilder.append(" soter_pay_open_type INTEGER");
    locala.columns[32] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(46962);
  }
  
  public final boolean cUl()
  {
    return this.field_is_reg == 1;
  }
  
  public final boolean cUm()
  {
    return this.field_is_reg == 2;
  }
  
  public final boolean cUn()
  {
    return this.field_is_reg == 0;
  }
  
  public final boolean cUo()
  {
    return this.field_is_reg == -1;
  }
  
  public final boolean cUp()
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