package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ah$1$2$1
  implements Runnable
{
  ah$1$2$1(ah.1.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(27371);
    ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene again");
    this.vLO.vLN.vLM.doScene(this.vLO.vLN.vLM.dispatcher(), this.vLO.vLN.vLM.callback);
    AppMethodBeat.o(27371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ah.1.2.1
 * JD-Core Version:    0.7.0.1
 */