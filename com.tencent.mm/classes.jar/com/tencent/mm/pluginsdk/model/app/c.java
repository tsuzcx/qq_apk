package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.i;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class c
  extends i
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(151651);
    info = i.aJm();
    AppMethodBeat.o(151651);
  }
  
  public c()
  {
    this.field_netTimes = 0L;
  }
  
  public final boolean efT()
  {
    if (this.field_totalLen <= 0L) {}
    while (this.field_offset != this.field_totalLen) {
      return false;
    }
    return true;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.c
 * JD-Core Version:    0.7.0.1
 */