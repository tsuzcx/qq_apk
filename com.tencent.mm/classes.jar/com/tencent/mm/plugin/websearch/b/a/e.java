package com.tencent.mm.plugin.websearch.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class e
  extends a<a>
{
  public List<a> pWR;
  
  public e(String paramString)
  {
    super(paramString, 2147483647);
    AppMethodBeat.i(116562);
    this.pWR = Collections.emptyList();
    AppMethodBeat.o(116562);
  }
  
  public final void iX(List<m> paramList)
  {
    AppMethodBeat.i(116563);
    this.pWR = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      m localm = (m)paramList.next();
      as localas = ((n)h.ae(n.class)).bbL().RG(localm.BHS);
      a locala = new a();
      locala.userName = localas.field_username;
      locala.PAT = localm.content;
      locala.nickName = localas.field_nickname;
      locala.remark = localas.field_conRemark;
      locala.idS = localas.apf();
      locala.desc = localas.hDq;
      this.pWR.add(locala);
    }
    AppMethodBeat.o(116563);
  }
  
  public static final class a
  {
    public String PAT;
    public String desc;
    public String idS;
    public String nickName;
    public String remark;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.a.e
 * JD-Core Version:    0.7.0.1
 */