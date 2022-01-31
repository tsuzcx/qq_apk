package com.tencent.xweb.xwalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimerTask;
import org.xwalk.core.XWalkInitializer;

final class g$1
  extends TimerTask
{
  g$1(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(85491);
    XWalkInitializer.addXWalkInitializeLog("task retry execute ! mRetrytimes = " + g.a(this.BLq));
    g.a(g.b(this.BLq), g.c(this.BLq), g.a(this.BLq));
    g.d(this.BLq);
    AppMethodBeat.o(85491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.g.1
 * JD-Core Version:    0.7.0.1
 */