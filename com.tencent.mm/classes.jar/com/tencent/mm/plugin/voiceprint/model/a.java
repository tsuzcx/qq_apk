package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class a
  extends l
{
  bd.a AvJ;
  bd.b AvK;
  
  a()
  {
    AppMethodBeat.i(29756);
    this.AvJ = new bd.a();
    this.AvK = new bd.b();
    AppMethodBeat.o(29756);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.AvJ;
  }
  
  public final l.e getRespObj()
  {
    return this.AvK;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.a
 * JD-Core Version:    0.7.0.1
 */