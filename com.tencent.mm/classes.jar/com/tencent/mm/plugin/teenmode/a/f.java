package com.tencent.mm.plugin.teenmode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.teenmode.b.a.b;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class f
  extends b
{
  public static IAutoDBItem.MAutoDBInfo dbInfo;
  
  static
  {
    AppMethodBeat.i(278944);
    dbInfo = aJm();
    AppMethodBeat.o(278944);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return dbInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.a.f
 * JD-Core Version:    0.7.0.1
 */