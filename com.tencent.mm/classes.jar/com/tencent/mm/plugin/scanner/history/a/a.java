package com.tencent.mm.plugin.scanner.history.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.gx;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class a
  extends gx
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(51587);
    info = gx.aJm();
    AppMethodBeat.o(51587);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.a.a
 * JD-Core Version:    0.7.0.1
 */