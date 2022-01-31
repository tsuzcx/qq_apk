package com.tencent.mm.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class b$c
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int ezt = 0;
  private int mCount = 0;
  
  public b$c(b paramb) {}
  
  public final boolean execute()
  {
    AppMethodBeat.i(124479);
    ab.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteAllFriendsTask mFriendType: %s]", new Object[] { Integer.valueOf(this.ezt) });
    if (this.ezt == 0) {
      this.mCount = this.ezi.ezg.g(c.mQK, -1).size();
    }
    AppMethodBeat.o(124479);
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(124480);
    String str = "DeleteAllFriends [" + this.mCount + ", " + this.ezt + "]";
    AppMethodBeat.o(124480);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.w.b.c
 * JD-Core Version:    0.7.0.1
 */