package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.gy;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class aq
  extends gy
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(120859);
    info = gy.aJm();
    AppMethodBeat.o(120859);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.aq
 * JD-Core Version:    0.7.0.1
 */