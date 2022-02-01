package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ae;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class n
  extends ae
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(32833);
    info = ae.aJm();
    AppMethodBeat.o(32833);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.n
 * JD-Core Version:    0.7.0.1
 */