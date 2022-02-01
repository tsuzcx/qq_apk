package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ij;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.ArrayList;
import org.json.JSONArray;

public final class aa
  extends ij
{
  public static IAutoDBItem.MAutoDBInfo info;
  public ArrayList<MallFunction> KJd;
  private ArrayList<MallNews> KJe;
  private ArrayList<a> KJf;
  public SparseArray<String> KJg;
  
  static
  {
    AppMethodBeat.i(70418);
    info = ij.aJm();
    AppMethodBeat.o(70418);
  }
  
  public aa()
  {
    AppMethodBeat.i(70416);
    this.KJd = new ArrayList();
    this.KJe = new ArrayList();
    this.KJf = new ArrayList();
    this.KJg = new SparseArray();
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
        this.KJd = b.Y(new JSONArray(str3));
      }
    }
    catch (Exception localException2)
    {
      try
      {
        if (!Util.isNullOrNil(str2)) {
          this.KJe = b.V(new JSONArray(str2));
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            if (!Util.isNullOrNil(str1)) {
              this.KJf = b.W(new JSONArray(str1));
            }
            try
            {
              if (!Util.isNullOrNil(paramCursor)) {
                this.KJg = b.X(new JSONArray(paramCursor));
              }
              AppMethodBeat.o(70417);
              return;
            }
            catch (Exception paramCursor)
            {
              this.KJg = null;
              Log.printErrStackTrace("MicroMsg.WalletFunciontListInfo", paramCursor, "", new Object[0]);
              AppMethodBeat.o(70417);
            }
            localException3 = localException3;
            Log.printErrStackTrace("MicroMsg.WalletFunciontListInfo", localException3, "", new Object[0]);
            continue;
            localException2 = localException2;
            this.KJe = null;
            Log.printErrStackTrace("MicroMsg.WalletFunciontListInfo", localException2, "", new Object[0]);
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            this.KJf = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aa
 * JD-Core Version:    0.7.0.1
 */