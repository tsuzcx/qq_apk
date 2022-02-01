package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.dh;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class bs
  extends dh
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(248430);
    info = dh.aJm();
    AppMethodBeat.o(248430);
  }
  
  public bs()
  {
    AppMethodBeat.i(248428);
    this.field_encryptUsername = "";
    this.field_username = "";
    AppMethodBeat.o(248428);
  }
  
  public bs(String paramString)
  {
    this();
    AppMethodBeat.i(248426);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.field_encryptUsername = str;
    this.field_modifyTime = System.currentTimeMillis();
    AppMethodBeat.o(248426);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bs
 * JD-Core Version:    0.7.0.1
 */