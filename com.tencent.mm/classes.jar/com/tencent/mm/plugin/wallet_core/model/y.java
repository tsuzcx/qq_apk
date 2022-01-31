package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fi;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;

public final class y
  extends fi
{
  public static c.a info;
  public ArrayList<MallFunction> oxK;
  private ArrayList<MallNews> oxL;
  private ArrayList<a> oxM;
  public SparseArray<String> oxN;
  
  static
  {
    AppMethodBeat.i(46899);
    c.a locala = new c.a();
    locala.yrK = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wallet_region";
    locala.yrM.put("wallet_region", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "wallet_region";
    locala.columns[1] = "function_list";
    locala.yrM.put("function_list", "TEXT");
    localStringBuilder.append(" function_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "new_list";
    locala.yrM.put("new_list", "TEXT");
    localStringBuilder.append(" new_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "banner_list";
    locala.yrM.put("banner_list", "TEXT");
    localStringBuilder.append(" banner_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "type_name_list";
    locala.yrM.put("type_name_list", "TEXT");
    localStringBuilder.append(" type_name_list TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "isShowSetting";
    locala.yrM.put("isShowSetting", "INTEGER");
    localStringBuilder.append(" isShowSetting INTEGER");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(46899);
  }
  
  public y()
  {
    AppMethodBeat.i(46897);
    this.oxK = new ArrayList();
    this.oxL = new ArrayList();
    this.oxM = new ArrayList();
    this.oxN = new SparseArray();
    AppMethodBeat.o(46897);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(46898);
    super.convertFrom(paramCursor);
    String str3 = this.field_function_list;
    String str2 = this.field_new_list;
    String str1 = this.field_banner_list;
    paramCursor = this.field_type_name_list;
    try
    {
      if (!bo.isNullOrNil(str3)) {
        this.oxK = b.I(new JSONArray(str3));
      }
    }
    catch (Exception localException2)
    {
      try
      {
        if (!bo.isNullOrNil(str2)) {
          this.oxL = b.F(new JSONArray(str2));
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            if (!bo.isNullOrNil(str1)) {
              this.oxM = b.G(new JSONArray(str1));
            }
            try
            {
              if (!bo.isNullOrNil(paramCursor)) {
                this.oxN = b.H(new JSONArray(paramCursor));
              }
              AppMethodBeat.o(46898);
              return;
            }
            catch (Exception paramCursor)
            {
              this.oxN = null;
              ab.printErrStackTrace("MicroMsg.WalletFunciontListInfo", paramCursor, "", new Object[0]);
              AppMethodBeat.o(46898);
            }
            localException3 = localException3;
            ab.printErrStackTrace("MicroMsg.WalletFunciontListInfo", localException3, "", new Object[0]);
            continue;
            localException2 = localException2;
            this.oxL = null;
            ab.printErrStackTrace("MicroMsg.WalletFunciontListInfo", localException2, "", new Object[0]);
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            this.oxM = null;
            ab.printErrStackTrace("MicroMsg.WalletFunciontListInfo", localException1, "", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.y
 * JD-Core Version:    0.7.0.1
 */