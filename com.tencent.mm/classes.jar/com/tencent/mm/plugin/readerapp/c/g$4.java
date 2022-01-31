package com.tencent.mm.plugin.readerapp.c;

import com.tencent.mm.plugin.n.c;
import com.tencent.mm.sdk.platformtools.bk;

final class g$4
  implements Runnable
{
  g$4(g paramg) {}
  
  public final void run()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      return;
    }
    bk.h(c.FG(), "ReaderApp_", 604800000L);
  }
  
  public final String toString()
  {
    return super.toString() + "|onAccountPostReset";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.g.4
 * JD-Core Version:    0.7.0.1
 */