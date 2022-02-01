package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.ui.applet.SecurityImage.b;

final class i
  extends SecurityImage.b
{
  protected byte[] kdr = null;
  protected String kds = "";
  protected String kdt = "";
  protected int kmJ = 0;
  
  public final void bnH()
  {
    AppMethodBeat.i(39073);
    com.tencent.mm.modelsimple.t localt = new com.tencent.mm.modelsimple.t(this.kmJ, "", this.kds, this.kdt);
    bg.azz().a(localt, 0);
    AppMethodBeat.o(39073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */