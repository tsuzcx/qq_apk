package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bx;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class bp
  extends bx
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(43198);
    info = bx.aJm();
    AppMethodBeat.o(43198);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final boolean jbg()
  {
    return this.field_isSend % 2 == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bp
 * JD-Core Version:    0.7.0.1
 */