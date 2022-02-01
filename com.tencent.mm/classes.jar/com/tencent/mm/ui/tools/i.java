package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.ui.applet.SecurityImage.b;

final class i
  extends SecurityImage.b
{
  protected byte[] jfo = null;
  protected String jfp = "";
  protected String jfq = "";
  protected int joz = 0;
  
  public final void aSU()
  {
    AppMethodBeat.i(39073);
    t localt = new t(this.joz, "", this.jfp, this.jfq);
    bc.ajj().a(localt, 0);
    AppMethodBeat.o(39073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */