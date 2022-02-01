package com.tencent.mm.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.h;

public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  public final void aEr()
  {
    AppMethodBeat.i(127630);
    if (aEs()) {
      this.BGp.ad(-107L, 1L);
    }
    AppMethodBeat.o(127630);
  }
  
  public final boolean aEs()
  {
    AppMethodBeat.i(127631);
    if (!hw(-107, 1))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.y.a
 * JD-Core Version:    0.7.0.1
 */