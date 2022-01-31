package com.tencent.mm.plugin.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.e.j;

public final class e
  extends j<y>
{
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(47074);
    SQL_CREATE = new String[] { j.getCreateSQLs(y.info, "WalletFunciontList") };
    AppMethodBeat.o(47074);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, y.info, "WalletFunciontList", null);
    this.db = parame;
  }
  
  public final void b(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(47073);
    y localy = new y();
    localy.field_wallet_region = paramInt1;
    localy.field_function_list = paramString1;
    localy.field_new_list = paramString2;
    localy.field_banner_list = paramString3;
    localy.field_type_name_list = paramString4;
    localy.field_isShowSetting = paramInt2;
    super.replace(localy);
    AppMethodBeat.o(47073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.e
 * JD-Core Version:    0.7.0.1
 */