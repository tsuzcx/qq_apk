package com.tencent.mm.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.h;

public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  public final void Pn()
  {
    AppMethodBeat.i(124472);
    if (Po()) {
      this.mQr.M(-107L, 1L);
    }
    AppMethodBeat.o(124472);
  }
  
  public final boolean Po()
  {
    AppMethodBeat.i(124473);
    if (!er(-107, 1))
    {
      AppMethodBeat.o(124473);
      return true;
    }
    AppMethodBeat.o(124473);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.w.a
 * JD-Core Version:    0.7.0.1
 */