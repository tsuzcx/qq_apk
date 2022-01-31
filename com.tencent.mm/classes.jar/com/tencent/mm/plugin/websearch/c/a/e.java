package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.mm.h.c.ao;
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
  public List<e.a> kxO = Collections.emptyList();
  
  public e(String paramString)
  {
    super(paramString);
  }
  
  public final void da(List<l> paramList)
  {
    this.kxO = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      l locall = (l)paramList.next();
      ad localad = ((j)g.r(j.class)).Fw().abl(locall.kwg);
      e.a locala = new e.a();
      locala.userName = localad.field_username;
      locala.qWf = locall.content;
      locala.aVr = localad.field_nickname;
      locala.fGK = localad.field_conRemark;
      locala.cMT = localad.vk();
      locala.desc = localad.cCJ;
      this.kxO.add(locala);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c.a.e
 * JD-Core Version:    0.7.0.1
 */