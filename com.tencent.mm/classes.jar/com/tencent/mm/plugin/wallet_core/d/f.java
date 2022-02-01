package com.tencent.mm.plugin.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class f
  extends MAutoStorage<aa>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(70614);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(aa.info, "WalletFunciontList") };
    AppMethodBeat.o(70614);
  }
  
  public f(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, aa.info, "WalletFunciontList", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final void c(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(70613);
    aa localaa = new aa();
    localaa.field_wallet_region = paramInt1;
    localaa.field_function_list = paramString1;
    localaa.field_new_list = paramString2;
    localaa.field_banner_list = paramString3;
    localaa.field_type_name_list = paramString4;
    localaa.field_isShowSetting = paramInt2;
    super.replace(localaa);
    AppMethodBeat.o(70613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.f
 * JD-Core Version:    0.7.0.1
 */