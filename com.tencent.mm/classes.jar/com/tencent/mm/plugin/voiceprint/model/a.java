package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.model.ba.a;
import com.tencent.mm.model.ba.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class a
  extends k
{
  ba.a tqT;
  ba.b tqU;
  
  a()
  {
    AppMethodBeat.i(26075);
    this.tqT = new ba.a();
    this.tqU = new ba.b();
    AppMethodBeat.o(26075);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.tqT;
  }
  
  public final l.e getRespObj()
  {
    return this.tqU;
  }
  
  public final int getType()
  {
    return 616;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/getvoiceprintresourcersa";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.a
 * JD-Core Version:    0.7.0.1
 */