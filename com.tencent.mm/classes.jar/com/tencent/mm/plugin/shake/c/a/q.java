package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.b.a.c;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class q
  extends c
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(28347);
    info = c.aJm();
    AppMethodBeat.o(28347);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.q
 * JD-Core Version:    0.7.0.1
 */