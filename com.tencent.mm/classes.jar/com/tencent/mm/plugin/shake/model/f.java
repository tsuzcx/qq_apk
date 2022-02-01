package com.tencent.mm.plugin.shake.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.b.a.a;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class f
  extends a
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(28128);
    info = a.aJm();
    AppMethodBeat.o(28128);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.model.f
 * JD-Core Version:    0.7.0.1
 */