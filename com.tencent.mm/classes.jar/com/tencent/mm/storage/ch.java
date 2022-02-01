package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ga;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class ch
  extends ga
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(32880);
    info = ga.aJm();
    AppMethodBeat.o(32880);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.ch
 * JD-Core Version:    0.7.0.1
 */