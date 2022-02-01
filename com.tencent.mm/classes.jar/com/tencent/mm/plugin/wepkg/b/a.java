package com.tencent.mm.plugin.wepkg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ip;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class a
  extends ip
{
  public static final IAutoDBItem.MAutoDBInfo nVV;
  
  static
  {
    AppMethodBeat.i(110557);
    nVV = ip.aJm();
    AppMethodBeat.o(110557);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.a
 * JD-Core Version:    0.7.0.1
 */