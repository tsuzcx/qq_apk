package com.tencent.mm.x;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;

final class b$f
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int dCc;
  private String dCd;
  private boolean dCg = false;
  
  public b$f(b paramb, String paramString)
  {
    this.dCd = paramString;
    this.dCc = 0;
  }
  
  public final boolean execute()
  {
    y.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[InsertFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.dCd, Integer.valueOf(this.dCc) });
    if (this.dCc == 0)
    {
      localObject = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).pI(this.dCd);
      if (localObject == null) {
        this.dCg = true;
      }
    }
    else
    {
      return true;
    }
    Object localObject = new b.a((com.tencent.mm.plugin.account.friend.a.a)localObject);
    if (b.a((b.a)localObject))
    {
      b.a(this.dBR, (b.a)localObject);
      return true;
    }
    this.dCg = true;
    return true;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("InsertFriend(\"").append(this.dCd).append("\", ").append(this.dCc).append(")");
    if (this.dCg) {}
    for (String str = " [skipped]";; str = "") {
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.x.b.f
 * JD-Core Version:    0.7.0.1
 */