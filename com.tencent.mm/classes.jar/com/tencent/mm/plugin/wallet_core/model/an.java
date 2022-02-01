package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.hs;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class an
  extends hs
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(70492);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[32];
    localMAutoDBInfo.columns = new String[33];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "uin";
    localMAutoDBInfo.colsMap.put("uin", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" uin TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "uin";
    localMAutoDBInfo.columns[1] = "is_reg";
    localMAutoDBInfo.colsMap.put("is_reg", "INTEGER");
    localStringBuilder.append(" is_reg INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "true_name";
    localMAutoDBInfo.colsMap.put("true_name", "TEXT");
    localStringBuilder.append(" true_name TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "card_num";
    localMAutoDBInfo.colsMap.put("card_num", "INTEGER");
    localStringBuilder.append(" card_num INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "isDomesticUser";
    localMAutoDBInfo.colsMap.put("isDomesticUser", "INTEGER");
    localStringBuilder.append(" isDomesticUser INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "cre_type";
    localMAutoDBInfo.colsMap.put("cre_type", "INTEGER");
    localStringBuilder.append(" cre_type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "main_card_bind_serialno";
    localMAutoDBInfo.colsMap.put("main_card_bind_serialno", "TEXT");
    localStringBuilder.append(" main_card_bind_serialno TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "ftf_pay_url";
    localMAutoDBInfo.colsMap.put("ftf_pay_url", "TEXT");
    localStringBuilder.append(" ftf_pay_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "switchConfig";
    localMAutoDBInfo.colsMap.put("switchConfig", "INTEGER");
    localStringBuilder.append(" switchConfig INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "reset_passwd_flag";
    localMAutoDBInfo.colsMap.put("reset_passwd_flag", "TEXT");
    localStringBuilder.append(" reset_passwd_flag TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "find_passwd_url";
    localMAutoDBInfo.colsMap.put("find_passwd_url", "TEXT");
    localStringBuilder.append(" find_passwd_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "is_open_touch";
    localMAutoDBInfo.colsMap.put("is_open_touch", "INTEGER");
    localStringBuilder.append(" is_open_touch INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "lct_wording";
    localMAutoDBInfo.colsMap.put("lct_wording", "TEXT");
    localStringBuilder.append(" lct_wording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "lct_url";
    localMAutoDBInfo.colsMap.put("lct_url", "TEXT");
    localStringBuilder.append(" lct_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "cre_name";
    localMAutoDBInfo.colsMap.put("cre_name", "TEXT");
    localStringBuilder.append(" cre_name TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "lqt_state";
    localMAutoDBInfo.colsMap.put("lqt_state", "INTEGER");
    localStringBuilder.append(" lqt_state INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "paymenu_use_new";
    localMAutoDBInfo.colsMap.put("paymenu_use_new", "INTEGER");
    localStringBuilder.append(" paymenu_use_new INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "is_show_lqb";
    localMAutoDBInfo.colsMap.put("is_show_lqb", "INTEGER");
    localStringBuilder.append(" is_show_lqb INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "is_open_lqb";
    localMAutoDBInfo.colsMap.put("is_open_lqb", "INTEGER");
    localStringBuilder.append(" is_open_lqb INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "lqb_open_url";
    localMAutoDBInfo.colsMap.put("lqb_open_url", "TEXT");
    localStringBuilder.append(" lqb_open_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "lqt_cell_is_show";
    localMAutoDBInfo.colsMap.put("lqt_cell_is_show", "INTEGER");
    localStringBuilder.append(" lqt_cell_is_show INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "lqt_cell_icon";
    localMAutoDBInfo.colsMap.put("lqt_cell_icon", "TEXT");
    localStringBuilder.append(" lqt_cell_icon TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "lqt_cell_is_open_lqt";
    localMAutoDBInfo.colsMap.put("lqt_cell_is_open_lqt", "INTEGER");
    localStringBuilder.append(" lqt_cell_is_open_lqt INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "lqt_cell_lqt_open_url";
    localMAutoDBInfo.colsMap.put("lqt_cell_lqt_open_url", "TEXT");
    localStringBuilder.append(" lqt_cell_lqt_open_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "lqt_cell_lqt_title";
    localMAutoDBInfo.colsMap.put("lqt_cell_lqt_title", "TEXT");
    localStringBuilder.append(" lqt_cell_lqt_title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "lqt_cell_lqt_wording";
    localMAutoDBInfo.colsMap.put("lqt_cell_lqt_wording", "TEXT");
    localStringBuilder.append(" lqt_cell_lqt_wording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "forget_passwd_url";
    localMAutoDBInfo.colsMap.put("forget_passwd_url", "TEXT");
    localStringBuilder.append(" forget_passwd_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "unipay_order_state";
    localMAutoDBInfo.colsMap.put("unipay_order_state", "INTEGER");
    localStringBuilder.append(" unipay_order_state INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "bank_priority";
    localMAutoDBInfo.colsMap.put("bank_priority", "TEXT");
    localStringBuilder.append(" bank_priority TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "wallet_balance";
    localMAutoDBInfo.colsMap.put("wallet_balance", "LONG");
    localStringBuilder.append(" wallet_balance LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "wallet_entrance_balance_switch_state";
    localMAutoDBInfo.colsMap.put("wallet_entrance_balance_switch_state", "INTEGER");
    localStringBuilder.append(" wallet_entrance_balance_switch_state INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "soter_pay_open_type";
    localMAutoDBInfo.colsMap.put("soter_pay_open_type", "INTEGER");
    localStringBuilder.append(" soter_pay_open_type INTEGER");
    localMAutoDBInfo.columns[32] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(70492);
  }
  
  public final boolean gJQ()
  {
    return this.field_is_reg == 1;
  }
  
  public final boolean gJR()
  {
    return this.field_is_reg == 2;
  }
  
  public final boolean gJS()
  {
    return this.field_is_reg == 0;
  }
  
  public final boolean gJT()
  {
    return this.field_is_reg == -1;
  }
  
  public final boolean gJU()
  {
    return this.field_is_open_touch == 1;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.an
 * JD-Core Version:    0.7.0.1
 */