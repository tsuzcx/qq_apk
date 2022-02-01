package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bw;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class bn
  extends bw
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(43197);
    info = bw.aJm();
    AppMethodBeat.o(43197);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bn
 * JD-Core Version:    0.7.0.1
 */