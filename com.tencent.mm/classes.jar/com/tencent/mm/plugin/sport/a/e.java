package com.tencent.mm.plugin.sport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.hr;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class e
  extends hr
  implements Comparable<e>
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(116812);
    info = hr.aJm();
    AppMethodBeat.o(116812);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.a.e
 * JD-Core Version:    0.7.0.1
 */