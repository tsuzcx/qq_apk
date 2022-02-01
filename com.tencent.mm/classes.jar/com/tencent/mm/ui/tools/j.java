package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.ui.applet.SecurityImage.b;

final class j
  extends SecurityImage.b
{
  protected String pRA = "";
  protected byte[] pRy = null;
  protected String pRz = "";
  protected int qbo = 0;
  
  public final void bWF()
  {
    AppMethodBeat.i(39073);
    u localu = new u(this.qbo, "", this.pRz, this.pRA);
    bh.aZW().a(localu, 0);
    AppMethodBeat.o(39073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.j
 * JD-Core Version:    0.7.0.1
 */