package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class e
  extends a<a>
{
  public List<a> tbH;
  
  public e(String paramString)
  {
    super(paramString, 2147483647);
    AppMethodBeat.i(116562);
    this.tbH = Collections.emptyList();
    AppMethodBeat.o(116562);
  }
  
  public final void mf(List<o> paramList)
  {
    AppMethodBeat.i(116563);
    this.tbH = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      o localo = (o)paramList.next();
      au localau = ((n)h.ax(n.class)).bzA().JE(localo.Hsz);
      a locala = new a();
      locala.userName = localau.field_username;
      locala.Wrk = localo.content;
      locala.nickName = localau.field_nickname;
      locala.remark = localau.field_conRemark;
      locala.kDc = localau.aJs();
      locala.desc = localau.kal;
      this.tbH.add(locala);
    }
    AppMethodBeat.o(116563);
  }
  
  public static final class a
  {
    public String Wrk;
    public String desc;
    public String kDc;
    public String nickName;
    public String remark;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c.a.e
 * JD-Core Version:    0.7.0.1
 */