package com.tencent.mm.x;

import com.tencent.mm.plugin.fts.a.h;

public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  protected final boolean BA()
  {
    return !cT(-107, 1);
  }
  
  protected final void Bz()
  {
    if (BA()) {
      this.kuE.A(-107L, 1L);
    }
  }
  
  public final String getName()
  {
    return "FTS5FriendStorage";
  }
  
  public final int getPriority()
  {
    return 1280;
  }
  
  protected final String getTableName()
  {
    return "Friend";
  }
  
  public final int getType()
  {
    return 1280;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.x.a
 * JD-Core Version:    0.7.0.1
 */