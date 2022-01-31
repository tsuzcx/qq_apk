package com.tencent.mm.plugin.scanner.util;

import com.tencent.mm.h.a.lu;
import com.tencent.mm.h.a.lu.b;

final class e$1
  implements Runnable
{
  e$1(e parame, lu paramlu) {}
  
  public final void run()
  {
    if ((this.nOI.getContext() == null) || (this.nOH.bUQ == null)) {}
    do
    {
      return;
      if (this.nOH.bUQ.ret == 1)
      {
        this.nOI.im(true);
        return;
      }
    } while (this.nOH.bUQ.ret != 2);
    this.nOI.im(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.e.1
 * JD-Core Version:    0.7.0.1
 */