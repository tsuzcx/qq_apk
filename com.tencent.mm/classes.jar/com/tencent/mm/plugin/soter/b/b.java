package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class b
  extends k
{
  c.a snI;
  c.b snJ;
  
  b()
  {
    AppMethodBeat.i(59297);
    this.snI = new c.a();
    this.snJ = new c.b();
    AppMethodBeat.o(59297);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.snI;
  }
  
  public final l.e getRespObj()
  {
    return this.snJ;
  }
  
  public final int getType()
  {
    return 627;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/updatesoteraskrsa";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.b
 * JD-Core Version:    0.7.0.1
 */