package com.tencent.mm.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.h;

public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  public final void acM()
  {
    AppMethodBeat.i(127630);
    if (acN()) {
      this.rni.U(-107L, 1L);
    }
    AppMethodBeat.o(127630);
  }
  
  public final boolean acN()
  {
    AppMethodBeat.i(127631);
    if (!fH(-107, 1))
    {
      AppMethodBeat.o(127631);
      return true;
    }
    AppMethodBeat.o(127631);
    return false;
  }
  
  public final String getName()
  {
    return "FTS5FriendStorage";
  }
  
  public final int getPriority()
  {
    return 1280;
  }
  
  public final String getTableName()
  {
    return "Friend";
  }
  
  public final int getType()
  {
    return 1280;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.x.a
 * JD-Core Version:    0.7.0.1
 */