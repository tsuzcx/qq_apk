package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.model.bg.a;
import com.tencent.mm.model.bg.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class a
  extends l
{
  bg.a CmF;
  bg.b CmG;
  
  a()
  {
    AppMethodBeat.i(29756);
    this.CmF = new bg.a();
    this.CmG = new bg.b();
    AppMethodBeat.o(29756);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.CmF;
  }
  
  public final l.e getRespObj()
  {
    return this.CmG;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.a
 * JD-Core Version:    0.7.0.1
 */