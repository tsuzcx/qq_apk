package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.TimerTask;

final class b$7
  extends TimerTask
{
  b$7(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(135325);
    b.p(this.tLv).post(new b.7.1(this));
    AppMethodBeat.o(135325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.7
 * JD-Core Version:    0.7.0.1
 */