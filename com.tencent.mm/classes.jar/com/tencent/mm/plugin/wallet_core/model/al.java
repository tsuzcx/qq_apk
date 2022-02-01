package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.io;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class al
  extends io
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(70492);
    info = io.aJm();
    AppMethodBeat.o(70492);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final boolean ijf()
  {
    return this.field_is_reg == 1;
  }
  
  public final boolean ijg()
  {
    return this.field_is_reg == 2;
  }
  
  public final boolean ijh()
  {
    return this.field_is_reg == 0;
  }
  
  public final boolean iji()
  {
    return this.field_is_reg == -1;
  }
  
  public final boolean ijj()
  {
    return this.field_is_open_touch == 1;
  }
  
  public final boolean ijk()
  {
    return this.field_authen_account_type == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.al
 * JD-Core Version:    0.7.0.1
 */