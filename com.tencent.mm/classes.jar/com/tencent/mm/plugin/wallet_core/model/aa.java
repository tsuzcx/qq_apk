package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.hn;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;

public final class aa
  extends hn
{
  public static IAutoDBItem.MAutoDBInfo info;
  public ArrayList<MallFunction> EOE;
  private ArrayList<MallNews> EOG;
  private ArrayList<a> EOH;
  public SparseArray<String> EOI;
  
  static
  {
    AppMethodBeat.i(70418);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "wallet_region";
    localMAutoDBInfo.colsMap.put("wallet_region", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "wallet_region";
    localMAutoDBInfo.columns[1] = "function_list";
    localMAutoDBInfo.colsMap.put("function_list", "TEXT");
    localStringBuilder.append(" function_list TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "new_list";
    localMAutoDBInfo.colsMap.put("new_list", "TEXT");
    localStringBuilder.append(" new_list TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "banner_list";
    localMAutoDBInfo.colsMap.put("banner_list", "TEXT");
    localStringBuilder.append(" banner_list TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "type_name_list";
    localMAutoDBInfo.colsMap.put("type_name_list", "TEXT");
    localStringBuilder.append(" type_name_list TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "isShowSetting";
    localMAutoDBInfo.colsMap.put("isShowSetting", "INTEGER");
    localStringBuilder.append(" isShowSetting INTEGER");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(70418);
  }
  
  public aa()
  {
    AppMethodBeat.i(70416);
    this.EOE = new ArrayList();
    this.EOG = new ArrayList();
    this.EOH = new ArrayList();
    this.EOI = new SparseArray();
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
      if (!Util.isNullOrNil(str3)) {
        this.EOE = b.T(new JSONArray(str3));
      }
    }
    catch (Exception localException2)
    {
      try
      {
        if (!Util.isNullOrNil(str2)) {
          this.EOG = b.Q(new JSONArray(str2));
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            if (!Util.isNullOrNil(str1)) {
              this.EOH = b.R(new JSONArray(str1));
            }
            try
            {
              if (!Util.isNullOrNil(paramCursor)) {
                this.EOI = b.S(new JSONArray(paramCursor));
              }
              AppMethodBeat.o(70417);
              return;
            }
            catch (Exception paramCursor)
            {
              this.EOI = null;
              Log.printErrStackTrace("MicroMsg.WalletFunciontListInfo", paramCursor, "", new Object[0]);
              AppMethodBeat.o(70417);
            }
            localException3 = localException3;
            Log.printErrStackTrace("MicroMsg.WalletFunciontListInfo", localException3, "", new Object[0]);
            continue;
            localException2 = localException2;
            this.EOG = null;
            Log.printErrStackTrace("MicroMsg.WalletFunciontListInfo", localException2, "", new Object[0]);
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            this.EOH = null;
            Log.printErrStackTrace("MicroMsg.WalletFunciontListInfo", localException1, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aa
 * JD-Core Version:    0.7.0.1
 */