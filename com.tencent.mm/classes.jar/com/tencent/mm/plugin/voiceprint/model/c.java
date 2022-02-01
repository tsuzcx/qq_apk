package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.bm.a;
import com.tencent.mm.model.bm.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class c
  extends o
{
  bm.a GQK;
  bm.b GQL;
  
  c()
  {
    AppMethodBeat.i(29758);
    this.GQK = new bm.a();
    this.GQL = new bm.b();
    AppMethodBeat.o(29758);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.GQK;
  }
  
  public final l.e getRespObj()
  {
    return this.GQL;
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