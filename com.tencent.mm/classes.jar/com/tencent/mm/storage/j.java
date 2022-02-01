package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ac;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class j
  extends ac
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(32817);
    info = ac.aJm();
    AppMethodBeat.o(32817);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.j
 * JD-Core Version:    0.7.0.1
 */