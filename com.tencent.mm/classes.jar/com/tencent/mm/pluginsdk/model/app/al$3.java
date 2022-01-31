package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;

final class al$3
  implements Runnable
{
  al$3(al paramal) {}
  
  public final void run()
  {
    AppMethodBeat.i(27413);
    SightVideoJNI.registerALL();
    AppMethodBeat.o(27413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.al.3
 * JD-Core Version:    0.7.0.1
 */