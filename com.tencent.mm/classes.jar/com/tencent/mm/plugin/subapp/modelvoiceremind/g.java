package com.tencent.mm.plugin.subapp.modelvoiceremind;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ie;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class g
  extends ie
{
  protected static IAutoDBItem.MAutoDBInfo info;
  int eQp = -1;
  
  static
  {
    AppMethodBeat.i(28963);
    info = ie.aJm();
    AppMethodBeat.o(28963);
  }
  
  public final boolean bPk()
  {
    return ((this.field_status > 1) && (this.field_status <= 3)) || (this.field_status == 8);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.modelvoiceremind.g
 * JD-Core Version:    0.7.0.1
 */