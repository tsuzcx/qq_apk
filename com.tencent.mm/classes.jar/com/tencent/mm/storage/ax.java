package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bc;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class ax
  extends bc
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(32840);
    info = bc.aJm();
    AppMethodBeat.o(32840);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.ax
 * JD-Core Version:    0.7.0.1
 */