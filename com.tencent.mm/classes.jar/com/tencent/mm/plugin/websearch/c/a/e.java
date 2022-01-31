package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class e
  extends a<e.a>
{
  public List<e.a> mTC;
  
  public e(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(91376);
    this.mTC = Collections.emptyList();
    AppMethodBeat.o(91376);
  }
  
  public final void ee(List<l> paramList)
  {
    AppMethodBeat.i(91377);
    this.mTC = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      l locall = (l)paramList.next();
      ad localad = ((j)g.E(j.class)).YA().arw(locall.mRV);
      e.a locala = new e.a();
      locala.userName = localad.field_username;
      locala.uLr = locall.content;
      locala.blZ = localad.field_nickname;
      locala.hKa = localad.field_conRemark;
      locala.dCJ = localad.Hq();
      locala.desc = localad.dqT;
      this.mTC.add(locala);
    }
    AppMethodBeat.o(91377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c.a.e
 * JD-Core Version:    0.7.0.1
 */