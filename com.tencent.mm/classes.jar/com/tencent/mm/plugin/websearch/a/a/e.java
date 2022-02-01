package com.tencent.mm.plugin.websearch.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class e
  extends a<a>
{
  public List<a> lnk;
  
  public e(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(116562);
    this.lnk = Collections.emptyList();
    AppMethodBeat.o(116562);
  }
  
  public final void gF(List<m> paramList)
  {
    AppMethodBeat.i(116563);
    this.lnk = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      m localm = (m)paramList.next();
      ai localai = ((k)g.ab(k.class)).awB().aNt(localm.sxG);
      a locala = new a();
      locala.userName = localai.field_username;
      locala.Cao = localm.content;
      locala.bLs = localai.field_nickname;
      locala.iAC = localai.field_conRemark;
      locala.eNf = localai.Tl();
      locala.desc = localai.eyf;
      this.lnk.add(locala);
    }
    AppMethodBeat.o(116563);
  }
  
  public static final class a
  {
    public String Cao;
    public String bLs;
    public String desc;
    public String eNf;
    public String iAC;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.e
 * JD-Core Version:    0.7.0.1
 */