package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;

final class ao$5
  implements Runnable
{
  ao$5(ao paramao)
  {
    AppMethodBeat.i(161481);
    AppMethodBeat.o(161481);
  }
  
  public final void run()
  {
    AppMethodBeat.i(232175);
    SightVideoJNI.registerALL();
    AppMethodBeat.o(232175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ao.5
 * JD-Core Version:    0.7.0.1
 */