package com.tencent.mm.plugin.websearch.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class e
  extends a<a>
{
  public List<a> mWl;
  
  public e(String paramString)
  {
    super(paramString, 2147483647);
    AppMethodBeat.i(116562);
    this.mWl = Collections.emptyList();
    AppMethodBeat.o(116562);
  }
  
  public final void ih(List<m> paramList)
  {
    AppMethodBeat.i(116563);
    this.mWl = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      m localm = (m)paramList.next();
      as localas = ((l)g.af(l.class)).aSN().Kn(localm.wVX);
      a locala = new a();
      locala.userName = localas.field_username;
      locala.IGC = localm.content;
      locala.nickName = localas.field_nickname;
      locala.remark = localas.field_conRemark;
      locala.fMb = localas.ajx();
      locala.desc = localas.fuR;
      this.mWl.add(locala);
    }
    AppMethodBeat.o(116563);
  }
  
  public static final class a
  {
    public String IGC;
    public String desc;
    public String fMb;
    public String nickName;
    public String remark;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.a.e
 * JD-Core Version:    0.7.0.1
 */