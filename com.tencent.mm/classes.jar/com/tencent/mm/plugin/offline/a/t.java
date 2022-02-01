package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fr;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class t
  extends fr
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(66319);
    info = fr.aJm();
    AppMethodBeat.o(66319);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.t
 * JD-Core Version:    0.7.0.1
 */