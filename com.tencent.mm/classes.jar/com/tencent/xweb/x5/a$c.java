package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.xweb.j;

public final class a$c
  implements JsResult
{
  public j BHP;
  
  public a$c(j paramj)
  {
    this.BHP = paramj;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(84780);
    this.BHP.cancel();
    AppMethodBeat.o(84780);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(84779);
    this.BHP.confirm();
    AppMethodBeat.o(84779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.x5.a.c
 * JD-Core Version:    0.7.0.1
 */