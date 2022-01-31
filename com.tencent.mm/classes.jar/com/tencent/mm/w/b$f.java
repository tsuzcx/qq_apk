package com.tencent.mm.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

final class b$f
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int ezt;
  private String ezu;
  private boolean ezx = false;
  
  public b$f(b paramb, String paramString)
  {
    this.ezu = paramString;
    this.ezt = 0;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(124483);
    ab.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[InsertFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.ezu, Integer.valueOf(this.ezt) });
    if (this.ezt == 0)
    {
      Object localObject = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).xa(this.ezu);
      if (localObject == null)
      {
        this.ezx = true;
        AppMethodBeat.o(124483);
        return true;
      }
      localObject = new b.a((com.tencent.mm.plugin.account.friend.a.a)localObject);
      if (!b.a((b.a)localObject)) {
        break label112;
      }
      b.a(this.ezi, (b.a)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(124483);
      return true;
      label112:
      this.ezx = true;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(124484);
    StringBuilder localStringBuilder = new StringBuilder("InsertFriend(\"").append(this.ezu).append("\", ").append(this.ezt).append(")");
    if (this.ezx) {}
    for (String str = " [skipped]";; str = "")
    {
      str = str;
      AppMethodBeat.o(124484);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.w.b.f
 * JD-Core Version:    0.7.0.1
 */