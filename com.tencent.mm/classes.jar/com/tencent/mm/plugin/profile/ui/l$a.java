package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.jx;

final class l$a
{
  private final jx MXF;
  
  private l$a()
  {
    AppMethodBeat.i(305495);
    this.MXF = new jx();
    AppMethodBeat.o(305495);
  }
  
  final void fI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(305500);
    jx localjx = this.MXF;
    localjx.iUN = paramInt1;
    localjx.iPC = paramInt2;
    localjx.bMH();
    AppMethodBeat.o(305500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.l.a
 * JD-Core Version:    0.7.0.1
 */