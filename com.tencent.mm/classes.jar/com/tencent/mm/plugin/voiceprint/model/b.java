package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.model.bh.a;
import com.tencent.mm.model.bh.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class b
  extends l
{
  bh.a CmH;
  bh.b CmI;
  
  b()
  {
    AppMethodBeat.i(29757);
    this.CmH = new bh.a();
    this.CmI = new bh.b();
    AppMethodBeat.o(29757);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.CmH;
  }
  
  public final l.e getRespObj()
  {
    return this.CmI;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.b
 * JD-Core Version:    0.7.0.1
 */