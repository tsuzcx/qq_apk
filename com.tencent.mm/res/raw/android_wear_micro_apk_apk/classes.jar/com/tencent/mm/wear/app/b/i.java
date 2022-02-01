package com.tencent.mm.wear.app.b;

import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.g.a;

final class i
  extends a
{
  protected final void execute()
  {
    if (q.D(h.a(h.mK()))) {
      h.a(h.mK(), h.ne());
    }
    d.c("MicroMsg.MMCore", "LocalNodeID=%s", new Object[] { h.a(h.mK()) });
  }
  
  protected final String getName()
  {
    return "SetUpTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.b.i
 * JD-Core Version:    0.7.0.1
 */