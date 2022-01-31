package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.model.bb.a;
import com.tencent.mm.model.bb.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class b
  extends k
{
  bb.a tqV;
  bb.b tqW;
  
  b()
  {
    AppMethodBeat.i(26076);
    this.tqV = new bb.a();
    this.tqW = new bb.b();
    AppMethodBeat.o(26076);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.tqV;
  }
  
  public final l.e getRespObj()
  {
    return this.tqW;
  }
  
  public final int getType()
  {
    return 618;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/getvoiceprintticketrsa";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.b
 * JD-Core Version:    0.7.0.1
 */