package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedHashMap;

final class am$3
  implements Runnable
{
  am$3(am paramam) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    synchronized (this.vtd)
    {
      am.cil().clear();
      am.cFw().clear();
      y.i("MicroMsg.TransformComponent", "alvinluo unsetTransformFlag cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.am.3
 * JD-Core Version:    0.7.0.1
 */