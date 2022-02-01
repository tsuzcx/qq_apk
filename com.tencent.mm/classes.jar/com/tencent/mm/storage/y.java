package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ao;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class y
  extends ao
{
  public static int acEX;
  public static int acEY;
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(248747);
    acEX = 1;
    acEY = 2;
    info = ao.aJm();
    AppMethodBeat.o(248747);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.y
 * JD-Core Version:    0.7.0.1
 */