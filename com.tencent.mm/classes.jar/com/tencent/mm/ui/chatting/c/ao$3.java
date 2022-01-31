package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.LinkedHashMap;

final class ao$3
  implements Runnable
{
  ao$3(ao paramao) {}
  
  public final void run()
  {
    AppMethodBeat.i(31785);
    long l = System.currentTimeMillis();
    synchronized (this.zIW)
    {
      ao.bUT().clear();
      ao.dJu().clear();
      ab.i("MicroMsg.TransformComponent", "alvinluo unsetTransformFlag cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(31785);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ao.3
 * JD-Core Version:    0.7.0.1
 */