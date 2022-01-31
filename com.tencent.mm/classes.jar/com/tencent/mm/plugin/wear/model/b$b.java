package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.wear.model.d.a;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.protobuf.cwy;

final class b$b
  extends d
{
  private cwy uGQ;
  
  public b$b(b paramb, cwy paramcwy)
  {
    this.uGQ = paramcwy;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(26279);
    aw.Rc().a(1091, this.uGP);
    a locala = new a(this.uGQ.yeC, "gh_43f2581f6fd6");
    aw.Rc().a(locala, 0);
    AppMethodBeat.o(26279);
  }
  
  public final String getName()
  {
    return "RegisterDeviceTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.b.b
 * JD-Core Version:    0.7.0.1
 */