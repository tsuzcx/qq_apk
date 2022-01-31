package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.q.a;
import com.tencent.mm.protocal.q.b;

final class o$a
  extends k
{
  private final q.a vNZ;
  final q.b vOa;
  
  public o$a()
  {
    AppMethodBeat.i(79559);
    this.vNZ = new q.a();
    this.vOa = new q.b();
    AppMethodBeat.o(79559);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.vNZ;
  }
  
  public final l.e getRespObj()
  {
    return this.vOa;
  }
  
  public final int getType()
  {
    if (f.whQ) {
      return 784;
    }
    return 722;
  }
  
  public final String getUri()
  {
    if (f.whQ) {
      return "/cgi-bin/micromsg-bin/secencryptcheckresupdate";
    }
    return "/cgi-bin/micromsg-bin/encryptcheckresupdate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.o.a
 * JD-Core Version:    0.7.0.1
 */