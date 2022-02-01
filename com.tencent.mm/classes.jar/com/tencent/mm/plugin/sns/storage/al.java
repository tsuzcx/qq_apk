package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ic;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class al
  extends ic
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(97651);
    info = ic.aJm();
    AppMethodBeat.o(97651);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.al
 * JD-Core Version:    0.7.0.1
 */