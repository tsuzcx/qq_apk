package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fa;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class n
  extends fa
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(70302);
    info = fa.aJm();
    AppMethodBeat.o(70302);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.n
 * JD-Core Version:    0.7.0.1
 */