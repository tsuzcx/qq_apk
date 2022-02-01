package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class b
  extends l
{
  c.a AES;
  c.b AET;
  
  b()
  {
    AppMethodBeat.i(130804);
    this.AES = new c.a();
    this.AET = new c.b();
    AppMethodBeat.o(130804);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.AES;
  }
  
  public final l.e getRespObj()
  {
    return this.AET;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.b
 * JD-Core Version:    0.7.0.1
 */