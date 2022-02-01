package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.n;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class c
  extends n
{
  bo.a UsV;
  bo.b UsW;
  
  c()
  {
    AppMethodBeat.i(29758);
    this.UsV = new bo.a();
    this.UsW = new bo.b();
    AppMethodBeat.o(29758);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.UsV;
  }
  
  public final l.e getRespObj()
  {
    return this.UsW;
  }
  
  public final int getType()
  {
    return 617;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/verifyvoiceprintrsa";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.c
 * JD-Core Version:    0.7.0.1
 */