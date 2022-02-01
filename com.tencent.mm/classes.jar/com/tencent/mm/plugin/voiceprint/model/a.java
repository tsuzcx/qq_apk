package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.model.be.a;
import com.tencent.mm.model.be.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class a
  extends l
{
  be.a BVe;
  be.b BVf;
  
  a()
  {
    AppMethodBeat.i(29756);
    this.BVe = new be.a();
    this.BVf = new be.b();
    AppMethodBeat.o(29756);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.BVe;
  }
  
  public final l.e getRespObj()
  {
    return this.BVf;
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