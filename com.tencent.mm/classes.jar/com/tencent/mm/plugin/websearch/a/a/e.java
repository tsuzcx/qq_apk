package com.tencent.mm.plugin.websearch.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class e
  extends a<a>
{
  public List<a> lKC;
  
  public e(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(116562);
    this.lKC = Collections.emptyList();
    AppMethodBeat.o(116562);
  }
  
  public final void gR(List<m> paramList)
  {
    AppMethodBeat.i(116563);
    this.lKC = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      m localm = (m)paramList.next();
      am localam = ((l)g.ab(l.class)).azp().Bf(localm.tuh);
      a locala = new a();
      locala.userName = localam.field_username;
      locala.DDj = localm.content;
      locala.bVF = localam.field_nickname;
      locala.iTM = localam.field_conRemark;
      locala.ffB = localam.VA();
      locala.desc = localam.ePD;
      this.lKC.add(locala);
    }
    AppMethodBeat.o(116563);
  }
  
  public static final class a
  {
    public String DDj;
    public String bVF;
    public String desc;
    public String ffB;
    public String iTM;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.e
 * JD-Core Version:    0.7.0.1
 */