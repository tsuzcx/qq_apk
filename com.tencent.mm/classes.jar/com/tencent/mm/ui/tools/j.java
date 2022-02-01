package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.ui.applet.SecurityImage.b;

final class j
  extends SecurityImage.b
{
  protected byte[] mUR = null;
  protected String mUS = "";
  protected String mUT = "";
  protected int neB = 0;
  
  public final void bxQ()
  {
    AppMethodBeat.i(39073);
    com.tencent.mm.modelsimple.t localt = new com.tencent.mm.modelsimple.t(this.neB, "", this.mUS, this.mUT);
    bh.aGY().a(localt, 0);
    AppMethodBeat.o(39073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.j
 * JD-Core Version:    0.7.0.1
 */