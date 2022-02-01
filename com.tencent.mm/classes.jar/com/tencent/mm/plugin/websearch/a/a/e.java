package com.tencent.mm.plugin.websearch.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class e
  extends a<a>
{
  public List<a> kLN;
  
  public e(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(116562);
    this.kLN = Collections.emptyList();
    AppMethodBeat.o(116562);
  }
  
  public final void gu(List<m> paramList)
  {
    AppMethodBeat.i(116563);
    this.kLN = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      m localm = (m)paramList.next();
      af localaf = ((k)g.ab(k.class)).apM().aHY(localm.roN);
      a locala = new a();
      locala.userName = localaf.field_username;
      locala.AHX = localm.content;
      locala.bNK = localaf.field_nickname;
      locala.iaz = localaf.field_conRemark;
      locala.eKn = localaf.Ss();
      locala.desc = localaf.evI;
      this.kLN.add(locala);
    }
    AppMethodBeat.o(116563);
  }
  
  public static final class a
  {
    public String AHX;
    public String bNK;
    public String desc;
    public String eKn;
    public String iaz;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.e
 * JD-Core Version:    0.7.0.1
 */