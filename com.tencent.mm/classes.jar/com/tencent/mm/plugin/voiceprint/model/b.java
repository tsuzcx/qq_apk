package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class b
  extends o
{
  bl.a GQI;
  bl.b GQJ;
  
  b()
  {
    AppMethodBeat.i(29757);
    this.GQI = new bl.a();
    this.GQJ = new bl.b();
    AppMethodBeat.o(29757);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.GQI;
  }
  
  public final l.e getRespObj()
  {
    return this.GQJ;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.b
 * JD-Core Version:    0.7.0.1
 */