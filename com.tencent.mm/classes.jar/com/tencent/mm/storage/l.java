package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ad;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class l
  extends ad
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(32825);
    info = ad.aJm();
    AppMethodBeat.o(32825);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.l
 * JD-Core Version:    0.7.0.1
 */