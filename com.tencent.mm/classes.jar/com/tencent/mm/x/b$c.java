package com.tencent.mm.x;

import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class b$c
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int dCc = 0;
  private int mCount = 0;
  
  public b$c(b paramb) {}
  
  public final boolean execute()
  {
    y.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteAllFriendsTask mFriendType: %s]", new Object[] { Integer.valueOf(this.dCc) });
    if (this.dCc == 0) {
      this.mCount = this.dBR.dBP.f(c.kuX, -1).size();
    }
    return true;
  }
  
  public final String toString()
  {
    return "DeleteAllFriends [" + this.mCount + ", " + this.dCc + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.x.b.c
 * JD-Core Version:    0.7.0.1
 */