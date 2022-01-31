package com.tencent.mm.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  m ezf;
  a ezg;
  private n.b ezh;
  
  public b()
  {
    AppMethodBeat.i(124486);
    this.ezh = new b.1(this);
    AppMethodBeat.o(124486);
  }
  
  public final boolean Pp()
  {
    AppMethodBeat.i(124488);
    ((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().b(this.ezh);
    AppMethodBeat.o(124488);
    return true;
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(i parami)
  {
    AppMethodBeat.i(124489);
    parami = new b.g(this, parami);
    parami = this.ezf.a(-65536, parami);
    AppMethodBeat.o(124489);
    return parami;
  }
  
  public final String getName()
  {
    return "FTS5SearchFriendLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(124487);
    if (!((com.tencent.mm.plugin.fts.a.n)g.G(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      ab.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Fail!");
      AppMethodBeat.o(124487);
      return false;
    }
    ab.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Success!");
    this.ezg = ((a)((com.tencent.mm.plugin.fts.a.n)g.G(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(1280));
    this.ezf = ((com.tencent.mm.plugin.fts.a.n)g.G(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.ezf.a(131172, new b.b(this, (byte)0));
    ((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().a(this.ezh);
    AppMethodBeat.o(124487);
    return true;
  }
  
  final class d
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int ezt;
    private String ezu;
    
    public d(String paramString)
    {
      this.ezu = paramString;
      this.ezt = 0;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(124481);
      ab.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.ezu, Integer.valueOf(this.ezt) });
      if (this.ezt == 0)
      {
        long l = com.tencent.mm.plugin.account.friend.a.a.wV(this.ezu);
        b.this.ezg.c(c.mQK, l);
      }
      AppMethodBeat.o(124481);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(124482);
      String str = "DeleteFriend(\"" + this.ezu + "\", " + this.ezt + ")";
      AppMethodBeat.o(124482);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.w.b
 * JD-Core Version:    0.7.0.1
 */