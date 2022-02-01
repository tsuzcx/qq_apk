package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.et;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class bz
  extends et
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(43200);
    info = et.aJm();
    AppMethodBeat.o(43200);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bz
 * JD-Core Version:    0.7.0.1
 */