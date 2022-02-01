package com.tencent.mm.plugin.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.gs;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class k
  extends gs
  implements c
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(140938);
    info = gs.aJm();
    AppMethodBeat.o(140938);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final int getKey()
  {
    return this.field_localId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.k
 * JD-Core Version:    0.7.0.1
 */