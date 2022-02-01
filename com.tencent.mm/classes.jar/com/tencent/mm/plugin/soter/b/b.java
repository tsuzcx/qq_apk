package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class b
  extends o
{
  c.a Fho;
  c.b Fhp;
  
  b()
  {
    AppMethodBeat.i(130804);
    this.Fho = new c.a();
    this.Fhp = new c.b();
    AppMethodBeat.o(130804);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.Fho;
  }
  
  public final l.e getRespObj()
  {
    return this.Fhp;
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