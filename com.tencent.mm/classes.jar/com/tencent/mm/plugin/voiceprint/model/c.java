package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class c
  extends l
{
  bf.a zdh;
  bf.b zdi;
  
  c()
  {
    AppMethodBeat.i(29758);
    this.zdh = new bf.a();
    this.zdi = new bf.b();
    AppMethodBeat.o(29758);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.zdh;
  }
  
  public final l.e getRespObj()
  {
    return this.zdi;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.c
 * JD-Core Version:    0.7.0.1
 */