package com.tencent.mm.plugin.music.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fg;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class c
  extends fg
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(63178);
    info = fg.ajs();
    AppMethodBeat.o(63178);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e.c
 * JD-Core Version:    0.7.0.1
 */