package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gv;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;

public final class z
  extends gv
{
  public static c.a info;
  public ArrayList<MallFunction> vPk;
  private ArrayList<MallNews> vPl;
  private ArrayList<a> vPm;
  public SparseArray<String> vPn;
  
  static
  {
    AppMethodBeat.i(70418);
    c.a locala = new c.a();
    locala.IBL = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wallet_region";
    locala.IBN.put("wallet_region", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "wallet_region";
    locala.columns[1] = "function_list";
    locala.IBN.put("function_list", "TEXT");
    localStringBuilder.append(" function_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "new_list";
    locala.IBN.put("new_list", "TEXT");
    localStringBuilder.append(" new_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "banner_list";
    locala.IBN.put("banner_list", "TEXT");
    localStringBuilder.append(" banner_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "type_name_list";
    locala.IBN.put("type_name_list", "TEXT");
    localStringBuilder.append(" type_name_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "isShowSetting";
    locala.IBN.put("isShowSetting", "INTEGER");
    localStringBuilder.append(" isShowSetting INTEGER");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(70418);
  }
  
  public z()
  {
    AppMethodBeat.i(70416);
    this.vPk = new ArrayList();
    this.vPl = new ArrayList();
    this.vPm = new ArrayList();
    this.vPn = new SparseArray();
    AppMethodBeat.o(70416);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(70417);
    super.convertFrom(paramCursor);
    String str3 = this.field_function_list;
    String str2 = this.field_new_list;
    String str1 = this.field_banner_list;
    paramCursor = this.field_type_name_list;
    try
    {
      if (!bu.isNullOrNil(str3)) {
        this.vPk = b.M(new JSONArray(str3));
      }
    }
    catch (Exception localException2)
    {
      try
      {
        if (!bu.isNullOrNil(str2)) {
          this.vPl = b.J(new JSONArray(str2));
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            if (!bu.isNullOrNil(str1)) {
              this.vPm = b.K(new JSONArray(str1));
            }
            try
            {
              if (!bu.isNullOrNil(paramCursor)) {
                this.vPn = b.L(new JSONArray(paramCursor));
              }
              AppMethodBeat.o(70417);
              return;
            }
            catch (Exception paramCursor)
            {
              this.vPn = null;
              ae.printErrStackTrace("MicroMsg.WalletFunciontListInfo", paramCursor, "", new Object[0]);
              AppMethodBeat.o(70417);
            }
            localException3 = localException3;
            ae.printErrStackTrace("MicroMsg.WalletFunciontListInfo", localException3, "", new Object[0]);
            continue;
            localException2 = localException2;
            this.vPl = null;
            ae.printErrStackTrace("MicroMsg.WalletFunciontListInfo", localException2, "", new Object[0]);
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            this.vPm = null;
            ae.printErrStackTrace("MicroMsg.WalletFunciontListInfo", localException1, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.z
 * JD-Core Version:    0.7.0.1
 */