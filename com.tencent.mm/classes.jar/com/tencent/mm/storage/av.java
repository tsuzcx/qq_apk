package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ba;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class av
  extends ba
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(116966);
    info = ba.aJm();
    AppMethodBeat.o(116966);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.av
 * JD-Core Version:    0.7.0.1
 */