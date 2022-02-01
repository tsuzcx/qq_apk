package com.tencent.mm.plugin.websearch.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class e
  extends a<a>
{
  public List<a> lPc;
  
  public e(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(116562);
    this.lPc = Collections.emptyList();
    AppMethodBeat.o(116562);
  }
  
  public final void hb(List<m> paramList)
  {
    AppMethodBeat.i(116563);
    this.lPc = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      m localm = (m)paramList.next();
      an localan = ((l)g.ab(l.class)).azF().BH(localm.tEY);
      a locala = new a();
      locala.userName = localan.field_username;
      locala.DVh = localm.content;
      locala.bVF = localan.field_nickname;
      locala.iWF = localan.field_conRemark;
      locala.fhy = localan.VI();
      locala.desc = localan.eRo;
      this.lPc.add(locala);
    }
    AppMethodBeat.o(116563);
  }
  
  public static final class a
  {
    public String DVh;
    public String bVF;
    public String desc;
    public String fhy;
    public String iWF;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.e
 * JD-Core Version:    0.7.0.1
 */