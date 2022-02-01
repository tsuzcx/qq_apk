package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.model.bk.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class a
  extends o
{
  bk.a GQG;
  bk.b GQH;
  
  a()
  {
    AppMethodBeat.i(29756);
    this.GQG = new bk.a();
    this.GQH = new bk.b();
    AppMethodBeat.o(29756);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.GQG;
  }
  
  public final l.e getRespObj()
  {
    return this.GQH;
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