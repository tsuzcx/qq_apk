package com.tencent.mm.plugin.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class f
  extends MAutoStorage<z>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(70614);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(z.info, "WalletFunciontList") };
    AppMethodBeat.o(70614);
  }
  
  public f(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, z.info, "WalletFunciontList", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final void b(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(70613);
    z localz = new z();
    localz.field_wallet_region = paramInt1;
    localz.field_function_list = paramString1;
    localz.field_new_list = paramString2;
    localz.field_banner_list = paramString3;
    localz.field_type_name_list = paramString4;
    localz.field_isShowSetting = paramInt2;
    super.replace(localz);
    AppMethodBeat.o(70613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.f
 * JD-Core Version:    0.7.0.1
 */