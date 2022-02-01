package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gg;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;

public final class y
  extends gg
{
  public static c.a info;
  public ArrayList<MallFunction> tsk;
  private ArrayList<MallNews> tsl;
  private ArrayList<a> tsm;
  public SparseArray<String> tsn;
  
  static
  {
    AppMethodBeat.i(70418);
    c.a locala = new c.a();
    locala.EYt = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wallet_region";
    locala.EYv.put("wallet_region", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "wallet_region";
    locala.columns[1] = "function_list";
    locala.EYv.put("function_list", "TEXT");
    localStringBuilder.append(" function_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "new_list";
    locala.EYv.put("new_list", "TEXT");
    localStringBuilder.append(" new_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "banner_list";
    locala.EYv.put("banner_list", "TEXT");
    localStringBuilder.append(" banner_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "type_name_list";
    locala.EYv.put("type_name_list", "TEXT");
    localStringBuilder.append(" type_name_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "isShowSetting";
    locala.EYv.put("isShowSetting", "INTEGER");
    localStringBuilder.append(" isShowSetting INTEGER");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(70418);
  }
  
  public y()
  {
    AppMethodBeat.i(70416);
    this.tsk = new ArrayList();
    this.tsl = new ArrayList();
    this.tsm = new ArrayList();
    this.tsn = new SparseArray();
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
      if (!bt.isNullOrNil(str3)) {
        this.tsk = b.K(new JSONArray(str3));
      }
    }
    catch (Exception localException2)
    {
      try
      {
        if (!bt.isNullOrNil(str2)) {
          this.tsl = b.H(new JSONArray(str2));
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            if (!bt.isNullOrNil(str1)) {
              this.tsm = b.I(new JSONArray(str1));
            }
            try
            {
              if (!bt.isNullOrNil(paramCursor)) {
                this.tsn = b.J(new JSONArray(paramCursor));
              }
              AppMethodBeat.o(70417);
              return;
            }
            catch (Exception paramCursor)
            {
              this.tsn = null;
              ad.printErrStackTrace("MicroMsg.WalletFunciontListInfo", paramCursor, "", new Object[0]);
              AppMethodBeat.o(70417);
            }
            localException3 = localException3;
            ad.printErrStackTrace("MicroMsg.WalletFunciontListInfo", localException3, "", new Object[0]);
            continue;
            localException2 = localException2;
            this.tsl = null;
            ad.printErrStackTrace("MicroMsg.WalletFunciontListInfo", localException2, "", new Object[0]);
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            this.tsm = null;
            ad.printErrStackTrace("MicroMsg.WalletFunciontListInfo", localException1, "", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.y
 * JD-Core Version:    0.7.0.1
 */