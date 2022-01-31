package com.tencent.mm.x;

import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.y;

final class b$d
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int dCc;
  private String dCd;
  
  public b$d(b paramb, String paramString)
  {
    this.dCd = paramString;
    this.dCc = 0;
  }
  
  public final boolean execute()
  {
    y.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.dCd, Integer.valueOf(this.dCc) });
    if (this.dCc == 0)
    {
      long l = com.tencent.mm.plugin.account.friend.a.a.pF(this.dCd);
      this.dBR.dBP.c(c.kuX, l);
    }
    return true;
  }
  
  public final String toString()
  {
    return "DeleteFriend(\"" + this.dCd + "\", " + this.dCc + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.x.b.d
 * JD-Core Version:    0.7.0.1
 */