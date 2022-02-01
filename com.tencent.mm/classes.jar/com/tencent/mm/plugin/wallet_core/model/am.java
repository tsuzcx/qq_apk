package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gz;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class am
  extends gz
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(70492);
    c.a locala = new c.a();
    locala.IhA = new Field[32];
    locala.columns = new String[33];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "uin";
    locala.IhC.put("uin", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" uin TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "uin";
    locala.columns[1] = "is_reg";
    locala.IhC.put("is_reg", "INTEGER");
    localStringBuilder.append(" is_reg INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "true_name";
    locala.IhC.put("true_name", "TEXT");
    localStringBuilder.append(" true_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "card_num";
    locala.IhC.put("card_num", "INTEGER");
    localStringBuilder.append(" card_num INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "isDomesticUser";
    locala.IhC.put("isDomesticUser", "INTEGER");
    localStringBuilder.append(" isDomesticUser INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "cre_type";
    locala.IhC.put("cre_type", "INTEGER");
    localStringBuilder.append(" cre_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "main_card_bind_serialno";
    locala.IhC.put("main_card_bind_serialno", "TEXT");
    localStringBuilder.append(" main_card_bind_serialno TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "ftf_pay_url";
    locala.IhC.put("ftf_pay_url", "TEXT");
    localStringBuilder.append(" ftf_pay_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "switchConfig";
    locala.IhC.put("switchConfig", "INTEGER");
    localStringBuilder.append(" switchConfig INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "reset_passwd_flag";
    locala.IhC.put("reset_passwd_flag", "TEXT");
    localStringBuilder.append(" reset_passwd_flag TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "find_passwd_url";
    locala.IhC.put("find_passwd_url", "TEXT");
    localStringBuilder.append(" find_passwd_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "is_open_touch";
    locala.IhC.put("is_open_touch", "INTEGER");
    localStringBuilder.append(" is_open_touch INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "lct_wording";
    locala.IhC.put("lct_wording", "TEXT");
    localStringBuilder.append(" lct_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "lct_url";
    locala.IhC.put("lct_url", "TEXT");
    localStringBuilder.append(" lct_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "cre_name";
    locala.IhC.put("cre_name", "TEXT");
    localStringBuilder.append(" cre_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "lqt_state";
    locala.IhC.put("lqt_state", "INTEGER");
    localStringBuilder.append(" lqt_state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "paymenu_use_new";
    locala.IhC.put("paymenu_use_new", "INTEGER");
    localStringBuilder.append(" paymenu_use_new INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "is_show_lqb";
    locala.IhC.put("is_show_lqb", "INTEGER");
    localStringBuilder.append(" is_show_lqb INTEGER");
    localStringBuilder.append(", ");
    locala.columns[18] = "is_open_lqb";
    locala.IhC.put("is_open_lqb", "INTEGER");
    localStringBuilder.append(" is_open_lqb INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "lqb_open_url";
    locala.IhC.put("lqb_open_url", "TEXT");
    localStringBuilder.append(" lqb_open_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "lqt_cell_is_show";
    locala.IhC.put("lqt_cell_is_show", "INTEGER");
    localStringBuilder.append(" lqt_cell_is_show INTEGER");
    localStringBuilder.append(", ");
    locala.columns[21] = "lqt_cell_icon";
    locala.IhC.put("lqt_cell_icon", "TEXT");
    localStringBuilder.append(" lqt_cell_icon TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "lqt_cell_is_open_lqt";
    locala.IhC.put("lqt_cell_is_open_lqt", "INTEGER");
    localStringBuilder.append(" lqt_cell_is_open_lqt INTEGER");
    localStringBuilder.append(", ");
    locala.columns[23] = "lqt_cell_lqt_open_url";
    locala.IhC.put("lqt_cell_lqt_open_url", "TEXT");
    localStringBuilder.append(" lqt_cell_lqt_open_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "lqt_cell_lqt_title";
    locala.IhC.put("lqt_cell_lqt_title", "TEXT");
    localStringBuilder.append(" lqt_cell_lqt_title TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "lqt_cell_lqt_wording";
    locala.IhC.put("lqt_cell_lqt_wording", "TEXT");
    localStringBuilder.append(" lqt_cell_lqt_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[26] = "forget_passwd_url";
    locala.IhC.put("forget_passwd_url", "TEXT");
    localStringBuilder.append(" forget_passwd_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[27] = "unipay_order_state";
    locala.IhC.put("unipay_order_state", "INTEGER");
    localStringBuilder.append(" unipay_order_state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[28] = "bank_priority";
    locala.IhC.put("bank_priority", "TEXT");
    localStringBuilder.append(" bank_priority TEXT");
    localStringBuilder.append(", ");
    locala.columns[29] = "wallet_balance";
    locala.IhC.put("wallet_balance", "LONG");
    localStringBuilder.append(" wallet_balance LONG");
    localStringBuilder.append(", ");
    locala.columns[30] = "wallet_entrance_balance_switch_state";
    locala.IhC.put("wallet_entrance_balance_switch_state", "INTEGER");
    localStringBuilder.append(" wallet_entrance_balance_switch_state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[31] = "soter_pay_open_type";
    locala.IhC.put("soter_pay_open_type", "INTEGER");
    localStringBuilder.append(" soter_pay_open_type INTEGER");
    locala.columns[32] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(70492);
  }
  
  public final boolean eGa()
  {
    return this.field_is_reg == 1;
  }
  
  public final boolean eGb()
  {
    return this.field_is_reg == 2;
  }
  
  public final boolean eGc()
  {
    return this.field_is_reg == 0;
  }
  
  public final boolean eGd()
  {
    return this.field_is_reg == -1;
  }
  
  public final boolean eGe()
  {
    return this.field_is_open_touch == 1;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.am
 * JD-Core Version:    0.7.0.1
 */