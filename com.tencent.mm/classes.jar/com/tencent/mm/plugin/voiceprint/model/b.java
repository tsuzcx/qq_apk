package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class b
  extends l
{
  bf.a BVg;
  bf.b BVh;
  
  b()
  {
    AppMethodBeat.i(29757);
    this.BVg = new bf.a();
    this.BVh = new bf.b();
    AppMethodBeat.o(29757);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.BVg;
  }
  
  public final l.e getRespObj()
  {
    return this.BVh;
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